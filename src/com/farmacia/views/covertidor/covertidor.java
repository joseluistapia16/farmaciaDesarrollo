/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmacia.views.covertidor;

import com.farmacia.conponentes.Formulario;
import com.farmacia.dao.CRUD;
import com.farmacia.entities1.EnvaseProducto;
import com.farmacia.entities1.MarcaProducto;
import com.farmacia.entities1.MedidaProducto;
import com.farmacia.entities1.Productos;
import com.farmacia.entities1.TipoProducto;
import com.farmacia.fecha.Fecha;
import com.farmacia.join_entidades.listarJoinProductosCompras;
import com.farmacia.views.compras.AgregarEnvase;
import com.farmacia.views.compras.AgregarMarca;
import com.farmacia.views.compras.AgregarMedida;
import com.farmacia.views.compras.AgregarTipo;
import java.awt.MouseInfo;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author usuario
 */
public class covertidor extends javax.swing.JDialog {
    
    CRUD crud = new CRUD();
    listarJoinProductosCompras obj1 = null;
    int x, y;
    ArrayList<TipoProducto> lista = null;
    ArrayList<MedidaProducto> listam = null;
    ArrayList<EnvaseProducto> listae = null;
    ArrayList<MarcaProducto> listama = null;
    String str_tipo = null, str_medidas = null, str_envase = null, str_marcas = null, strIva = null;
    String error = "", IVA = "";
    Long id_tipo, id_medida, id_envase, id_marca, id_PrecioNuevo;
    int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
    int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
    listarJoinProductosCompras objeto = null;
    Integer resta = 0, suma = 0;
    
    public covertidor(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.setUndecorated(true);
        initComponents();
        setLocationRelativeTo(null);
        listarCombos(obj1);
        llenarFormulario(obj1);
        Habilitar(false);
    }
    
    public covertidor(java.awt.Frame parent, boolean modal, listarJoinProductosCompras obj) {
        super(parent, modal);
        this.setUndecorated(true);
        initComponents();
        setLocationRelativeTo(null);
        //ArrayList<listarJoinProductosCompras> lista = crud.listarTodoJoinProductos(1);
        obj1 = obj;
        listarCombos(obj1);
        llenarFormulario(obj1);
        Habilitar(false);
    }
    
    public void listarCombos(listarJoinProductosCompras obj) {
        
        lista = crud.listarTodoTipoProductos1();
        listam = crud.listarTodoMedidasProductos();
        listae = crud.listarTodoEnvaseProductos();
        listama = crud.listarTodoMarcaProductos();
        
        cbxTipos1.setModel(Formulario.listarComboTipoPro(lista));
        cbxMedida1.setModel(Formulario.listarComboMedidaPro(listam));
        cbxEnvase1.setModel(Formulario.listarComboEnvasePro(listae));
        cbxMarca1.setModel(Formulario.listarComboMarcaPro(listama));
        
        str_tipo = crud.getNombreComboProducto(Long.valueOf("1"), obj.getId_tipo());
        cbxTipos1.setSelectedItem(str_tipo);
        str_medidas = crud.getNombreComboProducto(Long.valueOf("2"), obj.getId_medida());
        cbxMedida1.setSelectedItem(str_medidas);
        str_envase = crud.getNombreComboProducto(Long.valueOf("3"), obj.getId_envase());
        cbxEnvase1.setSelectedItem(str_envase);
        str_marcas = crud.getNombreComboProducto(Long.valueOf("4"), obj.getId_marca());
        cbxMarca1.setSelectedItem(str_marcas);
        //id_usuario.setText(obj.getId_usuario().toString());
        strIva = crud.getNombreComboProducto(Long.valueOf("5"), obj.getId_productos());
        
    }
    
    private void llenarFormulario(listarJoinProductosCompras obj) {
        txtcodgo.setText(obj.getId_productos().toString());
        txtProducto.setText(obj.getNombreProductos());
        txtdescripcion.setText(obj.getDescripcion());
        txtcant.setText(obj.getCantidadStock().toString());
        //txtPeso1.setText(obj.getPeso().toString());
        // txtFechaActual1.setText(obj.getFecha_registro().toString());

        //txtcantMinima.setText(obj.getCantidad_minima().toString());
        System.out.println(//"id_medida: "+obj.getId_medida()+"/n"+
                "id_tipo:" + id_tipo);
//                            "id_envase"+obj.getNombreEnvase()+"/n"+
//                            "id_marca"+obj.getId_marca());
//        
    }
    
    public void Habilitar(boolean valor) {
        cbxEnvase1.disable();
        cbxMedida1.disable();
        cbxMarca1.disable();
        cbxTipos1.disable();
        btnCalcular.setEnabled(valor);
        jPanel3.setEnabled(valor);
        txtcant3.setEnabled(valor);
        codigo3.setEnabled(valor);
        buscarProducto3.setEnabled(valor);
        producto3.setEnabled(valor);
        descripcion3.setEnabled(valor);
        cbxEnvase3.setEnabled(valor);
        cbxMarca3.setEnabled(valor);
        cbxMedida3.setEnabled(valor);
        cbxTipos3.setEnabled(valor);

        ///////////
        jPanel4.setEnabled(valor);
        cant4.setEnabled(valor);
        
        producto4.setEnabled(valor);
        descripcion4.setEnabled(valor);
        cant4.setEnabled(valor);
        cbxEnvase4.setEnabled(valor);
        cbxMarca4.setEnabled(valor);
        cbxMedida4.setEnabled(valor);
        cbxTipos4.setEnabled(valor);
        btnGuardar.setEnabled(valor);
        btnGuardar4.setEnabled(valor);
        btnAgregarMedida4.setEnabled(valor);
        btnAgreEnvase4.setEnabled(valor);
        btnAgreMarca4.setEnabled(valor);
        btnAgregarTipo4.setEnabled(valor);
        btnCalcular4.setEnabled(valor);
        
    }
    
    public void HabilitarPanel3(boolean valor) {
        jPanel3.setEnabled(valor);
        txtcant3.setEnabled(valor);
        codigo3.setEnabled(valor);
        buscarProducto3.setEnabled(valor);
        producto3.setEnabled(valor);
        descripcion3.setEnabled(valor);
        cbxEnvase3.setEnabled(valor);
        cbxMarca3.setEnabled(valor);
        cbxMedida3.setEnabled(valor);
        cbxTipos3.setEnabled(valor);
        
        btnCalcular.setEnabled(false);
    }
    
    public void HabilitarPanel4(boolean valor) {
        jPanel4.setEnabled(valor);
        cant4.setEnabled(valor);
        
        producto4.setEnabled(valor);
        descripcion4.setEnabled(valor);
        cant4.setEnabled(valor);
        cbxEnvase4.setEnabled(valor);
        cbxMarca4.setEnabled(valor);
        cbxMedida4.setEnabled(valor);
        cbxTipos4.setEnabled(valor);
        // btnGuardar.setEnabled(valor);
        btnAgregarMedida4.setEnabled(valor);
        btnAgreEnvase4.setEnabled(valor);
        btnAgreMarca4.setEnabled(valor);
        btnAgregarTipo4.setEnabled(valor);
        btnCalcular4.setEnabled(valor);
        
    }
    
    private String seleccionId() {
        error = "";
        
        if (producto4.getText().length() < 5) {
            error = error + "\nNombre invalido!";
        }
        if (descripcion4.getText().length() < 5) {
            error = error + "\nDescripcion invalida!";
        }
//        if (txtPeso1.getText() == null || "".equals(txtPeso1.getText())) {
//            error = error + "\nCantidad invalida!";
//        }
        int pos = (cbxTipos4.getSelectedIndex() - 1);
        if (pos < 0) {
            error = error + "\nTipo de producto invalido !";
        } else {
            id_tipo = lista.get(pos).getId_tipo();
            System.err.println(id_tipo);
        }
        
        pos = (cbxMedida4.getSelectedIndex() - 1);
        if (pos < 0) {
            error = error + "\nMedida invalida !";
        } else {
            id_medida = listam.get(pos).getId_medidas();
            System.err.println(id_medida);
        }
        
        pos = (cbxMarca4.getSelectedIndex() - 1);
        if (pos < 0) {
            error = error + "\nMarca invalida !";
        } else {
            id_marca = listama.get(pos).getId_Marcas();
            System.err.println(id_marca);
        }
        
        pos = (cbxEnvase4.getSelectedIndex() - 1);
        if (pos < 0) {
            error = error + "\nEnvase invalido !";
        } else {
            id_envase = listae.get(pos).getId_envase();
            System.err.println(id_envase);
        }
        return error;
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
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        txtProducto = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        cbxMedida1 = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        cbxTipos1 = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        cbxEnvase1 = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        cbxMarca1 = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        txtcodgo = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtdescripcion = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbxElaine = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        producto3 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        cbxMedida3 = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        cbxTipos3 = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        cbxEnvase3 = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        cbxMarca3 = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        codigo3 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        descripcion3 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        buscarProducto3 = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();
        txtcant3 = new javax.swing.JTextField();
        btnCalcular = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        cbxTipos4 = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        cbxEnvase4 = new javax.swing.JComboBox<>();
        jLabel25 = new javax.swing.JLabel();
        cbxMarca4 = new javax.swing.JComboBox<>();
        jLabel26 = new javax.swing.JLabel();
        descripcion4 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        producto4 = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        cbxMedida4 = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        cant4 = new javax.swing.JTextField();
        btnAgregarMedida4 = new javax.swing.JButton();
        btnAgregarTipo4 = new javax.swing.JButton();
        btnAgreEnvase4 = new javax.swing.JButton();
        btnAgreMarca4 = new javax.swing.JButton();
        btnCalcular4 = new javax.swing.JButton();
        btnGuardar4 = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        txtcant = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        cbxTipos5 = new javax.swing.JComboBox<>();
        jLabel27 = new javax.swing.JLabel();
        cbxEnvase5 = new javax.swing.JComboBox<>();
        jLabel33 = new javax.swing.JLabel();
        cbxMarca5 = new javax.swing.JComboBox<>();
        jLabel34 = new javax.swing.JLabel();
        descripcion5 = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        producto5 = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        cbxMedida5 = new javax.swing.JComboBox<>();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        cant5 = new javax.swing.JTextField();
        btnAgregarMedida5 = new javax.swing.JButton();
        btnAgregarTipo5 = new javax.swing.JButton();
        btnAgreEnvase5 = new javax.swing.JButton();
        btnAgreMarca5 = new javax.swing.JButton();
        btnCalcular5 = new javax.swing.JButton();
        btnGuardar5 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel2.setBackground(new java.awt.Color(0, 153, 153));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("CONVERTIDOR");
        jLabel2.setOpaque(true);
        jLabel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel2MouseDragged(evt);
            }
        });
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel2MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1022, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        txtProducto.setEditable(false);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("UNIDAD DE MEDIDA:");

        cbxMedida1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbxMedida1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxMedida1ActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("TIPO:");

        cbxTipos1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbxTipos1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxTipos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTipos1ActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setText("PRESENTACION:");

        cbxEnvase1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbxEnvase1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxEnvase1ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("MARCA/LABORATORIO:");

        cbxMarca1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbxMarca1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxMarca1ActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("PRODUCTO:");

        txtcodgo.setEditable(false);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("CODIGO:");

        txtdescripcion.setEditable(false);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("DESCRIPCION:");

        jLabel4.setText("CONVERTIR A:");

        cbxElaine.setEditable(true);
        cbxElaine.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TODOS", "ELEGIR PRODUCTO", "NUEVO PRODUCTO", "PRODUCTO NUEVO PRECIO" }));
        cbxElaine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxElaineActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CONVERTIR A EXISTENTE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 11))); // NOI18N

        producto3.setEditable(false);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("UNIDAD DE MEDIDA:");

        cbxMedida3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbxMedida3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxMedida3ActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("TIPO:");

        cbxTipos3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbxTipos3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxTipos3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTipos3ActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setText("PRESENTACION:");

        cbxEnvase3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbxEnvase3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxEnvase3ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("MARCA/LABORATORIO:");

        cbxMarca3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbxMarca3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxMarca3ActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setText("PRODUCTO:");

        codigo3.setEditable(false);

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setText("CODIGO:");

        descripcion3.setEditable(false);

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setText("DESCRIPCION:");

        jLabel3.setText("TRANSFORMAR EXISTENTE");

        buscarProducto3.setFont(new java.awt.Font("Times New Roman", 1, 11)); // NOI18N
        buscarProducto3.setText("BUSCAR PRODUCTO");
        buscarProducto3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarProducto3ActionPerformed(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel31.setText("CANT:");

        txtcant3.setEditable(false);

        btnCalcular.setFont(new java.awt.Font("Times New Roman", 1, 11)); // NOI18N
        btnCalcular.setText("CALCULAR");
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });

        btnGuardar.setFont(new java.awt.Font("Times New Roman", 1, 11)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/farmacia/icon/guardar.jpg"))); // NOI18N
        btnGuardar.setText("GUARDAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel15)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(codigo3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(producto3, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(descripcion3, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtcant3, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                                .addContainerGap())
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbxMedida3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbxTipos3, 0, 242, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel19))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbxEnvase3, 0, 233, Short.MAX_VALUE)
                                    .addComponent(cbxMarca3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(63, 63, 63))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buscarProducto3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCalcular)
                        .addGap(18, 18, 18)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscarProducto3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtcant3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(producto3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(codigo3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(descripcion3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxMedida3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxTipos3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cbxEnvase3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxMarca3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CONVERTIR A NUEVO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 11))); // NOI18N

        cbxTipos4.setEditable(true);
        cbxTipos4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbxTipos4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxTipos4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTipos4ActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel24.setText("PRESENTACION:");

        cbxEnvase4.setEditable(true);
        cbxEnvase4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbxEnvase4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxEnvase4ActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel25.setText("MARCA/LABORATORIO:");

        cbxMarca4.setEditable(true);
        cbxMarca4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbxMarca4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxMarca4ActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel26.setText("PRODUCTO:");

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel28.setText("DESCRIPCION:");

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel29.setText("UNIDAD DE MEDIDA:");

        cbxMedida4.setEditable(true);
        cbxMedida4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbxMedida4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxMedida4ActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel23.setText("TIPO:");

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel32.setText("CANT:");

        cant4.setEditable(false);
        cant4.setText("0");

        btnAgregarMedida4.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnAgregarMedida4.setText("AGREGAR");
        btnAgregarMedida4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarMedida4ActionPerformed(evt);
            }
        });

        btnAgregarTipo4.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnAgregarTipo4.setText("AGREGAR");
        btnAgregarTipo4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarTipo4ActionPerformed(evt);
            }
        });

        btnAgreEnvase4.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnAgreEnvase4.setText("AGREGAR");
        btnAgreEnvase4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgreEnvase4ActionPerformed(evt);
            }
        });

        btnAgreMarca4.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnAgreMarca4.setText("AGREGAR");
        btnAgreMarca4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgreMarca4ActionPerformed(evt);
            }
        });

        btnCalcular4.setFont(new java.awt.Font("Times New Roman", 1, 11)); // NOI18N
        btnCalcular4.setText("CALCULAR");
        btnCalcular4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcular4ActionPerformed(evt);
            }
        });

        btnGuardar4.setFont(new java.awt.Font("Times New Roman", 1, 11)); // NOI18N
        btnGuardar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/farmacia/icon/guardar.jpg"))); // NOI18N
        btnGuardar4.setText("GUARDAR");
        btnGuardar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardar4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addComponent(jLabel29)
                    .addComponent(jLabel26))
                .addGap(28, 28, 28)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(producto4, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel28)
                        .addGap(18, 18, 18)
                        .addComponent(descripcion4, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cant4)
                        .addGap(22, 22, 22))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbxMedida4, 0, 180, Short.MAX_VALUE)
                            .addComponent(cbxTipos4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAgregarMedida4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAgregarTipo4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24)
                            .addComponent(jLabel25))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxEnvase4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbxMarca4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAgreEnvase4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAgreMarca4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20))))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(176, 176, 176)
                .addComponent(btnCalcular4)
                .addGap(35, 35, 35)
                .addComponent(btnGuardar4, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 544, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCalcular4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cant4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(producto4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(descripcion4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxEnvase4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAgreEnvase4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxMarca4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAgreMarca4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxMedida4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAgregarMedida4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxTipos4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAgregarTipo4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel30.setText("CANT:");

        txtcant.setEditable(false);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CONVERTIR CON NUEVO PRECIO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 11))); // NOI18N

        cbxTipos5.setEditable(true);
        cbxTipos5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbxTipos5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxTipos5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTipos5ActionPerformed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel27.setText("PRESENTACION:");

        cbxEnvase5.setEditable(true);
        cbxEnvase5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbxEnvase5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxEnvase5ActionPerformed(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel33.setText("MARCA/LABORATORIO:");

        cbxMarca5.setEditable(true);
        cbxMarca5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbxMarca5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxMarca5ActionPerformed(evt);
            }
        });

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel34.setText("PRODUCTO:");

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel35.setText("DESCRIPCION:");

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel36.setText("UNIDAD DE MEDIDA:");

        cbxMedida5.setEditable(true);
        cbxMedida5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbxMedida5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxMedida5ActionPerformed(evt);
            }
        });

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel37.setText("TIPO:");

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel38.setText("CANT:");

        cant5.setEditable(false);

        btnAgregarMedida5.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnAgregarMedida5.setText("AGREGAR");
        btnAgregarMedida5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarMedida5ActionPerformed(evt);
            }
        });

        btnAgregarTipo5.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnAgregarTipo5.setText("AGREGAR");
        btnAgregarTipo5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarTipo5ActionPerformed(evt);
            }
        });

        btnAgreEnvase5.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnAgreEnvase5.setText("AGREGAR");
        btnAgreEnvase5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgreEnvase5ActionPerformed(evt);
            }
        });

        btnAgreMarca5.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnAgreMarca5.setText("AGREGAR");
        btnAgreMarca5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgreMarca5ActionPerformed(evt);
            }
        });

        btnCalcular5.setFont(new java.awt.Font("Times New Roman", 1, 11)); // NOI18N
        btnCalcular5.setText("CALCULAR");
        btnCalcular5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcular5ActionPerformed(evt);
            }
        });

        btnGuardar5.setFont(new java.awt.Font("Times New Roman", 1, 11)); // NOI18N
        btnGuardar5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/farmacia/icon/guardar.jpg"))); // NOI18N
        btnGuardar5.setText("GUARDAR");
        btnGuardar5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardar5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel37)
                    .addComponent(jLabel36)
                    .addComponent(jLabel34))
                .addGap(28, 28, 28)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(producto5, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel35)
                        .addGap(18, 18, 18)
                        .addComponent(descripcion5, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cant5)
                        .addGap(22, 22, 22))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbxMedida5, 0, 180, Short.MAX_VALUE)
                            .addComponent(cbxTipos5, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAgregarMedida5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAgregarTipo5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27)
                            .addComponent(jLabel33))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxEnvase5, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbxMarca5, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAgreEnvase5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAgreMarca5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20))))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(176, 176, 176)
                .addComponent(btnCalcular5)
                .addGap(35, 35, 35)
                .addComponent(btnGuardar5, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 544, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCalcular5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cant5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(producto5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(descripcion5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxEnvase5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAgreEnvase5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxMarca5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAgreMarca5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxMedida5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAgregarMedida5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxTipos5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAgregarTipo5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel11)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtcodgo, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtdescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtcant, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 43, Short.MAX_VALUE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cbxMedida1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cbxTipos1, 0, 248, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel18)
                                            .addComponent(jLabel9))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cbxEnvase1, 0, 231, Short.MAX_VALUE)
                                            .addComponent(cbxMarca1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(49, 49, 49))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbxElaine, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(24, 24, 24))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcodgo, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcant, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxMedida1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxTipos1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxEnvase1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxMarca1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbxElaine, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel2);

        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 11)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/farmacia/icon/action_exit_close_remove_13915.png"))); // NOI18N
        jButton2.setText("SALIR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(888, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 833, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxMedida1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxMedida1ActionPerformed
        seleccionId();
    }//GEN-LAST:event_cbxMedida1ActionPerformed

    private void cbxTipos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTipos1ActionPerformed
        seleccionId();
    }//GEN-LAST:event_cbxTipos1ActionPerformed

    private void btnAgregarTipo4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarTipo4ActionPerformed
        AgregarTipo nuevotipo = new AgregarTipo(new javax.swing.JFrame(), true);
        nuevotipo.setVisible(true);
        lista = crud.listarTodoTipoProductos1();
        cbxTipos1.setModel(Formulario.listarComboTipoPro(lista));
    }//GEN-LAST:event_btnAgregarTipo4ActionPerformed

    private void btnAgregarMedida4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarMedida4ActionPerformed
        AgregarMedida agremed = new AgregarMedida(new javax.swing.JFrame(), true);
        agremed.setVisible(true);
        //        listam.clear();
        //        cbxMedida.removeAll();
        //        listam = crud.listarTodoMedidasProductos();//     listarTodoTipoProductos1();
        //        cbxMedida.setModel(Formulario.listarComboMedidaPro(listam));
        listarCombos(obj1);
    }//GEN-LAST:event_btnAgregarMedida4ActionPerformed

    private void btnAgreMarca4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgreMarca4ActionPerformed
        AgregarMarca agremar = new AgregarMarca(new javax.swing.JFrame(), true);
        agremar.setVisible(true);
        listama = crud.listarTodoMarcaProductos();//     listarTodoTipoProductos1();
        cbxMarca1.setModel(Formulario.listarComboMarcaPro(listama));
    }//GEN-LAST:event_btnAgreMarca4ActionPerformed

    private void btnAgreEnvase4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgreEnvase4ActionPerformed
        AgregarEnvase agreenv = new AgregarEnvase(new javax.swing.JFrame(), true);
        agreenv.setVisible(true);
        listae = crud.listarTodoEnvaseProductos();
        cbxEnvase1.setModel(Formulario.listarComboEnvasePro(listae));
    }//GEN-LAST:event_btnAgreEnvase4ActionPerformed

    private void cbxEnvase1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxEnvase1ActionPerformed
        seleccionId();
        // System.out.println(" " + listae.get(pos_envase).getId_envase() + " " + listae.get(pos_envase).getNombreEnvase());
    }//GEN-LAST:event_cbxEnvase1ActionPerformed

    private void cbxMarca1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxMarca1ActionPerformed
        seleccionId();
    }//GEN-LAST:event_cbxMarca1ActionPerformed

    private void cbxMedida3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxMedida3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxMedida3ActionPerformed

    private void cbxTipos3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTipos3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxTipos3ActionPerformed

    private void cbxEnvase3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxEnvase3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxEnvase3ActionPerformed

    private void cbxMarca3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxMarca3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxMarca3ActionPerformed

    private void cbxMedida4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxMedida4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxMedida4ActionPerformed

    private void cbxTipos4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTipos4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxTipos4ActionPerformed

    private void cbxEnvase4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxEnvase4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxEnvase4ActionPerformed

    private void cbxMarca4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxMarca4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxMarca4ActionPerformed

    private void cbxElaineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxElaineActionPerformed
        int valor = cbxElaine.getSelectedIndex();
        if (valor == 1) {
            HabilitarPanel3(true);
            HabilitarPanel4(false);
        } else if (valor == 2) {
            HabilitarPanel4(true);
            HabilitarPanel3(false);
        } else if (valor == 0) {
            Habilitar(false);
        }
    }//GEN-LAST:event_cbxElaineActionPerformed

    private void jLabel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jLabel2MousePressed

    private void jLabel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseDragged
        Point point = MouseInfo.getPointerInfo().getLocation();
        setLocation(point.x - x, point.y - y);
    }//GEN-LAST:event_jLabel2MouseDragged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void buscarProducto3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarProducto3ActionPerformed
        try {
            productosRegistrados pr = new productosRegistrados(null, rootPaneCheckingEnabled);
            pr.setVisible(rootPaneCheckingEnabled);
            
            if (pr.getDevuelvePro() != null) {
                if (obj1.getIdStock() != pr.getDevuelvePro().getIdStock()) {
                    objeto = pr.getDevuelvePro();
                    llenarJpanel3();
                    btnCalcular.setEnabled(true);
                } else {
                    JOptionPane.showMessageDialog(rootPane, "es el mismo producto, escoja otro");
                }
                
            } else {
                btnCalcular.setEnabled(false);
            }
            
        } catch (Exception e) {
            System.out.println("sms " + e.getMessage());
        }
    }//GEN-LAST:event_buscarProducto3ActionPerformed

    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed
        FrmCalcular fr = new FrmCalcular(null, rootPaneCheckingEnabled, obj1, objeto);
        fr.setVisible(rootPaneCheckingEnabled);
        
        if (fr.getvalorTotal() == null || fr.getvalorTotal() == -1) {
            btnGuardar.setEnabled(false);
        } else {
            resta = Integer.valueOf(txtcant.getText()) - fr.getvalorA();
            txtcant.setText(resta.toString());
            suma = Integer.valueOf(txtcant3.getText()) + fr.getvalorB();
            txtcant3.setText(suma.toString());
            btnGuardar.setEnabled(true);
        }

    }//GEN-LAST:event_btnCalcularActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        int seleccion = JOptionPane.showOptionDialog(null, "ESTA SEGURO DE CONVERTIR ESTE PRODUCTO",
                "Selector de opciones", JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE, null,// null para icono por defecto.
                new Object[]{"SI", "NO"}, "NO");
        System.out.println(seleccion);
        switch (seleccion) {
            case 0:
                String valor = "";
                valor = crud.iniciarConversion(obj1, objeto, resta, suma);
                if ("EXITO".equals(valor)) {
                    this.setVisible(false);
                }
                break;
            case 1:
                break;
            default:
                break;
        }

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCalcular4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcular4ActionPerformed
        if ("".equals(seleccionId())) {
            String valor = "";
            Productos p = new Productos();
            p.setNombre(producto4.getText());
            p.setDescripcion(descripcion4.getText());
            p.setFecha_registro(Fecha.FechaSql());
            p.setPeso(Double.parseDouble(obj1.getPeso().toString()));
            p.setId_tipo(id_tipo);
            p.setId_medidas(id_medida);
            p.setId_envase(id_envase);
            p.setId_marcas(id_marca);
            p.setId_usuario(Long.valueOf("3"));
            p.setIva(obj1.getIva());
            p.setCantidad_minima(Long.valueOf(obj1.getCantidad_minima()));
            valor = crud.insertarProductoNuevoConvertidor(p);
            if (!"".equals(valor)) {
                FrmCalcularConPrecio fg = new FrmCalcularConPrecio(null, rootPaneCheckingEnabled, obj1, valor);
                fg.setVisible(rootPaneCheckingEnabled);
                if (fg.getvalorTotal() == null || fg.getvalorTotal() == -1) {
                    btnGuardar.setEnabled(false);
                } else {
                    resta = Integer.valueOf(txtcant.getText()) - fg.getvalorA();
                    txtcant.setText(resta.toString());
                    suma = Integer.valueOf(txtcant3.getText()) + fg.getvalorB();
                    txtcant3.setText(suma.toString());
                    id_PrecioNuevo = Long.valueOf(fg.getIdPrecio());
                    btnGuardar.setEnabled(true);
                }
            }
        }

    }//GEN-LAST:event_btnCalcular4ActionPerformed
    private boolean validarBoton() {
        boolean bandera = false;
        
        return bandera;
    }
    private void btnGuardar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardar4ActionPerformed
        int seleccion = JOptionPane.showOptionDialog(null, "ESTA SEGURO DE CONVERTIR ESTE PRODUCTO",
                "Selector de opciones", JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE, null,// null para icono por defecto.
                new Object[]{"SI", "NO"}, "NO");
        System.out.println(seleccion);
        switch (seleccion) {
            case 0:
                String valor = "";
                valor = crud.iniciarConversionProductoNuevo(obj1, id_PrecioNuevo, resta, suma);
                if ("EXITO".equals(valor)) {
                    this.setVisible(false);
                }
                break;
            case 1:
                break;
            default:
                break;
        }
    }//GEN-LAST:event_btnGuardar4ActionPerformed

    private void cbxTipos5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTipos5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxTipos5ActionPerformed

    private void cbxEnvase5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxEnvase5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxEnvase5ActionPerformed

    private void cbxMarca5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxMarca5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxMarca5ActionPerformed

    private void cbxMedida5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxMedida5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxMedida5ActionPerformed

    private void btnAgregarMedida5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarMedida5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarMedida5ActionPerformed

    private void btnAgregarTipo5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarTipo5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarTipo5ActionPerformed

    private void btnAgreEnvase5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgreEnvase5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgreEnvase5ActionPerformed

    private void btnAgreMarca5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgreMarca5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgreMarca5ActionPerformed

    private void btnCalcular5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcular5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCalcular5ActionPerformed

    private void btnGuardar5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardar5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardar5ActionPerformed
    public void llenarJpanel3() {
        codigo3.setText(objeto.getId_productos().toString());
        producto3.setText(objeto.getNombreProductos());
        descripcion3.setText(objeto.getDescripcion());
        txtcant3.setText(objeto.getCantidadStock().toString());

//        lista = crud.listarTodoTipoProductos1();
//        listam = crud.listarTodoMedidasProductos();
//        listae = crud.listarTodoEnvaseProductos();
//        listama = crud.listarTodoMarcaProductos();
        cbxTipos3.setModel(Formulario.listarComboTipoPro(lista));
        cbxMedida3.setModel(Formulario.listarComboMedidaPro(listam));
        cbxEnvase3.setModel(Formulario.listarComboEnvasePro(listae));
        cbxMarca3.setModel(Formulario.listarComboMarcaPro(listama));
        
        str_tipo = crud.getNombreComboProducto(Long.valueOf("1"), objeto.getId_tipo());
        cbxTipos3.setSelectedItem(str_tipo);
        str_medidas = crud.getNombreComboProducto(Long.valueOf("2"), objeto.getId_medida());
        cbxMedida3.setSelectedItem(str_medidas);
        str_envase = crud.getNombreComboProducto(Long.valueOf("3"), objeto.getId_envase());
        cbxEnvase3.setSelectedItem(str_envase);
        str_marcas = crud.getNombreComboProducto(Long.valueOf("4"), objeto.getId_marca());
        cbxMarca3.setSelectedItem(str_marcas);
        //id_usuario.setText(obj.getId_usuario().toString());
        strIva = crud.getNombreComboProducto(Long.valueOf("5"), objeto.getId_productos());
        cbxEnvase3.setEnabled(false);
        cbxMarca3.setEnabled(false);
        cbxMedida3.setEnabled(false);
        cbxTipos3.setEnabled(false);
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
            java.util.logging.Logger.getLogger(covertidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(covertidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(covertidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(covertidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                covertidor dialog = new covertidor(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnAgreEnvase4;
    private javax.swing.JButton btnAgreEnvase5;
    private javax.swing.JButton btnAgreMarca4;
    private javax.swing.JButton btnAgreMarca5;
    private javax.swing.JButton btnAgregarMedida4;
    private javax.swing.JButton btnAgregarMedida5;
    private javax.swing.JButton btnAgregarTipo4;
    private javax.swing.JButton btnAgregarTipo5;
    private javax.swing.JButton btnCalcular;
    private javax.swing.JButton btnCalcular4;
    private javax.swing.JButton btnCalcular5;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnGuardar4;
    private javax.swing.JButton btnGuardar5;
    private javax.swing.JButton buscarProducto3;
    private javax.swing.JTextField cant4;
    private javax.swing.JTextField cant5;
    private javax.swing.JComboBox<String> cbxElaine;
    private javax.swing.JComboBox<String> cbxEnvase1;
    private javax.swing.JComboBox<String> cbxEnvase3;
    private javax.swing.JComboBox<String> cbxEnvase4;
    private javax.swing.JComboBox<String> cbxEnvase5;
    private javax.swing.JComboBox<String> cbxMarca1;
    private javax.swing.JComboBox<String> cbxMarca3;
    private javax.swing.JComboBox<String> cbxMarca4;
    private javax.swing.JComboBox<String> cbxMarca5;
    private javax.swing.JComboBox<String> cbxMedida1;
    private javax.swing.JComboBox<String> cbxMedida3;
    private javax.swing.JComboBox<String> cbxMedida4;
    private javax.swing.JComboBox<String> cbxMedida5;
    private javax.swing.JComboBox<String> cbxTipos1;
    private javax.swing.JComboBox<String> cbxTipos3;
    private javax.swing.JComboBox<String> cbxTipos4;
    private javax.swing.JComboBox<String> cbxTipos5;
    private javax.swing.JTextField codigo3;
    private javax.swing.JTextField descripcion3;
    private javax.swing.JTextField descripcion4;
    private javax.swing.JTextField descripcion5;
    private javax.swing.JButton jButton2;
    public static javax.swing.JLabel jLabel10;
    public static javax.swing.JLabel jLabel11;
    public static javax.swing.JLabel jLabel12;
    public static javax.swing.JLabel jLabel13;
    public static javax.swing.JLabel jLabel14;
    public static javax.swing.JLabel jLabel15;
    public static javax.swing.JLabel jLabel16;
    public static javax.swing.JLabel jLabel17;
    public static javax.swing.JLabel jLabel18;
    public static javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    public static javax.swing.JLabel jLabel20;
    public static javax.swing.JLabel jLabel21;
    public static javax.swing.JLabel jLabel22;
    public static javax.swing.JLabel jLabel23;
    public static javax.swing.JLabel jLabel24;
    public static javax.swing.JLabel jLabel25;
    public static javax.swing.JLabel jLabel26;
    public static javax.swing.JLabel jLabel27;
    public static javax.swing.JLabel jLabel28;
    public static javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    public static javax.swing.JLabel jLabel30;
    public static javax.swing.JLabel jLabel31;
    public static javax.swing.JLabel jLabel32;
    public static javax.swing.JLabel jLabel33;
    public static javax.swing.JLabel jLabel34;
    public static javax.swing.JLabel jLabel35;
    public static javax.swing.JLabel jLabel36;
    public static javax.swing.JLabel jLabel37;
    public static javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    public static javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField producto3;
    private javax.swing.JTextField producto4;
    private javax.swing.JTextField producto5;
    private javax.swing.JTextField txtProducto;
    private javax.swing.JTextField txtcant;
    private javax.swing.JTextField txtcant3;
    private javax.swing.JTextField txtcodgo;
    private javax.swing.JTextField txtdescripcion;
    // End of variables declaration//GEN-END:variables
}
