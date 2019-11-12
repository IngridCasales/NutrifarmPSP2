
package baseDatos;

import java.util.List;

import modelo.Ingrediente;

public interface IngredienteDAO {
  
  public List<Ingrediente> obtenerIngredientes();
  
  public int insertar(Ingrediente ing);
  
}
