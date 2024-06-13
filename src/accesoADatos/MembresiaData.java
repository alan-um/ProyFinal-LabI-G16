/*
● Los usuarios deben poder registrar nuevas membresías especificando el socio,
tipo de membresía, y duración.
● Los usuarios deben poder visualizar el historial de membresías con posibilidad
de filtrado por socio o tipo de membresía.
● Los usuarios deben poder renovar o cancelar membresías existentes.
 */
package accesoADatos;

import entidades.Membresia;
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
import vistas.gestionAsistencia;

public class MembresiaData {

    private Connection con = null;
    private SocioData sData = new SocioData();
 
    
    public MembresiaData() {
        con = Conexion.getConexion();

    }

    public void guardaMembresia(Membresia membr) {
        String sql = "INSERT INTO membresia (idSocio, cantPases, fInicio, fFin, costo, estado) VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, membr.getSocio().getIdSocio());
            ps.setInt(2, membr.getCantPases());
            ps.setDate(3, Date.valueOf(membr.getfInicio()));
            ps.setDate(4, Date.valueOf(membr.getfFin()));
            ps.setDouble(5, membr.getCosto());
            ps.setBoolean(6, membr.isEstado());
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            
            if (rs.next()) {
                membr.setIdMembresia(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Se ha efectuado la membresía con éxito.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Membresia" + ex.getMessage());
        }
    }

        
    public Membresia buscarMembresia(int id) {
        Membresia m = null;
        String sql = "SELECT * FROM membresia WHERE idMembresia = ?";
        try {
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                m = new Membresia();
                m.setIdMembresia(rs.getInt("idMembresia"));
                m.setSocio(sData.buscarSocio(rs.getInt("idSocio")));
                m.setCantPases(rs.getInt("cantPases"));
                m.setfInicio(rs.getDate("fInicio").toLocalDate());
                m.setfFin(rs.getDate("fFin").toLocalDate());
                m.setCosto(rs.getInt("costo"));
                m.setEstado(rs.getBoolean("estado"));
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Membresia " + ex.getMessage());
        }
        return m;
    }
    
    
    public List<Membresia> listadoMembresia() {
        List<Membresia> membresias = new ArrayList();
        try {
            String sql = "SELECT * FROM membresia";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Membresia m = new Membresia();
                m.setIdMembresia(rs.getInt("idMembresia"));
                m.setSocio(sData.buscarSocio(rs.getInt("idSocio")));
                m.setCantPases(rs.getInt("cantPases"));
                m.setfInicio(rs.getDate("fInicio").toLocalDate());
                m.setfFin(rs.getDate("fFin").toLocalDate());
                m.setCosto(rs.getInt("costo"));
                m.setEstado(rs.getBoolean("estado"));
                membresias.add(m);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Membresia " + ex.getMessage());
        }
        return membresias;
    }

    public List<Membresia> membresiasPorSocio(int idSocio) {
        List<Membresia> membresias = new ArrayList();
        try {
            String sql = "SELECT * FROM membresia WHERE idSocio = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idSocio);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                 Membresia m = new Membresia();
                m.setIdMembresia(rs.getInt("idMembresia"));
                m.setSocio(sData.buscarSocio(rs.getInt("idSocio")));
                m.setCantPases(rs.getInt("cantPases"));
                m.setfInicio(rs.getDate("fInicio").toLocalDate());
                m.setfFin(rs.getDate("fFin").toLocalDate());
                m.setCosto(rs.getInt("costo"));
                m.setEstado(rs.getBoolean("estado"));
                membresias.add(m);
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Membresia " + e.getMessage());
        }
        return membresias;
    }
    
    public List<Membresia> membresiasPorSocioYFecha(int idSocio, LocalDate fecha) {
        List<Membresia> membresias = new ArrayList();
        try {
            String sql = "SELECT * FROM membresia WHERE idSocio = ? AND fInicio < ? AND fFin > ? AND estado = 1";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idSocio);
            ps.setDate(2, Date.valueOf(fecha));
            ps.setDate(3, Date.valueOf(fecha));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Membresia m = new Membresia();
                m.setIdMembresia(rs.getInt("idMembresia"));
                m.setSocio(sData.buscarSocio(rs.getInt("idSocio")));
                m.setCantPases(rs.getInt("cantPases"));
                m.setfInicio(rs.getDate("fInicio").toLocalDate());
                m.setfFin(rs.getDate("fFin").toLocalDate());
                m.setCosto(rs.getInt("costo"));
                m.setEstado(rs.getBoolean("estado"));
                membresias.add(m);
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Membresia " + e.getMessage());
        }
        return membresias;
    }

    public void eliminarMembresia(int id) {
        try {
            String sql = "UPDATE membresia SET estado = 0 WHERE idMembresia = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);          
            int fila = ps.executeUpdate();
            if (fila == 1) {
                JOptionPane.showMessageDialog(null, "Se borró la membresia con éxito.");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Membresia");
        }
    }

    public void modificarMembresia(Membresia membresia) {
        try {
            String sql = "UPDATE membresia SET idSocio = ?, cantPases = ?, fInicio = ?, fFin = ?, costo = ?, estado = ? WHERE idMembresia = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,membresia.getSocio().getIdSocio());
            ps.setInt(2,membresia.getCantPases());
            ps.setDate(3, Date.valueOf(membresia.getfInicio()));
            ps.setDate(4, Date.valueOf(membresia.getfFin()));
            ps.setDouble(5,membresia.getCosto());
            ps.setBoolean(6, membresia.isEstado());
            ps.setInt(7, membresia.getIdMembresia());
            int fila = ps.executeUpdate();
            if (fila == 1) {
                JOptionPane.showMessageDialog(null, "Se actualizó la membresia correctamente.");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Membresia "+ e.getMessage());
        }
    }
    
    //Es membresia Válida??
    public boolean nuevaMembresiaValida(Socio socio, Membresia nueva) {
        
        try {
            String sql = "SELECT * FROM membresia WHERE idSocio = ? AND ( fInicio < ? AND fFin > ? AND cantPases > 0 ) AND estado = 1";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, socio.getIdSocio());
            ps.setDate(2, Date.valueOf(nueva.getfFin()));
            ps.setDate(3, Date.valueOf(nueva.getfInicio()));
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return false;
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Membresia " + e.getMessage());
        }
        return true;
    }

}

