package vista;

import baseDatos.ClasificacionDAOIMP;
import baseDatos.IngredienteDAOIMP;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import modelo.Clasificacion;
import modelo.Ingrediente;
import modelo.Mezcla;

public class SeleccionaIngredientes extends JPanel {

  private static final long serialVersionUID = 1L;
  private JPanel panelTabla;
  private JPanel contentPane;
  private List<Ingrediente> ingredientes;
  private LinkedList<Ingrediente> ingSeleccionados;
  private JComboBox<String> comboBoxCla;
  private JComboBox<String> comboBoxIngrediente;
  private List<Clasificacion> clasificaciones;
  
  
  /**
   * Constructor.
   * @param tarjetero contenedor concentrado
   */
  public SeleccionaIngredientes(CardLayout tarjetero, JPanel contenedor, Mezcla concentrado) {
    
    setBackground(new Color(255, 192, 203));
    setBounds(100, 100, 330, 500);
    this.contentPane = contenedor;
    ClasificacionDAOIMP cla = new ClasificacionDAOIMP();
    IngredienteDAOIMP ing = new IngredienteDAOIMP();
    clasificaciones = cla.obtnenerClasificaciones();
    ingredientes = ing.obtenerIngredientes();
    this.ingSeleccionados = new LinkedList<Ingrediente>();
    SpringLayout springLayout = new SpringLayout();
    setLayout(springLayout);
    
    JLabel label = new JLabel("NUTRI");
    springLayout.putConstraint(SpringLayout.WEST, label, 75, SpringLayout.WEST, this);
    springLayout.putConstraint(SpringLayout.SOUTH, label, -440, SpringLayout.SOUTH, this);
    springLayout.putConstraint(SpringLayout.EAST, label, -165, SpringLayout.EAST, this);
    label.setForeground(Color.RED);
    label.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
    label.setBackground(Color.RED);
    add(label);
    
    JLabel label1 = new JLabel("Farm");
    springLayout.putConstraint(SpringLayout.NORTH, label1, 24, SpringLayout.NORTH, this);
    springLayout.putConstraint(SpringLayout.WEST, label1, 6, SpringLayout.EAST, label);
    springLayout.putConstraint(SpringLayout.EAST, label1, -80, SpringLayout.EAST, this);
    label1.setForeground(Color.WHITE);
    label1.setFont(new Font("Lucida Grande", Font.BOLD, 30));
    add(label1);

    JLabel lblSeleccionaLos = new JLabel("Elige los Ingredientes");
    springLayout.putConstraint(SpringLayout.SOUTH,label1, -6,SpringLayout.NORTH, lblSeleccionaLos);
    springLayout.putConstraint(SpringLayout.NORTH, lblSeleccionaLos, 6, SpringLayout.SOUTH, label);
    springLayout.putConstraint(SpringLayout.WEST, lblSeleccionaLos, 59, SpringLayout.WEST, this);
    lblSeleccionaLos.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
    add(lblSeleccionaLos);

    JLabel lblClasificacion = new JLabel("Clasificacion:");
    lblClasificacion.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
    add(lblClasificacion);
    
    JLabel lblIngrediente = new JLabel("Ingrediente:");
    springLayout.putConstraint(SpringLayout.WEST,lblClasificacion,0,SpringLayout.WEST,lblIngrediente);
    springLayout.putConstraint(SpringLayout.WEST, lblIngrediente, 44, SpringLayout.WEST, this);
    lblIngrediente.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
    add(lblIngrediente);

    comboBoxCla = new JComboBox<String>();
    springLayout.putConstraint(SpringLayout.NORTH,comboBoxCla,33,SpringLayout.SOUTH,lblSeleccionaLos);
    springLayout.putConstraint(SpringLayout.WEST,comboBoxCla, 162,SpringLayout.WEST, this);
    springLayout.putConstraint(SpringLayout.EAST,comboBoxCla, -49,SpringLayout.EAST, this);
    springLayout.putConstraint(SpringLayout.EAST,lblClasificacion,-23,SpringLayout.WEST,comboBoxCla);
    springLayout.putConstraint(SpringLayout.NORTH,lblClasificacion,2,SpringLayout.NORTH,comboBoxCla);
    add(comboBoxCla);

    comboBoxIngrediente = new JComboBox<String>();
    springLayout.putConstraint(SpringLayout.NORTH, lblIngrediente, 2, SpringLayout.NORTH, comboBoxIngrediente);
    springLayout.putConstraint(SpringLayout.EAST, lblIngrediente, -33, SpringLayout.WEST, comboBoxIngrediente);
    springLayout.putConstraint(SpringLayout.EAST, comboBoxIngrediente, 0, SpringLayout.EAST, comboBoxCla);
    springLayout.putConstraint(SpringLayout.NORTH, comboBoxIngrediente, 10, SpringLayout.SOUTH, comboBoxCla);
    springLayout.putConstraint(SpringLayout.WEST, comboBoxIngrediente, 0, SpringLayout.WEST, comboBoxCla);
    add(comboBoxIngrediente);
    comboBoxIngrediente.addItem("-");
    
    JButton btnAgregar = new JButton("Agregar");
    springLayout.putConstraint(SpringLayout.NORTH, btnAgregar, 5, SpringLayout.SOUTH, comboBoxIngrediente);
    springLayout.putConstraint(SpringLayout.WEST, btnAgregar, 127, SpringLayout.WEST, this);
    springLayout.putConstraint(SpringLayout.SOUTH, btnAgregar, -271, SpringLayout.SOUTH, this);
    springLayout.putConstraint(SpringLayout.EAST, btnAgregar, -124, SpringLayout.EAST, this);
    btnAgregar.setIcon(null);
    btnAgregar.setBackground(new Color(230, 230, 250));
    btnAgregar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (comboBoxIngrediente.getSelectedItem().equals("-")
            || comboBoxCla.getSelectedItem().equals("-")) {
          JOptionPane.showMessageDialog(null,"Error! *Elija un Ingrediente -");
        } else {
          if (ingSeleccionados.size() >= 6) {
            JOptionPane.showMessageDialog(null,"Error! *No se pueden agregar mas ingredientes-");
          } else {
            Ingrediente nuevo = null;
            for (int i = 0;i < ingredientes.size();i++) {
              if (ingredientes.get(i).getClasificacion_tipo().equals(comboBoxCla.getSelectedItem())
                  && ingredientes.get(i).getNom_ing().equals(
                  comboBoxIngrediente.getSelectedItem())) {
                nuevo = ingredientes.get(i);
              }
            }
            if (nuevo != null) {
              int cont = 0;
              for (int i = 0;i < ingSeleccionados.size();i++) {
                if (ingSeleccionados.get(i).equals(nuevo)) {
                  JOptionPane.showMessageDialog(null,"Error! *El ingrediente ya esta en la lista-");
                  cont++;
                }
              }
              if (cont == 0) {
                ingSeleccionados.add(nuevo);
              }
            }
          }
        }
        muestraTabla();
      }
    });
    add(btnAgregar);

    JButton btnFormular = new JButton("Siguiente");
    springLayout.putConstraint(SpringLayout.WEST, btnFormular, 202, SpringLayout.WEST, this);
    springLayout.putConstraint(SpringLayout.SOUTH, btnFormular, -21, SpringLayout.SOUTH, this);
    springLayout.putConstraint(SpringLayout.EAST, btnFormular, 0, SpringLayout.EAST, comboBoxCla);
    btnFormular.setIcon(null);
    btnFormular.setBackground(new Color(230, 230, 250));
    btnFormular.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (ingSeleccionados.size() < 2) {
          JOptionPane.showMessageDialog(null,"Error! *Ingredientes insuficientes-");
        } else {
          concentrado.setIngredientes(ingSeleccionados);
          concentrado.balancear();
          JOptionPane.showMessageDialog(null,"Datos agregados correctamente!!");
          MezclaObtenida mezclaObtenida = new MezclaObtenida(concentrado,tarjetero,contentPane);
          contentPane.add(mezclaObtenida,"mezclaObtenida5");
          tarjetero.show(contentPane, "mezclaObtenida5");
          comboBoxCla.removeAll();
          comboBoxIngrediente.removeAll();
          ingSeleccionados.removeAll(ingSeleccionados);
        }
      }
    });
    JLabel lblIngredietnes = new JLabel("* Ingredietnes *");
    springLayout.putConstraint(SpringLayout.SOUTH,lblIngredietnes,-160,SpringLayout.NORTH,btnFormular);
    add(btnFormular);

    panelTabla = new JPanel();
    springLayout.putConstraint(SpringLayout.NORTH, panelTabla, 63, SpringLayout.SOUTH, comboBoxIngrediente);
    springLayout.putConstraint(SpringLayout.SOUTH, panelTabla, -79, SpringLayout.SOUTH, this);
    springLayout.putConstraint(SpringLayout.NORTH, btnFormular, 22, SpringLayout.SOUTH, panelTabla);
    springLayout.putConstraint(SpringLayout.WEST, panelTabla, 22, SpringLayout.WEST, this);
    springLayout.putConstraint(SpringLayout.EAST, panelTabla, -23, SpringLayout.EAST, this);
    add(panelTabla);
    
    JButton btnNewButton = new JButton("Regresar");
    springLayout.putConstraint(SpringLayout.WEST, btnNewButton, 50, SpringLayout.WEST, this);
    springLayout.putConstraint(SpringLayout.EAST, btnNewButton, 0, SpringLayout.EAST, lblIngrediente);
    btnNewButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        EligeAnimal eligeAnimal = new EligeAnimal(tarjetero,contentPane);
        contentPane.add(eligeAnimal,"eligeAnimal3");
        tarjetero.show(contentPane,"eligeAnimal3");
      }
    });
    springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 22, SpringLayout.SOUTH,panelTabla);
    springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton, -21, SpringLayout.SOUTH, this);
    btnNewButton.setIcon(null);
    add(btnNewButton);
    agregaCla();
    muestraTabla();
  }
  
  /**
   * Metodo que muestra la tabla de ingredientes con los resultados del balanceo.
   */
  public void muestraTabla() {
    panelTabla.removeAll();
    panelTabla.setLayout(new GridLayout(0, 1, 0, 0));
    TablaIngredientes table = new TablaIngredientes(ingSeleccionados,null);
    panelTabla.add(table);
    panelTabla.updateUI();
  }
  
  /**
   * Agrega las clasificaciones de los ingredientes
   * a partir de una lista de clasificaciones.
   */
  public void agregaCla() {
    comboBoxCla.addItem("-");
    for (int i = 0;i < clasificaciones.size();i++) {
      comboBoxCla.addItem(clasificaciones.get(i).getTipo());
    }
    ActionListener ecomboesp = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (comboBoxCla.getSelectedItem().equals("-")) {
          JOptionPane.showMessageDialog(null,"Error! *Elija una Clasificacion -");
          comboBoxIngrediente.removeAllItems();
          comboBoxIngrediente.addItem("-");
        } else {
          comboBoxIngrediente.removeAllItems();
          comboBoxIngrediente.addItem("-");
          agregaIngreCombo();
        }
      }
    };
    comboBoxCla.addActionListener(ecomboesp);
  }

  /**
   * Ingresa los ingredientes dependiendo la clasificaion elegida.
   */
  public void agregaIngreCombo() {
    for (int i = 0;i < ingredientes.size();i++) {
      if (ingredientes.get(i).getClasificacion_tipo().equals(
          (String)comboBoxCla.getSelectedItem())) {
        int cont = 0;
        for (int j = 0;j < comboBoxIngrediente.getItemCount();j++) {
          if (ingredientes.get(i).getNom_ing() == (String)comboBoxIngrediente.getItemAt(j)) {
            cont++;
          }
        }
        if (cont == 0) {
          comboBoxIngrediente.addItem(ingredientes.get(i).getNom_ing());  
        }
      }
    }
  }
}
