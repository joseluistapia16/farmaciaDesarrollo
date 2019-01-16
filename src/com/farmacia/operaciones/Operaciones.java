/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmacia.operaciones;

import com.farmacia.entities1.Ip_Publica;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TapiaSoftware
 */
public class Operaciones {

    public static void main(String[] args) throws Exception {
            
         System.out.println(getIpHost() + " - " + getNombreDispositivo() + " " + getIpDispositivo());
        System.out.println("publica"+getIpPublica().getIp_publica_full());
        System.out.println(getIpOrden());
         System.out.println(getIpLocalCompleta());
    }

     
    public static String getIpLocalCompleta() {
        String ip = "";
        try {
            InetAddress direccion = InetAddress.getLocalHost();
            ip = InetAddress.getLoopbackAddress() + "/" + direccion;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ip;
    }

    public static String getIpHost() {
        String ip = InetAddress.getLoopbackAddress().toString();
        String[] arreglo = ip.split("/");
        return arreglo[1];
    }

    public static String getNombreDispositivo() {
        InetAddress direccion = null;
        try {
            direccion = InetAddress.getLocalHost();
        } catch (UnknownHostException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return direccion.getHostName();//nombre host 
    }

    public static String getIpDispositivo() {
        InetAddress direccion = null;
        String[] arreglo = null;
        try {
            direccion = InetAddress.getLocalHost();
            arreglo = direccion.toString().split("/");
        } catch (UnknownHostException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arreglo[1];
    }

    public static String getIpOrden() {
        return getNombreDispositivo() + "/" + getIpHost() + "/" + getIpDispositivo();
    }

    public static Ip_Publica getIpPublica() {
        String comando = "nslookup"; //Comando de apagado en linux
        Process process1;
        try {
            process1 = Runtime.getRuntime().exec(comando);
            InputStreamReader input = new InputStreamReader(process1.getInputStream());
            BufferedReader stdInput = new BufferedReader(input);
            comando = stdInput.readLine();
        } catch (IOException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return getIPPublicaCompleta(comando);
    }

    public static Ip_Publica getIPPublicaCompleta(String msg) {
        String cadena = "";
        Ip_Publica ip= new Ip_Publica();
        int tot = 0;
        for (int i = 0; i < msg.length(); i++) {
            if (msg.charAt(i) == '-') {
                if (tot > 0) {
                    cadena = cadena + ".";
                }
                tot++;
            }
            if ((msg.charAt(i) >= '0' && msg.charAt(i) <= '9')) {

                cadena = cadena + msg.charAt(i);
            }
        }
        ip.setIp(cadena);
        cadena = "";
        tot = 0;
        for (int i = 0; i < msg.length(); i++) {
            if (msg.charAt(i) == '.') {
                tot = i;
            }
            if (tot > 0) {
                    cadena = cadena + msg.charAt(i);
            }
        }
        ip.setNombre(cadena.substring(1));
        return ip;
    }
}