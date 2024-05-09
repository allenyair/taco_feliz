package Vistas;

import javax.swing.*;
import java.awt.*;

public class ReportesPanel extends JPanel {
    public ReportesPanel() {



        setBackground(Color.PINK); 
        GridLayout layout = new GridLayout(3, 3);

        setLayout(layout);

        JLabel tituloLabel = new JLabel("Reportes",SwingConstants.CENTER);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 24));
        tituloLabel.setForeground(Color.BLACK);

        add(tituloLabel);
      
        JLabel label = new JLabel("ROSAAAAAAAAA");
        label.setForeground(Color.BLACK);
       
        add(label);

        
    }   
}
    