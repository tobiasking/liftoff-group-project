package org.liftoff.project.controllers;

import org.liftoff.project.data.UserRepository;
import org.liftoff.project.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


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
    public String updateBio(@RequestParam String bio, Integer id, Model model) {

        Optional<User> userBio = this.userRepository.findById(id);
        User updateBio = userBio.get();
        updateBio.setBio(bio);
        userRepository.save(updateBio);
        return "User/success";
    }


    @GetMapping(value = "/profile/{id}")
    public String displayProfile(@PathVariable Integer id, Model model){
                Optional<User> attributes = this.userRepository.findById(id);

                model.addAttribute("user", attributes.get() );
                return "User/profile";

    }

}