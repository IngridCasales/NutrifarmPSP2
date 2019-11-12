package vista;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import modelo.Ingrediente;




public class IngresaIngrediente extends JPanel {

  private static final long serialVersionUID = 1L;
  private JTextField nombre;
  private JTextField clasificacion;
  private JTextField matSec;
  private JTextField tnd;
  private JTextField proCru;
  private JTextField fibCru;
  private JTextField ca;
  private JTextField p;
  private JTextField mg;
  private JTextField em;

  /**
   * Constructor.
   */
  public IngresaIngrediente(CardLayout tarjetero, JPanel contenedor) {
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
    
    JLabel lblMezclaObtenida = new JLabel("Ingresa nuevo ingrediente");
    springLayout.putConstraint(SpringLayout.NORTH, lblMezclaObtenida, 6, SpringLayout.SOUTH, label);
    springLayout.putConstraint(SpringLayout.EAST, lblMezclaObtenida, -38, SpringLayout.EAST, this);
    lblMezclaObtenida.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
    add(lblMezclaObtenida);
    
    JPanel panel = new JPanel();
    springLayout.putConstraint(SpringLayout.NORTH, panel, 31, SpringLayout.SOUTH,lblMezclaObtenida);
    springLayout.putConstraint(SpringLayout.WEST, panel, 54, SpringLayout.WEST, this);
    springLayout.putConstraint(SpringLayout.SOUTH, panel, 319,SpringLayout.SOUTH,lblMezclaObtenida);
    springLayout.putConstraint(SpringLayout.EAST, panel, 276, SpringLayout.WEST, this);
    panel.setBackground(new Color(255, 240, 245));
    add(panel);
    panel.setLayout(new GridLayout(0, 2, 0, 0));
    
    JLabel lblNombre = new JLabel("Nombre:  ");
    lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
    panel.add(lblNombre);
    
    nombre = new JTextField();
    panel.add(nombre);
    nombre.setColumns(10);
    
    JLabel lblNewLabel = new JLabel("Clasificacion:  ");
    lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    panel.add(lblNewLabel);
    
    clasificacion = new JTextField();
    panel.add(clasificacion);
    clasificacion.setColumns(10);
    
    JLabel lblTnd = new JLabel("Tnd:  ");
    lblTnd.setHorizontalAlignment(SwingConstants.RIGHT);
    panel.add(lblTnd);
    
    tnd = new JTextField();
    panel.add(tnd);
    tnd.setColumns(10);
    
    JLabel lblNewLabel1 = new JLabel("Materia seca:  ");
    lblNewLabel1.setHorizontalAlignment(SwingConstants.RIGHT);
    panel.add(lblNewLabel1);
    
    matSec = new JTextField();
    panel.add(matSec);
    matSec.setColumns(10);
    
    JLabel lblProteinaCruda = new JLabel("Proteina cruda:  ");
    lblProteinaCruda.setHorizontalAlignment(SwingConstants.RIGHT);
    panel.add(lblProteinaCruda);
    
    proCru = new JTextField();
    panel.add(proCru);
    proCru.setColumns(10);
    
    JLabel lblNewLabel2 = new JLabel("Fibra cruda:  ");
    lblNewLabel2.setHorizontalAlignment(SwingConstants.RIGHT);
    panel.add(lblNewLabel2);
    
    fibCru = new JTextField();
    panel.add(fibCru);
    fibCru.setColumns(10);
    
    JLabel lblNewLabel3 = new JLabel("Ca:  ");
    lblNewLabel3.setHorizontalAlignment(SwingConstants.RIGHT);
    panel.add(lblNewLabel3);
    
    ca = new JTextField();
    panel.add(ca);
    ca.setColumns(10);
    
    JLabel lblP = new JLabel("P:  ");
    lblP.setHorizontalAlignment(SwingConstants.RIGHT);
    panel.add(lblP);
    
    p = new JTextField();
    panel.add(p);
    p.setColumns(10);
    
    JLabel lblMg = new JLabel("Mg:  ");
    lblMg.setHorizontalAlignment(SwingConstants.RIGHT);
    panel.add(lblMg);
    
    mg = new JTextField();
    panel.add(mg);
    mg.setColumns(10);
    
    JLabel lblEm = new JLabel("Em:  ");
    lblEm.setHorizontalAlignment(SwingConstants.RIGHT);
    panel.add(lblEm);
    
    em = new JTextField();
    panel.add(em);
    em.setColumns(10);
    
    JButton btnRegresar = new JButton("Regresar");
    springLayout.putConstraint(SpringLayout.NORTH, btnRegresar, -59, SpringLayout.SOUTH, this);
    springLayout.putConstraint(SpringLayout.WEST, btnRegresar, 0, SpringLayout.WEST, lblMezclaObtenida);
    springLayout.putConstraint(SpringLayout.SOUTH, btnRegresar, -23, SpringLayout.SOUTH, this);
    btnRegresar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        tarjetero.show(contenedor,"menu2");
      }
    });
    add(btnRegresar);
    
    JButton btnAgregar = new JButton("Agregar");
    springLayout.putConstraint(SpringLayout.NORTH, btnAgregar, 0, SpringLayout.NORTH, btnRegresar);
    springLayout.putConstraint(SpringLayout.SOUTH, btnAgregar, -23, SpringLayout.SOUTH, this);
    springLayout.putConstraint(SpringLayout.EAST, btnAgregar, 0, SpringLayout.EAST, lblMezclaObtenida);
    btnAgregar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (nombre.getText().equals("") || clasificacion.getText().equals("")
            || ca.getText().equals("") || tnd.getText().equals("") 
            || em.getText().equals("") || fibCru.getText().equals("") 
            || matSec.getText().equals("") || p.getText().equals("") 
            || mg.getText().equals("")) {
          JOptionPane.showMessageDialog(null,"Error! *Ingrese todo los datos del ingrediente-");
        } else {
          try {
            Ingrediente nuevo = new Ingrediente();
            nuevo.setNom_ing(nombre.getText());
            nuevo.setClasificacion_tipo(clasificacion.getText());
            nuevo.setCa(Double.parseDouble(ca.getText()));
            nuevo.setTnd(Double.parseDouble(tnd.getText()));
            nuevo.setPro_cru(Double.parseDouble(proCru.getText()));
            nuevo.setEm(Double.parseDouble(em.getText()));
            nuevo.setFib_cru(Double.parseDouble(fibCru.getText()));
            nuevo.setMat_sec(Double.parseDouble(matSec.getText()));
            nuevo.setP(Double.parseDouble(p.getText()));
            nuevo.setMg(Double.parseDouble(mg.getText()));
            ConfirmaIngrediente confirma = new ConfirmaIngrediente(nuevo);
            confirma.setVisible(true);
          } catch (NumberFormatException e1) {
            JOptionPane.showMessageDialog(null,
                "Error! *Datos no validos fabor de ingresar numeros\nen los capos numericos -");
          }
        }
      }
    });
    add(btnAgregar);
  }
}
