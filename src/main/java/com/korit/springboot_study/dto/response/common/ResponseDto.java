package com.korit.springboot_study.dto.response.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
@ApiModel(description = "응답 DTO")
public class ResponseDto<T> {

    @ApiModelProperty(value = "응답 시간", example = "2000-01-01T12:00:00.00")
    private String timestamp = String.valueOf(LocalDateTime.now());

    @ApiModelProperty(value = "응답 데이터", example = "")
    private final T data;
}
