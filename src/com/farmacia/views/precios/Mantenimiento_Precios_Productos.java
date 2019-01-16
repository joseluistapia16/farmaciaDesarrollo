/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmacia.views.precios;

import com.farmacia.conponentes.Formulario;
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
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author alumno
 */
public class Mantenimiento_Precios_Productos extends javax.swing.JDialog {

    CRUD crud = new CRUD();
    Consultas llamar = new Consultas();
    Precios precios = null;
    int x, y;
    Long id_pro, id_precio;
    String fecha = "", hora = "", strEstado;
    Double dbe_compra = null, dbe_venta = null;
    ArrayList<Precios> listaPrecios = null;
    // ArrayList<Precios> listavalorIva = llamar.listarPreciosProductos("SELECT id_precio,`id_producto`,`precio_compra`,`precio_venta`,`porcentaje_descuento`,`valor_descuento` FROM `precios` WHERE `id_producto`= " + id_pro );

    public Mantenimiento_Precios_Productos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        this.setLocationRelativeTo(null);
        setLayout(null);
    }

    public Mantenimiento_Precios_Productos(java.awt.Frame parent, boolean modal, Long id_pro1, String producto1) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        this.setLocationRelativeTo(null);
        setLayout(null);
        id_pro = id_pro1;
        System.out.println("id:pro " + id_pro);
        llenarCombo();
        llenarDatos(producto1);
        //FECHA DEL SISTEMA
        java.util.Date sistFecha = new java.util.Date();
        SimpleDateFormat formato = new SimpleDateFormat("YYYY-MM-dd");
        fecha = (formato.format(sistFecha));

        //HORA DEL SISTEMA
        Timer tiempo = new Timer(100, new Mantenimiento_Precios_Productos.horas());
        tiempo.start();
    }

    public void llenarCombo() {
        listaPrecios = llamar.listarPrecioCompra("SELECT id_precio,`id_producto`,`precio_compra`,`precio_venta`, estado ,estado1 FROM `precios` WHERE `id_producto`= " + id_pro);
        precios = llamar.listarPreciosProductos("SELECT id_precio,`id_producto`,`precio_compra`,`precio_venta`, estado FROM `precios` WHERE `id_producto`= " + id_pro + " and estado='A'");
        cbx1.setModel(Formulario.listarComboPrecioCompraPro(listaPrecios));
        cbx2.setModel(Formulario.listarComboPrecioVentaPro(listaPrecios));
        // cbxEstado.setModel(Formulario.listarComboEstadoPrecios(listaPrecios));
        strEstado = crud.getNombreComboProducto(Long.valueOf("8"), id_pro);
        strEstado = estado(strEstado);
        cbxEstado.setSelectedItem(strEstado);
    }

    public String estado(String valor) {
        if ("A".equals(valor)) {
            return "ACTIVO";
        } else {
            return "INACTIVO";
        }
    }

    public void ActualizarCombo() {
        dbe_compra = crud.getNombreComboPrecioPro(Long.valueOf("6"), id_pro);
        cbx1.setSelectedIndex(getPosicionPrecioCompraCombo(dbe_compra));
        dbe_venta = crud.getNombreComboPrecioPro(Long.valueOf("7"), id_pro);
        cbx2.setSelectedIndex(getPosicionPrecioVentaCombo(dbe_venta));
    }

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
            dbe_compra = crud.getNombreComboPrecioPro(Long.valueOf("6"), id_pro);
            // System.out.println(" error "+str_compra);
            cbx1.setSelectedIndex(getPosicionPrecioCompraCombo(dbe_compra));
            dbe_venta = crud.getNombreComboPrecioPro(Long.valueOf("7"), id_pro);
            cbx2.setSelectedIndex(getPosicionPrecioVentaCombo(dbe_venta));

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
        cbx1 = new javax.swing.JComboBox<>();
        cbx2 = new javax.swing.JComboBox<>();
        agregarCompra = new javax.swing.JButton();
        guardar = new javax.swing.JButton();
        cerrar = new javax.swing.JButton();
        nomProducto = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        editarPrecioCompra = new javax.swing.JButton();
        cbxEstado = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cbx1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx1ActionPerformed(evt);
            }
        });

        cbx2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cbx2FocusLost(evt);
            }
        });
        cbx2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx2ActionPerformed(evt);
            }
        });

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

        jLabel2.setText("PRECIO COMPRA:");

        jLabel3.setText("PRECIO VENTA:");

        jLabel1.setText("PRODUCTO: ");

        editarPrecioCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/farmacia/icon/editar.png"))); // NOI18N
        editarPrecioCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarPrecioCompraActionPerformed(evt);
            }
        });

        cbxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<SELECCIONE>", "ACTIVO", "INACTIVO" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(nomProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(111, 111, 111))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbx2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbx1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(agregarCompra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(12, 12, 12)
                                        .addComponent(editarPrecioCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(61, 61, 61))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(cbxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(guardar)
                        .addGap(18, 18, 18)
                        .addComponent(cerrar)
                        .addGap(70, 70, 70))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbx2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(nomProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cbx1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cbxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(agregarCompra)
                                    .addComponent(editarPrecioCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guardar)
                    .addComponent(cerrar))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void agregarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarCompraActionPerformed
        ArrayList<Obcx> lista = new ArrayList();
        boolean band = false;
        int pos = 0;
        Agregar_Precios_Productos ic = new Agregar_Precios_Productos(new javax.swing.JFrame(), true, id_pro);
        ic.setVisible(true);

//        ic.getPrecioCompra();
//        ic.getPrecioVenta();
        id_precio = ic.getId_precio();
        listaPrecios.clear();
        cbx1.removeAll();
        cbx2.removeAll();
        System.out.println("idpro: " + id_pro);
        llenarCombo();
        ActualizarCombo();
    }//GEN-LAST:event_agregarCompraActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed

        guardarNuevoPrecio();
        setVisible(false);

    }//GEN-LAST:event_guardarActionPerformed

    public void guardarNuevoPrecio() {//jefferson compras
        String valor = "";
        String fechaA = fecha + " " + hora;
        System.out.println("fecha:" + fechaA);
        Precios pre = new Precios();
        pre.setId_producto(id_pro);
        pre.setPrecio_compra(Double.valueOf(cbx1.getSelectedItem().toString()));
        System.out.println("compra: " + pre.getPrecio_compra());
        pre.setPrecio_venta(Double.valueOf(cbx2.getSelectedItem().toString()));
        pre.setFecha_registro(fechaA);
        pre.setId_usuario(Long.valueOf("2"));
        valor = crud.guardarNuevoPrecio(Long.valueOf("1"), pre);//ejecuta y prueba
        JOptionPane.showMessageDialog(this, valor);
    }
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

    private void cbx2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cbx2FocusLost
        // validarPrecios();
    }//GEN-LAST:event_cbx2FocusLost

    private void cbx1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx1ActionPerformed
        try {
            Double x = Double.valueOf(cbx1.getSelectedItem().toString());
            if (!Objects.equals(x, precios.getPrecio_compra())) {
                cbx2.setSelectedIndex(getPosicionCompra(x));
                // System.out.println(" "+x+" "+valorIva.getPrecio_compra());
                for (int i = 0; i < listaPrecios.size(); i++) {
                    if (Objects.equals(x, listaPrecios.get(i).getPrecio_compra())) {
                        System.out.println("cambio de posicion");
                        String esta = listaPrecios.get(i).getEstadoPrecio();
                        esta = estado(esta);
                        cbxEstado.setSelectedItem(esta);
                    }

                }

            } else {
                cbx2.setSelectedIndex(getPosicionCompra(x));
                for (int i = 0; i < listaPrecios.size(); i++) {
                    if (Objects.equals(x, listaPrecios.get(i).getPrecio_compra())) {
                        System.out.println("no hace nada");
                        String esta = listaPrecios.get(i).getEstadoPrecio();
                        esta = estado(esta);
                        cbxEstado.setSelectedItem(esta);
                    }

                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }//GEN-LAST:event_cbx1ActionPerformed

    private void cbx2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx2ActionPerformed
        try {
            Double x = Double.valueOf(cbx2.getSelectedItem().toString());
            if (!Objects.equals(x, precios.getPrecio_venta())) {
                cbx1.setSelectedIndex(getPosicionVenta(x));
            } else {
                cbx1.setSelectedIndex(getPosicionVenta(x));
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cbx2ActionPerformed

    private void editarPrecioCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarPrecioCompraActionPerformed
        Precios pr = new Precios();
        pr.setPrecio_compra(Double.valueOf(cbx1.getSelectedItem().toString()));
        pr.setPrecio_venta(Double.valueOf(cbx2.getSelectedItem().toString()));
        Editar_Precio_Productos ed = new Editar_Precio_Productos(new javax.swing.JFrame(), true, id_pro, precios.getId_precio(), pr);
        ed.setVisible(true);
        listaPrecios.clear();
        cbx1.removeAll();
        cbx2.removeAll();
        System.out.println("idpro: " + id_pro);
        llenarCombo();
        ActualizarCombo();
    }//GEN-LAST:event_editarPrecioCompraActionPerformed
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
    private javax.swing.JComboBox<String> cbx1;
    private javax.swing.JComboBox<String> cbx2;
    private javax.swing.JComboBox<String> cbxEstado;
    private javax.swing.JButton cerrar;
    private javax.swing.JButton editarPrecioCompra;
    private javax.swing.JButton guardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel nomProducto;
    // End of variables declaration//GEN-END:variables
}
