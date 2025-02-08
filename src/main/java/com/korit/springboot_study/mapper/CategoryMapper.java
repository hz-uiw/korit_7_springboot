package com.korit.springboot_study.mapper;

import com.korit.springboot_study.entity.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CategoryMapper {
    List<Category> selectCategoriesAllContaining(@Param(value = "categoryName") String categoryName);

    int insertCategory(Category category);
}
