import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class frmEstudiantes extends javax.swing.JFrame {

    Conexion c = new Conexion();
    EstudiantesDAO e = new EstudiantesDAO();
    Estudiantes est = new Estudiantes();
    
    String nomb="";
    String apel="";
    String fecha = "";
    String correoI="";
    String corP="";
    long cel=0;
    long fij=0;
    String prog="";
    
    /**
     * Creates new form frmEstudiantes
     */
    public frmEstudiantes() {
        initComponents();
        c.abrirConexion();
        mostrarJTable();
        inhabilitarFormulario();
    }

    public void mostrarJTable(){
        try {
            
            DefaultTableModel mod = new DefaultTableModel();
            jTableEstudiantes.setModel(mod);
            PreparedStatement pst = c.conexion.prepareStatement("select * from estudiantes");
            ResultSet rs = pst.executeQuery();
            ResultSetMetaData rsmd =rs.getMetaData();
            int cantColum = rsmd.getColumnCount();
            
            
            mod.addColumn("NOMBRE");
            mod.addColumn("APELLIDOS");
            mod.addColumn("FECHA DE NACIMIENTO");
            mod.addColumn("CORREO INSTITUCIONAL");
            mod.addColumn("CORREO PERSONAL");
            mod.addColumn("CELULAR");
            mod.addColumn("FIJO");
            mod.addColumn("PROGRAMA");
            
            while(rs.next()){
                Object[] filas=new Object[cantColum];
                for (int i = 0; i < cantColum; i++) {
                    filas[i]=rs.getObject(i+1);
                }
                mod.addRow(filas);
            }
            pst.close();
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
        
    public void buscarEstudiantes(String correoI){
        try {
            PreparedStatement pst = c.conexion.prepareStatement("Select * from estudiantes Where correoI=?");
            pst.setString(1, correoI);
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                txtNombre.setText(rs.getString("nombre"));
                txtApellidos.setText(rs.getString("apellido"));
                txtFecha.setText(rs.getString("fechaN"));
                txtCorreoI.setText(rs.getString("correoI"));
                txtCorreoP.setText(rs.getString("correoP"));
                txtCelular.setText(rs.getString("celular"));
                txtFijo.setText(rs.getString("fijo"));
                txtPrograma.setText(rs.getString("programa"));
                
            }else{
                JOptionPane.showMessageDialog(null, "No se encontro ningun registro","Registro de Estudiantes",JOptionPane.ERROR_MESSAGE);
            }
            pst.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    /*public void buscarEstudiantes(long fijo){
        try {
            PreparedStatement pst = c.conexion.prepareStatement("Select * from estudiantes Where fijo=?");
            pst.setString(1, String.valueOf(fijo));
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                txtNombre.setText(rs.getString("nombre"));
                txtApellidos.setText(rs.getString("apellido"));
                txtFecha.setText(rs.getString("fechaN"));
                txtCorreoI.setText(rs.getString("correoI"));
                txtCorreoP.setText(rs.getString("correoP"));
                txtCelular.setText(rs.getString("celular"));
                txtFijo.setText(rs.getString("fijo"));
                txtPrograma.setText(rs.getString("programa"));
                
            }else{
                JOptionPane.showMessageDialog(null, "No se encontro ningun registro","Registro de Estudiantes",JOptionPane.ERROR_MESSAGE);
            }
            pst.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }*/
    
    public void limpiarDatos(){
        txtNombre.setText("");
        txtApellidos.setText("");
        txtFecha.setText("");
        txtCorreoI.setText("");
        txtCorreoP.setText("");
        txtCelular.setText("");
        txtFijo.setText("");
        txtPrograma.setText("");
        txtNombre.requestFocus();
    }
    
    public void habilitarFormulario(){
        txtNombre.setEnabled(true);
        txtApellidos.setEnabled(true);
        txtFecha.setEnabled(true);
        txtCorreoI.setEnabled(true);  
        txtCorreoP.setEnabled(true);  
        txtCelular.setEnabled(true);  
        txtFijo.setEnabled(true);  
        txtPrograma.setEnabled(true);  
        txtNombre.requestFocus();        
    }
    
    public void inhabilitarFormulario(){
        txtNombre.setEnabled(false);
        txtApellidos.setEnabled(false);
        txtFecha.setEnabled(false);
        txtCorreoI.setEnabled(false);  
        txtCorreoP.setEnabled(false);  
        txtCelular.setEnabled(false);  
        txtFijo.setEnabled(false);  
        txtPrograma.setEnabled(false);   
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnRegistrar.setEnabled(false);
        txtNombre.requestFocus(); 
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();
        txtCorreoP = new javax.swing.JTextField();
        txtFijo = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        txtCorreoI = new javax.swing.JTextField();
        txtCelular = new javax.swing.JTextField();
        txtPrograma = new javax.swing.JTextField();
        btnNuevo = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableEstudiantes = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setForeground(new java.awt.Color(153, 153, 255));

        jPanel1.setBackground(new java.awt.Color(255, 204, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos de los Estudiantes - Institución La Floresta", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        jLabel1.setText("Nombre:");

        jLabel2.setText("Apellidos:");

        jLabel3.setText("Fecha de Nacimiento:");

        jLabel4.setText("Correo Institucional:");

        jLabel5.setText("Correo Personal:");

        jLabel6.setText("Número Celular:");

        jLabel7.setText("Teléfono Fijo:");

        jLabel8.setText("Programa:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFijo, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCorreoP, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(66, 66, 66)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel8)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCorreoI, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrograma, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCorreoI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(txtCorreoP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(txtFijo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrograma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jTableEstudiantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableEstudiantes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableEstudiantesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableEstudiantes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(btnNuevo)
                .addGap(64, 64, 64)
                .addComponent(btnRegistrar)
                .addGap(71, 71, 71)
                .addComponent(btnModificar)
                .addGap(80, 80, 80)
                .addComponent(btnEliminar)
                .addGap(75, 75, 75)
                .addComponent(btnCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalir)
                .addGap(47, 47, 47))
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 825, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(btnRegistrar)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar)
                    .addComponent(btnCancelar)
                    .addComponent(btnSalir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:
        if(!txtNombre.getText().isEmpty() || txtApellidos.getText().isEmpty() || txtFecha.getText().isEmpty() || txtCorreoI.getText().isEmpty() || txtCorreoP.getText().isEmpty() || txtCelular.getText().isEmpty() || txtFijo.getText().isEmpty() || txtPrograma.getText().isEmpty()){
            correoI=txtCorreoI.getText();
            if(!e.verificarDatosTablas(correoI)){
                nomb=txtNombre.getText();
                apel=txtApellidos.getText();
                fecha=txtFecha.getText();
    //            corI=txtCorreoI.getText();
                corP=txtCorreoP.getText();
                cel=Integer.parseInt(txtCelular.getText());
                fij=Integer.parseInt(txtFijo.getText());
                prog=txtPrograma.getText();
                e.insertarDatos(nomb, apel, fecha, correoI, corP, cel, fij, prog);
                JOptionPane.showMessageDialog(null, "El registro del Estudiante fue guardado","Registro de Estudiantes",JOptionPane.INFORMATION_MESSAGE);
                mostrarJTable();
                limpiarDatos();
            }else{
                JOptionPane.showMessageDialog(null, "El correo Institucional ya existe","Registro de Estudiantes",JOptionPane.ERROR_MESSAGE);
                txtNombre.requestFocus();
            }
        }else{        
            JOptionPane.showMessageDialog(null, "Faltan datos por llenar","Registro de Estudiantes",JOptionPane.ERROR_MESSAGE);
            }
        btnModificar.setEnabled(true);
        btnEliminar.setEnabled(true);        
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        if(!txtNombre.getText().isEmpty() || txtApellidos.getText().isEmpty() || txtFecha.getText().isEmpty() || txtCorreoI.getText().isEmpty() || txtCorreoP.getText().isEmpty() || txtCelular.getText().isEmpty() || txtFijo.getText().isEmpty() || txtPrograma.getText().isEmpty()){
            correoI=txtCorreoI.getText();
            if(e.verificarDatosTablas(correoI)){
                nomb=txtNombre.getText();
                apel=txtApellidos.getText();
                fecha=txtFecha.getText();
                correoI=txtCorreoI.getText();
                corP=txtCorreoP.getText();
                cel=Long.parseLong(txtCelular.getText());
                fij=Long.parseLong(txtFijo.getText());
                prog=txtPrograma.getText();
                e.actualizarDatos(correoI, corP, cel, fij, prog);
                JOptionPane.showMessageDialog(null, "El registro del Estudiante fue actualizado","Registro de Estudiantes",JOptionPane.INFORMATION_MESSAGE);
                mostrarJTable();
                limpiarDatos();
            }else{
                JOptionPane.showMessageDialog(null, "El correo Institucional no existe","Registro de Estudiantes",JOptionPane.ERROR_MESSAGE);
                txtNombre.requestFocus();
            }
        }else{        
            JOptionPane.showMessageDialog(null, "Faltan datos por llenar","Registro de Estudiantes",JOptionPane.ERROR_MESSAGE);
            }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        if(!txtCorreoI.getText().isEmpty()){
            correoI=txtCorreoI.getText();
            if(e.verificarDatosTablas(correoI)){
                e.eliminarDatos(correoI);
                JOptionPane.showMessageDialog(null, "El registro del Estudiante fue eliminado","Registro de Estudiantes",JOptionPane.INFORMATION_MESSAGE);
                mostrarJTable();
                limpiarDatos();
            }else{
                JOptionPane.showMessageDialog(null, "El correo Institucional no existe","Registro de Estudiantes",JOptionPane.ERROR_MESSAGE);
                txtNombre.requestFocus();
            }
        }else{        
            JOptionPane.showMessageDialog(null, "Faltan datos por llenar","Registro de Estudiantes",JOptionPane.ERROR_MESSAGE);
            }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void jTableEstudiantesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableEstudiantesMouseClicked
        // TODO add your handling code here:
        if(jTableEstudiantes.getSelectedRow()!=-1){
            String corI="";
            corI = (String) jTableEstudiantes.getValueAt(jTableEstudiantes.getSelectedRow(), 3);
            buscarEstudiantes(corI);
        }
        /*if(jTableEstudiantes.getSelectedRow()!=-1){
            long fijo=0;
            fijo = (Integer)jTableEstudiantes.getValueAt(jTableEstudiantes.getSelectedRow(), 0);
            buscarEstudiantes(fijo);
        }*/
        
        btnModificar.setEnabled(true);
        btnEliminar.setEnabled(true); 
    }//GEN-LAST:event_jTableEstudiantesMouseClicked

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        this.habilitarFormulario();
        btnRegistrar.setEnabled(true);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        limpiarDatos();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        int res=0;
        res = JOptionPane.showConfirmDialog(null, "Desea Salir del Programa?", "Finalizar Programa", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(res==JOptionPane.YES_OPTION){
            System.exit(0);
            c.cerrarConexion();
        }
    }//GEN-LAST:event_btnSalirActionPerformed

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
            java.util.logging.Logger.getLogger(frmEstudiantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmEstudiantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmEstudiantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmEstudiantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmEstudiantes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableEstudiantes;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtCorreoI;
    private javax.swing.JTextField txtCorreoP;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtFijo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrograma;
    // End of variables declaration//GEN-END:variables
}
