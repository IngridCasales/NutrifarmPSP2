package vista;

import java.awt.CardLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ContenedorPaneles extends JFrame {

  private static final long serialVersionUID = 1L;
  private JPanel contentPane;
  private CardLayout tarjetero;
  private Inicio inicio;
  private Menu menu;
  private EligeAnimal eligeAnimal;

  /**
   *@ metodo principal Frame contenedor.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          ContenedorPaneles frame = new ContenedorPaneles();
          frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   *@ Constructor: Se instancia un objeto CardLayout y JPanel 
   *para alamcenar todas las pantallas a usar, 
   *se agragan los primeros 3 paneles
   *y se hace visible la pantalla incial.
   */
  public ContenedorPaneles() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 330, 520);
    contentPane = new JPanel();
    setContentPane(contentPane);
    tarjetero = new CardLayout();
    contentPane.setLayout(tarjetero);
    cargaPaneles();
    tarjetero.show(contentPane,"inicio1");
  }
  
  /**
   * Crea los primeros 3 paneles y los agrega al tarjetero(CadrLayout).
   */
  private void cargaPaneles() {
    inicio = new Inicio(tarjetero,contentPane);
    contentPane.add(inicio,"inicio1");
    menu = new Menu(tarjetero,contentPane);
    contentPane.add(menu,"menu2");
    eligeAnimal = new EligeAnimal(tarjetero,contentPane);
    contentPane.add(eligeAnimal,"eligeAnimal3");
  }

}
