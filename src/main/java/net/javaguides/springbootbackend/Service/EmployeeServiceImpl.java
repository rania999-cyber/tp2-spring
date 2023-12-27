package net.javaguides.springbootbackend.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import net.javaguides.springbootbackend.Repository.EmployeeRepository;
import net.javaguides.springbootbackend.Controller.EmployeeController;
import net.javaguides.springbootbackend.Exception.ResourceNotFoundException;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.setEmployeeRepository(employeeRepository);
    }

    public EmployeeRepository getEmployeeRepository() {
        return employeeRepository;
        
    }

    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
        
    }

    @Override
    public EmployeeService saveEmployee(EmployeeService employee) {
        return getEmployeeRepository().save(employee);
    }

    @Override
    public List<EmployeeController> getAllEmployees() {
        return getEmployeeRepository().findAll();
    }

    @Override
    public EmployeeService getEmployeeById(long id) {
        return (EmployeeService) getEmployeeRepository().findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
    }

    @Override
    public EmployeeService updateEmployee(EmployeeService employee, long id) {
        EmployeeController existingEmployee = getEmployeeRepository().findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));

        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());

        return (EmployeeService) getEmployeeRepository().save(existingEmployee);
    }

    @Override
    public void deleteEmployee(long id) {
        if (getEmployeeRepository().existsById(id)) {
            getEmployeeRepository().deleteById(id);
        } else {
            throw new ResourceNotFoundException("Employee", "Id", id);
        }
    }

    @Override
    public String getFirstName() {
         throw new UnsupportedOperationException("Unimplemented method 'getFirstName'");
    }

    @Override
    public String getLastName() {
         throw new UnsupportedOperationException("Unimplemented method 'getLastName'");
    }

    @Override
    public String getEmail() {
         throw new UnsupportedOperationException("Unimplemented method 'getEmail'");
    }
}

