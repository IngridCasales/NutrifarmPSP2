package vista;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SpringLayout;
import modelo.Mezcla;

public class MezclaObtenida extends JPanel {

  private static final long serialVersionUID = 1L;
  private JPanel contentPane;
  private JPanel panelTabla;
  private CardLayout tarjetero;
  private JComboBox<String> comboBox;
  private Mezcla concentrado;
  private JTable table;
  
  /**
   * Constructor.
   * @param concentrado tarjetero contenedor
   */
  public MezclaObtenida(Mezcla concentrado,CardLayout tarjetero, JPanel contenedor) {

    this.setConcentrado(concentrado);
    this.contentPane = contenedor;
    this.tarjetero = tarjetero;

    setBackground(new Color(255, 192, 203));
    setBounds(100, 100, 330, 500);
    SpringLayout springLayout = new SpringLayout();
    setLayout(springLayout);

    JLabel label = new JLabel("NUTRI");
    label.setForeground(Color.RED);
    label.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
    label.setBackground(Color.RED);
    add(label);
 
    JLabel label1 = new JLabel("Farm");
    springLayout.putConstraint(SpringLayout.NORTH, label1, 26, SpringLayout.NORTH, this);
    springLayout.putConstraint(SpringLayout.WEST, label1, 167, SpringLayout.WEST, this);
    springLayout.putConstraint(SpringLayout.NORTH, label, 0, SpringLayout.NORTH, label1);
    springLayout.putConstraint(SpringLayout.EAST, label, -6, SpringLayout.WEST, label1);
    label1.setForeground(Color.WHITE);
    label1.setFont(new Font("Lucida Grande", Font.BOLD, 30));
    add(label1);

    JLabel lblMezclaObtenida = new JLabel("Mezcla obtenida");
    springLayout.putConstraint(SpringLayout.NORTH, lblMezclaObtenida, 6, SpringLayout.SOUTH, label);
    springLayout.putConstraint(SpringLayout.WEST, lblMezclaObtenida, 10, SpringLayout.WEST, label);
    lblMezclaObtenida.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
    add(lblMezclaObtenida);

    JButton btnExpotar = new JButton("Expotar");
    btnExpotar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        exporta();
      }
    });
    add(btnExpotar);

    comboBox = new JComboBox<String>();
    springLayout.putConstraint(SpringLayout.WEST, comboBox, 28, SpringLayout.WEST, this);
    springLayout.putConstraint(SpringLayout.SOUTH, comboBox, -17, SpringLayout.NORTH, btnExpotar);
    springLayout.putConstraint(SpringLayout.WEST, btnExpotar, 0, SpringLayout.WEST, comboBox);
    add(comboBox);
    comboBox.addItem("-");
    comboBox.addItem("JPG");
    comboBox.addItem("PDF");
  
    JButton btnMenu = new JButton("Menu");
    springLayout.putConstraint(SpringLayout.SOUTH, btnMenu, -22, SpringLayout.SOUTH, this);
    springLayout.putConstraint(SpringLayout.NORTH, btnExpotar, 0, SpringLayout.NORTH, btnMenu);
    btnMenu.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        tarjetero.show(contentPane,"menu2");
      }
    });
    add(btnMenu);

    panelTabla = new JPanel();
    springLayout.putConstraint(SpringLayout.SOUTH, panelTabla, -34, SpringLayout.NORTH, comboBox);
    springLayout.putConstraint(SpringLayout.EAST, btnMenu, 0, SpringLayout.EAST, panelTabla);
    panelTabla.setBackground(new Color(255, 182, 193));
    springLayout.putConstraint(SpringLayout.WEST, panelTabla, 28, SpringLayout.WEST, this);
    springLayout.putConstraint(SpringLayout.EAST, panelTabla, 296, SpringLayout.WEST, this);
    add(panelTabla);
    panelTabla.setLayout(new CardLayout(0, 0));

    JPanel panel = new JPanel();
    springLayout.putConstraint(SpringLayout.SOUTH, panel, -265, SpringLayout.SOUTH, this);
    springLayout.putConstraint(SpringLayout.NORTH, panelTabla, 13, SpringLayout.SOUTH, panel);
    panel.setBackground(new Color(255, 182, 193));
    springLayout.putConstraint(SpringLayout.NORTH, panel, 31, SpringLayout.SOUTH,lblMezclaObtenida);
    springLayout.putConstraint(SpringLayout.WEST, panel, 53, SpringLayout.WEST, this);
    springLayout.putConstraint(SpringLayout.EAST, panel, 270, SpringLayout.WEST, this);
    add(panel);
    panel.setLayout(new GridLayout(0, 2, 0, 0));

    JLabel lblNombre = new JLabel("Especie:");
    panel.add(lblNombre);

    JLabel esp = new JLabel(concentrado.getAnimal().getEspecie());
    panel.add(esp);
  
    JLabel lblNewLabel2 = new JLabel("Etapa:");
    lblNewLabel2.setToolTipText("");
    panel.add(lblNewLabel2);
  
    JLabel etapa = new JLabel(concentrado.getAnimal().getEtapa_descrip());
    panel.add(etapa);
   
    JLabel lblNewLabel4 = new JLabel("Peso:");
    panel.add(lblNewLabel4);

    JLabel peso = new JLabel("" + concentrado.getAnimal().getPeso_kg());
    panel.add(peso);

    JLabel lblNewLabel3 = new JLabel("Ganancia:");
    panel.add(lblNewLabel3);

    JLabel gana = new JLabel("" + 10);
    panel.add(gana);
    muestraTabla();
  }

  /**
   * Metodo que crea una tabla deacuerdo a la lista de ingredientes 
   * que se encuentra en el objeto concetrado.
   */
  public void muestraTabla() {
    panelTabla.removeAll();
    int numeroIng = concentrado.getIngredientes().size();
    if (numeroIng == 0) {
      Object[] titulo = {"*INGREDIENTES*","*PC*","*TND*","*CAN*"};
      Object[][] info = {{"ING","%PC","%TND","%CAN"}};
      table = new JTable(info,titulo);
      table.setForeground(new Color(1, 1, 1));
      table.setBackground(new Color(255, 182, 193));
      panelTabla.add(table);
      panelTabla.updateUI();
    }
    if (numeroIng == 1) {
      Object[] titulo = {"*INGREDIENTES*","*PC*","*TND*","*CAN*"};
      Object[][] info = {{"ING","%PC","%TND","%CAN"},
        {concentrado.getIngredientes().get(0).getNom_ing(),
        concentrado.getIngredientes().get(0).getPro_cru(),
        concentrado.getIngredientes().get(0).getTnd(),
        concentrado.getCantidadesIng().get(0).getPorcent()}};
      table = new JTable(info,titulo);
      table.setForeground(new Color(1, 1, 1));
      table.setBackground(new Color(255, 182, 193));
      panelTabla.add(table);
      panelTabla.updateUI();
    }
    if (numeroIng == 2) {
      Object[] titulo = {"*INGREDIENTES*","*PC*","*TND*","*CAN*"};
      Object[][] info = {{"ING","%PC","%TND","%CAN"},
          {concentrado.getIngredientes().get(0).getNom_ing(),
          concentrado.getIngredientes().get(0).getPro_cru(),
          concentrado.getIngredientes().get(0).getTnd(),
          concentrado.getCantidadesIng().get(0).getPorcent()},
          {concentrado.getIngredientes().get(1).getNom_ing(),
          concentrado.getIngredientes().get(1).getPro_cru(),
          concentrado.getIngredientes().get(1).getTnd(),
          concentrado.getCantidadesIng().get(1).getPorcent()}};
      table = new JTable(info,titulo);
      table.setForeground(new Color(1, 1, 1));
      table.setBackground(new Color(255, 182, 193));
      panelTabla.add(table);
      panelTabla.updateUI();
    }
    if (numeroIng == 3) {
      Object[] titulo = {"*INGREDIENTES*","*PC*","*TND*","*CAN*"};
      Object[][] info = {{"ING","%PC","%TND","%CAN"},
          {concentrado.getIngredientes().get(0).getNom_ing(),
          concentrado.getIngredientes().get(0).getPro_cru(),
          concentrado.getIngredientes().get(0).getTnd(),
          concentrado.getCantidadesIng().get(0).getPorcent()},
          {concentrado.getIngredientes().get(1).getNom_ing(),
          concentrado.getIngredientes().get(1).getPro_cru(),
          concentrado.getIngredientes().get(1).getTnd(),
          concentrado.getCantidadesIng().get(1).getPorcent()},
          {concentrado.getIngredientes().get(2).getNom_ing(),
          concentrado.getIngredientes().get(2).getPro_cru(),
          concentrado.getIngredientes().get(2).getTnd(),
          concentrado.getCantidadesIng().get(2).getPorcent()}};
      table = new JTable(info,titulo);
      table.setForeground(new Color(1, 1, 1));
      table.setBackground(new Color(255, 182, 193));
      panelTabla.add(table);
      panelTabla.updateUI();
    }
    if (numeroIng == 4) {
      Object[] titulo = {"*INGREDIENTES*","*PC*","*TND*","*CAN*"};
      Object[][] info = {{"ING","%PC","%TND","%CAN"},
          {concentrado.getIngredientes().get(0).getNom_ing(),
          concentrado.getIngredientes().get(0).getPro_cru(),
          concentrado.getIngredientes().get(0).getTnd(),
          concentrado.getCantidadesIng().get(0).getPorcent()},
          {concentrado.getIngredientes().get(1).getNom_ing(),
          concentrado.getIngredientes().get(1).getPro_cru(),
          concentrado.getIngredientes().get(1).getTnd(),
          concentrado.getCantidadesIng().get(1).getPorcent()},
          {concentrado.getIngredientes().get(2).getNom_ing(),
          concentrado.getIngredientes().get(2).getPro_cru(),
          concentrado.getIngredientes().get(2).getTnd(),
          concentrado.getCantidadesIng().get(2).getPorcent()},
          {concentrado.getIngredientes().get(3).getNom_ing(),
          concentrado.getIngredientes().get(3).getPro_cru(),
          concentrado.getIngredientes().get(3).getTnd(),
          concentrado.getCantidadesIng().get(3).getPorcent()}};
      table = new JTable(info,titulo);
      table.setForeground(new Color(1, 1, 1));
      table.setBackground(new Color(255, 182, 193));
      panelTabla.add(table);
      panelTabla.updateUI();
    }
    if (numeroIng == 5) {
      Object[] titulo = {"*INGREDIENTES*","*PC*","*TND*","*CAN*"};
      Object[][] info = {{"ING","%PC","%TND","%CAN"},
          {concentrado.getIngredientes().get(0).getNom_ing(),
          concentrado.getIngredientes().get(0).getPro_cru(),
          concentrado.getIngredientes().get(0).getTnd(),
          concentrado.getCantidadesIng().get(0).getPorcent()},
          {concentrado.getIngredientes().get(1).getNom_ing(),
          concentrado.getIngredientes().get(1).getPro_cru(),
          concentrado.getIngredientes().get(1).getTnd(),
          concentrado.getCantidadesIng().get(1).getPorcent()},
          {concentrado.getIngredientes().get(2).getNom_ing(),
          concentrado.getIngredientes().get(2).getPro_cru(),
          concentrado.getIngredientes().get(2).getTnd(),
          concentrado.getCantidadesIng().get(2).getPorcent()},
          {concentrado.getIngredientes().get(3).getNom_ing(),
          concentrado.getIngredientes().get(3).getPro_cru(),
          concentrado.getIngredientes().get(3).getTnd(),
          concentrado.getCantidadesIng().get(3).getPorcent()},
          {concentrado.getIngredientes().get(4).getNom_ing(),
          concentrado.getIngredientes().get(4).getPro_cru(),
          concentrado.getIngredientes().get(4).getTnd(),
          concentrado.getCantidadesIng().get(4).getPorcent()}};
      table = new JTable(info,titulo);
      table.setForeground(new Color(1, 1, 1));
      table.setBackground(new Color(255, 182, 193));
      panelTabla.add(table);
      panelTabla.updateUI();
    }
    if (numeroIng == 6) {
      Object[] titulo = {"*INGREDIENTES*","*PC*","*TND*","*CAN*"};
      Object[][] info = {{"ING","%PC","%TND","%CAN"},
          {concentrado.getIngredientes().get(0).getNom_ing(),
          concentrado.getIngredientes().get(0).getPro_cru(),
          concentrado.getIngredientes().get(0).getTnd(),
          concentrado.getCantidadesIng().get(0).getPorcent()},
          {concentrado.getIngredientes().get(1).getNom_ing(),
          concentrado.getIngredientes().get(1).getPro_cru(),
          concentrado.getIngredientes().get(1).getTnd(),
          concentrado.getCantidadesIng().get(1).getPorcent()},
          {concentrado.getIngredientes().get(2).getNom_ing(),
          concentrado.getIngredientes().get(2).getPro_cru(),
          concentrado.getIngredientes().get(2).getTnd(),
          concentrado.getCantidadesIng().get(0).getPorcent()},
          {concentrado.getIngredientes().get(3).getNom_ing(),
          concentrado.getIngredientes().get(3).getPro_cru(),
          concentrado.getIngredientes().get(3).getTnd(),
          concentrado.getCantidadesIng().get(3).getPorcent()},
          {concentrado.getIngredientes().get(4).getNom_ing(),
          concentrado.getIngredientes().get(4).getPro_cru(),
          concentrado.getIngredientes().get(4).getTnd(),
          concentrado.getCantidadesIng().get(4).getPorcent()},
          {concentrado.getIngredientes().get(5).getNom_ing(),
          concentrado.getIngredientes().get(5).getPro_cru(),
          concentrado.getIngredientes().get(5).getTnd(),
          concentrado.getCantidadesIng().get(5).getPorcent()}};
      table = new JTable(info,titulo);
      table.setForeground(new Color(1, 1, 1));
      table.setBackground(new Color(255, 182, 193));
      panelTabla.add(table);
      panelTabla.updateUI();
    }
  }
  
  /**
   * En este metodo realiza todas la acciones para guardar una un mezcla
   * en el dispositivo con formato pdf o jpg 
   * aun no implementado al %100. 
   */
  public void exporta() {
    if (((String)comboBox.getSelectedItem()).equals("-")) {
      JOptionPane.showMessageDialog(null,"Seleccione un formato de exportacion");
    } else {
      JOptionPane.showMessageDialog(null,"Tabla de mezcla guardada en dispositivo");
      tarjetero.show(contentPane,"menu2");
    }
  }
  
  public Mezcla getConcentrado() {
    return concentrado;
  }
  
  public void setConcentrado(Mezcla concentrado) {
    this.concentrado = concentrado;
  }
}
