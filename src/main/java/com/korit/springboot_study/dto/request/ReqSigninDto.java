package com.korit.springboot_study.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Pattern;

@Data
public class ReqSigninDto {
    @ApiModelProperty(value = "사용자 이름", example = "hzuiw", required = true)
    @Pattern(regexp = "^[a-zA-Z0-9_]{5,20}$", message = "사용자 이름은 5~20자의 영문자, 숫자, 밑줄(_)만 포함 가능합니다.")
    private String username;

    @ApiModelProperty(value = "비밀번호", example = "qwer1234!", required = true)
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[!@#$%^&*])[A-Za-z\\d!@#$%^&*]{8,20}$", message = "8~20자의 영문자, 숫자, 특수문자(!@#$%^&*)를 포함해야 합니다.")
    private String password;
}
