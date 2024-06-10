package accesoADatos;

import entidades.Socio;
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
public class SocioData {
    private Connection con = null;

    public SocioData() {
        con = Conexion.getConexion();
    }

    //Guardar un socio en la DB
    public void guardarSocio(Socio socio) {
        String sql = "INSERT INTO socio (dni, nombre, apellido, edad, correo, telefono, estado) VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, socio.getDni());
            ps.setString(2, socio.getNombre());
            ps.setString(3, socio.getApellido());
            ps.setInt(4, socio.getEdad());
            ps.setString(5, socio.getCorreo());
            ps.setString(6, socio.getTelefono());
            ps.setBoolean(7, socio.isEstado());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
 
            if (rs.next()) {
                socio.setIdSocio(rs.getInt(1));   
          
                JOptionPane.showMessageDialog(null, "Socio añadido con éxito.");
            }

            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Socio" + ex.getMessage());
        }
    }

    //Buscar un socio según su idSocio
    public Socio buscarSocio(int id) {
        Socio socio = null;
        String sql = "SELECT dni, nombre, apellido, edad, correo, telefono FROM socio WHERE idSocio = ? AND estado = 1";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                socio = new Socio();
                socio.setIdSocio(id);
                socio.setDni(rs.getInt("dni"));
                socio.setNombre(rs.getString("nombre"));
                socio.setApellido(rs.getString("apellido"));
                socio.setEdad(rs.getInt("edad"));
                socio.setCorreo(rs.getString("correo"));
                socio.setTelefono(rs.getString("telefono"));
                socio.setEstado(true);

            } else {
                JOptionPane.showMessageDialog(null, "No existe ningún socio con ese Id");              
                ps.close();}
            
            }catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Socio " + ex.getMessage());
            }

            return socio;    
        }
    
    //Buscar un socio según su DNI
    public Socio buscarSocioPorDni(int dni) {
        Socio socio = null;
        String sql = "SELECT idSocio, dni, nombre, apellido, edad, correo, telefono FROM socio WHERE dni = ? AND estado = 1";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, dni);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                socio = new Socio();
                socio.setIdSocio(rs.getInt("idSocio"));
                socio.setDni(rs.getInt("dni"));
                socio.setNombre(rs.getString("nombre"));
                socio.setApellido(rs.getString("apellido"));
                socio.setEdad(rs.getInt("edad"));
                socio.setCorreo(rs.getString("correo"));
                socio.setTelefono(rs.getString("telefono"));
                socio.setEstado(true);

            } else {
                JOptionPane.showMessageDialog(null, "No existe ningún socio con ese DNI");              
                ps.close();}
            
            }catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Socio " + ex.getMessage());
                    }

            return socio;    
        }
    
    //Listar los socios según su nombre.
    public List<Socio> listarSociosPorNombre(String nombre) {

        List<Socio> socios = new ArrayList<>();
        try {
            String sql = "SELECT * FROM socio WHERE nombre LIKE ? AND estado = 1 ";
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps = con.prepareStatement(sql);
            ps.setString(1, '%'+nombre+'%');
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Socio socio = new Socio();
                
                socio.setIdSocio(rs.getInt("idSocio"));
                socio.setDni(rs.getInt("dni"));
                socio.setNombre(rs.getString("nombre"));
                socio.setApellido(rs.getString("apellido"));
                socio.setEdad(rs.getInt("edad"));
                socio.setCorreo(rs.getString("correo"));
                socio.setTelefono(rs.getString("telefono"));
                socio.setEstado(rs.getBoolean("estado"));
                
                socios.add(socio);

            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Socio " + ex.getMessage());
        }
        return socios;
    }
    
    
    //Listar los socios de la BD, que estén activos.
    public List<Socio> listarSocios() {

        List<Socio> socios = new ArrayList<>();
        try {
            String sql = "SELECT * FROM socio WHERE estado = 1 ";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Socio socio = new Socio();
                
                socio.setIdSocio(rs.getInt("idSocio"));
                socio.setDni(rs.getInt("dni"));
                socio.setNombre(rs.getString("nombre"));
                socio.setApellido(rs.getString("apellido"));
                socio.setEdad(rs.getInt("edad"));
                socio.setCorreo(rs.getString("correo"));
                socio.setTelefono(rs.getString("telefono"));
                socio.setEstado(rs.getBoolean("estado"));
                
                socios.add(socio);

            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Socio " + ex.getMessage());
        }
        return socios;
    }

    //Actualizar un socio de la DB.
    public void modificarSocio(Socio socio) {
        String sql = "UPDATE socio SET dni = ?, nombre = ?, apellido = ?, edad = ?, correo = ?, telefono = ?, estado = ? WHERE idSocio = ?";
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, socio.getDni());
            ps.setString(2, socio.getNombre());
            ps.setString(3, socio.getApellido());
            ps.setInt(4, socio.getEdad());
            ps.setString(5, socio.getCorreo());
            ps.setString(6, socio.getTelefono());
            ps.setBoolean(7, socio.isEstado());
            ps.setInt(8, socio.getIdSocio());
            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Modificado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "El socio no existe");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Socio " + ex.getMessage());
        }

    }

    //Eliminar un socio de la BD. BORRADO LÓGICO!!
    public void eliminarSocio(int id) {

        try {
            String sql = "UPDATE socio SET estado = 0 WHERE idSocio = ? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int fila = ps.executeUpdate();

            if (fila == 1) {
                JOptionPane.showMessageDialog(null, " Se eliminó el socio.");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Socio");
        }

    }
    
}
