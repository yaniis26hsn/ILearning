import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class LoginPage extends JFrame {
    private final JTextField usernameField;
    private final JPasswordField passwordField;

    public LoginPage() {
        setTitle("Page Login");
        setSize(420, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));

        JLabel titleLabel = new JLabel("Connexion", SwingConstants.CENTER);

        JLabel emptyLabel = new JLabel("");
        JLabel userLabel = new JLabel("Login :");
        JLabel passwordLabel = new JLabel("Mot de passe :");

        usernameField = new JTextField();
        passwordField = new JPasswordField();

        JButton loginButton = new JButton("Se connecter");
        JButton quitButton = new JButton("Quitter");

        loginButton.addActionListener(e -> seConnecter());
        quitButton.addActionListener(e -> dispose());

        panel.add(titleLabel);
        panel.add(emptyLabel);
        panel.add(userLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(loginButton);
        panel.add(quitButton);

        setContentPane(panel);
    }

    private void seConnecter() {
        String login = usernameField.getText().trim();
        String password = new String(passwordField.getPassword()).trim();

        if (login.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Remplissez tous les champs.");
            return;
        }

        JOptionPane.showMessageDialog(this, "Connexion simple pour : " + login);
    }
}
