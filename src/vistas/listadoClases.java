
package vistas;

import accesoADatos.ClaseData;
import accesoADatos.EntrenadorData;
import entidades.Clase;
import entidades.Entrenador;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CCMEW
 */
public class listadoClases extends javax.swing.JInternalFrame {
    private List<LocalTime> listaS; //1
    private List<Entrenador>listaE;
    private ClaseData claseData;  //2
    private EntrenadorData entrenaData;
    private DefaultTableModel modelo = new DefaultTableModel();

 
    public listadoClases() {
        initComponents();
        int x=JFInicio.escritorio.getWidth()- this.getWidth();
        int y=JFInicio.escritorio.getHeight() - this.getHeight();
        setLocation(x/2, y/2);
        claseData = new ClaseData();//3
        entrenaData= new EntrenadorData();
        armarCabeceraTabla();//4
         jTableClases.getColumnModel().getColumn(0).setPreferredWidth(80);
         jTableClases.getColumnModel().getColumn(1).setPreferredWidth(350);
         jTableClases.getColumnModel().getColumn(2).setPreferredWidth(80);
         jTableClases.getColumnModel().getColumn(3).setPreferredWidth(150);
         jTableClases.getColumnModel().getColumn(4).setPreferredWidth(150);
         jTableClases.setRowHeight(30);

        
        cargaComboBoxEntrenadores();
        cargaComboBoxHorarios();
        jComboBoxEntrenador.setSelectedIndex(-1);
        jComboBoxHorario.setSelectedIndex(-1);
        jComboBoxEntrenador.setEnabled(false);
        jComboBoxHorario.setEnabled(false);
        
        cargaClases();//5
     }
    
private void armarCabeceraTabla(){
    ArrayList <Object>filaCabecera=new ArrayList<>();
    filaCabecera.add("ID Clase");
    filaCabecera.add("Nombre");
    filaCabecera.add("ID Entrenador");
    filaCabecera.add("Horario");
    filaCabecera.add("Capacidad");
    jTableClases.getColumnModel().getColumn(0).setPreferredWidth(200);
    
  
    for(Object it:filaCabecera){
        modelo.addColumn(it);
    }
    jTableClases.setModel(modelo);
  }

private void cargaComboBoxEntrenadores() {
       listaE=entrenaData.listarEntrenadores();
       for(Entrenador item: listaE){
        jComboBoxEntrenador.addItem(item);
    }
    }

private void cargaComboBoxHorarios() {
       listaS=claseData.horariosDeAtencion();
       for(LocalTime itemH: listaS){
        jComboBoxHorario.addItem(itemH);
    }
    }

       
private void borrarFilaComboEntrenadores(){
    int indice=jComboBoxEntrenador.getItemCount()-1;  //modelo.getRowCount()-1;
    for (int i=indice; i>=0; i--){
        jComboBoxEntrenador.removeItemAt(i); 
    }
   }

private void borrarFilaTabla(){
    int indice=modelo.getRowCount()-1;
    for (int i=indice; i>=0; i--){
        modelo.removeRow(i);
    }
   }
private DefaultTableModel cargaClases() {
          
   List<Clase> lista=claseData.listarClases();
   for(Clase m: lista){
     modelo.addRow(new Object[] {m.getIdClase() ,m.getNombre(),m.getEntrenador().getIdEntrenador(), m.getHorario(), m.getCapacidad()});  
   }
     return modelo;  
     }
  
private DefaultTableModel cargaClasePorNombre() {
   borrarFilaTabla();  
   List<Clase> lista=claseData.listarClasesPorNombre(jTextApellido.getText());
   for(Clase m: lista){
      modelo.addRow(new Object[] {m.getIdClase() ,m.getNombre(),m.getEntrenador().getIdEntrenador(), m.getHorario(), m.getCapacidad()});  
   }
     return modelo;  
     }

  private DefaultTableModel cargaClasePorEntrenador() {
    borrarFilaTabla();  
    
    Entrenador selec =(Entrenador)jComboBoxEntrenador.getSelectedItem();
   if (selec!=null) {
    List<Clase> lista=claseData.listarClasesPorEntrenador(selec);
   for(Clase m: lista){
      modelo.addRow(new Object[] {m.getIdClase() ,m.getNombre(),m.getEntrenador().getIdEntrenador(), m.getHorario(), m.getCapacidad()});  
   }
   }
     return modelo;  
     }
  
  private DefaultTableModel cargaClasePorHorario() {
    borrarFilaTabla();  
    LocalTime selec =(LocalTime)jComboBoxHorario.getSelectedItem();
    if (selec!=null) {
    List<Clase> lista=claseData.listarClasesPorHorario(selec);
   for(Clase m: lista){
      modelo.addRow(new Object[] {m.getIdClase() ,m.getNombre(),m.getEntrenador().getIdEntrenador(), m.getHorario(), m.getCapacidad()});  
   }
    }
     return modelo;  
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
        btnSalir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jTextApellido = new javax.swing.JTextField();
        jRadioNombre = new javax.swing.JRadioButton();
        jRadioEntrenadores = new javax.swing.JRadioButton();
        jRadioHorario = new javax.swing.JRadioButton();
        jComboBoxEntrenador = new javax.swing.JComboBox<>();
        jComboBoxHorario = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableClases = new javax.swing.JTable();
        jLabelFondo = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("GESTION CLASES - LISTADOS DE CLASES DISPONIBLES");

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconSalir.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 610, 120, 70));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/clasesDisp.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, -40, 560, 230));

        jPanel2.setBackground(new java.awt.Color(0, 51, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar Clase", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(204, 204, 204))); // NOI18N
        jPanel2.setToolTipText("Buscar Clase");
        jPanel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel2.setName("Buscar"); // NOI18N
        jPanel2.setOpaque(false);

        jTextApellido.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTextApellido.setForeground(new java.awt.Color(0, 51, 153));
        jTextApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextApellidoActionPerformed(evt);
            }
        });
        jTextApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextApellidoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextApellidoKeyTyped(evt);
            }
        });

        jRadioNombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jRadioNombre.setForeground(new java.awt.Color(255, 255, 255));
        jRadioNombre.setSelected(true);
        jRadioNombre.setText("Por Nombre:");
        jRadioNombre.setOpaque(false);
        jRadioNombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioNombreMouseClicked(evt);
            }
        });
        jRadioNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioNombreActionPerformed(evt);
            }
        });

        jRadioEntrenadores.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jRadioEntrenadores.setForeground(new java.awt.Color(255, 255, 255));
        jRadioEntrenadores.setText("Por Entrenador");
        jRadioEntrenadores.setOpaque(false);
        jRadioEntrenadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioEntrenadoresActionPerformed(evt);
            }
        });

        jRadioHorario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jRadioHorario.setForeground(new java.awt.Color(255, 255, 255));
        jRadioHorario.setText("Por Horario");
        jRadioHorario.setOpaque(false);
        jRadioHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioHorarioActionPerformed(evt);
            }
        });

        jComboBoxEntrenador.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBoxEntrenador.setForeground(new java.awt.Color(0, 0, 153));
        jComboBoxEntrenador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxEntrenadorActionPerformed(evt);
            }
        });

        jComboBoxHorario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBoxHorario.setForeground(new java.awt.Color(0, 0, 153));
        jComboBoxHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxHorarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jRadioEntrenadores)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBoxEntrenador, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jRadioHorario)
                                .addGap(53, 53, 53)
                                .addComponent(jComboBoxHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jRadioNombre)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioNombre))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxEntrenador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioEntrenadores))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioHorario)
                    .addComponent(jComboBoxHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 530, 440, 150));

        jTableClases.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID CLASE", "NOMBRE CLASE", "ID ENTRENADOR", "HORARIO", "CAPACIDAD"
            }
        ));
        jScrollPane1.setViewportView(jTableClases);
        if (jTableClases.getColumnModel().getColumnCount() > 0) {
            jTableClases.getColumnModel().getColumn(0).setPreferredWidth(200);
            jTableClases.getColumnModel().getColumn(1).setPreferredWidth(500);
            jTableClases.getColumnModel().getColumn(2).setResizable(false);
            jTableClases.getColumnModel().getColumn(2).setPreferredWidth(200);
            jTableClases.getColumnModel().getColumn(3).setResizable(false);
            jTableClases.getColumnModel().getColumn(3).setPreferredWidth(400);
            jTableClases.getColumnModel().getColumn(4).setPreferredWidth(400);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 710, 390));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondoFormulario.jpeg"))); // NOI18N
        jPanel1.add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 710));

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

    private void jRadioNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioNombreActionPerformed
        jRadioEntrenadores.setSelected(false);
        jRadioHorario.setSelected(false);
        jRadioNombre.setSelected(true);
        
        jTextApellido.setText("");
        jComboBoxHorario.setSelectedItem("");
        jComboBoxEntrenador.setSelectedItem("");
        
        jComboBoxEntrenador.setEnabled(false);
        jComboBoxHorario.setEnabled(false);
        jTextApellido.setEnabled(true);  
        
        jTextApellido.setText("");
        jComboBoxHorario.setSelectedItem("");
        jComboBoxEntrenador.setSelectedItem("");
        
        jComboBoxEntrenador.setSelectedIndex(-1);
        jComboBoxHorario.setSelectedIndex(-1);
        borrarFilaTabla();
        cargaClases();
        jTextApellido.requestFocus();
        
    }//GEN-LAST:event_jRadioNombreActionPerformed

    private void jRadioNombreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioNombreMouseClicked

    }//GEN-LAST:event_jRadioNombreMouseClicked

    private void jRadioEntrenadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioEntrenadoresActionPerformed
        
        jComboBoxHorario.setSelectedIndex(-1);
        jRadioEntrenadores.setSelected(true);
        jRadioHorario.setSelected(false);
        jRadioNombre.setSelected(false);
        jComboBoxEntrenador.setEnabled(true);
        jComboBoxHorario.setEnabled(false);
        jTextApellido.setEnabled(false);  
        
        jTextApellido.setText("");
        jComboBoxHorario.setSelectedItem("");
        borrarFilaTabla();
         cargaClases();
//        cargaComboBoxEntrenadores();
        
        jComboBoxEntrenador.requestFocus();
    }//GEN-LAST:event_jRadioEntrenadoresActionPerformed

    private void jTextApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextApellidoKeyTyped
        
        char c=evt.getKeyChar(); // para ingresar solo numeros
        if(c<'a' || c>'z')evt.consume(); 
        
        //---------- Primer caracter en mayuscula---------------
        String nuestroTexto=jTextApellido.getText(); 
        if(nuestroTexto.length()> 0){
            char primeraLetra=nuestroTexto.charAt(0);
            nuestroTexto=Character.toUpperCase(primeraLetra)+ nuestroTexto.substring(1, nuestroTexto.length());
            jTextApellido.setText(nuestroTexto);
        }
       //------------------------------------------------------ 
    }//GEN-LAST:event_jTextApellidoKeyTyped

    private void jRadioHorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioHorarioActionPerformed
        jRadioEntrenadores.setSelected(false);
        jRadioHorario.setSelected(true);
        jRadioNombre.setSelected(false);
        jComboBoxEntrenador.setEnabled(false);
        jComboBoxHorario.setEnabled(true);
        jTextApellido.setEnabled(false);  
        
        jTextApellido.setText("");
        jComboBoxEntrenador.setSelectedIndex(-1);
        
        
        borrarFilaTabla();
         cargaClases();
       
        
        jComboBoxHorario.requestFocus();
    }//GEN-LAST:event_jRadioHorarioActionPerformed

    private void jComboBoxEntrenadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEntrenadorActionPerformed
        cargaClasePorEntrenador();
    }//GEN-LAST:event_jComboBoxEntrenadorActionPerformed

    private void jTextApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextApellidoActionPerformed

    private void jTextApellidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextApellidoKeyReleased
      cargaClasePorNombre();
    }//GEN-LAST:event_jTextApellidoKeyReleased

    private void jComboBoxHorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxHorarioActionPerformed
       cargaClasePorHorario();
    }//GEN-LAST:event_jComboBoxHorarioActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<Entrenador> jComboBoxEntrenador;
    private javax.swing.JComboBox<LocalTime> jComboBoxHorario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioEntrenadores;
    private javax.swing.JRadioButton jRadioHorario;
    private javax.swing.JRadioButton jRadioNombre;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableClases;
    private javax.swing.JTextField jTextApellido;
    // End of variables declaration//GEN-END:variables
}
