package accesoADatos;

import entidades.Asistencia;
import entidades.Clase;
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
        String sql = "INSERT INTO asistencia (idSocio, idClase, fAsistencia) VALUES (?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, asistencia.getSocio().getIdSocio());
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
    
    //Buscar un aistencia según su idAsistencia
    public Asistencia buscarAsistencia(int id) {
        Asistencia asist = null;
        String sql = "SELECT idSocio, idClase, fAsistencia FROM asistencia WHERE idAsistencia = ?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                asist = new Asistencia();
                asist.setIdAsistencia(id);
                Socio socio = sData.buscarSocio(rs.getInt("idSocio"));
                asist.setSocio(socio);
                Clase clase = cData.buscarClase(rs.getInt("idClase"));
                asist.setClase(clase);
                asist.setfAsistencia(rs.getDate("fAsistencia").toLocalDate());

            } else {
                JOptionPane.showMessageDialog(null, "No existe ninguna Asistencia con ese Id");              
                ps.close();}
            
            }catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Asistencia " + ex.getMessage());
            }

            return asist;    
        }

    public List<Socio> socioPorClases(int idClase, LocalDate fAsistencia) {
        List<Socio> socios = new ArrayList();
        try {
            String sql = "SELECT idSocio FROM asistencia WHERE idClase = ? AND fAsistencia = ?;";
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
    
    public List<Asistencia> asistenciaPorSocio(int idSocio) {
        List<Asistencia> asistencias = new ArrayList();
        Asistencia asist=null;
        try {
            String sql = "SELECT * FROM asistencia WHERE idSocio = ?;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idSocio);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                asist = new Asistencia();
                asist.setIdAsistencia(rs.getInt("idAsistencia"));
                Socio socio = sData.buscarSocio(rs.getInt("idSocio"));
                asist.setSocio(socio);
                Clase clase = cData.buscarClase(rs.getInt("idClase"));
                asist.setClase(clase);
                asist.setfAsistencia(rs.getDate("fAsistencia").toLocalDate());
                asistencias.add(asist);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la Base de Datos " + ex.getMessage());
        }
        return asistencias;
    }

    public void modificarAsistencia (Asistencia asistencia) {
        try {
            String sql = "UPDATE asistencia SET idSocio = ?, idClase = ?, fAsistencia = ? WHERE idAsistencia = ? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, asistencia.getSocio().getIdSocio());
            ps.setInt(2, asistencia.getClase().getIdClase());
            ps.setDate(3, Date.valueOf(asistencia.getfAsistencia()));
            ps.setInt(4, asistencia.getIdAsistencia());
            int fila = ps.executeUpdate();
            if (fila == 1) {
                JOptionPane.showMessageDialog(null, "Se actualizó la fecha correctamente.");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Asistencia");
        }
    }

    public void eliminarAsistencia(int id) {
        try {
            String sql = "DELETE FROM asistencia WHERE idAsistencia = ? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int fila = ps.executeUpdate();

            if (fila == 1) {
                JOptionPane.showMessageDialog(null, "Se borró la asistencia correctamente.");
            } else if (fila > 1) {
                JOptionPane.showMessageDialog(null, "Se borraron " + fila + " registros de asistencias.");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Asistencia");
        }
    }
}
