package com.pavan.security.SpringSecurity.Service;

import com.pavan.security.SpringSecurity.Models.Users;
import com.pavan.security.SpringSecurity.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private  UserRepo repo;
     private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);
    public  Users add(Users user) {

        user.setPassword(encoder.encode(user.getPassword()));
          repo.save(user);
          return user;
    }
}
