package net.javaguides.springbootbackend.Service;

import java.util.List;

import net.javaguides.springbootbackend.Controller.EmployeeController;

public interface EmployeeService {
    EmployeeService saveEmployee(EmployeeService employee);
    List<EmployeeController> getAllEmployees();
    EmployeeService getEmployeeById(long id);
    EmployeeService updateEmployee(EmployeeService employee, long id);
    void deleteEmployee(long id);
    String getFirstName();
    String getLastName();
    String getEmail();
}


