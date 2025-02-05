package com.korit.springboot_study.dto.response.common;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseDto {
    private int status;
    private String message;
    private String timestamp;
}
