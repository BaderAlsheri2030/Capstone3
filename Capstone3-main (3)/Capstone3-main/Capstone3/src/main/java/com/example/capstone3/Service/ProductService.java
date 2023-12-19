package com.example.capstone3.Service;

import com.example.capstone3.ApiException.ApiException;
import com.example.capstone3.Model.Product;
import com.example.capstone3.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;


    public List<Product> getProducts(){
       return productRepository.findAll();
    }

    public void addProduct(Product product){
        productRepository.save(product);
    }


    public void updateProduct(Integer id, Product product){
        Product product1 = productRepository.findProductById(id);
        if (product1 == null){
            throw new ApiException("Invalid product id");
        }
        product1.setPrice(product.getPrice());
        product1.setProduct_name(product.getProduct_name());
        product1.setCategory(product.getCategory());
        productRepository.save(product1);
    }

    public void deleteProduct(Integer id){
        Product product = productRepository.findProductById(id);
        if (product == null){
            throw new ApiException("Invalid Product id");
        }
        productRepository.delete(product);
    }
}
