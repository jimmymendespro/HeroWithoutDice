package data;

/**
 * Classe abstraite représentant un personnage en général, avec ses caractéristiques de base.
 * @author Jimmy Mendes
 */
public abstract class Character {
	
	protected String name;
	protected int skill;
	protected int stamina;
	
	public Character(String name, int skill, int stamina) {
		this.name = name;
		this.skill = skill;
		this.stamina = stamina;
	}
	
	// Getters & Setter -----------------------------------------------------------------------------------------------------------------------------------
	
	public String getName() {
		return name;
	}
	
	public int getSkill() {
		return skill;
	}
	
	public int getStamina() {
		return stamina;
	}

	public void setSkill(int skill) {
		this.skill = skill;
	}

	public void setStamina(int stamina) {
		this.stamina = stamina;
	}
	
	// Methods ----------------------------------------------------------------------------------------------------------------------------------------------
	
	public String toString() {
		return "["+this.name+", Habileté : "+this.skill+", Endurance : "+this.stamina+"]";
	}
	
	/**
	 * Permet de retirer des points de stamina sans descendre en dessous de 0.
	 * @param nombreDeDegats
	 */
	public void decreaseStamina(int nombreDeDegats) {
		if(this.stamina - nombreDeDegats < 0) this.stamina = 0;
		else this.stamina -= nombreDeDegats;
	}
	
}