package vista;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import modelo.Mezcla;

public class Menu extends JPanel {

  private static final long serialVersionUID = 1L;
  private JPanel contentPane;
  private CardLayout tarjetero;
  private Mezcla concentrado;
  
  /**
   *@ Contructor: se recive como parametro el panel contendor y tarjetero
   *para poder visulizar la siguiente pantalla al oprimir el boton formular mezcla.
   */
  public Menu(CardLayout tarjetero, JPanel contenedor) {
    
    this.contentPane = contenedor;
    this.tarjetero = tarjetero;
    setBackground(new Color(255, 192, 203));
    setBounds(100, 100, 330, 500);
    SpringLayout springLayout = new SpringLayout();
    setLayout(springLayout);

    JLabel label = new JLabel("NUTRI");
    springLayout.putConstraint(SpringLayout.WEST, label, 50, SpringLayout.WEST, this);
    label.setForeground(Color.RED);
    label.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
    add(label);

    JLabel label1 = new JLabel("Farm");
    label1.setForeground(Color.WHITE);
    springLayout.putConstraint(SpringLayout.NORTH, label1, 36, SpringLayout.NORTH, this);
    springLayout.putConstraint(SpringLayout.WEST, label1, 176, SpringLayout.WEST, this);
    springLayout.putConstraint(SpringLayout.NORTH, label, 0, SpringLayout.NORTH, label1);
    springLayout.putConstraint(SpringLayout.EAST, label, -6, SpringLayout.WEST, label1);
    label1.setFont(new Font("Lucida Grande", Font.BOLD, 40));
    add(label1);

    JButton btnFormularMezcla = new JButton("Formular Mezcla");
    btnFormularMezcla.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        tarjetero.show(contentPane,"eligeAnimal3");
      }
    });
    
    springLayout.putConstraint(SpringLayout.NORTH, btnFormularMezcla,154, SpringLayout.NORTH,this);
    springLayout.putConstraint(SpringLayout.WEST, btnFormularMezcla, 20, SpringLayout.WEST, this);
    springLayout.putConstraint(SpringLayout.SOUTH, btnFormularMezcla, -265, SpringLayout.SOUTH,
        this);
    springLayout.putConstraint(SpringLayout.EAST, btnFormularMezcla, 152, SpringLayout.WEST, this);
    add(btnFormularMezcla);

    JButton btnMezclasPredefinidas = new JButton("Mezclas Predef.");
    springLayout.putConstraint(SpringLayout.NORTH,btnMezclasPredefinidas,70,SpringLayout.SOUTH,
        label1);
    springLayout.putConstraint(SpringLayout.WEST,btnMezclasPredefinidas,176,SpringLayout.WEST,this);
    springLayout.putConstraint(SpringLayout.SOUTH,btnMezclasPredefinidas,-265,SpringLayout.SOUTH,
        this);
    springLayout.putConstraint(SpringLayout.EAST,btnMezclasPredefinidas,-22,SpringLayout.EAST,this);
    add(btnMezclasPredefinidas);
  
    JButton btnNewButton = new JButton("Historial\nMezclas");
    springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 258, SpringLayout.NORTH, this);
    springLayout.putConstraint(SpringLayout.WEST, btnNewButton, 20, SpringLayout.WEST, this);
    springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton, -161, SpringLayout.SOUTH, this);
    springLayout.putConstraint(SpringLayout.EAST,btnNewButton,0,SpringLayout.EAST,
        btnFormularMezcla);
    add(btnNewButton);

    JButton btnAgregarIngre = new JButton("Agregar Ingre");
    springLayout.putConstraint(SpringLayout.NORTH, btnAgregarIngre, 258, SpringLayout.NORTH, this);
    springLayout.putConstraint(SpringLayout.WEST,btnAgregarIngre,24,SpringLayout.EAST,btnNewButton);
    springLayout.putConstraint(SpringLayout.SOUTH,btnAgregarIngre,0,SpringLayout.SOUTH,
        btnNewButton);
    add(btnAgregarIngre);

    JButton btnReferencias = new JButton("Referencias");
    springLayout.putConstraint(SpringLayout.WEST, btnReferencias, 0, SpringLayout.WEST,
        btnFormularMezcla);
    add(btnReferencias);

    JButton btnAcercaDe = new JButton("Acerca de...");
    springLayout.putConstraint(SpringLayout.SOUTH,btnAcercaDe, -10, SpringLayout.SOUTH, this);
    springLayout.putConstraint(SpringLayout.NORTH,btnReferencias,0,SpringLayout.NORTH,btnAcercaDe);
    springLayout.putConstraint(SpringLayout.EAST,btnAcercaDe,0,SpringLayout.EAST,
        btnMezclasPredefinidas);
    add(btnAcercaDe);
  }

  public JPanel getContentPane() {
    return contentPane;
  }

  public void setContentPane(JPanel contentPane) {
    this.contentPane = contentPane;
  }

  public CardLayout getTarjetero() {
    return tarjetero;
  }

  public void setTarjetero(CardLayout tarjetero) {
    this.tarjetero = tarjetero;
  }

  public Mezcla getConcentrado() {
    return concentrado;
  }

  public void setConcentrado(Mezcla concentrado) {
    this.concentrado = concentrado;
  }

}
