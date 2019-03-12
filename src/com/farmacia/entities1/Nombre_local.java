/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmacia.entities1;

import java.sql.Date;

/**
 *
 * @author carlos
 */
public class Nombre_local {
    private Long id_punto_venta; 
    private String nombre;
    private String direccion; 
    private String telefono_pv;
    private Date fecha_creacion;
    private Date fecha_actualizacion;

    public Nombre_local() {
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono_pv() {
        return telefono_pv;
    }

    public void setTelefono_pv(String telefono_pv) {
        this.telefono_pv = telefono_pv;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public Date getFecha_actualizacion() {
        return fecha_actualizacion;
    }

    public void setFecha_actualizacion(Date fecha_actualizacion) {
        this.fecha_actualizacion = fecha_actualizacion;
    }

    public Nombre_local(Long id_punto_venta, String nombre, String direccion, String telefono_pv, Date fecha_creacion, Date fecha_actualizacion) {
        this.id_punto_venta = id_punto_venta;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono_pv = telefono_pv;
        this.fecha_creacion = fecha_creacion;
        this.fecha_actualizacion = fecha_actualizacion;
    }

}
