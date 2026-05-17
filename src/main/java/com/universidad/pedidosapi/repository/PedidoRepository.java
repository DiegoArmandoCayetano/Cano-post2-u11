package com.universidad.pedidosapi.repository;

import com.universidad.pedidosapi.model.Pedido;
import com.universidad.pedidosapi.model.Producto;
import org.springframework.stereotype.Repository;

@Repository
public class PedidoRepository {

    public Producto findProductoById(Long id) {

        return new Producto(id, 100);
    }

    public Pedido save(Pedido pedido) {

        return pedido;
    }
}