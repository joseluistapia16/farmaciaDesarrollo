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
    
    long id_control;
    int cantidad;

   

    public StockVentas() {}

    public StockVentas(long id_control, int cantidad) {
        this.id_control = id_control;
        this.cantidad = cantidad;
    }

    public long getId_control() {
        return id_control;
    }

    public void setId_control(long id_control) {
        this.id_control = id_control;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    

    
    
    
    
    
    
}
