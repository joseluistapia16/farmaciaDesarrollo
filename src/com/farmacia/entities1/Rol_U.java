/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmacia.entities1;

/**
 *
 * @author carlos
 */
public class Rol_U {
    private Long id_rol;
    private String cargo;
    private String descripcion;

    public Rol_U() {
    }

    public Rol_U(Long id_rol, String cargo, String descripcion) {
        this.id_rol = id_rol;
        this.cargo = cargo;
        this.descripcion = descripcion;
    }

    public Long getId_rol() {
        return id_rol;
    }

    public void setId_rol(Long id_rol) {
        this.id_rol = id_rol;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
