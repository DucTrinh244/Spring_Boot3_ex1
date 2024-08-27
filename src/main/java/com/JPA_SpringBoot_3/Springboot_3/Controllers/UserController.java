package com.JPA_SpringBoot_3.Springboot_3.Controllers;

import com.JPA_SpringBoot_3.Springboot_3.Entity.User;
import com.JPA_SpringBoot_3.Springboot_3.Service.UserService;
import com.JPA_SpringBoot_3.Springboot_3.dto.request.UserCreationRequest;
import com.JPA_SpringBoot_3.Springboot_3.dto.request.UserUpdationRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    User createUser(@RequestBody @Valid UserCreationRequest request){
    return userService.createUser(request);
}

    @GetMapping
    List<User> createUser(){
        return userService.getUsers();
    }

    @GetMapping("/{userId}")
    User getUser(@PathVariable("userId") String userId){
        return userService.getUser(userId);
    }
    @PutMapping("/{userId}")
    User updateUser(@PathVariable("userId") String userid,@RequestBody UserUpdationRequest request){
        return userService.updateUser(userid,request);
    }

    @DeleteMapping("/{userId}")
    String DeleteUser(@PathVariable("userId") String userId){
        userService.deleteUser(userId);
        return "User has been deleted !!";
    }


}
