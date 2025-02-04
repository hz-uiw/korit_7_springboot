package com.korit.springboot_study.dto.request.study;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "학생 정보 조회 학습 DTO")
public class ReqStudentDto {
    @ApiModelProperty(value = "학생 이름", example = "권민창")
    private String name;
    @ApiModelProperty(value = "학생 나이", example = "26")
    private int age;
}
