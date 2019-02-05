package com.farmacia.views.iva;

//import com.iva.componentes.Tablas;
//import com.iva.dao.CRUD;
//import com.iva.dao.Conexion;
//import com.iva.entities.Iva;
import com.farmacia.conponentes.Tablas;
import com.farmacia.dao.CRUD;
import com.farmacia.entities1.ClaseReporte;
import com.farmacia.entities1.Iva;
import java.awt.Dimension;
import java.sql.Connection;
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

public class Mostrar_iva extends javax.swing.JDialog {

    Iva iva_bus;
    ArrayList<Iva> lista = new ArrayList();
    CRUD crud = new CRUD();
    int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
    int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
    public Mostrar_iva(java.awt.Frame parent, boolean modal) {

        super(parent, modal);
        initComponents();
        lista = crud.listarIva();
        Tablas.listarIva(lista, tabla_iva);
        setLocationRelativeTo(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        iva_valor = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_iva = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        Reporte = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        iva_valor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iva_valorActionPerformed(evt);
            }
        });
        getContentPane().add(iva_valor, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 28, 130, -1));

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel1.setText("IVA :");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 30, 48, -1));

        tabla_iva.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jScrollPane1.setViewportView(tabla_iva);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 62, 375, 126));

        jButton1.setText("INSERTAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(237, 27, 107, -1));

        jButton2.setFont(new java.awt.Font("Ubuntu", 1, 13)); // NOI18N
        jButton2.setText("ELIMINAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 206, 100, -1));

        jButton3.setFont(new java.awt.Font("Ubuntu", 1, 13)); // NOI18N
        jButton3.setText("SALIR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(268, 206, 100, -1));

        Reporte.setFont(new java.awt.Font("Ubuntu", 1, 13)); // NOI18N
        Reporte.setText("IMPRIMIR");
        Reporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReporteActionPerformed(evt);
            }
        });
        getContentPane().add(Reporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 206, 100, 30));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 396, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 246, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 250));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void iva_valorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iva_valorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_iva_valorActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Double valor = (Double.valueOf(iva_valor.getText())/100);
        int user = 1;
        String res = crud.insertarIva(valor, user);
        JOptionPane.showMessageDialog(null, res);
        setVisible(false);
         
        Mostrar_iva mi = new Mostrar_iva(new javax.swing.JFrame(),true);
        mi.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int fila = tabla_iva.getSelectedRow();
        iva_bus = getObject(lista, Double.valueOf(tabla_iva.getValueAt(fila, 0).toString()));
        String mn = crud.eliminar_iva(Integer.valueOf((iva_bus.getId_iva()).toString()));
        JOptionPane.showMessageDialog(null, mn);
         setVisible(false);
        Mostrar_iva mi = new Mostrar_iva(new javax.swing.JFrame(),true);
        mi.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void ReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReporteActionPerformed
        java.util.List lista = new ArrayList();
        for (int i = 0; i < tabla_iva.getRowCount(); i++) {
            ClaseReporte medida = new ClaseReporte (tabla_iva.getValueAt(i, 0).toString(),tabla_iva.getValueAt(i, 1).toString(),tabla_iva.getValueAt(i, 2).toString());
            lista.add(medida);
        }
        try {
            JasperReport reporte = (JasperReport) JRLoader.loadObject("Mostrar_iva.jasper");
            JasperPrint jprint = JasperFillManager.fillReport(reporte,null, new JRBeanCollectionDataSource(lista));
            JDialog frame = new JDialog(this);
            JRViewer viewer = new JRViewer(jprint);
            frame.add(viewer);
            frame.setSize(new Dimension(ancho/2,alto/2));
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            viewer.setFitWidthZoomRatio();
        } catch (JRException ex) {
            Logger.getLogger(Mostrar_iva.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ReporteActionPerformed

    public Iva getObject(ArrayList<Iva> listaj, Double num) {
        Iva iva_opt = null;
        for (int i = 0; i < lista.size(); i++) {
            if (num == lista.get(i).getIva()) {
                iva_opt = lista.get(i);
                
            }
        }
        return iva_opt;
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Mostrar_iva dialog = new Mostrar_iva(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton Reporte;
    private javax.swing.JTextField iva_valor;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla_iva;
    // End of variables declaration//GEN-END:variables
}
