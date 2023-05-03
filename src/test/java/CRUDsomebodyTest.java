import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.sql.Connection;

import java.time.LocalDate;
import java.util.ArrayList;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
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
    void add() {
        Student ivanov = new Student(1, "ivanov", "ivan", LocalDate.of(2015,02,02));
        Student petrov = new Student(2,"petrov", "petr", LocalDate.of(2012,02,03));
        long m = System.currentTimeMillis();

        assertThat(cruDsomebody.add(ivanov).getName(), is("ivan"));


        System.out.println(System.currentTimeMillis() - m);
    }


    @Test
    void findById() {
        int id;
        Student ivanov = new Student(1, "ivanov", "ivan", LocalDate.of(2015,02,02));
        Student petrov = new Student(2,"petrov", "petr", LocalDate.of(2012,02,03));
        long m = System.currentTimeMillis();
        cruDsomebody.add(ivanov);
        cruDsomebody.add(petrov);
        id = cruDsomebody.selectId(ivanov);

        assertThat(cruDsomebody.findById(id).getName(),is("ivan"));

    }

  /*  @Test
    void update() {
        Student ivanov = new Student(1, "ivanov", "ivan", LocalDate.of(2015,02,02));
        Student petrov = new Student(2,"petrov", "petr", LocalDate.of(2012,02,03));
        long m = System.currentTimeMillis();
        cruDsomebody.add(ivanov);
        cruDsomebody.add(petrov);
        cruDsomebody.update(ivanov);
        assertThat(cruDsomebody.update(ivanov).getSurname(), is("surname"));
    }



    @Test
    void delete() {
    }

    @Test
    void close() {
    }

   */


}