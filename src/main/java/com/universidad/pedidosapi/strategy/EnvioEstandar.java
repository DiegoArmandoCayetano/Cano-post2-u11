package com.universidad.pedidosapi.strategy;

import com.universidad.pedidosapi.model.Pedido;
import org.springframework.stereotype.Component;

@Component("ESTANDAR")
public class EnvioEstandar
        implements EstrategiaEnvio {

    @Override
    public double calcularCosto(Pedido pedido) {

        return pedido.getTotal() > 50
                ? 0.0
                : 5.99;
    }
}