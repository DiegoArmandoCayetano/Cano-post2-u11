package com.universidad.pedidosapi.service;

import com.universidad.pedidosapi.model.LineaPedido;
import com.universidad.pedidosapi.model.Pedido;
import com.universidad.pedidosapi.repository.PedidoRepository;
import com.universidad.pedidosapi.valueobject.CodigoDescuento;
import com.universidad.pedidosapi.valueobject.DatosCliente;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class PedidoService {

    private final PedidoRepository repo;
    private final NotificacionService notificacion;

    public PedidoService(
            PedidoRepository repo,
            NotificacionService notificacion) {

        this.repo = repo;
        this.notificacion = notificacion;
    }

    public String procesarPedido(
            DatosCliente cliente,
            LineaPedido[] lineas,
            String metodoPago,
            boolean esUrgente,
            CodigoDescuento descuento) {

        double total = calcularTotal(lineas);

        double totalConDescuento =
                aplicarDescuento(total, descuento);

        notificacion.notificarPedido(cliente, esUrgente);

        return persistirPedido(cliente, totalConDescuento);
    }

    private double calcularTotal(LineaPedido[] lineas) {

        return Arrays.stream(lineas)
                .mapToDouble(
                        l -> l.getPrecioUnitario()
                                * l.getCantidad())
                .sum();
    }

    private double aplicarDescuento(
            double total,
            CodigoDescuento descuento) {

        return descuento != null
                ? total * (1 - descuento.getPorcentaje())
                : total;
    }

    private String persistirPedido(
            DatosCliente cliente,
            double total) {

        Pedido pedido =
                new Pedido(
                        1L,
                        cliente.getNombre(),
                        total);

        return "OK_" + repo.save(pedido).getId();
    }
}