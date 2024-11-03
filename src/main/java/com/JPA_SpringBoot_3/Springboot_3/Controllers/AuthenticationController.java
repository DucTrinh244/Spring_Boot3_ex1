package com.JPA_SpringBoot_3.Springboot_3.Controllers;

import com.JPA_SpringBoot_3.Springboot_3.Service.AuthenticationService;
import com.JPA_SpringBoot_3.Springboot_3.dto.request.APIResponse;
import com.JPA_SpringBoot_3.Springboot_3.dto.request.AuthenticationRequest;
import com.JPA_SpringBoot_3.Springboot_3.dto.response.AuthenticationResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class AuthenticationController {
    AuthenticationService authenticationService;
    @PostMapping("/log-in")
    APIResponse<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){
        boolean result=authenticationService.authenticate(request);
        return APIResponse.<AuthenticationResponse>builder()
                .result(AuthenticationResponse.builder()
                        .authenticated(result)
                        .build())
                .build();
    }

}
