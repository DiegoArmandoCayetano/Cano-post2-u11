package com.universidad.pedidosapi.model;

public class Pedido {

    private Long id;
    private Long clienteId;
    private String clienteNombre;
    private double total;

    public Pedido(Long clienteId, String clienteNombre, double total) {
        this.clienteId = clienteId;
        this.clienteNombre = clienteNombre;
        this.total = total;
    }

    public Long getId() {
        return 1L;
    }
}