package com.korit.springboot_study.dto.request.study;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@ApiModel(description = "도서 정보 조회 DTO")
public class ReqBookDto {
    @ApiModelProperty(value = "도서 이름", example = "지금, 만나러 갑니다.")
    private String bookName;
    @ApiModelProperty(value = "도서 ID", example = "123456")
    private int bookId;
}
