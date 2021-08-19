package data;

public class Ennemi extends Personnage {

	public Ennemi(String nom, int habilete, int endurance) {
		super(nom, habilete, endurance);
	}
	
	// Méthodes
	
	public int attaquer(Hero hero, int scoreChance) {
		if(scoreChance >= 0) {
			return hero.recevoirDegats(1);
		}
		else return hero.recevoirDegats(3);
	}

}
