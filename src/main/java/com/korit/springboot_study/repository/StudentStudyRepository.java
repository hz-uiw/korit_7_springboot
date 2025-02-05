package com.korit.springboot_study.repository;

import com.korit.springboot_study.entity.study.Major;
import com.korit.springboot_study.mapper.StudentStudyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentStudyRepository {

    @Autowired
    private StudentStudyMapper studentStudyMapper;

    public Optional<List<Major>> findMajorAll() {
        List<Major> foundMajors = studentStudyMapper.selectMajorsAll();

//        if(foundMajors.isEmpty()) {
//            return Optional.empty();
//        }
//
//        return Optional.ofNullable(foundMajors);

        return foundMajors.isEmpty()
                ? Optional.empty()
                : Optional.ofNullable(foundMajors);
    }
}
