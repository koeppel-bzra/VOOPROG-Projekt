package view;

import model.*;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class MainFrame {

    public static void main(String[] args) {

        // FRAME + MODEL
        JFrame frame = new JFrame("IdealCar4You");
        frame.setSize(1000, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        CarManageModel model = new CarManageModel();

        // TOP TITLE
        JLabel lblTop = new JLabel("IdealCar4You - Verwaltung", SwingConstants.CENTER);
        lblTop.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(lblTop, BorderLayout.NORTH);

        // NAVIGATION (LEFT)
        JPanel pnlNav = new JPanel();
        pnlNav.setLayout(new BoxLayout(pnlNav, BoxLayout.Y_AXIS));

        JButton btnFahrzeuge = new JButton("Fahrzeuge ⬇");
        JButton btnAddAuto = new JButton("Auto hinzufügen");
        JButton btnAddTransporter = new JButton("Transporter hinzufügen");

        JPanel pnlSub = new JPanel();
        pnlSub.setLayout(new BoxLayout(pnlSub, BoxLayout.Y_AXIS));
        pnlSub.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
        pnlSub.add(btnAddAuto);
        pnlSub.add(btnAddTransporter);

        btnFahrzeuge.addActionListener(e -> {
            pnlSub.setVisible(!pnlSub.isVisible());
        });

        pnlNav.add(btnFahrzeuge);
        pnlNav.add(pnlSub);
        frame.add(pnlNav, BorderLayout.WEST);

        // LIST (CENTER LEFT)
        DefaultListModel<Fahrzeug> listModel = new DefaultListModel<>();
        JList<Fahrzeug> lstFahrzeuge = new JList<>(listModel);

        // DETAIL BASE PANEL
        JPanel pnlBase = new JPanel(new GridLayout(0, 2, 5, 5));
        pnlBase.setBorder(BorderFactory.createTitledBorder("Fahrzeug"));

        JLabel lblId = new JLabel("-");
        JLabel lblMarke = new JLabel("-");
        JLabel lblModell = new JLabel("-");
        JLabel lblHubraum = new JLabel("-");
        JLabel lblTreibstoff = new JLabel("-");
        JLabel lblKm = new JLabel("-");
        JLabel lblPs = new JLabel("-");
        JLabel lblDatum = new JLabel("-");
        JLabel lblFarbe = new JLabel("-");
        JLabel lblGewicht = new JLabel("-");

        pnlBase.add(new JLabel("ID:")); pnlBase.add(lblId);
        pnlBase.add(new JLabel("Marke:")); pnlBase.add(lblMarke);
        pnlBase.add(new JLabel("Modell:")); pnlBase.add(lblModell);
        pnlBase.add(new JLabel("Hubraum:")); pnlBase.add(lblHubraum);
        pnlBase.add(new JLabel("Treibstoff:")); pnlBase.add(lblTreibstoff);
        pnlBase.add(new JLabel("KM-Stand:")); pnlBase.add(lblKm);
        pnlBase.add(new JLabel("Leistung (PS):")); pnlBase.add(lblPs);
        pnlBase.add(new JLabel("Erstzulassung:")); pnlBase.add(lblDatum);
        pnlBase.add(new JLabel("Aussenfarbe:")); pnlBase.add(lblFarbe);
        pnlBase.add(new JLabel("Leergewicht:")); pnlBase.add(lblGewicht);

        // AUTO DETAILS
        JPanel pnlAuto = new JPanel(new GridLayout(0, 2, 5, 5));
        pnlAuto.setBorder(BorderFactory.createTitledBorder("Auto"));

        JLabel lblAufbau = new JLabel("-");
        JLabel lblNavigation = new JLabel("-");

        pnlAuto.add(new JLabel("Aufbau:"));
        pnlAuto.add(lblAufbau);
        pnlAuto.add(new JLabel("Navigation:"));
        pnlAuto.add(lblNavigation);

        // TRANSPORTER DETAILS
        JPanel pnlTransporter = new JPanel(new GridLayout(0, 2, 5, 5));
        pnlTransporter.setBorder(BorderFactory.createTitledBorder("Transporter"));

        JLabel lblZuladung = new JLabel("-");
        pnlTransporter.add(new JLabel("Max. Zuladung:"));
        pnlTransporter.add(lblZuladung);

        // CARD LAYOUT
        CardLayout cardLayout = new CardLayout();
        JPanel pnlType = new JPanel(cardLayout);
        pnlType.add(new JPanel(), "EMPTY");
        pnlType.add(pnlAuto, "AUTO");
        pnlType.add(pnlTransporter, "TRANSPORTER");

        pnlType.setPreferredSize(new Dimension(0, 120));

        JPanel pnlDetails = new JPanel();
        pnlDetails.setLayout(new BoxLayout(pnlDetails, BoxLayout.Y_AXIS));
        pnlBase.setAlignmentX(Component.LEFT_ALIGNMENT);
        pnlDetails.add(pnlBase);

        pnlType.setAlignmentX(Component.LEFT_ALIGNMENT);
        pnlType.setMaximumSize(new Dimension(Integer.MAX_VALUE, 120));
        pnlDetails.add(pnlType);

        // SPLIT PANE
        JSplitPane split = new JSplitPane(
                JSplitPane.HORIZONTAL_SPLIT,
                new JScrollPane(lstFahrzeuge),
                pnlDetails
        );
        split.setDividerLocation(500);
        frame.add(split, BorderLayout.CENTER);

        // LIST SELECTION
        lstFahrzeuge.addListSelectionListener(e -> {
            if (e.getValueIsAdjusting()) return;

            Fahrzeug f = lstFahrzeuge.getSelectedValue();
            if (f == null) {
                cardLayout.show(pnlType, "EMPTY");
                return;
            }

            lblId.setText(String.valueOf(f.getFahrzeugId()));
            lblMarke.setText(f.getMarke());
            lblModell.setText(f.getModell());
            lblHubraum.setText(String.valueOf(f.getHubraum()));
            lblTreibstoff.setText(f.getTreibstoffArt().toString());
            lblKm.setText(String.valueOf(f.getKmStand()));
            lblPs.setText(String.valueOf(f.getLeistungsPs()));
            lblDatum.setText(f.getErstzulassung().toString());
            lblFarbe.setText(f.getAussenfarbe());
            lblGewicht.setText(String.valueOf(f.getLeergewicht()));

            if (f instanceof Auto a) {
                lblAufbau.setText(a.getAufbauArt().toString());
                lblNavigation.setText(a.hasNavigation().toString());
                cardLayout.show(pnlType, "AUTO");

            } else if (f instanceof Transporter t) {
                lblZuladung.setText(String.valueOf(t.getMaxZuladungInKg()));
                cardLayout.show(pnlType, "TRANSPORTER");
            }
        });

        // ADD AUTO
        btnAddAuto.addActionListener(e -> {
            JDialog d = new JDialog(frame, "Auto hinzufügen", true);
            d.setSize(350, 400);
            d.setLayout(new GridLayout(0, 2, 5, 5));

            JTextField txtMarke = new JTextField();
            JTextField txtModell = new JTextField();
            JTextField txtHubraum = new JTextField();
            JComboBox<TreibstoffArt> cmbTreibstoff = new JComboBox<>(TreibstoffArt.values());
            JTextField txtKm = new JTextField();
            JTextField txtPs = new JTextField();
            JTextField txtDatum = new JTextField();
            JTextField txtFarbe = new JTextField();
            JTextField txtGewicht = new JTextField();
            JComboBox<AufbauArt> cmbAufbau = new JComboBox<>(AufbauArt.values());
            JComboBox<Navigationssystem> cmbNav = new JComboBox<>(Navigationssystem.values());

            JButton btnOk = new JButton("Hinzufügen");

            d.add(new JLabel("Marke")); d.add(txtMarke);
            d.add(new JLabel("Modell")); d.add(txtModell);
            d.add(new JLabel("Hubraum")); d.add(txtHubraum);
            d.add(new JLabel("Treibstoff")); d.add(cmbTreibstoff);
            d.add(new JLabel("KM")); d.add(txtKm);
            d.add(new JLabel("PS")); d.add(txtPs);
            d.add(new JLabel("Datum")); d.add(txtDatum);
            d.add(new JLabel("Farbe")); d.add(txtFarbe);
            d.add(new JLabel("Gewicht")); d.add(txtGewicht);
            d.add(new JLabel("Aufbau")); d.add(cmbAufbau);
            d.add(new JLabel("Navigation")); d.add(cmbNav);
            d.add(new JLabel()); d.add(btnOk);

            btnOk.addActionListener(ev -> {
                try {
                    Auto a = new Auto(
                            model.getNextFahrzeugId(),
                            txtMarke.getText(),
                            txtModell.getText(),
                            Integer.parseInt(txtHubraum.getText()),
                            (TreibstoffArt) cmbTreibstoff.getSelectedItem(),
                            Integer.parseInt(txtKm.getText()),
                            Integer.parseInt(txtPs.getText()),
                            LocalDate.parse(txtDatum.getText(), DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                            txtFarbe.getText(),
                            Integer.parseInt(txtGewicht.getText()),
                            (AufbauArt) cmbAufbau.getSelectedItem(),
                            (Navigationssystem) cmbNav.getSelectedItem()
                    );
                    model.addFahrzeug(a);
                    listModel.addElement(a);
                    d.dispose();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(d, "Eingabefehler");
                }
            });

            d.setLocationRelativeTo(frame);
            d.setVisible(true);
        });

        // ADD TRANSPORTER
        btnAddTransporter.addActionListener(e -> {
            JDialog d = new JDialog(frame, "Transporter hinzufügen", true);
            d.setSize(350, 350);
            d.setLayout(new GridLayout(0, 2, 5, 5));

            JTextField txtMarke = new JTextField();
            JTextField txtModell = new JTextField();
            JTextField txtHubraum = new JTextField();
            JComboBox<TreibstoffArt> cmbTreibstoff = new JComboBox<>(TreibstoffArt.values());
            JTextField txtKm = new JTextField();
            JTextField txtPs = new JTextField();
            JTextField txtDatum = new JTextField();
            JTextField txtFarbe = new JTextField();
            JTextField txtGewicht = new JTextField();
            JTextField txtZuladung = new JTextField();

            JButton btnOk = new JButton("Hinzufügen");

            d.add(new JLabel("Marke")); d.add(txtMarke);
            d.add(new JLabel("Modell")); d.add(txtModell);
            d.add(new JLabel("Hubraum")); d.add(txtHubraum);
            d.add(new JLabel("Treibstoff")); d.add(cmbTreibstoff);
            d.add(new JLabel("KM")); d.add(txtKm);
            d.add(new JLabel("PS")); d.add(txtPs);
            d.add(new JLabel("Datum")); d.add(txtDatum);
            d.add(new JLabel("Farbe")); d.add(txtFarbe);
            d.add(new JLabel("Gewicht")); d.add(txtGewicht);
            d.add(new JLabel("Zuladung")); d.add(txtZuladung);
            d.add(new JLabel()); d.add(btnOk);

            btnOk.addActionListener(ev -> {
                try {
                    Transporter t = new Transporter(
                            model.getNextFahrzeugId(),
                            txtMarke.getText(),
                            txtModell.getText(),
                            Integer.parseInt(txtHubraum.getText()),
                            (TreibstoffArt) cmbTreibstoff.getSelectedItem(),
                            Integer.parseInt(txtKm.getText()),
                            Integer.parseInt(txtPs.getText()),
                            LocalDate.parse(txtDatum.getText(), DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                            txtFarbe.getText(),
                            Integer.parseInt(txtGewicht.getText()),
                            Integer.parseInt(txtZuladung.getText())
                    );
                    model.addFahrzeug(t);
                    listModel.addElement(t);
                    d.dispose();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(d, "Eingabefehler");
                }
            });

            d.setLocationRelativeTo(frame);
            d.setVisible(true);
        });

        frame.setVisible(true);
    }
}
