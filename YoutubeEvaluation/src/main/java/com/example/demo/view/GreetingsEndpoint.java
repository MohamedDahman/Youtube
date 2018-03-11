package com.example.demo.view;


import com.example.demo.model.Video;
import com.example.demo.parser.*;
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


    @ModelAttribute("videos")
    List<Video> videos(Model model){
        Parser parser = new Parser();
        model.addAttribute("CN1","Canada");

        List<Video> videos =
                parser.getDataFromFile("src/main/java/com/example/demo/data/CAvideos.csv", "CA");

        model.addAttribute("CN2","USA");
        List<Video> videos1 =
                parser.getDataFromFile("src/main/java/com/example/demo/data/USvideos.csv", "USA");
        model.addAttribute("ss",videos1);

        return videos;
    }

}
