package com.korit.springboot_study.entity;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
public class ReqModifyUserDto {
    @NotNull(message = "이메일을 입력해 주세요.")
    @Email(message = "이메일 주소 형식으로 입력하세요.")
    private String email;

    public User toUser(int userId) {
        return User.builder()
                .userId(userId)
                .email(email)
                .build();
    }
}
