
package baseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Ingrediente;

public class IngredienteDAOIMP implements IngredienteDAO {
  
  private AdminBD admin;
  private Connection conexion;
  
  public IngredienteDAOIMP() {
    admin = new AdminBD();    
    conexion = null;
  }
  
  @Override
  public List<Ingrediente> obtenerIngredientes() {
    List<Ingrediente> lista = new ArrayList<Ingrediente>();
    String sql = "SELECT * FROM ingredientes";
    Ingrediente ingrediente = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    try {
      conexion = admin.obtenerConexion();
      ps = conexion.prepareStatement(sql);
      rs = ps.executeQuery();
      while(rs.next()) {
        ingrediente = new Ingrediente();
        ingrediente.setNum_ing(rs.getInt("num_ing"));
        ingrediente.setNom_ing(rs.getString("nom_ing"));
        ingrediente.setMat_sec(rs.getDouble("mat_sec"));
        ingrediente.setPro_cru(rs.getDouble("pro_cru"));
        ingrediente.setFib_cru(rs.getDouble("fib_cru"));
        ingrediente.setCa(rs.getDouble("ca"));
        ingrediente.setP(rs.getDouble("p"));
        ingrediente.setMg(rs.getDouble("mg"));
        ingrediente.setEm(rs.getDouble("em"));
        ingrediente.setTnd(rs.getDouble("tnd"));
        ingrediente.setClasificacion_tipo(rs.getString("clasificacion_tipo"));
        lista.add(ingrediente);
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
