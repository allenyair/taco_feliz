package Vistas;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;

public class AddOrdenesPanel {
    private JFrame ventanaFormulario;

    public AddOrdenesPanel() {
        ventanaFormulario = new JFrame("Agregar reportes");
        
        JPanel AddOrdenesPanel = new JPanel(new GridLayout(0,2,20,20));
        AddOrdenesPanel.add(new JLabel("Agregar repoortes"));
        AddOrdenesPanel.add(new JLabel(""));

        JTextField mesaField = new JTextField(10);
        JTextField ordenField = new JTextField(10);
        JTextField importetotalField = new JTextField(10);
     

        AddOrdenesPanel.add(new JLabel("Mesa:"));
        AddOrdenesPanel.add(mesaField);
        AddOrdenesPanel.add(new JLabel("Orden:"));
        AddOrdenesPanel.add(ordenField);
        AddOrdenesPanel.add(new JLabel("Importe total:"));
        AddOrdenesPanel.add(importetotalField);
 
        
        JButton agregarTxt = new JButton("Agregar en TXT");
        
        agregarTxt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                try {
                    BufferedWriter escritor = new BufferedWriter(new FileWriter("src/dbFiles/reportes.txt", true));
                    
                    String mesa= mesaField.getText();
                    String orden = ordenField.getText();
                    String importetotal = importetotalField.getText();
                    
                    
                    escritor.newLine(); 
                    escritor.write(mesa + ":" + orden + ":" + importetotal);
                    
                    mesaField.setText("");
                    ordenField.setText("");
                    importetotalField.setText("");
                    
                    
                    escritor.close();

                    cerrar();
                    
                    JOptionPane.showMessageDialog(null, "Los datos se han escrito en el archivo correctamente.");
                } catch (IOException ioException) {
                    JOptionPane.showMessageDialog(null, "Error al escribir en el archivo: " + ioException.getMessage());
                    cerrar();
                }
            }
        });

        AddOrdenesPanel.add(new JLabel(""));
        AddOrdenesPanel.add(agregarTxt);

        ventanaFormulario.add(AddOrdenesPanel);
        ventanaFormulario.setSize(600, 400);
    }

    public void mostrar() {
        ventanaFormulario.setVisible(true);
    }

    public void cerrar(){
        ventanaFormulario.setVisible(false);
    }
}
