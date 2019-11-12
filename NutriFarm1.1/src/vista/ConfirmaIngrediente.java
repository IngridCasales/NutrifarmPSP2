package vista;

import baseDatos.IngredienteDAOIMP;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import modelo.Ingrediente;

public class ConfirmaIngrediente extends JFrame {

  private static final long serialVersionUID = 1L;
  private JPanel contentPane;

  /**
   * Create the frame.
   */
  public ConfirmaIngrediente(Ingrediente nuevo) {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 305, 324);
    contentPane = new JPanel();
    contentPane.setBackground(new Color(255, 192, 203));
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    SpringLayout slcontentPane = new SpringLayout();
    contentPane.setLayout(slcontentPane);
    
    JPanel panel = new JPanel();
    panel.setBackground(new Color(255, 240, 245));
    slcontentPane.putConstraint(SpringLayout.NORTH, panel, 34, SpringLayout.NORTH, contentPane);
    slcontentPane.putConstraint(SpringLayout.WEST, panel, 10, SpringLayout.WEST, contentPane);
    slcontentPane.putConstraint(SpringLayout.SOUTH, panel, 249, SpringLayout.NORTH, contentPane);
    slcontentPane.putConstraint(SpringLayout.EAST, panel, 285, SpringLayout.WEST, contentPane);
    panel.setLayout(new GridLayout(0, 2, 0, 0));
    JLabel nombre = new JLabel(nuevo.getNom_ing());
    JLabel clasi = new JLabel(nuevo.getClasificacion_tipo());
    JLabel tnd = new JLabel("" + nuevo.getTnd());
    JLabel matSec = new JLabel("" + nuevo.getMat_sec());
    JLabel proCru = new JLabel("" + nuevo.getPro_cru());
    JLabel fibCru = new JLabel("" + nuevo.getFib_cru());
    JLabel ca = new JLabel("" + nuevo.getCa());
    JLabel pe = new JLabel("" + nuevo.getP());
    JLabel mg = new JLabel("" + nuevo.getMg());
    JLabel em = new JLabel("" + nuevo.getEm());
    JLabel nombre1 = new JLabel("Nombre:  ");
    nombre1.setHorizontalAlignment(SwingConstants.RIGHT);
    JLabel clasi1 = new JLabel("Clasificacion: ");
    clasi1.setHorizontalAlignment(SwingConstants.RIGHT);
    JLabel tnd1 = new JLabel("" + "Tnd:  ");
    tnd1.setHorizontalAlignment(SwingConstants.RIGHT);
    JLabel matSec1 = new JLabel("Matria seca:  ");
    matSec1.setHorizontalAlignment(SwingConstants.RIGHT);
    JLabel proCru1 = new JLabel("Proteina cruda:  ");
    proCru1.setHorizontalAlignment(SwingConstants.RIGHT);
    JLabel fibCru1 = new JLabel("Fibra cruda:  ");
    fibCru1.setHorizontalAlignment(SwingConstants.RIGHT);
    JLabel ca1 = new JLabel("Ca:  ");
    ca1.setHorizontalAlignment(SwingConstants.RIGHT);
    JLabel pe1 = new JLabel("P:  ");
    pe1.setHorizontalAlignment(SwingConstants.RIGHT);
    JLabel mg1 = new JLabel("Mg:  ");
    mg1.setHorizontalAlignment(SwingConstants.RIGHT);
    JLabel em1 = new JLabel("Em:  ");
    em1.setHorizontalAlignment(SwingConstants.RIGHT);
    panel.add(nombre1);
    panel.add(nombre);
    panel.add(clasi1);
    panel.add(clasi);
    panel.add(tnd1);
    panel.add(tnd);
    panel.add(matSec1);
    panel.add(matSec);
    panel.add(proCru1);
    panel.add(proCru);
    panel.add(fibCru1);
    panel.add(fibCru);
    panel.add(ca1);
    panel.add(ca);
    panel.add(pe1);
    panel.add(pe);
    panel.add(mg1);
    panel.add(mg);
    panel.add(em1);
    panel.add(em);
    contentPane.add(panel);
    
    JLabel lblSonCorrectosEstos = new JLabel("Son correctos estos datos?");
    slcontentPane.putConstraint(SpringLayout.WEST,lblSonCorrectosEstos,0,SpringLayout.WEST,panel);
    slcontentPane.putConstraint(SpringLayout.SOUTH,lblSonCorrectosEstos,-8,SpringLayout.NORTH,panel);
    contentPane.add(lblSonCorrectosEstos);
    
    JButton btnCancelar = new JButton("Cancelar");
    btnCancelar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        dispose();
      }
    });
    slcontentPane.putConstraint(SpringLayout.NORTH, btnCancelar, 6, SpringLayout.SOUTH, panel);
    slcontentPane.putConstraint(SpringLayout.WEST, btnCancelar, 0, SpringLayout.WEST, panel);
    contentPane.add(btnCancelar);
    
    JButton btnAgregar = new JButton("Agregar");
    btnAgregar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        IngredienteDAOIMP baseDatos = new IngredienteDAOIMP();
        int i = baseDatos.insertar(nuevo);
        if (i > 0) {
          JOptionPane.showMessageDialog(null,"Ingrediente agregado correctamente-"
        		  , "Agregar ingrediente", JOptionPane.PLAIN_MESSAGE);
        }
        dispose();
      }
    });
    slcontentPane.putConstraint(SpringLayout.SOUTH, btnAgregar, 0, SpringLayout.SOUTH, btnCancelar);
    slcontentPane.putConstraint(SpringLayout.EAST, btnAgregar, -10, SpringLayout.EAST, contentPane);
    contentPane.add(btnAgregar);
  }

}
