/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmacia.entities1;

/**
 *
 * @author usuario
 */
public class Productos_Stock {
    Long id_producto;
    String nombre_Producto;
    String descripcion;
    Long id_precio;
    Double precio_compra;
    Double precio_venta;
    Long id_stock;
    String tipo;
    String medida;
    String envase;
    String marca;
    Long cantidad;

    public Productos_Stock() {
    }

    public Productos_Stock(Long id_producto, String nombre_Producto, String descripcion, Long id_precio, Double precio_compra, Double precio_venta, Long id_stock, String tipo, String medida, String envase, String marca, Long cantidad) {
        this.id_producto = id_producto;
        this.nombre_Producto = nombre_Producto;
        this.descripcion = descripcion;
        this.id_precio = id_precio;
        this.precio_compra = precio_compra;
        this.precio_venta = precio_venta;
        this.id_stock = id_stock;
        this.tipo = tipo;
        this.medida = medida;
        this.envase = envase;
        this.marca = marca;
        this.cantidad = cantidad;
    }

    public Long getId_producto() {
        return id_producto;
    }

    public void setId_producto(Long id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre_Producto() {
        return nombre_Producto;
    }

    public void setNombre_Producto(String nombre_Producto) {
        this.nombre_Producto = nombre_Producto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getId_precio() {
        return id_precio;
    }

    public void setId_precio(Long id_precio) {
        this.id_precio = id_precio;
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

    public Long getId_stock() {
        return id_stock;
    }

    public void setId_stock(Long id_stock) {
        this.id_stock = id_stock;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

    public String getEnvase() {
        return envase;
    }

    public void setEnvase(String envase) {
        this.envase = envase;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    
    
}
