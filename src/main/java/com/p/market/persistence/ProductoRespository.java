package com.p.market.persistence;

import com.p.market.domain.Product;
import com.p.market.domain.repository.ProductRepository;
import com.p.market.persistence.crud.ProductoCrudRepository;
import com.p.market.persistence.entity.Producto;
import com.p.market.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//Clase que se encarga de realizar las consultas a la base de datos
// implementa la interfaz ProductRepository domain
@Repository
public class ProductoRespository implements ProductRepository {

    @Autowired //Inyeccion de dependencias
    private ProductoCrudRepository productoCrudRespository; //Inyeccion de prodictoCrudRepository

    @Autowired //Inyeccion de dependencias
    private ProductMapper mapper; //Inyeccion Mapeo de productos

    //Metodos que se pueden realizar con la base de datos
    @Override
    public List<Product> getAll(){
        List<Producto> productos= (List<Producto>) productoCrudRespository.findAll();
        return mapper.toProducts(productos);//Convertimos la lista de productos a una lista de productos
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto> productos= productoCrudRespository.findByidCategoria(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product> > getScarseProducts(int quantity) {
        Optional<List<Producto>> productos = productoCrudRespository.findByCantidadStockLessThanAndEstado(quantity,true);
        return productos.map(prods -> mapper.toProducts(prods));
    }
    @Override
    public Optional<Product> getProduct(int productId) {
        return productoCrudRespository.findById(productId).map(producto -> mapper.toProduct(producto));
    }

    @Override
    public Product save(Product product) {
        Producto producto = mapper.toProducto(product); //Convertimos el producto a un producto
        return mapper.toProduct(productoCrudRespository.save(producto));//Guardamos el producto y lo convertimos a un producto
    }

    @Override
    public void delete(int productId) {
        productoCrudRespository.deleteById(productId);
    }


}
