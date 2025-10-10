package iuh.fit.bai1.daos.Impl;

import iuh.fit.bai1.entities.Employee;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements iuh.fit.bai1.daos.EmployeeDAO {
    private JdbcTemplate jdbcTemplate;

    public EmployeeDAOImpl(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Employee> getAll(){
        String sql = "SELECT * FROM Employee";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Employee.class));
    }

    @Override
    public boolean add(Employee employee){
        String sql = "INSERT INTO Employee (name, role) VALUES (?, ?)";
        return jdbcTemplate.update(sql, employee.getName(), employee.getRole()) > 0;
    }

    @Override
    public boolean update(Employee employee){
        String sql = "UPDATE Employee SET name = ?, role = ? WHERE id = ?";
        return jdbcTemplate.update(sql, employee.getName(), employee.getRole(), employee.getId()) > 0;
    }

    @Override
    public boolean delete(long id){
        String sql = "DELETE FROM Employee WHERE id = ?";
        return jdbcTemplate.update(sql, id) > 0;
    }
}
