
package modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.Timestamp;

public class Mezcla {
  
  private int num_mezcla;
  private Date fecha;
  private String nota;
  private String animal_especie;
  private int animal_kg;
  private String animal_descrip; // etapa
  private List<Cantidad> cantidades;
  
  
  public static int contador = 0;
  
  /** Busca al  ingrediente con mayor contenido de pc. **/
  public int buscaMayorPc(ArrayList<Ingrediente> ingredientes) {
    int i = 0;
    int mayor = 0;
    for (i = 1;i < ingredientes.size();i++) {
      if (ingredientes.get(i).getPro_cru() > ingredientes.get(mayor).getPro_cru()) {
        if (ingredientes.get(i).getClasificacion_tipo().equalsIgnoreCase("voluminoso")) {
          break; 
        } else {
          mayor = i;
        }
      }
    }
    return mayor;
  }
  
  /** Busca al  ingrediente con menor contenido de pc. **/  
  public int buscaMenorrPc(ArrayList<Ingrediente> ingredientes) {
    int i = 0;
    int menor = 0;
    for (i = 1;i < ingredientes.size();i++) {
      if (ingredientes.get(i).getPro_cru() < ingredientes.get(menor).getPro_cru()) {
        if (ingredientes.get(i).getClasificacion_tipo().equalsIgnoreCase("voluminoso")) {
          break; 
        } else {
          menor = i;
        }
      }
    }
    return menor;
  }
  
  /** Busca al  ingrediente con mayor contenido de em. **/
  public int buscaMayorEm(ArrayList<Ingrediente> ingredientes) { 
    int i = 0;
    int mayor = 0;
    for (i = 1;i < ingredientes.size();i++) {
      if (ingredientes.get(i).getEm() > ingredientes.get(mayor).getEm()) {
    	  if (ingredientes.get(i).getClasificacion_tipo().equalsIgnoreCase("voluminoso")) {
              break; 
            } else {
               mayor = i;
            }
      }
    }
    return mayor;
  }
  
  /** Busca al  ingrediente con menor contenido de em. **/
  public int buscaMenorEm(ArrayList<Ingrediente> ingredientes) {
    int i = 0; 
    int menor = 0;
    for (i = 1;i < ingredientes.size();i++) {
      if (ingredientes.get(i).getEm() < ingredientes.get(menor).getEm()) {
        if (ingredientes.get(i).getClasificacion_tipo().equalsIgnoreCase("voluminoso")) {
          break; 
        } else {
          menor = i;
        }
      }
    }
    return menor;
  }
  
  /** Busca al  ingrediente con mayor contenido de tnd. **/
  public int buscaMayorTnd(ArrayList<Ingrediente> ingredientes) {
    int i = 0;
    int mayor = 0;
    for (i = 1;i < ingredientes.size();i++) {
      if (ingredientes.get(i).getEm() > ingredientes.get(mayor).getEm()) {
        if (ingredientes.get(i).getClasificacion_tipo().equalsIgnoreCase("voluminoso")) {
          mayor = i;
        }
      }
    }
    return mayor;
  }
  
  /** Busca al  ingrediente con menor contenido de tnd. **/
  public int buscaMenorTnd(ArrayList<Ingrediente> ingredientes) {
    int i = 0;
    int menor = 0;
    for (i = 1;i < ingredientes.size();i++) {
      if (ingredientes.get(i).getTnd() < ingredientes.get(menor).getTnd()) {
        if (ingredientes.get(i).getClasificacion_tipo().equalsIgnoreCase("voluminoso")) {
          break;
        } else {
          menor = i;
        }
      }
    }
    return menor;
  }
  
  public Mezcla(int num_mezcla,Date fecha,String nota,String animal_especie,
      int animal_kg,String animal_descrip,List<Cantidad> cantidades) {
    this.num_mezcla = num_mezcla;
    this.fecha = fecha;
    this.nota = nota;
    this.animal_especie = animal_especie;
    this.animal_kg = animal_kg;
    this.animal_descrip = animal_descrip;
    this.cantidades = cantidades;
  }
  
  public Mezcla() {
    
  }
  
  public int getNum_mezcla() {
    return num_mezcla;
  }

  public Date getFecha() {
    return fecha;
  }

  public String getNota() {
    return nota;
  }

  public String getAnimal_especie() {
    return animal_especie;
  }

  public int getAnimal_kg() {
    return animal_kg;
  }

  public String getAnimal_descrip() {
    return animal_descrip;
  }

  public List<Cantidad> getCantidades() {
    return cantidades;
  }

  public void setNum_mezcla(int num_mezcla) {
    this.num_mezcla = num_mezcla;
  }

  public void setFecha(Date fecha) {
    this.fecha = fecha;
  }

  public void setNota(String nota) {
    this.nota = nota;
  }

  public void setAnimal_especie(String animal_especie) {
    this.animal_especie = animal_especie;
  }

  public void setAnimal_kg(int animal_kg) {
    this.animal_kg = animal_kg;
  }

  public void setAnimal_descrip(String animal_descrip) {
    this.animal_descrip = animal_descrip;
  }

  public void setCantidades(List<Cantidad> cantidades) {
    this.cantidades = cantidades;
  }
  public ArrayList<Double> porcentajeInicial(int total) {
	  double porcentajeInicial = 100 / total;
	  int i = 0;
	  ArrayList<Double> porcentajes = new ArrayList<Double> ();
	  for (i = 0; i<total; i++ ) {
		  porcentajes.add(porcentajeInicial);
	  }
	  
	  return porcentajes;
  }
  public ArrayList<Double> balancearPc(ArrayList<Ingrediente> ingres, Double requerimiento, ArrayList<Double> porcentajes) {
	  int menor = 0;
	  int mayor = 0;
	  int i = 0;
	  int vuelta = 0;
	  double pc = 0;
	  Boolean listo = false;
	  double total = ingres.size();
	  
	  Mezcla m = new Mezcla();
	  do {
		  for (i = 0;i < total;i++) {
		        pc = pc + ((porcentajes.get(i) * ingres.get(i).getPro_cru()) / 100);
		      }
		  if (pc < requerimiento) {
			  mayor = m.buscaMayorPc(ingres);
			  menor = m.buscaMenorrPc(ingres);
			  if ((porcentajes.get(mayor) > 10 && porcentajes.get(mayor) < 50)
					  || (porcentajes.get(menor) > 10 && porcentajes.get(menor) < 50)) {
				  porcentajes.set(mayor, porcentajes.get(mayor) + 0.5);
				  porcentajes.set(menor, porcentajes.get(menor) - 0.5);
			  }
			  
			  
		  } else {
			  if ( pc > (requerimiento +2)) {
				  mayor = m.buscaMayorPc(ingres);
				  menor = m.buscaMenorrPc(ingres);
				  if ((porcentajes.get(mayor) > 10 && porcentajes.get(mayor) < 50)
						  || (porcentajes.get(menor) > 10 && porcentajes.get(menor) < 50)) {
					  porcentajes.set(mayor, porcentajes.get(mayor) - 0.5);
					  porcentajes.set(menor, porcentajes.get(menor) + 0.5);
				  }
				  
			  } else {
				  listo = true;
			  }
		  }
		vuelta++;
	  } while (listo || vuelta <= 25);  
	  
    return porcentajes;
  }
  public ArrayList<Double> balancearEm (ArrayList<Ingrediente> ingres, Double requerimiento, ArrayList<Double> porcentajes) {
	  int menor = 0;
	  int mayor = 0;
	  int i = 0;
	  int vuelta = 0;
	  double em = 0;
	  Boolean listo = false;
	  double total = ingres.size();
	  
	  Mezcla m = new Mezcla();
	  do {
		  for (i = 0;i < total;i++) {
		        em = em + ((porcentajes.get(i) * ingres.get(i).getPro_cru()) / 100);
		      }
		  if (em < requerimiento) {
			  mayor = m.buscaMayorEm(ingres);
			  menor = m.buscaMenorEm(ingres);
			  if ((porcentajes.get(mayor) > 10 && porcentajes.get(mayor) < 50)
					  || (porcentajes.get(menor) > 10 && porcentajes.get(menor) < 50)) {
				  porcentajes.set(mayor, porcentajes.get(mayor) + 0.5);
				  porcentajes.set(menor, porcentajes.get(menor) - 0.5);
			  }  
			  
		  } else {
			  if ( em > (requerimiento +2)) {
				  mayor = m.buscaMayorEm(ingres);
				  menor = m.buscaMenorEm(ingres);
				  if ((porcentajes.get(mayor) > 10 && porcentajes.get(mayor) < 50)
						  || (porcentajes.get(menor) > 10 && porcentajes.get(menor) < 50)) {
					  porcentajes.set(mayor, porcentajes.get(mayor) - 0.5);
					  porcentajes.set(menor, porcentajes.get(menor) + 0.5);
				  }
				  
			  } else {
				  listo = true;
			  }
		  }
		vuelta++;
	  } while (listo || vuelta <= 25);

    return porcentajes;
  }
  
  public ArrayList<Double> balancearTnd(ArrayList<Ingrediente> ingres, Double requerimiento, ArrayList<Double> porcentajes) {
	  int menor = 0;
	  int mayor = 0;
	  int i = 0;
	  int vuelta = 0;
	  double tnd = 0;
	  Boolean listo = false;
	  double total = ingres.size();
	  
	  Mezcla m = new Mezcla();
	  do {
		  for (i = 0;i < total;i++) {
		        tnd = tnd + ((porcentajes.get(i) * ingres.get(i).getPro_cru()) / 100);
		      }
		  if (tnd < requerimiento) {
			  mayor = m.buscaMayorTnd(ingres);
			  menor = m.buscaMenorTnd(ingres);
			  if ((porcentajes.get(mayor) > 10 && porcentajes.get(mayor) < 50)
					  || (porcentajes.get(menor) > 10 && porcentajes.get(menor) < 50)) {
				  porcentajes.set(mayor, porcentajes.get(mayor) + 0.5);
				  porcentajes.set(menor, porcentajes.get(menor) - 0.5);
			  }
			  
			  
		  } else {
			  if ( tnd > (requerimiento +2)) {
				  mayor = m.buscaMayorTnd(ingres);
				  menor = m.buscaMenorTnd(ingres);
				  if ((porcentajes.get(mayor) > 10 && porcentajes.get(mayor) < 50)
						  || (porcentajes.get(menor) > 10 && porcentajes.get(menor) < 50)) {
					  porcentajes.set(mayor, porcentajes.get(mayor) - 0.5);
					  porcentajes.set(menor, porcentajes.get(menor) + 0.5);
				  }
				  
			  } else {
				  listo = true;
			  }
		  }
		vuelta++;
	  } while (listo || vuelta <= 25);

    return porcentajes;
  }
  
  public ArrayList<Cantidad> balancear(ArrayList<Ingrediente> ingres, Animal animal, ArrayList<Double> porcentajes) {
	    Mezcla m = new Mezcla();
	    ArrayList<Cantidad> cantidades = new ArrayList<Cantidad> ();
	    Cantidad cantidad = null;
	    int i = 0;
	    int total = ingres.size();
	    double pc = 0;
	    double em = 0;
	    double tnd = 0;
	    contador++;
	    if (contador <= 200) {
	      porcentajes = m.balancearPc(ingres, animal.getPro_cru(), porcentajes);
	      for (i = 0;i < total;i++) {
	        pc = pc + ((porcentajes.get(i) * ingres.get(i).getPro_cru()) / 100);
	      }
	      if (pc < animal.getPro_cru() || pc > (animal.getPro_cru() + 2)) {
	        	m.balancear(ingres, animal, porcentajes);
	        } else {
	        	 porcentajes = m.balancearEm(ingres, animal.getEm(), porcentajes);
	             for (i = 0;i < total;i++) {
	            	 pc = pc + ((porcentajes.get(i) * ingres.get(i).getPro_cru()) / 100);
	                 em = em + ((porcentajes.get(i) * ingres.get(i).getPro_cru()) / 100);
	               }
	             if ((pc < animal.getPro_cru() || pc > (animal.getPro_cru() + 2)) 
	            		 || em < animal.getEm() || em > (animal.getEm() + 2)) {
	            	 m.balancear(ingres, animal, porcentajes);       	 
	             } else {
	            	 porcentajes = m.balancearTnd(ingres, animal.getEm(), porcentajes);
	                 for (i = 0;i < total;i++) {
	                	 pc = pc + ((porcentajes.get(i) * ingres.get(i).getPro_cru()) / 100);
	                     em = em + ((porcentajes.get(i) * ingres.get(i).getEm()) / 100);
	                     tnd = tnd + ((porcentajes.get(i) * ingres.get(i).getTnd()) / 100);
	                 }
	                 if ((pc < animal.getPro_cru() || pc > (animal.getPro_cru() + 2)) 
	                		 || em < animal.getEm() || em > (animal.getEm() + 2)
	                		 || tnd < animal.getTnd() || tnd > (animal.getTnd() + 2)) {
	                	 m.balancear(ingres, animal, porcentajes);
	                 }
	             }
	        }
	    	
	    }
	    for (i = 0; i < ingres.size(); i++) {
	    	cantidad = new Cantidad ();
	    	cantidad.setNum_ing(ingres.get(i).getNum_ing());
	    	cantidad.setPorcent(porcentajes.get(i));
	    	cantidades.add(cantidad); 
	    }
	    
	    return cantidades;
		  
	  }
  
  public Mezcla preparaMezcla(Animal animal, ArrayList<Cantidad> cantidades) {
	  Mezcla mezcla = new Mezcla();
	  Date date= new Date();
	  
	  long time = date.getTime();
	  Timestamp ts = new Timestamp(time);
	  
	  mezcla.animal_descrip = animal.getEtapa_descrip();
	  mezcla.animal_especie = animal.getEspecie();
	  mezcla.animal_kg = animal.getPeso_kg();
	  mezcla.cantidades = cantidades;
	  mezcla.fecha = ts;
	  mezcla.nota = "creada en la aplicación NutriFarm el día" + ts ;
	  
	  return mezcla;
	  
  }


}
