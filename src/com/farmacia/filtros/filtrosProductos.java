/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmacia.filtros;

/**
 *
 * @author User
 */
public class filtrosProductos {
    
    public String comboProductoCodigo (){
        String query="";
        query="SELECT p.`id_productos`,p.`nombre`,p.`descripcion`,p.`fecha_registro`,p.`peso`,p.`id_tipo`,t.`nombre`AS tipo,p.`id_medidas`,m.`nombre_medida` AS medida,\n" +
            "      p.`id_envase`,e.`nombre`AS envase ,p.`id_marcas`,ma.`nombre` AS marca, p.id_usuario, p.iva , p.cantidad_minima\n" +
            "      FROM `productos` p\n" +
            "      JOIN `tipo` t ON t.`id_tipo`= p.`id_tipo` \n" +
            "      JOIN `medidas` m ON m.`id_medidas`= p.`id_medidas`\n" +
            "      JOIN `envase` e ON e.`id_envase`= p.`id_envase`\n" +
            "      JOIN `marcas` ma ON ma.`id_marcas`= p.`id_marcas`\n" +
            "      WHERE p.`id_productos` = ";
        return query;
    
    }
    public String comboProductoNombre (){
        String query="SELECT p.`id_productos`,p.`nombre`,p.`descripcion`,p.`fecha_registro`,p.`peso`,p.`id_tipo`,t.`nombre`AS tipo,p.`id_medidas`,m.`nombre_medida` AS medida,\n" +
            "      p.`id_envase`,e.`nombre`AS envase ,p.`id_marcas`,ma.`nombre` AS marca, p.id_usuario, p.iva , p.cantidad_minima\n" +
            "      FROM `productos` p\n" +
            "      JOIN `tipo` t ON t.`id_tipo`= p.`id_tipo` \n" +
            "      JOIN `medidas` m ON m.`id_medidas`= p.`id_medidas`\n" +
            "      JOIN `envase` e ON e.`id_envase`= p.`id_envase`\n" +
            "      JOIN `marcas` ma ON ma.`id_marcas`= p.`id_marcas`\n" +
            "      WHERE p.`nombre` like '%";
        return query;
    
    }
    public String comboProductoTipo (){
        String query="";
        query="SELECT p.`id_productos`,p.`nombre`,p.`descripcion`,p.`fecha_registro`,p.`peso`,p.`id_tipo`,t.`nombre`AS tipo,p.`id_medidas`,m.`nombre_medida` AS medida,\n" +
            "      p.`id_envase`,e.`nombre`AS envase ,p.`id_marcas`,ma.`nombre` AS marca, p.id_usuario, p.iva , p.cantidad_minima\n" +
            "      FROM `productos` p\n" +
            "      JOIN `tipo` t ON t.`id_tipo`= p.`id_tipo` \n" +
            "      JOIN `medidas` m ON m.`id_medidas`= p.`id_medidas`\n" +
            "      JOIN `envase` e ON e.`id_envase`= p.`id_envase`\n" +
            "      JOIN `marcas` ma ON ma.`id_marcas`= p.`id_marcas`\n" +
            "      WHERE t.`nombre` LIKE '%";
        return query;
    
    }
    public String comboProductoMedida (){
        String query="";
        query="SELECT p.`id_productos`,p.`nombre`,p.`descripcion`,p.`fecha_registro`,p.`peso`,p.`id_tipo`,t.`nombre`AS tipo,p.`id_medidas`,m.`nombre_medida` AS medida,\n" +
            "      p.`id_envase`,e.`nombre`AS envase ,p.`id_marcas`,ma.`nombre` AS marca, p.id_usuario, p.iva , p.cantidad_minima\n" +
            "      FROM `productos` p\n" +
            "      JOIN `tipo` t ON t.`id_tipo`= p.`id_tipo` \n" +
            "      JOIN `medidas` m ON m.`id_medidas`= p.`id_medidas`\n" +
            "      JOIN `envase` e ON e.`id_envase`= p.`id_envase`\n" +
            "      JOIN `marcas` ma ON ma.`id_marcas`= p.`id_marcas`\n" +
            "      WHERE m.`nombre_medida` LIKE '%";
        return query;
    
    }
    public String comboProductoEnvase (){
        String query="";
        query="SELECT p.`id_productos`,p.`nombre`,p.`descripcion`,p.`fecha_registro`,p.`peso`,p.`id_tipo`,t.`nombre`AS tipo,p.`id_medidas`,m.`nombre_medida` AS medida,\n" +
            "      p.`id_envase`,e.`nombre`AS envase ,p.`id_marcas`,ma.`nombre` AS marca, p.id_usuario, p.iva , p.cantidad_minima\n" +
            "      FROM `productos` p\n" +
            "      JOIN `tipo` t ON t.`id_tipo`= p.`id_tipo` \n" +
            "      JOIN `medidas` m ON m.`id_medidas`= p.`id_medidas`\n" +
            "      JOIN `envase` e ON e.`id_envase`= p.`id_envase`\n" +
            "      JOIN `marcas` ma ON ma.`id_marcas`= p.`id_marcas`\n" +
            "      WHERE e.`nombre` LIKE '%";
        return query;
    
    }
    public String comboProductoMarca (){
        String query="";
        query="SELECT p.`id_productos`,p.`nombre`,p.`descripcion`,p.`fecha_registro`,p.`peso`,p.`id_tipo`,t.`nombre`AS tipo,p.`id_medidas`,m.`nombre_medida` AS medida,\n" +
            "      p.`id_envase`,e.`nombre`AS envase ,p.`id_marcas`,ma.`nombre` AS marca, p.id_usuario, p.iva , p.cantidad_minima\n" +
            "      FROM `productos` p\n" +
            "      JOIN `tipo` t ON t.`id_tipo`= p.`id_tipo` \n" +
            "      JOIN `medidas` m ON m.`id_medidas`= p.`id_medidas`\n" +
            "      JOIN `envase` e ON e.`id_envase`= p.`id_envase`\n" +
            "      JOIN `marcas` ma ON ma.`id_marcas`= p.`id_marcas`\n" +
            "      WHERE ma.`nombre` LIKE '%";
        return query;
    
    }
    public String comboProductoTodo (){
        String query="";
        query="SELECT p.`id_productos`,p.`nombre`,p.`descripcion`,p.`fecha_registro`,p.`peso`,p.`id_tipo`,t.`nombre`AS tipo,p.`id_medidas`,m.`nombre_medida` AS medida,\n" +
            "      p.`id_envase`,e.`nombre`AS envase ,p.`id_marcas`,ma.`nombre` AS marca, p.id_usuario, p.iva , p.cantidad_minima\n" +
            "      FROM `productos` p\n" +
            "      JOIN `tipo` t ON t.`id_tipo`= p.`id_tipo` \n" +
            "      JOIN `medidas` m ON m.`id_medidas`= p.`id_medidas`\n" +
            "      JOIN `envase` e ON e.`id_envase`= p.`id_envase`\n" +
            "      JOIN `marcas` ma ON ma.`id_marcas`= p.`id_marcas`";
     
        return query;
    
    }
    
    public String comboProveedorCorreo (){
    String query="";
        query="SELECT pm.`id_promail`,pm.`id_tipo_correo`,pm.`mail`,tc.`nombre` AS tipo_correo,pm.cedula_ruc\n" +
            "FROM `proveedor_mail` pm\n" +
            "JOIN `tipo_correo` tc  ON tc.`id_tipo_correo`=pm.`id_tipo_correo`";
    
    return query;
    }
    public String comboProveedorTelefono (){
    String query="";
        query="SELECT pt.`id_protelefono`,pt.`id_tipo_telefono`,pt.`telefono`,tt.`nombre` AS tipo_telefono,pt.cedula_ruc\n" +
            "FROM `proveedor_telefono` pt\n" +
            "JOIN `tipo_telefono` tt ON tt.`id_tipo_telefono`=pt.`id_tipo_telefono`";

    return query;
    }
    ////////////piguiFaltantes
    public String codigoFaltantes() {

        String query = "";
        query = query = "SELECT \n"
                + "    p.id_productos, ma.nombre AS marca, p.nombre, p.descripcion, df.cantidad, df.estado\n"
                + "FROM\n"
                + "    productos p\n"
                + "        JOIN\n"
                + "    marcas ma ON ma.id_marcas = p.id_marcas\n"
                + "    join\n"
                + "    detalle_faltantes df ON df.id_producto = p.id_productos\n"
                + "WHERE\n"
                + "    p.id_productos = ";

        return query;
    }

    public String productosFaltantes() {

        String query = "";
        query = query = "SELECT \n"
                + "    p.id_productos,\n"
                + "    ma.nombre AS marca,\n"
                + "    p.nombre,\n"
                + "    p.descripcion,\n"
                + "    df.cantidad,\n"
                + "    df.estado\n"
                + "FROM\n"
                + "    productos p\n"
                + "        JOIN\n"
                + "    marcas ma ON ma.id_marcas = p.id_marcas\n"
                + "        JOIN\n"
                + "    detalle_faltantes df ON df.id_producto = p.id_productos";

        return query;
    }

    public String nombreProductoFaltantes() {

        String query = "";
        query = query = "SELECT \n"
                + "    p.id_productos,\n"
                + "    ma.nombre AS marca,\n"
                + "    p.nombre,\n"
                + "    p.descripcion,\n"
                + "    df.cantidad,\n"
                + "    df.estado\n"
                + "FROM\n"
                + "    productos p\n"
                + "        JOIN\n"
                + "    marcas ma ON ma.id_marcas = p.id_marcas\n"
                + "        JOIN\n"
                + "    detalle_faltantes df ON df.id_producto = p.id_productos\n"
                + "    where p.nombre like '%";

        return query;
    }

    public String marcaProductoFaltantes() {

        String query = "";
        query = query = " SELECT \n"
                + "    p.id_productos,\n"
                + "    ma.nombre AS marca,\n"
                + "    p.nombre,\n"
                + "    p.descripcion,\n"
                + "    df.cantidad,\n"
                + "    df.estado\n"
                + "FROM\n"
                + "    productos p\n"
                + "        JOIN\n"
                + "    marcas ma ON ma.id_marcas = p.id_marcas\n"
                + "        JOIN\n"
                + "    detalle_faltantes df ON df.id_producto = p.id_productos\n"
                + "    where ma.nombre like '%"
                + "";

        return query;
    }
    /////////////////
    public static String comboProductoCodigoNotaPedido() {

        String query = "SELECT df.id_detalle_faltantes,df.id_producto,p.nombre AS producto,m.id_marcas,m.nombre AS marca,"
                + "p.id_envase,en.nombre AS envase,p.id_medidas,me.nombre_medida AS medida,t.id_tipo,t.nombre AS tipo,"
                + "df.cantidad,df.estado,pr.precio_compra AS precio"
                + " FROM detalle_faltantes df "
                + "JOIN productos p ON  p.id_productos= df.id_producto "
                + "JOIN tipo t ON t.id_tipo=p.id_tipo"
                + " JOIN marcas m ON m.id_marcas=p.id_marcas "
                + "JOIN envase en ON en.id_envase = p.id_envase "
                + "JOIN medidas me ON me.id_medidas = p.id_medidas "
                + "JOIN precios pr ON pr.id_producto = p.id_productos "
                + "WHERE df.estado= 'OK' AND pr.estado ='A' AND p.`id_productos`=";

        return query;
    }

    public String comboProductoNombreNotaPedido() {
        String query = "SELECT df.id_detalle_faltantes,df.id_producto,p.nombre AS producto,m.id_marcas,m.nombre AS marca,"
                + "p.id_envase,en.nombre AS envase,p.id_medidas,me.nombre_medida AS medida,t.id_tipo,t.nombre AS tipo,"
                + "df.cantidad,df.estado,pr.precio_compra AS precio"
                + " FROM detalle_faltantes df "
                + "JOIN productos p ON  p.id_productos= df.id_producto "
                + "JOIN tipo t ON t.id_tipo=p.id_tipo"
                + " JOIN marcas m ON m.id_marcas=p.id_marcas "
                + "JOIN envase en ON en.id_envase = p.id_envase "
                + "JOIN medidas me ON me.id_medidas = p.id_medidas "
                + "JOIN precios pr ON pr.id_producto = p.id_productos "
                + "WHERE df.estado= 'OK'  AND pr.estado ='A' AND p.`nombre` like '%";
        return query;

    }

    public String comboProductoTipoNotaPedido() {
        String query = "SELECT df.id_detalle_faltantes,df.id_producto,p.nombre AS producto,m.id_marcas,m.nombre AS marca,"
                + "p.id_envase,en.nombre AS envase,p.id_medidas,me.nombre_medida AS medida,t.id_tipo,t.nombre AS tipo,"
                + "df.cantidad,df.estado,pr.precio_compra AS precio"
                + " FROM detalle_faltantes df "
                + "JOIN productos p ON  p.id_productos= df.id_producto "
                + "JOIN tipo t ON t.id_tipo=p.id_tipo"
                + " JOIN marcas m ON m.id_marcas=p.id_marcas "
                + "JOIN envase en ON en.id_envase = p.id_envase "
                + "JOIN medidas me ON me.id_medidas = p.id_medidas "
                + "JOIN precios pr ON pr.id_producto = p.id_productos "
                + "WHERE df.estado= 'OK' AND pr.estado ='A' AND t.nombre like '%";
        return query;

    }

    public String comboProductoMedidaNotaPedido() {
        String query = "SELECT df.id_detalle_faltantes,df.id_producto,p.nombre AS producto,m.id_marcas,m.nombre AS marca,"
                + "p.id_envase,en.nombre AS envase,p.id_medidas,me.nombre_medida AS medida,t.id_tipo,t.nombre AS tipo,"
                + "df.cantidad,df.estado,pr.precio_compra AS precio"
                + " FROM detalle_faltantes df "
                + "JOIN productos p ON  p.id_productos= df.id_producto "
                + "JOIN tipo t ON t.id_tipo=p.id_tipo"
                + " JOIN marcas m ON m.id_marcas=p.id_marcas "
                + "JOIN envase en ON en.id_envase = p.id_envase "
                + "JOIN medidas me ON me.id_medidas = p.id_medidas "
                + "JOIN precios pr ON pr.id_producto = p.id_productos "
                + "WHERE df.estado= 'OK' AND pr.estado ='A' AND me.nombre_medida like '%";
        return query;

    }

    public String comboProductoEnvaseNotaPedido() {
        String query = "SELECT df.id_detalle_faltantes,df.id_producto,p.nombre AS producto,m.id_marcas,m.nombre AS marca,"
                + "p.id_envase,en.nombre AS envase,p.id_medidas,me.nombre_medida AS medida,t.id_tipo,t.nombre AS tipo,"
                + "df.cantidad,df.estado,pr.precio_compra AS precio"
                + " FROM detalle_faltantes df "
                + "JOIN productos p ON  p.id_productos= df.id_producto "
                + "JOIN tipo t ON t.id_tipo=p.id_tipo"
                + " JOIN marcas m ON m.id_marcas=p.id_marcas "
                + "JOIN envase en ON en.id_envase = p.id_envase "
                + "JOIN medidas me ON me.id_medidas = p.id_medidas "
                + "JOIN precios pr ON pr.id_producto = p.id_productos "
                + "WHERE df.estado='OK' AND pr.estado ='A' AND en.nombre like '%";
        return query;

    }

    public String comboProductoMarcaNotaPedido() {
        String query = "SELECT df.id_detalle_faltantes,df.id_producto,p.nombre AS producto,m.id_marcas,m.nombre AS marca,"
                + "p.id_envase,en.nombre AS envase,p.id_medidas,me.nombre_medida AS medida,t.id_tipo,t.nombre AS tipo,"
                + "df.cantidad,df.estado,pr.precio_compra AS precio"
                + " FROM detalle_faltantes df "
                + "JOIN productos p ON  p.id_productos= df.id_producto "
                + "JOIN tipo t ON t.id_tipo=p.id_tipo"
                + " JOIN marcas m ON m.id_marcas=p.id_marcas "
                + "JOIN envase en ON en.id_envase = p.id_envase "
                + "JOIN medidas me ON me.id_medidas = p.id_medidas "
                + "JOIN precios pr ON pr.id_producto = p.id_productos "
                + "WHERE df.estado= 'OK' AND pr.estado ='A' AND m.nombre like '%";
        return query;

    }

    public String comboProductoTodoNotaPedido() {
         String query = "SELECT df.id_detalle_faltantes,df.id_producto,p.nombre AS producto,m.id_marcas,m.nombre AS marca,"
                + "p.id_envase,en.nombre AS envase,p.id_medidas,me.nombre_medida AS medida,t.id_tipo,t.nombre AS tipo,"
                + "df.cantidad,df.estado,pr.precio_compra AS precio"
                + " FROM detalle_faltantes df "
                + "JOIN productos p ON  p.id_productos= df.id_producto "
                + "JOIN tipo t ON t.id_tipo=p.id_tipo"
                + " JOIN marcas m ON m.id_marcas=p.id_marcas "
                + "JOIN envase en ON en.id_envase = p.id_envase "
                + "JOIN medidas me ON me.id_medidas = p.id_medidas "
                + "JOIN precios pr ON pr.id_producto = p.id_productos "
                + "WHERE df.estado= 'OK' AND pr.estado ='A' ORDER BY producto";

        return query;

    }
}
