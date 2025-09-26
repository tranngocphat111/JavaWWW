package service;

import enities.Group;
import enities.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserService {

    @Bean
    public Group groupService(){
        return new Group(1, "Admin Group");
    }

    @Bean
    public User UserService(){
        return new User(1,"User 01", "123456",groupService());
    }
}
