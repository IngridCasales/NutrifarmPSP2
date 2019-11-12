
package baseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
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
      while (rs.next()) {
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
  
  @Override
  public int insertar(Ingrediente ing) {
    int cont = 0;
    String sql = "INSERT INTO ingredientes("
        + "nom_ing,mat_sec,pro_cru,fib_cru,ca,p,mg,em,tnd,clasificacion_tipo)"
        + " VALUES(?,?,?,?,?,?,?,?,?,?)";
    PreparedStatement ps = null;
    try {
      conexion = admin.obtenerConexion();
      conexion.setAutoCommit(false);
      ps = conexion.prepareStatement(sql);
      ps.setString(1,ing.getNom_ing());
      ps.setDouble(2,ing.getMat_sec());
      ps.setDouble(3,ing.getPro_cru());
      ps.setDouble(4,ing.getFib_cru());
      ps.setDouble(5,ing.getCa());
      ps.setDouble(6,ing.getP());
      ps.setDouble(7,ing.getMg());
      ps.setDouble(8,ing.getEm());
      ps.setDouble(9,ing.getTnd());
      ps.setString(10,ing.getClasificacion_tipo());
      cont = ps.executeUpdate();
      if (cont == 1) {
        conexion.commit();
      } else {
        conexion.rollback();
      }
      
    } catch (SQLException e) {
      e.printStackTrace();
      JOptionPane.showMessageDialog(null, "Error!*Ingrediente No agregado",
          "Error", JOptionPane.ERROR_MESSAGE);
    } finally {
    	try {
			ps.close();
			conexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    return cont;
  }

}
