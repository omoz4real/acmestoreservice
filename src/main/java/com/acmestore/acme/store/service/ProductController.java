/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acmestore.acme.store.service;

import java.util.Collection;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author omozegieaziegbe
 */
@RequestScoped
@Path("products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductController {

    @Inject
    private ProductRepository repository;

    ProductController() {
    }
    
    @Inject
    ProductController(ProductRepository repository) {
        this.repository = repository;
    }

    @GET
    public Collection<Product> getAll() {
        return repository.getAll();
    }

    @GET
    @Path("{productName}")
    public Product findById(@PathParam("productName") String productName) {
        return this.repository.findById(productName).orElseThrow(
                () -> new WebApplicationException("There is no item with the id " + productName, Response.Status.NOT_FOUND));
    }

    @POST
    public Response insert(Product product) {
        return Response.status(Response.Status.CREATED)
                .entity(repository.save(product))
                .build();
    }

    @PUT
    @Path("{productName}")
    public Response updateProduct(@PathParam("productName") String productName, Product product) {
        Product updateProduct = repository.findProductById(productName);

        updateProduct.setDescription(product.getDescription());
        updateProduct.setName(product.getName());
        updateProduct.setQuantity(product.getQuantity());
        repository.update(productName, product);

        return Response.ok().build();
    }
    

    @DELETE
    @Path("{productName}")
    public Response delete(@PathParam("productName") String productName) {
        this.repository.deleteById(productName);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
