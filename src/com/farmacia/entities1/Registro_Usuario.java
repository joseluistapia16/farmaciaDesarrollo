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
public class Registro_Usuario {
    
    String Nombre;
    String Apellido;
    String Telefono;
    String Rol;
    String Punto_Venta;

    public Registro_Usuario() {
    }

    public Registro_Usuario(String Nombre, String Apellido, String Telefono, String Rol, String Punto_Venta) {
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Telefono = Telefono;
        this.Rol = Rol;
        this.Punto_Venta = Punto_Venta;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getRol() {
        return Rol;
    }

    public void setRol(String Rol) {
        this.Rol = Rol;
    }

    public String getPunto_Venta() {
        return Punto_Venta;
    }

    public void setPunto_Venta(String Punto_Venta) {
        this.Punto_Venta = Punto_Venta;
    }
    
    
    
    
    
}
