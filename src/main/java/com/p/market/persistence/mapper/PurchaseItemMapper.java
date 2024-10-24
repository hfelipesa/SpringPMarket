package com.p.market.persistence.mapper;


import com.p.market.domain.PurchaseItem;
import com.p.market.persistence.entity.ComprasProducto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {ProductMapper.class}) //Usar ProductMapper
public interface PurchaseItemMapper {
    @Mappings({
            @Mapping(source = "id.idProducto", target = "productId"), //Mapear el idProducto de ComprasProducto a productId de PurchaseItem clave compuesta
            @Mapping(source = "cantidad", target = "quantity"),
            @Mapping(source = "estado", target = "active")
            //No es necesario mapear el total porque se llama igual en ambas clases
    })
    PurchaseItem toPurchaseItem(ComprasProducto producto); //convertir de ComprasProducto a PurchaseItem

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "compra", ignore=true), //Ignorar la compra porque no se necesita
            @Mapping(target = "producto", ignore=true), //Ignorar el producto porque no se necesita
            @Mapping(target = "id.idCompra", ignore=true) //Ignorar el idCompra porque no se necesita de la clave compuesta
    })
    ComprasProducto toComprasProducto(PurchaseItem item); //convertir de PurchaseItem a ComprasProducto
}
