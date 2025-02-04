package com.korit.springboot_study.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClassA {

    @Autowired  // ClassD 클래스 의존 => ClassD를 ClassA에 의존성 주입
    private ClassD d;

    public void classCallA() {
        System.out.println("ClassA 메서드 호출");
        //dddd
    }
}