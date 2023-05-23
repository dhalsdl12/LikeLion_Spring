package com.rest.RestApi.controller;

import com.rest.RestApi.domain.Product;
import com.rest.RestApi.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin("*") // *을 하면 모든것을 풀어주겠다.
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    @PostMapping("/products/create")
    public ResponseEntity<Product> create(@RequestBody Product product){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(productService.save(product));
    }
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> read(@PathVariable("id") Long id){
        return ResponseEntity
                //.status(HttpStatus.OK)
                .ok(productService.findById(id));
    }
    @PostMapping("/products/{id}")
    public ResponseEntity<Product> update(@PathVariable("id") Long id, @RequestBody Product product){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(productService.update(id, product));
    }
    @DeleteMapping("/products/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id){
        productService.delete(id);
        ResponseEntity.noContent();

        return null;
    }
}
