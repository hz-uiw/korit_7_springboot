package com.korit.springboot_study.service;

import com.korit.springboot_study.dto.request.ReqSignupDto;
import com.korit.springboot_study.entity.User;
import com.korit.springboot_study.exception.CustomDuplicateKeyException;
import com.korit.springboot_study.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public User signup(ReqSignupDto reqSignupDto) {
        User user = reqSignupDto.toUser(passwordEncoder);
        return userRepository.save(user)
                .orElseThrow(() -> new CustomDuplicateKeyException("이미 존재하는 사용자 이름입니다.", Map.of("username", "이미 존재하는 사용자 이름입니다.")));
    }
}
