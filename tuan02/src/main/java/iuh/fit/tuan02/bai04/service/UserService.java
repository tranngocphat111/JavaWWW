package iuh.fit.tuan02.bai04.service;


import iuh.fit.tuan02.bai04.User;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserService {
    public User getUser(){
        return new User(1,"Phat","Phat@gmail.com");
    }
}
