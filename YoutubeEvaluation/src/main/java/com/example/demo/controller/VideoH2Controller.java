package com.example.demo.controller;


import com.example.demo.persistence.TestVideo;
import com.example.demo.persistence.TestVideoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/test")
public class VideoH2Controller {

    private TestVideoRepository testVideoRepository;

    public VideoH2Controller(TestVideoRepository videoRepository) {
        this.testVideoRepository = videoRepository;
    }

    @GetMapping
    String page(){
        return "test";
    }

    @PostMapping
    String add(@Valid TestVideo testVideo, BindingResult result){
        if (result.hasErrors()) {
            return page();
        }
        testVideoRepository.save(testVideo);
        return "redirect:" + page();
    }

    @DeleteMapping("/{id}")
    public String remove(@PathVariable Long id) {
        testVideoRepository.delete(id);
        return "redirect:/" + page();
    }

    @ModelAttribute("testVideos")
    List<TestVideo> allvideos(){
        return testVideoRepository.findAll();
    }

    @ModelAttribute("testvideo")
    TestVideo testVideo(){
        return new TestVideo();
    }
}
