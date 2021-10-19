/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acmestore.acme.store.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author omozegieaziegbe
 */
@ApplicationScoped
public class ProductRepositoryMemory implements ProductRepository {

    private static final Logger LOGGER = Logger.getLogger(ProductRepositoryMemory.class.getName());

    private Map<String, Product> data;

    public ProductRepositoryMemory() {
        this.data = new HashMap<>();
    }

    @Override
    public Collection<Product> getAll() {
        return data.values();
    }

    @Override
    public Product save(Product product) {
        if(product==null){
        throw new RuntimeException("Product cannot be null");
        }
        this.data.put(product.getName(), product);
        LOGGER.info("The Product was updated: " + product);
        return product;

    }

    @Override
    public Product update(String productName, Product newProduct){
    this.data.put(productName, newProduct);
    return newProduct;
    }
    
//    @Override
//    public void updateProduct(Product product){
//    
//    }
//    
    @Override
    public Product findProductById(String id){
        this.data.get(id);
        return new Product();
    }
    
    @Override
    public Optional<Product> findById(String id) {
        LOGGER.info("Finding the Product by id: " + id);
        return Optional.ofNullable(data.get(id));
    }

    @Override
    public void deleteById(String id) {
        this.data.remove(id);
    }
}
