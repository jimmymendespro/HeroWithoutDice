package temp;

import java.util.HashSet;

public class Livre {
	
	private String nom;
	
	public Livre(String nom) {
		this.nom = nom;
	}
	
	// Getter
	
	public String getNom() {
		return this.nom;
	}
	
	// Méthodes
	
	public static HashSet<Integer> extractionNumeros(String numerosPointsVirgule) {
		HashSet<Integer> ensembleNumero = new HashSet<>();
		for(int i = 0 ; i < numerosPointsVirgule.length() ; i++) {
			if(numerosPointsVirgule.charAt(i) == ';') {
				ensembleNumero.add(Integer.parseInt(numerosPointsVirgule.substring(0,i)));
				ensembleNumero.addAll(extractionNumeros(numerosPointsVirgule.substring(i+1)));
				break;
			}
			else if(i == numerosPointsVirgule.length()-1) {
				ensembleNumero.add(Integer.parseInt(numerosPointsVirgule));
			}
		}
		return ensembleNumero;
	}
	
}