package com.universidad.pedidosapi.strategy;

import com.universidad.pedidosapi.model.Pedido;
import org.springframework.stereotype.Component;

@Component("MISMO_DIA")
public class EnvioMismoDia
        implements EstrategiaEnvio {

    @Override
    public double calcularCosto(Pedido pedido) {

        return 24.99;
    }
}