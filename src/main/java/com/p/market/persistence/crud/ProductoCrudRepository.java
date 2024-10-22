package com.p.market.persistence.crud;


import com.p.market.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

//Implementado CrudRespository para poder realizar operaciones CRUD
//Pasamos la entidad Producto y el tipo de dato de la llave primaria de la entidad
//En este caso la llave primaria es de tipo Integer

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {

    //Query Methods
    //Se pueden realizar consultas personalizadas

    //Obtener productos por categoria
    List<Producto> findByidCategoria(int idCategoria);

    //obtener productos por cantidad de stock y estado
    List<Producto> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);

    //Obtener productos por cantidad de stock y ordenarlos de forma descendente
    List<Producto> findTopByOrderByCantidadStockDesc(int cantidadStock);
}
