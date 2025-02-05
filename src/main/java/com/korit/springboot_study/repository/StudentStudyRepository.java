package com.korit.springboot_study.repository;

import com.korit.springboot_study.entity.study.Instructor;
import com.korit.springboot_study.entity.study.Major;
import com.korit.springboot_study.exception.CustomDuplicateKeyException;
import com.korit.springboot_study.mapper.StudentStudyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
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

    public Optional<List<Instructor>> findInstructorsAll() {
        List<Instructor> foundInstructors = studentStudyMapper.selectInstructorsAll();

        return foundInstructors.isEmpty()
                ? Optional.empty()
                : Optional.ofNullable(foundInstructors);
    }

    public Optional<Major> saveMajor(Major major) throws DuplicateKeyException {
        try {
            studentStudyMapper.insertMajor(major);
        } catch (DuplicateKeyException e) {
            throw new CustomDuplicateKeyException(
                    e.getMessage(),
                    Map.of("majorName", "이미 존재하는 학과명입니다.")
            );
        }
        return Optional.ofNullable(new Major(major.getMajorId(), major.getMajorName()));
    }
}
