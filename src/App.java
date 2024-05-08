import javax.swing.*;

import com.formdev.flatlaf.FlatDarkLaf;

import Vistas.InventarioPanel;
import Vistas.MenuPanel;
import Vistas.MesasPanel;
import Vistas.NavegacionPanel;

import java.awt.*;
import java.awt.event.*;

public class App extends JFrame implements ActionListener {
    JPanel container;
    final static String PANEL1 = "Panel 1";
    final static String PANEL2 = "Panel 2";
    final static String PANEL3 = "Panel 3";
    
    public App() {
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf()); // Puedes cambiar FlatDarkLaf por otro tema FlatLaf según tu preferencia
        } catch (UnsupportedLookAndFeelException ex) {
            System.err.println("Failed to initialize FlatLaf");
        }

        setTitle("Restaurante El Taco Feliz");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Crear el contenedor para los paneles
        container = new JPanel(new CardLayout());

        // Agregar los paneles al contenedor
        container.add(new MenuPanel(), PANEL1);
        container.add(new MesasPanel(), PANEL2);
        container.add(new InventarioPanel(this), PANEL3);

        JPanel buttonPanel = new NavegacionPanel(this);

        getContentPane().add(buttonPanel, BorderLayout.WEST);
        getContentPane().add(container, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        CardLayout cl = (CardLayout)(container.getLayout());
        if (e.getActionCommand().equals("Menu")) {
            cl.show(container, PANEL1);
        } else if (e.getActionCommand().equals("Servicio de Mesas")) {
            cl.show(container, PANEL2);
        } else if (e.getActionCommand().equals("Inventario")) {
            cl.show(container, PANEL3);
            ((InventarioPanel)container.getComponent(2)).repaint();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new App();
            }
        });
    }
}