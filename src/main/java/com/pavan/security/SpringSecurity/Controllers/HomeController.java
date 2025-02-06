package com.pavan.security.SpringSecurity.Controllers;

import com.pavan.security.SpringSecurity.Models.Users;
import com.pavan.security.SpringSecurity.Repository.UserRepo;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {

    @GetMapping("/")
    public String get(HttpServletRequest request)
    {

        return "Hello world "+request.getRequestedSessionId();
    }

}
