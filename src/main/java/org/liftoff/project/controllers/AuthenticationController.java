package org.liftoff.project.controllers;

import org.liftoff.project.data.UserRepository;
import org.liftoff.project.models.User;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;
import java.util.Optional;

public class AuthenticationController {
    //create UserRepository instance to handle User model objects with this controller
    @Autowired
    UserRepository userRepository;


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
