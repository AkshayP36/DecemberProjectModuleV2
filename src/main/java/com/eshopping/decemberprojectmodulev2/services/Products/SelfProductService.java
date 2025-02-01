package com.eshopping.decemberprojectmodulev2.services.Products;

import com.eshopping.decemberprojectmodulev2.exceptions.Products.ProductNotFoundException;
import com.eshopping.decemberprojectmodulev2.models.Products.Category;
import com.eshopping.decemberprojectmodulev2.models.Products.Product;
import com.eshopping.decemberprojectmodulev2.repository.Products.CategoryRepository;
import com.eshopping.decemberprojectmodulev2.repository.Products.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service("selfProductService")
public class SelfProductService implements ProductService {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository; // Corrected typo

    public SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository; // Corrected typo
    }

    @Override
    public Product getSingleProduct(Long id) throws ProductNotFoundException {
        Optional<Product> response = productRepository.findById(id);
        if(response.isPresent()) return response.get();
        throw new ProductNotFoundException("Product not found in DB");
    }

    @Override
    public Product[] getAllProducts(){
        List<Product> productList =  productRepository.findAll();
        Product[] result = new Product[productList.size()];
        for(int i=0;i<productList.size();i++){
            result[i] = productList.get(i);
        }
        return result;
    }

    @Override
    public Product createProduct(Long id, String title, String description, Double price, String imageUrl, String categoryTitle) {
        Product p = new Product();
        Optional<Category> currentCat = categoryRepository.findByName(categoryTitle);
        if(currentCat.isEmpty()) {
            Category newCat = new Category();
            newCat.setName(categoryTitle);
            Category newRow = categoryRepository.save(newCat);
            p.setCategory(newRow);
        } else {
            Category currentCategory = currentCat.get();
            p.setCategory(currentCategory);
        }
        p.setTitle(title);
        p.setDescription(description);
        p.setImageUrl(imageUrl);
        p.setPrice(price);
        p.setCreatedAt(new Date());
        p.setUpdatedAt(new Date());
        p.setDeleted(false);
        return productRepository.save(p);

    }

    @Override
    public Product updateAProduct(Long id, String title, String description, Double price, String imageUrl, String categoryName) {
        Optional<Product> existingProduct = productRepository.findById(id);

        if (existingProduct.isPresent()) {
            Product product = existingProduct.get();
            product.setTitle(title);
            product.setDescription(description);
            product.setPrice(price);
            product.setImageUrl(imageUrl);

            Category category = findOrCreateCategory(categoryName); // Reuse helper method
            product.setCategory(category);

            return productRepository.save(product);
        }
        return null;
    }

    @Override
    public Product deleteAProduct(Long id){
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            productRepository.delete(product.get());
            return product.get();
        }
        return null;
    }


    // Helper method to find or create a category
    private Category findOrCreateCategory(String categoryName) {
        Optional<Category> existingCategory = categoryRepository.findByName(categoryName);
        return existingCategory.orElseGet(() -> {
            Category newCategory = new Category();
            newCategory.setName(categoryName);
            return categoryRepository.save(newCategory);
        });
    }
}