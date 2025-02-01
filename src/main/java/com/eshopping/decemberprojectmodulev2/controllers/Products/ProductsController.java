package com.eshopping.decemberprojectmodulev2.controllers.Products;

import com.eshopping.decemberprojectmodulev2.exceptions.Products.ProductNotFoundException;
import com.eshopping.decemberprojectmodulev2.models.Products.Product;
import com.eshopping.decemberprojectmodulev2.services.Products.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductsController {
    private ProductService productService;

    public ProductsController(@Qualifier("selfProductService") ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/products", method = RequestMethod.POST)
//    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product){
        Product response = productService.createProduct(product.getId(), product.getTitle(),
                product.getDescription(), product.getPrice(), product.getImageUrl(), product.getCategory().getName());
        return response;
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) throws ProductNotFoundException {
        Product products = productService.getSingleProduct(id);
        ResponseEntity<Product> response = new ResponseEntity<>(
                products, HttpStatus.OK
        );
        return response;
    }

    @GetMapping("/products")
    public Product[] getAllProducts(){
        Product[] productsList= productService.getAllProducts();
        return productsList;
    }


    @PutMapping("/products/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product){
        Product response = productService.updateAProduct(id, product.getTitle(), product.getDescription(), product.getPrice(), product.getImageUrl(),
                product.getCategory().getName());
        return response;
    }

    @DeleteMapping("/products/{id}")
    public Product deleteProductById(@PathVariable("id") long id){
        Product product = productService.deleteAProduct(id);
        return product;
    }
}
