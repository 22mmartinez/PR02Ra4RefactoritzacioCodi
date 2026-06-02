import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class MagatzemTest {

    @Test
    void testDegradacioNormal() {
        Article[] art = { new Article("Poma", 10, 20) };
        new Magatzem(art).actualitzarEstat();
        assertEquals(9, art[0].diesPerVendre, "Els dies haurien de baixar en 1");
        assertEquals(19, art[0].qualitat, "La qualitat hauria de baixar en 1");
    }

    @Test
    void testFormatgeMilloraAmbElTemps() {
        Article[] art = { new Article("Formatge Gidurat", 10, 20) };
        new Magatzem(art).actualitzarEstat();
        assertTrue(art[0].qualitat > 20, "El formatge hauria d'augmentar la seva qualitat");
    }

    }