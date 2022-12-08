package org.liftoff.project.controllers;

import org.liftoff.project.data.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/explore-page")
public class Explore {

    @Autowired
    private PostRepository posttRepository;

    private int counter;

    @GetMapping
    public String displayOldestPosts(Model model){
        counter = 0;
        model.addAttribute("posts", posttRepository.findByOrderByIdAsc());
        model.addAttribute("counter", counter);
        return "explore";
    }

    @PostMapping()
    public String test(Model model) {
        counter += 1;
        model.addAttribute("counter", counter);
        return "explore";
    }


}