package com.keepcoding.catalog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CatalogController {


    @Autowired
    private GamesService gamesService;

    @Autowired
    private CategoryService categoryService;


    @GetMapping(value = "/catalog", produces = "application/json")
    public Catalog getCatalog() {
        CategoryList categoryList = categoryService.getCategories();

        Catalog catalog = new Catalog();
        catalog.setCategoriesPort(categoryList.getPort());
        catalog.setCategoriesData(categoryList.getCategoryList());

        catalog.setCategories(new ArrayList<>());
        categoryList.getCategoryList().forEach(category -> {
            List<Game> games = gamesService.getGames(category.getId());
            catalog.getCategories().add(new CatalogCategory(category.getName(), games));
        });
        return catalog;
    }
}
