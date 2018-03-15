package com.example.demo.controller;

import com.example.demo.persistence.Video;
import com.example.demo.persistence.VideoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;

@Controller
@RequestMapping("/data")
public class VideoController {


    private VideoRepository videoRepository;

    public VideoController(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }


    @GetMapping
    String Page() {
        return "data";
    }

    @ModelAttribute("videodata")
    List<Video> getAllVideo(){
        videoRepository.findAll()
                .stream()
                .limit(3)
                .forEach(e -> System.out.println(e.toString()));

        return videoRepository.findAll();
    }
}
