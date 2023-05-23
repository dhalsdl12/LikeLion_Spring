package com.rest.RestApi.service;

import com.rest.RestApi.domain.Product;
import com.rest.RestApi.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    public Product save(Product product){
        return productRepository.save(
                new Product(
                        product.getProductName(),
                        product.getPrice())
        );
    }
    public Product findById(Long id){
        return productRepository.findById(id).get();
    }
    public Product update(Long id, Product product){
        Product productData = productRepository.findById(id).get();
        productData.setProductName(product.getProductName());
        productData.setPrice(product.getPrice());
        Product _product = productData;

        return productRepository.save(_product);
    }
    public void delete(Long id){
        productRepository.deleteById(id);
    }
}