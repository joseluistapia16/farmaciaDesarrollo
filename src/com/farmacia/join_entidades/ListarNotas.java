
package com.farmacia.join_entidades;

import java.sql.Date;
import java.sql.Time;

public class ListarNotas {
    private Long id_cabecera_nota_pedidos;
    private Long id_proveedor;
    private String entidad;
    private String representante;
    private String fecha_creacion;
    private String estado;
    private Double iva;
    private Double descuento;
    private Double total;

    public ListarNotas() {
    }

    public ListarNotas(Long id_cabecera_nota_pedidos, Long id_proveedor, String entidad, String representante, String fecha_creacion, String estado, Double iva, Double descuento, Double total) {
        this.id_cabecera_nota_pedidos = id_cabecera_nota_pedidos;
        this.id_proveedor = id_proveedor;
        this.entidad = entidad;
        this.representante = representante;
        this.fecha_creacion = fecha_creacion;
        this.estado = estado;
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

}
