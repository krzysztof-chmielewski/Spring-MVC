package io.kch.spring.mvc2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

    @RequestMapping
    public String helloWorld(Model model) {
        model.addAttribute("message", "This is the app that will run always if we do not specify context path.");
        return "helloWorld";
    }
}
