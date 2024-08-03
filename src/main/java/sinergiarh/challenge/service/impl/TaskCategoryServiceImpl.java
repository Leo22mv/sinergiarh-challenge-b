package sinergiarh.challenge.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sinergiarh.challenge.entity.TaskCategory;
import sinergiarh.challenge.repository.TaskCategoryRepository;
import sinergiarh.challenge.service.TaskCategoryService;

// Implementación del servicio de categorías de tareas

@Service
public class TaskCategoryServiceImpl implements TaskCategoryService {

    @Autowired
    private TaskCategoryRepository taskCategoryRepository;

    @Override
    public List<TaskCategory> findAll() {
        return taskCategoryRepository.findAll();
    }

    @Override
    public Optional<TaskCategory> findById(Long id) {
        if (!taskCategoryRepository.existsById(id)) {
            throw new RuntimeException("Categoría de tareas con ID " + id + " no encontrado.");
        }
        return taskCategoryRepository.findById(id);
    }
    
}
