package org.liftoff.project.controllers;

import org.liftoff.project.data.UserRepository;
import org.liftoff.project.models.Post;
import org.liftoff.project.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.events.Event;

import javax.persistence.Id;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;

@Controller
public class Profile {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public String getAllUsers (Model model) {
        model.addAttribute("user", userRepository.findAll());
        return "User/users";
    }
    @GetMapping(value = "/profile/{id}")
    public String displayProfile(@PathVariable Integer id, Model model){
                Optional<User> attributes = this.userRepository.findById(id);

                model.addAttribute("user", attributes.get() );
                return "User/profile";

    }
}