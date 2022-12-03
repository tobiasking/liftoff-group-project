package org.liftoff.project.controllers;

import org.liftoff.project.data.CategoryRepository;
import org.liftoff.project.data.PostRepository;
import org.liftoff.project.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/explore")
public class Explore {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping
    public String displayMostRecentPosts(Model model){
        model.addAttribute("posts", postRepository.findByOrderByIdDesc());
        return "explore";
    }

    @GetMapping("content")
    public String displayPostContent(@RequestParam Integer postId, Model model){

        Optional<Post> result = postRepository.findById(postId);

        if (result.isEmpty()) {
            model.addAttribute("header", "Post does not exist");
        } else {
            Post post = result.get();
            model.addAttribute("header", post.getTitle() + " by " + post.getUser());
            model.addAttribute("postContent", post.getContent());
        }

        return "post/content";
    }

}