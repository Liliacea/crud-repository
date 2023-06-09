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
        Student ivanov = new Student.Builder()
                .surname("ivanov")
                .name("ivan")
                .dateOfBirth(LocalDate.of(2000,12,20))
                .build();

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

        CRUDsomebody cruDsomebody = new CRUDsomebody(DBConfig.getConnection());
        Student ivanov = new Student.Builder()
                .surname("ivanov")
                .name("ivan")
                .dateOfBirth(LocalDate.of(2000,12,20))
                .build();
        long m = System.currentTimeMillis();
        int id = cruDsomebody.add(ivanov).getId();


        assertThat(cruDsomebody.findById(id).getName(), is("ivan"));
        System.out.println(System.currentTimeMillis() - m);

    }

    /**
     * test update returns entity which field was changed
     */

    @Test
    void update() {
        CRUDsomebody cruDsomebody = new CRUDsomebody(DBConfig.getConnection());
        Student ivanov = new Student.Builder()
                .surname("ivanov")
                .name("ivan")
                .dateOfBirth(LocalDate.of(2000,12,20))
                .build();
        long m = System.currentTimeMillis();
        int id = cruDsomebody.add(ivanov).getId();
        cruDsomebody.update(ivanov);
        assertThat(cruDsomebody.findById(id).getSurname(), is("surname"));
        System.out.println(System.currentTimeMillis() - m);
    }

    /**
     * test deleted entity is null
     */
    @Test
    void delete() {
        ArrayList<Student> students = new ArrayList<>();
        CRUDsomebody cruDsomebody = new CRUDsomebody(DBConfig.getConnection());
        Student ivanov = new Student.Builder()
                .surname("ivanov")
                .name("ivan")
                .dateOfBirth(LocalDate.of(2000,12,20))
                .build();
        long m = System.currentTimeMillis();
        int id = cruDsomebody.add(ivanov).getId();
        cruDsomebody.delete(ivanov);
        assertNull(cruDsomebody.findById(id));
        System.out.println(System.currentTimeMillis() - m);
    }

    @Test
    void close() {
    }


}