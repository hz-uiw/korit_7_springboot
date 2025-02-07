package com.korit.springboot_study.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ReqAddPublisher {
    @ApiModelProperty(value = "출판사명", example = "글나무", required = true)
    private String publisherName;
}
