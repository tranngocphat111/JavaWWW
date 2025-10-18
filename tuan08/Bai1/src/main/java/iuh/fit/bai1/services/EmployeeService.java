package iuh.fit.bai1.services;

import iuh.fit.bai1.entities.Employee;

import java.util.List;

public interface EmployeeService {
    public void save(Employee employee) ;
    public void delete(int id);

    public List<Employee> findAll();
    public Employee findByid(int id);
    public List<Employee> findByName(String keyword);

}
