package com.plannerapp.service;

import com.plannerapp.model.dto.TaskDTO;
import com.plannerapp.model.dto.TaskHomeViewModel;
import com.plannerapp.model.dto.TasksAddBindingModel;
import com.plannerapp.model.entity.Priority;
import com.plannerapp.model.entity.Task;
import com.plannerapp.model.entity.User;
import com.plannerapp.repo.PriorityRepository;
import com.plannerapp.repo.TaskRepository;
import com.plannerapp.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final PriorityRepository priorityRepository;
    private final UserRepository userRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository, PriorityRepository priorityRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.priorityRepository = priorityRepository;
        this.userRepository = userRepository;
    }

    public TaskHomeViewModel getHomeViewData(String username) {
        User user = userRepository.findByUsername(username);

        List<TaskDTO> assignedTasks = taskRepository.findByAssignee(user).stream()
                .map(TaskDTO::createFromTask).collect(Collectors.toList());

        List<TaskDTO> availableTasks = taskRepository.getAllAvailable().stream()
                .map(TaskDTO::createFromTask).collect(Collectors.toList());

        return new TaskHomeViewModel(assignedTasks, availableTasks);

    }

    public void add(TasksAddBindingModel tasksAddBindingModel) {
        Priority priority = priorityRepository.findByName(tasksAddBindingModel.getPriority());

        if (priority != null) {
            Task task = new Task();
            task.setDescription(tasksAddBindingModel.getDescription());
            task.setDueDate(LocalDate.parse(tasksAddBindingModel.getDueDate()));
            task.setPriority(priority);

            taskRepository.save(task);
        }
    }

    public void remove(Long id) {
        this.taskRepository.deleteById(id);
    }

    public void assign(Long id, String username) {
        Optional<Task> optionalTask = taskRepository.findById(id);

        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();

            if (username == null) {
                task.setAssignee(null);
            } else {
                User user = userRepository.findByUsername(username);
                task.setAssignee(user);
            }

            taskRepository.save(task);
        }
    }
}
