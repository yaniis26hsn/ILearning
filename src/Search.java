import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
    DefaultTableModel model;

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

        model = new DefaultTableModel();
        model.addColumn("Id");
        model.addColumn("prenom");
        model.addColumn("nom");
        model.addColumn("Age");
        model.addColumn("Filliare");
        model.addColumn("niveau");
        model.addColumn("sexe");
        model.addColumn("jour de naissance");

        table = new JTable(model);
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

        b1.addActionListener(e -> search());

        b2.addActionListener(e -> {
            cb1.setSelectedIndex(0);
            cb2.setSelectedIndex(0);
            model.setRowCount(0);
        });

        b3.addActionListener(e -> {
            dispose();
            new StudentManger().setVisible(true);
        });

        // You can still change the query inside search()
    }

    public void search() {
        String specialty = cb1.getSelectedItem().toString();
        String level = cb2.getSelectedItem().toString();

        try {
            Connection mycn = Connect.getConnection();

            if (mycn == null) {
                System.out.println("connection failed");
                return;
            }

            PreparedStatement ps = mycn.prepareStatement(
                    "select * from students where specialty = ? and level = ?");
            ps.setString(1, specialty);
            ps.setString(2, level);

            ResultSet rs = ps.executeQuery();

            model.setRowCount(0);

            while (rs.next()) {
                String id = rs.getString("id");
                String lname = rs.getString("lname");
                String fname = rs.getString("fname");
                int age = rs.getInt("age");
                String spec = rs.getString("specialty");
                String lev = rs.getString("level");
                String gender = rs.getString("gender");
                String birthday = rs.getString("birthday");

                model.addRow(new Object[] { id, lname, fname, age, spec, lev, gender, birthday });
            }

            if (model.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "Aucun etudiant trouve.");
            }

            rs.close();
            ps.close();
            mycn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
