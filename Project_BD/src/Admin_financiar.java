//package prBD;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

import net.proteanit.sql.DbUtils;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class Admin_financiar extends JFrame {
    private JTable table;
    private JTable table_2;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Admin_financiar frame = new Admin_financiar();
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

    public Admin_financiar() {
        setTitle("Policlinică");
        setIconImage(Toolkit.getDefaultToolkit().getImage("art/cross.png"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1100, 700);
        getContentPane().setBackground(new Color(253, 219, 50));
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        GroupLayout groupLayout = new GroupLayout(getContentPane());
        groupLayout.setHorizontalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGap(23)
                                .addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
                                .addContainerGap())
        );
        groupLayout.setVerticalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGap(23)
                                .addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
                                .addContainerGap())
        );

        JPanel panel = new JPanel();
        tabbedPane.addTab("Profit", null, panel, null);

        JButton btnNewButton = new JButton("Profit medici pe unitate medicală");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=root");
                    PreparedStatement s= con.prepareStatement("SELECT unitati_medicale.adresa, SUM(sumaplatita) AS venituri,\r\n"
                            + "IF(COUNT(programari.medicul), 3000 + SUM(medic.Procent_neg_servicii / 100 * sumaplatita),3000) AS cheltuieli, SUM(sumaplatita) - 3000 - SUM(medic.Procent_neg_servicii / 100 * sumaplatita) AS profit\r\n"
                            + "FROM angajat, utilizatori, istoricbonuri, medic, programari, unitati_medicale\r\n"
                            + "WHERE utilizatori.Id_ca_angajat = angajat.Id_angajat \r\n"
                            + "AND programari.medicul = medic.Id_medic \r\n"
                            + "AND medic.Id_ca_utilizator=utilizatori.id_utilizator \r\n"
                            + "AND istoricbonuri.id_de_la_programare = programari.id_programare\r\n"
                            + "AND programari.unitatea=unitati_medicale.id_unitate_medicala\r\n"
                            + "AND MONTH(programari.datapacient) = MONTH(CURRENT_DATE - INTERVAL 1 MONTH)\r\n"
                            + "GROUP BY unitati_medicale.adresa;");
                    ResultSet rez = s.executeQuery();
                    table.setModel(DbUtils.resultSetToTableModel(rez));


                    con.close();
                }catch(Exception e) {System.out.print(e);}
            }

        });
        btnNewButton.setBounds(10, 55, 354, 33);
        btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        JButton btnProfitMedici = new JButton("Profit medici");
        btnProfitMedici.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=root");
                    PreparedStatement s= con.prepareStatement("SELECT nume, prenume, SUM(sumaplatita) AS venituri, \r\n"
                            + "IF(COUNT(programari.medicul),3000 + SUM(medic.Procent_neg_servicii / 100 * sumaplatita),3000) AS cheltuieli, SUM(sumaplatita) - 3000 - SUM(medic.Procent_neg_servicii / 100 * sumaplatita) AS profit\r\n"
                            + "FROM angajat, utilizatori, istoricbonuri, medic, programari \r\n"
                            + "WHERE utilizatori.Id_ca_angajat = angajat.Id_angajat\r\n"
                            + "AND programari.medicul = medic.Id_medic \r\n"
                            + "AND medic.Id_ca_utilizator = utilizatori.id_utilizator \r\n"
                            + "AND istoricbonuri.id_de_la_programare = programari.id_programare\r\n"
                            + "AND MONTH(programari.datapacient) = MONTH(CURRENT_DATE - INTERVAL 1 MONTH)\r\n"
                            + "GROUP BY medic.id_medic;");
                    ResultSet rez= s.executeQuery();
                    table.setModel(DbUtils.resultSetToTableModel(rez));


                    con.close();
                }catch(Exception e) {System.out.print(e);}

            }
        });
        btnProfitMedici.setBounds(96, 130, 167, 33);
        btnProfitMedici.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        JButton btnInapoi = new JButton("Delogare");
        btnInapoi.setBounds(10, 440, 120, 50);
        btnInapoi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Financiar f = new Financiar();
                f.show();
                center(f);
                dispose();
            }
        });
        btnInapoi.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        panel.setLayout(null);
        panel.add(btnNewButton);
        panel.add(btnProfitMedici);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(393, 54, 407, 411);
        panel.add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);
        panel.add(btnInapoi);

        JButton btnProfitTotal = new JButton("Profit total");
        btnProfitTotal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=root");
                    PreparedStatement s = con.prepareStatement(" SELECT SUM(IF(MONTH(programari.datapacient)=MONTH(CURRENT_DATE - INTERVAL 1 MONTH),sumaplatita,0)) as venituri,\r\n"
                            + "IF(utilizatori.tip='medic' AND MONTH(programari.datapacient)=MONTH(CURRENT_DATE - INTERVAL 1 MONTH),IF(COUNT(programari.medicul),3000+SUM(medic.Procent_neg_servicii/100 * sumaplatita),3000), SUM(salar_neg*nr_ore*28)) as cheltuieli,\r\n"
                            + "SUM(IF(MONTH(programari.datapacient)=MONTH(CURRENT_DATE - INTERVAL 1 MONTH),sumaplatita,0))-IF(utilizatori.tip='medic' and MONTH(programari.datapacient)=MONTH(CURRENT_DATE - INTERVAL 1 MONTH),IF(COUNT(programari.medicul),3000+SUM(medic.Procent_neg_servicii/100 * sumaplatita),3000), SUM(salar_neg*nr_ore*28)) as profit \r\n"
                            + "FROM angajat, utilizatori, istoricbonuri,programari,medic\r\n"
                            + "WHERE utilizatori.Id_ca_angajat=angajat.Id_angajat AND\r\n"
                            + "istoricbonuri.id_de_la_programare=programari.id_programare \r\n"
                            + "AND medic.Id_ca_utilizator=utilizatori.id_utilizator\r\n"
                            + " \r\n"
                            + "AND programari.medicul=medic.id_medic;");
                    ResultSet rez= s.executeQuery();
                    table.setModel(DbUtils.resultSetToTableModel(rez));


                    con.close();
                }catch(Exception e) {System.out.print(e);}
            }
        });
        btnProfitTotal.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        btnProfitTotal.setBounds(96, 290, 167, 33);
        panel.add(btnProfitTotal);

        JButton btnProfitSpecializari = new JButton("Profit specializari");
        btnProfitSpecializari.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=root");
                    PreparedStatement s= con.prepareStatement("	SELECT specialitate, SUM(sumaplatita) AS venituri,  \r\n"
                            + "3000+SUM(medic.Procent_neg_servicii/100 * sumaplatita) AS cheltuieli, \r\n"
                            + "SUM(sumaplatita)-3000-SUM(medic.Procent_neg_servicii/100 * sumaplatita) AS profit\r\n"
                            + "FROM angajat, utilizatori, istoricbonuri,medic,programari\r\n"
                            + "WHERE utilizatori.Id_ca_angajat=angajat.Id_angajat\r\n"
                            + "AND programari.medicul=medic.Id_medic \r\n"
                            + "AND medic.Id_ca_utilizator=utilizatori.id_utilizator\r\n"
                            + "AND istoricbonuri.id_de_la_programare=programari.id_programare\r\n"
                            + "AND MONTH(programari.datapacient)=MONTH(CURRENT_DATE - INTERVAL 1 MONTH)\r\n"
                            + "GROUP BY medic.specialitate;");
                    ResultSet rez= s.executeQuery();
                    table.setModel(DbUtils.resultSetToTableModel(rez));


                    con.close();
                }catch(Exception e) {System.out.print(e);}

            }
        });
        btnProfitSpecializari.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        btnProfitSpecializari.setBounds(85, 210, 194, 33);
        panel.add(btnProfitSpecializari);

        JButton btnProfitLunar = new JButton("Profit lunar");
        btnProfitLunar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=root");
                    PreparedStatement s= con.prepareStatement("SELECT m.month, SUM(istoricbonuri.sumaplatita) as venituri,\r\n"
                            + "IF(utilizatori.tip='medic',IF(COUNT(programari.medicul),3000+SUM(medic.Procent_neg_servicii/100 * sumaplatita),3000), SUM(salar_neg*nr_ore*28)) as cheltuieli,\r\n"
                            + "SUM(sumaplatita)-IF(utilizatori.tip='medic',IF(COUNT(programari.medicul),3000+SUM(medic.Procent_neg_servicii/100 * sumaplatita),3000), SUM(salar_neg*nr_ore*28)) as profit \r\n"
                            + "FROM (\r\n"
                            + "SELECT 'January' AS MONTH UNION SELECT 'February' AS MONTH UNION SELECT 'March' AS MONTH UNION SELECT 'April' AS MONTH UNION SELECT 'May' AS\r\n"
                            + "MONTH UNION SELECT 'June' AS MONTH UNION SELECT 'July' AS MONTH UNION SELECT 'August' AS MONTH UNION SELECT 'September' AS MONTH\r\n"
                            + "UNION SELECT 'October' AS MONTH UNION SELECT 'November' AS MONTH UNION SELECT 'December' AS MONTH\r\n"
                            + ") AS m, angajat, utilizatori, istoricbonuri,programari,medic\r\n"
                            + "WHERE istoricbonuri.id_de_la_programare = programari.id_programare \r\n"
                            + "AND m.month = monthname(programari.datapacient)\r\n"
                            + "AND programari.medicul = medic.id_medic\r\n"
                            + "GROUP BY m.month;");
                    ResultSet rez= s.executeQuery();
                    table.setModel(DbUtils.resultSetToTableModel(rez));


                    con.close();
                }catch(Exception e) {System.out.print(e);}
            }
        });
        btnProfitLunar.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        btnProfitLunar.setBounds(96, 370, 167, 33);
        panel.add(btnProfitLunar);

        JPanel panel_2 = new JPanel();
        tabbedPane.addTab("Salarii", null, panel_2, null);

        JButton btnNewButton_1 = new JButton("Salarii medici");
        btnNewButton_1.setBounds(55, 44, 165, 33);
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=root");
                    PreparedStatement s= con.prepareStatement("SELECT nume,prenume, \r\n"
                            + "IF(COUNT(programari.medicul),3000+SUM(medic.Procent_neg_servicii/100 * sumaplatita),3000) as salariu \r\n"
                            + "FROM istoricbonuri,utilizatori,medic,programari \r\n"
                            + "WHERE medic.id_medic = programari.medicul \r\n"
                            + "AND programari.id_programare = istoricbonuri.id_de_la_programare \r\n"
                            + "AND utilizatori.id_utilizator = medic.Id_ca_utilizator \r\n"
                            + "AND MONTH(programari.datapacient) = MONTH(CURRENT_DATE - INTERVAL 1 MONTH)\r\n"
                            + "GROUP BY medic.id_medic;");
                    ResultSet rez= s.executeQuery();
                    table_2.setModel(DbUtils.resultSetToTableModel(rez));


                    con.close();
                }catch(Exception e) {System.out.print(e);}
            }
        });
        btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        JButton btnNewButton_1_1 = new JButton("Salarii asistenti");
        btnNewButton_1_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=root");

                    PreparedStatement s= con.prepareStatement("SELECT utilizatori.nume, utilizatori.prenume, salar_neg * nr_ore * 28 AS salariu FROM angajat, utilizatori WHERE angajat.id_angajat=utilizatori.id_ca_angajat AND utilizatori.tip = 'asistent';");
                    ResultSet rez= s.executeQuery();

                    table_2.setModel(DbUtils.resultSetToTableModel(rez));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        btnNewButton_1_1.setBounds(45, 120, 186, 33);
        btnNewButton_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        JButton btnNewButton_1_2 = new JButton("Salarii recepționeri");
        btnNewButton_1_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=root");

                    PreparedStatement s= con.prepareStatement("SELECT utilizatori.nume, utilizatori.prenume, salar_neg * nr_ore * 28 AS salariu FROM angajat, utilizatori WHERE angajat.id_angajat = utilizatori.id_ca_angajat AND utilizatori.tip = 'receptioner';");
                    ResultSet rez= s.executeQuery();

                    table_2.setModel(DbUtils.resultSetToTableModel(rez));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        btnNewButton_1_2.setBounds(35, 200, 208, 33);
        btnNewButton_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        JButton btnNewButton_1_3 = new JButton("Alte salarii");
        btnNewButton_1_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=root");

                    PreparedStatement s= con.prepareStatement("SELECT utilizatori.nume, utilizatori.prenume, salar_neg*nr_ore * 28 AS salariu, utilizatori.tip FROM angajat, utilizatori WHERE angajat.id_angajat = utilizatori.id_ca_angajat AND NOT utilizatori.tip = 'medic' AND NOT utilizatori.tip = 'receptioner' AND NOT utilizatori.tip = 'asistent';");
                    ResultSet rez= s.executeQuery();

                    table_2.setModel(DbUtils.resultSetToTableModel(rez));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        btnNewButton_1_3.setBounds(60, 280, 151, 33);
        btnNewButton_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        JButton btnInapoi_2 = new JButton("Delogare");
        btnInapoi_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Financiar f = new Financiar();
                f.show();
                center(f);
                dispose();
            }
        });
        btnInapoi_2.setBounds(20, 410, 120, 50);
        btnInapoi_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        panel_2.setLayout(null);
        panel_2.add(btnNewButton_1);
        panel_2.add(btnNewButton_1_1);
        panel_2.add(btnNewButton_1_2);
        panel_2.add(btnNewButton_1_3);
        panel_2.add(btnInapoi_2);

        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(279, 44, 346, 368);
        panel_2.add(scrollPane_1);

        table_2 = new JTable();
        scrollPane_1.setViewportView(table_2);
        getContentPane().setLayout(groupLayout);
    }
}
