package com.farmacia.views.pedidos;

import com.farmacia.conponentes.Tablas;
import com.farmacia.dao.CRUD;
import com.farmacia.entities1.CabeceraNotaPedido;
import com.farmacia.filtros.filtrosProductos;
import com.farmacia.join_entidades.ListarJoinProveedorNotaPedido;
import com.farmacia.join_entidades.joinProductoDetallesFaltantes;
import com.farmacia.join_entidades.listarJoinProductosNotaPedidos;
import com.farmacia.validaciones.ComponentesFaltantes;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class NotePedidos extends javax.swing.JDialog {

    int x, y;
    CRUD crud = new CRUD();
    filtrosProductos fil = new filtrosProductos();
    joinProductoDetallesFaltantes objeto = null;
    ListarJoinProveedorNotaPedido proveedorC = null;
    static ArrayList<listarJoinProductosNotaPedidos> listar = null;
    ArrayList<joinProductoDetallesFaltantes> lista = crud.listarFaltantesDetalles(1);
    ArrayList<joinProductoDetallesFaltantes> lista1 = new ArrayList<joinProductoDetallesFaltantes>();

    public NotePedidos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);

        setUndecorated(true);
        initComponents();
//        PanelSec.setEnabled(false);
//        filtro.setEnabled(false);
//        t_Nota_faltantes.setEnabled(false);
//        tbaListaFaltantes.setEnabled(false);
//        btnBuscar.setEnabled(false);
//        btnGuardar.setEnabled(false);
//        btnNuevo.setEnabled(false);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        TotalDescuento2();
        TotalPro();
        TotalIVA2();
        Tablas.cargarJoinProductoDetallesFaltantes(t_Nota_faltantes, lista);

        //FECHA DEL SISTEMA
        java.util.Date sistFecha = new java.util.Date();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
        txtFecha.setText(formato.format(sistFecha));

        //HORA DEL SISTEMA
        Timer tiempo = new Timer(100, new NotePedidos.horas());
        tiempo.start();

    }

    class horas implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            java.util.Date sistHora = new java.util.Date();
            String pmAm = "HH:mm:ss";
            SimpleDateFormat format = new SimpleDateFormat(pmAm);
            Calendar hoy = Calendar.getInstance();
            txtHora.setText(String.format(format.format(sistHora), hoy));

        }
    }

    public static double redondearDecimales(double valorInicial, int numeroDecimales) {
        double parteEntera, resultado;
        resultado = valorInicial;
        parteEntera = Math.floor(resultado);
        resultado = (resultado - parteEntera) * Math.pow(10, numeroDecimales);
        resultado = Math.round(resultado);
        resultado = (resultado / Math.pow(10, numeroDecimales)) + parteEntera;
        return resultado;
    }

    public void TotalPro() {
        BigDecimal TotalPro = new BigDecimal("0.00");
        for (int i = 0; i < tbaListaFaltantes.getRowCount(); i++) {
            Integer Cant = lista1.get(i).getCantidad();
            BigDecimal Cantidad = new BigDecimal(Cant);
//            System.out.println("cantidad " + Cantidad);
            BigDecimal Precio = lista1.get(i).getPrecios();
//            System.out.println("Precio " + Precio);
            BigDecimal Subtotal = Cantidad.multiply(Precio);
////            System.out.println("Subtotal " + Subtotal);
            BigDecimal PorcentajeDesc = lista1.get(i).getPorcentaje_descuento();
            BigDecimal ValorDes = Subtotal.multiply(PorcentajeDesc).divide(new BigDecimal("100"));
//            System.out.println("Descuento " + ValorDes);
            if (lista1.get(i).getIva().equals("NO")) {
                TotalPro = TotalPro.add(Subtotal).subtract(ValorDes);
//                System.out.println("Total " + TotalPro);
            }
            if (!"NO".equals(lista1.get(i).getIva())) {
                String ivaget = lista1.get(i).getIva();
                BigDecimal IVA = new BigDecimal(ivaget);
                BigDecimal ValorIVA = IVA.multiply(Subtotal);
                TotalPro = TotalPro.add(Subtotal).subtract(ValorDes).add(ValorIVA);
            }
        }
        TotalPro = TotalPro.setScale(2, BigDecimal.ROUND_HALF_UP);
        txtTotal.setText(TotalPro.toString());
    }

    public void TotalIVA2() {
        BigDecimal TotalIva = new BigDecimal("0.00");

        for (int i = 0; i < tbaListaFaltantes.getRowCount(); i++) {
            BigDecimal ValorIva = new BigDecimal("0.00");
            BigDecimal Precio = lista1.get(i).getPrecios();
            Integer Cant = lista1.get(i).getCantidad();
            BigDecimal Cantidad = new BigDecimal(Cant);
//            System.out.println("CAntidad " + Cantidad);
//            System.out.println("Precio " + Precio);

            BigDecimal Subtotal = Cantidad.multiply(Precio);

            if (!"NO".equals(lista1.get(i).getIva())) {
                String ivaget = lista1.get(i).getIva();
                System.out.println("iva get " + ivaget);
                BigDecimal IVA = new BigDecimal(ivaget);
                ValorIva = Subtotal.multiply(IVA);
                TotalIva = TotalIva.add(ValorIva);
            }
        }
        TotalIva = TotalIva.setScale(2, BigDecimal.ROUND_HALF_UP);
        txtIva.setText(TotalIva.toString());
    }

    public void TotalDescuento2() {
        BigDecimal TotalDesc = new BigDecimal("0.00");
        for (int i = 0; i < tbaListaFaltantes.getRowCount(); i++) {
            BigDecimal Precio = lista1.get(i).getPrecios();
//            System.out.println("precio " + Precio);
            BigDecimal PorcDesc = lista1.get(i).getPorcentaje_descuento();
//            System.out.println("porcent " + PorcDesc);
            Integer Cant = lista1.get(i).getCantidad();
            BigDecimal Cantidad = new BigDecimal(Cant);
            BigDecimal Subtotal = Cantidad.multiply(Precio);
//            System.out.println("Subtotal " + Subtotal);
            BigDecimal ValorDesc = Subtotal.multiply(PorcDesc).divide(new BigDecimal("100"));

            TotalDesc = TotalDesc.add(ValorDesc);
//            System.out.println("TotalDEsc " + TotalDesc);
        }
        TotalDesc = TotalDesc.setScale(2, BigDecimal.ROUND_HALF_UP);
        txtDescuento.setText(TotalDesc.toString());
    }

    public static String FechaActual() {
        Date fecha = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("YYYY/MM/dd");
        return formatoFecha.format(fecha);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtDireccion1 = new javax.swing.JTextField();
        txtCorreo1 = new javax.swing.JTextField();
        txtRuc1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtNombre1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtRepresentante = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtTipo1 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtCodigoProveedor = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtTelefono1 = new javax.swing.JTextField();
        btnProveedor = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cbxFormaP = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        txtHora = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        cbxPlazo = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        PanelSec = new javax.swing.JPanel();
        filtro = new javax.swing.JTextField();
        tipofiltro = new javax.swing.JComboBox<>();
        btnBuscar = new javax.swing.JButton();
        tblProduc = new javax.swing.JScrollPane();
        t_Nota_faltantes = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbaListaFaltantes = new javax.swing.JTable();
        btnGuardar = new javax.swing.JButton();
        btnSalir2 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtIva = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtDescuento = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        btnNuevo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel5MouseDragged(evt);
            }
        });
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel5MousePressed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setText("Direccion :");

        jLabel5.setText("Correo :");

        jLabel2.setText("Nombre :");

        jLabel6.setText("RUC :");

        jLabel11.setText("Representante");

        txtRepresentante.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRepresentanteKeyReleased(evt);
            }
        });

        jLabel12.setText("Tipo:");

        jLabel13.setText("Codigo:");

        txtCodigoProveedor.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setText("Telefono :");

        btnProveedor.setText("Proveedor");
        btnProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProveedorActionPerformed(evt);
            }
        });

        jButton1.setText("Mantenimiento");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTelefono1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtRepresentante, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNombre1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtCodigoProveedor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnProveedor)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtRuc1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCorreo1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTipo1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDireccion1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtRuc1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txtCorreo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(txtCodigoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtDireccion1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(44, 44, 44))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRepresentante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTelefono1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTipo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel9.setText("Fecha :");

        txtFecha.setEditable(false);

        jLabel10.setText("Plazo:");

        cbxFormaP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Contado", "Credito" }));

        jLabel15.setText("Hora:");

        txtHora.setEditable(false);

        jLabel16.setText("Forma de Pago");

        cbxPlazo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Inmediato", "3 Meses", "6 Meses", "9 Meses", "12 Meses", "24 Meses" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtHora, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(cbxPlazo, javax.swing.GroupLayout.Alignment.TRAILING, 0, 115, Short.MAX_VALUE)))
                .addGap(12, 12, 12))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbxFormaP, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxPlazo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbxFormaP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(0, 189, 189));
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

        jLabel7.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel7.setForeground(java.awt.Color.white);
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Nota de Pedido ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(365, 365, 365))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        filtro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtroActionPerformed(evt);
            }
        });
        filtro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                filtroKeyReleased(evt);
            }
        });

        tipofiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CODIGO", "NOMBRE", "TIPO", "MEDIDA", "ENVASE", "MARCA" }));

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        t_Nota_faltantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8 "
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        t_Nota_faltantes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_Nota_faltantesMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                t_Nota_faltantesMousePressed(evt);
            }
        });
        tblProduc.setViewportView(t_Nota_faltantes);

        javax.swing.GroupLayout PanelSecLayout = new javax.swing.GroupLayout(PanelSec);
        PanelSec.setLayout(PanelSecLayout);
        PanelSecLayout.setHorizontalGroup(
            PanelSecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelSecLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tipofiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(filtro, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBuscar)
                .addContainerGap(438, Short.MAX_VALUE))
            .addComponent(tblProduc, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        PanelSecLayout.setVerticalGroup(
            PanelSecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelSecLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(PanelSecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tipofiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filtro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tblProduc, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tbaListaFaltantes.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.gray, null));
        tbaListaFaltantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "MARCA", "TIPO", "PRODUCTO", "ENVASE", "MEDIDA", "CANTIDAD", "PRECIO", "DESCUENTO", "IVA", "TOTAL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, true, true, true, false, true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbaListaFaltantes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbaListaFaltantesMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbaListaFaltantes);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelSec, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 95, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelSec, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnSalir2.setText("SALIR");
        btnSalir2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir2ActionPerformed(evt);
            }
        });

        jLabel14.setText("TOTAL");

        txtTotal.setEditable(false);
        txtTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel17.setText("IVA");

        txtIva.setEditable(false);
        txtIva.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel18.setText("DESCUENTO");

        txtDescuento.setEditable(false);
        txtDescuento.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("$");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("$");

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("$");

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnNuevo)
                        .addGap(18, 18, 18)
                        .addComponent(btnSalir2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtIva, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar)
                    .addComponent(btnSalir2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProveedorActionPerformed
        Consulta_proveedor_Nota Prov = new Consulta_proveedor_Nota(new javax.swing.JFrame(), true);
        Prov.setVisible(true);

        proveedorC = Prov.getProveedor();
        if (proveedorC != null) {
            PanelSec.setEnabled(true);
            filtro.setEnabled(true);
            t_Nota_faltantes.setEnabled(true);
            tbaListaFaltantes.setEnabled(true);
            btnBuscar.setEnabled(true);
            btnGuardar.setEnabled(true);
            //
            txtCodigoProveedor.setText(proveedorC.getId_proveedor().toString());
            txtRuc1.setText(proveedorC.getCedula_ruc());
            txtNombre1.setText(proveedorC.getEntidad());
            txtCorreo1.setText(proveedorC.getMail());
            txtRepresentante.setText(proveedorC.getRepresentante());
            txtTipo1.setText(proveedorC.getClase());
            txtTelefono1.setText(proveedorC.getTelefono());
            txtDireccion1.setText(proveedorC.getDireccion());

        } else {
            JOptionPane.showMessageDialog(null, " Elija un Proveedor  ");
        }

    }//GEN-LAST:event_btnProveedorActionPerformed

    private void txtRepresentanteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRepresentanteKeyReleased


    }//GEN-LAST:event_txtRepresentanteKeyReleased

    private void t_Nota_faltantesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_Nota_faltantesMouseClicked


    }//GEN-LAST:event_t_Nota_faltantesMouseClicked


    private void btnSalir2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir2ActionPerformed
        int r = JOptionPane.showConfirmDialog(null, "¿Desea Salir?", "", JOptionPane.YES_NO_OPTION);

        if (r == JOptionPane.YES_OPTION) {
            setVisible(false);

        } else {

        }
    }//GEN-LAST:event_btnSalir2ActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (!"0.0".equals(txtTotal.getText())) {

            ArrayList<String> queryL = new ArrayList<String>();
            ArrayList<String> queryL1 = new ArrayList<String>();
            String id_cab = "";
            String cad = "";
            String cad1 = "";
            CabeceraNotaPedido cn = new CabeceraNotaPedido();
            cn.setId_proveedor(Long.parseLong(txtCodigoProveedor.getText()));
            cn.setId_usuario(Long.valueOf("2"));
            cn.setFecha_creacion(txtFecha.getText() + " " + txtHora.getText());
            cn.setPlazo(cbxPlazo.getSelectedItem().toString());
            cn.setForma_pago(cbxFormaP.getSelectedItem().toString());

            String iva1 = txtIva.getText();
            BigDecimal IVA = new BigDecimal(iva1);
            cn.setIva(IVA);//
            String descuento1 = txtDescuento.getText();
            BigDecimal DESCUENTO = new BigDecimal(descuento1);
            cn.setDescuento(DESCUENTO);//
            String total1 = txtTotal.getText();
            BigDecimal TOTAL = new BigDecimal(total1);
            cn.setTotal(TOTAL);//
            id_cab = crud.insertarCabeceraNotaPedido(cn);

            String query = "SELECT `id_cabecera_nota_pedidos` FROM `cabecera_nota_pedidos` WHERE `id_proveedor`=" + txtCodigoProveedor.getText() + " AND `fecha_creacion`=" + "'" + txtFecha.getText() + " " + txtHora.getText() + "'" + " AND `total`=" + txtTotal.getText();
            id_cab = crud.buscarIDCabeceraNotaPedido(query);

            for (int i = 0; i < tbaListaFaltantes.getRowCount(); i++) {
                cad1 = "INSERT INTO detalle_nota_pedidos"
                        + "(`id_cabecera_nota_pedidos`,`id_precio`,`cantidad`,`precio`,`descuento`,`total`,`iva`,`bono`)"
                        + "VALUES(" + id_cab + "," + lista.get(i).getId_precios() + "," + tbaListaFaltantes.getValueAt(i, 7).toString() + "," + tbaListaFaltantes.getValueAt(i, 8).toString() + "," + tbaListaFaltantes.getValueAt(i, 9).toString() + "," + tbaListaFaltantes.getValueAt(i, 11).toString() + "," + tbaListaFaltantes.getValueAt(i, 10).toString() + "," + tbaListaFaltantes.getValueAt(i, 6) + ")";
                queryL1.add(cad1);
                System.out.println(cad1);
            }
            crud.InsertarDetallesNotaPedidos(queryL1);
            queryL1.clear();

            JOptionPane.showMessageDialog(null, " Guardado con Exito ");
            btnNuevo.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(rootPane, "INGRESE DATOS");
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void t_Nota_faltantesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_Nota_faltantesMousePressed
        int i = 0;
        String msg = null;
        try {
            if (evt.getClickCount() == 2) {
                i = t_Nota_faltantes.getSelectedRow();
                objeto = devuelveObjeto(lista.get(i).getId_precios().toString(), lista);
//                objeto = devuelveObjeto(t_Nota_faltantes.getValueAt(i, 0).toString(), lista);
                if (objeto != null) {
                    AgregarProductoNotaPedido np = new AgregarProductoNotaPedido(new javax.swing.JFrame(), true, objeto);
                    np.setVisible(true);
//                    msg = ComponentesFaltantes.validarListaFaltantes(tbaListaFaltantes, objeto.getId_producto().toString());
                    msg = ComponentesFaltantes.validarListaFaltantes(tbaListaFaltantes, objeto.getId_producto().toString());

                    if (msg == null) {
                        Tablas.cargarJoinProductoDetallesFaltantes(t_Nota_faltantes, lista);
                        if (np.getObjf().getCantidad() > 0) {
                            int suma = Integer.parseInt((String) t_Nota_faltantes.getValueAt(i, 6)) + np.getObjf().getCantidad();
                            getPosicion2(objeto.getId_producto(), suma);
                            lista1.add(np.getObjf());
                            Tablas.cargarJoinProductoDetallesFaltantes(t_Nota_faltantes, lista);
                            Tablas.cargarJoinProductoIngresoNotas(tbaListaFaltantes, lista1);

                            TotalDescuento2();
                            TotalPro();
                            TotalIVA2();
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, msg);
                    }

                }
            }
        } catch (Exception e) {
            Logger.getLogger(NotePedidos.class.getName()).log(Level.SEVERE, null, e);
        }

    }//GEN-LAST:event_t_Nota_faltantesMousePressed

    private void getPosicion(Long id, int valor) {
        for (int i = 0; i < lista.size(); i++) {
            if (id == lista.get(i).getId_precios()) {
                lista.get(i).setCantidad(valor);
            }
        }

    }

    private void getPosicion2(Long id, int valor) {
        for (int i = 0; i < lista.size(); i++) {
            if (id == lista.get(i).getId_producto()) {
                lista.get(i).setCantidad(valor);
            }
        }

    }
    private void filtroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtroActionPerformed

    }//GEN-LAST:event_filtroActionPerformed

    private void filtroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filtroKeyReleased

    }//GEN-LAST:event_filtroKeyReleased

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String f = filtro.getText().toUpperCase();
        String query = "";
        int pos = tipofiltro.getSelectedIndex();
        if ("".equals(f)) {
            query = fil.comboProductoTodoNotaPedido();
        }
        if (pos == 0) {
            if ("".equals(f)) {
                Tablas.cargarJoinProductoDetallesFaltantes(t_Nota_faltantes, lista);
            } else {
                query = fil.comboProductoCodigoNotaPedido() + f;
            }
        }
        if (pos == 1) {
            query = fil.comboProductoNombreNotaPedido() + f + "%'";
        }
        if (pos == 2) {
            query = fil.comboProductoTipoNotaPedido() + f + "%'";
        }
        if (pos == 3) {
            query = fil.comboProductoMedidaNotaPedido() + f + "%'";
        }
        if (pos == 4) {
            query = fil.comboProductoEnvaseNotaPedido() + f + "%'";
        }
        if (pos == 5) {
            query = fil.comboProductoMarcaNotaPedido() + f + "%'";
        }
        listar = crud.filtroBusquedaProductoNotaPedido(query);

        Tablas.cargarFiltroProductosNota(t_Nota_faltantes, listar);
        query = "";
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void tbaListaFaltantesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbaListaFaltantesMousePressed
//        Double iva = 0.00;
        BigDecimal iva = new BigDecimal("0.00");
//        Double descuento = 0.00;
        BigDecimal descuento = new BigDecimal("0.00");
//        Double total = 0.00;
        BigDecimal total = new BigDecimal("0.00");

        try {
            if (evt.getClickCount() == 2) {
                int r = JOptionPane.showConfirmDialog(null, "¿Desea eliminar este producto de la lista?", "", JOptionPane.YES_NO_OPTION);
                if (r == JOptionPane.YES_OPTION) {
                    int i = tbaListaFaltantes.getSelectedRow();

                    objeto = devuelveObjeto2(tbaListaFaltantes.getValueAt(i, 0).toString(), lista);

                    int resta = (Integer.valueOf(objeto.getCantidad()) - Integer.parseInt((String) tbaListaFaltantes.getValueAt(i, 6)));
                    System.out.println("eliminar************");
                    getPosicion2(objeto.getId_producto(), resta);
                    System.out.println("ddfdf" + objeto.getId_producto());

                    iva = (BigDecimal) tbaListaFaltantes.getValueAt(i, 9);
                    System.out.println(" iva****" + iva);
                    descuento = (BigDecimal) tbaListaFaltantes.getValueAt(i, 8);
                    total = (BigDecimal) tbaListaFaltantes.getValueAt(i, 10);

                    String iva1 = txtIva.getText();
                    System.out.println("iva " + iva1);
                    BigDecimal IVA = new BigDecimal(iva1);
                    String descuento1 = txtDescuento.getText();
                    System.out.println("descuento" + descuento1);
                    BigDecimal DESCUENTO = new BigDecimal(descuento1);
                    String total1 = txtTotal.getText();
                    System.out.println("total" + total1);
                    BigDecimal TOTAL = new BigDecimal(total1);
                    iva = IVA.subtract(iva);
//                    iva = redondearDecimales(iva, 2);
                    descuento = DESCUENTO.subtract(descuento);
//                    descuento = redondearDecimales(descuento, 2);
                    total = TOTAL.subtract(total);
//                    total = redondearDecimales(total, 2);

                    txtIva.setText(iva.toString());
                    txtDescuento.setText(descuento.toString());
                    txtTotal.setText(total.toString());

                    lista1.remove(i);

                    Tablas.cargarJoinProductoDetallesFaltantes(tbaListaFaltantes, lista1);
                    Tablas.cargarJoinProductoIngresoNotas(tbaListaFaltantes, lista1);
                    Tablas.cargarJoinProductoDetallesFaltantes(t_Nota_faltantes, lista);
                    TotalPro();
                    TotalIVA2();
                    TotalDescuento2();

                } else {

                }

            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_tbaListaFaltantesMousePressed

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        Point point = MouseInfo.getPointerInfo().getLocation();
        setLocation(point.x - x, point.y - y);
    }//GEN-LAST:event_formMouseDragged

    private void jPanel5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel5MousePressed

    private void jPanel3MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseDragged
        Point point = MouseInfo.getPointerInfo().getLocation();
        setLocation(point.x - x, point.y - y);
    }//GEN-LAST:event_jPanel3MouseDragged

    private void jPanel5MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseDragged
        Point point = MouseInfo.getPointerInfo().getLocation();
        setLocation(point.x - x, point.y - y);
    }//GEN-LAST:event_jPanel5MouseDragged

    private void jPanel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jPanel3MousePressed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        Reiniciar();
        btnBuscar.setEnabled(false);
        btnGuardar.setEnabled(false);
        t_Nota_faltantes.setEnabled(false);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        MantenimientoNotaPedidos Man = new MantenimientoNotaPedidos(new javax.swing.JFrame(), true);
        Man.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed
    public joinProductoDetallesFaltantes devuelveObjeto(String datos, ArrayList<joinProductoDetallesFaltantes> listarobj) {
        joinProductoDetallesFaltantes objeto1 = null;
        for (int i = 0; i < listarobj.size(); i++) {
            if (datos.equals(listarobj.get(i).getId_precios().toString())) {
                objeto1 = listarobj.get(i);
                break;
            }
        }
        return objeto1;

    }

    public joinProductoDetallesFaltantes devuelveObjeto2(String datos, ArrayList<joinProductoDetallesFaltantes> listarobj) {
        joinProductoDetallesFaltantes objeto1 = null;
        for (int i = 0; i < listarobj.size(); i++) {
            if (datos.equals(listarobj.get(i).getId_producto().toString())) {
                objeto1 = listarobj.get(i);
                break;
            }
        }
        return objeto1;

    }

    private void Reiniciar() {
        txtCodigoProveedor.setText("");
        txtCorreo1.setText("");
        txtDescuento.setText("");
        txtNombre1.setText("");
        txtRepresentante.setText("");
        txtDireccion1.setText("");
        txtRuc1.setText("");
        txtTipo1.setText("");
        txtTelefono1.setText("");
        txtIva.setText("");
        txtTotal.setText("");
        lista1.clear();
        Tablas.cargarJoinProductoIngresoNotas(tbaListaFaltantes, lista1);
        tbaListaFaltantes.clearSelection();
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NotePedidos dialog = new NotePedidos(new javax.swing.JFrame(), true);
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
    private javax.swing.JPanel PanelSec;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnProveedor;
    private javax.swing.JButton btnSalir2;
    private javax.swing.JComboBox<String> cbxFormaP;
    private javax.swing.JComboBox<String> cbxPlazo;
    private javax.swing.JTextField filtro;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    public static javax.swing.JLabel jLabel11;
    public static javax.swing.JLabel jLabel12;
    public static javax.swing.JLabel jLabel13;
    public static javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    public static javax.swing.JLabel jLabel17;
    public static javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    public static javax.swing.JLabel jLabel2;
    public static javax.swing.JLabel jLabel3;
    public static javax.swing.JLabel jLabel4;
    public static javax.swing.JLabel jLabel5;
    public static javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable t_Nota_faltantes;
    private javax.swing.JTable tbaListaFaltantes;
    private javax.swing.JScrollPane tblProduc;
    private javax.swing.JComboBox<String> tipofiltro;
    public static javax.swing.JLabel txtCodigoProveedor;
    public static javax.swing.JTextField txtCorreo1;
    public static javax.swing.JTextField txtDescuento;
    public static javax.swing.JTextField txtDireccion1;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtHora;
    public static javax.swing.JTextField txtIva;
    public static javax.swing.JTextField txtNombre1;
    public static javax.swing.JTextField txtRepresentante;
    public static javax.swing.JTextField txtRuc1;
    public static javax.swing.JTextField txtTelefono1;
    public static javax.swing.JTextField txtTipo1;
    public static javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
