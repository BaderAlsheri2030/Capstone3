package com.example.capstone3.Service;

import com.example.capstone3.ApiException.ApiException;
import com.example.capstone3.DTO.ProductDetailsDTO;
import com.example.capstone3.Model.Product;
import com.example.capstone3.Model.ProductDetails;
import com.example.capstone3.Repository.ProductDetailsRepository;
import com.example.capstone3.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductDetailsService {

    private final ProductDetailsRepository productDetailsRepository;
    private final ProductRepository productRepository;

    public List<ProductDetails> get(){
        return productDetailsRepository.findAll();
    }

    public void addProductDetails(ProductDetailsDTO productDetailsDTO){
        Product product = productRepository.findProductById(productDetailsDTO.getProduct_id());
        if (product == null){
            throw new ApiException("Invalid Product id");
        }

        ProductDetails productDetails = new ProductDetails(null,product,null,productDetailsDTO.getQuantity());
        productDetailsRepository.save(productDetails);
    }

    public void updateProductDetails(Integer id, ProductDetailsDTO productDetailsDTO){
        ProductDetails productDetails = productDetailsRepository.findProductDetailsById(id);
        Product product = productRepository.findProductById(productDetailsDTO.getProduct_id());

        if (productDetails == null){
            throw new ApiException("Invalid product details id");
        }
        productDetails.setProduct(product);
        productDetails.setQuantity(productDetailsDTO.getQuantity());

        productDetailsRepository.save(productDetails);
    }

    public void deleteProductDetails(Integer id){
        ProductDetails productDetails = productDetailsRepository.findProductDetailsById(id);
        if (productDetails == null){
            throw new ApiException("Invalid product details id");
        }
    }
}
