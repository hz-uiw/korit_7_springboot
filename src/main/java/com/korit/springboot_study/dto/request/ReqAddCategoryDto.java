package com.korit.springboot_study.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ReqAddCategoryDto {
    @ApiModelProperty(value = "카테고리명", example = "시사/교양", required = true)
    private String categoryName;
}
