/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prototipointerfaces;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

/**
 *
 * @author santiago
 */
public class MóduloClientes extends javax.swing.JFrame {

    Cliente nuevoCliente = new Cliente();
    static Cliente nuevoClienteA = new Cliente();
    static String campoActualizar;

    /**
     * Creates new form Interfaz
     */
    public MóduloClientes() {
        initComponents();
        setLocationRelativeTo(null);
        //mostrarTabla();

    }

    void mostrarTabla() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Tipo de Documento");
        modelo.addColumn("Numero de Documento");
        modelo.addColumn("Telefono Celular");
        modelo.addColumn("Direccion");
        modelo.addColumn("Correo");
        modelo.addColumn("Estado");
        tblDatos.setModel(modelo);

        String sql = "SELECT * FROM clientes";

        String datos[] = new String[8];

        Conexion con = new Conexion();
        Connection cn = (Connection) con.conexion();
        Statement st;

        try {
            st = (Statement) cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                datos[6] = rs.getString(7);
                datos[7] = rs.getString(8);
                modelo.addRow(datos);
            }
            tblDatos.setModel(modelo);
        } catch (SQLException e) {
            //Logger.getLogger(MóduloClientes.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    void mostrarInfo(String tipoDoc, String numeroDoc) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Tipo de Documento");
        modelo.addColumn("Numero de Documento");
        modelo.addColumn("Telefono Celular");
        modelo.addColumn("Direccion");
        modelo.addColumn("Correo");
        modelo.addColumn("Estado");
        tblDatos.setModel(modelo);

        String sql = "SELECT * FROM clientes WHERE Numero_de_Documento LIKE ? AND Tipo_de_Documento LIKE ?";
        String datos[] = new String[8];

        Conexion con = new Conexion();
        Connection cn = (Connection) con.conexion();
        PreparedStatement pst;
        ResultSet rs;

        try {
            pst = (PreparedStatement) cn.prepareStatement(sql);
            pst.setString(1, numeroDoc);
            pst.setString(2, tipoDoc);
            rs = pst.executeQuery();
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                datos[6] = rs.getString(7);
                datos[7] = rs.getString(8);
                modelo.addRow(datos);
            }
            tblDatos.setModel(modelo);
        } catch (SQLException e) {

        }
    }

    boolean esCliente(String tipoDoc, String numeroDoc) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Tipo de Documento");
        modelo.addColumn("Numero de Documento");
        modelo.addColumn("Telefono Celular");
        modelo.addColumn("Direccion");
        modelo.addColumn("Correo");
        modelo.addColumn("Estado");
        tblDatos.setModel(modelo);

        String sql = "SELECT * FROM clientes WHERE Numero_de_Documento LIKE ? AND Tipo_de_Documento LIKE ?";
        String datos[] = new String[8];

        Conexion con = new Conexion();
        Connection cn = (Connection) con.conexion();
        PreparedStatement pst;
        ResultSet rs;

        try {
            pst = (PreparedStatement) cn.prepareStatement(sql);
            pst.setString(1, numeroDoc);
            pst.setString(2, tipoDoc);
            rs = pst.executeQuery();
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                datos[6] = rs.getString(7);
                datos[7] = rs.getString(8);
                modelo.addRow(datos);
            }
            if (datos[3] == null) {
                //JOptionPane.showMessageDialog(null, "Cliente no registrado - Primero registre el Cliente");
                return false;
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e);
        }
        return true;

    }

    void eliminarCliente(String numDoc) {
        Conexion con = new Conexion();
        Connection cn = (Connection) con.conexion();
        com.mysql.jdbc.PreparedStatement pstm;
        try {
            pstm = (com.mysql.jdbc.PreparedStatement) cn.prepareStatement("delete from clientes WHERE Numero_de_Documento LIKE ?");
            pstm.setString(1, numDoc);
            pstm.executeUpdate();
        } catch (Exception e) {

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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        lblNombres = new javax.swing.JLabel();
        lblApellidos = new javax.swing.JLabel();
        txtNombreRC = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtApellidoRC = new javax.swing.JTextField();
        txtCorreoRC = new javax.swing.JTextField();
        txtTelCelRC = new javax.swing.JTextField();
        btnRegistrarCliente = new javax.swing.JButton();
        cmbTipoDocumentoRC = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtNumDocumentoRC = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtDireccionRC = new javax.swing.JTextField();
        btnAtrasRC = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        cmbTipoDocumentoAC = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txtNumDocumentoAC = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cmbCampocClienteAC = new javax.swing.JComboBox<>();
        btnSiguienteAC = new javax.swing.JButton();
        btnAtrasAC = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        cmbTipoDocumentoCC = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        txtNumDocumentoCC = new javax.swing.JTextField();
        btnConsultarCliente = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();
        btnAtrasCC = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        cmbTipoDocumentoEC = new javax.swing.JComboBox<>();
        txtNumDocumentoEC = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btnEliminarCliente = new javax.swing.JButton();
        btnAtrasEC = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Vendedor de Mostrador");

        lblNombres.setText("Nombre");

        lblApellidos.setText("Apellido");

        jLabel1.setText("Correo Electrónico");

        jLabel2.setText("Tipo de Documento");

        jLabel3.setText("Teléfono Celular");

        btnRegistrarCliente.setText("Registrar");
        btnRegistrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarClienteActionPerformed(evt);
            }
        });

        cmbTipoDocumentoRC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "RUC", "C.I.", "Pasaporte" }));

        jLabel6.setText("Número de Documento");

        jLabel7.setText("Dirección");

        btnAtrasRC.setText("Atrás");
        btnAtrasRC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasRCActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAtrasRC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRegistrarCliente)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblNombres)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtNombreRC, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblApellidos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtApellidoRC, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmbTipoDocumentoRC, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtTelCelRC, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCorreoRC, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtDireccionRC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(txtNumDocumentoRC, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(87, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombres)
                    .addComponent(txtNombreRC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblApellidos)
                    .addComponent(txtApellidoRC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbTipoDocumentoRC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtNumDocumentoRC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelCelRC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDireccionRC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCorreoRC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrarCliente)
                    .addComponent(btnAtrasRC))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Registrar Cliente", jPanel1);

        jLabel4.setText("Tipo de documento");

        cmbTipoDocumentoAC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar...", "RUC", "C.I.", "Pasaporte" }));

        jLabel8.setText("Número de documento");

        jLabel5.setText("Campo");

        cmbCampocClienteAC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Teléfono celular", "Dirección", "Correo electrónico", "Estado" }));

        btnSiguienteAC.setText("Siguiente");
        btnSiguienteAC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteACActionPerformed(evt);
            }
        });

        btnAtrasAC.setText("Atrás");
        btnAtrasAC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasACActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAtrasAC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSiguienteAC)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtNumDocumentoAC, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbCampocClienteAC, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbTipoDocumentoAC, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(98, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbTipoDocumentoAC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNumDocumentoAC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbCampocClienteAC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSiguienteAC)
                    .addComponent(btnAtrasAC))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Actualizar Cliente", jPanel2);

        jLabel9.setText("Tipo de Documento");

        cmbTipoDocumentoCC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "RUC", "C.I.", "Pasaporte" }));

        jLabel10.setText("Número de documento");

        btnConsultarCliente.setText("Consultar");
        btnConsultarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarClienteActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Datos"));

        tblDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Apellido", "Teléfono Celular", "Dirección", "Correo", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblDatos);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnAtrasCC.setText("Atrás");
        btnAtrasCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasCCActionPerformed(evt);
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
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnAtrasCC)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbTipoDocumentoCC, 0, 190, Short.MAX_VALUE)
                            .addComponent(txtNumDocumentoCC))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnConsultarCliente)
                        .addGap(53, 53, 53))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel10))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(cmbTipoDocumentoCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNumDocumentoCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(btnConsultarCliente)))
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAtrasCC)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Consultar Cliente", jPanel3);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Eliminar"));

        cmbTipoDocumentoEC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "RUC", "C.I.", "Pasaporte" }));

        jLabel11.setText("Tipo de Documento");

        jLabel12.setText("Número de documento");

        btnEliminarCliente.setText("Eliminar Cliente");
        btnEliminarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel11))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNumDocumentoEC)
                            .addComponent(cmbTipoDocumentoEC, 0, 200, Short.MAX_VALUE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(187, 187, 187)
                        .addComponent(btnEliminarCliente)))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbTipoDocumentoEC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNumDocumentoEC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(btnEliminarCliente)
                .addContainerGap())
        );

        btnAtrasEC.setText("Atrás");
        btnAtrasEC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasECActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btnAtrasEC)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAtrasEC)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Eliminar Cliente", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarClienteActionPerformed
        // TODO add your handling code here:
        String nombre;
        String apellido;
        String tipoDoc;
        String numDoc;
        String telf;
        String direccion;
        String correo;
        String estado;
        if (txtNombreRC.getText().equals("")
                || txtApellidoRC.getText().equals("")
                || txtNumDocumentoRC.getText().equals("")
                || txtTelCelRC.getText().equals("")
                || txtDireccionRC.getText().equals("")
                || txtCorreoRC.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Para registrar un cliente debe llenar TODOS los campos", "Error", JOptionPane.WARNING_MESSAGE);
        } else {
            Conexion con = new Conexion();
            Connection cn = (Connection) con.conexion();
            try {
                PreparedStatement pps = (PreparedStatement) cn.prepareStatement("INSERT INTO clientes(Nombre,Apellido,Tipo_de_Documento,Numero_de_Documento,Telefono_Celular,Direccion,Correo_Electronico,Estado) VALUES(?,?,?,?,?,?,?,?)");

                nombre = txtNombreRC.getText();
                if (!nuevoCliente.esNombreValido(nombre)) {
                    //JOptionPane.showMessageDialog(null, "Nombre incorrecto", "Error", JOptionPane.WARNING_MESSAGE);
                    JOptionPane.showMessageDialog(null, "Datos del cliente incorrectos - Corrija", "Error", JOptionPane.WARNING_MESSAGE);
                } else {
                    nuevoCliente.nombre = nombre;
                    apellido = txtApellidoRC.getText();
                    if (!nuevoCliente.esApellidoValido(apellido)) {
                        //JOptionPane.showMessageDialog(null, "Apellido incorrecto", "Error", JOptionPane.WARNING_MESSAGE);
                        JOptionPane.showMessageDialog(null, "Datos del cliente incorrectos - Corrija", "Error", JOptionPane.WARNING_MESSAGE);
                    } else {
                        nuevoCliente.apellido = apellido;
                        tipoDoc = String.valueOf(cmbTipoDocumentoRC.getSelectedItem());
                        nuevoCliente.tipoDoc = tipoDoc;
                        switch (tipoDoc) {
                            case "C.I.":
                                numDoc = txtNumDocumentoRC.getText();
                                if (numDoc.length() < 10) {
                                    //JOptionPane.showMessageDialog(null, "Número de cédula invalido", "Error", JOptionPane.WARNING_MESSAGE);
                                    JOptionPane.showMessageDialog(null, "Número de Documento Incorrecto - Vuelva a Ingresar", "Error", JOptionPane.WARNING_MESSAGE);
                                } else {
                                    nuevoCliente.numDoc = numDoc;
                                    if (!nuevoCliente.esDocumentoValido()) {
                                        //JOptionPane.showMessageDialog(null, "Cédula incorrecta", "Error", JOptionPane.WARNING_MESSAGE);
                                        JOptionPane.showMessageDialog(null, "Número de Documento Incorrecto - Vuelva a Ingresar", "Error", JOptionPane.WARNING_MESSAGE);
                                    } else {
                                        if (esCliente(nuevoCliente.tipoDoc, nuevoCliente.numDoc)) {
                                            JOptionPane.showMessageDialog(null, "Cliente ya registrado - Ingrese un nuevo Cliente");
                                        } else {
                                            telf = txtTelCelRC.getText();
                                            if (!nuevoCliente.esTelefonoValido(telf)) {
                                                //JOptionPane.showMessageDialog(null, "Teléfono incorrecto", "Error", JOptionPane.WARNING_MESSAGE);
                                                JOptionPane.showMessageDialog(null, "Datos del cliente incorrectos - Corrija", "Error", JOptionPane.WARNING_MESSAGE);
                                            } else {
                                                nuevoCliente.telf = telf;
                                                direccion = txtDireccionRC.getText();
                                                if (!nuevoCliente.esDireccionValido(direccion)) {
                                                    //JOptionPane.showMessageDialog(null, "Direccion incorrecta", "Error", JOptionPane.WARNING_MESSAGE);
                                                    JOptionPane.showMessageDialog(null, "Datos del cliente incorrectos - Corrija", "Error", JOptionPane.WARNING_MESSAGE);
                                                } else {
                                                    nuevoCliente.direccion = direccion;
                                                    correo = txtCorreoRC.getText();
                                                    if (!nuevoCliente.esCorreoValido(correo)) {
                                                        //JOptionPane.showMessageDialog(null, "Correo incorrecto", "Error", JOptionPane.WARNING_MESSAGE);
                                                        JOptionPane.showMessageDialog(null, "Datos del cliente incorrectos - Corrija", "Error", JOptionPane.WARNING_MESSAGE);
                                                    } else {
                                                        nuevoCliente.correo = correo;
                                                        nuevoCliente.estado = "Activo";
                                                        pps.setString(1, nuevoCliente.nombre);
                                                        pps.setString(2, nuevoCliente.apellido);
                                                        pps.setString(3, nuevoCliente.tipoDoc);
                                                        pps.setString(4, nuevoCliente.numDoc);
                                                        pps.setString(5, nuevoCliente.telf);
                                                        pps.setString(6, nuevoCliente.direccion);
                                                        pps.setString(7, nuevoCliente.correo);
                                                        pps.setString(8, nuevoCliente.estado);

                                                        int a = pps.executeUpdate();
                                                        if (a > 0) {
                                                            JOptionPane.showMessageDialog(null, "¡Cliente Registrado Exitosamente!");
                                                        } else {
                                                            JOptionPane.showMessageDialog(null, "ERROR", "Error", JOptionPane.WARNING_MESSAGE);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                break;
                            case "Pasaporte":
                                numDoc = txtNumDocumentoRC.getText();
                                if (numDoc.length() < 10) {
                                    //JOptionPane.showMessageDialog(null, "Pasaporte invalido", "Error", JOptionPane.WARNING_MESSAGE);
                                    JOptionPane.showMessageDialog(null, "Número de Documento Incorrecto - Vuelva a Ingresar", "Error", JOptionPane.WARNING_MESSAGE);
                                } else {
                                    nuevoCliente.numDoc = numDoc;
                                    if (!nuevoCliente.esDocumentoValido()) {
                                        //JOptionPane.showMessageDialog(null, "Pasaporte incorrecto", "Error", JOptionPane.WARNING_MESSAGE);
                                        JOptionPane.showMessageDialog(null, "Número de Documento Incorrecto - Vuelva a Ingresar", "Error", JOptionPane.WARNING_MESSAGE);
                                    } else {
                                        if (esCliente(nuevoCliente.tipoDoc, nuevoCliente.numDoc)) {
                                            JOptionPane.showMessageDialog(null, "Cliente ya registrado - Ingrese un nuevo Cliente");
                                        } else {
                                            telf = txtTelCelRC.getText();
                                            if (!nuevoCliente.esTelefonoValido(telf)) {
                                                //JOptionPane.showMessageDialog(null, "Teléfono incorrecto", "Error", JOptionPane.WARNING_MESSAGE);
                                                JOptionPane.showMessageDialog(null, "Datos del cliente incorrectos - Corrija", "Error", JOptionPane.WARNING_MESSAGE);
                                            } else {

                                                nuevoCliente.telf = telf;
                                                direccion = txtDireccionRC.getText();
                                                if (!nuevoCliente.esDireccionValido(direccion)) {
                                                    //JOptionPane.showMessageDialog(null, "Direccion incorrecta", "Error", JOptionPane.WARNING_MESSAGE);
                                                    JOptionPane.showMessageDialog(null, "Datos del cliente incorrectos - Corrija", "Error", JOptionPane.WARNING_MESSAGE);
                                                } else {
                                                    nuevoCliente.direccion = direccion;
                                                    correo = txtCorreoRC.getText();
                                                    if (!nuevoCliente.esCorreoValido(correo)) {
                                                        //JOptionPane.showMessageDialog(null, "Correo incorrecto", "Error", JOptionPane.WARNING_MESSAGE);
                                                        JOptionPane.showMessageDialog(null, "Datos del cliente incorrectos - Corrija", "Error", JOptionPane.WARNING_MESSAGE);
                                                    } else {
                                                        nuevoCliente.correo = correo;
                                                        nuevoCliente.estado = "Activo";
                                                        pps.setString(1, nuevoCliente.nombre);
                                                        pps.setString(2, nuevoCliente.apellido);
                                                        pps.setString(3, nuevoCliente.tipoDoc);
                                                        pps.setString(4, nuevoCliente.numDoc);
                                                        pps.setString(5, nuevoCliente.telf);
                                                        pps.setString(6, nuevoCliente.direccion);
                                                        pps.setString(7, nuevoCliente.correo);
                                                        pps.setString(8, nuevoCliente.estado);

                                                        int a = pps.executeUpdate();
                                                        if (a > 0) {
                                                            JOptionPane.showMessageDialog(null, "¡Cliente Registrado Exitosamente!");
                                                        } else {
                                                            JOptionPane.showMessageDialog(null, "ERROR", "Error", JOptionPane.WARNING_MESSAGE);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                break;
                            case "RUC":
                                numDoc = txtNumDocumentoRC.getText();
                                if (numDoc.length() < 13) {
                                    //JOptionPane.showMessageDialog(null, "Número de RUC invalido", "Error", JOptionPane.WARNING_MESSAGE);
                                    JOptionPane.showMessageDialog(null, "Número de Documento Incorrecto - Vuelva a Ingresar", "Error", JOptionPane.WARNING_MESSAGE);
                                } else {
                                    nuevoCliente.numDoc = numDoc;
                                    if (!nuevoCliente.esDocumentoValido()) {
                                        //JOptionPane.showMessageDialog(null, "RUC incorrecto", "Error", JOptionPane.WARNING_MESSAGE);
                                        JOptionPane.showMessageDialog(null, "Número de Documento Incorrecto - Vuelva a Ingresar", "Error", JOptionPane.WARNING_MESSAGE);
                                    } else {
                                        if (esCliente(nuevoCliente.tipoDoc, nuevoCliente.numDoc)) {
                                            JOptionPane.showMessageDialog(null, "Cliente ya registrado - Ingrese un nuevo Cliente");
                                        } else {
                                            telf = txtTelCelRC.getText();
                                            if (!nuevoCliente.esTelefonoValido(telf)) {
                                                //JOptionPane.showMessageDialog(null, "Teléfono incorrecto", "Error", JOptionPane.WARNING_MESSAGE);
                                                JOptionPane.showMessageDialog(null, "Datos del cliente incorrectos - Corrija", "Error", JOptionPane.WARNING_MESSAGE);
                                            } else {
                                                nuevoCliente.telf = telf;
                                                direccion = txtDireccionRC.getText();
                                                if (!nuevoCliente.esDireccionValido(direccion)) {
                                                    //JOptionPane.showMessageDialog(null, "Direccion incorrecta", "Error", JOptionPane.WARNING_MESSAGE);
                                                    JOptionPane.showMessageDialog(null, "Datos del cliente incorrectos - Corrija", "Error", JOptionPane.WARNING_MESSAGE);
                                                } else {
                                                    nuevoCliente.direccion = direccion;
                                                    correo = txtCorreoRC.getText();
                                                    if (!nuevoCliente.esCorreoValido(correo)) {
                                                        //JOptionPane.showMessageDialog(null, "Correo incorrecto", "Error", JOptionPane.WARNING_MESSAGE);
                                                        JOptionPane.showMessageDialog(null, "Datos del cliente incorrectos - Corrija", "Error", JOptionPane.WARNING_MESSAGE);
                                                    } else {
                                                        nuevoCliente.correo = correo;
                                                        nuevoCliente.estado = "Activo";
                                                        pps.setString(1, nuevoCliente.nombre);
                                                        pps.setString(2, nuevoCliente.apellido);
                                                        pps.setString(3, nuevoCliente.tipoDoc);
                                                        pps.setString(4, nuevoCliente.numDoc);
                                                        pps.setString(5, nuevoCliente.telf);
                                                        pps.setString(6, nuevoCliente.direccion);
                                                        pps.setString(7, nuevoCliente.correo);
                                                        pps.setString(8, nuevoCliente.estado);

                                                        int a = pps.executeUpdate();
                                                        if (a > 0) {
                                                            JOptionPane.showMessageDialog(null, "¡Cliente Registrado Exitosamente!");
                                                        } else {
                                                            JOptionPane.showMessageDialog(null, "ERROR", "Error", JOptionPane.WARNING_MESSAGE);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                break;
                        }
                    }
                }

            } catch (Exception e) {
                System.err.println("Error: " + e);
            }
        }


    }//GEN-LAST:event_btnRegistrarClienteActionPerformed

    private void btnAtrasRCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasRCActionPerformed
        // TODO add your handling code here:
        VendedorDeMostrador nuevoVendedor = new VendedorDeMostrador();
        nuevoVendedor.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAtrasRCActionPerformed

    private void btnAtrasACActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasACActionPerformed
        // TODO add your handling code here:
        VendedorDeMostrador nuevoVendedor = new VendedorDeMostrador();
        nuevoVendedor.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAtrasACActionPerformed

    private void btnAtrasCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasCCActionPerformed
        // TODO add your handling code here:
        VendedorDeMostrador nuevoVendedor = new VendedorDeMostrador();
        nuevoVendedor.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAtrasCCActionPerformed

    private void btnAtrasECActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasECActionPerformed
        // TODO add your handling code here:
        VendedorDeMostrador nuevoVendedor = new VendedorDeMostrador();
        nuevoVendedor.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAtrasECActionPerformed

    private void btnSiguienteACActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteACActionPerformed
        // TODO add your handling code here:
        try {
            String tipoDoc = String.valueOf(cmbTipoDocumentoAC.getSelectedItem());
            nuevoClienteA.tipoDoc = tipoDoc;
            switch (tipoDoc) {
                case "C.I.":
                    nuevoClienteA.numDoc = txtNumDocumentoAC.getText();
                    if (nuevoClienteA.numDoc.length() < 10) {
                        //JOptionPane.showMessageDialog(null, "Número de cédula invalido", "Error", JOptionPane.WARNING_MESSAGE);
                        JOptionPane.showMessageDialog(null, "Número de Documento Incorrecto - Vuelva a Ingresar", "Error", JOptionPane.WARNING_MESSAGE);
                    } else {
                        if (!nuevoClienteA.esDocumentoValido()) {
                            //JOptionPane.showMessageDialog(null, "Cédula incorrecta", "Error", JOptionPane.WARNING_MESSAGE);
                            JOptionPane.showMessageDialog(null, "Número de Documento Incorrecto - Vuelva a Ingresar", "Error", JOptionPane.WARNING_MESSAGE);
                            txtNumDocumentoAC.setText("");
                        } else {
                            if (!esCliente(nuevoClienteA.tipoDoc, nuevoClienteA.numDoc)) {
                                JOptionPane.showMessageDialog(null, "Cliente no registrado - Primero registre el Cliente");
                            } else {

                                String campo = String.valueOf(cmbCampocClienteAC.getSelectedItem());
                                switch (campo) {
                                    case "Nombre":
                                        campoActualizar = "Nombre";
                                        break;
                                    case "Apellido":
                                        campoActualizar = "Apellido";
                                        break;
                                    case "Teléfono celular":
                                        campoActualizar = "Telefono_Celular";
                                        break;
                                    case "Dirección":
                                        campoActualizar = "Direccion";
                                        break;
                                    case "Correo electrónico":
                                        campoActualizar = "Correo_Electronico";
                                        break;
                                    case "Estado":
                                        campoActualizar = "Estado";
                                        break;
                                }
                                //----------------------------------------------------------------------
                                ActualizarDatoCliente nuevaActualizacion = new ActualizarDatoCliente();
                                nuevaActualizacion.setVisible(true);
                                this.dispose();
                                //----------------------------------------------------------------------
                            }
                        }
                    }
                    break;
                case "RUC":
                    nuevoClienteA.numDoc = txtNumDocumentoAC.getText();
                    if (nuevoClienteA.numDoc.length() < 13) {
                        //JOptionPane.showMessageDialog(null, "RUC invalido", "Error", JOptionPane.WARNING_MESSAGE);
                        JOptionPane.showMessageDialog(null, "Número de Documento Incorrecto - Vuelva a Ingresar", "Error", JOptionPane.WARNING_MESSAGE);
                    } else {
                        if (!nuevoClienteA.esDocumentoValido()) {
                            //JOptionPane.showMessageDialog(null, "RUC incorrecto", "Error", JOptionPane.WARNING_MESSAGE);
                            JOptionPane.showMessageDialog(null, "Número de Documento Incorrecto - Vuelva a Ingresar", "Error", JOptionPane.WARNING_MESSAGE);
                            txtNumDocumentoAC.setText("");
                        } else {
                            if (!esCliente(nuevoClienteA.tipoDoc, nuevoClienteA.numDoc)) {
                                JOptionPane.showMessageDialog(null, "Cliente no registrado - Primero registre el Cliente");
                            } else {
                                String campo = String.valueOf(cmbCampocClienteAC.getSelectedItem());
                                switch (campo) {
                                    case "Nombre":
                                        campoActualizar = "Nombre";
                                        break;
                                    case "Apellido":
                                        campoActualizar = "Apellido";
                                        break;
                                    case "Teléfono celular":
                                        campoActualizar = "Telefono_Celular";
                                        break;
                                    case "Dirección":
                                        campoActualizar = "Direccion";
                                        break;
                                    case "Correo electrónico":
                                        campoActualizar = "Correo_Electronico";
                                        break;
                                    case "Estado":
                                        campoActualizar = "Estado";
                                        break;
                                }
                                //----------------------------------------------------------------------
                                ActualizarDatoCliente nuevaActualizacion = new ActualizarDatoCliente();
                                nuevaActualizacion.setVisible(true);
                                this.dispose();
                                //----------------------------------------------------------------------
                            }
                        }
                    }
                    break;
                case "Pasaporte":
                    nuevoClienteA.numDoc = txtNumDocumentoAC.getText();
                    if (nuevoClienteA.numDoc.length() < 10) {
                        //JOptionPane.showMessageDialog(null, "Pasaporte invalido", "Error", JOptionPane.WARNING_MESSAGE);
                        JOptionPane.showMessageDialog(null, "Número de Documento Incorrecto - Vuelva a Ingresar", "Error", JOptionPane.WARNING_MESSAGE);
                    } else {
                        if (!nuevoClienteA.esDocumentoValido()) {
                            //JOptionPane.showMessageDialog(null, "Pasaporte incorrecto", "Error", JOptionPane.WARNING_MESSAGE);
                            JOptionPane.showMessageDialog(null, "Número de Documento Incorrecto - Vuelva a Ingresar", "Error", JOptionPane.WARNING_MESSAGE);
                            txtNumDocumentoAC.setText("");
                        } else {
                            if (!esCliente(nuevoClienteA.tipoDoc, nuevoClienteA.numDoc)) {
                                JOptionPane.showMessageDialog(null, "Cliente no registrado - Primero registre el Cliente");
                            } else {
                                String campo = String.valueOf(cmbCampocClienteAC.getSelectedItem());
                                switch (campo) {
                                    case "Nombre":
                                        campoActualizar = "Nombre";
                                        break;
                                    case "Apellido":
                                        campoActualizar = "Apellido";
                                        break;
                                    case "Teléfono celular":
                                        campoActualizar = "Telefono_Celular";
                                        break;
                                    case "Dirección":
                                        campoActualizar = "Direccion";
                                        break;
                                    case "Correo electrónico":
                                        campoActualizar = "Correo_Electronico";
                                        break;
                                    case "Estado":
                                        campoActualizar = "Estado";
                                        break;
                                }
                                //----------------------------------------------------------------------
                                ActualizarDatoCliente nuevaActualizacion = new ActualizarDatoCliente();
                                nuevaActualizacion.setVisible(true);
                                this.dispose();
                                //----------------------------------------------------------------------
                            }
                        }
                    }
                    break;
                case "Seleccionar...":
                    JOptionPane.showMessageDialog(null, "¡Seleccione una Opción!");
                    break;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }


    }//GEN-LAST:event_btnSiguienteACActionPerformed

    private void btnConsultarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarClienteActionPerformed
        // TODO add your handling code here:
        nuevoCliente.tipoDoc = String.valueOf(cmbTipoDocumentoCC.getSelectedItem());
        nuevoCliente.numDoc = String.valueOf(txtNumDocumentoCC.getText());
        switch (nuevoCliente.tipoDoc) {
            case "C.I.":
                if (nuevoCliente.numDoc.length() < 10) {
                    //JOptionPane.showMessageDialog(null, "Número de cédula invalido, caracteres insuhdsuhas", "Error", JOptionPane.WARNING_MESSAGE);
                    JOptionPane.showMessageDialog(null, "Número de Documento Incorrecto - Vuelva a Ingresar", "Error", JOptionPane.WARNING_MESSAGE);
                } else {
                    if (!nuevoCliente.esDocumentoValido()) {
                        //JOptionPane.showMessageDialog(null, "Cédula incorrecta o no registrada", "Error", JOptionPane.WARNING_MESSAGE);
                        JOptionPane.showMessageDialog(null, "Número de Documento Incorrecto - Vuelva a Ingresar", "Error", JOptionPane.WARNING_MESSAGE);
                        txtNumDocumentoCC.setText("");

                    } else {
                        if (!esCliente(nuevoCliente.tipoDoc, nuevoCliente.numDoc)) {
                            JOptionPane.showMessageDialog(null, "Cliente no Registrado - Primero registre el Cliente", "Error", JOptionPane.WARNING_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Cliente Encontrado");
                            mostrarInfo(nuevoCliente.tipoDoc, nuevoCliente.numDoc);
                        }

                    }
                }
                break;
            case "RUC":
                if (nuevoCliente.numDoc.length() < 13) {
                    //JOptionPane.showMessageDialog(null, "RUC invalido", "Error", JOptionPane.WARNING_MESSAGE);
                    JOptionPane.showMessageDialog(null, "Número de Documento Incorrecto - Vuelva a Ingresar", "Error", JOptionPane.WARNING_MESSAGE);
                } else {
                    if (!nuevoCliente.esDocumentoValido()) {
                        //JOptionPane.showMessageDialog(null, "RUC incorrecto o no registrado", "Error", JOptionPane.WARNING_MESSAGE);
                        JOptionPane.showMessageDialog(null, "Número de Documento Incorrecto - Vuelva a Ingresar", "Error", JOptionPane.WARNING_MESSAGE);
                        txtNumDocumentoCC.setText("");
                    } else {
                        if (!esCliente(nuevoCliente.tipoDoc, nuevoCliente.numDoc)) {
                            JOptionPane.showMessageDialog(null, "Cliente no Registrado - Primero registre el Cliente", "Error", JOptionPane.WARNING_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Cliente Encontrado");
                            mostrarInfo(nuevoCliente.tipoDoc, nuevoCliente.numDoc);
                        }
                    }
                }
                break;
            case "Pasaporte":
                if (nuevoCliente.numDoc.length() < 10) {
                    //JOptionPane.showMessageDialog(null, "Pasaporte invalido", "Error", JOptionPane.WARNING_MESSAGE);
                    JOptionPane.showMessageDialog(null, "Número de Documento Incorrecto - Vuelva a Ingresar", "Error", JOptionPane.WARNING_MESSAGE);
                } else {
                    if (!nuevoCliente.esDocumentoValido()) {
                        //JOptionPane.showMessageDialog(null, "Psaporte incorrecto o no registrado", "Error", JOptionPane.WARNING_MESSAGE);
                        JOptionPane.showMessageDialog(null, "Número de Documento Incorrecto - Vuelva a Ingresar", "Error", JOptionPane.WARNING_MESSAGE);
                        txtNumDocumentoCC.setText("");
                    } else {
                        if (!esCliente(nuevoCliente.tipoDoc, nuevoCliente.numDoc)) {
                            JOptionPane.showMessageDialog(null, "Cliente no Registrado - Primero registre el Cliente", "Error", JOptionPane.WARNING_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Cliente Encontrado");
                            mostrarInfo(nuevoCliente.tipoDoc, nuevoCliente.numDoc);
                        }
                    }
                }
                break;
            default:
                break;
        }
    }//GEN-LAST:event_btnConsultarClienteActionPerformed

    private void btnEliminarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarClienteActionPerformed
        // TODO add your handling code here:
        nuevoCliente.tipoDoc = String.valueOf(cmbTipoDocumentoEC.getSelectedItem());
        nuevoCliente.numDoc = String.valueOf(txtNumDocumentoEC.getText());
        switch (nuevoCliente.tipoDoc) {
            case "C.I.":
                if (nuevoCliente.numDoc.length() < 10) {
                    JOptionPane.showMessageDialog(null, "Número de Documento Incorrecto - Vuelva a Ingresar", "Error", JOptionPane.WARNING_MESSAGE);
                } else {
                    if (!nuevoCliente.esDocumentoValido()) {
                        //JOptionPane.showMessageDialog(null, "Cédula incorrecta", "Error", JOptionPane.WARNING_MESSAGE);
                        JOptionPane.showMessageDialog(null, "Número de Documento Incorrecto - Vuelva a Ingresar", "Error", JOptionPane.WARNING_MESSAGE);
                        txtNumDocumentoEC.setText("");
                    } else {
                        if (!esCliente(nuevoCliente.tipoDoc, nuevoCliente.numDoc)) {
                            JOptionPane.showMessageDialog(null, "Cliente no Registrado - Primero registre el Cliente", "Error", JOptionPane.WARNING_MESSAGE);
                        } else {
                            int confirmacion = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar al Cliente?", "ALERTA", WIDTH);
                            switch (confirmacion) {
                                case JOptionPane.YES_OPTION:
                                    eliminarCliente(nuevoCliente.numDoc);
                                    JOptionPane.showMessageDialog(null, "Cliente Eliminado Exitosamente");
                                    break;
                                case JOptionPane.NO_OPTION:
                                    JOptionPane.showMessageDialog(null, "Ha cancelado la operación");
                                    break;
                                case JOptionPane.CANCEL_OPTION:
                                    JOptionPane.showMessageDialog(null, "Ha cancelado la operación");
                                    break;
                                default:
                                    break;
                            }
                            
                            
                        }

                    }
                }
                break;
            case "RUC":
                if (nuevoCliente.numDoc.length() < 10) {
                    //JOptionPane.showMessageDialog(null, "Número de cédula invalido", "Error", JOptionPane.WARNING_MESSAGE);
                    JOptionPane.showMessageDialog(null, "Número de Documento Incorrecto - Vuelva a Ingresar", "Error", JOptionPane.WARNING_MESSAGE);
                } else {
                    if (!nuevoCliente.esDocumentoValido()) {
                        //JOptionPane.showMessageDialog(null, "Cédula incorrecta", "Error", JOptionPane.WARNING_MESSAGE);
                        JOptionPane.showMessageDialog(null, "Número de Documento Incorrecto - Vuelva a Ingresar", "Error", JOptionPane.WARNING_MESSAGE);
                        txtNumDocumentoEC.setText("");
                    } else {
                        if (!esCliente(nuevoCliente.tipoDoc, nuevoCliente.numDoc)) {
                            JOptionPane.showMessageDialog(null, "Cliente no Registrado - Primero registre el Cliente", "Error", JOptionPane.WARNING_MESSAGE);
                        } else {
                            int confirmacion = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar al Cliente?", "ALERTA", WIDTH);
                            switch (confirmacion) {
                                case JOptionPane.YES_OPTION:
                                    eliminarCliente(nuevoCliente.numDoc);
                                    JOptionPane.showMessageDialog(null, "Cliente Eliminado Exitosamente");
                                    break;
                                case JOptionPane.NO_OPTION:
                                    JOptionPane.showMessageDialog(null, "Ha cancelado la operación");
                                    break;
                                case JOptionPane.CANCEL_OPTION:
                                    JOptionPane.showMessageDialog(null, "Ha cancelado la operación");
                                    break;
                                default:
                                    break;
                            }
                        }
                    }
                }
                break;
            case "Pasaporte":
                if (nuevoCliente.numDoc.length() < 10) {
                    //JOptionPane.showMessageDialog(null, "Número de cédula invalido", "Error", JOptionPane.WARNING_MESSAGE);
                    JOptionPane.showMessageDialog(null, "Número de Documento Incorrecto - Vuelva a Ingresar", "Error", JOptionPane.WARNING_MESSAGE);
                } else {
                    if (!nuevoCliente.esDocumentoValido()) {
                        //JOptionPane.showMessageDialog(null, "Cédula incorrecta", "Error", JOptionPane.WARNING_MESSAGE);
                        JOptionPane.showMessageDialog(null, "Número de Documento Incorrecto - Vuelva a Ingresar", "Error", JOptionPane.WARNING_MESSAGE);
                        txtNumDocumentoEC.setText("");
                    } else {
                        if (!esCliente(nuevoCliente.tipoDoc, nuevoCliente.numDoc)) {
                            JOptionPane.showMessageDialog(null, "Cliente no Registrado - Primero registre el Cliente", "Error", JOptionPane.WARNING_MESSAGE);
                        } else {
                            int confirmacion = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar al Cliente?", "ALERTA", WIDTH);
                            switch (confirmacion) {
                                case JOptionPane.YES_OPTION:
                                    eliminarCliente(nuevoCliente.numDoc);
                                    JOptionPane.showMessageDialog(null, "Cliente Eliminado Exitosamente");
                                    break;
                                case JOptionPane.NO_OPTION:
                                    JOptionPane.showMessageDialog(null, "Ha cancelado la operación");
                                    break;
                                case JOptionPane.CANCEL_OPTION:
                                    JOptionPane.showMessageDialog(null, "Ha cancelado la operación");
                                    break;
                                default:
                                    break;
                            }
                        }
                    }
                }
                break;
            default:
                break;
        }
    }//GEN-LAST:event_btnEliminarClienteActionPerformed

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
            java.util.logging.Logger.getLogger(MóduloClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MóduloClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MóduloClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MóduloClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MóduloClientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtrasAC;
    private javax.swing.JButton btnAtrasCC;
    private javax.swing.JButton btnAtrasEC;
    private javax.swing.JButton btnAtrasRC;
    private javax.swing.JButton btnConsultarCliente;
    private javax.swing.JButton btnEliminarCliente;
    private javax.swing.JButton btnRegistrarCliente;
    private javax.swing.JButton btnSiguienteAC;
    private javax.swing.JComboBox<String> cmbCampocClienteAC;
    private javax.swing.JComboBox<String> cmbTipoDocumentoAC;
    private javax.swing.JComboBox<String> cmbTipoDocumentoCC;
    private javax.swing.JComboBox<String> cmbTipoDocumentoEC;
    private javax.swing.JComboBox<String> cmbTipoDocumentoRC;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
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
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblApellidos;
    private javax.swing.JLabel lblNombres;
    private javax.swing.JTable tblDatos;
    private javax.swing.JTextField txtApellidoRC;
    private javax.swing.JTextField txtCorreoRC;
    private javax.swing.JTextField txtDireccionRC;
    private javax.swing.JTextField txtNombreRC;
    private javax.swing.JTextField txtNumDocumentoAC;
    private javax.swing.JTextField txtNumDocumentoCC;
    private javax.swing.JTextField txtNumDocumentoEC;
    private javax.swing.JTextField txtNumDocumentoRC;
    private javax.swing.JTextField txtTelCelRC;
    // End of variables declaration//GEN-END:variables
}
