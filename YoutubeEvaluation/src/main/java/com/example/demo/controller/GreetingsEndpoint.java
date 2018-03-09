package com.example.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


//@RestController
@Controller
@RequestMapping("/videos")
public class GreetingsEndpoint {

    @GetMapping
    String page(){
        return "videos";
    }

    @ModelAttribute("welcome")
    String sayHi() {
        return "Hello Where are you!";
    }

    @ModelAttribute("videos")
    List<model.Video> videos(Model model){
        parser.Parser parser = new parser.Parser();
        model.addAttribute("CN1","Canada");
        List<model.Video> videos =
                parser.getDataFromFile("src/main/java/com/example/demo/data/CAvideos.csv", "CA");

        model.addAttribute("CN2","USA");
        List<model.Video> videos1 =
                parser.getDataFromFile("src/main/java/com/example/demo/data/USvideos.csv", "USA");
        model.addAttribute("ss",videos1);

        return videos;
    }

}
