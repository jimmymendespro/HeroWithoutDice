package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	
	private JPanel mainPanel;
	
	private JPanel heroPanel;
	/*private JPanel heroPanelLigne1;
	private JPanel heroPanelLigne2;
	private JPanel heroPanelLigne3;
	private JPanel heroPanelLigne4;*/
	private JLabel nomHero;
	private JButton sauvegarde;
	private JLabel habileteHero;
	private JLabel enduranceHero;
	private JLabel chanceHero;
	private JLabel orHero;
	private JLabel tresorHero;
	private JLabel provisionHero;
	private JTextArea equipementHero;
	
	private JPanel interactionPanel;
	// Combat 
	private JLabel nomEnnemi;
	private JLabel habileteEnnemi;
	private JLabel enduranceEnnemi;
	private JPanel mainFight;
	private JLabel resultatAssaut;
	private JButton ouiTenterChanceFight;
	private JButton nonTenterChanceFight;
	private JButton continuer;
	private JLabel resultatChance;
	
	private JButton nextFightButton;
	
	// Test
	private JLabel titre;
	private JTextField valeur;
	private JButton valider;
	private JLabel ou;
	private JButton aleatoire;
	private JLabel resultatAleatoireTest;
	
	private JPanel nextNumbersPanel;
	private JPanel noBouttonPanel;
	private JButton start;
	private JButton next1;
	private JButton next2;
	private JButton next3;
	private JButton next4;
	private JButton next5;
	
	private JButton choixCombattre;
	private JButton choixFuir;
	
	public MainFrame() {
		super();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Hero without Dice");
		this.setSize(500,700);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	// Getters
	
	public JLabel getNomHero() {
		return this.nomHero;
	}
	
	public JLabel getHabileteHero() {
		return this.habileteHero;
	}
	
	public JLabel getEnduranceHero() {
		return this.enduranceHero;
	}
	
	public JLabel getChanceHero() {
		return this.chanceHero;
	}
	
	public JLabel getOrHero() {
		return this.orHero;
	}

	public JLabel getProvisionHero() {
		return this.provisionHero;
	}
	
	public JTextArea getEquipementHero() {
		return this.equipementHero;
	}
	
	public JPanel getInteractionPanel() {
		return this.interactionPanel;
	}
	
	// Combat
	public JLabel getNomEnnemi() {
		return this.nomEnnemi;
	}
	
	public JLabel getHabileteEnnemi() {
		return this.habileteEnnemi;
	}
	
	public JLabel getEnduranceEnnemi() {
		return this.enduranceEnnemi;
	}
	
	public JPanel getMainFightPanel() {
		return this.mainFight;
	}
	
	public JLabel getResultatAssaut() {
		return this.resultatAssaut;	
	}
	
	public JButton getOuiTenterChanceFight() {
		return this.ouiTenterChanceFight;
	}
	
	public JButton getNonTenterChanceFight() {
		return this.nonTenterChanceFight;
	}
	
	public JButton getContinuer() {
		return this.continuer;
	}
	
	public JLabel getResultatChance() {
		return this.resultatChance;
	}
	
	public JButton getNextFightButton() {
		return this.nextFightButton;
	}
	// Test
	
	public JButton getAleatoireButton() {
		return this.aleatoire;
	}
	
	public JLabel getResultatAleatoireTestLabel() {
		return this.resultatAleatoireTest;
	}
	
	public JPanel getNextNumbersPanel() {
		return this.nextNumbersPanel;
	}
	
	public JButton getStartButton() {
		return this.start;
	}
	
	public JButton getNext1Button() {
		return this.next1;
	}
	
	public JButton getNext2Button() {
		return this.next2;
	}
	
	public JButton getNext3Button() {
		return this.next3;
	}
	
	public JButton getNext4Button() {
		return this.next4;
	}
	
	public JButton getNext5Button() {
		return this.next5;
	}
	
	//
	
	public JButton getChoixCombattre() {
		return this.choixCombattre;
	}
	
	public JButton getChoixFuir() {
		return this.choixFuir;
	}
	
	
	// Méthodes
	
	public void start() {
		mainPanel = new JPanel(new BorderLayout());
		
		setHeroPanel();
	
		interactionPanel = new JPanel();
		//Toute la partie start disparaitra surement avec la V1
		start = new JButton("Start !");
		interactionPanel.add(start);
		
		nextNumbersPanel = new JPanel();
		nextNumbersPanel.setBorder(BorderFactory.createTitledBorder("Numéro(s) Suivant(s)"));
		setButton();
		
		mainPanel.add(heroPanel, BorderLayout.NORTH);
		mainPanel.add(interactionPanel);
		mainPanel.add(nextNumbersPanel, BorderLayout.SOUTH);
		this.setContentPane(mainPanel);
	}
	
	public void resetAffichage() {
		interactionPanel.remove(start);
		mainPanel.repaint();
	}
	
	/*public void setHeroPanel() {
		heroPanel = new JPanel(new GridLayout(5,1));
		heroPanel.setBorder(BorderFactory.createTitledBorder("Feuille d'Aventure"));
		
		heroPanelLigne1 = new JPanel(new GridLayout(1,3));
		nomHero = new JLabel("Nom");
		JLabel vide = new JLabel();
		sauvegarde = new JButton("Sauvegarde");
		heroPanelLigne1.add(nomHero);
		heroPanelLigne1.add(vide);
		heroPanelLigne1.add(sauvegarde);
		
		heroPanelLigne2 = new JPanel(new GridLayout(1,3));
		habileteHero = new JLabel("Habileté : ");
		enduranceHero = new JLabel("Endurance : ");
		chanceHero = new JLabel("Chance : ");
		heroPanelLigne2.add(habileteHero);
		heroPanelLigne2.add(enduranceHero);
		heroPanelLigne2.add(chanceHero);
		
		heroPanelLigne3 = new JPanel(new GridLayout(1,3));
		orHero = new JLabel("Or : ");
		tresorHero = new JLabel("Trésor : ");
		provisionHero = new JLabel("Provisions : ");
		heroPanelLigne3.add(orHero);
		heroPanelLigne3.add(tresorHero);
		heroPanelLigne3.add(provisionHero);
		
		heroPanelLigne4 = new JPanel(new GridLayout(1,1));
		equipementHero = new JTextArea();
		equipementHero.setEditable(false);
		equipementHero.setText("Baguette\nÉpée\nBouclier");
		JScrollPane scrollpane = new JScrollPane(equipementHero);
		scrollpane.setPreferredSize(new Dimension(0,20));
		heroPanelLigne4.add(scrollpane);
		
		heroPanel.add(heroPanelLigne1);
		heroPanel.add(heroPanelLigne2);
		heroPanel.add(heroPanelLigne3);
		heroPanel.add(heroPanelLigne4);
	}*/
	
	public void setHeroPanel() {
		heroPanel = new JPanel(new GridBagLayout());
		heroPanel.setBorder(BorderFactory.createTitledBorder("Feuille d'Aventure"));
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.BOTH;
		constraints.insets = new Insets(1, 0, 1, 0);
		constraints.weightx = 3;
		constraints.weighty = 6;
		
		nomHero = new JLabel("Nom");
		sauvegarde = new JButton("Sauvegarde");
		constraints.gridx = 0;
		constraints.gridy = 0;
		heroPanel.add(nomHero,constraints);
		constraints.gridx = 2;
		constraints.gridy = 0;
		heroPanel.add(sauvegarde,constraints);
		
		constraints.insets = new Insets(4, 0, 4, 0);
		habileteHero = new JLabel("Habileté : ");
		enduranceHero = new JLabel("Endurance : ");
		chanceHero = new JLabel("Chance : ");
		constraints.gridx = 0;
		constraints.gridy = 1;
		heroPanel.add(habileteHero,constraints);
		constraints.gridx = 1;
		constraints.gridy = 1;
		heroPanel.add(enduranceHero,constraints);
		constraints.gridx = 2;
		constraints.gridy = 1;
		heroPanel.add(chanceHero,constraints);
		
		orHero = new JLabel("Or : ");
		tresorHero = new JLabel("Trésor : ");
		provisionHero = new JLabel("Provisions : ");
		constraints.gridx = 0;
		constraints.gridy = 2;
		heroPanel.add(orHero,constraints);
		constraints.gridx = 1;
		constraints.gridy = 2;
		heroPanel.add(tresorHero,constraints);
		constraints.gridx = 2;
		constraints.gridy = 2;
		heroPanel.add(provisionHero,constraints);
		
		JLabel equipementHeroLabel = new JLabel("Équipement :");
		constraints.gridx = 0;
		constraints.gridy = 3;
		heroPanel.add(equipementHeroLabel,constraints);
		
		equipementHero = new JTextArea();
		equipementHero.setEditable(false);
		JScrollPane scrollpane = new JScrollPane(equipementHero);
		scrollpane.setPreferredSize(new Dimension(0,50));
		constraints.gridx = 0;
		constraints.gridy = 4;
		constraints.gridwidth = 3;
		constraints.gridheight = 2;
		heroPanel.add(scrollpane,constraints);
	}
	
	public void setButton() {
		noBouttonPanel = new JPanel();
		noBouttonPanel.setPreferredSize(new Dimension(0,26));
		next1 = new JButton();
		next2 = new JButton();
		next3 = new JButton();
		next4 = new JButton();
		next5 = new JButton();
	}
	
	public void setNextButton(int nombreBouttons) {
		nextNumbersPanel.removeAll();
		switch(nombreBouttons) {
		case 0:
			nextNumbersPanel.add(noBouttonPanel);
			break;
		case 1:
			nextNumbersPanel.add(next1);
			break;
		case 2:
			nextNumbersPanel.add(next1);
			nextNumbersPanel.add(next2);
			break;
		case 3:
			nextNumbersPanel.add(next1);
			nextNumbersPanel.add(next2);
			nextNumbersPanel.add(next3);
			break;
		case 4:
			nextNumbersPanel.add(next1);
			nextNumbersPanel.add(next2);
			nextNumbersPanel.add(next3);
			nextNumbersPanel.add(next4);
			break;
		case 5:
			nextNumbersPanel.add(next1);
			nextNumbersPanel.add(next2);
			nextNumbersPanel.add(next3);
			nextNumbersPanel.add(next4);
			nextNumbersPanel.add(next5);
			break;
		default:
			System.out.println("ERROR");
			break;
		}
		nextNumbersPanel.revalidate();
		nextNumbersPanel.repaint();
	}
	
	public void setTest() {
		interactionPanel.setLayout(new BorderLayout());
		
		JPanel nord = new JPanel();
		nord.setPreferredSize(new Dimension(0,140));
		interactionPanel.add(nord, BorderLayout.NORTH);
		
		JPanel main = new JPanel(new GridLayout(4,1));
		
		JPanel ligne1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		titre = new JLabel();
		ligne1.add(titre);
		main.add(ligne1);
		
		JPanel ligne2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		valeur = new JTextField();
		valeur.setPreferredSize(new Dimension(20,20));
		valider = new JButton("Valider");
		ligne2.add(valeur);
		ligne2.add(valider);
		main.add(ligne2);
		
		JPanel ligne3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		ou = new JLabel("ou");
		ligne3.add(ou);
		main.add(ligne3);
		
		JPanel ligne4 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		aleatoire = new JButton("Aléatoire");
		ligne4.add(aleatoire);
		main.add(ligne4);
		
		interactionPanel.add(main, BorderLayout.CENTER);
		
		JPanel sud = new JPanel();
		sud.setPreferredSize(new Dimension(0,140));
		interactionPanel.add(sud, BorderLayout.SOUTH);
	}
	
	public void setTestChance() {
		titre.setText("Tenter votre chance :");
	}
	
	public void setTestEndurance() {
		titre.setText("Tenter votre endurance :");
	}
	
	public void setTestHabilete() {
		titre.setText("Tester votre habileté :");
	}
	
	public void setTestChanceAleatoire() {
		interactionPanel.setLayout(new BorderLayout());
		
		JPanel nord = new JPanel();
		nord.setPreferredSize(new Dimension(0,200));
		interactionPanel.add(nord, BorderLayout.NORTH);
		
		JPanel main = new JPanel(new FlowLayout(FlowLayout.CENTER));
		resultatAleatoireTest = new JLabel();
		main.add(resultatAleatoireTest);
		
		interactionPanel.add(main, BorderLayout.CENTER);
		
		JPanel sud = new JPanel();
		sud.setPreferredSize(new Dimension(0,160));
		interactionPanel.add(sud, BorderLayout.SOUTH);
	}
	
	public void setFight() {
		interactionPanel.setLayout(new BorderLayout());
		
		JPanel ennemi = new JPanel(new GridLayout(2,1));
		ennemi.setPreferredSize(new Dimension(0,80));
		ennemi.setBorder(BorderFactory.createTitledBorder("Ennemi"));
		
		JPanel ennemiLigne1 = new JPanel(new GridLayout(1,1));
		nomEnnemi = new JLabel();
		ennemiLigne1.add(nomEnnemi);
		
		JPanel ennemiLigne2 = new JPanel(new GridLayout(1,2));
		habileteEnnemi = new JLabel();
		ennemiLigne2.add(habileteEnnemi);
		enduranceEnnemi = new JLabel();
		ennemiLigne2.add(enduranceEnnemi);
		
		ennemi.add(ennemiLigne1);
		ennemi.add(ennemiLigne2);
		
		mainFight = new JPanel(new BorderLayout());
		
		JPanel nord = new JPanel();
		nord.setPreferredSize(new Dimension(0,100));
		mainFight.add(nord, BorderLayout.NORTH);
		
		JPanel center = new JPanel(new GridLayout(4,1));
		
		JPanel ligne1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		titre = new JLabel("Combattez !");
		ligne1.add(titre);
		center.add(ligne1);
		
		JPanel ligne2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		valeur = new JTextField();
		valeur.setPreferredSize(new Dimension(20,20));
		valider = new JButton("Valider");
		ligne2.add(valeur);
		ligne2.add(valider);
		center.add(ligne2);
		
		JPanel ligne3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		ou = new JLabel("ou");
		ligne3.add(ou);
		center.add(ligne3);
		
		JPanel ligne4 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		aleatoire = new JButton("Aléatoire");
		ligne4.add(aleatoire);
		center.add(ligne4);
		
		mainFight.add(center, BorderLayout.CENTER);
		
		JPanel sud = new JPanel();
		sud.setPreferredSize(new Dimension(0,100));
		mainFight.add(sud, BorderLayout.SOUTH);
	
		interactionPanel.add(ennemi, BorderLayout.NORTH);
		interactionPanel.add(mainFight, BorderLayout.CENTER);
	}
	
	public void majFight() {
		
		mainFight = new JPanel(new BorderLayout());
		
		JPanel nord = new JPanel();
		nord.setPreferredSize(new Dimension(0,100));
		mainFight.add(nord, BorderLayout.NORTH);
		
		JPanel center = new JPanel(new GridLayout(4,1));
		
		JPanel ligne1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		titre = new JLabel("Combattez !");
		ligne1.add(titre);
		center.add(ligne1);
		
		JPanel ligne2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		valeur = new JTextField();
		valeur.setPreferredSize(new Dimension(20,20));
		valider = new JButton("Valider");
		ligne2.add(valeur);
		ligne2.add(valider);
		center.add(ligne2);
		
		JPanel ligne3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		ou = new JLabel("ou");
		ligne3.add(ou);
		center.add(ligne3);
		
		JPanel ligne4 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		aleatoire = new JButton("Aléatoire");
		ligne4.add(aleatoire);
		center.add(ligne4);
		
		mainFight.add(center, BorderLayout.CENTER);
		
		JPanel sud = new JPanel();
		sud.setPreferredSize(new Dimension(0,100));
		mainFight.add(sud, BorderLayout.SOUTH);
	
		interactionPanel.add(mainFight, BorderLayout.CENTER);
	}
	
	public void setNextFight() {
		JPanel nord = new JPanel();
		nord.setPreferredSize(new Dimension(0,120));
		mainFight.add(nord, BorderLayout.NORTH);
		
		JPanel center = new JPanel(new GridLayout(3,1));
		
		JPanel ligne1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel ennemiVaincu = new JLabel("Ennemi vaincu !");
		ennemiVaincu.setForeground(new Color(103,221,51));
		ligne1.add(ennemiVaincu);
		center.add(ligne1);
		
		JPanel ligne2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		nextFightButton = new JButton("Ennemi suivant");
		ligne2.add(nextFightButton);
		center.add(ligne2);
		
		mainFight.add(center, BorderLayout.CENTER);
		
		JPanel sud = new JPanel();
		sud.setPreferredSize(new Dimension(0,120));
		mainFight.add(sud, BorderLayout.SOUTH);

		interactionPanel.add(mainFight, BorderLayout.CENTER);
	}
	
	public void setFightAleatoire() {

		JPanel nord = new JPanel();
		nord.setPreferredSize(new Dimension(0,120));
		mainFight.add(nord, BorderLayout.NORTH);
		
		JPanel center = new JPanel(new GridLayout(3,1));
		
		JPanel ligne1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		resultatAssaut = new JLabel();
		ligne1.add(resultatAssaut);
		center.add(ligne1);
		
		JPanel ligne2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		ou = new JLabel("Tentez votre chance ?");
		ligne2.add(ou);
		center.add(ligne2);
		
		JPanel ligne3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		ouiTenterChanceFight = new JButton("Oui");
		ligne3.add(ouiTenterChanceFight);
		nonTenterChanceFight = new JButton("Non");
		ligne3.add(nonTenterChanceFight);
		center.add(ligne3);
		
		mainFight.add(center, BorderLayout.CENTER);
		
		JPanel sud = new JPanel();
		sud.setPreferredSize(new Dimension(0,120));
		mainFight.add(sud, BorderLayout.SOUTH);

		interactionPanel.add(mainFight, BorderLayout.CENTER);
	}
	
	public void setFightAleatoireEgalite() {
		JPanel nord = new JPanel();
		nord.setPreferredSize(new Dimension(0,120));
		mainFight.add(nord, BorderLayout.NORTH);
		
		JPanel center = new JPanel(new GridLayout(2,1));
		
		JPanel ligne1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		resultatAssaut = new JLabel();
		ligne1.add(resultatAssaut);
		center.add(ligne1);
		
		JPanel ligne2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		continuer = new JButton("Assaut suivant");
		ligne2.add(continuer);
		center.add(ligne2);
		
		mainFight.add(center, BorderLayout.CENTER);
		
		JPanel sud = new JPanel();
		sud.setPreferredSize(new Dimension(0,120));
		mainFight.add(sud, BorderLayout.SOUTH);

		interactionPanel.add(mainFight, BorderLayout.CENTER);
	}
	
	public void setTenterChanceFight() {
		
		JPanel nord = new JPanel();
		nord.setPreferredSize(new Dimension(0,120));
		mainFight.add(nord, BorderLayout.NORTH);
		
		JPanel center = new JPanel(new GridLayout(4,1));
		
		JPanel ligne1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		titre = new JLabel();
		ligne1.add(titre);
		center.add(ligne1);
		
		JPanel ligne2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		valeur = new JTextField();
		valeur.setPreferredSize(new Dimension(20,20));
		valider = new JButton("Valider");
		ligne2.add(valeur);
		ligne2.add(valider);
		center.add(ligne2);
		
		JPanel ligne3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		ou = new JLabel("ou");
		ligne3.add(ou);
		center.add(ligne3);
		
		JPanel ligne4 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		aleatoire = new JButton("Aléatoire");
		ligne4.add(aleatoire);
		center.add(ligne4);
		
		mainFight.add(center, BorderLayout.CENTER);
		
		JPanel sud = new JPanel();
		sud.setPreferredSize(new Dimension(0,120));
		mainFight.add(sud, BorderLayout.SOUTH);
		
		interactionPanel.add(mainFight, BorderLayout.CENTER);
	}
	
	public void setResultatChanceFight() {
		JPanel nord = new JPanel();
		nord.setPreferredSize(new Dimension(0,120));
		mainFight.add(nord, BorderLayout.NORTH);
		
		JPanel center = new JPanel(new GridLayout(2,1));
		
		JPanel ligne1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		resultatChance = new JLabel();
		ligne1.add(resultatChance);
		center.add(ligne1);
		
		JPanel ligne2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		continuer = new JButton("Assaut suivant");
		ligne2.add(continuer);
		center.add(ligne2);
		
		mainFight.add(center, BorderLayout.CENTER);
		
		JPanel sud = new JPanel();
		sud.setPreferredSize(new Dimension(0,120));
		mainFight.add(sud, BorderLayout.SOUTH);

		interactionPanel.add(mainFight, BorderLayout.CENTER);
	}
	
	public void setFightWin() {
		JPanel winFightPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel winFight = new JLabel("Combat gagné !");
		winFight.setForeground(new Color(103,221,51));
		winFightPanel.add(winFight);
		mainFight.add(winFightPanel);
	}
	
	public void setFightGameOver() {
		JPanel gameOverPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel gameOver = new JLabel("GAME OVER");
		gameOver.setForeground(Color.RED);
		gameOverPanel.add(gameOver);
		mainFight.add(gameOverPanel);
	}
	
	public void setFightOrEscape() {
		interactionPanel.setLayout(new BorderLayout());
		
		JPanel nord = new JPanel();
		nord.setPreferredSize(new Dimension(0,160));
		interactionPanel.add(nord, BorderLayout.NORTH);
		
		JPanel main = new JPanel(new GridLayout(2,1));
		
		JPanel ligne1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		titre = new JLabel("Combattre ou fuir ?");
		ligne1.add(titre);
		main.add(ligne1);
		
		JPanel ligne2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		choixCombattre = new JButton("Combattre");
		choixFuir = new JButton("Fuir");
		ligne2.add(choixCombattre);
		ligne2.add(choixFuir);
		main.add(ligne2);
		
		interactionPanel.add(main, BorderLayout.CENTER);
		
		JPanel sud = new JPanel();
		sud.setPreferredSize(new Dimension(0,160));
		interactionPanel.add(sud, BorderLayout.SOUTH);
	}
	
	public void rollTheDice(int diceValue) {
		long currentMilliSeconds = System.currentTimeMillis();
		long waitingMilli = currentMilliSeconds + 700;
		while(currentMilliSeconds < waitingMilli) {
			
			currentMilliSeconds = System.currentTimeMillis();
		}
	}
	
	public void rollTheDices(int diceValue1, int diceValue2) {
		long currentMilliSeconds = System.currentTimeMillis();
		long waitingMilli = currentMilliSeconds + 700;
		while(currentMilliSeconds < waitingMilli) {
			
			currentMilliSeconds = System.currentTimeMillis();
		}
	}

}