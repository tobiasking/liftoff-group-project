package org.liftoff.project.controllers;

import org.liftoff.project.data.CategoryRepository;
import org.liftoff.project.data.PostRepository;
import org.liftoff.project.data.UserRepository;
import org.liftoff.project.models.Category;
import org.liftoff.project.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("post")
    public String displayCreatePostForm(Model model) {
        model.addAttribute("title", "Create Post");
        model.addAttribute(new Post());
        model.addAttribute("categories", categoryRepository.findAll());
        return "post/index";
    }
//    @GetMapping
//    public String displayPosts(@RequestParam(required = false) Integer categoryId, Model model) {
//
//        if (categoryId == null) {
//            model.addAttribute("title", "All Posts");
//            model.addAttribute("posts", postRepository.findAll());
//        } else {
//            Optional<Category> result = categoryRepository.findById(categoryId);
//            if (result.isEmpty()) {
//                model.addAttribute("title", "Invalid Category ID: " + categoryId);
//            } else {
//                Category category = result.get();
//                model.addAttribute("title", "Posts in category: " + category.getCategoryName());
//                model.addAttribute("posts",category.getPosts());
//            }
//        }
//
//        return "post";
//    }
//
//    @GetMapping("post")
//    public String displayCreatePostForm(Model model) {
//        model.addAttribute("title", "Create A Post");
//        model.addAttribute("post",new Post());
//        model.addAttribute("categories", categoryRepository.findAll());
//        return "post";
//    }
//
//    @PostMapping()
//    public String processCreatePostForm(@ModelAttribute @Valid Post newPost,
//                                         Errors errors, Model model) {
//        if(errors.hasErrors()) {
//            model.addAttribute("title", "Create Post");
//            return "post";
//        }
//
//        postRepository.save(newPost);
//        return "redirect:";
//    }

}
