package Vistas;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;

public class AddReservasPanel {
    private JFrame ventanaFormulario;

    public AddReservasPanel() {
        ventanaFormulario = new JFrame("Agregar Reservaciòn");
        
        JPanel addReservasPanel = new JPanel(new GridLayout(0,2,20,20));
        addReservasPanel.add(new JLabel("Agregar Reservaciòn"));
        addReservasPanel.add(new JLabel(""));

        JTextField nombreField = new JTextField(10);
        JTextField personasField = new JTextField(10);
        JTextField mesaField = new JTextField(10);
        JTextField observacionesField = new JTextField(10);
        JTextField ordenField = new JTextField(10); 

        addReservasPanel.add(new JLabel("Orden:"));
        addReservasPanel.add(ordenField);
        addReservasPanel.add(new JLabel("Nombre:"));
        addReservasPanel.add(nombreField);
        addReservasPanel.add(new JLabel("Personas:"));
        addReservasPanel.add(personasField);
        addReservasPanel.add(new JLabel("Mesa:"));
        addReservasPanel.add(mesaField);
        addReservasPanel.add(new JLabel("Observaciones:"));
        addReservasPanel.add(observacionesField);
        
        JButton agregarReservasBtn = new JButton("Agregar reservaciones");
        
        agregarReservasBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                try {
                    BufferedWriter escritor = new BufferedWriter(new FileWriter("src/dbFiles/Reservas.txt", true));
                    
                    String orden = ordenField.getText();
                    String nombre = nombreField.getText();
                    String personas = personasField.getText();
                    String mesa = mesaField.getText();
                    String observaciones = observacionesField.getText();
                    
                    // Escribir en el archivo
                    escritor.newLine(); // Nueva línea
                    escritor.write(orden + ":" + nombre + ":" + personas + ":" + mesa + ":" + observaciones);
                    
                    ordenField.setText("");
                    nombreField.setText("");
                    personasField.setText("");
                    mesaField.setText("");
                    observacionesField.setText("");

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

        addReservasPanel.add(new JLabel(""));
        addReservasPanel.add(agregarReservasBtn);

        ventanaFormulario.add(addReservasPanel);
        ventanaFormulario.setSize(600, 400);
    }

    public void mostrar() {
        ventanaFormulario.setVisible(true);
    }

    public void cerrar(){
        ventanaFormulario.setVisible(false);
    }
}
