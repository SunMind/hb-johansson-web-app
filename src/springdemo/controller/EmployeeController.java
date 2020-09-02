package springdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springdemo.entity.Employee;
import springdemo.service.EmployeeService;


import java.lang.annotation.Retention;
import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    //need to inject the employee service
    //spring will scan for a components that implements EmployeeDAO interface
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/list")
    public String listCustomers(Model theModel){

        //get employees from DAO
        List<Employee> theEmployees = employeeService.getEmployees();

        //add the customers to the model, so it can be reached in "list-employees.jsp"
        theModel.addAttribute("employees", theEmployees);

        return "list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){

        //create model attribute to bind form data
        Employee theEmployee = new Employee();

        theModel.addAttribute("employee", theEmployee);

        return "employee-form";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee theEmployee){

        //save the employee using our service
        employeeService.saveEmployee(theEmployee);

        return "redirect:/employee/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int theId, Model theModel){

        //get the employee from service
        Employee theEmployee = employeeService.getEmployee(theId);

        //set employee as a model attribute to pre-populate the form
        theModel.addAttribute("employee", theEmployee);

        //send over to our form
        return "employee-form";
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("employeeId") int theId){

        employeeService.deleteEmployee(theId);

        return "redirect:/employee/list";
    }

    @GetMapping("/hoursTable")
    public String hoursTable(@RequestParam("employeeId") int theId, Model theModel){

        //get the employee from service
        Employee theEmployee = employeeService.getEmployee(theId);

        //set employee as a model attribute to continue with it in next form
        theModel.addAttribute("employee", theEmployee);

        return "hours-table";
    }
}
