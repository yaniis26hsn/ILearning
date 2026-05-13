import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.sql.* ;

public class StudentManger extends JFrame {
    JLabel l1;
    JLabel l2;
    JLabel l3;
    JLabel l4;
    JLabel l5;
    JLabel l6;
    JLabel l7;
    JLabel l8;

    JTextField t1;
    JTextField t2;
    JTextField t3;
    JTextField t4;
    JTextField t7;

    JComboBox<String> cb1;
    JComboBox<String> cb2;

    JRadioButton r1;
    JRadioButton r2;
    ButtonGroup bg;

    JButton b1;
    JButton b2;
    JButton b3;
    JButton b4;
    JButton b5;
    JButton b6;

    JTable table;
    JScrollPane sp;
    DefaultTableModel model;

    public StudentManger() {
        setTitle("Gestion des etudiants");
        setSize(1030, 550);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        l1 = new JLabel("Id");
        l1.setBounds(30, 30, 100, 30);

        l2 = new JLabel("Age");
        l2.setBounds(30, 70, 100, 30);

        l3 = new JLabel("Prenom");
        l3.setBounds(30, 110, 100, 30);

        l4 = new JLabel("Nom");
        l4.setBounds(30, 150, 100, 30);

        l5 = new JLabel("Filiere");
        l5.setBounds(30, 190, 100, 30);

        l6 = new JLabel("Niveau");
        l6.setBounds(30, 230, 100, 30);

        l7 = new JLabel("Sexe");
        l7.setBounds(30, 270, 100, 30);

        l8 = new JLabel("Date naissance");
        l8.setBounds(30, 310, 120, 30);

        t1 = new JTextField();
        t1.setBounds(150, 30, 150, 30);

        b6 = new JButton("Selectionner");
        b6.setBounds(310, 30, 120, 30);

        t2 = new JTextField();
        t2.setBounds(150, 70, 150, 30);

        t3 = new JTextField();
        t3.setBounds(150, 110, 150, 30);

        t4 = new JTextField();
        t4.setBounds(150, 150, 150, 30);

        cb1 = new JComboBox<>();
        cb1.setBounds(150, 190, 150, 30);
        cb1.addItem("Informatique");
        cb1.addItem("Math");
        cb1.addItem("Physique");
        cb1.addItem("Chimie");
        cb1.addItem("RO");

        cb2 = new JComboBox<>();
        cb2.setBounds(150, 230, 150, 30);
        cb2.addItem("Licence");
        cb2.addItem("Master");

        r1 = new JRadioButton("Masculin");
        r1.setBounds(150, 270, 90, 30);

        r2 = new JRadioButton("Feminin");
        r2.setBounds(240, 270, 90, 30);

        bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);

        t7 = new JTextField("JJ-MM-AAAA");
        t7.setBounds(150, 310, 150, 30);

        b1 = new JButton("Ajout");
        b1.setBounds(30, 380, 100, 30);

        b2 = new JButton("Modifier");
        b2.setBounds(140, 380, 100, 30);

        b3 = new JButton("Supprimer");
        b3.setBounds(250, 380, 110, 30);

        b4 = new JButton("Actualiser");
        b4.setBounds(370, 380, 110, 30);

        b5 = new JButton("Chercher");
        b5.setBounds(490, 380, 110, 30);

        model = new DefaultTableModel();
        model.addColumn("Id");
        model.addColumn("Prenom");
        model.addColumn("Nom");
        model.addColumn("Age");
        model.addColumn("Filiere");
        model.addColumn("Niveau");
        model.addColumn("Sexe");
        model.addColumn("Date naissance");

        table = new JTable(model);
        sp = new JScrollPane(table);
        sp.setBounds(450, 30, 540, 320);

        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(l5);
        add(l6);
        add(l7);
        add(l8);

        add(t1);
        add(t2);
        add(t3);
        add(t4);
        add(t7);

        add(cb1);
        add(cb2);

        add(r1);
        add(r2);

        add(b6);
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
        add(sp);

        b2.addActionListener(e -> {
            update();
        });
        
          b1.addActionListener(e->{add() ;}) ;
        
         b3.addActionListener(e->{delete() ;}) ;
        b4.addActionListener(e->{projection();}) ;

        b5.addActionListener(e -> {
            dispose();
            new Search().setVisible(true);
        });
        b6.addActionListener(e -> {
          
             select() ;
        });

        projection();
    }
    public void projection(){
         try {
            Connection mycn = Connect.getConnection();

            if (mycn == null) {
                System.out.println("connection failed");
                return;
            }

            PreparedStatement ps = mycn.prepareStatement(
                    "select * from students ");
           

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

                model.addRow(new Object[] { id, fname, lname, age, spec, lev, gender, birthday });
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
    public void update(){
     if(t1.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Saisissez un id.");
            return ;
        }

        String gender = "";
        if(r1.isSelected()) {
            gender = "M";
        }
        else if(r2.isSelected()) {
            gender = "F";
        }

        if(t2.getText().equals("") || t3.getText().equals("") || t4.getText().equals("") || t7.getText().equals("") || gender.equals("")) {
            JOptionPane.showMessageDialog(this, "Remplissez tous les champs.");
            return;
        }

         try {
            Connection mycn = Connect.getConnection();

            if (mycn == null) {
                System.out.println("connection failed");
                return;
            }

            PreparedStatement ps = mycn.prepareStatement(
                    "update students set age = ?, fname = ?, lname = ?, specialty = ?, level = ?, gender = ?, birthday = ? where id = ?");
            ps.setInt(1, Integer.parseInt(t2.getText()));
            ps.setString(2, t3.getText());
            ps.setString(3, t4.getText());
            ps.setString(4, cb1.getSelectedItem().toString());
            ps.setString(5, cb2.getSelectedItem().toString());
            ps.setString(6, gender);
            ps.setString(7, t7.getText());
            ps.setString(8, t1.getText());

            int rows = ps.executeUpdate();

            if(rows > 0) {
                JOptionPane.showMessageDialog(this, "Etudiant modifie.");
            }
            else {
                JOptionPane.showMessageDialog(this, "Aucun etudiant trouve.");
            }

            ps.close();
            mycn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void add(){
     if(t1.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Saisissez un id.");
            return ;
        }

        String gender = "";
        if(r1.isSelected()) {
            gender = "M";
        }
        else if(r2.isSelected()) {
            gender = "F";
        }

        if(t2.getText().equals("") || t3.getText().equals("") || t4.getText().equals("") || t7.getText().equals("") || gender.equals("")) {
            JOptionPane.showMessageDialog(this, "Remplissez tous les champs.");
            return;
        }

         try {
            Connection mycn = Connect.getConnection();

            if (mycn == null) {
                System.out.println("connection failed");
                return;
            }

            PreparedStatement check = mycn.prepareStatement(
                    "select * from students where id = ?");
            check.setString(1, t1.getText());

            ResultSet rs = check.executeQuery();

            if(rs.next()) {
                JOptionPane.showMessageDialog(this, "Cet id existe deja.");
                rs.close();
                check.close();
                mycn.close();
                return;
            }

            rs.close();
            check.close();

            PreparedStatement ps = mycn.prepareStatement(
                    "insert into students values(?,?,?,?,?,?,?,?) ");
            ps.setString(1, t1.getText());
            ps.setInt(2, Integer.parseInt(t2.getText()));
            ps.setString(3, t3.getText());
            ps.setString(4, t4.getText());
            ps.setString(5, cb1.getSelectedItem().toString());
            ps.setString(6, cb2.getSelectedItem().toString());
            ps.setString(7, gender);
            ps.setString(8, t7.getText());

            int rows = ps.executeUpdate();

            if(rows > 0) {
                JOptionPane.showMessageDialog(this, "Etudiant ajoute.");
            }
            else {
                JOptionPane.showMessageDialog(this, "Ajout impossible.");
            }

            ps.close();
            mycn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void select(){
     if(t1.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Saisissez un id.");
            return ;
        }
         try {
            Connection mycn = Connect.getConnection();

            if (mycn == null) {
                System.out.println("connection failed");
                return;
            }

            PreparedStatement ps = mycn.prepareStatement(
                    "select * from students where id = ? ");
            ps.setString(1,t1.getText())  ;

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                t2.setText(String.valueOf(rs.getInt("age")));
                t3.setText(rs.getString("fname"));
                t4.setText(rs.getString("lname"));
                cb1.setSelectedItem(rs.getString("specialty"));
                cb2.setSelectedItem(rs.getString("level"));

                if(rs.getString("gender").equals("M")) {
                    r1.setSelected(true);
                }
                else if(rs.getString("gender").equals("F")) {
                    r2.setSelected(true);
                }

                t7.setText(rs.getString("birthday"));
            }
            else {
                JOptionPane.showMessageDialog(this, "Aucun etudiant trouve.");
            }
          
            rs.close();
            ps.close();
            mycn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void delete(){
         if(t1.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Saisissez un id.");
            return ;
        }


         try {
            Connection mycn = Connect.getConnection();

            if (mycn == null) {
                System.out.println("connection failed");
                return;
            }

            PreparedStatement ps = mycn.prepareStatement(
                    "delete from students where id = ?");
           ps.setString(1, t1.getText());

            int rows = ps.executeUpdate();

            if(rows > 0) {
                JOptionPane.showMessageDialog(this, "Etudiant supprime.");
            }
            else {
                JOptionPane.showMessageDialog(this, "Aucun etudiant trouve.");
            }

            ps.close();
            mycn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


 
