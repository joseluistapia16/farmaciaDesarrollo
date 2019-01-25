/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmacia.pruebas;

import com.farmacia.join_entidades.FaltantesCabeceraDetalles;
import com.farmacia.validaciones.ValidarIngresoProducto;
import com.farmacia.dao.CRUD;
import com.farmacia.join_entidades.JoinListarDetalleNotaPedido;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author josel
 */
public class Pruebas {

    public static void main(String[] args) {
        //      ValidarIngresoProducto c = new ValidarIngresoProducto();
        //     c.validarTipoProducto("analgesico");
        //f();

    }

   
    public static void join() {
        CRUD obj = new CRUD();
        ArrayList<FaltantesCabeceraDetalles> lista = obj.listarJoinProductos(1);
        System.out.println(" tam " + lista.size());
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(" tam " + lista.get(i).getNombre() + " " + lista.get(i).getMarca());
        }
    }

    public static void p() {
        ValidarIngresoProducto c = new ValidarIngresoProducto();
        c.validarTipoProducto("analgesico");
        //    System.out.println("num: "+i);
    }

    public static void f() {
        CRUD cr = new CRUD();
        JoinListarDetalleNotaPedido n = new JoinListarDetalleNotaPedido();
        n.setDescuento(34.56);
        n.setPrecio(23.45);
        //  Double valor = cr.eliminardetalleCompra(n);
        //     System.out.println("valor= "+valor);
//    String valor=cr.getNombreTipo(Long.valueOf("1"),Long.valueOf("6"));
//        System.out.println(""+valor);
    }

}
