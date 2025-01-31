package com.eshopping.decemberprojectmodulev2.controllers.Products;

import com.eshopping.decemberprojectmodulev2.exceptions.Products.ProductNotFoundException;
import com.eshopping.decemberprojectmodulev2.models.Products.Products;
import com.eshopping.decemberprojectmodulev2.services.Products.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductsController {
    private ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/products", method = RequestMethod.POST)
//    @PostMapping("/products")
    public Products createProduct(@RequestBody Products product){
        Products response = productService.createProduct(product.getId(), product.getTitle(),
                product.getDescription(), product.getPrice(), product.getImageUrl(), product.getCategory().getName());
        return response;
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Products> getProductById(@PathVariable("id") Long id) throws ProductNotFoundException {
        Products products = productService.getSingleProduct(id);
        ResponseEntity<Products> response = new ResponseEntity<>(
                products, HttpStatus.OK
        );
        return response;
    }

    @GetMapping("/products")
    public Products[] getAllProducts(){
        Products[] productsList= productService.getAllProducts();
        return productsList;
    }


    @PutMapping("/products/{id}")
    public Products updateProduct(@PathVariable("id") Long id, @RequestBody Products product){
        Products response = productService.updateAProduct(id, product.getTitle(), product.getDescription(), product.getPrice(), product.getImageUrl(),
                product.getCategory().getName());
        return response;
    }

    @DeleteMapping("/products/{id}")
    public Products deleteProductById(@PathVariable("id") long id){
        Products product = productService.deleteAProduct(id);
        return product;
    }
}
