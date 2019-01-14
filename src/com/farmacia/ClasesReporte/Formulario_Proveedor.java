/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmacia.ClasesReporte;

/**
 *
 * @author guest-isepxs
 */
public class Formulario_Proveedor {
    private String cedula_ruc;
    private String entidad;
    private String contacto;
    private String fecha_ingreso;

    public Formulario_Proveedor() {
    }

    public Formulario_Proveedor(String cedula_ruc, String entidad, String contacto, String fecha_ingreso) {
        this.cedula_ruc = cedula_ruc;
        this.entidad = entidad;
        this.contacto = contacto;
        this.fecha_ingreso = fecha_ingreso;
    }

    public String getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(String fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    

    public String getCedula_ruc() {
        return cedula_ruc;
    }

    public void setCedula_ruc(String cedula_ruc) {
        this.cedula_ruc = cedula_ruc;
    }

    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }
   
    
    
}
