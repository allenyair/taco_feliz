package Vistas;

import javax.swing.*;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

public class NavegacionPanel extends JPanel {
    public NavegacionPanel(ActionListener listener) {
        
        setLayout(new GridLayout(0, 1));

        JButton btnIrMenu = new JButton("Menu");
        btnIrMenu.setPreferredSize(new Dimension(250, 50));
        btnIrMenu.addActionListener(listener);

        JButton btnIrMesas = new JButton("Servicio de Mesas");
        btnIrMesas.setSize(new Dimension(250, 50));
        btnIrMesas.addActionListener(listener);

        JButton btnIrReservaciones = new JButton("Reservaciones");
        btnIrReservaciones.setSize(new Dimension(250, 50));
        btnIrReservaciones.addActionListener(listener);

        JButton btnIrInventario = new JButton("Inventario");
        btnIrInventario.setSize(new Dimension(250, 50));
        btnIrInventario.addActionListener(listener);

        JButton btnIrReportes = new JButton("Reportes");
        btnIrReportes.setSize(new Dimension(250, 50));
        btnIrReportes.addActionListener(listener);

        JButton btnIrConfiguracion = new JButton("Configuración");
        btnIrConfiguracion.setSize(new Dimension(250, 50));
        btnIrConfiguracion.addActionListener(listener);

        JLabel logoRestaurante = new JLabel("TACO FELIZ :D");
        logoRestaurante.setHorizontalAlignment(SwingConstants.CENTER);

        add(logoRestaurante);
        add(btnIrMenu);
        add(btnIrMesas);
        add(btnIrReservaciones);
        add(btnIrInventario);
        add(btnIrReportes);
        add(btnIrConfiguracion);
    }
}
