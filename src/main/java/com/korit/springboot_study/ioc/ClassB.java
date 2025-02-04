package com.korit.springboot_study.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ClassB {
    @Qualifier(value = "classC2")
    @Autowired(required = false)
    private ClassC c;

    public void classCallB() {
        System.out.println("ClassB 메서드 호출");
    }
}
