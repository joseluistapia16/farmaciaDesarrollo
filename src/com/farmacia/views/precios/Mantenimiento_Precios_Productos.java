/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmacia.views.precios;

import com.farmacia.conponentes.Formulario;
import com.farmacia.conponentes.Tablas;
import com.farmacia.dao.CRUD;
import com.farmacia.dao.Consultas;
import com.farmacia.entities1.Obcx;
import com.farmacia.entities1.Precios;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author alumno
 */
public class Mantenimiento_Precios_Productos extends javax.swing.JDialog {

    CRUD crud = new CRUD();
    Consultas llamar = new Consultas();
    Tablas t = new Tablas();
    Precios precios = null;
    int x, y;
    Long  id_precio,id_pro;
    String fecha = "", hora = "", strEstado;
    Double dbe_compra = null, dbe_venta = null;
    ArrayList<Precios> listaPrecios = null;
    Precios objeto = null;
    // ArrayList<Precios> listavalorIva = llamar.listarPreciosProductos("SELECT id_precio,`id_producto`,`precio_compra`,`precio_venta`,`porcentaje_descuento`,`valor_descuento` FROM `precios` WHERE `id_producto`= " + id_pro );

    public Mantenimiento_Precios_Productos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
    }

    public Mantenimiento_Precios_Productos(java.awt.Frame parent, boolean modal, Long id_pro1, String producto1) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        this.setLocationRelativeTo(null);
        setLayout(null);
        id_pro = id_pro1;
        System.out.println("id:pro " + id_pro);
        llenarDatos(producto1);
        listaPrecios= llamar.listarPrecioCompra("SELECT id_precio,`id_producto`,`precio_compra`,`precio_venta`, estado FROM `precios` WHERE `id_producto`= " + id_pro);
 
        t.visualizar(jtbPrecios,id_pro);
        //FECHA DEL SISTEMA
        java.util.Date sistFecha = new java.util.Date();
        SimpleDateFormat formato = new SimpleDateFormat("YYYY-MM-dd");
        fecha = (formato.format(sistFecha));

        //HORA DEL SISTEMA
        Timer tiempo = new Timer(100, new Mantenimiento_Precios_Productos.horas());
        tiempo.start();
    }

//   public String estado(String valor) {
//        if ("A".equals(valor)) {
//            return "ACTIVO";
//        } else {
//            return "INACTIVO";
//        }
//    }

    class horas implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            java.util.Date sistHora = new java.util.Date();
            String pmAm = "HH:mm:ss";
            SimpleDateFormat format = new SimpleDateFormat(pmAm);
            Calendar hoy = Calendar.getInstance();
            hora = (String.format(format.format(sistHora), hoy));
        }
    }

    public void llenarDatos(String producto1) {
        try {
            nomProducto.setText(producto1);
            System.out.println("nomb: " + producto1);
              
        } catch (Exception e) {
            System.out.println("err " + e.getMessage());
        }
    }

    private int getPosicionPrecioCompraCombo(Double precio) {
        int pos = 0;
        if (precio != null) {
            for (int i = 0; i < listaPrecios.size(); i++) {
                if (Objects.equals(precio, listaPrecios.get(i).getPrecio_compra())) {
                    pos = (i + 1);
                }
            }
        }
        return pos;

    }

    private int getPosicionPrecioVentaCombo(Double precio) {
        int pos = 0;
        if (precio != null) {
            for (int i = 0; i < listaPrecios.size(); i++) {
                if (Objects.equals(precio, listaPrecios.get(i).getPrecio_venta())) {
                    pos = (i + 1);
                }
            }
        }
        return pos;

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        agregarCompra = new javax.swing.JButton();
        guardar = new javax.swing.JButton();
        cerrar = new javax.swing.JButton();
        nomProducto = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        editarPrecioCompra = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbPrecios = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        agregarCompra.setText("+");
        agregarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarCompraActionPerformed(evt);
            }
        });

        guardar.setText("GUARDAR");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });

        cerrar.setText("CERRAR");
        cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarActionPerformed(evt);
            }
        });

        jLabel10.setBackground(new java.awt.Color(175, 226, 226));
        jLabel10.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 51));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("MANTENIMIENTO PRECIOS");
        jLabel10.setOpaque(true);
        jLabel10.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel10MouseDragged(evt);
            }
        });
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel10MousePressed(evt);
            }
        });

        jLabel1.setText("PRODUCTO: ");

        editarPrecioCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/farmacia/icon/editar.png"))); // NOI18N
        editarPrecioCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarPrecioCompraActionPerformed(evt);
            }
        });

        jtbPrecios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtbPrecios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtbPreciosMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jtbPrecios);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(nomProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(agregarCompra)
                        .addGap(18, 18, 18)
                        .addComponent(editarPrecioCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(guardar)
                        .addGap(18, 18, 18)
                        .addComponent(cerrar)
                        .addGap(8, 8, 8)))
                .addContainerGap(19, Short.MAX_VALUE))
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(editarPrecioCompra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(agregarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guardar)
                    .addComponent(cerrar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void agregarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarCompraActionPerformed
        int i = 0;
//        i = jtbPrecios.getSelectedRow();
//        objeto = devuelveObjeto(jtbPrecios.getValueAt(i, 0).toString(), listaPrecios);
        Agregar_Precios_Productos ic = new Agregar_Precios_Productos(new javax.swing.JFrame(), true, id_pro);
        ic.setVisible(true);
        
        id_precio = ic.getId_precio();
        listaPrecios.clear();
        listaPrecios=llamar.listarPrecioCompra("SELECT id_precio,`id_producto`,`precio_compra`,`precio_venta`, estado FROM `precios` WHERE `id_producto`= " + id_pro);
        t.visualizar(jtbPrecios,id_pro);
//        System.out.println(objeto.getId_precio()+"  "+objeto.getPrecio_compra());
    }//GEN-LAST:event_agregarCompraActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed

//        guardarNuevoPrecio();
//        setVisible(false);
           ListaIngresoProductos();
           this.setVisible(false);
    }//GEN-LAST:event_guardarActionPerformed
    public Precios devuelveObjeto(String datos, ArrayList<Precios> listarobj) {
        Precios objeto1 = null;
        for (int i = 0; i < listarobj.size(); i++) {
            if (datos.equals(listarobj.get(i).getId_precio().toString())) {
                objeto1 = listarobj.get(i);
                break;
            }
        }
        return objeto1;
    }
    public String transformarboolean(boolean valor) {
        if (valor == true) {
            return "A";
        } else {
            return "I";
        }
    }

    private void ListaIngresoProductos() {
        ArrayList<String> queryL1 = new ArrayList<String>();
        String cad1 = "";
        boolean estado = false;
        for (int i = 0; i < jtbPrecios.getRowCount(); i++) {
            //int estado = (int) jtbPrecios.getValueAt(i, 4);
            // cad1 = "UPDATE  `detalle_compra`(`id_cabecera_compra`,`cantidad`,`id_producto`)VALUES(" + id_cab + "," + tbaListaComprasB.getValueAt(i, 5).toString() + "," + tbaListaComprasB.getValueAt(i, 0).toString() + ")";
            estado = (boolean) jtbPrecios.getValueAt(i, 4);
            String est = transformarboolean(estado);
            cad1 = "UPDATE `precios` SET `estado`='"+est+"' WHERE `id_producto`= " + jtbPrecios.getValueAt(i, 1) + " AND `id_precio`=" + jtbPrecios.getValueAt(i, 0) + ";";
            queryL1.add(cad1);
            System.out.println(cad1);
        }
        crud.insertarDetallesCompra(queryL1);
        queryL1.clear();
//////////////////////////////////////////////////////////////////////////////////  
    }
//    public void guardarNuevoPrecio() {//jefferson compras
//        String valor = "";
//        String fechaA = fecha + " " + hora;
//        System.out.println("fecha:" + fechaA);
//        Precios pre = new Precios();
//        pre.setId_producto(id_pro);
//    //    pre.setPrecio_compra(Double.valueOf(cbx1.getSelectedItem().toString()));
//        System.out.println("compra: " + pre.getPrecio_compra());
//     //   pre.setPrecio_venta(Double.valueOf(cbx2.getSelectedItem().toString()));
//        pre.setFecha_registro(fechaA);
//        pre.setId_usuario(Long.valueOf("2"));
//        valor = crud.guardarNuevoPrecio(Long.valueOf("1"), pre);//ejecuta y prueba
//        JOptionPane.showMessageDialog(this, valor);
//    }
    private void cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarActionPerformed
        setVisible(false);
    }//GEN-LAST:event_cerrarActionPerformed

    private void jLabel10MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseDragged
        Point point = MouseInfo.getPointerInfo().getLocation();
        setLocation(point.x - x, point.y - y);
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel10MouseDragged

    private void jLabel10MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MousePressed
        x = evt.getX();
        y = evt.getY();
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel10MousePressed

    private void editarPrecioCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarPrecioCompraActionPerformed
        int i = 0;
        i = jtbPrecios.getSelectedRow();
        if(i!=-1){
        objeto = devuelveObjeto(jtbPrecios.getValueAt(i, 0).toString(), listaPrecios);
        Editar_Precio_Productos ic = new Editar_Precio_Productos(new javax.swing.JFrame(), true, id_pro,objeto);
        ic.setVisible(true);
        listaPrecios.clear();
        listaPrecios=llamar.listarPrecioCompra("SELECT id_precio,`id_producto`,`precio_compra`,`precio_venta`, estado FROM `precios` WHERE `id_producto`= " + id_pro);
        t.visualizar(jtbPrecios,id_pro);
        }else{
        JOptionPane.showMessageDialog(this, "escoja una fila");
        }
        
        
    }//GEN-LAST:event_editarPrecioCompraActionPerformed

    private void jtbPreciosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbPreciosMousePressed
        int i = 0;
        try {
            if (evt.getClickCount() == 2) {
        i = jtbPrecios.getSelectedRow();
        objeto = devuelveObjeto(jtbPrecios.getValueAt(i, 0).toString(), listaPrecios);
        //Agregar_Precios_Productos ic = new Agregar_Precios_Productos(new javax.swing.JFrame(), true, id_pro,objeto);
        Editar_Precio_Productos ic = new Editar_Precio_Productos(new javax.swing.JFrame(), true, id_pro,objeto);
        ic.setVisible(true);
        listaPrecios.clear();
        listaPrecios=llamar.listarPrecioCompra("SELECT id_precio,`id_producto`,`precio_compra`,`precio_venta`, estado FROM `precios` WHERE `id_producto`= " + id_pro);
         t.visualizar(jtbPrecios,id_pro);
//        id_precio = ic.getId_precio();
//        listaPrecios.clear();
        System.out.println(objeto.getId_precio()+"  "+objeto.getPrecio_compra());
            }
        }catch(Exception e){
            Logger.getLogger(Mantenimiento_Precios_Productos.class.getName()).log(Level.SEVERE, null, e);}
    }//GEN-LAST:event_jtbPreciosMousePressed
    private int getPosicionCompra(Double precio) {
        int pos = 0;
        if (precio != null) {
            for (int i = 0; i < listaPrecios.size(); i++) {
                if (Objects.equals(precio, listaPrecios.get(i).getPrecio_compra())) {
                    pos = (i + 1);
                }
            }
        }
        return pos;

    }

    private int getPosicionVenta(Double precio) {
        int pos = 0;
        if (precio != null) {
            for (int i = 0; i < listaPrecios.size(); i++) {
                if (Objects.equals(precio, listaPrecios.get(i).getPrecio_venta())) {
                    pos = (i + 1);
                }
            }
        }
        return pos;

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Mantenimiento_Precios_Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mantenimiento_Precios_Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mantenimiento_Precios_Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mantenimiento_Precios_Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Mantenimiento_Precios_Productos dialog = new Mantenimiento_Precios_Productos(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarCompra;
    private javax.swing.JButton cerrar;
    private javax.swing.JButton editarPrecioCompra;
    private javax.swing.JButton guardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtbPrecios;
    private javax.swing.JLabel nomProducto;
    // End of variables declaration//GEN-END:variables
}
