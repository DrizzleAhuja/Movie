package com.ncu.user.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("/{id}")
    public String getUserDetails(@PathVariable("id") String id) {
     
        return "User details for user with ID: " + id;
    }

    @PostMapping
    public String createUser(@RequestBody String user) {
     
        return "User created: " + user;
    }

  @PutMapping("/edit/{id}")
public String updateUser(@PathVariable("id") String id, @RequestBody String user) {
    return "User with ID " + id + " updated: " + user;
}

@DeleteMapping("/delete/{id}")
public String deleteUser(@PathVariable("id") String id) {
    return "User with ID " + id + " deleted.";
}

}