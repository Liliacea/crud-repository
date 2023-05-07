import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * test CRUD
 * connectionn rollback
 */

class CRUDsomebodyTest {
    CRUDsomebody cruDsomebody;

    @BeforeEach
    void setUp() {

        try {
            cruDsomebody = new CRUDsomebody(ConnectionRollBack.create(DBConfig.getConnection()));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * test rollBack connection
     */
   /* @Test
    void getConnection() {
        assertNotNull(cruDsomebody.connection);
    }

    */

    /**
     * test the field name of the added entity corresponds to the field name of the object
     */
    @Test
    void add() {
        Student ivanov = new Student(1, "ivanov", "ivan", LocalDate.of(2015, 02, 02));
        Student petrov = new Student(2, "petrov", "petr", LocalDate.of(2012, 02, 03));
        long m = System.currentTimeMillis();
        Student addedIvanov = cruDsomebody.add(ivanov);
        assertThat(cruDsomebody.add(ivanov).getName(), is("ivan"));
        System.out.println(System.currentTimeMillis() - m);

    }

    /**
     * test findById returns entity which field name corresponds to the field name of the added object
     */
    @Test
    void findById() {

        Student ivanov = new Student(1, "ivanov", "ivan", LocalDate.of(2015, 02, 02));
        Student petrov = new Student(2, "petrov", "petr", LocalDate.of(2012, 02, 03));
        long m = System.currentTimeMillis();
        cruDsomebody.add(ivanov);
        Student addedIvanov = cruDsomebody.add(ivanov);
        System.out.println(System.currentTimeMillis() - m);
        assertThat(cruDsomebody.findById(addedIvanov.getId()).getName(), is("ivan"));


    }

    /**
     * test update returns entity which field was changed
     */

    @Test
    void update() {
        Student ivanov = new Student(1, "ivanov", "ivan", LocalDate.of(2015, 02, 02));
        Student petrov = new Student(2, "petrov", "petr", LocalDate.of(2012, 02, 03));
        long m = System.currentTimeMillis();
        cruDsomebody.add(ivanov);
        cruDsomebody.update(ivanov);
       // assertThat(cruDsomebody.findById(cruDsomebody.added).getSurname(), is("surname"));
        System.out.println(System.currentTimeMillis() - m);
    }

    /**
     * test deleted entity is null
     */
    @Test
    void delete() {
        ArrayList<Student> students = new ArrayList<>();
        Student ivanov = new Student(1, "ivanov", "ivan", LocalDate.of(2015, 02, 02));
        Student petrov = new Student(2, "petrov", "petr", LocalDate.of(2012, 02, 03));
        long m = System.currentTimeMillis();
        cruDsomebody.add(ivanov);
        cruDsomebody.delete(ivanov);
       // assertNull(cruDsomebody.findById(cruDsomebody.added));
        System.out.println(System.currentTimeMillis() - m);
    }

    @Test
    void close() {
    }


}