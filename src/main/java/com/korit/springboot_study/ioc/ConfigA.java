package com.korit.springboot_study.ioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration  // 우선순위가 가장 높음 => 컴파일 시 Bean 등록
public class ConfigA {
    // 메서드를 호출하지 않아도 Configuration가 자동 호출 -> 클래스와 메서드의 리턴값을 bean 등록
    @Bean(value = "qwe")    // qwe라는 이름으로 bean 이름 설정 -> 기본설정은 메서드명으로 Bean에서 등록
    public ClassD call() {
        System.out.println("ConfigA call");
        return new ClassD();
    }


}
