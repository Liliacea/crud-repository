import org.flywaydb.core.Flyway;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Formatter;

public class Check {
    public static void main(String[] args) {

        Migrate migrate = new Migrate();
        CRUDsomebody cruDsomebody = new CRUDsomebody();
       // migrate.migrate();
       Student student = new Student(1, "Ivanov", "Sidor", LocalDate.of(2010,02,15));
       Student student2 = new Student(2, "petrov", "Sidor", LocalDate.of(2011,02,15));
        Student student3 = new Student(3, "sidorov", "Sidor", LocalDate.of(2012,02,15));
        Student student4 = new Student(4, "Ivanov", "petr", LocalDate.of(2013,02,15));
      //  Student student5 = new Student(1, "Ivanov", "Sidor", LocalDate.of(2010,02,15));
       // Student student6 = new Student(1, "Ivanov", "Sidor", LocalDate.of(2010,02,15));

        cruDsomebody.delete(student2);


    }


}
