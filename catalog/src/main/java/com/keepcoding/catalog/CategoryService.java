package com.keepcoding.catalog;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CategoryService {

    @Autowired
    private RestTemplate restTemplate;;

    @HystrixCommand(fallbackMethod = "getFallbackCategory",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000")
            }
    )
    public CategoryList getCategories() {
        return restTemplate.getForObject("http://category-service/categories", CategoryList.class);
    }

    private CategoryList getFallbackCategory() {
        return new CategoryList();
    }
}