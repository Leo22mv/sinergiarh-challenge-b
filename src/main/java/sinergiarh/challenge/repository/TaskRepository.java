package sinergiarh.challenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sinergiarh.challenge.entity.Task;

// Repositorio que brinda los métodos necesarios para administrar las tareas

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByCategoryId(Long categoryId);
}