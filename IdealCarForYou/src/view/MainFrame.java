package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("IdealCar4You");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Top Label
        JLabel lblTop = new JLabel("IdealCar4You - Verwaltung", SwingConstants.CENTER);
        lblTop.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(lblTop, BorderLayout.NORTH);

        // Navigation links
        JPanel pnlNav = new JPanel();
        pnlNav.setLayout(new GridLayout(5, 1, 5, 5));
        JButton btnFahrzeuge = new JButton("Fahrzeuge");
        JButton btnKunden = new JButton("Kunden");
        pnlNav.add(btnFahrzeuge);
        pnlNav.add(btnKunden);
        frame.add(pnlNav, BorderLayout.WEST);

        // Hauptbereich
        JTextArea txaMain = new JTextArea("Hallo");
        txaMain.setEditable(false);
        frame.add(new JScrollPane(txaMain), BorderLayout.CENTER);

        // Add-Button unten rechts
        JPanel pnlBottom = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton btnAddFahrzeug = new JButton("Hinzufügen");
        pnlBottom.add(btnAddFahrzeug);
        frame.add(pnlBottom, BorderLayout.SOUTH);

        // ActionListener für Buttons
        btnFahrzeuge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txaMain.setText("Fahrzeuge: ");
            }
        });

        btnKunden.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txaMain.setText("Kunden: ");
            }
        });

        btnAddFahrzeug.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog dialogAdd = new JDialog(frame, "Neues Fahrzeug hinzufügen", true);
                dialogAdd.setSize(300, 400);
                dialogAdd.setLayout(new GridLayout(0, 2, 5, 5));
                dialogAdd.setVisible(true);
            }
        });


        frame.setVisible(true);
    }
}
