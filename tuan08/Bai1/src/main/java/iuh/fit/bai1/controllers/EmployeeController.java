package iuh.fit.bai1.controllers;

import iuh.fit.bai1.entities.Employee;
import iuh.fit.bai1.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class EmployeeController {

    EmployeeService employeeService;
    public EmployeeController(EmployeeService service){
        employeeService = service;
    }


    @GetMapping("/list")
    public String list(Model model){
        List<Employee> employees =  employeeService.findAll();
        model.addAttribute("employees", employees);
        return "list";
    }

    @GetMapping("/search")
    public String search(@RequestParam(value = "keyword", required = false) String keyword, Model model) {
        List<Employee> employees;

        if (keyword == null || keyword.trim().isEmpty()) {
            employees = employeeService.findAll(); // Nếu không nhập gì thì load toàn bộ
        } else {
            employees = employeeService.findByName(keyword);
        }

        model.addAttribute("employees", employees);
        model.addAttribute("keyword", keyword); // để hiển thị lại keyword trong ô tìm kiếm
        return "list";
    }



    @GetMapping("/show-form")
    public String showForm(Model model){
        Employee employee =  new Employee();
        model.addAttribute("employee", employee);
        return "register";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("employee") Employee employee, BindingResult result, Model model){

        if(result.hasErrors()){
            return "register";
        }
        employeeService.save(employee);
        return "redirect:/list";
    }

    @GetMapping("/update")
    public String showFormUpdate(@RequestParam("id") int id, Model model){
        Employee employee = employeeService.findByid(id);
        model.addAttribute("employee",employee);
        return  "register";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("id") int id, Model model){
        employeeService.delete(id);
        return "redirect:/list";
    }

}
