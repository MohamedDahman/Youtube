package com.example.demo.controller;


import com.example.demo.persistence.Tag;
import com.example.demo.persistence.TagRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
@RequestMapping("/tags")
public class TagsData {

    private TagRepository tagRepository;

    public TagsData(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }


    @GetMapping
    String page(){
        return "tags";
    }

    @ModelAttribute("tagsnames")
    List<Tag> getalltags(){
        List<Tag> collect = tagRepository.findAll().stream().limit(10).collect(Collectors.toList());
        return collect;
    }


}
