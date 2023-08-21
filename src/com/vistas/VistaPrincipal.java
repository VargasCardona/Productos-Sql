package com.vistas;

public class VistaPrincipal extends javax.swing.JFrame {

	public VistaPrincipal() {
            setLocationRelativeTo(this);
            setTitle("Productos");
            initComponents();
			
			btnActualizar.setEnabled(false);
			btnEliminar.setEnabled(false);
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
        

	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        btnListar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Consultar Base de Datos");
        bg.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 380, 40));

        btnEliminar.setText("Eliminar Producto");
        bg.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 380, 30));

        btnListar.setText("Listar Productos");
        btnListar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnListarMouseClicked(evt);
            }
        });
        bg.add(btnListar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 380, 30));

        btnBuscar.setText("Buscar por SKU");
        bg.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 380, 30));

        btnActualizar.setText("Actualizar Productos");
        bg.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 380, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnListarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnListarMouseClicked
        VistaListar vista = new VistaListar();
		vista.setVisible(true);
    }//GEN-LAST:event_btnListarMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnListar;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
