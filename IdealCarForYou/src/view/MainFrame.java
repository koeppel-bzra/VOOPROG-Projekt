package view;

import model.AufbauArt;
import model.Navigationssystem;
import model.TreibstoffArt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("IdealCar4You");
        frame.setSize(1000, 600);
        frame.setLocationRelativeTo(null);
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

        // Auto-Add-Button unten rechts
        JPanel pnlBottom = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton btnAddFahrzeug = new JButton("Auto hinzufügen");
        pnlBottom.add(btnAddFahrzeug);
        frame.add(pnlBottom, BorderLayout.SOUTH);

        // Transporter-Add-Button unten rechts
        JButton btnAddTransporter = new JButton("Transporter hinzufügen");
        pnlBottom.add(btnAddTransporter);


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


        // Actionlistener für Add Auto Button
        btnAddFahrzeug.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog dialogAdd = new JDialog(frame, "Fahrzeug hinzufügen", true);
                dialogAdd.setSize(300, 400);
                dialogAdd.setLocationRelativeTo(null);
                dialogAdd.setLayout(new GridLayout(0, 2, 5, 5));

                JLabel lblMarke = new JLabel("Marke: ");
                JTextField txtMarke = new JTextField();

                JLabel lblModell = new JLabel("Modell: ");
                JTextField txtModell = new JTextField();

                JLabel lblHubraum = new JLabel("Hubraum [ccm]: ");
                JTextField txtHubraum = new JTextField();

                JLabel lblTreibstoffart = new JLabel("Treibstoffart: ");
                JComboBox<TreibstoffArt> cmbTreibstoffart = new JComboBox<>(TreibstoffArt.values());

                JLabel lblKmStand = new JLabel("Aktueller Km-Stand: ");
                JTextField txtKmStand = new JTextField();

                JLabel lblLeistung = new JLabel("Leistung [PS]: ");
                JTextField txtLeistung = new JTextField();

                JLabel lblErstzulassungsdatum = new JLabel("Erstzulassungsdatum: ");
                JTextField txtErstzulassungsdatum = new JTextField();

                JLabel lblAussenfarbe = new JLabel("Aussenfarbe: ");
                JTextField txtAussenfarbe = new JTextField();

                JLabel lblLehrgewicht = new JLabel("Lehrgewicht [kg]: ");
                JTextField txtLehrgewicht = new JTextField();

                JLabel lblAufbau = new JLabel("Aufbau: ");
                JComboBox<AufbauArt> cmbAufbau = new JComboBox<>(AufbauArt.values());

                JLabel lblNavigation = new JLabel("Navigationssystem: ");
                JComboBox<Navigationssystem> cmbNavigation = new JComboBox<>(Navigationssystem.values());


                dialogAdd.add(lblMarke);
                dialogAdd.add(txtMarke);
                dialogAdd.add(lblModell);
                dialogAdd.add(txtModell);
                dialogAdd.add(lblHubraum);
                dialogAdd.add(txtHubraum);
                dialogAdd.add(lblTreibstoffart);
                dialogAdd.add(cmbTreibstoffart);
                dialogAdd.add(lblKmStand);
                dialogAdd.add(txtKmStand);
                dialogAdd.add(lblLeistung);
                dialogAdd.add(txtLeistung);
                dialogAdd.add(lblErstzulassungsdatum);
                dialogAdd.add(txtErstzulassungsdatum);
                dialogAdd.add(lblAussenfarbe);
                dialogAdd.add(txtAussenfarbe);
                dialogAdd.add(lblLehrgewicht);
                dialogAdd.add(txtLehrgewicht);
                dialogAdd.add(lblAufbau);
                dialogAdd.add(cmbAufbau);
                dialogAdd.add(lblNavigation);
                dialogAdd.add(cmbNavigation);

                dialogAdd.setVisible(true);
            }
        });

        // Actionslistener für Add Transporter Button
        btnAddTransporter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog dialogAdd = new JDialog(frame, "Fahrzeug hinzufügen", true);
                dialogAdd.setSize(350, 400);
                dialogAdd.setLocationRelativeTo(null);
                dialogAdd.setLayout(new GridLayout(0, 2, 5, 5));

                JLabel lblMarke = new JLabel("Marke: ");
                JTextField txtMarke = new JTextField();

                JLabel lblModell = new JLabel("Modell: ");
                JTextField txtModell = new JTextField();

                JLabel lblHubraum = new JLabel("Hubraum [ccm]: ");
                JTextField txtHubraum = new JTextField();

                JLabel lblTreibstoffart = new JLabel("Treibstoffart: ");
                JComboBox<TreibstoffArt> cmbTreibstoffart = new JComboBox<>(TreibstoffArt.values());

                JLabel lblKmStand = new JLabel("Aktueller Km-Stand: ");
                JTextField txtKmStand = new JTextField();

                JLabel lblLeistung = new JLabel("Leistung [PS]: ");
                JTextField txtLeistung = new JTextField();

                JLabel lblErstzulassungsdatum = new JLabel("Erstzulassungsdatum: ");
                JTextField txtErstzulassungsdatum = new JTextField();

                JLabel lblAussenfarbe = new JLabel("Aussenfarbe: ");
                JTextField txtAussenfarbe = new JTextField();

                JLabel lblLehrgewicht = new JLabel("Lehrgewicht [kg]: ");
                JTextField txtLehrgewicht = new JTextField();

                JLabel lblMaxZuladung = new JLabel("Maximale Zuladung [kg]: ");
                JTextField txtMaxZuladung = new JTextField();


                dialogAdd.add(lblMarke);
                dialogAdd.add(txtMarke);
                dialogAdd.add(lblModell);
                dialogAdd.add(txtModell);
                dialogAdd.add(lblHubraum);
                dialogAdd.add(txtHubraum);
                dialogAdd.add(lblTreibstoffart);
                dialogAdd.add(cmbTreibstoffart);
                dialogAdd.add(lblKmStand);
                dialogAdd.add(txtKmStand);
                dialogAdd.add(lblLeistung);
                dialogAdd.add(txtLeistung);
                dialogAdd.add(lblErstzulassungsdatum);
                dialogAdd.add(txtErstzulassungsdatum);
                dialogAdd.add(lblAussenfarbe);
                dialogAdd.add(txtAussenfarbe);
                dialogAdd.add(lblLehrgewicht);
                dialogAdd.add(txtLehrgewicht);
                dialogAdd.add(lblMaxZuladung);
                dialogAdd.add(txtMaxZuladung);

                dialogAdd.setVisible(true);
            }
        });

        frame.setVisible(true);
    }
}
