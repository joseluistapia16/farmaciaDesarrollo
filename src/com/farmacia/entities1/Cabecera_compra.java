/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmacia.entities1;

/**
 *
 * @author User
 */
public class Cabecera_compra {

    Long id_cabecera_compra;
    Long id_proveedor;
    Long id_usuario;
    String fecha_creacion;
    String plazo;
    Long id_sucursal;
    String id_tipoPago;
    Double iva;
    Double descuento;
    Double total;
    String estado;
    Long idcabecerapedido;
    public Cabecera_compra() {
    }

    public Cabecera_compra(Long id_cabecera_compra, Long id_proveedor, Long id_usuario, String fecha_creacion, String plazo, Long id_sucursal, String id_tipoPago, Double iva, Double descuento, Double total, String estado, Long idcabecerapedido) {
        this.id_cabecera_compra = id_cabecera_compra;
        this.id_proveedor = id_proveedor;
        this.id_usuario = id_usuario;
        this.fecha_creacion = fecha_creacion;
        this.plazo = plazo;
        this.id_sucursal = id_sucursal;
        this.id_tipoPago = id_tipoPago;
        this.iva = iva;
        this.descuento = descuento;
        this.total = total;
        this.estado = estado;
        this.idcabecerapedido = idcabecerapedido;
    }

    public Long getId_cabecera_compra() {
        return id_cabecera_compra;
    }

    public void setId_cabecera_compra(Long id_cabecera_compra) {
        this.id_cabecera_compra = id_cabecera_compra;
    }

    public Long getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(Long id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(String fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public String getPlazo() {
        return plazo;
    }

    public void setPlazo(String plazo) {
        this.plazo = plazo;
    }

    public Long getId_sucursal() {
        return id_sucursal;
    }

    public void setId_sucursal(Long id_sucursal) {
        this.id_sucursal = id_sucursal;
    }

    public String getId_tipoPago() {
        return id_tipoPago;
    }

    public void setId_tipoPago(String id_tipoPago) {
        this.id_tipoPago = id_tipoPago;
    }

    public Double getIva() {
        return iva;
    }

    public void setIva(Double iva) {
        this.iva = iva;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getIdcabecerapedido() {
        return idcabecerapedido;
    }

    public void setIdcabecerapedido(Long idcabecerapedido) {
        this.idcabecerapedido = idcabecerapedido;
    }

    
}
