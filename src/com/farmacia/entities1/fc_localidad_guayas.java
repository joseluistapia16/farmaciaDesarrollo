/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmacia.entities1;

//import java.math.BigInteger;

/**
 *
 * @author carlos
 */
public class fc_localidad_guayas {
    private Long id_localidad_guayas;
    private String localidad;

    public fc_localidad_guayas() {
    }

    
    public fc_localidad_guayas(Long id_localidad_guayas, String localidad) {
        this.id_localidad_guayas = id_localidad_guayas;
        this.localidad = localidad;
    }

    public Long getId_localidad_guayas() {
        return id_localidad_guayas;
    }

    public void setId_localidad_guayas(Long id_localidad_guayas) {
        this.id_localidad_guayas = id_localidad_guayas;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }
    
    
}
