package com.example.demo.view;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index1")
public class StartApp {

    @GetMapping
    String page()
    {
        return "index1";
    }


}
