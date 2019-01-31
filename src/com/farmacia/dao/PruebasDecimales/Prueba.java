/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmacia.dao.PruebasDecimales;

import com.farmacia.join_entidades.JoinListarDetalleNotaPedido;
import java.math.BigDecimal;

/**
 *
 * @author ineval
 */
public class Prueba {
    private  Integer cantidad;
    private  BigDecimal precio;
    private  BigDecimal decuento;
    private  BigDecimal iva;
    private  BigDecimal total;

    public Prueba() {
    }

    public Prueba(Integer cantidad, BigDecimal precio, BigDecimal decuento, BigDecimal iva, BigDecimal total) {
        this.cantidad = cantidad;
        this.precio = precio;
        this.decuento = decuento;
        this.iva = iva;
        this.total = total;
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

    public BigDecimal getDecuento() {
        return decuento;
    }

    public void setDecuento(BigDecimal decuento) {
        this.decuento = decuento;
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


    
}
