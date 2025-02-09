package com.korit.springboot_study.controller.bookInfo;


import com.korit.springboot_study.dto.request.book.add.ReqAddAuthorDto;
import com.korit.springboot_study.dto.request.book.search.ReqSearchAuthor;
import com.korit.springboot_study.dto.response.common.SuccessResponseDto;
import com.korit.springboot_study.entity.Author;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import com.korit.springboot_study.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

@Controller
@Api(tags = "저자 정보 API")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/api/authors")
    @ApiModelProperty(value = "저자 정보 전체 조회")
    public ResponseEntity<SuccessResponseDto<List<Author>>> getAuthors(@ModelAttribute ReqSearchAuthor reqSearchAuthor) throws Exception {
        return ResponseEntity.ok().body(authorService.getAllAuthors(reqSearchAuthor));
    }

    @PostMapping("/api/author")
    @ApiModelProperty(value = "저자 정보 추가")
    public ResponseEntity<SuccessResponseDto<Author>> addAuthor(@Valid @RequestBody ReqAddAuthorDto reqAddAuthorDto) {
        return ResponseEntity.ok().body(new SuccessResponseDto<>(authorService.addAuthor(reqAddAuthorDto)));
    }
}
