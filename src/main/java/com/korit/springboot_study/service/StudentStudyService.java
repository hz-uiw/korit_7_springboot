package com.korit.springboot_study.service;

import com.korit.springboot_study.dto.response.common.SuccessResponseDto;
import com.korit.springboot_study.entity.study.Major;
import com.korit.springboot_study.repository.StudentStudyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentStudyService {

    @Autowired
    private StudentStudyRepository studentStudyRepository;

    public SuccessResponseDto<List<Major>> getMajorsAll() {
        Optional<List<Major>> foundMajors = studentStudyRepository.findMajorAll();
        if(foundMajors.isEmpty()) {
            return
        }
    }
}
