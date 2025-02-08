package com.korit.springboot_study.service;

import com.korit.springboot_study.dto.request.ReqAddCategoryDto;
import com.korit.springboot_study.dto.response.common.SuccessResponseDto;
import com.korit.springboot_study.entity.Category;
import com.korit.springboot_study.repository.CategoryRepository;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public SuccessResponseDto<List<Category>> getAllCategories() throws NotFoundException {
        List<Category> foundCategories = categoryRepository.findAllCategory()
                .orElseThrow(() -> new NotFoundException("카테고리가 존재하지 않습니다."));
        return new SuccessResponseDto<>(foundCategories);
    }

    public Category addCategory(ReqAddCategoryDto reqAddCategoryDto) {
        return categoryRepository
                .save(reqAddCategoryDto.toCategory())
                .get();
    }
}
