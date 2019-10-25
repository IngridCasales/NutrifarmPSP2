
package baseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Peso;

public class PesoDAOIMP implements PesoDAO{
  
  private AdminBD admin;
  private Connection conexion;
  
  public PesoDAOIMP() {
    admin = new AdminBD();    
    conexion = null;
  }
  
  @Override
  public List<Peso> obtenerPesos() {
    List<Peso> lista = new ArrayList<Peso>();
    String sql = "SELECT * FROM pesos";
    PreparedStatement ps = null;
    ResultSet rs = null;
    Peso peso = null;
    try {
      conexion = admin.obtenerConexion();
      ps = conexion.prepareStatement(sql);
      rs = ps.executeQuery();
      while(rs.next()) {
        peso = new Peso();
        peso.setKg(rs.getInt("kg"));
        lista.add(peso);
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
