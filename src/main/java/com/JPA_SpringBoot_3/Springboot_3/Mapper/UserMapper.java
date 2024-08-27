package com.JPA_SpringBoot_3.Springboot_3.Mapper;


import com.JPA_SpringBoot_3.Springboot_3.Entity.User;
import com.JPA_SpringBoot_3.Springboot_3.dto.request.UserCreationRequest;
import com.JPA_SpringBoot_3.Springboot_3.dto.request.UserUpdationRequest;
import com.JPA_SpringBoot_3.Springboot_3.dto.response.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest request);

    // trường hợp muốn mapping với property mong muốn
    // @Mapping(source = "firstname",target = "lastname")


    //trường hợp muốn bro qua property muong muốn
    //@Mapping(target = "firstname",ignore = true)

    UserResponse toUserResponse(User user);

    void updateUser(@MappingTarget User user, UserUpdationRequest request);

}
