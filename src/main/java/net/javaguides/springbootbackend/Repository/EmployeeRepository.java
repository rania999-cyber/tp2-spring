package net.javaguides.springbootbackend.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import net.javaguides.springbootbackend.Controller.EmployeeController;
import net.javaguides.springbootbackend.Exception.ResourceNotFoundException;
import net.javaguides.springbootbackend.Service.EmployeeService;

public interface EmployeeRepository extends JpaRepository<EmployeeController, Long> {
    // Ajoutez ici des méthodes spécifiques au référentiel, si nécessaire
    EmployeeController findByFirstName(String firstName);
    // ...

    default List<EmployeeController> getAllEmployees() {
        return findAll();
    }

    default EmployeeController getEmployeeById(long id) {
        return findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Employee", "Id", id));
    }

    default void deleteEmployee(long id) {
        findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Employee", "Id", id));
        deleteById(id);
    }

    EmployeeService save(EmployeeService employee);
}

