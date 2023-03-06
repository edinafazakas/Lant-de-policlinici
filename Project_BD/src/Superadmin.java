//package prBD;
import java.awt.*;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Superadmin extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JTable table;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    private JTextField textField_7;
    private JTextField textField_8;
    private JTextField textField_9;
    private JTextField textField_10;
    private JTextField textField_11;
    private JTextField textField_12;
    private JTextField textField_13;
    private JTextField textField_14;
    private JLabel lblNewLabel;
    private JLabel lblTip;
    private JLabel lblParola;
    private JLabel lblCnp;
    private JLabel lblNewLabel_1;
    private JLabel lblPrenume;
    private JLabel lblAdresa;
    private JLabel lblNrtelefon;
    private JLabel lblDataAngajarii;
    private JLabel lblMail;
    private JLabel lblCont;
    private JLabel lblNrContract;
    private JLabel lblFunctie;
    private JLabel lblRol;
    private JLabel lblIdCaAngajat;
    private JButton btnInsert;
    private JButton btnUpdateTabel;
    private JButton btnStergereDinTabel;
    private JComboBox comboBoxId;
    private JTextField textFieldSearch;
    private JLabel lblNewLabel_3;
    private JButton btnDelogare;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Superadmin frame = new Superadmin();
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

    public void fillComboBox() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=root");
            String sql = "SELECT * FROM utilizatori ";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery(sql);
            while(rs.next()) {
                comboBoxId.addItem(rs.getString("Id_utilizator"));//+" "+rs.getString("Nume")+" "+rs.getString("Prenume"));
            }

            con.close();

        }catch(Exception e2) {System.out.print(e2);}
    }
    public void refreshTable() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=root");
            String sql = "SELECT * FROM utilizatori ";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery(sql);
            table.setModel(DbUtils.resultSetToTableModel(rs));
            con.close();
			/*ResultSet rs=stmt.executeQuery(sql);
			if(rs.next()) {
				//JOptionPane.showMessageDialog(null,"     Successfully ");
				modul3_2 fr1 = new modul3_2();
				fr1.show();
				dispose();
			}
			else
				JOptionPane.showMessageDialog(null,"       ID sau parolă greșită !");
			con.close();*/
        }catch(Exception e2) {System.out.print(e2);}
    }
    /**
     * Create the frame.
     */
    public Superadmin() {
        setTitle("Policlinică");
        setIconImage(Toolkit.getDefaultToolkit().getImage("art/cross.png"));
        //Statement stmt=con.createStatement();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1200, 800);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(253, 219, 50));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnLoadTable = new JButton("Vizualizare Utilizatori");
        btnLoadTable.setBackground(new Color(135, 206, 235));
        btnLoadTable.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        btnLoadTable.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e1) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=root");
                    String sql = "SELECT * FROM utilizatori ";
                    Statement pst = con.prepareStatement(sql);
                    ResultSet rs = pst.executeQuery(sql);
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                    con.close();
					/*ResultSet rs=stmt.executeQuery(sql);
					if(rs.next()) {
						//JOptionPane.showMessageDialog(null,"     Successfully ");
						modul3_2 fr1=new modul3_2();
						fr1.show();
						dispose();
					}
					else
						JOptionPane.showMessageDialog(null,"       ID sau parolă greșită ! ");
					con.close();*/
                }catch(Exception e2) {System.out.print(e2);}

            }
        });
        btnLoadTable.setBounds(436, 29, 612, 38);
        contentPane.add(btnLoadTable);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(372, 162, 748, 419);
        contentPane.add(scrollPane);

        table = new JTable();
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=root");
                    int row = table.getSelectedRow();
                    String idul = (table.getModel().getValueAt(row,0)).toString();
                    String sql1 = "SELECT * FROM utilizatori WHERE id_utilizator = '" + idul + "'";
                    PreparedStatement pst = con2.prepareStatement(sql1);

                    ResultSet rs = pst.executeQuery();
                    while(rs.next()) {
                        textField.setText(rs.getString("id_utilizator"));
                        textField_1.setText(rs.getString("tip"));
                        textField_2.setText(rs.getString("parola"));
                        textField_3.setText(rs.getString("CNP"));
                        textField_4.setText(rs.getString("nume"));
                        textField_5.setText(rs.getString("prenume"));
                        textField_6.setText(rs.getString("adresa"));
                        textField_7.setText(rs.getString("nr_telefon"));
                        textField_8.setText(rs.getString("mail"));
                        textField_9.setText(rs.getString("cont"));
                        textField_10.setText(rs.getString("nr_contract"));
                        textField_11.setText(rs.getString("data_angajarii"));
                        textField_12.setText(rs.getString("functie"));
                        textField_13.setText(rs.getString("rol"));
                        textField_14.setText(rs.getString("id_ca_angajat"));
                    }
                    //JOptionPane.showMessageDialog(null,"      Successfully ");

                    pst.close();
                    con2.close();
                }catch(Exception e6) {System.out.print(e6);}
            }
        });
        scrollPane.setViewportView(table);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(124, 74, 192, 29);
        contentPane.add(textField_1);

        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(124, 113, 192, 29);
        contentPane.add(textField_2);

        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(124, 152, 192, 29);
        contentPane.add(textField_3);

        textField_4 = new JTextField();
        textField_4.setColumns(10);
        textField_4.setBounds(124, 191, 192, 29);
        contentPane.add(textField_4);

        textField_5 = new JTextField();
        textField_5.setColumns(10);
        textField_5.setBounds(124, 230, 192, 29);
        contentPane.add(textField_5);

        textField_6 = new JTextField();
        textField_6.setColumns(10);
        textField_6.setBounds(124, 277, 192, 29);
        contentPane.add(textField_6);

        textField_7 = new JTextField();
        textField_7.setColumns(10);
        textField_7.setBounds(124, 318, 192, 29);
        contentPane.add(textField_7);

        textField_8 = new JTextField();
        textField_8.setColumns(10);
        textField_8.setBounds(124, 355, 192, 29);
        contentPane.add(textField_8);

        textField_9 = new JTextField();
        textField_9.setColumns(10);
        textField_9.setBounds(124, 400, 192, 29);
        contentPane.add(textField_9);

        textField_10 = new JTextField();
        textField_10.setColumns(10);
        textField_10.setBounds(124, 439, 192, 29);
        contentPane.add(textField_10);

        textField_11 = new JTextField();
        textField_11.setColumns(10);
        textField_11.setBounds(124, 478, 192, 29);
        contentPane.add(textField_11);

        textField_12 = new JTextField();
        textField_12.setColumns(10);
        textField_12.setBounds(124, 517, 192, 29);
        contentPane.add(textField_12);

        textField_13 = new JTextField();
        textField_13.setColumns(10);
        textField_13.setBounds(124, 560, 192, 29);
        contentPane.add(textField_13);

        textField_14 = new JTextField();
        textField_14.setColumns(10);
        textField_14.setBounds(124, 599, 192, 29);
        contentPane.add(textField_14);

        textField = new JTextField();
        textField.setBounds(124, 33, 192, 29);
        contentPane.add(textField);
        textField.setColumns(10);

        lblNewLabel = new JLabel("ID utilizator:");
        lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNewLabel.setBounds(10, 37, 104, 21);
        contentPane.add(lblNewLabel);

        lblTip = new JLabel("Tip:");
        lblTip.setHorizontalAlignment(SwingConstants.RIGHT);
        lblTip.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblTip.setBounds(10, 82, 104, 21);
        contentPane.add(lblTip);

        lblParola = new JLabel("Parolă:");
        lblParola.setHorizontalAlignment(SwingConstants.RIGHT);
        lblParola.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblParola.setBounds(10, 121, 104, 21);
        contentPane.add(lblParola);

        lblCnp = new JLabel("CNP:");
        lblCnp.setHorizontalAlignment(SwingConstants.RIGHT);
        lblCnp.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblCnp.setBounds(10, 160, 104, 21);
        contentPane.add(lblCnp);

        lblNewLabel_1 = new JLabel("Nume:");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNewLabel_1.setBounds(10, 199, 104, 21);
        contentPane.add(lblNewLabel_1);

        lblPrenume = new JLabel("Prenume:");
        lblPrenume.setHorizontalAlignment(SwingConstants.RIGHT);
        lblPrenume.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblPrenume.setBounds(10, 237, 104, 21);
        contentPane.add(lblPrenume);

        lblAdresa = new JLabel("Adresă:");
        lblAdresa.setHorizontalAlignment(SwingConstants.RIGHT);
        lblAdresa.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblAdresa.setBounds(10, 279, 104, 21);
        contentPane.add(lblAdresa);

        lblNrtelefon = new JLabel("Nr. telefon:");
        lblNrtelefon.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNrtelefon.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNrtelefon.setBounds(10, 320, 104, 21);
        contentPane.add(lblNrtelefon);

        lblDataAngajarii = new JLabel("Data angajării:");
        lblDataAngajarii.setHorizontalAlignment(SwingConstants.RIGHT);
        lblDataAngajarii.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lblDataAngajarii.setBounds(-5, 480, 120, 21);
        contentPane.add(lblDataAngajarii);

        lblMail = new JLabel("E-mail:");
        lblMail.setHorizontalAlignment(SwingConstants.RIGHT);
        lblMail.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblMail.setBounds(10, 359, 104, 21);
        contentPane.add(lblMail);

        lblCont = new JLabel("Cont IBAN:");
        lblCont.setHorizontalAlignment(SwingConstants.RIGHT);
        lblCont.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblCont.setBounds(10, 402, 104, 21);
        contentPane.add(lblCont);

        lblNrContract = new JLabel("Nr. contract:");
        lblNrContract.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNrContract.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNrContract.setBounds(10, 443, 104, 21);
        contentPane.add(lblNrContract);

        lblFunctie = new JLabel("Funcție:");
        lblFunctie.setHorizontalAlignment(SwingConstants.RIGHT);
        lblFunctie.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblFunctie.setBounds(10, 521, 104, 21);
        contentPane.add(lblFunctie);

        lblRol = new JLabel("Rol:");
        lblRol.setHorizontalAlignment(SwingConstants.RIGHT);
        lblRol.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblRol.setBounds(10, 562, 104, 21);
        contentPane.add(lblRol);

        lblIdCaAngajat = new JLabel("ID ca angajat:");
        lblIdCaAngajat.setHorizontalAlignment(SwingConstants.RIGHT);
        lblIdCaAngajat.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lblIdCaAngajat.setBounds(10, 601, 104, 21);
        contentPane.add(lblIdCaAngajat);

        btnInsert = new JButton("Inserare în tabel");
        btnInsert.setBackground(new Color(124, 252, 0));
        btnInsert.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e4) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=root");
                    //String sql1="insert into utilizatori(id_utilizator,tip,parola,CNP,nume,prenume,adresa,nr_telefon,mail,cont,nr_contract,data_angajarii,functie,rol,id_ca_angajat)"+ "values "+ "("+textField.getText()+",\""+ textField_1.getText()+"\",\""+ textField_2.getText()+"\","+textField_3.getText()+",\""+ textField_4.getText()+"\",\""+ textField_5.getText()+"\",\""+ textField_6.getText()+"\",\""+ textField_7.getText()+"\",\""+ textField_8.getText()+"\",\""+ textField_9.getText()+"\","+ textField_10.getText()+",\""+ textField_11.getText()+"\",\""+ textField_12.getText()+"\",\""+ textField_13.getText()+"\","+ textField_14.getText()+"); ";

                    String sql1 = "INSERT INTO utilizatori(id_utilizator, tip, parola, CNP, nume, prenume, adresa, nr_telefon, mail, cont, nr_contract, data_angajarii, functie, rol,id_ca_angajat)" + "VALUES" + "(" + textField.getText() + ",\"" + textField_1.getText() + "\",\"" + textField_2.getText() + "\"," + textField_3.getText() + ",\"" + textField_4.getText() + "\",\"" + textField_5.getText() + "\",\"" + textField_6.getText() + "\",\"" + textField_7.getText() + "\",\"" + textField_8.getText() + "\",\"" + textField_9.getText() + "\"," + textField_10.getText() + ",'" + textField_11.getText() + "',\"" + textField_12.getText() + "\",\"" + textField_13.getText() + "\"," + textField_14.getText() + " );" ;
                    // +"\","+textField_3.getText()+",\""+ textField_4.getText()+"\",\""+ textField_5.getText()+"\",\""+ textField_6.getText()+"\",\""+ textField_7.getText()+"\",\""+ textField_8.getText()+"\",\""+ textField_9.getText()+"\","+ textField_10.getText()+",\""+ textField_11.getText()+"\",\""+ textField_12.getText()+"\",\""+ textField_13.getText()+"\","+ textField_14.getText()+"); ";

                    PreparedStatement pst = con2.prepareStatement(sql1);

                    pst.execute(sql1);
                    JOptionPane.showMessageDialog(null,"         Inserare cu succes !");

                    pst.close();

                    con2.close();
                }catch(Exception e3) {System.out.print(e4);}
                refreshTable();
            }
        });
        btnInsert.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        btnInsert.setBounds(436, 83, 192, 38);
        contentPane.add(btnInsert);

        btnUpdateTabel = new JButton("Update tabel");
        btnUpdateTabel.setBackground(new Color(218, 112, 214));
        btnUpdateTabel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=root");
                    //String sql1="insert into utilizatori(id_utilizator,tip,parola,CNP,nume,prenume,		adresa,nr_telefon,mail,cont,nr_contract,data_angajarii,functie,rol,id_ca_angajat) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?); ";

                    String sql1 = "UPDATE utilizatori SET id_utilizator = " + textField.getText() + ",tip = \"" + textField_1.getText() + "\",parola = \"" + textField_2.getText() + "\",CNP = " + textField_3.getText() + ",nume = \"" + textField_4.getText() + "\",prenume = \"" + textField_5.getText() + "\",adresa = \""+ textField_6.getText() + "\",nr_telefon = \"" + textField_7.getText() + "\",mail = \"" + textField_8.getText() + "\",cont = \"" + textField_9.getText() + "\",nr_contract = " + textField_10.getText() + ",data_angajarii = '" + textField_11.getText() + "',functie = \"" + textField_12.getText() + "\",rol = \"" + textField_13.getText() + "\",id_ca_angajat = " + textField_14.getText() + "  WHERE id_utilizator = " + textField.getText() + ";";

                    PreparedStatement pst = con2.prepareStatement(sql1);

                    pst.execute(sql1);
                    JOptionPane.showMessageDialog(null,"         Modificare cu succes !");

                    pst.close();

                    con2.close();
                }catch(Exception e6) {System.out.print(e6);}
                refreshTable();
            }
        });
        btnUpdateTabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        btnUpdateTabel.setBounds(645, 83, 192, 38);
        contentPane.add(btnUpdateTabel);

        btnStergereDinTabel = new JButton("Ștergere din tabel");
        btnStergereDinTabel.setBackground(new Color(250, 128, 114));
        btnStergereDinTabel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=root");
                    //String sql1="insert into utilizatori(id_utilizator,tip,parola,CNP,nume,prenume,adresa,nr_telefon,mail,cont,nr_contract,data_angajarii,functie,rol,id_ca_angajat) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?); ";

                    String sql1 = "DELETE FROM utilizatori WHERE id_utilizator = " + textField.getText() + ";";

                    PreparedStatement pst = con2.prepareStatement(sql1);

                    pst.execute(sql1);
                    JOptionPane.showMessageDialog(null,"         Ștergere cu succes !");

                    pst.close();
                    con2.close();
                }catch(Exception e6) {System.out.print(e6);}
                refreshTable();
            }
        });
        btnStergereDinTabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        btnStergereDinTabel.setBounds(856, 83, 192, 38);
        contentPane.add(btnStergereDinTabel);

        comboBoxId = new JComboBox();
        comboBoxId.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        comboBoxId.setBounds(540, 590, 192, 38);
        contentPane.add(comboBoxId);

        JLabel lblNewLabel_2 = new JLabel("Căutare după ID:");
        lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNewLabel_2.setBounds(394, 597, 150, 29);
        contentPane.add(lblNewLabel_2);

        JButton btnCautare = new JButton("Căutare");
        btnCautare.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=root");
                    //String sql1="insert into utilizatori(id_utilizator,tip,parola,CNP,nume,prenume,adresa,nr_telefon,mail,cont,nr_contract,data_angajarii,functie,rol,id_ca_angajat) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?); ";
                    String sql1 = "SELECT * FROM utilizatori WHERE id_utilizator = ?";
                    PreparedStatement pst = con2.prepareStatement(sql1);
                    pst.setString(1, (String)comboBoxId.getSelectedItem());
                    ResultSet rs = pst.executeQuery();
                    while(rs.next()) {
                        textField.setText(rs.getString("id_utilizator"));
                        textField_1.setText(rs.getString("tip"));
                        textField_2.setText(rs.getString("parola"));
                        textField_3.setText(rs.getString("CNP"));
                        textField_4.setText(rs.getString("nume"));
                        textField_5.setText(rs.getString("prenume"));
                        textField_6.setText(rs.getString("adresa"));
                        textField_7.setText(rs.getString("nr_telefon"));
                        textField_8.setText(rs.getString("mail"));
                        textField_9.setText(rs.getString("cont"));
                        textField_10.setText(rs.getString("nr_contract"));
                        textField_11.setText(rs.getString("data_angajarii"));
                        textField_12.setText(rs.getString("functie"));
                        textField_13.setText(rs.getString("rol"));
                    }
                    //JOptionPane.showMessageDialog(null,"      Successfully ");

                    pst.close();
                    con2.close();
                }catch(Exception e6) {System.out.print(e6);}
            }
        });
        btnCautare.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        btnCautare.setBounds(570, 638, 120, 29);
        contentPane.add(btnCautare);

        textFieldSearch = new JTextField();
        textFieldSearch.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=root");
                    //String sql1="insert into utilizatori(id_utilizator,tip,parola,CNP,nume,prenume,adresa,nr_telefon,mail,cont,nr_contract,data_angajarii,functie,rol,id_ca_angajat) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?); ";
                    String sql1 = "SELECT * FROM utilizatori WHERE nume = ?";
                    PreparedStatement pst = con2.prepareStatement(sql1);
                    pst.setString(1, textFieldSearch.getText());
                    ResultSet rs = pst.executeQuery();
                    table.setModel(DbUtils.resultSetToTableModel(rs));

                    //JOptionPane.showMessageDialog(null,"      Successfully ");

                    pst.close();
                    con2.close();
                }catch(Exception e6) {System.out.print(e6);}
            }
        });
        textFieldSearch.setBounds(950, 591, 173, 38);
        contentPane.add(textFieldSearch);
        textFieldSearch.setColumns(10);

        lblNewLabel_3 = new JLabel("Căutare după nume:");
        lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNewLabel_3.setBounds(778, 603, 180, 25);
        contentPane.add(lblNewLabel_3);

        btnDelogare = new JButton("Delogare");
        btnDelogare.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Login_superadmin back = new Login_superadmin();
                back.show();
                center(back);
                dispose();
            }
        });

        btnDelogare.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        btnDelogare.setBounds(1059, 700, 117, 50);
        contentPane.add(btnDelogare);
        fillComboBox();
    }
}
