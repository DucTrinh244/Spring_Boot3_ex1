package com.JPA_SpringBoot_3.Springboot_3.Service;

import com.JPA_SpringBoot_3.Springboot_3.Exception.AppException;
import com.JPA_SpringBoot_3.Springboot_3.Exception.ErrorCode;
import com.JPA_SpringBoot_3.Springboot_3.dto.request.AuthenticationRequest;
import com.JPA_SpringBoot_3.Springboot_3.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
@Service
public class AuthenticationService {
    UserRepository userRepository;

    public boolean authenticate(AuthenticationRequest request){
        var user =userRepository.findByUsername(request.getUsername())
                .orElseThrow(()->new AppException(ErrorCode.USER_NOT_EXIST));

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        return passwordEncoder.matches(request.getPassword(),user.getPassword());
    }
}
