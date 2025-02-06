package com.korit.springboot_study.controller;


import com.korit.springboot_study.dto.response.common.SuccessResponseDto;
import com.korit.springboot_study.entity.Author;
import io.swagger.annotations.ApiModelProperty;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import com.korit.springboot_study.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/api/authors")
    @ApiModelProperty(value = "저자 정보 전체 조회")
    public ResponseEntity<SuccessResponseDto<List<Author>>> getAuthors() throws NotFoundException {
        return ResponseEntity.ok().body(authorService.getAllAuthors());
    }
}
