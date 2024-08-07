package sinergiarh.challenge.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

// Entidad de categoría de tareas

@NoArgsConstructor
@Getter
@Entity
@Table(name = "task_category")
public class TaskCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public TaskCategory(String name) {
        this.name = name;
    }
}
