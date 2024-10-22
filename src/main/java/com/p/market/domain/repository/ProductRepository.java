package com.p.market.domain.repository;

import com.p.market.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
//Solo nombre de los metodo que cualquier repositorio de productos debe implementar
   List<Product> getAll();
   Optional<List<Product>> getByCategory(int categoryId);
   List<Product> getScarseProducts(int quantity);
   Optional<Product> getProduct(int productId);

   Product save(Product product);

   void delete(int productId);


}
