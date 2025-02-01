package com.eshopping.decemberprojectmodulev2.controllers.Users;

import com.eshopping.decemberprojectmodulev2.models.User.User;
import com.eshopping.decemberprojectmodulev2.services.Users.UserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    UserService userService;


    public UserController(@Qualifier("selfUserService") UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/{id}")
    public User getAUser(@PathVariable("id") Long id){
        User user = userService.getAUser(id);
        return user;
    }
    @GetMapping("/users")
    public User[] getAllUsers(){
        User[] userlist = userService.getAllUsers();
        return userlist;
    }
    @PostMapping("/users")
    public User createAUser(@RequestBody User user){
        User response = userService.createAUser(user.getEmail(), user.getUsername(), user.getPhone());
        return response;
    }
    @DeleteMapping("/users/{id}")
    public User deleteAUser(@PathVariable("id") Long id){
        User user = userService.deleteAUser(id);
        return user;
    }
    @PutMapping("/users/{id}")
    public User updateAUser(@PathVariable("id") Long id, @RequestBody User user){
        User response = userService.updateAUser(id, user.getEmail(), user.getUsername(), user.getPhone());
        return response;
    }
}
