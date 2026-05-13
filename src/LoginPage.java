import java.sql.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPage extends JFrame {
    JTextField t1;
    JPasswordField t2;
    JButton b1;
    JButton b2;
    JLabel l1;
    JLabel l2;
    JLabel l3;

    public LoginPage() {
        setTitle("Page Login");
        setSize(400, 250);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        l1 = new JLabel("Connexion");
        l1.setBounds(160, 20, 100, 30);

        l2 = new JLabel("Login :");
        l2.setBounds(50, 70, 100, 30);

        l3 = new JLabel("Mot de passe :");
        l3.setBounds(50, 110, 100, 30);

        t1 = new JTextField();
        t1.setBounds(160, 70, 150, 30);

        t2 = new JPasswordField();
        t2.setBounds(160, 110, 150, 30);

        b1 = new JButton("Se connecter");
        b1.setBounds(70, 160, 120, 30);

        b2 = new JButton("Quitter");
        b2.setBounds(210, 160, 100, 30);

        add(l1);
        add(l2);
        add(l3);
        add(t1);
        add(t2);
        add(b1);
        add(b2);

        b1.addActionListener(e -> connecting());
        b2.addActionListener(e -> dispose());
    }

    public void connecting() {
        String login = t1.getText();
        String password = new String(t2.getPassword());

        if (login.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Remplissez tous les champs.");
        } else {
            try {
            Connection mycn = Connect.getConnection();

            if (mycn == null) {
                System.out.println("connection failed");
                return;
            }

            PreparedStatement pstt = mycn.prepareStatement(
            "select * from users " +
            "where username = ? and password = ?" );
            pstt.setString(1,login) ;
            pstt.setString(2,password) ;
           
            ResultSet rs = pstt.executeQuery() ;
            if(rs.next()){
               dispose();
               new StudentManger().setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(this, "Login ou mot de passe incorrect");
            }

            rs.close();
            pstt.close();
            mycn.close();
        }
            catch (Exception e) {
            e.printStackTrace();
        }

        }
    }
}
