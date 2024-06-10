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
public class gestionSocios extends javax.swing.JInternalFrame {

    /**
     * Creates new form gestionSocios
     */
    public gestionSocios() {
        initComponents();
       int x=JFInicio.escritorio.getWidth()- this.getWidth();
        int y=JFInicio.escritorio.getHeight() - this.getHeight();
        setLocation(x/2, y/2);
         jTextCodigo.setEnabled(false);
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
        jLabelTelefono = new javax.swing.JLabel();
        jLabelNombre = new javax.swing.JLabel();
        jLabelCodigo = new javax.swing.JLabel();
        jLabelDni = new javax.swing.JLabel();
        jLabelApellido = new javax.swing.JLabel();
        jLabelEdad = new javax.swing.JLabel();
        jLabelEmail = new javax.swing.JLabel();
        jTextTelefono = new javax.swing.JTextField();
        jTextCodigo = new javax.swing.JTextField();
        jTextDni = new javax.swing.JTextField();
        jTextNombre = new javax.swing.JTextField();
        jTextApellido = new javax.swing.JTextField();
        jTextEdad = new javax.swing.JTextField();
        jTextEmail = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabelPorDni = new javax.swing.JLabel();
        jLabelFondo = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("GESTION SOCIOS - ABM");

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/usuarios.png"))); // NOI18N
        jPanel1.add(jLabelUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, 270, 260));

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
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 600, 120, 70));

        jLabelTelefono.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelTelefono.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTelefono.setText("TELEFONO:");
        jPanel1.add(jLabelTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 450, 120, 40));

        jLabelNombre.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelNombre.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNombre.setText("NOMBRE:");
        jPanel1.add(jLabelNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, 120, 40));

        jLabelCodigo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelCodigo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCodigo.setText("CÓDIGO:");
        jPanel1.add(jLabelCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, 120, 40));

        jLabelDni.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelDni.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDni.setText("DNI:");
        jPanel1.add(jLabelDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 50, 40));

        jLabelApellido.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelApellido.setForeground(new java.awt.Color(255, 255, 255));
        jLabelApellido.setText("APELLIDO:");
        jPanel1.add(jLabelApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 300, 120, 40));

        jLabelEdad.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelEdad.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEdad.setText("EDAD:");
        jPanel1.add(jLabelEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 350, 120, 40));

        jLabelEmail.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelEmail.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEmail.setText("EMAIL:");
        jPanel1.add(jLabelEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 400, 120, 40));

        jTextTelefono.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTextTelefono.setForeground(new java.awt.Color(0, 51, 153));
        jTextTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextTelefonoKeyTyped(evt);
            }
        });
        jPanel1.add(jTextTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 450, 120, 30));

        jTextCodigo.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTextCodigo.setForeground(new java.awt.Color(0, 51, 153));
        jTextCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextCodigoKeyTyped(evt);
            }
        });
        jPanel1.add(jTextCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 100, 30));

        jTextDni.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTextDni.setForeground(new java.awt.Color(0, 51, 153));
        jTextDni.setToolTipText("solo números sin punto");
        jTextDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextDniActionPerformed(evt);
            }
        });
        jTextDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextDniKeyTyped(evt);
            }
        });
        jPanel1.add(jTextDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, 120, 30));

        jTextNombre.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTextNombre.setForeground(new java.awt.Color(0, 51, 153));
        jTextNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNombreActionPerformed(evt);
            }
        });
        jTextNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextNombreKeyTyped(evt);
            }
        });
        jPanel1.add(jTextNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, 260, 30));

        jTextApellido.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTextApellido.setForeground(new java.awt.Color(0, 51, 153));
        jPanel1.add(jTextApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 300, 260, 30));

        jTextEdad.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTextEdad.setForeground(new java.awt.Color(0, 51, 153));
        jTextEdad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextEdadKeyTyped(evt);
            }
        });
        jPanel1.add(jTextEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 350, 100, 30));

        jTextEmail.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTextEmail.setForeground(new java.awt.Color(0, 51, 153));
        jPanel1.add(jTextEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 400, 260, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/titulo.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 530, 230));

        jLabelPorDni.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar.png"))); // NOI18N
        jLabelPorDni.setToolTipText("Buscar por DNI");
        jPanel1.add(jLabelPorDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 200, 50, 30));

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

    private void limpiarCampos(){
       jTextCodigo.setText(" ");
       jTextDni.setText(" ");
       jTextApellido.setText(" ");
       jTextNombre.setText(" ");
       jTextEdad.setText(" ");
       jTextEmail.setText(" ");
       jTextTelefono.setText(" ");
       
    }
    
    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
     limpiarCampos();
    }//GEN-LAST:event_btnNuevoActionPerformed

    // limita que solo se ingresen 8 caracteres
    private void jTextDniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextDniKeyTyped
        
        if(jTextDni.getText().length()>=8){
            evt.consume();
        }
        char c=evt.getKeyChar();
        if(c<'0' || c>'9')evt.consume(); 
        
    }//GEN-LAST:event_jTextDniKeyTyped

    private void jTextDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextDniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextDniActionPerformed

    private void jTextCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextCodigoKeyTyped
        char c=evt.getKeyChar(); // para ingresar solo numeros
        if(c<'0' || c>'9')evt.consume();         // TODO add your handling code here:
    }//GEN-LAST:event_jTextCodigoKeyTyped

    private void jTextEdadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextEdadKeyTyped
 char c=evt.getKeyChar(); // para ingresar solo numeros
        if(c<'0' || c>'9')evt.consume();         // TODO add your handling code here:
    }//GEN-LAST:event_jTextEdadKeyTyped

    private void jTextTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextTelefonoKeyTyped
        char c=evt.getKeyChar(); // para ingresar solo numeros
        if(c<'0' || c>'9')evt.consume(); 
    }//GEN-LAST:event_jTextTelefonoKeyTyped

    private void jTextNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextNombreKeyTyped
        char c=evt.getKeyChar(); // para ingresar solo numeros
        if(( c< 'a' || c> 'z')) evt.consume(); 
        String nuestroTexto=jTextNombre.getText(); 
        if(nuestroTexto.length()> 0){
            char primeraLetra=nuestroTexto.charAt(0);
            nuestroTexto=Character.toUpperCase(primeraLetra)+ nuestroTexto.substring(1, nuestroTexto.length());
            jTextNombre.setText(nuestroTexto);
        }
       
    }//GEN-LAST:event_jTextNombreKeyTyped

    private void jTextNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextNombreActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelApellido;
    private javax.swing.JLabel jLabelCodigo;
    private javax.swing.JLabel jLabelDni;
    private javax.swing.JLabel jLabelEdad;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelPorDni;
    private javax.swing.JLabel jLabelTelefono;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextApellido;
    private javax.swing.JTextField jTextCodigo;
    private javax.swing.JTextField jTextDni;
    private javax.swing.JTextField jTextEdad;
    private javax.swing.JTextField jTextEmail;
    private javax.swing.JTextField jTextNombre;
    private javax.swing.JTextField jTextTelefono;
    // End of variables declaration//GEN-END:variables
}