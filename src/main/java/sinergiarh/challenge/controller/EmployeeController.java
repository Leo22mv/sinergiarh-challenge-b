package sinergiarh.challenge.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sinergiarh.challenge.controller.request.EmployeeForm;
import sinergiarh.challenge.entity.Employee;
import sinergiarh.challenge.entity.Task;
import sinergiarh.challenge.service.EmployeeService;
import sinergiarh.challenge.service.GenderService;
import sinergiarh.challenge.service.TaskService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

// Controlador con los endpoints para administrar los empleados

@RestController
@RequestMapping("/employee")
@CrossOrigin("http://localhost:4200")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @Autowired
    GenderService genderService;

    @Autowired
    TaskService taskService;

    @GetMapping
    public ResponseEntity<List<Employee>> findAll () {
        List<Employee> employeesList = employeeService.findAll();
        return ResponseEntity.ok(employeesList);
    }

    @GetMapping("/search/name")
    public ResponseEntity<List<Employee>> findByName (@RequestParam String name) {
        if (name.isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        }
        List<Employee> results = employeeService.findByName(name);
        return ResponseEntity.ok(results);
    }

    @GetMapping("/search/surname")
    public ResponseEntity<List<Employee>> findBySurname (@RequestParam String surname) {
        if (surname.isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        }
        List<Employee> results = employeeService.findBySurname(surname);
        return ResponseEntity.ok(results);
    }

    @PostMapping
    public ResponseEntity<Employee> create(@RequestBody EmployeeForm employee) {
        List<Task> taskList = new ArrayList<>();

        for (Long id : employee.getTasks_ids()) {
            Task task = taskService.findById(id)
                    .orElseThrow(() -> new RuntimeException("Tarea con ID " + id + " no encontrada."));
            taskList.add(task);
        }

        Employee tutor = null;

        if (employee.getTutor_id() != null) {
            tutor = employeeService.findById(employee.getTutor_id()).orElseThrow(() -> new RuntimeException("Empleado tutor con ID " + employee.getTutor_id() + " no encontrada."));
        }
        
        Employee newEmployee = new Employee(
            employee.getName(),
            employee.getSurname(),
            employee.getPhone(),
            genderService.findById(employee.getGender_id()).get(),
            tutor,
            taskList);
        
        for (Employee i : employeeService.findAll()) {
            if (i.getName().equals(newEmployee.getName()) && i.getSurname().equals(newEmployee.getSurname())) {
                throw new RuntimeException("Empleado existente.");
            }
        }
        
        employeeService.create(newEmployee);
        return ResponseEntity.ok(newEmployee);
    }
    
    @PutMapping({"/{id}"})
    public ResponseEntity<Employee> edit(@PathVariable Long id, @RequestBody EmployeeForm employeeForm) {
        List<Task> taskList = new ArrayList<>();

        if (employeeForm.getTasks_ids() != null) {
            employeeForm.getTasks_ids().forEach(taskId -> {
                Task task = taskService.findById(taskId).orElseThrow(() -> new RuntimeException("Tarea con ID " + taskId + " no encontrada."));
                taskList.add(task);
            });
        } else {
            throw new RuntimeException("Cada empleado debe tener al menos una tarea.");
        }
    
        Employee tutor = null;
        
        if (employeeForm.getTutor_id() != null) {
            tutor = employeeService.findById(employeeForm.getTutor_id()).orElseThrow(() -> new RuntimeException("Tutor con ID " + employeeForm.getTutor_id() + " no encontrado."));
        }
    
        Employee employee = new Employee(
                employeeForm.getName(),
                employeeForm.getSurname(),
                employeeForm.getPhone(),
                genderService.findById(employeeForm.getGender_id()).orElseThrow(() -> new RuntimeException("Género con ID " + employeeForm.getGender_id() + " no encontrado.")),
                tutor,
                taskList
        );
        
        Optional<Employee> editedEmployee = employeeService.edit(id, employee);

        return editedEmployee.map(ResponseEntity::ok).orElseThrow(() -> new RuntimeException("Empleado con ID " + id + " no encontrado."));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Employee> deletedEmployee = employeeService.delete(id);
        return ResponseEntity.ok(deletedEmployee.get());
    }
}
