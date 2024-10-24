package com.p.market.persistence;

import com.p.market.domain.Purchase;
import com.p.market.domain.repository.PurchaseRepository;
import com.p.market.persistence.crud.CompraCrudRepository;
import com.p.market.persistence.entity.Compra;
import com.p.market.persistence.mapper.PurshaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class CompraRepository implements PurchaseRepository { // Se implementa la interfaz PurshaseRepository

    @Autowired
    private CompraCrudRepository compraCrudRepository; // Se inyecta la interfaz CompraCrudRepository
    @Autowired
    private PurshaseMapper mapper; // Se crea un objeto de la clase PurshaceMapper
    @Override
    public List<Purchase> getAll() {
        return mapper.toPurchases((List<Compra>) compraCrudRepository.findAll());
    }

    @Override
    public Optional<List<Purchase>> getByClient(String clientId) {
        return compraCrudRepository.findByIdCliente(clientId)
                .map(compras -> mapper.toPurchases(compras));
    }

    @Override
    public Purchase save(Purchase purchase) {
        Compra compra= mapper.toCompra(purchase); //convirtiendo un objeto de dominio Purchase a un objeto de entidad Compra utilizando el PurshaseMapper.
        compra.getProductos().forEach(producto -> producto.setCompra(compra));
        return mapper.toPurchase(compraCrudRepository.save(compra));
    }
}
