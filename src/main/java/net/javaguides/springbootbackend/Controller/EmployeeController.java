package net.javaguides.springbootbackend.Controller;

  import jakarta.persistence.*;
import lombok.Data;
import net.javaguides.springbootbackend.Exception.ResourceNotFoundException;
import net.javaguides.springbootbackend.Service.EmployeeServiceImpl;


@Data
@Entity
@Table(name="employees")
public class EmployeeController {

 public EmployeeController saveEmployee(EmployeeServiceImpl employeeServiceImpl) {
        return employeeServiceImpl.getEmployeeRepository().save(this);
    }
public EmployeeController updateEmployee(EmployeeServiceImpl employeeServiceImpl, long id) {
    EmployeeController existingEmployee = employeeServiceImpl.getEmployeeRepository().findById(id).orElseThrow(
            () -> new ResourceNotFoundException("Employee", "Id", id));
    existingEmployee.setFirstName(getFirstName());
    existingEmployee.setLastName(getLastName());
    existingEmployee.setEmail(getEmail());
    return employeeServiceImpl.getEmployeeRepository().save(existingEmployee);
}
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;
@Column(name = "first_name", nullable = false)
private String firstName;
@Column(name = "last_name")
private String lastName;
@Column(name = "email")
private String email;
}
    

