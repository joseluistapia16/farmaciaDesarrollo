/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmacia.entities1;

/**
 *
 * @author TapiaSoftware
 */
public class Ip_Publica {

    private String ip;
    private String nombre;
    private String ip_publica_full;

    public Ip_Publica() {
    }

    public Ip_Publica(String ip1, String nombre1) {
        this.ip = ip1;
        this.nombre = nombre1;
        this.ip_publica_full = ip + "." + nombre;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIp_publica_full() {
        ip_publica_full = ip + "." + nombre;
        return ip_publica_full;
    }

}
