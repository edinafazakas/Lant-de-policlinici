//package prBD;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class Vaccin extends JFrame {

    private JPanel contentPane;
    private JTextField id;
    private JTextField nume;
    private JTextField prenume;
    private JTextField acord;
    private JPasswordField parola;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Vaccin frame = new Vaccin();
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

    public Vaccin() {
        setTitle("Policlinică - VACCINARE");
        setIconImage(Toolkit.getDefaultToolkit().getImage("art/cross.png"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 700, 700);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(253, 219, 50));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Pentru a vă inregistră în vederea efectuării vaccinului \"Pfizer\" vă");
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNewLabel.setBounds(36, 55, 580, 20);
        contentPane.add(lblNewLabel);

        JLabel lblVaRugamSa = new JLabel("rugăm să completați câmpurile următoare:");
        lblVaRugamSa.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblVaRugamSa.setBounds(36, 85, 580, 25);
        contentPane.add(lblVaRugamSa);

        JLabel lblNewLabel_1 = new JLabel("ID:");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNewLabel_1.setBounds(36, 165, 100, 20);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_4 = new JLabel("Vă mulțumim pentru alegerea făcută!");
        lblNewLabel_4.setForeground(Color.RED);
        lblNewLabel_4.setBackground(Color.WHITE);
        lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNewLabel_4.setBounds(343, 480, 343, 30);
        contentPane.add(lblNewLabel_4);

        JLabel lblNewLabel_1_1 = new JLabel("Nume:");
        lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNewLabel_1_1.setBounds(36, 215, 100, 20);
        contentPane.add(lblNewLabel_1_1);

        JLabel lblNewLabel_1_2 = new JLabel("Prenume:");
        lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNewLabel_1_2.setBounds(36, 265, 100, 20);
        contentPane.add(lblNewLabel_1_2);

        JLabel lblNewLabel_1_3 = new JLabel("Sunt de acord cu vaccinarea:");
        lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNewLabel_1_3.setBounds(36, 315, 261, 20);
        contentPane.add(lblNewLabel_1_3);

        id = new JTextField();
        id.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        id.setBounds(484, 165, 100, 20);
        contentPane.add(id);
        id.setColumns(10);

        nume = new JTextField();
        nume.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        nume.setColumns(10);
        nume.setBounds(484, 216, 100, 20);
        contentPane.add(nume);

        prenume = new JTextField();
        prenume.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        prenume.setColumns(10);
        prenume.setBounds(484, 265, 100, 20);
        contentPane.add(prenume);

        acord = new JTextField();
        acord.setText("DA / NU");
        acord.setHorizontalAlignment(SwingConstants.CENTER);
        acord.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        acord.setColumns(10);
        acord.setBounds(484, 315, 100, 20);
        contentPane.add(acord);

        JLabel lblNewLabel_1_4 = new JLabel("Parolă:");
        lblNewLabel_1_4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNewLabel_1_4.setBounds(36, 365, 100, 20);
        contentPane.add(lblNewLabel_1_4);

        parola = new JPasswordField();
        parola.setBounds(484, 365, 100, 20);
        contentPane.add(parola);

        JButton btnNewButton = new JButton("Trimite");
        btnNewButton.setForeground(Color.WHITE);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=root");
                    String sql = "UPDATE Utilizatori SET vaccin = '" + acord.getText() + "' WHERE id_utilizator = " + id.getText()+" ";
                    PreparedStatement pst=con.prepareStatement(sql);

                    pst.execute(sql);
                    //ResultSet rs = stmt.executeQuery(sql);

                    if (pst != null) {
                        JOptionPane.showMessageDialog(null, "     Modificare efectuată cu succes !");
                        connection.close();
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "     Datele introduse nu sunt corecte !");
                    }
                } catch (Exception e1) {

                }
            }
        });
        btnNewButton.setBackground(Color.RED);
        btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnNewButton.setBounds(467, 420, 135, 35);
        contentPane.add(btnNewButton);

        JLabel lblNewLabel_2 = new JLabel("Notă: Sunt acceptate modificări ulterioare.");
        lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        lblNewLabel_2.setBounds(408, 10, 318, 20);
        contentPane.add(lblNewLabel_2);
        JButton btnNewButton_1 = new JButton("Înapoi");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Principala vpr = new Principala();
                vpr.show();
                center(vpr);
                dispose();
            }
        });
        //btnNewButton_1.setForeground(Color.RED);
        //btnNewButton_1.setBackground(Color.LIGHT_GRAY);
        btnNewButton_1.setBounds(40, 580, 100, 60);
        btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        contentPane.add(btnNewButton_1);
    }
}
