
package modelo;

public class Ingrediente {
  
  private int num_ing;
  private String nom_ing;
  private double mat_sec;
  private double pro_cru;
  private double fib_cru;
  private double ca;
  private double p;
  private double mg;
  private double em;
  private double tnd;
  private String clasificacion_tipo;
  
  /**
   * Contructor.
   * @param num_ing nom_ing mat_sec pro_cru fib_cru ca p mg em tnd clasificacion_tipo
   */
  public Ingrediente(int num_ing,String nom_ing,double mat_sec,double pro_cru,double fib_cru,
      double ca,double p,double mg, double em,double tnd,String clasificacion_tipo) {
    this.num_ing = num_ing;
    this.nom_ing = nom_ing;
    this.mat_sec = mat_sec;
    this.pro_cru = pro_cru;
    this.fib_cru = fib_cru;
    this.ca = ca;
    this.p = p;
    this.mg = mg;
    this.em = em;
    this.tnd = tnd;
    this.clasificacion_tipo = clasificacion_tipo;
  }
  
  public Ingrediente() {
    
  }

  public int getNum_ing() {
    return num_ing;
  }

  public String getNom_ing() {
    return nom_ing;
  }

  public double getMat_sec() {
    return mat_sec;
  }

  public double getPro_cru() {
    return pro_cru;
  }

  public double getFib_cru() {
    return fib_cru;
  }

  public double getCa() {
    return ca;
  }

  public double getP() {
    return p;
  }

  public double getMg() {
    return mg;
  }

  public double getEm() {
    return em;
  }

  public double getTnd() {
    return tnd;
  }

  public String getClasificacion_tipo() {
    return clasificacion_tipo;
  }

  public void setNum_ing(int num_ing) {
    this.num_ing = num_ing;
  }

  public void setNom_ing(String nom_ing) {
    this.nom_ing = nom_ing;
  }

  public void setMat_sec(double mat_sec) {
    this.mat_sec = mat_sec;
  }

  public void setPro_cru(double pro_cru) {
    this.pro_cru = pro_cru;
  }

  public void setFib_cru(double fib_cru) {
    this.fib_cru = fib_cru;
  }

  public void setCa(double ca) {
    this.ca = ca;
  }

  public void setP(double p) {
    this.p = p;
  }

  public void setMg(double mg) {
    this.mg = mg;
  }

  public void setEm(double em) {
    this.em = em;
  }

  public void setTnd(double tnd) {
    this.tnd = tnd;
  }

  public void setClasificacion_tipo(String clasificacion_tipo) {
    this.clasificacion_tipo = clasificacion_tipo;
  }
  
}
