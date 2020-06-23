package com.keepcoding.category;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class CategoryController {

    @GetMapping("/categories")
    public CategoryList getCategories() {
        var result = new CategoryList();
        result.setCategoryList(Arrays.asList(new Category(1L, "Accion/Aventura"),
                new Category(2L, "JRPG"),
                new Category(3L, "Shooter")));
        return result;
    }
}
