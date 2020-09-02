package springdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springdemo.dao.EmployeeDAO;
import springdemo.entity.Employee;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    @Transactional
    public void saveEmployee(Employee theEmployee) {

        employeeDAO.saveEmployee(theEmployee);
    }

    @Override
    @Transactional
    public List<Employee> getEmployees() {
        return employeeDAO.getEmployees();
    }

    @Override
    @Transactional
    public Employee getEmployee(int theId) {
        return employeeDAO.getEmployee(theId);
    }

    @Override
    @Transactional
    public void deleteEmployee(int theId) {

        employeeDAO.deleteEmployee(theId);
    }
}
