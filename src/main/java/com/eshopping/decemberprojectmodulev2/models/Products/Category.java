package com.eshopping.decemberprojectmodulev2.models.Products;

import com.eshopping.decemberprojectmodulev2.models.BaseModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Category extends BaseModel {

    private String name;
    @JsonIgnore
    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Product> productsList;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    public Category(String name, List<Product> productsList) {
        this.name = name;
        this.productsList = productsList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<Product> productsList) {
        this.productsList = productsList;
    }
}
