package data;

import java.util.HashSet;

/**
 * Repr�sente un num�ro du livre dans son ensemble avec les num�ros suivants associ�s.
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
	 * Ajoute un num�ro suivant � ensembleNumeroSuivants.
	 * @param nombre
	 */
	public void addNumero(int nombre) {
		this.ensembleNumeroSuivants.add(new Numero(nombre));
	}
	
}