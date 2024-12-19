package com.soap.pokemon;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PokemonApplicationTests {

    @Test
    void testMain() {
        assertDoesNotThrow(() -> PokemonApplication.main(new String[] {}));
    }

}
