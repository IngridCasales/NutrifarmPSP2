package vista;

import baseDatos.AnimalDAOIMP;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import modelo.Animal;
import modelo.Mezcla;

public class EligeAnimal extends JPanel {

  private static final long serialVersionUID = 1L;
  private List<Animal> animales;
  private JPanel contentPane;
  private CardLayout tarjetero;
  private Mezcla concentrado;
  private JComboBox<String> comboAnimales;
  private JComboBox<String> comboEtapas;
  private JComboBox<String> comboPeso;
  private JComboBox<String> comboGanancia;
  private SeleccionaIngredientes seleccionaIngredientes;
  
  /**
   * Constructor.
   */
  public EligeAnimal(CardLayout tarjetero, JPanel contenedor) {

    this.contentPane = contenedor;
    this.tarjetero = tarjetero;
    this.concentrado = new Mezcla();
    setBackground(new Color(255, 192, 203));
    setBounds(100, 100, 330, 500);
    SpringLayout springLayout = new SpringLayout();
    setLayout(springLayout);
    
    JLabel lblNutri = new JLabel("NUTRI");
    lblNutri.setForeground(Color.RED);
    lblNutri.setBackground(Color.RED);
    lblNutri.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
    add(lblNutri);

    JLabel lblFarm = new JLabel("Farm");
    springLayout.putConstraint(SpringLayout.NORTH, lblFarm, 24, SpringLayout.NORTH, this);
    springLayout.putConstraint(SpringLayout.WEST, lblFarm, 171, SpringLayout.WEST, this);
    springLayout.putConstraint(SpringLayout.NORTH, lblNutri, 0, SpringLayout.NORTH, lblFarm);
    springLayout.putConstraint(SpringLayout.EAST, lblNutri, -6, SpringLayout.WEST, lblFarm);
    lblFarm.setForeground(Color.WHITE);
    lblFarm.setFont(new Font("Lucida Grande", Font.BOLD, 30));
    add(lblFarm);

    JLabel lblSeleccionaUnAnimal = new JLabel("Selecciona un animal");
    springLayout.putConstraint(SpringLayout.NORTH,lblSeleccionaUnAnimal,6,SpringLayout.SOUTH,
        lblNutri);
    springLayout.putConstraint(SpringLayout.WEST,lblSeleccionaUnAnimal,64,SpringLayout.WEST,this);
    springLayout.putConstraint(SpringLayout.EAST,lblSeleccionaUnAnimal,-65,SpringLayout.EAST,this);
    lblSeleccionaUnAnimal.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
    add(lblSeleccionaUnAnimal);

    JLabel lblEspecie = new JLabel("Especie:");
    lblEspecie.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
    add(lblEspecie);

    comboAnimales = new JComboBox<String>();
    springLayout.putConstraint(SpringLayout.NORTH,comboAnimales,53,SpringLayout.SOUTH,
        lblSeleccionaUnAnimal);
    springLayout.putConstraint(SpringLayout.WEST, comboAnimales, 149, SpringLayout.WEST,this);
    springLayout.putConstraint(SpringLayout.EAST, comboAnimales, -45, SpringLayout.EAST,this);
    springLayout.putConstraint(SpringLayout.NORTH,lblEspecie,2,SpringLayout.NORTH,comboAnimales);
    springLayout.putConstraint(SpringLayout.EAST,lblEspecie,-41,SpringLayout.WEST,comboAnimales);
    add(comboAnimales);

    JLabel lblEtapa = new JLabel("Etapa:");
    springLayout.putConstraint(SpringLayout.WEST, lblEtapa, 0, SpringLayout.WEST, lblEspecie);
    lblEtapa.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
    add(lblEtapa);

    comboEtapas = new JComboBox<String>();
    springLayout.putConstraint(SpringLayout.NORTH, lblEtapa, 2, SpringLayout.NORTH, comboEtapas);
    springLayout.putConstraint(SpringLayout.NORTH,comboEtapas,35,SpringLayout.SOUTH,
        comboAnimales);
    springLayout.putConstraint(SpringLayout.WEST,comboEtapas,0,SpringLayout.WEST,
        comboAnimales);
    springLayout.putConstraint(SpringLayout.EAST,comboEtapas,0,SpringLayout.EAST,
        comboAnimales);
    add(comboEtapas);
    comboEtapas.addItem("-");

    JLabel lblPeso = new JLabel("Peso:");
    springLayout.putConstraint(SpringLayout.NORTH, lblPeso, 40, SpringLayout.SOUTH, lblEtapa);
    springLayout.putConstraint(SpringLayout.WEST, lblPeso, 0, SpringLayout.WEST, lblEspecie);
    lblPeso.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
    add(lblPeso);

    comboPeso = new JComboBox<String>();
    springLayout.putConstraint(SpringLayout.NORTH,comboPeso,-2,SpringLayout.NORTH,
        lblPeso);
    springLayout.putConstraint(SpringLayout.WEST,comboPeso,0,SpringLayout.WEST, comboAnimales);
    springLayout.putConstraint(SpringLayout.EAST,comboPeso,0,SpringLayout.EAST,
        comboAnimales);
    add(comboPeso);
    comboPeso.addItem("-");
 
    JLabel lblGanancia = new JLabel("Ganancia:");
    springLayout.putConstraint(SpringLayout.NORTH, lblGanancia, 41, SpringLayout.SOUTH, lblPeso);
    lblGanancia.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
    springLayout.putConstraint(SpringLayout.WEST, lblGanancia, 0, SpringLayout.WEST, lblEspecie);
    add(lblGanancia);
    comboGanancia = new JComboBox<String>();
    springLayout.putConstraint(SpringLayout.NORTH,comboGanancia,-2,SpringLayout.NORTH,
        lblGanancia);
    springLayout.putConstraint(SpringLayout.WEST, comboGanancia, 0, SpringLayout.WEST,
        comboAnimales);
    springLayout.putConstraint(SpringLayout.EAST, comboGanancia, -45, SpringLayout.EAST, this);
    add(comboGanancia);
    comboGanancia.addItem("-");
    comboGanancia.setEnabled(false);
   
    JButton btnSiguiente = new JButton("Siguiente");
    springLayout.putConstraint(SpringLayout.NORTH, btnSiguiente, 60, SpringLayout.SOUTH, 
        comboGanancia);
    springLayout.putConstraint(SpringLayout.SOUTH, btnSiguiente, -52, SpringLayout.SOUTH, this);
    btnSiguiente.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        validaDatos();
      }
    });
    springLayout.putConstraint(SpringLayout.WEST, btnSiguiente, 122, SpringLayout.WEST, this);
    springLayout.putConstraint(SpringLayout.EAST, btnSiguiente, -110, SpringLayout.EAST, this);
    btnSiguiente.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
    add(btnSiguiente);
    agregaEspecieComboBox();
  }

  /**
   * valida los datos ingresados y de ser correctos crea un objeto animal 
   * y lo agrega en el objeto concetrado.
  */
  public void validaDatos() {
    if (((String)comboPeso.getSelectedItem()).equals("-") 
        || ((String)comboEtapas.getSelectedItem()).equals("-")) {

      JOptionPane.showMessageDialog(null,"ERROR! *Faltan datos");
    } else {
      Animal nuevoA = new Animal();
      nuevoA.setEspecie((String)comboAnimales.getSelectedItem());
      nuevoA.setEtapa_descrip((String)comboEtapas.getSelectedItem());
      nuevoA.setPeso_kg(Integer.parseInt((String)comboPeso.getSelectedItem()));
      AnimalDAOIMP animalesDis = new AnimalDAOIMP();
      animalesDis.asignarRequerimientos(nuevoA);
      concentrado.setAnimal(nuevoA);
      JOptionPane.showMessageDialog(null,"Datos agregados correctamente!!");
      seleccionaIngredientes = new SeleccionaIngredientes(tarjetero,contentPane,concentrado);
      contentPane.add(seleccionaIngredientes,"seleccionaIngredientes4");
      tarjetero.show(contentPane,"seleccionaIngredientes4");
      
    }
  }
  
  /**
   * Ingresa al comboAnimales las diferentes especies que existen. 
   */
  public void agregaEspecieComboBox() {
    comboAnimales.addItem("-");
    AnimalDAOIMP animalesBD = new AnimalDAOIMP();
    animales = animalesBD.obtenerAnimales();
    for (int i = 0;i < animales.size();i++) {
      int cont = 0;
      for (int j = 0;j < comboAnimales.getItemCount();j++) {
        if (animales.get(i).getEspecie().equals((String)comboAnimales.getItemAt(j))) {
          cont++;
        }
      }
      if (cont == 0) {
        comboAnimales.addItem(animales.get(i).getEspecie());  
      }
    }
    ActionListener ecomboesp = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (comboAnimales.getSelectedItem().equals("-")) {
          JOptionPane.showMessageDialog(null,"Error! *Elija un Animal -");
          comboEtapas.removeAllItems();
          comboEtapas.addItem("-");
          comboPeso.removeAllItems();
          comboPeso.addItem("-");
        } else {
          comboEtapas.removeAllItems();
          comboEtapas.addItem("-");
          comboPeso.removeAllItems();
          comboPeso.addItem("-");
          agregaEtapasCombo();
          agregaPesoCombo();
        }
      }
    };
    comboAnimales.addActionListener(ecomboesp);
  }
  
  /**
   * Ingresa al comboEtapas El nombre de la estapas del animal elegido. 
   */
  private void agregaEtapasCombo() {
    for (int i = 0;i < animales.size();i++) {
      if (animales.get(i).getEspecie().equals((String)comboAnimales.getSelectedItem())) {
        int cont = 0;
        for (int j = 0;j < comboEtapas.getItemCount();j++) {
          if (animales.get(i).getEtapa_descrip().equals((String)comboEtapas.getItemAt(j))) {
            cont++;
          }
        }
        if (cont == 0) {
          comboEtapas.addItem(animales.get(i).getEtapa_descrip());  
        }
      }
    } 
  }
  
  /**
   * Se ingresan al combo los diferentes pesos del animal elegido. 
   */
  private void agregaPesoCombo() {
    for (int i = 0;i < animales.size();i++) {
      if (animales.get(i).getEspecie().equals((String)comboAnimales.getSelectedItem())) {
        int cont = 0;
        for (int j = 0;j < comboPeso.getItemCount();j++) {
          if ((Integer.toString(animales.get(i).getPeso_kg())).equals(
              (String)comboPeso.getItemAt(j))) {
            cont++;
          } 
        }
        if (cont == 0) { 
          comboPeso.addItem("" + animales.get(i).getPeso_kg());  
        } 
      }
    } 
  }
}
