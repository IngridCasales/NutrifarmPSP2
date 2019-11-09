package baseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Animal;

public class AnimalDAOIMP implements AnimalDAO {

  private AdminBD admin;
  private Connection conexion;

  public AnimalDAOIMP() {
    admin = new AdminBD();    
    conexion = null;
  }
  
  @Override
  public List<Animal> obtenerAnimales() {
    List<Animal> lista = new ArrayList<Animal>();
    String sql = "SELECT * FROM animales";
    PreparedStatement ps = null;
    ResultSet rs = null;
    Animal animal = null;
    try {
      conexion = admin.obtenerConexion();
      ps = conexion.prepareStatement(sql);
      rs = ps.executeQuery();
      while (rs.next()) {
        animal = new Animal();
        animal.setEspecie(rs.getString("especie"));
        animal.setPeso_kg(rs.getInt("peso_kg"));
        animal.setEtapa_descrip(rs.getString("etapa_descrip"));
        lista.add(animal);
      }
      rs.close();
      ps.close();
      conexion.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return lista;
  }
  
  public void asignarRequerimientos(Animal animal) {
    // Implementar
  }
}
