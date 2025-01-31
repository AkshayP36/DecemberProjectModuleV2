package com.eshopping.decemberprojectmodulev2.services.Products;

import com.eshopping.decemberprojectmodulev2.dto.Products.FakeStoreProductDto;
import com.eshopping.decemberprojectmodulev2.models.Products.Products;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{


    @Override
    public Products getSingleProduct(Long id) {
        return null;
    }

    @Override
    public Products[] getAllProducts() {
        return new Products[0];
    }

    @Override
    public Products createProduct(Long id, String title, String description, Double price, String imageUrl, String category) {
        return null;
    }

    @Override
    public Products updateAProduct(Long id, String title, String description, Double price, String imageUrl, String category) {
        return null;
    }

    @Override
    public Products deleteAProduct(Long id) {
        return null;
    }
}
