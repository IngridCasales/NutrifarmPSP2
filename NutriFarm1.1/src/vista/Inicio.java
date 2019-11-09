package vista;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

public class Inicio extends JPanel {

  private static final long serialVersionUID = 1L;
  private JPanel contentPane;
  private CardLayout tarjetero;
  private ImageIcon logo;

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
    
    JLabel lblVersion = new JLabel("Version 1.0-2019");
    lblVersion.setForeground(new Color(255, 255, 255));
    lblVersion.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
    springLayout.putConstraint(SpringLayout.SOUTH, lblVersion, -10, SpringLayout.SOUTH, this);
    springLayout.putConstraint(SpringLayout.EAST, lblVersion, -10, SpringLayout.EAST, this);
    add(lblVersion);
    
    JLabel lblNutri = new JLabel();
    springLayout.putConstraint(SpringLayout.NORTH, lblNutri, 63, SpringLayout.NORTH, this);
    springLayout.putConstraint(SpringLayout.SOUTH, lblNutri, 139, SpringLayout.NORTH, this);
    lblNutri.setIcon(new ImageIcon(Inicio.class.getResource("/imagenes/nitruFarm.png")));
    springLayout.putConstraint(SpringLayout.WEST, lblNutri, 10, SpringLayout.WEST, this);
    springLayout.putConstraint(SpringLayout.EAST, lblNutri, 0, SpringLayout.EAST, lblVersion);
    Icon icono1 = new ImageIcon(logo.getImage().getScaledInstance(lblNutri.getWidth(),lblNutri.getHeight(),Image.SCALE_DEFAULT));
    this.repaint();
    add(lblNutri);

    JButton btnAcceder = new JButton("Acceder");
    btnAcceder.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        tarjetero.show(contentPane,"menu2");
      }
    });
    
    springLayout.putConstraint(SpringLayout.NORTH, btnAcceder, -180, SpringLayout.SOUTH, this);
    springLayout.putConstraint(SpringLayout.WEST, btnAcceder, 85, SpringLayout.WEST, this);
    springLayout.putConstraint(SpringLayout.SOUTH,btnAcceder,-116,SpringLayout.NORTH,lblVersion);
    springLayout.putConstraint(SpringLayout.EAST, btnAcceder, -73, SpringLayout.EAST, this);
    btnAcceder.setFont(new Font("Lucida Grande", Font.BOLD, 15));
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
