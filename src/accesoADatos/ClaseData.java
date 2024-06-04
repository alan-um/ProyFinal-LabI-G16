package accesoADatos;

import entidades.Entrenador;
import entidades.Clase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author urqui
 */
public class ClaseData {
    private Connection con = null;
    private EntrenadorData eData = new EntrenadorData();

    public ClaseData() {
        con = Conexion.getConexion();
    }

    //Guardar una clase en la DB
    public void guardarClase(Clase clase) {
        String sql = "INSERT INTO clase (nombre, idEntrenador, horario, capacidad, estado) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, clase.getNombre());
            ps.setInt(2, clase.getEntrenador().getIdEntrenador());
            ps.setTime(3, Time.valueOf(clase.getHorario()));
            ps.setInt(4, clase.getCapacidad());
            ps.setBoolean(5, clase.isEstado());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
 
            if (rs.next()) {
                clase.setIdClase(rs.getInt(1));   
          
                JOptionPane.showMessageDialog(null, "Clase añadida con éxito.");
            }

            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Clase" + ex.getMessage());
        }
    }

    //Buscar una Clase según su idClase
    public Clase buscarClase(int id) {
        Clase clase = null;
        String sql = "SELECT nombre, idEntrenador, horario, capacidad FROM clase WHERE idClase = ? AND estado = 1";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                clase = new Clase();
                clase.setIdClase(id);
                clase.setNombre(rs.getString("nombre"));
                Entrenador entrenador = eData.buscarEntrenador(rs.getInt("idEntrenador"));
                clase.setEntrenador(entrenador);
                clase.setHorario(rs.getTime("horario").toLocalTime());
                clase.setCapacidad(rs.getInt("capacidad"));
                clase.setEstado(true);

            } else {
                JOptionPane.showMessageDialog(null, "No existe ninguna clase con ese Id");              
                ps.close();}
            
            }catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Clase " + ex.getMessage());
            }

            return clase;    
        }
    

    //Listar las Clase de la BD, que estén activas.
    public List<Clase> listarClases() {

        List<Clase> clases = new ArrayList<>();
        try {
            String sql = "SELECT * FROM clase WHERE estado = 1 ";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Clase clase = new Clase();
                clase.setIdClase(rs.getInt("idClase"));
                clase.setNombre(rs.getString("nombre"));
                Entrenador entrenador = eData.buscarEntrenador(rs.getInt("idEntrenador"));
                clase.setEntrenador(entrenador);
                clase.setHorario(rs.getTime("horario").toLocalTime());
                clase.setCapacidad(rs.getInt("capacidad"));
                clase.setEstado(true);
                
                clases.add(clase);

            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Clase " + ex.getMessage());
        }
        return clases;
    }

    //Actualizar una Clase de la DB.
    public void modificarClase(Clase clase) {
        String sql = "UPDATE clase SET nombre = ?, idEntrenador = ?, horario = ?, capacidad = ?, estado = ? WHERE idClase = ?";
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, clase.getNombre());
            ps.setInt(2, clase.getEntrenador().getIdEntrenador());
            ps.setTime(3, Time.valueOf(clase.getHorario()));
            ps.setInt(4, clase.getCapacidad());
            ps.setBoolean(5, clase.isEstado());
            ps.setInt(6, clase.getIdClase());
            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Modificada exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "La clase no existe");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Clase " + ex.getMessage());
        }

    }

    //Eliminar una Clase de la BD. BORRADO LÓGICO!!
    public void eliminarClase(int id) {

        try {
            String sql = "UPDATE clase SET estado = 0 WHERE idClase = ? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int fila = ps.executeUpdate();

            if (fila == 1) {
                JOptionPane.showMessageDialog(null, " Se eliminó la clase.");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Clase");
        }

    }
   
}
