/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prototipointerfaces;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author santiago
 */
public class VentanaFactura extends javax.swing.JFrame {

    String cedula = MóduloFacturaciónVentas.nuevoCliente.numDoc;
    ListaEnlazadaProductos nuevaLista = MóduloFacturaciónVentas.listaF;
    Double precio = MóduloFacturaciónVentas.precioFinal;
    Factura factura = MóduloFacturaciónVentas.nuevaFactura;

    /**
     * Creates new form Proforma
     */
    public VentanaFactura() {
        initComponents();
        setLocationRelativeTo(null);
        mostrarFactura();

    }

    void mostrarFactura() {
        String text = "";
        text += "Factura Nº " + factura.numFactura;
        text += "\n\nCédula del Cliente: " + cedula + "\n";
        text += "\nFecha: " + factura.fecha + "\n\n";

        text += "___________________________________________________________________________\n";

        text += "Código\tNombre\t\tTipo\tCantidad\tPrecio Unitario\n\n";

        text += nuevaLista.mostrar();

        text += "___________________________________________________________________________\n";

        text += "\nTotal a pagar (más IVA): " + precio;

        txaFactura.setText(text);
    }
    
    String detalle(){
        String text = txaFactura.getText();
        return text;
    }

    void guardarFactura(String numFac, String fecha, String cedula, String numDet, String anulado) {
        Conexion con = new Conexion();
        Connection cn = (Connection) con.conexion();

        //PreparedStatement pst = (PreparedStatement) cn.prepareStatement("INSERT INTO facturas(numero_factura,cedula_cliente,valor_total) VALUES(?,?,?)");
        try {
            PreparedStatement pst = (PreparedStatement) cn.prepareStatement("INSERT INTO facturas(numero_factura,fecha,cedula_cliente,numero_detalle,anulada) VALUES(?,?,?,?,?)");
            pst.setString(1, numFac);
            pst.setString(2, fecha);
            pst.setString(3, cedula);
            pst.setString(4, numDet);
            pst.setString(5, anulado);
            //ResultSet rs = pst.executeQuery();
            int a = pst.executeUpdate();
            if (a > 0) {
                JOptionPane.showMessageDialog(null, "¡Factura Guardada Exitosamente!");
            } else {
                JOptionPane.showMessageDialog(null, "ERROR", "Error", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            //Logger.getLogger(MóduloClientes.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    void guardarDetalle(String numDet, String detalle, String anulado) {
        Conexion con = new Conexion();
        Connection cn = (Connection) con.conexion();

        //PreparedStatement pst = (PreparedStatement) cn.prepareStatement("INSERT INTO facturas(numero_factura,cedula_cliente,valor_total) VALUES(?,?,?)");
        try {
            PreparedStatement pst = (PreparedStatement) cn.prepareStatement("INSERT INTO detalle_factura(numero_detalle,detalle,anulado) VALUES(?,?,?)");
            pst.setString(1, numDet);
            pst.setString(2, detalle);
            pst.setString(3, anulado);
            //ResultSet rs = pst.executeQuery();
            int a = pst.executeUpdate();
            if (a > 0) {
                //JOptionPane.showMessageDialog(null, "¡Detalle de Guardada Exitosamente!");
            } else {
                JOptionPane.showMessageDialog(null, "ERROR", "Error", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            //Logger.getLogger(MóduloClientes.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAtrasGF2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaFactura = new javax.swing.JTextArea();
        btnGuardarFactura = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Vendedor de Mostrador");

        btnAtrasGF2.setText("Atrás");
        btnAtrasGF2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasGF2ActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Factura"));

        txaFactura.setColumns(20);
        txaFactura.setRows(5);
        jScrollPane1.setViewportView(txaFactura);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnGuardarFactura.setText("Guardar Factura");
        btnGuardarFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarFacturaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAtrasGF2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGuardarFactura)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAtrasGF2)
                    .addComponent(btnGuardarFactura))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAtrasGF2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasGF2ActionPerformed
        // TODO add your handling code here:
        txaFactura.setText("");
        MóduloFacturaciónVentas.listaF.resetear();
        //----------------------------------------------------------------------
        MóduloFacturaciónVentas nuevoModFacVen = new MóduloFacturaciónVentas();
        nuevoModFacVen.setVisible(true);
        this.dispose();
        //----------------------------------------------------------------------
    }//GEN-LAST:event_btnAtrasGF2ActionPerformed

    private void btnGuardarFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarFacturaActionPerformed
        // TODO add your handling code here:
        //String precioFinal = String.valueOf(factura.precioFinal);
        guardarFactura(factura.numFactura, factura.fecha, factura.cedulaCliente, factura.numDetalle, factura.anulado);
        guardarDetalle(factura.numDetalle, detalle(), "no");
        txaFactura.setText("");
        MóduloFacturaciónVentas.listaF.resetear();
        //----------------------------------------------------------------------
        MóduloFacturaciónVentas nuevoModFacVen = new MóduloFacturaciónVentas();
        nuevoModFacVen.setVisible(true);
        this.dispose();
        //----------------------------------------------------------------------
        
    }//GEN-LAST:event_btnGuardarFacturaActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaFactura().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtrasGF2;
    private javax.swing.JButton btnGuardarFactura;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txaFactura;
    // End of variables declaration//GEN-END:variables
}
