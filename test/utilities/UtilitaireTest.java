package utilities;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

class UtilitaireTest {

	@Test
	@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
	public void isNumericTestTrue() {
		Assertions.assertTrue(Utilitaire.isNumeric("15"));
	}
	
	@Test
	@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
	public void isNumericTestFalse() {
		Assertions.assertFalse(Utilitaire.isNumeric("Test")); 
	}

}
