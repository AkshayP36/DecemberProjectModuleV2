package com.eshopping.decemberprojectmodulev2.services.Products;

import com.eshopping.decemberprojectmodulev2.exceptions.Products.ProductNotFoundException;
import com.eshopping.decemberprojectmodulev2.models.Products.Product;

public interface ProductService {
    Product getSingleProduct(Long id) throws ProductNotFoundException;
    Product[] getAllProducts();
    Product createProduct(Long id, String title, String description, Double price, String imageUrl, String category);

    Product updateAProduct(Long id, String title, String description, Double price, String imageUrl, String category);

    Product deleteAProduct(Long id);
}
