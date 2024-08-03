package sinergiarh.challenge.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sinergiarh.challenge.entity.Task;
import sinergiarh.challenge.repository.TaskRepository;
import sinergiarh.challenge.service.TaskService;

// Implementación del servicio de tareas

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public Optional<Task> findById(Long id) {
        if (!taskRepository.existsById(id)) {
            throw new RuntimeException("Tarea con ID " + id + " no encontrado.");
        }
        return taskRepository.findById(id);
    }

    @Override
    public List<Task> findByCategory(Long categoryId) {
        return taskRepository.findByCategoryId(categoryId);
    }
    
}
