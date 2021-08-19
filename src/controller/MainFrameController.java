package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import data.Ennemi;
import data.Hero;
import gui.MainFrame;
import temp.Numero;
import temp.Utilitaire;
import tramereader.MainReader;

public class MainFrameController {
	
	private MainFrame mainFrame;
	private MainReader mainReader;
	private Hero pj;
	private Numero currentNumero;
	private String[] currentAction;
	private Ennemi currentEnnemi;
	private int nombreEnnemi;
	private int numeroCombat;
	private int valueDicesPj;
	private int valueDicesEnnemi;
	
	public MainFrameController() throws IOException {
		mainFrame = new MainFrame();
		mainReader = new MainReader();
		// Héros à créer autrement
		pj = new Hero("James",8,21,6);
		startController();
		setHero();
	}
	
	// Getter
	
	public MainFrame getMainFrame() {
		return this.mainFrame;
	}
	
	public MainReader getMainReader() {
		return this.mainReader;
	}
	
	public Hero getPj() {
		return this.pj;
	}
	
	// Méthodes
	
	public void startController() {
		mainFrame.start();
		mainFrame.getStartButton().addActionListener(new StartButtonListener());
		seNumerotListener();
	}
	
	public void setHero() {
		mainFrame.getNomHero().setText(pj.getNom());
		mainFrame.getHabileteHero().setText(mainFrame.getHabileteHero().getText()+pj.getHabilete());
		mainFrame.getEnduranceHero().setText(mainFrame.getEnduranceHero().getText()+pj.getEndurance());
		mainFrame.getChanceHero().setText(mainFrame.getChanceHero().getText()+pj.getChance());
		mainFrame.getOrHero().setText(mainFrame.getOrHero().getText()+pj.getOr());
		mainFrame.getProvisionHero().setText(mainFrame.getProvisionHero().getText()+pj.getProvision());
		String equipmentString = "";
		for(int i = 0 ; i < pj.getEquipment().size() ; i++) {
			if(i != pj.getEquipment().size()-1) equipmentString += pj.getEquipment().get(i)+"\n";
			else equipmentString += pj.getEquipment().get(i);
		}
		mainFrame.getEquipementHero().setText(equipmentString);
	}
	
	public void majHero() {
		mainFrame.getHabileteHero().setText("Habileté : "+pj.getHabilete());
		mainFrame.getEnduranceHero().setText("Endurance : "+pj.getEndurance());
		mainFrame.getChanceHero().setText("Chance : "+pj.getChance());
		mainFrame.getOrHero().setText("Or : "+pj.getOr());
		mainFrame.getProvisionHero().setText("Provisions : "+pj.getProvision());
		String equipmentString = "";
		for(int i = 0 ; i < pj.getEquipment().size() ; i++) {
			if(i != pj.getEquipment().size()-1) equipmentString += pj.getEquipment().get(i)+"\n";
			else equipmentString += pj.getEquipment().get(i);
		}
		mainFrame.getEquipementHero().setText(equipmentString);
	}
	
	public void setEnnemi() {
		currentEnnemi = new Ennemi(currentAction[1], Integer.parseInt(currentAction[2]), Integer.parseInt(currentAction[3]));
		mainFrame.getNomEnnemi().setText(currentAction[1]);
		mainFrame.getHabileteEnnemi().setText("Habileté : "+currentAction[2]);
		mainFrame.getEnduranceEnnemi().setText("Endurance : "+currentAction[3]);
	}
	
	public void setEnnemiX() {
		numeroCombat++;
		int i = 0;
		if(numeroCombat == 1) i = 1;
		else if(numeroCombat == 2) i = 7;
		else if(numeroCombat == 3) i = 13;
		else if(numeroCombat == 4) i = 19;
		else if(numeroCombat == 5) i = 25;
		currentEnnemi = new Ennemi(currentAction[i], Integer.parseInt(currentAction[i+1]), Integer.parseInt(currentAction[i+2]));
		mainFrame.getNomEnnemi().setText(currentAction[i]);
		mainFrame.getHabileteEnnemi().setText("Habileté : "+currentAction[i+1]);
		mainFrame.getEnduranceEnnemi().setText("Endurance : "+currentAction[i+2]);
	}
	
	public void majEnnemi() {
		mainFrame.getHabileteEnnemi().setText("Habileté : "+currentEnnemi.getHabilete());
		mainFrame.getEnduranceEnnemi().setText("Endurance : "+currentEnnemi.getEndurance());
	}
	
	public void calculNombreEnnemi() {
		nombreEnnemi = 0;
		for(int i = 0 ; i < currentAction.length ; i++) {
			if(currentAction[i].equalsIgnoreCase("FIGHTX")) nombreEnnemi++;
		}
	}
	
	public void setTextNumero(Numero numero) {
		Numero[] tableauNumeroSuivant = new Numero[numero.getEnsembleNumeroSuivants().size()];
		numero.getEnsembleNumeroSuivants().toArray(tableauNumeroSuivant);
		switch(tableauNumeroSuivant.length) {
		case 1:
			mainFrame.getNext1Button().setText(tableauNumeroSuivant[0].getNumero()+"");
			mainFrame.getNext1Button().setActionCommand(tableauNumeroSuivant[0].getNumero()+"");
			break;
		case 2:
			mainFrame.getNext1Button().setText(tableauNumeroSuivant[0].getNumero()+"");
			mainFrame.getNext1Button().setActionCommand(tableauNumeroSuivant[0].getNumero()+"");
			mainFrame.getNext2Button().setText(tableauNumeroSuivant[1].getNumero()+"");
			mainFrame.getNext2Button().setActionCommand(tableauNumeroSuivant[1].getNumero()+"");
			break;
		case 3:
			mainFrame.getNext1Button().setText(tableauNumeroSuivant[0].getNumero()+"");
			mainFrame.getNext1Button().setActionCommand(tableauNumeroSuivant[0].getNumero()+"");
			mainFrame.getNext2Button().setText(tableauNumeroSuivant[1].getNumero()+"");
			mainFrame.getNext2Button().setActionCommand(tableauNumeroSuivant[1].getNumero()+"");
			mainFrame.getNext3Button().setText(tableauNumeroSuivant[2].getNumero()+"");
			mainFrame.getNext3Button().setActionCommand(tableauNumeroSuivant[2].getNumero()+"");
			break;
		case 4:
			mainFrame.getNext1Button().setText(tableauNumeroSuivant[0].getNumero()+"");
			mainFrame.getNext1Button().setActionCommand(tableauNumeroSuivant[0].getNumero()+"");
			mainFrame.getNext2Button().setText(tableauNumeroSuivant[1].getNumero()+"");
			mainFrame.getNext2Button().setActionCommand(tableauNumeroSuivant[1].getNumero()+"");
			mainFrame.getNext3Button().setText(tableauNumeroSuivant[2].getNumero()+"");
			mainFrame.getNext3Button().setActionCommand(tableauNumeroSuivant[2].getNumero()+"");
			mainFrame.getNext4Button().setText(tableauNumeroSuivant[3].getNumero()+"");
			mainFrame.getNext4Button().setActionCommand(tableauNumeroSuivant[3].getNumero()+"");
			break;
		case 5:
			mainFrame.getNext1Button().setText(tableauNumeroSuivant[0].getNumero()+"");
			mainFrame.getNext1Button().setActionCommand(tableauNumeroSuivant[0].getNumero()+"");
			mainFrame.getNext2Button().setText(tableauNumeroSuivant[1].getNumero()+"");
			mainFrame.getNext2Button().setActionCommand(tableauNumeroSuivant[1].getNumero()+"");
			mainFrame.getNext3Button().setText(tableauNumeroSuivant[2].getNumero()+"");
			mainFrame.getNext3Button().setActionCommand(tableauNumeroSuivant[2].getNumero()+"");
			mainFrame.getNext4Button().setText(tableauNumeroSuivant[3].getNumero()+"");
			mainFrame.getNext4Button().setActionCommand(tableauNumeroSuivant[3].getNumero()+"");
			mainFrame.getNext5Button().setText(tableauNumeroSuivant[4].getNumero()+"");
			mainFrame.getNext5Button().setActionCommand(tableauNumeroSuivant[4].getNumero()+"");
			break;
		default:
			break;
		}
	}
	
	public void seNumerotListener() {
		mainFrame.getNext1Button().addActionListener(new NumeroButtonListener());
		mainFrame.getNext2Button().addActionListener(new NumeroButtonListener());
		mainFrame.getNext3Button().addActionListener(new NumeroButtonListener());
		mainFrame.getNext4Button().addActionListener(new NumeroButtonListener());
		mainFrame.getNext5Button().addActionListener(new NumeroButtonListener());
	}
	
	public boolean testChance() {
		int resultat = pj.calculScoreChance();
		pj.decrementChance();
		if(resultat >= 0) return true;
		else return false;
	}
	
	public void setAction(String keyWord) {
		switch(keyWord) {
		case "NEXT":
			for(int i = 1 ; i < currentAction.length ; i++) {
				currentNumero.addNumero(Integer.parseInt(currentAction[i]));
			}
			mainFrame.resetAffichage();
			mainFrame.setNextButton(currentNumero.getEnsembleNumeroSuivants().size());
			setTextNumero(currentNumero);
			break;
		case "TEST":
			mainFrame.setNextButton(0);
			mainFrame.setTest();
			mainFrame.getAleatoireButton().addActionListener(new TestAleatoireButtonListener());
			switch(currentAction[1]) {
			case "SKILL":
				mainFrame.setTestHabilete();
				break;
			case "STAMINA":
				mainFrame.setTestEndurance();
				break;
			case "LUCK":
				mainFrame.setTestChance();
				break;
			default:
				System.out.println("ERROR");
				break;
			}
			mainFrame.resetAffichage();
			break;
		case "FIGHT":
			mainFrame.setNextButton(0);
			mainFrame.setFight();
			setEnnemi();
			nombreEnnemi = 1;
			numeroCombat = 1;
			mainFrame.getAleatoireButton().addActionListener(new FightXAleatoireButtonListener());
			break;
		case "FIGHTX":
			mainFrame.setNextButton(0);
			mainFrame.setFight();
			numeroCombat = 0;
			setEnnemiX();
			calculNombreEnnemi();
			mainFrame.getAleatoireButton().addActionListener(new FightAleatoireButtonListener());
			break;
		case "LOOT":
			currentNumero.addNumero(Integer.parseInt(currentAction[1]));
			mainFrame.setNextButton(currentNumero.getEnsembleNumeroSuivants().size());
			setTextNumero(currentNumero);
			for(int i = 2 ; i < currentAction.length ; i++) {
				switch(currentAction[i]) {
				case "LUCK":
					i++;
					pj.addLuck(Integer.parseInt(currentAction[i]));
					majHero();
					break;
				case "GOLD":
					i++;
					pj.addGold(Integer.parseInt(currentAction[i]));
					majHero();
					break;
				case "EQUIPMENT":
					i++;
					pj.addEquipment(currentAction[i]);
					majHero();
					break;
				}
			}
			break;
		case "MALUS":
			switch(currentAction[1]) {
			case "SKILL":
				break;
			case "STAMINA":
				pj.recevoirDegats(Integer.parseInt(currentAction[2]));
				majHero();
				break;
			case "LUCK":
				break;
			default:
				System.out.println("ERROR");
				break;
			}
			currentNumero.addNumero(Integer.parseInt(currentAction[3]));
			mainFrame.setNextButton(currentNumero.getEnsembleNumeroSuivants().size());
			setTextNumero(currentNumero);
			break;
		case "CHOICE":
			int compteur = 1;
			if(currentAction[1].equalsIgnoreCase("ESCAPE")) {
				mainFrame.setNextButton(0);
				mainFrame.setFightOrEscape();
			}
			else {
				while(Utilitaire.isNumeric(currentAction[compteur])) {
					currentNumero.addNumero(Integer.parseInt(currentAction[compteur]));
					compteur++;
				}
				mainFrame.resetAffichage();
				mainFrame.setNextButton(currentNumero.getEnsembleNumeroSuivants().size());
				setTextNumero(currentNumero);
				switch(currentAction[compteur]) {
				case "TEST":
					mainFrame.setTest();
					mainFrame.getAleatoireButton().addActionListener(new TestAleatoireChoiceButtonListener());
					switch(currentAction[compteur+1]) {
					case "SKILL":
						mainFrame.setTestHabilete();
						break;
					case "STAMINA":
						mainFrame.setTestEndurance();
						break;
					case "LUCK":
						mainFrame.setTestChance();
						break;
					default:
						System.out.println("ERROR");
						break;
					}
					mainFrame.resetAffichage();
					break;
				default:
					System.out.println("ERROR");
					break;
				}
			}
			break;
		default:
			System.out.println("ERROR");
			break;
		}
	}
	
	// Listener ----------------------------------------------------------------------------------------------------------------------------------------------
	
	class StartButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			try {
				currentNumero = new Numero(1);
				currentAction = mainReader.readAction(currentNumero, pj);
				for(int i = 1 ; i < currentAction.length ; i++) {
					currentNumero.addNumero(Integer.parseInt(currentAction[i]));
				}
				mainFrame.resetAffichage();
				mainFrame.setNextButton(currentNumero.getEnsembleNumeroSuivants().size());
				setTextNumero(currentNumero);
			} 
			catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	class NumeroButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			try {
				mainFrame.getInteractionPanel().removeAll();
				String numEnCours = e.getActionCommand();
				for(Numero numero : currentNumero.getEnsembleNumeroSuivants()) {
					if(numero.getNumero() == Integer.parseInt(numEnCours)) {
						currentNumero = numero;
						break;
					}
				}
				currentAction = mainReader.readAction(currentNumero, pj);
				setAction(currentAction[0]);
			} 
			catch (IOException e1) {
				e1.printStackTrace();
			}
			mainFrame.getInteractionPanel().revalidate();
			mainFrame.getInteractionPanel().repaint();
		}
	}

	class TestAleatoireButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			mainFrame.getInteractionPanel().removeAll();
			int valueDice1 = Utilitaire.lancerSix();
			int valueDice2 = Utilitaire.lancerSix();
			int valueDices = valueDice1 + valueDice2;
			System.out.println(valueDices);
			switch(currentAction[1]) {
			case "SKILL":
				if(valueDices <= pj.getHabilete()) {
					mainFrame.setNextButton(1);
					currentNumero.addNumero(Integer.parseInt(currentAction[2]));
					setTextNumero(currentNumero);
				}
				else {
					mainFrame.setNextButton(1);
					currentNumero.addNumero(Integer.parseInt(currentAction[3]));
					setTextNumero(currentNumero);
				}
				break;
			case "LUCK":
				mainFrame.setNextButton(1);
				mainFrame.setTestChanceAleatoire();
				if(valueDices <= pj.getChance()) {
					currentNumero.addNumero(Integer.parseInt(currentAction[2]));
					mainFrame.getResultatAleatoireTestLabel().setText("Réussite !");
					mainFrame.getResultatAleatoireTestLabel().setForeground(Color.GREEN);
				}
				else {
					currentNumero.addNumero(Integer.parseInt(currentAction[3]));
					mainFrame.getResultatAleatoireTestLabel().setText("Échec !");
					mainFrame.getResultatAleatoireTestLabel().setForeground(Color.RED);
				}
				setTextNumero(currentNumero);
				pj.decrementChance();
				majHero();
				break;
			default:
				System.out.println("ERROR");
				break;
			}
			mainFrame.getInteractionPanel().revalidate();
			mainFrame.getInteractionPanel().repaint();
		}
	}
	
	class TestAleatoireChoiceButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			mainFrame.getInteractionPanel().removeAll();
			int valueDice1 = Utilitaire.lancerSix();
			int valueDice2 = Utilitaire.lancerSix();
			int valueDices = valueDice1 + valueDice2;
			System.out.println(valueDices);
			currentNumero.getEnsembleNumeroSuivants().clear();
			switch(currentAction[3]) {
			case "SKILL":
				mainFrame.setNextButton(1);
				if(valueDices <= pj.getHabilete()) {
					currentNumero.addNumero(Integer.parseInt(currentAction[4]));
				}
				else {
					currentNumero.addNumero(Integer.parseInt(currentAction[5]));
				}
				setTextNumero(currentNumero);
				break;
			case "LUCK":
				mainFrame.setNextButton(1);
				mainFrame.setTestChanceAleatoire();
				if(valueDices <= pj.getChance()) {
					currentNumero.addNumero(Integer.parseInt(currentAction[4]));
					mainFrame.getResultatAleatoireTestLabel().setText("Réussite !");
					mainFrame.getResultatAleatoireTestLabel().setForeground(Color.GREEN);
				}
				else {
					currentNumero.addNumero(Integer.parseInt(currentAction[5]));
					mainFrame.getResultatAleatoireTestLabel().setText("Échec !");
					mainFrame.getResultatAleatoireTestLabel().setForeground(Color.RED);
				}
				setTextNumero(currentNumero);
				pj.decrementChance();
				majHero();
				break;
			default:
				System.out.println("ERROR");
				break;
			}
			mainFrame.getInteractionPanel().revalidate();
			mainFrame.getInteractionPanel().repaint();
		}
	}
	
	class FightAleatoireButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			mainFrame.getMainFightPanel().removeAll();
			int valueDice1Ennemi = Utilitaire.lancerSix();
			int valueDice2Ennemi = Utilitaire.lancerSix();
			valueDicesEnnemi = currentEnnemi.getHabilete() + valueDice1Ennemi + valueDice2Ennemi;
			System.out.println("ennemi : "+valueDicesEnnemi);
			int valueDice1Pj = Utilitaire.lancerSix();
			int valueDice2Pj = Utilitaire.lancerSix();
			valueDicesPj = pj.getHabilete() + valueDice1Pj + valueDice2Pj;
			System.out.println("pj : "+valueDicesPj);
			if(valueDicesPj != valueDicesEnnemi) {
				mainFrame.setFightAleatoire();
				mainFrame.getOuiTenterChanceFight().addActionListener(new OuiTenterChanceFightButtonListener());
				mainFrame.getNonTenterChanceFight().addActionListener(new NonTenterChanceFightButtonListener());
			}
			if(valueDicesPj > valueDicesEnnemi) {
				mainFrame.getResultatAssaut().setText("Assaut remporté !");
				mainFrame.getResultatAssaut().setForeground(new Color(103,221,51));
			}
			else if(valueDicesPj < valueDicesEnnemi) {
				mainFrame.getResultatAssaut().setText("Assaut perdu...");
				mainFrame.getResultatAssaut().setForeground(Color.RED);
			}
			else {
				mainFrame.setFightAleatoireEgalite();
				mainFrame.getResultatAssaut().setText("Égalité !");
				mainFrame.getContinuer().addActionListener(new AssautSuivantEgaliteListener());
				mainFrame.getResultatAssaut().setForeground(new Color(57,147,232));
			}
			mainFrame.getMainFightPanel().revalidate();
			mainFrame.getMainFightPanel().repaint();
		}
	}
	
	class FightXAleatoireButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			mainFrame.getMainFightPanel().removeAll();
			int valueDice1Ennemi = Utilitaire.lancerSix();
			int valueDice2Ennemi = Utilitaire.lancerSix();
			valueDicesEnnemi = currentEnnemi.getHabilete() + valueDice1Ennemi + valueDice2Ennemi;
			System.out.println("ennemi : "+valueDicesEnnemi);
			int valueDice1Pj = Utilitaire.lancerSix();
			int valueDice2Pj = Utilitaire.lancerSix();
			valueDicesPj = pj.getHabilete() + valueDice1Pj + valueDice2Pj;
			System.out.println("pj : "+valueDicesPj);
			if(valueDicesPj != valueDicesEnnemi) {
				mainFrame.setFightAleatoire();
				mainFrame.getOuiTenterChanceFight().addActionListener(new OuiTenterChanceFightButtonListener());
				mainFrame.getNonTenterChanceFight().addActionListener(new NonTenterChanceFightButtonListener());
			}
			if(valueDicesPj > valueDicesEnnemi) {
				mainFrame.getResultatAssaut().setText("Assaut remporté !");
				mainFrame.getResultatAssaut().setForeground(new Color(103,221,51));
			}
			else if(valueDicesPj < valueDicesEnnemi) {
				mainFrame.getResultatAssaut().setText("Assaut perdu...");
				mainFrame.getResultatAssaut().setForeground(Color.RED);
			}
			else {
				mainFrame.setFightAleatoireEgalite();
				mainFrame.getResultatAssaut().setText("Égalité !");
				mainFrame.getContinuer().addActionListener(new AssautSuivantEgaliteListener());
				mainFrame.getResultatAssaut().setForeground(new Color(57,147,232));
			}
			mainFrame.getMainFightPanel().revalidate();
			mainFrame.getMainFightPanel().repaint();
		}
	}
	
	class AssautSuivantEgaliteListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			mainFrame.getMainFightPanel().removeAll();
			mainFrame.majFight();
			mainFrame.getAleatoireButton().addActionListener(new FightAleatoireButtonListener());
			mainFrame.getMainFightPanel().revalidate();
			mainFrame.getMainFightPanel().repaint();
		}
	}
	
	class AssautSuivantChanceListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			mainFrame.getMainFightPanel().removeAll();
			mainFrame.majFight();
			mainFrame.getAleatoireButton().addActionListener(new FightAleatoireButtonListener());
			mainFrame.getMainFightPanel().revalidate();
			mainFrame.getMainFightPanel().repaint();
		}
	}
	
	class OuiTenterChanceFightButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			mainFrame.getMainFightPanel().removeAll();
			mainFrame.setTenterChanceFight();
			mainFrame.getAleatoireButton().addActionListener(new OuiTenterChanceAleatoireFightButtonListener());
			mainFrame.setTestChance();
			mainFrame.getMainFightPanel().revalidate();
			mainFrame.getMainFightPanel().repaint();
		}
	}
	
	class NonTenterChanceFightButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			mainFrame.getMainFightPanel().removeAll();
			if(valueDicesPj > valueDicesEnnemi) {
				currentEnnemi.recevoirDegats(2);
				if(currentEnnemi.getEndurance() > 0) majEnnemi();
				else {
					currentEnnemi.setEndurance(0);
					majEnnemi();
					if(numeroCombat != nombreEnnemi) {
						mainFrame.setNextFight();
						mainFrame.getNextFightButton().addActionListener(new NextEnnemiButtonListener());
					}
					else {
						mainFrame.setFightWin();
						mainFrame.setNextButton(1);
						currentNumero.addNumero(Integer.parseInt(currentAction[currentAction.length-2]));
						setTextNumero(currentNumero);
					}
				}
			}
			else if(valueDicesPj < valueDicesEnnemi) {
				pj.recevoirDegats(2);
				if(pj.getEndurance() > 0) majHero();
				else {
					pj.setEndurance(0);
					majHero();
					mainFrame.setFightGameOver();
				}
			}
			if(currentEnnemi.getEndurance() > 0 && pj.getEndurance() > 0) {
				mainFrame.majFight();
				mainFrame.getAleatoireButton().addActionListener(new FightAleatoireButtonListener());
			}
			mainFrame.getMainFightPanel().revalidate();
			mainFrame.getMainFightPanel().repaint();
		}
	}
	
	class OuiTenterChanceAleatoireFightButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			mainFrame.getMainFightPanel().removeAll();
			int valueDice1 = Utilitaire.lancerSix();
			int valueDice2 = Utilitaire.lancerSix();
			int valueDices = valueDice1 + valueDice2;
			mainFrame.setResultatChanceFight();
			if(valueDicesPj > valueDicesEnnemi) {
				if(valueDices <= pj.getChance()) {
					mainFrame.getResultatChance().setText("Réussite !");
					mainFrame.getResultatChance().setForeground(new Color(103,221,51));
					currentEnnemi.recevoirDegats(4);
				}
				else {
					mainFrame.getResultatChance().setText("Échec !");
					mainFrame.getResultatChance().setForeground(Color.RED);
					currentEnnemi.recevoirDegats(1);
				}
				if(currentEnnemi.getEndurance() > 0) majEnnemi();
				else {
					currentEnnemi.setEndurance(0);
					majEnnemi();
					if(numeroCombat != nombreEnnemi) {
						mainFrame.setNextFight();
						mainFrame.getNextFightButton().addActionListener(new NextEnnemiButtonListener());
					}
					else {
						mainFrame.setFightWin();
						mainFrame.setNextButton(1);
						currentNumero.addNumero(Integer.parseInt(currentAction[currentAction.length-2]));
						setTextNumero(currentNumero);
					}
				}
			}
			else if(valueDicesPj < valueDicesEnnemi) {
				if(valueDices <= pj.getChance()) {
					mainFrame.getResultatChance().setText("Réussite !");
					mainFrame.getResultatChance().setForeground(new Color(103,221,51));
					pj.recevoirDegats(1);
				}
				else {
					mainFrame.getResultatChance().setText("Échec !");
					mainFrame.getResultatChance().setForeground(Color.RED);
					pj.recevoirDegats(3);
				}
				if(pj.getEndurance() > 0) majHero();
				else {
					pj.setEndurance(0);
					majHero();
					mainFrame.setFightGameOver();
				}
			}
			if(currentEnnemi.getEndurance() > 0 && pj.getEndurance() > 0) {
				mainFrame.getContinuer().addActionListener(new AssautSuivantChanceListener());
			}
			mainFrame.getMainFightPanel().revalidate();
			mainFrame.getMainFightPanel().repaint();
		}
	}
	
	class NextEnnemiButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			mainFrame.getMainFightPanel().removeAll();
			setEnnemiX();
			mainFrame.majFight();
			mainFrame.getAleatoireButton().addActionListener(new FightAleatoireButtonListener());
			mainFrame.getMainFightPanel().revalidate();
			mainFrame.getMainFightPanel().repaint();
		}
	}
}