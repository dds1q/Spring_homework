package com.sparta.springcore.service;

import com.sparta.springcore.model.Product;
import com.sparta.springcore.dto.ProductMypriceRequestDto;
import com.sparta.springcore.repository.ProductRepository;
import com.sparta.springcore.dto.ProductRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService( ProductRepository productRepository ){
        this.productRepository = productRepository;
    }

    public Product createProduct(ProductRequestDto requestDto) {

        Product product = new Product( requestDto );
        productRepository.save( product );

        return product;
    }

    public Product updateProduct(Long id, ProductMypriceRequestDto requestDto){

        Product product = productRepository.findById( id )
                .orElseThrow(() -> new NullPointerException("해당 아이디 존재안함"));


        product.setMyprice( requestDto.getMyprice()  );

        productRepository.save( product );
        return product;
    }

    public List<Product> getProducts() {
        List<Product> products = productRepository.findAll();
        return products;
    }
}
