package com.korit.springboot_study.dto.response.common;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data(staticConstructor = ResponseDto)
@ApiModel(description = "데이터 조회 실패 응답 DTO")
public class NotFoundResponseDto<T> extends ResponseDto {
    private T data;

    public NotFoundResponseDto(T data) {
        super(404, "데이터를 찾을 수 없습니다.", String.valueOf(System.currentTimeMillis()));
        this.data = data;
    }
}
