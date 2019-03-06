package sistemafarmacia.presentacion;

import com.farmacia.view.principal.Envases;
import com.farmacia.view.principal.Tipo_Producto;
import com.farmacia.views.clientes.Consulta_Clientes;
import com.farmacia.views.laboratorio.Consulta_Lab;
import com.farmacia.views.marca.ConsultaMarcas;
import com.farmacia.views.medida.ConsultaMedidas;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import sistemafarmacia.Fondo;
import sistemafarmacia.VariablesFunciones;
import com.farmacia.entities1.Usuario;
import com.farmacia.views.compras.CabeceraCompra;
import com.farmacia.views.compras.ListaDePedidos;
import com.farmacia.views.devoluciones.ComprasEfectuadas;
import com.farmacia.views.iva.Mostrar_iva;
import com.farmacia.views.pedidos.MantenimientoNotaPedidos;
import com.farmacia.views.pedidos.NotePedidos;

import com.farmacia.views.producto.MantenimientoProducto;
import com.farmacia.views.producto.Products;
import com.farmacia.views.proveedor.Consulta_Proveedor;
import com.farmacia.views.stock.Stock_Productos;
import com.farmacia.views.usuario.Local;
import com.farmacia.views.usuario.Mostrar_usuario;
import com.farmacia.views.ventas.MenuPreVentas;

public class FrmPrincipal extends javax.swing.JFrame {

    private static final String TITLE = "Principal";
    VariablesFunciones variables = new VariablesFunciones();
//    private static Usuario usuarioSession;

//    public static Usuario getUsuarioSession() {
//        return usuarioSession;
//    }

    public FrmPrincipal(/*Usuario usuario*/) {
        initComponents();

        this.setTitle(variables.getTitle() + TITLE);
        this.setLocationRelativeTo(null);
        this.setExtendedState(this.MAXIMIZED_BOTH);
        this.setIconImage(variables.getIconoVentana());
        pnlBanner.setBackground(variables.getColor());
        pnlPie.setBackground(variables.getColor());

        btnClientes.setIcon(variables.getIconoBoton(btnClientes, 90, 10, "cliente"));
        btnProducto.setIcon(variables.getIconoBoton(btnProducto, 100, 10, "producto"));
        btnGenVenta.setIcon(variables.getIconoBoton(btnGenVenta, 130, 10, "venta"));
        btnProveedores.setIcon(variables.getIconoBoton(btnProveedores, 115, 10, "cliente"));
        this.add(new Fondo(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height), BorderLayout.CENTER);
//        usuarioSession = usuario;
//        lblNombreUsuario.setText(usuario.getPersona().getNombres() + " " + usuario.getPersona().getApellidos());
//        lblPrivilegio.setText(usuario.getPerfil());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu5 = new javax.swing.JMenu();
        pnlPie = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblNombreUsuario = new javax.swing.JLabel();
        lblPrivilegio = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        pnlBanner = new javax.swing.JPanel();
        btnGenVenta = new javax.swing.JButton();
        btnProducto = new javax.swing.JButton();
        btnClientes = new javax.swing.JButton();
        btnProveedores = new javax.swing.JButton();
        btnEmpelados = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        mnuLaboratorio = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem7 = new javax.swing.JMenuItem();
        jmLocal = new javax.swing.JMenu();
        jMenuItem11 = new javax.swing.JMenuItem();
        jmEmpleados = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mnuRegistrarVenta = new javax.swing.JMenuItem();
        mnuCliente = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        mnuRegistrarVenta1 = new javax.swing.JMenuItem();
        mnuCliente1 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        mnuAyuda = new javax.swing.JMenu();
        mnuAcerca = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem14 = new javax.swing.JMenuItem();

        jMenu5.setText("jMenu5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Usuario:");

        lblNombreUsuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNombreUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreUsuario.setText("Nombre Completo de Usuario");

        lblPrivilegio.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblPrivilegio.setForeground(new java.awt.Color(255, 255, 255));
        lblPrivilegio.setText("Administrador");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Privilegio:");

        javax.swing.GroupLayout pnlPieLayout = new javax.swing.GroupLayout(pnlPie);
        pnlPie.setLayout(pnlPieLayout);
        pnlPieLayout.setHorizontalGroup(
            pnlPieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPieLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPrivilegio, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(264, Short.MAX_VALUE))
        );
        pnlPieLayout.setVerticalGroup(
            pnlPieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPieLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlPieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(lblPrivilegio))
                    .addGroup(pnlPieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(lblNombreUsuario)))
                .addContainerGap())
        );

        btnGenVenta.setText("Generar Venta");
        btnGenVenta.setFocusable(false);
        btnGenVenta.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnGenVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenVentaActionPerformed(evt);
            }
        });

        btnProducto.setText("Productos");
        btnProducto.setFocusable(false);
        btnProducto.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductoActionPerformed(evt);
            }
        });

        btnClientes.setText("Clientes");
        btnClientes.setFocusable(false);
        btnClientes.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesActionPerformed(evt);
            }
        });

        btnProveedores.setText("Proveedores");
        btnProveedores.setFocusable(false);
        btnProveedores.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProveedoresActionPerformed(evt);
            }
        });

        btnEmpelados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/farmacia/icono/Activar.png"))); // NOI18N
        btnEmpelados.setText("Empleados");
        btnEmpelados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmpeladosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBannerLayout = new javax.swing.GroupLayout(pnlBanner);
        pnlBanner.setLayout(pnlBannerLayout);
        pnlBannerLayout.setHorizontalGroup(
            pnlBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBannerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEmpelados, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGenVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        pnlBannerLayout.setVerticalGroup(
            pnlBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBannerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBannerLayout.createSequentialGroup()
                        .addGroup(pnlBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGenVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btnEmpelados, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jMenu3.setText("Productos");

        jMenu6.setText("Componentes");

        jMenuItem2.setText("Envases");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem2);

        jMenuItem3.setText("Marcas");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem3);

        jMenuItem4.setText("Medidas");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem4);

        jMenuItem5.setText("Tipo de Producto");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem5);

        mnuLaboratorio.setText("Laboratorio");
        mnuLaboratorio.setToolTipText("");
        mnuLaboratorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuLaboratorioActionPerformed(evt);
            }
        });
        jMenu6.add(mnuLaboratorio);

        jMenuItem10.setText("IVA");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem10);

        jMenu3.add(jMenu6);
        jMenu3.add(jSeparator2);

        jMenuItem7.setText("Mantenimiento");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem7);

        jMenuBar1.add(jMenu3);

        jmLocal.setText("Usuario");

        jMenuItem11.setText("Local");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jmLocal.add(jMenuItem11);

        jmEmpleados.setText("Empleados");
        jmEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmEmpleadosActionPerformed(evt);
            }
        });
        jmLocal.add(jmEmpleados);

        jMenuBar1.add(jmLocal);

        jMenu2.setText("Ventas");

        mnuRegistrarVenta.setText("Registrar Venta");
        mnuRegistrarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuRegistrarVentaActionPerformed(evt);
            }
        });
        jMenu2.add(mnuRegistrarVenta);

        mnuCliente.setText("Clientes");
        mnuCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuClienteActionPerformed(evt);
            }
        });
        jMenu2.add(mnuCliente);

        jMenuItem1.setText("Lista de Ventas");
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        jMenu4.setText("Compras");

        mnuRegistrarVenta1.setText("Registrar Nota Pedido");
        mnuRegistrarVenta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuRegistrarVenta1ActionPerformed(evt);
            }
        });
        jMenu4.add(mnuRegistrarVenta1);

        mnuCliente1.setText("Proveedores");
        mnuCliente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCliente1ActionPerformed(evt);
            }
        });
        jMenu4.add(mnuCliente1);

        jMenuItem8.setText("Registrar Compra");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem8);

        jMenuItem9.setText("Mantenimiento Nota Pedido");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem9);

        jMenuItem12.setText("Productos Faltantes");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem12);

        jMenuBar1.add(jMenu4);

        mnuAyuda.setText("Ayuda");

        mnuAcerca.setText("Acerca de ...");
        mnuAcerca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAcercaActionPerformed(evt);
            }
        });
        mnuAyuda.add(mnuAcerca);

        jMenuItem6.setText("Salir");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        mnuAyuda.add(jMenuItem6);

        jMenuBar1.add(mnuAyuda);

        jMenu1.setText("Stock");

        jMenuItem13.setText("Productos en Stock");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem13);

        jMenuBar1.add(jMenu1);

        jMenu7.setText("Devoluciones");

        jMenuItem14.setText("devolucion compra");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem14);

        jMenuBar1.add(jMenu7);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBanner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlPie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlBanner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 229, Short.MAX_VALUE)
                .addComponent(pnlPie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenVentaActionPerformed
//        DlgGenerarVenta generarVenta= new DlgGenerarVenta(this, rootPaneCheckingEnabled);
//        generarVenta.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_btnGenVentaActionPerformed

    private void btnProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductoActionPerformed
////        DlgProducto producto= new DlgProducto(this, rootPaneCheckingEnabled);
////        producto.setVisible(rootPaneCheckingEnabled);
            Products pr = new Products(new javax.swing.JFrame(), true);
            pr.setVisible(true);
    }//GEN-LAST:event_btnProductoActionPerformed

    private void mnuLaboratorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuLaboratorioActionPerformed
//        DlgLaboratorio laboratorio= new DlgLaboratorio(this, rootPaneCheckingEnabled,0);
//        laboratorio.setVisible(rootPaneCheckingEnabled);

        Consulta_Lab cl = new Consulta_Lab(new javax.swing.JFrame(), true);
        cl.setVisible(true);
    }//GEN-LAST:event_mnuLaboratorioActionPerformed

    private void mnuRegistrarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuRegistrarVentaActionPerformed
//        DlgGenerarVenta generarVenta= new DlgGenerarVenta(this, rootPaneCheckingEnabled);
//        generarVenta.setVisible(rootPaneCheckingEnabled);
        MenuPreVentas mp=new MenuPreVentas(new javax.swing.JFrame(), true);
        mp.setVisible(true);
    }//GEN-LAST:event_mnuRegistrarVentaActionPerformed

    private void mnuClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuClienteActionPerformed
//        DlgCliente cliente= new DlgCliente(this, rootPaneCheckingEnabled);
//        cliente.setVisible(rootPaneCheckingEnabled);

        Consulta_Clientes cl = new Consulta_Clientes(new javax.swing.JFrame(), true);
        cl.setVisible(true);
    }//GEN-LAST:event_mnuClienteActionPerformed

    private void btnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesActionPerformed
//        DlgCliente cliente= new DlgCliente(this, rootPaneCheckingEnabled);
//        cliente.setVisible(rootPaneCheckingEnabled);
        Consulta_Clientes cliente = new Consulta_Clientes(new javax.swing.JFrame(), true);
        cliente.setVisible(true);
    }//GEN-LAST:event_btnClientesActionPerformed

    private void mnuAcercaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAcercaActionPerformed
//        DlgAcerca acerca = new DlgAcerca(this, rootPaneCheckingEnabled);
//        acerca.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_mnuAcercaActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        Envases e = new Envases(new javax.swing.JFrame(), true);
        e.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        Tipo_Producto t = new Tipo_Producto(new javax.swing.JFrame(), true);
        t.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        ConsultaMarcas cmx = new ConsultaMarcas(new javax.swing.JFrame(), true);
        cmx.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        ConsultaMedidas cm = new ConsultaMedidas(new javax.swing.JFrame(), true);
        cm.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        FrmLogin lo = new FrmLogin();
        lo.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
//        Products p1 = new Products(new javax.swing.JFrame(), true);
//        p1.setVisible(true);
          MantenimientoProducto p1 = new MantenimientoProducto(new javax.swing.JFrame(), true);
          p1.setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void btnProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProveedoresActionPerformed
        Consulta_Proveedor p = new Consulta_Proveedor(new javax.swing.JFrame(), true);
        p.setVisible(true);
    }//GEN-LAST:event_btnProveedoresActionPerformed

    private void mnuRegistrarVenta1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuRegistrarVenta1ActionPerformed
        NotePedidos np = new NotePedidos(new javax.swing.JFrame(), true);
        np.setVisible(true);
    }//GEN-LAST:event_mnuRegistrarVenta1ActionPerformed

    private void mnuCliente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCliente1ActionPerformed
       Consulta_Proveedor pro = new Consulta_Proveedor(new javax.swing.JFrame(), true);
       pro.setVisible(true);
       
    }//GEN-LAST:event_mnuCliente1ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
       CabeceraCompra CB=new CabeceraCompra(new javax.swing.JFrame(), true);
       CB.setVisible(true);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
      MantenimientoNotaPedidos mp=new MantenimientoNotaPedidos(new javax.swing.JFrame(), true);
      mp.setVisible(true);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        Mostrar_iva MI = new Mostrar_iva(new javax.swing.JFrame(), true);
        MI.setVisible(true);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        Local lc = new Local(new javax.swing.JFrame(), true);
        lc.setVisible(true);
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void btnEmpeladosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmpeladosActionPerformed
        Mostrar_usuario mu = new Mostrar_usuario(new javax.swing.JFrame(), true);
        mu.setVisible(true);
    }//GEN-LAST:event_btnEmpeladosActionPerformed

    private void jmEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmEmpleadosActionPerformed
        Mostrar_usuario mu = new Mostrar_usuario(new javax.swing.JFrame(), true);
        mu.setVisible(true);
    }//GEN-LAST:event_jmEmpleadosActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
       
        ListaDePedidos Lp = new ListaDePedidos(new javax.swing.JFrame(), true);
        Lp.setVisible(true);
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        Stock_Productos sp = new Stock_Productos(this, rootPaneCheckingEnabled);
        sp.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
       ComprasEfectuadas ce = new ComprasEfectuadas(this, rootPaneCheckingEnabled);
       ce.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_jMenuItem14ActionPerformed

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
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new FrmPrincipal().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClientes;
    private javax.swing.JButton btnEmpelados;
    private javax.swing.JButton btnGenVenta;
    public javax.swing.JButton btnProducto;
    private javax.swing.JButton btnProveedores;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JMenuItem jmEmpleados;
    private javax.swing.JMenu jmLocal;
    private javax.swing.JLabel lblNombreUsuario;
    private javax.swing.JLabel lblPrivilegio;
    private javax.swing.JMenuItem mnuAcerca;
    private javax.swing.JMenu mnuAyuda;
    private javax.swing.JMenuItem mnuCliente;
    private javax.swing.JMenuItem mnuCliente1;
    private javax.swing.JMenuItem mnuLaboratorio;
    private javax.swing.JMenuItem mnuRegistrarVenta;
    private javax.swing.JMenuItem mnuRegistrarVenta1;
    private javax.swing.JPanel pnlBanner;
    private javax.swing.JPanel pnlPie;
    // End of variables declaration//GEN-END:variables
}
