
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.*;

class DBConfigTest {


    @BeforeEach
    void setUp() {
        DBConfig dbConfig = new DBConfig();

    }


    @Test
    void getConnection() {
        assertNotNull(DBConfig.getConnection());
    }



}