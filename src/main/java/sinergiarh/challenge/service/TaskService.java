package sinergiarh.challenge.service;

import java.util.List;
import java.util.Optional;

import sinergiarh.challenge.entity.Task;

// Interfaz para el servicio de tareas

public interface TaskService {
    List<Task> findAll();
    Optional<Task> findById(Long id);
    List<Task> findByCategory(Long categoryId);
}
