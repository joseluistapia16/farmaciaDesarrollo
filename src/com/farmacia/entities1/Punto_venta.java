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
public class Punto_venta {

    private Long id_punto_venta;
    private Long id_localidad;
    private String nombre;
    private String dir_ip;
    private String direccion;
    private String estado;
    private String observacion; 
    private String localidad;
    
    public Punto_venta() {
    }

    public Punto_venta(Long id_punto_venta, Long id_localidad, String nombre, String dir_ip, String direccion, String estado, String observacion, String localidad) {
        this.id_punto_venta = id_punto_venta;
        this.id_localidad = id_localidad;
        this.nombre = nombre;
        this.dir_ip = dir_ip;
        this.direccion = direccion;
        this.estado = estado;
        this.observacion = observacion;
        this.localidad = localidad;
    }

    public Long getId_punto_venta() {
        return id_punto_venta;
    }

    public void setId_punto_venta(Long id_punto_venta) {
        this.id_punto_venta = id_punto_venta;
    }

    public Long getId_localidad() {
        return id_localidad;
    }

    public void setId_localidad(Long id_localidad) {
        this.id_localidad = id_localidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDir_ip() {
        return dir_ip;
    }

    public void setDir_ip(String dir_ip) {
        this.dir_ip = dir_ip;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

}
