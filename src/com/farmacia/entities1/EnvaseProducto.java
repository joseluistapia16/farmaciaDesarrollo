/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmacia.entities1;

/**
 *
 * @author User
 */
public class EnvaseProducto {
    private Long id_presentaciones;
    private String nombreEnvase;
    private String estado;

    public EnvaseProducto() {
    }

    public EnvaseProducto(Long id_presentaciones, String nombreEnvase) {
        this.id_presentaciones = id_presentaciones;
        this.nombreEnvase = nombreEnvase;
    }

    public EnvaseProducto(Long id_presentaciones, String nombreEnvase, String estado) {
        this.id_presentaciones = id_presentaciones;
        this.nombreEnvase = nombreEnvase;
        this.estado = estado;
    }

    public Long getId_presentaciones() {
        return id_presentaciones;
    }

    public void setId_presentaciones(Long id_presentaciones) {
        this.id_presentaciones = id_presentaciones;
    }

    public String getNombreEnvase() {
        return nombreEnvase;
    }

    public void setNombreEnvase(String nombreEnvase) {
        this.nombreEnvase = nombreEnvase;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }




     
    
}
