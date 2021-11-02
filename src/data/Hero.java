package data;

import java.util.ArrayList;

/**
 * Classe représentant le personnage que le joueur incarne avec toute ses propriétés.
 * <p>Le personnage est créé de base avec :
 * <ul><li>Son nom indiqué par le joueur</li>
 * <li>Son habileté/skill indiqué par le joueur</li>
 * <li>Son endurance/stamina indiqué par le joueur</li>
 * <li>Sa chance/luck indiqué par le joueur</li>
 * <li>Une pièce d'or</li>
 * <li>Dix provisions</li>
 * <li>Un équipement de base (épée, armure de cuir, sac à dos et lanterne</li></ul>
 * <p>Le pj possède deux ArrayList<String>, un pour l'équipement, et un pour les trésors ramassés</p>
 * @author Jimmy Mendes
 */
public class Hero extends Character {
	
	private int startingSkill;
	private int startingStamina;
	private int startingLuck;
	private int luck;
	private int gold;
	private int provisions;
	private ArrayList<String> equipmentList;
	private ArrayList<String> treasureList;

	public Hero(String name, int skill, int stamina, int luck) {
		super(name, skill, stamina);
		this.startingSkill = skill;
		this.startingStamina = stamina;
		this.luck = luck;
		this.startingLuck = luck;
		this.gold = 1;
		this.provisions = 10;
		this.equipmentList = new ArrayList<>();
		this.equipmentList.add("Épée");
		this.equipmentList.add("Armure de Cuir");
		this.equipmentList.add("Sac à Dos");
		this.equipmentList.add("Lanterne");
		this.treasureList = new ArrayList<>();
	}
	
	// Getters & Setter -----------------------------------------------------------------------------------------------------------------------------------
	
	public int getStartingSkill() {
		return startingSkill;
	}
	
	public int getStartingStamina() {
		return startingStamina;
	}

	public int getLuck() {
		return luck;
	}
	
	public int getStartingLuck() {
		return startingLuck;
	}
	
	public int getGold() {
		return this.gold;
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
	
	public void setLuck(int luck) {
		this.luck = luck;
	}
	
	// Exceptions -------------------------------------------------------------------------------------------------------------------------------------------------
	
	@SuppressWarnings("serial")
	class EquipmentNotFindException extends IllegalArgumentException {}
	@SuppressWarnings("serial")
	class TreasureNotFindException extends IllegalArgumentException {}
	@SuppressWarnings("serial")
	class NotEnoughProvisionException extends IllegalArgumentException {}
	
	// Methods ----------------------------------------------------------------------------------------------------------------------------------------------------
	
	public String toString() {
		return "["+this.name+", Habileté : "+this.skill+", Endurance : "+this.stamina+", Chance : "+this.luck+"]";
	}
	
	/**
	 * Permet d'ajouter des points de skill, sans excéder leur total de départ.
	 * @param skillNumber
	 */
	public void addSkill(int skillNumber) {
		if(this.skill + skillNumber > this.startingSkill) this.skill = this.startingSkill;
		else this.skill += skillNumber;
	}
	
	/**
	 * Retire un nombre de point d'habileté au Héros.
	 * <p>Le nombre de point de skill ne peut être en dessous de 0.</p>
	 * @param skillNumber
	 */
	public void decreaseSkill(int skillNumber) {
		if(this.skill - skillNumber < 0) this.skill = 0;
		else this.skill -= skillNumber;
	}
	
	/**
	 * Permet d'ajouter des points de stamina, sans excéder leur total de départ.
	 * @param staminaNumber
	 */
	public void addStamina(int staminaNumber) {
		if(this.stamina + staminaNumber > this.startingStamina) this.stamina = this.startingStamina;
		else this.stamina += staminaNumber;
	}
	
	/**
	 * Cette méthode permet d'ajouter des points de chance, sans excéder leur total de départ.
	 * @param luckNumber
	 */
	public void addLuck(int luckNumber) {
		if(this.luck + luckNumber > this.startingLuck) this.luck = this.startingLuck;
		else this.luck += luckNumber;
	}
	
	/**
	 * Cette méthode permet de retirer des points de chance, sans descendre en dessous de 0.
	 * @param luckNumber
	 */
	public void decreaseLuck(int luckNumber) {
		if(this.luck - luckNumber < 0) this.luck = 0;
		else this.luck -= luckNumber;
	}
	
	/**
	 * Cette méthode permet de retirer un point de chance, sans descendre en dessous de 0.
	 * @param luckNumber
	 */
	public void decrementLuck() {
		if(this.luck - 1 < 0) this.luck = 0;
		else this.luck--;
	}
	
	/**
	 * Ajoute une quantité d'or à la valeur d'or du Héro
	 * @param goldCoinsNumber
	 */
	public void addGold(int goldCoinsNumber) {
		this.gold += goldCoinsNumber;
	}
	
	/**
	 * Soustrait la quantité d'or passée en entrée à la valeur d'or actuelle du héro.
	 * @throws IllegalStateException si la valeur actuelle de l'or - l'or à retirer < 0
	 * @param goldCoinsNumber
	 */
	public void decreaseGold(int goldCoinsNumber) {
		if(this.gold - goldCoinsNumber < 0) throw new IllegalStateException();
		this.gold -= goldCoinsNumber;
	}
	
	/**
	 * Permet de rajouter une pièce d'équipement à equipmentList.
	 * <p>L'ajout de la pièce d'équipement "Épée à la lame d'acier" ajoute +2 sur skill/startingSkill</p>
	 * @param equipmentName
	 */
	public void addEquipment(String equipmentName) {
		this.getEquipment().add(equipmentName);
		if(equipmentName.equalsIgnoreCase("Épée à la lame d'acier")) {
			this.startingSkill += 2;
			this.skill += 2;
		}
	}
	
	/**
	 * Permet de retirer un équipement de equipmentList.
	 * <p>Le retrait de la pièce d'équipement "Épée à la lame d'acier" retire -2 sur skill/startingSkill</p>
	 * @throws EquipmentNotFindException si l'équipement n'est pas présent dans equipmentList
	 * @param equipmentName
	 */
	public void removeEquipment(String equipmentName) {
		if(!this.equipmentList.contains(equipmentName)) throw new EquipmentNotFindException();
		this.getEquipment().remove(equipmentName);
		if(equipmentName.equalsIgnoreCase("Épée à la lame d'acier")) {
			this.startingSkill -= 2;
			this.skill -= 2;
		}
	}
	
	/**
	 * Permet de rajouter un trésor à treasureList.
	 * @param treasureName
	 */
	public void addTreasure(String treasureName) {
		this.treasureList.add(treasureName);
	}
	
	/**
	 * Permet de retirer un trésor de treasureList.
	 * @throws TreasureNotFindException si le trésor n'est pas présent dans treasureList
	 * @param treasureName
	 */
	public void removeTreasure(String treasureName) {
		if(!this.treasureList.contains(treasureName)) throw new TreasureNotFindException();
		this.treasureList.remove(treasureName);
	}
	
	/**
	 * Ajoute un nombre de provision.
	 * @param provisionNumber
	 */
	public void addProvision(int provisionNumber) {
		this.provisions += provisionNumber;
	}
	
	/**
	 * Permet de retirer un certain nombre de provisions.
	 * @throws NotEnoughProvisionException si le nombre de provision à retirer fait descendre le total en dessous de 0.
	 * @param provisionNumber
	 */
	public void removeProvision(int provisionNumber) {
		if(this.provisions - provisionNumber < 0) throw new NotEnoughProvisionException();
		this.provisions -= provisionNumber;
	}
	
	/**
	 * Permet de prendre un repas.
	 * <p>On retire un provision et on ajoute 4 à la stamina. 
	 * Attention, si le +4 dépasse le total de départ, on ajoute uniquement jusqu'à atteindre le startingStamina</p>
	 */
	public void takeMeal() {
		this.provisions--;
		if(this.stamina + 4 > this.startingStamina) this.stamina = this.startingStamina;
		else this.stamina +=4;
	}
	
	/**
	 * Permet de partager un repas.
	 * <p>On retire un provision et on ajoute 2 à la stamina. 
	 * Attention, si le +2 dépasse le total de départ, on ajoute uniquement jusqu'à atteindre le startingStamina</p>
	 */
	public void shareMeal() {
		this.provisions--;
		if(this.stamina + 2 > this.startingStamina) this.stamina = this.startingStamina;
		else this.stamina +=2;
	}
	
	/**
	 * Permet de retourner un ArrayList<String> contenant l'ensemble de l'équipement ET des trésors du Héro.
	 * @return listEquipmentAndTreasure
	 */
	public ArrayList<String> getEquipmentAndTreasure(){
		ArrayList<String> listEquipmentAndTreasure = new ArrayList<>();
		listEquipmentAndTreasure.addAll(equipmentList);
		listEquipmentAndTreasure.addAll(treasureList);
		return listEquipmentAndTreasure;
	}
	
}