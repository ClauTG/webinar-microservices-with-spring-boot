package com.keepcoding.catalog;

import java.util.List;

public class Catalog {
    private int categoriesPort;
    private List<Category> categoriesData;
    private List<CatalogCategory> categories;

    public Catalog() {
    }

    public Catalog(List<Category> categoriesData, List<CatalogCategory> categories) {
        this.categoriesData = categoriesData;
        this.categories = categories;
    }

    public List<Category> getCategoriesData() {
        return categoriesData;
    }

    public void setCategoriesData(List<Category> categoriesData) {
        this.categoriesData = categoriesData;
    }

    public List<CatalogCategory> getCategories() {
        return categories;
    }

    public void setCategories(List<CatalogCategory> categories) {
        this.categories = categories;
    }

    public int getCategoriesPort() {
        return categoriesPort;
    }

    public void setCategoriesPort(int categoriesPort) {
        this.categoriesPort = categoriesPort;
    }
}
