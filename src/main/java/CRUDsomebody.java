import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class CRUDsomebody implements CRUDrepository<Student, Integer>{

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
            statement = DBConfig.getConnection().createStatement();
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
            PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(sql);
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
            PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(sql);
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
