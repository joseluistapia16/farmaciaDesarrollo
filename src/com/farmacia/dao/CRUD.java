/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmacia.dao;

import com.farmacia.dao.PruebasDecimales.Prueba;
import com.farmacia.entities.mappers.EntidadesMappers;
import com.farmacia.entities1.Bitacora_seguridad;
import com.farmacia.entities1.CabeceraNotaPedido;
import com.farmacia.entities1.Cabecera_compra;
import com.farmacia.entities1.Cabecera_ventas;
import com.farmacia.join_entidades.FaltantesCabeceraDetalles;
import com.farmacia.join_entidades.ListarJoinProveedor;
import com.farmacia.join_entidades.joinProductoDetallesFaltantes;
import com.farmacia.join_entidades.listarJoinProductosCompras;
import com.farmacia.entities1.Correo;
import com.farmacia.entities1.DetalleNotaPedido;
import com.farmacia.entities1.Detalle_compra;
import com.farmacia.entities1.Detalle_ventas;
import com.farmacia.entities1.EnvaseProducto;
import com.farmacia.entities1.Estado_usuario;
import com.farmacia.entities1.Faltantes;
import com.farmacia.entities1.Genero;
import com.farmacia.entities1.Iva;
import com.farmacia.entities1.Laboratorio;
import com.farmacia.entities1.Listar_usuario;
import com.farmacia.entities1.MedidaProducto;
import com.farmacia.entities1.Productos;
import com.farmacia.entities1.MarcaProducto;
import com.farmacia.entities1.Nombre_local;
import com.farmacia.entities1.Obcx;
import com.farmacia.entities1.Persona;
import com.farmacia.entities1.Precios;
import com.farmacia.entities1.Productos_Stock;
import com.farmacia.entities1.Punto_venta;
import com.farmacia.entities1.Punto_venta_usuario;
import com.farmacia.entities1.Rol;
import com.farmacia.entities1.Rol_U;
import com.farmacia.entities1.StockVentas;
import com.farmacia.entities1.Telefono;
import com.farmacia.entities1.TipoProducto;
import com.farmacia.entities1.Usuario;
import com.farmacia.entities1.Usuario_S;
import com.farmacia.entities1.fc_localidad_guayas;
import com.farmacia.join_entidades.JoinListarCabeceraVenta;
import com.farmacia.join_entidades.JoinListarDetalleNotaPedido;
import com.farmacia.join_entidades.JoinListarNotaPedidosCabecera;
import com.farmacia.join_entidades.JoinListarProductosVentas;
import com.farmacia.join_entidades.ListarJoinPrecioNotaPedido;
import com.farmacia.join_entidades.ListarJoinProveedorNotaPedido;
import com.farmacia.join_entidades.listarJoinProductosNotaPedidos;
import com.farmacia.validaciones.ValidarIngresoProducto;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class CRUD {

    Connection conect = null;
    java.sql.Statement st = null;
    ResultSet rs = null;
    PreparedStatement ps;
    Conexion con = new Conexion();

    String query;

    public void insertarListaFaltantes(ArrayList<String> queryL) {
        try {
            conect = con.conectar();
            for (int i = 0; i < queryL.size(); i++) {
                java.sql.Statement st = conect.createStatement();
                st.executeUpdate(queryL.get(i));
            }
            conect.close();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String insertarCabeceraCompras(Cabecera_compra obj) {
        String valor = "";
        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement prodProAlm = conect.prepareCall(
                    "{ call insertarCabceraCompras(?,?,?,?,?,?,?,?,?,?,?) }");
            prodProAlm.setLong(1, obj.getId_proveedor());
            prodProAlm.setLong(2, obj.getId_usuario());
            prodProAlm.setString(3, obj.getFecha_creacion());
            prodProAlm.setString(4, obj.getPlazo());
            prodProAlm.setLong(5, obj.getId_sucursal());
            prodProAlm.setString(6, obj.getId_tipoPago());
            prodProAlm.setBigDecimal(7, obj.getIva());
            prodProAlm.setBigDecimal(8, obj.getDescuento());
            prodProAlm.setBigDecimal(9, obj.getTotal());
            prodProAlm.setDouble(10, obj.getIdcabecerapedido());
            prodProAlm.registerOutParameter("valor", Types.VARCHAR);
            prodProAlm.executeUpdate();
            valor = prodProAlm.getString("valor");

            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return valor;
    }

    public String buscarIDPrecioEnStock(String query) {
        String id = "";
        try {
            conect = con.conectar();

            java.sql.Statement st = conect.createStatement();
            rs = st.executeQuery(query);
            rs.next();
            id = rs.getString("id_precio");
            conect.close();
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;

    }

    public int buscarCantidadEnStock(String query) {
        int id = 0;
        try {
            conect = con.conectar();

            java.sql.Statement st = conect.createStatement();
            rs = st.executeQuery(query);
            rs.next();
            id = rs.getInt("cantidad");
            conect.close();
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;

    }

    public int buscarCantidadEnFaltantes(String query) {
        int id = 0;
        try {
            conect = con.conectar();

            java.sql.Statement st = conect.createStatement();
            rs = st.executeQuery(query);
            rs.next();
            id = rs.getInt("cantidad");
            conect.close();
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;

    }

    //cambie a uno por uno
    public void insertarDetallesCompra(ArrayList<String> queryL) {
        try {
            conect = con.conectar();
            for (int i = 0; i < queryL.size(); i++) {
                java.sql.Statement st = conect.createStatement();
                st.executeUpdate(queryL.get(i));
            }
            conect.close();
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void insertarDetallesCompraRegistro(String queryL) {
        try {
            conect = con.conectar();
//            for (int i = 0; i < queryL.size(); i++) {
            java.sql.Statement st = conect.createStatement();
            st.executeUpdate(queryL);
            //}
            conect.close();
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void UpdateCantidadFaltantes(String queryL) {
        try {
            conect = con.conectar();
//            for (int i = 0; i < queryL.size(); i++) {
            java.sql.Statement st = conect.createStatement();
            st.executeUpdate(queryL);
            //}
            conect.close();
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void insertarBitacoraFaltantes(ArrayList<String> queryL) {
        try {
            conect = con.conectar();
            for (int i = 0; i < queryL.size(); i++) {
                java.sql.Statement st = conect.createStatement();
                st.executeUpdate(queryL.get(i));
            }
            conect.close();
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ArrayList<Productos> listarProductos(String Query) {
        ArrayList<Productos> lista = new ArrayList<Productos>();

        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement prcProcedimientoAlmacenado = conect.prepareCall(
                    "{ call listarProductos() }");
            prcProcedimientoAlmacenado.execute();
            rs = prcProcedimientoAlmacenado.getResultSet();
            while (rs.next()) {
                Productos obj = EntidadesMappers.getProductosFromResultSet(rs);
                lista.add(obj);
            }
            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lista;
    }

    public ArrayList<FaltantesCabeceraDetalles> listarJoinProductos(int op) {
        ArrayList<FaltantesCabeceraDetalles> lista = new ArrayList<FaltantesCabeceraDetalles>();

        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement prcProcedimientoAlmacenado = conect.prepareCall(
                    "{ call listarJoinProductos(?) }");
            prcProcedimientoAlmacenado.setInt(1, op);
            prcProcedimientoAlmacenado.execute();
            rs = prcProcedimientoAlmacenado.getResultSet();
            while (rs.next()) {
                FaltantesCabeceraDetalles obj = EntidadesMappers.getJoinProductosFromResultSet(rs);
                lista.add(obj);
            }
            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lista;
    }

    public ArrayList<joinProductoDetallesFaltantes> listarFaltantesDetalles(int op) {
        ArrayList<joinProductoDetallesFaltantes> lista = new ArrayList<joinProductoDetallesFaltantes>();

        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement prcProcedimientoAlmacenado = conect.prepareCall(
                    "{ call listarfaltantesEnNota(?) }");
            prcProcedimientoAlmacenado.setInt(1, op);
            prcProcedimientoAlmacenado.execute();
            rs = prcProcedimientoAlmacenado.getResultSet();
            while (rs.next()) {
                joinProductoDetallesFaltantes obj = EntidadesMappers.getJoinDetallesFaltantesFromResultSet(rs);
                lista.add(obj);
            }
            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lista;
    }

    public ArrayList<listarJoinProductosCompras> listarTodoJoinProductos(int op) {
        ArrayList<listarJoinProductosCompras> lista = new ArrayList<listarJoinProductosCompras>();

        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement prcProcedimientoAlmacenado = conect.prepareCall(
                    "{ call listarPoductosCompras(?) }");
            prcProcedimientoAlmacenado.setInt(1, op);
            prcProcedimientoAlmacenado.execute();
            rs = prcProcedimientoAlmacenado.getResultSet();
            while (rs.next()) {
                listarJoinProductosCompras obj = EntidadesMappers.getJoinTodosProductosFromResultSet(rs);
                lista.add(obj);
            }
            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lista;
    }

    public ArrayList<TipoProducto> listarTodoTipoProductos1() {
        ArrayList<TipoProducto> lista = new ArrayList<TipoProducto>();

        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement prcProcedimientoAlmacenado = conect.prepareCall(
                    "{ call listarComboTipoPro }");
            //   prcProcedimientoAlmacenado.setInt(1, op);
            prcProcedimientoAlmacenado.execute();
            rs = prcProcedimientoAlmacenado.getResultSet();
            while (rs.next()) {
                TipoProducto obj = EntidadesMappers.getTipoProductoFromResultSet(rs);
                lista.add(obj);
            }

            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lista;
    }

    public ArrayList<MedidaProducto> listarTodoMedidasProductos() {
        ArrayList<MedidaProducto> lista = new ArrayList<MedidaProducto>();

        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement prcProcedimientoAlmacenado = conect.prepareCall(
                    "{ call listarComboMedidaPro }");
            //   prcProcedimientoAlmacenado.setInt(1, op);
            prcProcedimientoAlmacenado.execute();
            rs = prcProcedimientoAlmacenado.getResultSet();
            while (rs.next()) {
                MedidaProducto obj = EntidadesMappers.getMedidaProductoFromResultSet(rs);
                lista.add(obj);
            }

            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lista;
    }

    public ArrayList<EnvaseProducto> listarTodoEnvaseProductos() {
        ArrayList<EnvaseProducto> lista = new ArrayList<EnvaseProducto>();

        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement prcProcedimientoAlmacenado = conect.prepareCall(
                    "{ call listarComboEnvasePro }");
            //   prcProcedimientoAlmacenado.setInt(1, op);
            prcProcedimientoAlmacenado.execute();
            rs = prcProcedimientoAlmacenado.getResultSet();
            while (rs.next()) {
                EnvaseProducto obj = EntidadesMappers.getEnvaseProductoFromResultSet(rs);
                lista.add(obj);
            }

            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lista;
    }

    public ArrayList<MarcaProducto> listarTodoMarcaProductos() {
        ArrayList<MarcaProducto> lista = new ArrayList<MarcaProducto>();

        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement prcProcedimientoAlmacenado = conect.prepareCall(
                    "{ call listarComboMarcaPro }");
            //   prcProcedimientoAlmacenado.setInt(1, op);
            prcProcedimientoAlmacenado.execute();
            rs = prcProcedimientoAlmacenado.getResultSet();
            while (rs.next()) {
                MarcaProducto obj = EntidadesMappers.getMarcaProductoFromResultSet(rs);
                lista.add(obj);
            }

            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lista;
    }

    public ArrayList<Iva> listarTodoIvaProducto() {
        ArrayList<Iva> lista = new ArrayList<Iva>();

        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement prcProcedimientoAlmacenado = conect.prepareCall(
                    "{ call listarComboIva }");
            //   prcProcedimientoAlmacenado.setInt(1, op);
            prcProcedimientoAlmacenado.execute();
            rs = prcProcedimientoAlmacenado.getResultSet();
            while (rs.next()) {
                Iva obj = EntidadesMappers.getIvaProductoFromResultSet(rs);
                lista.add(obj);
            }

            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lista;
    }

    public String insertarProductoNuevo(Productos obj) {
        //ArrayList<Productos> lista = new ArrayList<Productos>();
        String valor = "";
        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement prodProAlm = conect.prepareCall(
                    "{ call ingresarProducto(?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");
            prodProAlm.setString(1, obj.getNombre());
            prodProAlm.setString(2, obj.getDescripcion());
            prodProAlm.setDate(3, obj.getFecha_registro());
            prodProAlm.setDouble(4, obj.getPeso());
            prodProAlm.setLong(5, obj.getId_tipo());
            prodProAlm.setLong(6, obj.getId_medidas());
            prodProAlm.setLong(7, obj.getId_envase());
            prodProAlm.setLong(8, obj.getId_marcas());
            prodProAlm.setLong(9, obj.getId_usuario());
            prodProAlm.setString(10, obj.getIva());
            prodProAlm.setLong(11, obj.getCantidad_minima());
            prodProAlm.setString(12, obj.getReceta());
            prodProAlm.setLong(13, obj.getDescuento_venta());
            prodProAlm.registerOutParameter("valor1", Types.VARCHAR);
            prodProAlm.executeUpdate();
            valor = prodProAlm.getString("valor1");
            //  rs = prodProAlm.getResultSet();
//            while (rs.next()) {
//                MarcaProducto obj = EntidadesMappers.getMarcaProductoFromResultSet(rs);
//                lista.add(obj);
//            }

            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return valor;
    }

    public ArrayList<ListarJoinProveedor> listarProveedores(Long op) {
        ArrayList<ListarJoinProveedor> lista = new ArrayList<ListarJoinProveedor>();

        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement prodProAlm = conect.prepareCall(
                    "{ call ListarProveedor(?) }");
            prodProAlm.setLong(1, op);
            prodProAlm.execute();
            rs = prodProAlm.getResultSet();
            while (rs.next()) {
                ListarJoinProveedor obj = EntidadesMappers.getListarJoinProveedorFromResultSet(rs);
                lista.add(obj);
            }
            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lista;
    }
    //////////////////////////////////////////////////////////////////////////////////////////

    public ArrayList<listarJoinProductosCompras> filtroBusquedaProducto(String query) {
        ArrayList<listarJoinProductosCompras> lista = new ArrayList<listarJoinProductosCompras>();

        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement prcProcedimientoAlmacenado = conect.prepareCall(
                    "{ call filtroProducto(?) }");
            prcProcedimientoAlmacenado.setString(1, query);
            prcProcedimientoAlmacenado.execute();
            rs = prcProcedimientoAlmacenado.getResultSet();
            while (rs.next()) {
                listarJoinProductosCompras obj = EntidadesMappers.getJoinTodosProductosFromResultSet(rs);
                lista.add(obj);
            }
            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lista;
    }

    public String getNombreComboProducto(Long op, Long id) {
        //ArrayList<Productos> lista = new ArrayList<Productos>();
        String valor = "";
        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement prodProAlm = conect.prepareCall(
                    "{ call getNombreComboProducto(?,?,?,?) }");
            prodProAlm.setLong(1, op);
            prodProAlm.setLong(2, id);
            prodProAlm.registerOutParameter("valor", Types.VARCHAR);
            prodProAlm.executeUpdate();
            valor = prodProAlm.getString("valor");
            //  rs = prodProAlm.getResultSet();
//            while (rs.next()) {
//                MarcaProducto obj = EntidadesMappers.getMarcaProductoFromResultSet(rs);
//                lista.add(obj);
//            }

            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return valor;
    }

    public String getCombosAcUsuarios(Long op, Long id) {
        //ArrayList<Productos> lista = new ArrayList<Productos>();
        String valor = "";
        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement prodProAlm = conect.prepareCall(
                    "{ call fc_combos_ac_usuarios(?,?,?) }");
            prodProAlm.setLong(1, op);
            prodProAlm.setLong(2, id);
            prodProAlm.registerOutParameter("valor", Types.VARCHAR);
            prodProAlm.executeUpdate();
            valor = prodProAlm.getString("valor");
            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return valor;
    }

    public String modificarProductos(Productos obj) {
        //ArrayList<Productos> lista = new ArrayList<Productos>();
        String valor = "";
        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement prodProAlm = conect.prepareCall(
                    "{ call modificarProductos(?,?,?,?,?,?,?,?,?,?,?,?) }");
            prodProAlm.setString(1, obj.getNombre());
            prodProAlm.setString(2, obj.getDescripcion());
            prodProAlm.setDouble(3, obj.getPeso());
            prodProAlm.setLong(4, obj.getId_tipo());
            prodProAlm.setLong(5, obj.getId_medidas());
            prodProAlm.setLong(6, obj.getId_envase());
            prodProAlm.setLong(7, obj.getId_marcas());
            prodProAlm.setLong(8, obj.getId_productos());
            prodProAlm.setLong(9, obj.getId_usuario());
            prodProAlm.setString(10, obj.getIva());
            prodProAlm.setLong(11, obj.getCantidad_minima());
            prodProAlm.registerOutParameter("valor", Types.VARCHAR);
            prodProAlm.execute();
            valor = prodProAlm.getString("valor");
            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return valor;
    }

    public String eliminarProducto(Long id) {
        //ArrayList<Productos> lista = new ArrayList<Productos>();
        String valor = "";
        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement prodProAlm = conect.prepareCall(
                    "{ call eliminarProducto(?,?) }");
            prodProAlm.setLong(1, id);
            prodProAlm.registerOutParameter("valor", Types.VARCHAR);
            prodProAlm.execute();
            valor = prodProAlm.getString("valor");
            //  rs = prodProAlm.getResultSet();
//            while (rs.next()) {
//                MarcaProducto obj = EntidadesMappers.getMarcaProductoFromResultSet(rs);
//                lista.add(obj);
//            }

            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return valor;
    }

    public ArrayList<Correo> listarCorreo(String query) {
        ArrayList<Correo> lista = new ArrayList();
        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement prcProcedimientoAlmacenado = conect.prepareCall(
                    "{ call filtroProducto(?) }");
            prcProcedimientoAlmacenado.setString(1, query);
            prcProcedimientoAlmacenado.execute();
            rs = prcProcedimientoAlmacenado.getResultSet();
            while (rs.next()) {
                Correo obj = EntidadesMappers.getCorreoFromResultSet(rs);
                lista.add(obj);
            }
            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lista;
    }

    public ArrayList<Telefono> listarTelefono(String query) {
        ArrayList<Telefono> lista = new ArrayList();
        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement prcProcedimientoAlmacenado = conect.prepareCall(
                    "{ call filtroProducto(?) }");
            prcProcedimientoAlmacenado.setString(1, query);
            prcProcedimientoAlmacenado.execute();
            rs = prcProcedimientoAlmacenado.getResultSet();
            while (rs.next()) {
                Telefono obj = EntidadesMappers.getTelefonoFromResultSet(rs);
                lista.add(obj);
            }
            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lista;
    }

    public String insertarProveedor(ListarJoinProveedor obj) {
        ArrayList<ListarJoinProveedor> lista = new ArrayList<ListarJoinProveedor>();
        String valor = "";
        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement prodProAlm = conect.prepareCall(
                    "{ call editarProveedor(?,?,?,?,?,?,?,?,?,?,?) }");
            prodProAlm.setLong(1, obj.getId_proveedor_clase());
            prodProAlm.setString(2, obj.getEntidad());
            prodProAlm.setString(3, obj.getRepresentante());
            prodProAlm.setString(4, obj.getDireccion());
            prodProAlm.setDate(5, obj.getFecha_registro());
            prodProAlm.setString(6, obj.getEstado());
            prodProAlm.setString(7, obj.getTelefono());
            prodProAlm.setString(8, obj.getMail());
            prodProAlm.setString(9, obj.getCedula_ruc());
            prodProAlm.setString(10, obj.getDireccionImagen());
            prodProAlm.registerOutParameter("valor", Types.VARCHAR);
            prodProAlm.execute();
            valor = prodProAlm.getString("valor");
            //  rs = prodProAlm.getResultSet();
//            while (rs.next()) {
//                MarcaProducto obj = EntidadesMappers.getMarcaProductoFromResultSet(rs);
//                lista.add(obj);
//            }

            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return valor;
    }

    public String eliminarProveedor(Long op, Long id) {
        //ArrayList<ListarJoinProveedor> lista = new ArrayList<ListarJoinProveedor>();
        String valor = "";
        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement prodProAlm = conect.prepareCall(
                    "{ call eliminarProveedor(?,?,?) }");
            prodProAlm.setLong(1, op);
            prodProAlm.setLong(2, id);
            prodProAlm.registerOutParameter("valor", Types.VARCHAR);
            prodProAlm.execute();
            valor = prodProAlm.getString("valor");

            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return valor;

    }

    public void insertarTelefono(ArrayList<Obcx> lis, String cedu) {
        for (int i = 0; i < lis.size(); i++) {
            try {
                conect = con.conectar();
                conect.setAutoCommit(false);
                CallableStatement prodProAlm = conect.prepareCall(""
                        + "{ call insertarTelefono(?,?,?) }");
                prodProAlm.setLong(1, lis.get(i).getTipos());
                prodProAlm.setString(2, lis.get(i).getTcd());
                prodProAlm.setString(3, cedu);
                //prcProcedimientoAlmacenado.registerOutParameter("mst", Types.VARCHAR);
                prodProAlm.executeUpdate();
                //mensaje = prcProcedimientoAlmacenado.getString("mst");
                conect.commit();

            } catch (Exception ex) {
                try {
                    conect.rollback();

                } catch (SQLException ex1) {
                    Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex1);
                }
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            conect.close();
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insertarCorreo(ArrayList<Obcx> lis, String cedu) {
        for (int i = 0; i < lis.size(); i++) {
            try {
                conect = con.conectar();
                conect.setAutoCommit(false);
                CallableStatement prodProAlm = conect.prepareCall(""
                        + "{ call insertarCorreo(?,?,?) }");
                prodProAlm.setLong(1, lis.get(i).getTipos());
                prodProAlm.setString(2, lis.get(i).getTcd());
                prodProAlm.setString(3, cedu);
                //prcProcedimientoAlmacenado.registerOutParameter("mst", Types.VARCHAR);
                prodProAlm.executeUpdate();
                //mensaje = prcProcedimientoAlmacenado.getString("mst");
                conect.commit();

            } catch (Exception ex) {
                try {
                    conect.rollback();

                } catch (SQLException ex1) {
                    Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex1);
                }
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            conect.close();
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//    public void insertarTelefonoCliente( ArrayList<Obcx> lis, String cedula1) {
//        String valor = null;
//          for (int i = 0; i < lis.size(); i++) {
//        try {
//            conect = con.conectar();
//            conect.setAutoCommit(false);
//            CallableStatement pro = conect.prepareCall(
//                    "{ call insertarTelefono(?,?,?,?)}");
//            pro.setString(1, cedula1);
//            pro.setInt(2, lis.get(i).getTipos());
//            pro.setString(3, lis.get(i).getTcd());
//            pro.registerOutParameter("msg", Types.VARCHAR);
//            pro.executeUpdate();
//            //pro.execute();
//            valor = pro.getString("msg");
//            conect.commit();
//        } catch (Exception ex) {
//                try {
//                    conect.rollback();
//
//                } catch (SQLException ex1) {
//                        Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex1);
//                }
//                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        try {
//            conect.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

    public String insertarNuevoProveedor(ListarJoinProveedor obj) {
        // ArrayList<ListarJoinProveedor> lista = new ArrayList();
        String valor = "";
        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement prodProAlm = conect.prepareCall(
                    "{ call insertarProveedor(?,?,?,?,?,?,?,?,?,?) }");
            prodProAlm.setLong(1, obj.getId_proveedor_clase());
            prodProAlm.setString(2, obj.getCedula_ruc());
            prodProAlm.setString(3, obj.getEntidad());
            prodProAlm.setString(4, obj.getRepresentante());
            prodProAlm.setString(5, obj.getDireccion());
            prodProAlm.setDate(6, obj.getFecha_registro());
            prodProAlm.setString(7, obj.getTelefono());
            prodProAlm.setString(8, obj.getMail());
            prodProAlm.setString(9, obj.getDireccionImagen());
            prodProAlm.registerOutParameter("valor", Types.VARCHAR);
            prodProAlm.execute();
            valor = prodProAlm.getString("valor");

            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (Exception ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return valor;
    }

//    public ArrayList<FaltantesCabeceraDetalles> listarJoinProductosFaltantes(int op) {//piguiFaltantes
//        ArrayList<FaltantesCabeceraDetalles> lista = new ArrayList<FaltantesCabeceraDetalles>();
//
//        try {
//            conect = con.conectar();
//            conect.setAutoCommit(false);
//            CallableStatement prcProcedimientoAlmacenado = conect.prepareCall(
//                    "{ call listarJoinProductosFaltantes(?) }");
//            prcProcedimientoAlmacenado.setInt(1, op);
//            prcProcedimientoAlmacenado.execute();
//            rs = prcProcedimientoAlmacenado.getResultSet();
//            while (rs.next()) {
//                FaltantesCabeceraDetalles obj = EntidadesMappers.getJoinProductosFromResultSet(rs);
//                lista.add(obj);
//            }
//            conect.commit();
//        } catch (Exception e) {
//            try {
//                conect.rollback();
//                e.printStackTrace();
//            } catch (SQLException ex) {
//                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        } finally {
//            try {
//                conect.close();
//            } catch (SQLException ex) {
//                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        return lista;
//    }
    public ArrayList<FaltantesCabeceraDetalles> filtroBusqueda(String query) {//piguiFaltantes
        ArrayList<FaltantesCabeceraDetalles> lista = new ArrayList<FaltantesCabeceraDetalles>();

        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement prcProcedimientoAlmacenado = conect.prepareCall(
                    "{ call filtroProducto(?) }");
            prcProcedimientoAlmacenado.setString(1, query);
            prcProcedimientoAlmacenado.execute();
            rs = prcProcedimientoAlmacenado.getResultSet();
            while (rs.next()) {
                FaltantesCabeceraDetalles obj = EntidadesMappers.getJoinTodosProductosFaltantesFromResultSet(rs);
                lista.add(obj);
            }
            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lista;
    }

    public ArrayList<Laboratorio> ListarLab() {//KELLY LABORATORIO
        ArrayList<Laboratorio> lista = new ArrayList<Laboratorio>();

        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement pro = conect.prepareCall(
                    "{ call listarLaboratorio() }");
            pro.executeUpdate();
            rs = pro.getResultSet();
            while (rs.next()) {
                Laboratorio obj = EntidadesMappers.getLaboratorioFromResultSet(rs);
                lista.add(obj);

            }
            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lista;
    }

    public ArrayList<Laboratorio> ListarLabBtn(String query) {//kelly laboratorio
        ArrayList<Laboratorio> lista = new ArrayList<Laboratorio>();

        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement pro = conect.prepareCall(
                    "{ call libreTransaccion(?)}");
            pro.setString(1, query);
            pro.executeUpdate();
            rs = pro.getResultSet();
            while (rs.next()) {
                Laboratorio obj = EntidadesMappers.getLaboratorioFromResultSet(rs);
                lista.add(obj);
                conect.commit();

            }
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lista;
    }

    public String Eliminar(Laboratorio lab) { //KELLY LABORATORIO OJO CAMBIAR DELETE POR UPDATE ESTADO 
        String dato = null;
        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement pro = conect.prepareCall(
                    "{ call eliminar(?,?)}");
            pro.setLong(1, lab.getId_Laboratorio());
            pro.registerOutParameter("valor", Types.VARCHAR);
            pro.executeUpdate();
            //pro.execute();
            dato = pro.getString("valor");
            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return dato;

    }

    public String Actualizar(Laboratorio lab) {
        String valor = null;
        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement pro = conect.prepareCall(
                    "{ call actualizar(?,?,?,?,?,?,?,?,?)}");
            // System.err.println("Error "+lab.getId_Laboratorio());
            pro.setLong(1, lab.getId_Laboratorio());
            pro.setString(2, lab.getRUC());
            pro.setString(3, lab.getNombre());
            pro.setString(4, lab.getDireccion());
            pro.setString(5, lab.getTelefono());
            pro.setDate(6, lab.getFecha());
            pro.setString(7, lab.getImagen());
            pro.setString(8, lab.getCorreo());
            pro.registerOutParameter("valor", Types.VARCHAR);
            pro.executeUpdate();
            //pro.execute();
            valor = pro.getString("valor");
            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return valor;
    }

    public String insertarLab(Laboratorio lab) {
        String valor = null;
        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement pro = conect.prepareCall(
                    "{ call insertarLab(?,?,?,?,?,?,?,?)}");
            pro.setString(1, lab.getRUC());
            pro.setString(2, lab.getNombre());
            pro.setString(3, lab.getDireccion());
            pro.setString(4, lab.getTelefono());
            pro.setDate(5, lab.getFecha());
            pro.setString(6, lab.getImagen());
            pro.setString(7, lab.getCorreo());
            pro.registerOutParameter("valor", Types.VARCHAR);
            pro.executeUpdate();
            //pro.execute();
            valor = pro.getString("valor");
            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return valor;
    }

    public String insertarClientes(String cedula1, String nombre1,
            String apellido1, String direccion1, String cbx1, String cbx2) {
        String valor = null;
        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement pro = conect.prepareCall(
                    "{ call insertarClientes(?,?,?,?,?,?,?)}");
            pro.setString(1, cedula1);
            pro.setString(2, nombre1);
            pro.setString(3, apellido1);
            pro.setString(4, direccion1);
            pro.setString(5, cbx1);
            pro.setString(6, cbx2);
            pro.registerOutParameter("msg", Types.VARCHAR);
            pro.executeUpdate();
            //pro.execute();
            valor = pro.getString("msg");
            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException exception) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, exception);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException exception) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, exception);
            }
        }
        return valor;
    }

    public void insertarTelefonoCliente(ArrayList<Obcx> lis, String cedula1) {
        String valor = null;
        for (int i = 0; i < lis.size(); i++) {
            try {
//            connn = con.Conexion("Modulo_Cliente");
                conect = con.conectar();
                conect.setAutoCommit(false);
                CallableStatement pro = conect.prepareCall(
                        "{ call insertarTelefonoCliente(?,?,?,?)}");
                pro.setString(1, cedula1);
                pro.setInt(2, lis.get(i).getTipos());
                pro.setString(3, lis.get(i).getTcd());
                pro.registerOutParameter("msg", Types.VARCHAR);
                pro.executeUpdate();
                //pro.execute();
                valor = pro.getString("msg");
                conect.commit();
            } catch (Exception ex) {
                try {
                    conect.rollback();

                } catch (Exception ex1) {
                    Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex1);
                }
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            conect.close();
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insertarCorreoCliente(ArrayList<Obcx> lis, String cedula1) {
        for (int i = 0; i < lis.size(); i++) {
            try {
//                connn = con.Conexion("Modulo_Cliente");
                conect = con.conectar();
                conect.setAutoCommit(false);
                CallableStatement prc = conect.prepareCall(""
                        + "{ call insertarCorreoCliente(?,?,?) }");
                prc.setString(1, cedula1);
                prc.setString(2, lis.get(i).getTcd());
                //prcProcedimientoAlmacenado.setLong(3, lis.get(i).getTipo());
                prc.registerOutParameter("msg", Types.VARCHAR);
                prc.executeUpdate();
                //mensaje = prcProcedimientoAlmacenado.getString("mst");
                conect.commit();

            } catch (Exception ex) {
                try {
                    conect.rollback();

                } catch (SQLException ex1) {
                    Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex1);
                }
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            conect.close();
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String editarCliente(String cedula, String nombre, String apellido, String direccion,
            String cbx1, String cbx2) {
        String mensaje = null;

        try {
//            connn = con.Conexion("Modulo_Cliente");
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement prc = conect.prepareCall(""
                    + "{ call actualizarCliente(?,?,?,?,?,?,?) }");
            prc.setString(1, cedula);
            prc.setString(2, nombre);
            prc.setString(3, apellido);
            prc.setString(4, direccion);
            prc.setString(5, cbx1);
            prc.setString(6, cbx2);
            prc.registerOutParameter("msg", Types.VARCHAR);
            prc.executeUpdate();
            mensaje = prc.getString("msg");
            conect.commit();

        } catch (Exception ex) {
            try {
                conect.rollback();

            } catch (Exception ex1) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conect.close();
        } catch (Exception ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mensaje;

    }

    public String eliminarCliente(String cedula) {
        String mensaje = null;
        //int por1 = Integer.valueOf(por);
        try {
//            connn = con.Conexion("Modulo_Cliente");
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement prc = conect.prepareCall(""
                    + "{ call estadoCliente(?,?) }");
            prc.setString(1, cedula);
            prc.registerOutParameter("msg", Types.VARCHAR);
            prc.executeUpdate();
            mensaje = prc.getString("msg");
            conect.commit();

        } catch (Exception ex) {
            try {
                conect.rollback();

            } catch (SQLException ex1) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conect.close();
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mensaje;

    }

    public String activarCliente(String cedula) {
        String mensaje = null;
        //int por1 = Integer.valueOf(por);
        try {
//            connn = con.Conexion("Modulo_Cliente");
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement prc = conect.prepareCall("{ call estadoCliente2(?,?) }");
            prc.setString(1, cedula);
            prc.registerOutParameter("mst", Types.VARCHAR);
            prc.executeUpdate();
            mensaje = prc.getString("mst");
            conect.commit();

        } catch (Exception ex) {
            try {
                conect.rollback();

            } catch (Exception ex1) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conect.close();
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mensaje;

    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////    
    // tipo Producto 
    public ArrayList<TipoProducto> MostrarTipo() {
        ArrayList<TipoProducto> tp = new ArrayList<>();

        try {
            conect = con.conectar();
            CallableStatement prcProAl = conect.prepareCall(
                    "{ call Tipo_producto() }");
            prcProAl.executeQuery();
            rs = prcProAl.getResultSet();
            while (rs.next()) {
                TipoProducto tpp = new TipoProducto(rs.getLong("id_tipo"),
                        rs.getString("nombre"));
                tp.add(tpp);
            }
            rs.close();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tp;
    }

    public void InsertarTipo(String valor) {
        String msg;
        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement cs = conect.prepareCall(
                    "{ call Insertar_Tipo(?,?) }");
            cs.setString(1, valor);
            cs.registerOutParameter("salida", Types.VARCHAR);
            cs.executeUpdate();
            msg = cs.getString("salida");
            JOptionPane.showMessageDialog(null, msg);
            conect.commit();
        } catch (SQLException e) {
            try {
                conect.rollback();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void ActualizarTipo(TipoProducto to, String valor) {
        String msg;
        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement cs = conect.prepareCall(
                    "{ call Actualizar_Tipo(?,?,?) }");
            cs.setString(1, valor);
            cs.setLong(2, to.getId_tipo());
            cs.registerOutParameter("salida", Types.VARCHAR);
            cs.executeUpdate();
            msg = cs.getString("salida");
            JOptionPane.showMessageDialog(null, msg);
            conect.commit();
        } catch (SQLException e) {
            try {
                conect.rollback();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void EliminarTipo(TipoProducto to) {
        String msg;
        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement cs = conect.prepareCall(
                    "{ call Eliminar_Tipo(?,?) }");
            cs.setLong(1, to.getId_tipo());
            cs.registerOutParameter("salida", Types.VARCHAR);
            cs.executeUpdate();
            msg = cs.getString("salida");
            JOptionPane.showMessageDialog(null, msg);
            conect.commit();
        } catch (SQLException e) {
            try {
                conect.rollback();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //tipo Envase
    public ArrayList<EnvaseProducto> MostrarEnvase() {
        ArrayList<EnvaseProducto> tp = new ArrayList<>();

        try {
            conect = con.conectar();
            CallableStatement prcProAl = conect.prepareCall(
                    "{ call Envase_Producto() }");
            prcProAl.executeQuery();
            rs = prcProAl.getResultSet();
            while (rs.next()) {
                EnvaseProducto tpp = new EnvaseProducto(rs.getLong("id_envase"),
                        rs.getString("nombre"));
                tp.add(tpp);
            }
            rs.close();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tp;
    }

    public void InsertarEnvase(String valor) {
        String msg;
        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement cs = conect.prepareCall(
                    "{ call Insertar_Envase(?,?) }");
            cs.setString(1, valor);
            cs.registerOutParameter("salida", Types.VARCHAR);
            cs.executeUpdate();
            msg = cs.getString("salida");
            JOptionPane.showMessageDialog(null, msg);
            conect.commit();
        } catch (SQLException e) {
            try {
                conect.rollback();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void ActualizarEnvase(EnvaseProducto en, String valor) {
        String msg;
        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement cs = conect.prepareCall(
                    "{ call Actualizar_Envase(?,?,?) }");
            cs.setString(1, valor);
            cs.setLong(2, en.getId_envase());
            cs.registerOutParameter("salida", Types.VARCHAR);
            cs.executeUpdate();
            msg = cs.getString("salida");
            JOptionPane.showMessageDialog(null, msg);
            conect.commit();
        } catch (SQLException e) {
            try {
                conect.rollback();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void EliminarEnvase(EnvaseProducto en) {
        String msg;
        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement cs = conect.prepareCall(
                    "{ call Eliminar_Envase(?,?) }");
            cs.setLong(1, en.getId_envase());
            cs.registerOutParameter("salida", Types.VARCHAR);
            cs.executeUpdate();
            msg = cs.getString("salida");
            JOptionPane.showMessageDialog(null, msg);
            conect.commit();
        } catch (SQLException e) {
            try {
                conect.rollback();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //medida
    public String validarMedidaProducto(String nombre) {
        String valor = null;
        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement prcProcedimientoAlmacenado = conect.prepareCall(""
                    + "{ CALL insertarMedidaProducto(?,?) }");// que solo x eso?asi es jajajaj toda la madrugada jajaj
            prcProcedimientoAlmacenado.setString(1, nombre);
            prcProcedimientoAlmacenado.registerOutParameter("valor1", Types.VARCHAR);
            prcProcedimientoAlmacenado.executeUpdate();
            valor = prcProcedimientoAlmacenado.getString("valor1");//voy revisar mi codigo
            System.out.println(valor);
            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(ValidarIngresoProducto.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(ValidarIngresoProducto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return valor;
    }

    public String eliminarMedidaProducto(MedidaProducto mdp) {
        String valor = null;
        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement prcProcedimientoAlmacenado = conect.prepareCall(""
                    + "{ CALL eliminarMedidaProducto(?,?) }");// que solo x eso?asi es jajajaj toda la madrugada jajaj
            prcProcedimientoAlmacenado.setLong(1, mdp.getId_medidas());
            prcProcedimientoAlmacenado.registerOutParameter("valor1", Types.VARCHAR);
            prcProcedimientoAlmacenado.executeUpdate();
            valor = prcProcedimientoAlmacenado.getString("valor1");//voy revisar mi codigo
            System.out.println(valor);
            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(ValidarIngresoProducto.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(ValidarIngresoProducto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return valor;
    }

    public String editarMedidaProducto(String nombre, Long id) {
        String valor = null;
        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement prcProcedimientoAlmacenado = conect.prepareCall(""
                    + "{ CALL editarMedidaProducto(?,?,?) }");// que solo x eso?asi es jajajaj toda la madrugada jajaj
            prcProcedimientoAlmacenado.setString(1, nombre);
            prcProcedimientoAlmacenado.setLong(2, id);
            prcProcedimientoAlmacenado.registerOutParameter("valor1", Types.VARCHAR);
            prcProcedimientoAlmacenado.executeUpdate();
            valor = prcProcedimientoAlmacenado.getString("valor1");//voy revisar mi codigo
            System.out.println(valor);
            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(ValidarIngresoProducto.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(ValidarIngresoProducto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return valor;
    }

    // marca
    public String editarMarcaProducto(String nombre, Long id) {
        String valor = null;
        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement prcProcedimientoAlmacenado = conect.prepareCall(""
                    + "{ CALL editarMarcaProducto(?,?,?) }");// que solo x eso?asi es jajajaj toda la madrugada jajaj
            prcProcedimientoAlmacenado.setString(1, nombre);
            prcProcedimientoAlmacenado.setLong(2, id);
            prcProcedimientoAlmacenado.registerOutParameter("valor1", Types.VARCHAR);
            prcProcedimientoAlmacenado.executeUpdate();
            valor = prcProcedimientoAlmacenado.getString("valor1");//voy revisar mi codigo
            System.out.println(valor);
            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(ValidarIngresoProducto.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(ValidarIngresoProducto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return valor;
    }

    public String eliminarMarcaProducto(MarcaProducto mdp) {
        String valor = null;
        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement prcProcedimientoAlmacenado = conect.prepareCall(""
                    + "{ CALL eliminarMarcaProducto(?,?) }");// que solo x eso?asi es jajajaj toda la madrugada jajaj
            prcProcedimientoAlmacenado.setLong(1, mdp.getId_Marcas());
            prcProcedimientoAlmacenado.registerOutParameter("valor1", Types.VARCHAR);
            prcProcedimientoAlmacenado.executeUpdate();
            valor = prcProcedimientoAlmacenado.getString("valor1");//voy revisar mi codigo
            System.out.println(valor);
            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(ValidarIngresoProducto.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(ValidarIngresoProducto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return valor;
    }

    public String actualizarPrecioCompra(Precios obj) {
        //ArrayList<Productos> lista = new ArrayList<Productos>();
        String valor = null;
        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement prodProAlm = conect.prepareCall(
                    "{ call actualizarPrecioCompra(?,?,?,?,?,?,?) }");
            prodProAlm.setLong(1, obj.getId_producto());
            prodProAlm.setDouble(2, obj.getPrecio_compra());
            prodProAlm.setDouble(3, obj.getPrecio_venta());
            prodProAlm.setString(4, obj.getFecha_registro());
            prodProAlm.setLong(5, obj.getId_usuario());
            prodProAlm.setLong(6, obj.getPorcentaje());
            prodProAlm.registerOutParameter("valor1", Types.VARCHAR);
            prodProAlm.executeUpdate();
            valor = prodProAlm.getString("valor1");
            //  rs = prodProAlm.getResultSet();
//            while (rs.next()) {
//                MarcaProducto obj = EntidadesMappers.getMarcaProductoFromResultSet(rs);
//                lista.add(obj);
//            }

            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return valor;
    }

    public String actualizarPrecioProductos(String query) {
        //ArrayList<Productos> lista = new ArrayList<Productos>();
        String valor = null;
        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement pro = conect.prepareCall(
                    "{ call actualizarPrecioProducto(?,?)}");
            pro.setString(1, query);
            pro.registerOutParameter("valor", Types.VARCHAR);
            pro.executeUpdate();
            valor = pro.getString("valor");
            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return valor;
    }

    public Double getNombreComboPrecioPro(Long op, Long id) {
        //ArrayList<Productos> lista = new ArrayList<Productos>();
        Double valor = null;
        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement prodProAlm = conect.prepareCall(
                    "{ call getNombreComboProducto(?,?,?,?) }");
            prodProAlm.setLong(1, op);
            prodProAlm.setLong(2, id);
            prodProAlm.registerOutParameter("valord", Types.DOUBLE);
            prodProAlm.executeUpdate();
            valor = prodProAlm.getDouble("valord");
            //  rs = prodProAlm.getResultSet();
//            while (rs.next()) {
//                MarcaProducto obj = EntidadesMappers.getMarcaProductoFromResultSet(rs);
//                lista.add(obj);
//            }

            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return valor;
    }

    public String guardarNuevoPrecio(Long op, Precios obj) {//jefferson compras
        String valor = null;
        System.out.println(obj.getId_producto() + "  PRUEBA PRECIO " + obj.getPrecio_venta());
        //int por1 = Integer.valueOf(por);
        try {
//            connn = con.Conexion("Modulo_Cliente");
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement prodProAlm = conect.prepareCall(
                    "{ call ingresoDePrecios(?,?,?,?,?,?,?) }");
            prodProAlm.setLong(1, op);
            prodProAlm.setLong(2, obj.getId_producto());
            prodProAlm.setDouble(3, obj.getPrecio_compra());
            prodProAlm.setDouble(4, obj.getPrecio_venta());
            prodProAlm.setString(5, obj.getFecha_registro());
            prodProAlm.setLong(6, obj.getId_usuario());
            prodProAlm.registerOutParameter("valor1", Types.VARCHAR);
            prodProAlm.executeUpdate();
            valor = prodProAlm.getString("valor1");
            conect.commit();
        } catch (Exception ex) {
            try {
                conect.rollback();

            } catch (Exception ex1) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conect.close();
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valor;

    }

    public String BuscarIDProductoNuevo(Productos obj) {
        String valor = null;
        //int por1 = Integer.valueOf(por);
        try {
//            connn = con.Conexion("Modulo_Cliente");
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement prodProAlm = conect.prepareCall(
                    "{ call BuscarIDProductoNuevo(?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");
            prodProAlm.setString(1, obj.getNombre());
            prodProAlm.setString(2, obj.getDescripcion());
            prodProAlm.setDate(3, obj.getFecha_registro());
            prodProAlm.setDouble(4, obj.getPeso());
            prodProAlm.setLong(5, obj.getId_tipo());
            prodProAlm.setLong(6, obj.getId_medidas());
            prodProAlm.setLong(7, obj.getId_envase());
            prodProAlm.setLong(8, obj.getId_marcas());
            prodProAlm.setLong(9, obj.getId_usuario());
            prodProAlm.setString(10, obj.getIva());
            prodProAlm.setLong(11, obj.getCantidad_minima());
            prodProAlm.setString(12, obj.getReceta());
            prodProAlm.setLong(13, obj.getDescuento_venta());
            prodProAlm.registerOutParameter("valor1", Types.VARCHAR);
            prodProAlm.executeUpdate();
            valor = prodProAlm.getString("valor1");
        } catch (Exception ex) {
            try {
                conect.rollback();

            } catch (Exception ex1) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conect.close();
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valor;

    }//getListadoCabeceraNotaPedidoEnComprasFromResultSet

    public ArrayList<JoinListarNotaPedidosCabecera> listarCabeceraNotaPedidoEnCompras(int op) {
        ArrayList<JoinListarNotaPedidosCabecera> lista = new ArrayList<JoinListarNotaPedidosCabecera>();
        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement prcProcedimientoAlmacenado = conect.prepareCall(
                    "{ call ListarRegistroDeNotas(?)}");
            prcProcedimientoAlmacenado.setInt(1, op);
            prcProcedimientoAlmacenado.execute();
            rs = prcProcedimientoAlmacenado.getResultSet();
            while (rs.next()) {
                JoinListarNotaPedidosCabecera obj = EntidadesMappers.getListadoCabeceraNotaPedidoEnComprasFromResultSet(rs);
                lista.add(obj);
            }
            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lista;
    }

    public ArrayList<JoinListarNotaPedidosCabecera> listarCabeceraNotaPedido(int op) {
        ArrayList<JoinListarNotaPedidosCabecera> lista = new ArrayList<JoinListarNotaPedidosCabecera>();
        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement prcProcedimientoAlmacenado = conect.prepareCall(
                    "{ call ListarRegistroDeNotas(?)}");
            prcProcedimientoAlmacenado.setInt(1, op);
            prcProcedimientoAlmacenado.execute();
            rs = prcProcedimientoAlmacenado.getResultSet();
            while (rs.next()) {
                JoinListarNotaPedidosCabecera obj = EntidadesMappers.getListadoCabeceraNotaPedidosFromResultSet(rs);
                lista.add(obj);
            }
            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lista;
    }

    public ArrayList<JoinListarDetalleNotaPedido> listarDetalleNotaPedido(int op, String id) {
        ArrayList<JoinListarDetalleNotaPedido> lista = new ArrayList<JoinListarDetalleNotaPedido>();
        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement prcProcedimientoAlmacenado = conect.prepareCall(
                    "{ call ListarRegistroDetalleNotaPedido(?,?)}");
            prcProcedimientoAlmacenado.setInt(1, op);
            prcProcedimientoAlmacenado.setString(2, id);
            prcProcedimientoAlmacenado.execute();
            rs = prcProcedimientoAlmacenado.getResultSet();
            while (rs.next()) {
                JoinListarDetalleNotaPedido obj = EntidadesMappers.getDetallePedidosFromResultSet(rs);
                lista.add(obj);
            }
            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lista;
    }

    public ArrayList<JoinListarDetalleNotaPedido> listarDetalleNotaPedidoEnCompra(int op, String id) {
        ArrayList<JoinListarDetalleNotaPedido> lista = new ArrayList<JoinListarDetalleNotaPedido>();
        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement prcProcedimientoAlmacenado = conect.prepareCall(
                    "{ call ListarRegistroDetalleNotaPedido(?,?)}");
            prcProcedimientoAlmacenado.setInt(1, op);
            prcProcedimientoAlmacenado.setString(2, id);
            prcProcedimientoAlmacenado.execute();
            rs = prcProcedimientoAlmacenado.getResultSet();
            while (rs.next()) {
                JoinListarDetalleNotaPedido obj = EntidadesMappers.getDetallePedidoEnCompraFromResultSet(rs);
                lista.add(obj);
            }
            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lista;
    }

    public String insertarCabeceraNotaPedido(CabeceraNotaPedido obj) {

        String valor = "";
        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement prodProAlm = conect.prepareCall(
                    "{ call insertarCabeceraNotaPedido(?,?,?,?,?,?,?,?,?) }");
            prodProAlm.setLong(1, obj.getId_proveedor());
            prodProAlm.setLong(2, obj.getId_usuario());
            prodProAlm.setString(3, obj.getFecha_creacion());
            prodProAlm.setString(4, obj.getPlazo());
            prodProAlm.setString(5, obj.getForma_pago());
            prodProAlm.setBigDecimal(6, obj.getIva());
            prodProAlm.setBigDecimal(7, obj.getDescuento());
            prodProAlm.setBigDecimal(8, obj.getTotal());

            prodProAlm.registerOutParameter("valor", Types.VARCHAR);
            prodProAlm.executeUpdate();
            valor = prodProAlm.getString("valor");
            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return valor;
    }

    public String buscarIDCabeceraNotaPedido(String queryL) {
        String id = "";
        try {
            conect = con.conectar();

            java.sql.Statement st = conect.createStatement();
            rs = st.executeQuery(queryL);
            rs.next();
            id = rs.getString("id_cabecera_nota_pedidos");
            conect.close();
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;

    }

    public void InsertarDetallesNotaPedidos(ArrayList<String> queryL) {
        try {
            conect = con.conectar();
            for (int i = 0; i < queryL.size(); i++) {
                java.sql.Statement st = conect.createStatement();
                st.executeUpdate(queryL.get(i));
            }
            conect.close();
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ArrayList<listarJoinProductosNotaPedidos> filtroBusquedaProductoNotaPedido(String query) {
        ArrayList<listarJoinProductosNotaPedidos> lista = new ArrayList<listarJoinProductosNotaPedidos>();
        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement prcProcedimientoAlmacenado = conect.prepareCall(
                    "{ call filtroProducto(?) }");
            prcProcedimientoAlmacenado.setString(1, query);
            prcProcedimientoAlmacenado.execute();
            rs = prcProcedimientoAlmacenado.getResultSet();
            while (rs.next()) {
                listarJoinProductosNotaPedidos obj = EntidadesMappers.getJoinTodosProductosFromResultSetNota(rs);
                lista.add(obj);
            }
            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lista;
    }

    public ArrayList<ListarJoinProveedorNotaPedido> listarProveedoresNotaPedido(Long op) {
        ArrayList<ListarJoinProveedorNotaPedido> lista = new ArrayList<ListarJoinProveedorNotaPedido>();

        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement prodProAlm = conect.prepareCall(
                    "{ call ListarProveedor(?) }");
            prodProAlm.setLong(1, op);
            prodProAlm.execute();
            rs = prodProAlm.getResultSet();
            while (rs.next()) {
                ListarJoinProveedorNotaPedido obj = EntidadesMappers.getListarJoinProveedorNotaPedidoFromResultSet(rs);
                lista.add(obj);
            }
            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lista;
    }

    public String insertarPunto_venta(Punto_venta_usuario pv) {
        String valor = null;
        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement pro = conect.prepareCall(
                    "{ call fc_nuevo_punto_venta(?,?,?,?,?,?)}");
            pro.setString(1, pv.getLocalidad());
            pro.setString(2, pv.getNombre());
            pro.setString(3, pv.getDireccion());
            pro.setString(4, pv.getRuc_local());
            pro.setString(5, pv.getTelefono_pv());
            pro.registerOutParameter("salida", Types.VARCHAR);
            pro.executeUpdate();
            valor = pro.getString("salida");
            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return valor;
    }

    public String CrearLocal(Nombre_local pv) {
        String valor = null;
        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement pro = conect.prepareCall(
                    "{ call fc_crear_local(?,?,?,?)}");
            pro.setString(1, pv.getNombre());
            pro.setString(2, pv.getDireccion());
            pro.setString(3, pv.getTelefono_pv());
            pro.registerOutParameter("salida", Types.VARCHAR);
            pro.executeUpdate();
            valor = pro.getString("salida");
            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return valor;
    }

    public String ActualizarLocal(Nombre_local pv) {
        String valor = null;
        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement pro = conect.prepareCall(
                    "{ call fc_actualizar_local(?,?,?,?)}");
            pro.setString(1, pv.getNombre());
            pro.setString(2, pv.getDireccion());
            pro.setString(3, pv.getTelefono_pv());
            pro.registerOutParameter("salida", Types.VARCHAR);
            pro.executeUpdate();
            valor = pro.getString("salida");
            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return valor;
    }

    public ArrayList<Nombre_local> listar_local() {
        ArrayList<Nombre_local> valor = new ArrayList<Nombre_local>();
        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement pro = conect.prepareCall(
                    "{ call fc_mostrar_local()}");
            rs = pro.executeQuery();
            while (rs.next()) {
                Nombre_local obj = EntidadesMappers.getListarLocalFromResultSet(rs);
                valor.add(obj);
            }
            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return valor;
    }

    public String actualizarPunto_venta(Punto_venta_usuario pv) {
        String valor = null;
        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement pro = conect.prepareCall(
                    "{ call actualizar_punto_venta(?,?,?,?,?,?,?,?) }");
            pro.setLong(1, pv.getId_punto_venta());
            pro.setLong(2, pv.getId_localidad());
            pro.setString(3, pv.getNombre());
            pro.setString(4, pv.getDireccion());
            pro.setString(5, pv.getDir_ip());
            pro.setString(6, pv.getObservacion());
            pro.setLong(7, pv.getId_punto_venta());
            pro.registerOutParameter("salida", Types.VARCHAR);
            pro.executeUpdate();
            valor = pro.getString("salida");
            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return valor;
    }

    public String Iniciar_sesion(Listar_usuario us) {
        String valor = null;
        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement pro = conect.prepareCall(
                    "{ call fc_login_bitacora(?,?,?,?,?,?) }");
            pro.setString(1, us.getCorreo());
            pro.setString(2, us.getPassword());
            pro.setString(3, us.getIp_equipo());
//            pro.setString(4, us.getIp_publico());
            pro.setString(4, us.getUsuario_equipo());
            pro.setString(5, us.getDir_ip_completa());
            pro.registerOutParameter("salida", Types.VARCHAR);
//            pro.executeUpdate();
            pro.execute();
            valor = pro.getString("salida");
            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return valor;
    }

    public String Nuevo_usuario(Usuario_S us) {
        String valor = null;
        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement pro = conect.prepareCall(
                    "{ call fc_registrar_usuario(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            pro.setString(1, us.getCedula());
            pro.setString(2, us.getNombre());
            pro.setString(3, us.getApellido());
            pro.setString(4, us.getTelefono());
            pro.setString(5, us.getConvencional());
            pro.setString(6, us.getCorreo());
            pro.setString(7, us.getDireccion());
            pro.setString(8, us.getIp_equipo());
            pro.setString(9, us.getUsuario_equipo());
            pro.setString(10, us.getDir_ip_completa());
            pro.setString(11, us.getRuta_imagen());
            pro.setString(12, us.getObservacion());
            pro.setString(13, us.getGenero());
            pro.setString(14, us.getCargo());
            pro.registerOutParameter("salida", Types.VARCHAR);
            pro.executeUpdate();
            //pro.execute();
            valor = pro.getString("salida");
            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return valor;
    }//usuario

    public String Actualizar_usuario(Usuario_S us) {
        String valor = null;
        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement pro = conect.prepareCall(
                    "{ call fc_actualizar_usuario(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            pro.setString(1, us.getCedula());
            pro.setString(2, us.getNombre());
            pro.setString(3, us.getApellido());
            pro.setString(4, us.getTelefono());
            pro.setString(5, us.getConvencional());
            pro.setString(6, us.getCorreo());
            pro.setString(7, us.getDireccion());
            pro.setString(8, us.getIp_equipo());
            pro.setString(9, us.getUsuario_equipo());
            pro.setString(10, us.getDir_ip_completa());
            pro.setString(11, us.getRuta_imagen());
            pro.setString(12, us.getObservacion());
            pro.setString(13, us.getGenero());
            pro.setString(14, us.getCargo());
            pro.setString(15, us.getPassword());
            pro.setLong(16, us.getId_sesion());
            pro.setString(17, us.getEstado());
            pro.registerOutParameter("salida", Types.VARCHAR);
            pro.executeUpdate();
            //pro.execute();
            valor = pro.getString("salida");
            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return valor;
    }

    public String Respaldo_usuario(Usuario_S us) {
        String valor = null;
        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement pro = conect.prepareCall(
                    "{ call fc_respaldo_usuario(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            pro.setString(1, us.getCedula());
            pro.setString(2, us.getNombre());
            pro.setString(3, us.getApellido());
            pro.setString(4, us.getTelefono());
            pro.setString(5, us.getConvencional());
            pro.setString(6, us.getCorreo());
            pro.setString(7, us.getDireccion());
            pro.setString(8, us.getIp_equipo());
            pro.setString(9, us.getUsuario_equipo());
            pro.setString(10, us.getDir_ip_completa());
            pro.setString(11, us.getObservacion());
            pro.setString(12, us.getGenero());
            pro.setString(13, us.getCargo());
            pro.setString(14, us.getEstado());
            pro.setLong(15, us.getId_sesion());
            pro.setString(16, us.getFecha_registro().toString());
            pro.executeUpdate();
            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return valor;
    }

    public String bitacoraSeguridad(Bitacora_seguridad bs) {

        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement pro = conect.prepareCall(
                    "{ call bitacora_seguridad(?,?,?,?,?)}");
            pro.setString(1, bs.getUser());
            pro.setString(2, bs.getPassword());
            pro.setString(3, bs.getIp_equipo());
            pro.setString(4, bs.getUsuario_equipo());
            pro.setString(5, bs.getDir_ip_completa());
            pro.executeUpdate();
            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;

    }

    public ArrayList<fc_localidad_guayas> listarLocalidadGuayas() {
        ArrayList<fc_localidad_guayas> lista = new ArrayList<fc_localidad_guayas>();

        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement prcProcedimientoAlmacenado = conect.prepareCall(
                    "{ call listaComboLocalidadr }");
            //   prcProcedimientoAlmacenado.setInt(1, op);
            prcProcedimientoAlmacenado.execute();
            rs = prcProcedimientoAlmacenado.getResultSet();
            while (rs.next()) {
                fc_localidad_guayas obj = EntidadesMappers.getLocalidadGuayasFromResultSet(rs);
                lista.add(obj);
            }

            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lista;
    }

    public ArrayList<Genero> listarGenero() {
        ArrayList<Genero> lista = new ArrayList<Genero>();
        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement prcProcedimientoAlmacenado = conect.prepareCall(
                    "{ call fc_combo_genero() }");
            //   prcProcedimientoAlmacenado.setInt(1, op);
            prcProcedimientoAlmacenado.execute();
            rs = prcProcedimientoAlmacenado.getResultSet();
            while (rs.next()) {
                Genero obj = EntidadesMappers.getGeneroFromResultSet(rs);
                lista.add(obj);
            }
            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lista;
    }

    public ArrayList<Rol_U> listarRol() {
        ArrayList<Rol_U> lista = new ArrayList<Rol_U>();
        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement prcProcedimientoAlmacenado = conect.prepareCall(
                    "{ call fc_combo_rol() }");
            //   prcProcedimientoAlmacenado.setInt(1, op);
            prcProcedimientoAlmacenado.execute();
            rs = prcProcedimientoAlmacenado.getResultSet();
            while (rs.next()) {
                Rol_U obj = EntidadesMappers.getRolFromResultSet(rs);
                lista.add(obj);
            }
            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lista;
    }

    public ArrayList<Estado_usuario> listarEstado() {
        ArrayList<Estado_usuario> lista = new ArrayList<Estado_usuario>();
        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement prcProcedimientoAlmacenado = conect.prepareCall(
                    "{ call fc_esatdo_usuario() }");
            //   prcProcedimientoAlmacenado.setInt(1, op);
            prcProcedimientoAlmacenado.execute();
            rs = prcProcedimientoAlmacenado.getResultSet();
            while (rs.next()) {
                Estado_usuario obj = EntidadesMappers.getEstadoUsuarioFromResultSet(rs);
                lista.add(obj);
            }
            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lista;
    }

    public String getLocalidadComboGuayas(Long op, Long id) {
        //ArrayList<Productos> lista = new ArrayList<Productos>();
        String valor = "";
        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement prodProAlm = conect.prepareCall(
                    "{ call getLocalidadComboGuayas(?,?,?) }");
            prodProAlm.setLong(1, op);
            prodProAlm.setLong(2, id);
            prodProAlm.registerOutParameter("valor", Types.VARCHAR);
            prodProAlm.executeUpdate();
            valor = prodProAlm.getString("valor");
            //  rs = prodProAlm.getResultSet();
//            while (rs.next()) {
//                MarcaProducto obj = EntidadesMappers.getMarcaProductoFromResultSet(rs);
//                lista.add(obj);
//            }

            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return valor;
    }

    public ArrayList<Listar_usuario> get_listar_usuario() {
        ArrayList<Listar_usuario> valor = new ArrayList<Listar_usuario>();
        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement pro = conect.prepareCall(
                    "{ call fc_mostrar_usuario}");
            rs = pro.executeQuery();
            while (rs.next()) {
                Listar_usuario obj = EntidadesMappers.getUsuarioFromResultSet(rs);
                valor.add(obj);
            }
            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return valor;
    }

    public ArrayList<Punto_venta_usuario> listarPuntoVenta() {
        ArrayList<Punto_venta_usuario> valor = new ArrayList<Punto_venta_usuario>();
        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement pro = conect.prepareCall(
                    "{ call fc_punto_venta_prueba() }");
            rs = pro.executeQuery();
            while (rs.next()) {
                Punto_venta_usuario obj = EntidadesMappers.getPuntoVentaUsuarioFromResultSet(rs);
                valor.add(obj);
            }
            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return valor;
    }

    public ArrayList<Listar_usuario> filtroBusquedaUsuario(String query) {
        ArrayList<Listar_usuario> lista = new ArrayList<Listar_usuario>();

        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement prcProcedimientoAlmacenado = conect.prepareCall(
                    "{ call universal_sentences(?) }");
            prcProcedimientoAlmacenado.setString(1, query);
            prcProcedimientoAlmacenado.execute();
            rs = prcProcedimientoAlmacenado.getResultSet();
            while (rs.next()) {
                Listar_usuario obj = EntidadesMappers.getUsuarioFromResultSet(rs);
                lista.add(obj);
            }
            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lista;
    }

    //////  listar Producto venta  
    public ArrayList<JoinListarProductosVentas> ListarTodoJoinProductosVentas(String op1) {
        ArrayList<JoinListarProductosVentas> lista = new ArrayList<JoinListarProductosVentas>();

        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement prcProcedimientoAlmacenado = conect.prepareCall(
                    "{call ListarProductosVentas(?)}");
            prcProcedimientoAlmacenado.setString(1, op1);
            prcProcedimientoAlmacenado.execute();
            rs = prcProcedimientoAlmacenado.getResultSet();
            while (rs.next()) {
                JoinListarProductosVentas obj = EntidadesMappers.getJoinTodosProductosVentasFromResultSet(rs);
                lista.add(obj);
            }
            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lista;
    }

    //////// Listar Cliente Ventas
    public ArrayList<Persona> ListarTodoClienteVentas(String op1) {
        ArrayList<Persona> lista = new ArrayList<Persona>();

        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement prcProcedimientoAlmacenado = conect.prepareCall(
                    "{call ListarClientesVentas(?)}");
            prcProcedimientoAlmacenado.setString(1, op1);
            prcProcedimientoAlmacenado.execute();
            rs = prcProcedimientoAlmacenado.getResultSet();
            while (rs.next()) {
                Persona obj = EntidadesMappers.getTodosClienteVentasFromResultSet(rs);
                lista.add(obj);
            }
            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lista;

    }

    public String ActualizarNotaPedidos(DetalleNotaPedido dnp) {
        String valor = null;
        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement pro = conect.prepareCall(
                    "{ call ActualizarDetalleNotaPedido(?,?,?,?,?,?,?)}");//ll
            pro.setLong(1, dnp.getId_detalle_nota_pedidos());
            pro.setInt(2, dnp.getCantidad());
            pro.setBigDecimal(3, dnp.getDescuento());
            pro.setBigDecimal(4, dnp.getIva());
            pro.setBigDecimal(5, dnp.getTotal());
            pro.setInt(6, dnp.getBono());
            pro.registerOutParameter("valor", Types.VARCHAR);
            pro.executeUpdate();
            //pro.execute();
            valor = pro.getString("valor");
            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return valor;
    }

    public String ActualizarNotaPedidosCabecera(CabeceraNotaPedido cnp) {
        String valor = null;
        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement pro = conect.prepareCall(
                    "{ call ActualizarCabeceraNotaPedido(?,?,?,?,?,?,?)}");
            pro.setString(1, cnp.getPlazo());
            pro.setString(2, cnp.getForma_pago());
            pro.setBigDecimal(3, cnp.getIva());
            pro.setBigDecimal(4, cnp.getDescuento());
            pro.setBigDecimal(5, cnp.getTotal());
            pro.setLong(6, cnp.getId_cabecera_nota_pedidos());
            pro.registerOutParameter("valor", Types.VARCHAR);
            pro.executeUpdate();
            //pro.execute();
            valor = pro.getString("valor");
            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return valor;
    }

    public String insertarProductoEditarNotaPedidos(DetalleNotaPedido dnp) {
        String valor = null;
        try {
            //id_detalle_nota_pedidos,id_precio,id_cabecera_nota_pedidos,cantidad,precio
////,descuento,iva,total,bono
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement pro = conect.prepareCall(
                    "{ call InsertarDetalleNotaPedido()}");
            pro.setLong(1, dnp.getId_detalle_nota_pedidos());
            pro.setLong(2, dnp.getId_precio());
            pro.setLong(3, dnp.getId_cabecera_nota_pedidos());
            pro.setInt(4, dnp.getCantidad());
            pro.setBigDecimal(5, dnp.getPrecio());
            pro.setBigDecimal(6, dnp.getDescuento());
            pro.setBigDecimal(7, dnp.getIva());
            pro.setBigDecimal(8, dnp.getTotal());
            pro.setDouble(9, dnp.getBono());
            pro.registerOutParameter("valor", Types.VARCHAR);
            pro.executeUpdate();
            //pro.execute();
            valor = pro.getString("valor");
            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return valor;
    }

    public String EliminarDetalleNotaPedido(DetalleNotaPedido det) {
        String dato = null;
        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement pro = conect.prepareCall(
                    "{ call EliminarDetalleNotaPedido(?,?)}");
            pro.setLong(1, det.getId_detalle_nota_pedidos());
            pro.registerOutParameter("valor", Types.VARCHAR);
            pro.executeUpdate();
            //pro.execute();
            dato = pro.getString("valor");
            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return dato;

    }

    public String eliminardetalleCompra(JoinListarDetalleNotaPedido dnp) {
        String valor = null;
        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement pro = conect.prepareCall(
                    "{ call eliminarDetalleCompra(?,?,?)}");

            pro.setLong(1, dnp.getId_cabecera_nota_pedido());
            pro.setLong(2, dnp.getId_detalle_nota_pedido());

            pro.registerOutParameter("valor", Types.VARCHAR);
            pro.executeUpdate();
            //pro.execute();
            valor = pro.getString("valor");
            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return valor;
    }
//

    public static void InsertarBDCompras(String id_cabecera, ArrayList<joinProductoDetallesFaltantes> lista) {
        String cad1 = "";
        String[] Filas = new String[12];

        for (int i = 0; i < lista.size(); i++) {

            Filas[0] = "" + lista.get(i).getId_producto().toString();
            Filas[1] = lista.get(i).getMarca();
            Filas[2] = lista.get(i).getNombre_tipo();
            Filas[3] = lista.get(i).getNombre_producto();
            Filas[4] = lista.get(i).getEnvase();
            Filas[5] = lista.get(i).getMedida();
            Filas[6] = lista.get(i).getCantidad().toString();
            Filas[7] = lista.get(i).getPrecios().toString();
            BigDecimal Cantidad = BigDecimal.valueOf(Integer.valueOf(lista.get(i).getCantidad()));//BigDecimal.valueOf(Double.parseDouble(comisiontxt.getText()))
            BigDecimal Precio = lista.get(i).getPrecios();
            BigDecimal PorcDesc = lista.get(i).getPorcentaje_descuento();
            BigDecimal ValorDes = Cantidad.multiply(Precio).multiply(PorcDesc).divide(new BigDecimal("100"));
            ValorDes = ValorDes.setScale(7, BigDecimal.ROUND_HALF_UP);
            ValorDes = BigDecimal.valueOf(Double.parseDouble(removeScientificNotation(ValorDes.toString())));

            BigDecimal iva = new BigDecimal("0.12");
            BigDecimal iva1 = new BigDecimal("0.00");
//          2, RoundingMode.HALF_UP
            Filas[8] = "" + ValorDes;

            if (lista.get(i).getIva().equals("NO")) {
                Filas[9] = "" + 0.00;
                BigDecimal importe = Cantidad.multiply(Precio).add(iva1).subtract(ValorDes);//creo q falata sumar iva
                importe = importe.setScale(7, BigDecimal.ROUND_HALF_UP);
//                Filas[10] = String.format("%5.2f", importe);
                Filas[10] = "" + importe;

            } else {

                iva1 = Cantidad.multiply(iva).multiply(Precio);// ojo cambiar el iva por el de base de datos
                iva1 = iva1.setScale(7, BigDecimal.ROUND_HALF_UP);
//                Filas[9] = String.format("%5.2f", iva1);
                Filas[9] = "" + iva1;

                // Double importe = Cantidad * Precio + iva1 - ValorDes;
                BigDecimal importe = Cantidad.multiply(Precio).add(iva1).subtract(ValorDes);
                importe = importe.setScale(7, BigDecimal.ROUND_HALF_UP);
                Filas[10] = "" + importe;
//                Filas[10] = String.format("%5.2f", importe);

            }
            Filas[11] = lista.get(i).getBono().toString();
            cad1 = "INSERT INTO `detalle_nota_pedidos`(`id_precio`,`id_cabecera_nota_pedidos`,`cantidad`,`precio`,`descuento`,`iva`,`total`,bono) VALUES ('" + lista.get(i).getId_precios() + "','" + id_cabecera + "','" + Filas[6] + "','" + Filas[7] + "','" + Filas[8] + "','" + Filas[9] + "','" + Filas[10] + "','" + Filas[11] + "');";

        }
        System.out.println(cad1);
        CRUD crud = new CRUD();
        crud.insertarDetallesEnRegistroCompras(cad1);
        cad1 = "";
    }

    public static String removeScientificNotation(String value) {
        return new BigDecimal(value).toPlainString();
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

    public void insertarDetallesEnRegistroCompras(String query) {
        try {
            conect = con.conectar();

            java.sql.Statement st = conect.createStatement();
            st.executeUpdate(query);

            conect.close();
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ArrayList<Iva> listarIva() {
        ArrayList<Iva> lista = new ArrayList();
        Iva iva = new Iva();
        try {

            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement prc = conect.prepareCall(
                    "{ call mostrar_iva() }"
            );
            prc.execute();
            rs = prc.getResultSet();
            while (rs.next()) {
                iva = EntidadesMappers.getIva(rs);
                lista.add(iva);
            }
            conect.commit();

        } catch (Exception e) {
            try {
                conect.rollback();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            conect.close();
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public String insertarIva(Double valor, int user) {
        //ArrayList<Iva> lista = new ArrayList();
        //Iva iva = new Iva();
        String valor_res = "fallo";
        try {
            //System.out.println("hola perro");
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement prc = conect.prepareCall(
                    "{ call insertar_iva(?,?,?) }"
            );
            prc.setDouble(1, valor);
            prc.setInt(2, user);
            prc.registerOutParameter("msg", Types.VARCHAR);
            prc.execute();
            // rs=prc.getResultSet();
            valor_res = prc.getString("msg");
            conect.commit();

        } catch (Exception e) {
            try {
                conect.rollback();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            conect.close();
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valor_res;
    }

    public String eliminar_iva(int id) {
        //ArrayList<Iva> lista = new ArrayList();
        //Iva iva = new Iva();
        String valor_res = "fallo";
        try {
            //System.out.println("hola perro");
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement prc = conect.prepareCall(
                    "{ call eliminar_iva(?,?) }"
            );
            prc.setDouble(1, id);
            //prc.setInt(2, user);
            prc.registerOutParameter("msg", Types.VARCHAR);
            prc.execute();
            // rs=prc.getResultSet();
            valor_res = prc.getString("msg");
            conect.commit();

        } catch (Exception e) {
            try {
                conect.rollback();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            conect.close();
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valor_res;
    }

    public String Prueba(Prueba p) {
        String valor = null;
        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement pro = conect.prepareCall(
                    //cantidad,precio,iva,decuento,total
                    "{ call Prueba(?,?,?,?,?)}");

            pro.setLong(1, p.getCantidad());
            pro.setBigDecimal(2, p.getPrecio());
            pro.setBigDecimal(3, p.getIva());
            pro.setBigDecimal(4, p.getDecuento());
            pro.setBigDecimal(5, p.getTotal());

//            pro.registerOutParameter("valor", Types.VARCHAR);
            pro.executeUpdate();
            //pro.execute();
//            valor = pro.getString("valor");
            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return valor;
    }

    ////////////////////
    public String ActivarEstadoNotaPedido(CabeceraNotaPedido cab) {
        String valor = null;
        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement pro = conect.prepareCall(
                    "{ call ActivarEstadoNotaPedido(?,?)}");
            pro.setLong(1, cab.getId_cabecera_nota_pedidos());
            pro.executeUpdate();
            //pro.execute();
            valor = pro.getString("valor");
            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return valor;

    }

    public String DesactivarEstadoNotaPedido(CabeceraNotaPedido cab) {
        String valor = null;
        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement pro = conect.prepareCall(
                    "{ call DesactivarNotaPedido(?,?)}");
            pro.setLong(1, cab.getId_cabecera_nota_pedidos());
            pro.executeUpdate();
            //pro.execute();
            valor = pro.getString("valor");
            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return valor;

    }

    public String insertarDetalleProductoCompra(Detalle_compra obj) {
        String valor = "";
        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement prodProAlm = conect.prepareCall(
                    "{ call insertarDetalleCompras(?,?,?,?,?,?,?,?) }");
            prodProAlm.setLong(1, obj.getId_cabecera_compra());
            prodProAlm.setLong(2, obj.getId_precio());
            prodProAlm.setLong(3, obj.getCantidad());
            prodProAlm.setBigDecimal(4, obj.getPrecio());
            prodProAlm.setBigDecimal(5, obj.getDescuento());
            prodProAlm.setBigDecimal(6, obj.getIva());
            prodProAlm.setBigDecimal(7, obj.getTotal());
            prodProAlm.setLong(8, obj.getBono());
//            prodProAlm.registerOutParameter("valor1", Types.VARCHAR);
            prodProAlm.executeUpdate();
//            valor = prodProAlm.getString("valor1");
            //  rs = prodProAlm.getResultSet();
//            while (rs.next()) {
//                MarcaProducto obj = EntidadesMappers.getMarcaProductoFromResultSet(rs);
//                lista.add(obj);
//            }

            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return valor;
    }

    public ArrayList<Productos_Stock> listarStockProducto(int op) {
        ArrayList<Productos_Stock> lista = new ArrayList<Productos_Stock>();

        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement prcProcedimientoAlmacenado = conect.prepareCall(
                    "{call listarProductosStock(?)}");
            prcProcedimientoAlmacenado.setInt(1, op);

            prcProcedimientoAlmacenado.execute();
            rs = prcProcedimientoAlmacenado.getResultSet();
            while (rs.next()) {
                Productos_Stock obj = EntidadesMappers.getStockProductosFromResultSet(rs);
                lista.add(obj);
            }
            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lista;

    }

    public String edicionCompra(Cabecera_compra cc) {
        String valor = null;
        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement pro = conect.prepareCall(
                    "{ call edicionCompra(?,?,?,?,?,?)}");
            pro.setBigDecimal(1, cc.getIva());
            pro.setBigDecimal(2, cc.getDescuento());
            pro.setBigDecimal(3, cc.getTotal());
            pro.setLong(4, cc.getIdcabecerapedido());
            pro.setLong(5, cc.getId_cabecera_compra());
            pro.registerOutParameter("valor", Types.VARCHAR);
            pro.executeUpdate();
            valor = pro.getString("valor");
            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return valor;
    }

    public String edicionCabeceraNotaPedido(Cabecera_compra cc) {
        String valor = null;
        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement pro = conect.prepareCall(
                    "{ call edicionCabeceraNota(?,?,?,?,?)}");
            pro.setBigDecimal(1, cc.getIva());
            pro.setBigDecimal(2, cc.getDescuento());
            pro.setBigDecimal(3, cc.getTotal());
            pro.setLong(4, cc.getIdcabecerapedido());

            pro.registerOutParameter("valor", Types.VARCHAR);
            pro.executeUpdate();
            valor = pro.getString("valor");
            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return valor;
    }

    public String buscarIDDetallesCompras(JoinListarDetalleNotaPedido obj) {
        String valor = "";
        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement prodProAlm = conect.prepareCall(
                    "{ call buscarIDDetalleCompras(?,?,?,?,?,?) }");
            prodProAlm.setLong(1, obj.getId_cabecera_nota_pedido());
            prodProAlm.setBigDecimal(2, obj.getDescuento());
            prodProAlm.setBigDecimal(3, obj.getIva());
            prodProAlm.setBigDecimal(4, obj.getTotal());
            prodProAlm.setLong(5, obj.getBono());
            prodProAlm.registerOutParameter("valor", Types.VARCHAR);
            prodProAlm.executeUpdate();
            valor = prodProAlm.getString("valor");

            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return valor;
    }

    //
    public String EliminarDetalleDevolucion(JoinListarDetalleNotaPedido obj) {
        String valor = "";
        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement prodProAlm = conect.prepareCall(
                    "{ call EliminarDetalleDevolucion(?,?,?,?,?,?,?,?) }");
            prodProAlm.setLong(1, obj.getId_detalle_nota_pedido());
            prodProAlm.setLong(2, obj.getId_precio());
            prodProAlm.setLong(3, obj.getCantidad());
            prodProAlm.setBigDecimal(4, obj.getDescuento());
            prodProAlm.setBigDecimal(5, obj.getIva());
            prodProAlm.setBigDecimal(6, obj.getTotal());
            prodProAlm.setLong(7, obj.getBono());
            prodProAlm.registerOutParameter("valor", Types.VARCHAR);
            prodProAlm.executeUpdate();
            valor = prodProAlm.getString("valor");

            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return valor;
    }

    public String ActualizarTodoCompras(DetalleNotaPedido dnp) {
        String valor = null;
        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement pro = conect.prepareCall(
                    "{ call ActualizarDetalleCompras(?,?,?,?,?,?,?,?,?,?)}");//ll
            pro.setLong(1, dnp.getId_detalle_nota_pedidos());
            pro.setInt(2, dnp.getCantidad());
            pro.setBigDecimal(3, dnp.getDescuento());
            pro.setBigDecimal(4, dnp.getIva());
            pro.setBigDecimal(5, dnp.getTotal());
            pro.setInt(6, dnp.getBono());
            pro.setInt(7, dnp.getIdCompra());
            pro.setLong(8, dnp.getId_precio());
            pro.setLong(9, dnp.getCantAnt());

            pro.registerOutParameter("valor", Types.VARCHAR);
            pro.executeUpdate();
            //pro.execute();
            valor = pro.getString("valor");
            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return valor;
    }

    public String buscarIDCabeceraCompras(Cabecera_compra obj) {
        String valor = "";
        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement prodProAlm = conect.prepareCall(
                    "{ call buscarIDCabeceraCompras(?,?,?,?) }");
            prodProAlm.setBigDecimal(1, obj.getDescuento());
            prodProAlm.setBigDecimal(2, obj.getIva());
            prodProAlm.setBigDecimal(3, obj.getTotal());
            prodProAlm.registerOutParameter("valor", Types.VARCHAR);
            prodProAlm.executeUpdate();
            valor = prodProAlm.getString("valor");

            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return valor;
    }

    //devolverProductosComprados
    public String devolverProductosComprados(Detalle_compra dnp) {
        String valor = null;
        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement pro = conect.prepareCall(
                    "{ call devolverProductosComprados(?,?,?)}");//ll

            pro.setInt(1, dnp.getCantidad());
            pro.setLong(2, dnp.getId_precio());
            pro.registerOutParameter("valor", Types.VARCHAR);
            pro.executeUpdate();
            //pro.execute();
            valor = pro.getString("valor");
            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return valor;
    }

    public String cambiarEstadoDevolucion(int id_nota, int id_compra) {
        String valor = "";
        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement prodProAlm = conect.prepareCall(
                    "{ call cambiarEstadoDevolucion(?,?) }");
            prodProAlm.setInt(1, id_nota);
            prodProAlm.setInt(2, id_compra);
            prodProAlm.executeUpdate();
            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return valor;
    }

    public ArrayList<JoinListarNotaPedidosCabecera> listarCabeceraComprasDevueltas(int op) {
        ArrayList<JoinListarNotaPedidosCabecera> lista = new ArrayList<JoinListarNotaPedidosCabecera>();
        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement prcProcedimientoAlmacenado = conect.prepareCall(
                    "{ call ListarRegistroDeNotas(?)}");
            prcProcedimientoAlmacenado.setInt(1, op);
            prcProcedimientoAlmacenado.execute();
            rs = prcProcedimientoAlmacenado.getResultSet();
            while (rs.next()) {
                JoinListarNotaPedidosCabecera obj = EntidadesMappers.getListadoCabeceraNotaPedidosFromResultSet(rs);
                lista.add(obj);
            }
            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lista;
    }

    public int obtenerNumeroOrdenes(String query) {
        int id = 0;
        try {
            conect = con.conectar();

            java.sql.Statement st = conect.createStatement();
            rs = st.executeQuery(query);
            rs.next();
            id = rs.getInt("cantidad");
            conect.close();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    public String InsertarCabeceraVentas(Cabecera_ventas obj) {

        String valor = "";
        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement prodProAlm = conect.prepareCall(
                    "{ call InsertarCabeceraVentas(?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");
            prodProAlm.setString(1, obj.getMun_venta());
            prodProAlm.setLong(2, obj.getId_cliente());
            prodProAlm.setLong(3, obj.getId_usuario());
            prodProAlm.setLong(4, obj.getId_sucursal());
            prodProAlm.setString(5, obj.getForma_de_pago());
            prodProAlm.setString(6, obj.getTipo_de_venta());
            prodProAlm.setBigDecimal(7, obj.getSubtotal_con_iva());
            prodProAlm.setBigDecimal(8, obj.getSubtotal_sin_iva());
            prodProAlm.setBigDecimal(9, obj.getIva_venta());
            prodProAlm.setBigDecimal(10, obj.getDescuento_venta());
            prodProAlm.setBigDecimal(11, obj.getTotal_venta());
            prodProAlm.setBigDecimal(12, obj.getUtilidad());
            prodProAlm.setString(13, obj.getEstado());

            prodProAlm.registerOutParameter("valor", Types.VARCHAR);
            prodProAlm.executeUpdate();
            valor = prodProAlm.getString("valor");
            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return valor;
    }

    ////////// insertar detalle ventas
    public String InsertarDetalleVentas(Detalle_ventas obj) {

        String valor = "";
        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement prodProAlm = conect.prepareCall(
                    "{ call InsertarDetalleVentas(?,?,?,?,?,?,?) }");
            prodProAlm.setLong(1, obj.getId_cabecera_venta());
            prodProAlm.setLong(2, obj.getId_control());
            prodProAlm.setBigDecimal(3, obj.getPrecio());
            prodProAlm.setLong(4, obj.getCantidad());
            prodProAlm.setBigDecimal(5, obj.getIva());
            prodProAlm.setBigDecimal(6, obj.getDescuento());

            prodProAlm.registerOutParameter("valor", Types.VARCHAR);
            prodProAlm.executeUpdate();
            valor = prodProAlm.getString("valor");
            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return valor;
    }

    public String EliminarDetalleDevolucion(DetalleNotaPedido det) {
        String dato = null;
        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement pro = conect.prepareCall(
                    "{ call EliminarDetalleDevolucion(?,?,?,?,?,?,?,?)}");
            pro.setLong(1, det.getId_detalle_nota_pedidos());
            pro.setLong(2, det.getId_precio());
            pro.setLong(3, det.getCantidad());
            pro.setBigDecimal(4, det.getDescuento());
            pro.setBigDecimal(5, det.getIva());
            pro.setBigDecimal(6, det.getTotal());
            pro.setLong(7, det.getBono());
            pro.registerOutParameter("valor", Types.VARCHAR);
            pro.executeUpdate();
            //pro.execute();
            dato = pro.getString("valor");
            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return dato;

    }

    public ArrayList<StockVentas> listarStockVentas(Long id_cab) {
        ArrayList<StockVentas> lista = new ArrayList<StockVentas>();

        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement prcProcedimientoAlmacenado = conect.prepareCall(
                    "{ call BuscarStockVentas(?)}");
            prcProcedimientoAlmacenado.setLong(1, id_cab);
            prcProcedimientoAlmacenado.execute();
            rs = prcProcedimientoAlmacenado.getResultSet();
            while (rs.next()) {
                StockVentas obj = EntidadesMappers.getStockVentasFromResultSet(rs);
                lista.add(obj);
            }
            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lista;
    }

    public void ActulizarStockVentas(StockVentas det) {

        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement pro = conect.prepareCall(
                    "{ call ActualizarStockVentas(?,?)}");
            pro.setLong(1, det.getId_control());
            pro.setLong(2, det.getCantidad());

            pro.executeUpdate();

            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public ArrayList<Listar_usuario> filtroApellidoUs(Listar_usuario lu) {
        ArrayList<Listar_usuario> valor = new ArrayList<Listar_usuario>();
        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement pro = conect.prepareCall(
                    "{ call fc_filtro_apellido_usuario(?)}");
            pro.setString(1, lu.getApellidos());
            rs = pro.executeQuery();
            while (rs.next()) {
                Listar_usuario obj = EntidadesMappers.getUsuarioFromResultSet(rs);
                valor.add(obj);
            }
            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return valor;
    }

    public ArrayList<Listar_usuario> filtroCodigoUs(Listar_usuario lu) {
        ArrayList<Listar_usuario> valor = new ArrayList<Listar_usuario>();
        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement pro = conect.prepareCall(
                    "{ call fc_filtro_cod_usuario(?)}");
            pro.setLong(1, lu.getId_sesion());
            rs = pro.executeQuery();
            while (rs.next()) {
                Listar_usuario obj = EntidadesMappers.getUsuarioFromResultSet(rs);
                valor.add(obj);
            }
            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return valor;
    }

    public ArrayList<Punto_venta_usuario> filtroPvNombre(Punto_venta_usuario lu) {
        ArrayList<Punto_venta_usuario> valor = new ArrayList<Punto_venta_usuario>();
        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement pro = conect.prepareCall(
                    "{ call fc_filtro_pv_nombre(?)}");
            //pro.setLong(1, lu.getId_localidad());
            pro.setString(1, lu.getNombre());
            //pro.setLong(3, lu.getId_punto_venta());
            rs = pro.executeQuery();
            while (rs.next()) {
                Punto_venta_usuario obj = EntidadesMappers.getPuntoVentaUsuarioFromResultSet(rs);
                valor.add(obj);
            }
            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return valor;
    }

    public ArrayList<Punto_venta_usuario> filtroPvCodigo(Punto_venta_usuario lu) {
        ArrayList<Punto_venta_usuario> valor = new ArrayList<Punto_venta_usuario>();
        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement pro = conect.prepareCall(
                    "{ call fc_filtro_pv_id(?)}");
            pro.setLong(1, lu.getId_punto_venta());
            rs = pro.executeQuery();
            while (rs.next()) {
                Punto_venta_usuario obj = EntidadesMappers.getPuntoVentaUsuarioFromResultSet(rs);
                valor.add(obj);
            }
            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return valor;
    }

    public ArrayList<Listar_usuario> filtroCedulaUs(Listar_usuario lu) {
        ArrayList<Listar_usuario> valor = new ArrayList<Listar_usuario>();
        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement pro = conect.prepareCall(
                    "{ call fc_filtro_cedula_usuario(?)}");
            pro.setString(1, lu.getCedula());
            rs = pro.executeQuery();
            while (rs.next()) {
                Listar_usuario obj = EntidadesMappers.getUsuarioFromResultSet(rs);
                valor.add(obj);
            }
            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return valor;
    }

    public ArrayList<Listar_usuario> filtroFechaUs(Listar_usuario lu) {
        ArrayList<Listar_usuario> valor = new ArrayList<Listar_usuario>();
        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement pro = conect.prepareCall(
                    "{ call fc_filtro_fecha_usuario(?)}");
            pro.setString(1, lu.getFecha_registro());
            rs = pro.executeQuery();
            while (rs.next()) {
                Listar_usuario obj = EntidadesMappers.getUsuarioFromResultSet(rs);
                valor.add(obj);
            }
            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return valor;
    }

    public ArrayList<Listar_usuario> filtroEstadoUs(Listar_usuario lu) {
        ArrayList<Listar_usuario> valor = new ArrayList<Listar_usuario>();
        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement pro = conect.prepareCall(
                    "{ call fc_filtro_estado_usuario(?)}");
            pro.setLong(1, lu.getId_estado());
            rs = pro.executeQuery();
            while (rs.next()) {
                Listar_usuario obj = EntidadesMappers.getUsuarioFromResultSet(rs);
                valor.add(obj);
            }
            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return valor;
    }

    public String RucLocal(Nombre_local pv) {
        String valor = null;
        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement pro = conect.prepareCall(
                    "{ call fc_ruc_local(?,?)}");
            pro.setString(1, pv.getRuc_local());
            pro.registerOutParameter("salida", Types.VARCHAR);
            pro.executeUpdate();
            valor = pro.getString("salida");
            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return valor;
    }

    public String ruc_local() {
        String ruc = "";
        try {
            conect = con.conectar();
            ps = conect.prepareStatement("SELECT `fc_punto_venta`.`ruc_local` FROM `fc_punto_venta`;");
            rs = ps.executeQuery();
            rs.next();
            ruc = rs.getString("ruc_local");
            conect.close();
        } catch (SQLException e) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ruc;
    }

    public Double obtenerIvaVentas(String query) {
        Double iva = 0.00;
        try {
            conect = con.conectar();

            java.sql.Statement st = conect.createStatement();
            rs = st.executeQuery(query);
            rs.next();
            iva = rs.getDouble("iva");
            conect.close();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return iva;
    }

    public ArrayList<JoinListarNotaPedidosCabecera> RangoFechaCompra(int op, JoinListarNotaPedidosCabecera cab) {
        ArrayList<JoinListarNotaPedidosCabecera> lista = new ArrayList<JoinListarNotaPedidosCabecera>();
        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement prcProcedimientoAlmacenado = conect.prepareCall(
                    "{ call FiltroRangoFecha(?,?,?)}");
            prcProcedimientoAlmacenado.setInt(1, op);
            prcProcedimientoAlmacenado.setString(2, cab.getFecha1());
            prcProcedimientoAlmacenado.setString(3, cab.getFecha2());
            prcProcedimientoAlmacenado.execute();
            rs = prcProcedimientoAlmacenado.getResultSet();
            while (rs.next()) {
                JoinListarNotaPedidosCabecera obj = EntidadesMappers.getListadoCabeceraNotaPedidoEnComprasRangoFechaFromResultSet(rs);
                lista.add(obj);
            }
            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lista;
    }
    ///////////////////RANGO FECHA Venta

    public ArrayList<JoinListarCabeceraVenta> RangoFechaVenta(int op, JoinListarCabeceraVenta cab) {
        ArrayList<JoinListarCabeceraVenta> lista = new ArrayList<JoinListarCabeceraVenta>();
        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement prcProcedimientoAlmacenado = conect.prepareCall(
                    "{ call FiltroRangoFechaVenta(?,?,?)}");
            prcProcedimientoAlmacenado.setInt(1, op);
            prcProcedimientoAlmacenado.execute();
            rs = prcProcedimientoAlmacenado.getResultSet();
            while (rs.next()) {
                JoinListarCabeceraVenta obj = EntidadesMappers.getListadoCabeceraVentaFromResultSet(rs);
                lista.add(obj);
            }
            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lista;
    }

    public ArrayList<JoinListarCabeceraVenta> ListarCabeceraVentas(int op) {
        ArrayList<JoinListarCabeceraVenta> lista = new ArrayList<JoinListarCabeceraVenta>();
        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement prcProcedimientoAlmacenado = conect.prepareCall(
                    "{ call ListarRegistroVenta(?)}");
            prcProcedimientoAlmacenado.setInt(1, op);
            prcProcedimientoAlmacenado.execute();
            rs = prcProcedimientoAlmacenado.getResultSet();
            while (rs.next()) {
                JoinListarCabeceraVenta obj = EntidadesMappers.getListadoCabeceraVentaFromResultSet(rs);
                lista.add(obj);
            }
            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lista;
    }

    public ArrayList<Faltantes> listarJoinProductosFaltantes(int op) {//piguiFaltantes
        ArrayList<Faltantes> lista = new ArrayList<Faltantes>();

        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement prcProcedimientoAlmacenado = conect.prepareCall(
                    "{ call faltantes_cantidad() }");
//            prcProcedimientoAlmacenado.setInt(1, op);
            prcProcedimientoAlmacenado.execute();
            rs = prcProcedimientoAlmacenado.getResultSet();
            while (rs.next()) {
                Faltantes obj = EntidadesMappers.getJoinFaltantesCantidadFromResultSet(rs);
                lista.add(obj);
            }
            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lista;
    }

    public ArrayList<ListarJoinPrecioNotaPedido> listarPrecioNota(int op, String id) {
        ArrayList<ListarJoinPrecioNotaPedido> lista = new ArrayList<ListarJoinPrecioNotaPedido>();

        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement prcProcedimientoAlmacenado = conect.prepareCall(
                    "{ call ListarPrecioNotaPedido(?,?) }");
            prcProcedimientoAlmacenado.setInt(1, op);
            prcProcedimientoAlmacenado.setString(2, id);
            prcProcedimientoAlmacenado.execute();
            rs = prcProcedimientoAlmacenado.getResultSet();
            while (rs.next()) {
                ListarJoinPrecioNotaPedido obj = EntidadesMappers.getJoinListarPrecioNotaFromResultSet(rs);
                lista.add(obj);
            }
            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lista;
    }
//   public ArrayList<ListarJoinPrecioNotaPedido> listarPrecioNota1(int op) {
//        ArrayList<ListarJoinPrecioNotaPedido> lista = new ArrayList<ListarJoinPrecioNotaPedido>();
//
//        try {
//            conect = con.conectar();
//            conect.setAutoCommit(false);
//            CallableStatement prcProcedimientoAlmacenado = conect.prepareCall(
//                    "{ call ListarPrecioNotaPedido(?) }");
//            prcProcedimientoAlmacenado.setInt(1, op);
//            prcProcedimientoAlmacenado.execute();
//            rs = prcProcedimientoAlmacenado.getResultSet();
//            while (rs.next()) {
//                ListarJoinPrecioNotaPedido obj = EntidadesMappers.getJoinListarPrecioNotaFromResultSet(rs);
//                lista.add(obj);
//            }
//            conect.commit();
//        } catch (Exception e) {
//            try {
//                conect.rollback();
//                e.printStackTrace();
//            } catch (SQLException ex) {
//                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        } finally {
//            try {
//                conect.close();
//            } catch (SQLException ex) {
//                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        return lista;
//    }

    public ArrayList<joinProductoDetallesFaltantes> FiltrosProductosNota(String op1, String op2) {
        ArrayList<joinProductoDetallesFaltantes> lista = new ArrayList<joinProductoDetallesFaltantes>();

        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement prcProcedimientoAlmacenado = conect.prepareCall(
                    "{call FiltrosProductosNota(?,?)}");
            prcProcedimientoAlmacenado.setString(1, op1);
            prcProcedimientoAlmacenado.setString(2, op2);
            prcProcedimientoAlmacenado.execute();
            rs = prcProcedimientoAlmacenado.getResultSet();
            while (rs.next()) {
                joinProductoDetallesFaltantes obj = EntidadesMappers.getJoinDetallesFaltantesFromResultSet(rs);
                lista.add(obj);
            }
            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lista;

    }

    public ArrayList<listarJoinProductosCompras> listarConvertidorProducto(int op) {
        ArrayList<listarJoinProductosCompras> lista = new ArrayList<listarJoinProductosCompras>();

        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement prcProcedimientoAlmacenado = conect.prepareCall(
                    "{call listarPoductosCompras(?)}");
            prcProcedimientoAlmacenado.setInt(1, op);

            prcProcedimientoAlmacenado.execute();
            rs = prcProcedimientoAlmacenado.getResultSet();
            while (rs.next()) {
                listarJoinProductosCompras obj = EntidadesMappers.getJoinConvertidorProductoFromResultSet(rs);
                lista.add(obj);
            }
            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lista;

    }

    public String iniciarConversion(listarJoinProductosCompras obj1, listarJoinProductosCompras obj2, Integer valorA, Integer valorB) {
        String valor = "";
        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement cs = conect.prepareCall(
                    "{ call convertirStock(?,?,?,?,?) }");
            cs.setLong(1, obj1.getIdStock());
            cs.setLong(2, obj2.getIdStock());
            cs.setInt(3, valorA);
            cs.setInt(4, valorB);
            cs.registerOutParameter("valor", Types.VARCHAR);
            cs.executeUpdate();
            valor = cs.getString("valor");
            conect.commit();
        } catch (SQLException e) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valor;
    }

    public ArrayList<Detalle_ventas> ListarDetallesVentas(int idCab) {
        ArrayList<Detalle_ventas> lista = new ArrayList<Detalle_ventas>();

        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement proced = conect.prepareCall(
                    "{ call ListarRegistroDetalleVenta(?) }");
            proced.setInt(1, idCab);
            proced.execute();
            rs = proced.getResultSet();
            while (rs.next()) {
                Detalle_ventas obj = EntidadesMappers.getJoinDetallesVentas(rs);
                lista.add(obj);
            }
            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lista;
    }
    public String insertarProductoNuevoConvertidor(Productos obj) {
        //ArrayList<Productos> lista = new ArrayList<Productos>();
        String valor = "";
        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement prodProAlm = conect.prepareCall(
                    "{ call ingresarProductoConvertidor(?,?,?,?,?,?,?,?,?,?,?,?) }");
            prodProAlm.setString(1, obj.getNombre());
            prodProAlm.setString(2, obj.getDescripcion());
            prodProAlm.setDate(3, obj.getFecha_registro());
            prodProAlm.setDouble(4, obj.getPeso());
            prodProAlm.setLong(5, obj.getId_tipo());
            prodProAlm.setLong(6, obj.getId_medidas());
            prodProAlm.setLong(7, obj.getId_envase());
            prodProAlm.setLong(8, obj.getId_marcas());
            prodProAlm.setLong(9, obj.getId_usuario());
            prodProAlm.setString(10, obj.getIva());
            prodProAlm.setLong(11, obj.getCantidad_minima());
            prodProAlm.registerOutParameter("valor1", Types.VARCHAR);
            prodProAlm.executeUpdate();
            valor = prodProAlm.getString("valor1");
            //  rs = prodProAlm.getResultSet();
//            while (rs.next()) {
//                MarcaProducto obj = EntidadesMappers.getMarcaProductoFromResultSet(rs);
//                lista.add(obj);
//            }

            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return valor;
    }
    public String actualizarPrecioCompraConvertidor(Precios obj) {
        //ArrayList<Productos> lista = new ArrayList<Productos>();
        String valor = null;
        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement prodProAlm = conect.prepareCall(
                    "{ call actualizarPrecioConvertidor(?,?,?,?,?,?,?) }");
            prodProAlm.setLong(1, obj.getId_producto());
            prodProAlm.setDouble(2, obj.getPrecio_compra());
            prodProAlm.setDouble(3, obj.getPrecio_venta());
            prodProAlm.setString(4, obj.getFecha_registro());
            prodProAlm.setLong(5, obj.getId_usuario());
            prodProAlm.setLong(6, obj.getPorcentaje());
            prodProAlm.registerOutParameter("valor2", Types.VARCHAR);
            prodProAlm.executeUpdate();
            valor = prodProAlm.getString("valor2");
            //  rs = prodProAlm.getResultSet();
//            while (rs.next()) {
//                MarcaProducto obj = EntidadesMappers.getMarcaProductoFromResultSet(rs);
//                lista.add(obj);
//            }

            conect.commit();
        } catch (Exception e) {
            try {
                conect.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                conect.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return valor;
    }
    public String iniciarConversionProductoNuevo(listarJoinProductosCompras obj1, Long idPrecioNuevo , Integer valorA, Integer valorB) {
        String valor = "";
        try {
            conect = con.conectar();
            conect.setAutoCommit(false);
            CallableStatement cs = conect.prepareCall(
                    "{ call convertirStockProductoNuevo(?,?,?,?,?) }");
            cs.setLong(1, obj1.getIdStock());
            cs.setLong(2, idPrecioNuevo);
            cs.setInt(3, valorA);
            cs.setInt(4, valorB);
            cs.registerOutParameter("valor", Types.VARCHAR);
            cs.executeUpdate();
            valor = cs.getString("valor");
            conect.commit();
        } catch (SQLException e) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valor;
    }
}
