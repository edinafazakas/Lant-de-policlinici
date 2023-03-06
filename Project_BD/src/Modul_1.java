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

public class Modul_1 extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Modul_1 frame = new Modul_1();
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

    public Modul_1() {
        setTitle("Policlinică");
        setIconImage(Toolkit.getDefaultToolkit().getImage("art/cross.png"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 621, 635);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(253, 219, 50));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JButton btnNewButton = new JButton("Administrator resurse umane");
        btnNewButton.setBounds(125, 162, 370, 60);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Login_resurse lru = new Login_resurse();
                lru.show();
                center(lru);
                dispose();
            }
        });
        contentPane.setLayout(null);
        btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 28));
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Angajat*");
        btnNewButton_1.setBounds(125, 362, 370, 60);
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Angajat lr1 = new Angajat();
                lr1.show();
                center(lr1);
                dispose();
            }
        });
        btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        contentPane.add(btnNewButton_1);

        JButton btnEconomic = new JButton("Administrator economic");
        btnEconomic.setBounds(125, 262, 370, 60);
        btnEconomic.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Login_economic le = new Login_economic();
                le.show();
                center(le);
                dispose();
            }
        });
        btnEconomic.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        contentPane.add(btnEconomic);

        JLabel lblNewLabel = new JLabel("LOGARE CA:");
        lblNewLabel.setBounds(102, -10, 411, 106);
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setForeground(new Color(0, 51, 204));
        lblNewLabel.setFont(new Font("Segoe UI Black", Font.PLAIN, 50));
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("*Angajat al unității medicale: recepționer, medic, asistent");
        lblNewLabel_1.setBounds(32, 556, 470, 20);
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        contentPane.add(lblNewLabel_1);

        /*JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon("D:\\PROIECT BD\\giphy (1).gif"));
        lblNewLabel_2.setBounds(0, -11, 686, 617);
        contentPane.add(lblNewLabel_2);*/

        JButton btnNewButton_2 = new JButton("Înapoi");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Principala vpr = new Principala();
                vpr.show();
                center(vpr);
                dispose();
            }
        });
        //btnNewButton_2.setForeground(Color.RED);
        //btnNewButton_2.setBackground(Color.LIGHT_GRAY);
        btnNewButton_2.setBounds(480, 520, 100, 60);
        btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        contentPane.add(btnNewButton_2);
    }
}
