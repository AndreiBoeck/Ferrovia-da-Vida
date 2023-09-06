import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TremTest {
    Locomotiva locomotiva = new Locomotiva();
    Vagao vagao = new Vagao();
    Trem trem = new Trem();

    @BeforeEach
    void setUp() {
        for (int i = 0; i < 10; i++) {
            vagao.addTrain();
            locomotiva.addLocomotiva();
        }
        for (int i = 0; i < 10; i++) {
            trem.engatarLocomotivas();
            trem.engatarVagoes();
        }
    }

    @Test
    void idTrem() {
        assertEquals("V1", trem.idTrem(), "Precisa ser igual");
    }

    @Test
    void alltrens() {
        assertNotNull(trem.alltrens(), "Precisa conter trens");
    }
}