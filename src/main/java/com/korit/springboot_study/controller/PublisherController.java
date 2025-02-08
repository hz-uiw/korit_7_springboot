package com.korit.springboot_study.controller;

import com.korit.springboot_study.dto.request.ReqAddPublisherDto;
import com.korit.springboot_study.dto.response.common.SuccessResponseDto;
import com.korit.springboot_study.entity.Publisher;
import com.korit.springboot_study.service.PublisherService;
import io.swagger.annotations.ApiModelProperty;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    @GetMapping("/api/publishers")
    @ApiModelProperty(value = "출판사 정보 전체 조회")
    public ResponseEntity<SuccessResponseDto<List<Publisher>>> getPublishers() throws NotFoundException {
        return ResponseEntity.ok().body(publisherService.getAllPublishers());
    }

    @PostMapping("/api/publisher")
    @ApiModelProperty(value = "도서 출판사 추가")
    public ResponseEntity<SuccessResponseDto<Publisher>> addPublisher(@RequestBody ReqAddPublisherDto reqAddPublisherDto) {
        return ResponseEntity.ok().body(new SuccessResponseDto<>(publisherService.addPublisher(reqAddPublisherDto)));
    }
}
