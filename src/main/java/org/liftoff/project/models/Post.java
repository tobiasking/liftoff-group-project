package org.liftoff.project.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Post extends AbstractEntity{

    @NotBlank(message = "Title is required.")
    @Size(min = 3, max = 100, message = "Title must be between 3 and 100 characters.")
    private String title;

    @NotBlank(message = "Post content is required to create a post.")
    @Size(min = 3, max = 1600, message = "Content must be between 3 and 1600 characters.")
    private String content;

    @ManyToOne
    private User user;

    @ManyToOne
    @NotNull(message = "Category is required")
    private Category category;


    public Post(String title, String content, Category category, User user) {
        this.title = title;
        this.content = content;
        this.category = category;
        this.user = user;
    }

    public Post() {}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Post> getPosts() {
        return getPosts();
    }
    @Override
    public String toString() {
        return title;
    }


}
