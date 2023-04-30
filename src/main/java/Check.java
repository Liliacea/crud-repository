import java.time.LocalDate;
import java.util.Date;
import java.util.Formatter;

public class Check {
    public static void main(String[] args) {
        CRUDsomebody cruDsomebody = new CRUDsomebody();
        Student student = new Student(1, "Ivanov", "Sidor", 1958);
        cruDsomebody.add(student);
    }
}
