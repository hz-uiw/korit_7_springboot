package com.korit.springboot_study.dto.request.study;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
//@AllArgsConstructor // 필수 생성자 뿐만 아니라 모든 필드를 초기화 하는 생성자를 생성
@RequiredArgsConstructor    // 생성될 때 필수로 값이 들어가야할 때 사용 NonNull, final 이 아닌 필드는 제외
//  두개의 어노테이션을 같이 사용할 경우 상황에 따라 특정필드만 초기화하거나 모든 필드를 초기화 하는 생성자를 선택할 수 있다
@ApiModel(description = "학생정보 조회 학습 DTO")
public class ReqStudentDto {
    @ApiModelProperty(value = "학생 이름", example = "권민창")
    private String name;
    @ApiModelProperty(value = "학생 나이", example = "26")
    private int age;
}
