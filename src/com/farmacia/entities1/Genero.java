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
public class Genero {
    private Long id_genero;
    private String genero;

    public Genero() {
    }

    public Genero(Long id_genero, String genero) {
        this.id_genero = id_genero;
        this.genero = genero;
    }

    public Long getId_genero() {
        return id_genero;
    }

    public void setId_genero(Long id_genero) {
        this.id_genero = id_genero;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    
}
