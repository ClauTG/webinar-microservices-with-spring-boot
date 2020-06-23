package com.keepcoding.product;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController()
public class ProductController {

    @GetMapping("/products")
    public ProductList getAllProducts() {
        return productMockedList();
    }

    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable Long id) {
        return productMockedList()
                .getProductList()
                .stream()
                .filter(product -> product.getId() == id)
                .findFirst()
                .get();
    }

    @GetMapping("products/category/{categoryId}")
    public List<Product> getProductsByCategory(@PathVariable Long categoryId) {
        return productMockedList()
                .getProductList()
                .stream()
                .filter(product -> product.getCategory() == categoryId)
                .collect(Collectors.toList());
    }


    private ProductList productMockedList() {
        var result = new ProductList();
        result.setProductList(Arrays.asList(
                new Product(1L, "pantalones", "pantalones vaqueros", BigDecimal.valueOf(100L), 1L),
                new Product(2L, "camiseta", "camiseta wapa", BigDecimal.valueOf(30L), 1L),
                new Product(3L, "pollo", "filetes de pollo", BigDecimal.valueOf(10L), 2L),
                new Product(4L, "leche", "leche de vaca", BigDecimal.valueOf(1L), 2L)));
        return result;
    }

}
