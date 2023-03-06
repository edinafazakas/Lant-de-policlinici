//package prBD;
import java.awt.*;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login_admin extends JFrame {

    private JPanel contentPane;
    private JTextField user;
    private JPasswordField pass;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login_admin frame = new Login_admin();
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

    public Login_admin() {
        setTitle("Policlinica");
        setIconImage(Toolkit.getDefaultToolkit().getImage("art/cross.png"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 650, 600);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(253, 219, 50));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("AUTENTIFICARE ADMIN");
        lblNewLabel.setBounds(93, 20, 479, 88);
        lblNewLabel.setForeground(new Color(0, 51, 204));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Segoe UI Black", Font.PLAIN, 40));
        contentPane.add(lblNewLabel);

        user = new JTextField();
        user.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        user.setBounds(190, 175, 350, 43);
        contentPane.add(user);
        user.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("ID:");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        lblNewLabel_1.setBounds(110, 180, 83, 32);
        contentPane.add(lblNewLabel_1);

        pass = new JPasswordField();
        pass.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        pass.setBounds(190, 275, 350, 43);
        contentPane.add(pass);

        JLabel lblNewLabel_2 = new JLabel("Parolă:");
        lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        lblNewLabel_2.setBounds(110, 280, 114, 25);
        contentPane.add(lblNewLabel_2);

        JButton btnlogin = new JButton("Logare");
        btnlogin.setBounds(430, 470, 142, 61);
        btnlogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=root");
                    Statement stmt = con.createStatement();
                    String sql = "SELECT * FROM utilizatori WHERE tip = 'admin' AND id_utilizator = '" + user.getText() + "' AND parola = '" + pass.getText().toString()+"'";
                    ResultSet rs = stmt.executeQuery(sql);
                    if(rs.next()) {
                        Admin ad1 = new Admin();
                        ad1.show();
                        center(ad1);
                        dispose();
                        JOptionPane.showMessageDialog(null,"       Logare cu succes !");
                    }
                    else
                        JOptionPane.showMessageDialog(null,"       ID sau parolă greșită !");
                    con.close();
                }catch(Exception e) {System.out.print(e);}
            }
        });
        btnlogin.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        contentPane.add(btnlogin);

        JButton btnNewButton = new JButton("Înapoi");
        btnNewButton.setBounds(60, 470, 126, 61);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Principala p1 = new Principala();
                p1.show();
                center(p1);
                dispose();
            }
        });
        btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        contentPane.add(btnNewButton);

        /*JLabel lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setIcon(new ImageIcon("D:\\PROIECT BD\\icon.png"));
        lblNewLabel_3.setBounds(0, -14, 659, 667);
        contentPane.add(lblNewLabel_3);*/
    }
}
