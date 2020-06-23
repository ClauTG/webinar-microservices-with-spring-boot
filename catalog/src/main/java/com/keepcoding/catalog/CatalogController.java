package com.keepcoding.catalog;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CatalogController {


    @GetMapping("/catalog")
    public Catalog getCatalog() {
        var restTemplate = new RestTemplate();
        CategoryList categoryList = restTemplate.getForObject("http://localhost:8000/categories", CategoryList.class);

        Catalog catalog = new Catalog();
        catalog.setCategoriesData(categoryList.getCategoryList());

        catalog.setCategories(new ArrayList<>());
        categoryList.getCategoryList().forEach(category -> {
            List<Game> games = restTemplate.getForObject("http://localhost:9090/games/category/" + category.getId(), List.class);
            catalog.getCategories().add(new CatalogCategory(category.getName(), games));
        });
        return catalog;
    }
}
