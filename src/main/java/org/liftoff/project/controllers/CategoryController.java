package org.liftoff.project.controllers;

import org.liftoff.project.data.CategoryRepository;
import org.liftoff.project.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping
    public String displayAllCategories(Model model) {
        Iterable<Category> categoryIterable = categoryRepository.findAll();
        List<Category> categories = new ArrayList<>();
        categoryIterable.forEach(categories::add);
        model.addAttribute("title", "All Categories");
        model.addAttribute("categories", categories);
        return "index";
    }
}




