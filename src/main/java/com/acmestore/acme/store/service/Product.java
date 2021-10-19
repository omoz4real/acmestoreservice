/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acmestore.acme.store.service;

import java.util.Objects;
import javax.json.bind.annotation.JsonbVisibility;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 *
 * @author omozegieaziegbe
 */
@JsonbVisibility(FieldPropertyVisibilityStrategy.class)
public class Product {

    @NotBlank
    @Size(min = 10, max = 100, message = "The description should be between 10 and 100 chars")
    private String name;

    @Size(min = 5, max = 100, message = "The description should be between 10 and 100 chars")
    private String description;

    @Min(1)
    private Integer quantity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void update(Product product, ProductRepository repository) {
        this.name = product.name;
        this.description = product.description;
        this.quantity = product.quantity;
        repository.save(product);
    }

    @Override
    public String toString() {
        return "Product{" + "name=" + name + ", description=" + description + ", quantity=" + quantity + '}';
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Product other = (Product) obj;
        if (this.quantity != other.quantity) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        return true;
    }

}
