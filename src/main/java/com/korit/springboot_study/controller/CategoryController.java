package com.korit.springboot_study.controller;

import com.korit.springboot_study.dto.request.ReqAddCategoryDto;
import com.korit.springboot_study.dto.request.ReqSearchCategory;
import com.korit.springboot_study.dto.response.common.SuccessResponseDto;
import com.korit.springboot_study.entity.Category;
import com.korit.springboot_study.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Api(tags = "카테고리 정보 API")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/api/categories")
    @ApiModelProperty(value = "카테고리 전체 조회")
    public ResponseEntity<SuccessResponseDto<List<Category>>> getCategories(@ModelAttribute ReqSearchCategory reqSearchCategory) throws Exception {
        return ResponseEntity.ok().body(categoryService.getAllCategories(reqSearchCategory));
    }

    @PostMapping("/api/category")
    @ApiModelProperty(value = "도서 카테고리 추가")
    public ResponseEntity<SuccessResponseDto<Category>> addCategory(@Valid @RequestBody ReqAddCategoryDto reqAddCategoryDto) {
        return ResponseEntity.ok().body(new SuccessResponseDto<>(categoryService.addCategory(reqAddCategoryDto)));
    }
}
