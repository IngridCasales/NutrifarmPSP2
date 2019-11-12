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
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import modelo.Mezcla;

public class MezclaObtenida extends JPanel {

  private static final long serialVersionUID = 1L;
  private JPanel contentPane;
  private JPanel panelTabla;
  private CardLayout tarjetero;
  private JComboBox<String> comboBox;
  private Mezcla concentrado;
  private TablaIngredientes table;
  
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
    springLayout.putConstraint(SpringLayout.WEST, btnExpotar, 28, SpringLayout.WEST, this);
    btnExpotar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        exporta();
      }
    });
    add(btnExpotar);

    comboBox = new JComboBox<String>();
    springLayout.putConstraint(SpringLayout.WEST, comboBox, 0, SpringLayout.WEST, btnExpotar);
    springLayout.putConstraint(SpringLayout.SOUTH, comboBox, -6, SpringLayout.NORTH, btnExpotar);
    add(comboBox);
    comboBox.addItem("-");
    comboBox.addItem("JPG");
    comboBox.addItem("PDF");
  
    JButton btnMenu = new JButton("Menu");
    springLayout.putConstraint(SpringLayout.SOUTH, btnMenu, -22, SpringLayout.SOUTH, this);
    springLayout.putConstraint(SpringLayout.EAST, btnMenu, -34, SpringLayout.EAST, this);
    springLayout.putConstraint(SpringLayout.NORTH, btnExpotar, 0, SpringLayout.NORTH, btnMenu);
    btnMenu.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        tarjetero.show(contentPane,"menu2");
      }
    });
    add(btnMenu);

    panelTabla = new JPanel();
    springLayout.putConstraint(SpringLayout.WEST, panelTabla, -7, SpringLayout.WEST, btnExpotar);
    springLayout.putConstraint(SpringLayout.SOUTH, panelTabla, -20, SpringLayout.NORTH, comboBox);
    springLayout.putConstraint(SpringLayout.EAST, panelTabla, 307, SpringLayout.WEST, this);
    panelTabla.setBackground(new Color(255, 182, 193));
    add(panelTabla);
    panelTabla.setLayout(new CardLayout(0, 0));

    JPanel panel = new JPanel();
    springLayout.putConstraint(SpringLayout.NORTH, panelTabla, 17, SpringLayout.SOUTH, panel);
    springLayout.putConstraint(SpringLayout.WEST, panel, -16, SpringLayout.WEST, label);
    springLayout.putConstraint(SpringLayout.EAST, panel, 196, SpringLayout.WEST, label);
    springLayout.putConstraint(SpringLayout.NORTH, panel, 16, SpringLayout.SOUTH,lblMezclaObtenida);
    springLayout.putConstraint(SpringLayout.SOUTH, panel, -291, SpringLayout.SOUTH, this);
    panel.setBackground(new Color(255, 240, 245));
    add(panel);
    panel.setLayout(new GridLayout(0, 2, 0, 0));

    JLabel lblNombre = new JLabel("Especie:  ");
    lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
    lblNombre.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
    panel.add(lblNombre);

    JLabel esp = new JLabel(concentrado.getAnimal().getEspecie());
    panel.add(esp);
  
    JLabel lblNewLabel2 = new JLabel("Etapa:  ");
    lblNewLabel2.setHorizontalAlignment(SwingConstants.RIGHT);
    lblNewLabel2.setToolTipText("");
    panel.add(lblNewLabel2);
  
    JLabel etapa = new JLabel(concentrado.getAnimal().getEtapa_descrip());
    panel.add(etapa);
   
    JLabel lblNewLabel4 = new JLabel("Peso:  ");
    lblNewLabel4.setHorizontalAlignment(SwingConstants.RIGHT);
    panel.add(lblNewLabel4);

    JLabel peso = new JLabel("" + concentrado.getAnimal().getPeso_kg() + "Kg");
    panel.add(peso);

    JLabel lblNewLabel3 = new JLabel("Ganancia:  ");
    lblNewLabel3.setHorizontalAlignment(SwingConstants.RIGHT);
    panel.add(lblNewLabel3);

    JLabel gana = new JLabel("" + concentrado.getAnimal().getGanancia() + "Kg");
    panel.add(gana);
    muestraTabla();
  }

  /**
   * Metodo que crea una tabla deacuerdo a la lista de ingredientes 
   * que se encuentra en el objeto concetrado.
   */
  public void muestraTabla() {
    panelTabla.removeAll();
    panelTabla.setLayout(new GridLayout(0, 1, 0, 0));
    table = new TablaIngredientes(null,concentrado);
    panelTabla.add(table, "name_20165854941381");
    panelTabla.updateUI();
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
