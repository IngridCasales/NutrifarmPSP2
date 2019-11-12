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

public class Inicio extends JPanel {

  private static final long serialVersionUID = 1L;
  private JPanel contentPane;
  private CardLayout tarjetero;

  /**
   *@ Contructor: se recive como parametro el panel contendor y tarjetero
   *para poder visulizar la siguiente pantalla al oprimir el boton acceder.
   */
  public Inicio(CardLayout tarjetero, JPanel contenedor) {

    this.contentPane = contenedor;
    this.tarjetero = tarjetero;
    setBackground(new Color(255, 192, 203));
    setBounds(100, 100, 330, 500);
    SpringLayout springLayout = new SpringLayout();
    setLayout(springLayout);

    JLabel lblNutri = new JLabel("NUTRI");
    springLayout.putConstraint(SpringLayout.WEST, lblNutri, 53, SpringLayout.WEST, this);
    lblNutri.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
    lblNutri.setForeground(Color.RED);
    add(lblNutri);

    JLabel lblFarm = new JLabel("Farm");
    lblFarm.setForeground(Color.WHITE);
    springLayout.putConstraint(SpringLayout.NORTH, lblNutri, 0, SpringLayout.NORTH, lblFarm);
    springLayout.putConstraint(SpringLayout.EAST, lblNutri, 0, SpringLayout.WEST, lblFarm);
    springLayout.putConstraint(SpringLayout.NORTH, lblFarm, 90, SpringLayout.NORTH, this);
    springLayout.putConstraint(SpringLayout.WEST, lblFarm, 173, SpringLayout.WEST, this);
    springLayout.putConstraint(SpringLayout.EAST, lblFarm, -53, SpringLayout.EAST, this);
    lblFarm.setFont(new Font("Lucida Grande", Font.BOLD, 40));
    add(lblFarm);

    JLabel lblVersion = new JLabel("Version 1.0-2019");
    lblVersion.setForeground(new Color(255, 255, 255));
    lblVersion.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
    springLayout.putConstraint(SpringLayout.SOUTH, lblVersion, -10, SpringLayout.SOUTH, this);
    springLayout.putConstraint(SpringLayout.EAST, lblVersion, -10, SpringLayout.EAST, this);
    add(lblVersion);

    JButton btnAcceder = new JButton("Acceder");
    
    springLayout.putConstraint(SpringLayout.NORTH, btnAcceder, -179, SpringLayout.SOUTH, this);
    springLayout.putConstraint(SpringLayout.WEST, btnAcceder, 80, SpringLayout.WEST, this);
    springLayout.putConstraint(SpringLayout.SOUTH, btnAcceder, -115, SpringLayout.NORTH, lblVersion);
    springLayout.putConstraint(SpringLayout.EAST, btnAcceder, -78, SpringLayout.EAST, this);
    btnAcceder.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        tarjetero.show(contentPane,"menu2");
      }
    });
    btnAcceder.setFont(new Font("Lucida Grande", Font.BOLD, 15));
    btnAcceder.setBackground(new Color(230, 230, 250));
    btnAcceder.setForeground(new Color(0, 0, 0));
    add(btnAcceder);
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
  
}
