/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

/**
 *
 * @author CCMEW
 */
public class gestionClases extends javax.swing.JInternalFrame {

    /**
     * Creates new form gestionSocios
     */
    public gestionClases() {
        initComponents();
        int x = JFInicio.escritorio.getWidth() - this.getWidth();
        int y = JFInicio.escritorio.getHeight() - this.getHeight();
        setLocation(x / 2, y / 2);
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
        jLabelUsuario = new javax.swing.JLabel();
        btnNuevo = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jLabelNombre = new javax.swing.JLabel();
        jLabelCodigo = new javax.swing.JLabel();
        jLabelApellido = new javax.swing.JLabel();
        jLabelEdad = new javax.swing.JLabel();
        jLabelEmail = new javax.swing.JLabel();
        jTextCodigoClase = new javax.swing.JTextField();
        jTextNombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabelPorCodigo = new javax.swing.JLabel();
        jComboBoxHorario = new javax.swing.JComboBox<>();
        jTextCapacidad = new javax.swing.JTextField();
        jComboBoxCodigo1 = new javax.swing.JComboBox<>();
        jLabelFondo = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("GESTION CLASES - ABM");

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ClasesChica.png"))); // NOI18N
        jPanel1.add(jLabelUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 50, 350, 400));

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconNuevo.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanel1.add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 540, 120, 70));

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconEliminar.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 540, -1, 70));

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconGuardar.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 540, -1, 70));

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconSalir.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 590, 120, 70));

        jLabelNombre.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelNombre.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNombre.setText("NOMBRE CLASE:");
        jPanel1.add(jLabelNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 140, 40));

        jLabelCodigo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelCodigo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCodigo.setText("CÓDIGO CLASE:");
        jPanel1.add(jLabelCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 140, 40));

        jLabelApellido.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelApellido.setForeground(new java.awt.Color(255, 255, 255));
        jLabelApellido.setText("CÓDIGO ENTRENADOR:");
        jPanel1.add(jLabelApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 300, 200, 40));

        jLabelEdad.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelEdad.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEdad.setText("HORARIO:");
        jPanel1.add(jLabelEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 360, 120, 40));

        jLabelEmail.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelEmail.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEmail.setText("CAPACIDAD:");
        jPanel1.add(jLabelEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 420, 120, 40));

        jTextCodigoClase.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTextCodigoClase.setForeground(new java.awt.Color(0, 51, 153));
        jTextCodigoClase.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextCodigoClaseKeyTyped(evt);
            }
        });
        jPanel1.add(jTextCodigoClase, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, 100, 30));

        jTextNombre.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTextNombre.setForeground(new java.awt.Color(0, 51, 153));
        jPanel1.add(jTextNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 240, 260, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/clases.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, -30, 530, 230));

        jLabelPorCodigo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar.png"))); // NOI18N
        jLabelPorCodigo.setToolTipText("Buscar Por Código");
        jPanel1.add(jLabelPorCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 180, 50, 30));

        jComboBoxHorario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBoxHorario.setForeground(new java.awt.Color(0, 0, 153));
        jPanel1.add(jComboBoxHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 360, 120, 30));

        jTextCapacidad.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTextCapacidad.setForeground(new java.awt.Color(0, 51, 153));
        jPanel1.add(jTextCapacidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 420, 90, 30));

        jComboBoxCodigo1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBoxCodigo1.setForeground(new java.awt.Color(0, 0, 153));
        jPanel1.add(jComboBoxCodigo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 300, 120, 30));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondoFormulario.jpeg"))); // NOI18N
        jPanel1.add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 710));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void limpiarCampos() {
        jTextCodigoClase.setText(" ");
        jTextNombre.setText(" ");
        jComboBoxHorario.setSelectedItem(0);
        jTextCapacidad.setText(" ");

    }

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void jTextCodigoClaseKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextCodigoClaseKeyTyped
        char c = evt.getKeyChar(); // para ingresar solo numeros
        if (c < '0' || c > '9') {
            evt.consume();         // TODO add your handling code here:
    }//GEN-LAST:event_jTextCodigoClaseKeyTyped
  }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> jComboBoxCodigo1;
    private javax.swing.JComboBox<String> jComboBoxHorario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelApellido;
    private javax.swing.JLabel jLabelCodigo;
    private javax.swing.JLabel jLabelEdad;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelPorCodigo;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextCapacidad;
    private javax.swing.JTextField jTextCodigoClase;
    private javax.swing.JTextField jTextNombre;
    // End of variables declaration//GEN-END:variables
}