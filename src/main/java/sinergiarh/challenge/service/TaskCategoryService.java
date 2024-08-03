package sinergiarh.challenge.service;

import java.util.List;
import java.util.Optional;

import sinergiarh.challenge.entity.TaskCategory;

// Interfaz para el servicio de categorías de tareas

public interface TaskCategoryService {
    List<TaskCategory> findAll();
    Optional<TaskCategory> findById(Long id);
}
