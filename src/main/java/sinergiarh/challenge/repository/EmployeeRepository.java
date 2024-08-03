package sinergiarh.challenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import sinergiarh.challenge.entity.Employee;

// Repositorio que brinda los métodos necesarios para administrar los empleados

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("SELECT e FROM Employee e WHERE LOWER(e.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Employee> findByName(@Param("name") String name);

    @Query("SELECT e FROM Employee e WHERE LOWER(e.surname) LIKE LOWER(CONCAT('%', :surname, '%'))")
    List<Employee> findBySurname(@Param("surname") String surname);

    List<Employee> findByTutorId(Long id);
}
