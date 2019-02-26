/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmacia.entities1;

import java.math.BigDecimal;

/**
 *
 * @author User
 */
public class Detalle_compra {
    private Long id_detalle_compra;
    private Long id_cabecera_compra;
    private Long id_precio;
    private Integer cantidad;
    private BigDecimal precio;
    private BigDecimal descuento;
    private BigDecimal iva;
    private BigDecimal total;
    private Integer bono;

    public Detalle_compra() {
    }

    public Detalle_compra(Long id_detalle_compra, Long id_cabecera_compra, Long id_precio, Integer cantidad, BigDecimal precio, BigDecimal descuento, BigDecimal iva, BigDecimal total, Integer bono) {
        this.id_detalle_compra = id_detalle_compra;
        this.id_cabecera_compra = id_cabecera_compra;
        this.id_precio = id_precio;
        this.cantidad = cantidad;
        this.precio = precio;
        this.descuento = descuento;
        this.iva = iva;
        this.total = total;
        this.bono = bono;
    }

    public Long getId_detalle_compra() {
        return id_detalle_compra;
    }

    public void setId_detalle_compra(Long id_detalle_compra) {
        this.id_detalle_compra = id_detalle_compra;
    }

    public Long getId_cabecera_compra() {
        return id_cabecera_compra;
    }

    public void setId_cabecera_compra(Long id_cabecera_compra) {
        this.id_cabecera_compra = id_cabecera_compra;
    }

    public Long getId_precio() {
        return id_precio;
    }

    public void setId_precio(Long id_precio) {
        this.id_precio = id_precio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public BigDecimal getDescuento() {
        return descuento;
    }

    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
    }

    public BigDecimal getIva() {
        return iva;
    }

    public void setIva(BigDecimal iva) {
        this.iva = iva;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Integer getBono() {
        return bono;
    }

    public void setBono(Integer bono) {
        this.bono = bono;
    }
    
    
}
