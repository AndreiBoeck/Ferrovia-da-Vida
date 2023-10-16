import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Teste destinado a testar métodos de Locomotiva
 *
 * @author adrei.boeck@edu.pucrs.br
 * @author luisa.scolari@edu.pucrs.br
 * @author marcela.zarichta@edu.pucrs.br
 * @author rafael.roth@edu.pucrs.br
 */
class LocomotivaTest {
    Locomotiva locomotiva = new Locomotiva(40.0,5);
    @Test
    void getIdentificador() {
        assertEquals("L2", locomotiva.getIdentificador(), "Precisa ser igual");
    }

    @Test
    void testToString() {
        String a = "Locomotiva[identificador=L1;pesoMaximo=40.0;qtdadeMaxVagoes=5]";
        assertEquals(a, locomotiva.toString(),"Precisa ser uma String");
    }
}