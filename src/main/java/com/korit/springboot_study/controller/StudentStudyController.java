package com.korit.springboot_study.controller;

import com.korit.springboot_study.dto.request.study.ReqAddInstructorDto;
import com.korit.springboot_study.dto.request.study.ReqAddMajorDto;
import com.korit.springboot_study.dto.request.study.ReqUpdateMajorDto;
import com.korit.springboot_study.dto.response.common.SuccessResponseDto;
import com.korit.springboot_study.entity.study.Instructor;
import com.korit.springboot_study.entity.study.Major;
import com.korit.springboot_study.service.StudentStudyService;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@Validated  // 컨트롤러 안에서 바로 유효검사, @Valid와는 상관없다
public class StudentStudyController {

    @Autowired
    private StudentStudyService studentStudyService;

    @GetMapping("/api/study/majors")
    @ApiModelProperty(value = "학과 전체 조회")
    public ResponseEntity<SuccessResponseDto<List<Major>>> getMajors() throws NotFoundException {

        return ResponseEntity.ok().body(studentStudyService.getMajorsAll());
    }

    @GetMapping("/api/study/instructors")
    @ApiModelProperty(value = "교수 전체 조회")
    public ResponseEntity<SuccessResponseDto<List<Instructor>>> getInstructor() throws NotFoundException {
        return ResponseEntity.ok().body(studentStudyService.getInstructorsAll());
    }

    @PostMapping("/api/study/major")
    public ResponseEntity<SuccessResponseDto<Major>> addMajor(@Valid @RequestBody ReqAddMajorDto reqAddMajorDto) throws MethodArgumentNotValidException {
        System.out.println(reqAddMajorDto);
        return ResponseEntity.ok().body(studentStudyService.addMajor(reqAddMajorDto));
    }

    @PostMapping("api/study/instructor")
    public ResponseEntity<SuccessResponseDto<Instructor>> addInstructor(@RequestBody ReqAddInstructorDto reqAddInstructorDto) {
        System.out.println(reqAddInstructorDto);
        return ResponseEntity.ok().body(studentStudyService.addInstructor(reqAddInstructorDto));
    }

    @PutMapping("/api/study/major/{majorId}")
    public ResponseEntity<SuccessResponseDto<?>> updateMajor(
            @ApiParam(value = "학과 ID", example = "1", required = true)
            @PathVariable @Min(value = 1, message = "학과 ID는 1이상의 정수여야합니다.") int majorId,
            @Valid @RequestBody ReqUpdateMajorDto reqUpdateMajorDto) throws NotFoundException, MethodArgumentNotValidException {
        return ResponseEntity.ok().body(studentStudyService.modifyMajor(majorId, reqUpdateMajorDto));
    }

}
