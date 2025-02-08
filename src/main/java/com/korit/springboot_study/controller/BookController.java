package com.korit.springboot_study.controller;

import com.korit.springboot_study.dto.request.ReqAddBookDto;
import com.korit.springboot_study.dto.response.common.SuccessResponseDto;
import com.korit.springboot_study.entity.Book;
import com.korit.springboot_study.service.BookService;
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
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/api/books")
    @ApiModelProperty(value = "도서 정보 전체 조회")
    public ResponseEntity<SuccessResponseDto<List<Book>>> getBooks() throws NotFoundException {
        return ResponseEntity.ok().body(bookService.getAllBooks());
    }

    @PostMapping("/api/book")
    @ApiModelProperty(value = "도서 추가")
    public ResponseEntity<SuccessResponseDto<Book>> addBook(@RequestBody ReqAddBookDto reqAddBookDto) {
        return ResponseEntity.ok().body(new SuccessResponseDto<>(bookService.addBook(reqAddBookDto)));
    }


}
