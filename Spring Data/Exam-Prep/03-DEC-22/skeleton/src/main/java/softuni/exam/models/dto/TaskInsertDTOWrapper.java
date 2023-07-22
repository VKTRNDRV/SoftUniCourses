package softuni.exam.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "tasks")
@XmlAccessorType(value = XmlAccessType.NONE)
public class TaskInsertDTOWrapper {

    @XmlElement(name = "task")
    private List<TaskInsertDTO> tasks;

    public List<TaskInsertDTO> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskInsertDTO> tasks) {
        this.tasks = tasks;
    }
}
