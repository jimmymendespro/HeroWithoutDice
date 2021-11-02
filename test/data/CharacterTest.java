package data;

import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

class CharacterTest {

	@Test
	@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
	public void testNormalDecreaseStamina() {
		Ennemi randomEnnemi = new Ennemi("Random", 10, 3);
		randomEnnemi.decreaseStamina(2);
		Assertions.assertEquals(1, randomEnnemi.getStamina());
	}
	
	@Test
	@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
	public void testUnder0DecreaseStamina() {
		Ennemi randomEnnemi = new Ennemi("Random", 10, 1);
		randomEnnemi.decreaseStamina(2);
		Assertions.assertEquals(0, randomEnnemi.getStamina());
	}

}
