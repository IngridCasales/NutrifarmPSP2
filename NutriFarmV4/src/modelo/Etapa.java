
package modelo;

public class Etapa {
  
  private String descrip;
  private int ganancia;
  
  public Etapa(String descrip,int ganancia) {
    this.descrip = descrip;
    this.ganancia = ganancia;
  }
  
  public Etapa() {
    
  }

  public String getDescrip() {
    return descrip;
  }

  public int getGanancia() {
    return ganancia;
  }

  public void setDescrip(String descrip) {
    this.descrip = descrip;
  }

  public void setGanancia(int ganancia) {
    this.ganancia = ganancia;
  }
  
}
