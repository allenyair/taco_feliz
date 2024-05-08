package Vistas;

import javax.swing.*;
import java.awt.*;

public class MesasPanel extends JPanel {
    public MesasPanel() {
        setBackground(Color.MAGENTA); // Fondo cyan para identificación visual
        GridLayout layout = new GridLayout(3, 3);
        setLayout(layout);
        add(new JLabel("Alv"));
    }

    
}
