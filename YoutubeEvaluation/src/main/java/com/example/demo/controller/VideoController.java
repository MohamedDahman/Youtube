package com.example.demo.controller;

import com.example.demo.persistence.Video;
import com.example.demo.persistence.VideoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
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
    List<Video> getAllVideo(HttpSession session, Model model){
        videoRepository.findAll()
                .stream()
                .limit(3)
                .forEach(e -> System.out.println(e.toString()));
        session.setAttribute("userName","Mohamed");
        Object koKo = null;
        try {
            koKo = session.getAttribute("userName");
            model.addAttribute("userName", koKo.toString());
        } catch (Exception e) {
            model.addAttribute("userName", "user not login .....!");
            e.printStackTrace();
        }

        /*HttpServletRequest request = null;
        request.getSession().setAttribute("koko", "Mohamed");
*/

        return videoRepository.findAll();
    }
}
