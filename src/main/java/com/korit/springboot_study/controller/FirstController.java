package com.korit.springboot_study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // 컨트롤러를 만들면 필수
public class FirstController {

    @GetMapping("/mvc/hello")
    public String hello(Model model) {
        model.addAttribute("name", "권민창");
        System.out.println("hello 메소드 호출");
        return "hello"; // return으로 view 파일 경로를 반환 => return "/resource/templates/hello.html";
    }
}
