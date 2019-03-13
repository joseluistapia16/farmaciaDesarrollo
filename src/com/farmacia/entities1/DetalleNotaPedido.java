/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmacia.entities1;

import java.math.BigDecimal;

/**
 *
 * @author Usuario
 */
public class DetalleNotaPedido {

    private Long id_detalle_nota_pedidos;
    private Long id_precio;
    private Long id_cabecera_nota_pedidos;
    private Integer cantidad;
    private Integer bono;
    private BigDecimal precio;
    private BigDecimal descuento;
    private BigDecimal iva;
    private BigDecimal total;
    private Integer cantAnt;
    private Integer idCompra;
    

    public DetalleNotaPedido() {
    }

    public DetalleNotaPedido(Long id_detalle_nota_pedidos, Long id_precio, Long id_cabecera_nota_pedidos, Integer cantidad, Integer bono, BigDecimal precio, BigDecimal descuento, BigDecimal iva, BigDecimal total, Integer cantAnt, Integer idCompra) {
        this.id_detalle_nota_pedidos = id_detalle_nota_pedidos;
        this.id_precio = id_precio;
        this.id_cabecera_nota_pedidos = id_cabecera_nota_pedidos;
        this.cantidad = cantidad;
        this.bono = bono;
        this.precio = precio;
        this.descuento = descuento;
        this.iva = iva;
        this.total = total;
        this.cantAnt = cantAnt;
        this.idCompra = idCompra;
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

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getBono() {
        return bono;
    }

    public void setBono(Integer bono) {
        this.bono = bono;
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

    public Integer getCantAnt() {
        return cantAnt;
    }

    public void setCantAnt(Integer cantAnt) {
        this.cantAnt = cantAnt;
    }

    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    
}
