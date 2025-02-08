package com.korit.springboot_study.repository;

import com.korit.springboot_study.entity.Category;
import com.korit.springboot_study.exception.CustomDuplicateKeyException;
import com.korit.springboot_study.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepository {

    @Autowired
    private CategoryMapper categoryMapper;

    public Optional<List<Category>> findAllCategory() {
        List<Category> foundCategories = categoryMapper.selectCategoriesAll();
        return foundCategories.isEmpty()
                ? Optional.empty()
                : Optional.ofNullable(foundCategories);
    }

    public Optional<Category> save(Category category) {
        try {
            categoryMapper.insertCategory(category);
        } catch (DuplicateKeyException e) {
            throw new CustomDuplicateKeyException(e.getMessage());
        }
        return Optional.of(category);
    }
}
