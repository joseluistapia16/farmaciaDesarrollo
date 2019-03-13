/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmacia.join_entidades;

/**
 *
 * @author User
 */
public class listarJoinProductosNotaPedidos {
    private Long id_productos;
    private String nombreProductos;
    private Long id_tipo;
    private String nombreTipo;
    private Long id_medida;
    private String nombreMedida;
    private Long id_envase;
    private String nombreEnvase;
    private Long id_marca;
    private String nombreMarca;
    private Integer cantidad;
    private Double precio;

    public listarJoinProductosNotaPedidos() {
    }

    public listarJoinProductosNotaPedidos(Long id_productos, String nombreProductos, Long id_tipo, String nombreTipo, Long id_medida, String nombreMedida, Long id_envase, String nombreEnvase, Long id_marca, String nombreMarca, Integer cantidad, Double precio) {
        this.id_productos = id_productos;
        this.nombreProductos = nombreProductos;
        this.id_tipo = id_tipo;
        this.nombreTipo = nombreTipo;
        this.id_medida = id_medida;
        this.nombreMedida = nombreMedida;
        this.id_envase = id_envase;
        this.nombreEnvase = nombreEnvase;
        this.id_marca = id_marca;
        this.nombreMarca = nombreMarca;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public Long getId_productos() {
        return id_productos;
    }

    public void setId_productos(Long id_productos) {
        this.id_productos = id_productos;
    }

    public String getNombreProductos() {
        return nombreProductos;
    }

    public void setNombreProductos(String nombreProductos) {
        this.nombreProductos = nombreProductos;
    }

    public Long getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(Long id_tipo) {
        this.id_tipo = id_tipo;
    }

    public String getNombreTipo() {
        return nombreTipo;
    }

    public void setNombreTipo(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }

    public Long getId_medida() {
        return id_medida;
    }

    public void setId_medida(Long id_medida) {
        this.id_medida = id_medida;
    }

    public String getNombreMedida() {
        return nombreMedida;
    }

    public void setNombreMedida(String nombreMedida) {
        this.nombreMedida = nombreMedida;
    }

    public Long getId_envase() {
        return id_envase;
    }

    public void setId_envase(Long id_envase) {
        this.id_envase = id_envase;
    }

    public String getNombreEnvase() {
        return nombreEnvase;
    }

    public void setNombreEnvase(String nombreEnvase) {
        this.nombreEnvase = nombreEnvase;
    }

    public Long getId_marca() {
        return id_marca;
    }

    public void setId_marca(Long id_marca) {
        this.id_marca = id_marca;
    }

    public String getNombreMarca() {
        return nombreMarca;
    }

    public void setNombreMarca(String nombreMarca) {
        this.nombreMarca = nombreMarca;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    
}
