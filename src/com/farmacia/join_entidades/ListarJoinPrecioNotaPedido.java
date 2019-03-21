/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmacia.join_entidades;

import java.math.BigDecimal;

/**
 *
 * @author alumno
 */
public class ListarJoinPrecioNotaPedido {
    
    private Long id_precio;
    private String nombre;
    private String descripcion;
    private Long id_producto;
    private BigDecimal precio_compra;
    private String estado_precio;
    private Long id_productos;
    private String fecha_registro;
    private Double peso;
    private Long id_tipo;
    private Long id_medidas;
    private Long id_envase;
    private Long id_marcas;
    private String estado_producto;
    private String iva;
    private String fecha_registroProducto;

    public ListarJoinPrecioNotaPedido() {
    }

    public ListarJoinPrecioNotaPedido(Long id_precio, String nombre, String descripcion, Long id_producto, BigDecimal precio_compra, String estado_precio, Long id_productos, String fecha_registro, Double peso, Long id_tipo, Long id_medidas, Long id_envase, Long id_marcas, String estado_producto, String iva, String fecha_registroProducto) {
        this.id_precio = id_precio;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.id_producto = id_producto;
        this.precio_compra = precio_compra;
        this.estado_precio = estado_precio;
        this.id_productos = id_productos;
        this.fecha_registro = fecha_registro;
        this.peso = peso;
        this.id_tipo = id_tipo;
        this.id_medidas = id_medidas;
        this.id_envase = id_envase;
        this.id_marcas = id_marcas;
        this.estado_producto = estado_producto;
        this.iva = iva;
        this.fecha_registroProducto = fecha_registroProducto;
    }

    public Long getId_precio() {
        return id_precio;
    }

    public void setId_precio(Long id_precio) {
        this.id_precio = id_precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getId_producto() {
        return id_producto;
    }

    public void setId_producto(Long id_producto) {
        this.id_producto = id_producto;
    }

    public BigDecimal getPrecio_compra() {
        return precio_compra;
    }

    public void setPrecio_compra(BigDecimal precio_compra) {
        this.precio_compra = precio_compra;
    }

    public String getEstado_precio() {
        return estado_precio;
    }

    public void setEstado_precio(String estado_precio) {
        this.estado_precio = estado_precio;
    }

    public Long getId_productos() {
        return id_productos;
    }

    public void setId_productos(Long id_productos) {
        this.id_productos = id_productos;
    }

    public String getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Long getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(Long id_tipo) {
        this.id_tipo = id_tipo;
    }

    public Long getId_medidas() {
        return id_medidas;
    }

    public void setId_medidas(Long id_medidas) {
        this.id_medidas = id_medidas;
    }

    public Long getId_envase() {
        return id_envase;
    }

    public void setId_envase(Long id_envase) {
        this.id_envase = id_envase;
    }

    public Long getId_marcas() {
        return id_marcas;
    }

    public void setId_marcas(Long id_marcas) {
        this.id_marcas = id_marcas;
    }

    public String getEstado_producto() {
        return estado_producto;
    }

    public void setEstado_producto(String estado_producto) {
        this.estado_producto = estado_producto;
    }

    public String getIva() {
        return iva;
    }

    public void setIva(String iva) {
        this.iva = iva;
    }

    public String getFecha_registroProducto() {
        return fecha_registroProducto;
    }

    public void setFecha_registroProducto(String fecha_registroProducto) {
        this.fecha_registroProducto = fecha_registroProducto;
    }

}
