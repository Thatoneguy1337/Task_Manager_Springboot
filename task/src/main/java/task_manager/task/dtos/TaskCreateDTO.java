package task_manager.task.dtos;
import lombok.Data;
import java.util.UUID;

@Data
public class TaskCreateDTO {
    private UUID id;
    private String title;
    private String status;
    private String description;
    
}
