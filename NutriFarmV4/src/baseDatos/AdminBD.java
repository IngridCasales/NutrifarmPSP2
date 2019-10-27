package baseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AdminBD {
  
  /**
   * Conexi�n con la Base de Datos NutriFarm.
   * @author John Cid
   * @version 2.1 08/10/19
   */  
  public Connection obtenerConexion() {
    String url = "jdbc:sqlite:/Users/mac/Documents/AsegDeLaCalidad/sqllite/sqlite-tools/nutrifarm";
    Connection conn = null;
    try {
      conn = DriverManager.getConnection(url);
      System.out.println("\n Conexion con la BD establecida !");
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return conn;
  }
  
}
