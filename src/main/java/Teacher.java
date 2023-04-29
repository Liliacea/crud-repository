import java.time.LocalDate;

public class Teacher {
    private int id;
    private String surname;
    private String name;
    private String group;
    private LocalDate dateOfBirth;

    public Teacher (int id, String surname, String name, String group, LocalDate dateOfBirth) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.group = group;
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

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
