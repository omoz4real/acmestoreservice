/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acmestore.acme.store.service;

import java.util.Collection;
import java.util.Optional;

/**
 *
 * @author omozegieaziegbe
 */
public interface ProductRepository {
    
    Collection<Product> getAll();

    Product save(Product product);

    Optional<Product> findById(String id);
    
    Product findProductById(String id);
 
//    void updateProduct(Product product);

    void deleteById(String id);
    
    Product update(String productName, Product product);
}
