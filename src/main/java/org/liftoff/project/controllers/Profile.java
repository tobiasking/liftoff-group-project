package org.liftoff.project.controllers;

import org.liftoff.project.data.UserRepository;
import org.liftoff.project.models.Post;
import org.liftoff.project.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.events.Event;

import javax.persistence.Id;
import javax.validation.Valid;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.function.BinaryOperator;

@Controller
public class Profile {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public String getAllUsers(Model model) {
        model.addAttribute("user", userRepository.findAll());
        return "User/users";
    }

    @RequestMapping(value = "/update-bio", method = RequestMethod.POST)
    public String updateBio(@ModelAttribute("bio") String bio) {
        userRepository.save(this.userRepository.findByBio(bio));
        return "User/success";
    }


    @GetMapping(value = "/profile/{id}")
    public String displayProfile(@PathVariable Integer id, Model model){
                Optional<User> attributes = this.userRepository.findById(id);

                model.addAttribute("user", attributes.get() );
                return "User/profile";

    }

}