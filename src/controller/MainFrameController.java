package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import data.Ennemi;
import data.Hero;
import data.Numero;
import gui.MainFrame;
import tramereader.MainReader;
import utilities.Utilitaire;

public class MainFrameController {
	
	private MainReader mainReader;
	
	private NewCharacterPanelController newCharacterController;
	private HeroPanelController heroPanelController;
	private MainFrame mainFrame;
	
	private Hero pj;
	private Numero currentNumero;
	private int previousNumber;
	private ArrayList<String> currentAction;
	private ArrayList<String> tempAction;
	private Ennemi currentEnnemi;
	private int nombreEnnemi;
	private int numeroCombat;
	private int nombreAssaut;
	private int valueDicesPj;
	private int valueDicesEnnemi;
	private int bet;
	private int ghoulWound = 0;
	private boolean waitingForUser = false;
	private int visitedCount = 0;
	private int testCount = 0;
	private boolean visited27 = false;
	private boolean visited72 = false;
	private boolean visited110 = false;
	private boolean visited132 = false;
	private boolean visited170 = false;
	private boolean visited179AndKill = false;
	private boolean visited206 = false;
	private boolean visited227 = false;
	private boolean visited294 = false;
	private boolean goldChoice = false;
	private boolean coupBloque = false;
	private boolean gambleBonus = false;
	
	public MainFrameController() throws IOException {
		mainFrame = new MainFrame();
		mainReader = new MainReader();
		startController();
	}
	
	// Methods ----------------------------------------------------------------------------------------------------------------------------------------------
	
	public void startController() {
		mainFrame.setMenu();
		mainFrame.getMenu().getNewGame().addActionListener(new NewHeroListener());
		mainFrame.getMenu().getLoadGame().addActionListener(null);
		mainFrame.getMenu().getExitGame().addActionListener(new MainExitListener());
	}
	
	public void setNewHeroListeners() {
		mainFrame.getNewCharacter().getValidateNewHero().addActionListener(new ValiderNewHeroListener());
		mainFrame.getNewCharacter().getExitNewHero().addActionListener(new ExitNewHeroListener());
	}
	
	public void startGame() {
		mainFrame.start();
		heroPanelController = new HeroPanelController(mainFrame.getHeroPanel(), pj);
		mainFrame.getStartButton().addActionListener(new StartButtonListener());
		setNumerotListener();
	}

	public void setEnnemi() {
		currentEnnemi = new Ennemi(currentAction.get(1), Integer.parseInt(currentAction.get(2)), Integer.parseInt(currentAction.get(3)));
		mainFrame.getEnnemiPanel().getEnnemiName().setText(currentAction.get(1));
		mainFrame.getEnnemiPanel().getEnnemiSkill().setText("Habileté : "+currentAction.get(2));
		mainFrame.getEnnemiPanel().getEnnemiStamina().setText("Endurance : "+currentAction.get(3));
		if(Integer.parseInt(currentAction.get(5)) == -1) mainFrame.getEnnemiPanel().getEscape().setVisible(false);
		else if(Integer.parseInt(currentAction.get(5)) != -1 && Integer.parseInt(currentAction.get(6)) == -1) {
			mainFrame.getEnnemiPanel().getEscape().setVisible(true);
			mainFrame.getEnnemiPanel().getEscape().setEnabled(true);
			mainFrame.getEnnemiPanel().getEscape().addActionListener(new FuiteCombatButtonListener());
		}
		else {
			mainFrame.getEnnemiPanel().getEscape().setVisible(true);
			mainFrame.getEnnemiPanel().getEscape().setEnabled(false);
			mainFrame.getEnnemiPanel().getEscape().addActionListener(new FuiteCombatButtonListener());
		}
	}
	
	public void setRandomEnnemi(String ennemiName, int ennemiSkill, int ennemiStamina) {
		currentEnnemi = new Ennemi(ennemiName, ennemiSkill, ennemiStamina);
		mainFrame.getEnnemiPanel().getEnnemiName().setText(ennemiName);
		mainFrame.getEnnemiPanel().getEnnemiSkill().setText("Habileté : "+ennemiSkill);
		mainFrame.getEnnemiPanel().getEnnemiStamina().setText("Endurance : "+ennemiStamina);
		mainFrame.getEnnemiPanel().getEscape().setVisible(false);
	}
	
	public void setChoiceEnnemi() {
		currentEnnemi = new Ennemi(currentAction.get(4), Integer.parseInt(currentAction.get(5)), Integer.parseInt(currentAction.get(6)));
		mainFrame.getEnnemiPanel().getEnnemiName().setText(currentAction.get(4));
		mainFrame.getEnnemiPanel().getEnnemiSkill().setText("Habileté : "+currentAction.get(5));
		mainFrame.getEnnemiPanel().getEnnemiStamina().setText("Endurance : "+currentAction.get(6));
		if(Integer.parseInt(currentAction.get(8)) == -1) mainFrame.getEnnemiPanel().getEscape().setVisible(false);
		else {
			mainFrame.getEnnemiPanel().getEscape().setVisible(true);
			mainFrame.getEnnemiPanel().getEscape().setEnabled(true);
			mainFrame.getEnnemiPanel().getEscape().addActionListener(new FuiteCombatButtonListener());
		}
	}
	
	public void setEnnemiX() {
		numeroCombat++;
		int i = 0;
		if(numeroCombat == 1) i = 1;
		else if(numeroCombat == 2) i = 7;
		else if(numeroCombat == 3) i = 13;
		else if(numeroCombat == 4) i = 19;
		else if(numeroCombat == 5) i = 25;
		currentEnnemi = new Ennemi(currentAction.get(i), Integer.parseInt(currentAction.get(i+1)), Integer.parseInt(currentAction.get(i+2)));
		mainFrame.getEnnemiPanel().getEnnemiName().setText(currentAction.get(i));
		mainFrame.getEnnemiPanel().getEnnemiSkill().setText("Habileté : "+currentAction.get(i+1));
		mainFrame.getEnnemiPanel().getEnnemiStamina().setText("Endurance : "+currentAction.get(i+2));
		if(Integer.parseInt(currentAction.get(i+4)) == -1) mainFrame.getEnnemiPanel().getEscape().setVisible(false);
		else if(currentNumero.getNumero() == 230) mainFrame.getEnnemiPanel().getEscape().setVisible(false);
		else {
			mainFrame.getEnnemiPanel().getEscape().setVisible(true);
			mainFrame.getEnnemiPanel().getEscape().setEnabled(true);
			mainFrame.getEnnemiPanel().getEscape().addActionListener(new FuiteCombatButtonListener());
		}
	}
	
	public void majEnnemi() {
		mainFrame.getEnnemiPanel().getEnnemiSkill().setText("Habileté : "+currentEnnemi.getSkill());
		mainFrame.getEnnemiPanel().getEnnemiStamina().setText("Endurance : "+currentEnnemi.getStamina());
	}
	
	public void calculNombreEnnemi() {
		nombreEnnemi = 0;
		for(int i = 0 ; i < currentAction.size() ; i++) {
			if(currentAction.get(i).equalsIgnoreCase("FIGHTX")) nombreEnnemi++;
		}
	}
	
	public void setTextNumero(Numero numero) {
		Numero[] tableauNumeroSuivant = new Numero[numero.getEnsembleNumeroSuivants().size()];
		numero.getEnsembleNumeroSuivants().toArray(tableauNumeroSuivant);
		switch(tableauNumeroSuivant.length) {
		case 1:
			mainFrame.getNextNumberPanel().getNextNumber1().setText(tableauNumeroSuivant[0].getNumero()+"");
			mainFrame.getNextNumberPanel().getNextNumber1().setActionCommand(tableauNumeroSuivant[0].getNumero()+"");
			break;
		case 2:
			mainFrame.getNextNumberPanel().getNextNumber1().setText(tableauNumeroSuivant[0].getNumero()+"");
			mainFrame.getNextNumberPanel().getNextNumber1().setActionCommand(tableauNumeroSuivant[0].getNumero()+"");
			mainFrame.getNextNumberPanel().getNextNumber2().setText(tableauNumeroSuivant[1].getNumero()+"");
			mainFrame.getNextNumberPanel().getNextNumber2().setActionCommand(tableauNumeroSuivant[1].getNumero()+"");
			break;
		case 3:
			mainFrame.getNextNumberPanel().getNextNumber1().setText(tableauNumeroSuivant[0].getNumero()+"");
			mainFrame.getNextNumberPanel().getNextNumber1().setActionCommand(tableauNumeroSuivant[0].getNumero()+"");
			mainFrame.getNextNumberPanel().getNextNumber2().setText(tableauNumeroSuivant[1].getNumero()+"");
			mainFrame.getNextNumberPanel().getNextNumber2().setActionCommand(tableauNumeroSuivant[1].getNumero()+"");
			mainFrame.getNextNumberPanel().getNextNumber3().setText(tableauNumeroSuivant[2].getNumero()+"");
			mainFrame.getNextNumberPanel().getNextNumber3().setActionCommand(tableauNumeroSuivant[2].getNumero()+"");
			break;
		case 4:
			mainFrame.getNextNumberPanel().getNextNumber1().setText(tableauNumeroSuivant[0].getNumero()+"");
			mainFrame.getNextNumberPanel().getNextNumber1().setActionCommand(tableauNumeroSuivant[0].getNumero()+"");
			mainFrame.getNextNumberPanel().getNextNumber2().setText(tableauNumeroSuivant[1].getNumero()+"");
			mainFrame.getNextNumberPanel().getNextNumber2().setActionCommand(tableauNumeroSuivant[1].getNumero()+"");
			mainFrame.getNextNumberPanel().getNextNumber3().setText(tableauNumeroSuivant[2].getNumero()+"");
			mainFrame.getNextNumberPanel().getNextNumber3().setActionCommand(tableauNumeroSuivant[2].getNumero()+"");
			mainFrame.getNextNumberPanel().getNextNumber4().setText(tableauNumeroSuivant[3].getNumero()+"");
			mainFrame.getNextNumberPanel().getNextNumber4().setActionCommand(tableauNumeroSuivant[3].getNumero()+"");
			break;
		case 5:
			mainFrame.getNextNumberPanel().getNextNumber1().setText(tableauNumeroSuivant[0].getNumero()+"");
			mainFrame.getNextNumberPanel().getNextNumber1().setActionCommand(tableauNumeroSuivant[0].getNumero()+"");
			mainFrame.getNextNumberPanel().getNextNumber2().setText(tableauNumeroSuivant[1].getNumero()+"");
			mainFrame.getNextNumberPanel().getNextNumber2().setActionCommand(tableauNumeroSuivant[1].getNumero()+"");
			mainFrame.getNextNumberPanel().getNextNumber3().setText(tableauNumeroSuivant[2].getNumero()+"");
			mainFrame.getNextNumberPanel().getNextNumber3().setActionCommand(tableauNumeroSuivant[2].getNumero()+"");
			mainFrame.getNextNumberPanel().getNextNumber4().setText(tableauNumeroSuivant[3].getNumero()+"");
			mainFrame.getNextNumberPanel().getNextNumber4().setActionCommand(tableauNumeroSuivant[3].getNumero()+"");
			mainFrame.getNextNumberPanel().getNextNumber5().setText(tableauNumeroSuivant[4].getNumero()+"");
			mainFrame.getNextNumberPanel().getNextNumber5().setActionCommand(tableauNumeroSuivant[4].getNumero()+"");
			break;
		default:
			break;
		}
	}
		
	public void setLootText() {
		int compteur = 0;
		for(int i = 1 ; i < currentAction.size() ; i++) {
			if(currentAction.get(i).equalsIgnoreCase("GOLD")) compteur++;
			else if(currentAction.get(i).equalsIgnoreCase("EQUIPMENT")) compteur++;
			else if(currentAction.get(i).equalsIgnoreCase("TREASURE")) compteur++;
		}
		switch(compteur) {
		case 1:
			if(currentAction.get(1).equalsIgnoreCase("GOLD")) mainFrame.getInteractionPanel().getLoot1Button().setText(currentAction.get(2)+" Or");
			else mainFrame.getInteractionPanel().getLoot1Button().setText(currentAction.get(2));
			if(currentAction.get(1).equalsIgnoreCase("GOLD")) mainFrame.getInteractionPanel().getLoot1Button().setActionCommand("GOLD");
			else mainFrame.getInteractionPanel().getLoot1Button().setActionCommand(currentAction.get(2));
			break;
		case 2:
			if(currentAction.get(1).equalsIgnoreCase("GOLD")) mainFrame.getInteractionPanel().getLoot1Button().setText(currentAction.get(2)+" Or");
			else mainFrame.getInteractionPanel().getLoot1Button().setText(currentAction.get(2));
			if(currentAction.get(1).equalsIgnoreCase("GOLD")) mainFrame.getInteractionPanel().getLoot1Button().setActionCommand("GOLD");
			else mainFrame.getInteractionPanel().getLoot1Button().setActionCommand(currentAction.get(2));
			
			if(currentAction.get(3).equalsIgnoreCase("GOLD")) mainFrame.getInteractionPanel().getLoot1Button().setText(currentAction.get(4)+" Or");
			else mainFrame.getInteractionPanel().getLoot2Button().setText(currentAction.get(4));
			if(currentAction.get(3).equalsIgnoreCase("GOLD")) mainFrame.getInteractionPanel().getLoot2Button().setActionCommand("GOLD");
			else mainFrame.getInteractionPanel().getLoot2Button().setActionCommand(currentAction.get(4));
			break;
		case 3:
			if(currentAction.get(1).equalsIgnoreCase("GOLD")) mainFrame.getInteractionPanel().getLoot1Button().setText(currentAction.get(2)+" Or");
			else mainFrame.getInteractionPanel().getLoot1Button().setText(currentAction.get(2));
			if(currentAction.get(1).equalsIgnoreCase("GOLD")) mainFrame.getInteractionPanel().getLoot1Button().setActionCommand("GOLD");
			else mainFrame.getInteractionPanel().getLoot1Button().setActionCommand(currentAction.get(2));
			
			if(currentAction.get(3).equalsIgnoreCase("GOLD")) mainFrame.getInteractionPanel().getLoot1Button().setText(currentAction.get(4)+" Or");
			else mainFrame.getInteractionPanel().getLoot2Button().setText(currentAction.get(4));
			if(currentAction.get(3).equalsIgnoreCase("GOLD")) mainFrame.getInteractionPanel().getLoot2Button().setActionCommand("GOLD");
			else mainFrame.getInteractionPanel().getLoot2Button().setActionCommand(currentAction.get(4));

			if(currentAction.get(5).equalsIgnoreCase("GOLD")) mainFrame.getInteractionPanel().getLoot1Button().setText(currentAction.get(6)+" Or");
			else mainFrame.getInteractionPanel().getLoot3Button().setText(currentAction.get(6));
			if(currentAction.get(5).equalsIgnoreCase("GOLD")) mainFrame.getInteractionPanel().getLoot3Button().setActionCommand("GOLD");
			else mainFrame.getInteractionPanel().getLoot3Button().setActionCommand(currentAction.get(6));
			break;
		default:
			break;
		}
	}
	
	public void setMultiLootText() {
		int compteur = 0;
		for(int i = 1 ; i < currentAction.size() ; i++) {
			if(currentAction.get(i).equalsIgnoreCase("GOLD")) compteur++;
			else if(currentAction.get(i).equalsIgnoreCase("EQUIPMENT")) compteur++;
			else if(currentAction.get(i).equalsIgnoreCase("TREASURE")) compteur++;
		}
		switch(compteur) {
		case 1:
			System.out.println("CASE 1 MULTILOOT NO CODED");
			break;
		case 2:
			System.out.println("CASE 2 MULTILOOT NO CODED");
			break;
		case 3:
			System.out.println("CASE 3 MULTILOOT NO CODED");
			break;
		case 4:
			System.out.println("CASE 4 MULTILOOT NO CODED");
			break;
		case 5:
			if(currentAction.get(1).equalsIgnoreCase("GOLD")) mainFrame.getInteractionPanel().getMultiLoot1Label().setText(currentAction.get(2)+" Or");
			else mainFrame.getInteractionPanel().getMultiLoot1Label().setText(currentAction.get(2));
			
			if(currentAction.get(3).equalsIgnoreCase("GOLD")) mainFrame.getInteractionPanel().getMultiLoot2Label().setText(currentAction.get(4)+" Or");
			else mainFrame.getInteractionPanel().getMultiLoot2Label().setText(currentAction.get(4));

			if(currentAction.get(5).equalsIgnoreCase("GOLD")) mainFrame.getInteractionPanel().getMultiLoot3Label().setText(currentAction.get(6)+" Or");
			else mainFrame.getInteractionPanel().getMultiLoot3Label().setText(currentAction.get(6));
			
			if(currentAction.get(7).equalsIgnoreCase("GOLD")) mainFrame.getInteractionPanel().getMultiLoot4Label().setText(currentAction.get(8)+" Or");
			else mainFrame.getInteractionPanel().getMultiLoot4Label().setText(currentAction.get(8));
			
			if(currentAction.get(9).equalsIgnoreCase("GOLD")) mainFrame.getInteractionPanel().getMultiLoot5Label().setText(currentAction.get(10)+" Or");
			else mainFrame.getInteractionPanel().getMultiLoot5Label().setText(currentAction.get(10));
			break;
		default:
			break;
		}
	}
	
	public void setEquipmentSwitchText() {
		mainFrame.getInteractionPanel().getEquipment1SwitchButton().setText(currentAction.get(1));
		mainFrame.getInteractionPanel().getEquipment1SwitchButton().setActionCommand(currentAction.get(1));
		mainFrame.getInteractionPanel().getEquipment2SwitchButton().setText(currentAction.get(2));
		mainFrame.getInteractionPanel().getEquipment2SwitchButton().setActionCommand(currentAction.get(2));
	}
	
	public void setEquipmentDropText() {
		mainFrame.getInteractionPanel().getEquipmentDropLabel().setText("Souhaitez vous conserver : "+currentAction.get(2)+" ?");
	}
	
	public void setBuyOptionText() {
		mainFrame.getInteractionPanel().getBuyOptionText().setText("Désirez vous acheter : "+currentAction.get(2)+" ?");
	}
	
	public void setNumerotListener() {
		mainFrame.getNextNumberPanel().getNextNumber1().addActionListener(new NumeroButtonListener());
		mainFrame.getNextNumberPanel().getNextNumber2().addActionListener(new NumeroButtonListener());
		mainFrame.getNextNumberPanel().getNextNumber3().addActionListener(new NumeroButtonListener());
		mainFrame.getNextNumberPanel().getNextNumber4().addActionListener(new NumeroButtonListener());
		mainFrame.getNextNumberPanel().getNextNumber5().addActionListener(new NumeroButtonListener());
		mainFrame.getNextNumberPanel().getNextAction().addActionListener(new SuiteButtonListener());
	}
	
	public void setLootButtonListener() {
		mainFrame.getInteractionPanel().getLoot1Button().addActionListener(new LootChoiceButtonListener());
		mainFrame.getInteractionPanel().getLoot2Button().addActionListener(new LootChoiceButtonListener());
		mainFrame.getInteractionPanel().getLoot3Button().addActionListener(new LootChoiceButtonListener());
	}
	
	public void setGambleParameters() {
		SpinnerModel gambleModel;
		if(pj.getGold() > 20) {
			gambleModel = new SpinnerNumberModel(1,1,20,1);
		}
		else {
			gambleModel = new SpinnerNumberModel(1,1,pj.getGold(),1);
		}
		mainFrame.getInteractionPanel().getGambleValue().setModel(gambleModel);
	}
	
	public void setAction(ArrayList<String> keyWords) {
		nombreAssaut = 0;
		mainFrame.getCurrentNumberPanel().getCurrentNumberLabel().setText(currentNumero.getNumero()+"");
		if(currentNumero.getNumero() == 72) {
			visited72 = true;
			visitedCount++;
		}
		else if(currentNumero.getNumero() == 132) {
			visited132 = true;
			visitedCount++;
		}
		else if(currentNumero.getNumero() == 27 && !visited27) {
			visited27 = true;
			visitedCount++;
		}
		else if(currentNumero.getNumero() == 110) {
			visited110 = true;
			visitedCount++;
		}
		else if(currentNumero.getNumero() == 170) {
			visited170 = true;
			visitedCount++;
		}
		else if(currentNumero.getNumero() == 294) visited294 = true;
		switch(keyWords.get(0)) {
		case "NEXT":
			if(currentNumero.getNumero() == 206 && visited206) currentNumero.addNumero(284);
			else if(currentNumero.getNumero() == 227 && visited227) currentNumero.addNumero(291);
			else if(currentNumero.getNumero() == 319 && visitedCount == 2) currentNumero.addNumero(81);
			else {
				for(int i = 1 ; i < keyWords.size() ; i++) {
					currentNumero.addNumero(Integer.parseInt(keyWords.get(i)));
				}
			}
			if(currentNumero.getNumero() == 206) visited206 = true;
			else if(currentNumero.getNumero() == 227) visited227 = true;
			mainFrame.resetAffichage();
			mainFrame.getNextNumberPanel().setNextButton(currentNumero.getEnsembleNumeroSuivants().size());			
			setTextNumero(currentNumero);
			break;
		case "TEST":
			mainFrame.getNextNumberPanel().setNextButton(0);
			mainFrame.getInteractionPanel().setTest();
			mainFrame.getInteractionPanel().getAleatoireButton().addActionListener(new TestAleatoireButtonListener());
			switch(keyWords.get(1)) {
			case "SKILL":
				mainFrame.getInteractionPanel().setTestHabilete();
				break;
			case "STAMINA":
				mainFrame.getInteractionPanel().setTestEndurance();
				break;
			case "LUCK":
				mainFrame.getInteractionPanel().setTestChance();
				break;
			case "MULTITEST":
				mainFrame.getInteractionPanel().setTestNone();
				break;
			case "MULTITESTLUCK":
				mainFrame.getInteractionPanel().setTestChance();
				break;
			case "NONE[1-3-5,2-4-6]":
			case "NONE[1-2,3-4,5-6]":
			case "NONE[1-3,4-5,6]":
			case "NONE[1-4,5-6]":
			case "NONE[1-5,6]":
				mainFrame.getInteractionPanel().setTestNone();
				break;
			default:
				System.out.println("ERROR");
				break;
			}
			mainFrame.resetAffichage();
			break;
		case "TESTX":
			mainFrame.getNextNumberPanel().setNextButton(0);
			mainFrame.getInteractionPanel().setTest();
			mainFrame.getInteractionPanel().getAleatoireButton().addActionListener(new TestXAleatoireButtonListener());
			switch(keyWords.get(1)) {
			case "SKILL":
				mainFrame.getInteractionPanel().setTestHabilete();
				break;
			case "STAMINA":
				mainFrame.getInteractionPanel().setTestEndurance();
				break;
			case "LUCK":
				mainFrame.getInteractionPanel().setTestChance();
				break;
			default:
				System.out.println("ERROR");
				break;
			}
			mainFrame.resetAffichage();
			waitingForUser = true;
			break;
		case "TESTZ":
			mainFrame.getNextNumberPanel().setNextButton(0);
			mainFrame.getInteractionPanel().setTest();
			mainFrame.getInteractionPanel().getAleatoireButton().addActionListener(new TestZAleatoireButtonListener());
			switch(keyWords.get(1)) {
			case "SKILL":
				mainFrame.getInteractionPanel().setTestHabilete();
				break;
			case "STAMINA":
				mainFrame.getInteractionPanel().setTestEndurance();
				break;
			case "LUCK":
				mainFrame.getInteractionPanel().setTestChance();
				break;
			default:
				System.out.println("ERROR");
				break;
			}
			mainFrame.resetAffichage();
			break;
		case "FIGHT":
			if(currentNumero.getNumero() == 179 && visited179AndKill) {
				currentNumero.addNumero(54);
				mainFrame.getNextNumberPanel().setNextButton(currentNumero.getEnsembleNumeroSuivants().size());			
				setTextNumero(currentNumero);
			}
			else {
				mainFrame.getNextNumberPanel().setNextButton(0);
				mainFrame.fightPanelRemoveAll();
				mainFrame.setFight();
				setEnnemi();
				nombreEnnemi = 1;
				numeroCombat = 1;
				Utilitaire.removeAllListeners(mainFrame.getFightPanel().getFightRandom());
				mainFrame.getFightPanel().getFightRandom().addActionListener(new FightAleatoireButtonListener());
				waitingForUser = true;
			}
			break;
		case "FIGHTX":
			mainFrame.getNextNumberPanel().setNextButton(0);
			mainFrame.fightPanelRemoveAll();
			mainFrame.setFight();
			numeroCombat = 0;
			setEnnemiX();
			calculNombreEnnemi();
			Utilitaire.removeAllListeners(mainFrame.getFightPanel().getFightRandom());
			mainFrame.getFightPanel().getFightRandom().addActionListener(new FightAleatoireButtonListener());
			break;
		case "FIGHTZ":
			mainFrame.getNextNumberPanel().setNextButton(0);
			mainFrame.fightPanelRemoveAll();
			if(keyWords.get(1).equalsIgnoreCase("RANDOMMONSTER")) {
				mainFrame.getInteractionPanel().setTest();
				mainFrame.getInteractionPanel().setThrowDice();
				mainFrame.getInteractionPanel().getAleatoireButton().addActionListener(new RandomMonsterButtonListener());
				nombreEnnemi = 1;
				numeroCombat = 1;
			}
			else {
				mainFrame.setFight();
				numeroCombat = 0;
				setEnnemiX();
				calculNombreEnnemi();
				nombreEnnemi++;
				Utilitaire.removeAllListeners(mainFrame.getFightPanel().getFightRandom());
				mainFrame.getFightPanel().getFightRandom().addActionListener(new FightAleatoireButtonListener());
			}
			break;
		case "FIGHTMEAL":
			mainFrame.getNextNumberPanel().setNextButton(0);
			mainFrame.fightPanelRemoveAll();
			mainFrame.setFight();
			setEnnemi();
			nombreEnnemi = 1;
			numeroCombat = 1;
			mainFrame.getInteractionPanel().getAleatoireButton().addActionListener(new FightAleatoireButtonListener());
			break;
		case "ESCAPE":
			mainFrame.getInteractionPanel().setEscape();
			mainFrame.getInteractionPanel().getFuir().addActionListener(new FuiteAvantCombatButtonListener());
			//waitingForUser = true;
			break;
		case "LOOT":
			for(int i = 1 ; i < keyWords.size() ; i++) {
				switch(keyWords.get(i)) {
				case "SKILL":
					i++;
					pj.addSkill(Integer.parseInt(keyWords.get(i)));
					break;
				case "LUCK":
					i++;
					pj.addLuck(Integer.parseInt(keyWords.get(i)));
					break;
				case "GOLD":
					i++;
					pj.addGold(Integer.parseInt(keyWords.get(i)));
					break;
				case "EQUIPMENT":
					i++;
					pj.addEquipment(keyWords.get(i));
					break;
				case "TREASURE":
					i++;
					pj.addTreasure(keyWords.get(i));
					if(currentNumero.getNumero() == 390 && !visited294) pj.addGold(5);
					break;
				default:
					currentNumero.addNumero(Integer.parseInt(keyWords.get(i)));
					break;
				}
			}
			heroPanelController.majHero();
			mainFrame.getNextNumberPanel().setNextButton(currentNumero.getEnsembleNumeroSuivants().size());
			setTextNumero(currentNumero);
			break;
		case "LOOTORNOT":
			mainFrame.getNextNumberPanel().setNextButton(0);
			mainFrame.getInteractionPanel().setLootOrNot();
			if(keyWords.get(1).matches("EQUIPMENT|TREASURE")) mainFrame.getInteractionPanel().getLootOrNotLabel().setText("Désirez vous prendre : " + keyWords.get(2) + " ?");
			else mainFrame.getInteractionPanel().getLootOrNotLabel().setText("Désirez vous prendre les provisions ?");
			mainFrame.getInteractionPanel().getOuiLootOrNot().addActionListener(new LootOrNotButtonListener());
			mainFrame.getInteractionPanel().getNonLootOrNot().addActionListener(new LootOrNotButtonListener());
			break;
		case "LOOTCHOICE":
			mainFrame.getInteractionPanel().setLootChoice();
			setLootText();
			setLootButtonListener();
			break;
		case "MULTILOOTCHOICE":
			waitingForUser = true;
			mainFrame.getInteractionPanel().setLootMultiChoice();
			setMultiLootText();
			mainFrame.getInteractionPanel().getValiderMultiLootChoice().addActionListener(new ValiderMultiLootButtonListener());
			break;
		case "IFOBJECT":
			mainFrame.resetAffichage();
			switch(keyWords.get(1)) {
			case "GOLD":
				if(keyWords.get(2).equalsIgnoreCase("SPECIAL")) {
					if(goldChoice && !visited110) {
						currentNumero.addNumero(Integer.parseInt(keyWords.get(3)));
						pj.addGold(2);
						heroPanelController.majHero();
					}
				}
				else if(pj.getGold() >= Integer.parseInt(keyWords.get(2))) currentNumero.addNumero(Integer.parseInt(keyWords.get(3)));
				break;
			case "EQUIPMENT":
			case "TREASURE":
				for(int i = 0 ; i < pj.getEquipmentAndTreasure().size() ; i++) {
					if(pj.getEquipmentAndTreasure().get(i).equalsIgnoreCase(keyWords.get(2))) {
						if(visited72) {
							if(Integer.parseInt(keyWords.get(3)) == 72) break;
						}
						if(visited132) {
							if(Integer.parseInt(keyWords.get(3)) == 132) break;
						}
						if(visited27) {
							if(Integer.parseInt(keyWords.get(3)) == 27) break;
						}
						if(visited170) {
							if(Integer.parseInt(keyWords.get(3)) == 170) break;
						}
						currentNumero.addNumero(Integer.parseInt(keyWords.get(3)));
						break;
					}
				}
				break;
			}
			for(int i = 3 ; i < keyWords.size() ; i++) {
				switch(keyWords.get(i)) {
				case "LUCK":
					i++;
					pj.addLuck(Integer.parseInt(keyWords.get(i)));
					break;
				case "BONUS":
					i++;
					switch(keyWords.get(i)) {
					case "SKILL":
						i++;
						pj.addSkill(Integer.parseInt(keyWords.get(i)));
						break;
					case "STAMINA":
						i++;
						pj.addStamina(Integer.parseInt(keyWords.get(i)));
						break;
					}
					break;
				case "MALUS":
					i++;
					switch(keyWords.get(i)) {
					case "SKILL":
						i++;
						pj.decreaseSkill(Integer.parseInt(keyWords.get(i)));
						break;
					case "STAMINA":
						i++;
						pj.decreaseStamina(Integer.parseInt(keyWords.get(i)));
						break;
					}
					break;
				case "NEXT":
					while(i+1 < keyWords.size()) {
						i++;
						currentNumero.addNumero(Integer.parseInt(keyWords.get(i)));
					}
					break;
				}
			}
			heroPanelController.majHero();
			mainFrame.getNextNumberPanel().setNextButton(currentNumero.getEnsembleNumeroSuivants().size());
			setTextNumero(currentNumero);
			break;
		case "IFOBJECTX":
			mainFrame.resetAffichage();
			for(int i = 0 ; i < keyWords.size() ; i++) {
				if(keyWords.get(i).matches("EQUIPMENT||TREASURE")) {
					i++;
					for(int j = 0 ; j < pj.getEquipmentAndTreasure().size() ; j++) {
						if(keyWords.get(i).equalsIgnoreCase(pj.getEquipmentAndTreasure().get(j))) {
							i++;
							currentNumero.addNumero(Integer.parseInt(keyWords.get(i)));
							break;
						}
					}
				}
			}
			mainFrame.getNextNumberPanel().setNextButton(currentNumero.getEnsembleNumeroSuivants().size());
			setTextNumero(currentNumero);
			break;
		case "OBJECTUSE":
			if(keyWords.get(1).equalsIgnoreCase("EQUIPMENT")) pj.removeEquipment(keyWords.get(2));
			else pj.removeTreasure(keyWords.get(2));
			for(int i = 3 ; i < keyWords.size() ; i++) {
				switch(keyWords.get(i)) {
				case "LUCK":
					i++;
					pj.addLuck(Integer.parseInt(keyWords.get(i)));
					break;
				case "MALUS":
					i++;
					switch(keyWords.get(i)) {
					case "STAMINA":
						i++;
						pj.decreaseStamina(Integer.parseInt(keyWords.get(i)));
						break;
					}
					break;
				case "NEXT":
					while(i+1 < keyWords.size()) {
						i++;
						currentNumero.addNumero(Integer.parseInt(keyWords.get(i)));
					}
					break;
				}
			}
			heroPanelController.majHero();
			mainFrame.getNextNumberPanel().setNextButton(currentNumero.getEnsembleNumeroSuivants().size());
			setTextNumero(currentNumero);
			break;
		case "GOLDUSE":
			if(previousNumber == 3) pj.decreaseGold(3);
			else if(previousNumber == 127) pj.decreaseGold(5);
			heroPanelController.majHero();
			currentNumero.addNumero(Integer.parseInt(keyWords.get(1)));
			mainFrame.resetAffichage();
			mainFrame.getNextNumberPanel().setNextButton(currentNumero.getEnsembleNumeroSuivants().size());
			setTextNumero(currentNumero);	
			break;
		case "EQUIPMENTEXCHANGE":
			mainFrame.getNextNumberPanel().setNextButton(0);
			if(pj.getEquipment().size() == 4 && pj.getTreasure().size() == 0) {
				mainFrame.getInteractionPanel().setText();
				mainFrame.getInteractionPanel().getUserFeedback().setText("Vous ne pouvez abandonner aucune pièce de votre équipement.");
				for(int i = 0 ; i < keyWords.size() ; i++) {
					if(keyWords.get(i).equalsIgnoreCase("NEXT")) {
						i++;
						currentNumero.addNumero(Integer.parseInt(keyWords.get(i)));
					}
				}
				mainFrame.getNextNumberPanel().setNextButton(currentNumero.getEnsembleNumeroSuivants().size());
				setTextNumero(currentNumero);
			}
			else {
				mainFrame.getInteractionPanel().setEquipmentChange();
				mainFrame.getInteractionPanel().getEquipmentExchangeOuiButton().addActionListener(new EquipmentChangeButtonListener());
				mainFrame.getInteractionPanel().getEquipmentExchangeNonButton().addActionListener(new EquipmentChangeButtonListener());
			}
			waitingForUser = true;
			break;
		case "EQUIPMENTSWITCH":
			mainFrame.getNextNumberPanel().setNextButton(0);
			mainFrame.getInteractionPanel().setEquipmentSwitch();
			setEquipmentSwitchText();
			mainFrame.getInteractionPanel().getEquipment1SwitchButton().addActionListener(new SwitchEquipmentButtonListener());
			mainFrame.getInteractionPanel().getEquipment2SwitchButton().addActionListener(new SwitchEquipmentButtonListener());
			waitingForUser = true;
			break;
		case "EQUIPMENTDROP":
			mainFrame.getNextNumberPanel().setNextButton(0);
			mainFrame.getInteractionPanel().setEquipmentDrop();
			setEquipmentDropText();
			mainFrame.getInteractionPanel().getEquipmentDropYesButton().addActionListener(new DropEquipmentButtonListener());
			mainFrame.getInteractionPanel().getEquipmentDropNoButton().addActionListener(new DropEquipmentButtonListener());
			waitingForUser = true;
			break;
		case "DIVERSIONDROP":
			mainFrame.getNextNumberPanel().setNextButton(0);
			mainFrame.getInteractionPanel().setChoiceEquipmentChange();
			if(pj.getEquipment().size() == 4 && pj.getTreasure().size() == 0) {
				mainFrame.getInteractionPanel().getListeEquipementJetable().addItem("1 Pièce d'Or");
			}
			else {
				for(int i = 4 ; i < pj.getEquipment().size() ; i++) {
					mainFrame.getInteractionPanel().getListeEquipementJetable().addItem(pj.getEquipment().get(i));
				}
				for(int i = 0 ; i < pj.getTreasure().size() ; i++) {
					mainFrame.getInteractionPanel().getListeEquipementJetable().addItem(pj.getTreasure().get(i));
				}
			}
			Utilitaire.removeAllListeners(mainFrame.getInteractionPanel().getValiderEquipementJetable());
			mainFrame.getInteractionPanel().getValiderEquipementJetable().addActionListener(new DiversionDropButtonListener());
			waitingForUser = true;
			break;
		case "BUYOPTION":
			mainFrame.getNextNumberPanel().setNextButton(0);
			mainFrame.getInteractionPanel().setBuyOption();
			setBuyOptionText();
			mainFrame.getInteractionPanel().getYesBuyOption().addActionListener(new BuyOptionButtonListener());
			mainFrame.getInteractionPanel().getNoBuyOption().addActionListener(new BuyOptionButtonListener());
			waitingForUser = true;
			break;
		case "MEAL":
			mainFrame.getNextNumberPanel().setNextButton(0);
			mainFrame.getInteractionPanel().setChoiceMeal();
			mainFrame.getInteractionPanel().getOuiPrendreRepas().addActionListener(new PrendreUnRepasButtonListener());
			mainFrame.getInteractionPanel().getNonPrendreRepas().addActionListener(new NePasPrendreUnRepasButtonListener());
			waitingForUser = true;
			break;
		case "MEALX":
			mainFrame.getNextNumberPanel().setNextButton(0);
			mainFrame.getInteractionPanel().setChoiceMeal();
			mainFrame.getInteractionPanel().getOuiPrendreRepas().addActionListener(new PrendreUnRepasButtonListener());
			mainFrame.getInteractionPanel().getNonPrendreRepas().addActionListener(new NePasPrendreUnRepasButtonListener());
			waitingForUser = true;
			break;
		case "TAKEMEAL":
			mainFrame.getNextNumberPanel().setNextButton(1);
			pj.takeMeal();
			heroPanelController.majHero();
			currentNumero.addNumero(Integer.parseInt(currentAction.get(1)));
			mainFrame.getNextNumberPanel().setNextButton(currentNumero.getEnsembleNumeroSuivants().size());
			setTextNumero(currentNumero);
			break;
		case "SHAREMEAL":
			mainFrame.getNextNumberPanel().setNextButton(0);
			mainFrame.getInteractionPanel().setChoiceMeal();
			mainFrame.getInteractionPanel().getOuiPrendreRepas().addActionListener(new PrendreUnRepasButtonListener());
			mainFrame.getInteractionPanel().getNonPrendreRepas().addActionListener(new NePasPrendreUnRepasButtonListener());
			break;
		case "TRAP":
			mainFrame.getInteractionPanel().setTest();
			mainFrame.getInteractionPanel().setdamageDice();
			mainFrame.getInteractionPanel().getAleatoireButton().addActionListener(new DegatsAleatoireButtonListener());
			break;
		case "BONUS":
			for(int i = 1 ; i < keyWords.size() ; i++) {
				switch(keyWords.get(i)) {
				case "SKILL":
					i++;
					pj.addSkill(Integer.parseInt(keyWords.get(i)));
					break;
				case "SKILLRELATIVE":
					i++;
					if(pj.getSkill() < pj.getStartingSkill()-Integer.parseInt(keyWords.get(i))) pj.setSkill(pj.getStartingSkill()-Integer.parseInt(keyWords.get(i)));
					break;
				case "STAMINA":
					i++;
					pj.addStamina(Integer.parseInt(keyWords.get(i)));
					break;
				case "STAMINARELATIVE":
					i++;
					if(pj.getStamina() < pj.getStartingStamina()-Integer.parseInt(keyWords.get(i))) pj.setStamina(pj.getStartingStamina()-Integer.parseInt(keyWords.get(i)));
					break;
				case "LUCK":
					i++;
					pj.addLuck(Integer.parseInt(keyWords.get(i)));
					break;
				case "LUCKRELATIVE":
					i++;
					if(pj.getLuck() < pj.getStartingLuck()-Integer.parseInt(keyWords.get(i))) pj.setLuck(pj.getStartingLuck()-Integer.parseInt(keyWords.get(i)));
					break;
				default:
					break;
				}
				if(keyWords.get(i).equalsIgnoreCase("NEXT")) {
					while(i+1 < keyWords.size()) {
						i++;
						currentNumero.addNumero(Integer.parseInt(keyWords.get(i)));
					}
					break;
				}
			}
			heroPanelController.majHero();
			mainFrame.getNextNumberPanel().setNextButton(currentNumero.getEnsembleNumeroSuivants().size());
			setTextNumero(currentNumero);
			break;
		case "MALUS":
			for(int i = 1 ; i < keyWords.size() ; i++) {
				switch(keyWords.get(i)) {
				case "SKILL":
					i++;
					pj.decreaseSkill(Integer.parseInt(keyWords.get(i)));
					break;
				case "STAMINA":
					i++;
					pj.decreaseStamina(Integer.parseInt(keyWords.get(i)));
					break;
				case "LUCK":
					break;
				default:
					if(keyWords.get(i).equalsIgnoreCase("NEXT")) {
						while(i+1 < keyWords.size()) {
							i++;
							currentNumero.addNumero(Integer.parseInt(keyWords.get(i)));
						}
						break;
					}
					break;
				}
			}
			heroPanelController.majHero();
			mainFrame.getNextNumberPanel().setNextButton(currentNumero.getEnsembleNumeroSuivants().size());
			setTextNumero(currentNumero);
			break;
		case "GAMBLE":
			mainFrame.getNextNumberPanel().setNextButton(0);
			mainFrame.getInteractionPanel().setGamble();
			setGambleParameters();
			mainFrame.getInteractionPanel().getValidateGambleValue().addActionListener(new ValidateGambleButtonListener());
			waitingForUser = true;
			break;
		case "CHOICE":
			int compteur = 1;
			if(keyWords.get(1).equalsIgnoreCase("ESCAPE")) {
				mainFrame.getNextNumberPanel().setNextButton(0);
				mainFrame.getInteractionPanel().setFightOrEscape();
				mainFrame.getInteractionPanel().getChoixCombattre().addActionListener(new ChoixCombattreButtonListener());
				mainFrame.getInteractionPanel().getChoixFuir().addActionListener(new FuiteAvantCombatButtonListener());
			}
			else if(keyWords.get(1).equalsIgnoreCase("MEAL")) {
				mainFrame.getNextNumberPanel().setNextButton(0);
				mainFrame.getInteractionPanel().setChoiceMeal();
				mainFrame.getInteractionPanel().getOuiPrendreRepas().addActionListener(new PrendreUnRepasChoiceButtonListener());
				mainFrame.getInteractionPanel().getNonPrendreRepas().addActionListener(new NePasPrendreUnRepasChoiceButtonListener());
			}
			else if(keyWords.get(1).equalsIgnoreCase("MEALX")) {
				mainFrame.getNextNumberPanel().setNextButton(0);
				mainFrame.getInteractionPanel().setChoiceMeal();
				mainFrame.getInteractionPanel().getOuiPrendreRepas().addActionListener(new PrendreUnRepasXButtonListener());
				mainFrame.getInteractionPanel().getNonPrendreRepas().addActionListener(new NePasPrendreUnRepasXButtonListener());
			}
			else {
				while(Utilitaire.isNumeric(keyWords.get(compteur))) {
					currentNumero.addNumero(Integer.parseInt(keyWords.get(compteur)));
					compteur++;
				}
				mainFrame.resetAffichage();
				mainFrame.getNextNumberPanel().setNextButton(currentNumero.getEnsembleNumeroSuivants().size());
				setTextNumero(currentNumero);
				switch(keyWords.get(compteur)) {
				case "TEST":
					mainFrame.getInteractionPanel().setTest();
					mainFrame.getInteractionPanel().getAleatoireButton().addActionListener(new TestAleatoireChoiceButtonListener());
					switch(keyWords.get(compteur+1)) {
					case "SKILL":
						mainFrame.getInteractionPanel().setTestHabilete();
						break;
					case "STAMINA":
						mainFrame.getInteractionPanel().setTestEndurance();
						break;
					case "LUCK":
						mainFrame.getInteractionPanel().setTestChance();
						break;
					default:
						System.out.println("ERROR");
						break;
					}
					mainFrame.resetAffichage();
					break;
				case "LOOTCHOICE":
					break;
				case "ESCAPE":
					mainFrame.getInteractionPanel().setEscape();
					mainFrame.getInteractionPanel().getFuir().addActionListener(new FuiteAvantCombatButtonListener());
					break;
				default:
					System.out.println("ERROR");
					break;
				}
			}
			break;
		case "MULTIPLE":
			tempAction = new ArrayList<>(currentAction);
			currentAction.removeAll(keyWords);
			currentAction.add(tempAction.get(1));
			for(int i = 2 ; i < tempAction.size() ; i++) {
				if(tempAction.get(i).matches("NEXT|TESTX|FIGHT|FIGHTX|ESCAPE|BONUS|MALUS|LOOT|MULTILOOTCHOICE|LOOTORNOT|EQUIPMENTSWITCH|EQUIPMENTEXCHANGE|IFOBJECT|MEAL")) break;
				else {
					currentAction.add(tempAction.get(i));
				}
			}
			tempAction.remove(1);
			while(tempAction.size() != 1 && !tempAction.get(1).matches("NEXT|TESTX|FIGHT|FIGHTX|ESCAPE|BONUS|MALUS|LOOT|MULTILOOTCHOICE|LOOTORNOT|EQUIPMENTSWITCH|EQUIPMENTEXCHANGE|IFOBJECT|MEAL")) {
				tempAction.remove(1);
			}
			setAction(currentAction);
			break;
		case "GAMEOVER":
			mainFrame.getNextNumberPanel().setNextButton(0);
			mainFrame.resetAffichage();
			mainFrame.getInteractionPanel().setGameOver();
			break;
		case "VICTORY":
			mainFrame.getNextNumberPanel().setNextButton(0);
			mainFrame.resetAffichage();
			mainFrame.getInteractionPanel().setVictory();
			break;
		default:
			System.out.println("ERROR");
			break;
		}
		multipleNextAction();
	}
	
	public void multipleNextAction() {
		if(!waitingForUser && tempAction != null && tempAction.size() > 1) {
			currentAction = tempAction;
			setAction(currentAction);
		}
	}
	
	// Listener ----------------------------------------------------------------------------------------------------------------------------------------------
	
	class NewGameListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			mainFrame.getMainPanel().removeAll();
			pj = new Hero("James",11,12,5);
			startGame();
			heroPanelController.setHero();
			mainFrame.getMainPanel().revalidate();
			mainFrame.getMainPanel().repaint();
		}
	}
	
	class NewHeroListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			mainFrame.getMainPanel().removeAll();
			mainFrame.setNewHero();
			setNewHeroListeners();
			newCharacterController = new NewCharacterPanelController(mainFrame.getNewCharacter());
			newCharacterController.setNewHeroListeners();
			mainFrame.getMainPanel().revalidate();
			mainFrame.getMainPanel().repaint();
		}
	}
	
	/**
	 * ATTENTION le joueur peut faire planter en mettant une lettre dans le JTextfield, ou mettre des valeurs abusées genre 100
	 * @author Admin
	 *
	 */
	class ValiderNewHeroListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if(mainFrame.getNewCharacter().getOriginalHeroRadioButton().isSelected()) {
				if(mainFrame.getNewCharacter().getHeroName().getText().equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(mainFrame, "Veuillez indiquer le nom de votre Héros.");
					return;
				}
				else if(mainFrame.getNewCharacter().getHeroSkill().getText().equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(mainFrame, "Veuillez indiquer l'habileté de votre Héros.");
					return;
				}
				else if(mainFrame.getNewCharacter().getHeroStamina().getText().equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(mainFrame, "Veuillez indiquer l'endurance de votre Héros.");
					return;
				}
				else if(mainFrame.getNewCharacter().getHeroLuck().getText().equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(mainFrame, "Veuillez indiquer la chance de votre Héros.");
					return;
				}
				else {
					pj = new Hero(mainFrame.getNewCharacter().getHeroName().getText(),
							Integer.parseInt(mainFrame.getNewCharacter().getHeroSkill().getText()),
							Integer.parseInt(mainFrame.getNewCharacter().getHeroStamina().getText()),
							Integer.parseInt(mainFrame.getNewCharacter().getHeroLuck().getText()));
				}
			}
			else {
				switch(mainFrame.getNewCharacter().getDefaultHeroComboBox().getSelectedIndex()) {
				case 1:
					pj = new Hero("Crowald le Nain",9,19,8);
					break;
				case 2:
					pj = new Hero("Chaelza la Voleuse",10,16,9);
					break;
				case 3:
					pj = new Hero("Raedhell d'Argenton",10,17,7);
					break;
				default:
					JOptionPane.showMessageDialog(mainFrame, "Veuillez choisir votre Héros.");
					return;
				}
			}
			mainFrame.getMainPanel().removeAll();
			startGame();
			heroPanelController.setHero();
			mainFrame.getMainPanel().revalidate();
			mainFrame.getMainPanel().repaint();
		}
	}
	
	class ExitNewHeroListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			mainFrame.getMainPanel().removeAll();
			startController();
			mainFrame.getMainPanel().revalidate();
			mainFrame.getMainPanel().repaint();
		}
	}
	
	class StartButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			try {
				currentNumero = new Numero(1);
				currentAction = mainReader.readAction(currentNumero);
				setAction(currentAction);
			} 
			catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	class NumeroButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			try {
				mainFrame.interactionPanelRemoveAll();
				String numEnCours = e.getActionCommand();
				previousNumber = currentNumero.getNumero();
				for(Numero numero : currentNumero.getEnsembleNumeroSuivants()) {
					if(numero.getNumero() == Integer.parseInt(numEnCours)) {
						currentNumero = numero;
						break;
					}
				}
				currentAction = mainReader.readAction(currentNumero);
				setAction(currentAction);
			} 
			catch (IOException error) {
				error.printStackTrace();
			}
			mainFrame.getInteractionPanel().revalidate();
			mainFrame.getInteractionPanel().repaint();
		}
	}
	
	class SuiteButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			mainFrame.interactionPanelRemoveAll();
			if(currentAction.get(0).equalsIgnoreCase("FIGHTZ") && currentAction.get(1).equalsIgnoreCase("RANDOMMONSTER")) {
				mainFrame.getInteractionPanel().setEnterPreviousNumero();
				mainFrame.getInteractionPanel().getValidateInputUserPreviousNumber().addActionListener(new ValidateInputUserPreviousNumberButtonListener());
			}
			else {
				currentAction.removeAll(currentAction);
				currentAction.addAll(tempAction);
				setAction(currentAction);
			}
			mainFrame.getInteractionPanel().revalidate();
			mainFrame.getInteractionPanel().repaint();
		}
	}

	class TestAleatoireButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			mainFrame.interactionPanelRemoveAll();
			int valueDice1 = Utilitaire.lancerSix();
			int valueDice2 = Utilitaire.lancerSix();
			int valueDices = valueDice1 + valueDice2;
			System.out.println(valueDices);
			switch(currentAction.get(1)) {
			case "SKILL":
				mainFrame.getNextNumberPanel().setNextButton(1);
				mainFrame.getInteractionPanel().setResultatTestAleatoire();
				mainFrame.getInteractionPanel().getDice1().rollTheDice(valueDice1);
				mainFrame.getInteractionPanel().getDice2().rollTheDice(valueDice2);
				if(valueDices <= pj.getSkill()) {
					currentNumero.addNumero(Integer.parseInt(currentAction.get(2)));
					mainFrame.getInteractionPanel().getResultatAleatoireTestLabel().setText("Réussite !");
					mainFrame.getInteractionPanel().getResultatAleatoireTestLabel().setForeground(new Color(103,221,51));
				}
				else {
					currentNumero.addNumero(Integer.parseInt(currentAction.get(3)));
					mainFrame.getInteractionPanel().getResultatAleatoireTestLabel().setText("Échec !");
					mainFrame.getInteractionPanel().getResultatAleatoireTestLabel().setForeground(Color.RED);
				}
				setTextNumero(currentNumero);
				break;
			case "STAMINA":
				if(valueDices <= pj.getStamina()) {
					mainFrame.getNextNumberPanel().setNextButton(1);
					currentNumero.addNumero(Integer.parseInt(currentAction.get(2)));
					setTextNumero(currentNumero);
				}
				else {
					if(currentNumero.getNumero() == 316) {
						mainFrame.getInteractionPanel().setChoiceMeal();
						mainFrame.getInteractionPanel().getOuiPrendreRepas().addActionListener(new PrendreUnRepasButtonListener());
						mainFrame.getInteractionPanel().getNonPrendreRepas().addActionListener(new NePasPrendreUnRepasButtonListener());
					}
					else {
						mainFrame.getNextNumberPanel().setNextButton(1);
						currentNumero.addNumero(Integer.parseInt(currentAction.get(3)));
						setTextNumero(currentNumero);
					}
				}
				break;
			case "LUCK":
				mainFrame.getNextNumberPanel().setNextButton(1);
				mainFrame.getInteractionPanel().setResultatTestAleatoire();
				mainFrame.getInteractionPanel().getDice1().rollTheDice(valueDice1);
				mainFrame.getInteractionPanel().getDice2().rollTheDice(valueDice2);
				if(valueDices <= pj.getLuck()) {
					currentNumero.addNumero(Integer.parseInt(currentAction.get(2)));
					mainFrame.getInteractionPanel().getResultatAleatoireTestLabel().setText("Réussite !");
					mainFrame.getInteractionPanel().getResultatAleatoireTestLabel().setForeground(new Color(103,221,51));
				}
				else {
					currentNumero.addNumero(Integer.parseInt(currentAction.get(3)));
					mainFrame.getInteractionPanel().getResultatAleatoireTestLabel().setText("Échec !");
					mainFrame.getInteractionPanel().getResultatAleatoireTestLabel().setForeground(Color.RED);
				}
				setTextNumero(currentNumero);
				pj.decrementLuck();
				heroPanelController.majHero();
				break;
			case "MULTITEST":
				mainFrame.getNextNumberPanel().setNextButton(1);
				mainFrame.getInteractionPanel().setResultatTestAleatoire();
				if(valueDices <= pj.getStamina() && valueDices <= pj.getLuck()) {
					currentNumero.addNumero(Integer.parseInt(currentAction.get(4)));
					mainFrame.getInteractionPanel().getResultatAleatoireTestLabel().setText("Réussite !");
					mainFrame.getInteractionPanel().getResultatAleatoireTestLabel().setForeground(new Color(103,221,51));
				}
				else {
					currentNumero.addNumero(Integer.parseInt(currentAction.get(5)));
					mainFrame.getInteractionPanel().getResultatAleatoireTestLabel().setText("Échec !");
					mainFrame.getInteractionPanel().getResultatAleatoireTestLabel().setForeground(Color.RED);
				}
				setTextNumero(currentNumero);
				heroPanelController.majHero();
				break;
			case "MULTITESTLUCK":
				pj.decrementLuck();
				testCount++;
				mainFrame.getInteractionPanel().setMultiTestRandomResult();
				if(valueDices <= pj.getLuck()) {
					mainFrame.getInteractionPanel().getResultatAleatoireTestLabel().setText("Réussite !");
					mainFrame.getInteractionPanel().getResultatAleatoireTestLabel().setForeground(new Color(103,221,51));
					mainFrame.getInteractionPanel().getNextTestMultitest().addActionListener(new NextTestMultiTestButtonListener());
					mainFrame.getInteractionPanel().getNextTestMultitest().setActionCommand("win");
				}
				else {
					mainFrame.getInteractionPanel().getResultatAleatoireTestLabel().setText("Échec !");
					mainFrame.getInteractionPanel().getResultatAleatoireTestLabel().setForeground(Color.RED);
					mainFrame.getInteractionPanel().getNextTestMultitest().addActionListener(new NextTestMultiTestButtonListener());
					mainFrame.getInteractionPanel().getNextTestMultitest().setActionCommand("lose");
				}
				heroPanelController.majHero();
				break;
			case "NONE[1-3-5,2-4-6]":
				System.out.println(valueDice1);
				mainFrame.getNextNumberPanel().setNextButton(1);
				mainFrame.getInteractionPanel().setResultatTestAleatoire();
				if(valueDice1%2 == 0) {
					mainFrame.getInteractionPanel().getResultatAleatoireTestLabel().setText("Réussite !");
					mainFrame.getInteractionPanel().getResultatAleatoireTestLabel().setForeground(new Color(103,221,51));
					pj.decreaseSkill(1);
					pj.decreaseStamina(2);
				}
				else {
					mainFrame.getInteractionPanel().getResultatAleatoireTestLabel().setText("Échec !");
					mainFrame.getInteractionPanel().getResultatAleatoireTestLabel().setForeground(Color.RED);
					pj.decreaseSkill(3);
					pj.decreaseStamina(1);
				}
				currentNumero.addNumero(Integer.parseInt(currentAction.get(3)));
				heroPanelController.majHero();
				setTextNumero(currentNumero);
				break;
			case "NONE[1-3,4-5,6]":
				System.out.println(valueDice1);
				mainFrame.getNextNumberPanel().setNextButton(1);
				mainFrame.getInteractionPanel().setResultatTestAleatoire();
				if(valueDice1 < 4) {
					currentNumero.addNumero(Integer.parseInt(currentAction.get(2)));
					mainFrame.getInteractionPanel().getResultatAleatoireTestLabel().setText("Réussite !");
					pj.addLuck(2);
					mainFrame.getInteractionPanel().getResultatAleatoireTestLabel().setForeground(new Color(103,221,51));
				}
				else if(valueDice1 < 6) {
					currentNumero.addNumero(Integer.parseInt(currentAction.get(3)));
					mainFrame.getInteractionPanel().getResultatAleatoireTestLabel().setText("Résultat en demi-teinte...");
					mainFrame.getInteractionPanel().getResultatAleatoireTestLabel().setForeground(new Color(57,147,232));
				}
				else {
					currentNumero.addNumero(Integer.parseInt(currentAction.get(4)));
					mainFrame.getInteractionPanel().getResultatAleatoireTestLabel().setText("Échec !");
					mainFrame.getInteractionPanel().getResultatAleatoireTestLabel().setForeground(Color.RED);
				}
				heroPanelController.majHero();
				setTextNumero(currentNumero);
				break;
			case "NONE[1-2,3-4,5-6]":
				System.out.println(valueDice1);
				mainFrame.getNextNumberPanel().setNextButton(1);
				mainFrame.getInteractionPanel().setResultatTestAleatoire();
				if(valueDice1 < 3) {
					currentNumero.addNumero(Integer.parseInt(currentAction.get(2)));
					mainFrame.getInteractionPanel().getResultatAleatoireTestLabel().setText("Échec !");
					mainFrame.getInteractionPanel().getResultatAleatoireTestLabel().setForeground(Color.RED);
				}
				else if(valueDice1 < 5) {
					currentNumero.addNumero(Integer.parseInt(currentAction.get(3)));
					mainFrame.getInteractionPanel().getResultatAleatoireTestLabel().setText("Résultat en demi-teinte...");
					mainFrame.getInteractionPanel().getResultatAleatoireTestLabel().setForeground(new Color(57,147,232));
				}
				else {
					currentNumero.addNumero(Integer.parseInt(currentAction.get(4)));
					mainFrame.getInteractionPanel().getResultatAleatoireTestLabel().setText("Réussite !");
					pj.addLuck(2);
					mainFrame.getInteractionPanel().getResultatAleatoireTestLabel().setForeground(new Color(103,221,51));
				}
				heroPanelController.majHero();
				setTextNumero(currentNumero);
				break;
			case "NONE[1-4,5-6]":
				System.out.println(valueDice1);
				mainFrame.getNextNumberPanel().setNextButton(1);
				mainFrame.getInteractionPanel().setResultatTestAleatoire();
				if(valueDice1 < 5) {
					currentNumero.addNumero(Integer.parseInt(currentAction.get(2)));
					mainFrame.getInteractionPanel().getResultatAleatoireTestLabel().setText("Réussite !");
					mainFrame.getInteractionPanel().getResultatAleatoireTestLabel().setForeground(new Color(103,221,51));
				}
				else {
					currentNumero.addNumero(Integer.parseInt(currentAction.get(3)));
					mainFrame.getInteractionPanel().getResultatAleatoireTestLabel().setText("Échec !");
					mainFrame.getInteractionPanel().getResultatAleatoireTestLabel().setForeground(Color.RED);
				}
				setTextNumero(currentNumero);
				break;
			case "NONE[1-5,6]":
				System.out.println(valueDice1);
				mainFrame.getNextNumberPanel().setNextButton(1);
				mainFrame.getInteractionPanel().setResultatTestAleatoire();
				if(valueDice1 < 6) {
					currentNumero.addNumero(Integer.parseInt(currentAction.get(2)));
					mainFrame.getInteractionPanel().getResultatAleatoireTestLabel().setText("Réussite !");
					mainFrame.getInteractionPanel().getResultatAleatoireTestLabel().setForeground(new Color(103,221,51));
				}
				else {
					currentNumero.addNumero(Integer.parseInt(currentAction.get(3)));
					mainFrame.getInteractionPanel().getResultatAleatoireTestLabel().setText("Échec !");
					mainFrame.getInteractionPanel().getResultatAleatoireTestLabel().setForeground(Color.RED);
				}
				setTextNumero(currentNumero);
				break;
			default:
				System.out.println("ERROR");
				break;
			}
			mainFrame.getInteractionPanel().revalidate();
			mainFrame.getInteractionPanel().repaint();
		}
	}
	
	class NextTestMultiTestButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			mainFrame.interactionPanelRemoveAll();
			if(e.getActionCommand().equalsIgnoreCase("win")) {
				if(testCount == 3) {
					mainFrame.getNextNumberPanel().setNextButton(1);
					currentNumero.addNumero(Integer.parseInt(currentAction.get(2)));
					setTextNumero(currentNumero);
				}
				else {
					mainFrame.getInteractionPanel().setTest();
					mainFrame.getInteractionPanel().setTestChance();
					mainFrame.getInteractionPanel().getAleatoireButton().addActionListener(new TestAleatoireButtonListener());
				}
			}
			else {
				mainFrame.getNextNumberPanel().setNextButton(1);
				currentNumero.addNumero(Integer.parseInt(currentAction.get(3)));
				setTextNumero(currentNumero);
			}
			mainFrame.getInteractionPanel().revalidate();
			mainFrame.getInteractionPanel().repaint();
		}
		
	}
	
	class TestXAleatoireButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			mainFrame.interactionPanelRemoveAll();
			int valueDice1 = Utilitaire.lancerSix();
			int valueDice2 = Utilitaire.lancerSix();
			int valueDices = valueDice1 + valueDice2;
			System.out.println(valueDices);
			if(Integer.parseInt(currentAction.get(2)) == -1) mainFrame.getNextNumberPanel().setNextButton(-1);
			else mainFrame.getNextNumberPanel().setNextButton(1);
			mainFrame.getInteractionPanel().setResultatTestAleatoire();
			switch(currentAction.get(1)) {
			case "SKILL":
				mainFrame.getInteractionPanel().getDice1().rollTheDice(valueDice1);
				mainFrame.getInteractionPanel().getDice2().rollTheDice(valueDice2);
				if(valueDices <= pj.getSkill()) {
					if(Integer.parseInt(currentAction.get(2)) != -1) currentNumero.addNumero(Integer.parseInt(currentAction.get(2)));
					mainFrame.getInteractionPanel().getResultatAleatoireTestLabel().setText("Réussite !");
					mainFrame.getInteractionPanel().getResultatAleatoireTestLabel().setForeground(new Color(103,221,51));
				}
				else {
					mainFrame.getInteractionPanel().getResultatAleatoireTestLabel().setText("Échec !");
					mainFrame.getInteractionPanel().getResultatAleatoireTestLabel().setForeground(Color.RED);
					for(int i = 3 ; i < currentAction.size() ; i++) {
						switch(currentAction.get(i)) {
						case "SKILL":
							pj.decreaseSkill(Integer.parseInt(currentAction.get(i+1)));
							break;
						case "STAMINA":
							pj.decreaseStamina(Integer.parseInt(currentAction.get(i+1)));
							break;
						}
					}
					if(Integer.parseInt(currentAction.get(2)) != -1) currentNumero.addNumero(Integer.parseInt(currentAction.get(currentAction.size()-1)));
				}
				break;
			case "LUCK":
				pj.decrementLuck();
				mainFrame.getInteractionPanel().getDice1().rollTheDice(valueDice1);
				mainFrame.getInteractionPanel().getDice2().rollTheDice(valueDice2);
				if(valueDices <= pj.getLuck()) {
					if(Integer.parseInt(currentAction.get(2)) != -1) currentNumero.addNumero(Integer.parseInt(currentAction.get(2)));
					mainFrame.getInteractionPanel().getResultatAleatoireTestLabel().setText("Réussite !");
					mainFrame.getInteractionPanel().getResultatAleatoireTestLabel().setForeground(new Color(103,221,51));
				}
				else {
					mainFrame.getInteractionPanel().getResultatAleatoireTestLabel().setText("Échec !");
					mainFrame.getInteractionPanel().getResultatAleatoireTestLabel().setForeground(Color.RED);
					for(int i = 3 ; i < currentAction.size() ; i++) {
						switch(currentAction.get(i)) {
						case "SKILL":
							i++;
							pj.decreaseSkill(Integer.parseInt(currentAction.get(i)));
							break;
						case "STAMINA":
							i++;
							pj.decreaseStamina(Integer.parseInt(currentAction.get(i)));
							break;
						}
					}
					if(Integer.parseInt(currentAction.get(2)) != -1) currentNumero.addNumero(Integer.parseInt(currentAction.get(currentAction.size()-1)));
				}
				break;
			default:
				System.out.println("ERROR");
				break;
			}
			if(Integer.parseInt(currentAction.get(2)) != -1) setTextNumero(currentNumero);
			heroPanelController.majHero();
			mainFrame.getInteractionPanel().revalidate();
			mainFrame.getInteractionPanel().repaint();
		}
	}
	
	class TestZAleatoireButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			mainFrame.interactionPanelRemoveAll();
			int valueDice1 = Utilitaire.lancerSix();
			int valueDice2 = Utilitaire.lancerSix();
			int valueDices = valueDice1 + valueDice2;
			System.out.println(valueDices);
			switch(currentAction.get(1)) {
			case "LUCK":
				pj.decrementLuck();
				heroPanelController.majHero();
				if(valueDices <= pj.getLuck()) {
					mainFrame.getInteractionPanel().setResultatTestAleatoire();
					mainFrame.getInteractionPanel().getResultatAleatoireTestLabel().setText("Réussite !");
					mainFrame.getInteractionPanel().getResultatAleatoireTestLabel().setForeground(new Color(103,221,51));
					int compteur = 0;
					for(int i = 0 ; i < currentAction.size() ; i++) {
						if(currentAction.get(i).equalsIgnoreCase("NEXT")) {
							i++;
							for(int j = i ; j < currentAction.size() ; j++) {
								compteur++;
								currentNumero.addNumero(Integer.parseInt(currentAction.get(j)));
							}
							break;
						}
					}
					mainFrame.getNextNumberPanel().setNextButton(compteur);
					setTextNumero(currentNumero);
				}
				else {
					mainFrame.getInteractionPanel().setNextTestAleatoire();
					mainFrame.getInteractionPanel().getResultatAleatoireTestLabel().setText("Échec !");
					mainFrame.getInteractionPanel().getResultatAleatoireTestLabel().setForeground(Color.RED);
					mainFrame.getInteractionPanel().getNextTestZ().addActionListener(new NextTestZListener());
					pj.decreaseStamina(1);
					heroPanelController.majHero();
				}
				break;
			default:
				System.out.println("ERROR");
				break;
			}
			mainFrame.getInteractionPanel().revalidate();
			mainFrame.getInteractionPanel().repaint();
		}
	}
	
	class NextTestZListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			mainFrame.interactionPanelRemoveAll();
			mainFrame.getInteractionPanel().revalidate();
			mainFrame.getInteractionPanel().repaint();
			setAction(currentAction);
		}
	}
	
	class TestAleatoireChoiceButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			mainFrame.interactionPanelRemoveAll();
			int valueDice1 = Utilitaire.lancerSix();
			int valueDice2 = Utilitaire.lancerSix();
			int valueDices = valueDice1 + valueDice2;
			System.out.println(valueDices);
			currentNumero.getEnsembleNumeroSuivants().clear();
			switch(currentAction.get(3)) {
			case "SKILL":
				mainFrame.getNextNumberPanel().setNextButton(1);
				if(valueDices <= pj.getSkill()) {
					currentNumero.addNumero(Integer.parseInt(currentAction.get(4)));
				}
				else {
					currentNumero.addNumero(Integer.parseInt(currentAction.get(5)));
				}
				setTextNumero(currentNumero);
				break;
			case "LUCK":
				mainFrame.getNextNumberPanel().setNextButton(1);
				mainFrame.getInteractionPanel().setResultatTestAleatoire();
				mainFrame.getInteractionPanel().getDice1().rollTheDice(valueDice1);
				mainFrame.getInteractionPanel().getDice2().rollTheDice(valueDice2);
				if(valueDices <= pj.getLuck()) {
					currentNumero.addNumero(Integer.parseInt(currentAction.get(4)));
					mainFrame.getInteractionPanel().getResultatAleatoireTestLabel().setText("Réussite !");
					mainFrame.getInteractionPanel().getResultatAleatoireTestLabel().setForeground(new Color(103,221,51));
				}
				else {
					currentNumero.addNumero(Integer.parseInt(currentAction.get(5)));
					mainFrame.getInteractionPanel().getResultatAleatoireTestLabel().setText("Échec !");
					mainFrame.getInteractionPanel().getResultatAleatoireTestLabel().setForeground(Color.RED);
				}
				setTextNumero(currentNumero);
				pj.decrementLuck();
				heroPanelController.majHero();
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
			mainFrame.fightPanelRemoveAll();
			coupBloque = false;
			nombreAssaut++;
			System.out.println("Assaut N°"+nombreAssaut);
			int valueDice1Ennemi = Utilitaire.lancerSix();
			int valueDice2Ennemi = Utilitaire.lancerSix();
			valueDicesEnnemi = currentEnnemi.getSkill() + valueDice1Ennemi + valueDice2Ennemi;
			System.out.println("ennemi : "+valueDicesEnnemi);
			int valueDice1Pj = Utilitaire.lancerSix();
			int valueDice2Pj = Utilitaire.lancerSix();
			valueDicesPj = pj.getSkill() + valueDice1Pj + valueDice2Pj;
			System.out.println("pj1st : "+valueDicesPj);
			if(pj.getEquipment().contains("Épée Magnifique") || currentNumero.getNumero() == 116) valueDicesPj += 1;
			if(pj.getEquipment().contains("Casque de Fer")) valueDicesPj += 1;
			if(currentNumero.getNumero() == 394) valueDicesPj -= 2;
			System.out.println("pj : "+valueDicesPj);
			if(valueDicesPj != valueDicesEnnemi) {
				if(pj.getEquipment().contains("Bouclier Rond au Croissant en Fer") && valueDicesPj < valueDicesEnnemi) {
					mainFrame.getFightPanel().setFightShield();
					Utilitaire.removeAllListeners(mainFrame.getInteractionPanel().getAleatoireButton());
					mainFrame.getFightPanel().getShieldRandom().addActionListener(new ResulatShieldListener());
				}
				else {
					mainFrame.getFightPanel().setFightAleatoire();
					Utilitaire.removeAllListeners(mainFrame.getFightPanel().getYesTryYourLuck());
					mainFrame.getFightPanel().getYesTryYourLuck().addActionListener(new OuiTenterChanceFightButtonListener());
					Utilitaire.removeAllListeners(mainFrame.getFightPanel().getNoTryYourLuck());
					mainFrame.getFightPanel().getNoTryYourLuck().addActionListener(new NonTenterChanceFightButtonListener());
					if(valueDicesPj > valueDicesEnnemi) {
						mainFrame.getFightPanel().getAssaultResult().setText("Assaut remporté !");
						mainFrame.getFightPanel().getAssaultResult().setForeground(new Color(103,221,51));
					}
					else {
						mainFrame.getFightPanel().getAssaultResult().setText("Assaut perdu...");
						mainFrame.getFightPanel().getAssaultResult().setForeground(Color.RED);
						if(currentNumero.getNumero() == 230) ghoulWound++;
					}
				}
			}
			else {
				mainFrame.getFightPanel().setFightAleatoireEgalite();
				mainFrame.getFightPanel().getAssaultResult().setText("Égalité !");
				mainFrame.getFightPanel().getAssaultResult().setForeground(new Color(57,147,232));
				Utilitaire.removeAllListeners(mainFrame.getFightPanel().getNextAssaultDraw());
				mainFrame.getFightPanel().getNextAssaultDraw().addActionListener(new AssautSuivantEgaliteListener());
			}
			mainFrame.getFightPanel().revalidate();
			mainFrame.getFightPanel().repaint();		
		}
	}
	
	class RandomMonsterButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			mainFrame.getInteractionPanel().removeAll();
			mainFrame.setFight();
			int ennemiNumber = Utilitaire.lancerSix();
			System.out.println(ennemiNumber);
			switch(ennemiNumber) {
			case 1:
				setRandomEnnemi("Gobelin",5,3);
				break;
			case 2:
				setRandomEnnemi("Orque",6,3);
				break;
			case 3:
				setRandomEnnemi("Diablotin",6,4);
				break;
			case 4:
				setRandomEnnemi("Rat Géant",5,4);
				break;
			case 5:
				setRandomEnnemi("Squelette",6,5);
				break;
			case 6:
				setRandomEnnemi("Troll",8,4);
				break;
			default:
				System.out.println("ERROR SWITCH RANDOMMONSTER");
			}
			mainFrame.getFightPanel().getFightRandom().addActionListener(new FightAleatoireButtonListener());
			mainFrame.getInteractionPanel().revalidate();
			mainFrame.getInteractionPanel().repaint();
		}
	}
	
	class AssautSuivantEgaliteListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			mainFrame.fightPanelRemoveAll();
			mainFrame.getFightPanel().setFight();
			mainFrame.getFightPanel().getFightRandom().addActionListener(new FightAleatoireButtonListener());
			if(currentNumero.getNumero() == 179 &&  nombreAssaut >= 4) mainFrame.getEnnemiPanel().getEscape().setEnabled(false);
			else if(currentAction.get(0).equalsIgnoreCase("FIGHT") && Integer.parseInt(currentAction.get(5)) != -1 && nombreAssaut >= Integer.parseInt(currentAction.get(6))) mainFrame.getEnnemiPanel().getEscape().setEnabled(true);
			mainFrame.getFightPanel().revalidate();
			mainFrame.getFightPanel().repaint();
		}
	}
	
	class OuiTenterChanceFightButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			mainFrame.fightPanelRemoveAll();
			pj.decreaseLuck(1);
			heroPanelController.majHero();
			mainFrame.getFightPanel().setTenterChanceFight();
			Utilitaire.removeAllListeners(mainFrame.getFightPanel().getFightRandom());
			mainFrame.getFightPanel().getTryYourLuckRandom().addActionListener(new OuiTenterChanceAleatoireFightButtonListener());
			mainFrame.getFightPanel().revalidate();
			mainFrame.getFightPanel().repaint();
		}
	}
	
	class OuiTenterChanceAleatoireFightButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			mainFrame.fightPanelRemoveAll();
			int valueDice1 = Utilitaire.lancerSix();
			int valueDice2 = Utilitaire.lancerSix();
			int valueDices = valueDice1 + valueDice2;
			mainFrame.getFightPanel().setResultatChanceFight();
			if(valueDicesPj > valueDicesEnnemi) {
				if(valueDices <= pj.getLuck()) {
					mainFrame.getFightPanel().getTryYourLuckResult().setText("Réussite !");
					mainFrame.getFightPanel().getTryYourLuckResult().setForeground(new Color(103,221,51));
					currentEnnemi.decreaseStamina(4);
				}
				else {
					mainFrame.getFightPanel().getTryYourLuckResult().setText("Échec !");
					mainFrame.getFightPanel().getTryYourLuckResult().setForeground(Color.RED);
					currentEnnemi.decreaseStamina(1);
				}
				if(currentEnnemi.getStamina() > 0) majEnnemi();
				else {
					currentEnnemi.setStamina(0);
					majEnnemi();
					if(numeroCombat != nombreEnnemi) {
						mainFrame.getFightPanel().setNextFight();
						Utilitaire.removeAllListeners(mainFrame.getFightPanel().getNextEnnemiButton());
						mainFrame.getFightPanel().getNextEnnemiButton().addActionListener(new NextEnnemiButtonListener());
					}
					else {
						mainFrame.fightPanelRemoveAll();
						if(currentAction.get(0).equalsIgnoreCase("FIGHTMEAL")) {
							mainFrame.getFightPanel().setFightMealWin();
							Utilitaire.removeAllListeners(mainFrame.getFightPanel().getYesMealAfterFight());
							mainFrame.getFightPanel().getYesMealAfterFight().addActionListener(new PrendreUnRepasApresCombatButtonListener());
							Utilitaire.removeAllListeners(mainFrame.getFightPanel().getNoMealAfterFight());
							mainFrame.getFightPanel().getNoMealAfterFight().addActionListener(new NePasPrendreUnRepasApresCombatButtonListener());
						}
						else {
							mainFrame.getFightPanel().setFightWin();
							if(currentNumero.getNumero() == 179) visited179AndKill = true;
							if(currentAction.get(0).equalsIgnoreCase("FIGHTZ") && currentAction.get(1).equalsIgnoreCase("RANDOMMONSTER")) {
								mainFrame.getNextNumberPanel().setNextButton(-1);
							}
							else {
								mainFrame.getNextNumberPanel().setNextButton(1);
								mainFrame.getEnnemiPanel().getEscape().setEnabled(false);
								if(currentAction.get(0).equalsIgnoreCase("FIGHT")) currentNumero.addNumero(Integer.parseInt(currentAction.get(currentAction.size()-3)));
								if(currentAction.get(0).equalsIgnoreCase("FIGHTX")) currentNumero.addNumero(Integer.parseInt(currentAction.get(currentAction.size()-2)));
								setTextNumero(currentNumero);
								if(waitingForUser) waitingForUser = false;
							}
						}
					}
				}
			}
			else if(valueDicesPj < valueDicesEnnemi) {
				if(valueDices <= pj.getLuck()) {
					mainFrame.getFightPanel().getTryYourLuckResult().setText("Réussite !");
					mainFrame.getFightPanel().getTryYourLuckResult().setForeground(new Color(103,221,51));
					if(!coupBloque) pj.decreaseStamina(1);
				}
				else {
					mainFrame.getFightPanel().getTryYourLuckResult().setText("Échec !");
					mainFrame.getFightPanel().getTryYourLuckResult().setForeground(Color.RED);
					if(coupBloque) pj.decreaseStamina(2);
					else pj.decreaseStamina(3);
				}
				if(currentNumero.getNumero() == 230 && ghoulWound == 4) {
					heroPanelController.majHero();
					mainFrame.getFightPanel().getNextAssaultDraw().setVisible(false);
					mainFrame.getNextNumberPanel().setNextButton(1);
					currentNumero.addNumero(Integer.parseInt(currentAction.get(5)));
					setTextNumero(currentNumero);
					mainFrame.getFightPanel().revalidate();
					mainFrame.getFightPanel().repaint();
					return;
				}
				else if(pj.getStamina() > 0) heroPanelController.majHero();
				else {
					pj.setStamina(0);
					heroPanelController.majHero();
					mainFrame.getEnnemiPanel().getEscape().setEnabled(false);
					if(currentNumero.getNumero() == 230) {
						mainFrame.getFightPanel().getNextAssaultDraw().setVisible(false);
						mainFrame.getNextNumberPanel().setNextButton(1);
						currentNumero.addNumero(Integer.parseInt(currentAction.get(5)));
						setTextNumero(currentNumero);
					}
					else {
						mainFrame.fightPanelRemoveAll();
						mainFrame.getFightPanel().setFightGameOver();
					}
				}
			}
			if(currentEnnemi.getStamina() > 0 && pj.getStamina() > 0) {
				mainFrame.getFightPanel().getNextAssaultTryYourLuck().addActionListener(new AssautSuivantChanceListener());
			}
			if(currentNumero.getNumero() == 179 && nombreAssaut >= 4) mainFrame.getEnnemiPanel().getEscape().setEnabled(false);
			else if(currentAction.get(0).equalsIgnoreCase("FIGHT") && Integer.parseInt(currentAction.get(5)) != -1 && nombreAssaut >= Integer.parseInt(currentAction.get(6))) mainFrame.getEnnemiPanel().getEscape().setEnabled(true);
			mainFrame.getFightPanel().revalidate();
			mainFrame.getFightPanel().repaint();
		}
	}
	
	
	class NonTenterChanceFightButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			mainFrame.fightPanelRemoveAll();
			if(valueDicesPj > valueDicesEnnemi) {
				currentEnnemi.decreaseStamina(2);
				if(currentEnnemi.getStamina() > 0) majEnnemi();
				else {
					currentEnnemi.setStamina(0);
					majEnnemi();
					if(numeroCombat != nombreEnnemi) {
						mainFrame.getFightPanel().setNextFight();
						Utilitaire.removeAllListeners(mainFrame.getFightPanel().getNextEnnemiButton());
						mainFrame.getFightPanel().getNextEnnemiButton().addActionListener(new NextEnnemiButtonListener());
					}
					else {
						if(currentAction.get(0).equalsIgnoreCase("FIGHTMEAL")) {
							mainFrame.getFightPanel().setFightMealWin();
							Utilitaire.removeAllListeners(mainFrame.getFightPanel().getYesMealAfterFight());
							mainFrame.getFightPanel().getYesMealAfterFight().addActionListener(new PrendreUnRepasApresCombatButtonListener());
							Utilitaire.removeAllListeners(mainFrame.getFightPanel().getNoMealAfterFight());
							mainFrame.getFightPanel().getNoMealAfterFight().addActionListener(new NePasPrendreUnRepasApresCombatButtonListener());
						}
						else {
							mainFrame.getFightPanel().setFightWin();
							if(currentNumero.getNumero() == 179) visited179AndKill = true;
							if(currentAction.get(0).equalsIgnoreCase("FIGHTZ") && currentAction.get(1).equalsIgnoreCase("RANDOMMONSTER")) {
								mainFrame.getNextNumberPanel().setNextButton(-1);
							}
							else {
								mainFrame.getNextNumberPanel().setNextButton(1);
								mainFrame.getEnnemiPanel().getEscape().setEnabled(false);
								if(currentAction.get(0).equalsIgnoreCase("FIGHT") || currentAction.get(0).equalsIgnoreCase("CHOICE"))currentNumero.addNumero(Integer.parseInt(currentAction.get(currentAction.size()-3)));
								else if(currentAction.get(0).equalsIgnoreCase("FIGHTX") || currentAction.get(0).equalsIgnoreCase("FIGHTZ")) currentNumero.addNumero(Integer.parseInt(currentAction.get(currentAction.size()-2)));
								setTextNumero(currentNumero);
								if(waitingForUser) waitingForUser = false;
							}
						}
					}
				}
			}
			else if(valueDicesPj < valueDicesEnnemi) {
				if(coupBloque) pj.decreaseStamina(1);
				else pj.decreaseStamina(2);
				if(currentNumero.getNumero() == 230 && ghoulWound == 4) {
					heroPanelController.majHero();
					mainFrame.getNextNumberPanel().setNextButton(1);
					currentNumero.addNumero(Integer.parseInt(currentAction.get(5)));
					setTextNumero(currentNumero);
					mainFrame.getFightPanel().revalidate();
					mainFrame.getFightPanel().repaint();
					return;
				}
				else if(pj.getStamina() > 0) heroPanelController.majHero();
				else {
					pj.setStamina(0);
					heroPanelController.majHero();
					mainFrame.getEnnemiPanel().getEscape().setEnabled(false);
					if(currentNumero.getNumero() == 230) {
						mainFrame.getNextNumberPanel().setNextButton(1);
						currentNumero.addNumero(Integer.parseInt(currentAction.get(5)));
						setTextNumero(currentNumero);
					}
					else {
						mainFrame.getFightPanel().setFightGameOver();
					}
				}
			}
			if(currentEnnemi.getStamina() > 0 && pj.getStamina() > 0) {
				if(currentNumero.getNumero() == 41) {
					mainFrame.getNextNumberPanel().setNextButton(1);
					currentNumero.addNumero(310);
					setTextNumero(currentNumero);
				}
				else {
					mainFrame.getFightPanel().setFight();
					Utilitaire.removeAllListeners(mainFrame.getFightPanel().getFightRandom());
					mainFrame.getFightPanel().getFightRandom().addActionListener(new FightAleatoireButtonListener());
				}
				if(currentNumero.getNumero() == 179 && nombreAssaut >= 4) mainFrame.getEnnemiPanel().getEscape().setEnabled(false);
				else if(currentAction.get(0).equalsIgnoreCase("FIGHT") && Integer.parseInt(currentAction.get(5)) != -1 && nombreAssaut >= Integer.parseInt(currentAction.get(6))) mainFrame.getEnnemiPanel().getEscape().setEnabled(true);
			}
			mainFrame.getFightPanel().revalidate();
			mainFrame.getFightPanel().repaint();
		}
	}
	
	class AssautSuivantChanceListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			mainFrame.fightPanelRemoveAll();
			mainFrame.getFightPanel().setFight();
			mainFrame.getFightPanel().getFightRandom().addActionListener(new FightAleatoireButtonListener());
			mainFrame.getFightPanel().revalidate();
			mainFrame.getFightPanel().repaint();
		}
	}
	
	class NextEnnemiButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			mainFrame.fightPanelRemoveAll();
			setEnnemiX();
			mainFrame.getFightPanel().setFight();
			mainFrame.getFightPanel().getFightRandom().addActionListener(new FightAleatoireButtonListener());
			mainFrame.getFightPanel().revalidate();
			mainFrame.getFightPanel().repaint();
		}
	}
	
	class ResulatShieldListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			mainFrame.fightPanelRemoveAll();
			int valueDiceShield = Utilitaire.lancerSix();
			mainFrame.getFightPanel().setResultFightShield();
			mainFrame.getFightPanel().getYesTryYourLuck().addActionListener(new OuiTenterChanceFightButtonListener());
			mainFrame.getFightPanel().getNoTryYourLuck().addActionListener(new NonTenterChanceFightButtonListener());
			if(valueDiceShield == 6) {
				coupBloque = true;
				mainFrame.getFightPanel().getShieldResult().setText("Coup bloqué !");
				mainFrame.getFightPanel().getShieldResult().setForeground(new Color(103,221,51));
			}
			else {
				mainFrame.getFightPanel().getShieldResult().setText("Échec.");
				mainFrame.getFightPanel().getShieldResult().setForeground(Color.RED);
			}
			mainFrame.getFightPanel().revalidate();
			mainFrame.getFightPanel().repaint();
		}
	}
	
	class ChoixCombattreButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			mainFrame.interactionPanelRemoveAll();
			mainFrame.fightPanelRemoveAll();
			mainFrame.setFight();
			setChoiceEnnemi();
			nombreEnnemi = 1;
			numeroCombat = 1;
			mainFrame.getFightPanel().getFightRandom().addActionListener(new FightAleatoireButtonListener());
			mainFrame.getInteractionPanel().revalidate();
			mainFrame.getInteractionPanel().repaint();
		}
	}
	
	class FuiteCombatButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			mainFrame.fightPanelRemoveAll();
			mainFrame.getFightPanel().setChoiceFuite();
			mainFrame.getEnnemiPanel().getEscape().setEnabled(false);
			mainFrame.getFightPanel().getYesTryYourLuckEscape().addActionListener(new FuiteCombatOuiChanceButtonListener());
			mainFrame.getFightPanel().getNoTryYourLuckEscape().addActionListener(new FuiteCombatNonChanceButtonListener());
			if(currentNumero.getNumero() == 143) pj.removeProvision(1);
			mainFrame.getFightPanel().revalidate();
			mainFrame.getFightPanel().repaint();
		}
	}
	
	class FuiteAvantCombatButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			mainFrame.interactionPanelRemoveAll();
			mainFrame.getInteractionPanel().setChoiceFuiteAvantCombat();
			mainFrame.getInteractionPanel().getYesEscapeBeforeFight().addActionListener(new FuiteAvantCombatOuiChanceButtonListener());
			mainFrame.getInteractionPanel().getNoEscapeBeforeFight().addActionListener(new FuiteAvantCombatNonChanceButtonListener());
			mainFrame.getInteractionPanel().revalidate();
			mainFrame.getInteractionPanel().repaint();
		}
	}
	
	class FuiteCombatOuiChanceButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			mainFrame.fightPanelRemoveAll();
			mainFrame.getFightPanel().setTenterChanceFight();
			mainFrame.getFightPanel().getTryYourLuckRandom().addActionListener(new FuiteCombatOuiChanceAleatoireButtonListener());
			mainFrame.getFightPanel().revalidate();
			mainFrame.getFightPanel().repaint();
		}
	}
	
	class FuiteAvantCombatOuiChanceButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			mainFrame.interactionPanelRemoveAll();
			mainFrame.getInteractionPanel().setTest();
			mainFrame.getInteractionPanel().setTestChance();
			mainFrame.getInteractionPanel().getAleatoireButton().addActionListener(new FuiteAvantCombatOuiChanceAleatoireButtonListener());
			mainFrame.getInteractionPanel().setTestChance();
			mainFrame.getInteractionPanel().revalidate();
			mainFrame.getInteractionPanel().repaint();
		}
	}
	
	class FuiteCombatOuiChanceAleatoireButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			mainFrame.fightPanelRemoveAll();
			mainFrame.resetAffichage();
			int valueDice1 = Utilitaire.lancerSix();
			int valueDice2 = Utilitaire.lancerSix();
			int valueDices = valueDice1 + valueDice2;
			System.out.println(valueDices);
			mainFrame.getFightPanel().setEscapeTryYourLuckRandom();
			if(valueDices <= pj.getLuck()) {
				pj.decreaseStamina(1);
				mainFrame.getFightPanel().getTryYourLuckResult().setText("Réussite !");
				mainFrame.getFightPanel().getTryYourLuckResult().setForeground(new Color(103,221,51));
			}
			else {
				pj.decreaseStamina(3);
				mainFrame.getFightPanel().getTryYourLuckResult().setText("Échec !");
				mainFrame.getFightPanel().getTryYourLuckResult().setForeground(Color.RED);
			}
			pj.decrementLuck();
			heroPanelController.majHero();
			if(currentAction.get(0).equalsIgnoreCase("FIGHT")) currentNumero.addNumero(Integer.parseInt(currentAction.get(currentAction.size()-2)));
			else currentNumero.addNumero(Integer.parseInt(currentAction.get(currentAction.size()-1)));
			mainFrame.getNextNumberPanel().setNextButton(currentNumero.getEnsembleNumeroSuivants().size());
			setTextNumero(currentNumero);
			waitingForUser = false;
			multipleNextAction();
			mainFrame.getFightPanel().revalidate();
			mainFrame.getFightPanel().repaint();
		}
	}
	
	class FuiteAvantCombatOuiChanceAleatoireButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			mainFrame.interactionPanelRemoveAll();
			mainFrame.resetAffichage();
			int valueDice1 = Utilitaire.lancerSix();
			int valueDice2 = Utilitaire.lancerSix();
			int valueDices = valueDice1 + valueDice2;
			System.out.println(valueDices);
			mainFrame.getInteractionPanel().setResultatTestAleatoire();
			if(valueDices <= pj.getLuck()) {
				pj.decreaseStamina(1);
				mainFrame.getInteractionPanel().getResultatAleatoireTestLabel().setText("Réussite !");
				mainFrame.getInteractionPanel().getResultatAleatoireTestLabel().setForeground(new Color(103,221,51));
			}
			else {
				pj.decreaseStamina(3);
				mainFrame.getInteractionPanel().getResultatAleatoireTestLabel().setText("Échec !");
				mainFrame.getInteractionPanel().getResultatAleatoireTestLabel().setForeground(Color.RED);
			}
			pj.decrementLuck();
			heroPanelController.majHero();
			int compteur = 0;
			while(!currentAction.get(compteur).equalsIgnoreCase("ESCAPE")) {
				compteur++;
			}
			compteur++;
			currentNumero.getEnsembleNumeroSuivants().clear();
			currentNumero.addNumero(Integer.parseInt(currentAction.get(compteur)));
			mainFrame.getNextNumberPanel().setNextButton(currentNumero.getEnsembleNumeroSuivants().size());
			setTextNumero(currentNumero);
			mainFrame.getInteractionPanel().revalidate();
			mainFrame.getInteractionPanel().repaint();
		}
	}
	
	class FuiteCombatNonChanceButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			mainFrame.interactionPanelRemoveAll();
			pj.decreaseStamina(2);
			heroPanelController.majHero();
			if(currentAction.get(0).equalsIgnoreCase("FIGHT")) currentNumero.addNumero(Integer.parseInt(currentAction.get(currentAction.size()-2)));
			else currentNumero.addNumero(Integer.parseInt(currentAction.get(currentAction.size()-1)));
			mainFrame.resetAffichage();
			mainFrame.getNextNumberPanel().setNextButton(currentNumero.getEnsembleNumeroSuivants().size());
			setTextNumero(currentNumero);
			waitingForUser = false;
			multipleNextAction();
			mainFrame.getInteractionPanel().revalidate();
			mainFrame.getInteractionPanel().repaint();
		}
	}
	
	class FuiteAvantCombatNonChanceButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			mainFrame.interactionPanelRemoveAll();
			pj.decreaseStamina(2);
			heroPanelController.majHero();
			int compteur = 0;
			while(!currentAction.get(compteur).equalsIgnoreCase("ESCAPE")) {
				compteur++;
			}
			compteur++;
			currentNumero.getEnsembleNumeroSuivants().clear();
			currentNumero.addNumero(Integer.parseInt(currentAction.get(compteur)));
			mainFrame.resetAffichage();
			mainFrame.getNextNumberPanel().setNextButton(currentNumero.getEnsembleNumeroSuivants().size());
			setTextNumero(currentNumero);
			mainFrame.getInteractionPanel().revalidate();
			mainFrame.getInteractionPanel().repaint();
		}
	}
	
	class DegatsAleatoireButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			mainFrame.interactionPanelRemoveAll();
			int valueDice = Utilitaire.lancerSix();
			pj.decreaseStamina(valueDice);
			if(pj.getStamina() > 0) {
				heroPanelController.majHero();
				currentNumero.addNumero(Integer.parseInt(currentAction.get(currentAction.size()-1)));
				mainFrame.resetAffichage();
				mainFrame.getNextNumberPanel().setNextButton(currentNumero.getEnsembleNumeroSuivants().size());
				setTextNumero(currentNumero);
			}
			else {
				pj.setStamina(0);
				heroPanelController.majHero();
				mainFrame.getInteractionPanel().setGameOver();
				mainFrame.getNextNumberPanel().setNextButton(0);
			}
			mainFrame.getInteractionPanel().revalidate();
			mainFrame.getInteractionPanel().repaint();
		}
	}
	
	class PrendreUnRepasButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			mainFrame.interactionPanelRemoveAll();
			if(currentNumero.getNumero() == 131) pj.shareMeal();
			else if(currentNumero.getNumero() == 15) {
				pj.takeMeal();
				pj.addStamina(2);
			}
			else pj.takeMeal();
			heroPanelController.majHero();
			if(currentNumero.getNumero() == 316) {
				currentNumero.addNumero(Integer.parseInt(currentAction.get(currentAction.size()-1)));
			}
			else {
				for(int i = 1 ; i < currentAction.size() ; i++) {
					currentNumero.addNumero(Integer.parseInt(currentAction.get(i)));
				}
			}
			mainFrame.resetAffichage();
			mainFrame.getNextNumberPanel().setNextButton(currentNumero.getEnsembleNumeroSuivants().size());
			setTextNumero(currentNumero);
			if(waitingForUser) {
				waitingForUser = false;
				multipleNextAction();
			}
			mainFrame.getInteractionPanel().revalidate();
			mainFrame.getInteractionPanel().repaint();
		}
	}
	
	class NePasPrendreUnRepasButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			mainFrame.interactionPanelRemoveAll();
			if(currentNumero.getNumero() == 316) {
				currentNumero.addNumero(Integer.parseInt(currentAction.get(currentAction.size()-1)));
			}
			else {
				for(int i = 1 ; i < currentAction.size() ; i++) {
					currentNumero.addNumero(Integer.parseInt(currentAction.get(i)));
				}
			}
			mainFrame.resetAffichage();
			mainFrame.getNextNumberPanel().setNextButton(currentNumero.getEnsembleNumeroSuivants().size());
			setTextNumero(currentNumero);
			if(waitingForUser) {
				waitingForUser = false;
				multipleNextAction();
			}
			mainFrame.getInteractionPanel().revalidate();
			mainFrame.getInteractionPanel().repaint();
		}
	}
	
	class PrendreUnRepasChoiceButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			mainFrame.interactionPanelRemoveAll();
			pj.takeMeal();
			heroPanelController.majHero();
			for(int i = 0 ; i < 3 ; i++) {
				currentAction.remove(0);
			}
			mainFrame.getInteractionPanel().revalidate();
			mainFrame.getInteractionPanel().repaint();
			setAction(currentAction);
		}
	}
	
	class NePasPrendreUnRepasChoiceButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			mainFrame.interactionPanelRemoveAll();
			for(int i = 0 ; i < 3 ; i++) {
				currentAction.remove(0);
			}
			mainFrame.getInteractionPanel().revalidate();
			mainFrame.getInteractionPanel().repaint();
			setAction(currentAction);
		}
	}
	
	class PrendreUnRepasXButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			mainFrame.interactionPanelRemoveAll();
			pj.takeMeal();
			for(int i = 2 ; i < currentAction.size() ; i++) {
				switch(currentAction.get(i)) {
				case"LUCK":
					i++;
					pj.addLuck(Integer.parseInt(currentAction.get(i)));
					break;
				default:
					break;
				}
			}
			heroPanelController.majHero();
			for(int i = 0 ; i < 4 ; i++) {
				currentAction.remove(0);
			}
			mainFrame.getInteractionPanel().revalidate();
			mainFrame.getInteractionPanel().repaint();
			setAction(currentAction);
		}
	}
	
	class NePasPrendreUnRepasXButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			mainFrame.interactionPanelRemoveAll();
			for(int i = 0 ; i < 4 ; i++) {
				currentAction.remove(0);
			}
			mainFrame.getInteractionPanel().revalidate();
			mainFrame.getInteractionPanel().repaint();
			setAction(currentAction);
		}
	}
	
	class PrendreUnRepasApresCombatButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			mainFrame.interactionPanelRemoveAll();
			pj.takeMeal();
			heroPanelController.majHero();
			currentNumero.addNumero(Integer.parseInt(currentAction.get(4)));
			mainFrame.resetAffichage();
			mainFrame.getNextNumberPanel().setNextButton(currentNumero.getEnsembleNumeroSuivants().size());
			setTextNumero(currentNumero);
			mainFrame.getInteractionPanel().revalidate();
			mainFrame.getInteractionPanel().repaint();
		}
	}
	
	class NePasPrendreUnRepasApresCombatButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			mainFrame.interactionPanelRemoveAll();
			currentNumero.addNumero(Integer.parseInt(currentAction.get(4)));
			mainFrame.resetAffichage();
			mainFrame.getNextNumberPanel().setNextButton(currentNumero.getEnsembleNumeroSuivants().size());
			setTextNumero(currentNumero);
			mainFrame.getInteractionPanel().revalidate();
			mainFrame.getInteractionPanel().repaint();
		}
	}
	
	class LootChoiceButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			mainFrame.interactionPanelRemoveAll();
			if(e.getActionCommand().equalsIgnoreCase("GOLD")) {
				int compteur = 0;
				for(int i = 0 ; i < currentAction.size() ; i++) {
					if(currentAction.get(i).equalsIgnoreCase("GOLD")) {
						compteur = i+1;
						break;
					}
				}
				pj.addGold(Integer.parseInt(currentAction.get(compteur)));
			}
			else {
				String beforeLoot = "";
				for(int i = 0 ; i < currentAction.size() ; i++) {
					if(currentAction.get(i).equalsIgnoreCase(e.getActionCommand())) break;
					beforeLoot = currentAction.get(i);
				}
				if(beforeLoot.equalsIgnoreCase("EQUIPMENT")) pj.addEquipment(e.getActionCommand());
				else if(beforeLoot.equalsIgnoreCase("TREASURE")) pj.addTreasure(e.getActionCommand());
				else System.out.println("ERROR");
			}
			heroPanelController.majHero();
			currentNumero.addNumero(Integer.parseInt(currentAction.get(currentAction.size()-1)));
			mainFrame.resetAffichage();
			mainFrame.getNextNumberPanel().setNextButton(currentNumero.getEnsembleNumeroSuivants().size());
			setTextNumero(currentNumero);
			mainFrame.getInteractionPanel().revalidate();
			mainFrame.getInteractionPanel().repaint();
		}
	}
	
	class LootOrNotButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			mainFrame.interactionPanelRemoveAll();
			if(e.getActionCommand().equalsIgnoreCase("oui")) {
				for(int i = 0 ; i < currentAction.size() ; i++) {
					if(currentAction.get(i).equalsIgnoreCase("EQUIPMENT")) {
						i++;
						pj.addEquipment(currentAction.get(i));
					}
					else if(currentAction.get(i).equalsIgnoreCase("TREASURE")) {
						i++;
						pj.addTreasure(currentAction.get(i));
					}
					if(currentAction.get(i).equalsIgnoreCase("PROVISION")) {
						i++;
						pj.addProvision(Integer.parseInt(currentAction.get(i)));
					}
					else if(currentAction.get(i).equalsIgnoreCase("NEXT")) break;
				}
			}
			heroPanelController.majHero();
			for(int i = 0 ; i < currentAction.size() ; i++) {
				if(currentAction.get(i).equalsIgnoreCase("NEXT")) {
					for(int j = i+1 ; j < currentAction.size() ; j++) {
						currentNumero.addNumero(Integer.parseInt(currentAction.get(j)));
					}
					break;
				}
			}
			mainFrame.getNextNumberPanel().setNextButton(currentNumero.getEnsembleNumeroSuivants().size());
			setTextNumero(currentNumero);
			mainFrame.getInteractionPanel().revalidate();
			mainFrame.getInteractionPanel().repaint();
		}
	}
	
	class EquipmentChangeButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			mainFrame.interactionPanelRemoveAll();
			if(e.getActionCommand().equalsIgnoreCase("oui")) {
				mainFrame.getInteractionPanel().setChoiceEquipmentChange();
				mainFrame.getInteractionPanel().getValiderEquipementJetable().addActionListener(new ValiderEquipmentJetableButtonListener());
				for(int i = 4 ; i < pj.getEquipment().size() ; i++) {
					mainFrame.getInteractionPanel().getListeEquipementJetable().addItem(pj.getEquipment().get(i));
				}
				for(int i = 0 ; i < pj.getTreasure().size() ; i++) {
					mainFrame.getInteractionPanel().getListeEquipementJetable().addItem(pj.getTreasure().get(i));
				}
			}
			else {
				for(int i = 0 ; i < currentAction.size() ; i++) {
					if(currentAction.get(i).equalsIgnoreCase("NEXT")) {
						while(i+1 < currentAction.size()) {
							i++;
							currentNumero.addNumero(Integer.parseInt(currentAction.get(i)));
						}
					}
				}
				mainFrame.getNextNumberPanel().setNextButton(currentNumero.getEnsembleNumeroSuivants().size());
				setTextNumero(currentNumero);
				waitingForUser = false;
				multipleNextAction();
			}
			mainFrame.getInteractionPanel().revalidate();
			mainFrame.getInteractionPanel().repaint();
		}
	}
	
	class ValiderEquipmentJetableButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			mainFrame.interactionPanelRemoveAll();
			if(pj.getEquipment().contains((String)mainFrame.getInteractionPanel().getListeEquipementJetable().getSelectedItem())) pj.removeEquipment((String)mainFrame.getInteractionPanel().getListeEquipementJetable().getSelectedItem());
			else  pj.removeTreasure((String)mainFrame.getInteractionPanel().getListeEquipementJetable().getSelectedItem());
			for(int i = 0 ; i < currentAction.size() ; i++) {
				if(currentAction.get(i).equalsIgnoreCase("EQUIPMENT")) {
					i++;
					pj.addEquipment(currentAction.get(i));
				}
				else if(currentAction.get(i).equalsIgnoreCase("TREASURE")) {
					i++;
					pj.addTreasure(currentAction.get(i));
				}
				else if(currentAction.get(i).equalsIgnoreCase("GOLD")) {
					i++;
					pj.addGold(Integer.parseInt(currentAction.get(i)));
				}
			}
			heroPanelController.majHero();
			for(int i = 0 ; i < currentAction.size() ; i++) {
				if(currentAction.get(i).equalsIgnoreCase("NEXT")) {
					while(i+1 < currentAction.size()) {
						i++;
						currentNumero.addNumero(Integer.parseInt(currentAction.get(i)));
					}
				}
			}
			mainFrame.getNextNumberPanel().setNextButton(currentNumero.getEnsembleNumeroSuivants().size());
			setTextNumero(currentNumero);
			waitingForUser = false;
			multipleNextAction();
			mainFrame.getInteractionPanel().revalidate();
			mainFrame.getInteractionPanel().repaint();
		}
	}
	
	class ValidateInputUserPreviousNumberButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			int inputUser = Integer.parseInt(mainFrame.getInteractionPanel().getInputUserPreviousNumber().getText());
			switch(inputUser) {
			case 12:
				if(previousNumber != 12) {
					JOptionPane.showMessageDialog(mainFrame, "Vous vous êtes trompé de numéro.");
					return;
				}
				currentNumero.addNumero(256);
				currentNumero.addNumero(364);
				break;
			case 43:
				if(previousNumber != 234) {
					JOptionPane.showMessageDialog(mainFrame, "Vous vous êtes trompé de numéro.");
					return;
				}
				break;
			case 48:
				if(previousNumber != 295) {
					JOptionPane.showMessageDialog(mainFrame, "Vous vous êtes trompé de numéro.");
					return;
				}
				break;
			case 117:
				if(previousNumber != 14) {
					JOptionPane.showMessageDialog(mainFrame, "Vous vous êtes trompé de numéro.");
					return;
				}
				break;
			case 291:
				if(previousNumber != 306) {
					JOptionPane.showMessageDialog(mainFrame, "Vous vous êtes trompé de numéro.");
					return;
				}
				break;
			default:
				JOptionPane.showMessageDialog(mainFrame, "Vous vous êtes trompé de numéro.");
				return;
			}
			mainFrame.interactionPanelRemoveAll();
			if(inputUser != 12) currentNumero.addNumero(inputUser);
			mainFrame.getNextNumberPanel().setNextButton(currentNumero.getEnsembleNumeroSuivants().size());
			setTextNumero(currentNumero);
			mainFrame.getInteractionPanel().revalidate();
			mainFrame.getInteractionPanel().repaint();
		}
	}
	
	class ValiderMultiLootButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			int compteur = 0;
			if(mainFrame.getInteractionPanel().getLoot1CheckBox().isSelected()) compteur++;
			if(mainFrame.getInteractionPanel().getLoot2CheckBox().isSelected()) compteur++;
			if(mainFrame.getInteractionPanel().getLoot3CheckBox().isSelected()) compteur++;
			if(mainFrame.getInteractionPanel().getLoot4CheckBox().isSelected()) compteur++;
			if(mainFrame.getInteractionPanel().getLoot5CheckBox().isSelected()) compteur++;
			if(compteur != 2) JOptionPane.showMessageDialog(mainFrame, "Veuillez selectionner deux objets."); 
			else {
				mainFrame.interactionPanelRemoveAll();
				if(mainFrame.getInteractionPanel().getLoot1CheckBox().isSelected()) {
					if(currentAction.get(1).equalsIgnoreCase("GOLD")) {
						pj.addGold(Integer.parseInt(currentAction.get(2)));
						goldChoice = true;
					}
					else if(currentAction.get(1).equalsIgnoreCase("EQUIPMENT")) pj.addEquipment(currentAction.get(2));
					else pj.addTreasure(currentAction.get(2));
				}
				if(mainFrame.getInteractionPanel().getLoot2CheckBox().isSelected()) {
					if(currentAction.get(3).equalsIgnoreCase("GOLD")) {
						pj.addGold(Integer.parseInt(currentAction.get(4)));
						goldChoice = true;
					}
					else if(currentAction.get(3).equalsIgnoreCase("EQUIPMENT")) pj.addEquipment(currentAction.get(4));
					else pj.addTreasure(currentAction.get(4));
				}
				if(mainFrame.getInteractionPanel().getLoot3CheckBox().isSelected()) {
					if(currentAction.get(5).equalsIgnoreCase("GOLD")) {
						pj.addGold(Integer.parseInt(currentAction.get(6)));
						goldChoice = true;
					}
					else if(currentAction.get(5).equalsIgnoreCase("EQUIPMENT")) pj.addEquipment(currentAction.get(6));
					else pj.addTreasure(currentAction.get(6));
				}
				if(mainFrame.getInteractionPanel().getLoot4CheckBox().isSelected()) {
					if(currentAction.get(7).equalsIgnoreCase("GOLD")) {
						pj.addGold(Integer.parseInt(currentAction.get(8)));
						goldChoice = true;
					}
					else if(currentAction.get(7).equalsIgnoreCase("EQUIPMENT")) pj.addEquipment(currentAction.get(8));
					else pj.addTreasure(currentAction.get(8));
				}
				if(mainFrame.getInteractionPanel().getLoot5CheckBox().isSelected()) {
					if(currentAction.get(9).equalsIgnoreCase("GOLD")) {
						pj.addGold(Integer.parseInt(currentAction.get(10)));
						goldChoice = true;
					}
					else if(currentAction.get(9).equalsIgnoreCase("EQUIPMENT")) pj.addEquipment(currentAction.get(10));
					else pj.addTreasure(currentAction.get(10));
				}
				heroPanelController.majHero();
				waitingForUser = false;
				multipleNextAction();
				mainFrame.getInteractionPanel().revalidate();
				mainFrame.getInteractionPanel().repaint();
			}
		}
	}
	
	class SwitchEquipmentButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			mainFrame.interactionPanelRemoveAll();
			pj.removeEquipment(e.getActionCommand());
			heroPanelController.majHero();
			waitingForUser = false;
			multipleNextAction();
			mainFrame.getInteractionPanel().revalidate();
			mainFrame.getInteractionPanel().repaint();
			
		}
	}
	
	class DropEquipmentButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			mainFrame.interactionPanelRemoveAll();
			if(e.getActionCommand().equalsIgnoreCase("Non")) {
				pj.removeEquipment(currentAction.get(2));
			}
			heroPanelController.majHero();
			waitingForUser = false;
			multipleNextAction();
			mainFrame.getInteractionPanel().revalidate();
			mainFrame.getInteractionPanel().repaint();
			
		}
	}
	
	class BuyOptionButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equalsIgnoreCase("yes")) {
				try {
					pj.decreaseGold(Integer.parseInt(currentAction.get(3)));
					mainFrame.interactionPanelRemoveAll();
					if(currentAction.get(1).equalsIgnoreCase("EQUIPMENT")) pj.addEquipment(currentAction.get(2));
					else pj.addTreasure(currentAction.get(2));
					heroPanelController.majHero();
					waitingForUser = false;
					multipleNextAction();
					mainFrame.getInteractionPanel().revalidate();
					mainFrame.getInteractionPanel().repaint();
				}
				catch(IllegalStateException error) {
					JOptionPane.showMessageDialog(mainFrame, "Vous ne possédez pas suffisamment d'or.");
				}
			}
			else {
				mainFrame.interactionPanelRemoveAll();
				waitingForUser = false;
				multipleNextAction();
				mainFrame.getInteractionPanel().revalidate();
				mainFrame.getInteractionPanel().repaint();
			}
		}
	}
	
	class DiversionDropButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			mainFrame.interactionPanelRemoveAll();
			if("1 Pièce d'Or".equalsIgnoreCase((String)mainFrame.getInteractionPanel().getListeEquipementJetable().getSelectedItem())) pj.decreaseGold(1);
			else if(pj.getEquipment().contains((String)mainFrame.getInteractionPanel().getListeEquipementJetable().getSelectedItem())) pj.removeEquipment((String)mainFrame.getInteractionPanel().getListeEquipementJetable().getSelectedItem());
			else  pj.removeTreasure((String)mainFrame.getInteractionPanel().getListeEquipementJetable().getSelectedItem());
			heroPanelController.majHero();
			waitingForUser = false;
			multipleNextAction();
			mainFrame.getInteractionPanel().revalidate();
			mainFrame.getInteractionPanel().repaint();
		}
	}
	
	class ValidateGambleButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			bet = (int)mainFrame.getInteractionPanel().getGambleValue().getValue();
			System.out.println(bet);
			mainFrame.interactionPanelRemoveAll();
			mainFrame.getInteractionPanel().setTest();
			mainFrame.getInteractionPanel().setThrowDice();
			mainFrame.getInteractionPanel().getAleatoireButton().addActionListener(new RandomGambleButtonListener());
			mainFrame.getInteractionPanel().revalidate();
			mainFrame.getInteractionPanel().repaint();
		}
	}
	
	class RandomGambleButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			mainFrame.interactionPanelRemoveAll();
			int valueDice1Pj = Utilitaire.lancerSix();
			int valueDice2Pj = Utilitaire.lancerSix();
			valueDicesPj = valueDice1Pj + valueDice2Pj;
			int valueDice1Ennemi = Utilitaire.lancerSix();
			int valueDice2Ennemi = Utilitaire.lancerSix();
			valueDicesEnnemi = valueDice1Ennemi + valueDice2Ennemi;
			mainFrame.getInteractionPanel().setGambleResult();
			if(valueDicesPj > valueDicesEnnemi) {
				pj.addGold(bet);
				mainFrame.getInteractionPanel().getResultatAleatoireTestLabel().setText("Réussite !");
				mainFrame.getInteractionPanel().getResultatAleatoireTestLabel().setForeground(new Color(103,221,51));
				if(!gambleBonus) {
					pj.addSkill(2);
					pj.addStamina(2);
					pj.addLuck(2);
					gambleBonus = true;
				}
			}
			else if(valueDicesPj < valueDicesEnnemi) {
				pj.decreaseGold(bet);
				mainFrame.getInteractionPanel().getResultatAleatoireTestLabel().setText("Échec !");
				mainFrame.getInteractionPanel().getResultatAleatoireTestLabel().setForeground(Color.RED);
			}
			else {
				mainFrame.getInteractionPanel().getResultatAleatoireTestLabel().setText("Égalité !");
				mainFrame.getInteractionPanel().getResultatAleatoireTestLabel().setForeground(new Color(57,147,232));
			}
			heroPanelController.majHero();
			mainFrame.getInteractionPanel().getYesGambleAgain().addActionListener(new YesGambleAgainButtonListener());
			mainFrame.getInteractionPanel().getNoGambleAgain().addActionListener(new NoGambleAgainButtonListener());
			mainFrame.getInteractionPanel().revalidate();
			mainFrame.getInteractionPanel().repaint();
		}
	}
	
	class YesGambleAgainButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if(pj.getGold() > 0) {
				mainFrame.interactionPanelRemoveAll();
				mainFrame.getInteractionPanel().setGamble();
				setGambleParameters();
				mainFrame.getInteractionPanel().getValidateGambleValue().addActionListener(new ValidateGambleButtonListener());
				mainFrame.getInteractionPanel().revalidate();
				mainFrame.getInteractionPanel().repaint();
			}
			else {
				JOptionPane.showMessageDialog(mainFrame, "Vous ne possédez pas suffisamment d'or.");
			}
		}
	}
	
	class NoGambleAgainButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			mainFrame.interactionPanelRemoveAll();
			waitingForUser = false;
			multipleNextAction();
			mainFrame.getInteractionPanel().revalidate();
			mainFrame.getInteractionPanel().repaint();
		}
	}
	
	class MainExitListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			mainFrame.dispose();
			System.exit(0);
		}
	}
}