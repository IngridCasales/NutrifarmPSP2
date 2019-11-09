package modelo;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Mezcla {
  private int num_mezcla;
  private Date fecha;
  private String nota;
  private List<Ingrediente> ingredientes;
  private Animal animal;
  private List<Cantidad> cantidadesIng;

  public int getNum_mezcla() {
	return num_mezcla;
}

public void setNum_mezcla(int num_mezcla) {
	this.num_mezcla = num_mezcla;
}

public Date getFecha() {
	return fecha;
}

public void setFecha(Date fecha) {
	this.fecha = fecha;
}

public String getNota() {
	return nota;
}

public void setNota(String nota) {
	this.nota = nota;
}

public void setIngredientes(List<Ingrediente> ingredientes) {
	this.ingredientes = ingredientes;
}

/**
   * Contructor que recibe como parametros una lista de ingredientes y un animal.
   */
  public Mezcla(LinkedList<Ingrediente> ingredientes, Animal animal) {
    super();
    this.ingredientes = ingredientes;
    this.animal = animal;
  }
  
  /**
   * Contructor instancia objetos.
   */
  public Mezcla() {
    this.ingredientes = new LinkedList<Ingrediente>();
    this.animal = new Animal();
    this.cantidadesIng = new LinkedList<Cantidad>();
  }
  
  /**
   * Realizar balanceo de mezcla con lista de ingredientes y parametros del animal. 
   */
  public void balancear() {
    //editar
    Cantidad cant1 = new Cantidad(1,34.5,1,3);
    Cantidad cant2 = new Cantidad(2,12.5,1,4);
    Cantidad cant3 = new Cantidad(3,46,1,5);
    Cantidad cant4 = new Cantidad(4,65.5,1,6);
    Cantidad cant5 = new Cantidad(5,43.5,1,2);
    Cantidad cant6 = new Cantidad(6,11.5,1,1);
    cantidadesIng.add(cant1);
    cantidadesIng.add(cant2);
    cantidadesIng.add(cant3);
    cantidadesIng.add(cant4);
    cantidadesIng.add(cant5);
    cantidadesIng.add(cant6);
  }

  public void agregarIngrediente(Ingrediente ingre) {
    ingredientes.add(ingre);
  }

  public List<Ingrediente> getIngredientes() {
    return ingredientes;
  }

  public void setIngredientes(LinkedList<Ingrediente> ingredientes) {
    this.ingredientes = ingredientes;
  }

  public Animal getAnimal() {
    return animal;
  }

  public void setAnimal(Animal animal) {
    this.animal = animal;
  }

  public List<Cantidad> getCantidadesIng() {
    return cantidadesIng;
  }

  public void setCantidadesIng(LinkedList<Cantidad> cantidadesIng) {
    this.cantidadesIng = cantidadesIng;
  }
}
