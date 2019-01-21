/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmacia.validaciones;

import com.farmacia.dao.CRUD;
import com.farmacia.join_entidades.joinProductoDetallesFaltantes;
import java.util.ArrayList;
import javax.swing.JTable;

/**
 *
 * @author alumno
 */
public class ComponentesFaltantes {
    CRUD crud = new CRUD();
ArrayList<joinProductoDetallesFaltantes> lista = crud.listarFaltantesDetalles(1);
    
    public static String validarListaFaltantes(JTable tabla, String Id_precios) {
        String o, msg = null;
        for (int i = 0; i < tabla.getRowCount(); i++) {
            o = (String) tabla.getValueAt(i, 0);
            if (o.equals(Id_precios)) {
                msg = "El producto ya fue Seleccionado!";
                break;
            }

        }

        return msg;
    }

    public static String validarListaCompras(JTable tabla, String id_producto) {
        String o, msg = null;
        for (int i = 0; i < tabla.getRowCount(); i++) {
            o = (String) tabla.getValueAt(i, 0);

            System.out.println((i + 1) + " prueba " + o + "   " + tabla.getRowCount());
            if (o.equals(id_producto)) {
                msg = "El producto ya fue Seleccionado!";
                break;
            }

        }

        return msg;
    }

}
