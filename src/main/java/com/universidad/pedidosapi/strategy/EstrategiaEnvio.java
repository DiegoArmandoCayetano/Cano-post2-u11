package com.universidad.pedidosapi.strategy;

import com.universidad.pedidosapi.model.Pedido;

public interface EstrategiaEnvio {

    double calcularCosto(Pedido pedido);
}