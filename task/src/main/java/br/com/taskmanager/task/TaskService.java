package br.com.taskmanager.task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.taskmanager.task.dtos.TaskCreateDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;


      public TaskEntity createTask(TaskCreateDTO taskDto) {
        TaskEntity task = new TaskEntity(taskDto.getTitle(), taskDto.getStatus(), taskDto.getDescription());
        return taskRepository.save(task);
    }

    public List<TaskEntity> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<TaskEntity> getTaskById(UUID id) {
        return taskRepository.findById(id);
    }

    public Optional<TaskEntity> updateTask(UUID id, TaskEntity updateTask) {
        Optional<TaskEntity> optionalTask = taskRepository.findById(id);
    
        TaskEntity existingTask = optionalTask.get();
        existingTask.setTitle(updateTask.getTitle());
        existingTask.setStatus(updateTask.getStatus());
        existingTask.setDescription(updateTask.getDescription());
    
        return Optional.of(taskRepository.save(existingTask));
        
    }

    public void deleteTask(UUID id) {
        taskRepository.deleteById(id);
    }
}
    
