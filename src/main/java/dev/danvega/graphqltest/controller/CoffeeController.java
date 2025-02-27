package dev.danvega.graphqltest.controller;

import dev.danvega.graphqltest.model.Coffee;
import dev.danvega.graphqltest.model.Product;
import dev.danvega.graphqltest.model.Size;
import dev.danvega.graphqltest.service.CoffeeService;
import dev.danvega.graphqltest.service.ProductService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class CoffeeController {

    private final CoffeeService coffeeService;
    private final ProductService productService;

    public CoffeeController(CoffeeService coffeeService, ProductService productService) {
        this.coffeeService = coffeeService;
        this.productService = productService;
    }

    @QueryMapping
    public List<Coffee> findAll() {
        return coffeeService.findAll();
    }

    @QueryMapping
    public List<Product> findAllProducts() {
        return productService.findAll();
    }

    @MutationMapping
    public Product createProduct(@Argument String productName) {
        return productService.createProduct(productName);
    }
    @QueryMapping
    public Optional<Coffee> findOne(@Argument Integer id) {
        return coffeeService.findOne(id);
    }

    @MutationMapping
    public Coffee create(@Argument String name, @Argument Size size) {
        return coffeeService.create(name,size);
    }

    @MutationMapping
    public Coffee update(@Argument Integer id, @Argument String name, @Argument Size size) {
        return coffeeService.update(id,name,size);
    }

    @MutationMapping
    public Coffee delete(@Argument Integer id) {
        return coffeeService.delete(id);
    }
}