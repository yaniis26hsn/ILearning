import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        Populate.init();

        try (Connection connection = Connect.getConnection()) {
            if (connection == null) {
                System.out.println("Database connection failed.");
            } else {
                System.out.println("Database connection successful.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> new LoginPage().setVisible(true));
    }
}
