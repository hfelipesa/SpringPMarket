package com.p.market.web.controller;


import com.p.market.domain.Product;
import com.p.market.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//Controlador de productos
//Para indicar que es un controlador
//Se encarga de recibir las peticiones y enviar las respuestas
@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    //Metodos


    @GetMapping("/allProducts")
    public List<Product> getAll(){
        return productService.getAll();
    }
    public Product getProduct(int productId){
        return productService.getProduct(productId).get();//Obtenemos el producto
    }


    @PostMapping("/save")
    public Product save(@RequestBody Product product){
        return productService.save(product);
    }
    public boolean delete(int productId){
        return productService.delete(productId);
    }

}
