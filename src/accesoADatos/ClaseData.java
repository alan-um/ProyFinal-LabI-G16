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
    
    //Buscar una Clase según su horario
    public Clase buscarClasePorHorario(LocalTime horario) {
        Clase clase = null;
        String sql = "SELECT idClase, nombre, idEntrenador, capacidad FROM clase WHERE horario = ? AND estado = 1";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setTime(1, Time.valueOf(horario));
            
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                clase = new Clase();
                clase.setIdClase(rs.getInt("idClase"));
                clase.setNombre(rs.getString("nombre"));
                Entrenador entrenador = eData.buscarEntrenador(rs.getInt("idEntrenador"));
                clase.setEntrenador(entrenador);
                clase.setHorario(horario);
                clase.setCapacidad(rs.getInt("capacidad"));
                clase.setEstado(true);

            } else {
                JOptionPane.showMessageDialog(null, "No existe ninguna clase en ese horario.");              
                ps.close();}
            
            }catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Clase " + ex.getMessage());
            }

            return clase;    
        }
    
    //Listar las Clase según nombre.
    public List<Clase> listarClasesPorNombre(String nombre) {

        List<Clase> clases = new ArrayList<>();
        try {
            String sql = "SELECT * FROM clase WHERE nombre LIKE ? AND estado = 1 ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, '%'+nombre+'%');
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
    
    //Listar las Clase según Entrenador.
    public List<Clase> listarClasesPorEntrenador(Entrenador entrenador) {

        List<Clase> clases = new ArrayList<>();
        try {
            String sql = "SELECT * FROM clase WHERE idEntrenador = ? AND estado = 1 ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, entrenador.getIdEntrenador());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Clase clase = new Clase();
                clase.setIdClase(rs.getInt("idClase"));
                clase.setNombre(rs.getString("nombre"));
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
    
    //Listar las Clase según Horario.
    public List<Clase> listarClasesPorHorario(LocalTime horario) {

        List<Clase> clases = new ArrayList<>();
        try {
            String sql = "SELECT * FROM clase WHERE horario = ? AND estado = 1 ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setTime(1, Time.valueOf(horario));
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
    
    //Listar horarios de atención del Gimnasio
    public List<LocalTime> horariosDeAtencion(){
        List<LocalTime> horarios = new ArrayList();
        
        //Carga de horarios disponibles de acuerdo al horario de atención del gimnasio. De 8hs a 13hs. y 15hs a 22hs.
        for(int i=8;i<13;i++){
            horarios.add(LocalTime.of(i,0,0));
        }
        for(int i=15;i<22;i++){
            horarios.add(LocalTime.of(i,0,0));
        }
        
        return horarios;
    }
    
    //Listar horarios disponibles
    public List<LocalTime> horariosDisponibles(){
        List<LocalTime> horarios = new ArrayList();
        
        //Carga de horarios disponibles de acuerdo al horario de atención del gimnasio. De 8hs a 13hs. y 15hs a 22hs.
        for(int i=8;i<13;i++){
            horarios.add(LocalTime.of(i,0,0));
        }
        for(int i=15;i<22;i++){
            horarios.add(LocalTime.of(i,0,0));
        }
        
        //Remueve los horarios ocupados por las clases activas
        try {
            String sql = "SELECT horario FROM clase WHERE estado = 1 ";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                horarios.remove((LocalTime)rs.getTime("horario").toLocalTime());
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Clase " + ex.getMessage());
        }
        
        return horarios;
    }
    
    //Listar los nombres de las Clases que se pueden dictar en el Gimnasio.
    public List<String> nombresDeClases() {

        List<String> clases = new ArrayList<>();
        
        //Hardcode con los nombres de las clases disponibles
        clases.add("Spinning");
        clases.add("CrossFit");
        clases.add("Running");
        clases.add("Zumba");
        clases.add("Musculación");
        clases.add("Aerobic");
        clases.add("Natación");
        clases.add("Elongación");
        
        return clases;
    }
   
}
