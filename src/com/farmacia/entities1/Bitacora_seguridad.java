/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmacia.entities1;

import java.sql.Date;

/**
 *
 * @author alumno
 */
public class Bitacora_seguridad {

    private Long id_bitacora_seguridad;
    private Long id_bitacora_autenticacion;
    private String user;
    private String password;
    private String ip_equipo;
    private String ip_publico;
    private String usuario_equipo;
    private Date fecha_login;
    private String dir_ip_completa;

    public Bitacora_seguridad() {
    }

    public Bitacora_seguridad(Long id_bitacora_autenticacion, String user, String password, String ip_equipo, String ip_publico, String usuario_equipo, Date fecha_login, String dir_ip_completa) {
        this.id_bitacora_autenticacion = id_bitacora_autenticacion;
        this.user = user;
        this.password = password;
        this.ip_equipo = ip_equipo;
        this.ip_publico = ip_publico;
        this.usuario_equipo = usuario_equipo;
        this.fecha_login = fecha_login;
        this.dir_ip_completa = dir_ip_completa;
    }

    public Bitacora_seguridad(Long id_bitacora_seguridad, Long id_bitacora_autenticacion, String user, String password, String ip_equipo, String ip_publico, String usuario_equipo, Date fecha_login, String dir_ip_completa) {
        this.id_bitacora_seguridad = id_bitacora_seguridad;
        this.id_bitacora_autenticacion = id_bitacora_autenticacion;
        this.user = user;
        this.password = password;
        this.ip_equipo = ip_equipo;
        this.ip_publico = ip_publico;
        this.usuario_equipo = usuario_equipo;
        this.fecha_login = fecha_login;
        this.dir_ip_completa = dir_ip_completa;
    }

    public Long getId_bitacora_seguridad() {
        return id_bitacora_seguridad;
    }

    public void setId_bitacora_seguridad(Long id_bitacora_seguridad) {
        this.id_bitacora_seguridad = id_bitacora_seguridad;
    }

    public Long getId_bitacora_autenticacion() {
        return id_bitacora_autenticacion;
    }

    public void setId_bitacora_autenticacion(Long id_bitacora_autenticacion) {
        this.id_bitacora_autenticacion = id_bitacora_autenticacion;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIp_equipo() {
        return ip_equipo;
    }

    public void setIp_equipo(String ip_equipo) {
        this.ip_equipo = ip_equipo;
    }

    public String getIp_publico() {
        return ip_publico;
    }

    public void setIp_publico(String ip_publico) {
        this.ip_publico = ip_publico;
    }

    public String getUsuario_equipo() {
        return usuario_equipo;
    }

    public void setUsuario_equipo(String usuario_equipo) {
        this.usuario_equipo = usuario_equipo;
    }

    public Date getFecha_login() {
        return fecha_login;
    }

    public void setFecha_login(Date fecha_login) {
        this.fecha_login = fecha_login;
    }

    public String getDir_ip_completa() {
        return dir_ip_completa;
    }

    public void setDir_ip_completa(String dir_ip_completa) {
        this.dir_ip_completa = dir_ip_completa;
    }

}
