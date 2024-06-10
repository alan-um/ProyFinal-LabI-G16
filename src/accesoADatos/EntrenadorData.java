package accesoADatos;

import entidades.Entrenador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author urqui
 */
public class EntrenadorData {
    private Connection con = null;

    public EntrenadorData() {
        con = Conexion.getConexion();
    }

    //Guardar un entrenador en la DB
    public void guardarEntrenador(Entrenador entrenador) {
        String sql = "INSERT INTO entrenador (dni, nombre, apellido, especialidad, estado) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, entrenador.getDni());
            ps.setString(2, entrenador.getNombre());
            ps.setString(3, entrenador.getApellido());
            ps.setString(4, entrenador.getEspecialidad());
            ps.setBoolean(5, entrenador.isEstado());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
 
            if (rs.next()) {
                entrenador.setIdEntrenador(rs.getInt(1));   
          
                JOptionPane.showMessageDialog(null, "Entrenador añadido con éxito.");
            }

            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Entrenador" + ex.getMessage());
        }
    }

    //Buscar un Entrenador según su idEntrenador
    public Entrenador buscarEntrenador(int id) {
        Entrenador entrenador = null;
        String sql = "SELECT dni, nombre, apellido, especialidad FROM entrenador WHERE idEntrenador = ? AND estado = 1";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                entrenador = new Entrenador();
                entrenador.setIdEntrenador(id);
                entrenador.setDni(rs.getInt("dni"));
                entrenador.setNombre(rs.getString("nombre"));
                entrenador.setApellido(rs.getString("apellido"));
                entrenador.setEspecialidad(rs.getString("especialidad"));
                entrenador.setEstado(true);

            } else {
                JOptionPane.showMessageDialog(null, "No existe ningún entrenador con ese Id");              
                ps.close();}
            
            }catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Entrenador " + ex.getMessage());
            }

            return entrenador;    
        }
    
    //Buscar un entrenador según su DNI
    public Entrenador buscarEntrenadorPorDni(int dni) {
        Entrenador entrenador = null;
        String sql = "SELECT idEntrenador, dni, nombre, apellido, especialidad FROM entrenador WHERE dni = ? AND estado = 1";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, dni);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                entrenador = new Entrenador();
                entrenador.setIdEntrenador(rs.getInt("idEntrenador"));
                entrenador.setDni(rs.getInt("dni"));
                entrenador.setNombre(rs.getString("nombre"));
                entrenador.setApellido(rs.getString("apellido"));
                entrenador.setEspecialidad(rs.getString("especialidad"));
                entrenador.setEstado(true);

            } else {
                JOptionPane.showMessageDialog(null, "No existe ningún entrenador con ese DNI");              
                ps.close();}
            
            }catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Entrenador " + ex.getMessage());
                    }

            return entrenador;    
        }
    
    //Listar los entrenadores según nombre o apellido.
    public List<Entrenador> listarEntrenadoresPorNombre(String nombre) {
        String apellido = nombre;
        List<Entrenador> entrenadores = new ArrayList<>();
        try {
            String sql = "SELECT * FROM entrenador WHERE ( nombre LIKE ? OR apellido LIKE ? ) AND estado = 1 ";
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, '%'+nombre+'%');
            ps.setString(2, '%'+apellido+'%');
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Entrenador entrenador = new Entrenador();
                
                entrenador.setIdEntrenador(rs.getInt("idEntrenador"));
                entrenador.setDni(rs.getInt("dni"));
                entrenador.setNombre(rs.getString("nombre"));
                entrenador.setApellido(rs.getString("apellido"));
                entrenador.setEspecialidad(rs.getString("especialidad"));
                entrenador.setEstado(true);
                
                entrenadores.add(entrenador);

            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Entrenador " + ex.getMessage());
        }
        return entrenadores;
    }
    
    //Listar los entrenadores según especialidad.
    public List<Entrenador> listarEntrenadoresPorEspecialidad(String especialidad) {

        List<Entrenador> entrenadores = new ArrayList<>();
        try {
            String sql = "SELECT * FROM entrenador WHERE especialidad LIKE ? AND estado = 1 ";
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, '%'+especialidad+'%');
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Entrenador entrenador = new Entrenador();
                
                entrenador.setIdEntrenador(rs.getInt("idEntrenador"));
                entrenador.setDni(rs.getInt("dni"));
                entrenador.setNombre(rs.getString("nombre"));
                entrenador.setApellido(rs.getString("apellido"));
                entrenador.setEspecialidad(rs.getString("especialidad"));
                entrenador.setEstado(true);
                
                entrenadores.add(entrenador);

            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Entrenador " + ex.getMessage());
        }
        return entrenadores;
    }
    
    //Listar los entrenadores de la BD, que estén activos.
    public List<Entrenador> listarEntrenadores() {

        List<Entrenador> entrenadores = new ArrayList<>();
        try {
            String sql = "SELECT * FROM entrenador WHERE estado = 1 ";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Entrenador entrenador = new Entrenador();
                
                entrenador.setIdEntrenador(rs.getInt("idEntrenador"));
                entrenador.setDni(rs.getInt("dni"));
                entrenador.setNombre(rs.getString("nombre"));
                entrenador.setApellido(rs.getString("apellido"));
                entrenador.setEspecialidad(rs.getString("especialidad"));
                entrenador.setEstado(true);
                
                entrenadores.add(entrenador);

            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Entrenador " + ex.getMessage());
        }
        return entrenadores;
    }

    //Actualizar un entrenador de la DB.
    public void modificarEntrenador(Entrenador entrenador) {
        String sql = "UPDATE entrenador SET dni = ?, nombre = ?, apellido = ?, especialidad = ?, estado = ? WHERE idEntrenador = ?";
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, entrenador.getDni());
            ps.setString(2, entrenador.getNombre());
            ps.setString(3, entrenador.getApellido());
            ps.setString(4, entrenador.getEspecialidad());
            ps.setBoolean(5, entrenador.isEstado());
            ps.setInt(6, entrenador.getIdEntrenador());
            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Modificado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "El entrenador no existe");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Entrenador " + ex.getMessage());
        }

    }

    //Eliminar un entrenador de la BD. BORRADO LÓGICO!!
    public void eliminarEntrenador(int id) {

        try {
            String sql = "UPDATE entrenador SET estado = 0 WHERE idEntrenador = ? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int fila = ps.executeUpdate();

            if (fila == 1) {
                JOptionPane.showMessageDialog(null, " Se eliminó el entrenador.");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Entrenador");
        }

    }
    
}
