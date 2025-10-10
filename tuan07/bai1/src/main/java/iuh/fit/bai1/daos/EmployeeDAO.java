package iuh.fit.bai1.daos;

import iuh.fit.bai1.entities.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> getAll();

    boolean add(Employee employee);

    boolean update(Employee employee);

    boolean delete(long id);
}
