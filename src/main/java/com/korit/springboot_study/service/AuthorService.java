package com.korit.springboot_study.service;

import com.korit.springboot_study.dto.request.ReqAddAuthorDto;
import com.korit.springboot_study.dto.request.ReqSearchAuthor;
import com.korit.springboot_study.dto.response.common.SuccessResponseDto;
import com.korit.springboot_study.entity.Author;
import com.korit.springboot_study.repository.AuthorRepository;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public SuccessResponseDto<List<Author>> getAllAuthors(ReqSearchAuthor reqSearchAuthor) throws Exception {
        List<Author> foundAuthors = authorRepository.findAllAuthor(reqSearchAuthor.getSearchKeyword())
                .orElseThrow(() -> new NotFoundException("저자 정보가 존재하지 않습니다."));
        return new SuccessResponseDto<>(foundAuthors);
    }

    public Author addAuthor(ReqAddAuthorDto reqAddAuthorDto) {
        return authorRepository
                .save(reqAddAuthorDto.toAuthor())
                .get();
    }
}
