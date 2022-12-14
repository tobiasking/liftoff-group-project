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

import javax.validation.Valid;

@Controller
@RequestMapping("categories")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping
    public String displayAllCategories(Model model) {
        model.addAttribute("title", "All Categories");
        model.addAttribute("categories", categoryRepository.findAll());
        return "explore";
    }

}
