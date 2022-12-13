package org.liftoff.project.controllers;

import org.liftoff.project.data.UserRepository;
import org.liftoff.project.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
public class Register {


    @Autowired
    UserRepository userRepository;

    @RequestMapping("register")
    public String getUserRegistration(Model model){
        User userRegister= new User();
        model.addAttribute("userRegister",userRegister);
        return "register";
    }

    @PostMapping("register")
    public String postUserRegistration(@Valid User userRegister, Errors error){

        if(error.hasErrors()){
            return "redirect:/register";
        }else{
            userRepository.save(userRegister);
        }

     return "/";
    }


}
