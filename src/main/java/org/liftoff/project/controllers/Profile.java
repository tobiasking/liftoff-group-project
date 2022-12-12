package org.liftoff.project.Controllers;

import org.liftoff.project.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Profile {


    @RequestMapping(value="/profile")
    public String profile(Model model){

        model.addAttribute("User",  new User("Test", "test123", null,  "test@test.com", "121233123123"));
        return "profile";
    }
//    ----!---- Maybe something like this ----!----
//    @GetMapping("/profile")
//     public string profile (Authentication authentication {
//     if (authentication = null) {
//    return "redirect:/login"
//    } else {
//    Profile profile = profileService.findByAuthentication(authentication);
//            return "redirect:/id/" + profile.getPath();
//        }
//    }
}
