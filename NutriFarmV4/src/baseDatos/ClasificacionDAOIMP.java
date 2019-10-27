package baseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Clasificacion;

public class ClasificacionDAOIMP implements ClasificacionDAO {
  
  private AdminBD admin;
  private Connection conexion;
  
  public ClasificacionDAOIMP() {
    admin = new AdminBD();    
    conexion = null;
  }
  
  @Override
  public List<Clasificacion> obtnenerClasificaciones() {
    List<Clasificacion> lista = new ArrayList<Clasificacion>();
    String sql = "SELECT * FROM clasificaciones";
    Clasificacion clasificacion = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    try {
      conexion = admin.obtenerConexion();
      ps = conexion.prepareStatement(sql);
      rs = ps.executeQuery();
      while (rs.next()) {
        clasificacion = new Clasificacion();
        clasificacion.setTipo(rs.getString("tipo"));
        lista.add(clasificacion);
      }
      rs.close();
      ps.close();
      conexion.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return lista;
  }

}
