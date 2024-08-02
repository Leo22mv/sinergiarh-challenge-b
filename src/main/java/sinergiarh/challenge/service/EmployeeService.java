package sinergiarh.challenge.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import sinergiarh.challenge.entity.Employee;

@Service
public interface EmployeeService {
    Employee create(Employee employee);
    Optional<Employee> edit(Long id, Employee editedEmployee);
    Optional<Employee> delete(Long id);
    List<Employee> findAll();
    Optional<Employee> findById(Long id);
    List<Employee> findByName(String name);
    List<Employee> findBySurname(String surname);
}