package org.belotelov.reminders.controllers;

import org.belotelov.reminders.entity.User;
import org.belotelov.reminders.services.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/users")
public class UserController {
    
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{email}")
    public User getUser(@PathVariable String email) {
        User user = userService.getUser(email);
        return user;
    }
}
