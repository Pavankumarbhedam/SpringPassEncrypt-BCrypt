package com.pavan.security.SpringSecurity.Repository;

import com.pavan.security.SpringSecurity.Models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Users,Integer> {
    Users findByUsername(String username);

}
