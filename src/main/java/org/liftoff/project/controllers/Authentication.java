package org.liftoff.project.controllers;

import org.liftoff.project.data.UserRepository;
import org.liftoff.project.models.User;
import org.liftoff.project.models.dto.LoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.Optional;
@Controller
public class Authentication {

    //create UserRepository instance to handle User model objects with this controller
    @Autowired
    UserRepository userRepository;
@GetMapping(value="/register")
    public String displayRegistrationForm(){

        return "register";
    }
@PostMapping(value="/register")
    public String processRegistrationForm(){

    return "register";
    }

    @GetMapping(value="/login")
    public String displayLoginForm(Model model){
        model.addAttribute(new LoginDTO());
        model.addAttribute("title", "Log In");
        return "login";
    }

    @PostMapping(value="/login")
    public String processLoginForm(){

        return "login";
    }



    //Session handlers


    //variable for storing user ID
    private static final String userSessionKey = "user";


    //User ID getter
    public User getUserFromSession(HttpSession session) {
        Integer userId = (Integer) session.getAttribute(userSessionKey);
        if (userId == null) {
            return null;
        }

        Optional<User> user = userRepository.findById(userId);

        // conditional
        if (user.isEmpty()) {
            return null;
        }
        return user.get();
    }


    //User ID setter
    private static void setUserInSession(HttpSession session, User user) {
        session.setAttribute(userSessionKey, user.getId());
    }
}
