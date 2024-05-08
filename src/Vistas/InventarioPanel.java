package Vistas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class InventarioPanel extends JPanel {
    public InventarioPanel(ActionListener listener) {
        
        setBackground(Color.PINK);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel tituloLabel = new JLabel("Inventario",SwingConstants.CENTER);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 24));
        tituloLabel.setForeground(Color.BLACK);
        add(tituloLabel);

        JPanel actionsPanel = new JPanel(new FlowLayout(0));

        JButton agregarBtn = new JButton("Agregar");
        
        agregarBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Al hacer clic en el botón, se crea y muestra la ventana del formulario
                AddExistenciasPanel formulario = new AddExistenciasPanel();
                formulario.mostrar();
            }
        });

        actionsPanel.add(agregarBtn);

        actionsPanel.add(new JButton("Opciones"));
        add(actionsPanel);

        JPanel tablaPanel = new JPanel(new BorderLayout());
        DefaultTableModel modeloInventario = new DefaultTableModel();
        modeloInventario.addColumn("Nombre");
        modeloInventario.addColumn("Categoría");
        modeloInventario.addColumn("Existencias");
        modeloInventario.addColumn("Costo");

        try {
            BufferedReader lector = new BufferedReader(new FileReader("src/dbFiles/existencias.txt"));
            String linea;
            while ((linea = lector.readLine()) != null) {
                String[] datos = linea.split(":");
                if (datos.length == 4) {
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
