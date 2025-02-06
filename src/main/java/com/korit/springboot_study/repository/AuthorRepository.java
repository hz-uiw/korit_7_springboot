package com.korit.springboot_study.repository;

import com.korit.springboot_study.mapper.AuthorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AuthorRepository {

    @Autowired
    private AuthorMapper authorMapper;
}
