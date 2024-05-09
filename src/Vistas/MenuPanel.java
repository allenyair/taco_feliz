package Vistas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MenuPanel extends JPanel {
    JPanel allProductos = new JPanel(new GridLayout(0,8,20,20));
    JButton recargarBtn = new JButton("Recargar");

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

        recargarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                llenarMenu();
            }
        });

        llenarMenu();
        
        actionsPanel.add(recargarBtn);
        add(allProductos);


        

    }


    public void llenarMenu(){
        try {
            BufferedReader lector = new BufferedReader(new FileReader("src/dbFiles/existencias.txt"));
            String linea;
            allProductos.removeAll();
            allProductos.revalidate(); // Actualiza la interfaz gráfica
            allProductos.repaint(); 
            while ((linea = lector.readLine()) != null) {
                String[] datos = linea.split(":");
                if (datos.length == 4) {
                    allProductos.add(new JButton(datos[0]));
                }
            }
            lector.close();
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }

}
