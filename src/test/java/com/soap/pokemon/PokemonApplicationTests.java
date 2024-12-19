package com.soap.pokemon;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PokemonApplicationTests {

	@Test
	void contextLoads() {
	}

    @Test
    void testMain() {
        PokemonApplication.main(new String[] {});
    }

}
