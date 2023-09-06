import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class VagaoTest {
    Vagao vagao;
    @Test
    void TestTrain() {
        assertNotEquals(vagao.train(), vagao.train(), "Não deve ser igual");
    }

    @org.junit.jupiter.api.Test
    void getID() {
        assertEquals(vagao.getID(1), vagao.getID(1), "Devem conter o mesmo identificador");
    }
}