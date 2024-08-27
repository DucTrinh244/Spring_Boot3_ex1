package com.JPA_SpringBoot_3.Springboot_3.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserUpdationRequest {
     String password;
     String firstname;
     String lastname;
     LocalDate dob;

}