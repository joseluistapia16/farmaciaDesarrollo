/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmacia.entities1;

/**
 *
 * @author User
 */
public class Precios {
    private Long id_precio;
    private Long id_producto;
    private Double precio_compra;
    private Double precio_venta;
    private String estado;
    private String estadoPrecio;
    private String fecha_registro;
    private Long id_usuario;

    public Precios() {
    }

    public Precios(Long id_precio, Long id_producto, Double precio_compra, Double precio_venta, String estado, String estadoPrecio, String fecha_registro, Long id_usuario) {
        this.id_precio = id_precio;
        this.id_producto = id_producto;
        this.precio_compra = precio_compra;
        this.precio_venta = precio_venta;
        this.estado = estado;
        this.estadoPrecio = estadoPrecio;
        this.fecha_registro = fecha_registro;
        this.id_usuario = id_usuario;
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

    public Double getPrecio_compra() {
        return precio_compra;
    }

    public void setPrecio_compra(Double precio_compra) {
        this.precio_compra = precio_compra;
    }

    public Double getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(Double precio_venta) {
        this.precio_venta = precio_venta;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstadoPrecio() {
        return estadoPrecio;
    }

    public void setEstadoPrecio(String estadoPrecio) {
        this.estadoPrecio = estadoPrecio;
    }

    public String getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

   
}
