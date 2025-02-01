package com.eshopping.decemberprojectmodulev2.services.Products;

import com.eshopping.decemberprojectmodulev2.dto.Products.FakeStoreProductDto;
import com.eshopping.decemberprojectmodulev2.models.Products.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{
    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getSingleProduct(Long id) {
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject("https://fakestoreapi.com/products/"+id, FakeStoreProductDto.class);
        return fakeStoreProductDto.getProducts();
    }

    @Override
    public Product[] getAllProducts() {
        FakeStoreProductDto[] response = restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreProductDto[].class);

        // Check if the response is null to prevent NullPointerException
        if (response == null) {
            return new Product[0];  // Return an empty array if response is null
        }

        // Map the FakeStoreProductDto array to Products array
        Product[] products = new Product[response.length];
        for (int i = 0; i < response.length; i++) {
            products[i] = response[i].getProducts();  // Convert each FakeStoreProductDto to Products
        }

        return products;  // Return the mapped Products array
    }


    @Override
    public Product createProduct(Long id, String title, String description, Double price, String imageUrl, String category) {
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setId(id);
        fakeStoreProductDto.setTitle(title);
        fakeStoreProductDto.setDescription(description);
        fakeStoreProductDto.setPrice(price);
        fakeStoreProductDto.setImage(imageUrl);
        fakeStoreProductDto.setCategory(category);

        FakeStoreProductDto response = restTemplate.postForObject("https://fakestoreapi.com/products", fakeStoreProductDto ,FakeStoreProductDto.class);

        return response.getProducts();
    }

    @Override
    public Product updateAProduct(Long id, String title, String description, Double price, String imageUrl, String category) {
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setId(id);
        fakeStoreProductDto.setTitle(title);
        fakeStoreProductDto.setDescription(description);
        fakeStoreProductDto.setPrice(price);
        fakeStoreProductDto.setImage(imageUrl);
        fakeStoreProductDto.setCategory(category);
        restTemplate.put("https://fakestoreapi.com/products/"+id, fakeStoreProductDto, FakeStoreProductDto.class);
        FakeStoreProductDto response = restTemplate.getForObject("https://fakestoreapi.com/products/"+id, FakeStoreProductDto.class);

        return response.getProducts();
    }

    @Override
    public Product deleteAProduct(Long id) {
        String url = "https://fakestoreapi.com/products/"+id;
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject(url, FakeStoreProductDto.class);
        restTemplate.delete(url);
        return fakeStoreProductDto.getProducts();
    }


}
