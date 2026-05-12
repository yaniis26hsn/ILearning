import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Search extends JFrame {
    JLabel l1;
    JLabel l2;
    JLabel l3;

    JComboBox<String> cb1;
    JComboBox<String> cb2;

    JButton b1;
    JButton b2;
    JButton b3;

    JTable table;
    JScrollPane sp;

    public Search() {
        setTitle("Search");
        setSize(1000, 550);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        l1 = new JLabel("Recherche");
        l1.setBounds(170, 30, 100, 30);

        l2 = new JLabel("Filiere");
        l2.setBounds(40, 100, 100, 30);

        l3 = new JLabel("Niveau");
        l3.setBounds(40, 160, 100, 30);

        cb1 = new JComboBox<>();
        cb1.setBounds(140, 100, 180, 30);
        cb1.addItem("Informatique");
        cb1.addItem("Math");
        cb1.addItem("Physique");
        cb1.addItem("Chimie");
        cb1.addItem("RO");

        cb2 = new JComboBox<>();
        cb2.setBounds(140, 160, 180, 30);
        cb2.addItem("Licence");
        cb2.addItem("Master");

        b1 = new JButton("Chercher");
        b1.setBounds(40, 250, 100, 30);

        b2 = new JButton("Clear");
        b2.setBounds(150, 250, 100, 30);

        b3 = new JButton("Retour");
        b3.setBounds(260, 250, 100, 30);

        table = new JTable();
        sp = new JScrollPane(table);
        sp.setBounds(400, 50, 560, 400);

        add(l1);
        add(l2);
        add(l3);

        add(cb1);
        add(cb2);

        add(b1);
        add(b2);
        add(b3);
        add(sp);

        b2.addActionListener(e -> {
            cb1.setSelectedIndex(0);
            cb2.setSelectedIndex(0);
        });

        b3.addActionListener(e -> {
            dispose();
            new StudentManger().setVisible(true);
        });

        
        String filiere = cb1.getSelectedItem().toString();
        String niveau = cb2.getSelectedItem().toString();
        Connection cn = Connect.getConnection();
        // PreparedStatement ps = cn.prepareStatement(...);
        // ResultSet rs = ps.executeQuery();
        // Fill the table with id, lname, fname, age, ...
        // b1.addActionListener(...)
    }
}
