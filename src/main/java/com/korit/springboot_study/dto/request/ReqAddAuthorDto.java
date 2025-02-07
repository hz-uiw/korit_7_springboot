package com.korit.springboot_study.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class ReqAddAuthorDto {
    @ApiModelProperty(value = "저자명", example = "권민창", required = true)
    private String authorName;
}
