package utilities;

import javax.swing.JButton;

/**
 * Ensemble divers de méthodes utilitaire.
 * @author Jimmy Mendes
 */
public abstract class Utilitaire {
	
	/**
	 * Permet d'obtenir un nombre au hasard entre 1 et 6.
	 * @return int entre 1 et 6
	 */
	public static int lancerSix() {
		double aleat = Math.random();
		if(aleat < 0.166666) return 1;
		else if(aleat < 0.333333) return 2;
		else if(aleat < 0.5) return 3;
		else if(aleat < 0.666666) return 4;
		else if(aleat < 0.833333) return 5;
		else return 6;
	}
	
	/**
	 * Permet d'obtenir un nombre au hasard entre 2 et 12.
	 * @return int entre 2 et 12
	 */
	public static int doubleLancerSix() {
		int premierLancer = lancerSix();
		int secondLancer = lancerSix();
		return premierLancer + secondLancer;
	}
	
	/**
	 * Teste si un string est numérique ou non.
	 * @param chaine
	 * @return true si la chaine est numérique, false sinon.
	 */
	public static boolean isNumeric(String chaine) {
		try {
			Integer.parseInt(chaine);
			return true;
		}
		catch(NumberFormatException e) {
			return false;
		}
	}
	
	/**
	 * Permet de supprimer l'ensemble des ActionListeners d'un JButton.
	 * @param button
	 */
	public static void removeAllListeners(JButton button) {
		while(button.getActionListeners().length > 0) {
			button.removeActionListener(button.getActionListeners()[0]);
		}
	}

}