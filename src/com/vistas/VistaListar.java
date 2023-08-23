package com.vistas;

import com.controladores.ControladorGeneral;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

public class VistaListar extends javax.swing.JFrame {

	ControladorGeneral controlador;
	
	public VistaListar() {
		    controlador = new ControladorGeneral();
		
            this.setLocationRelativeTo(null);
            setTitle("Listar Productos");
			
            initComponents();
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cerrar unicamente la ventana actual
			
			actualizarTabla();
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
        
        private void actualizarTabla() {
            try {
                DefaultTableModel modelo = new DefaultTableModel();
                tablaProductos.setModel(modelo);

                ResultSet rs = controlador.listarTabla();

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

        bg.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 370, 230));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaProductos;
    // End of variables declaration//GEN-END:variables
}
