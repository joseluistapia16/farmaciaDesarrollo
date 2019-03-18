/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmacia.entities1;

/**
 *
 * @author jorge
 */
public class StockVentas {
    
    Long id_control;
    Long cantidad;

   

    public StockVentas() {}

    public StockVentas(Long id_control, Long cantidad) {
        this.id_control = id_control;
        this.cantidad = cantidad;
    }

    public Long getId_control() {
        return id_control;
    }

    public void setId_control(Long id_control) {
        this.id_control = id_control;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }


    

    
    
    
    
    
    
}
