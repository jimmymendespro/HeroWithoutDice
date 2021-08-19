package data;

public abstract class Personnage {
	
	protected String nom;
	protected int habilete;
	protected int endurance;
	
	public Personnage(String nom, int habilete, int endurance) {
		this.nom = nom;
		this.habilete = habilete;
		this.endurance = endurance;
	}
	
	// Getters et Setters
	
	public String getNom() {
		return nom;
	}
	
	public int getHabilete() {
		return habilete;
	}
	
	public int getEndurance() {
		return endurance;
	}

	public void setHabilete(int habilete) {
		this.habilete = habilete;
	}

	public void setEndurance(int endurance) {
		this.endurance = endurance;
	}
	
	// M�thodes
	
	public int recevoirDegats(int nombreDeDegats) {
		int endurance = this.getEndurance();
		endurance -= nombreDeDegats;
		this.setEndurance(endurance);
		return endurance;
	}
	
	public int attaquer(Personnage personnage) {
		return personnage.recevoirDegats(2);
	}
	
	public String toString() {
		return "["+this.nom+", Habilet� : "+this.habilete+", Endurance : "+this.endurance+"]";
	}
	
}