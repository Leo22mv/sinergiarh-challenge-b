package sinergiarh.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sinergiarh.challenge.entity.TaskCategory;

// Repositorio que brinda los métodos necesarios para administrar las categorías de las tareas

@Repository
public interface TaskCategoryRepository extends JpaRepository<TaskCategory, Long> {
}
