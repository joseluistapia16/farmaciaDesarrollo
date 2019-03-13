
package com.farmacia.entities1;

import java.math.BigDecimal;
import java.util.Date;





public class CabeceraNotaPedido {
    private Long id_cabecera_nota_pedidos;
    private Long id_proveedor;
    private Long id_usuario;
    private String fecha_creacion;
    private String estado;
    private String plazo;
    private String forma_pago;
    private BigDecimal iva;
    private BigDecimal descuento;
    private BigDecimal total;
 

    public CabeceraNotaPedido() {
    }

    public CabeceraNotaPedido(Long id_cabecera_nota_pedidos, Long id_proveedor, Long id_usuario, String fecha_creacion, String estado, String plazo, String forma_pago, BigDecimal iva, BigDecimal descuento, BigDecimal total) {
        this.id_cabecera_nota_pedidos = id_cabecera_nota_pedidos;
        this.id_proveedor = id_proveedor;
        this.id_usuario = id_usuario;
        this.fecha_creacion = fecha_creacion;
        this.estado = estado;
        this.plazo = plazo;
        this.forma_pago = forma_pago;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPlazo() {
        return plazo;
    }

    public void setPlazo(String plazo) {
        this.plazo = plazo;
    }

    public String getForma_pago() {
        return forma_pago;
    }

    public void setForma_pago(String forma_pago) {
        this.forma_pago = forma_pago;
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
