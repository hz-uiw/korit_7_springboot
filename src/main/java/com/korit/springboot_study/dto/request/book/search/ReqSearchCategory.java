package com.korit.springboot_study.dto.request.book.search;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReqSearchCategory {
    @ApiModelProperty(value = "카테고리명", example = "시사/교양", required = true)
    private String searchKeyword = "";
}
