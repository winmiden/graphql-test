package dev.danvega.graphqltest.service;

import dev.danvega.graphqltest.model.Product;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.sound.sampled.Port;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class ProductService {
    AtomicInteger id = new AtomicInteger(0);

    List<Product> productsDb = new ArrayList<>();


    public List<Product> findAll() {
        return productsDb;
    }

    public Product createProduct(String productName) {
        Product product = new Product(id.incrementAndGet(), productName);
        productsDb.add(product);

        return product;
    }

    @PostConstruct
    public void initProductsDb() {
        productsDb.add(new Product(id.incrementAndGet(), "Software"));
        productsDb.add(new Product(id.incrementAndGet(), "Hardware"));
    }
}
