
package accesoADatos;

import entidades.Asistencia;
import entidades.Socio;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class AsistenciaData {
    private Connection con = null;
    private SocioData sData = new SocioData();
    private ClaseData cData = new ClaseData();

    public AsistenciaData() {
         con = Conexion.getConexion();
    }
    
     public void guardarAsistencia(Asistencia asistencia) {
        String sql = "INSERT INTO asistencia (idSocio, idClase, ifAsistencia) VALUES (?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, asistencia.getSocio().getIdSocio());
            ps.setInt(2, asistencia.getClase().getIdClase());
            ps.setDate(3, Date.valueOf(asistencia.getfAsistencia()));
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
 
            if (rs.next()) {
                asistencia.setIdAsistencia(rs.getInt(1));

                JOptionPane.showMessageDialog(null, "Asistencia registrada con éxito.");
            }

            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Asistencia" + ex.getMessage());
        }
    }
    
        public List<Socio> socioPorClases(int idClase, LocalDate fAsistencia) { 
        List<Socio> socios = new ArrayList();
        try {
            String sql = "SELECT idSocio FROM asistencia WHERE idClase = ?;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idClase);
            ps.setDate(2, Date.valueOf(fAsistencia));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Socio socio = new Socio();
                socio = sData.buscarSocio(rs.getInt("idSocio"));
                socios.add(socio);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la Base de Datos " + ex.getMessage());
        }
        return socios;
    }
        
        public void actualizarMembresia(Asistencia asistencia) {
           try {
            String sql = "UPDATE asistencia SET fAsistencia = ? WHERE idSocio = ? AND idMClase = ? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(asistencia.getfAsistencia()));
            ps.setInt(2,asistencia.getSocio().getIdSocio());
            ps.setInt(3, asistencia.getClase().getIdClase());
            int fila = ps.executeUpdate();
            if (fila == 1) {
                JOptionPane.showMessageDialog(null, "Se actualizó la fecha correctamente.");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Asistencia");
        }
    }
        
         public void borrarAsistenciaSocio(int idSocio, int idClase){
        try {
            String sql = "DELETE FROM asistencia WHERE idSocio = ? AND idClase = ? ";
            PreparedStatement ps = con.prepareStatement(sql);
           ps.setInt(1,idSocio);
            ps.setInt(2, idClase);
            int fila = ps.executeUpdate();

            if (fila == 1) {
                JOptionPane.showMessageDialog(null, "Se borró la asistencia correctamente.");
            }else if(fila>1){
                JOptionPane.showMessageDialog(null, "Se borraron "+fila+" registros de asistencias.");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Asistencia");
        }
    }
    }

