package task_manager.task;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
import java.util.Optional;
import java.util.UUID;



public class TaskServices {

    private TaskRepository taskRepository;

    @Autowired
    public TaskServices(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @SuppressWarnings("null")
    public TaskEntity createTask(TaskEntity task) {
        return taskRepository.save(task);
    }

    public List<TaskEntity> getAllTasks() {
        return taskRepository.findAll();
    }

    @SuppressWarnings("null")
    public Optional<TaskEntity> getTaskById(UUID id) {
        return taskRepository.findById(id);
    }



    


}
