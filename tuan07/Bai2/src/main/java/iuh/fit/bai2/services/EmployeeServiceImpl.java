package iuh.fit.bai2.services;

import iuh.fit.bai2.daos.EmployeeDAO;
import iuh.fit.bai2.entities.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDAO employeeDAO;

    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }


    @Override
    public List<Employee> getAll(){
        return  employeeDAO.findAll();
    }

    @Override
    public Employee getId(int id){
        return  employeeDAO.findById(id).orElse(null);
    }

    @Override
    public Employee add(Employee employee){
        return employeeDAO.save(employee);
    }

    @Override
    public Employee update(Employee employee){
        return employeeDAO.save(employee);
    }

    @Override
    public void delete(int id){
        employeeDAO.deleteById(id);
    }

    @Override
    public Employee findByName(String name){
        return  employeeDAO.findByName(name);
    }


}
