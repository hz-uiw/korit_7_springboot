package com.korit.springboot_study.repository;

import com.korit.springboot_study.entity.Author;
import com.korit.springboot_study.mapper.AuthorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AuthorRepository {

    @Autowired
    private AuthorMapper authorMapper;

    public Optional<List<Author>> selectAuthorsAll() {
        List<Author> foundAllAuthors = authorMapper.selectAuthorsAll();

        return foundAllAuthors.isEmpty()
                ? Optional.empty()
                : Optional.ofNullable(foundAllAuthors);

    }
}
