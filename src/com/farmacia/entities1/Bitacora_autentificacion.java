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
public class Bitacora_autentificacion {
    
    private Long id_bitacora_autentificacion;
    private int login;

    public Bitacora_autentificacion() {
    }

    public Bitacora_autentificacion(int login) {
        this.login = login;
    }

    public Bitacora_autentificacion(Long id_bitacora_autentificacion, int login) {
        this.id_bitacora_autentificacion = id_bitacora_autentificacion;
        this.login = login;
    }

    public Long getId_bitacora_autentificacion() {
        return id_bitacora_autentificacion;
    }

    public void setId_bitacora_autentificacion(Long id_bitacora_autentificacion) {
        this.id_bitacora_autentificacion = id_bitacora_autentificacion;
    }

    public int getLogin() {
        return login;
    }

    public void setLogin(int login) {
        this.login = login;
    }
    
    
}
