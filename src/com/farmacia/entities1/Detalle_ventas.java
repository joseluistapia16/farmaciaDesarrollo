/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmacia.entities1;

import java.math.BigDecimal;

/**
 *
 * @author alumno
 */
public class Detalle_ventas {

    private Long id_detalle_venta;
    private Long id_cabecera_venta;
    private Long id_control;
    private Long id_producto;
    private String nombre_producto;
    private Long cantidad;
    private BigDecimal precio;
    private BigDecimal precio_compra;
    private BigDecimal subtotal;
    private BigDecimal iva;
    private BigDecimal descuento;
    private BigDecimal total;
    
    

    public Detalle_ventas() {
    }

    public Detalle_ventas(Long id_detalle_venta, Long id_cabecera_venta, Long id_control, Long id_producto, String nombre_producto, Long cantidad, BigDecimal precio, BigDecimal precio_compra, BigDecimal subtotal, BigDecimal iva, BigDecimal descuento, BigDecimal total) {
        this.id_detalle_venta = id_detalle_venta;
        this.id_cabecera_venta = id_cabecera_venta;
        this.id_control = id_control;
        this.id_producto = id_producto;
        this.nombre_producto = nombre_producto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.precio_compra = precio_compra;
        this.subtotal = subtotal;
        this.iva = iva;
        this.descuento = descuento;
        this.total = total;
    }

    public Long getId_detalle_venta() {
        return id_detalle_venta;
    }

    public void setId_detalle_venta(Long id_detalle_venta) {
        this.id_detalle_venta = id_detalle_venta;
    }

    public Long getId_cabecera_venta() {
        return id_cabecera_venta;
    }

    public void setId_cabecera_venta(Long id_cabecera_venta) {
        this.id_cabecera_venta = id_cabecera_venta;
    }

    public Long getId_control() {
        return id_control;
    }

    public void setId_control(Long id_control) {
        this.id_control = id_control;
    }

    public Long getId_producto() {
        return id_producto;
    }

    public void setId_producto(Long id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public BigDecimal getPrecio_compra() {
        return precio_compra;
    }

    public void setPrecio_compra(BigDecimal precio_compra) {
        this.precio_compra = precio_compra;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getIva() {
        return iva;
    }

    public void setIva(BigDecimal iva) {
        this.iva = iva;
    }

    public BigDecimal getDescuento() {
        return descuento;
    }

    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    

    

    

    
}
