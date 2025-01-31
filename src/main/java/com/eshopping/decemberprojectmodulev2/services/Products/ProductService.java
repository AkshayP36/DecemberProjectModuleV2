package com.eshopping.decemberprojectmodulev2.services.Products;

import com.eshopping.decemberprojectmodulev2.models.Products.Products;

public interface ProductService {
    Products getSingleProduct(Long id);
    Products[] getAllProducts();
    Products createProduct(Long id, String title, String description, Double price, String imageUrl, String category);

    Products updateAProduct(Long id, String title, String description, Double price, String imageUrl, String category);

    Products deleteAProduct(Long id);
}
