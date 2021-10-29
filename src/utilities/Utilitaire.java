package utilities;

import javax.swing.JButton;

public class Utilitaire {
	
	public static int lancerSix() {
		double aleat = Math.random();
		if(aleat < 0.166666) return 1;
		else if(aleat < 0.333333) return 2;
		else if(aleat < 0.5) return 3;
		else if(aleat < 0.666666) return 4;
		else if(aleat < 0.833333) return 5;
		else return 6;
	}
	
	public static int doubleLancerSix() {
		int premierLancer = lancerSix();
		int secondLancer = lancerSix();
		return premierLancer + secondLancer;
	}
	
	public static boolean isNumeric(String chaine) {
		try {
			Integer.parseInt(chaine);
			return true;
		}
		catch(NumberFormatException e) {
			return false;
		}
	}
	
	public static void removeAllListeners(JButton button) {
		while(button.getActionListeners().length > 0) {
			button.removeActionListener(button.getActionListeners()[0]);
		}
	}

}