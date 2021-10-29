package data;

import java.util.ArrayList;

import utilities.Utilitaire;

public class Hero extends Personnage {
	
	private int habileteDepart;
	private int enduranceDepart;
	private int chanceDepart;
	private int luck;
	private int or;
	private int provisions;
	private ArrayList<String> equipmentList;
	private ArrayList<String> treasureList;

	public Hero(String nom, int habilete, int endurance, int luck) {
		super(nom, habilete, endurance);
		this.habileteDepart = habilete+4;
		this.enduranceDepart = endurance +7;
		this.luck = luck;
		this.chanceDepart = luck+3;
		this.or = 17;
		this.provisions = 10;
		this.equipmentList = new ArrayList<>();
		this.equipmentList.add("Épée");
		this.equipmentList.add("Armure de Cuir");
		this.equipmentList.add("Sac à Dos");
		this.equipmentList.add("Lanterne");
		//this.equipmentList.add("Potion d'Invisibilité");
		//this.equipmentList.add("Petits Piquets taillés en pointe (Épieux)");
		this.treasureList = new ArrayList<>();
		/*this.treasureList.add("L'Oeil du Cyclope");
		this.treasureList.add("Fromage");*/
		//this.treasureList.add("Crucifix en Argent");
		/*this.treasureList.add("Arc et Flèche d'Argent");
		this.treasureList.add("Bâton en forme de Y");*/
	}
	
	// Getters & Setter -----------------------------------------------------------------------------------------------------------------------------------
	
	public int getHabileteDepart() {
		return habileteDepart;
	}
	
	public int getEnduranceDepart() {
		return enduranceDepart;
	}

	public int getLuck() {
		return luck;
	}
	
	public int getChanceDepart() {
		return chanceDepart;
	}
	
	public int getOr() {
		return this.or;
	}
	
	public int getProvision() {
		return this.provisions;
	}
	
	public ArrayList<String> getEquipment(){
		return this.equipmentList;
	}
	
	public ArrayList<String> getTreasure(){
		return this.treasureList;
	}
	
	public void setChance(int chance) {
		this.luck = chance;
	}
	
	public void setGoldCoins(int goldCoinsNumber) {
		this.or = goldCoinsNumber;
	}
	
	// Méthodes ---------------------------------------------------------------------------------------------------------------------------------------------------
	
	public String toString() {
		return "["+this.nom+", Habileté : "+this.habilete+", Endurance : "+this.endurance+", Chance : "+this.luck+"]";
	}
	
	public int modifierEndurance(int nombre) {
		int endurance = this.getStamina();
		endurance -= nombre;
		this.setEndurance(endurance);
		return endurance;
	}
	
	public int calculScoreChance() {
		return luck - Utilitaire.doubleLancerSix();
	}
	
	public int attaquer(Personnage personnage, int scoreChance) {
		if(scoreChance >= 0) {
			return personnage.recevoirDegats(4);
		}
		else return personnage.recevoirDegats(1);
	}
	
	public void addSkill(int skillNumber) {
		if(this.habilete + skillNumber > this.habileteDepart) this.habilete = this.habileteDepart;
		else this.habilete += skillNumber;
	}
	
	public void decreaseSkill(int skillNumber) {
		int currentSkill = this.getSkill();
		if(currentSkill - skillNumber < 0) currentSkill = 0;
		else currentSkill -= skillNumber;
		this.setHabilete(currentSkill);
	}
	
	public void addStamina(int staminaNumber) {
		if(this.endurance + staminaNumber > this.enduranceDepart) this.endurance = this.enduranceDepart;
		else this.endurance += staminaNumber;
	}
	
	/**
	 * Cette méthode permet de rajouter des points de chance, sans excéder leur total de départ.
	 * @param luckNumber
	 */
	public void addLuck(int luckNumber) {
		if(this.luck + luckNumber > this.chanceDepart) this.luck = this.chanceDepart;
		else this.luck += luckNumber;
	}
	
	/**
	 * Cette méthode permet de retirer un point de chance, sans descendre en dessous de 0.
	 * @param luckNumber
	 */
	public void decrementChance() {
		if(this.luck - 1 < 0) this.luck = 0;
		else this.luck--;
	}
	
	/**
	 * Cette méthode permet de retirer des points de chance, sans descendre en dessous de 0.
	 * @param luckNumber
	 */
	public void decreaseLuck(int luckNumber) {
		if(this.luck - luckNumber < 0) this.luck = 0;
		else this.luck -= luckNumber;
	}
	
	public void addGold(int goldCoinsNumber) {
		int currentGoldCoins = this.getOr();
		currentGoldCoins += goldCoinsNumber;
		this.setGoldCoins(currentGoldCoins);
	}
	
	public void decreaseGold(int goldCoinsNumber) {
		int currentGoldCoins = this.getOr();
		if(currentGoldCoins - goldCoinsNumber < 0) throw new IllegalStateException();
		currentGoldCoins -= goldCoinsNumber;
		this.setGoldCoins(currentGoldCoins);
	}
	
	public void addEquipment(String equipmentName) {
		this.getEquipment().add(equipmentName);
		if(equipmentName.equalsIgnoreCase("Épée à la lame d'acier")) {
			this.habileteDepart += 2;
			this.habilete += 2;
		}
	}
	
	public void removeEquipment(String equipmentName) {
		this.getEquipment().remove(equipmentName);
		if(equipmentName.equalsIgnoreCase("Épée à la lame d'acier")) {
			this.habileteDepart -= 2;
			this.habilete -= 2;
		}
	}
	
	public void addTreasure(String treasureName) {
		this.getTreasure().add(treasureName);
	}
	
	public void removeTreasure(String treasureName) {
		this.getTreasure().remove(treasureName);
	}
	
	public void addProvision(int provisionNumber) {
		this.provisions += provisionNumber;
	}
	
	public void removeProvision(int provisionNumber) {
		this.provisions -= provisionNumber;
	}
	
	public void takeMeal() {
		this.provisions--;
		if(this.endurance + 4 > this.enduranceDepart) this.endurance = this.enduranceDepart;
		else this.endurance +=4;
	}
	
	public void shareMeal() {
		this.provisions--;
		if(this.endurance + 2 > this.enduranceDepart) this.endurance = this.enduranceDepart;
		else this.endurance +=2;
	}
	
	public ArrayList<String> getEquipmentAndTreasure(){
		ArrayList<String> listEquipmentAndTreasure = new ArrayList<>();
		listEquipmentAndTreasure.addAll(equipmentList);
		listEquipmentAndTreasure.addAll(treasureList);
		return listEquipmentAndTreasure;
	}
	
}