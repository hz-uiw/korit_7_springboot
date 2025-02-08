package com.korit.springboot_study.dto.request;

import com.korit.springboot_study.entity.Book;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ReqAddBookDto {
    @ApiModelProperty(value = "도서명", example = "소나무", required = true)
    private String bookName;
    @ApiModelProperty(value = "저자 ID", example = "123456", required = true)
    private int authorId;
    @ApiModelProperty(value = "ISBN", example = "C12345", required = true)
    private String isbn;
    @ApiModelProperty(value = "카테고리 ID", example = "123456", required = true)
    private int categoryId;
    @ApiModelProperty(value = "출판사 ID", example = "123456", required = true)
    private int publisherId;
    @ApiModelProperty(value = "이미지 경로(URL)", example = "http://example.com/test.jpg", required = true)
    private String bookImgUrl;

    public Book toBook() {
        return Book.builder().
                bookName(bookName).
                authorId(authorId).
                isbn(isbn).
                categoryId(categoryId).
                publisherId(publisherId).
                bookImgUrl(bookImgUrl).
                build();
    }
}
