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

public class Modul_3 extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Modul_3 frame = new Modul_3();
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

    public Modul_3() {
        setTitle("Policlinică");
        setIconImage(Toolkit.getDefaultToolkit().getImage("art/cross.png"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 656,600);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(253, 219, 50));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnNewButton = new JButton("Recepționer");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Login_receptioner lr3 = new Login_receptioner();
                lr3.show();
                center(lr3);
                dispose();
            }
        });
        btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        btnNewButton.setBounds(126, 172, 386, 50);
        contentPane.add(btnNewButton);

        JButton btnMedic = new JButton("Medic");
        btnMedic.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Login_medic lm3 = new Login_medic();
                lm3.show();
                center(lm3);
                dispose();
            }
        });
        btnMedic.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        btnMedic.setBounds(126, 250, 386, 50);
        contentPane.add(btnMedic);

        JButton btnAsistentMedical = new JButton("Asistent medical");
        btnAsistentMedical.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Login_asistent la3=new Login_asistent();
                la3.show();
                center(la3);
                dispose();
            }
        });
        btnAsistentMedical.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        btnAsistentMedical.setBounds(126, 330, 386, 50);
        contentPane.add(btnAsistentMedical);

        JLabel lblNewLabel = new JLabel("LOGARE CA:");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setForeground(new Color(0, 51, 204));
        lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 50));
        lblNewLabel.setBounds(67, 10, 516, 86);
        contentPane.add(lblNewLabel);

        /*JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("D:\\PROIECT BD\\giphy (1).gif"));
        lblNewLabel_1.setBounds(0, -13, 676, 651);
        contentPane.add(lblNewLabel_1);*/

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
        btnNewButton_1.setBounds(40, 470, 120, 60);
        btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        contentPane.add(btnNewButton_1);
    }
}

