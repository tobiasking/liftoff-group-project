package org.liftoff.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class LogIn {

    @RequestMapping(value="/login")

    public String login(){
        return "login";
    }
}
