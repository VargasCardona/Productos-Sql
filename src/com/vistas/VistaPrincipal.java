package com.vistas;

import com.utils.ConexionUtils;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class VistaPrincipal extends javax.swing.JFrame {

	public VistaPrincipal() {
            setLocationRelativeTo(this);
            setTitle("Productos");
            initComponents();
            actualizarTabla(null);
	}
        
//        private void logicaBotonBuscar(){
//            String campo = txt.getText();
//            String where = null;
//            if (!campo.equals("")) {
//                where = "WHERE codigo = '"+campo+"'";
//            }
//            actualizarTabla(where);
//        }
        
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

                ResultSet rs = ConexionUtils.realizarConsulta("SELECT * FROM productos");

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

                jScrollPane1 = new javax.swing.JScrollPane();
                tablaProductos = new javax.swing.JTable();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                                .addContainerGap())
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                                .addContainerGap())
                );

                pack();
        }// </editor-fold>//GEN-END:initComponents

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JTable tablaProductos;
        // End of variables declaration//GEN-END:variables
}
