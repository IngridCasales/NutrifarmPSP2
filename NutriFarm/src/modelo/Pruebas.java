
package modelo;

import java.util.ArrayList;
import java.util.List;

import baseDatos.AdminBD;

public class Pruebas {
  public static void main(String[] args) {	
	  AdminBD admin = new AdminBD();
	  admin.obtenerConexion();
	  
  }
	
  /*
  public static void main(String[] args) {
    List<TipoIngrediente> TipIng = new ArrayList<TipoIngrediente>();
    List<Ingrediente> Ing = new ArrayList<Ingrediente>();
    Query queryTI = new Query();
    TipIng = queryTI.obtenerTipoIngredientes();
    
    System.out.println("Tipo_Ingredientes");
    for(TipoIngrediente ti: TipIng) {
      System.out.println(ti.getNum_tipo()+" | "+ti.getNom_tipo());
    }
    Query queryI = new Query();
    Ing = queryI.obtenerIngredientes();
    System.out.println("Ingredientes");
    for(Ingrediente i: Ing) {
      System.out.println(i.getNum_intnac()+" | "+i.getNom_ing()+"  "+i.getMat_seca()+"  "+i.getPro_cru()+"  "+i.getFib_cru());
    }
  }
  */
}
