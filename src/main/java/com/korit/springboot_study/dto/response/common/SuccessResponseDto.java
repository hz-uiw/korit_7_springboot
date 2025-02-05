package com.korit.springboot_study.dto.response.common;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(description = "성공 응답 DTO")
public class SuccessResponseDto<T> extends ResponseDto {
    private T data;

    public SuccessResponseDto(T data) {
        super(200, "요청이 성공적으로 처리되었습니다.", String.valueOf(System.currentTimeMillis()));
        this.data = data;
    }
}
