package com.p.market.persistence.mapper;

import com.p.market.domain.Category;
import com.p.market.persistence.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

//Mapper de categoria
//Se encarga de mapear la categoria
//convertir de una categoria a otra

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    //Categoria a Category
    @Mappings({
            @Mapping(source="idCategoria", target="categoryId"),
            @Mapping(source="descripcion", target="category"),
            @Mapping(source="estado", target="active"),
    })
     Category ToCategory(Categoria categoria);
    //Category a Categoria
    @InheritInverseConfiguration
    @Mapping(target = "productos", ignore = true) //Ignorar la lista de productos
    Categoria toCategoria(Category category);


}
