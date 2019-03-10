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
public class Cabecera_ventas {

    private Long id_cabecera_venta;
    private Long id_cliente;
    private Long id_usuario;
    private Date fecha_venta;
    private String forma_de_pago;
    private Double total_venta;
    private Double descuento_venta;
    private Double iva_venta;
    private Double utilidad;
    private String estado;
    private String mun_venta;
    
    public Cabecera_ventas (){}

    public Cabecera_ventas(Long id_cabecera_venta, Long id_cliente, Long id_usuario, Date fecha_venta, String forma_de_pago, Double total_venta, Double descuento_venta, Double iva_venta, Double utilidad, String estado, String mun_venta) {
        this.id_cabecera_venta = id_cabecera_venta;
        this.id_cliente = id_cliente;
        this.id_usuario = id_usuario;
        this.fecha_venta = fecha_venta;
        this.forma_de_pago = forma_de_pago;
        this.total_venta = total_venta;
        this.descuento_venta = descuento_venta;
        this.iva_venta = iva_venta;
        this.utilidad = utilidad;
        this.estado = estado;
        this.mun_venta = mun_venta;
    }

    public Long getId_cabecera_venta() {
        return id_cabecera_venta;
    }

    public void setId_cabecera_venta(Long id_cabecera_venta) {
        this.id_cabecera_venta = id_cabecera_venta;
    }

    public Long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Long id_cliente) {
        this.id_cliente = id_cliente;
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Date getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(Date fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public String getForma_de_pago() {
        return forma_de_pago;
    }

    public void setForma_de_pago(String forma_de_pago) {
        this.forma_de_pago = forma_de_pago;
    }

    public Double getTotal_venta() {
        return total_venta;
    }

    public void setTotal_venta(Double total_venta) {
        this.total_venta = total_venta;
    }

    public Double getDescuento_venta() {
        return descuento_venta;
    }

    public void setDescuento_venta(Double descuento_venta) {
        this.descuento_venta = descuento_venta;
    }

    public Double getIva_venta() {
        return iva_venta;
    }

    public void setIva_venta(Double iva_venta) {
        this.iva_venta = iva_venta;
    }

    public Double getUtilidad() {
        return utilidad;
    }

    public void setUtilidad(Double utilidad) {
        this.utilidad = utilidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMun_venta() {
        return mun_venta;
    }

    public void setMun_venta(String mun_venta) {
        this.mun_venta = mun_venta;
    }

   
    
}
