package org.liftoff.project.Controllers;

import org.liftoff.project.Models.RegisterModel;
import org.springframework.beans.factory.annotation.Autowired;
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
