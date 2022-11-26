package org.liftoff.project.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
public class Category {

    @Id
    @GeneratedValue
    private int id;

    @NotBlank(message = "Category name is required.")
    @Size(min = 3, max = 100, message = "Category name must be between 3 and 100 characters.")
    private String categoryName;


    public Category(String categoryName){
        this.categoryName = categoryName;
    }

    public Category(){}

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return categoryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return id == category.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
