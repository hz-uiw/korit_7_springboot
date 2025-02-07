package com.korit.springboot_study.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class ReqAddPublisher {
    @ApiModelProperty(value = "출판사명", example = "글나무", required = true)
    private String publisherName;
}
