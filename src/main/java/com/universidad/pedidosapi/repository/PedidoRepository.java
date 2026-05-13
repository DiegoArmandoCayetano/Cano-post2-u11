package com.universidad.pedidosapi.repository;

import org.springframework.stereotype.Repository;

import com.universidad.pedidosapi.model.Pedido;
import com.universidad.pedidosapi.model.Producto;

@Repository
public class PedidoRepository {

    public Producto findProductoById(Long id) {

        return new Producto(id, 100);
    }

    public Pedido save(Pedido pedido) {

        return pedido;
    }
}