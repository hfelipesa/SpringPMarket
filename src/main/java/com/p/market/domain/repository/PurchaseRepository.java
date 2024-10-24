package com.p.market.domain.repository;

import com.p.market.domain.Purchase;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {
    List<Purchase> getAll(); //Obtener todos los registros
    Optional<List<Purchase>> getByClient(String clientId); //Obtener registros por cliente
    Purchase save(Purchase purchase); //Guardar un registro

}
