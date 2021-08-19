package data;

import java.util.ArrayList;

import temp.Utilitaire;

public class Hero extends Personnage {
	
	private int chance;
	private int or;
	private int provisions;
	private ArrayList<String> equipmentList;

	public Hero(String nom, int habilete, int endurance, int chance) {
		super(nom, habilete, endurance);
		this.chance = chance;
		this.or = 1;
		this.provisions = 10;
		this.equipmentList = new ArrayList<>();
		this.equipmentList.add("Épée");
		this.equipmentList.add("Armure de Cuir");
		this.equipmentList.add("Sac à Dos");
		this.equipmentList.add("Lanterne");
	}
	
	// Getters & Setter

	public int getChance() {
		return chance;
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
	
	public void setChance(int chance) {
		this.chance = chance;
	}
	
	public void setGoldCoins(int goldCoinsNumber) {
		this.or = goldCoinsNumber;
	}
	
	// Méthodes
	
	public String toString() {
		return "["+this.nom+", Habileté : "+this.habilete+", Endurance : "+this.endurance+", Chance : "+this.chance+"]";
	}
	
	public int modifierEndurance(int nombre) {
		int endurance = this.getEndurance();
		endurance -= nombre;
		this.setEndurance(endurance);
		return endurance;
	}
	
	public int decrementChance() {
		int chance = this.getChance();
		chance--;
		this.setChance(chance);
		return chance;
	}
	
	public int calculScoreChance() {
		return chance - Utilitaire.doubleLancerSix();
	}
	
	public int attaquer(Personnage personnage, int scoreChance) {
		if(scoreChance >= 0) {
			return personnage.recevoirDegats(4);
		}
		else return personnage.recevoirDegats(1);
	}
	
	public void addLuck(int luckNumber) {
		int currentLuck = this.getChance();
		currentLuck += luckNumber;
		this.setChance(currentLuck);
	}
	
	public void decreaseLuck(int goldCoinsNumber) {
		int currentGoldCoins = this.getOr();
		currentGoldCoins -= goldCoinsNumber;
		this.setGoldCoins(currentGoldCoins);
	}
	
	public void addGold(int goldCoinsNumber) {
		int currentGoldCoins = this.getOr();
		currentGoldCoins += goldCoinsNumber;
		this.setGoldCoins(currentGoldCoins);
	}
	
	public void decreaseGold(int goldCoinsNumber) {
		int currentGoldCoins = this.getOr();
		currentGoldCoins -= goldCoinsNumber;
		this.setGoldCoins(currentGoldCoins);
	}
	
	public void addEquipment(String equipmentName) {
		this.getEquipment().add(equipmentName);
	}

}
