package Vistas;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;

public class AddExistenciasPanel {
    private JFrame ventanaFormulario;

    public AddExistenciasPanel() {
        ventanaFormulario = new JFrame("Agregar existencias");
        
        JPanel addExistenciasPanel = new JPanel(new GridLayout(0,2,20,20));
        addExistenciasPanel.add(new JLabel("Agregar existencias"));
        addExistenciasPanel.add(new JLabel(""));

        JTextField nombreField = new JTextField(10);
        JTextField categoriaField = new JTextField(10);
        JTextField existenciasField = new JTextField(10);
        JTextField costoField = new JTextField(10);

        addExistenciasPanel.add(new JLabel("Nombre:"));
        addExistenciasPanel.add(nombreField);
        addExistenciasPanel.add(new JLabel("Categoria:"));
        addExistenciasPanel.add(categoriaField);
        addExistenciasPanel.add(new JLabel("Existencias:"));
        addExistenciasPanel.add(existenciasField);
        addExistenciasPanel.add(new JLabel("Costo:"));
        addExistenciasPanel.add(costoField);
        
        JButton agregarTxt = new JButton("Agregar en TXT");
        
        agregarTxt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                try {
                    BufferedWriter escritor = new BufferedWriter(new FileWriter("src/dbFiles/existencias.txt", true));
                    
                    String nombre = nombreField.getText();
                    String categoria = categoriaField.getText();
                    String existencias = existenciasField.getText();
                    int existenciasInt = Integer.parseInt(existencias);
                    String costo = costoField.getText();
                    int costoInt = Integer.parseInt(costo);
                    
                    // Escribir en el archivo
                    escritor.newLine(); // Nueva línea
                    escritor.write(nombre+ ":" + categoria + ":" + existencias + ":" + costo);
                    
                    nombreField.setText("");
                    categoriaField.setText("");
                    existenciasField.setText("");
                    costoField.setText("");
                    
                    // Cerrar el escritor
                    escritor.close();

                    cerrar();
                    
                    JOptionPane.showMessageDialog(null, "Los datos se han escrito en el archivo correctamente.");
                } catch (IOException ioException) {
                    JOptionPane.showMessageDialog(null, "Error al escribir en el archivo: " + ioException.getMessage());
                    cerrar();
                }
            }
        });

        addExistenciasPanel.add(new JLabel(""));
        addExistenciasPanel.add(agregarTxt);

        ventanaFormulario.add(addExistenciasPanel);
        ventanaFormulario.setSize(600, 400);
    }

    public void mostrar() {
        ventanaFormulario.setVisible(true);
    }

    public void cerrar(){
        ventanaFormulario.setVisible(false);
    }
}
