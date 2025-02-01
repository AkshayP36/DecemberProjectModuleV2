package com.eshopping.decemberprojectmodulev2.repository;

import com.eshopping.decemberprojectmodulev2.models.Products.Product;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ProductRepository extends JpaRepository<Product, Long> {

    // Find by title
    Product findByTitle(String title);

    // Find by description
    Product findByDescription(String description);

    // Find by ID (already provided by JpaRepository)
    // Optional<Products> findById(Long id);  No need to redefine this

    // Find all (already provided by JpaRepository)
    // List<Products> findAll(); No need to redefine this

    // Find all (incorrectly named in original code)
    // Products[] findAllById();  This is not a standard JPA method. Use findAll()

    // Create (already provided by JpaRepository)
    // Products save(Products product); No need to redefine this

    // Update (handled by save() method of JpaRepository)
    // No need to define a separate update method

    // Delete (already provided by JpaRepository)
    // No need to define a separate delete method
}
