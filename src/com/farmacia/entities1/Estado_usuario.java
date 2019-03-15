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
public class Estado_usuario {
    private Long id_estado; 
    private String estado;

    public Estado_usuario() {
    }

    public Estado_usuario(Long id_estado, String estado) {
        this.id_estado = id_estado;
        this.estado = estado;
    }

    public Long getId_estado() {
        return id_estado;
    }

    public void setId_estado(Long id_estado) {
        this.id_estado = id_estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
