package org.liftoff.project.models;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Category extends AbstractEntity {


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


    @Override
    public String toString() {
        return categoryName;
    }

}
