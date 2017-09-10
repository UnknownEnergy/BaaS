package com.unknown_energy.baas.controller;

import com.unknown_energy.baas.bean.User;
import com.unknown_energy.baas.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/users/add")
    @PreAuthorize("hasRole('ROLE_USER')")
    public void insertNewUser(@RequestBody User user) {
        if(userMapper.checkIfUserExists(user.getUsername())== null) {
            userMapper.insertUser(user);
        }
    }

    @RequestMapping("/users")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<User> getAllUsers() {
        return userMapper.selectUsers();
    }

    @RequestMapping("/user/greeting")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String greetingUser(@RequestParam(value="name", defaultValue="User") String name) {
        return "hello " + name;
    }
}