package org.liftoff.project.controllers;

import org.liftoff.project.data.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Explore {

    @Autowired
    private PostRepository postRepository;

    @GetMapping(value="/explore")
    public String displayMostRecentPosts(Model model){

        model.addAttribute("posts", postRepository.findAll());
        return "explore";
    }
}