package modelo;

public class Animal {
  
  private String especie;
  private double en;
  private double em;
  private double ed;
  private double tnd;
  private double pro_cru;
  private double cal;
  private double fos;
  private double vit_a;
  private int peso_kg;
  private String etapa_descrip;
  private int ganancia;
  
  /**
   * Constructor.
   *@param especie en em ed tnd pro_cru cal fos vit_a peso_kg etapa_descrip.
   */
  public Animal(String especie,double en,double em,double ed,double tnd,double pro_cru,
      double cal,double fos,double vit_a,int peso_kg,String etapa_descrip) {
    this.especie = especie;
    this.en = en;
    this.em = em;
    this.ed = ed;
    this.tnd = tnd;
    this.pro_cru = pro_cru;
    this.cal = cal;
    this.fos = fos;
    this.vit_a = vit_a;
    this.peso_kg = peso_kg;
    this.etapa_descrip = etapa_descrip;
  }
  
  public Animal() {
    
  }

  public String getEspecie() {
    return especie;
  }

  public double getEn() {
    return en;
  }

  public double getEm() {
    return em;
  }

  public double getEd() {
    return ed;
  }

  public double getTnd() {
    return tnd;
  }

  public double getPro_cru() {
    return pro_cru;
  }

  public double getCal() {
    return cal;
  }

  public double getFos() {
    return fos;
  }

  public double getVit_a() {
    return vit_a;
  }

  public int getPeso_kg() {
    return peso_kg;
  }

  public String getEtapa_descrip() {
    return etapa_descrip;
  }

  public void setEspecie(String especie) {
    this.especie = especie;
  }

  public void setEn(double en) {
    this.en = en;
  }

  public void setEm(double em) {
    this.em = em;
  }

  public void setEd(double ed) {
    this.ed = ed;
  }

  public void setTnd(double tnd) {
    this.tnd = tnd;
  }

  public void setPro_cru(double pro_cru) {
    this.pro_cru = pro_cru;
  }

  public void setCal(double cal) {
    this.cal = cal;
  }

  public void setFos(double fos) {
    this.fos = fos;
  }

  public void setVit_a(double vit_a) {
    this.vit_a = vit_a;
  }

  public void setPeso_kg(int peso_kg) {
    this.peso_kg = peso_kg;
  }

  public void setEtapa_descrip(String etapa_descrip) {
    this.etapa_descrip = etapa_descrip;
  }

  public int getGanancia() {
    return ganancia;
  }

  public void setGanancia(int ganancia) {
    this.ganancia = ganancia;
  }
  
}
