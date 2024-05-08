package Vistas;

import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {
    public MenuPanel() {
        setBackground(Color.PINK);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel tituloLabel = new JLabel("Menu",SwingConstants.CENTER);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 24));
        tituloLabel.setForeground(Color.BLACK);
        add(tituloLabel);

        JPanel actionsPanel = new JPanel(new FlowLayout(0));
        actionsPanel.add(new JButton("Agregar"));
        actionsPanel.add(new JButton("Opciones"));
        add(actionsPanel);

        JPanel allProductos = new JPanel(new GridLayout(0,8,20,20));
        allProductos.add(new JButton("TACO DE BISTEC"));
        allProductos.add(new JButton("TACO DE BISTEC"));
        allProductos.add(new JButton("TACO DE BISTEC"));
        allProductos.add(new JButton("TACO DE BISTEC"));
        allProductos.add(new JButton("TACO DE BISTEC"));
        allProductos.add(new JButton("TACO DE BISTEC"));
        allProductos.add(new JButton("TACO DE BISTEC"));
        allProductos.add(new JButton("TACO DE BISTEC"));

        add(allProductos);


        

    }
}
