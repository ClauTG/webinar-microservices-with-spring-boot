package com.keepcoding.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class CategoryController {

    @Autowired
    private Environment environment;

    @GetMapping(value= "/categories", produces = "application/json")
    public CategoryList getCategories() {
        var result = new CategoryList();
        var port = environment.getProperty("local.server.port");
        if(port != null) {
            result.setPort(Integer.parseInt(port));
        }
        result.setCategoryList(Arrays.asList(new Category(1L, "Accion/Aventura"),
                new Category(2L, "JRPG"),
                new Category(3L, "Shooter")));
        return result;
    }
}
