package com.keepcoding.catalog;

import java.util.List;

public class CatalogCategory {
    private Long id;
    private List<Product> productList;

    public CatalogCategory() {
    }

    public CatalogCategory(Long id, List<Product> productList) {
        this.id = id;
        this.productList = productList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
