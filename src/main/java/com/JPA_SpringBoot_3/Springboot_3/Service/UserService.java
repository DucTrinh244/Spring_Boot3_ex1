package com.JPA_SpringBoot_3.Springboot_3.Service;

import com.JPA_SpringBoot_3.Springboot_3.Entity.User;
import com.JPA_SpringBoot_3.Springboot_3.dto.request.UserCreationRequest;
import com.JPA_SpringBoot_3.Springboot_3.dto.request.UserUpdationRequest;
import com.JPA_SpringBoot_3.Springboot_3.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User createUser(UserCreationRequest request){
        User user= new User();

        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setFirstname(request.getFirstname());
        user.setLastname(request.getLastname());
        user.setDob(request.getDob());

        return userRepository.save(user);
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User getUser(String id){
        return userRepository.findById(id)
                .orElseThrow(() ->new RuntimeException("User not fould"));
    }
    public User updateUser(String userId ,UserUpdationRequest request){
        User user= getUser(userId);

        user.setPassword(request.getPassword());
        user.setFirstname(request.getFirstname());
        user.setLastname(request.getLastname());
        user.setDob(request.getDob());

        return userRepository.save(user);
    }

    public void deleteUser(String userid){
        userRepository.deleteById(userid);
    }
}
