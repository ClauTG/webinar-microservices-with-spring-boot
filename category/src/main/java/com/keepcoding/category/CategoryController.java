package com.keepcoding.category;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class CategoryController {

    @GetMapping("/categories")
    public CategoryList getCategories() {
        var result = new CategoryList();
        result.setCategoryList(Arrays.asList(new Category(1L, "ropa"), new Category(2L, "comida")));
        return result;
    }
}
