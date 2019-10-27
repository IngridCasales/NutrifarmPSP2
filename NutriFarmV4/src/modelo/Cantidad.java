package modelo;

public class Cantidad {
  
  private int num_seq;
  private double porcent;
  private int num_mezcla;
  private int num_ing;
  
  /**
   * Constructor.
   * @param num_seq porcent num_mezcla num_ing
   */
  public Cantidad(int num_seq,double porcent,int num_mezcla,int num_ing) {
    this.num_seq = num_seq;
    this.porcent = porcent;
    this.num_mezcla = num_mezcla;
    this.num_ing = num_ing;
  }
  
  public Cantidad() {
    
  }

  public int getNum_seq() {
    return num_seq;
  }

  public double getPorcent() {
    return porcent;
  }

  public int getNum_mezcla() {
    return num_mezcla;
  }

  public int getNum_ing() {
    return num_ing;
  }

  public void setNum_seq(int num_seq) {
    this.num_seq = num_seq;
  }

  public void setPorcent(double porcent) {
    this.porcent = porcent;
  }

  public void setNum_mezcla(int num_mezcla) {
    this.num_mezcla = num_mezcla;
  }

  public void setNum_ing(int num_ing) {
    this.num_ing = num_ing;
  }
  
}
