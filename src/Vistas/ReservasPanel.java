package Vistas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class ReservasPanel extends JPanel {
    public ReservasPanel() {
        setBackground(Color.pink); 
        GridLayout layout = new GridLayout(3, 3);
        setLayout(layout);
        JLabel tituloLabel = new JLabel("Reservas",SwingConstants.CENTER);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 24));
        tituloLabel.setForeground(Color.BLACK);
        add(tituloLabel);


        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));


        JPanel actionsPanel = new JPanel(new FlowLayout(0));

        JButton agregarBtn = new JButton("Agregar");
        
        agregarBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              
                AddReservasPanel formulario = new AddReservasPanel();
                formulario.mostrar();
            }
        });

        actionsPanel.add(agregarBtn);



        JPanel tablaPanel = new JPanel(new BorderLayout());
        DefaultTableModel modeloInventario = new DefaultTableModel();
        modeloInventario.addColumn("Orden");
        modeloInventario.addColumn("Nombre");
        modeloInventario.addColumn("Costo");

        try {
            BufferedReader lector = new BufferedReader(new FileReader("src/dbFiles/Reservas.txt"));
            String linea;
            while ((linea = lector.readLine()) != null) {
                String[] datos = linea.split(":");
                if (datos.length == 3) {
                    modeloInventario.addRow(datos);
                }
            }
            lector.close();
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }

        JTable tabla = new JTable(modeloInventario);
        JScrollPane scrollPane = new JScrollPane(tabla);
        tablaPanel.add(scrollPane, BorderLayout.CENTER);
        add(tablaPanel);
    }
}

    
