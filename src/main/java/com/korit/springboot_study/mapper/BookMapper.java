package com.korit.springboot_study.mapper;

import com.korit.springboot_study.entity.Author;
import com.korit.springboot_study.entity.Book;
import com.korit.springboot_study.entity.Category;
import com.korit.springboot_study.entity.Publisher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BookMapper {
    List<Book> selectBooksAllContaining(@Param(value = "bookName") String bookName);

    int insertBook(Book book);
}
