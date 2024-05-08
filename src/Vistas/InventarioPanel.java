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

    DefaultTableModel modeloInventario = new DefaultTableModel();

    public InventarioPanel(ActionListener listener) {
        
        setBackground(Color.PINK);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel tituloLabel = new JLabel("Inventario",SwingConstants.CENTER);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 24));
        tituloLabel.setForeground(Color.BLACK);
        add(tituloLabel);

        JPanel actionsPanel = new JPanel(new FlowLayout(0));

        JButton agregarBtn = new JButton("Agregar");
        JButton recargarBtn = new JButton("Recargar");
        
        // Al hacer clic en el botón, se crea y muestra la ventana del formulario
        agregarBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AddExistenciasPanel formulario = new AddExistenciasPanel();
                formulario.mostrar();
            }
        });

        recargarBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                modeloInventario.setRowCount(0);
                llenarModelo(modeloInventario, "src/dbFiles/existencias.txt");
            }
        });

        actionsPanel.add(agregarBtn);
        actionsPanel.add(recargarBtn);

        add(actionsPanel);

        JPanel tablaPanel = new JPanel(new BorderLayout());
        modeloInventario.addColumn("Nombre");
        modeloInventario.addColumn("Categoría");
        modeloInventario.addColumn("Existencias");
        modeloInventario.addColumn("Costo");
        JTable tabla = new JTable(modeloInventario);
        llenarModelo(modeloInventario, "src/dbFiles/existencias.txt");

        JScrollPane scrollPane = new JScrollPane(tabla);
        tablaPanel.add(scrollPane, BorderLayout.CENTER);
        add(tablaPanel);
    }

    public void llenarModelo(DefaultTableModel modelo, String ruta){
        try {
            BufferedReader lector = new BufferedReader(new FileReader(ruta));
            DefaultTableModel modeloTabla = modelo;
            String linea;
            while ((linea = lector.readLine()) != null) {
                String[] datos = linea.split(":");
                if (datos.length == 4) {
                    modeloTabla.addRow(datos);
                }
            }
            lector.close();
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }    

}
