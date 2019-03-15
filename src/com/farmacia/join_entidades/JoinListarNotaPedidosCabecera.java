
package com.farmacia.join_entidades;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;


public class JoinListarNotaPedidosCabecera {
    private Long id_cabecera_nota_pedidos;
    private Long id_proveedor;
    private String entidad;
    private String representante;
    private String telefono;
    private Long id_proveedor_clase;
    private String clase;
    private String direccion;
    private String cedula_ruc;
    private String correo;
    private String Plazo;
    private String forma_pago;
    private String fecha_creacion;
    private String fecha2;
    private String fecha1;
    private BigDecimal iva;
    private BigDecimal descuento;
    private BigDecimal total;

    public JoinListarNotaPedidosCabecera() {
    }

    public JoinListarNotaPedidosCabecera(Long id_cabecera_nota_pedidos, Long id_proveedor, String entidad, String representante, String telefono, Long id_proveedor_clase, String clase, String direccion, String cedula_ruc, String correo, String Plazo, String forma_pago, String fecha_creacion, String fecha2, String fecha1, BigDecimal iva, BigDecimal descuento, BigDecimal total) {
        this.id_cabecera_nota_pedidos = id_cabecera_nota_pedidos;
        this.id_proveedor = id_proveedor;
        this.entidad = entidad;
        this.representante = representante;
        this.telefono = telefono;
        this.id_proveedor_clase = id_proveedor_clase;
        this.clase = clase;
        this.direccion = direccion;
        this.cedula_ruc = cedula_ruc;
        this.correo = correo;
        this.Plazo = Plazo;
        this.forma_pago = forma_pago;
        this.fecha_creacion = fecha_creacion;
        this.fecha2 = fecha2;
        this.fecha1 = fecha1;
        this.iva = iva;
        this.descuento = descuento;
        this.total = total;
    }

    public Long getId_cabecera_nota_pedidos() {
        return id_cabecera_nota_pedidos;
    }

    public void setId_cabecera_nota_pedidos(Long id_cabecera_nota_pedidos) {
        this.id_cabecera_nota_pedidos = id_cabecera_nota_pedidos;
    }

    public Long getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(Long id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    public String getRepresentante() {
        return representante;
    }

    public void setRepresentante(String representante) {
        this.representante = representante;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Long getId_proveedor_clase() {
        return id_proveedor_clase;
    }

    public void setId_proveedor_clase(Long id_proveedor_clase) {
        this.id_proveedor_clase = id_proveedor_clase;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCedula_ruc() {
        return cedula_ruc;
    }

    public void setCedula_ruc(String cedula_ruc) {
        this.cedula_ruc = cedula_ruc;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPlazo() {
        return Plazo;
    }

    public void setPlazo(String Plazo) {
        this.Plazo = Plazo;
    }

    public String getForma_pago() {
        return forma_pago;
    }

    public void setForma_pago(String forma_pago) {
        this.forma_pago = forma_pago;
    }

    public String getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(String fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public String getFecha2() {
        return fecha2;
    }

    public void setFecha2(String fecha2) {
        this.fecha2 = fecha2;
    }

    public String getFecha1() {
        return fecha1;
    }

    public void setFecha1(String fecha1) {
        this.fecha1 = fecha1;
    }

    public BigDecimal getIva() {
        return iva;
    }

    public void setIva(BigDecimal iva) {
        this.iva = iva;
    }

    public BigDecimal getDescuento() {
        return descuento;
    }

    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }


}
