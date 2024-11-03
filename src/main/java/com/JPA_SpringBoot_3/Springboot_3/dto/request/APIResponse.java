package com.JPA_SpringBoot_3.Springboot_3.dto.request;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.FieldDefaults;

// CREATE CONTRUCTOR FOR API RESPONSE
// KẾT QUẢ TRẢ VỀ THEO CẤU TRÚC ĐƯỢC CHỈ ĐỊNH
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class APIResponse <T> {
    @Builder.Default
    private int code =1000;
    private String message;
    private T result;
}
