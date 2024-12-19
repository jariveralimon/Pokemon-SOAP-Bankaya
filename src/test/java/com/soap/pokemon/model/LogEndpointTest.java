package com.soap.pokemon.model;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

class LogEndpointTest {

    @Test
    void testSettersAndGetters() {
        // Arrange
        LogEndpoint logEndpoint = new LogEndpoint();
        Long expectedId = 1L;
        String expectedIpDeOrigen = "127.0.0.1";
        LocalDateTime expectedFechaRequest = LocalDateTime.now();
        String expectedMetodo = "GET";
        Long expectedTiempoPeticion = 120L;
        String expectedRequest = "pikachu";
        String expectedResponse = "success";

        // Act
        logEndpoint.setId(expectedId);
        logEndpoint.setIpDeOrigen(expectedIpDeOrigen);
        logEndpoint.setFechaRequest(expectedFechaRequest);
        logEndpoint.setMetodo(expectedMetodo);
        logEndpoint.setTiempoPeticion(expectedTiempoPeticion);
        logEndpoint.setRequest(expectedRequest);
        logEndpoint.setResponse(expectedResponse);

        // Assert
        assertEquals(expectedId, logEndpoint.getId());
        assertEquals(expectedIpDeOrigen, logEndpoint.getIpDeOrigen());
        assertEquals(expectedFechaRequest, logEndpoint.getFechaRequest());
        assertEquals(expectedMetodo, logEndpoint.getMetodo());
        assertEquals(expectedTiempoPeticion, logEndpoint.getTiempoPeticion());
        assertEquals(expectedRequest, logEndpoint.getRequest());
        assertEquals(expectedResponse, logEndpoint.getResponse());
    }

    @Test
    void testDefaultConstructor() {
        // Arrange
        LogEndpoint logEndpoint = new LogEndpoint();

        // Act & Assert
        assertNotNull(logEndpoint); // Verificar que la instancia se creó correctamente
    }
}
