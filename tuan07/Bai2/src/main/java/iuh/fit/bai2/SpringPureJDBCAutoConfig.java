package iuh.fit.bai2;

import iuh.fit.bai2.entities.Employee;
import iuh.fit.bai2.services.EmployeeService;
import iuh.fit.bai2.services.EmployeeServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringPureJDBCAutoConfig {
    public static void main(String[] args) {
        SpringApplication.run(SpringPureJDBCAutoConfig.class, args);
    }

    @Bean
    CommandLineRunner runner(EmployeeService employeeService){
        return args -> {
            Employee employee = new Employee();
            employee.setName("Phat");
            employee.setRole("Manager");
            employeeService.add(employee);

            List<Employee> employees = employeeService.getAll();
            employees.forEach(System.out::println);

            Employee employee1 = employeeService.findByName("Phat");
            System.out.println(employee1);


        };
    }
}
