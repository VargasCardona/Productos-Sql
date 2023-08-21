package com.vistas;

import com.utils.ConexionUtils;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

public class VistaBuscar extends javax.swing.JFrame {

	public VistaBuscar() {
		this.setLocationRelativeTo(null);
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

			String consulta = "SELECT * FROM productos " + where;
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
			
			if(modelo.getRowCount() == 0){
				lblResultados.setText("No se han encontrado coincidencias");
			} else {
				lblResultados.setText(" ");
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
        lblResultados = new javax.swing.JLabel();
        txtSku = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Buscar por SKU");
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

        bg.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 370, 210));

        lblResultados.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        lblResultados.setForeground(new java.awt.Color(255, 0, 0));
        lblResultados.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblResultados.setText("{Resultados}");
        bg.add(lblResultados, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 370, 30));

        txtSku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSkuActionPerformed(evt);
            }
        });
        txtSku.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSkuKeyReleased(evt);
            }
        });
        bg.add(txtSku, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 340, 20));

        jLabel3.setText("SKU:");
        bg.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 30, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSkuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSkuActionPerformed
		// TODO add your handling code here:
    }//GEN-LAST:event_txtSkuActionPerformed

    private void txtSkuKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSkuKeyReleased
		if (!txtSku.equals("")) {
			actualizarTabla("WHERE sku = '" + txtSku.getText() + "'");
		}
    }//GEN-LAST:event_txtSkuKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblResultados;
    private javax.swing.JTable tablaProductos;
    private javax.swing.JTextField txtSku;
    // End of variables declaration//GEN-END:variables
}
