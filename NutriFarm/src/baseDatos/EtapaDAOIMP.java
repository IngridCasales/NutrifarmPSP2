
package baseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Etapa;

public class EtapaDAOIMP implements EtapaDAO {
  
  private AdminBD admin;
  private Connection conexion;
  
  public EtapaDAOIMP() {
    admin = new AdminBD();    
    conexion = null;
  }
  
  @Override
  public List<Etapa> obtenerEtapas() {
    List<Etapa> lista = new ArrayList<Etapa>();
    String sql = "SELECT * FROM etapas";
    PreparedStatement ps = null;
    ResultSet rs = null;
    Etapa etapa = null;
    try {
      conexion = admin.obtenerConexion();
      ps = conexion.prepareStatement(sql);
      rs = ps.executeQuery();
      while(rs.next()) {
        etapa = new Etapa();
        etapa.setDescrip(rs.getString("descrip"));
        etapa.setGanancia(rs.getInt("ganancia"));
        lista.add(etapa);
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
