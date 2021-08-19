package tramereader;

import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;

import data.Hero;
import temp.Numero;

public class MainReader {
	
	public String[] readAction(Numero numero, Hero pj) throws IOException {
		String[] retourAction;
		int numeroPage = numero.getNumero();
		FileReader monLecteur = new FileReader("LSDLMDF.txt",StandardCharsets.UTF_8);
		StreamTokenizer monTokenizer = new StreamTokenizer(monLecteur);
		monTokenizer.nextToken();
		while(monTokenizer.ttype != StreamTokenizer.TT_EOF) {
			if(monTokenizer.ttype == '*') {
				monTokenizer.nextToken();
				if(monTokenizer.ttype == StreamTokenizer.TT_NUMBER && numeroPage == (int)monTokenizer.nval) {
					monTokenizer.nextToken();
					if(monTokenizer.ttype == StreamTokenizer.TT_WORD && monTokenizer.sval.equalsIgnoreCase("NEXT")) {
						retourAction = caseNext(monTokenizer, numero);
						monLecteur.close();
						return retourAction;
					}
					else if(monTokenizer.ttype == StreamTokenizer.TT_WORD && monTokenizer.sval.equalsIgnoreCase("TEST")) {
						retourAction = caseTest(monTokenizer);
						monLecteur.close();
						return retourAction;
					}
					else if(monTokenizer.ttype == StreamTokenizer.TT_WORD && monTokenizer.sval.equalsIgnoreCase("FIGHT")) {
						retourAction = caseFight(monTokenizer);
						monLecteur.close();
						return retourAction;
					}
					else if(monTokenizer.ttype == StreamTokenizer.TT_WORD && monTokenizer.sval.equalsIgnoreCase("FIGHTX")) {
						retourAction = caseFightX(monTokenizer);
						monLecteur.close();
						return retourAction;
					}
					else if(monTokenizer.ttype == StreamTokenizer.TT_WORD && monTokenizer.sval.equalsIgnoreCase("LOOT")) {
						retourAction = caseLoot(monTokenizer);
						monLecteur.close();
						return retourAction;
					}
					else if(monTokenizer.ttype == StreamTokenizer.TT_WORD && monTokenizer.sval.equalsIgnoreCase("MALUS")) {
						retourAction = caseMalus(monTokenizer);
						monLecteur.close();
						return retourAction;
					}
					else if(monTokenizer.ttype == StreamTokenizer.TT_WORD && monTokenizer.sval.equalsIgnoreCase("CHOICE")) {
						retourAction = caseChoice(monTokenizer);
						monLecteur.close();
						return retourAction;
					}
					/*else if(monTokenizer.ttype == StreamTokenizer.TT_WORD && monTokenizer.sval.equalsIgnoreCase("GAMEOVER")) {
						return "GAMEOVER";	
					}*/
				}
			}
			monTokenizer.nextToken();
		}
		monLecteur.close();
		retourAction = new String[1];
		return retourAction;
	}
	
	public static String[] caseNext(StreamTokenizer monTokenizer, Numero numero) throws IOException {
		HashSet<String> ensembleNumerosSuivants = new HashSet<>();
		monTokenizer.nextToken();
		while(monTokenizer.ttype == '\'') {
			ensembleNumerosSuivants.add(monTokenizer.sval);
			monTokenizer.nextToken();
		}
		String[] retour = new String[ensembleNumerosSuivants.size()+1];
		retour[0] = "NEXT";
		int compteur = 1;
		for(String num : ensembleNumerosSuivants) {
			retour[compteur] = num;
			compteur++;
		}
		return retour;
	}
	
	public static String[] caseTest(StreamTokenizer monTokenizer) throws IOException {
		String[] retour = new String[4];
		retour[0] = "TEST";
		int compteur = 1;
		monTokenizer.nextToken();
		while(monTokenizer.ttype == '\'') {
			retour[compteur] = monTokenizer.sval;
			compteur++;
			monTokenizer.nextToken();
		}
		return retour;
	}
	
	public static String[] caseFight(StreamTokenizer monTokenizer) throws IOException {
		String[] retour = new String[6];
		retour[0] = "FIGHT";
		int compteur = 1;
		monTokenizer.nextToken();
		while(monTokenizer.ttype == '\'') {
			retour[compteur] = monTokenizer.sval;
			compteur++;
			monTokenizer.nextToken();
		}
		return retour;
	}
	
	public static String[] caseFightX(StreamTokenizer monTokenizer) throws IOException {
		ArrayList<String> retourListe = new ArrayList<>();
		retourListe.add("FIGHTX");
		int compteur = 1;
		monTokenizer.nextToken();
		while(monTokenizer.ttype == '\'') {
			retourListe.add(monTokenizer.sval);
			compteur++;
			monTokenizer.nextToken();
		}
		String[] retourTableau = new String[compteur];
		for(int i = 0 ; i < retourTableau.length ; i++) {
			retourTableau[i] = retourListe.get(i);
		}
		return retourTableau;
	}
	
	public static String[] caseLoot(StreamTokenizer monTokenizer) throws IOException {
		ArrayList<String> retourListe = new ArrayList<>();
		retourListe.add("LOOT");
		int compteur = 1;
		monTokenizer.nextToken();
		while(monTokenizer.ttype == '\'') {
			retourListe.add(monTokenizer.sval);
			compteur++;
			monTokenizer.nextToken();
		}
		String[] retourTableau = new String[compteur];
		for(int i = 0 ; i < retourTableau.length ; i++) {
			retourTableau[i] = retourListe.get(i);
		}
		return retourTableau;
	}
	
	public static String[] caseMalus(StreamTokenizer monTokenizer) throws IOException {
		String[] retour = new String[4];
		retour[0] = "MALUS";
		int compteur = 1;
		monTokenizer.nextToken();
		while(monTokenizer.ttype == '\'') {
			retour[compteur] = monTokenizer.sval;
			compteur++;
			monTokenizer.nextToken();
		}
		return retour;
	}
	
	public static String[] caseChoice(StreamTokenizer monTokenizer) throws IOException {
		ArrayList<String> retourListe = new ArrayList<>();
		retourListe.add("CHOICE");
		int compteur = 1;
		monTokenizer.nextToken();
		while(monTokenizer.ttype == '\'') {
			retourListe.add(monTokenizer.sval);
			compteur++;
			monTokenizer.nextToken();
		}
		String[] retourTableau = new String[compteur];
		for(int i = 0 ; i < retourTableau.length ; i++) {
			retourTableau[i] = retourListe.get(i);
		}
		return retourTableau;
	}
	
	/*public static void caseTest(StreamTokenizer monTokenizer, Numero numero, Hero pj) throws IOException {
		monTokenizer.nextToken();
		if(monTokenizer.sval.equalsIgnoreCase("SKILL")) {
			
		}
		else if(monTokenizer.sval.equalsIgnoreCase("STAMINA")) {
			
		}
		else if(monTokenizer.sval.equalsIgnoreCase("LUCK")) {
			// test luck
			boolean luck = true;
			if(luck) {
				monTokenizer.nextToken();
				System.out.println(monTokenizer.sval);
				numero.fromIntegerToNumero(Livre.extractionNumeros(monTokenizer.sval));
				monTokenizer.nextToken();
				if(monTokenizer.nval != 0) {
					int nombreConsequenceChance = (int)monTokenizer.nval;
					monTokenizer.nextToken();
					if(monTokenizer.sval.equalsIgnoreCase("SKILL")) {
						
					}
					else if(monTokenizer.sval.equalsIgnoreCase("STAMINA")) {
						pj.modifierEndurance(nombreConsequenceChance);
					}
					else if(monTokenizer.sval.equalsIgnoreCase("LUCK")) {
						
					}
				}
			}
			else {
				monTokenizer.nextToken();
				monTokenizer.nextToken();
				monTokenizer.nextToken();
				if(monTokenizer.ttype == StreamTokenizer.TT_WORD) monTokenizer.nextToken();
				System.out.println(monTokenizer.sval);
				numero.fromIntegerToNumero(Livre.extractionNumeros(monTokenizer.sval));
				monTokenizer.nextToken();
				if(monTokenizer.nval != 0) {
					int nombreConsequenceChance = (int)monTokenizer.nval;
					monTokenizer.nextToken();
					if(monTokenizer.sval.equalsIgnoreCase("SKILL")) {
						
					}
					else if(monTokenizer.sval.equalsIgnoreCase("STAMINA")) {
						pj.modifierEndurance(-nombreConsequenceChance);
					}
					else if(monTokenizer.sval.equalsIgnoreCase("LUCK")) {
						
					}
				}
			}
		}
	}*/
	
	/*public void readTest(Numero numero, Hero pj) throws IOException {
	FileReader monLecteur = new FileReader("LSDLMDF.txt");
	int numeroPage = numero.getNumero();
	StreamTokenizer monTokenizer = new StreamTokenizer(monLecteur);
	monTokenizer.nextToken();
	while(monTokenizer.ttype != StreamTokenizer.TT_EOF) {
		if(monTokenizer.ttype == '*') {
			monTokenizer.nextToken();
			if(monTokenizer.ttype == StreamTokenizer.TT_NUMBER && numeroPage == (int)monTokenizer.nval) {
				do {
					monTokenizer.nextToken();
					if(monTokenizer.ttype == StreamTokenizer.TT_WORD && monTokenizer.sval.equalsIgnoreCase("NEXT")) {
						caseNext(monTokenizer, numero);
						monLecteur.close();
						return;
					}
					else if(monTokenizer.ttype == StreamTokenizer.TT_WORD && monTokenizer.sval.equalsIgnoreCase("TEST")) {
						caseTest(monTokenizer, numero, pj);
						monLecteur.close();
						return;
					}
					else if(monTokenizer.ttype == StreamTokenizer.TT_WORD && monTokenizer.sval.equalsIgnoreCase("GAMEOVER")) {
						
					}
				}while(!monTokenizer.sval.equalsIgnoreCase("NEXT"));
			}
		}
		monTokenizer.nextToken();
	}
	monLecteur.close();
}*/

}