package task_manager.task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



import java.util.List;
import java.util.UUID;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, UUID> {
    List<TaskEntity>findById( String id);
    
    @SuppressWarnings("null")
    List<TaskEntity>findAll();
}
