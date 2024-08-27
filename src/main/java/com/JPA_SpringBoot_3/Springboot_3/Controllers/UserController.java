package com.JPA_SpringBoot_3.Springboot_3.Controllers;

import com.JPA_SpringBoot_3.Springboot_3.Entity.User;
import com.JPA_SpringBoot_3.Springboot_3.Service.UserService;
import com.JPA_SpringBoot_3.Springboot_3.dto.request.APIResponse;
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
    APIResponse<User> createUser(@RequestBody @Valid UserCreationRequest request){
        // khởi tọa đối tượng api
        APIResponse<User> apiResponse = new APIResponse<>();

        // set result
        apiResponse.setResult(userService.createUser(request));
        // TRẢ VỀ API RESPONSE ĐÃ ĐƯỢC CHUYỂN TỪ USER VỀ APIResponse
    return apiResponse;
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
