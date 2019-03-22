/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmacia.views.compras;

import com.farmacia.views.pedidos.*;
import com.farmacia.join_entidades.FaltantesCabeceraDetalles;
import com.farmacia.join_entidades.joinProductoDetallesFaltantes;
import com.farmacia.validaciones.Validacion;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import javax.swing.JOptionPane;

/**
 *
 * @author guest-qzjm76
 */
public class AgregarProductoEnCompras extends javax.swing.JDialog {

    int x, y;
    joinProductoDetallesFaltantes objf = new joinProductoDetallesFaltantes();
    Validacion v = new Validacion();

    public AgregarProductoEnCompras(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        this.setLocationRelativeTo(null);
    }

    public void Descuento() {

    }

    public AgregarProductoEnCompras(java.awt.Frame parent, boolean modal, joinProductoDetallesFaltantes obj1) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        this.setLocationRelativeTo(null);
        llenarFormulario(obj1);
        System.out.println("producto "+obj1.getNombre_producto());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        valorDescuento = new javax.swing.JTextField();
        jDialog1 = new javax.swing.JDialog();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        marca = new javax.swing.JTextField();
        txtcantidadpro = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnAnadir = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        codigo = new javax.swing.JTextField();
        producto = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        Medida = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtEnvase3 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtTipo = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtIva = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtporcentajeDescuento = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtBono = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        codigo1 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txtEnvase4 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        txtTipo1 = new javax.swing.JTextField();
        txtIva1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtporcentajeDescuento1 = new javax.swing.JTextField();
        marca1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtcantidadpro1 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtBono1 = new javax.swing.JTextField();
        btnAnadir1 = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        producto1 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        btnSalir1 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        Medida1 = new javax.swing.JTextField();
        txtPrecio1 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();

        jDialog1.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel3MouseDragged(evt);
            }
        });
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel3MousePressed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(2, 184, 184));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(254, 254, 254));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("AÑADIR CANTIDAD ");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 12, 227, 28));

        marca.setEditable(false);

        txtcantidadpro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcantidadproActionPerformed(evt);
            }
        });
        txtcantidadpro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcantidadproKeyTyped(evt);
            }
        });

        jLabel6.setText("Marca:");

        btnAnadir.setText("AÑADIR");
        btnAnadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnadirActionPerformed(evt);
            }
        });

        jLabel4.setText("Codigo:");

        jLabel2.setText("Producto:");

        codigo.setEditable(false);
        codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigoActionPerformed(evt);
            }
        });

        producto.setEditable(false);

        jLabel14.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel14.setText("Cantidad:");

        btnSalir.setText("SALIR");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        Medida.setEditable(false);
        Medida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MedidaActionPerformed(evt);
            }
        });
        Medida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                MedidaKeyTyped(evt);
            }
        });

        jLabel9.setText("Medida:");

        jLabel10.setText("Envase:");

        txtEnvase3.setEditable(false);
        txtEnvase3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEnvase3ActionPerformed(evt);
            }
        });

        jLabel15.setText("TIPO:");

        txtTipo.setEditable(false);
        txtTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTipoActionPerformed(evt);
            }
        });
        txtTipo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTipoKeyTyped(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel16.setText("Precio:");

        txtPrecio.setEditable(false);
        txtPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioActionPerformed(evt);
            }
        });
        txtPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioKeyTyped(evt);
            }
        });

        jLabel17.setText("IVA:");

        txtIva.setEditable(false);

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel5.setText("Descuento:");

        txtporcentajeDescuento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtporcentajeDescuentoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtporcentajeDescuentoKeyTyped(evt);
            }
        });

        jLabel1.setText("%");

        jLabel18.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel18.setText("Bono:");

        txtBono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBonoActionPerformed(evt);
            }
        });
        txtBono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBonoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btnAnadir, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel10)
                                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(60, 60, 60)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Medida, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(producto, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(marca, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtEnvase3, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(156, 156, 156)
                                        .addComponent(txtcantidadpro, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel18))
                                        .addGap(41, 41, 41)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtIva, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(txtBono, javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtporcentajeDescuento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel1)))))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Medida, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(marca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEnvase3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtporcentajeDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcantidadpro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAnadir, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel8.setBackground(new java.awt.Color(0, 153, 153));
        jLabel8.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(254, 254, 254));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("AÑADIR CANTIDAD ");
        jLabel8.setOpaque(true);
        jLabel8.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel8MouseDragged(evt);
            }
        });
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel8MousePressed(evt);
            }
        });

        codigo1.setEditable(false);
        codigo1.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        codigo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigo1ActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel13.setText("CODIGO:");

        jLabel20.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel20.setText("IVA:");

        jLabel25.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel25.setText("ENVASE:");

        txtEnvase4.setEditable(false);
        txtEnvase4.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        txtEnvase4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEnvase4ActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel26.setText("TIPO:");

        txtTipo1.setEditable(false);
        txtTipo1.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        txtTipo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTipo1ActionPerformed(evt);
            }
        });
        txtTipo1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTipo1KeyTyped(evt);
            }
        });

        txtIva1.setEditable(false);
        txtIva1.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel11.setText("DESCUENTO:");

        txtporcentajeDescuento1.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        txtporcentajeDescuento1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtporcentajeDescuento1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtporcentajeDescuento1KeyTyped(evt);
            }
        });

        marca1.setEditable(false);
        marca1.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel3.setText("%");

        txtcantidadpro1.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        txtcantidadpro1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcantidadpro1ActionPerformed(evt);
            }
        });
        txtcantidadpro1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcantidadpro1KeyTyped(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel21.setText("BONO:");

        jLabel12.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel12.setText("MARCA:");

        txtBono1.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        txtBono1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBono1ActionPerformed(evt);
            }
        });
        txtBono1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBono1KeyTyped(evt);
            }
        });

        btnAnadir1.setFont(new java.awt.Font("Ubuntu", 1, 10)); // NOI18N
        btnAnadir1.setForeground(new java.awt.Color(0, 102, 0));
        btnAnadir1.setText("AÑADIR");
        btnAnadir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnadir1ActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel22.setText("PRODUCTO:");

        producto1.setEditable(false);
        producto1.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N

        jLabel23.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel23.setText("CANTIDAD:");

        btnSalir1.setBackground(new java.awt.Color(153, 0, 0));
        btnSalir1.setFont(new java.awt.Font("Ubuntu", 1, 10)); // NOI18N
        btnSalir1.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir1.setText("SALIR");
        btnSalir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir1ActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel19.setText("PRECIO:");

        Medida1.setEditable(false);
        Medida1.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        Medida1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Medida1ActionPerformed(evt);
            }
        });
        Medida1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Medida1KeyTyped(evt);
            }
        });

        txtPrecio1.setEditable(false);
        txtPrecio1.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        txtPrecio1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecio1ActionPerformed(evt);
            }
        });
        txtPrecio1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecio1KeyTyped(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel24.setText("MEDIDA:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24)
                    .addComponent(jLabel22)
                    .addComponent(jLabel12)
                    .addComponent(jLabel25)
                    .addComponent(jLabel26)
                    .addComponent(jLabel13)
                    .addComponent(jLabel21)
                    .addComponent(jLabel11)
                    .addComponent(jLabel23)
                    .addComponent(jLabel19))
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtcantidadpro1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtBono1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtporcentajeDescuento1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addComponent(jLabel3))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txtPrecio1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel20)
                        .addGap(3, 3, 3)
                        .addComponent(txtIva1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(codigo1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Medida1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(producto1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(marca1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEnvase4, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTipo1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 35, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(btnAnadir1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalir1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codigo1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Medida1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(producto1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(marca1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEnvase4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTipo1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtporcentajeDescuento1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBono1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtcantidadpro1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPrecio1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIva1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAnadir1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtcantidadproActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcantidadproActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcantidadproActionPerformed

    private void txtcantidadproKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcantidadproKeyTyped
        char c = evt.getKeyChar();
        if (c < '0' || c > '9') {
            evt.consume();
            //            JOptionPane.showMessageDialog(null, "INGRESE NUMEROS");
        }
    }//GEN-LAST:event_txtcantidadproKeyTyped

    private void btnAnadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnadirActionPerformed
        String cant;
        String porc;
        String bono;
        if (txtcantidadpro.getText() == null || "".equals(txtcantidadpro.getText())) {
            JOptionPane.showMessageDialog(null, "Ingrese Cantidad");
        } else {
            cant = txtcantidadpro.getText();
            objf.setCantidad(Integer.parseInt(cant));
            setVisible(false);
        }
        /////////////
        if (!"".equals(txtporcentajeDescuento.getText())) {
            porc = txtporcentajeDescuento.getText();

        } else {
            porc = "0.00";

        }
        objf.setPorcentaje_descuento(BigDecimal.valueOf(Double.valueOf(porc)));
        if (!"".equals(txtBono.getText())) {
            bono = txtBono.getText();
        } else {
            bono = "0";
        }
        objf.setBono(Integer.parseInt(bono));
    }//GEN-LAST:event_btnAnadirActionPerformed

    private void codigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigoActionPerformed

    }//GEN-LAST:event_codigoActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        int r = JOptionPane.showConfirmDialog(null, "¿Desea Salir?", "", JOptionPane.YES_NO_OPTION);

        if (r == JOptionPane.YES_OPTION) {
            setVisible(false);

        } else {

        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void MedidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MedidaActionPerformed

    }//GEN-LAST:event_MedidaActionPerformed

    private void MedidaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MedidaKeyTyped

    }//GEN-LAST:event_MedidaKeyTyped

    private void txtEnvase3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEnvase3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEnvase3ActionPerformed

    private void txtTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTipoActionPerformed

    private void txtTipoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTipoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTipoKeyTyped

    private void txtPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioActionPerformed

    private void txtPrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioKeyTyped

    private void txtporcentajeDescuentoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtporcentajeDescuentoKeyReleased
        int largor = txtporcentajeDescuento.getText().length();
        if (largor > 2) {
            if (Integer.parseInt(txtporcentajeDescuento.getText()) == 100) {
                CADENA = txtporcentajeDescuento.getText();
                txtporcentajeDescuento.setText(CADENA);
            } else {
                CADENA = txtporcentajeDescuento.getText().substring(0, 2);
                txtporcentajeDescuento.setText(CADENA);
                JOptionPane.showMessageDialog(null, "INGRESE VALOR CORRECTO");
            }
        }
    }//GEN-LAST:event_txtporcentajeDescuentoKeyReleased

    private void txtporcentajeDescuentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtporcentajeDescuentoKeyTyped
        char c = evt.getKeyChar();
        if (c < '0' || c > '9') {
            evt.consume();
            //            JOptionPane.showMessageDialog(null, "INGRESE NUMEROS");
        }
    }//GEN-LAST:event_txtporcentajeDescuentoKeyTyped

    private void txtBonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBonoActionPerformed

    private void txtBonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBonoKeyTyped
        char c = evt.getKeyChar();
        if (c < '0' || c > '9') {
            evt.consume();
            //            JOptionPane.showMessageDialog(null, "INGRESE NUMEROS");
        }
    }//GEN-LAST:event_txtBonoKeyTyped

    private void jPanel3MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseDragged
        Point point = MouseInfo.getPointerInfo().getLocation();
        setLocation(point.x - x, point.y - y);
    }//GEN-LAST:event_jPanel3MouseDragged

    private void jPanel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jPanel3MousePressed

    private void txtPrecio1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecio1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecio1ActionPerformed

    private void txtPrecio1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecio1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecio1KeyTyped

    private void txtporcentajeDescuento1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtporcentajeDescuento1KeyReleased
        int largor = txtporcentajeDescuento.getText().length();
        if (largor > 2) {
            if (Integer.parseInt(txtporcentajeDescuento.getText()) == 100) {
                CADENA = txtporcentajeDescuento.getText();
                txtporcentajeDescuento.setText(CADENA);
            } else {
                CADENA = txtporcentajeDescuento.getText().substring(0, 2);
                txtporcentajeDescuento.setText(CADENA);
                JOptionPane.showMessageDialog(null, "INGRESE VALOR CORRECTO");
            }
        }
    }//GEN-LAST:event_txtporcentajeDescuento1KeyReleased

    private void txtporcentajeDescuento1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtporcentajeDescuento1KeyTyped
        char c = evt.getKeyChar();
        if (c < '0' || c > '9') {
            evt.consume();
            //            JOptionPane.showMessageDialog(null, "INGRESE NUMEROS");
        }
    }//GEN-LAST:event_txtporcentajeDescuento1KeyTyped

    private void txtcantidadpro1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcantidadpro1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcantidadpro1ActionPerformed

    private void txtcantidadpro1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcantidadpro1KeyTyped
        char c = evt.getKeyChar();
        if (c < '0' || c > '9') {
            evt.consume();
            //            JOptionPane.showMessageDialog(null, "INGRESE NUMEROS");
        }
    }//GEN-LAST:event_txtcantidadpro1KeyTyped

    private void txtBono1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBono1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBono1ActionPerformed

    private void txtBono1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBono1KeyTyped
        char c = evt.getKeyChar();
        if (c < '0' || c > '9') {
            evt.consume();
            //            JOptionPane.showMessageDialog(null, "INGRESE NUMEROS");
        }
    }//GEN-LAST:event_txtBono1KeyTyped

    private void btnAnadir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnadir1ActionPerformed
        String cant;
        String porc;
        String bono;
        if (txtcantidadpro.getText() == null || "".equals(txtcantidadpro.getText())) {
            JOptionPane.showMessageDialog(null, "Ingrese Cantidad");
        } else {
            cant = txtcantidadpro.getText();
            objf.setCantidad(Integer.parseInt(cant));
            setVisible(false);
        }
        /////////////
        if (!"".equals(txtporcentajeDescuento.getText())) {
            porc = txtporcentajeDescuento.getText();

        } else {
            porc = "0.00";

        }
        objf.setPorcentaje_descuento(BigDecimal.valueOf(Double.valueOf(porc)));
        if (!"".equals(txtBono.getText())) {
            bono = txtBono.getText();
        } else {
            bono = "0";
        }
        objf.setBono(Integer.parseInt(bono));
    }//GEN-LAST:event_btnAnadir1ActionPerformed

    private void codigo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigo1ActionPerformed

    }//GEN-LAST:event_codigo1ActionPerformed

    private void btnSalir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir1ActionPerformed
        int r = JOptionPane.showConfirmDialog(null, "¿Desea Salir?", "", JOptionPane.YES_NO_OPTION);

        if (r == JOptionPane.YES_OPTION) {
            setVisible(false);

        } else {

        }
    }//GEN-LAST:event_btnSalir1ActionPerformed

    private void Medida1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Medida1ActionPerformed

    }//GEN-LAST:event_Medida1ActionPerformed

    private void Medida1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Medida1KeyTyped

    }//GEN-LAST:event_Medida1KeyTyped

    private void txtEnvase4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEnvase4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEnvase4ActionPerformed

    private void txtTipo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTipo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTipo1ActionPerformed

    private void txtTipo1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTipo1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTipo1KeyTyped

    private void jLabel8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jLabel8MousePressed

    private void jLabel8MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseDragged
        Point point = MouseInfo.getPointerInfo().getLocation();
        setLocation(point.x - x, point.y - y);
    }//GEN-LAST:event_jLabel8MouseDragged
    private void llenarFormulario(joinProductoDetallesFaltantes obj) {
        codigo1.setText(obj.getId_producto().toString());
        producto1.setText(obj.getNombre_producto());
        Medida1.setText(obj.getMedida());
        marca1.setText(obj.getMarca());
        txtEnvase4.setText(obj.getEnvase());
        txtTipo1.setText(obj.getNombre_tipo());
        txtPrecio1.setText(String.valueOf(obj.getPrecios()));
        txtIva1.setText(obj.getIva());
//        txtporcentajeDescuento1.setText(obj.getPorcentaje_descuento().toString());
//        txtBono1.setText(obj.getBono().toString());
//        txtcantidadpro1.setText(obj.getCantidad().toString());
//        txtPrecio1.setText(obj.getPrecios().toString());
        
        //
        objf.setId_producto(obj.getId_producto());
        objf.setNombre_producto(obj.getNombre_producto());
        objf.setMedida(obj.getMedida());
        objf.setMarca(obj.getMarca());
        objf.setEnvase(obj.getEnvase());
        objf.setNombre_tipo(obj.getNombre_tipo());
        objf.setPrecios(obj.getPrecios());
        objf.setIva(obj.getIva());
        objf.setId_precios(obj.getId_precios());
    }    public joinProductoDetallesFaltantes getObjf() {
        return objf;
    }    String CADENA = "";
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
            java.util.logging.Logger.getLogger(AgregarProductoEnCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarProductoEnCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarProductoEnCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarProductoEnCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AgregarProductoEnCompras dialog = new AgregarProductoEnCompras(new javax.swing.JFrame(), true);
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
    private javax.swing.JTextField Medida;
    private javax.swing.JTextField Medida1;
    private javax.swing.JButton btnAnadir;
    private javax.swing.JButton btnAnadir1;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSalir1;
    private javax.swing.JTextField codigo;
    private javax.swing.JTextField codigo1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField marca;
    private javax.swing.JTextField marca1;
    private javax.swing.JTextField producto;
    private javax.swing.JTextField producto1;
    private javax.swing.JTextField txtBono;
    private javax.swing.JTextField txtBono1;
    private javax.swing.JTextField txtEnvase3;
    private javax.swing.JTextField txtEnvase4;
    private javax.swing.JTextField txtIva;
    private javax.swing.JTextField txtIva1;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtPrecio1;
    private javax.swing.JTextField txtTipo;
    private javax.swing.JTextField txtTipo1;
    private javax.swing.JTextField txtcantidadpro;
    private javax.swing.JTextField txtcantidadpro1;
    private javax.swing.JTextField txtporcentajeDescuento;
    private javax.swing.JTextField txtporcentajeDescuento1;
    private javax.swing.JTextField valorDescuento;
    // End of variables declaration//GEN-END:variables
}
