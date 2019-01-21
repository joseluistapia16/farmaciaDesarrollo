/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmacia.entities.mappers;

import com.farmacia.join_entidades.FaltantesCabeceraDetalles;
import com.farmacia.join_entidades.ListarJoinProveedor;
import com.farmacia.join_entidades.ListarNotas;

import com.farmacia.join_entidades.joinProductoDetallesFaltantes;
import com.farmacia.join_entidades.listarJoinProductosCompras;
import com.farmacia.entities1.Clientes;
import com.farmacia.entities1.Correo;
import com.farmacia.entities1.Correo_Cliente;
import com.farmacia.entities1.EnvaseProducto;
import com.farmacia.entities1.Laboratorio;
import com.farmacia.entities1.ListarPuntoVenta;
import com.farmacia.entities1.Listar_usuario;
import com.farmacia.entities1.MedidaProducto;
import com.farmacia.entities1.Productos;
import com.farmacia.entities1.MarcaProducto;
import com.farmacia.entities1.Persona;
import com.farmacia.entities1.Precios;
import com.farmacia.entities1.Telefono;
import com.farmacia.entities1.Telefono_Cliente;
import com.farmacia.entities1.TipoProducto;
import com.farmacia.entities1.fc_localidad_guayas;
//<<<<<<< HEAD
//=======
import com.farmacia.join_entidades.JoinListarDetalleNotaPedido;
//>>>>>>> origin/JoseLuis
import com.farmacia.join_entidades.JoinListarNotaPedidosCabecera;
import com.farmacia.join_entidades.JoinListarProductosVentas;
import com.farmacia.join_entidades.ListarJoinProveedorNotaPedido;
import com.farmacia.join_entidades.listarJoinProductosNotaPedidos;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author josel
 */
public class EntidadesMappers {

    public static Productos getProductosFromResultSet(ResultSet rs) {
        Productos obj = new Productos();
        try {
            obj.setId_productos(rs.getLong("ID_PRODUCTOS"));
            obj.setId_tipo(rs.getLong("ID_TIPO"));
            obj.setId_marcas(rs.getLong("ID_MARCAS"));
            obj.setId_medidas(rs.getLong("MEDIDAS"));
            obj.setId_envase(rs.getLong("ID_ENVASE"));
            obj.setNombre(rs.getString("NOMBRE"));
            obj.setDescripcion(rs.getString("DESCRIPCION"));
            obj.setPeso(rs.getDouble("PESO"));
            obj.setFecha_registro(rs.getDate("FECHA_REGISTRO"));

        } catch (SQLException ex) {
            Logger.getLogger(EntidadesMappers.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }

    public static FaltantesCabeceraDetalles getJoinProductosFromResultSet(ResultSet rs) {
        FaltantesCabeceraDetalles obj = new FaltantesCabeceraDetalles();
        try {
            obj.setId_detalle_faltantes(rs.getLong("ID_DETALLE_FALTANTES"));
            obj.setFecha_registro(rs.getDate("FECHA_REGISTRO"));
            obj.setCantidad(rs.getInt("CANTIDAD"));
            obj.setEstado(rs.getString("ESTADO"));
            obj.setId_marcas(rs.getLong("ID_MARCAS"));
            obj.setMarca(rs.getString("MARCA"));
            obj.setId_productos(rs.getLong("ID_PRODUCTOS"));
            obj.setNombre(rs.getString("NOMBRE"));
            obj.setDescripcion(rs.getString("DESCRIPCION"));

        } catch (SQLException ex) {
            Logger.getLogger(EntidadesMappers.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }

    public static joinProductoDetallesFaltantes getJoinDetallesFaltantesFromResultSet(ResultSet rs) {
        joinProductoDetallesFaltantes obj = new joinProductoDetallesFaltantes();
        try {
            obj.setId_detalle_faltantes(rs.getLong("ID_DETALLE_FALTANTES"));
            obj.setId_producto(rs.getLong("ID_PRODUCTO"));
            obj.setNombre_producto(rs.getString("PRODUCTO"));
            obj.setId_marcas(rs.getLong("ID_MARCAS"));
            obj.setMarca(rs.getString("MARCA"));
            obj.setId_tipo(rs.getLong("ID_TIPO"));
            obj.setNombre_tipo(rs.getString("TIPO"));
            obj.setCantidad(rs.getInt("CANTIDAD"));
            obj.setId_medida(rs.getLong("ID_MEDIDAS"));
            obj.setMedida(rs.getString("MEDIDA"));
            obj.setId_envase(rs.getLong("ID_ENVASE"));
            obj.setEnvase(rs.getString("ENVASE"));
            obj.setEstado(rs.getString("ESTADO"));
            obj.setId_precios(rs.getLong("ID_PRECIO"));
            obj.setPrecios(rs.getDouble("PRECIO"));
            obj.setIva(rs.getString("IVA"));

        } catch (SQLException ex) {
            Logger.getLogger(EntidadesMappers.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }

    public static listarJoinProductosCompras getJoinTodosProductosFromResultSet(ResultSet rs) {
        listarJoinProductosCompras obj = new listarJoinProductosCompras();
        try {
            obj.setId_productos(rs.getLong("ID_PRODUCTOS"));
            obj.setNombreProductos(rs.getString("NOMBRE"));
            obj.setDescripcion(rs.getString("DESCRIPCION"));
            obj.setFecha_registro(rs.getDate("FECHA_REGISTRO"));
            obj.setPeso(rs.getDouble("peso"));
            obj.setId_tipo(rs.getLong("ID_TIPO"));
            obj.setNombreTipo(rs.getString("TIPO"));
            obj.setId_medida(rs.getLong("ID_MEDIDAS"));
            obj.setNombreMedida(rs.getString("MEDIDA"));
            obj.setId_envase(rs.getLong("ID_ENVASE"));
            obj.setNombreEnvase(rs.getString("ENVASE"));
            obj.setId_marca(rs.getLong("ID_MARCAS"));
            obj.setNombreMarca(rs.getString("MARCA"));
            obj.setId_usuario(rs.getLong("ID_USUARIO"));
            obj.setIva(rs.getString("IVA"));
            obj.setCantidad_minima(rs.getLong("CANTIDAD_MINIMA"));

        } catch (SQLException ex) {
            Logger.getLogger(EntidadesMappers.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }
    
    public static ListarPuntoVenta getJoinLocalidadGyFromResultSet(ResultSet rs) {
        ListarPuntoVenta obj = new ListarPuntoVenta();
        try {
            obj.setId_punto_venta(rs.getLong("id_punto_venta"));
            obj.setNombre(rs.getString("nombre"));
            obj.setLocalidad(rs.getString("localidad"));
            obj.setDireccion(rs.getString("direccion"));
            obj.setObservacion(rs.getString("observacion"));
        } catch (SQLException ex) {
            Logger.getLogger(EntidadesMappers.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }

    public static TipoProducto getTipoProductoFromResultSet(ResultSet rs) {
        TipoProducto obj = new TipoProducto();
        try {
            obj.setId_tipo(rs.getLong("ID_TIPO"));
            obj.setNombreTipo(rs.getString("NOMBRE"));

        } catch (SQLException ex) {
            Logger.getLogger(EntidadesMappers.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }

    public static MedidaProducto getMedidaProductoFromResultSet(ResultSet rs) {
        MedidaProducto obj = new MedidaProducto();
        try {
            obj.setId_medidas(rs.getLong("ID_MEDIDAS"));
            obj.setNombre_medida(rs.getString("NOMBRE_MEDIDA"));

        } catch (SQLException ex) {
            Logger.getLogger(EntidadesMappers.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }

    public static EnvaseProducto getEnvaseProductoFromResultSet(ResultSet rs) {
        EnvaseProducto obj = new EnvaseProducto();
        try {
            obj.setId_envase(rs.getLong("ID_ENVASE"));
            obj.setNombreEnvase(rs.getString("NOMBRE"));

        } catch (SQLException ex) {
            Logger.getLogger(EntidadesMappers.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }

    public static MarcaProducto getMarcaProductoFromResultSet(ResultSet rs) {
        MarcaProducto obj = new MarcaProducto();
        try {
            obj.setId_Marcas(rs.getLong("ID_MARCAS"));
            obj.setNombreMarca(rs.getString("NOMBRE"));
        } catch (SQLException ex) {
            Logger.getLogger(EntidadesMappers.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }

    public static ListarJoinProveedor getListarJoinProveedorFromResultSet(ResultSet rs) {
        ListarJoinProveedor obj = new ListarJoinProveedor();
        try {
            obj.setId_proveedor(rs.getLong("ID_PROVEEDOR"));
            obj.setId_proveedor_clase(rs.getLong("ID_PROVEEDOR_CLASE"));
            obj.setClase(rs.getString("CLASE"));
            obj.setCedula_ruc(rs.getString("CEDULA_RUC"));
            obj.setEntidad(rs.getString("ENTIDAD"));
            obj.setRepresentante(rs.getString("REPRESENTANTE"));
            obj.setDireccion(rs.getString("DIRECCION"));
            obj.setFecha_registro(rs.getDate("FECHA_REGISTRO"));
            obj.setEstado(rs.getString("ESTADO"));
            //   obj.set//Id_tipo_telefono(rs.getLong("ID_TIPO_TELEFONO"));
            obj.setTelefono(rs.getString("TELEFONO"));
            // obj.setTipo_telefon(rs.getString("TIPO_TELEFON"));
            //  obj.setId_tipo_correo(rs.getLong("ID_TIPO_CORREO"));
            obj.setMail(rs.getString("CORREO"));
            // obj.setTipo_correo(rs.getString("TIPO_CORREO"));
            // obj.setTelefono(telefono);
            obj.setDireccionImagen(rs.getString("direccionImagen"));

        } catch (SQLException ex) {
            Logger.getLogger(EntidadesMappers.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////
//    public static ListarNotas getListarNotasFromResultSet(ResultSet rs) {
//        ListarNotas obj = new ListarNotas();
//        try {
//            //SELECT ,p.entidad ,p.representante,cnp.fecha_creacion,cnp.estado,cnp.iva,cnp.descuento,cnp.total
//
//            obj.setId_cabecera_nota_pedidos(rs.getLong("ID_CABECERA_NOTA_PEDIDOS"));
//            obj.setId_proveedor(rs.getLong("CODIGO"));
//            obj.setEntidad(rs.getString("NOMBRE"));
//            obj.setRepresentante(rs.getString("REPRESENTANTE"));
//            obj.setFecha_creacion(rs.getString("FECHA_CREACION"));
//            obj.setDescuento(rs.getDouble("DESCUENTO"));
//            obj.setIva(rs.getDouble("IVA"));
//            obj.setTotal(rs.getDouble("TOTAL"));
//         
//        } catch (SQLException ex) {
//            Logger.getLogger(EntidadesMappers.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return obj;
//    }
    public static Correo getCorreoFromResultSet(ResultSet rs) {
        Correo obj = new Correo();
        try {
            obj.setId_correo(rs.getLong("ID_PROMAIL"));
            //  obj.setId_proveedor(rs.getLong("ID_PROVEEDOR"));
            obj.setId_tipo_correo(rs.getInt("ID_TIPO_CORREO"));
            obj.setCorreo(rs.getString("MAIL"));
            obj.setTipo_correo(rs.getString("TIPO_CORREO"));
            obj.setCedula_ruc(rs.getString("CEDULA_RUC"));
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(EntidadesMappers.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }

//    public static Proveedor getProveedorFromResultSet (ResultSet rs){
//    Proveedor obj = new Proveedor();   
//        try {
//            obj.setId_proveedor(rs.getLong("id_proveedor"));
//            obj.setCedula_ruc(rs.getString("cedula_ruc"));
//            obj.setNombre(rs.getString("entidad"));
//            obj.setContacto_re(rs.getString("contacto"));
//            obj.setDireccion(rs.getString("direccion"));
//            obj.setFecha_registro(rs.getDate("fecha_registro"));    
//            obj.setStr_telefono(rs.getString("str_telefono"));
//            obj.setStr_correo(rs.getString("str_correo"));
//        } catch (SQLException ex) {
//            java.util.logging.Logger.getLogger(EntidadesMappers.class.getName()).log(Level.SEVERE, null, ex);
//        }
//      return obj;
//    }
    public static Telefono getTelefonoFromResultSet(ResultSet rs) {
        Telefono obj = new Telefono();
        try {
            obj.setId_telefono(rs.getLong("id_protelefono"));
            //obj.setId_proveedor(rs.getLong("ID_PROVEEDOR"));
            obj.setId_tipo_telefono(rs.getInt("ID_TIPO_TELEFONO"));
            obj.setTelefono(rs.getString("telefono"));
            obj.setTipoTelefono(rs.getString("TIPO_TELEFONO"));
            obj.setCedula_ruc(rs.getString("CEDULA_RUC"));

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(EntidadesMappers.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }

    public static FaltantesCabeceraDetalles getJoinTodosProductosFaltantesFromResultSet(ResultSet rs) {//piguiFaltantes
        FaltantesCabeceraDetalles obj = new FaltantesCabeceraDetalles();
        try {
            obj.setId_productos(rs.getLong("ID_PRODUCTOS"));
            obj.setMarca(rs.getString("MARCA"));;
            obj.setNombre(rs.getString("NOMBRE"));
            obj.setDescripcion(rs.getString("DESCRIPCION"));
            obj.setCantidad(rs.getInt("CANTIDAD"));
            obj.setEstado(rs.getString("ESTADO"));

        } catch (SQLException ex) {
            Logger.getLogger(EntidadesMappers.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }

    public static Laboratorio getLaboratorioFromResultSet(ResultSet rs) {//KELLY LABORATORIO
        Laboratorio obj = new Laboratorio();
        try {
            obj.setId_Laboratorio(rs.getLong("id_Laboratorio"));
            obj.setRUC(rs.getString("RUC"));
            obj.setNombre(rs.getString("Nombre"));
            obj.setDireccion(rs.getString("Direccion"));
            obj.setTelefono(rs.getString("Telefono"));
            obj.setFecha(rs.getDate("Fecha"));
            obj.setImagen(rs.getString("Imagen"));
            obj.setCorreo(rs.getString("Correo"));
        } catch (SQLException ex) {
            Logger.getLogger(EntidadesMappers.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }

    public static Correo_Cliente getCorreoClientesFromResultSet(ResultSet rs) {//kelly cliente
        Correo_Cliente obj = new Correo_Cliente();
        try {
            obj.setId_Correo(rs.getLong("id_Correo"));
            obj.setCorreo(rs.getString("Correo"));
            obj.setCedula(rs.getString("Cedula"));
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(EntidadesMappers.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }

    public static Clientes getClienteFromResultSet(ResultSet rs) {
        Clientes obj = new Clientes();
        try {
            obj.setId_Clientes(rs.getLong("id_Clientes"));
            obj.setCedula(rs.getString("Cedula"));
            obj.setNombre(rs.getString("Nombre"));
            obj.setApellido(rs.getString("Apellido"));
            obj.setDireccion(rs.getString("Direccion"));
            obj.setFecha_reg(rs.getDate("Fecha_reg"));
            obj.setStr_telefono(rs.getString("str_telefono"));
            obj.setStr_correo(rs.getString("str_correo"));
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(EntidadesMappers.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }

    public static Telefono_Cliente getTelefonoClienteFromResultSet(ResultSet rs) {
        Telefono_Cliente obj = new Telefono_Cliente();
        try {
            obj.setId_Telefono(rs.getLong("id_Telefono"));
            obj.setId_tipo_Telefono(rs.getLong("id_Tipo_Telefono"));
            obj.setNumero(rs.getString("Numero"));
            obj.setCedula(rs.getString("Cedula"));

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(EntidadesMappers.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }

    public static Precios getPrecioCompraFromResultSet(ResultSet rs) {
        Precios obj = new Precios();
        try {
            obj.setId_precio(rs.getLong("id_precio"));
            obj.setId_producto(rs.getLong("id_producto"));
            obj.setPrecio_compra(rs.getDouble("precio_compra"));
            obj.setPrecio_venta(rs.getDouble("precio_venta"));
            obj.setEstado(rs.getString("estado"));

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(EntidadesMappers.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }

    public static Precios getPreciosProductosFromResultSet(ResultSet rs) {
        Precios obj = new Precios();
        try {
            obj.setId_precio(rs.getLong("id_precio"));
            obj.setId_producto(rs.getLong("id_producto"));
            obj.setPrecio_compra(rs.getDouble("precio_compra"));
            obj.setPrecio_venta(rs.getDouble("precio_venta"));
            obj.setEstado(rs.getString("ESTADO"));

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(EntidadesMappers.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }

    public static JoinListarNotaPedidosCabecera getListadoCabeceraNotaPedidosFromResultSet(ResultSet rs) {
        JoinListarNotaPedidosCabecera obj = new JoinListarNotaPedidosCabecera();
        try {

            obj.setId_cabecera_nota_pedidos(rs.getLong("ID_CABECERA_NOTA_PEDIDOS"));
            obj.setId_proveedor(rs.getLong("ID_PROVEEDOR"));
            obj.setCorreo(rs.getString("CORREO"));
            obj.setId_proveedor_clase(rs.getLong("ID_PROVEEDOR_CLASE"));
            obj.setClase(rs.getString("CLASE"));
            obj.setDireccion(rs.getString("DIRECCION"));
            obj.setCedula_ruc(rs.getString("CEDULA_RUC"));
            obj.setRepresentante(rs.getString("REPRESENTANTE"));
            obj.setEntidad(rs.getString("PROVEEDOR"));
            obj.setTelefono(rs.getString("TELEFONO"));
            obj.setFecha_creacion(rs.getString("FECHA_CREACION"));
            obj.setIva(rs.getDouble("IVA"));
            obj.setDescuento(rs.getDouble("DESCUENTO"));
            obj.setTotal(rs.getDouble("TOTAL"));
//            obj.setPlazo(rs.getString("PLAZO"));

        } catch (SQLException ex) {
            Logger.getLogger(EntidadesMappers.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }
    public static JoinListarNotaPedidosCabecera getListadoCabeceraNotaPedidoEnComprasFromResultSet(ResultSet rs) {
        JoinListarNotaPedidosCabecera obj = new JoinListarNotaPedidosCabecera();
        try {

            obj.setId_cabecera_nota_pedidos(rs.getLong("ID_CABECERA_NOTA_PEDIDOS"));
            obj.setId_proveedor(rs.getLong("ID_PROVEEDOR"));
            obj.setCorreo(rs.getString("CORREO"));
            obj.setId_proveedor_clase(rs.getLong("ID_PROVEEDOR_CLASE"));
            obj.setClase(rs.getString("CLASE"));
            obj.setDireccion(rs.getString("DIRECCION"));
            obj.setCedula_ruc(rs.getString("CEDULA_RUC"));
            obj.setRepresentante(rs.getString("REPRESENTANTE"));
            obj.setEntidad(rs.getString("PROVEEDOR"));
            obj.setTelefono(rs.getString("TELEFONO"));
            obj.setFecha_creacion(rs.getString("FECHA_CREACION"));
            obj.setIva(rs.getDouble("IVA"));
            obj.setDescuento(rs.getDouble("DESCUENTO"));
            obj.setTotal(rs.getDouble("TOTAL"));
            obj.setPlazo(rs.getString("PLAZO"));
            obj.setForma_pago(rs.getString("FORMA_PAGO"));

        } catch (SQLException ex) {
            Logger.getLogger(EntidadesMappers.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }
     public static JoinListarDetalleNotaPedido getDetallePedidosFromResultSet(ResultSet rs) {
        JoinListarDetalleNotaPedido obj = new JoinListarDetalleNotaPedido();
        try {
            obj.setId_detalle_nota_pedido(rs.getLong("ID_DETALLE_NOTA_PEDIDOS"));
            obj.setId_producto(rs.getLong("ID_PRODUCTO"));
            obj.setMarca(rs.getString("MARCA"));
            obj.setTipo(rs.getString("TIPO"));
            obj.setProducto(rs.getString("PRODUCTO"));
            obj.setEnvase(rs.getString("ENVASE"));
            obj.setMedida(rs.getString("MEDIDA"));
            obj.setCantidad(rs.getInt("CANTIDAD"));
            obj.setPrecio(rs.getDouble("PRECIO"));
            obj.setDescuento(rs.getDouble("DESCUENTO"));
            obj.setIva(rs.getDouble("IVA"));
            obj.setTotal(rs.getDouble("TOTAL"));
            obj.setId_precio(rs.getLong("id_precio"));
            obj.setId_cabecera_nota_pedido(rs.getLong("id_cabecera_nota_pedidos"));
        } catch (SQLException ex) {
            Logger.getLogger(EntidadesMappers.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }
     public static JoinListarDetalleNotaPedido getDetallePedidoEnCompraFromResultSet(ResultSet rs) {
        JoinListarDetalleNotaPedido obj = new JoinListarDetalleNotaPedido();
        try {
            obj.setId_detalle_nota_pedido(rs.getLong("ID_DETALLE_NOTA_PEDIDOS"));
            obj.setId_producto(rs.getLong("ID_PRODUCTO"));
            obj.setMarca(rs.getString("MARCA"));
            obj.setTipo(rs.getString("TIPO"));
            obj.setProducto(rs.getString("PRODUCTO"));
            obj.setEnvase(rs.getString("ENVASE"));
            obj.setMedida(rs.getString("MEDIDA"));
            obj.setCantidad(rs.getInt("CANTIDAD"));
            obj.setPrecio(rs.getDouble("PRECIO"));
            obj.setDescuento(rs.getDouble("DESCUENTO"));
            obj.setIva(rs.getDouble("IVA"));
            obj.setTotal(rs.getDouble("TOTAL"));
        } catch (SQLException ex) {
            Logger.getLogger(EntidadesMappers.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }
//     public static JoinListarDetalleNotaPedido getDetallePedidosFromResultSet(ResultSet rs) {
//        JoinListarDetalleNotaPedido obj = new JoinListarDetalleNotaPedido();
//        try {
//
//            obj.setId_producto(rs.getLong("ID_PRODUCTO"));
//            obj.setMarca(rs.getString("MARCA"));
//            obj.setTipo(rs.getString("TIPO"));
//            obj.setProducto(rs.getString("PRODUCTO"));
//            obj.setEnvase(rs.getString("ENVASE"));
//            obj.setMedida(rs.getString("MEDIDA"));
//            obj.setCantidad(rs.getInt("CANTIDAD"));
//            obj.setPrecio(rs.getDouble("PRECIO"));
//            obj.setDescuento(rs.getDouble("DESCUENTO"));
//            obj.setIva(rs.getDouble("IVA"));
//            obj.setTotal(rs.getDouble("TOTAL"));
//        } catch (SQLException ex) {
//            Logger.getLogger(EntidadesMappers.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return obj;
//    }
    public static JoinListarNotaPedidosCabecera getCabeceraPedidosFromResultSet(ResultSet rs) {
        JoinListarNotaPedidosCabecera obj = new JoinListarNotaPedidosCabecera();
        try {

            obj.setId_cabecera_nota_pedidos(rs.getLong("ID_CABECERA_NOTA_PEDIDOS"));
            obj.setId_proveedor(rs.getLong("ID_PROVEEDOR"));
            obj.setCorreo(rs.getString("CORREO"));
            obj.setId_proveedor_clase(rs.getLong("ID_PROVEEDOR_CLASE"));
            obj.setClase(rs.getString("CLASE"));
            obj.setDireccion(rs.getString("DIRECCION"));
            obj.setCedula_ruc(rs.getString("CEDULA_RUC"));
            obj.setRepresentante(rs.getString("REPRESENTANTE"));
            obj.setEntidad(rs.getString("PROVEEDOR"));
            obj.setTelefono(rs.getString("TELEFONO"));
            obj.setFecha_creacion(rs.getString("FECHA_CREACION"));
            obj.setIva(rs.getDouble("IVA"));
            obj.setDescuento(rs.getDouble("DESCUENTO"));
            obj.setTotal(rs.getDouble("TOTAL"));
            obj.setPlazo(rs.getString("PLAZO"));

        } catch (SQLException ex) {
            Logger.getLogger(EntidadesMappers.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }

    public static listarJoinProductosNotaPedidos getJoinTodosProductosFromResultSetNota(ResultSet rs) {
        listarJoinProductosNotaPedidos obj = new listarJoinProductosNotaPedidos();
        try {
            obj.setId_productos(rs.getLong("ID_PRODUCTO"));
            obj.setNombreProductos(rs.getString("PRODUCTO"));
            obj.setId_tipo(rs.getLong("ID_TIPO"));
            obj.setNombreTipo(rs.getString("TIPO"));
            obj.setId_medida(rs.getLong("ID_MEDIDAS"));
            obj.setNombreMedida(rs.getString("MEDIDA"));
            obj.setId_envase(rs.getLong("ID_ENVASE"));
            obj.setNombreEnvase(rs.getString("ENVASE"));
            obj.setId_marca(rs.getLong("ID_MARCAS"));
            obj.setNombreMarca(rs.getString("MARCA"));
            obj.setCantidad(rs.getInt("CANTIDAD"));
            obj.setPrecio(rs.getDouble("PRECIO"));

        } catch (SQLException ex) {
            Logger.getLogger(EntidadesMappers.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }

    public static ListarJoinProveedorNotaPedido getListarJoinProveedorNotaPedidoFromResultSet(ResultSet rs) {
        ListarJoinProveedorNotaPedido obj = new ListarJoinProveedorNotaPedido();
        try {
            obj.setId_proveedor(rs.getLong("ID_PROVEEDOR"));
            obj.setId_proveedor_clase(rs.getLong("ID_PROVEEDOR_CLASE"));
            obj.setClase(rs.getString("CLASE"));
            obj.setCedula_ruc(rs.getString("CEDULA_RUC"));
            obj.setEntidad(rs.getString("ENTIDAD"));
            obj.setRepresentante(rs.getString("REPRESENTANTE"));
            obj.setDireccion(rs.getString("DIRECCION"));
            obj.setFecha_registro(rs.getDate("FECHA_REGISTRO"));
            obj.setEstado(rs.getString("ESTADO"));
            //   obj.set//Id_tipo_telefono(rs.getLong("ID_TIPO_TELEFONO"));
            obj.setTelefono(rs.getString("TELEFONO"));
            // obj.setTipo_telefon(rs.getString("TIPO_TELEFON"));
            //  obj.setId_tipo_correo(rs.getLong("ID_TIPO_CORREO"));
            obj.setMail(rs.getString("CORREO"));

        } catch (SQLException ex) {
            Logger.getLogger(EntidadesMappers.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }
    public static fc_localidad_guayas getLocalidadGuayasFromResultSet(ResultSet rs) {
        fc_localidad_guayas obj = new fc_localidad_guayas();
        try {
            obj.setId_localidad_guayas(rs.getLong("ID_LOCALIDAD_GUAYAS"));
            obj.setLocalidad(rs.getString("LOCALIDAD"));
            
         
        } catch (SQLException ex) {
            Logger.getLogger(EntidadesMappers.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }
    
    public static ListarPuntoVenta getPuntoVentaFromResultSet(ResultSet rs) {
        ListarPuntoVenta obj = new ListarPuntoVenta();
        try {
            obj.setId_punto_venta(rs.getLong("id_punto_venta"));
            obj.setNombre(rs.getString("nombre"));
            obj.setLocalidad(rs.getString("localidad"));
            obj.setDireccion(rs.getString("direccion"));
            obj.setObservacion(rs.getString("observacion"));
            
         
        } catch (SQLException ex) {
            Logger.getLogger(EntidadesMappers.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }
    public static Listar_usuario getUsuarioFromResultSet(ResultSet rs) {
        Listar_usuario obj = new Listar_usuario();
        try {
            obj.setId_sesion(rs.getLong("id_sesion"));
            obj.setFecha_registro(rs.getDate("fecha_registro"));
            obj.setCedula(rs.getString("cedula"));
            obj.setApellidos(rs.getString("apellidos"));
            obj.setNombres(rs.getString("nombres"));
            obj.setDireccion(rs.getString("direccion"));
            obj.setTelefono(rs.getString("telefono"));
            obj.setConvencional(rs.getString("convencional"));
            obj.setCorreo(rs.getString("correo"));
            obj.setCargo(rs.getString("cargo"));
            obj.setGenero(rs.getString("genero"));
            obj.setDiscapacidad(rs.getString("discapacidad"));
            obj.setPorcentaje(rs.getString("porcentaje"));
            obj.setEstado(rs.getString("estado"));
            obj.setObservacion(rs.getString("observacion"));
            
         
        } catch (SQLException ex) {
            Logger.getLogger(EntidadesMappers.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }
    /////////// mapper identidad listar producto ventas
    public static JoinListarProductosVentas getJoinTodosProductosVentasFromResultSet(ResultSet rs) {
        JoinListarProductosVentas obj = new JoinListarProductosVentas();
       
        try {
    
            obj.setId_producto(rs.getLong("Codigo"));
            obj.setProducto_nombre(rs.getString("Nombre del producto"));
            obj.setProducto_descripcion(rs.getString("Descripcion"));
            //obj.setId_tipo(rs.getLong("ID_TIPO"));
            obj.setTipo_nombre(rs.getString("Tipo"));
            //obj.setId_medida(rs.getLong("ID_MEDIDAS"));
            obj.setMedida_nombre(rs.getString("Medida"));
            //obj.setId_envase(rs.getLong("ID_ENVASE"));
            obj.setEnvase_nombre(rs.getString("Envase"));
            //obj.setId_marca(rs.getLong("ID_MARCAS"));
            obj.setMarca_nombre(rs.getString("Marca"));
            //obj.setId_stock(rs.getLong("ID_PRODUCTO"));
            obj.setStock(rs.getDouble("Stock"));
            obj.setIva(rs.getString("Iva"));
            //obj.setId_precio(rs.getLong("ID_PRECIO"));
            obj.setPrecio_venta(rs.getDouble("Precio de venta"));
            

        } catch (SQLException ex) {
            Logger.getLogger(EntidadesMappers.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }
    /////////// mapper identidad listar cliente ventas
    public static Persona getTodosClienteVentasFromResultSet(ResultSet rs) {
        Persona obj = new Persona();
       
        try {
    
            obj.setId_Clientes(rs.getLong("Codigo"));
            obj.setCedula(rs.getString("Cedula"));
            obj.setNombre(rs.getString("Nombre"));
            obj.setApellido(rs.getString("Apellido"));
            obj.setDireccion(rs.getString("Direccion"));
            obj.setStr_telefono(rs.getString("Telefono"));
            obj.setStr_correo(rs.getString("correo"));
     
            

        } catch (SQLException ex) {
            Logger.getLogger(EntidadesMappers.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }
}
