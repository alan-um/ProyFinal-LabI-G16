
package accesoADatos;

import entidades.Socio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    
    
    
        public List<Socio> socioPorClases(int idClase) {
        List<Socio> socios = new ArrayList();
        try {
            String sql = "SELECT idSocio FROM asistencia WHERE idClase = ?;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idClase);
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
}
