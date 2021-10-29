package data;

import java.util.HashSet;

public class Numero {
	
	private int numero;
	private HashSet<Numero> ensembleNumeroSuivants;
	
	public Numero(int numero) {
		this.numero = numero;
		ensembleNumeroSuivants = new HashSet<>();
	}
	
	// Getters et Setter

	public int getNumero() {
		return numero;
	}

	public HashSet<Numero> getEnsembleNumeroSuivants() {
		return ensembleNumeroSuivants;
	}

	// Méthodes
	
	public String toString() {
		String retour = "";
		for(Numero num : ensembleNumeroSuivants) {
			retour +=" "+num.getNumero();
		}
		return numero +" -"+ retour;
	}
	
	public void addNumero(int nombre) {
		this.ensembleNumeroSuivants.add(new Numero(nombre));
	}
	
	public void fromIntegerToNumero(HashSet<Integer> ensembleNombre) {
		for(Integer nombre : ensembleNombre) {
			this.ensembleNumeroSuivants.add(new Numero(nombre));
		}
	}
	
}
