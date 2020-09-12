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
            id_envase = listae.get(pos).getId_presentaciones();
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
        cbxEnvase1 = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        cbxMarca1 = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        txtcodgo = new javax.swing.JTextField();
        txtProducto = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        txtcant = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtdescripcion = new javax.swing.JTextField();
        cbxMedida1 = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbxTipos1 = new javax.swing.JComboBox<>();
        cbxElaine = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
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
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

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

        cbxEnvase1.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        cbxEnvase1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxEnvase1ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel9.setText("MARCA/LABORATORIO:");

        cbxMarca1.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        cbxMarca1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxMarca1ActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel12.setText("PRODUCTO:");

        txtcodgo.setEditable(false);
        txtcodgo.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N

        txtProducto.setEditable(false);
        txtProducto.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N

        jLabel30.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel30.setText("CANTIDAD:");

        txtcant.setEditable(false);
        txtcant.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel13.setText("CODIGO:");

        jLabel11.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel11.setText("UNIDAD DE MEDIDA:");

        txtdescripcion.setEditable(false);
        txtdescripcion.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N

        cbxMedida1.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        cbxMedida1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxMedida1ActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel14.setText("DESCRIPCION:");

        jLabel16.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel16.setText("TIPO:");

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel4.setText("CONVERTIR A:");

        cbxTipos1.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        cbxTipos1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxTipos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTipos1ActionPerformed(evt);
            }
        });

        cbxElaine.setEditable(true);
        cbxElaine.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        cbxElaine.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TODOS", "ELEGIR PRODUCTO", "NUEVO PRODUCTO" }));
        cbxElaine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxElaineActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel18.setText("PRESENTACION:");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "CONVERTIR A EXISTENTE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Ubuntu", 1, 14))); // NOI18N

        producto3.setEditable(false);
        producto3.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N

        jLabel15.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel15.setText("UNIDAD DE MEDIDA:");

        cbxMedida3.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        cbxMedida3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxMedida3ActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel17.setText("TIPO:");

        cbxTipos3.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        cbxTipos3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxTipos3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTipos3ActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel19.setText("PRESENTACION:");

        cbxEnvase3.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        cbxEnvase3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxEnvase3ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel10.setText("MARCA/LABORATORIO:");

        cbxMarca3.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        cbxMarca3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxMarca3ActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel20.setText("PRODUCTO:");

        codigo3.setEditable(false);
        codigo3.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N

        jLabel21.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel21.setText("CODIGO:");

        descripcion3.setEditable(false);
        descripcion3.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N

        jLabel22.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel22.setText("DESCRIPCION:");

        buscarProducto3.setFont(new java.awt.Font("Times New Roman", 1, 11)); // NOI18N
        buscarProducto3.setText("BUSCAR PRODUCTO");
        buscarProducto3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarProducto3ActionPerformed(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel31.setText("CANTIDAD:");

        txtcant3.setEditable(false);
        txtcant3.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N

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
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(241, 241, 241)
                                .addComponent(buscarProducto3)
                                .addGap(18, 18, 18)
                                .addComponent(btnCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(codigo3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(producto3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(descripcion3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel31)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtcant3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbxMedida3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxTipos3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbxEnvase3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxMarca3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscarProducto3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(producto3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel20)
                        .addComponent(codigo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel21)
                        .addComponent(jLabel22))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(descripcion3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel31)
                            .addComponent(txtcant3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(cbxMedida3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxTipos3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxEnvase3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(cbxMarca3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "CONVERTIR A NUEVO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Ubuntu", 1, 14))); // NOI18N

        cbxTipos4.setEditable(true);
        cbxTipos4.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        cbxTipos4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxTipos4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTipos4ActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel24.setText("PRESENTACION:");

        cbxEnvase4.setEditable(true);
        cbxEnvase4.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        cbxEnvase4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxEnvase4ActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel25.setText("MARCA/LABORATORIO:");

        cbxMarca4.setEditable(true);
        cbxMarca4.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        cbxMarca4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxMarca4ActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel26.setText("PRODUCTO:");

        descripcion4.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        descripcion4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                descripcion4FocusLost(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel28.setText("DESCRIPCION:");

        producto4.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        producto4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                producto4FocusLost(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel29.setText("UNIDAD DE MEDIDA:");

        cbxMedida4.setEditable(true);
        cbxMedida4.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        cbxMedida4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxMedida4ActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel23.setText("TIPO:");

        jLabel32.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel32.setText("CANTIDAD:");

        cant4.setEditable(false);
        cant4.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        cant4.setText("0");

        btnAgregarMedida4.setFont(new java.awt.Font("Ubuntu", 1, 10)); // NOI18N
        btnAgregarMedida4.setText("AGREGAR");
        btnAgregarMedida4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarMedida4ActionPerformed(evt);
            }
        });

        btnAgregarTipo4.setFont(new java.awt.Font("Ubuntu", 1, 10)); // NOI18N
        btnAgregarTipo4.setText("AGREGAR");
        btnAgregarTipo4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarTipo4ActionPerformed(evt);
            }
        });

        btnAgreEnvase4.setFont(new java.awt.Font("Ubuntu", 1, 10)); // NOI18N
        btnAgreEnvase4.setText("AGREGAR");
        btnAgreEnvase4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgreEnvase4ActionPerformed(evt);
            }
        });

        btnAgreMarca4.setFont(new java.awt.Font("Ubuntu", 1, 10)); // NOI18N
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
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(93, 93, 93)
                                .addComponent(jLabel26)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(producto4, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(jLabel28))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel23)
                                    .addComponent(jLabel29))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbxMedida4, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxTipos4, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnAgregarMedida4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnAgregarTipo4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel24)
                                    .addComponent(jLabel25))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbxEnvase4, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxMarca4, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnAgreEnvase4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnAgreMarca4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(descripcion4, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel32)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cant4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(338, 338, 338)
                        .addComponent(btnCalcular4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnGuardar4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCalcular4, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(btnGuardar4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(producto4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(descripcion4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cant4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 11)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/farmacia/icon/action_exit_close_remove_13915.png"))); // NOI18N
        jButton2.setText("SALIR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel11)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbxMedida1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxTipos1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(51, 51, 51)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbxEnvase1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxMarca1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(cbxElaine, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(95, 95, 95))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(435, 435, 435))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtcodgo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtdescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtcant, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcodgo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcant, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cbxMedida1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbxTipos1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxEnvase1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxMarca1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxElaine, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        cbxTipos4.setModel(Formulario.listarComboTipoPro(lista));
    }//GEN-LAST:event_btnAgregarTipo4ActionPerformed

    private void btnAgregarMedida4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarMedida4ActionPerformed
        AgregarMedida agremed = new AgregarMedida(new javax.swing.JFrame(), true);
        agremed.setVisible(true);
                listam.clear();
                listam = crud.listarTodoMedidasProductos();//     listarTodoTipoProductos1();
                cbxMedida4.setModel(Formulario.listarComboMedidaPro(listam));
        listarCombos(obj1);
    }//GEN-LAST:event_btnAgregarMedida4ActionPerformed

    private void btnAgreMarca4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgreMarca4ActionPerformed
        AgregarMarca agremar = new AgregarMarca(new javax.swing.JFrame(), true);
        agremar.setVisible(true);
        listama = crud.listarTodoMarcaProductos();//     listarTodoTipoProductos1();
        cbxMarca4.setModel(Formulario.listarComboMarcaPro(listama));
    }//GEN-LAST:event_btnAgreMarca4ActionPerformed

    private void btnAgreEnvase4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgreEnvase4ActionPerformed
        AgregarEnvase agreenv = new AgregarEnvase(new javax.swing.JFrame(), true);
        agreenv.setVisible(true);
        listae = crud.listarTodoEnvaseProductos();
        cbxEnvase4.setModel(Formulario.listarComboEnvasePro(listae));
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
       seleccionId();
    }//GEN-LAST:event_cbxMedida4ActionPerformed

    private void cbxTipos4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTipos4ActionPerformed
        seleccionId();
    }//GEN-LAST:event_cbxTipos4ActionPerformed

    private void cbxEnvase4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxEnvase4ActionPerformed
       seleccionId();
    }//GEN-LAST:event_cbxEnvase4ActionPerformed

    private void cbxMarca4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxMarca4ActionPerformed
        seleccionId();
    }//GEN-LAST:event_cbxMarca4ActionPerformed

    private void cbxElaineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxElaineActionPerformed
        int valor = cbxElaine.getSelectedIndex();
        if (valor == 1) {
            HabilitarPanel3(true);
            HabilitarPanel4(false);
        } else if (valor == 2) {
            HabilitarPanel4(true);
            HabilitarPanel3(false);
            listarCombosJpanel4(obj1);
        } else if (valor == 0) {
            Habilitar(false);
        }
    }//GEN-LAST:event_cbxElaineActionPerformed
     public void listarCombosJpanel4(listarJoinProductosCompras obj) {
        lista.clear();
        listam.clear();
        listae.clear();
        listama.clear();
        
        lista = crud.listarTodoTipoProductos1();
        listam = crud.listarTodoMedidasProductos();
        listae = crud.listarTodoEnvaseProductos();
        listama = crud.listarTodoMarcaProductos();
        
        cbxTipos4.setModel(Formulario.listarComboTipoPro(lista));
        cbxMedida4.setModel(Formulario.listarComboMedidaPro(listam));
        cbxEnvase4.setModel(Formulario.listarComboEnvasePro(listae));
        cbxMarca4.setModel(Formulario.listarComboMarcaPro(listama));
        
        str_tipo = crud.getNombreComboProducto(Long.valueOf("1"), obj.getId_tipo());
        cbxTipos4.setSelectedItem(str_tipo);
        str_medidas = crud.getNombreComboProducto(Long.valueOf("2"), obj.getId_medida());
        cbxMedida4.setSelectedItem(str_medidas);
        str_envase = crud.getNombreComboProducto(Long.valueOf("3"), obj.getId_envase());
        cbxEnvase4.setSelectedItem(str_envase);
        str_marcas = crud.getNombreComboProducto(Long.valueOf("4"), obj.getId_marca());
        cbxMarca4.setSelectedItem(str_marcas);
        //id_usuario.setText(obj.getId_usuario().toString());
        strIva = crud.getNombreComboProducto(Long.valueOf("5"), obj.getId_productos());
        
    }
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
                    btnGuardar4.setEnabled(false);
                } else {
                    resta = Integer.valueOf(txtcant.getText()) - Integer.valueOf(fg.getvalorA());
                    txtcant.setText(resta.toString());
                    suma = Integer.valueOf(cant4.getText()) + Integer.valueOf(fg.getvalorB());
                    cant4.setText(suma.toString());
                    id_PrecioNuevo = Long.valueOf(fg.getIdPrecio());
                    btnGuardar4.setEnabled(true);
                }
            }
        }else{
        JOptionPane.showMessageDialog(rootPane, "complete los campos po favo");
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

    private void producto4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_producto4FocusLost
         producto4.setText(producto4.getText().toUpperCase());
    }//GEN-LAST:event_producto4FocusLost

    private void descripcion4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_descripcion4FocusLost
         descripcion4.setText(descripcion4.getText().toUpperCase());
    }//GEN-LAST:event_descripcion4FocusLost
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
    private javax.swing.JButton btnAgreMarca4;
    private javax.swing.JButton btnAgregarMedida4;
    private javax.swing.JButton btnAgregarTipo4;
    private javax.swing.JButton btnCalcular;
    private javax.swing.JButton btnCalcular4;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnGuardar4;
    private javax.swing.JButton buscarProducto3;
    private javax.swing.JTextField cant4;
    private javax.swing.JComboBox<String> cbxElaine;
    private javax.swing.JComboBox<String> cbxEnvase1;
    private javax.swing.JComboBox<String> cbxEnvase3;
    private javax.swing.JComboBox<String> cbxEnvase4;
    private javax.swing.JComboBox<String> cbxMarca1;
    private javax.swing.JComboBox<String> cbxMarca3;
    private javax.swing.JComboBox<String> cbxMarca4;
    private javax.swing.JComboBox<String> cbxMedida1;
    private javax.swing.JComboBox<String> cbxMedida3;
    private javax.swing.JComboBox<String> cbxMedida4;
    private javax.swing.JComboBox<String> cbxTipos1;
    private javax.swing.JComboBox<String> cbxTipos3;
    private javax.swing.JComboBox<String> cbxTipos4;
    private javax.swing.JTextField codigo3;
    private javax.swing.JTextField descripcion3;
    private javax.swing.JTextField descripcion4;
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
    public static javax.swing.JLabel jLabel28;
    public static javax.swing.JLabel jLabel29;
    public static javax.swing.JLabel jLabel30;
    public static javax.swing.JLabel jLabel31;
    public static javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    public static javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField producto3;
    private javax.swing.JTextField producto4;
    private javax.swing.JTextField txtProducto;
    private javax.swing.JTextField txtcant;
    private javax.swing.JTextField txtcant3;
    private javax.swing.JTextField txtcodgo;
    private javax.swing.JTextField txtdescripcion;
    // End of variables declaration//GEN-END:variables
}
