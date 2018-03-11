package com.example.demo.view;

import com.example.demo.controller.Dislpyer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;


@Controller
@RequestMapping("/moreVideos")
public class MostChanelHaveVideos {

    @GetMapping
    String page() {
        return "moreVideos";
    }

    @GetMapping("/{country}")
    String showMostChanelHaveVideos(@PathVariable String country, Model model) {
        Dislpyer dislpyer = new Dislpyer();
        List<String> list = dislpyer.displayMostChanelHaveVideoAsList(5, country);
        model.addAttribute("videos", list);
        return "moreVideos";
    }
}
