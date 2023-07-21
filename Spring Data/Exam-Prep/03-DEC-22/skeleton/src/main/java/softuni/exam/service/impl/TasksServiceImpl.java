package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.Constants;
import softuni.exam.models.dto.TaskInsertDTO;
import softuni.exam.models.dto.TaskInsertDTOWrapper;
import softuni.exam.models.dto.exportDTOs.CarExportDTO;
import softuni.exam.models.dto.exportDTOs.MechanicExportDTO;
import softuni.exam.models.dto.exportDTOs.TaskExportDTO;
import softuni.exam.models.entity.*;
import softuni.exam.repository.CarsRepository;
import softuni.exam.repository.MechanicsRepository;
import softuni.exam.repository.PartsRepository;
import softuni.exam.repository.TasksRepository;
import softuni.exam.service.TasksService;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// TODO: Implement all methods
@Service
public class TasksServiceImpl implements TasksService {

    private TasksRepository tasksRepository;
    private CarsRepository carsRepository;
    private MechanicsRepository mechanicsRepository;
    private PartsRepository partsRepository;
    private XmlParser xmlParser;
    private ModelMapper modelMapper;
    private static String TASKS_FILE_PATH = "src/main/resources/files/xml/tasks.xml";

    @Autowired
    public TasksServiceImpl(TasksRepository tasksRepository,
                            CarsRepository carsRepository,
                            MechanicsRepository mechanicsRepository,
                            PartsRepository partsRepository,
                            XmlParser xmlParser,
                            ModelMapper modelMapper) {
        this.tasksRepository = tasksRepository;
        this.carsRepository = carsRepository;
        this.mechanicsRepository = mechanicsRepository;
        this.partsRepository = partsRepository;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.tasksRepository.count() > 0;
    }

    @Override
    public String readTasksFileContent() throws IOException {
        return Files.readString(Path.of(TASKS_FILE_PATH));
    }

    @Override
    public String importTasks() throws IOException{
        StringBuilder output = new StringBuilder();
        String xml = readTasksFileContent();
        List<TaskInsertDTO> taskDTOs = new ArrayList<>();
        try{
            TaskInsertDTOWrapper wrapper = this.xmlParser
                    .fromString(xml, TaskInsertDTOWrapper.class);
            taskDTOs = wrapper.getTasks();
        }catch (JAXBException e){
            output.append(Arrays.toString(e.getStackTrace()));
        }

        for(TaskInsertDTO taskInsertDTO : taskDTOs){
            if(isValid(taskInsertDTO)){
                Task task = this.modelMapper.map(taskInsertDTO, Task.class);
                Car car = this.carsRepository.findById(taskInsertDTO.getCar().getId()).get();
                Mechanic mechanic = this.mechanicsRepository
                        .findFirstByFirstName(taskInsertDTO.getMechanic().getFirstName()).get();
                Part part = this.partsRepository
                        .findFirstById(taskInsertDTO.getPart().getId()).get();
                task.setCar(car);
                task.setMechanic(mechanic);
                task.setPart(part);
                task.setDate(taskInsertDTO.getDateAsLocalDateTime());
                this.tasksRepository.save(task);
                output.append(String.format(Constants.SUCCESSFULLY_IMPORTED_FORMAT + Constants.TASK_IMPORT_FORMAT,
                        "task", task.getPrice()));
            }else {
                output.append(String.format(Constants.INVALID_FORMAT, "task"));
            }

            output.append(System.lineSeparator());
        }
        return output.toString().trim();
    }

    private boolean isValid(TaskInsertDTO taskInsertDTO){
        if(this.carsRepository.findById(taskInsertDTO.getCar().getId()).isEmpty() ||
                this.mechanicsRepository.findFirstByFirstName(taskInsertDTO.getMechanic().getFirstName()).isEmpty() ||
                this.partsRepository.findFirstById(taskInsertDTO.getPart().getId()).isEmpty() ||
                taskInsertDTO.getPrice().compareTo(BigDecimal.ZERO) <= 0){
            return false;
        }
        return true;
    }

    @Override
    public String getCoupeCarTasksOrderByPrice() {
        List<Task> tasks = this.tasksRepository
                .getTasksByCarCarTypeOrderByPriceDesc(CarType.coupe);
        StringBuilder output = new StringBuilder();
        for(Task task : tasks){
            TaskExportDTO taskExportDTO = this.modelMapper.map(task, TaskExportDTO.class);
            taskExportDTO.setCarExportDTO(this.modelMapper.map(task.getCar(), CarExportDTO.class));
            taskExportDTO.setMechanicExportDTO(this.modelMapper.map(task.getMechanic(), MechanicExportDTO.class));
            output.append(taskExportDTO.toString())
                    .append(System.lineSeparator());
        }
        return output.toString().trim();
    }
}
