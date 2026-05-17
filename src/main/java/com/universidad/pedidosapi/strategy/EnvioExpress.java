package com.universidad.pedidosapi.strategy;

import com.universidad.pedidosapi.model.Pedido;
import org.springframework.stereotype.Component;

@Component("EXPRESS")
public class EnvioExpress
        implements EstrategiaEnvio {

    @Override
    public double calcularCosto(Pedido pedido) {

        return 12.99;
    }
}