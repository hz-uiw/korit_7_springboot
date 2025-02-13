package com.korit.springboot_study.dto.request;

import com.korit.springboot_study.entity.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

@Data
public class ReqSignupDto {
    @ApiModelProperty(value = "사용자 이름", example = "hzuiw", required = true)
    @Pattern(regexp = "^[a-zA-Z0-9_]{5,20}$", message = "사용자 이름은 5~20자의 영문자, 숫자, 밑줄(_)만 포함 가능합니다.")
    private String username;

    @ApiModelProperty(value = "비밀번호", example = "qwer1234!", required = true)
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[!@#$%^&*])[A-Za-z\\d!@#$%^&*]{8,20}$", message = "8~20자의 영문자, 숫자, 특수문자(!@#$%^&*)를 포함해야 합니다.")
    private String password;

    @ApiModelProperty(value = "성명", example = "신신", required = true)
    @Pattern(regexp = "^[가-힣a-zA-Z]{2,30}$", message = "이름은 2~30자의 한글 또는 영문자로 입력해야 합니다.")
    private String name;

    @ApiModelProperty(value = "이메일", example = "qwe234@gmail.com", required = true)
    @Email(message = "올바른 이메일 형식(example@example.com)으로 입력해주세요.")
    private String email;

    public User toUser(BCryptPasswordEncoder passwordEncoder) {
        return User.builder()
                .username(username)
                .password(password)
                .name(name)
                .email(email)
                .build();
    }
}
