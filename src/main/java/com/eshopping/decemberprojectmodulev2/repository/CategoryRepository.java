package com.eshopping.decemberprojectmodulev2.repository;

import com.eshopping.decemberprojectmodulev2.models.Products.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findByName(String name);
//    Category save(Category name);
}
