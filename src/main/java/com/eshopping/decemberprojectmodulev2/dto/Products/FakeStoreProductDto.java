package com.eshopping.decemberprojectmodulev2.dto.Products;

import com.eshopping.decemberprojectmodulev2.models.Products.Category;
import com.eshopping.decemberprojectmodulev2.models.Products.Products;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FakeStoreProductDto {
    private Long id;
    private String title;
    private Double price;
    private String description;
    private String category;
    private String image;


    public Products getProducts(){
        Products product = new Products();
        product.setId(this.id);
        product.setTitle(this.title);
        product.setDescription(this.description);
        product.setImageUrl(this.image);
        product.setPrice(this.price);

        Category cat = new Category();
        cat.setName(this.category);
        product.setCategory(cat);

        return product;
    }




}

