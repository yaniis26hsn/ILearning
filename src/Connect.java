import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:sqlite:LocalDB/ilearning.db");
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
