//package prBD;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class Principala extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Principala frame = new Principala();
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

    public Principala() {
        setFont(new Font("Times New Roman", Font.PLAIN, 11));
        setForeground(Color.BLUE);
        setIconImage(Toolkit.getDefaultToolkit().getImage("art/cross.png"));
        setAlwaysOnTop(true);
        setTitle("Policlinică");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 654, 678);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(253, 219, 50));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnNewButton = new JButton("Gestiunea resurselor umane");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Modul_1 m1 = new Modul_1();
                m1.show();
                center(m1);
                dispose();
            }
        });
        btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        btnNewButton.setBounds(156, 117, 347, 51);
        contentPane.add(btnNewButton);

        JButton btnModul = new JButton("Operații financiar contabile  ");
        btnModul.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Financiar m2 = new Financiar();
                m2.show();
                center(m2);
                dispose();
            }
        });
        btnModul.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        btnModul.setBounds(156, 212, 347, 51);
        contentPane.add(btnModul);

        JButton btnModul_1 = new JButton("Gestiunea activităților operaționale");
        btnModul_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Modul_3 m3 = new Modul_3();
                m3.show();
                center(m3);
                dispose();
            }
        });
        btnModul_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        btnModul_1.setBounds(156, 307, 347, 51);
        contentPane.add(btnModul_1);

        JButton btnAdministrator = new JButton("Administrator");
        btnAdministrator.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Login_admin l4 = new Login_admin();
                l4.show();
                center(l4);
                dispose();
            }
        });
        btnAdministrator.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        btnAdministrator.setBounds(156, 409, 347, 51);
        contentPane.add(btnAdministrator);

        JButton btnSuperAdministrator = new JButton("Super Administrator");
        btnSuperAdministrator.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Login_superadmin l5 = new Login_superadmin();
                l5.show();
                center(l5);
                dispose();
            }

        });
        btnSuperAdministrator.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        btnSuperAdministrator.setBounds(156, 507, 347, 51);
        contentPane.add(btnSuperAdministrator);
        JButton btnNewButton_1 = new JButton("");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Vaccin vac = new Vaccin();
                vac.show();
                center(vac);
                dispose();
            }
        });
        btnNewButton_1.setIcon(new ImageIcon("art/vaccine.png"));
        btnNewButton_1.setBounds(536, 540, 80, 80);
        contentPane.add(btnNewButton_1);
        JLabel lblNewLabel = new JLabel("POLICLINICĂ");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Segoe UI Black", Font.PLAIN, 55));
        lblNewLabel.setForeground(new Color(0, 102, 153));
        lblNewLabel.setBounds(111, 10, 445, 97);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("art/background.png"));
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setBounds(0, 0, 660, 641);
        contentPane.add(lblNewLabel_1);
    }
}
