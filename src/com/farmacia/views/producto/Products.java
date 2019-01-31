/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmacia.views.producto;

import com.farmacia.conponentes.Formulario;
import com.farmacia.dao.CRUD;
import com.farmacia.entities1.EnvaseProducto;
import com.farmacia.entities1.Iva;
import com.farmacia.entities1.MarcaProducto;
import com.farmacia.entities1.MedidaProducto;
import com.farmacia.entities1.Productos;
import com.farmacia.entities1.TipoProducto;
import com.farmacia.fecha.Fecha;
import com.farmacia.views.compras.AgregarEnvase;
import com.farmacia.views.compras.AgregarMarca;
import com.farmacia.views.compras.AgregarMedida;
import com.farmacia.views.compras.AgregarTipo;
import com.farmacia.views.precios.Ingreso_de_Precios;

import java.awt.MouseInfo;
import java.awt.Point;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author guest-qzjm76
 */
public class Products extends javax.swing.JDialog {
    int x, y;
    CRUD crud = new CRUD();
    ArrayList<TipoProducto> lista = crud.listarTodoTipoProductos1();
    ArrayList<MedidaProducto> listam = crud.listarTodoMedidasProductos();
    ArrayList<EnvaseProducto> listae = crud.listarTodoEnvaseProductos();
    ArrayList<MarcaProducto> listama = crud.listarTodoMarcaProductos();
    ArrayList<Iva> listaIva = crud.listarTodoIvaProducto();
    Long id_tipo, id_medida, id_envase, id_marca;
    String error = "",IVA="",valorIDProd="";

    public Products(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        this.setLocationRelativeTo(null);

        cbxTipos.setModel(Formulario.listarComboTipoPro(lista));
        cbxMedida.setModel(Formulario.listarComboMedidaPro(listam));
        cbxEnvase.setModel(Formulario.listarComboEnvasePro(listae));
        cbxMarca.setModel(Formulario.listarComboMarcaPro(listama));
        cbxIva.setModel(Formulario.listarComboIva(listaIva));
        txtFechaActual.setText(FechaActual());
        Habilitar(false);
    }
    public void Habilitar(boolean valor) {
        ingresoDePrecio.setEnabled(valor);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel11 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnAgregar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cbxMarca = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        cbxMedida = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cbxTipos = new javax.swing.JComboBox<>();
        btnAgregarTipo = new javax.swing.JButton();
        btnAgregarMedida = new javax.swing.JButton();
        btnAgreMarca = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtPeso = new javax.swing.JTextField();
        btnAgreEnvase = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        cbxEnvase = new javax.swing.JComboBox<>();
        nombre1 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        cbxIva = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtcantMinima = new javax.swing.JTextField();
        ingresoDePrecio = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        id_usuario = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtFechaActual = new javax.swing.JTextField();

        jLabel11.setText("Fecha :");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/farmacia/icon/folder_add_icon-icons.com_74436.png"))); // NOI18N
        btnAgregar.setText("AGREGAR");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/farmacia/icon/action_exit_close_remove_13915.png"))); // NOI18N
        btnSalir.setText("SALIR");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setText("Nombre :");

        jLabel8.setText("MARCA:");

        cbxMarca.setEditable(true);
        cbxMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxMarcaActionPerformed(evt);
            }
        });

        jLabel10.setText("MEDIDA:");

        cbxMedida.setEditable(true);
        cbxMedida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxMedidaActionPerformed(evt);
            }
        });

        jLabel3.setText("Descripcion:");

        txtDescripcion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDescripcionFocusLost(evt);
            }
        });

        jLabel5.setText("TIPO:");

        cbxTipos.setEditable(true);
        cbxTipos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxTipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTiposActionPerformed(evt);
            }
        });

        btnAgregarTipo.setText("agregar");
        btnAgregarTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarTipoActionPerformed(evt);
            }
        });

        btnAgregarMedida.setText("agregar");
        btnAgregarMedida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarMedidaActionPerformed(evt);
            }
        });

        btnAgreMarca.setText("agregar");
        btnAgreMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgreMarcaActionPerformed(evt);
            }
        });

        jLabel6.setText("PESO:");

        txtPeso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesoActionPerformed(evt);
            }
        });

        btnAgreEnvase.setText("agregar");
        btnAgreEnvase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgreEnvaseActionPerformed(evt);
            }
        });

        jLabel13.setText("ENVASE:");

        cbxEnvase.setEditable(true);
        cbxEnvase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxEnvaseActionPerformed(evt);
            }
        });

        nombre1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                nombre1FocusLost(evt);
            }
        });

        jLabel20.setText("IVA");

        cbxIva.setEditable(true);
        cbxIva.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NO", "SI" }));
        cbxIva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxIvaActionPerformed(evt);
            }
        });

        jLabel7.setText("CANT. MINIMA:");

        txtcantMinima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcantMinimaActionPerformed(evt);
            }
        });

        ingresoDePrecio.setText("INGRESAR PRECIOS");
        ingresoDePrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresoDePrecioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addComponent(cbxTipos, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(11, 11, 11)
                                                .addComponent(cbxEnvase, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnAgregarTipo)
                                            .addComponent(btnAgreEnvase)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(cbxMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnAgreMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbxMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnAgregarMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtDescripcion)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(nombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cbxIva, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(txtcantMinima, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ingresoDePrecio)
                        .addGap(67, 67, 67))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxIva, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarMedida))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxTipos, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarTipo)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxEnvase, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgreEnvase)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgreMarca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtcantMinima, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ingresoDePrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel14.setBackground(new java.awt.Color(175, 226, 226));
        jLabel14.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 51));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("PRODUCTOS");
        jLabel14.setOpaque(true);
        jLabel14.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel14MouseDragged(evt);
            }
        });
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel14MousePressed(evt);
            }
        });

        jLabel9.setText("USUARIO:");

        id_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_usuarioActionPerformed(evt);
            }
        });

        jLabel12.setText("Fecha :");

        txtFechaActual.setEditable(false);
        txtFechaActual.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(btnAgregar)
                        .addGap(37, 37, 37)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(jLabel9)
                        .addGap(27, 27, 27)
                        .addComponent(id_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(txtFechaActual, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(id_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFechaActual, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnSalir))
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 460));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
       String valor="";
        if (!"".equals(seleccionId())) {
            JOptionPane.showMessageDialog(this, error);

        } else {

            Productos p = new Productos();
            p.setNombre(nombre1.getText());
            p.setDescripcion(txtDescripcion.getText());
            p.setFecha_registro(Fecha.FechaSql());
            p.setPeso(Double.parseDouble(txtPeso.getText()));
            p.setId_tipo(id_tipo);
            p.setId_medidas(id_medida);
            p.setId_envase(id_envase);
            p.setId_marcas(id_marca);
            p.setId_usuario(Long.valueOf(id_usuario.getText()));
            p.setIva(IVA);
            p.setCantidad_minima(Long.valueOf(txtcantMinima.getText()));
            valor = crud.insertarProductoNuevo(p);
            JOptionPane.showMessageDialog(this, valor);
            
            Productos p2 = new Productos();
            p2.setNombre(nombre1.getText());
            p2.setDescripcion(txtDescripcion.getText());
            p2.setFecha_registro(Fecha.FechaSql());
            p2.setPeso(Double.parseDouble(txtPeso.getText()));
            p2.setId_tipo(id_tipo);
            p2.setId_medidas(id_medida);
            p2.setId_envase(id_envase);
            p2.setId_marcas(id_marca);
            p2.setId_usuario(Long.valueOf(id_usuario.getText()));
            p2.setIva(IVA);
            p2.setCantidad_minima(Long.valueOf(txtcantMinima.getText()));
            valorIDProd = crud.BuscarIDProductoNuevo(p2);
            if(valorIDProd!=null){
            Habilitar(true);
            btnAgregar.setEnabled(false);
            }
            //setVisible(false);
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void cbxMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxMarcaActionPerformed
        seleccionId();
    }//GEN-LAST:event_cbxMarcaActionPerformed

    private void cbxMedidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxMedidaActionPerformed
        seleccionId();
    }//GEN-LAST:event_cbxMedidaActionPerformed

    private void cbxTiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTiposActionPerformed
        seleccionId();
    }//GEN-LAST:event_cbxTiposActionPerformed

    private void btnAgregarTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarTipoActionPerformed
        AgregarTipo nuevotipo = new AgregarTipo(new javax.swing.JFrame(), true);
        nuevotipo.setVisible(true);
        lista = crud.listarTodoTipoProductos1();
        cbxTipos.setModel(Formulario.listarComboTipoPro(lista));
    }//GEN-LAST:event_btnAgregarTipoActionPerformed

    private void btnAgregarMedidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarMedidaActionPerformed
        AgregarMedida agremed = new AgregarMedida(new javax.swing.JFrame(), true);
        agremed.setVisible(true);
        listam = crud.listarTodoMedidasProductos();//     listarTodoTipoProductos1();
        cbxMedida.setModel(Formulario.listarComboMedidaPro(listam));
    }//GEN-LAST:event_btnAgregarMedidaActionPerformed

    private void btnAgreMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgreMarcaActionPerformed
        AgregarMarca agremar = new AgregarMarca(new javax.swing.JFrame(), true);
        agremar.setVisible(true);
        listama = crud.listarTodoMarcaProductos();//     listarTodoTipoProductos1();
        cbxMarca.setModel(Formulario.listarComboMarcaPro(listama));
    }//GEN-LAST:event_btnAgreMarcaActionPerformed

    private void txtPesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesoActionPerformed

    private void btnAgreEnvaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgreEnvaseActionPerformed
        AgregarEnvase agreenv = new AgregarEnvase(new javax.swing.JFrame(), true);
        agreenv.setVisible(true);
        listae = crud.listarTodoEnvaseProductos();
        cbxEnvase.setModel(Formulario.listarComboEnvasePro(listae));
    }//GEN-LAST:event_btnAgreEnvaseActionPerformed

    private void cbxEnvaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxEnvaseActionPerformed
        seleccionId();
        // System.out.println(" " + listae.get(pos_envase).getId_envase() + " " + listae.get(pos_envase).getNombreEnvase());
    }//GEN-LAST:event_cbxEnvaseActionPerformed

    private void nombre1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nombre1FocusLost
        nombre1.setText(nombre1.getText().toUpperCase());
    }//GEN-LAST:event_nombre1FocusLost

    private void txtDescripcionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDescripcionFocusLost
        txtDescripcion.setText(txtDescripcion.getText().toUpperCase());
    }//GEN-LAST:event_txtDescripcionFocusLost

    private void txtcantMinimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcantMinimaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcantMinimaActionPerformed

    private void id_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_usuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_id_usuarioActionPerformed

    private void cbxIvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxIvaActionPerformed
        IVA=cbxIva.getSelectedItem().toString();
        System.out.println("iba: "+IVA);
    }//GEN-LAST:event_cbxIvaActionPerformed

    private void ingresoDePrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingresoDePrecioActionPerformed
        Ingreso_de_Precios p = new Ingreso_de_Precios(new javax.swing.JFrame(), true,Long.valueOf(valorIDProd),nombre1.getText());
        p.setVisible(true);
    }//GEN-LAST:event_ingresoDePrecioActionPerformed

    private void jLabel14MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseDragged
        Point point = MouseInfo.getPointerInfo().getLocation();
        setLocation(point.x - x, point.y - y);
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel14MouseDragged

    private void jLabel14MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MousePressed
        x = evt.getX();
        y = evt.getY();
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel14MousePressed

    private String seleccionId() {
        error = "";
      
        if (nombre1.getText().length() < 5) {
            error = error + "\nNombre invalido!";
        }
          if (txtDescripcion.getText().length() < 5) {
            error = error + "\nDescripcion invalida!";
        }
        if (txtPeso.getText() == null || "".equals(txtPeso.getText())) {
            error = error + "\nCantidad invalida!";
        }
        int pos = (cbxTipos.getSelectedIndex() - 1);
        if (pos < 0) {
            error = error + "\nTipo de producto invalido !";
        } else {
            id_tipo = lista.get(pos).getId_tipo();
            System.err.println(id_tipo);
        }

        pos = (cbxMedida.getSelectedIndex() - 1);
        if (pos < 0) {
            error = error + "\nMedida invalida !";
        } else {
            id_medida = listam.get(pos).getId_medidas();
            System.err.println(id_medida);
        }

        pos = (cbxMarca.getSelectedIndex() - 1);
        if (pos < 0) {
            error = error + "\nMarca invalida !";
        } else {
            id_marca = listama.get(pos).getId_Marcas();
            System.err.println(id_marca);
        }

        pos = (cbxEnvase.getSelectedIndex() - 1);
        if (pos < 0) {
            error = error + "\nEnvase invalido !";
        } else {
            id_envase = listae.get(pos).getId_envase();
            System.err.println(id_envase);
        }
        return error;
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
            java.util.logging.Logger.getLogger(Products.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Products.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Products.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Products.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Products dialog = new Products(new javax.swing.JFrame(), true);
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

    public static String FechaActual() {
        Date fecha = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("YYYY/MM/dd");
        return formatoFecha.format(fecha);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgreEnvase;
    private javax.swing.JButton btnAgreMarca;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAgregarMedida;
    private javax.swing.JButton btnAgregarTipo;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cbxEnvase;
    private javax.swing.JComboBox<String> cbxIva;
    private javax.swing.JComboBox<String> cbxMarca;
    private javax.swing.JComboBox<String> cbxMedida;
    private javax.swing.JComboBox<String> cbxTipos;
    public static javax.swing.JTextField id_usuario;
    private javax.swing.JButton ingresoDePrecio;
    public static javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    public static javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    public static javax.swing.JLabel jLabel2;
    public static javax.swing.JLabel jLabel20;
    public static javax.swing.JLabel jLabel3;
    public static javax.swing.JLabel jLabel5;
    public static javax.swing.JLabel jLabel6;
    public static javax.swing.JLabel jLabel7;
    public static javax.swing.JLabel jLabel8;
    public static javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField nombre1;
    public static javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtFechaActual;
    public static javax.swing.JTextField txtPeso;
    public static javax.swing.JTextField txtcantMinima;
    // End of variables declaration//GEN-END:variables
}
