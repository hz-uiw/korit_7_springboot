package com.korit.springboot_study.repository;

import com.korit.springboot_study.entity.Book;
import com.korit.springboot_study.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BookRepository {

    @Autowired
    private BookMapper bookMapper;

    public Optional<List<Book>> selectBooksAll() {
        List<Book> foundAllBook = bookMapper.selectBooksAll();

        return foundAllBook.isEmpty()
                ? Optional.empty()
                : Optional.ofNullable(foundAllBook);
    }
}
