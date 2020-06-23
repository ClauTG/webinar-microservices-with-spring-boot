package com.keepcoding.catalog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CatalogController {


    @Autowired
    private RestTemplate restTemplate;


    @GetMapping(value = "/catalog", produces = "application/json")
    public Catalog getCatalog() {
        CategoryList categoryList = restTemplate.getForObject("http://category-service/categories", CategoryList.class);

        Catalog catalog = new Catalog();
        catalog.setCategoriesPort(categoryList.getPort());
        catalog.setCategoriesData(categoryList.getCategoryList());

        catalog.setCategories(new ArrayList<>());
        categoryList.getCategoryList().forEach(category -> {
            List<Game> games = restTemplate.getForObject("http://games-service/games/category/" + category.getId(), List.class);
            catalog.getCategories().add(new CatalogCategory(category.getName(), games));
        });
        return catalog;
    }
}
