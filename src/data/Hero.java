package data;

import java.util.ArrayList;

/**
 * Classe repr�sentant le personnage que le joueur incarne avec toute ses propri�t�s.
 * <p>Le personnage est cr�� de base avec :
 * <ul><li>Son nom indiqu� par le joueur</li>
 * <li>Son habilet�/skill indiqu� par le joueur</li>
 * <li>Son endurance/stamina indiqu� par le joueur</li>
 * <li>Sa chance/luck indiqu� par le joueur</li>
 * <li>Une pi�ce d'or</li>
 * <li>Dix provisions</li>
 * <li>Un �quipement de base (�p�e, armure de cuir, sac � dos et lanterne</li></ul>
 * <p>Le pj poss�de deux ArrayList<String>, un pour l'�quipement, et un pour les tr�sors ramass�s</p>
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
		this.equipmentList.add("�p�e");
		this.equipmentList.add("Armure de Cuir");
		this.equipmentList.add("Sac � Dos");
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
		return "["+this.name+", Habilet� : "+this.skill+", Endurance : "+this.stamina+", Chance : "+this.luck+"]";
	}
	
	/**
	 * Permet d'ajouter des points de skill, sans exc�der leur total de d�part.
	 * @param skillNumber
	 */
	public void addSkill(int skillNumber) {
		if(this.skill + skillNumber > this.startingSkill) this.skill = this.startingSkill;
		else this.skill += skillNumber;
	}
	
	/**
	 * Retire un nombre de point d'habilet� au H�ros.
	 * <p>Le nombre de point de skill ne peut �tre en dessous de 0.</p>
	 * @param skillNumber
	 */
	public void decreaseSkill(int skillNumber) {
		if(this.skill - skillNumber < 0) this.skill = 0;
		else this.skill -= skillNumber;
	}
	
	/**
	 * Permet d'ajouter des points de stamina, sans exc�der leur total de d�part.
	 * @param staminaNumber
	 */
	public void addStamina(int staminaNumber) {
		if(this.stamina + staminaNumber > this.startingStamina) this.stamina = this.startingStamina;
		else this.stamina += staminaNumber;
	}
	
	/**
	 * Cette m�thode permet d'ajouter des points de chance, sans exc�der leur total de d�part.
	 * @param luckNumber
	 */
	public void addLuck(int luckNumber) {
		if(this.luck + luckNumber > this.startingLuck) this.luck = this.startingLuck;
		else this.luck += luckNumber;
	}
	
	/**
	 * Cette m�thode permet de retirer des points de chance, sans descendre en dessous de 0.
	 * @param luckNumber
	 */
	public void decreaseLuck(int luckNumber) {
		if(this.luck - luckNumber < 0) this.luck = 0;
		else this.luck -= luckNumber;
	}
	
	/**
	 * Cette m�thode permet de retirer un point de chance, sans descendre en dessous de 0.
	 * @param luckNumber
	 */
	public void decrementLuck() {
		if(this.luck - 1 < 0) this.luck = 0;
		else this.luck--;
	}
	
	/**
	 * Ajoute une quantit� d'or � la valeur d'or du H�ro
	 * @param goldCoinsNumber
	 */
	public void addGold(int goldCoinsNumber) {
		this.gold += goldCoinsNumber;
	}
	
	/**
	 * Soustrait la quantit� d'or pass�e en entr�e � la valeur d'or actuelle du h�ro.
	 * @throws IllegalStateException si la valeur actuelle de l'or - l'or � retirer < 0
	 * @param goldCoinsNumber
	 */
	public void decreaseGold(int goldCoinsNumber) {
		if(this.gold - goldCoinsNumber < 0) throw new IllegalStateException();
		this.gold -= goldCoinsNumber;
	}
	
	/**
	 * Permet de rajouter une pi�ce d'�quipement � equipmentList.
	 * <p>L'ajout de la pi�ce d'�quipement "�p�e � la lame d'acier" ajoute +2 sur skill/startingSkill</p>
	 * @param equipmentName
	 */
	public void addEquipment(String equipmentName) {
		this.getEquipment().add(equipmentName);
		if(equipmentName.equalsIgnoreCase("�p�e � la lame d'acier")) {
			this.startingSkill += 2;
			this.skill += 2;
		}
	}
	
	/**
	 * Permet de retirer un �quipement de equipmentList.
	 * <p>Le retrait de la pi�ce d'�quipement "�p�e � la lame d'acier" retire -2 sur skill/startingSkill</p>
	 * @throws EquipmentNotFindException si l'�quipement n'est pas pr�sent dans equipmentList
	 * @param equipmentName
	 */
	public void removeEquipment(String equipmentName) {
		if(!this.equipmentList.contains(equipmentName)) throw new EquipmentNotFindException();
		this.getEquipment().remove(equipmentName);
		if(equipmentName.equalsIgnoreCase("�p�e � la lame d'acier")) {
			this.startingSkill -= 2;
			this.skill -= 2;
		}
	}
	
	/**
	 * Permet de rajouter un tr�sor � treasureList.
	 * @param treasureName
	 */
	public void addTreasure(String treasureName) {
		this.treasureList.add(treasureName);
	}
	
	/**
	 * Permet de retirer un tr�sor de treasureList.
	 * @throws TreasureNotFindException si le tr�sor n'est pas pr�sent dans treasureList
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
	 * @throws NotEnoughProvisionException si le nombre de provision � retirer fait descendre le total en dessous de 0.
	 * @param provisionNumber
	 */
	public void removeProvision(int provisionNumber) {
		if(this.provisions - provisionNumber < 0) throw new NotEnoughProvisionException();
		this.provisions -= provisionNumber;
	}
	
	/**
	 * Permet de prendre un repas.
	 * <p>On retire un provision et on ajoute 4 � la stamina. 
	 * Attention, si le +4 d�passe le total de d�part, on ajoute uniquement jusqu'� atteindre le startingStamina</p>
	 */
	public void takeMeal() {
		this.provisions--;
		if(this.stamina + 4 > this.startingStamina) this.stamina = this.startingStamina;
		else this.stamina +=4;
	}
	
	/**
	 * Permet de partager un repas.
	 * <p>On retire un provision et on ajoute 2 � la stamina. 
	 * Attention, si le +2 d�passe le total de d�part, on ajoute uniquement jusqu'� atteindre le startingStamina</p>
	 */
	public void shareMeal() {
		this.provisions--;
		if(this.stamina + 2 > this.startingStamina) this.stamina = this.startingStamina;
		else this.stamina +=2;
	}
	
	/**
	 * Permet de retourner un ArrayList<String> contenant l'ensemble de l'�quipement ET des tr�sors du H�ro.
	 * @return listEquipmentAndTreasure
	 */
	public ArrayList<String> getEquipmentAndTreasure(){
		ArrayList<String> listEquipmentAndTreasure = new ArrayList<>();
		listEquipmentAndTreasure.addAll(equipmentList);
		listEquipmentAndTreasure.addAll(treasureList);
		return listEquipmentAndTreasure;
	}
	
}