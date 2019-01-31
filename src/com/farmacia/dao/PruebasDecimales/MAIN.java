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
        BigDecimal b1 = new BigDecimal("1400000000000000000000000000000000000000000000000000000000");
        BigDecimal b2 = new BigDecimal("400000000000000000000000000000000000000000000000000000000");
        BigDecimal r = new BigDecimal("0.0");
        r = b1.add(b2);
        System.out.println("Dato b1 " + b1);
        System.out.println("Dato b2 " + b2);
        System.out.println("");

        System.out.println("Suma " + r);
        System.out.println("");

        r = b1.subtract(b2);
        System.out.println("Resta " + r);
        System.out.println("");

        r = b1.multiply(b2);
        System.out.println("Multi " + r);
        System.out.println("");

        r = b1.divide(b2);
        System.out.println("Divi " + r);
        System.out.println("");

    }

//    int itemCost;
//    int totalCost = 0;
//
//    public BigDecimal calcular(int itemQuantity, BigDecimal itemPrice) {
//        itemCost = itemPrice.multiply(itemQuantity);
//        totalCost = totalCost + itemCost;
//        return totalCost;
}
