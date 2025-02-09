package com.korit.springboot_study.controller.bookInfo;

import com.korit.springboot_study.dto.request.book.add.ReqAddBookDto;
import com.korit.springboot_study.dto.request.book.search.ReqSearchBook;
import com.korit.springboot_study.dto.response.common.SuccessResponseDto;
import com.korit.springboot_study.entity.Book;
import com.korit.springboot_study.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Api(tags = "도서 정보 API")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/api/books")
    @ApiModelProperty(value = "도서 정보 전체 조회")
    public ResponseEntity<SuccessResponseDto<List<Book>>> getBooks(@ModelAttribute ReqSearchBook reqSearchBook) throws Exception {
        return ResponseEntity.ok().body(bookService.getAllBooks(reqSearchBook));
    }

    @PostMapping("/api/book")
    @ApiModelProperty(value = "도서 추가")
    public ResponseEntity<SuccessResponseDto<Book>> addBook(@Valid @RequestBody ReqAddBookDto reqAddBookDto) {
        return ResponseEntity.ok().body(new SuccessResponseDto<>(bookService.addBook(reqAddBookDto)));
    }


}
