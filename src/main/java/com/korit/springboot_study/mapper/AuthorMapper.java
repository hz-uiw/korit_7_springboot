package com.korit.springboot_study.mapper;

import com.korit.springboot_study.entity.Author;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AuthorMapper {
    List<Author> selectAuthorsAll();
}
