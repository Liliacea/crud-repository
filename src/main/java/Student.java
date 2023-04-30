import java.sql.Date;
import java.time.LocalDate;

public class Student {
    private int id;
    private String surname;
    private String name;

    private LocalDate dateOfBirth;

    public Student(int id, String surname, String name, LocalDate dateOfBirth) {
        this.id = id;
        this.surname = surname;
        this.name = name;

        this.dateOfBirth = dateOfBirth;
    }

    public int getId() {
        return id;
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



    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
