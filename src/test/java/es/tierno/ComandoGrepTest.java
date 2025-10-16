package es.tierno;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

class ComandoGrepTest {

    @Test
    void testCrearProceso() throws IOException {
        Process proceso = ComandoGrep.crearProceso("grep", "PSP");
        assertNotNull(proceso);
        proceso.destroy();
    }
}

