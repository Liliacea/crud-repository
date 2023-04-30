import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class CRUDsomebody implements CRUDrepository<Student, Integer>{
    static Connection connection;

    static String sql;
    Statement statement;

    @Override
    public Student add (Student student) {
        try {

            statement = DBConfig.getConnection().createStatement();

            sql = "INSERT INTO people.newtable1 (surname, name, dateOfBirth) VALUES (?,?,?)";
            PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(sql);

            preparedStatement.setString(1, student.getSurname());
            preparedStatement.setString(2, student.getName());
           ;
            preparedStatement.setInt(3, student.getDateOfBirth());

            preparedStatement.executeUpdate();

            statement.close();


        } catch (Exception e) {

            e.printStackTrace();


        }

        System.out.println("-- Records created successfully");

       return student;
    }


    @Override
    public Student findById(Integer id) {
        return null;
    }

    @Override
    public Student update(Student student) {
        return null;
    }

    @Override
    public Student delete(Student student) {
        return null;
    }

    @Override
    public void close() throws Exception {
        throw new SQLException();
    }
}
