package Vistas;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
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

        tabla.getModel().addTableModelListener(new TableModelListener() {
            public void tableChanged(TableModelEvent e) {
                int fila = e.getFirstRow();
                int columna = e.getColumn();
                if (fila != -1 && columna != -1) {
                    DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
                    String nombre = (String) modelo.getValueAt(fila, 0);
                    String categoria = (String) modelo.getValueAt(fila, 1);
                    String existencias = (String) modelo.getValueAt(fila, 2);
                    String costo = (String) modelo.getValueAt(fila, 3);

                    try {
                        BufferedWriter escritor = new BufferedWriter(new FileWriter("src/dbFiles/existencias.txt"));

                        // Escribir los datos al archivo, reemplazando la línea editada
                        for (int i = 0; i < modelo.getRowCount(); i++) {
                            if (i == fila) {
                                // Si es la fila editada, escribir los nuevos datos
                                escritor.write(nombre + ":" + categoria + ":" + existencias + ":" + costo);
                            } else {
                                // Si no es la fila editada, escribir los datos existentes
                                escritor.write(modelo.getValueAt(i, 0) + ":" + modelo.getValueAt(i, 1) + ":" +
                                        modelo.getValueAt(i, 2) + ":" + modelo.getValueAt(i, 3));
                            }
                            escritor.newLine(); // Nueva línea
                        }

                        // Cerrar el escritor
                        escritor.close();

                        JOptionPane.showMessageDialog(null, "Los cambios se han guardado correctamente en el archivo.");
                    } catch (IOException ioException) {
                        JOptionPane.showMessageDialog(null, "Error al guardar los cambios en el archivo: " + ioException.getMessage());
                    }
                }
            }
        });
        
    }
}
