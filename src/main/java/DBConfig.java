import org.flywaydb.core.Flyway;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBConfig {
    static Connection connection;


    protected static Connection getConnection() {



        try (InputStream input = DBConfig.class.getClassLoader().getResourceAsStream("app.properties")) {
            Class.forName("org.postgresql.Driver");


            Properties prop = new Properties();
            prop.load(input);

            connection = DriverManager.getConnection
                    (prop.getProperty("db.url"), prop.getProperty("db.user"),
                            prop.getProperty("db.password"));


            System.out.println(prop.getProperty("db.url"));
            System.out.println(prop.getProperty("db.user"));
            System.out.println(prop.getProperty("db.password"));


        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Connection Failed");


        }


        if (connection != null) {
            System.out.println("You successfully connected to database now");
        } else {
            System.out.println("Failed to make connection to database");
        }
        return connection;
    }
}
