package sinergiarh.challenge.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sinergiarh.challenge.service.TaskCategoryService;
import sinergiarh.challenge.service.TaskService;
import sinergiarh.challenge.entity.Task;
import sinergiarh.challenge.entity.TaskCategory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// Controlador con los endpoints necesarios para administrar las tareas

@RestController
@RequestMapping("/task")
@CrossOrigin("http://localhost:4200")
public class TaskController {

    @Autowired
    private TaskService taskService;
    
    @Autowired
    private TaskCategoryService taskCategoryService;

    @GetMapping
    public List<Task> findAll() {
        return taskService.findAll();
    }

    @GetMapping("/{categoryId}")
    public List<Task> findByCategory(@PathVariable Long categoryId) {
        return taskService.findByCategory(categoryId);
    }
    
    @GetMapping("/category")
    public List<TaskCategory> findCategoryById() {
        return taskCategoryService.findAll();
    }
}
