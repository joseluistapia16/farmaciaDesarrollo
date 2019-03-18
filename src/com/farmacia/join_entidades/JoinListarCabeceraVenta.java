
package com.farmacia.join_entidades;

import java.math.BigDecimal;
import java.sql.Date;


public class JoinListarCabeceraVenta {
    private Long id_cabecera_venta;
    private String mun_venta;
    private Long id_cliente;
    private String forma_de_pago;
    private String nombre;   
    private String apellido;   
    private String correo;   
    private String direccion;   
    private String cedula; 
    private String fecha_creacion;
    private String telefono;
    private String fecha_registro;
    private String estado;
    private Long id_usuario;
    private Long id_sucursal;
    private String tipo_pago;
    private String tipo_venta;
    private BigDecimal subtotal_con_iva;
    private BigDecimal subtotal_sin_iva;
    private BigDecimal iva_total;
    private BigDecimal descuento_total;
    private BigDecimal total;
    private BigDecimal utilidad;
    private String ruc;
    private String sucursal_nombre;
    private String sucursal_representante;
    private String sucursal_direccion;
    private Long sucursal_id_proveedor;

    public JoinListarCabeceraVenta() {
    }

    public JoinListarCabeceraVenta(Long id_cabecera_venta, String mun_venta, Long id_cliente, String forma_de_pago, String nombre, String apellido, String correo, String direccion, String cedula, String fecha_creacion, String telefono, String fecha_registro, String estado, Long id_usuario, Long id_sucursal, String tipo_pago, String tipo_venta, BigDecimal subtotal_con_iva, BigDecimal subtotal_sin_iva, BigDecimal iva_total, BigDecimal descuento_total, BigDecimal total, BigDecimal utilidad, String ruc, String sucursal_nombre, String sucursal_representante, String sucursal_direccion, Long sucursal_id_proveedor) {
        this.id_cabecera_venta = id_cabecera_venta;
        this.mun_venta = mun_venta;
        this.id_cliente = id_cliente;
        this.forma_de_pago = forma_de_pago;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.direccion = direccion;
        this.cedula = cedula;
        this.fecha_creacion = fecha_creacion;
        this.telefono = telefono;
        this.fecha_registro = fecha_registro;
        this.estado = estado;
        this.id_usuario = id_usuario;
        this.id_sucursal = id_sucursal;
        this.tipo_pago = tipo_pago;
        this.tipo_venta = tipo_venta;
        this.subtotal_con_iva = subtotal_con_iva;
        this.subtotal_sin_iva = subtotal_sin_iva;
        this.iva_total = iva_total;
        this.descuento_total = descuento_total;
        this.total = total;
        this.utilidad = utilidad;
        this.ruc = ruc;
        this.sucursal_nombre = sucursal_nombre;
        this.sucursal_representante = sucursal_representante;
        this.sucursal_direccion = sucursal_direccion;
        this.sucursal_id_proveedor = sucursal_id_proveedor;
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

    public Long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Long id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getForma_de_pago() {
        return forma_de_pago;
    }

    public void setForma_de_pago(String forma_de_pago) {
        this.forma_de_pago = forma_de_pago;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(String fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getSucursal_nombre() {
        return sucursal_nombre;
    }

    public void setSucursal_nombre(String sucursal_nombre) {
        this.sucursal_nombre = sucursal_nombre;
    }

    public String getSucursal_representante() {
        return sucursal_representante;
    }

    public void setSucursal_representante(String sucursal_representante) {
        this.sucursal_representante = sucursal_representante;
    }

    public String getSucursal_direccion() {
        return sucursal_direccion;
    }

    public void setSucursal_direccion(String sucursal_direccion) {
        this.sucursal_direccion = sucursal_direccion;
    }

    public Long getSucursal_id_proveedor() {
        return sucursal_id_proveedor;
    }

    public void setSucursal_id_proveedor(Long sucursal_id_proveedor) {
        this.sucursal_id_proveedor = sucursal_id_proveedor;
    }

}