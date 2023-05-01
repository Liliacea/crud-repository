import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.sql.Connection;

import java.time.LocalDate;
import java.util.ArrayList;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertNotNull;



class CRUDsomebodyTest {
    CRUDsomebody cruDsomebody;



    @BeforeEach
    void setUp() {
        Connection connection = CRUDsomebody.getConnection();
        cruDsomebody = new CRUDsomebody(connection);


    }


    @Test
    void getConnection() {
        assertNotNull(cruDsomebody.connection);
    }


    @Test
    void migrate() {
        long m = System.currentTimeMillis();
        assertThat(cruDsomebody.migrate(), is(true));


        System.out.println(System.currentTimeMillis() - m);
    }
    @Test
    void add() {
        Student ivanov = new Student(1, "ivanov", "ivan", LocalDate.of(2015,02,02));
        Student petrov = new Student(2,"petrov", "petr", LocalDate.of(2012,02,03));
        long m = System.currentTimeMillis();
      //  cruDsomebody.migrate();

        assertThat(cruDsomebody.add(ivanov).getName(), is("ivan"));


        System.out.println(System.currentTimeMillis() - m);
    }


    @Test
    void findById() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void close() {
    }
}