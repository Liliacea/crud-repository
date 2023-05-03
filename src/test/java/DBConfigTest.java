import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * test main connection
 */
class DBConfigTest {

    @Test
    void getConnection() {
        assertNotNull(DBConfig.getConnection());
    }



}