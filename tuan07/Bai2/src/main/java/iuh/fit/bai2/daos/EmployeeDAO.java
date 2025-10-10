package iuh.fit.bai2.daos;

import iuh.fit.bai2.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeDAO extends JpaRepository<Employee,Integer> {

    Employee findByName(String name);
}
