/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmacia.entities1;

/**
 *
 * @author jorge
 */
public class ListarDetalleVentas {

    private String producto;
    private String detalle;
    private int cantidad;
    private Double pvp;
    private Double descuento;
    private String iva;
    private Double subtotal;

    public ListarDetalleVentas() {
    }

    public ListarDetalleVentas(String producto, String detalle, int cantidad, Double pvp, Double descuento, String iva, Double subtotal) {
        this.producto = producto;
        this.detalle = detalle;
        this.cantidad = cantidad;
        this.pvp = pvp;
        this.descuento = descuento;
        this.iva = iva;
        this.subtotal = subtotal;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPvp() {
        return pvp;
    }

    public void setPvp(Double pvp) {
        this.pvp = pvp;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public String getIva() {
        return iva;
    }

    public void setIva(String iva) {
        this.iva = iva;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

}
