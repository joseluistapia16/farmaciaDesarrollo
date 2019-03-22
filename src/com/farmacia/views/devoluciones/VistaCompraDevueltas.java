package com.farmacia.views.devoluciones;

import com.farmacia.conponentes.Formato_Numeros;
import com.farmacia.views.comprasRealizadas.EditarProductoCompra1;
import com.farmacia.views.pedidos.*;
import com.farmacia.conponentes.Tablas;
import com.farmacia.dao.CRUD;
import com.farmacia.entities1.CabeceraNotaPedido;
import com.farmacia.entities1.Cabecera_compra;
import com.farmacia.entities1.ClaseReporte;
import com.farmacia.entities1.Detalle_compra;
import com.farmacia.filtros.filtrosProductos;
import com.farmacia.join_entidades.JoinListarDetalleNotaPedido;
import com.farmacia.join_entidades.JoinListarNotaPedidosCabecera;
import com.farmacia.join_entidades.joinProductoDetallesFaltantes;
import com.farmacia.join_entidades.listarJoinProductosCompras;
import com.farmacia.join_entidades.listarJoinProductosNotaPedidos;
import com.farmacia.validaciones.ComponentesFaltantes;
import com.farmacia.views.compras.ListaDePedidos;
import com.farmacia.views.compras.OrdenCompra;
import static com.farmacia.views.pedidos.EditarProductoNota.redondearDecimales;
import com.farmacia.views.producto.MantenimientoProducto;
import com.farmacia.views.producto.Products;
import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.Point;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JRViewer;

public class VistaCompraDevueltas extends javax.swing.JDialog {

    int x, y, variableCerrar;
    int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
    int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
    CRUD crud = new CRUD();
    filtrosProductos fil = new filtrosProductos();
    BigDecimal VGiva = null, VGtotal = null, VGdescuento = null;
    static ArrayList<listarJoinProductosNotaPedidos> listar = null;
    joinProductoDetallesFaltantes objeto = null;
    ArrayList<joinProductoDetallesFaltantes> lista = crud.listarFaltantesDetalles(1);
    ArrayList<joinProductoDetallesFaltantes> lista1 = new ArrayList<joinProductoDetallesFaltantes>();
    JoinListarNotaPedidosCabecera objf = new JoinListarNotaPedidosCabecera();
    ArrayList<listarJoinProductosCompras> listapro = crud.listarTodoJoinProductos(1);
    String codigocabecera = "";
    ArrayList<JoinListarDetalleNotaPedido> lista3 = null;
    JoinListarDetalleNotaPedido objetop = null;
    JoinListarNotaPedidosCabecera buscador = null;
    int idComprasCab;

    public VistaCompraDevueltas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);

        setUndecorated(true);
        initComponents();

    }

    public VistaCompraDevueltas(java.awt.Frame parent, boolean modal, JoinListarNotaPedidosCabecera obj1, int vari) {
//        super(parent, modal);
//
//        setUndecorated(true);
//        setLocationRelativeTo(null);
//        initComponents();        
//        this.setResizable(false);
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        this.setLocationRelativeTo(null);
        setLayout(null);
        llenarFormulario(obj1);
        buscador = obj1;
//        Tablas.cargarJoinProductoDetallesFaltantes(t_Nota_faltantes, lista);
        codigocabecera = txtNumero.getText().toString();

        lista3 = crud.listarDetalleNotaPedido(1, codigocabecera);
        Tablas.cargarJoinRegistroDetalleNotas(tbaListaFaltantes, lista3);

        TotalIVA();
        TotalDescuento();
        Total();

        variableCerrar = vari;
        idComprasCab = buscarIDcabCompras();
    }

    private void llenarFormulario(JoinListarNotaPedidosCabecera obj) {
        txtCodigoProveedor.setText(obj.getId_proveedor().toString());
        txtNombre1.setText(obj.getEntidad());
        txtCorreo1.setText(obj.getCorreo());
        txtRuc1.setText(obj.getCedula_ruc());
        txtTelefono1.setText(obj.getTelefono());
        txtRepresentante.setText(obj.getRepresentante());
        txtFechaCreacion.setText(obj.getFecha_creacion());
        txtNumero.setText(obj.getId_cabecera_nota_pedidos().toString());
        txtDireccion1.setText(obj.getDireccion());
        txtTipo1.setText(obj.getClase());
        cbxPlazo.setSelectedItem(obj.getPlazo());
        cbxFormaP.setSelectedItem(obj.getForma_pago());
//       
        objf.setId_proveedor(obj.getId_proveedor());
        objf.setEntidad(obj.getEntidad());
        objf.setCorreo(obj.getCorreo());
        objf.setCedula_ruc(obj.getCedula_ruc());
        objf.setFecha_creacion(obj.getFecha_creacion());
        objf.setId_cabecera_nota_pedidos(obj.getId_cabecera_nota_pedidos());
        objf.setDireccion(obj.getDireccion());
        objf.setClase(obj.getClase());
        objf.setTelefono(obj.getTelefono());
        objf.setRepresentante(obj.getRepresentante());
        objf.setPlazo(obj.getPlazo());
        objf.setForma_pago(obj.getForma_pago());

    }

    public int buscarIDcabCompras() {
        int cab = 0;
        Cabecera_compra cn = new Cabecera_compra();
        cn.setIva(VGiva);
        cn.setDescuento(VGdescuento);
        cn.setTotal(VGtotal);
        cab = Integer.parseInt(crud.buscarIDCabeceraCompras(cn));
        return cab;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
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
        jPanel3 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
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
        jLabel20 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtFechaCreacion = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cbxFormaP = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        cbxPlazo = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbaListaFaltantes = new javax.swing.JTable();
        btnReporte = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
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

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
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

        btnSalir2.setBackground(new java.awt.Color(153, 0, 0));
        btnSalir2.setFont(new java.awt.Font("Ubuntu", 1, 11)); // NOI18N
        btnSalir2.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir2.setText("SALIR");
        btnSalir2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir2ActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("TOTAL:");

        txtTotal.setEditable(false);
        txtTotal.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        txtTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("IVA:");

        txtIva.setEditable(false);
        txtIva.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        txtIva.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setText("DESCUENTO:");

        txtDescuento.setEditable(false);
        txtDescuento.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        txtDescuento.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("$");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("$");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("$");

        jPanel3.setBackground(new java.awt.Color(2, 184, 184));
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

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("#");

        txtNumero.setEditable(false);
        txtNumero.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N

        jLabel7.setBackground(new java.awt.Color(2, 184, 184));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setForeground(java.awt.Color.white);
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("DETALLE COMPRAS EFECTUADAS");
        jLabel7.setOpaque(true);
        jLabel7.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel7MouseDragged(evt);
            }
        });
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel7MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(67, 67, 67)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel15)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("DIRECCION:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("CORREO:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("NOMBRE:");

        txtDireccion1.setEditable(false);
        txtDireccion1.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N

        txtCorreo1.setEditable(false);
        txtCorreo1.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N

        txtRuc1.setEditable(false);
        txtRuc1.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("RUC :");

        txtNombre1.setEditable(false);
        txtNombre1.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("REPRESENTANTE:");

        txtRepresentante.setEditable(false);
        txtRepresentante.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        txtRepresentante.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRepresentanteKeyReleased(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("TIPO:");

        txtTipo1.setEditable(false);
        txtTipo1.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("CODIGO:");

        txtCodigoProveedor.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        txtCodigoProveedor.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("TELEFONO:");

        txtTelefono1.setEditable(false);
        txtTelefono1.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("DATOS DEL PROVEEDOR");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel11)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtTelefono1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtRepresentante, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel3))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(txtDireccion1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtTipo1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtCorreo1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtCodigoProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(92, 92, 92)
                        .addComponent(jLabel6)
                        .addGap(48, 48, 48)
                        .addComponent(txtRuc1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(7, 7, 7))
                        .addComponent(txtCodigoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRuc1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCorreo1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRepresentante, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDireccion1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefono1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTipo1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("FECHA:");

        txtFechaCreacion.setEditable(false);
        txtFechaCreacion.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        txtFechaCreacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaCreacionActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("PLAZO:");

        cbxFormaP.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        cbxFormaP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Contado", "Credito" }));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("FORMA DE PAGO:");

        cbxPlazo.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        cbxPlazo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Inmediato", "3 Meses", "6 Meses", "9 Meses", "12 Meses", "24 Meses" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbxFormaP, 0, 150, Short.MAX_VALUE)
                    .addComponent(cbxPlazo, 0, 150, Short.MAX_VALUE)
                    .addComponent(txtFechaCreacion))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFechaCreacion, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxPlazo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxFormaP, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        tbaListaFaltantes.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.gray, null));
        tbaListaFaltantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "MARCA", "TIPO", "PRODUCTO", "ENVASE", "MEDIDA", "BONO", "CANTIDAD", "PRECIO", "DESCUENTO", "IVA", "TOTAL"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, true, true, true, true, false, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

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
        if (tbaListaFaltantes.getColumnModel().getColumnCount() > 0) {
            tbaListaFaltantes.getColumnModel().getColumn(0).setPreferredWidth(55);
            tbaListaFaltantes.getColumnModel().getColumn(1).setPreferredWidth(90);
            tbaListaFaltantes.getColumnModel().getColumn(3).setPreferredWidth(90);
            tbaListaFaltantes.getColumnModel().getColumn(10).setPreferredWidth(40);
            tbaListaFaltantes.getColumnModel().getColumn(11).setPreferredWidth(55);
        }

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        btnReporte.setFont(new java.awt.Font("Ubuntu", 1, 11)); // NOI18N
        btnReporte.setText("IMPRIMIR");
        btnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel17)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel18)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtIva, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDescuento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(177, 177, 177)
                .addComponent(btnReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalir2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(177, 177, 177))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIva, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(156, 156, 156))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 552, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void TotalIVA() {
        BigDecimal Total1Iva = new BigDecimal("0.0000");

        for (int i = 0; i < tbaListaFaltantes.getRowCount(); i++) {
            BigDecimal Iva1 = lista3.get(i).getIva();
            Total1Iva = Total1Iva.add(Iva1);
//            totalIva = redondearDecimales(totalIva, 2);
        }
        VGiva = BigDecimal.valueOf(Double.parseDouble(removeScientificNotation(Total1Iva.setScale(7, BigDecimal.ROUND_HALF_UP).toString())));
        txtIva.setText(removeScientificNotation(Total1Iva.setScale(2, BigDecimal.ROUND_HALF_UP).toString()));

    }

    public void TotalDescuento() {
        BigDecimal TotalDescuento = new BigDecimal("0.0000");
        for (int i = 0; i < tbaListaFaltantes.getRowCount(); i++) {
            BigDecimal descuento = lista3.get(i).getDescuento();
            TotalDescuento = TotalDescuento.add(descuento);
//            TotalDescuento = redondearDecimales(TotalDescuento, 2);
        }
        VGdescuento = BigDecimal.valueOf(Double.parseDouble(removeScientificNotation(TotalDescuento.setScale(7, BigDecimal.ROUND_HALF_UP).toString())));
        txtDescuento.setText(removeScientificNotation(TotalDescuento.setScale(2, BigDecimal.ROUND_HALF_UP).toString()));
    }

    public void Total() {
        BigDecimal Total_ = new BigDecimal("0.0000");
        for (int i = 0; i < tbaListaFaltantes.getRowCount(); i++) {
            BigDecimal total = lista3.get(i).getTotal();
            Total_ = Total_.add(total);

        }
        VGtotal = BigDecimal.valueOf(Double.parseDouble(removeScientificNotation(Total_.setScale(7, BigDecimal.ROUND_HALF_UP).toString())));
        txtTotal.setText(Total_.setScale(2, BigDecimal.ROUND_HALF_UP).toString());
    }

    public static String removeScientificNotation(String value) {
        return new BigDecimal(value).toPlainString();
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
    private void txtRepresentanteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRepresentanteKeyReleased


    }//GEN-LAST:event_txtRepresentanteKeyReleased


    private void btnSalir2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir2ActionPerformed
        int r = JOptionPane.showConfirmDialog(null, "¿Desea Salir?", "", JOptionPane.YES_NO_OPTION);

        if (r == JOptionPane.YES_OPTION) {
            if (variableCerrar == 1) {
                this.setVisible(false);
            }
            if (variableCerrar != 1) {
                setVisible(false);
            }
        } else {

        }
    }//GEN-LAST:event_btnSalir2ActionPerformed

    public void actualizarTabla2() {
        String id = txtNumero.getText().toString();
        lista3.clear();
        lista3 = crud.listarDetalleNotaPedido(1, codigocabecera);
        Tablas.cargarJoinRegistroDetalleNotas(tbaListaFaltantes, lista3);

        Total();
        TotalIVA();
        TotalDescuento();
    }

    private void getPosicion(Long id, int valor) {
        for (int i = 0; i < lista.size(); i++) {
            if (id == lista.get(i).getId_producto()) {
                lista.get(i).setCantidad(valor);
            }
        }

    }

    public joinProductoDetallesFaltantes devuelveObjeto2(String datos, ArrayList<joinProductoDetallesFaltantes> listarobj) {
        joinProductoDetallesFaltantes objeto1 = null;
        for (int i = 0; i < listarobj.size(); i++) {
            if (datos.equals(listarobj.get(i).getId_precios().toString())) {
                objeto1 = listarobj.get(i);
                break;
            }
        }
        return objeto1;

    }

    public JoinListarDetalleNotaPedido devuelveObjeto(String codPro, String total, String iva, ArrayList<JoinListarDetalleNotaPedido> listarobj) {
        JoinListarDetalleNotaPedido objeto1 = null;
        for (int i = 0; i < listarobj.size(); i++) {
            if (codPro.equals(listarobj.get(i).getId_producto().toString())) {
                if (total.equals(Formato_Numeros.formatoNumero(listarobj.get(i).getTotal().toString()))) {
                    if (iva.equals(Formato_Numeros.formatoNumero(listarobj.get(i).getIva().toString()))) {
                        objeto1 = listarobj.get(i);
                        break;
                    }
                }

            }
        }
        return objeto1;

    }
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

    private void jPanel5MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseDragged
        Point point = MouseInfo.getPointerInfo().getLocation();
        setLocation(point.x - x, point.y - y);
    }//GEN-LAST:event_jPanel5MouseDragged

    private void jLabel7MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseDragged
        Point point = MouseInfo.getPointerInfo().getLocation();
        setLocation(point.x - x, point.y - y);
    }//GEN-LAST:event_jLabel7MouseDragged

    private void jLabel7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jLabel7MousePressed

    private void tbaListaFaltantesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbaListaFaltantesMousePressed
//        try {
//            int i = 0;
//            if (evt.getClickCount() == 2) {
//                i = tbaListaFaltantes.getSelectedRow();
//                // lista = crud.listarCabeceraNotaPedidoEnCompras(3);
//                objetop = devuelveObjeto(tbaListaFaltantes.getValueAt(i, 0).toString(), tbaListaFaltantes.getValueAt(i, 11).toString(), tbaListaFaltantes.getValueAt(i, 10).toString(), lista3);
//                if (objetop != null) {
//                    int seleccion = JOptionPane.showOptionDialog(null, "Seleccione una opcion",
//                            "Selector de opciones", JOptionPane.YES_NO_CANCEL_OPTION,
//                            JOptionPane.QUESTION_MESSAGE, null,// null para icono por defecto.
//                            new Object[]{"Devolver", "Modificar"}, "opcion 1");
//                    System.out.println(seleccion);
//                    switch (seleccion) {
//                        case 0://eliminar
//                            String valor = "";
//                            int seleccion1 = JOptionPane.showOptionDialog(null, "Esta Seguro De Eliminar El Item Seleccionado",
//                                    "Selector de opciones", JOptionPane.YES_NO_CANCEL_OPTION,
//                                    JOptionPane.QUESTION_MESSAGE, null,// null para icono por defecto.
//                                    new Object[]{"SI", "NO"}, "NO");
//                            if (seleccion1 == 0) {
//                                valor = crud.EliminarDetalleDevolucion(objetop);
//                                if ("EXITO".equals(valor)) {
//                                    JOptionPane.showMessageDialog(rootPane, valor);
//                                    actualizarTabla2();
//                                    Cabecera_compra cn = new Cabecera_compra();
//                                    cn.setIva(VGiva);
//                                    cn.setDescuento(VGdescuento);
//                                    cn.setTotal(VGtotal);
//                                    cn.setId_cabecera_compra(Long.valueOf(idComprasCab));
//                                    cn.setIdcabecerapedido(Long.valueOf(txtNumero.getText()));
//                                    crud.edicionCompra(cn);
//                                }
//                            }
//                            break;
//                        case 1://modificar
//                            EditarProductoCompra1 Man = new EditarProductoCompra1(new javax.swing.JFrame(), true, objetop);
//                            Man.setVisible(true);
//                            actualizarTabla2();
//                            if ("2".equals(Man.getop())) {
//                                Cabecera_compra cn = new Cabecera_compra();
//                                cn.setIva(VGiva);
//                                cn.setDescuento(VGdescuento);
//                                cn.setTotal(VGtotal);
//                                cn.setId_cabecera_compra(Long.valueOf(idComprasCab));
//                                cn.setIdcabecerapedido(Long.valueOf(txtNumero.getText()));
//                                crud.edicionCompra(cn);
//                            } else {
//                            }
//                            break;
//                        case -1:
//                            System.out.println("lala");
//                            break;
//                        default:
//                            System.out.println("error");
//                            break;
//                    }
//                }
//                System.out.println("vacuo");
//            }
//        } catch (Exception ex) {
//            Logger.getLogger(VistaCompraDevueltas.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_tbaListaFaltantesMousePressed

    private void jPanel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jPanel3MousePressed

    private void jPanel3MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseDragged
        Point point = MouseInfo.getPointerInfo().getLocation();
        setLocation(point.x - x, point.y - y);
    }//GEN-LAST:event_jPanel3MouseDragged

    private void txtFechaCreacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaCreacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaCreacionActionPerformed

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
                ArrayList tablac = new ArrayList();
        for (int i = 0; i < tbaListaFaltantes.getRowCount(); i++) {
            ClaseReporte tabla1 = new ClaseReporte(txtNumero.getText(),
                txtCodigoProveedor.getText(),
                txtNombre1.getText(),
                txtRepresentante.getText(),
                txtTelefono1.getText(),
                txtRuc1.getText(),
                txtCorreo1.getText(),
                txtDireccion1.getText(),
                txtTipo1.getText(),
                txtFechaCreacion.getText(),
                cbxPlazo.getSelectedItem().toString(),
                cbxFormaP.getSelectedItem().toString(),
                tbaListaFaltantes.getValueAt(i, 0).toString(),
                tbaListaFaltantes.getValueAt(i, 1).toString(),
                tbaListaFaltantes.getValueAt(i, 2).toString(),
                tbaListaFaltantes.getValueAt(i, 3).toString(),
                tbaListaFaltantes.getValueAt(i, 4).toString(),
                tbaListaFaltantes.getValueAt(i, 5).toString(),
                tbaListaFaltantes.getValueAt(i, 6).toString(),
                tbaListaFaltantes.getValueAt(i, 7).toString(),
                tbaListaFaltantes.getValueAt(i, 8).toString(),
                tbaListaFaltantes.getValueAt(i, 9).toString(),
                tbaListaFaltantes.getValueAt(i, 10).toString(),
                tbaListaFaltantes.getValueAt(i, 11).toString(),
                txtDescuento.getText(),
                txtIva.getText(),
                txtTotal.getText());
            tablac.add(tabla1);
        }
        try {
            String dir = System.getProperty("user.dir") + "/Reportes/" +"VistaCompraDevueltas.jasper";
            JasperReport reporte = (JasperReport) JRLoader.loadObject(dir);
            JasperPrint jprint = JasperFillManager.fillReport(reporte, null, new JRBeanCollectionDataSource(tablac));
            JDialog frame = new JDialog(this);
            JRViewer viewer = new JRViewer(jprint);
            frame.add(viewer);
            frame.setSize(new Dimension(ancho / 2, alto / 2));
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            viewer.setFitWidthZoomRatio();
        } catch (JRException ex) {
            Logger.getLogger(OrdenCompra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnReporteActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VistaCompraDevueltas dialog = new VistaCompraDevueltas(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnReporte;
    private javax.swing.JButton btnSalir2;
    private javax.swing.JComboBox<String> cbxFormaP;
    private javax.swing.JComboBox<String> cbxPlazo;
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
    private javax.swing.JLabel jLabel20;
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
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbaListaFaltantes;
    public static javax.swing.JLabel txtCodigoProveedor;
    public static javax.swing.JTextField txtCorreo1;
    public static javax.swing.JTextField txtDescuento;
    public static javax.swing.JTextField txtDireccion1;
    private javax.swing.JTextField txtFechaCreacion;
    public static javax.swing.JTextField txtIva;
    public static javax.swing.JTextField txtNombre1;
    public static javax.swing.JTextField txtNumero;
    public static javax.swing.JTextField txtRepresentante;
    public static javax.swing.JTextField txtRuc1;
    public static javax.swing.JTextField txtTelefono1;
    public static javax.swing.JTextField txtTipo1;
    public static javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
