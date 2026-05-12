import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class StudentManger extends JFrame {
    JLabel l1;
    JLabel l2;
    JLabel l3;
    JLabel l4;
    JLabel l5;
    JLabel l6;
    JLabel l7;

    JTextField t1;
    JTextField t2;
    JTextField t3;
    JTextField t4;
    JTextField t5;
    JTextField t6;
    JTextField t7;

    JButton b1;
    JButton b2;
    JButton b3;
    JButton b4;
    JButton b5;

    JTable table;
    JScrollPane sp;

    public StudentManger() {
        setTitle("Student Manager");
        setSize(800, 500);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        l1 = new JLabel("Id");
        l1.setBounds(30, 30, 100, 30);

        l2 = new JLabel("Age");
        l2.setBounds(30, 70, 100, 30);

        l3 = new JLabel("First Name");
        l3.setBounds(30, 110, 100, 30);

        l4 = new JLabel("Last Name");
        l4.setBounds(30, 150, 100, 30);

        l5 = new JLabel("Level");
        l5.setBounds(30, 190, 100, 30);

        l6 = new JLabel("Gender");
        l6.setBounds(30, 230, 100, 30);

        l7 = new JLabel("Birthday");
        l7.setBounds(30, 270, 100, 30);

        t1 = new JTextField();
        t1.setBounds(140, 30, 150, 30);

        t2 = new JTextField();
        t2.setBounds(140, 70, 150, 30);

        t3 = new JTextField();
        t3.setBounds(140, 110, 150, 30);

        t4 = new JTextField();
        t4.setBounds(140, 150, 150, 30);

        t5 = new JTextField();
        t5.setBounds(140, 190, 150, 30);

        t6 = new JTextField();
        t6.setBounds(140, 230, 150, 30);

        t7 = new JTextField();
        t7.setBounds(140, 270, 150, 30);

        b1 = new JButton("Add");
        b1.setBounds(30, 330, 100, 30);

        b2 = new JButton("Update");
        b2.setBounds(140, 330, 100, 30);

        b3 = new JButton("Delete");
        b3.setBounds(250, 330, 100, 30);

        b4 = new JButton("Clear");
        b4.setBounds(360, 330, 100, 30);

        b5 = new JButton("Chercher");
        b5.setBounds(470, 330, 120, 30);

        table = new JTable();
        sp = new JScrollPane(table);
        sp.setBounds(330, 30, 430, 260);

        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(l5);
        add(l6);
        add(l7);

        add(t1);
        add(t2);
        add(t3);
        add(t4);
        add(t5);
        add(t6);
        add(t7);

        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
        add(sp);

        // Add your action listeners here
        // b1.addActionListener(...)
        // b2.addActionListener(...)
        // b3.addActionListener(...)
        // b4.addActionListener(...)
        b5.addActionListener(e -> {
            dispose();
            new Search().setVisible(true);
        });
    }
}
