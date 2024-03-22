package br.com.taskmanager.task;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;

import br.com.taskmanager.task.dtos.TaskCreateDTO;

@Service
public class TaskService {

    // @Autowired
    private TaskRepository taskRepository;

    public TaskEntity createTask(TaskCreateDTO taskDto) {
        TaskEntity task = new TaskEntity(taskDto.getTitle(), taskDto.getStatus(), taskDto.getDescription());
        return taskRepository.save(task);
    }

    public List<TaskEntity> getAllTasks() {
        return taskRepository.findAll();
    }

    @SuppressWarnings("null")
    public Optional<TaskEntity> getTaskById(UUID id) {
        return taskRepository.findById(id);
    }

    public Optional<TaskEntity> updateTask(UUID id, TaskEntity updateTask) {
        @SuppressWarnings("null")
        Optional<TaskEntity> optionalTask = taskRepository.findById(id);

        TaskEntity existingTask = optionalTask.get();
        existingTask.setTitle(updateTask.getTitle());
        existingTask.setStatus(updateTask.getStatus());
        existingTask.setDescription(updateTask.getDescription());

        return Optional.of(taskRepository.save(existingTask));

    }

    @SuppressWarnings("null")
    public void deleteTask(UUID id) {
        taskRepository.deleteById(id);
    }
}
