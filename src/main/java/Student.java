import java.sql.Date;
import java.time.LocalDate;

public class Student {

   /* public Student(int id, String surname, String name, LocalDate dateOfBirth) {

        this.id = id;
        this.surname = surname;
        this.name = name;
        this.dateOfBirth = dateOfBirth;

    }


    public Student(String surname, String name, LocalDate dateOfBirth) {
        this.surname = surname;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    */


    private Integer id;
    private String surname;
    private String name;
    private LocalDate dateOfBirth;

    private Student (Builder builder) {
        surname = builder.surname;
        name = builder.name;
        dateOfBirth = builder.dateOfBirth;


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public static class Builder {
        private String surname;
        //Необязательные параметры со значениями по умолчанию

        private String name;
        private LocalDate dateOfBirth;

        //Конструктор с обязательными параметрами
        public Builder() {


        }
        public Builder surname (String val) {
            surname = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder dateOfBirth(LocalDate val) {
            dateOfBirth = val;
            return this;
        }


        //Метод с возвращающим типом Good для генерации объекта
        public Student build() {
            return new Student(this);
        }


    }
}


