package com.korit.springboot_study.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ClassB {

    @Qualifier("c1")
    @Autowired
    private ClassC c1;
    @Qualifier("c2")
    @Autowired
    private ClassC c2;

    public void classCallB() {
        System.out.println("ClassB 메서드 호출");
    }
}