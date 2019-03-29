/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmacia.entities1;

/**
 *
 * @author alumno
 */
public class Cantidad_compras {

    private long id_cabecera_compra;
    private long id_producto;
    private String nombre;
    private String fecha_creacion;
    private String tipo_de_pago;
    private String plazo;
    private int cantidad_comprado;
    private String fecha2;
    private String fecha1;
    private double total;
    private String descripcion;

    public Cantidad_compras() {
    }

    public Cantidad_compras(long id_cabecera_compra, long id_producto, String nombre, String fecha_creacion, String tipo_de_pago, String plazo, int cantidad_comprado, String fecha2, String fecha1, double total, String descripcion) {
        this.id_cabecera_compra = id_cabecera_compra;
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.fecha_creacion = fecha_creacion;
        this.tipo_de_pago = tipo_de_pago;
        this.plazo = plazo;
        this.cantidad_comprado = cantidad_comprado;
        this.fecha2 = fecha2;
        this.fecha1 = fecha1;
        this.total = total;
        this.descripcion = descripcion;
    }

    public long getId_cabecera_compra() {
        return id_cabecera_compra;
    }

    public void setId_cabecera_compra(long id_cabecera_compra) {
        this.id_cabecera_compra = id_cabecera_compra;
    }

    public long getId_producto() {
        return id_producto;
    }

    public void setId_producto(long id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(String fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public String getTipo_de_pago() {
        return tipo_de_pago;
    }

    public void setTipo_de_pago(String tipo_de_pago) {
        this.tipo_de_pago = tipo_de_pago;
    }

    public String getPlazo() {
        return plazo;
    }

    public void setPlazo(String plazo) {
        this.plazo = plazo;
    }

    public int getCantidad_comprado() {
        return cantidad_comprado;
    }

    public void setCantidad_comprado(int cantidad_comprado) {
        this.cantidad_comprado = cantidad_comprado;
    }

    public String getFecha2() {
        return fecha2;
    }

    public void setFecha2(String fecha2) {
        this.fecha2 = fecha2;
    }

    public String getFecha1() {
        return fecha1;
    }

    public void setFecha1(String fecha1) {
        this.fecha1 = fecha1;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

   

}
