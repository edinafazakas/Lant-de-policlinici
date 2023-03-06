//package prBD;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Modul_medic extends JFrame {

    private JPanel contentPane;
    private JTable tablep;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    private JTextField textField_7;
    private JTextField textField_8;
    private JTextField textField_9;
    private JTextField textField_11;
    private JTextField textField_12;
    private JTextField textField_13;
    private JTable table;
    private JTextField textField_14;
    private JTextField textField_15;
    private JTextField textField_16;
    private JTextField textField_17;
    private JTextField textField_18;
    private JTextField textField_19;
    private JTextField textField_20;
    private JTextField textField_21;
    private JTextField textField_22;
    private JTextField textField_23;
    private JTextField textField_24;
    private JTextField textField_25;
    private JTextField textField_26;
    private JTextField textField_28;
    private JTextField textField_29;
    private JTable tabler;
    private JTextField t1;
    private JTextField t3;
    private JTextField t4;
    private JTextField textField_36;
    private JTextField textField_37;
    private JTextField textField_10;
    private JTextField t8;
    private JTextField t2;
    private JTextField t5;
    private JTextField t6;
    private JTextField t7;
    private JTextField textField_41;
    private JTextField textField_40;
    private JTable tables;
    private JTextField textField_47;
    private JTextField textField_42;
    private JTextField textField_43;
    private JTextField textField_44;
    private JTextField textField_45;
    private JTextField textField_46;
    private JTextField textField_27;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Modul_medic frame = new Modul_medic();
                    frame.setVisible(true);
                    center(frame);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private static void center(final JFrame frame) {
        final Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        final int w = frame.getSize().width;
        final int h = frame.getSize().height;
        final int x = (dim.width - w) / 2;
        final int y = (dim.height - h) / 2;
        frame.setLocation(x, y);
    }

    public void refreshTable1() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=root");
            String sql = "SELECT * FROM raport_medical ";
            Statement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery(sql);
            tabler.setModel(DbUtils.resultSetToTableModel(rs));
            con.close();
        }catch(Exception e2) {System.out.print(e2);}

    }
    public void refreshTable2() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=root");
            String sql = "SELECT * FROM servicii";
            Statement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery(sql);
            tables.setModel(DbUtils.resultSetToTableModel(rs));
            con.close();
        }catch(Exception e2) {System.out.print(e2);}
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=root");

            String sql1 = "SELECT max(id_servicii) + 1 AS idp FROM servicii;";
            PreparedStatement pst = con2.prepareStatement(sql1);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {

                textField_42.setText(rs.getString("idp"));
            }
            if(textField_42.getText().equals("")) {
                textField_42.setText("1");
            }
            textField_42.setText(rs.getString(""));
            textField_43.setText(rs.getString(""));
            textField_44.setText(rs.getString(""));
            textField_45.setText(rs.getString(""));
            textField_46.setText(rs.getString(""));
            textField_47.setText(rs.getString(""));

            //JOptionPane.showMessageDialog(null," Successfully ");

            pst.close();
            con2.close();
        }catch(Exception e6) {System.out.print(e6);}
    }
    /**
     * Create the frame.
     */
    public Modul_medic() {
        setTitle("Policlinică");
        setIconImage(Toolkit.getDefaultToolkit().getImage("art/cross.png"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1200,800);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(253, 219, 50));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnDelogare = new JButton("Delogare");
        btnDelogare.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Modul_3 m3_1 = new Modul_3();
                m3_1.show();
                center(m3_1);
                dispose();
            }
        });
        btnDelogare.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        btnDelogare.setBounds(1020, 724, 117, 29);
        contentPane.add(btnDelogare);

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBounds(10, 10, 1166, 704);
        contentPane.add(tabbedPane);

        JPanel panel = new JPanel();
        tabbedPane.addTab("Pacienți ", null, panel, null);
        panel.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(377, 60, 726, 379);
        panel.add(scrollPane);

        tablep = new JTable();
        tablep.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=root");
                    int row = tablep.getSelectedRow();
                    String idul = (tablep.getModel().getValueAt(row,0)).toString();
                    //String sql1="select * from utilizatori where id_utilizator='"+idul+"'";
                    String sql1 = "SELECT * FROM pacienti WHERE id_pacient = " + idul + ";";
                    PreparedStatement pst = con2.prepareStatement(sql1);
                    //	pst.setString(1, (String)comboBoxId.getSelectedItem());
                    ResultSet rs = pst.executeQuery();
                    while(rs.next()) {
                        textField.setText(rs.getString("id_pacient"));
                        textField_1.setText(rs.getString("alergii"));
                        textField_2.setText(rs.getString("boli"));
                        textField_3.setText(rs.getString("nume"));
                        textField_4.setText(rs.getString("prenume"));
                        textField_5.setText(rs.getString("datanasterii"));
                        textField_6.setText(rs.getString("sexul"));
                        textField_7.setText(rs.getString("domiciliu"));
                        textField_8.setText(rs.getString("cetatenie"));
                        textField_9.setText(rs.getString("asigurare"));

                    }
                    //JOptionPane.showMessageDialog(null," Successfully ");

                    pst.close();
                    con2.close();
                }catch(Exception e6) {System.out.print(e6);}
            }
        });
        scrollPane.setViewportView(tablep);

        textField = new JTextField();
        textField.setBounds(157, 60, 150, 30);
        panel.add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(157, 100, 150, 30);
        panel.add(textField_1);

        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(157, 140, 150, 30);
        panel.add(textField_2);

        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(157, 181, 150, 30);
        panel.add(textField_3);

        textField_4 = new JTextField();
        textField_4.setColumns(10);
        textField_4.setBounds(157, 221, 150, 30);
        panel.add(textField_4);

        textField_5 = new JTextField();
        textField_5.setColumns(10);
        textField_5.setBounds(157, 265, 150, 30);
        panel.add(textField_5);

        textField_6 = new JTextField();
        textField_6.setColumns(10);
        textField_6.setBounds(157, 309, 150, 30);
        panel.add(textField_6);

        textField_7 = new JTextField();
        textField_7.setColumns(10);
        textField_7.setBounds(157, 354, 150, 30);
        panel.add(textField_7);

        textField_8 = new JTextField();
        textField_8.setColumns(10);
        textField_8.setBounds(157, 400, 150, 30);
        panel.add(textField_8);

        textField_9 = new JTextField();
        textField_9.setColumns(10);
        textField_9.setBounds(157, 447, 150, 30);
        panel.add(textField_9);

        JLabel lblNewLabel = new JLabel("ID pacient:");
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel.setBounds(48, 60, 99, 29);
        panel.add(lblNewLabel);

        JLabel lblAlergi = new JLabel("Alergi:");
        lblAlergi.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblAlergi.setHorizontalAlignment(SwingConstants.RIGHT);
        lblAlergi.setBounds(48, 99, 99, 29);
        panel.add(lblAlergi);

        JLabel lblBoli = new JLabel("Boli:");
        lblBoli.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblBoli.setHorizontalAlignment(SwingConstants.RIGHT);
        lblBoli.setBounds(48, 139, 99, 29);
        panel.add(lblBoli);

        JLabel lblNume = new JLabel("Nume:");
        lblNume.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNume.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNume.setBounds(48, 180, 99, 29);
        panel.add(lblNume);

        JLabel lblPrenume = new JLabel("Prenume:");
        lblPrenume.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblPrenume.setHorizontalAlignment(SwingConstants.RIGHT);
        lblPrenume.setBounds(48, 221, 99, 29);
        panel.add(lblPrenume);

        JLabel lblDataNasterii = new JLabel("Data nașterii:");
        lblDataNasterii.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblDataNasterii.setHorizontalAlignment(SwingConstants.RIGHT);
        lblDataNasterii.setBounds(48, 264, 105, 29);
        panel.add(lblDataNasterii);

        JLabel lblSexul = new JLabel("Sexul:");
        lblSexul.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblSexul.setHorizontalAlignment(SwingConstants.RIGHT);
        lblSexul.setBounds(48, 309, 99, 29);
        panel.add(lblSexul);

        JLabel lblDomiciuliu = new JLabel("Domiciliu:");
        lblDomiciuliu.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblDomiciuliu.setHorizontalAlignment(SwingConstants.RIGHT);
        lblDomiciuliu.setBounds(48, 353, 99, 29);
        panel.add(lblDomiciuliu);

        JLabel lblCetatenie = new JLabel("Cetățenie:");
        lblCetatenie.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblCetatenie.setHorizontalAlignment(SwingConstants.RIGHT);
        lblCetatenie.setBounds(48, 399, 99, 29);
        panel.add(lblCetatenie);

        JLabel lblAsigurare = new JLabel("Asigurare:");
        lblAsigurare.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblAsigurare.setHorizontalAlignment(SwingConstants.RIGHT);
        lblAsigurare.setBounds(48, 447, 99, 29);
        panel.add(lblAsigurare);

        JButton btnNewButton = new JButton("Vizualizarea tuturor pacienților");
        btnNewButton.setBackground(new Color(135, 206, 235));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e41) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=root");
                    String sql = "SELECT * FROM pacienti";
                    Statement pst = con.prepareStatement(sql);
                    ResultSet rs = pst.executeQuery(sql);
                    tablep.setModel(DbUtils.resultSetToTableModel(rs));
                    pst.close();
                    con.close();
                }catch(Exception e2) {System.out.print(e2);}

            }
        });
        btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        btnNewButton.setBounds(580, 449, 313, 36);
        panel.add(btnNewButton);

        textField_11 = new JTextField();
        textField_11.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=root");
                    //String sql1="insert into utilizatori(id_utilizator,tip,parola,CNP,nume,prenume,adresa,nr_telefon,mail,cont,nr_contract,data_angajarii,functie,rol,id_ca_angajat) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?); ";
                    String sql1 = "SELECT * FROM pacienti WHERE id_pacient = ?";
                    PreparedStatement pst = con2.prepareStatement(sql1);
                    pst.setString(1, textField_11.getText());
                    ResultSet rs = pst.executeQuery();
                    tablep.setModel(DbUtils.resultSetToTableModel(rs));

                    //JOptionPane.showMessageDialog(null," Successfully ");

                    pst.close();
                    con2.close();
                }catch(Exception e6) {System.out.print(e6);}
            }
        });
        textField_11.setBounds(677, 503, 245, 34);
        panel.add(textField_11);
        textField_11.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Căutare pacient după ID:");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNewLabel_1.setBounds(460, 511, 200, 22);
        panel.add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("Căutare pacient după nume:");
        lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNewLabel_1_1.setBounds(435, 556, 250, 22);
        panel.add(lblNewLabel_1_1);

        textField_12 = new JTextField();
        textField_12.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=root");
                    //String sql1="insert into utilizatori(id_utilizator,tip,parola,CNP,nume,prenume,adresa,nr_telefon,mail,cont,nr_contract,data_angajarii,functie,rol,id_ca_angajat) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?); ";
                    String sql1 = "SELECT * FROM pacienti WHERE nume = ?";
                    PreparedStatement pst = con2.prepareStatement(sql1);
                    pst.setString(1, textField_12.getText());
                    ResultSet rs = pst.executeQuery();
                    tablep.setModel(DbUtils.resultSetToTableModel(rs));

                    //JOptionPane.showMessageDialog(null," Successfully ");

                    pst.close();
                    con2.close();
                }catch(Exception e6) {System.out.print(e6);}
            }
        });
        textField_12.setColumns(10);
        textField_12.setBounds(677, 548, 245, 34);
        panel.add(textField_12);

        JLabel lblNewLabel_1_2 = new JLabel("Căutare pacient după ID-ul programării:");
        //lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNewLabel_1_2.setBounds(340, 640, 350, 22);
        panel.add(lblNewLabel_1_2);

        textField_13 = new JTextField();
        textField_13.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=root");
                    //String sql1="insert into utilizatori(id_utilizator,tip,parola,CNP,nume,prenume,adresa,nr_telefon,mail,cont,nr_contract,data_angajarii,functie,rol,id_ca_angajat) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?); ";
                    String sql1 = "SELECT pacienti.id_pacient, alergii, boli, nume, prenume, datanasterii, sexul, domiciliu, asigurare, id_programare FROM pacienti, programari WHERE pacienti.id_pacient = programari.id_pacient AND id_programare = ?";
                    PreparedStatement pst = con2.prepareStatement(sql1);
                    pst.setString(1, textField_13.getText());
                    ResultSet rs = pst.executeQuery();
                    tablep.setModel(DbUtils.resultSetToTableModel(rs));

                    //JOptionPane.showMessageDialog(null," Successfully ");

                    pst.close();
                    con2.close();
                }catch(Exception e6) {System.out.print(e6);}
            }
        });
        textField_13.setColumns(10);
        textField_13.setBounds(677, 633, 245, 34);
        panel.add(textField_13);

        textField_10 = new JTextField();
        textField_10.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=root");
                    //String sql1="insert into utilizatori(id_utilizator,tip,parola,CNP,nume,prenume,adresa,nr_telefon,mail,cont,nr_contract,data_angajarii,functie,rol,id_ca_angajat) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?); ";
                    String sql1 = "SELECT * FROM pacienti WHERE prenume = ?";
                    PreparedStatement pst = con2.prepareStatement(sql1);
                    pst.setString(1, textField_10.getText());
                    ResultSet rs = pst.executeQuery();
                    tablep.setModel(DbUtils.resultSetToTableModel(rs));

                    //JOptionPane.showMessageDialog(null," Successfully ");

                    pst.close();
                    con2.close();
                }catch(Exception e6) {System.out.print(e6);}
            }
        });
        textField_10.setColumns(10);
        textField_10.setBounds(677, 592, 245, 34);
        panel.add(textField_10);

        JLabel lblNewLabel_1_1_1 = new JLabel("Căutare pacient după prenume:");
        //lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNewLabel_1_1_1.setBounds(410, 600, 300, 22);
        panel.add(lblNewLabel_1_1_1);

        JPanel panel_1 = new JPanel();
        tabbedPane.addTab("Programări pacienți", null, panel_1, null);
        panel_1.setLayout(null);

        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(355, 27, 782, 393);
        panel_1.add(scrollPane_1);

        table = new JTable();
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=root");
                    int row = table.getSelectedRow();
                    String idul = (table.getModel().getValueAt(row,0)).toString();
                    //String sql1="select * from utilizatori where id_utilizator='"+idul+"'";
                    String sql1 = "SELECT * FROM programari WHERE id_programare = " + idul + ";";
                    PreparedStatement pst = con2.prepareStatement(sql1);
                    //	pst.setString(1, (String)comboBoxId.getSelectedItem());
                    ResultSet rs = pst.executeQuery();
                    while(rs.next()) {
                        textField_14.setText(rs.getString("id_programare"));
                        textField_15.setText(rs.getString("id_pacient"));
                        textField_16.setText(rs.getString("id_serviciupr"));
                        textField_40.setText(rs.getString("id_serviciupr2"));
                        textField_41.setText(rs.getString("id_serviciupr3"));
                        textField_17.setText(rs.getString("ora_inceperii"));
                        textField_18.setText(rs.getString("ora_finalizarii"));
                        textField_19.setText(rs.getString("datapacient"));
                        textField_20.setText(rs.getString("unitatea"));
                        textField_21.setText(rs.getString("medicul"));

                    }
                    //JOptionPane.showMessageDialog(null," Successfully ");

                    pst.close();
                    con2.close();
                }catch(Exception e6) {System.out.print(e6);}
            }
        });
        scrollPane_1.setViewportView(table);

        textField_14 = new JTextField();
        textField_14.setBounds(146, 39, 150, 30);
        panel_1.add(textField_14);
        textField_14.setColumns(10);


        textField_15 = new JTextField();
        textField_15.setColumns(10);
        textField_15.setBounds(146, 85, 150, 30);
        panel_1.add(textField_15);

        textField_16 = new JTextField();
        textField_16.setColumns(10);
        textField_16.setBounds(146, 132, 150, 30);
        panel_1.add(textField_16);

        textField_17 = new JTextField();
        textField_17.setColumns(10);
        textField_17.setBounds(146, 269, 150, 30);
        panel_1.add(textField_17);

        textField_18 = new JTextField();
        textField_18.setColumns(10);
        textField_18.setBounds(146, 314, 150, 30);
        panel_1.add(textField_18);

        textField_19 = new JTextField();
        textField_19.setColumns(10);
        textField_19.setBounds(146, 361, 150, 30);
        panel_1.add(textField_19);

        textField_20 = new JTextField();
        textField_20.setColumns(10);
        textField_20.setBounds(146, 410, 150, 30);
        panel_1.add(textField_20);

        textField_21 = new JTextField();
        textField_21.setColumns(10);
        textField_21.setBounds(146, 458, 150, 30);
        panel_1.add(textField_21);

        JLabel lblNewLabel_2 = new JLabel("ID programare:");
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNewLabel_2.setBounds(10, 40, 126, 29);
        panel_1.add(lblNewLabel_2);

        JLabel lblNewLabel_2_1 = new JLabel("ID pacient:");
        lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNewLabel_2_1.setBounds(10, 85, 126, 29);
        panel_1.add(lblNewLabel_2_1);

        JLabel lblNewLabel_2_2 = new JLabel("ID serviciupr1:");
        lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_2_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNewLabel_2_2.setBounds(10, 132, 126, 29);
        panel_1.add(lblNewLabel_2_2);

        JLabel lblNewLabel_2_3 = new JLabel("Ora începerii:");
        lblNewLabel_2_3.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_2_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNewLabel_2_3.setBounds(10, 269, 126, 29);
        panel_1.add(lblNewLabel_2_3);

        JLabel lblNewLabel_2_4 = new JLabel("Ora finalizării:");
        lblNewLabel_2_4.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_2_4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNewLabel_2_4.setBounds(10, 315, 126, 29);
        panel_1.add(lblNewLabel_2_4);

        JLabel lblNewLabel_2_5 = new JLabel("Data:");
        lblNewLabel_2_5.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_2_5.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNewLabel_2_5.setBounds(10, 361, 126, 29);
        panel_1.add(lblNewLabel_2_5);

        JLabel lblNewLabel_2_6 = new JLabel("Unitatea medicală:");
        lblNewLabel_2_6.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_2_6.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        lblNewLabel_2_6.setBounds(10, 410, 126, 29);
        panel_1.add(lblNewLabel_2_6);

        JLabel lblNewLabel_2_7 = new JLabel("Medicul:");
        lblNewLabel_2_7.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_2_7.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNewLabel_2_7.setBounds(10, 459, 126, 29);
        panel_1.add(lblNewLabel_2_7);

        JButton btnNewButton_2 = new JButton("Vizualizare programări");
        btnNewButton_2.setBackground(new Color(135, 206, 235));
        btnNewButton_2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e41) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=root");
                    String sql = "SELECT * FROM programari WHERE datapacient = curdate()";
                    Statement pst = con.prepareStatement(sql);
                    ResultSet rs = pst.executeQuery(sql);
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                    pst.close();
                    con.close();
                }catch(Exception e2) {System.out.print(e2);}

            }
        });
        btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        btnNewButton_2.setBounds(526, 461, 346, 39);
        panel_1.add(btnNewButton_2);

        JLabel lblNewLabel_3 = new JLabel("Afișează doar programările cu:");
        lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNewLabel_3.setBounds(34, 548, 346, 30);
        panel_1.add(lblNewLabel_3);

        textField_22 = new JTextField();
        textField_22.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=root");
                    //String sql1="insert into utilizatori(id_utilizator,tip,parola,CNP,nume,prenume,adresa,nr_telefon,mail,cont,nr_contract,data_angajarii,functie,rol,id_ca_angajat) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?); ";
                    String sql1 = "SELECT * FROM programari WHERE datapacient = curdate() AND id_programare = ?";
                    PreparedStatement pst = con2.prepareStatement(sql1);
                    pst.setString(1, textField_22.getText());
                    ResultSet rs = pst.executeQuery();
                    table.setModel(DbUtils.resultSetToTableModel(rs));

                    //JOptionPane.showMessageDialog(null," Successfully ");

                    pst.close();
                    con2.close();
                }catch(Exception e6) {System.out.print(e6);}
            }
        });
        textField_22.setBounds(106, 597, 120, 27);
        panel_1.add(textField_22);
        textField_22.setColumns(10);

        textField_23 = new JTextField();
        textField_23.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=root");
                    //String sql1="insert into utilizatori(id_utilizator,tip,parola,CNP,nume,prenume,adresa,nr_telefon,mail,cont,nr_contract,data_angajarii,functie,rol,id_ca_angajat) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?); ";
                    String sql1 = "SELECT * FROM programari WHERE datapacient = curdate() AND id_pacient = ?";
                    PreparedStatement pst = con2.prepareStatement(sql1);
                    pst.setString(1, textField_23.getText());
                    ResultSet rs = pst.executeQuery();
                    table.setModel(DbUtils.resultSetToTableModel(rs));

                    //JOptionPane.showMessageDialog(null," Successfully ");

                    pst.close();
                    con2.close();
                }catch(Exception e6) {System.out.print(e6);}
            }
        });
        textField_23.setColumns(10);
        textField_23.setBounds(248, 597, 120, 27);
        panel_1.add(textField_23);

        textField_24 = new JTextField();
        textField_24.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=root");
                    //String sql1="insert into utilizatori(id_utilizator,tip,parola,CNP,nume,prenume,adresa,nr_telefon,mail,cont,nr_contract,data_angajarii,functie,rol,id_ca_angajat) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?); ";
                    String sql1 = "SELECT * FROM programari WHERE datapacient = curdate() AND id_serviciupr = ?";
                    PreparedStatement pst = con2.prepareStatement(sql1);
                    pst.setString(1, textField_24.getText());
                    ResultSet rs = pst.executeQuery();
                    table.setModel(DbUtils.resultSetToTableModel(rs));

                    //JOptionPane.showMessageDialog(null," Successfully ");

                    pst.close();
                    con2.close();
                }catch(Exception e6) {System.out.print(e6);}
            }
        });

        textField_24.setColumns(10);
        textField_24.setBounds(396, 597, 120, 27);
        panel_1.add(textField_24);

        textField_25 = new JTextField();
        textField_25.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=root");
                    //String sql1="insert into utilizatori(id_utilizator,tip,parola,CNP,nume,prenume,adresa,nr_telefon,mail,cont,nr_contract,data_angajarii,functie,rol,id_ca_angajat) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?); ";
                    String sql1 = "SELECT * FROM programari WHERE datapacient = curdate() AND ora_inceperii = ?";
                    PreparedStatement pst = con2.prepareStatement(sql1);
                    pst.setString(1, textField_25.getText());
                    ResultSet rs = pst.executeQuery();
                    table.setModel(DbUtils.resultSetToTableModel(rs));

                    //JOptionPane.showMessageDialog(null," Successfully ");

                    pst.close();
                    con2.close();
                }catch(Exception e6) {System.out.print(e6);}
            }
        });
        textField_25.setColumns(10);
        textField_25.setBounds(540, 597, 120, 27);
        panel_1.add(textField_25);

        textField_26 = new JTextField();
        textField_26.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=root");
                    //String sql1="insert into utilizatori(id_utilizator,tip,parola,CNP,nume,prenume,adresa,nr_telefon,mail,cont,nr_contract,data_angajarii,functie,rol,id_ca_angajat) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?); ";
                    String sql1 = "SELECT * FROM programari WHERE datapacient = curdate() AND ora_finalizarii = ?";
                    PreparedStatement pst = con2.prepareStatement(sql1);
                    pst.setString(1, textField_26.getText());
                    ResultSet rs = pst.executeQuery();
                    table.setModel(DbUtils.resultSetToTableModel(rs));

                    //JOptionPane.showMessageDialog(null," Successfully ");

                    pst.close();
                    con2.close();
                }catch(Exception e6) {System.out.print(e6);}
            }
        });
        textField_26.setColumns(10);
        textField_26.setBounds(684, 597, 120, 27);
        panel_1.add(textField_26);

        textField_28 = new JTextField();
        textField_28.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=root");
                    //String sql1="insert into utilizatori(id_utilizator,tip,parola,CNP,nume,prenume,adresa,nr_telefon,mail,cont,nr_contract,data_angajarii,functie,rol,id_ca_angajat) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?); ";
                    String sql1 = "SELECT * FROM programari WHERE datapacient = curdate() AND unitatea = ?";
                    PreparedStatement pst = con2.prepareStatement(sql1);
                    pst.setString(1, textField_28.getText());
                    ResultSet rs = pst.executeQuery();
                    table.setModel(DbUtils.resultSetToTableModel(rs));

                    //JOptionPane.showMessageDialog(null," Successfully ");

                    pst.close();
                    con2.close();
                }catch(Exception e6) {System.out.print(e6);}
            }
        });
        textField_28.setColumns(10);
        textField_28.setBounds(819, 597, 120, 27);
        panel_1.add(textField_28);

        textField_29 = new JTextField();
        textField_29.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=root");
                    //String sql1="insert into utilizatori(id_utilizator,tip,parola,CNP,nume,prenume,adresa,nr_telefon,mail,cont,nr_contract,data_angajarii,functie,rol,id_ca_angajat) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?); ";
                    String sql1 = "SELECT * FROM programari WHERE datapacient = curdate() AND medicul = ?";
                    PreparedStatement pst = con2.prepareStatement(sql1);
                    pst.setString(1, textField_29.getText());
                    ResultSet rs = pst.executeQuery();
                    table.setModel(DbUtils.resultSetToTableModel(rs));

                    //JOptionPane.showMessageDialog(null," Successfully ");

                    pst.close();
                    con2.close();
                }catch(Exception e6) {System.out.print(e6);}
            }
        });
        textField_29.setColumns(10);
        textField_29.setBounds(949, 597, 120, 27);
        panel_1.add(textField_29);

        JLabel lblNewLabel_2_8 = new JLabel("ID programare");
        lblNewLabel_2_8.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_2_8.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblNewLabel_2_8.setBounds(85, 621, 126, 29);
        panel_1.add(lblNewLabel_2_8);

        JLabel lblNewLabel_2_1_1 = new JLabel("ID pacient");
        lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_2_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblNewLabel_2_1_1.setBounds(215, 621, 126, 29);
        panel_1.add(lblNewLabel_2_1_1);

        JLabel lblNewLabel_2_2_1 = new JLabel("ID serviciupr");
        lblNewLabel_2_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_2_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblNewLabel_2_2_1.setBounds(370, 621, 126, 29);
        panel_1.add(lblNewLabel_2_2_1);

        JLabel lblNewLabel_2_3_1 = new JLabel("Ora începerii");
        lblNewLabel_2_3_1.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_2_3_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblNewLabel_2_3_1.setBounds(515, 621, 126, 29);
        panel_1.add(lblNewLabel_2_3_1);

        JLabel lblNewLabel_2_4_1 = new JLabel("Ora finalizării");
        lblNewLabel_2_4_1.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_2_4_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblNewLabel_2_4_1.setBounds(660, 621, 126, 29);
        panel_1.add(lblNewLabel_2_4_1);

        JLabel lblNewLabel_2_6_1 = new JLabel("Unitatea medicală");
        lblNewLabel_2_6_1.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_2_6_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblNewLabel_2_6_1.setBounds(805, 621, 126, 29);
        panel_1.add(lblNewLabel_2_6_1);

        JLabel lblNewLabel_2_7_1 = new JLabel("Medicul");
        lblNewLabel_2_7_1.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_2_7_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblNewLabel_2_7_1.setBounds(905, 621, 126, 29);
        panel_1.add(lblNewLabel_2_7_1);

        textField_41 = new JTextField();
        textField_41.setColumns(10);
        textField_41.setBounds(146, 219, 150, 30);
        panel_1.add(textField_41);

        JLabel lblNewLabel_2_2_2 = new JLabel("ID serviciupr2:");
        lblNewLabel_2_2_2.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_2_2_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNewLabel_2_2_2.setBounds(10, 177, 126, 29);
        panel_1.add(lblNewLabel_2_2_2);

        textField_40 = new JTextField();
        textField_40.setColumns(10);
        textField_40.setBounds(146, 179, 150, 30);
        panel_1.add(textField_40);

        JLabel lblNewLabel_2_2_3 = new JLabel("ID serviciupr3:");
        lblNewLabel_2_2_3.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_2_2_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNewLabel_2_2_3.setBounds(10, 217, 126, 29);
        panel_1.add(lblNewLabel_2_2_3);

        JPanel panel_2 = new JPanel();
        tabbedPane.addTab("Rapoarte Medicale", null, panel_2, null);
        panel_2.setLayout(null);

        JScrollPane scrollPane_2 = new JScrollPane();
        scrollPane_2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane_2.setBounds(376, 23, 754, 405);
        panel_2.add(scrollPane_2);

        tabler = new JTable();
        tabler.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=");
                    int row = tabler.getSelectedRow();
                    String idul = (tabler.getModel().getValueAt(row,0)).toString();
                    //String sql1="select * from utilizatori where id_utilizator='"+idul+"'";
                    String sql1 = "SELECT * FROM raport_medical WHERE id_fisa = " + idul + ";";
                    PreparedStatement pst = con2.prepareStatement(sql1);
                    //	pst.setString(1, (String)comboBoxId.getSelectedItem());
                    ResultSet rs = pst.executeQuery();
                    while(rs.next()) {
                        t1.setText(rs.getString("id_fisa"));
                        t2.setText(rs.getString("id_programare"));
                        t3.setText(rs.getString("istoric"));
                        t4.setText(rs.getString("simptome"));
                        t5.setText(rs.getString("investigatii"));
                        t6.setText(rs.getString("diagnostic"));
                        t7.setText(rs.getString("recomandari"));
                        t8.setText(rs.getString("validare"));

                    }
                    //JOptionPane.showMessageDialog(null," Successfully ");

                    pst.close();
                    con2.close();
                }catch(Exception e6) {System.out.print(e6);}
            }
        });
        scrollPane_2.setViewportView(tabler);

        t1 = new JTextField();
        t1.setColumns(10);
        t1.setBounds(146, 68, 150, 30);
        panel_2.add(t1);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=root");
            String sql1 = "SELECT max(id_fisa) + 1 AS idp FROM raport_medical;";
            PreparedStatement pst = con2.prepareStatement(sql1);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {

                t1.setText(rs.getString("idp"));
            }
            if(t1.getText().equals("")) {
                t1.setText("1");
            }
            //JOptionPane.showMessageDialog(null," Successfully ");

            pst.close();
            con2.close();
        }catch(Exception e6) {System.out.print(e6);}

        t3 = new JTextField();
        t3.setColumns(10);
        t3.setBounds(146, 152, 150, 30);
        panel_2.add(t3);

        t4 = new JTextField();
        t4.setColumns(10);
        t4.setBounds(146, 202, 150, 30);
        panel_2.add(t4);

        JLabel lblNewLabel_2_9 = new JLabel("ID fișă:");
        lblNewLabel_2_9.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_2_9.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNewLabel_2_9.setBounds(10, 68, 126, 29);
        panel_2.add(lblNewLabel_2_9);

        JLabel lblNewLabel_2_11 = new JLabel("ID programare:");
        lblNewLabel_2_11.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_2_11.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNewLabel_2_11.setBounds(10, 108, 126, 29);
        panel_2.add(lblNewLabel_2_11);

        JLabel lblNewLabel_2_12 = new JLabel("Istoric:");
        lblNewLabel_2_12.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_2_12.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNewLabel_2_12.setBounds(10, 150, 126, 29);
        panel_2.add(lblNewLabel_2_12);

        JButton btnNewButton_4 = new JButton("Vizualizare rapoarte medicale");
        btnNewButton_4.setBackground(new Color(135, 206, 235));
        btnNewButton_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e41) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=root");
                    String sql = "SELECT * FROM raport_medical";
                    Statement pst = con.prepareStatement(sql);
                    ResultSet rs = pst.executeQuery(sql);
                    tabler.setModel(DbUtils.resultSetToTableModel(rs));
                    pst.close();
                    con.close();
                }catch(Exception e2) {System.out.print(e2);}

            }
        });
        btnNewButton_4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        btnNewButton_4.setBounds(376, 491, 295, 30);
        panel_2.add(btnNewButton_4);

        JButton btnNewButton_4_1 = new JButton("Inserare raport medical");
        btnNewButton_4_1.setBackground(new Color(152, 251, 152));
        btnNewButton_4_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=root");
                    String sql1 = "INSERT INTO raport_medical" + " VALUES " + "(" + t1.getText() + "," + t2.getText() + ",\"" + t3.getText() + "\",\"" + t4.getText() + "\",\"" + t5.getText() + "\",\"" + t6.getText() + "\",\"" + t7.getText() + "\",\"" + t8.getText() + "\" );";
                    PreparedStatement pst = con2.prepareStatement(sql1);

                    pst.execute(sql1);
                    JOptionPane.showMessageDialog(null," Successfully ");

                    pst.close();

                    con2.close();
                }catch(Exception e3) {System.out.print(e3);}
                refreshTable1();
            }
        });
        btnNewButton_4_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        btnNewButton_4_1.setBounds(727, 467, 295, 30);
        panel_2.add(btnNewButton_4_1);

        JButton btnNewButton_4_2 = new JButton("Validare");
        btnNewButton_4_2.setBackground(new Color(252, 191, 82));
        btnNewButton_4_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=root");
                    //String sql1="insert into utilizatori(id_utilizator,tip,parola,CNP,nume,prenume,		adresa,nr_telefon,mail,cont,nr_contract,data_angajarii,functie,rol,id_ca_angajat) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?); ";
                    String sql3 = "UPDATE raport_medical SET validare = 1 WHERE id_fisa = " + t1.getText() + ";";

                    PreparedStatement pst = con2.prepareStatement(sql3);

                    pst.execute(sql3);
                    JOptionPane.showMessageDialog(null," Successfully ");

                    pst.close();
                    con2.close();
                }catch(Exception e897) {System.out.print(e897);}
                refreshTable1();
            }
        });
        btnNewButton_4_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        btnNewButton_4_2.setBounds(727, 513, 295, 30);
        panel_2.add(btnNewButton_4_2);

        textField_36 = new JTextField();
        textField_36.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=root");
                    //String sql1="insert into utilizatori(id_utilizator,tip,parola,CNP,nume,prenume,adresa,nr_telefon,mail,cont,nr_contract,data_angajarii,functie,rol,id_ca_angajat) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?); ";
                    String sql1 = "SELECT * FROM raport_medical WHERE id_fisa = ?";
                    PreparedStatement pst = con2.prepareStatement(sql1);
                    pst.setString(1, textField_36.getText());
                    ResultSet rs = pst.executeQuery();
                    tabler.setModel(DbUtils.resultSetToTableModel(rs));

                    //JOptionPane.showMessageDialog(null," Successfully ");

                    pst.close();
                    con2.close();
                }catch(Exception e6) {System.out.print(e6);}
            }
        });
        textField_36.setBounds(346, 573, 238, 37);
        panel_2.add(textField_36);
        textField_36.setColumns(10);

        textField_37 = new JTextField();
        textField_37.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=root");
                    //String sql1="insert into utilizatori(id_utilizator,tip,parola,CNP,nume,prenume,adresa,nr_telefon,mail,cont,nr_contract,data_angajarii,functie,rol,id_ca_angajat) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?); ";
                    String sql1 = "SELECT * FROM raport_medical WHERE id_programare = ?";
                    PreparedStatement pst = con2.prepareStatement(sql1);
                    pst.setString(1, textField_37.getText());
                    ResultSet rs = pst.executeQuery();
                    tabler.setModel(DbUtils.resultSetToTableModel(rs));

                    //JOptionPane.showMessageDialog(null," Successfully ");

                    pst.close();
                    con2.close();
                }catch(Exception e6) {System.out.print(e6);}
            }
        });
        textField_37.setColumns(10);
        textField_37.setBounds(346, 620, 238, 37);
        panel_2.add(textField_37);

        JLabel lblNewLabel_4 = new JLabel("Căutare raport medical cu ID-ul fișei:");
        lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblNewLabel_4.setBounds(50, 574, 286, 30);
        panel_2.add(lblNewLabel_4);

        JLabel lblNewLabel_4_1 = new JLabel("Căutare raport medical cu ID-ul programării:");
        lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_4_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblNewLabel_4_1.setBounds(41, 620, 295, 30);
        panel_2.add(lblNewLabel_4_1);

        t8 = new JTextField();
        t8.setColumns(10);
        t8.setBounds(146, 389, 150, 30);
        panel_2.add(t8);

        JLabel lblNewLabel_2_12_1 = new JLabel("Simptome:");
        lblNewLabel_2_12_1.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_2_12_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNewLabel_2_12_1.setBounds(10, 200, 126, 29);
        panel_2.add(lblNewLabel_2_12_1);

        t2 = new JTextField();
        t2.setColumns(10);
        t2.setBounds(146, 108, 150, 30);
        panel_2.add(t2);

        JLabel lblNewLabel_2_12_1_1 = new JLabel("Investigații:");
        lblNewLabel_2_12_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_2_12_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNewLabel_2_12_1_1.setBounds(10, 252, 126, 29);
        panel_2.add(lblNewLabel_2_12_1_1);

        t5 = new JTextField();
        t5.setColumns(10);
        t5.setBounds(146, 254, 150, 30);
        panel_2.add(t5);

        JLabel lblNewLabel_2_12_1_2 = new JLabel("Diagnostic:");
        lblNewLabel_2_12_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_2_12_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNewLabel_2_12_1_2.setBounds(10, 297, 126, 29);
        panel_2.add(lblNewLabel_2_12_1_2);

        t6 = new JTextField();
        t6.setColumns(10);
        t6.setBounds(146, 299, 150, 30);
        panel_2.add(t6);

        JLabel lblNewLabel_2_12_1_3 = new JLabel("Recomandări:");
        lblNewLabel_2_12_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_2_12_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNewLabel_2_12_1_3.setBounds(10, 342, 126, 29);
        panel_2.add(lblNewLabel_2_12_1_3);

        t7 = new JTextField();
        t7.setColumns(10);
        t7.setBounds(146, 339, 150, 30);
        panel_2.add(t7);

        JLabel lblNewLabel_2_12_1_4 = new JLabel("Validare:");
        lblNewLabel_2_12_1_4.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_2_12_1_4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNewLabel_2_12_1_4.setBounds(10, 387, 126, 29);
        panel_2.add(lblNewLabel_2_12_1_4);

        JLabel lblNewLabel_4_2 = new JLabel("Căutare raport medical cu ID-ul pacientului:");
        lblNewLabel_4_2.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_4_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblNewLabel_4_2.setBounds(596, 599, 286, 30);
        panel_2.add(lblNewLabel_4_2);

        textField_27 = new JTextField();
        textField_27.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=root");
                    //String sql1="insert into utilizatori(id_utilizator,tip,parola,CNP,nume,prenume,adresa,nr_telefon,mail,cont,nr_contract,data_angajarii,functie,rol,id_ca_angajat) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?); ";
                    String sql1 = "SELECT raport_medical.id_fisa, istoric, simptome, investigatii, diagnostic, recomandari, validare FROM raport_medical, programari WHERE raport_medical.id_programare = programari.id_programare AND programari.id_pacient = ?";
                    PreparedStatement pst=con2.prepareStatement(sql1);
                    pst.setString(1, textField_27.getText());
                    ResultSet rs = pst.executeQuery();
                    tabler.setModel(DbUtils.resultSetToTableModel(rs));

                    //JOptionPane.showMessageDialog(null," Successfully ");

                    pst.close();
                    con2.close();
                }catch(Exception e6) {System.out.print(e6);}
            }
        });
        textField_27.setColumns(10);
        textField_27.setBounds(890, 598, 238, 37);
        panel_2.add(textField_27);

        JPanel panel_3 = new JPanel();
        tabbedPane.addTab("Adăugare serviciu", null, panel_3, null);
        panel_3.setLayout(null);

        JScrollPane scrollPane_3 = new JScrollPane();
        scrollPane_3.setBounds(336, 10, 783, 423);
        panel_3.add(scrollPane_3);

        tables = new JTable();
        tables.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=root");
                    int row = tables.getSelectedRow();
                    String idul = (tables.getModel().getValueAt(row,0)).toString();
                    //String sql1="select * from utilizatori where id_utilizator='"+idul+"'";
                    String sql1 = "SELECT * FROM servicii WHERE id_servicii = " + idul + ";";
                    PreparedStatement pst = con2.prepareStatement(sql1);
                    //	pst.setString(1, (String)comboBoxId.getSelectedItem());
                    ResultSet rs = pst.executeQuery();
                    while(rs.next()) {
                        textField_42.setText(rs.getString("id_servicii"));
                        textField_43.setText(rs.getString("secialitate"));
                        textField_44.setText(rs.getString("necesitate_competente"));
                        textField_45.setText(rs.getString("pret"));
                        textField_46.setText(rs.getString("durata"));
                        textField_47.setText(rs.getString("echipament_necesar"));

                    }
                    //JOptionPane.showMessageDialog(null," Successfully ");

                    pst.close();
                    con2.close();
                }catch(Exception e6) {System.out.print(e6);}
            }
        });
        scrollPane_3.setViewportView(tables);

        JLabel lblNewLabel_2_9_1 = new JLabel("ID servicii:");
        lblNewLabel_2_9_1.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_2_9_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNewLabel_2_9_1.setBounds(10, 100, 148, 29);
        panel_3.add(lblNewLabel_2_9_1);

        textField_47 = new JTextField();
        textField_47.setColumns(10);
        textField_47.setBounds(168, 304, 150, 30);
        panel_3.add(textField_47);

        JLabel lblNewLabel_2_9_2 = new JLabel("Specialitate:");
        lblNewLabel_2_9_2.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_2_9_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNewLabel_2_9_2.setBounds(10, 139, 148, 29);
        panel_3.add(lblNewLabel_2_9_2);

        textField_42 = new JTextField();
        textField_42.setColumns(10);
        textField_42.setBounds(168, 100, 150, 30);
        panel_3.add(textField_42);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=root");
            String sql1 = "SELECT max(id_servicii) + 1 AS idp FROM servicii;";
            PreparedStatement pst = con2.prepareStatement(sql1);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {

                textField_42.setText(rs.getString("idp"));
            }
            if(textField_42.getText().equals("")) {
                textField_42.setText("1");
            }
            //JOptionPane.showMessageDialog(null," Successfully ");

            pst.close();
            con2.close();
        }catch(Exception e6) {System.out.print(e6);}

        JLabel lblNewLabel_2_9_3 = new JLabel("Necesitate competente:");
        lblNewLabel_2_9_3.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_2_9_3.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        lblNewLabel_2_9_3.setBounds(0, 181, 160, 29);
        panel_3.add(lblNewLabel_2_9_3);

        textField_43 = new JTextField();
        textField_43.setColumns(10);
        textField_43.setBounds(168, 142, 150, 30);
        panel_3.add(textField_43);

        JLabel lblNewLabel_2_9_4 = new JLabel("Preț:");
        lblNewLabel_2_9_4.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_2_9_4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNewLabel_2_9_4.setBounds(10, 220, 148, 29);
        panel_3.add(lblNewLabel_2_9_4);

        textField_44 = new JTextField();
        textField_44.setColumns(10);
        textField_44.setBounds(168, 181, 150, 30);
        panel_3.add(textField_44);

        JLabel lblNewLabel_2_9_5 = new JLabel("Durata:");
        lblNewLabel_2_9_5.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_2_9_5.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNewLabel_2_9_5.setBounds(10, 262, 148, 29);
        panel_3.add(lblNewLabel_2_9_5);

        textField_45 = new JTextField();
        textField_45.setColumns(10);
        textField_45.setBounds(168, 223, 150, 30);
        panel_3.add(textField_45);

        JLabel lblNewLabel_2_9_6 = new JLabel("Echipament necesar:");
        lblNewLabel_2_9_6.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_2_9_6.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        lblNewLabel_2_9_6.setBounds(10, 304, 148, 29);
        panel_3.add(lblNewLabel_2_9_6);

        textField_46 = new JTextField();
        textField_46.setColumns(10);
        textField_46.setBounds(168, 265, 150, 30);
        panel_3.add(textField_46);

        JButton btnNewButton_4_1_1 = new JButton("Adăugare serviciu");
        btnNewButton_4_1_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String sql1 = "INSERT INTO servicii VALUES (" + textField_42.getText() + ",'" + textField_43.getText() + "','" + textField_44.getText() + "'," + textField_45.getText() + "," + textField_46.getText() + ",'" + textField_47.getText() + "');";
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=root");
                    //String sql1="insert into raport_medical"+ " values "+ "("+textField_30.getText()+","+ textField_31.getText()+",\""+ textField_32.getText()+"\",\""+textField_33.getText()+"\",\""+ textField_34.getText()+"\",\""+textField_35.getText()+"\",\""+textField_38.getText()+"\",\""+textField_39.getText()+"\" );" ;
                    PreparedStatement pst=con2.prepareStatement(sql1);

                    pst.execute(sql1);
                    JOptionPane.showMessageDialog(null,"         Adăugare cu succes !");

                    pst.close();

                    con2.close();
                    refreshTable2();
                }catch(Exception e6) {System.out.print(e6);}
            }
        });
        btnNewButton_4_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        btnNewButton_4_1_1.setBackground(new Color(152, 251, 152));
        btnNewButton_4_1_1.setBounds(23, 470, 295, 30);
        panel_3.add(btnNewButton_4_1_1);

        JButton btnNewButton_4_3 = new JButton("Vizualizare servicii");
        btnNewButton_4_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=root");
                    String sql = "SELECT * FROM servicii";
                    Statement pst = con.prepareStatement(sql);
                    ResultSet rs = pst.executeQuery(sql);
                    tables.setModel(DbUtils.resultSetToTableModel(rs));
                    pst.close();
                    con.close();
                }catch(Exception e2) {System.out.print(e2);}
            }
        });
        btnNewButton_4_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        btnNewButton_4_3.setBackground(new Color(135, 206, 235));
        btnNewButton_4_3.setBounds(585, 453, 295, 30);
        panel_3.add(btnNewButton_4_3);

        JButton btnNewButton_4_1_1_1 = new JButton("Ștergere serviciu");
        btnNewButton_4_1_1_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String sql1 = "DELETE FROM servicii WHERE id_servicii = " + textField_42.getText() + ";";
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=root");
                    //String sql1="insert into raport_medical"+ " values "+ "("+textField_30.getText()+","+ textField_31.getText()+",\""+ textField_32.getText()+"\",\""+textField_33.getText()+"\",\""+ textField_34.getText()+"\",\""+textField_35.getText()+"\",\""+textField_38.getText()+"\",\""+textField_39.getText()+"\" );" ;
                    PreparedStatement pst = con2.prepareStatement(sql1);

                    pst.execute(sql1);
                    JOptionPane.showMessageDialog(null,"         Ștergere cu succes !");

                    pst.close();

                    con2.close();
                    refreshTable2();
                }catch(Exception e6) {System.out.print(e6);}
            }
        });
        btnNewButton_4_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        btnNewButton_4_1_1_1.setBackground(new Color(255, 102, 102));
        btnNewButton_4_1_1_1.setBounds(23, 519, 295, 30);
        panel_3.add(btnNewButton_4_1_1_1);
    }
}
