package org.liftoff.project.controllers;

import org.liftoff.project.data.CategoryRepository;
import org.liftoff.project.data.PostRepository;
import org.liftoff.project.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @RequestMapping(value="post")
    public String post(){
        return "post";
    }
    @GetMapping("create")
    @ResponseBody
    public String displayCreatePostForm() { return "Create a Post Page";}

    //@PostMapping()
    // public String processCreatePostForm() {}

}