package com.eshopping.decemberprojectmodulev2.repository;

import com.eshopping.decemberprojectmodulev2.models.Products.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {


}
