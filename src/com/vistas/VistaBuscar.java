package com.vistas;

import com.utils.ConexionUtils;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

public class VistaBuscar extends javax.swing.JFrame {

    public VistaBuscar() {
        setLocationRelativeTo(this);
        setTitle("Buscar Productos");

        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cerrar unicamente la ventana actual

        actualizarTabla("");
        tablaProductos.setDefaultEditor(Object.class, null); // Evitar ediciones en la tabla
        tablaProductos.getTableHeader().setEnabled(false); // Evitar reorganizaciones de Headers en la tabla
        tablaProductos.setCellSelectionEnabled(false); // Evitar selecciones en la tabla
    }
               
//        private void logicaBotonCrear(){
//            String sku = txt.getText();
//            String nombre = txt.getText();
//            String precio = txt.getText();
//            String distribuidor = txt.getText();
//            String categorias = txt.getText();
//            
//            if (!precio.esNumero()) {
//                JOptionPane.showMessageDialog(null, "El precio debe ser escrito en dígitos");
//                return;
//            }
//            
//            String sql = "INSERT INTO `estudiantes` (`nombre`, `edad`, `cedula`, `codigo`, `id`) VALUES ('Dejan Stankovic', '23', '76132', '12', NULL);";
//        }
        
        private void actualizarTabla(String where) {
            try {
                DefaultTableModel modelo = new DefaultTableModel();
                tablaProductos.setModel(modelo);

                String consulta = "SELECT * FROM productos "+where;
                ResultSet rs = ConexionUtils.realizarConsulta(consulta);

                ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
                int cantidadColumnas = rsMd.getColumnCount();

                modelo.addColumn("SKU:");
                modelo.addColumn("Nombre:");
                modelo.addColumn("Precio:");
                modelo.addColumn("Distribuidor:");
                modelo.addColumn("Categorias:");

                int[] anchos = {50, 50, 50, 50, 50};
                for (int i = 0; i < tablaProductos.getColumnCount(); i++) {
                    tablaProductos.getColumnModel().getColumn(i).setPreferredWidth(anchos[1]);
                }
                while (rs.next()) {
                    Object[] filas = new Object[cantidadColumnas];
                    for (int i = 0; i < cantidadColumnas; i++) {
                        filas[i] = rs.getObject(i + 1);
                    }
                    modelo.addRow(filas);
                }
            } catch (SQLException e) {
                System.err.println(e.toString());
            }
        }

	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtSku = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Productos Registrados");
        bg.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 370, 50));

        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablaProductos);

        bg.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 370, 230));

        jLabel2.setText("SKU:");
        bg.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        txtSku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSkuActionPerformed(evt);
            }
        });
        bg.add(txtSku, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 200, 20));

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        bg.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, -1, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSkuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSkuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSkuActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String campo = txtSku.getText();
        String where = "";
        if (!campo.equals("")) {
            where = "WHERE sku = '"+campo+"'";
        }
        actualizarTabla(where);
    }//GEN-LAST:event_btnBuscarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaProductos;
    private javax.swing.JTextField txtSku;
    // End of variables declaration//GEN-END:variables
}
