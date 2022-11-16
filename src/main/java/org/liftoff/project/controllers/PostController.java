package org.liftoff.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {

    @RequestMapping(value="/create")
    @ResponseBody
    public String index() { return "Create a Post Page";}

}
