package org.liftoff.project.controllers;

import org.liftoff.project.data.CategoryRepository;
import org.liftoff.project.data.PostRepository;
import org.liftoff.project.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("explore")
public class Explore {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping
    public String displayMostRecentPosts(Model model){
        model.addAttribute("posts", postRepository.findByOrderByIdDesc());
        return "explore";
    }

    @GetMapping("content")
    public String displayPostContent(@RequestParam Integer postId, Model model){

        Optional<Post> result = postRepository.findById(postId);

        if (result.isEmpty()) {
            model.addAttribute("header", "Post does not exist");
        } else {
            Post post = result.get();
            model.addAttribute("header", post.getTitle() + " by " + post.getUser());
            model.addAttribute("postContent", post.getContent());
            model.addAttribute("postId", post.getId());
        }

        return "post/content";
    }

    @GetMapping("edit")
    public String getEditPostPage(@RequestParam Integer postId, Model model){

        Optional<Post> result = postRepository.findById(postId);

        if (result.isEmpty()) {
            model.addAttribute("title", "Post does not exist");
        } else {
            Post post = result.get();
            model.addAttribute("title", post.getTitle());
            model.addAttribute("postContent", post.getContent());
            model.addAttribute("postId", post.getId());
        }

        return "post/edit";
    }

    @PostMapping("edit")
    public String submitEditPostForm(@RequestParam Integer postId, String title, String postContent, Model model){

        Optional<Post> result = postRepository.findById(postId);

        Post postToUpdate = result.get();
        postToUpdate.setTitle(title);
        postToUpdate.setContent(postContent);
        postRepository.save(postToUpdate);


        return "redirect:/explore/content?postId="+postId;
    }
    @GetMapping("delete")
    public String deletePost(@RequestParam Integer postId) {
        // Retrieve the post by id
        Optional<Post> result = postRepository.findById(postId);

        // Check if the post exists
        if (result.isPresent()) {
            // Delete the post from the database
            postRepository.deleteById(postId);
        }

        // Redirect to the explore page after deleting
        return "redirect:/explore";
    }
}

