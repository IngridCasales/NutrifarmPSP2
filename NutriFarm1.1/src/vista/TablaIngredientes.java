package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import modelo.Ingrediente;
import modelo.Mezcla;


public class TablaIngredientes extends JPanel {

  private static final long serialVersionUID = 1L;
  private JTable table;
  private JScrollPane scrollPane;
  private List<Ingrediente> ingredientes;
  private Mezcla concentrado;

  /**
   * Constructor: Identifica que parametro es nulo
   * para crear la tabla que correspondiente
   * (Mezcla obtenida o Seleccionar ingredientes).
   */
  public TablaIngredientes(List<Ingrediente> ingredientes,Mezcla mezcla) {
    setBackground(Color.LIGHT_GRAY);
    this.ingredientes = ingredientes;
    this.concentrado = mezcla;
    scrollPane = new JScrollPane();
    if (ingredientes == null && mezcla == null) {
      System.out.println("ERROR no se puede crear la tabla sin informacion"); 
    } else {
      if (mezcla != null) {
        creaTablaM(llenaDatosMezcla());
      }
      if (ingredientes != null) {
        creaTabla(llenaDatos());
      }
    }
    setLayout(new BorderLayout(0, 0));
    add(scrollPane);
  }
  
  /**
   * Crea la tabla con la informacion que contiene la matriz que recibe como parametro
   * .@param datos
   */
  public void creaTablaM(Object[][] datos) {
    DefaultTableModel modelo = new DefaultTableModel();
    table = new JTable(modelo);
    table.setBackground(new Color(255, 240, 245));
    table.setModel(new DefaultTableModel(datos,new String[] {"INGREDIETE","%CAN","%PC","%TND"}) {
      private static final long serialVersionUID = 1L;
      Class<?> [] tipos = new Class[]{java.lang.String.class,java.lang.String.class,
        java.lang.String.class,java.lang.String.class};
      
      @Override
      public Class<?> getColumnClass(int columnIndex) {
        return tipos[columnIndex];
      }

      @Override
      public boolean isCellEditable(int row, int column) {
        return false;
      }
    });
    table.setRowHeight(25);
    table.getColumnModel().getColumn(0).setMaxWidth(150);
    table.getColumnModel().getColumn(1).setMaxWidth(50);
    table.getColumnModel().getColumn(2).setMaxWidth(50);
    table.getColumnModel().getColumn(3).setMaxWidth(50);
    scrollPane.setViewportView(table);
  }

  
  /**
   * Crea la tabla con la informacion que contiene la matriz que recibe como parametro
   * .@param datos
   */
  public void creaTabla(Object[][] datos) {

    DefaultTableModel modelo = new DefaultTableModel();
    table = new JTable(modelo);
    table.setBackground(new Color(255, 240, 245));
    table.setModel(new DefaultTableModel(datos,new String[] {"INGREDIETE","%PC","%TND","  "}) {
      private static final long serialVersionUID = 1L;
      Class<?> [] tipos = new Class[]{java.lang.String.class,java.lang.String.class,
        java.lang.String.class,JButton.class};
            
      @Override
      public Class<?> getColumnClass(int columnIndex) {
        return tipos[columnIndex];
      }

      @Override
      public boolean isCellEditable(int row, int column) {
        return false;
      }
    });

    table.setDefaultRenderer(JButton.class, new TableCellRenderer() {
      
      @Override
      public Component getTableCellRendererComponent(JTable jtable, Object objeto, 
          boolean estaSeleccionado,boolean tieneElFoco, int fila, int columna) {
              
        return (Component) objeto;
      }
    });
    table.setRowHeight(25);
    table.getColumnModel().getColumn(0).setMaxWidth(150);
    table.getColumnModel().getColumn(1).setMaxWidth(50);
    table.getColumnModel().getColumn(2).setMaxWidth(50);
    table.getColumnModel().getColumn(3).setMaxWidth(50);
    table.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        int fila = table.rowAtPoint(e.getPoint());
        int columna = table.columnAtPoint(e.getPoint());
        if (ingredientes.size() > 0) {
          if ((columna == 3) && (fila < ingredientes.size())) {
            ingredientes.remove(fila);
            creaTabla(llenaDatos());
          }
        }
      }
    });
    scrollPane.setViewportView(table);
  }

  /**
   * Crea y llena una matriz con los datos que se mostraran en la tabla
   * a partir de la lista de ingredientes que se recive como parametro en el constructor de la clase
   * .@return
   */
  public Object[][] llenaDatos() {
    Object[][] datos = new Object[6][4];
    for (int i = 0;i < ingredientes.size(); i++) {
      datos[i][0] = ingredientes.get(i).getNom_ing();
      datos[i][1] = "" + ingredientes.get(i).getPro_cru();
      datos[i][2] = "" + ingredientes.get(i).getTnd();
      JButton btn1 = new JButton("");
      btn1.setIcon(new ImageIcon("/Users/mac/Downloads/bote.png"));
      datos[i][3] = btn1;
    }
    return datos;
  }

  /**
   * Crea y llena una matriz con los datos de la mezcla obtenida
   * .@return
   */
  public Object[][] llenaDatosMezcla() {
    Object[][] datos = new Object[6][4];
    for (int i = 0;i < concentrado.getIngredientes().size(); i++) {
      datos[i][0] = concentrado.getIngredientes().get(i).getNom_ing();
      datos[i][1] = "" + concentrado.getCantidadesIng().get(i).getPorcent();
      datos[i][2] = "" + concentrado.getIngredientes().get(i).getPro_cru();
      datos[i][3] = "" + concentrado.getIngredientes().get(i).getTnd();
      
    }
    return datos;
  }
  
  public List<Ingrediente> getIngredientes() {
    return ingredientes;
  }

  public void setIngredientes(List<Ingrediente> ingredientes) {
    this.ingredientes = ingredientes;
  }
}
