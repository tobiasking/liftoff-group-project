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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping
    public String displayAllCategories(Model model) {
        System.out.println("Inside displayAllCategories method");
        Iterable<Category> categoryIterable = categoryRepository.findAll();
        List<Category> categories = new ArrayList<>();
        categoryIterable.forEach(categories::add);
        System.out.println("Number of categories: " + categories.size());
        model.addAttribute("title", "All Categories");
        model.addAttribute("categories", categories);
        return "index";
    }
}




