package iuh.fit.bai1.entities;



import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Employee {
    private int id;
    public Employee(String role, String name) {
        this.role = role;
        this.name = name;
    }

    private String role;
    private String name;
}
