/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmacia.entities1;

import javax.swing.Icon;

/**
 *
 * @author guest-ndqukr
 */
public class ProveedorRep {
    private String fecha_ingreso;
    private String cedula;
    private String entidad;
    private String direccion;
    private String contacto;
    private String telefono;
    private String correo;
    private String imagen;
    
    public ProveedorRep() {
    }

    public ProveedorRep(String fecha_ingreso, String cedula, String entidad, String direccion, String contacto, String telefono, String correo, String imagen) {
        this.fecha_ingreso = fecha_ingreso;
        this.cedula = cedula;
        this.entidad = entidad;
        this.direccion = direccion;
        this.contacto = contacto;
        this.telefono = telefono;
        this.correo = correo;
        this.imagen = imagen;
    }

    public ProveedorRep(String fecha_ingreso, String cedula, String entidad, String contacto) {
        this.fecha_ingreso = fecha_ingreso;
        this.cedula = cedula;
        this.entidad = entidad;
        this.contacto = contacto;
    }

    public ProveedorRep(String fecha_ingreso, String cedula, String entidad, String direccion, String contacto, String telefono, String correo) {
        this.fecha_ingreso = fecha_ingreso;
        this.cedula = cedula;
        this.entidad = entidad;
        this.direccion = direccion;
        this.contacto = contacto;
        this.telefono = telefono;
        this.correo = correo;
    }
    
    
    
          
    public String getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(String fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }    
        
}