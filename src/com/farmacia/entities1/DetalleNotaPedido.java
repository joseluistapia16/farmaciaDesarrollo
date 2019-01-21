/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmacia.entities1;

/**
 *
 * @author Usuario
 */
public class DetalleNotaPedido {

    private Long id_detalle_nota_pedidos;
    private Long id_precio;
    private Long id_cabecera_nota_pedidos;
    private int cantidad;
    private Double precio;
    private Double descuento;
    private Double iva;
    private Double total;

    public DetalleNotaPedido() {
    }

    public DetalleNotaPedido(Long id_detalle_nota_pedidos, Long id_precio, Long id_cabecera_nota_pedidos, int cantidad, Double precio, Double descuento, Double iva, Double total) {
        this.id_detalle_nota_pedidos = id_detalle_nota_pedidos;
        this.id_precio = id_precio;
        this.id_cabecera_nota_pedidos = id_cabecera_nota_pedidos;
        this.cantidad = cantidad;
        this.precio = precio;
        this.descuento = descuento;
        this.iva = iva;
        this.total = total;
    }

    public Long getId_detalle_nota_pedidos() {
        return id_detalle_nota_pedidos;
    }

    public void setId_detalle_nota_pedidos(Long id_detalle_nota_pedidos) {
        this.id_detalle_nota_pedidos = id_detalle_nota_pedidos;
    }

    public Long getId_precio() {
        return id_precio;
    }

    public void setId_precio(Long id_precio) {
        this.id_precio = id_precio;
    }

    public Long getId_cabecera_nota_pedidos() {
        return id_cabecera_nota_pedidos;
    }

    public void setId_cabecera_nota_pedidos(Long id_cabecera_nota_pedidos) {
        this.id_cabecera_nota_pedidos = id_cabecera_nota_pedidos;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public Double getIva() {
        return iva;
    }

    public void setIva(Double iva) {
        this.iva = iva;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
    
}
