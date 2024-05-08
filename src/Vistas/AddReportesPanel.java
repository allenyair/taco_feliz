package Vistas;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;

public class AddReportesPanel {
    private JFrame ventanaFormulario;

    public AddReportesPanel() {
        ventanaFormulario = new JFrame("Agregar reportes");
        
        JPanel addReportesPanel = new JPanel(new GridLayout(0,2,20,20));
        addReportesPanel.add(new JLabel("Agregar repoortes"));
        addReportesPanel.add(new JLabel(""));

        JTextField periodoField = new JTextField(10);
        JTextField ordenField = new JTextField(10);
        JTextField importetotalField = new JTextField(10);
     

        addReportesPanel.add(new JLabel("Periodo:"));
        addReportesPanel.add(periodoField);
        addReportesPanel.add(new JLabel("Orden:"));
        addReportesPanel.add(ordenField);
        addReportesPanel.add(new JLabel("Importe total:"));
        addReportesPanel.add(importetotalField);
 
        
        JButton agregarTxt = new JButton("Agregar en TXT");
        
        agregarTxt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                try {
                    BufferedWriter escritor = new BufferedWriter(new FileWriter("src/dbFiles/reportes.txt", true));
                    
                    String periodo= periodoField.getText();
                    String orden = ordenField.getText();
                    String importetotal = importetotalField.getText();
                    
                    
                    escritor.newLine(); 
                    escritor.write(periodo + ":" + orden + ":" + importetotal);
                    
                    periodoField.setText("");
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

        addReportesPanel.add(new JLabel(""));
        addReportesPanel.add(agregarTxt);

        ventanaFormulario.add(addReportesPanel);
        ventanaFormulario.setSize(600, 400);
    }

    public void mostrar() {
        ventanaFormulario.setVisible(true);
    }

    public void cerrar(){
        ventanaFormulario.setVisible(false);
    }
}
