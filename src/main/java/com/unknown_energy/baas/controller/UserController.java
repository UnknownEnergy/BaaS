package com.unknown_energy.baas.controller;

import com.unknown_energy.baas.mapper.UserMapper;
import com.unknown_energy.baas.bean.Greeting;
import com.unknown_energy.baas.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class UserController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/admin/users")
    public List<User> getAllUsers() {
        return this.userMapper.selectAllUsers();
    }

    @RequestMapping("/user/greeting")
    public Greeting greetingUser(@RequestParam(value="name", defaultValue="User") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }
}