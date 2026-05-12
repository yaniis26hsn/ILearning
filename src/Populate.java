import java.sql.Statement;
import java.sql.Connection;

public class Populate {

    public static void init() {
        try {
            Connection mycn = Connect.getConnection();

            if (mycn == null) {
                System.out.println("connection failed");
                return;
            }

            Statement statement = mycn.createStatement();

            String createUsersTable =
                    "create table if not exists users (" +
                    "username text primary key, " +
                    "password text not null" +
                    ")";

            String createStudentsTable =
                    "create table if not exists students (" +
                    "id text primary key, " +
                    "age integer not null, " +
                    "fname text not null, " +
                    "lname text not null, " +
                    "level integer, " +
                    "gender text, " +
                    "birthday text" +
                    ")";

            statement.execute(createUsersTable);
            statement.execute(createStudentsTable);

            statement.executeUpdate("insert or ignore into users values ('admin','admin123')");
           

            statement.executeUpdate("insert or ignore into students values ('S001',20,'Amine','Belaid',2,'M','2004-01-15')");
            statement.executeUpdate("insert or ignore into students values ('S002',21,'Sara','Mansouri',3,'F','2003-03-22')");
            statement.executeUpdate("insert or ignore into students values ('S003',19,'Yacine','Haddad',1,'M','2005-07-10')");
            statement.executeUpdate("insert or ignore into students values ('S004',22,'Lina','Benali',4,'F','2002-11-05')");
            statement.executeUpdate("insert or ignore into students values ('S005',20,'Nadir','Kaci',2,'M','2004-05-18')");
            statement.executeUpdate("insert or ignore into students values ('S006',21,'Imane','Zeroual',3,'F','2003-09-12')");
            statement.executeUpdate("insert or ignore into students values ('S007',23,'Rayane','Touati',5,'M','2001-12-01')");
            statement.executeUpdate("insert or ignore into students values ('S008',18,'Nesrine','Bouzid',1,'F','2006-02-27')");
            statement.executeUpdate("insert or ignore into students values ('S009',20,'Walid','Cherif',2,'M','2004-06-30')");
            statement.executeUpdate("insert or ignore into students values ('S010',22,'Aya','Meziane',4,'F','2002-08-14')");
            statement.executeUpdate("insert or ignore into students values ('S011',19,'Islam','Hamdi',1,'M','2005-04-09')");
            statement.executeUpdate("insert or ignore into students values ('S012',21,'Melissa','Rahal',3,'F','2003-10-19')");
            statement.executeUpdate("insert or ignore into students values ('S013',20,'Houssem','Saidi',2,'M','2004-03-03')");
            statement.executeUpdate("insert or ignore into students values ('S014',23,'Sabrina','Benkhelifa',5,'F','2001-07-25')");
            statement.executeUpdate("insert or ignore into students values ('S015',22,'Adel','Boumediene',4,'M','2002-01-11')");
            statement.executeUpdate("insert or ignore into students values ('S016',18,'Yasmine','Ferhat',1,'F','2006-09-08')");
            statement.executeUpdate("insert or ignore into students values ('S017',20,'Ilyes','Mokhtar',2,'M','2004-12-20')");
            statement.executeUpdate("insert or ignore into students values ('S018',21,'Marwa','Djebar',3,'F','2003-06-17')");
            statement.executeUpdate("insert or ignore into students values ('S019',19,'Sofiane','Abbassi',1,'M','2005-11-29')");
            statement.executeUpdate("insert or ignore into students values ('S020',22,'Celia','Brahimi',4,'F','2002-04-13')");

            System.out.println("database was successfully initialized");

            statement.close();
            mycn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
