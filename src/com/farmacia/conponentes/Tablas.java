/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmacia.conponentes;

//import com.objetos.domain.Laboratorio;
//import com.objetos.fecha.Fecha;
import com.farmacia.dao.Consultas;
import com.farmacia.join_entidades.FaltantesCabeceraDetalles;
import com.farmacia.join_entidades.ListarJoinProveedor;
import com.farmacia.join_entidades.ListarNotas;
import com.farmacia.join_entidades.joinProductoDetallesFaltantes;
import com.farmacia.join_entidades.listarJoinProductosCompras;
import com.farmacia.entities1.Clientes;
import com.farmacia.entities1.EnvaseProducto;
import com.farmacia.entities1.Iva;
import com.farmacia.entities1.Laboratorio;
import com.farmacia.entities1.ListarPuntoVenta;
import com.farmacia.entities1.Listar_usuario;
import com.farmacia.entities1.MarcaProducto;
import com.farmacia.entities1.MedidaProducto;
import com.farmacia.entities1.Persona;
import com.farmacia.entities1.Precios;
import com.farmacia.entities1.TipoProducto;
import com.farmacia.fecha.Fecha;
import com.farmacia.join_entidades.JoinListarDetalleNotaPedido;
import com.farmacia.join_entidades.JoinListarNotaPedidosCabecera;
import com.farmacia.join_entidades.JoinListarProductosVentas;
import com.farmacia.join_entidades.ListarJoinProveedorNotaPedido;
import com.farmacia.join_entidades.listarJoinProductosNotaPedidos;
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
    private boolean[] editable = {false, false, false, false, true, false};
//=======
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
        String[] Co = {"Cedula", "Nombre", "Apellido", "Direccion", "Fecha_reg"};
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
        String[] Co = {"ID", "Tipo"};
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
        String[] Co = {"ID", "Tipo"};
        String[] Filas = new String[2];
        model = new DefaultTableModel(null, Co);
        Tabla.setShowGrid(true);
        for (int i = 0; i < lista.size(); i++) {
            Filas[0] = String.valueOf(lista.get(i).getId_envase());
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
        String[] Co = {"#", "Medidas"};
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
            Filas[5] = lista.get(i).getFecha_creacion();
            Filas[6] = "" + lista.get(i).getIva().toString();
            Filas[7] = "" + lista.get(i).getDescuento().toString();
            Filas[8] = "" + lista.get(i).getTotal().toString();

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

        int[] a = {5, 5, 52, 90, 150, 110, 15, 50};
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        DefaultTableCellRenderer tcr1 = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        tcr1.setHorizontalAlignment(SwingConstants.RIGHT);
        model = Tablas.VaciarTabla(Tabla);
        String[] Co = {"N° ORDEN", "CODIGO", "PROVEEDOR", "REPRESENTANTE", "TELEFONO", "FECHA DE CREACION", "PLAZO", "TOTAL"};
        String[] Filas = new String[9];
        model = new DefaultTableModel(null, Co);
        Tabla.setShowGrid(true);
        for (int i = 0; i < lista.size(); i++) {
            Filas[0] = "" + lista.get(i).getId_cabecera_nota_pedidos().toString();
            Filas[1] = lista.get(i).getId_proveedor().toString();
            Filas[2] = lista.get(i).getEntidad();
            Filas[3] = lista.get(i).getRepresentante();
            Filas[4] = lista.get(i).getTelefono();
            Filas[5] = lista.get(i).getFecha_creacion();
            Filas[6] = "" + lista.get(i).getPlazo();
            Filas[7] = "" + lista.get(i).getTotal().toString();

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

    public static void cargarJoinProductoIngresoNotas(JTable Tabla, ArrayList<joinProductoDetallesFaltantes> lista) {

        int[] a = {10, 30, 32, 70, 15, 30, 10,10 ,10, 20, 10, 5};
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        DefaultTableCellRenderer tcr1 = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        tcr1.setHorizontalAlignment(SwingConstants.RIGHT);
        model = Tablas.VaciarTabla(Tabla);
        String[] Co = {"CODIGO", "MARCA", "TIPO", "PRODUCTO", "ENVASE", "MEDIDA","BONO", "CANTIDAD", "PRECIO", "DESCUENTO", "IVA", "TOTAL"};
        String[] Filas = new String[12];
        model = new DefaultTableModel(null, Co);
        Tabla.setShowGrid(true);
        for (int i = 0; i < lista.size(); i++) {
            int Cantidad = lista.get(i).getCantidad();
            Double Precio = lista.get(i).getPrecios();
            Precio = redondearDecimales(Precio, 2);
            Double PorcDesc = lista.get(i).getPorcentaje_descuento();
            Double ValorDes = Cantidad * Precio * PorcDesc / 100;
            ValorDes = redondearDecimales(ValorDes, 2);
            Double PrecioTotal = Cantidad * Precio;
            PrecioTotal = redondearDecimales(PrecioTotal, 2);
            Double iva = 0.12;
            Double iva1 = 0.00;
            
            int Bono = lista.get(i).getBono();
            int CantidadTotal = Bono + Cantidad;
            Double PrecioBono = PrecioTotal / CantidadTotal;
            PrecioBono = redondearDecimales(PrecioBono, 2);
            Filas[0] = "" + lista.get(i).getId_producto().toString();
            Filas[1] = lista.get(i).getMarca();
            Filas[2] = lista.get(i).getNombre_tipo();
            Filas[3] = lista.get(i).getNombre_producto();
            Filas[4] = lista.get(i).getEnvase();
            Filas[5] = lista.get(i).getMedida();
            Filas[6] = ""+Bono;
            Filas[7] = ""+CantidadTotal;
            Filas[8] = ""+PrecioBono;
            Filas[9] = "" + ValorDes;
            if (lista.get(i).getIva().equals("SI")) {
                iva1 = Cantidad * iva * Precio;
                iva1 = redondearDecimales(iva1, 2);
                Filas[10] = "" + iva1;
                Double importe = Cantidad * Precio + iva1 - ValorDes;
                importe = redondearDecimales(importe, 2);
                Filas[11] = "" + importe;
            }
            if (lista.get(i).getIva().equals("NO")) {
                Filas[10] = "" + 0;
                Double importe = Cantidad * Precio - ValorDes;
                importe = redondearDecimales(importe, 2);
                Filas[11] = "" + importe;
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
            Tabla.getColumnModel().getColumn(11).setPreferredWidth(a[11]);
            Tabla.getColumnModel().getColumn(11).setCellRenderer(tcr);
        }

    }
     
    public static double redondearDecimales(double valorInicial, int numeroDecimales) {
        double parteEntera, resultado;
        resultado = valorInicial;
        parteEntera = Math.floor(resultado);
        resultado = (resultado - parteEntera) * Math.pow(10, numeroDecimales);
        resultado = Math.round(resultado);
        resultado = (resultado / Math.pow(10, numeroDecimales)) + parteEntera;
        return resultado;
    }

    public static void cargarFiltroProductosNota(JTable Tabla, ArrayList<listarJoinProductosNotaPedidos> lista) {

        int[] a = {10, 30, 32, 52, 15, 30, 10, 10};
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        DefaultTableCellRenderer tcr1 = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        tcr1.setHorizontalAlignment(SwingConstants.RIGHT);
        model = Tablas.VaciarTabla(Tabla);
        String[] Co = {"CODIGO", "MARCA", "TIPO", "PRODUCTO", "ENVASE", "MEDIDA", "CANTIDAD", "PRECIO"};
        String[] Filas = new String[8];
        model = new DefaultTableModel(null, Co);
        Tabla.setShowGrid(true);
        for (int i = 0; i < lista.size(); i++) {
            Filas[0] = lista.get(i).getId_productos().toString();
            Filas[1] = lista.get(i).getNombreMarca();
            Filas[2] = lista.get(i).getNombreTipo();
            Filas[3] = lista.get(i).getNombreProductos();
            Filas[4] = lista.get(i).getNombreEnvase();
            Filas[5] = lista.get(i).getNombreMedida();
            Filas[6] = "" + lista.get(i).getCantidad();
            Filas[7] = "" + lista.get(i).getPrecio();
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

    ////////////////////////////
    public static void cargarJoinProductoDetallesFaltantes(JTable Tabla, ArrayList<joinProductoDetallesFaltantes> lista) {

        int[] a = {10, 30, 32, 52, 15, 15, 15, 10};
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        DefaultTableCellRenderer tcr1 = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        tcr1.setHorizontalAlignment(SwingConstants.RIGHT);
        model = Tablas.VaciarTabla(Tabla);
        String[] Co = {"CODIGO", "MARCA", "TIPO", "PRODUCTO", "ENVASE", "MEDIDA", "CANTIDAD", "PRECIO"};
        String[] Filas = new String[8];
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
            Filas[7] = lista.get(i).getPrecios().toString();

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

    public static void cargarJoinPuntoVenta(JTable Tabla, ArrayList<ListarPuntoVenta> lista) {

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

    public static void cargarJoinUsuario(JTable Tabla, ArrayList<Listar_usuario> lista) {

        int[] a = {10, 50, 40, 52, 52, 80, 30, 30, 52, 30, 30, 40, 30, 10, 80};
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        DefaultTableCellRenderer tcr1 = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.LEFT);
        tcr1.setHorizontalAlignment(SwingConstants.CENTER);
        model = VaciarTabla(Tabla);
        String[] Co = {"Codigo", "Fecha de registro", "Cedula", "Apellidos", "Nombres", "Direccion", "celular", "Convencional",
            "Correo", "Cargo", "Genero", "Discapacidad", "Porcentaje", "estado", "Observacion"};
        String[] Filas = new String[15];
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
            Filas[7] = lista.get(i).getConvencional();
            Filas[8] = lista.get(i).getCorreo();
            Filas[9] = lista.get(i).getCargo();
            Filas[10] = lista.get(i).getGenero();
            Filas[11] = lista.get(i).getDiscapacidad();
            Filas[12] = lista.get(i).getPorcentaje();
            Filas[13] = lista.get(i).getEstado();
            Filas[14] = lista.get(i).getObservacion();
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
            Tabla.getColumnModel().getColumn(14).setPreferredWidth(a[14]);
            Tabla.getColumnModel().getColumn(14).setCellRenderer(tcr);
        }
    }

    public void visualizar(JTable tabla, Long id) {//1

        tabla.setDefaultRenderer(Object.class, new Render());
        DefaultTableModel dt = new DefaultTableModel(new String[]{"CODIGO PRECIO", "CODIGO PRODUCTO", "PRECIO COMPRA", "PRECIO VENTA", "ESTADO",}, 0) {

            Class[] types = new Class[]{
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.Object.class
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
        ArrayList<Precios> list = llamar.listarPrecioCompra("SELECT id_precio,`id_producto`,`precio_compra`,`precio_venta`, estado FROM `precios` WHERE `id_producto`= " + id);

        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                // model.addRow(new Object[]{});
                Object fila[] = new Object[6];
                vo = list.get(i);
                fila[0] = vo.getId_precio();
                fila[1] = vo.getId_producto();
                fila[2] = vo.getPrecio_compra();
                fila[3] = vo.getPrecio_venta();
                String ac = (String) vo.getEstado();
                if ("A".equals(ac)) {
                    fila[4] = true;
                } else {
                    fila[4] = false;
                }
                //  fila[5] = btn_visualizar;

                dt.addRow(fila);

            }

        }

        tabla.setModel(dt);

    }

    public static void cargarJoinRegistroDetalleNotas(JTable Tabla, ArrayList<JoinListarDetalleNotaPedido> lista) {

        int[] a = {10, 30, 32, 70, 15, 30,10, 10, 10, 20, 10, 5};
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        DefaultTableCellRenderer tcr1 = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        tcr1.setHorizontalAlignment(SwingConstants.RIGHT);
        model = Tablas.VaciarTabla(Tabla);
        String[] Co = {"CODIGO", "MARCA", "TIPO", "PRODUCTO", "ENVASE", "MEDIDA", "CANTIDAD","BONO", "PRECIO", "DESCUENTO", "IVA", "TOTAL"};
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
            System.out.println("bono "+lista.get(i).getBono());
            Filas[7] = "" + lista.get(i).getBono();
            Filas[8] = lista.get(i).getPrecio().toString();
            Filas[9] = lista.get(i).getDescuento().toString();
            Filas[10] = lista.get(i).getIva().toString();
            Filas[11] = lista.get(i).getTotal().toString();
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
            Filas[8] = lista.get(i).getPrecio().toString();
            Filas[9] = lista.get(i).getDescuento().toString();
            Filas[10] = lista.get(i).getIva().toString();
            Filas[11] = lista.get(i).getTotal().toString();
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

        int[] a = {10, 30, 52, 30, 30, 30, 30, 30, 30, 30};
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        DefaultTableCellRenderer tcr1 = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        tcr1.setHorizontalAlignment(SwingConstants.RIGHT);
        model = Tablas.VaciarTabla(Tabla);
        String[] Co = {"CODIGO", "PRODUCTO", "DESCRIPCION", "TIPO", "MEDIDA", "ENVASE", "MARCA", "STOCK", "IVA", "PRECIO VENTA"};
        String[] Filas = new String[10];
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

}
