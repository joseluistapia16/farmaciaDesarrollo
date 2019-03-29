
package com.farmacia.join_entidades;

import java.math.BigDecimal;
import java.sql.Date;


public class JoinListarCabeceraVenta {
    private Long id_cabecera_venta;
    private String mun_venta;
    private Long id_sucursal;
    private String surcusal;
    private String ruc;
    private String direccion;
    private String telefono;
    private Long id_cliente;
    private String nombre_completo_cliente;
    private String cedula_cliente;
    private Long id_usuario;
    private String nombre_completo_usuario;
    private String fecha_creacion; 
    private String tipo_pago;
    private String tipo_venta;
    private BigDecimal subtotal_con_iva;
    private BigDecimal subtotal_sin_iva;
    private BigDecimal subtotal;
    private BigDecimal iva_total;
    private BigDecimal descuento_total;
    private BigDecimal total;
    private BigDecimal utilidad;
    private String estado;


    public JoinListarCabeceraVenta() {
    }

    public JoinListarCabeceraVenta(Long id_cabecera_venta, String mun_venta, Long id_sucursal, String surcusal, String ruc, String direccion, String telefono, Long id_cliente, String nombre_completo_cliente, String cedula_cliente, Long id_usuario, String nombre_completo_usuario, String fecha_creacion, String tipo_pago, String tipo_venta, BigDecimal subtotal_con_iva, BigDecimal subtotal_sin_iva, BigDecimal subtotal, BigDecimal iva_total, BigDecimal descuento_total, BigDecimal total, BigDecimal utilidad, String estado) {
        this.id_cabecera_venta = id_cabecera_venta;
        this.mun_venta = mun_venta;
        this.id_sucursal = id_sucursal;
        this.surcusal = surcusal;
        this.ruc = ruc;
        this.direccion = direccion;
        this.telefono = telefono;
        this.id_cliente = id_cliente;
        this.nombre_completo_cliente = nombre_completo_cliente;
        this.cedula_cliente = cedula_cliente;
        this.id_usuario = id_usuario;
        this.nombre_completo_usuario = nombre_completo_usuario;
        this.fecha_creacion = fecha_creacion;
        this.tipo_pago = tipo_pago;
        this.tipo_venta = tipo_venta;
        this.subtotal_con_iva = subtotal_con_iva;
        this.subtotal_sin_iva = subtotal_sin_iva;
        this.subtotal = subtotal;
        this.iva_total = iva_total;
        this.descuento_total = descuento_total;
        this.total = total;
        this.utilidad = utilidad;
        this.estado = estado;
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

    public Long getId_sucursal() {
        return id_sucursal;
    }

    public void setId_sucursal(Long id_sucursal) {
        this.id_sucursal = id_sucursal;
    }

    public String getSurcusal() {
        return surcusal;
    }

    public void setSurcusal(String surcusal) {
        this.surcusal = surcusal;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
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

    public Long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Long id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombre_completo_cliente() {
        return nombre_completo_cliente;
    }

    public void setNombre_completo_cliente(String nombre_completo_cliente) {
        this.nombre_completo_cliente = nombre_completo_cliente;
    }

    public String getCedula_cliente() {
        return cedula_cliente;
    }

    public void setCedula_cliente(String cedula_cliente) {
        this.cedula_cliente = cedula_cliente;
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_completo_usuario() {
        return nombre_completo_usuario;
    }

    public void setNombre_completo_usuario(String nombre_completo_usuario) {
        this.nombre_completo_usuario = nombre_completo_usuario;
    }

    public String getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(String fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public String getTipo_pago() {
        return tipo_pago;
    }

    public void setTipo_pago(String tipo_pago) {
        this.tipo_pago = tipo_pago;
    }

    public String getTipo_venta() {
        return tipo_venta;
    }

    public void setTipo_venta(String tipo_venta) {
        this.tipo_venta = tipo_venta;
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

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getIva_total() {
        return iva_total;
    }

    public void setIva_total(BigDecimal iva_total) {
        this.iva_total = iva_total;
    }

    public BigDecimal getDescuento_total() {
        return descuento_total;
    }

    public void setDescuento_total(BigDecimal descuento_total) {
        this.descuento_total = descuento_total;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
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