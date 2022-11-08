package org.liftoff.project.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Explore {

    @RequestMapping(value="/explore     ")
    @ResponseBody
    public String index(){
        return "Exploration Page";
    }
}