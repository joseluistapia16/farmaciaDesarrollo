/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmacia.entities1;

import java.sql.Date;

/**
 *
 * @author alumno
 */
public class Faltantes {

    private Long id_detalle_faltantes;
    private Long id_producto;
    private String nombre;
    private Integer cantidad_minima;
    private Integer cantidad_faltantes;
    private String estado;
    private Integer total;
    private String descripcion;
    private String marcas;
    private Integer cantidad;
//    private Integer total;
    private String tipo;

    public Faltantes() {
       
    }

    public Faltantes(Long id_detalle_faltantes, Long id_producto, String nombre, Integer cantidad_minima, Integer cantidad_faltantes, String estado, Integer total) {
        this.id_detalle_faltantes = id_detalle_faltantes;
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.cantidad_minima = cantidad_minima;
        this.cantidad_faltantes = cantidad_faltantes;
        this.estado = estado;
        this.total = total;
    }

    public Faltantes(Long id_detalle_faltantes, Long id_producto, String nombre, Integer cantidad_minima, Integer cantidad_faltantes, String estado, Integer total, String descripcion, String marcas, Integer cantidad, String tipo) {
        this.id_detalle_faltantes = id_detalle_faltantes;
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.cantidad_minima = cantidad_minima;
        this.cantidad_faltantes = cantidad_faltantes;
        this.estado = estado;
        this.total = total;
        this.descripcion = descripcion;
        this.marcas = marcas;
        this.cantidad = cantidad;
        this.tipo = tipo;
    }

    public Long getId_detalle_faltantes() {
        return id_detalle_faltantes;
    }

    public void setId_detalle_faltantes(Long id_detalle_faltantes) {
        this.id_detalle_faltantes = id_detalle_faltantes;
    }

    public Long getId_producto() {
        return id_producto;
    }

    public void setId_producto(Long id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantidad_minima() {
        return cantidad_minima;
    }

    public void setCantidad_minima(Integer cantidad_minima) {
        this.cantidad_minima = cantidad_minima;
    }

    public Integer getCantidad_faltantes() {
        return cantidad_faltantes;
    }

    public void setCantidad_faltantes(Integer cantidad_faltantes) {
        this.cantidad_faltantes = cantidad_faltantes;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMarcas() {
        return marcas;
    }

    public void setMarcas(String marcas) {
        this.marcas = marcas;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

 

   
   

}