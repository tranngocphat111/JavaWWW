package enities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;
    private String password;
    private String userName;

//    @Autowired
    private Group group;

    @Autowired
    public User(Group group) {
        this.group = group;
    }

    @Autowired
    public void setGroup(Group group) {
        this.group = group;
    }
}
