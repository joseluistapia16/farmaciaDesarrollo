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
public class Filtros_modulo_seguridad {
    
    public String comboLocalidadTodo (){
        String query="";
        query="SELECT pv.id_punto_venta, pv.nombre, lg.localidad, pv.direccion,  pv.observacion FROM fc_localidad_guayas lg, fc_punto_venta pv \n" +
"WHERE pv.`id_localidad_guayas` = lg.`id_localidad_guayas`";
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
        query="SELECT pv.id_punto_venta, pv.nombre, lg.localidad, pv.direccion,  pv.observacion FROM fc_localidad_guayas lg, fc_punto_venta pv \n" +
               "WHERE lg.id_localidad_guayas= pv.id_localidad_guayas AND pv.nombre LIKE'";
        return query;
    
    }
    public String comboTodoUsuario (){
        String query="";
        query="SELECT `fc_session`.`id_sesion`, `fc_usuario`.`fecha_registro`, `fc_usuario`.`cedula`, `fc_usuario`.`apellidos`, `fc_usuario`.`nombres`, \n" +
        "`fc_usuario`.`direccion`, `fc_usuario`.`telefono`, `fc_usuario`.`convencional`, `fc_usuario`.`correo`, `fc_rol`.`cargo`, \n" +
        "`fc_genero`.`genero`, `fc_discapacidad`.`discapacidad`, `fc_porcentaje_discapacidad`.`porcentaje`, `fc_session`.`estado`, `fc_session`.`observacion` \n" +
        "FROM `fc_usuario` INNER JOIN `fc_session` ON `fc_usuario`.`id_usuario` = `fc_session`.`id_usuario`\n" +
        "INNER JOIN `fc_rol` ON `fc_rol`.`id_rol` = `fc_session`.`id_rol` \n" +
        "INNER JOIN `fc_genero` ON `fc_genero`.`id_genero` = `fc_usuario`.`id_genero` \n" +
        "INNER JOIN `fc_discapacidad` ON `fc_discapacidad`.`id_discapacidad` = `fc_usuario`.`id_discapacidad` \n" +
        "INNER JOIN `fc_porcentaje_discapacidad` ON `fc_porcentaje_discapacidad`.`id_porcentaje_discapacidad` = `fc_usuario`.`id_porcentaje_discapacidad`";
        return query;
    }
    public String comboUsuarioId (){
        String query="";
        query="SELECT `fc_session`.`id_sesion`, `fc_usuario`.`fecha_registro`, `fc_usuario`.`cedula`, `fc_usuario`.`apellidos`, `fc_usuario`.`nombres`, \n" +
        "`fc_usuario`.`direccion`, `fc_usuario`.`telefono`, `fc_usuario`.`convencional`, `fc_usuario`.`correo`, `fc_rol`.`cargo`, \n" +
        "`fc_genero`.`genero`, `fc_discapacidad`.`discapacidad`, `fc_porcentaje_discapacidad`.`porcentaje`, `fc_session`.`estado`, `fc_session`.`observacion` \n" +
        "FROM `fc_usuario` INNER JOIN `fc_session` ON `fc_usuario`.`id_usuario` = `fc_session`.`id_usuario`\n" +
        "INNER JOIN `fc_rol` ON `fc_rol`.`id_rol` = `fc_session`.`id_rol` \n" +
        "INNER JOIN `fc_genero` ON `fc_genero`.`id_genero` = `fc_usuario`.`id_genero` \n" +
        "INNER JOIN `fc_discapacidad` ON `fc_discapacidad`.`id_discapacidad` = `fc_usuario`.`id_discapacidad` \n" +
        "INNER JOIN `fc_porcentaje_discapacidad` ON `fc_porcentaje_discapacidad`.`id_porcentaje_discapacidad` = `fc_usuario`.`id_porcentaje_discapacidad`\n" +
        "WHERE `id_sesion` = ";
        return query;
    }
    
    public String comboUsuarioApellido (){
        String query="";
        query="SELECT `fc_session`.`id_sesion`, `fc_usuario`.`fecha_registro`, `fc_usuario`.`cedula`, `fc_usuario`.`apellidos`, `fc_usuario`.`nombres`, \n" +
        "`fc_usuario`.`direccion`, `fc_usuario`.`telefono`, `fc_usuario`.`convencional`, `fc_usuario`.`correo`, `fc_rol`.`cargo`, \n" +
        "`fc_genero`.`genero`, `fc_discapacidad`.`discapacidad`, `fc_porcentaje_discapacidad`.`porcentaje`, `fc_session`.`estado`, `fc_session`.`observacion` \n" +
        "FROM `fc_usuario` INNER JOIN `fc_session` ON `fc_usuario`.`id_usuario` = `fc_session`.`id_usuario`\n" +
        "INNER JOIN `fc_rol` ON `fc_rol`.`id_rol` = `fc_session`.`id_rol` \n" +
        "INNER JOIN `fc_genero` ON `fc_genero`.`id_genero` = `fc_usuario`.`id_genero` \n" +
        "INNER JOIN `fc_discapacidad` ON `fc_discapacidad`.`id_discapacidad` = `fc_usuario`.`id_discapacidad` \n" +
        "INNER JOIN `fc_porcentaje_discapacidad` ON `fc_porcentaje_discapacidad`.`id_porcentaje_discapacidad` = `fc_usuario`.`id_porcentaje_discapacidad`\n" +
        "WHERE `apellidos` LIKE'";
        return query;
    }
    public String comboUsuarioCedula (){
        String query="";
        query="SELECT `fc_session`.`id_sesion`, `fc_usuario`.`fecha_registro`, `fc_usuario`.`cedula`, `fc_usuario`.`apellidos`, `fc_usuario`.`nombres`, \n" +
        "`fc_usuario`.`direccion`, `fc_usuario`.`telefono`, `fc_usuario`.`convencional`, `fc_usuario`.`correo`, `fc_rol`.`cargo`, \n" +
        "`fc_genero`.`genero`, `fc_discapacidad`.`discapacidad`, `fc_porcentaje_discapacidad`.`porcentaje`, `fc_session`.`estado`, `fc_session`.`observacion` \n" +
        "FROM `fc_usuario` INNER JOIN `fc_session` ON `fc_usuario`.`id_usuario` = `fc_session`.`id_usuario`\n" +
        "INNER JOIN `fc_rol` ON `fc_rol`.`id_rol` = `fc_session`.`id_rol` \n" +
        "INNER JOIN `fc_genero` ON `fc_genero`.`id_genero` = `fc_usuario`.`id_genero` \n" +
        "INNER JOIN `fc_discapacidad` ON `fc_discapacidad`.`id_discapacidad` = `fc_usuario`.`id_discapacidad` \n" +
        "INNER JOIN `fc_porcentaje_discapacidad` ON `fc_porcentaje_discapacidad`.`id_porcentaje_discapacidad` = `fc_usuario`.`id_porcentaje_discapacidad`\n" +
        "WHERE `cedula` LIKE'";
        return query;
    }
    public String comboUsuarioFecha (){
        String query="";
        query="SELECT `fc_session`.`id_sesion`, `fc_usuario`.`fecha_registro`, `fc_usuario`.`cedula`, `fc_usuario`.`apellidos`, `fc_usuario`.`nombres`, \n" +
        "`fc_usuario`.`direccion`, `fc_usuario`.`telefono`, `fc_usuario`.`convencional`, `fc_usuario`.`correo`, `fc_rol`.`cargo`, \n" +
        "`fc_genero`.`genero`, `fc_discapacidad`.`discapacidad`, `fc_porcentaje_discapacidad`.`porcentaje`, `fc_session`.`estado`, `fc_session`.`observacion` \n" +
        "FROM `fc_usuario` INNER JOIN `fc_session` ON `fc_usuario`.`id_usuario` = `fc_session`.`id_usuario`\n" +
        "INNER JOIN `fc_rol` ON `fc_rol`.`id_rol` = `fc_session`.`id_rol` \n" +
        "INNER JOIN `fc_genero` ON `fc_genero`.`id_genero` = `fc_usuario`.`id_genero` \n" +
        "INNER JOIN `fc_discapacidad` ON `fc_discapacidad`.`id_discapacidad` = `fc_usuario`.`id_discapacidad` \n" +
        "INNER JOIN `fc_porcentaje_discapacidad` ON `fc_porcentaje_discapacidad`.`id_porcentaje_discapacidad` = `fc_usuario`.`id_porcentaje_discapacidad`\n" +
        "WHERE `fecha_registro` LIKE'%";
        return query;
    }
}
