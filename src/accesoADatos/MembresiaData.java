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
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class MembresiaData {

    private Connection con = null;
    private SocioData sData = new SocioData();
    //private ClaseData cData = new ClaseData();
    //private EntrenadorData eData = new EntrenadorData();
    
    
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
            ResultSet rs = ps.getGeneratedKeys();
            ps.executeUpdate();
            if (rs.next()) {
                membr.setIdMembresia(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Se ha efectuado la membresía con éxito.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Membresia" + ex.getMessage());
        }
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
                //m.setClase(cData.buscarClase(rs.getInt("idClase")));----------------------------
                //m.setEntrenador(eData.buscarClase(rs.getInt("idEntrenador")));--------------------
                membresias.add(m);
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Membresia " + e.getMessage());
        }
        return membresias;
    }

    public void borrarMembresiaSocio(int idSocio) {
        try {
            String sql = "UPDATE FROM membresia SET estado = ?  WHERE idSocio = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idSocio);          
            int fila = ps.executeUpdate();
            if (fila == 1) {
                JOptionPane.showMessageDialog(null, "Se borró la membresia con éxito.");
            } else if (fila > 1) {
                JOptionPane.showMessageDialog(null, "Se borraron " + fila + " registros de membresía.");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Membresia");
        }

    }

    public void actualizarMembresia(Membresia membresia) {
        try {
            String sql = "UPDATE membresia SET cantPases = ?, fInicio=?, fFin=?, costo=?, estado=? WHERE idSocio = ? AND idClase = ?  WHERE idSocio=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,membresia.getCantPases());
            ps.setDate(2, Date.valueOf(membresia.getfInicio()));
            ps.setDate(3, Date.valueOf(membresia.getfFin()));
            ps.setBoolean(4, membresia.isEstado());
            int fila = ps.executeUpdate();
            if (fila == 1) {
                JOptionPane.showMessageDialog(null, "Se actualizó la membresia correctamente.");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Membresia");
        }
    }



}

