package com.korit.springboot_study.dto.request.book.search;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReqSearchAuthor {
    @ApiModelProperty(value = "저자명", example = "박민지", required = true)
    private String searchKeyword = "";
}
