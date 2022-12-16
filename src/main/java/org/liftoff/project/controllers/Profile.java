package org.liftoff.project.controllers;

import org.liftoff.project.data.UserRepository;
import org.liftoff.project.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Profile {

    @Autowired
    private UserRepository userRepository;


    @RequestMapping(value = "/profile")
    public String userProfile(Model model) {

        model.addAttribute("User", userRepository.findById(userId));
        return "profile";
    }
}
