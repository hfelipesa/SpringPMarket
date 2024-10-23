package com.p.market.domain.service;

import com.p.market.domain.Product;
import com.p.market.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //Para indicar que es un servicio
public class ProductService {
    @Autowired
    private ProductRepository productRepository; //inyectar el repositorio productRepository
    public List<Product> getAll(){
        return productRepository.getAll();
    }

    public Optional <Product> getProduct(int productId){
        return productRepository.getProduct(productId);
    }

    public Optional<List<Product>>  getByCategory(int categoryId){
        return productRepository.getByCategory(categoryId);
    }

    public Product save(Product product){
        return productRepository.save(product);
    }

    public boolean delete(int productId){
        if (getProduct(productId).isPresent()){
            productRepository.delete(productId);
            return true;
        }else{
            return false;
        }
    }


}
