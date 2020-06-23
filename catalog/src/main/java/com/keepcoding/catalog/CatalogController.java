package com.keepcoding.catalog;

import org.springframework.beans.factory.annotation.Autowired;
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
        CategoryList categoryList = restTemplate.getForObject("http://localhost:8080/categories", CategoryList.class);

        Catalog catalog = new Catalog();
        catalog.setCategoriesData(categoryList.getCategoryList());

        catalog.setCategories(new ArrayList<>());
        categoryList.getCategoryList().forEach(category -> {
            List<Product> products = restTemplate.getForObject("http://localhost:8100/products/category/" + category.getId(), List.class);
            catalog.getCategories().add(new CatalogCategory(category.getId(), products));
        });
        return catalog;
    }
}
