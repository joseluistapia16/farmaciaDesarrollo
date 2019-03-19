
package com.farmacia.entities1;

import java.sql.Date;

/**
 *
 * @author carlos
 */
public class Listar_usuario {
    private Long id_sesion;
    private String fecha_registro;
    private String cedula;
    private String apellidos;
    private String nombres;
    private String direccion;
    private String telefono;
    private String convencional;
    private String correo;
    private String password;
    private Long id_rol;
    private String ruta_imagen;
    private Long id_usuario_registro;
    private String cargo;
    private String genero;
    private String discapacidad;
    private String porcentaje;
    private String observacion;
    private String estado;
    private Long id_genero;
    private Long id_estado;
    private String ip_equipo;
    private String ip_publico;
    private String usuario_equipo;
    private String dir_ip_completa;
    

    public Listar_usuario() {
    }

    public Listar_usuario(Long id_sesion, String fecha_registro, String cedula, String apellidos, String nombres, String direccion, String telefono, String convencional, String correo, String password, Long id_rol, String ruta_imagen, Long id_usuario_registro, String cargo, String genero, String discapacidad, String porcentaje, String observacion, String estado, Long id_genero, Long id_estado, String ip_equipo, String ip_publico, String usuario_equipo, String dir_ip_completa) {
        this.id_sesion = id_sesion;
        this.fecha_registro = fecha_registro;
        this.cedula = cedula;
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.direccion = direccion;
        this.telefono = telefono;
        this.convencional = convencional;
        this.correo = correo;
        this.password = password;
        this.id_rol = id_rol;
        this.ruta_imagen = ruta_imagen;
        this.id_usuario_registro = id_usuario_registro;
        this.cargo = cargo;
        this.genero = genero;
        this.discapacidad = discapacidad;
        this.porcentaje = porcentaje;
        this.observacion = observacion;
        this.estado = estado;
        this.id_genero = id_genero;
        this.id_estado = id_estado;
        this.ip_equipo = ip_equipo;
        this.ip_publico = ip_publico;
        this.usuario_equipo = usuario_equipo;
        this.dir_ip_completa = dir_ip_completa;
    }

    public Long getId_sesion() {
        return id_sesion;
    }

    public void setId_sesion(Long id_sesion) {
        this.id_sesion = id_sesion;
    }

    public String getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getConvencional() {
        return convencional;
    }

    public void setConvencional(String convencional) {
        this.convencional = convencional;
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

    public Long getId_rol() {
        return id_rol;
    }

    public void setId_rol(Long id_rol) {
        this.id_rol = id_rol;
    }

    public String getRuta_imagen() {
        return ruta_imagen;
    }

    public void setRuta_imagen(String ruta_imagen) {
        this.ruta_imagen = ruta_imagen;
    }

    public Long getId_usuario_registro() {
        return id_usuario_registro;
    }

    public void setId_usuario_registro(Long id_usuario_registro) {
        this.id_usuario_registro = id_usuario_registro;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDiscapacidad() {
        return discapacidad;
    }

    public void setDiscapacidad(String discapacidad) {
        this.discapacidad = discapacidad;
    }

    public String getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(String porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getId_genero() {
        return id_genero;
    }

    public void setId_genero(Long id_genero) {
        this.id_genero = id_genero;
    }

    public Long getId_estado() {
        return id_estado;
    }

    public void setId_estado(Long id_estado) {
        this.id_estado = id_estado;
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

}
