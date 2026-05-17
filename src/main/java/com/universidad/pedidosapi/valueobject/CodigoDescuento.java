package com.universidad.pedidosapi.valueobject;

public class CodigoDescuento {

    private final double porcentaje;

    public CodigoDescuento(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public double getPorcentaje() {
        return porcentaje;
    }
}