/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmacia.conponentes;

//import com.objetos.domain.Laboratorio;
//import com.objetos.fecha.Fecha;
import com.farmacia.dao.Consultas;
import com.farmacia.entities1.Cantidad_Ventas;
import com.farmacia.entities1.Cantidad_compras;
import com.farmacia.join_entidades.FaltantesCabeceraDetalles;
import com.farmacia.join_entidades.ListarJoinProveedor;
import com.farmacia.join_entidades.joinProductoDetallesFaltantes;
import com.farmacia.join_entidades.listarJoinProductosCompras;
import com.farmacia.entities1.Clientes;
import com.farmacia.entities1.Detalle_ventas;
import com.farmacia.entities1.EnvaseProducto;
import com.farmacia.entities1.Faltantes;
import com.farmacia.entities1.Iva;
import com.farmacia.entities1.Laboratorio;
import com.farmacia.entities1.ListarDetalleVentas;
import com.farmacia.entities1.Listar_usuario;
import com.farmacia.entities1.MarcaProducto;
import com.farmacia.entities1.MedidaProducto;
import com.farmacia.entities1.Nombre_local;
import com.farmacia.entities1.Persona;
import com.farmacia.entities1.Precios;
import com.farmacia.entities1.Productos_Stock;
import com.farmacia.entities1.Punto_venta;
import com.farmacia.entities1.Punto_venta_usuario;
import com.farmacia.entities1.TipoProducto;
import com.farmacia.fecha.Fecha;
import com.farmacia.join_entidades.JoinListarCabeceraVenta;
import com.farmacia.join_entidades.JoinListarDetalleNotaPedido;
import com.farmacia.join_entidades.JoinListarNotaPedidosCabecera;
import com.farmacia.join_entidades.JoinListarProductosVentas;
import com.farmacia.join_entidades.ListarJoinPrecioNotaPedido;
import com.farmacia.join_entidades.ListarJoinProveedorNotaPedido;
import com.farmacia.join_entidades.listarJoinProductosNotaPedidos;
import java.awt.Color;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author alumno
 */
public class Tablas {

//<<<<<<< HEAD
    private boolean[] editable = {false, false, false, false,false, false,false,true};
//>>>>>>> origin/JoseLuis
    static DefaultTableModel model;

    public static DefaultTableModel VaciarTabla(JTable tabla) {
        DefaultTableModel lab
                = (DefaultTableModel) tabla.getModel();
        while (lab.getRowCount() > 0) {
            lab.removeRow(0);
        }
        return lab;

    }

    public static void listarLab(ArrayList<Laboratorio> lista, JTable Tabla) {
        int[] a = {15, 30, 30, 10, 15};
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        DefaultTableCellRenderer tcr1 = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        tcr1.setHorizontalAlignment(SwingConstants.RIGHT);
        model = Tablas.VaciarTabla(Tabla);
        String[] Co = {"RUC", "Nombre", "Direccion", "Telefono", "Fecha"};
        //   Date[] Ca = {Date.valueOf("Fecha")};
        String[] Filas = new String[5];
        //  Date[] Fila = new Date [1];
        model = new DefaultTableModel(null, Co);
        //  laboratorio = new DefaultTableModel(null, Ca);
        Tabla.setShowGrid(true);
        for (int i = 0; i < lista.size(); i++) {
            Filas[0] = lista.get(i).getRUC();
            Filas[1] = lista.get(i).getNombre();
            Filas[2] = lista.get(i).getDireccion();
            Filas[3] = lista.get(i).getTelefono();
            Filas[4] = Fecha.getStringFecha(lista.get(i).getFecha());
            model.addRow(Filas);
            //     laboratorio.addRow(Fila);
            Tabla.setModel(model);
            Tabla.getColumnModel().getColumn(0).setPreferredWidth(a[0]);
            Tabla.getColumnModel().getColumn(0).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(1).setPreferredWidth(a[1]);
            Tabla.getColumnModel().getColumn(1).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(2).setPreferredWidth(a[2]);
            Tabla.getColumnModel().getColumn(2).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(3).setPreferredWidth(a[3]);
            Tabla.getColumnModel().getColumn(3).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(4).setPreferredWidth(a[4]);
            Tabla.getColumnModel().getColumn(4).setCellRenderer(tcr);
        }

    }
    /// 17/11/2018 jefferson Anchundia modulo Faltantes 15:15:00  

    public static void cargarJoinProducto(JTable Tabla, ArrayList<FaltantesCabeceraDetalles> lista) {

        int[] a = {10, 30, 32, 52, 15, 30};
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        DefaultTableCellRenderer tcr1 = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        tcr1.setHorizontalAlignment(SwingConstants.RIGHT);
        model = Tablas.VaciarTabla(Tabla);
        String[] Co = {"CODIGO", "MARCA", "PRODUCTO", "DESCRIPCION", "CANTIDAD", "ESTADO"};
        String[] Filas = new String[6];
        model = new DefaultTableModel(null, Co);
        Tabla.setShowGrid(true);
        for (int i = 0; i < lista.size(); i++) {
            Filas[0] = "" + lista.get(i).getId_productos().toString();
            Filas[1] = lista.get(i).getMarca();
            Filas[2] = lista.get(i).getNombre();
            Filas[3] = lista.get(i).getDescripcion();
            Filas[4] = lista.get(i).getCantidad().toString();
            Filas[5] = lista.get(i).getEstado();

            model.addRow(Filas);
            Tabla.setModel(model);
            Tabla.getColumnModel().getColumn(0).setPreferredWidth(a[0]);
            Tabla.getColumnModel().getColumn(0).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(1).setPreferredWidth(a[1]);
            Tabla.getColumnModel().getColumn(1).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(2).setPreferredWidth(a[2]);
            Tabla.getColumnModel().getColumn(2).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(3).setPreferredWidth(a[3]);
            Tabla.getColumnModel().getColumn(3).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(4).setPreferredWidth(a[4]);
            Tabla.getColumnModel().getColumn(4).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(5).setPreferredWidth(a[5]);
            Tabla.getColumnModel().getColumn(5).setCellRenderer(tcr);
        }

    }
/////////////////////////////////////////
//    public static void cargarJoinProductoDetallesFaltantes(JTable Tabla,ArrayList<joinProductoDetallesFaltantes> lista) {
//       
//        int[] a = {10, 30, 32, 52,15,15};
//        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
//        DefaultTableCellRenderer tcr1 = new DefaultTableCellRenderer();
//        tcr.setHorizontalAlignment(SwingConstants.CENTER);
//        tcr1.setHorizontalAlignment(SwingConstants.RIGHT);
//        model = Tablas.VaciarTabla(Tabla);
//        String[] Co = {"CODIGO", "MARCA","TIPO", "PRODUCTO","CANTIDAD","ESTADO"};
//        String[] Filas = new String[6];
//        model = new DefaultTableModel(null, Co);
//        Tabla.setShowGrid(true);
//        for (int i = 0; i < lista.size(); i++) {
//            Filas[0] = "" + lista.get(i).getId_producto().toString();
//            Filas[1] = lista.get(i).getMarca();
//            Filas[2] = lista.get(i).getNombre_tipo();
//            Filas[3] = lista.get(i).getNombre_producto();
//            Filas[4] = lista.get(i).getCantidad().toString();
//            Filas[5] = lista.get(i).getEstado();
//            model.addRow(Filas);
//            Tabla.setModel(model);
//            Tabla.getColumnModel().getColumn(0).setPreferredWidth(a[0]);
//            Tabla.getColumnModel().getColumn(0).setCellRenderer(tcr);
//            Tabla.getColumnModel().getColumn(1).setPreferredWidth(a[1]);
//            Tabla.getColumnModel().getColumn(1).setCellRenderer(tcr);
//            Tabla.getColumnModel().getColumn(2).setPreferredWidth(a[2]);
//            Tabla.getColumnModel().getColumn(2).setCellRenderer(tcr);
//            Tabla.getColumnModel().getColumn(3).setPreferredWidth(a[3]);
//            Tabla.getColumnModel().getColumn(3).setCellRenderer(tcr);
//            Tabla.getColumnModel().getColumn(4).setPreferredWidth(a[4]);
//            Tabla.getColumnModel().getColumn(4).setCellRenderer(tcr);
//            Tabla.getColumnModel().getColumn(5).setPreferredWidth(a[5]);
//            Tabla.getColumnModel().getColumn(5).setCellRenderer(tcr);
//        } 
//
//    }
/////////////////////////////// cargar productos en ordencompra

    public static void cargarJoinProductosMCompra(JTable Tabla, ArrayList<listarJoinProductosCompras> lista) {

        int[] a = {10, 30, 32, 52, 15, 30};
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        DefaultTableCellRenderer tcr1 = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        tcr1.setHorizontalAlignment(SwingConstants.RIGHT);
        model = Tablas.VaciarTabla(Tabla);
        String[] Co = {"CODIGO", "PRODUCTO", "TIPO", "MEDIDA", "ENVASE", "MARCA"};
        String[] Filas = new String[6];
        model = new DefaultTableModel(null, Co);
        Tabla.setShowGrid(true);
        for (int i = 0; i < lista.size(); i++) {
            Filas[0] = "" + lista.get(i).getId_productos().toString();
            Filas[1] = lista.get(i).getNombreProductos();
            Filas[2] = lista.get(i).getNombreTipo();
            Filas[3] = lista.get(i).getNombreMedida();
            Filas[4] = lista.get(i).getNombreEnvase();
            Filas[5] = lista.get(i).getNombreMarca();
            model.addRow(Filas);
            Tabla.setModel(model);
            Tabla.getColumnModel().getColumn(0).setPreferredWidth(a[0]);
            Tabla.getColumnModel().getColumn(0).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(1).setPreferredWidth(a[1]);
            Tabla.getColumnModel().getColumn(1).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(2).setPreferredWidth(a[2]);
            Tabla.getColumnModel().getColumn(2).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(3).setPreferredWidth(a[3]);
            Tabla.getColumnModel().getColumn(3).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(4).setPreferredWidth(a[4]);
            Tabla.getColumnModel().getColumn(4).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(5).setPreferredWidth(a[5]);
            Tabla.getColumnModel().getColumn(5).setCellRenderer(tcr);
        }

    }

    public static void cargarJoinProductoIngresoCompras(JTable Tabla, ArrayList<joinProductoDetallesFaltantes> lista) {

        int[] a = {10, 30, 32, 52, 15, 30};
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        DefaultTableCellRenderer tcr1 = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        tcr1.setHorizontalAlignment(SwingConstants.RIGHT);
        model = Tablas.VaciarTabla(Tabla);
        String[] Co = {"CODIGO", "PRODUCTO", "MARCA", "TIPO", "MEDIDA", "CANTIDAD"};
        String[] Filas = new String[6];
        model = new DefaultTableModel(null, Co);
        Tabla.setShowGrid(true);
        for (int i = 0; i < lista.size(); i++) {
            Filas[0] = "" + lista.get(i).getId_producto().toString();
            Filas[1] = lista.get(i).getNombre_producto();
            Filas[2] = lista.get(i).getMarca();
            Filas[3] = lista.get(i).getNombre_tipo();
            Filas[4] = lista.get(i).getMedida();
            Filas[5] = lista.get(i).getCantidad().toString();
            model.addRow(Filas);
            Tabla.setModel(model);
            Tabla.getColumnModel().getColumn(0).setPreferredWidth(a[0]);
            Tabla.getColumnModel().getColumn(0).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(1).setPreferredWidth(a[1]);
            Tabla.getColumnModel().getColumn(1).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(2).setPreferredWidth(a[2]);
            Tabla.getColumnModel().getColumn(2).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(3).setPreferredWidth(a[3]);
            Tabla.getColumnModel().getColumn(3).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(4).setPreferredWidth(a[4]);
            Tabla.getColumnModel().getColumn(4).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(5).setPreferredWidth(a[5]);
            Tabla.getColumnModel().getColumn(5).setCellRenderer(tcr);
        }

    }

    public static void cargarFaltantes(JTable Tabla, ArrayList<joinProductoDetallesFaltantes> lista) {
//        for (int i = 0; i < lista.size(); i++) {
//             System.out.println("tabla  "+lista.get(i).getCantidad().toString());
//        }
//        
        //DefaultTableModel model1;
        int[] a = {10, 30, 32, 52, 15};
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        DefaultTableCellRenderer tcr1 = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        tcr1.setHorizontalAlignment(SwingConstants.RIGHT);
        model = Tablas.VaciarTabla(Tabla);
        String[] Co = {"CODIGO", "TIPO", "MARCA", "PRODUCTO", "CANTIDAD"};
        String[] Filas = new String[5];
        model = new DefaultTableModel(null, Co);
        Tabla.setShowGrid(true);
        for (int i = 0; i < lista.size(); i++) {
            Filas[0] = "" + lista.get(i).getId_producto().toString();
            Filas[1] = lista.get(i).getNombre_tipo();
            Filas[2] = lista.get(i).getMarca();
            Filas[3] = lista.get(i).getNombre_producto();
            Filas[4] = lista.get(i).getCantidad().toString();

            model.addRow(Filas);
            Tabla.setModel(model);
            Tabla.getColumnModel().getColumn(0).setPreferredWidth(a[0]);
            Tabla.getColumnModel().getColumn(0).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(1).setPreferredWidth(a[1]);
            Tabla.getColumnModel().getColumn(1).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(2).setPreferredWidth(a[2]);
            Tabla.getColumnModel().getColumn(2).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(3).setPreferredWidth(a[3]);
            Tabla.getColumnModel().getColumn(3).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(4).setPreferredWidth(a[4]);
            Tabla.getColumnModel().getColumn(4).setCellRenderer(tcr);
        }

    }

    public static void CargarJoinProveedores(JTable Tabla, ArrayList<ListarJoinProveedor> lista) {

        int[] a = {30, 20, 55, 52, 52, 52, 52, 15};
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        DefaultTableCellRenderer tcr1 = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        tcr1.setHorizontalAlignment(SwingConstants.RIGHT);
        model = Tablas.VaciarTabla(Tabla);
        String[] Co = {"CODIGO", "RUC", "NOMBRE", "REPRESENTANTE", "DIRECCION", "TELEFONO", "MAIL", "CLASE"};
        String[] Filas = new String[8];
        model = new DefaultTableModel(null, Co);
        Tabla.setShowGrid(true);
        for (int i = 0; i < lista.size(); i++) {
            Filas[0] = "" + lista.get(i).getId_proveedor().toString();
            Filas[1] = lista.get(i).getCedula_ruc();
            Filas[2] = lista.get(i).getEntidad();
            Filas[3] = lista.get(i).getRepresentante();
            Filas[4] = lista.get(i).getDireccion();
            Filas[5] = lista.get(i).getTelefono();
            Filas[6] = lista.get(i).getMail();
            Filas[7] = lista.get(i).getClase();
            model.addRow(Filas);
            Tabla.setModel(model);
            Tabla.getColumnModel().getColumn(0).setPreferredWidth(a[0]);
            Tabla.getColumnModel().getColumn(0).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(1).setPreferredWidth(a[1]);
            Tabla.getColumnModel().getColumn(1).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(2).setPreferredWidth(a[2]);
            Tabla.getColumnModel().getColumn(2).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(3).setPreferredWidth(a[3]);
            Tabla.getColumnModel().getColumn(3).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(4).setPreferredWidth(a[4]);
            Tabla.getColumnModel().getColumn(4).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(5).setPreferredWidth(a[5]);
            Tabla.getColumnModel().getColumn(5).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(6).setPreferredWidth(a[6]);
            Tabla.getColumnModel().getColumn(6).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(6).setPreferredWidth(a[7]);
            Tabla.getColumnModel().getColumn(6).setCellRenderer(tcr);
        }

    }
//    public static void CargarJoinRegistrosdeNota(JTable Tabla,ArrayList<ListarNotas> lista) {
//       
//        int[] a = {10, 55, 52, 52, 52, 52, 15};
//        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
//        DefaultTableCellRenderer tcr1 = new DefaultTableCellRenderer();
//        tcr.setHorizontalAlignment(SwingConstants.CENTER);
//        tcr1.setHorizontalAlignment(SwingConstants.RIGHT);
//        model = Tablas.VaciarTabla(Tabla);
//        String[] Co = {"N#", "CODIGO DE PROVEEDOR", "NOMBRE", "REPRESENTANTE","FECHA DE CREACION","HORA","ESTADO"};
//        String[] Filas = new String[7];
//        model = new DefaultTableModel(null, Co);
//        Tabla.setShowGrid(true);
//        for (int i = 0; i < lista.size(); i++) {
//            Filas[0] = "" + lista.get(i).getId_cabecera_nota_pedidos().toString();
//            Filas[1] = lista.get(i).getId_proveedor().toString();
//            Filas[2] = lista.get(i).getNombre();
//            Filas[3] = lista.get(i).getRepresentante();
//            Filas[4] = lista.get(i).getFecha_creacion().toString();
//            Filas[5] = lista.get(i).getHora().toString();
//            Filas[6] = lista.get(i).getEstado();
//          
//            model.addRow(Filas);
//            Tabla.setModel(model);
//            Tabla.getColumnModel().getColumn(0).setPreferredWidth(a[0]);
//            Tabla.getColumnModel().getColumn(0).setCellRenderer(tcr);
//            Tabla.getColumnModel().getColumn(1).setPreferredWidth(a[1]);
//            Tabla.getColumnModel().getColumn(1).setCellRenderer(tcr);
//            Tabla.getColumnModel().getColumn(2).setPreferredWidth(a[2]);
//            Tabla.getColumnModel().getColumn(2).setCellRenderer(tcr);
//            Tabla.getColumnModel().getColumn(3).setPreferredWidth(a[3]);
//            Tabla.getColumnModel().getColumn(3).setCellRenderer(tcr);
//            Tabla.getColumnModel().getColumn(4).setPreferredWidth(a[4]);
//            Tabla.getColumnModel().getColumn(4).setCellRenderer(tcr);
//            Tabla.getColumnModel().getColumn(5).setPreferredWidth(a[5]);
//            Tabla.getColumnModel().getColumn(5).setCellRenderer(tcr);
//            Tabla.getColumnModel().getColumn(6).setPreferredWidth(a[6]);
//            Tabla.getColumnModel().getColumn(6).setCellRenderer(tcr);
//        } 
//
//    }

    public static void cargarFiltroProductos(JTable Tabla, ArrayList<listarJoinProductosCompras> lista) {

        int[] a = {10, 30, 32, 52, 15, 30};
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        DefaultTableCellRenderer tcr1 = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        tcr1.setHorizontalAlignment(SwingConstants.RIGHT);
        model = Tablas.VaciarTabla(Tabla);
        String[] Co = {"CODIGO", "PRODUCTO", "TIPO", "MEDIDA", "ENVASE", "MARCA"};
        String[] Filas = new String[6];
        model = new DefaultTableModel(null, Co);
        Tabla.setShowGrid(true);
        for (int i = 0; i < lista.size(); i++) {
            Filas[0] = "" + lista.get(i).getId_productos().toString();
            Filas[1] = lista.get(i).getNombreProductos();
            Filas[2] = lista.get(i).getNombreTipo();
            Filas[3] = lista.get(i).getNombreMedida();
            Filas[4] = lista.get(i).getNombreEnvase();
            Filas[5] = lista.get(i).getNombreMarca();
            model.addRow(Filas);
            Tabla.setModel(model);
            Tabla.getColumnModel().getColumn(0).setPreferredWidth(a[0]);
            Tabla.getColumnModel().getColumn(0).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(1).setPreferredWidth(a[1]);
            Tabla.getColumnModel().getColumn(1).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(2).setPreferredWidth(a[2]);
            Tabla.getColumnModel().getColumn(2).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(3).setPreferredWidth(a[3]);
            Tabla.getColumnModel().getColumn(3).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(4).setPreferredWidth(a[4]);
            Tabla.getColumnModel().getColumn(4).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(5).setPreferredWidth(a[5]);
            Tabla.getColumnModel().getColumn(5).setCellRenderer(tcr);
        }

    }

    ///////////maquilon proveedor
    public static void listarProveedor(ArrayList<ListarJoinProveedor> lista, JTable Tabla) {
        int[] a = {10, 30, 32, 52};
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        DefaultTableCellRenderer tcr1 = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        tcr1.setHorizontalAlignment(SwingConstants.RIGHT);
        model = Tablas.VaciarTabla(Tabla);
        String[] Co = {"Cedula_Ruc", "Entidad", "Contacto", "Fecha de Ingreso"};
        String[] Filas = new String[4];
        model = new DefaultTableModel(null, Co);
        Tabla.setShowGrid(true);
        for (int i = 0; i < lista.size(); i++) {
            Filas[0] = lista.get(i).getCedula_ruc();
            Filas[1] = lista.get(i).getEntidad();
            Filas[2] = lista.get(i).getRepresentante();
            Filas[3] = (lista.get(i).getFecha_registro()).toString();
            model.addRow(Filas);
            Tabla.setModel(model);
            Tabla.getColumnModel().getColumn(0).setPreferredWidth(a[0]);
            Tabla.getColumnModel().getColumn(0).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(1).setPreferredWidth(a[1]);
            Tabla.getColumnModel().getColumn(1).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(2).setPreferredWidth(a[2]);
            Tabla.getColumnModel().getColumn(2).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(3).setPreferredWidth(a[3]);
            Tabla.getColumnModel().getColumn(3).setCellRenderer(tcr);
        }

    }

    public static void cargarJoinProductosFaltantes(JTable Tabla, ArrayList<FaltantesCabeceraDetalles> lista) {//piguiFaltantes

        int[] a = {10, 30, 32, 52, 15, 30};
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        DefaultTableCellRenderer tcr1 = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        tcr1.setHorizontalAlignment(SwingConstants.RIGHT);
        model = Tablas.VaciarTabla(Tabla);
        String[] Co = {"CODIGO", "MARCA", "PRODUCTO", "DESCRIPCION", "CANTIDAD", "ESTADO"};
        String[] Filas = new String[6];
        model = new DefaultTableModel(null, Co);
        Tabla.setShowGrid(true);
        for (int i = 0; i < lista.size(); i++) {
            Filas[0] = "" + lista.get(i).getId_productos().toString();
            Filas[1] = lista.get(i).getMarca();
            Filas[2] = lista.get(i).getNombre();
            Filas[3] = lista.get(i).getDescripcion();
            Filas[4] = lista.get(i).getCantidad().toString();
            Filas[5] = lista.get(i).getEstado();

            model.addRow(Filas);
            Tabla.setModel(model);
            Tabla.getColumnModel().getColumn(0).setPreferredWidth(a[0]);
            Tabla.getColumnModel().getColumn(0).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(1).setPreferredWidth(a[1]);
            Tabla.getColumnModel().getColumn(1).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(2).setPreferredWidth(a[2]);
            Tabla.getColumnModel().getColumn(2).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(3).setPreferredWidth(a[3]);
            Tabla.getColumnModel().getColumn(3).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(4).setPreferredWidth(a[4]);
            Tabla.getColumnModel().getColumn(4).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(5).setPreferredWidth(a[5]);
            Tabla.getColumnModel().getColumn(5).setCellRenderer(tcr);
        }

    }

    public static void listarClientes(ArrayList<Clientes> lista, JTable Tabla) {
        int[] a = {10, 30, 30, 30, 15};
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        DefaultTableCellRenderer tcr1 = new DefaultTableCellRenderer();
        tcr1.setHorizontalAlignment(SwingConstants.CENTER);
        tcr.setHorizontalAlignment(SwingConstants.RIGHT);
        model = Tablas.VaciarTabla(Tabla);
        String[] Co = {"CEDULA", "NOMBRE", "APELLIDO", "DIRECCION", "FECHA REGISTRO"};
        String[] Filas = new String[5];
        model = new DefaultTableModel(null, Co);
        Tabla.setShowGrid(true);
        for (int i = 0; i < lista.size(); i++) {
            Filas[0] = lista.get(i).getCedula();
            Filas[1] = lista.get(i).getNombre();
            Filas[2] = lista.get(i).getApellido();
            Filas[3] = lista.get(i).getDireccion();
            Filas[4] = Fecha.getStringFecha(lista.get(i).getFecha_reg());
            model.addRow(Filas);
            Tabla.setModel(model);
            Tabla.getColumnModel().getColumn(0).setPreferredWidth(a[0]);
            Tabla.getColumnModel().getColumn(0).setCellRenderer(tcr1);
            Tabla.getColumnModel().getColumn(1).setPreferredWidth(a[1]);
            Tabla.getColumnModel().getColumn(1).setCellRenderer(tcr1);
            Tabla.getColumnModel().getColumn(2).setPreferredWidth(a[2]);
            Tabla.getColumnModel().getColumn(2).setCellRenderer(tcr1);
            Tabla.getColumnModel().getColumn(3).setPreferredWidth(a[3]);
            Tabla.getColumnModel().getColumn(3).setCellRenderer(tcr1);
            Tabla.getColumnModel().getColumn(4).setPreferredWidth(a[4]);
            Tabla.getColumnModel().getColumn(4).setCellRenderer(tcr1);
        }

    }

    public static void filtro(String valor, JTable Tabla) {
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(model);
        Tabla.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter("(?i)" + valor));
    }

    public static void listarTipoProducto(ArrayList<TipoProducto> lista, JTable Tabla) {
        int[] a = {10, 30, 32, 52,};
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        DefaultTableCellRenderer tcr1 = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        tcr1.setHorizontalAlignment(SwingConstants.RIGHT);
        model = Tablas.VaciarTabla(Tabla);
        String[] Co = {"CODIGO", "Tipo"};
        String[] Filas = new String[2];
        model = new DefaultTableModel(null, Co);
        Tabla.setShowGrid(true);
        for (int i = 0; i < lista.size(); i++) {
            Filas[0] = String.valueOf(lista.get(i).getId_tipo());
            Filas[1] = lista.get(i).getNombreTipo();
            model.addRow(Filas);
            Tabla.setModel(model);
            Tabla.getColumnModel().getColumn(0).setPreferredWidth(a[0]);
            Tabla.getColumnModel().getColumn(0).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(1).setPreferredWidth(a[1]);
            Tabla.getColumnModel().getColumn(1).setCellRenderer(tcr);
        }

    }

    public static void listarEnvase(ArrayList<EnvaseProducto> lista, JTable Tabla) {
        int[] a = {10, 30, 32, 52,};
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        DefaultTableCellRenderer tcr1 = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        tcr1.setHorizontalAlignment(SwingConstants.RIGHT);
        model = Tablas.VaciarTabla(Tabla);
        String[] Co = {"CODIGO", "Tipo"};
        String[] Filas = new String[2];
        model = new DefaultTableModel(null, Co);
        Tabla.setShowGrid(true);
        for (int i = 0; i < lista.size(); i++) {
            Filas[0] = String.valueOf(lista.get(i).getId_presentaciones());
            Filas[1] = lista.get(i).getNombreEnvase();
            model.addRow(Filas);
            Tabla.setModel(model);
            Tabla.getColumnModel().getColumn(0).setPreferredWidth(a[0]);
            Tabla.getColumnModel().getColumn(0).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(1).setPreferredWidth(a[1]);
            Tabla.getColumnModel().getColumn(1).setCellRenderer(tcr);
        }

    }

    public static void listarMedidas(ArrayList<MedidaProducto> lista, JTable Tabla) {
        int[] a = {15, 30};
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        DefaultTableCellRenderer tcr1 = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        tcr1.setHorizontalAlignment(SwingConstants.RIGHT);
        model = VaciarTabla(Tabla);
        String[] Co = {"CODIGO", "Medidas"};
        //   Date[] Ca = {Date.valueOf("Fecha")};
        String[] Filas = new String[5];
        //  Date[] Fila = new Date [1];
        model = new DefaultTableModel(null, Co);
        //  laboratorio = new DefaultTableModel(null, Ca);
        Tabla.setShowGrid(true);
        for (int i = 0; i < lista.size(); i++) {
            Filas[0] = lista.get(i).getId_medidas().toString();
            Filas[1] = lista.get(i).getNombre_medida();

            model.addRow(Filas);
            //     laboratorio.addRow(Fila);
            Tabla.setModel(model);
            Tabla.getColumnModel().getColumn(0).setPreferredWidth(a[0]);
            Tabla.getColumnModel().getColumn(0).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(1).setPreferredWidth(a[1]);
            Tabla.getColumnModel().getColumn(1).setCellRenderer(tcr);

        }

    }

    public static void listarMarcas(ArrayList<MarcaProducto> lista, JTable Tabla) {
        int[] a = {15, 30};
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        DefaultTableCellRenderer tcr1 = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        tcr1.setHorizontalAlignment(SwingConstants.RIGHT);
        model = VaciarTabla(Tabla);
        String[] Co = {"ID", "Marcas"};
        //   Date[] Ca = {Date.valueOf("Fecha")};
        String[] Filas = new String[5];
        //  Date[] Fila = new Date [1];
        model = new DefaultTableModel(null, Co);
        //  laboratorio = new DefaultTableModel(null, Ca);
        Tabla.setShowGrid(true);
        for (int i = 0; i < lista.size(); i++) {
            Filas[0] = lista.get(i).getId_Marcas().toString();
            Filas[1] = lista.get(i).getNombreMarca();
            model.addRow(Filas);
            Tabla.setModel(model);
            Tabla.getColumnModel().getColumn(0).setPreferredWidth(a[0]);
            Tabla.getColumnModel().getColumn(0).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(1).setPreferredWidth(a[1]);
            Tabla.getColumnModel().getColumn(1).setCellRenderer(tcr);

        }

    }

    public static void CargarJoinListadoCabeceraNotaPedidos(JTable Tabla, ArrayList<JoinListarNotaPedidosCabecera> lista) {

        int[] a = {5, 5, 52, 90, 150, 110, 15, 50, 10};
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        DefaultTableCellRenderer tcr1 = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        tcr1.setHorizontalAlignment(SwingConstants.RIGHT);
        model = Tablas.VaciarTabla(Tabla);
        String[] Co = {"N", "CODIGO", "PROVEEDOR", "REPRESENTANTE", "TELEFONO", "FECHA DE CREACION", "IVA", "DESCUENTO", "TOTAL"};
        String[] Filas = new String[9];
        model = new DefaultTableModel(null, Co);
        Tabla.setShowGrid(true);
        for (int i = 0; i < lista.size(); i++) {
            Filas[0] = "" + lista.get(i).getId_cabecera_nota_pedidos().toString();
            Filas[1] = lista.get(i).getId_proveedor().toString();
            Filas[2] = lista.get(i).getEntidad();
            Filas[3] = lista.get(i).getRepresentante();
            Filas[4] = lista.get(i).getTelefono();
            String j = Fecha.getStringFecha1(lista.get(i).getFecha_creacion());
            Filas[5] = Fecha.getStringFecha(Date.valueOf(j));
//            Filas[5] = lista.get(i).getFecha_creacion().toString();
            Filas[6] = Formato_Numeros.formatoNumero("" + lista.get(i).getIva().toString());
            Filas[7] = Formato_Numeros.formatoNumero("" + lista.get(i).getDescuento().toString());
            Filas[8] = Formato_Numeros.formatoNumero("" + lista.get(i).getTotal().toString());

            model.addRow(Filas);
            Tabla.setModel(model);
            Tabla.getColumnModel().getColumn(0).setPreferredWidth(a[0]);
            Tabla.getColumnModel().getColumn(0).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(1).setPreferredWidth(a[1]);
            Tabla.getColumnModel().getColumn(1).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(2).setPreferredWidth(a[2]);
            Tabla.getColumnModel().getColumn(2).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(3).setPreferredWidth(a[3]);
            Tabla.getColumnModel().getColumn(3).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(4).setPreferredWidth(a[4]);
            Tabla.getColumnModel().getColumn(4).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(5).setPreferredWidth(a[5]);
            Tabla.getColumnModel().getColumn(5).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(6).setPreferredWidth(a[6]);
            Tabla.getColumnModel().getColumn(6).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(7).setPreferredWidth(a[7]);
            Tabla.getColumnModel().getColumn(7).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(8).setPreferredWidth(a[8]);
            Tabla.getColumnModel().getColumn(8).setCellRenderer(tcr);
        }

    }

    public static void CargarJoinListaCabeceraPedido(JTable Tabla, ArrayList<JoinListarNotaPedidosCabecera> lista) {

        int[] a = {50, 80, 180, 190, 180, 180, 100, 100};
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        DefaultTableCellRenderer tcr1 = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        tcr1.setHorizontalAlignment(SwingConstants.RIGHT);
        model = Tablas.VaciarTabla(Tabla);
        String[] Co = {"N° ", "CODIGO", "PROVEEDOR", "REPRESENTANTE", "TELEFONO", "FECHA DE CREACION", "PLAZO", "TOTAL"};
        String[] Filas = new String[9];
        model = new DefaultTableModel(null, Co);
        Tabla.setShowGrid(true);
        for (int i = 0; i < lista.size(); i++) {
            Filas[0] = "" + lista.get(i).getId_cabecera_nota_pedidos().toString();
            Filas[1] = lista.get(i).getId_proveedor().toString();
            Filas[2] = lista.get(i).getEntidad();
            Filas[3] = lista.get(i).getRepresentante();
            Filas[4] = lista.get(i).getTelefono();
            String j = Fecha.getStringFecha1(lista.get(i).getFecha_creacion());
            System.out.println(" fec " + j);
            Filas[5] = Fecha.getStringFecha(Date.valueOf(j));
            //   Filas[5] = lista.get(i).getFecha_creacion();
            Filas[6] = "" + lista.get(i).getPlazo();
            Filas[7] = Formato_Numeros.formatoNumero("" + lista.get(i).getTotal().toString());

            model.addRow(Filas);
            Tabla.setModel(model);
            Tabla.getColumnModel().getColumn(0).setPreferredWidth(a[0]);
            Tabla.getColumnModel().getColumn(0).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(1).setPreferredWidth(a[1]);
            Tabla.getColumnModel().getColumn(1).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(2).setPreferredWidth(a[2]);
            Tabla.getColumnModel().getColumn(2).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(3).setPreferredWidth(a[3]);
            Tabla.getColumnModel().getColumn(3).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(4).setPreferredWidth(a[4]);
            Tabla.getColumnModel().getColumn(4).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(5).setPreferredWidth(a[5]);
            Tabla.getColumnModel().getColumn(5).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(6).setPreferredWidth(a[6]);
            Tabla.getColumnModel().getColumn(6).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(7).setPreferredWidth(a[7]);
            Tabla.getColumnModel().getColumn(7).setCellRenderer(tcr);

        }

    }
//cargarJoinProductoIngresoNotas

    public static String formatoNumero(String valor) {   ////////////////   1

        DecimalFormat formato = new DecimalFormat("#,###.00");
        String valorFormateado = formato.format(Double.parseDouble(valor));

        if (valorFormateado.charAt(0) == ',') {
            String h = "0" + valorFormateado;
            valorFormateado = h;
            System.out.println("H" + h);
        }

        return valorFormateado;
    }

    public static void cargarJoinProductoIngresoNotas(JTable Tabla, ArrayList<joinProductoDetallesFaltantes> lista) {

        int[] a = {10, 30, 32, 70, 15, 30, 10, 20, 30, 30, 5, 30};
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        DefaultTableCellRenderer tcr1 = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        tcr1.setHorizontalAlignment(SwingConstants.RIGHT);
        model = Tablas.VaciarTabla(Tabla);
        String[] Co = {"CODIGO", "MARCA", "TIPO", "PRODUCTO", "ENVASE", "MEDIDA", "BONO", "CANTIDAD", "PRECIO", "DESCUENTO", "IVA", "TOTAL"};
        String[] Filas = new String[12];
        model = new DefaultTableModel(null, Co);
        Tabla.setShowGrid(true);
        BigDecimal PrecioBono = new BigDecimal("0.00");
        for (int i = 0; i < lista.size(); i++) {

            Filas[0] = "" + lista.get(i).getId_producto().toString();
            Filas[1] = lista.get(i).getMarca();
            Filas[2] = lista.get(i).getNombre_tipo();
            Filas[3] = lista.get(i).getNombre_producto();
            Filas[4] = lista.get(i).getEnvase();
            Filas[5] = lista.get(i).getMedida();
            Filas[6] = lista.get(i).getBono().toString();
            Filas[7] = lista.get(i).getCantidad().toString();

            Filas[8] = formatoNumero(lista.get(i).getPrecioBono().setScale(2, BigDecimal.ROUND_HALF_UP).toString());
            Filas[9] = formatoNumero(lista.get(i).getValor_descuento().setScale(2, BigDecimal.ROUND_HALF_UP).toString());
            Filas[10] = formatoNumero(lista.get(i).getPrecioiva().setScale(2, BigDecimal.ROUND_HALF_UP).toString());
            Filas[11] = formatoNumero(lista.get(i).getImporte().setScale(2, BigDecimal.ROUND_HALF_UP).toString());

            model.addRow(Filas);
            Tabla.setModel(model);
            Tabla.getColumnModel().getColumn(0).setPreferredWidth(a[0]);
            Tabla.getColumnModel().getColumn(0).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(1).setPreferredWidth(a[1]);
            Tabla.getColumnModel().getColumn(1).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(2).setPreferredWidth(a[2]);
            Tabla.getColumnModel().getColumn(2).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(3).setPreferredWidth(a[3]);
            Tabla.getColumnModel().getColumn(3).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(4).setPreferredWidth(a[4]);
            Tabla.getColumnModel().getColumn(4).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(5).setPreferredWidth(a[5]);
            Tabla.getColumnModel().getColumn(5).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(6).setPreferredWidth(a[6]);
            Tabla.getColumnModel().getColumn(6).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(7).setPreferredWidth(a[7]);
            Tabla.getColumnModel().getColumn(7).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(8).setPreferredWidth(a[8]);
            Tabla.getColumnModel().getColumn(8).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(9).setPreferredWidth(a[9]);
            Tabla.getColumnModel().getColumn(9).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(10).setPreferredWidth(a[10]);
            Tabla.getColumnModel().getColumn(10).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(11).setPreferredWidth(a[11]);
            Tabla.getColumnModel().getColumn(11).setCellRenderer(tcr);
        }
    }

//    public static void cargarJoinProductoIngresoNotas(JTable Tabla, ArrayList<joinProductoDetallesFaltantes> lista) {
//
//        int[] a = {10, 30, 32, 70, 15, 30, 10, 10, 10, 20, 10, 5};
//        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
//        DefaultTableCellRenderer tcr1 = new DefaultTableCellRenderer();
//        tcr.setHorizontalAlignment(SwingConstants.CENTER);
//        tcr1.setHorizontalAlignment(SwingConstants.RIGHT);
//        model = Tablas.VaciarTabla(Tabla);
//        String[] Co = {"CODIGO", "MARCA", "TIPO", "PRODUCTO", "ENVASE", "MEDIDA", "BONO", "CANTIDAD", "PRECIO", "DESCUENTO", "IVA", "TOTAL"};
//        String[] Filas = new String[12];
//        model = new DefaultTableModel(null, Co);
//        Tabla.setShowGrid(true);
//
//        for (int i = 0; i < lista.size(); i++) {
//            Integer Cant = lista.get(i).getCantidad();
//            BigDecimal Cantidad = new BigDecimal(Cant);
//            BigDecimal Precio = lista.get(i).getPrecios();
//            BigDecimal Subtotal = Cantidad.multiply(Precio);
//            Integer Bono = lista.get(i).getBono();
//            BigDecimal Bono1 = new BigDecimal(Bono);
//            BigDecimal CantidadTotal = Cantidad.add(Bono1);
//            BigDecimal PrecioBono = Subtotal.divide(CantidadTotal);
//            BigDecimal PorcentajeDesc = lista.get(i).getPorcentaje_descuento();
//            BigDecimal cien = new BigDecimal("100");
//            BigDecimal ValorDes = Subtotal.multiply(PorcentajeDesc).divide(cien);
//            Filas[0] = "" + lista.get(i).getId_producto().toString();
//            Filas[1] = lista.get(i).getMarca();
//            Filas[2] = lista.get(i).getNombre_tipo();
//            Filas[3] = lista.get(i).getNombre_producto();
//            Filas[4] = lista.get(i).getEnvase();
//            Filas[5] = lista.get(i).getMedida();
//            Filas[6] = "" + Bono;
//            Filas[7] = "" + Cant;
//            Filas[8] = "" + PrecioBono;
//            Filas[9] = "" + ValorDes;
//            if (lista.get(i).getIva().equals("NO")) {
//                Filas[10] = "" + 0.00;
//                BigDecimal importe = Subtotal.subtract(ValorDes);
//                Filas[11] = "" + importe;
//            }else
////            if (!"NO".equals(lista.get(i).getIva())) 
//            {
//                String ivaget = lista.get(i).getIva();
//                BigDecimal IVA = new BigDecimal(ivaget);
//                BigDecimal ValorIVA = IVA.multiply(Subtotal);
//                Filas[10] = "" + ValorIVA;
//                BigDecimal importe = Subtotal.add(ValorIVA).subtract(ValorDes);
//                Filas[11] = "" + importe;
//            }
//            model.addRow(Filas);
//            Tabla.setModel(model);
//            Tabla.getColumnModel().getColumn(0).setPreferredWidth(a[0]);
//            Tabla.getColumnModel().getColumn(0).setCellRenderer(tcr);
//            Tabla.getColumnModel().getColumn(1).setPreferredWidth(a[1]);
//            Tabla.getColumnModel().getColumn(1).setCellRenderer(tcr);
//            Tabla.getColumnModel().getColumn(2).setPreferredWidth(a[2]);
//            Tabla.getColumnModel().getColumn(2).setCellRenderer(tcr);
//            Tabla.getColumnModel().getColumn(3).setPreferredWidth(a[3]);
//            Tabla.getColumnModel().getColumn(3).setCellRenderer(tcr);
//            Tabla.getColumnModel().getColumn(4).setPreferredWidth(a[4]);
//            Tabla.getColumnModel().getColumn(4).setCellRenderer(tcr);
//            Tabla.getColumnModel().getColumn(5).setPreferredWidth(a[5]);
//            Tabla.getColumnModel().getColumn(5).setCellRenderer(tcr);
//            Tabla.getColumnModel().getColumn(6).setPreferredWidth(a[6]);
//            Tabla.getColumnModel().getColumn(6).setCellRenderer(tcr);
//            Tabla.getColumnModel().getColumn(7).setPreferredWidth(a[7]);
//            Tabla.getColumnModel().getColumn(7).setCellRenderer(tcr);
//            Tabla.getColumnModel().getColumn(8).setPreferredWidth(a[8]);
//            Tabla.getColumnModel().getColumn(8).setCellRenderer(tcr);
//            Tabla.getColumnModel().getColumn(9).setPreferredWidth(a[9]);
//            Tabla.getColumnModel().getColumn(9).setCellRenderer(tcr);
//            Tabla.getColumnModel().getColumn(10).setPreferredWidth(a[10]);
//            Tabla.getColumnModel().getColumn(10).setCellRenderer(tcr);
//            Tabla.getColumnModel().getColumn(11).setPreferredWidth(a[11]);
//            Tabla.getColumnModel().getColumn(11).setCellRenderer(tcr);
//        }
//
//    }
    public static double redondearDecimales(double valorInicial, int numeroDecimales) {
        double parteEntera, resultado;
        resultado = valorInicial;
        parteEntera = Math.floor(resultado);
        resultado = (resultado - parteEntera) * Math.pow(10, numeroDecimales);
        resultado = Math.round(resultado);
        resultado = (resultado / Math.pow(10, numeroDecimales)) + parteEntera;
        return resultado;
    }

    public static void cargarFiltroProductosNota(JTable Tabla, ArrayList<joinProductoDetallesFaltantes> lista) {

        int[] a = {10, 30, 32, 52, 15, 30, 10};
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        DefaultTableCellRenderer tcr1 = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        tcr1.setHorizontalAlignment(SwingConstants.RIGHT);
        model = Tablas.VaciarTabla(Tabla);
        String[] Co = {"CODIGO", "MARCA", "TIPO", "PRODUCTO", "ENVASE", "MEDIDA", "CANTIDAD"};
        String[] Filas = new String[7];
        model = new DefaultTableModel(null, Co);
        Tabla.setShowGrid(true);
        for (int i = 0; i < lista.size(); i++) {
            Filas[0] = "" + lista.get(i).getId_producto();
            Filas[1] = lista.get(i).getMarca();
            Filas[2] = lista.get(i).getNombre_tipo();
            Filas[3] = lista.get(i).getNombre_producto();
            Filas[4] = lista.get(i).getEnvase();
            Filas[5] = lista.get(i).getMedida();
            Filas[6] = "" + lista.get(i).getCantidad();
            model.addRow(Filas);
            Tabla.setModel(model);
            Tabla.getColumnModel().getColumn(0).setPreferredWidth(a[0]);
            Tabla.getColumnModel().getColumn(0).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(1).setPreferredWidth(a[1]);
            Tabla.getColumnModel().getColumn(1).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(2).setPreferredWidth(a[2]);
            Tabla.getColumnModel().getColumn(2).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(3).setPreferredWidth(a[3]);
            Tabla.getColumnModel().getColumn(3).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(4).setPreferredWidth(a[4]);
            Tabla.getColumnModel().getColumn(4).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(5).setPreferredWidth(a[5]);
            Tabla.getColumnModel().getColumn(5).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(6).setPreferredWidth(a[6]);
            Tabla.getColumnModel().getColumn(6).setCellRenderer(tcr);
        }

    }

    ////////////////////////////
    public static void cargarJoinProductoDetallesFaltantes(JTable Tabla, ArrayList<joinProductoDetallesFaltantes> lista) {

        int[] a = {10, 30, 32, 52, 15, 15, 15};
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        DefaultTableCellRenderer tcr1 = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        tcr1.setHorizontalAlignment(SwingConstants.RIGHT);
        model = Tablas.VaciarTabla(Tabla);
        String[] Co = {"CODIGO", "MARCA", "TIPO", "PRODUCTO", "ENVASE", "MEDIDA", "CANTIDAD"};
        String[] Filas = new String[7];
        model = new DefaultTableModel(null, Co);
        Tabla.setShowGrid(true);
        for (int i = 0; i < lista.size(); i++) {

            Filas[0] = "" + lista.get(i).getId_producto().toString();
            Filas[1] = lista.get(i).getMarca();
            Filas[2] = lista.get(i).getNombre_tipo();
            Filas[3] = lista.get(i).getNombre_producto();
            Filas[4] = lista.get(i).getEnvase();
            Filas[5] = lista.get(i).getMedida();
            Filas[6] = lista.get(i).getCantidad().toString();
//            Filas[7] = Formato_Numeros.formatoNumero(lista.get(i).getPrecios().toString());

            model.addRow(Filas);
            Tabla.setModel(model);
            Tabla.getColumnModel().getColumn(0).setPreferredWidth(a[0]);
            Tabla.getColumnModel().getColumn(0).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(1).setPreferredWidth(a[1]);
            Tabla.getColumnModel().getColumn(1).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(2).setPreferredWidth(a[2]);
            Tabla.getColumnModel().getColumn(2).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(3).setPreferredWidth(a[3]);
            Tabla.getColumnModel().getColumn(3).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(4).setPreferredWidth(a[4]);
            Tabla.getColumnModel().getColumn(4).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(5).setPreferredWidth(a[5]);
            Tabla.getColumnModel().getColumn(5).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(6).setPreferredWidth(a[6]);
            Tabla.getColumnModel().getColumn(6).setCellRenderer(tcr);
//            Tabla.getColumnModel().getColumn(7).setPreferredWidth(a[7]);
//            Tabla.getColumnModel().getColumn(7).setCellRenderer(tcr);

        }

    }

    public static void cargarJoinPuntoVenta(JTable Tabla, ArrayList<Punto_venta_usuario> lista) {

        int[] a = {5, 30, 32, 52, 80};
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        DefaultTableCellRenderer tcr1 = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.LEFT);
        tcr1.setHorizontalAlignment(SwingConstants.CENTER);
        model = VaciarTabla(Tabla);
        String[] Co = {"Codigo", "Nombre", "Localidad", "Direccion", "Observación"};
        String[] Filas = new String[5];
        model = new DefaultTableModel(null, Co);// eso es chi 
        Tabla.setShowGrid(true);
        for (int i = 0; i < lista.size(); i++) {
            Filas[0] = "" + lista.get(i).getId_punto_venta().toString();
            Filas[1] = lista.get(i).getNombre();
            Filas[2] = lista.get(i).getLocalidad();
            Filas[3] = lista.get(i).getDireccion();
            Filas[4] = lista.get(i).getObservacion();
            model.addRow(Filas);
            Tabla.setModel(model);
            Tabla.getColumnModel().getColumn(0).setPreferredWidth(a[0]);
            Tabla.getColumnModel().getColumn(0).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(1).setPreferredWidth(a[1]);
            Tabla.getColumnModel().getColumn(1).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(2).setPreferredWidth(a[2]);
            Tabla.getColumnModel().getColumn(2).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(3).setPreferredWidth(a[3]);
            Tabla.getColumnModel().getColumn(3).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(4).setPreferredWidth(a[4]);
            Tabla.getColumnModel().getColumn(4).setCellRenderer(tcr);
        }
    }

    public static void cargarLocal(JTable Tabla, ArrayList<Nombre_local> lista) {

        int[] a = {30, 50, 50, 70, 70};
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        DefaultTableCellRenderer tcr1 = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.LEFT);
        tcr1.setHorizontalAlignment(SwingConstants.CENTER);
        model = VaciarTabla(Tabla);
        String[] Co = {"NOMBRE", "TELÉFONO", "DIRECCIÓN", "FECHA DE CREACIÓN", "FECHA DE ACTUALIZACIÓN"};
        String[] Filas = new String[5];
        model = new DefaultTableModel(null, Co);
        Tabla.setShowGrid(true);
        for (int i = 0; i < lista.size(); i++) {

            Filas[0] = lista.get(i).getNombre();
            Filas[1] = lista.get(i).getTelefono_pv();
            Filas[2] = lista.get(i).getDireccion();
            Filas[3] = lista.get(i).getFecha_creacion().toString();
            Filas[4] = lista.get(i).getFecha_actualizacion().toString();
            model.addRow(Filas);
            Tabla.setModel(model);
            Tabla.getColumnModel().getColumn(0).setPreferredWidth(a[0]);
            Tabla.getColumnModel().getColumn(0).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(1).setPreferredWidth(a[1]);
            Tabla.getColumnModel().getColumn(1).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(2).setPreferredWidth(a[2]);
            Tabla.getColumnModel().getColumn(2).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(3).setPreferredWidth(a[3]);
            Tabla.getColumnModel().getColumn(3).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(4).setPreferredWidth(a[4]);
            Tabla.getColumnModel().getColumn(4).setCellRenderer(tcr);
        }
    }

    public static void listarProveedorNotaPedido(ArrayList<ListarJoinProveedorNotaPedido> lista, JTable Tabla) {
        int[] a = {10, 30, 32, 52};
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        DefaultTableCellRenderer tcr1 = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        tcr1.setHorizontalAlignment(SwingConstants.RIGHT);
        model = Tablas.VaciarTabla(Tabla);
        String[] Co = {"Cedula_Ruc", "Entidad", "Contacto", "Fecha de Ingreso"};
        String[] Filas = new String[4];
        model = new DefaultTableModel(null, Co);
        Tabla.setShowGrid(true);
        for (int i = 0; i < lista.size(); i++) {
            Filas[0] = lista.get(i).getCedula_ruc();
            Filas[1] = lista.get(i).getEntidad();
            Filas[2] = lista.get(i).getRepresentante();
            Filas[3] = (lista.get(i).getFecha_registro()).toString();
            model.addRow(Filas);
            Tabla.setModel(model);
            Tabla.getColumnModel().getColumn(0).setPreferredWidth(a[0]);
            Tabla.getColumnModel().getColumn(0).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(1).setPreferredWidth(a[1]);
            Tabla.getColumnModel().getColumn(1).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(2).setPreferredWidth(a[2]);
            Tabla.getColumnModel().getColumn(2).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(3).setPreferredWidth(a[3]);
            Tabla.getColumnModel().getColumn(3).setCellRenderer(tcr);
        }

    }
    public static void cargarusuario(JTable Tabla, ArrayList<Listar_usuario> lista){
        int[] a = {10,40,52,52,30};
        DefaultTableCellRenderer tablerender = new DefaultTableCellRenderer();
        DefaultTableCellRenderer tablerender1 = new DefaultTableCellRenderer();
        tablerender.setHorizontalAlignment(SwingConstants.CENTER);
        tablerender1.setHorizontalAlignment(SwingConstants.RIGHT);
        model = VaciarTabla(Tabla);
        String[] Co = {"CODIGO","CEDULA","APELLIDOS","NOMBRES","CARGO"};
        String[] Filas = new String[9];
        model = new DefaultTableModel(null,Co);
        Tabla.setShowGrid(true);
        for(int i=0;i<lista.size();i++){
            Filas[0] = ""+ lista.get(i).getId_sesion().toString();
            Filas[1] = lista.get(i).getCedula().toString();
            Filas[2] = lista.get(i).getApellidos();
            Filas[3] = lista.get(i).getNombres();
            Filas[4] = lista.get(i).getCargo();
            model.addRow(Filas);
            Tabla.setModel(model);
            Tabla.getColumnModel().getColumn(0).setPreferredWidth(a[0]);
            Tabla.getColumnModel().getColumn(0).setCellRenderer(tablerender);
            Tabla.getColumnModel().getColumn(1).setPreferredWidth(a[1]);
            Tabla.getColumnModel().getColumn(1).setCellRenderer(tablerender);
            Tabla.getColumnModel().getColumn(2).setPreferredWidth(a[2]);
            Tabla.getColumnModel().getColumn(2).setCellRenderer(tablerender);
            Tabla.getColumnModel().getColumn(3).setPreferredWidth(a[3]);
            Tabla.getColumnModel().getColumn(3).setCellRenderer(tablerender);
            Tabla.getColumnModel().getColumn(4).setPreferredWidth(a[4]);
            Tabla.getColumnModel().getColumn(4).setCellRenderer(tablerender);
        }
    }   
    public static void cargarJoinUsuario(JTable Tabla, ArrayList<Listar_usuario> lista) {

        int[] a = {10, 50, 40, 52, 52, 80, 30, 52, 30};
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        DefaultTableCellRenderer tcr1 = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.LEFT);
        tcr1.setHorizontalAlignment(SwingConstants.CENTER);
        model = VaciarTabla(Tabla);
        String[] Co = {"CÓDIGO", "FECHA DE REGISTRO", "CÉDULA", "APELLIDOS", "NOMBRES", "DIRECCIÓN", "CELULAR", /*"CONVENCIONAL",*/
            "CORREO", "CARGO"/*"OBSERVACIÓN"*/};
        String[] Filas = new String[9];
        model = new DefaultTableModel(null, Co);
        Tabla.setShowGrid(true);
        for (int i = 0; i < lista.size(); i++) {
            Filas[0] = "" + lista.get(i).getId_sesion().toString();
            Filas[1] = lista.get(i).getFecha_registro().toString();
            Filas[2] = lista.get(i).getCedula();
            Filas[3] = lista.get(i).getApellidos();
            Filas[4] = lista.get(i).getNombres();
            Filas[5] = lista.get(i).getDireccion();
            Filas[6] = lista.get(i).getTelefono();
            Filas[7] = lista.get(i).getCorreo();
            Filas[8] = lista.get(i).getCargo();
            model.addRow(Filas);
            Tabla.setModel(model);
            Tabla.getColumnModel().getColumn(0).setPreferredWidth(a[0]);
            Tabla.getColumnModel().getColumn(0).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(1).setPreferredWidth(a[1]);
            Tabla.getColumnModel().getColumn(1).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(2).setPreferredWidth(a[2]);
            Tabla.getColumnModel().getColumn(2).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(3).setPreferredWidth(a[3]);
            Tabla.getColumnModel().getColumn(3).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(4).setPreferredWidth(a[4]);
            Tabla.getColumnModel().getColumn(4).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(5).setPreferredWidth(a[5]);
            Tabla.getColumnModel().getColumn(5).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(6).setPreferredWidth(a[6]);
            Tabla.getColumnModel().getColumn(6).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(7).setPreferredWidth(a[7]);
            Tabla.getColumnModel().getColumn(7).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(8).setPreferredWidth(a[8]);
            Tabla.getColumnModel().getColumn(8).setCellRenderer(tcr);
        }
    }

    public void visualizar(JTable tabla, Long id) {

        tabla.setDefaultRenderer(Object.class, new Render());
        DefaultTableModel dt = new DefaultTableModel(new String[]{"COD.PRECIO", "COD.PRODUCTO","PRE.FARMAC.", "PRE.COMPRA", "PRE.VENTA", "PORCENTAJE", "GANANCIA", "ESTADO",}, 0) {

            Class[] types = new Class[]{
                java.lang.Object.class,java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int row, int column) {
                return editable[column];
            }
        };

//        JButton btn_visualizar = new JButton("Visualizar");
//        btn_visualizar.setName("v");
        Consultas llamar = new Consultas();
        Precios vo = new Precios();
        //Long id= Long.valueOf("22");
        ArrayList<Precios> list = llamar.listarPrecioCompra("SELECT id_precio,`id_producto`,`precio_base`,`precio_compra`,`precio_venta`, estado,porcentaje,descuentoVenta FROM `precios` WHERE `id_producto`= " + id);

        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                // model.addRow(new Object[]{});
                Object fila[] = new Object[8];
                vo = list.get(i);
                fila[0] = vo.getId_precio();
                fila[1] = vo.getId_producto();
                fila[2] = vo.getPrecio_base();
                fila[3] = vo.getPrecio_compra();
                fila[4] = vo.getPrecio_venta();
                fila[5] = vo.getPorcentaje();
                Double por=0.00; Double envio=0.00;
                if(vo.getPorcentaje()==0){
                    Double valor1= vo.getPrecio_compra();
                    Double valor2= vo.getPrecio_venta();
                    envio= valor2-valor1;
                }
                if(vo.getPorcentaje()!=0){
                 por = Double.parseDouble(vo.getPorcentaje().toString()) / 100;
                 envio = vo.getPrecio_compra() * por;
                }
                
                fila[6] = Formato_Numeros.formatoNumero(envio.toString());
                String ac = (String) vo.getEstado();
                if ("A".equals(ac)) {
                    fila[7] = true;
                } else {
                    fila[7] = false;
                }
                //  fila[5] = btn_visualizar;

                dt.addRow(fila);

            }

        }

        tabla.setModel(dt);

    }

    public static void cargarJoinRegistroDetalleNotas(JTable Tabla, ArrayList<JoinListarDetalleNotaPedido> lista) {

        int[] a = {10, 30, 32, 70, 15, 30, 10, 10, 10, 20, 10, 5};
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        DefaultTableCellRenderer tcr1 = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        tcr1.setHorizontalAlignment(SwingConstants.RIGHT);
        model = Tablas.VaciarTabla(Tabla);
        String[] Co = {"CODIGO", "MARCA", "TIPO", "PRODUCTO", "ENVASE", "MEDIDA", "CANTIDAD", "BONO", "PRECIO", "DESCUENTO", "IVA", "TOTAL"};
        String[] Filas = new String[12];
        model = new DefaultTableModel(null, Co);
        Tabla.setShowGrid(true);
        for (int i = 0; i < lista.size(); i++) {
            Filas[0] = "" + lista.get(i).getId_producto().toString();
            Filas[1] = lista.get(i).getMarca();
            Filas[2] = lista.get(i).getTipo();
            Filas[3] = lista.get(i).getProducto();
            Filas[4] = lista.get(i).getEnvase();
            Filas[5] = lista.get(i).getMedida();
            Filas[6] = "" + lista.get(i).getCantidad();
            Filas[7] = "" + lista.get(i).getBono();
            Filas[8] = lista.get(i).getPrecio().setScale(2, BigDecimal.ROUND_HALF_UP).toString();
            Filas[9] = Formato_Numeros.formatoNumero(lista.get(i).getDescuento().setScale(2, BigDecimal.ROUND_HALF_UP).toString());//new BigDecimal(value).toPlainString();
            Filas[10] = Formato_Numeros.formatoNumero(lista.get(i).getIva().setScale(2, BigDecimal.ROUND_HALF_UP).toString());
            Filas[11] = Formato_Numeros.formatoNumero(lista.get(i).getTotal().setScale(2, BigDecimal.ROUND_HALF_UP).toString());
            model.addRow(Filas);
            Tabla.setModel(model);
            Tabla.getColumnModel().getColumn(0).setPreferredWidth(a[0]);
            Tabla.getColumnModel().getColumn(0).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(1).setPreferredWidth(a[1]);
            Tabla.getColumnModel().getColumn(1).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(2).setPreferredWidth(a[2]);
            Tabla.getColumnModel().getColumn(2).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(3).setPreferredWidth(a[3]);
            Tabla.getColumnModel().getColumn(3).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(4).setPreferredWidth(a[4]);
            Tabla.getColumnModel().getColumn(4).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(5).setPreferredWidth(a[5]);
            Tabla.getColumnModel().getColumn(5).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(6).setPreferredWidth(a[6]);
            Tabla.getColumnModel().getColumn(6).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(7).setPreferredWidth(a[7]);
            Tabla.getColumnModel().getColumn(7).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(8).setPreferredWidth(a[8]);
            Tabla.getColumnModel().getColumn(8).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(9).setPreferredWidth(a[9]);
            Tabla.getColumnModel().getColumn(9).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(10).setPreferredWidth(a[10]);
            Tabla.getColumnModel().getColumn(10).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(11).setPreferredWidth(a[11]);
            Tabla.getColumnModel().getColumn(11).setCellRenderer(tcr);
        }
    }

    public static void cargarJoinRegistroDetalleCompras(JTable Tabla, ArrayList<JoinListarDetalleNotaPedido> lista) {

        int[] a = {10, 10, 30, 32, 70, 15, 30, 10, 10, 20, 10, 5};
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        DefaultTableCellRenderer tcr1 = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        tcr1.setHorizontalAlignment(SwingConstants.RIGHT);
        model = Tablas.VaciarTabla(Tabla);
        String[] Co = {"N#", "CODIGO", "MARCA", "TIPO", "PRODUCTO", "ENVASE", "MEDIDA", "CANTIDAD", "PRECIO", "DESCUENTO", "IVA", "TOTAL"};
        String[] Filas = new String[12];
        model = new DefaultTableModel(null, Co);
        Tabla.setShowGrid(true);
        for (int i = 0; i < lista.size(); i++) {
            Filas[0] = "" + lista.get(i).getId_detalle_nota_pedido().toString();
            Filas[1] = "" + lista.get(i).getId_producto().toString();
            Filas[2] = lista.get(i).getMarca();
            Filas[3] = lista.get(i).getTipo();
            Filas[4] = lista.get(i).getProducto();
            Filas[5] = lista.get(i).getEnvase();
            Filas[6] = lista.get(i).getMedida();
            Filas[7] = "" + lista.get(i).getCantidad();
            Filas[8] = Formato_Numeros.formatoNumero(lista.get(i).getPrecio().setScale(2, BigDecimal.ROUND_HALF_UP).toString());
            Filas[9] = Formato_Numeros.formatoNumero(lista.get(i).getDescuento().setScale(2, BigDecimal.ROUND_HALF_UP).toString());
            Filas[10] = Formato_Numeros.formatoNumero(lista.get(i).getIva().setScale(2, BigDecimal.ROUND_HALF_UP).toString());
            Filas[11] = Formato_Numeros.formatoNumero(lista.get(i).getTotal().setScale(2, BigDecimal.ROUND_HALF_UP).toString());
            model.addRow(Filas);
            Tabla.setModel(model);
            Tabla.getColumnModel().getColumn(0).setPreferredWidth(a[0]);
            Tabla.getColumnModel().getColumn(0).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(1).setPreferredWidth(a[1]);
            Tabla.getColumnModel().getColumn(1).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(2).setPreferredWidth(a[2]);
            Tabla.getColumnModel().getColumn(2).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(3).setPreferredWidth(a[3]);
            Tabla.getColumnModel().getColumn(3).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(4).setPreferredWidth(a[4]);
            Tabla.getColumnModel().getColumn(4).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(5).setPreferredWidth(a[5]);
            Tabla.getColumnModel().getColumn(5).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(6).setPreferredWidth(a[6]);
            Tabla.getColumnModel().getColumn(6).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(7).setPreferredWidth(a[7]);
            Tabla.getColumnModel().getColumn(7).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(8).setPreferredWidth(a[8]);
            Tabla.getColumnModel().getColumn(8).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(9).setPreferredWidth(a[9]);
            Tabla.getColumnModel().getColumn(9).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(10).setPreferredWidth(a[10]);
            Tabla.getColumnModel().getColumn(10).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(11).setPreferredWidth(a[11]);
            Tabla.getColumnModel().getColumn(11).setCellRenderer(tcr);
        }
    }
    ///////// cargar tabla  Join producto ventas

    public static void cargarJoinProductosVentas(JTable Tabla, ArrayList<JoinListarProductosVentas> lista) {

        int[] a = {10, 30, 52, 30, 30, 30, 30, 30, 30, 30, 30};
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        DefaultTableCellRenderer tcr1 = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        tcr1.setHorizontalAlignment(SwingConstants.RIGHT);
        model = Tablas.VaciarTabla(Tabla);
        String[] Co = {"CODIGO", "PRODUCTO", "DESCRIPCION", "TIPO", "MEDIDA", "ENVASE", "MARCA", "STOCK", "IVA", "PRECIO VENTA", "DESCUENTO"};
        String[] Filas = new String[11];
        model = new DefaultTableModel(null, Co);
        Tabla.setShowGrid(true);
        for (int i = 0; i < lista.size(); i++) {
            Filas[0] = lista.get(i).getId_producto().toString();
            Filas[1] = lista.get(i).getProducto_nombre();
            Filas[2] = lista.get(i).getProducto_descripcion();
            Filas[3] = lista.get(i).getTipo_nombre();
            Filas[4] = lista.get(i).getMedida_nombre();
            Filas[5] = lista.get(i).getEnvase_nombre();
            Filas[6] = lista.get(i).getMarca_nombre();
            Filas[7] = lista.get(i).getStock().toString();
            Filas[8] = lista.get(i).getIva();
            Filas[9] = lista.get(i).getPrecio_venta().toString();
//            Filas[10] = lista.get(i).getDescuento().toString();


            model.addRow(Filas);
            Tabla.setModel(model);
            Tabla.getColumnModel().getColumn(0).setPreferredWidth(a[0]);
            Tabla.getColumnModel().getColumn(0).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(1).setPreferredWidth(a[1]);
            Tabla.getColumnModel().getColumn(1).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(2).setPreferredWidth(a[2]);
            Tabla.getColumnModel().getColumn(2).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(3).setPreferredWidth(a[3]);
            Tabla.getColumnModel().getColumn(3).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(4).setPreferredWidth(a[4]);
            Tabla.getColumnModel().getColumn(4).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(5).setPreferredWidth(a[5]);
            Tabla.getColumnModel().getColumn(5).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(6).setPreferredWidth(a[6]);
            Tabla.getColumnModel().getColumn(6).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(7).setPreferredWidth(a[7]);
            Tabla.getColumnModel().getColumn(7).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(8).setPreferredWidth(a[8]);
            Tabla.getColumnModel().getColumn(8).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(9).setPreferredWidth(a[9]);
            Tabla.getColumnModel().getColumn(9).setCellRenderer(tcr);
          //  Tabla.getColumnModel().getColumn(10).setPreferredWidth(a[10]);
          //  Tabla.getColumnModel().getColumn(10).setCellRenderer(tcr);

            
        }
    }
    ///////// cargar tabla  Join cliente ventas

    public static void cargarClienteVentas(JTable Tabla, ArrayList<Persona> lista) {

        int[] a = {10, 30, 30, 30, 30, 30, 30};
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        DefaultTableCellRenderer tcr1 = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        tcr1.setHorizontalAlignment(SwingConstants.RIGHT);
        model = Tablas.VaciarTabla(Tabla);
        String[] Co = {"CODIGO", "CEDULA", "NOMBRE", "APELLIDO", "DIRECCION", "TELEFONO", "CORREO"};
        String[] Filas = new String[7];
        model = new DefaultTableModel(null, Co);
        Tabla.setShowGrid(true);
        for (int i = 0; i < lista.size(); i++) {
            Filas[0] = lista.get(i).getId_Clientes().toString();
            Filas[1] = lista.get(i).getCedula();
            Filas[2] = lista.get(i).getNombre();
            Filas[3] = lista.get(i).getApellido();
            Filas[4] = lista.get(i).getDireccion();
            Filas[5] = lista.get(i).getStr_telefono();
            Filas[6] = lista.get(i).getStr_correo();

            model.addRow(Filas);
            Tabla.setModel(model);
            Tabla.getColumnModel().getColumn(0).setPreferredWidth(a[0]);
            Tabla.getColumnModel().getColumn(0).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(1).setPreferredWidth(a[1]);
            Tabla.getColumnModel().getColumn(1).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(2).setPreferredWidth(a[2]);
            Tabla.getColumnModel().getColumn(2).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(3).setPreferredWidth(a[3]);
            Tabla.getColumnModel().getColumn(3).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(4).setPreferredWidth(a[4]);
            Tabla.getColumnModel().getColumn(4).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(5).setPreferredWidth(a[5]);
            Tabla.getColumnModel().getColumn(5).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(6).setPreferredWidth(a[6]);
            Tabla.getColumnModel().getColumn(6).setCellRenderer(tcr);

        }
    }

    //////////  cargar lista detalle ventas  
    public static void cargarListaVentasDetalle(JTable Tabla, ArrayList<Detalle_ventas> lista) {

        int[] a = {30, 160, 50, 50, 50, 50, 50, 50};
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        DefaultTableCellRenderer tcr1 = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        tcr1.setHorizontalAlignment(SwingConstants.RIGHT);
        model = Tablas.VaciarTabla(Tabla);
        String[] Co = {"CODIGO", "PRODUCTO", "CANTIDAD", "PRECIO", "SUBTOTAL", "DESCUENTO", "IVA", "TOTAL"};
        String[] Filas = new String[8];
        model = new DefaultTableModel(null, Co);
        Tabla.setShowGrid(true);
        for (int i = 0; i < lista.size(); i++) {
            Filas[0] = "" + lista.get(i).getId_producto();
            Filas[1] = lista.get(i).getNombre_producto();
            Filas[2] = "" + lista.get(i).getCantidad();
            Filas[3] = lista.get(i).getPrecio().setScale(2, BigDecimal.ROUND_HALF_UP).toEngineeringString();
            Filas[4] = lista.get(i).getSubtotal().setScale(2, BigDecimal.ROUND_HALF_UP).toEngineeringString();
            Filas[5] = lista.get(i).getDescuento().setScale(2, BigDecimal.ROUND_HALF_UP).toEngineeringString();
            Filas[6] = lista.get(i).getIva().setScale(2, BigDecimal.ROUND_HALF_UP).toEngineeringString();
            Filas[7] = lista.get(i).getTotal().setScale(2, BigDecimal.ROUND_HALF_UP).toEngineeringString();
            model.addRow(Filas);

            Tabla.setModel(model);
            Tabla.getColumnModel().getColumn(0).setPreferredWidth(a[0]);
            Tabla.getColumnModel().getColumn(0).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(1).setPreferredWidth(a[1]);
            Tabla.getColumnModel().getColumn(1).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(2).setPreferredWidth(a[2]);
            Tabla.getColumnModel().getColumn(2).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(3).setPreferredWidth(a[3]);
            Tabla.getColumnModel().getColumn(3).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(4).setPreferredWidth(a[4]);
            Tabla.getColumnModel().getColumn(4).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(5).setPreferredWidth(a[5]);
            Tabla.getColumnModel().getColumn(5).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(6).setPreferredWidth(a[6]);
            Tabla.getColumnModel().getColumn(6).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(7).setPreferredWidth(a[7]);
            Tabla.getColumnModel().getColumn(7).setCellRenderer(tcr);
        }

    }
//    public void visualizar(JTable tabla,Long id) {
//
//        tabla.setDefaultRenderer(Object.class, new Render());
//        DefaultTableModel dt = new DefaultTableModel(new String[]{"CODIGO PRECIO", "CODIGO PRODUCTO", "PRECIO COMPRA", "PRECIO VENTA", "ESTADO",}, 0) {
//
//            Class[] types = new Class[]{
//                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.Object.class
//            };
//
//            public Class getColumnClass(int columnIndex) {
//                return types[columnIndex];
//            }
//
//            public boolean isCellEditable(int row, int column) {
//                return editable[column];
//            }
//        };
//
////        JButton btn_visualizar = new JButton("Visualizar");
////        btn_visualizar.setName("v");
//        Consultas llamar = new Consultas();
//        Precios vo = new Precios();
//        //Long id= Long.valueOf("22");
//        ArrayList<Precios> list = llamar.listarPrecioCompra("SELECT id_precio,`id_producto`,`precio_compra`,`precio_venta`, estado FROM `precios` WHERE `id_producto`= " + id);
//
//        if (list.size() > 0) {
//            for (int i = 0; i < list.size(); i++) {
//                // model.addRow(new Object[]{});
//                Object fila[] = new Object[6];
//                vo = list.get(i);
//                fila[0] = vo.getId_precio();
//                fila[1] = vo.getId_producto();
//                fila[2] = vo.getPrecio_compra();
//                fila[3] = vo.getPrecio_venta();
//                String ac = (String) vo.getEstado();
//                if ("A".equals(ac)) {
//                    fila[4] = true;
//                } else {
//                    fila[4] = false;
//                }
//                //  fila[5] = btn_visualizar;
//                
//                dt.addRow(fila);
//            
//            }
//
//        }
//
//        tabla.setModel(dt);
//
//    }
//    public static void cargarJoinRegistroDetalleNotas(JTable Tabla, ArrayList<JoinListarDetalleNotaPedido> lista) {
//
//        int[] a = {10, 30, 32, 70, 15, 30, 10, 10, 20, 10, 5};
//        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
//        DefaultTableCellRenderer tcr1 = new DefaultTableCellRenderer();
//        tcr.setHorizontalAlignment(SwingConstants.CENTER);
//        tcr1.setHorizontalAlignment(SwingConstants.RIGHT);
//        model = Tablas.VaciarTabla(Tabla);
//        String[] Co = {"CODIGO", "MARCA", "TIPO", "PRODUCTO", "ENVASE", "MEDIDA", "CANTIDAD", "PRECIO", "DESCUENTO", "IVA", "TOTAL"};
//        String[] Filas = new String[11];
//        model = new DefaultTableModel(null, Co);
//        Tabla.setShowGrid(true);
//        for (int i = 0; i < lista.size(); i++) {
//            Filas[0] = "" + lista.get(i).getId_producto().toString();
//            Filas[1] = lista.get(i).getMarca();
//            Filas[2] = lista.get(i).getTipo();
//            Filas[3] = lista.get(i).getProducto();
//            Filas[4] = lista.get(i).getEnvase();
//            Filas[5] = lista.get(i).getMedida();
//            Filas[6] = "" + lista.get(i).getCantidad();
//            Filas[7] = lista.get(i).getPrecio().toString();
//            Filas[8] =  lista.get(i).getDescuento().toString();
//            Filas[9] = lista.get(i).getIva().toString();
//            Filas[10] =lista.get(i).getTotal().toString();
//            model.addRow(Filas);
//            Tabla.setModel(model);
//            Tabla.getColumnModel().getColumn(0).setPreferredWidth(a[0]);
//            Tabla.getColumnModel().getColumn(0).setCellRenderer(tcr);
//            Tabla.getColumnModel().getColumn(1).setPreferredWidth(a[1]);
//            Tabla.getColumnModel().getColumn(1).setCellRenderer(tcr);
//            Tabla.getColumnModel().getColumn(2).setPreferredWidth(a[2]);
//            Tabla.getColumnModel().getColumn(2).setCellRenderer(tcr);
//            Tabla.getColumnModel().getColumn(3).setPreferredWidth(a[3]);
//            Tabla.getColumnModel().getColumn(3).setCellRenderer(tcr);
//            Tabla.getColumnModel().getColumn(4).setPreferredWidth(a[4]);
//            Tabla.getColumnModel().getColumn(4).setCellRenderer(tcr);
//            Tabla.getColumnModel().getColumn(5).setPreferredWidth(a[5]);
//            Tabla.getColumnModel().getColumn(5).setCellRenderer(tcr);
//            Tabla.getColumnModel().getColumn(6).setPreferredWidth(a[6]);
//            Tabla.getColumnModel().getColumn(6).setCellRenderer(tcr);
//            Tabla.getColumnModel().getColumn(7).setPreferredWidth(a[7]);
//            Tabla.getColumnModel().getColumn(7).setCellRenderer(tcr);
//            Tabla.getColumnModel().getColumn(8).setPreferredWidth(a[8]);
//            Tabla.getColumnModel().getColumn(8).setCellRenderer(tcr);
//            Tabla.getColumnModel().getColumn(9).setPreferredWidth(a[9]);
//            Tabla.getColumnModel().getColumn(9).setCellRenderer(tcr);
//            Tabla.getColumnModel().getColumn(10).setPreferredWidth(a[10]);
//            Tabla.getColumnModel().getColumn(10).setCellRenderer(tcr);
//        }
//
//    }

    public static void listarIva(ArrayList<Iva> lista, JTable Tabla) {
        int[] a = {15, 30, 30};
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        DefaultTableCellRenderer tcr1 = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        tcr1.setHorizontalAlignment(SwingConstants.RIGHT);
        model = Tablas.VaciarTabla(Tabla);
        String[] Co = {"IVA", "FECHA DE INGRESO", "USUARIO"};
        //   Date[] Ca = {Date.valueOf("Fecha")};
        String[] Filas = new String[5];
        //  Date[] Fila = new Date [1];
        model = new DefaultTableModel(null, Co);
        //  laboratorio = new DefaultTableModel(null, Ca);
        Tabla.setShowGrid(true);
        for (int i = 0; i < lista.size(); i++) {
            // Filas[0] = String.valueOf(lista.get(i).getIva() +"%");
            Filas[0] = String.valueOf(lista.get(i).getIva());
            Filas[1] = String.valueOf(lista.get(i).getFecha());
            Filas[2] = String.valueOf(lista.get(i).getId_usuario());
            //Filas[3] = lista.get(i).getTelefono();
            //Filas[4] = Fecha.getStringFecha(lista.get(i).getFecha());
            model.addRow(Filas);
            //     laboratorio.addRow(Fila);
            Tabla.setModel(model);
            Tabla.getColumnModel().getColumn(0).setPreferredWidth(a[0]);
            Tabla.getColumnModel().getColumn(0).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(1).setPreferredWidth(a[1]);
            Tabla.getColumnModel().getColumn(1).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(2).setPreferredWidth(a[2]);
            Tabla.getColumnModel().getColumn(2).setCellRenderer(tcr);

        }

    }

    public static void cargarJoinProductoIngresoDetalleNotaPedido(JTable Tabla, ArrayList<JoinListarDetalleNotaPedido> lista) {

        int[] a = {10, 30, 32, 70, 15, 30, 10, 10, 20, 10, 5};
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        DefaultTableCellRenderer tcr1 = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        tcr1.setHorizontalAlignment(SwingConstants.RIGHT);
        model = Tablas.VaciarTabla(Tabla);
        String[] Co = {"CODIGO", "MARCA", "TIPO", "PRODUCTO", "ENVASE", "MEDIDA", "CANTIDAD", "PRECIO", "DESCUENTO", "IVA", "TOTAL"};
        String[] Filas = new String[11];
        model = new DefaultTableModel(null, Co);
        Tabla.setShowGrid(true);
        for (int i = 0; i < lista.size(); i++) {
            Filas[0] = "" + lista.get(i).getId_producto().toString();
            Filas[1] = lista.get(i).getMarca();
            Filas[2] = lista.get(i).getTipo();
            Filas[3] = lista.get(i).getProducto();
            Filas[4] = lista.get(i).getEnvase();
            Filas[5] = lista.get(i).getMedida();
            Filas[6] = "" + lista.get(i).getCantidad();
            Filas[7] = lista.get(i).getPrecio().toString();
            Filas[8] = lista.get(i).getDescuento().toString();
            Filas[9] = lista.get(i).getIva().toString();
            Filas[10] = lista.get(i).getTotal().toString();

        }
        model.addRow(Filas);
        Tabla.setModel(model);
        Tabla.getColumnModel().getColumn(0).setPreferredWidth(a[0]);
        Tabla.getColumnModel().getColumn(0).setCellRenderer(tcr);
        Tabla.getColumnModel().getColumn(1).setPreferredWidth(a[1]);
        Tabla.getColumnModel().getColumn(1).setCellRenderer(tcr);
        Tabla.getColumnModel().getColumn(2).setPreferredWidth(a[2]);
        Tabla.getColumnModel().getColumn(2).setCellRenderer(tcr);
        Tabla.getColumnModel().getColumn(3).setPreferredWidth(a[3]);
        Tabla.getColumnModel().getColumn(3).setCellRenderer(tcr);
        Tabla.getColumnModel().getColumn(4).setPreferredWidth(a[4]);
        Tabla.getColumnModel().getColumn(4).setCellRenderer(tcr);
        Tabla.getColumnModel().getColumn(5).setPreferredWidth(a[5]);
        Tabla.getColumnModel().getColumn(5).setCellRenderer(tcr);
        Tabla.getColumnModel().getColumn(6).setPreferredWidth(a[6]);
        Tabla.getColumnModel().getColumn(6).setCellRenderer(tcr);
        Tabla.getColumnModel().getColumn(7).setPreferredWidth(a[7]);
        Tabla.getColumnModel().getColumn(7).setCellRenderer(tcr);
        Tabla.getColumnModel().getColumn(8).setPreferredWidth(a[8]);
        Tabla.getColumnModel().getColumn(8).setCellRenderer(tcr);
        Tabla.getColumnModel().getColumn(9).setPreferredWidth(a[9]);
        Tabla.getColumnModel().getColumn(9).setCellRenderer(tcr);
        Tabla.getColumnModel().getColumn(10).setPreferredWidth(a[10]);
        Tabla.getColumnModel().getColumn(10).setCellRenderer(tcr);
    }

    public static void ListarStockProductos(ArrayList<Productos_Stock> lista, JTable Tabla) {
        int[] a = {90, 150, 160, 100, 100, 90, 100, 100, 100, 100};
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        DefaultTableCellRenderer tcr1 = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        tcr1.setHorizontalAlignment(SwingConstants.RIGHT);
        model = Tablas.VaciarTabla(Tabla);
        String[] Co = {"CODIGO", "PRODUCTO", "DESCRIPCION", "PRECIO COMPRA", "PRECIO VENTA", "STOCK", "TOTAL"};
        //   Date[] Ca = {Date.valueOf("Fecha")};
        String[] Filas = new String[7];
        //  Date[] Fila = new Date [1];
        model = new DefaultTableModel(null, Co);
        //  laboratorio = new DefaultTableModel(null, Ca);
        Tabla.setShowGrid(true);
        for (int i = 0; i < lista.size(); i++) {
            Filas[0] = lista.get(i).getId_producto().toString();
            Filas[1] = lista.get(i).getNombre_Producto();
            Filas[2] = lista.get(i).getDescripcion();
            Filas[3] = Formato_Numeros.formatoNumero(lista.get(i).getPrecio_compra().toString());
            Filas[4] = Formato_Numeros.formatoNumero(lista.get(i).getPrecio_venta().toString());
            Filas[5] = lista.get(i).getCantidad().toString();
            Double ao = lista.get(i).getCantidad() * (lista.get(i).getPrecio_compra());
            Filas[6] = Formato_Numeros.formatoNumero(ao.toString());

            model.addRow(Filas);
            //     laboratorio.addRow(Fila);
            Tabla.setModel(model);
            Tabla.getColumnModel().getColumn(0).setPreferredWidth(a[0]);
            Tabla.getColumnModel().getColumn(0).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(1).setPreferredWidth(a[1]);
            Tabla.getColumnModel().getColumn(1).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(2).setPreferredWidth(a[2]);
            Tabla.getColumnModel().getColumn(2).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(3).setPreferredWidth(a[3]);
            Tabla.getColumnModel().getColumn(3).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(4).setPreferredWidth(a[4]);
            Tabla.getColumnModel().getColumn(4).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(5).setPreferredWidth(a[5]);
            Tabla.getColumnModel().getColumn(5).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(6).setPreferredWidth(a[5]);
            Tabla.getColumnModel().getColumn(6).setCellRenderer(tcr);

        }

    }

    public static void CargarJoinListaCabeceraVenta(JTable Tabla, ArrayList<JoinListarCabeceraVenta> lista) {

        int[] a = {100, 100, 100, 100, 100, 110, 100, 100, 100, 100, 100, 100, 100, 100};
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        DefaultTableCellRenderer tcr1 = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        tcr1.setHorizontalAlignment(SwingConstants.RIGHT);
        model = Tablas.VaciarTabla(Tabla);
        String[] Co = {"NUMERO_VENTA ", "SUCURSAL", "FECHA", "CLIENTE", "CEDULA_CLIENTE", "USUARIO",
            "FORMA DE PAGO", "TIPO DE VENTA", "SUBTOTAL", "IVA", "DESCUENTO", "TOTAL", "UTILIDAD", "ESTADO"};
        String[] Filas = new String[14];
        model = new DefaultTableModel(null, Co);
        Tabla.setShowGrid(true);
        for (int i = 0; i < lista.size(); i++) {
            Filas[0] = lista.get(i).getMun_venta();
            Filas[1] = lista.get(i).getSurcusal();
            String j = Fecha.getStringFecha1(lista.get(i).getFecha_creacion());
            Filas[2] = Fecha.getStringFecha(Date.valueOf(j));
            Filas[3] = lista.get(i).getNombre_completo_cliente();
            Filas[4] = lista.get(i).getCedula_cliente();
            Filas[5] = lista.get(i).getNombre_completo_usuario();
            Filas[6] = lista.get(i).getTipo_pago();
            Filas[7] = lista.get(i).getTipo_venta();
            Filas[8] = Formato_Numeros.formatoNumero(lista.get(i).getSubtotal().toString());
            Filas[9] = Formato_Numeros.formatoNumero(lista.get(i).getIva_total().toString());
            Filas[10] = Formato_Numeros.formatoNumero(lista.get(i).getDescuento_total().toString());
            Filas[11] = Formato_Numeros.formatoNumero(lista.get(i).getTotal().toString());
            Filas[12] = Formato_Numeros.formatoNumero(lista.get(i).getUtilidad().toString());
            Filas[13] = lista.get(i).getEstado();
            model.addRow(Filas);
            Tabla.setModel(model);
            Tabla.getColumnModel().getColumn(0).setPreferredWidth(a[0]);
            Tabla.getColumnModel().getColumn(0).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(1).setPreferredWidth(a[1]);
            Tabla.getColumnModel().getColumn(1).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(2).setPreferredWidth(a[2]);
            Tabla.getColumnModel().getColumn(2).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(3).setPreferredWidth(a[3]);
            Tabla.getColumnModel().getColumn(3).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(4).setPreferredWidth(a[4]);
            Tabla.getColumnModel().getColumn(4).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(5).setPreferredWidth(a[5]);
            Tabla.getColumnModel().getColumn(5).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(6).setPreferredWidth(a[6]);
            Tabla.getColumnModel().getColumn(6).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(7).setPreferredWidth(a[7]);
            Tabla.getColumnModel().getColumn(7).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(8).setPreferredWidth(a[8]);
            Tabla.getColumnModel().getColumn(8).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(9).setPreferredWidth(a[9]);
            Tabla.getColumnModel().getColumn(9).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(10).setPreferredWidth(a[10]);
            Tabla.getColumnModel().getColumn(10).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(11).setPreferredWidth(a[11]);
            Tabla.getColumnModel().getColumn(11).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(12).setPreferredWidth(a[12]);
            Tabla.getColumnModel().getColumn(12).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(13).setPreferredWidth(a[13]);
            Tabla.getColumnModel().getColumn(13).setCellRenderer(tcr);

        }

    }

    public static void cargarJoinFaltantes_cantidad(JTable Tabla, ArrayList<Faltantes> lista) {

        int[] a = {10, 30, 32, 52, 15, 30};
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        DefaultTableCellRenderer tcr1 = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        tcr1.setHorizontalAlignment(SwingConstants.RIGHT);
        model = Tablas.VaciarTabla(Tabla);
        String[] Co = {"CODIGO", "NOMBRE", "CANTIDAD FALTANTES", "CANTIDAD_MINIMA", "ESTADO"};
        String[] Filas = new String[5];
        model = new DefaultTableModel(null, Co);
        Tabla.setShowGrid(true);
        for (int i = 0; i < lista.size(); i++) {
            Filas[0] = "" + lista.get(i).getId_producto().toString();
            Filas[1] = lista.get(i).getNombre();
            Filas[2] = lista.get(i).getCantidad_faltantes().toString();
            Filas[3] = lista.get(i).getCantidad_minima().toString();
            Filas[4] = lista.get(i).getEstado();
//            Filas[5] = lista.get(i).getTotal().toString();

            model.addRow(Filas);
            Tabla.setModel(model);
            Tabla.getColumnModel().getColumn(0).setPreferredWidth(a[0]);
            Tabla.getColumnModel().getColumn(0).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(1).setPreferredWidth(a[1]);
            Tabla.getColumnModel().getColumn(1).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(2).setPreferredWidth(a[2]);
            Tabla.getColumnModel().getColumn(2).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(3).setPreferredWidth(a[3]);
            Tabla.getColumnModel().getColumn(3).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(4).setPreferredWidth(a[4]);
            Tabla.getColumnModel().getColumn(4).setCellRenderer(tcr);
//            Tabla.getColumnModel().getColumn(5).setPreferredWidth(a[5]);
//            Tabla.getColumnModel().getColumn(5).setCellRenderer(tcr);
        }

    }

    public static void cargarFaltantesB(JTable Tabla, ArrayList<Faltantes> lista) {
//        for (int i = 0; i < lista.size(); i++) {
//            System.out.println("tabla: " + lista.get(i).getTotal().toString());
//        }

        int[] a = {10, 30, 32, 52, 15, 30};
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        DefaultTableCellRenderer tcr1 = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        tcr1.setHorizontalAlignment(SwingConstants.RIGHT);
        model = Tablas.VaciarTabla(Tabla);
        String[] Co = {"CODIGO", "MARCA", "PRODUCTO", "DESCRIPCION", "CANTIDAD"};
        String[] Filas = new String[5];
        model = new DefaultTableModel(null, Co);
        Tabla.setShowGrid(true);
        for (int i = 0; i < lista.size(); i++) {
            Filas[0] = "" + lista.get(i).getId_producto().toString();
            Filas[1] = lista.get(i).getMarcas();
            Filas[2] = lista.get(i).getNombre();
            Filas[3] = lista.get(i).getDescripcion();
            Filas[4] = lista.get(i).getTotal().toString();

            model.addRow(Filas);
            Tabla.setModel(model);
            Tabla.getColumnModel().getColumn(0).setPreferredWidth(a[0]);
            Tabla.getColumnModel().getColumn(0).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(1).setPreferredWidth(a[1]);
            Tabla.getColumnModel().getColumn(1).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(2).setPreferredWidth(a[2]);
            Tabla.getColumnModel().getColumn(2).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(3).setPreferredWidth(a[3]);
            Tabla.getColumnModel().getColumn(3).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(4).setPreferredWidth(a[4]);
            Tabla.getColumnModel().getColumn(4).setCellRenderer(tcr);

        }
    }

    public static void cargarJoinPrecioNotaPedido(JTable Tabla, ArrayList<ListarJoinPrecioNotaPedido> lista) {

        int[] a = {100, 200, 200, 100};
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        DefaultTableCellRenderer tcr1 = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        tcr1.setHorizontalAlignment(SwingConstants.RIGHT);
        model = Tablas.VaciarTabla(Tabla);
        String[] Co = {"CODIGO", "PRODUCTO", "DESCRIPCION", "PRECIO"};
        String[] Filas = new String[4];
        model = new DefaultTableModel(null, Co);
        Tabla.setShowGrid(true);
        for (int i = 0; i < lista.size(); i++) {

            Filas[0] = "" + lista.get(i).getId_precio();
            Filas[1] = lista.get(i).getNombre();
            Filas[2] = lista.get(i).getDescripcion();
            Filas[3] = lista.get(i).getPrecio_compra().toString();
//            Filas[4] = lista.get(i).getIva();

            model.addRow(Filas);
            Tabla.setModel(model);
            Tabla.getColumnModel().getColumn(0).setPreferredWidth(a[0]);
            Tabla.getColumnModel().getColumn(0).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(1).setPreferredWidth(a[1]);
            Tabla.getColumnModel().getColumn(1).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(2).setPreferredWidth(a[2]);
            Tabla.getColumnModel().getColumn(2).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(3).setPreferredWidth(a[3]);
            Tabla.getColumnModel().getColumn(3).setCellRenderer(tcr);
//            Tabla.getColumnModel().getColumn(4).setPreferredWidth(a[4]);
//            Tabla.getColumnModel().getColumn(4).setCellRenderer(tcr);
        }

    }
    public static void ListarConvertidorProductos(ArrayList<listarJoinProductosCompras> lista, JTable Tabla) {
        int[] a = {90, 150, 160, 100, 100, 100, 100, 100, 100};
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        DefaultTableCellRenderer tcr1 = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        tcr1.setHorizontalAlignment(SwingConstants.RIGHT);
        model = Tablas.VaciarTabla(Tabla);
        String[] Co = {"CODIGO", "PRODUCTO", "DESCRIPCION", "PRECIO COMPRA", "STOCK","TIPO","MEDIDA","ENVASE","MARCA" };
        //   Date[] Ca = {Date.valueOf("Fecha")};
        String[] Filas = new String[9];
        //  Date[] Fila = new Date [1];
        model = new DefaultTableModel(null, Co);
        //  laboratorio = new DefaultTableModel(null, Ca);
        Tabla.setShowGrid(true);
        for (int i = 0; i < lista.size(); i++) {
            Filas[0] = lista.get(i).getId_productos().toString();
            Filas[1] = lista.get(i).getNombreProductos();
            Filas[2] = lista.get(i).getDescripcion();
            Filas[3] = Formato_Numeros.formatoNumero(lista.get(i).getPrecioCompra().toString());
            //Filas[4] = Formato_Numeros.formatoNumero(lista.get(i).getPrecio_venta().toString());
            Filas[4] = lista.get(i).getCantidadStock().toString();
            Filas[5] = lista.get(i).getNombreTipo();
            Filas[6] = lista.get(i).getNombreMedida();
            Filas[7] = lista.get(i).getNombreEnvase();
            Filas[8] = lista.get(i).getNombreMarca();

            model.addRow(Filas);
            //     laboratorio.addRow(Fila);
            Tabla.setModel(model);
            Tabla.getColumnModel().getColumn(0).setPreferredWidth(a[0]);
            Tabla.getColumnModel().getColumn(0).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(1).setPreferredWidth(a[1]);
            Tabla.getColumnModel().getColumn(1).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(2).setPreferredWidth(a[2]);
            Tabla.getColumnModel().getColumn(2).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(3).setPreferredWidth(a[3]);
            Tabla.getColumnModel().getColumn(3).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(4).setPreferredWidth(a[4]);
            Tabla.getColumnModel().getColumn(4).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(5).setPreferredWidth(a[5]);
            Tabla.getColumnModel().getColumn(5).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(6).setPreferredWidth(a[6]);
            Tabla.getColumnModel().getColumn(6).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(7).setPreferredWidth(a[7]);
            Tabla.getColumnModel().getColumn(7).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(8).setPreferredWidth(a[8]);
            Tabla.getColumnModel().getColumn(8).setCellRenderer(tcr);

        }

    }
    public static void CargarJoinCantidadCompras(JTable Tabla, ArrayList<Cantidad_compras> lista) {

        int[] a = {65, 65, 150, 150, 130, 135, 135};
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        DefaultTableCellRenderer tcr1 = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.LEFT);
        tcr1.setHorizontalAlignment(SwingConstants.RIGHT);
        model = Tablas.VaciarTabla(Tabla);
        String[] Co = {"ID", "PRODUCTO", "DESCRIPCION", "CANTIDAD COMPRADO", "TOTAL $"};
        String[] Filas = new String[5];
        model = new DefaultTableModel(null, Co);
        Tabla.setShowGrid(true);
        for (int i = 0; i < lista.size(); i++) {

            Filas[0] = "" + lista.get(i).getId_producto();
            Filas[1] = "" + lista.get(i).getNombre();
            Filas[2] = "" + lista.get(i).getDescripcion();
            Filas[3] = "" + lista.get(i).getCantidad_comprado();
            Filas[4] = Formato_Numeros.formatoNumero("" + lista.get(i).getTotal());

            model.addRow(Filas);
            Tabla.setModel(model);
            Tabla.getColumnModel().getColumn(0).setPreferredWidth(a[0]);
            Tabla.getColumnModel().getColumn(0).setCellRenderer(tcr1);
            Tabla.getColumnModel().getColumn(1).setPreferredWidth(a[1]);
            Tabla.getColumnModel().getColumn(1).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(2).setPreferredWidth(a[2]);
            Tabla.getColumnModel().getColumn(2).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(3).setPreferredWidth(a[3]);
            Tabla.getColumnModel().getColumn(3).setCellRenderer(tcr1);
            Tabla.getColumnModel().getColumn(4).setPreferredWidth(a[4]);
            Tabla.getColumnModel().getColumn(4).setCellRenderer(tcr1);

        }
    }

    public static void CargarJoinCantidadVentas(JTable Tabla, ArrayList<Cantidad_Ventas> lista) {

        int[] a = {65, 65, 150, 150, 130, 135, 135};
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        DefaultTableCellRenderer tcr1 = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.LEFT);
        tcr1.setHorizontalAlignment(SwingConstants.RIGHT);
        model = Tablas.VaciarTabla(Tabla);
        String[] Co = {"ID", "PRODUCTO", "DESCRIPCION", "CANTIDAD VENTA", "TOTAL $"};
        String[] Filas = new String[5];
        model = new DefaultTableModel(null, Co);
        Tabla.setShowGrid(true);
        for (int i = 0; i < lista.size(); i++) {

            Filas[0] = "" + lista.get(i).getId_productos();
            Filas[1] = "" + lista.get(i).getNombre();
            Filas[2] = "" + lista.get(i).getDescripcion();
            Filas[3] = "" + lista.get(i).getTotal_venta();
            Filas[4] = Formato_Numeros.formatoNumero("" + lista.get(i).getTotal());

            model.addRow(Filas);
            Tabla.setModel(model);
            Tabla.getColumnModel().getColumn(0).setPreferredWidth(a[0]);
            Tabla.getColumnModel().getColumn(0).setCellRenderer(tcr1);
            Tabla.getColumnModel().getColumn(1).setPreferredWidth(a[1]);
            Tabla.getColumnModel().getColumn(1).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(2).setPreferredWidth(a[2]);
            Tabla.getColumnModel().getColumn(2).setCellRenderer(tcr);
            Tabla.getColumnModel().getColumn(3).setPreferredWidth(a[3]);
            Tabla.getColumnModel().getColumn(3).setCellRenderer(tcr1);
            Tabla.getColumnModel().getColumn(4).setPreferredWidth(a[4]);
            Tabla.getColumnModel().getColumn(4).setCellRenderer(tcr1);

        }

    }
}
