/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmacia.entities1;

import java.util.Date;

/**
 *
 * @author alumno
 */
public class Usuario_S {

    private Long id_usuario;
    private Long id_punto_venta;
    private Long id_rol;
    private String cedula;
    private String nombre;
    private String apellido;
    private String telefono;
    private String correo;
    private String password;
    private String ruta_imagen;
    private Date fecha_registro;
    private Long id_usuario_registro;
    private String estado;
    private String ip_equipo;
    private String ip_publico;
    private String usuario_equipo;
    private String dir_ip_completa;
    private String convencional;
    private String genero;
    private String direccion;
    private String observacion;
    private String cargo;
    private Long id_sesion;
    

    public Usuario_S() {
    }

    public Usuario_S(Long id_usuario, Long id_punto_venta, Long id_rol, String cedula, String nombre, String apellido, String telefono, String correo, String password, String ruta_imagen, Date fecha_registro, Long id_usuario_registro, String estado, String ip_equipo, String ip_publico, String usuario_equipo, String dir_ip_completa, String convencional, String genero, String direccion, String observacion, String cargo, Long id_sesion) {
        this.id_usuario = id_usuario;
        this.id_punto_venta = id_punto_venta;
        this.id_rol = id_rol;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.correo = correo;
        this.password = password;
        this.ruta_imagen = ruta_imagen;
        this.fecha_registro = fecha_registro;
        this.id_usuario_registro = id_usuario_registro;
        this.estado = estado;
        this.ip_equipo = ip_equipo;
        this.ip_publico = ip_publico;
        this.usuario_equipo = usuario_equipo;
        this.dir_ip_completa = dir_ip_completa;
        this.convencional = convencional;
        this.genero = genero;
        this.direccion = direccion;
        this.observacion = observacion;
        this.cargo = cargo;
        this.id_sesion = id_sesion;
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Long getId_punto_venta() {
        return id_punto_venta;
    }

    public void setId_punto_venta(Long id_punto_venta) {
        this.id_punto_venta = id_punto_venta;
    }

    public Long getId_rol() {
        return id_rol;
    }

    public void setId_rol(Long id_rol) {
        this.id_rol = id_rol;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRuta_imagen() {
        return ruta_imagen;
    }

    public void setRuta_imagen(String ruta_imagen) {
        this.ruta_imagen = ruta_imagen;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public Long getId_usuario_registro() {
        return id_usuario_registro;
    }

    public void setId_usuario_registro(Long id_usuario_registro) {
        this.id_usuario_registro = id_usuario_registro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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

    public String getDir_ip_completa() {
        return dir_ip_completa;
    }

    public void setDir_ip_completa(String dir_ip_completa) {
        this.dir_ip_completa = dir_ip_completa;
    }

    public String getConvencional() {
        return convencional;
    }

    public void setConvencional(String convencional) {
        this.convencional = convencional;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Long getId_sesion() {
        return id_sesion;
    }

    public void setId_sesion(Long id_sesion) {
        this.id_sesion = id_sesion;
    }

    
}
