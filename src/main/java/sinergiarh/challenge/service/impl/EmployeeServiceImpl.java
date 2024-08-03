package sinergiarh.challenge.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import sinergiarh.challenge.entity.Employee;
import sinergiarh.challenge.repository.EmployeeRepository;
import sinergiarh.challenge.service.EmployeeService;

// Implementación del servicio de empleados

@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {
    
    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Override
    public Employee create(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    @Transactional
    public Optional<Employee> edit(Long id, Employee editedEmployee) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        employeeOptional.ifPresent(employee -> {
                    employee.setName(editedEmployee.getName());
                    employee.setSurname(editedEmployee.getSurname());
                    employee.setPhone(editedEmployee.getPhone());
                    employee.setGender(editedEmployee.getGender());
                    employee.setTutor(editedEmployee.getTutor());
                    employee.setTasks(editedEmployee.getTasks());
                    employeeRepository.save(employee);
                }
        );

        return employeeOptional;
    }

    @Override
    public Optional<Employee> delete(Long id) {
        if (!employeeRepository.existsById(id)) {
            throw new RuntimeException("Empleado con ID " + id + " no encontrado.");
        }
        List<Employee> students = employeeRepository.findByTutorId(id);
        if (!students.isEmpty()) {
            throw new RuntimeException("No se puede eliminar empleados que sean tutor de otro.");
        }
        employeeRepository.deleteById(id);
        return null;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> findById(Long id) {
        if (!employeeRepository.existsById(id)) {
            throw new RuntimeException("Empleado con ID " + id + " no encontrado.");
        }
        return employeeRepository.findById(id);
    }

    @Override
    public List<Employee> findByName(String name) {
        List<Employee> results = employeeRepository.findByName(name);
        if (results.isEmpty()) {
            throw new RuntimeException("No se encontraron empleados con el nombre: " + name);
        }
        return results;
    }

    @Override
    public List<Employee> findBySurname(String surname) {
        List<Employee> results = employeeRepository.findBySurname(surname);
        if (results.isEmpty()) {
            throw new RuntimeException("No se encontraron empleados con el apellido: " + surname);
        }
        return results;
    }
}
