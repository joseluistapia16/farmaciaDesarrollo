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
public class Session {
    
    private Long id_session;
    private Long id_usuario;
    private String ip_equipo;
    private String ip_publico;
    private String usuario_equipo;
    private Date fecha_login;

    public Session() {
    }

    public Session(Long id_usuario, String ip_equipo, String ip_publico, String usuario_equipo, Date fecha_login) {
        this.id_usuario = id_usuario;
        this.ip_equipo = ip_equipo;
        this.ip_publico = ip_publico;
        this.usuario_equipo = usuario_equipo;
        this.fecha_login = fecha_login;
    }

    public Session(Long id_session, Long id_usuario, String ip_equipo, String ip_publico, String usuario_equipo, Date fecha_login) {
        this.id_session = id_session;
        this.id_usuario = id_usuario;
        this.ip_equipo = ip_equipo;
        this.ip_publico = ip_publico;
        this.usuario_equipo = usuario_equipo;
        this.fecha_login = fecha_login;
    }

    public Long getId_session() {
        return id_session;
    }

    public void setId_session(Long id_session) {
        this.id_session = id_session;
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
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
    
    
}
