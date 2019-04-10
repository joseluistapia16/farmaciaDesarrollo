package com.farmacia.views.pedidos;

import com.farmacia.conponentes.Formato_Numeros;
import com.farmacia.conponentes.Tablas;
import com.farmacia.dao.CRUD;
import com.farmacia.entities1.CabeceraNotaPedido;
import com.farmacia.entities1.Cabecera_compra;
import com.farmacia.entities1.ClaseReporte;
import com.farmacia.entities1.Listar_usuario;
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
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.text.DecimalFormat;
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

public class EditarNotaPedido extends javax.swing.JDialog {

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
    Listar_usuario objUsuario = null;

    public EditarNotaPedido(java.awt.Frame parent, boolean modal) {
        super(parent, modal);

        setUndecorated(true);
        initComponents();

    }

    public EditarNotaPedido(java.awt.Frame parent, boolean modal, JoinListarNotaPedidosCabecera obj1, int vari) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        this.setLocationRelativeTo(null);
        setLayout(null);
        llenarFormulario(obj1);
        Tablas.cargarJoinProductoDetallesFaltantes(t_Nota_faltantes, lista);
        codigocabecera = txtNumero.getText().toString();

        lista3 = crud.listarDetalleNotaPedido(1, codigocabecera);
        Tablas.cargarJoinRegistroDetalleNotas(tbaListaFaltantes, lista3);

        TotalIVA();
        TotalDescuento();
        Total();

        variableCerrar = vari;
    }

    public EditarNotaPedido(java.awt.Frame parent, boolean modal, JoinListarNotaPedidosCabecera obj1, int vari, Listar_usuario obj) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        this.setLocationRelativeTo(null);
        setLayout(null);
        llenarFormulario(obj1);
        Tablas.cargarJoinProductoDetallesFaltantes(t_Nota_faltantes, lista);
        codigocabecera = txtNumero.getText().toString();

        lista3 = crud.listarDetalleNotaPedido(1, codigocabecera);
        Tablas.cargarJoinRegistroDetalleNotas(tbaListaFaltantes, lista3);

        TotalIVA();
        TotalDescuento();
        Total();

        variableCerrar = vari;
        objUsuario = obj;
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
        btnEditar = new javax.swing.JButton();
        btnReporte = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
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
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        tblProduc = new javax.swing.JScrollPane();
        t_Nota_faltantes = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbaListaFaltantes = new javax.swing.JTable();
        tipofiltro1 = new javax.swing.JComboBox<>();
        TxtFiltro = new javax.swing.JTextField();

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

        btnSalir2.setFont(new java.awt.Font("Ubuntu", 1, 11)); // NOI18N
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

        btnEditar.setFont(new java.awt.Font("Ubuntu", 1, 11)); // NOI18N
        btnEditar.setText("GUARDAR");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnReporte.setFont(new java.awt.Font("Ubuntu", 1, 11)); // NOI18N
        btnReporte.setText("IMPRIMIR");
        btnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));
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

        jLabel7.setBackground(new java.awt.Color(0, 153, 153));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setForeground(java.awt.Color.white);
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("REGISTROS DE NOTAS DE PEDIDOS");
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
                .addGap(32, 32, 32)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel15)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        btnBuscar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("DIRECCION:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("CORREO:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("NOMBRE:");

        txtDireccion1.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N

        txtCorreo1.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N

        txtRuc1.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("RUC :");

        txtNombre1.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("REPRESENTANTE:");

        txtRepresentante.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        txtRepresentante.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRepresentanteKeyReleased(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("TIPO:");

        txtTipo1.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("CODIGO:");

        txtCodigoProveedor.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        txtCodigoProveedor.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("TELEFONO:");

        txtTelefono1.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("DATOS DEL PROVEEDOR");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel11)
                    .addComponent(jLabel13)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txtCodigoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTelefono1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRepresentante, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(txtNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(21, 21, 21)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addGap(58, 58, 58)
                                    .addComponent(txtRuc1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtCorreo1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(18, 18, 18)
                            .addComponent(txtDireccion1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(58, 58, 58)
                        .addComponent(txtTipo1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtRuc1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtCodigoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtDireccion1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtRepresentante, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtTipo1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtTelefono1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtCorreo1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))))
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

        jButton1.setFont(new java.awt.Font("Ubuntu", 1, 10)); // NOI18N
        jButton1.setText("PRODUCTO");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Ubuntu", 1, 10)); // NOI18N
        jButton3.setText("DESACTIVAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Ubuntu", 1, 10)); // NOI18N
        jButton2.setText("FALTANTES");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbxFormaP, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(112, 112, 112)
                                .addComponent(cbxPlazo, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addComponent(txtFechaCreacion, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        t_Nota_faltantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8 "
            }
        ));
        t_Nota_faltantes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_Nota_faltantesMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                t_Nota_faltantesMousePressed(evt);
            }
        });
        tblProduc.setViewportView(t_Nota_faltantes);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tblProduc)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tblProduc, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
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

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        tipofiltro1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tipofiltro1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TODO", "CODIGO", "NOMBRE", "TIPO", "MEDIDA", "ENVASE", "MARCA" }));

        TxtFiltro.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        TxtFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtFiltroActionPerformed(evt);
            }
        });
        TxtFiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TxtFiltroKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtFiltroKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(234, 234, 234)
                .addComponent(tipofiltro1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TxtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBuscar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(jLabel17)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(4, 4, 4)
                            .addComponent(txtIva, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(jLabel18)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(4, 4, 4)
                            .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(218, 218, 218)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76)
                .addComponent(btnSalir2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addComponent(btnReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tipofiltro1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIva, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void TotalIVA() {
        BigDecimal Total1Iva = new BigDecimal("0.0000");

        for (int i = 0; i < tbaListaFaltantes.getRowCount(); i++) {
            BigDecimal Iva1 = lista3.get(i).getIva();
            Total1Iva = Total1Iva.add(Iva1);
        }
        VGiva = BigDecimal.valueOf(Double.parseDouble(Formato_Numeros.removeScientificNotation(Total1Iva.setScale(7, BigDecimal.ROUND_HALF_UP).toString())));
        txtIva.setText(Formato_Numeros.formatoNumero(Total1Iva.toString()));
    }

    public void TotalDescuento() {
        BigDecimal TotalDescuento = new BigDecimal("0.0000");
        for (int i = 0; i < tbaListaFaltantes.getRowCount(); i++) {
            BigDecimal descuento = lista3.get(i).getDescuento();
            TotalDescuento = TotalDescuento.add(descuento);
        }
        VGdescuento = BigDecimal.valueOf(Double.parseDouble(Formato_Numeros.removeScientificNotation(TotalDescuento.setScale(7, BigDecimal.ROUND_HALF_UP).toString())));
        txtDescuento.setText(Formato_Numeros.formatoNumero(TotalDescuento.toString()));
    }

    public void Total() {
        BigDecimal Total_ = new BigDecimal("0.0000");
        for (int i = 0; i < tbaListaFaltantes.getRowCount(); i++) {
            BigDecimal total = lista3.get(i).getTotal();
            Total_ = Total_.add(total);

        }
        VGtotal = BigDecimal.valueOf(Double.parseDouble(Formato_Numeros.removeScientificNotation(Total_.setScale(7, BigDecimal.ROUND_HALF_UP).toString())));
        txtTotal.setText(Formato_Numeros.formatoNumero(Total_.toString()));
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

    private void t_Nota_faltantesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_Nota_faltantesMouseClicked


    }//GEN-LAST:event_t_Nota_faltantesMouseClicked


    private void btnSalir2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir2ActionPerformed
        int r = JOptionPane.showConfirmDialog(null, "¿Desea Salir?", "", JOptionPane.YES_NO_OPTION);

        if (r == JOptionPane.YES_OPTION) {
            if (variableCerrar == 1) {
                this.setVisible(false);
            }
            if (variableCerrar != 1) {
                setVisible(false);
                MantenimientoNotaPedidos Man = new MantenimientoNotaPedidos(new javax.swing.JFrame(), true);
                Man.setVisible(true);
            }
        } else {

        }
    }//GEN-LAST:event_btnSalir2ActionPerformed

    private void t_Nota_faltantesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_Nota_faltantesMousePressed
        int i = 0;
        String msg = null;
        try {
            if (evt.getClickCount() == 2) {
                i = t_Nota_faltantes.getSelectedRow();

//                objeto = devuelveObjeto2(lista.get(i).getId_precios().toString(), lista);
                objeto = devuelveObjeto(t_Nota_faltantes.getValueAt(i, 0).toString(), lista);
                if (objeto != null) {
                    AgregarProductoEditarNotaPedido np = new AgregarProductoEditarNotaPedido(new javax.swing.JFrame(), true, objeto);
                    np.setVisible(true);
                    msg = ComponentesFaltantes.validarListaFaltantes(tbaListaFaltantes, objeto.getId_producto().toString());
//  msg = ComponentesFaltantes.validarListaCompras(t_Nota_faltantes, msg);
                    if (msg == null) {
                        Tablas.cargarJoinProductoDetallesFaltantes(t_Nota_faltantes, lista);

                        if (np.getObjf().getCantidad() > 0 || np.getObjf().getCantidad() != null) {
                            int suma = Integer.parseInt((String) t_Nota_faltantes.getValueAt(i, 6)) + np.getObjf().getCantidad();
                            getPosicion(objeto.getId_producto(), suma);
                            lista1.add(np.getObjf());

                            Tablas.cargarJoinProductoDetallesFaltantes(t_Nota_faltantes, lista);

//                            Tablas.cargarJoinProductoIngresoDetalleNotaPedido(tbaListaFaltantes, lista3);
                            //Tablas.cargarJoinRegistroDetalleNotas(tbaListaFaltantes, lista3);
                            crud.InsertarBDCompras(txtNumero.getText(), lista1);
                            actualizarTabla2();
                            actualizarCabecera();
                            btnSalir2.setEnabled(false);
                        }

                    }
                }
            }
        } catch (Exception e) {
            Logger.getLogger(NotePedidos.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_t_Nota_faltantesMousePressed
    public void actualizarTabla2() {
        String id = txtNumero.getText().toString();
        lista3.clear();
        lista3 = crud.listarDetalleNotaPedido(1, codigocabecera);
        Tablas.cargarJoinRegistroDetalleNotas(tbaListaFaltantes, lista3);

        Total();
        TotalIVA();
        TotalDescuento();
    }

    public void actualizarCabecera() {
        Cabecera_compra cn = new Cabecera_compra();
        cn.setIva(VGiva);
        cn.setDescuento(VGdescuento);
        cn.setTotal(VGtotal);
        // cn.setId_cabecera_compra(Long.valueOf(idComprasCab));
        cn.setIdcabecerapedido(Long.valueOf(txtNumero.getText()));
        crud.edicionCabeceraNotaPedido(cn);
    }

    private void getPosicion(Long id, int valor) {
        for (int i = 0; i < lista.size(); i++) {
            if (id == lista.get(i).getId_producto()) {
                lista.get(i).setCantidad(valor);
            }
        }

    }

    public JoinListarDetalleNotaPedido devuelveObjeto2(String datos, ArrayList<JoinListarDetalleNotaPedido> listarobj) {
        JoinListarDetalleNotaPedido objeto1 = null;
        for (int i = 0; i < listarobj.size(); i++) {
            if (datos.equals(listarobj.get(i).getId_precio().toString())) {
                objeto1 = listarobj.get(i);
                break;
            }
        }
        return objeto1;

    }

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

    }//GEN-LAST:event_btnBuscarActionPerformed
    public void Buscar() {
        String query = "";

        query = TxtFiltro.getText() + "%";

        int pos = tipofiltro1.getSelectedIndex();
        if (pos == 0) {
            lista = crud.FiltrosProductosNota(query, "TODO");

        }
        if (pos == 1) {
            lista = crud.FiltrosProductosNota(query, "CODIGO");

        }
        if (pos == 2) {
            lista = crud.FiltrosProductosNota(query, "NOMBRE");

        }
        if (pos == 3) {
            lista = crud.FiltrosProductosNota(query, "TIPO");

        }
        if (pos == 4) {
            lista = crud.FiltrosProductosNota(query, "MEDIDA");

        }
        if (pos == 5) {
            lista = crud.FiltrosProductosNota(query, "ENVASE");

        }
        if (pos == 6) {
            lista = crud.FiltrosProductosNota(query, "MARCA");

        }

        TxtFiltro.setText("");

        Tablas.cargarFiltroProductosNota(t_Nota_faltantes, lista);
        query = "";
    }

    public joinProductoDetallesFaltantes devuelveObjeto(String datos, ArrayList<joinProductoDetallesFaltantes> listarobj) {

        joinProductoDetallesFaltantes objeto1 = null;

        for (int i = 0; i < listarobj.size(); i++) {
            if (datos.equals(listarobj.get(i).getId_producto().toString())) {
                objeto1 = listarobj.get(i);
                break;
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

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        String valor = "";
        int r = JOptionPane.showConfirmDialog(null, "¿Desea Actualizar?", "", JOptionPane.YES_NO_CANCEL_OPTION);

        if (r == JOptionPane.YES_OPTION) {
            CabeceraNotaPedido cn = new CabeceraNotaPedido();
            cn.setPlazo(cbxPlazo.getSelectedItem().toString());
            cn.setForma_pago(cbxFormaP.getSelectedItem().toString());
            cn.setIva(VGiva);
            cn.setDescuento(VGdescuento);
            cn.setTotal(VGtotal);
            cn.setId_cabecera_nota_pedidos(Long.valueOf(txtNumero.getText()));
            valor = crud.ActualizarNotaPedidosCabecera(cn);
            btnSalir2.setEnabled(true);
            if (!"".equals(valor)) {
                JOptionPane.showMessageDialog(null, valor);
                setVisible(false);
                
                MantenimientoNotaPedidos Man = new MantenimientoNotaPedidos(new javax.swing.JFrame(), true);
                Man.setVisible(true);
            }
        } else {

        }
//        btnSalir2.setEnabled(true);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
        ArrayList tablac = new ArrayList();
        for (int i = 0; i < tbaListaFaltantes.getRowCount(); i++) {
            ClaseReporte tabla1 = new ClaseReporte(txtNumero.getText(), txtCodigoProveedor.getText(), txtNombre1.getText(), txtRepresentante.getText(), txtTelefono1.getText(), txtRuc1.getText(), txtCorreo1.getText(), txtDireccion1.getText(), txtTipo1.getText(), tbaListaFaltantes.getValueAt(i, 0).toString(), tbaListaFaltantes.getValueAt(i, 1).toString(), tbaListaFaltantes.getValueAt(i, 2).toString(), tbaListaFaltantes.getValueAt(i, 3).toString(), tbaListaFaltantes.getValueAt(i, 4).toString(), tbaListaFaltantes.getValueAt(i, 5).toString(), tbaListaFaltantes.getValueAt(i, 6).toString(), tbaListaFaltantes.getValueAt(i, 7).toString(), tbaListaFaltantes.getValueAt(i, 8).toString(), tbaListaFaltantes.getValueAt(i, 9).toString(), tbaListaFaltantes.getValueAt(i, 10).toString(), tbaListaFaltantes.getValueAt(i, 11).toString(), txtDescuento.getText(), txtIva.getText(), txtTotal.getText(), txtFechaCreacion.getText(), cbxPlazo.getSelectedItem().toString(), cbxFormaP.getSelectedItem().toString());
            tablac.add(tabla1);
        }
        try {
            String dir = System.getProperty("user.dir") + "/Reportes/" + "EditarNotaPedido.jasper";
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
            Logger.getLogger(EditarNotaPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnReporteActionPerformed

    private void jLabel7MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseDragged
        Point point = MouseInfo.getPointerInfo().getLocation();
        setLocation(point.x - x, point.y - y);
    }//GEN-LAST:event_jLabel7MouseDragged

    private void jLabel7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jLabel7MousePressed

    private void tbaListaFaltantesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbaListaFaltantesMousePressed

        int i = 0;

        if (evt.getClickCount() == 2) {
            i = tbaListaFaltantes.getSelectedRow();
//            objetop = devuelveObjeto(lista3.get(i).getId_precio().toString(), lista3);
//            objetop = devuelveObjeto(codigocabecera, lista);
            objetop = devuelveObjeto2(lista3.get(i).getId_precio().toString(), lista3);
            if (objetop != null) {
                EditarProductoNota Man = new EditarProductoNota(new javax.swing.JFrame(), true, objetop);
                Man.setVisible(true);
                lista3.clear();
                lista3 = crud.listarDetalleNotaPedido(1, codigocabecera);
                Tablas.cargarJoinRegistroDetalleNotas(tbaListaFaltantes, lista3);
                Total();
                TotalIVA();
                TotalDescuento();
                this.btnSalir2.setEnabled(false);
            }
        }
    }//GEN-LAST:event_tbaListaFaltantesMousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        MantenimientoProducto Prod = new MantenimientoProducto(new javax.swing.JFrame(), true, objUsuario);
        Prod.setVisible(true);
        listapro.clear();
        listapro = crud.listarTodoJoinProductos(1);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ListaDePedidos Lp = new ListaDePedidos(new javax.swing.JFrame(), true);
        Lp.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        String id_cab = "";

        CabeceraNotaPedido cn = new CabeceraNotaPedido();

        cn.setId_cabecera_nota_pedidos(Long.valueOf(txtNumero.getText()));
        id_cab = crud.DesactivarEstadoNotaPedido(cn);
        setVisible(false);
        RegistrosInactivosNotaPedidos RIN = new RegistrosInactivosNotaPedidos(new javax.swing.JFrame(), true);

        RIN.setVisible(true);

    }//GEN-LAST:event_jButton3ActionPerformed

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

    private void TxtFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtFiltroActionPerformed

    }//GEN-LAST:event_TxtFiltroActionPerformed

    private void TxtFiltroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtFiltroKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Buscar();
        }
    }//GEN-LAST:event_TxtFiltroKeyPressed

    private void TxtFiltroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtFiltroKeyReleased
        //        String buscar = filtro.getText();
        //        Tablas.filtro(buscar, t_Nota_faltantes);
    }//GEN-LAST:event_TxtFiltroKeyReleased

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EditarNotaPedido dialog = new EditarNotaPedido(new javax.swing.JFrame(), true);
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
    private javax.swing.JTextField TxtFiltro;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnReporte;
    private javax.swing.JButton btnSalir2;
    private javax.swing.JComboBox<String> cbxFormaP;
    private javax.swing.JComboBox<String> cbxPlazo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable t_Nota_faltantes;
    private javax.swing.JTable tbaListaFaltantes;
    private javax.swing.JScrollPane tblProduc;
    private javax.swing.JComboBox<String> tipofiltro1;
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
