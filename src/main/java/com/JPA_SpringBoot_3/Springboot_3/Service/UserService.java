package com.JPA_SpringBoot_3.Springboot_3.Service;

import com.JPA_SpringBoot_3.Springboot_3.Entity.User;
import com.JPA_SpringBoot_3.Springboot_3.Exception.AppException;
import com.JPA_SpringBoot_3.Springboot_3.Exception.ErrorCode;
import com.JPA_SpringBoot_3.Springboot_3.Mapper.UserMapper;
import com.JPA_SpringBoot_3.Springboot_3.dto.request.UserCreationRequest;
import com.JPA_SpringBoot_3.Springboot_3.dto.request.UserUpdationRequest;
import com.JPA_SpringBoot_3.Springboot_3.dto.response.UserResponse;
import com.JPA_SpringBoot_3.Springboot_3.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor// thay thế cho @autowride
// ó tự động tạo ra một constructor cho tất cả các trường final trong lớp mà bạn đánh dấu với annotation này
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class UserService {
     UserRepository userRepository;
     UserMapper userMapper;

    public User createUser(UserCreationRequest request){
        if(userRepository.existsByUsername(request.getUsername()))
            //AppException này là bắt lỗi được chọn với errorcode được truyền vào
            throw new AppException(ErrorCode.USER_EXIST);

        User user= userMapper.toUser(request);
        PasswordEncoder passwordEncoder= new BCryptPasswordEncoder(10);
        user.setPassword(passwordEncoder.encode(request.getPassword()));


        return userRepository.save(user);
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public UserResponse getUser(String id){
        return userMapper.toUserResponse( userRepository.findById(id)
                .orElseThrow(() ->new RuntimeException("User not fould")));
    }
    public UserResponse updateUser(String userId ,UserUpdationRequest request){

        User user= userRepository.findById(userId)
                .orElseThrow(() ->new RuntimeException("User not fould"));
        userMapper.updateUser(user,request);

        return userMapper.toUserResponse(userRepository.save(user));
    }

    public void deleteUser(String userid){
        userRepository.deleteById(userid);
    }
}
