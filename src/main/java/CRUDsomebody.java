import org.flywaydb.core.Flyway;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Properties;

public class CRUDsomebody implements CRUDrepository<Student, Integer> {


   private Connection connection;





    public CRUDsomebody(Connection connection) {
        this.connection = connection;


    }

    @Override
    public Student add(Student student) {


        try (Statement statement = connection.createStatement()) {
            String[] returnId = {"id"};
            String sql = "INSERT INTO people.newtable1 (surname, name, dateOfBirth) VALUES (?,?,?) ";
            PreparedStatement preparedStatement = connection.prepareStatement(sql, returnId);
            preparedStatement.setString(1, student.getSurname());
            preparedStatement.setString(2, student.getName());
            preparedStatement.setDate(3, Date.valueOf(student.getDateOfBirth()));

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating user failed, no rows affected.");
            }
            try (ResultSet rs = preparedStatement.getGeneratedKeys()) {
                if (rs.next()) {

                    System.out.println(rs.getInt(1));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();

        }

        return student;
    }

    @Override
    public Student findById(Integer id) {
        Student student = null;

        try (Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery("SELECT * FROM people.newtable1 where id = id;")) {
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
        } catch (Exception e) {
            e.printStackTrace();
        }

        return student;
    }

    @Override
    public Student update(Student student) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "UPDATE people.newtable1 set surname = 'surname' where name = ?;");
        ) {
            preparedStatement.setString(1, student.getName());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public Student delete(Student student) {
        try (PreparedStatement preparedStatement = connection.prepareStatement
                ("DELETE from people.newtable1 where name =?;");) {
            preparedStatement.setString(1, student.getName());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public void close() throws SQLException {
        connection.close();
    }
}
