package com.pavan.security.SpringSecurity.Controllers;

import com.pavan.security.SpringSecurity.Models.Student;
import com.pavan.security.SpringSecurity.Models.Users;
import com.pavan.security.SpringSecurity.Repository.UserRepo;
import com.pavan.security.SpringSecurity.Service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    List<Student> students=new ArrayList<>(List.of(
            new Student(75,"pavan",89),
            new Student(76,"kumar",90))
    );


    @GetMapping("/student")
    public List<Student> getAll()
    {
        return students;
    }
    @GetMapping("csrftoken")
    public CsrfToken getToken(HttpServletRequest request)
    {
        return (CsrfToken) request.getAttribute("_csrf");
    }
    @PostMapping("/student")
    public Student addStudent(@RequestBody  Student std)
    {
        students.add(std);
        return std;
    }
    @Autowired
    UserService service;
    @PostMapping("/register")
    public Users addStudent(@RequestBody  Users user)
    {

        return service.add(user);
    }
}
