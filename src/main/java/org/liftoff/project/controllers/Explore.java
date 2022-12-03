package org.liftoff.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Explore {

    @RequestMapping(value="/explore")
    public String explore(){
        return "explore";
    }
}