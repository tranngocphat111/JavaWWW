package iuh.fit.bai2.services;

import iuh.fit.bai2.entities.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAll();

    Employee getId(int id);

    Employee add(Employee employee);

    Employee update(Employee employee);

    void delete(int id);

    Employee findByName(String name);
}
