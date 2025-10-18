package iuh.fit.bai1.services.impl;

import iuh.fit.bai1.entities.Employee;
import iuh.fit.bai1.repositories.EmployeeRepository;
import iuh.fit.bai1.services.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    EmployeeRepository employeeRepository;
    public EmployeeServiceImpl(EmployeeRepository repository){
        employeeRepository = repository;
    }
    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void delete(int id) {
        employeeRepository.deleteById(id);
    }


    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findByid(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Employee> findByName(String keyword) {
        return employeeRepository.findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(keyword, keyword);
    }

}
