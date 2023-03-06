//package prBD;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Financiar extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Financiar frame = new Financiar();
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

    public Financiar() {
        setTitle("Policlinică");
        setIconImage(Toolkit.getDefaultToolkit().getImage("art/cross.png"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 600);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(253, 219, 50));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JButton btnNewButton = new JButton("Administrator financiar");
        btnNewButton.setBounds(117, 157, 361, 55);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Login_financiar f = new Login_financiar();
                f.show();
                center(f);
                dispose();
            }
        });
        btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 30));

        JButton btnNewButton_1 = new JButton("Salarii");
        btnNewButton_1.setBounds(210, 250, 160, 55);
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Salariu f = new Salariu();
                f.show();
                center(f);
                dispose();
            }
        });
        btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 30));

        JLabel lblNewLabel = new JLabel("OPERAȚII FINANCIAR CONTABILE");
        lblNewLabel.setForeground(new Color(0, 51, 204));
        lblNewLabel.setBounds(20, 30, 550, 43);
        lblNewLabel.setFont(new Font("Segoe UI Black", Font.PLAIN, 33));

        JButton btnNewButton_2 = new JButton("Înapoi");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Principala finp = new Principala();
                finp.show();
                center(finp);
                dispose();
            }
        });
        btnNewButton_2.setBounds(50, 460, 120, 60);
        btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        contentPane.setLayout(null);
        contentPane.add(btnNewButton_1);
        contentPane.add(btnNewButton);
        contentPane.add(lblNewLabel);
        contentPane.add(btnNewButton_2);

        /*JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("D:\\PROIECT BD\\icon.png"));
        lblNewLabel_1.setBounds(-14, 0, 614, 531);
        contentPane.add(lblNewLabel_1);*/
    }
}
