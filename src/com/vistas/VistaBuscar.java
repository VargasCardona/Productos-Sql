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
			if(modelo.getRowCount() == 1){
				lblSku.setText(rs.getObject(1).toString());
				lblNombre.setText(rs.getObject(2).toString());
				lblPrecio.setText(rs.getObject(3).toString());
				lblDistribuidor.setText(rs.getObject(4).toString());
				lblCategoria.setText(rs.getObject(5).toString());
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
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblCategoria = new javax.swing.JLabel();
        lblDistribuidor = new javax.swing.JLabel();
        lblPrecio = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblSku = new javax.swing.JLabel();

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

        txtSku.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSkuKeyReleased(evt);
            }
        });
        bg.add(txtSku, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 340, 20));

        jLabel3.setText("SKU:");
        bg.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 30, 20));

        jLabel2.setText("SKU:");
        bg.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 100, -1, -1));

        jLabel4.setText("Nombre:");
        bg.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 140, -1, -1));

        jLabel5.setText("Distribuidor:");
        bg.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 220, -1, -1));

        jLabel6.setText("Precio:");
        bg.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 180, -1, -1));

        jLabel7.setText("Categoría:");
        bg.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 260, -1, -1));

        lblCategoria.setText("-");
        bg.add(lblCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 260, 190, -1));

        lblDistribuidor.setText("-");
        bg.add(lblDistribuidor, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 220, 190, -1));

        lblPrecio.setText("-");
        bg.add(lblPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 180, 190, -1));

        lblNombre.setText("-");
        bg.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 140, 190, -1));

        lblSku.setText("-");
        bg.add(lblSku, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 100, 190, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSkuKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSkuKeyReleased
		if (!txtSku.getText().equals("")) {
			actualizarTabla("WHERE sku = '" + txtSku.getText() + "'");
		} else {
			actualizarTabla("");
		}
    }//GEN-LAST:event_txtSkuKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblDistribuidor;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblResultados;
    private javax.swing.JLabel lblSku;
    private javax.swing.JTable tablaProductos;
    private javax.swing.JTextField txtSku;
    // End of variables declaration//GEN-END:variables
}
