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
                    "specialty text , " +
                    "level text, " +
                    "gender text, " +
                    "birthday text" +
                    ")";

            statement.execute(createUsersTable);
            statement.execute(createStudentsTable);

            statement.executeUpdate("insert or ignore into users values ('admin','admin123')");
           

            statement.executeUpdate("insert or ignore into students values ('S001',20,'Amine','Belaid','Informatique','Licence','M','2004-01-15')");
            statement.executeUpdate("insert or ignore into students values ('S002',21,'Sara','Mansouri','Math','Master','F','2003-03-22')");
            statement.executeUpdate("insert or ignore into students values ('S003',19,'Yacine','Haddad','Physique','Licence','M','2005-07-10')");
            statement.executeUpdate("insert or ignore into students values ('S004',22,'Lina','Benali','Chimie','Master','F','2002-11-05')");
            statement.executeUpdate("insert or ignore into students values ('S005',20,'Nadir','Kaci','RO','Licence','M','2004-05-18')");
            statement.executeUpdate("insert or ignore into students values ('S006',21,'Imane','Zeroual','Informatique','Master','F','2003-09-12')");
            statement.executeUpdate("insert or ignore into students values ('S007',23,'Rayane','Touati','Math','Master','M','2001-12-01')");
            statement.executeUpdate("insert or ignore into students values ('S008',18,'Nesrine','Bouzid','Physique','Licence','F','2006-02-27')");
            statement.executeUpdate("insert or ignore into students values ('S009',20,'Walid','Cherif','Chimie','Licence','M','2004-06-30')");
            statement.executeUpdate("insert or ignore into students values ('S010',22,'Aya','Meziane','RO','Master','F','2002-08-14')");
            statement.executeUpdate("insert or ignore into students values ('S011',19,'Islam','Hamdi','Informatique','Licence','M','2005-04-09')");
            statement.executeUpdate("insert or ignore into students values ('S012',21,'Melissa','Rahal','Math','Master','F','2003-10-19')");
            statement.executeUpdate("insert or ignore into students values ('S013',20,'Houssem','Saidi','Physique','Licence','M','2004-03-03')");
            statement.executeUpdate("insert or ignore into students values ('S014',23,'Sabrina','Benkhelifa','Chimie','Master','F','2001-07-25')");
            statement.executeUpdate("insert or ignore into students values ('S015',22,'Adel','Boumediene','RO','Master','M','2002-01-11')");
            statement.executeUpdate("insert or ignore into students values ('S016',18,'Yasmine','Ferhat','Informatique','Licence','F','2006-09-08')");
            statement.executeUpdate("insert or ignore into students values ('S017',20,'Ilyes','Mokhtar','Math','Licence','M','2004-12-20')");
            statement.executeUpdate("insert or ignore into students values ('S018',21,'Marwa','Djebar','Physique','Master','F','2003-06-17')");
            statement.executeUpdate("insert or ignore into students values ('S019',19,'Sofiane','Abbassi','Chimie','Licence','M','2005-11-29')");
            statement.executeUpdate("insert or ignore into students values ('S020',22,'Celia','Brahimi','RO','Master','F','2002-04-13')");

            System.out.println("database was successfully initialized");

            statement.close();
            mycn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
