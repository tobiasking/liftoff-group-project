package org.liftoff.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {

    @GetMapping("create")
    @ResponseBody
    public String displayCreatePostForm() { return "Create a Post Page";}

    //@PostMapping()
    // public String processCreatePostForm() {}

}
