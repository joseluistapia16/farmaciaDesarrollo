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
public class Cantidad_Ventas {

    private long id_cabecera_venta;
    private String num_venta;
    private long id_productos;
    private String nombre;
    private String fecha_creacion;
    private String tipo_pago;
    private String tipo_venta;
    private int total_venta;
    private String fecha2;
    private String fecha1;
    private double total;
    private double utilidad;
    private String descripcion;

    public Cantidad_Ventas() {
    }

    public Cantidad_Ventas(long id_cabecera_venta, String num_venta, long id_productos, String nombre, String fecha_creacion, String tipo_pago, String tipo_venta, int total_venta, String fecha2, String fecha1, double total, double utilidad, String descripcion) {
        this.id_cabecera_venta = id_cabecera_venta;
        this.num_venta = num_venta;
        this.id_productos = id_productos;
        this.nombre = nombre;
        this.fecha_creacion = fecha_creacion;
        this.tipo_pago = tipo_pago;
        this.tipo_venta = tipo_venta;
        this.total_venta = total_venta;
        this.fecha2 = fecha2;
        this.fecha1 = fecha1;
        this.total = total;
        this.utilidad = utilidad;
        this.descripcion = descripcion;
    }

    public long getId_cabecera_venta() {
        return id_cabecera_venta;
    }

    public void setId_cabecera_venta(long id_cabecera_venta) {
        this.id_cabecera_venta = id_cabecera_venta;
    }

    public String getNum_venta() {
        return num_venta;
    }

    public void setNum_venta(String num_venta) {
        this.num_venta = num_venta;
    }

    public long getId_productos() {
        return id_productos;
    }

    public void setId_productos(long id_productos) {
        this.id_productos = id_productos;
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

    public String getTipo_pago() {
        return tipo_pago;
    }

    public void setTipo_pago(String tipo_pago) {
        this.tipo_pago = tipo_pago;
    }

    public String getTipo_venta() {
        return tipo_venta;
    }

    public void setTipo_venta(String tipo_venta) {
        this.tipo_venta = tipo_venta;
    }

    public int getTotal_venta() {
        return total_venta;
    }

    public void setTotal_venta(int total_venta) {
        this.total_venta = total_venta;
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

    public double getUtilidad() {
        return utilidad;
    }

    public void setUtilidad(double utilidad) {
        this.utilidad = utilidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    

}
