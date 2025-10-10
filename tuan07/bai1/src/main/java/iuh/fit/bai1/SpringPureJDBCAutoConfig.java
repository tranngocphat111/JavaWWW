package iuh.fit.bai1;

import iuh.fit.bai1.daos.EmployeeDAO;
import iuh.fit.bai1.entities.Employee;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication(scanBasePackages ={"iuh.fit.bai1.daos", "iuh.fit.bai1.daos.Impl"})
public class SpringPureJDBCAutoConfig {
    public static void main(String[] args) {
        SpringApplication.run(SpringPureJDBCAutoConfig.class, args);
    }

    @Bean
    CommandLineRunner runner(EmployeeDAO employeeDAO){
        return args -> {
            Employee employee = new Employee("Nguyen Van A", "Super Admin");
            employeeDAO.add(employee);

            List<Employee> employees = employeeDAO.getAll();
            employees.forEach(System.out::println);


        };
    }
}
