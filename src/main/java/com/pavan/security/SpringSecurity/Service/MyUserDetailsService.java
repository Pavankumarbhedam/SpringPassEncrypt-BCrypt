package com.pavan.security.SpringSecurity.Service;

import com.pavan.security.SpringSecurity.Models.MyUserDetails;
import com.pavan.security.SpringSecurity.Models.Users;
import com.pavan.security.SpringSecurity.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("MyUserDetailsService Called");

       Users user=repo.findByUsername(username);
        System.out.println(user);
         if(user==null)
         {
             System.out.println("User not found");
             throw new UsernameNotFoundException("User not Found");
         }
        System.out.println("MyUserDetailsService is returningg");

        return new MyUserDetails(user);
    }
}
