package springdemo.service;

import springdemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public void saveEmployee (Employee theEmployee);

    public List<Employee> getEmployees();

    public Employee getEmployee(int theId);

    public void deleteEmployee(int theId);
}
