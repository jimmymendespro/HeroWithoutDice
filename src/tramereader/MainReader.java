package tramereader;

import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import data.Numero;

/**
 * Classe regroupant les m�thodes permettant d'extraire les instructions de LSDLMDF.txt.
 * @author Jimmy Mendes
 */
public class MainReader {
	
	/**
	 * Permet d'extraire les instructions du num�ro en entr�e.
	 * <p>La m�thode recherche dans le texte la chaine *numero(int).<br/>
	 * Une fois trouv�e, elle envoie le streamTokenizer � la m�thode toStringArray</p>
	 * @param numero
	 * @return ArrayList<String> contenant toutes les instructions du num�ro en entr�e.
	 * @throws IOException
	 */
	public ArrayList<String> readAction(Numero numero) throws IOException {
		ArrayList<String> retourAction;
		int numeroPage = numero.getNumero();
		FileReader monLecteur = new FileReader("LSDLMDF.txt",StandardCharsets.UTF_8);
		StreamTokenizer monTokenizer = new StreamTokenizer(monLecteur);
		monTokenizer.nextToken();
		while(monTokenizer.ttype != StreamTokenizer.TT_EOF) {
			if(monTokenizer.ttype == '*') {
				monTokenizer.nextToken();
				if(monTokenizer.ttype == StreamTokenizer.TT_NUMBER && numeroPage == (int)monTokenizer.nval) {
					monTokenizer.nextToken();	
					retourAction = toStringArray(monTokenizer);
					monLecteur.close();
					return retourAction;
				}
			}
			monTokenizer.nextToken();
		}
		monLecteur.close();
		return null;
	}
	
	/**
	 * Extrait les instructions de la ligne en cours et les place dans un ArrayList<String>.
	 * @param monTokenizer
	 * @return ArrayList<String> contenant toutes les instructions de la ligne en cours.
	 * @throws IOException
	 */
	public static ArrayList<String> toStringArray(StreamTokenizer monTokenizer) throws IOException {
		ArrayList<String> retourListe = new ArrayList<>();
		retourListe.add(monTokenizer.sval);
		monTokenizer.nextToken();
		while(monTokenizer.ttype == '\'') {
			retourListe.add(monTokenizer.sval);
			monTokenizer.nextToken();
		}
		return retourListe;
	}
}