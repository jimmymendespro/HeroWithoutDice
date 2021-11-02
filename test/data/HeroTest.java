package data;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import data.Hero.EquipmentNotFindException;
import data.Hero.TreasureNotFindException;
import data.Hero.NotEnoughProvisionException;

class HeroTest {

	@Test
	@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
	void testAddSkillNormal() {
		Hero randomHero = new Hero("Random", 7, 7, 7);
		randomHero.decreaseSkill(5);
		randomHero.addSkill(4);
		Assertions.assertEquals(6, randomHero.getSkill());
	}
	
	@Test
	@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
	void testAddSkillReachStartingSkill() {
		Hero randomHero = new Hero("Random", 7, 7, 7);
		randomHero.decreaseSkill(2);
		randomHero.addSkill(4);
		Assertions.assertEquals(7, randomHero.getSkill());
	}

	@Test
	@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
	void testDecreaseSkillNormal() {
		Hero randomHero = new Hero("Random", 7, 7, 7);
		randomHero.decreaseSkill(2);
		Assertions.assertEquals(5, randomHero.getSkill());
	}
	
	@Test
	@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
	void testDecreaseSkillUnder0() {
		Hero randomHero = new Hero("Random", 7, 7, 7);
		randomHero.decreaseSkill(9);
		Assertions.assertEquals(0, randomHero.getSkill());
	}

	@Test
	@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
	void testAddStaminaNormal() {
		Hero randomHero = new Hero("Random", 7, 7, 7);
		randomHero.decreaseStamina(5);
		randomHero.addStamina(4);
		Assertions.assertEquals(6, randomHero.getStamina());
	}
	
	@Test
	@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
	void testAddStaminaReachStartingStamina() {
		Hero randomHero = new Hero("Random", 7, 7, 7);
		randomHero.decreaseStamina(2);
		randomHero.addStamina(4);
		Assertions.assertEquals(7, randomHero.getStamina());
	}
	
	@Test
	@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
	void testAddLuckNormal() {
		Hero randomHero = new Hero("Random", 7, 7, 7);
		randomHero.decreaseLuck(5);
		randomHero.addLuck(4);
		Assertions.assertEquals(6, randomHero.getLuck());
	}
	
	@Test
	@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
	void testAddLuckReachStartingLuck() {
		Hero randomHero = new Hero("Random", 7, 7, 7);
		randomHero.decreaseLuck(2);
		randomHero.addLuck(4);
		Assertions.assertEquals(7, randomHero.getLuck());
	}
	
	@Test
	@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
	void testDecreaseLuckNormal() {
		Hero randomHero = new Hero("Random", 7, 7, 7);
		randomHero.decreaseLuck(2);
		Assertions.assertEquals(5, randomHero.getLuck());
	}
	
	@Test
	@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
	void testDecreaseLuckUnder0() {
		Hero randomHero = new Hero("Random", 7, 7, 7);
		randomHero.decreaseLuck(9);
		Assertions.assertEquals(0, randomHero.getLuck());
	}
	
	@Test
	@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
	void testDecrementLuckNormal() {
		Hero randomHero = new Hero("Random", 7, 7, 7);
		randomHero.decrementLuck();
		Assertions.assertEquals(6, randomHero.getLuck());
	}
	
	@Test
	@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
	void testDecrementLuckUnder0() {
		Hero randomHero = new Hero("Random", 7, 7, 0);
		randomHero.decrementLuck();
		Assertions.assertEquals(0, randomHero.getLuck());
	}
	
	@Test
	@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
	void testAddGold() {
		Hero randomHero = new Hero("Random", 7, 7, 7);
		randomHero.addGold(2);
		Assertions.assertEquals(3, randomHero.getGold());
	}

	@Test
	@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
	void testDecreaseGoldNormal() {
		Hero randomHero = new Hero("Random", 7, 7, 7);
		randomHero.decreaseGold(1);
		Assertions.assertEquals(0, randomHero.getGold());
	}
	
	@Test
	@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
	void testDecreaseGoldUnder0() {
		Hero randomHero = new Hero("Random", 7, 7, 7);
		Assertions.assertThrows(IllegalStateException.class, () -> {
			randomHero.decreaseGold(2);
		});
	}

	@Test
	@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
	void testAddEquipment() {
		Hero randomHero = new Hero("Random", 7, 7, 7);
		randomHero.addEquipment("RandomSword");
		Assertions.assertTrue(randomHero.getEquipment().contains("RandomSword"));
	}

	@Test
	@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
	void testRemoveEquipmentNormal() {
		Hero randomHero = new Hero("Random", 7, 7, 7);
		randomHero.addEquipment("RandomSword");
		randomHero.removeEquipment("RandomSword");
		Assertions.assertFalse(randomHero.getEquipment().contains("RandomSword"));
	}
	
	@Test
	@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
	void testRemoveEquipmentException() {
		Hero randomHero = new Hero("Random", 7, 7, 7);
		Assertions.assertThrows(EquipmentNotFindException.class, () -> {
			randomHero.removeEquipment("RandomSword");
		});
	}

	@Test
	@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
	void testAddTreasure() {
		Hero randomHero = new Hero("Random", 7, 7, 7);
		randomHero.addTreasure("RandomTreasure");
		Assertions.assertTrue(randomHero.getTreasure().contains("RandomTreasure"));
	}

	@Test
	@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
	void testRemoveTreasureNormal() {
		Hero randomHero = new Hero("Random", 7, 7, 7);
		randomHero.addTreasure("RandomTreasure");
		randomHero.removeTreasure("RandomTreasure");
		Assertions.assertFalse(randomHero.getTreasure().contains("RandomTreasure"));
	}
	
	@Test
	@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
	void testRemoveTreasureException() {
		Hero randomHero = new Hero("Random", 7, 7, 7);
		Assertions.assertThrows(TreasureNotFindException.class, () -> {
			randomHero.removeTreasure("RandomSword");
		});
	}

	@Test
	@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
	void testAddProvision() {
		Hero randomHero = new Hero("Random", 7, 7, 7);
		randomHero.addProvision(5);
		Assertions.assertEquals(15, randomHero.getProvision());
	}

	@Test
	@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
	void testRemoveProvisionNormal() {
		Hero randomHero = new Hero("Random", 7, 7, 7);
		randomHero.removeProvision(5);
		Assertions.assertEquals(5, randomHero.getProvision());
	}
	
	@Test
	@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
	void testRemoveProvisionException() {
		Hero randomHero = new Hero("Random", 7, 7, 7);
		Assertions.assertThrows(NotEnoughProvisionException.class, () -> {
			randomHero.removeProvision(11);
		});
	}

	@Test
	@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
	void testTakeMealNormal() {
		Hero randomHero = new Hero("Random", 7, 7, 7);
		randomHero.decreaseStamina(5);
		randomHero.takeMeal();
		Assertions.assertEquals(6, randomHero.getStamina());
		Assertions.assertEquals(9, randomHero.getProvision());
	}
	
	@Test
	@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
	void testTakeMealReachStartingStamina() {
		Hero randomHero = new Hero("Random", 7, 7, 7);
		randomHero.decreaseStamina(2);
		randomHero.takeMeal();
		Assertions.assertEquals(7, randomHero.getStamina());
		Assertions.assertEquals(9, randomHero.getProvision());
	}

	@Test
	@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
	void testShareMealNormal() {
		Hero randomHero = new Hero("Random", 7, 7, 7);
		randomHero.decreaseStamina(5);
		randomHero.shareMeal();
		Assertions.assertEquals(4, randomHero.getStamina());
		Assertions.assertEquals(9, randomHero.getProvision());
	}
	
	@Test
	@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
	void testShareMealReachStartingStamina() {
		Hero randomHero = new Hero("Random", 7, 7, 7);
		randomHero.decreaseStamina(1);
		randomHero.shareMeal();
		Assertions.assertEquals(7, randomHero.getStamina());
		Assertions.assertEquals(9, randomHero.getProvision());
	}

}