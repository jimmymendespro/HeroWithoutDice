package tramereader;

import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import data.Numero;

public class MainReader {
	
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