//package prBD;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Login_financiar extends JFrame {

    private JPanel contentPane;
    private JTextField user;
    private JPasswordField parola;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login_financiar frame = new Login_financiar();
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

    public Login_financiar() {
        setTitle("Policlinică");
        setIconImage(Toolkit.getDefaultToolkit().getImage("art/cross.png"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(new Color(253, 219, 50));
        setContentPane(contentPane);

        user = new JTextField();
        user.setBounds(170, 175, 350, 43);
        user.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        user.setColumns(10);

        parola = new JPasswordField();
        parola.setBounds(170, 275, 350, 43);
        parola.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        JLabel lblNewLabel = new JLabel("ID: ");
        lblNewLabel.setBounds(90, 180, 83, 32);
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));

        JLabel lblParola = new JLabel("Parolă: ");
        lblParola.setBounds(90, 280, 114, 25);
        lblParola.setFont(new Font("Times New Roman", Font.PLAIN, 25));

        JLabel lblNewLabel_1 = new JLabel("Administrator financiar");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setForeground(new Color(0, 51, 204));
        lblNewLabel_1.setBounds(50, 10, 500, 51);
        lblNewLabel_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 40));

        JButton btnNewButton = new JButton("Logare");
        btnNewButton.setBounds(380, 460, 120, 60);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/Policlinica?serverTimezone=UTC&user=root&password=root");
                    Statement stmt = con.createStatement();
                    String sql = "SELECT * FROM utilizatori WHERE id_utilizator='" + user.getText() + "' AND parola = '" + parola.getText().toString() + "'AND tip = 'economic';";
                    ResultSet rs = stmt.executeQuery(sql);
                    if (rs.next()) {
                        Admin_financiar f = new Admin_financiar();
                        f.show();
                        center(f);
                        dispose();
                        JOptionPane.showMessageDialog(null, "       Logare cu succes !");

                    } else
                        JOptionPane.showMessageDialog(null, "       ID sau parolă greșită! ");
                    con.close();
                } catch (Exception e) {
                    System.out.print(e);
                }

            }
        });
        btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        JButton btnNewButton_1 = new JButton("Înapoi");
        btnNewButton_1.setBounds(70, 460, 120, 60);
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Financiar f = new Financiar();
                f.show();
                center(f);
                dispose();
            }
        });
        btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        contentPane.setLayout(null);
        contentPane.add(lblNewLabel);
        contentPane.add(lblParola);
        contentPane.add(parola);
        contentPane.add(user);
        contentPane.add(lblNewLabel_1);
        contentPane.add(btnNewButton);
        contentPane.add(btnNewButton_1);

        /*JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon("D:\\PROIECT BD\\icon.png"));
        lblNewLabel_2.setBounds(0, 0, 600, 532);
        contentPane.add(lblNewLabel_2);*/
    }

}
