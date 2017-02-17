package io.kch.spring.mvc1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

    @RequestMapping
    public String helloWorld(Model model) {
        model.addAttribute("message", "Hello World!!!");
        return "helloWorld";
    }
}
