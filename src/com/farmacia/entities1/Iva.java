/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmacia.entities1;

import java.sql.Date;

/**
 *
 * @author guest-lwglxq
 */
public class Iva {
    private Long id_iva;
    private double iva;
    private Date fecha;
    private Long id_usuario;
    private String estado;
    
    public Iva() {
    }

    public Iva(Long id_iva, double iva, Date fecha, Long id_usuario, String estado) {
        this.id_iva = id_iva;
        this.iva = iva;
        this.fecha = fecha;
        this.id_usuario = id_usuario;
        this.estado = estado;
    }

    public Long getId_iva() {
        return id_iva;
    }

    public void setId_iva(Long id_iva) {
        this.id_iva = id_iva;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
}
