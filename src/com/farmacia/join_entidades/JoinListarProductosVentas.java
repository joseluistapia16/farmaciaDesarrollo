/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmacia.join_entidades;

import java.math.BigDecimal;

/**
 *
 * @author JorgeMV
 */
public class JoinListarProductosVentas {

    private Long id_control;
    private Long id_producto;
    private String producto_nombre;
    private String producto_descripcion;
    private Long id_tipo;
    private String tipo_nombre;
    private Long id_medida;
    private String medida_nombre;
    private Long id_envase;
    private String envase_nombre;
    private Long id_marca;
    private String marca_nombre;
    private Long id_stock;
    private Long stock;
    private Long id_precio;
    private BigDecimal precio_venta;
    private Long id_descuento;
    private BigDecimal descuento_venta;
    private Long descuento;
    private String iva;
    private BigDecimal precio_compra;
    private BigDecimal descuento_compra;
    private String estado;
    
    
    
    public JoinListarProductosVentas(){
        
    }

    public JoinListarProductosVentas(Long id_control, Long id_producto, String producto_nombre, String producto_descripcion, Long id_tipo, String tipo_nombre, Long id_medida, String medida_nombre, Long id_envase, String envase_nombre, Long id_marca, String marca_nombre, Long id_stock, Long stock, Long id_precio, BigDecimal precio_venta, Long id_descuento, BigDecimal descuento_venta, Long descuento, String iva, BigDecimal precio_compra, BigDecimal descuento_compra, String estado) {
        this.id_control = id_control;
        this.id_producto = id_producto;
        this.producto_nombre = producto_nombre;
        this.producto_descripcion = producto_descripcion;
        this.id_tipo = id_tipo;
        this.tipo_nombre = tipo_nombre;
        this.id_medida = id_medida;
        this.medida_nombre = medida_nombre;
        this.id_envase = id_envase;
        this.envase_nombre = envase_nombre;
        this.id_marca = id_marca;
        this.marca_nombre = marca_nombre;
        this.id_stock = id_stock;
        this.stock = stock;
        this.id_precio = id_precio;
        this.precio_venta = precio_venta;
        this.id_descuento = id_descuento;
        this.descuento_venta = descuento_venta;
        this.descuento = descuento;
        this.iva = iva;
        this.precio_compra = precio_compra;
        this.descuento_compra = descuento_compra;
        this.estado = estado;
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

    public String getProducto_nombre() {
        return producto_nombre;
    }

    public void setProducto_nombre(String producto_nombre) {
        this.producto_nombre = producto_nombre;
    }

    public String getProducto_descripcion() {
        return producto_descripcion;
    }

    public void setProducto_descripcion(String producto_descripcion) {
        this.producto_descripcion = producto_descripcion;
    }

    public Long getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(Long id_tipo) {
        this.id_tipo = id_tipo;
    }

    public String getTipo_nombre() {
        return tipo_nombre;
    }

    public void setTipo_nombre(String tipo_nombre) {
        this.tipo_nombre = tipo_nombre;
    }

    public Long getId_medida() {
        return id_medida;
    }

    public void setId_medida(Long id_medida) {
        this.id_medida = id_medida;
    }

    public String getMedida_nombre() {
        return medida_nombre;
    }

    public void setMedida_nombre(String medida_nombre) {
        this.medida_nombre = medida_nombre;
    }

    public Long getId_envase() {
        return id_envase;
    }

    public void setId_envase(Long id_envase) {
        this.id_envase = id_envase;
    }

    public String getEnvase_nombre() {
        return envase_nombre;
    }

    public void setEnvase_nombre(String envase_nombre) {
        this.envase_nombre = envase_nombre;
    }

    public Long getId_marca() {
        return id_marca;
    }

    public void setId_marca(Long id_marca) {
        this.id_marca = id_marca;
    }

    public String getMarca_nombre() {
        return marca_nombre;
    }

    public void setMarca_nombre(String marca_nombre) {
        this.marca_nombre = marca_nombre;
    }

    public Long getId_stock() {
        return id_stock;
    }

    public void setId_stock(Long id_stock) {
        this.id_stock = id_stock;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    public Long getId_precio() {
        return id_precio;
    }

    public void setId_precio(Long id_precio) {
        this.id_precio = id_precio;
    }

    public BigDecimal getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(BigDecimal precio_venta) {
        this.precio_venta = precio_venta;
    }

    public Long getId_descuento() {
        return id_descuento;
    }

    public void setId_descuento(Long id_descuento) {
        this.id_descuento = id_descuento;
    }

    public BigDecimal getDescuento_venta() {
        return descuento_venta;
    }

    public void setDescuento_venta(BigDecimal descuento_venta) {
        this.descuento_venta = descuento_venta;
    }

    public Long getDescuento() {
        return descuento;
    }

    public void setDescuento(Long descuento) {
        this.descuento = descuento;
    }

    public String getIva() {
        return iva;
    }

    public void setIva(String iva) {
        this.iva = iva;
    }

    public BigDecimal getPrecio_compra() {
        return precio_compra;
    }

    public void setPrecio_compra(BigDecimal precio_compra) {
        this.precio_compra = precio_compra;
    }

    public BigDecimal getDescuento_compra() {
        return descuento_compra;
    }

    public void setDescuento_compra(BigDecimal descuento_compra) {
        this.descuento_compra = descuento_compra;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
}
