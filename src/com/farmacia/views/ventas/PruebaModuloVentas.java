/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmacia.views.ventas;

import com.farmacia.dao.CRUD;
import com.farmacia.join_entidades.JoinListarProductosVentas;
import java.util.ArrayList;

/**
 *
 * @author Jomugue
 */
public class PruebaModuloVentas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        CRUD crud = new CRUD();
        ArrayList<JoinListarProductosVentas> listar = null;

        listar = crud.ListarTodoJoinProductosVentas("22","buscar_codigo");
        
        System.out.println(listar.get(0).getId_producto().toString());
                

    }

}
