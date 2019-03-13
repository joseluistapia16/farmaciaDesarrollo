/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmacia.entities1;

public class ListarPuntoVenta {
    private Long id_punto_venta;
    private String nombre;
    private String localidad;
    private String direccion;
    private String observacion;

    public ListarPuntoVenta() {
    }

    public ListarPuntoVenta(Long id_punto_venta, String nombre, String localidad, String direccion, String observacion) {
        this.id_punto_venta = id_punto_venta;
        this.nombre = nombre;
        this.localidad = localidad;
        this.direccion = direccion;
        this.observacion = observacion;
    }

    public Long getId_punto_venta() {
        return id_punto_venta;
    }

    public void setId_punto_venta(Long id_punto_venta) {
        this.id_punto_venta = id_punto_venta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    
    
}
