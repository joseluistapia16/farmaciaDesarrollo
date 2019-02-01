/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmacia.dao.PruebasDecimales;

import com.farmacia.dao.CRUD;
import java.math.BigDecimal;

/*BigDecimal a = new BigDecimal("5");
BigDecimal b = new BigDecimal("7");

//Equivalent to result = a + b
BigDecimal result = a.add(b);
System.out.println(result);
 */
public class MAIN {

    CRUD c = new CRUD();

    public static void main(String[] args) {
        BigDecimal b1 = new BigDecimal("30");
        BigDecimal b2 = new BigDecimal("0.75");
        BigDecimal iva = new BigDecimal("0.12");
        BigDecimal desc = new BigDecimal("0.10");
        BigDecimal r = new BigDecimal("0.0");
        BigDecimal total = new BigDecimal("0.0");
        r = b1.add(b2);
        System.out.println("Dato b1 " + b1);
        System.out.println("Dato b2 " + b2);
        System.out.println("");


        r = b1.multiply(b2).multiply(iva);
        System.out.println("iva" + r);
        
        r = b1.multiply(b2).multiply(desc);
        System.out.println("dec" + r);
        System.out.println("");
//        total = b1.multiply(b2).add(b3)


    }
}
