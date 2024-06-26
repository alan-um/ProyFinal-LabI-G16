/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import accesoADatos.EntrenadorData;
import accesoADatos.SocioData;
import entidades.Entrenador;
import entidades.Socio;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CCMEW
 */
public class listadoEntrenadores extends javax.swing.JInternalFrame {

    private List<Entrenador> listaS; //1
    private EntrenadorData entrenadorData;  //2

    private DefaultTableModel modelo = new DefaultTableModel();

    public listadoEntrenadores() {
        initComponents();
        int x = JFInicio.escritorio.getWidth() - this.getWidth();
        int y = JFInicio.escritorio.getHeight() - this.getHeight();
        setLocation(x / 2, y / 2);
        jTextEspecialidad.setEnabled(false);
        entrenadorData = new EntrenadorData();//3
        armarCabeceraTabla();
        cargaSocioPorNombre();
        jTableEntrenadores.getColumnModel().getColumn(0).setPreferredWidth(80);
        jTableEntrenadores.getColumnModel().getColumn(1).setPreferredWidth(100);
        jTableEntrenadores.getColumnModel().getColumn(2).setPreferredWidth(250);
        jTableEntrenadores.getColumnModel().getColumn(3).setPreferredWidth(250);
        jTableEntrenadores.getColumnModel().getColumn(4).setPreferredWidth(200);
        jTableEntrenadores.setRowHeight(30);
    }

    private void armarCabeceraTabla() {
        ArrayList<Object> filaCabecera = new ArrayList<>();
        filaCabecera.add("ID");
        filaCabecera.add("DNI");
        filaCabecera.add("Nombre");
        filaCabecera.add("Apellido");
        filaCabecera.add("Especialidad");

        for (Object it : filaCabecera) {
            modelo.addColumn(it);
        }
        jTableEntrenadores.setModel(modelo);
    }

    private DefaultTableModel cargaEntrenadores() {

        List<Entrenador> lista = entrenadorData.listarEntrenadores();
        for (Entrenador m : lista) {
            modelo.addRow(new Object[]{m.getIdEntrenador(), m.getDni(), m.getNombre(), m.getApellido(), m.getEspecialidad()});
        }
        return modelo;
    }

    private void borrarFilaTabla() {
        int indice = modelo.getRowCount() - 1;
        for (int i = indice; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }

    private DefaultTableModel cargaSocioPorNombre() {
        borrarFilaTabla();
        List<Entrenador> lista = entrenadorData.listarEntrenadoresPorNombre(jTextApellido.getText());
        for (Entrenador m : lista) {
            modelo.addRow(new Object[]{m.getIdEntrenador(), m.getDni(), m.getNombre(), m.getApellido(), m.getEspecialidad()});
        }
        return modelo;
    }

    private DefaultTableModel cargaSocioPorEspecialidad() {
        borrarFilaTabla();
        List<Entrenador> lista = entrenadorData.listarEntrenadoresPorEspecialidad(jTextEspecialidad.getText());
        for (Entrenador m : lista) {
            modelo.addRow(new Object[]{m.getIdEntrenador(), m.getDni(), m.getNombre(), m.getApellido(), m.getEspecialidad()});
        }
        return modelo;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnSalir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jTextApellido = new javax.swing.JTextField();
        jTextEspecialidad = new javax.swing.JTextField();
        jRadioCodigo = new javax.swing.JRadioButton();
        jRadioApellido = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableEntrenadores = new javax.swing.JTable();
        jLabelFondo = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("GESTION SOCIOS - LISTADOS");

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconSalir.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 600, 120, 70));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/tituloEntrenadores.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, -40, 560, 230));

        jPanel2.setBackground(new java.awt.Color(0, 51, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar Entrenador", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(204, 204, 204))); // NOI18N
        jPanel2.setToolTipText("Buscar un Socio");
        jPanel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel2.setName("Buscar"); // NOI18N
        jPanel2.setOpaque(false);

        jTextApellido.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTextApellido.setForeground(new java.awt.Color(0, 51, 153));
        jTextApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextApellidoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextApellidoKeyTyped(evt);
            }
        });

        jTextEspecialidad.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTextEspecialidad.setForeground(new java.awt.Color(0, 51, 153));
        jTextEspecialidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextEspecialidadKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextEspecialidadKeyTyped(evt);
            }
        });

        jRadioCodigo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jRadioCodigo.setForeground(new java.awt.Color(255, 255, 255));
        jRadioCodigo.setSelected(true);
        jRadioCodigo.setText("Por Nombre");
        jRadioCodigo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioCodigoMouseClicked(evt);
            }
        });
        jRadioCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioCodigoActionPerformed(evt);
            }
        });

        jRadioApellido.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jRadioApellido.setForeground(new java.awt.Color(255, 255, 255));
        jRadioApellido.setText("Por Especialidad");
        jRadioApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioApellidoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jRadioApellido)
                        .addGap(18, 18, 18)
                        .addComponent(jTextEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jRadioCodigo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioCodigo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioApellido))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 590, 440, 100));

        jTableEntrenadores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "CODIGO", "DNI", "APELLIDO", "NOMBRE", "TELEFONO", "EMAIL"
            }
        ));
        jScrollPane1.setViewportView(jTableEntrenadores);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 137, 810, 440));

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

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void jRadioCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioCodigoActionPerformed
        jRadioCodigo.setSelected(true);
        jRadioApellido.setSelected(false);
        jTextEspecialidad.setVisible(false);
        jTextEspecialidad.setEnabled(false);
        jTextApellido.setVisible(true);
        jTextApellido.setEnabled(true);
        jTextEspecialidad.setText("");
        jTextApellido.setText("");
        jTextApellido.requestFocus();
        borrarFilaTabla();
        cargaEntrenadores();
    }//GEN-LAST:event_jRadioCodigoActionPerformed

    private void jRadioCodigoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioCodigoMouseClicked

    }//GEN-LAST:event_jRadioCodigoMouseClicked

    private void jRadioApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioApellidoActionPerformed
        jTextEspecialidad.setVisible(true);
        jRadioCodigo.setSelected(false);
        jRadioApellido.setSelected(true);
        jTextApellido.setVisible(false);
        jTextApellido.setEnabled(false);
        jTextEspecialidad.setEnabled(true);
        jTextEspecialidad.setText("");
        jTextApellido.setText("");
        jTextEspecialidad.requestFocus();
        borrarFilaTabla();
        cargaEntrenadores();
    }//GEN-LAST:event_jRadioApellidoActionPerformed

    private void jTextApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextApellidoKeyTyped

        char c = evt.getKeyChar(); // para ingresar solo numeros
        if (c < 'a' || c > 'z') {
            evt.consume();
        }

        //---------- Primer caracter en mayuscula---------------
        String nuestroTexto = jTextApellido.getText();
        if (nuestroTexto.length() > 0) {
            char primeraLetra = nuestroTexto.charAt(0);
            nuestroTexto = Character.toUpperCase(primeraLetra) + nuestroTexto.substring(1, nuestroTexto.length());
            jTextApellido.setText(nuestroTexto);
        }
        //------------------------------------------------------ 
    }//GEN-LAST:event_jTextApellidoKeyTyped

    private void jTextEspecialidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextEspecialidadKeyTyped
        char c = evt.getKeyChar(); /// para ingresar solo letras
        if (c < 'a' || c > 'z') {
            evt.consume();
        }
        //---------- Primer caracter en mayuscula---------------
        String nuestroTexto = jTextEspecialidad.getText();
        if (nuestroTexto.length() > 0) {
            char primeraLetra = nuestroTexto.charAt(0);
            nuestroTexto = Character.toUpperCase(primeraLetra) + nuestroTexto.substring(1, nuestroTexto.length());
            jTextEspecialidad.setText(nuestroTexto);
        }
    }//GEN-LAST:event_jTextEspecialidadKeyTyped

    private void jTextApellidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextApellidoKeyReleased
        cargaSocioPorNombre();
    }//GEN-LAST:event_jTextApellidoKeyReleased

    private void jTextEspecialidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextEspecialidadKeyReleased
        cargaSocioPorEspecialidad();        // TODO add your handling code here:
    }//GEN-LAST:event_jTextEspecialidadKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioApellido;
    private javax.swing.JRadioButton jRadioCodigo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableEntrenadores;
    private javax.swing.JTextField jTextApellido;
    private javax.swing.JTextField jTextEspecialidad;
    // End of variables declaration//GEN-END:variables
}
