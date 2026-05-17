package com.universidad.pedidosapi.service;

import com.universidad.pedidosapi.model.Pedido;
import com.universidad.pedidosapi.strategy.EnvioEstandar;
import com.universidad.pedidosapi.strategy.EnvioExpress;
import com.universidad.pedidosapi.strategy.EnvioMismoDia;
import com.universidad.pedidosapi.strategy.EstrategiaEnvio;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EnvioServiceTest {

    private final EnvioService service;

    public EnvioServiceTest() {

        Map<String, EstrategiaEnvio> estrategias =
                new HashMap<>();

        estrategias.put(
                "ESTANDAR",
                new EnvioEstandar());

        estrategias.put(
                "EXPRESS",
                new EnvioExpress());

        estrategias.put(
                "MISMO_DIA",
                new EnvioMismoDia());

        service =
                new EnvioService(estrategias);
    }

    @Test
    void calcularEnvio_estandar_conTotalAlto_debeSerGratis() {

        Pedido p = new Pedido(null, null, 0);

        p.setTotal(60.0);

        assertEquals(
                0.0,
                service.calcularEnvio(
                        p,
                        "ESTANDAR"
                ),
                0.001
        );
    }

    @Test
    void aprobarCredito_clienteNulo_debeRechazar() {

        assertEquals(
                "RECHAZADO",
                service.aprobarCredito(
                        null,
                        1000
                )
        );
    }
}