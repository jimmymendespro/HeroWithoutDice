package data;

import java.util.HashSet;

/**
 * Représente un numéro du livre dans son ensemble avec les numéros suivants associés.
 * @author Jimmy Mendes
 */
public class Numero {
	
	private int numero;
	private HashSet<Numero> ensembleNumeroSuivants;
	
	public Numero(int numero) {
		this.numero = numero;
		ensembleNumeroSuivants = new HashSet<>();
	}
	
	// Getters & Setter -----------------------------------------------------------------------------------------------------------------------------------

	public int getNumero() {
		return numero;
	}

	public HashSet<Numero> getEnsembleNumeroSuivants() {
		return ensembleNumeroSuivants;
	}

	// Methods ----------------------------------------------------------------------------------------------------------------------------------------------
	
	public String toString() {
		String retour = "";
		for(Numero num : ensembleNumeroSuivants) {
			retour +=" "+num.getNumero();
		}
		return numero +" -"+ retour;
	}
	
	/**
	 * Ajoute un numéro suivant à ensembleNumeroSuivants.
	 * @param nombre
	 */
	public void addNumero(int nombre) {
		this.ensembleNumeroSuivants.add(new Numero(nombre));
	}
	
}