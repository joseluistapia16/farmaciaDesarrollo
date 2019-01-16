/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmacia.conponentes;

/**
 *
 * @author carlos
 */
public class FiltrosPuntoVenta {
    
    public String comboLocalidadTodo (){
        String query="";
        query="SELECT pv.id_punto_venta, pv.nombre, lg.localidad, pv.direccion,  pv.observacion FROM fc_localidad_guayas lg, fc_punto_venta pv ";
        return query;
    
    }
    
    public String comboLocalidadId (){
        String query="";
        query="SELECT pv.id_punto_venta, pv.nombre, lg.localidad, pv.direccion,  pv.observacion FROM fc_localidad_guayas lg, fc_punto_venta pv\n" +
              " WHERE lg.id_localidad_guayas= pv.id_localidad_guayas AND pv.id_punto_venta = ";
        return query;
    
    }
    
    public String comboLocalidadNombre (){
        String query="";
        query="SELECT pv.id_punto_venta, pv.nombre, lg.localidad, pv.direccion,  pv.observacion FROM fc_localidad_guayas lg, fc_punto_venta pv\n" +
              " WHERE lg.id_localidad_guayas= pv.id_localidad_guayas AND pv.nombre LIKE '% ";
        return query;
    
    }
    
}
