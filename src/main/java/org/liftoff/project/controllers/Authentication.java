package org.liftoff.project.controllers;

import org.liftoff.project.data.UserRepository;
import org.liftoff.project.models.User;
import org.liftoff.project.models.dto.LoginDTO;
import org.liftoff.project.models.dto.RegisterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Optional;

@Controller
public class Authentication {

    //create a UserRepository instance to handle User model objects with the controller
    @Autowired
    UserRepository userRepository;

    private static final String userSessionKey = "user";


//    @GetMapping(value = "/register")
//    public String displayRegistrationForm(Model model) {
//        model.addAttribute(new RegisterDTO());
//        model.addAttribute("title", "register");
//        return "register";
//    }

    @PostMapping(value = "/login")
    public String processLoginForm(@ModelAttribute @Valid LoginDTO loginDTO,
                                   Errors errors, HttpServletRequest request,
                                   Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Log In");
            return "login";
        }

        User theUser = userRepository.findByUserName(loginDTO.getUsername());


        if (theUser == null) {
            errors.rejectValue("username", "user.invalid", "That username does not exist");
            model.addAttribute("title", "Log In");
        }else {

            String password = loginDTO.getPassword();


            // Password verification

            if (!theUser.isMatchingPassword(password)) {
                errors.rejectValue("password", "password.invalid", "Invalid password");
                model.addAttribute("title", "Log In");

                setUserInSession(request.getSession(), theUser);

                return "login";
            }

            return "index";
        }
        return "login";
    }

    private void setUserInSession(HttpSession session, User theUser) {
    }


    public User getUserFromSession (HttpSession session, User user){
        Integer userId = (Integer) session.getAttribute(userSessionKey);
        if (userId == null) {
            return null;
        }

        Optional<User> theUser = userRepository.findById(userId);

        // conditional
        if (theUser.isEmpty()) {
            return null;
        }
        return theUser.get();
    }



    @GetMapping(value = "/login")
    public String displayLoginForm(Model model) {
        model.addAttribute(new LoginDTO());
        model.addAttribute("title", "Log In");
        return "login";
    }

//    @PostMapping(value = "/register")
//    public String processRegistrationForm(@ModelAttribute @Valid RegisterDTO registerDTO,
//                                          Errors errors, HttpServletRequest request,
//                                          Model model) {
//        if (errors.hasErrors()) {
//            model.addAttribute("title", "Register");
//            return "register";
//
//        }
//        User existingUser = userRepository.findByUserName(registerDTO.getUsername());
//
//        if (existingUser != null) {
//            errors.rejectValue("username", "username.alreadyexists", "A user with that username already exists");
//            model.addAttribute("title", "Register");
//
//
//            String password = registerDTO.getPassword();
//            String verifyPassword = registerDTO.getVerifyPassword();
//            if (!password.equals(verifyPassword)) {
//                errors.rejectValue("password", "passwords.mismatch", "Passwords do not match");
//                model.addAttribute("title", "Register");
//                return "register";
//            }
//        errors.rejectValue("username", "username.alreadyexists",
//                "A user with that username already exists");
//
//
//            // use these object methods for later use ----> ,
//            //registerDTO.getDateOfBirth(), registerDTO.getEmail(), registerDTO.getPhoneNumber())
//
//
//            //create a new user object to store in the DB
//
//            User newUser = new User(registerDTO.getUsername(), registerDTO.getPassword());
//
//            userRepository.save(newUser);
//            setUserInSession(request.getSession(), newUser);
//
//            return "redirect:";
//        }
//
//
//        //Session handlers...
//
//
////}
////
//
//        return "register";
//    }
    @GetMapping(value="/logout")
    public String logout(HttpServletRequest request){
        request.getSession().invalidate();
        return "redirect/login";
    }
}