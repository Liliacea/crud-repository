import org.flywaydb.core.Flyway;

import java.io.InputStream;
import java.util.Properties;

public class Migrate {

    public void migrate() {
        try (
                InputStream input = DBConfig.class.getClassLoader().getResourceAsStream("app.properties")) {


            Properties prop = new Properties();
            prop.load(input);
            Flyway flyway = new Flyway();
            flyway.setDataSource(prop.getProperty("db.url"), prop.getProperty("db.user"), prop.getProperty("db.password"));
            flyway.migrate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Connection Failed");


        }
    }
}