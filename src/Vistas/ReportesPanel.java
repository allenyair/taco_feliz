package Vistas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class ReportesPanel extends JPanel {
    public ReportesPanel() {
        setBackground(Color.pink); 
        GridLayout layout = new GridLayout(3, 3);
        setLayout(layout);
        JLabel tituloLabel = new JLabel("Reportes",SwingConstants.CENTER);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 24));
        tituloLabel.setForeground(Color.BLACK);
        add(tituloLabel);


        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));


        JPanel actionsPanel = new JPanel(new FlowLayout(0));

        JButton agregarBtn = new JButton("Agregar");
        
        agregarBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              
                AddReportesPanel formulario = new AddReportesPanel();
                formulario.mostrar();
            }
        });

        actionsPanel.add(agregarBtn);

        actionsPanel.add(new JButton("Opciones"));
        add(actionsPanel);

        JPanel tablaPanel = new JPanel(new BorderLayout());
        DefaultTableModel modeloReportes = new DefaultTableModel();
        modeloReportes.addColumn("Periodo");
        modeloReportes.addColumn("Orden");
        modeloReportes.addColumn("Importe total");

        try {
            BufferedReader lector = new BufferedReader(new FileReader("src/dbFiles/Reportes.txt"));
            String linea;
            while ((linea = lector.readLine()) != null) {
                String[] datos = linea.split(":");
                if (datos.length == 3) {
                    modeloReportes.addRow(datos);
                }
            }
            lector.close();
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }

        JTable tabla = new JTable(modeloReportes);
        JScrollPane scrollPane = new JScrollPane(tabla);
        tablaPanel.add(scrollPane, BorderLayout.CENTER);
        add(tablaPanel);
    }
}

    