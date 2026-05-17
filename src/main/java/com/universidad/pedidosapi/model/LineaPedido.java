package com.universidad.pedidosapi.model;

public class LineaPedido {

    private double precioUnitario;
    private int cantidad;

    public LineaPedido(double precioUnitario, int cantidad) {
        this.precioUnitario = precioUnitario;
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public int getCantidad() {
        return cantidad;
    }
}