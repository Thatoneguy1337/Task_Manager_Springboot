package br.com.taskmanager.task;

import java.util.UUID;
import javax.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
@Entity(name = "task")
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotEmpty
    @Column(nullable = false)
    private String title;

    @NotEmpty
    @Column(nullable = false)
    private String status;

    @NotEmpty
    @Column(nullable = false)
    private String description;

    public TaskEntity(String title, String status, String description) {
        this.title = title;
        this.status = status;
        this.description = description;
    }

}
