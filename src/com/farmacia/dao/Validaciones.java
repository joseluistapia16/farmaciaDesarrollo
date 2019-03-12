/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmacia.dao;

import java.sql.Date;
import java.util.Calendar;

/**
 *
 * @author alumno
 */
public class Validaciones {
    
    public static int comparacionFecha(Date fecha1, Date fecha2) {
        int val = 0;
        val = fecha1.compareTo(fecha2);

        return val;

    }

     public static Date FechaSql() {
        String dias = "" + Dia(), mes = "" + Mes();
        if (dias.length() == 1) {
            dias = "0" + dias;
        }
        if (mes.length() == 1) {
            mes = "0" + mes;
        }
        return java.sql.Date.valueOf("" + Anio() + "-" + mes + "-" + dias);
    }

    public static int Dia() {
        Calendar c1 = Calendar.getInstance();
        return c1.get(Calendar.DATE);
    }

    public static int Mes() {
        Calendar c1 = Calendar.getInstance();
        return c1.get(Calendar.MONTH)+1;
    }

    public static int Anio() {
        Calendar c1 = Calendar.getInstance();
        return c1.get(Calendar.YEAR);
    }

    public static String getStringFecha(Date fecha) {
         if (fecha != null) {
            String cad[] = fecha.toString().split("-");
            return cad[2] + "/"
                    + getStringMes(Integer.parseInt(cad[1])) + "/" + cad[0];

        } else {
            return "";
        }
    }

    

    public static String getStringMes(int mes) {
        String gui = null;
        if (mes == 1) {
            gui = "Enero";
        }
        if (mes == 2) {
            gui = "Febrero";
        }

        if (mes == 3) {
            gui = "Marzo";
        }
        if (mes == 4) {
            gui = "Abril";
        }
        if (mes == 5) {
            gui = "Mayo";
        }
        if (mes == 6) {
            gui = "Junio";
        }

        if (mes == 7) {
            gui = "Julio";
        }
        if (mes == 8) {
            gui = "Agosto";
        }
        if (mes == 9) {
            gui = "Septiembre";
        }
        if (mes == 10) {
            gui = "Octubre";
        }

        if (mes == 11) {
            gui = "Noviembre";
        }
        if (mes == 12) {
            gui = "Diciembre";
        }
        return gui;
    }
    
}
