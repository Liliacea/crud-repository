import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;

public class CRUDsomebody implements CRUDrepository{
    static Connection connection;

    static String sql;

    @Override
    public Object add (Object o) {
        try (Statement statement = connection.createStatement();){



            sql = "INSERT INTO people.newtable (surname, name, group, dateOfBirth) VALUES (?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, o.getSurname());
            preparedStatement.setInt(2, person.getAge());
            preparedStatement.setString(3, person.getAdress());
            preparedStatement.setDouble(4, person.getSalary());

            preparedStatement.executeUpdate();




        } catch (Exception e) {

            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);


        }

        System.out.println("-- Records created successfully");

       return student;
    }
    }

    @Override
    public Object findById(Object id) {
        return null;
    }

    @Override
    public Object update(Object o) {
        return null;
    }

    @Override
    public Object delete(Object o) {
        return null;
    }

    @Override
    public void close() throws Exception {

    }
}
