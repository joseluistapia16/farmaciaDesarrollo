/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmacia.join_entidades;

import java.math.BigDecimal;
import java.sql.Date;

/**
 *
 * @author ineval
 */
public class JoinListarDetalleNotaPedido {
    private Long id_detalle_nota_pedido;
    private Long id_precio;
    private Long id_producto;
    private String producto;
    private Long id_marca;
    private String marca;
    private Long  id_tipo;
    private String tipo;
    private Long id_envase;
    private String envase;
    private Long id_medida;
    private String medida;
    private Long id_cabecera_nota_pedido;
    private Integer cantidad;
    private Integer bono;
    private BigDecimal precio;
    private BigDecimal descuento;
    private BigDecimal iva;
    private BigDecimal total;

    public JoinListarDetalleNotaPedido() {
    }

    public JoinListarDetalleNotaPedido(Long id_detalle_nota_pedido, Long id_precio, Long id_producto, String producto, Long id_marca, String marca, Long id_tipo, String tipo, Long id_envase, String envase, Long id_medida, String medida, Long id_cabecera_nota_pedido, Integer cantidad, Integer bono, BigDecimal precio, BigDecimal descuento, BigDecimal iva, BigDecimal total) {
        this.id_detalle_nota_pedido = id_detalle_nota_pedido;
        this.id_precio = id_precio;
        this.id_producto = id_producto;
        this.producto = producto;
        this.id_marca = id_marca;
        this.marca = marca;
        this.id_tipo = id_tipo;
        this.tipo = tipo;
        this.id_envase = id_envase;
        this.envase = envase;
        this.id_medida = id_medida;
        this.medida = medida;
        this.id_cabecera_nota_pedido = id_cabecera_nota_pedido;
        this.cantidad = cantidad;
        this.bono = bono;
        this.precio = precio;
        this.descuento = descuento;
        this.iva = iva;
        this.total = total;
    }

    public Long getId_detalle_nota_pedido() {
        return id_detalle_nota_pedido;
    }

    public void setId_detalle_nota_pedido(Long id_detalle_nota_pedido) {
        this.id_detalle_nota_pedido = id_detalle_nota_pedido;
    }

    public Long getId_precio() {
        return id_precio;
    }

    public void setId_precio(Long id_precio) {
        this.id_precio = id_precio;
    }

    public Long getId_producto() {
        return id_producto;
    }

    public void setId_producto(Long id_producto) {
        this.id_producto = id_producto;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public Long getId_marca() {
        return id_marca;
    }

    public void setId_marca(Long id_marca) {
        this.id_marca = id_marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Long getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(Long id_tipo) {
        this.id_tipo = id_tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Long getId_envase() {
        return id_envase;
    }

    public void setId_envase(Long id_envase) {
        this.id_envase = id_envase;
    }

    public String getEnvase() {
        return envase;
    }

    public void setEnvase(String envase) {
        this.envase = envase;
    }

    public Long getId_medida() {
        return id_medida;
    }

    public void setId_medida(Long id_medida) {
        this.id_medida = id_medida;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

    public Long getId_cabecera_nota_pedido() {
        return id_cabecera_nota_pedido;
    }

    public void setId_cabecera_nota_pedido(Long id_cabecera_nota_pedido) {
        this.id_cabecera_nota_pedido = id_cabecera_nota_pedido;
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

}
