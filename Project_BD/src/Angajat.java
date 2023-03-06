//package prBD;

import java.awt.*;

import javax.swing.*;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Angajat extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private JTextField id;
    private JPasswordField passwordField;
    private JTextField D;
    private JTextField Dinceput;
    private JTextField Dfinal;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Angajat frame = new Angajat();
                    frame.setVisible(true);
                    center(frame);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */

    private static void center(final JFrame frame) {
        final Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        final int w = frame.getSize().width;
        final int h = frame.getSize().height;
        final int x = (dim.width - w) / 2;
        final int y = (dim.height - h) / 2;
        frame.setLocation(x, y);
    }

    Connection connection = null;

    public Angajat() {
        setTitle("Policlinică");
        setIconImage(Toolkit.getDefaultToolkit().getImage("art/cross.png"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 700, 700);
        getContentPane().setLayout(null);
        getContentPane().setBackground(new Color(253, 219, 50));

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(268, 60, 372, 275);
        getContentPane().add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);

        id = new JTextField();
        id.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        id.setBounds(100, 113, 100, 20);
        getContentPane().add(id);
        id.setColumns(10);

        JLabel txtId = new JLabel("ID:");
        //txtId.setHorizontalAlignment(SwingConstants.RIGHT);
        txtId.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        txtId.setBounds(28, 113, 60, 20);
        getContentPane().add(txtId);

        JLabel lblParola = new JLabel("Parolă:");
        lblParola.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblParola.setBounds(28, 167, 100, 20);
        getContentPane().add(lblParola);

        passwordField = new JPasswordField();
        passwordField.setBounds(100, 167, 100, 20);
        getContentPane().add(passwordField);

        JButton ProgramAfisare = new JButton("Afișare program");
        ProgramAfisare.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    connection = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=root");
                    String sql = "SELECT datapr AS 'Data', ora_incepere AS 'Ora inceput', ora_plecare AS 'Ora final', Unit.denumire AS 'Unitatea'"
                            + " FROM Utilizatori U, Angajat A, programangajati Pr, unitati_medicale AS Unit"
                            + " WHERE U.id_ca_angajat = A.id_angajat AND A.id_angajat = Pr.id_ca_angajat AND id_unitate_medicala = Pr.unitate"
                            + " AND id_utilizator = '" + id.getText() + "' AND parola = '" + passwordField.getText()
                            + "'" + " AND concediu = 0 ORDER BY datapr";
                    Statement stmt = connection.createStatement();
                    ResultSet rs = stmt.executeQuery(sql);
                    if (rs.next())
                        table.setModel(DbUtils.resultSetToTableModel(rs));

                    connection.close();
                } catch (Exception e1) {
                    System.out.print("Nu sunt date de afișat");
                }
            }
        });
        ProgramAfisare.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        ProgramAfisare.setBackground(new Color(176, 224, 230));
        ProgramAfisare.setBounds(28, 229, 190, 35);
        getContentPane().add(ProgramAfisare);

        JButton btnAfisareConcediu = new JButton("Afișare concediu");
        btnAfisareConcediu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    connection = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=root");
                    String sql = "SELECT datapr AS 'Data'"
                            + " FROM Utilizatori U, Angajat A, programangajati Pr, unitati_medicale AS Unit"
                            + " WHERE U.id_ca_angajat = A.id_angajat AND A.id_angajat = Pr.id_ca_angajat AND id_unitate_medicala = Pr.unitate"
                            + " AND id_utilizator = '" + id.getText() + "' AND parola = '" + passwordField.getText()
                            + "'" + "AND concediu = 1 ORDER BY datapr";
                    Statement stmt = connection.createStatement();
                    ResultSet rs = stmt.executeQuery(sql);
                    // if(rs.next())
                    table.setModel(DbUtils.resultSetToTableModel(rs));

                    connection.close();
                } catch (Exception e1) {
                    System.out.print("Nu sunt date de afișat");
                }
            }
        });
        btnAfisareConcediu.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        btnAfisareConcediu.setBackground(new Color(176, 224, 230));
        btnAfisareConcediu.setBounds(28, 288, 190, 35);
        getContentPane().add(btnAfisareConcediu);

        JLabel lblNewLabel = new JLabel("Introduceți o dată calendaristică pentru a afișa programul:");
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNewLabel.setBounds(28, 394, 612, 20);
        getContentPane().add(lblNewLabel);

        D = new JTextField();
        D.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        D.setText("AN-LUNĂ-ZI");
        D.setBounds(28, 445, 100, 20);
        getContentPane().add(D);
        D.setColumns(10);

        JButton cautareZi = new JButton("Afișare program");
        cautareZi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    connection = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=root");
                    String sql = "SELECT CONCAT(ora_incepere, ' - ', ora_plecare) AS 'Program', Unit.denumire AS 'Unitatea'"
                            + " FROM Utilizatori U, Angajat A, programangajati Pr, unitati_medicale AS Unit"
                            + " WHERE concediu = 0 AND U.id_ca_angajat = A.id_angajat AND A.id_angajat = Pr.id_ca_angajat AND id_unitate_medicala = Pr.unitate"
                            + " AND id_angajat = '" + id.getText() + "' AND parola = '" + passwordField.getText() + "'"
                            + "AND datapr = '" + D.getText() + "'";
                    Statement stmt = connection.createStatement();
                    ResultSet rs = stmt.executeQuery(sql);
                    // if(rs.next())
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                    String sql2 = "CALL verificareAconcediu('" + id.getText() + "', '" + passwordField.getText()
                            + "', '" + D.getText() + "')";
                    Statement stmt2 = connection.createStatement();
                    ResultSet rs2 = stmt2.executeQuery(sql2);
                    if (rs2.next() && rs2.getString("concediu").equals("1")) {
                        JOptionPane.showMessageDialog(null, "Perioada de concediu");
                    }
                    connection.close();
                } catch (Exception e1) {
                    System.out.print("Nu sunt date de afișat !");
                }
            }
        });
        cautareZi.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        cautareZi.setBackground(new Color(181, 130, 227));
        cautareZi.setBounds(450, 435, 190, 35);

        getContentPane().add(cautareZi);

        JLabel lblNewLabel_1 = new JLabel("Sau introduceți o perioadă:");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNewLabel_1.setBounds(28, 504, 612, 20);
        getContentPane().add(lblNewLabel_1);

        Dinceput = new JTextField();
        Dinceput.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        Dinceput.setText("Data de început");
        Dinceput.setColumns(10);
        Dinceput.setBounds(28, 551, 100, 20);
        getContentPane().add(Dinceput);

        JLabel lblNewLabel_2 = new JLabel("     -");
        lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblNewLabel_2.setBounds(113, 550, 34, 20);
        getContentPane().add(lblNewLabel_2);

        Dfinal = new JTextField();
        Dfinal.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        Dfinal.setText("Data de final");
        Dfinal.setColumns(10);
        Dfinal.setBounds(145, 551, 100, 20);
        getContentPane().add(Dfinal);

        JButton cautareProgram = new JButton("Afișare program");
        cautareProgram.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    connection = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=root");
                    String sql = "SELECT datapr AS 'Data', CONCAT(ora_incepere, ' - ', ora_plecare) AS 'Program', Unit.denumire AS 'Unitatea'"
                            + " FROM Utilizatori U, Angajat A, programangajati Pr, unitati_medicale AS Unit"
                            + " WHERE concediu = 0 AND U.id_ca_angajat = A.id_angajat AND A.id_angajat = Pr.id_ca_angajat AND id_unitate_medicala = Pr.unitate"
                            + " AND id_utilizator = '" + id.getText() + "' AND parola = '" + passwordField.getText()
                            + "'" + "AND datapr BETWEEN '" + Dinceput.getText() + "' AND '" + Dfinal.getText()
                            + "' ORDER BY datapr";
                    Statement stmt = connection.createStatement();
                    ResultSet rs = stmt.executeQuery(sql);
                    // if(rs.next())
                    table.setModel(DbUtils.resultSetToTableModel(rs));

                    connection.close();
                } catch (Exception e1) {
                    System.out.print("Nu sunt date de afișat");
                }
            }
        });
        cautareProgram.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        cautareProgram.setBackground(new Color(181, 130, 227));
        cautareProgram.setBounds(450, 541, 190, 35);
        getContentPane().add(cautareProgram);

        JButton btn_back1_1_1 = new JButton("Înapoi");
        btn_back1_1_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Modul_1 vpr = new Modul_1();
                vpr.show();
                center(vpr);
                dispose();
            }
        });
        //btnNewButton_1.setForeground(Color.RED);
        //btnNewButton_1.setBackground(Color.LIGHT_GRAY);
        btn_back1_1_1.setBounds(25, 600, 100, 50);
        btn_back1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        getContentPane().add(btn_back1_1_1);

        JLabel lblNewLabel_3 = new JLabel("Vă rugăm introduceți datele:");
        lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblNewLabel_3.setBounds(28, 56, 229, 20);
        getContentPane().add(lblNewLabel_3);

        JButton AfisareProgramari = new JButton("Afișare programări");
        AfisareProgramari.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    connection = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=root");
                    String sql = "SELECT CONCAT(ora_incepere, ' ', ora_plecare) AS 'Programare', Unit.denumire AS 'Unitatea',"
                            + " echipament_necesar AS 'Echipament'"
                            + " FROM Utilizatori U, Angajat A, programangajati Pr, unitati_medicale AS Unit, programari PrP, servicii S"
                            + " WHERE U.id_ca_angajat = A.id_angajat AND A.id_angajat = Pr.id_ca_angajat AND id_unitate_medicala = Pr.unitate"
                            + " AND PrP.unitatea = id_unitate_medicala AND PrP.medicul = id_angajat AND PrP.id_serviciupr = id_servicii"
                            + " AND id_utilizator = '" + id.getText() + "' AND parola = '" + passwordField.getText()
                            + "'" + " AND datapr = '" + D.getText() + "'";
                    Statement stmt = connection.createStatement();
                    ResultSet rs = stmt.executeQuery(sql);
                    // if(rs.next())
                    table.setModel(DbUtils.resultSetToTableModel(rs));

                    connection.close();
                } catch (Exception e1) {
                    System.out.print("Nu sunt date de afișat");
                }
            }
        });
        AfisareProgramari.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        AfisareProgramari.setBackground(new Color(96, 205, 92));
        AfisareProgramari.setBounds(224, 435, 208, 35);
        getContentPane().add(AfisareProgramari);
    }
}
