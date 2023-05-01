import org.flywaydb.core.Flyway;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Properties;

public class CRUDsomebody implements CRUDrepository<Student, Integer>{

    static String sql;
    Statement statement;
    static Connection connection;

    public CRUDsomebody(Connection connection) {
        this.connection = connection;
    }

    public static Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            Properties prop = new Properties();
            InputStream input = CRUDsomebody.class.getClassLoader().getResourceAsStream("app.properties");
            prop.load(input);
            connection = DriverManager.getConnection
                    (prop.getProperty("db.url"), prop.getProperty("db.user"),
                            prop.getProperty("db.password"));
            connection = ConnectionRollBack.create(connection);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("connection doesn't exist");
        }
        return connection;
    }

    public boolean migrate() {
        boolean isMigrated = false;
        try (
                InputStream input = CRUDsomebody.class.getClassLoader().getResourceAsStream("app.properties")) {


            Properties prop = new Properties();
            prop.load(input);
            Flyway flyway = new Flyway();
            flyway.setDataSource(prop.getProperty("db.url"), prop.getProperty("db.user"), prop.getProperty("db.password"));
            flyway.migrate();
            isMigrated = true;
        } catch (Exception e) {
            isMigrated = false;
            e.printStackTrace();
            System.out.println("Connection Failed");


        }

        return  isMigrated;
    }

    @Override
    public Student add (Student student) {
        try {

            statement = connection.createStatement();

            sql = "INSERT INTO people.newtable1 (surname, name, dateOfBirth) VALUES (?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, student.getSurname());
            preparedStatement.setString(2, student.getName());
           ;
            preparedStatement.setDate(3, Date.valueOf(student.getDateOfBirth()));

            preparedStatement.executeUpdate();

            statement.close();


        } catch (Exception e) {

            e.printStackTrace();


        }



       return student;
    }


    @Override
    public Student findById(Integer id) {

        Student student = null;
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM people.newtable1 where id = id;");
            while (rs.next()) {
                if (rs.getInt("id") == id) {
                    id = rs.getInt("id");
                    String surname = rs.getString("surname");
                    String name = rs.getString("name");
                    LocalDate dateOfBirth = rs.getDate("dateOfBirth").toLocalDate();
                    student = new Student(id, surname, name, dateOfBirth);

                    System.out.println(String.format("ID=%s SURNAME=%s NAME=%s DATEOFBIRTH=%s", id, surname, name, dateOfBirth));
                }
            }

            rs.close();
            statement.close();


        } catch (Exception e) {
            e.printStackTrace();

        }



        return student;

    }

    @Override
    public Student update(Student student) {

        try {


            sql = "UPDATE people.newtable1 set surname = 'surname' where ID= ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, student.getId());

            preparedStatement.executeUpdate();


            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


        return student;
    }

    @Override
    public Student delete(Student student) {

        try {


            sql = "DELETE from people.newtable1 where ID=?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, student.getId());
            preparedStatement.executeUpdate();


            preparedStatement.close();



        } catch (Exception e) {
            e.printStackTrace();

        }
        return student;
    }

    @Override
    public void close() throws Exception {
        throw new SQLException();
    }
}
