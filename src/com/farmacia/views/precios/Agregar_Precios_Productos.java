/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmacia.views.precios;

//import com.farmacia.dao.Conectar;
//import com.farmacia.dao.ConsultasSQL;
//import com.farmacia.domain.Telefono_Cliente;
//import com.farmacia.validaciones.Validaciones;
//import com.objetos.views.clientes.*;
//import com.farmacia.validaciones.Validacion;
//import com.objetos.dao.CRUD;
//import com.objetos.dao.Consultas;
//import com.objetos.entities.Precios;
//import com.objetos.entities.Telefono_Cliente;
import com.farmacia.dao.CRUD;
import com.farmacia.dao.Consultas;
import com.farmacia.entities1.Precios;
import com.farmacia.views.compras.OrdenCompra;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author guest-v52snc
 */
public class Agregar_Precios_Productos extends javax.swing.JDialog {

    int x, y;
    private Double precio;
    private Double precioCompra;
    private Double precioVenta;
    private Long id_precio;
    String FechaActual;
    public String[] verificar = new String[10];
    CRUD crud = new CRUD();
    static Long id_producto;
    public ArrayList<Precios> lista_t = null;
    Consultas llamar = new Consultas();
    Precios objeto=null;
    Date date = new Date();
    DateFormat hourdateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    public Long getId_precio() {
        return id_precio;
    }

    public void setId_precio(Long id_precio) {
        this.id_precio = id_precio;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    public Agregar_Precios_Productos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        setLocationRelativeTo(null);
        
    }   
    public Agregar_Precios_Productos(java.awt.Frame parent, boolean modal, Long id) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        setLocationRelativeTo(null);
        // Habilitar(false);
        id_producto = id;
       
        lista_t = llamar.listarPrecioCompra("SELECT id_precio,`id_producto`,`precio_compra`,`precio_venta`,estado FROM `precios` WHERE `id_producto`= " + id_producto);
        for (int i = 0; i < lista_t.size(); i++) {
            System.out.println(223 + " hol" + id_producto + " " + lista_t.get(i).getPrecio_compra());
        }
        //llenarPrecios();
        
   
    }
    public void llenarPrecios(){
    nuevo1.setText(objeto.getPrecio_compra().toString());
    nuevo2.setText(objeto.getPrecio_venta().toString());
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        nuevo1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        BotonGuardar = new javax.swing.JButton();
        BotonSalir = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nuevo2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 112), 2, true));

        nuevo1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nuevo1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                nuevo1FocusLost(evt);
            }
        });
        nuevo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevo1ActionPerformed(evt);
            }
        });
        nuevo1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nuevo1KeyTyped(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel1.setText("PRECIO COMPRA:");

        BotonGuardar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BotonGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/farmacia/icono/guardar1.jpg"))); // NOI18N
        BotonGuardar.setText("ACEPTAR");
        BotonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonGuardarActionPerformed(evt);
            }
        });

        BotonSalir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BotonSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/farmacia/icono/salir1.png"))); // NOI18N
        BotonSalir.setText("SALIR");
        BotonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonSalirActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(0, 153, 153));
        jLabel3.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("INGRESO DE PRECIOS");
        jLabel3.setToolTipText("");
        jLabel3.setOpaque(true);
        jLabel3.setPreferredSize(new java.awt.Dimension(530, 230));
        jLabel3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel3MouseDragged(evt);
            }
        });
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel3MousePressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel2.setText("PRECIO VENTA:");

        nuevo2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nuevo2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                nuevo2FocusLost(evt);
            }
        });
        nuevo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevo2ActionPerformed(evt);
            }
        });
        nuevo2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nuevo2KeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nuevo1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nuevo2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(BotonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BotonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nuevo1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nuevo2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nuevo1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nuevo1KeyTyped
        if (!Character.isDigit(evt.getKeyChar()) && evt.getKeyChar() != '.') {
            evt.consume();
        }
        if (evt.getKeyChar() == '.' && nuevo1.getText().contains(".")) {
            evt.consume();
        }
    }//GEN-LAST:event_nuevo1KeyTyped
    public void Habilitar(boolean lock) {
        BotonGuardar.setEnabled(lock);
        // cbx1.setEnabled(lock);

    }
    private void BotonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonGuardarActionPerformed
        boolean pos = Validar();
        boolean var = false;
        String valor = null;
        FechaActual=hourdateFormat.format(date);
        if (pos == false) {
            setPrecio(Double.valueOf(nuevo1.getText()));
            Precios pr = new Precios();
            pr.setId_producto(id_producto);
            pr.setPrecio_compra(Double.valueOf(nuevo1.getText()));
            pr.setPrecio_venta(Double.valueOf(nuevo2.getText()));
            pr.setFecha_registro(FechaActual);
            pr.setId_usuario(Long.valueOf("2"));
            valor = crud.actualizarPrecioCompra(pr);
            if (valor != null) {
                JOptionPane.showMessageDialog(null, valor);
            }
            //setId_precio(idPre);
//            setPrecioCompra(Double.valueOf(nuevo1.getText()));
//            setPrecioVenta(Double.valueOf(nuevo2.getText()));
            setVisible(false);

        }
    }//GEN-LAST:event_BotonGuardarActionPerformed
    public boolean Validar() {
        boolean pos = false;
//        lista_t = llamar.listarTelefonoCliente("Modulo_Cliente", "select * from Telefono");
        lista_t = llamar.listarPrecioCompra("SELECT id_precio,`id_producto`,`precio_compra`,`precio_venta`,estado FROM `precios` WHERE `id_producto`= " + id_producto);
        // System.out.println(id_producto + " " + lista_t.get(0).getId_producto());
        for (int i = 0; i < lista_t.size(); i++) {
            // System.out.println(223 + " hol"+id_producto +" " +lista_t.get(i).getPrecio_compra());
            if (id_producto.equals(lista_t.get(i).getId_producto())) {
                //    System.out.println(33 + " "+id_producto +" " +lista_t.get(i).getPrecio_compra());
                // for (int j = 0; j < lista_t.size(); j++) {
                Double PrecioCompra = Double.valueOf(nuevo1.getText());
                Double PrecioVenta = Double.valueOf(nuevo2.getText());

                if (Objects.equals(lista_t.get(i).getPrecio_compra(), PrecioCompra)) {
                    int h = Confirmacion("El precio "+nuevo1.getText()+" ya existe desea mantenerlo?");
                    if(h==0){
                    pos = false;
                    }else{pos = true;}
                   
                }
                if (Objects.equals(lista_t.get(i).getPrecio_venta(), PrecioVenta)) {
                    int h = Confirmacion("El precio "+nuevo1.getText()+" ya existe desea mantenerlo?");
                    if(h==0){
                    pos = false;
                    }else{pos = true;}

                }

            }
        }
        return pos;
    }
    public int Confirmacion(String msx) {
        int select = JOptionPane.showConfirmDialog(null, msx, "Confirmar", JOptionPane.YES_OPTION, JOptionPane.NO_OPTION);
        System.out.println(select);
        return select;
    }

    private void nuevo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevo1ActionPerformed

    }//GEN-LAST:event_nuevo1ActionPerformed

    private void BotonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonSalirActionPerformed
        this.setVisible(false);

    }//GEN-LAST:event_BotonSalirActionPerformed

    private void jLabel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MousePressed
        x = evt.getX();
        y = evt.getY();
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MousePressed

    private void jLabel3MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseDragged
        Point point = MouseInfo.getPointerInfo().getLocation();
        setLocation(point.x - x, point.y - y);
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseDragged

    private void nuevo1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nuevo1FocusLost


    }//GEN-LAST:event_nuevo1FocusLost

    private void nuevo2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nuevo2FocusLost
        //  Thread.sleep(5*1000);
        boolean valor = validarPrecios();
        if (valor == true) {
            //  BotonGuardar.setEnabled(true);
        }
    }//GEN-LAST:event_nuevo2FocusLost
    public boolean validarPrecios() {
        boolean valor = false;
        Double comboA = Double.valueOf(nuevo1.getText());
        Double comboB = Double.valueOf(nuevo2.getText());
        if (comboA > comboB) {
            JOptionPane.showMessageDialog(this, "el precio de venta debe ser mayor al de compras");
            return valor;
        }

        return valor = true;
    }
    private void nuevo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevo2ActionPerformed

    }//GEN-LAST:event_nuevo2ActionPerformed

    private void nuevo2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nuevo2KeyTyped
          if (!Character.isDigit(evt.getKeyChar()) && evt.getKeyChar() != '.') {
            evt.consume();
        }
        if (evt.getKeyChar() == '.' && nuevo2.getText().contains(".")) {
            evt.consume();
        }
    }//GEN-LAST:event_nuevo2KeyTyped

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
            java.util.logging.Logger.getLogger(Agregar_Precios_Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Agregar_Precios_Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Agregar_Precios_Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Agregar_Precios_Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Agregar_Precios_Productos dialog = new Agregar_Precios_Productos(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton BotonGuardar;
    private javax.swing.JButton BotonSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nuevo1;
    private javax.swing.JTextField nuevo2;
    // End of variables declaration//GEN-END:variables
}
