package com.korit.springboot_study.repository;

import com.korit.springboot_study.entity.Author;
import com.korit.springboot_study.exception.CustomDuplicateKeyException;
import com.korit.springboot_study.mapper.AuthorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AuthorRepository {

    @Autowired
    private AuthorMapper authorMapper;

    public Optional<List<Author>> findAllAuthor(String authorName) {
        List<Author> foundAuthors = authorMapper.selectAuthorsAllContaining(authorName);

        return foundAuthors.isEmpty()
                ? Optional.empty()
                : Optional.of(foundAuthors);
    }

    public Optional<Author> save(Author author) {
        try {
            authorMapper.insertAuthor(author);
        } catch (DuplicateKeyException e) {
            throw new CustomDuplicateKeyException("이미 존재하는 저자입니다.");
        }
        return Optional.of(author);
    }
}
