package com.korit.springboot_study.ioc;

import org.springframework.stereotype.Component;

@Component
public class ClassA {

    public void classCallA() {
        System.out.println("ClassA 메서드 호출");
    }
}
