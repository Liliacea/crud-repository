import java.sql.Date;
import java.time.LocalDate;

public class Student {
    private int id;
    private String surname;
    private String name;

    private int dateOfBirth;

    public Student(int id, String surname, String name, int dateOfBirth) {
        this.id = id;
        this.surname = surname;
        this.name = name;

        this.dateOfBirth = dateOfBirth;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public int getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(int dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
