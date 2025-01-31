package com.eshopping.decemberprojectmodulev2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository<Product> extends JpaRepository<Product, Long> {

    //get
    Product findByTitle(String title);

    //get all

    //create
//    Product save(Product product);

    //update

    //delete
}
