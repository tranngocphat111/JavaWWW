package iuh.fit.bai1.controllers;

import iuh.fit.bai1.entities.Employee;
import iuh.fit.bai1.services.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class EmployeeController {

    EmployeeService employeeService;
    public EmployeeController(EmployeeService service){
        employeeService = service;
    }


    @GetMapping
    public String list(Model model){
        List<Employee> employees =  employeeService.findAll();
        model.addAttribute("employees", employees);
        return "list";
    }
}
