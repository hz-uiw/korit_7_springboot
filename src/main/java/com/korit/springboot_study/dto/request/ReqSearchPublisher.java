package com.korit.springboot_study.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReqSearchPublisher {
    @ApiModelProperty(value = "출판사명", example = "성심당", required = true)

    private String searchKeyword = "";
}
