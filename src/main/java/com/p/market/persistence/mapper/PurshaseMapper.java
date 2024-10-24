package com.p.market.persistence.mapper;


import com.p.market.domain.Purchase;
import com.p.market.persistence.entity.Compra;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PurchaseItemMapper.class}) // Usamos PurchaseItemMapper class
public interface PurshaseMapper {
    @Mappings({
            @Mapping(source="idCompra", target="purchaseId"),
            @Mapping(source="idCliente", target="clientId"),
            @Mapping(source="fecha", target="date"),
            @Mapping(source="medioPago", target="paymentMethod"),
            @Mapping(source="comentario", target="comment"),
            @Mapping(source="estado", target="state"),
            @Mapping(source = "productos", target = "items")
    })
    Purchase toPurchase(Compra compra); //
    List<Purchase> toPurchases(List<Compra> compras); //Lista de compras

    @InheritInverseConfiguration
    @Mapping(target = "cliente", ignore = true)//Ignoramos el cliente en la compra
    Compra toCompra(Purchase purchase);

}
