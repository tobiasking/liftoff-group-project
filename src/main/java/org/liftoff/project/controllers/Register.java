package org.liftoff.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Register {

    @RequestMapping(value="/register")
    @ResponseBody
    public String index(){
        return "Registration Page";
    }
}
