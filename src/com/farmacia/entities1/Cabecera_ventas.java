/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmacia.entities1;

import java.math.BigDecimal;
import java.sql.Date;

/**
 *
 * @author alumno
 */
public class Cabecera_ventas {

    private Long id_cabecera_venta;
    private String mun_venta;
    private String forma_de_pago;
    private Long id_cliente;
    private Long id_usuario;
    private Long id_sucursal;
    private Date fecha_venta;
    private String tipo_de_venta;
    private BigDecimal subtotal_con_iva;
    private BigDecimal subtotal_sin_iva;
    private BigDecimal subtotal_no_obj_iva;
    private BigDecimal subtotal_exento_iva;
    private BigDecimal subtotal_venta;
    private BigDecimal ice_venta;
    private BigDecimal descuento_venta;
    private BigDecimal iva_venta;
    private BigDecimal total_venta;
    private BigDecimal utilidad;
    private String estado;

    
 

    public Cabecera_ventas() {
    }

    public Cabecera_ventas(Long id_cabecera_venta, String mun_venta, String forma_de_pago, Long id_cliente, Long id_usuario, Long id_sucursal, Date fecha_venta, String tipo_de_venta, BigDecimal subtotal_con_iva, BigDecimal subtotal_sin_iva, BigDecimal subtotal_no_obj_iva, BigDecimal subtotal_exento_iva, BigDecimal subtotal_venta, BigDecimal ice_venta, BigDecimal descuento_venta, BigDecimal iva_venta, BigDecimal total_venta, BigDecimal utilidad, String estado) {

        this.id_cabecera_venta = id_cabecera_venta;
        this.mun_venta = mun_venta;
        this.forma_de_pago = forma_de_pago;
        this.id_cliente = id_cliente;
        this.id_usuario = id_usuario;
        this.id_sucursal = id_sucursal;
        this.fecha_venta = fecha_venta;
        this.tipo_de_venta = tipo_de_venta;
        this.subtotal_con_iva = subtotal_con_iva;
        this.subtotal_sin_iva = subtotal_sin_iva;
        this.subtotal_no_obj_iva = subtotal_no_obj_iva;
        this.subtotal_exento_iva = subtotal_exento_iva;
        this.subtotal_venta = subtotal_venta;
        this.ice_venta = ice_venta;
        this.descuento_venta = descuento_venta;
        this.iva_venta = iva_venta;
        this.total_venta = total_venta;
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

    public String getMun_venta() {
        return mun_venta;
    }

    public void setMun_venta(String mun_venta) {
        this.mun_venta = mun_venta;
    }

    public String getForma_de_pago() {
        return forma_de_pago;
    }

    public void setForma_de_pago(String forma_de_pago) {
        this.forma_de_pago = forma_de_pago;
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

    public Long getId_sucursal() {
        return id_sucursal;
    }

    public void setId_sucursal(Long id_sucursal) {
        this.id_sucursal = id_sucursal;
    }

    public Date getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(Date fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public String getTipo_de_venta() {
        return tipo_de_venta;
    }

    public void setTipo_de_venta(String tipo_de_venta) {
        this.tipo_de_venta = tipo_de_venta;
    }

    public BigDecimal getSubtotal_con_iva() {
        return subtotal_con_iva;
    }

    public void setSubtotal_con_iva(BigDecimal subtotal_con_iva) {
        this.subtotal_con_iva = subtotal_con_iva;
    }

    public BigDecimal getSubtotal_sin_iva() {
        return subtotal_sin_iva;
    }

    public void setSubtotal_sin_iva(BigDecimal subtotal_sin_iva) {
        this.subtotal_sin_iva = subtotal_sin_iva;
    }

    public BigDecimal getSubtotal_no_obj_iva() {
        return subtotal_no_obj_iva;
    }

    public void setSubtotal_no_obj_iva(BigDecimal subtotal_no_obj_iva) {
        this.subtotal_no_obj_iva = subtotal_no_obj_iva;
    }

    public BigDecimal getSubtotal_exento_iva() {
        return subtotal_exento_iva;
    }

    public void setSubtotal_exento_iva(BigDecimal subtotal_exento_iva) {
        this.subtotal_exento_iva = subtotal_exento_iva;
    }

    public BigDecimal getSubtotal_venta() {
        return subtotal_venta;
    }

    public void setSubtotal_venta(BigDecimal subtotal_venta) {
        this.subtotal_venta = subtotal_venta;
    }

    public BigDecimal getIce_venta() {
        return ice_venta;
    }

    public void setIce_venta(BigDecimal ice_venta) {
        this.ice_venta = ice_venta;
    }

    public BigDecimal getDescuento_venta() {
        return descuento_venta;
    }

    public void setDescuento_venta(BigDecimal descuento_venta) {
        this.descuento_venta = descuento_venta;
    }

    public BigDecimal getIva_venta() {
        return iva_venta;
    }

    public void setIva_venta(BigDecimal iva_venta) {
        this.iva_venta = iva_venta;
    }

    public BigDecimal getTotal_venta() {
        return total_venta;
    }

    public void setTotal_venta(BigDecimal total_venta) {
        this.total_venta = total_venta;
    }

    public BigDecimal getUtilidad() {
        return utilidad;
    }

    public void setUtilidad(BigDecimal utilidad) {
        this.utilidad = utilidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }


   

    
}
