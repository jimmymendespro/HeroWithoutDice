package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	
	// Panel
	
	private JPanel mainPanel;
	
	private MenuPanel menu;
	private NewCharacterPanel newCharacter;
	
	private HeroPanel heroPanel;
	private CurrentNumberPanel currentNumberPanel;

	private JPanel interactionPanel;
	private JPanel northInteractionPanel;
	private JPanel centerInteractionPanel;
	private JPanel southInteractionPanel;
	
	//private EnnemiPanel ennemiPanel;
	// private FightPanel fightPanel;
	
	private JPanel fightPanel;
	private JPanel northFightPanel;
	private JPanel centerFightPanel;
	private JPanel southFightPanel;
	
	private NextNumberPanel nextNumberPanel;
	
	// Component
	
	// Combat 
	private JLabel nomEnnemi;
	private JButton fuite;
	private JLabel habileteEnnemi;
	private JLabel enduranceEnnemi;
	
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
	
	private JButton start;
	
	private JButton choixCombattre;
	private JButton choixFuir;
	
	private JButton fuir;
	
	private JButton ouiPrendreRepas;
	private JButton nonPrendreRepas;
	
	private JButton ouiRepasApresCombat;
	private JButton nonRepasApresCombat;
	
	private JButton loot1;
	private JButton loot2;
	private JButton loot3;
	
	private JLabel lootOrNotLabel;
	private JButton ouiLootOrNot;
	private JButton nonLootOrNot;
	
	private JButton nextTestZ;
	
	private JButton equipmentExchangeOuiButton;
	private JButton equipmentExchangeNonButton;
	
	private JLabel userFeedback;
	
	private JComboBox<String> listeEquipementJetable;
	private JButton validerEquipementJetable;
	
	private JLabel shieldResultText;
	
	private JTextField inputUserPreviousNumber;
	private JButton validateInputUserPreviousNumber;
	
	private JCheckBox loot1CheckBox;
	private JCheckBox loot2CheckBox;
	private JCheckBox loot3CheckBox;
	private JCheckBox loot4CheckBox;
	private JCheckBox loot5CheckBox;
	private JLabel multiLoot1Label;
	private JLabel multiLoot2Label;
	private JLabel multiLoot3Label;
	private JLabel multiLoot4Label;
	private JLabel multiLoot5Label;
	private JButton validerMultiLootChoice;
	
	private JButton equipment1SwitchButton;
	private JButton equipment2SwitchButton;
	
	private JLabel equipmentDropLabel;
	private JButton equipmentDropYesButton;
	private JButton equipmentDropNoButton;
	
	private JLabel buyOptionText;
	private JButton yesBuyOption;
	private JButton noBuyOption;
	
	private JSpinner gambleValue;
	private JButton validateGambleValue;
	
	private JButton yesGambleAgain;
	private JButton noGambleAgain;
	
	private JButton nextTestMultitest;
	
	private DicePanel dice1;
	private DicePanel dice2;
	
	public MainFrame() {
		super();
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			SwingUtilities.updateComponentTreeUI(this);
		}
		catch(Exception e) {
			System.out.println("Erreur LookAndFeel");
		}
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Hero without Dice");
		this.setSize(500,800);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	// Getters ---------------------------------------------------------------------------------------------------------------------------------
	
	public MenuPanel getMenu() {
		return this.menu;
	}
	
	public NewCharacterPanel getNewCharacter() {
		return this.newCharacter;
	}
	
	public HeroPanel getHeroPanel() {
		return this.heroPanel;
	}
	
	public CurrentNumberPanel getCurrentNumberPanel() {
		return this.currentNumberPanel;
	}
	
	public JPanel getMainPanel() {
		return this.mainPanel;
	}
	
	//
	
	public JPanel getInteractionPanel() {
		return this.interactionPanel;
	}
	
	public NextNumberPanel getNextNumberPanel() {
		return this.nextNumberPanel;
	}
	
	//
	
	public JLabel getUserFeedback() {
		return this.userFeedback;
	}
	
	// Combat
	
	public JLabel getNomEnnemi() {
		return this.nomEnnemi;
	}
	
	public JButton getFuite() {
		return this.fuite;
	}
	
	public JLabel getHabileteEnnemi() {
		return this.habileteEnnemi;
	}
	
	public JLabel getEnduranceEnnemi() {
		return this.enduranceEnnemi;
	}
	
	public JPanel getFightPanel() {
		return this.fightPanel;
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
	
	public JButton getStartButton() {
		return this.start;
	}
	
	//
	
	public JButton getChoixCombattre() {
		return this.choixCombattre;
	}
	
	public JButton getChoixFuir() {
		return this.choixFuir;
	}
	
	public JButton getFuir() {
		return this.fuir;
	}
	
	public JButton getOuiPrendreRepas() {
		return this.ouiPrendreRepas;
	}
	
	public JButton getNonPrendreRepas() {
		return this.nonPrendreRepas;
	}
	
	public JButton getOuiRepasApresCombat() {
		return this.ouiRepasApresCombat;
	}
	
	public JButton getNonRepasApresCombat() {
		return this.nonRepasApresCombat;
	}
	
	public JButton getLoot1Button() {
		return this.loot1;
	}
	
	public JButton getLoot2Button() {
		return this.loot2;
	}
	
	public JButton getLoot3Button() {
		return this.loot3;
	}
	
	public JLabel getLootOrNotLabel() {
		return this.lootOrNotLabel;
	}
	
	public JButton getOuiLootOrNot() {
		return this.ouiLootOrNot;
	}
	
	public JButton getNonLootOrNot() {
		return this.nonLootOrNot;
	}
	
	public JButton getNextTestZ() {
		return this.nextTestZ;
	}
	
	public JButton getEquipmentExchangeOuiButton() {
		return this.equipmentExchangeOuiButton;
	}
	
	public JButton getEquipmentExchangeNonButton() {
		return this.equipmentExchangeNonButton;
	}
	
	public JComboBox<String> getListeEquipementJetable() {
		return this.listeEquipementJetable;
	}
	
	public JButton getValiderEquipementJetable() {
		return this.validerEquipementJetable;
	}
	
	public JLabel getShieldResultText() {
		return this.shieldResultText;
	}
	
	public JTextField getInputUserPreviousNumber() {
		return this.inputUserPreviousNumber;
	}
	
	public JButton getValidateInputUserPreviousNumber() {
		return this.validateInputUserPreviousNumber;
	}
	
	//
	
	public JCheckBox getLoot1CheckBox() {
		return this.loot1CheckBox;
	}
	
	public JCheckBox getLoot2CheckBox() {
		return this.loot2CheckBox;
	}
	
	public JCheckBox getLoot3CheckBox() {
		return this.loot3CheckBox;
	}
	
	public JCheckBox getLoot4CheckBox() {
		return this.loot4CheckBox;
	}
	
	public JCheckBox getLoot5CheckBox() {
		return this.loot5CheckBox;
	}
	
	public JLabel getMultiLoot1Label() {
		return this.multiLoot1Label;
	}
	
	public JLabel getMultiLoot2Label() {
		return this.multiLoot2Label;
	}
	
	public JLabel getMultiLoot3Label() {
		return this.multiLoot3Label;
	}
	
	public JLabel getMultiLoot4Label() {
		return this.multiLoot4Label;
	}
	
	public JLabel getMultiLoot5Label() {
		return this.multiLoot5Label;
	}
	
	public JButton getValiderMultiLootChoice() {
		return this.validerMultiLootChoice;
	}
	
	//
	
	public JButton getEquipment1SwitchButton() {
		return this.equipment1SwitchButton;
	}
	
	public JButton getEquipment2SwitchButton() {
		return this.equipment2SwitchButton;
	}
	
	//
	
	public JLabel getEquipmentDropLabel() {
		return this.equipmentDropLabel;
	}
	
	public JButton getEquipmentDropYesButton() {
		return this.equipmentDropYesButton;
	}
	
	public JButton getEquipmentDropNoButton() {
		return this.equipmentDropNoButton;
	}
	
	public JLabel getBuyOptionText() {
		return this.buyOptionText;
	}
	
	public JButton getYesBuyOption() {
		return this.yesBuyOption;
	}
	
	public JButton getNoBuyOption() {
		return this.noBuyOption;
	}
	
	public JSpinner getGambleValue() {
		return this.gambleValue;
	}
	
	public JButton getValidateGambleValue() {
		return this.validateGambleValue;
	}
	
	public JButton getYesGambleAgain() {
		return this.yesGambleAgain;
	}
	
	public JButton getNoGambleAgain() {
		return this.noGambleAgain;
	}
	
	public JButton getNextTestMultitest() {
		return this.nextTestMultitest;
	}
	
	public DicePanel getDice1() {
		return this.dice1;
	}
	
	public DicePanel getDice2() {
		return this.dice2;
	}

	// Méthodes ---------------------------------------------------------------------------------------------------------------------------------------------------
	
	public void start() {
		heroPanel = new HeroPanel();
		currentNumberPanel = new CurrentNumberPanel();
		
		interactionPanel = new JPanel();
		northInteractionPanel = new JPanel();
		centerInteractionPanel = new JPanel();
		southInteractionPanel = new JPanel();
		
		fightPanel = new JPanel();
		northFightPanel = new JPanel();
		centerFightPanel = new JPanel();
		southFightPanel = new JPanel();
		
		//Toute la partie start disparaitra surement avec la V1
		start = new JButton("Start !");
		interactionPanel.add(start);
		
		nextNumberPanel = new NextNumberPanel();
		
		JPanel northPanel = new JPanel(new BorderLayout());
		northPanel.add(heroPanel);
		northPanel.add(currentNumberPanel, BorderLayout.SOUTH);
		
		mainPanel.add(northPanel, BorderLayout.NORTH);
		mainPanel.add(interactionPanel);
		mainPanel.add(nextNumberPanel, BorderLayout.SOUTH);
		this.setContentPane(mainPanel);
	}
	
	public void resetAffichage() {
		interactionPanel.remove(start);
		mainPanel.repaint();
	}
	
	public void setMenu() {
		mainPanel = new JPanel(new BorderLayout());
		menu = new MenuPanel();
		mainPanel.add(menu);
		this.setContentPane(mainPanel);
	}
	
	public void setNewHero() {
		newCharacter = new NewCharacterPanel();
		mainPanel.add(newCharacter);
	}
	
	public void interactionPanelRemoveAll() {
		interactionPanel.removeAll();
		centerInteractionPanel.removeAll();
	}
	
	public void fightPanelRemoveAll() {
		fightPanel.removeAll();
		centerFightPanel.removeAll();
	}
	
	// Normal Mode -------------------------------------------------------------------------------------------------------------------------------------------
	
	public void setText() {
		interactionPanel.setLayout(new BorderLayout());
		
		northInteractionPanel.setPreferredSize(new Dimension(0,200));
		interactionPanel.add(northInteractionPanel, BorderLayout.NORTH);
		
		centerInteractionPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		userFeedback = new JLabel();
		centerInteractionPanel.add(userFeedback);
		
		interactionPanel.add(centerInteractionPanel, BorderLayout.CENTER);
		
		southInteractionPanel.setPreferredSize(new Dimension(0,140));
		interactionPanel.add(southInteractionPanel, BorderLayout.SOUTH);
	}
	
	public void setTest() {
		interactionPanel.setLayout(new BorderLayout());
		
		northInteractionPanel.setPreferredSize(new Dimension(0,140));
		interactionPanel.add(northInteractionPanel, BorderLayout.NORTH);
		
		centerInteractionPanel.setLayout(new GridLayout(4,1));
		
		JPanel ligne1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		titre = new JLabel();
		ligne1.add(titre);
		centerInteractionPanel.add(ligne1);
		
		JPanel ligne2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		valeur = new JTextField();
		valeur.setPreferredSize(new Dimension(20,20));
		valider = new JButton("Valider");
		ligne2.add(valeur);
		ligne2.add(valider);
		centerInteractionPanel.add(ligne2);
		
		JPanel ligne3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		ou = new JLabel("ou");
		ligne3.add(ou);
		centerInteractionPanel.add(ligne3);
		
		JPanel ligne4 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		aleatoire = new JButton("Aléatoire");
		ligne4.add(aleatoire);
		centerInteractionPanel.add(ligne4);
		
		interactionPanel.add(centerInteractionPanel, BorderLayout.CENTER);
		
		southInteractionPanel.setPreferredSize(new Dimension(0,140));
		interactionPanel.add(southInteractionPanel, BorderLayout.SOUTH);
	}
	
	public void setTestChance() {
		titre.setText("Tenter votre chance :");
	}
	
	public void setTestEndurance() {
		titre.setText("Tester votre endurance :");
	}
	
	public void setTestHabilete() {
		titre.setText("Tester votre habileté :");
	}
	
	public void setTestNone() {
		titre.setText("Tenter votre action :");
	}
	
	public void setWhichEnnemi() {
		titre.setText("Quel ennemi allez vous affronter ?");
	}
	
	public void setdamageDice() {
		titre.setText("Combien de dégâts encaissez vous ?");
	}
	
	public void setThrowDice() {
		titre.setText("Lancez vos dés !");
	}
	
	public void setResultatTestAleatoire() {
		interactionPanel.setLayout(new BorderLayout());

		northInteractionPanel.setPreferredSize(new Dimension(0,140));
		interactionPanel.add(northInteractionPanel, BorderLayout.NORTH);
		
		centerInteractionPanel.setLayout(new GridLayout(2,1));
		
		JPanel line1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		dice1 = new DicePanel(0);
		dice2 = new DicePanel(0);
		line1.add(dice1);
		line1.add(dice2);
		
		JPanel line2 = new JPanel();
		resultatAleatoireTest = new JLabel();
		line2.add(resultatAleatoireTest);
		
		centerInteractionPanel.add(line1);
		centerInteractionPanel.add(line2);
		
		interactionPanel.add(centerInteractionPanel, BorderLayout.CENTER);

		southInteractionPanel.setPreferredSize(new Dimension(0,120));
		interactionPanel.add(southInteractionPanel, BorderLayout.SOUTH);
	}
	
	public void setMultiTestRandomResult() {
		interactionPanel.setLayout(new BorderLayout());

		northInteractionPanel.setPreferredSize(new Dimension(0,140));
		interactionPanel.add(northInteractionPanel, BorderLayout.NORTH);
		
		centerInteractionPanel.setLayout(new GridLayout(2,1));
		
		JPanel line1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		resultatAleatoireTest = new JLabel();
		line1.add(resultatAleatoireTest);
		
		JPanel line2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		nextTestMultitest = new JButton("Suite");
		line2.add(nextTestMultitest);
		
		centerInteractionPanel.add(line1);
		centerInteractionPanel.add(line2);
		
		interactionPanel.add(centerInteractionPanel, BorderLayout.CENTER);

		southInteractionPanel.setPreferredSize(new Dimension(0,120));
		interactionPanel.add(southInteractionPanel, BorderLayout.SOUTH);
	}
	
	public void setNextTestAleatoire() {
		interactionPanel.setLayout(new BorderLayout());

		northInteractionPanel.setPreferredSize(new Dimension(0,200));
		interactionPanel.add(northInteractionPanel, BorderLayout.NORTH);
		
		centerInteractionPanel.setLayout(new GridLayout(2,0));
		
		JPanel ligne1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		resultatAleatoireTest = new JLabel();
		ligne1.add(resultatAleatoireTest);
		
		JPanel ligne2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		nextTestZ = new JButton("Essai suivant");
		ligne2.add(nextTestZ);
		
		centerInteractionPanel.add(ligne1);
		centerInteractionPanel.add(ligne2);
		
		interactionPanel.add(centerInteractionPanel, BorderLayout.CENTER);

		southInteractionPanel.setPreferredSize(new Dimension(0,160));
		interactionPanel.add(southInteractionPanel, BorderLayout.SOUTH);
	}
	
	public void setFightOrEscape() {
		interactionPanel.setLayout(new BorderLayout());
		
		northInteractionPanel.setPreferredSize(new Dimension(0,160));
		interactionPanel.add(northInteractionPanel, BorderLayout.NORTH);
		
		centerInteractionPanel.setLayout(new GridLayout(2,1));
		
		JPanel ligne1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		titre = new JLabel("Combattre ou fuir ?");
		ligne1.add(titre);
		centerInteractionPanel.add(ligne1);
		
		JPanel ligne2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		choixCombattre = new JButton("Combattre");
		choixFuir = new JButton("Fuir");
		ligne2.add(choixCombattre);
		ligne2.add(choixFuir);
		centerInteractionPanel.add(ligne2);
		
		interactionPanel.add(centerInteractionPanel, BorderLayout.CENTER);
		
		southInteractionPanel.setPreferredSize(new Dimension(0,160));
		interactionPanel.add(southInteractionPanel, BorderLayout.SOUTH);
	}
	
	public void setEscape() {
		interactionPanel.setLayout(new BorderLayout());
		
		northInteractionPanel.setPreferredSize(new Dimension(0,200));
		interactionPanel.add(northInteractionPanel, BorderLayout.NORTH);
		
		JPanel main = new JPanel(new FlowLayout(FlowLayout.CENTER));
		fuir = new JButton("Fuir");
		main.add(fuir);
		
		interactionPanel.add(main, BorderLayout.CENTER);
		
		southInteractionPanel.setPreferredSize(new Dimension(0,160));
		interactionPanel.add(southInteractionPanel, BorderLayout.SOUTH);
	}
	
	public void setChoiceFuiteAvantCombat() {
		interactionPanel.setLayout(new BorderLayout());
		
		northInteractionPanel.setPreferredSize(new Dimension(0,120));
		interactionPanel.add(northInteractionPanel, BorderLayout.NORTH);
		
		centerInteractionPanel.setLayout(new GridLayout(3,1));
		
		JPanel ligne1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel fuite = new JLabel("Vous recevez une blessure.");
		fuite.setForeground(Color.RED);
		ligne1.add(fuite);
		centerInteractionPanel.add(ligne1);
		
		JPanel ligne2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		ou = new JLabel("Tentez votre chance ?");
		ligne2.add(ou);
		centerInteractionPanel.add(ligne2);
		
		JPanel ligne3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		ouiTenterChanceFight = new JButton("Oui");
		ligne3.add(ouiTenterChanceFight);
		nonTenterChanceFight = new JButton("Non");
		ligne3.add(nonTenterChanceFight);
		centerInteractionPanel.add(ligne3);
		
		interactionPanel.add(centerInteractionPanel, BorderLayout.CENTER);
		
		southInteractionPanel.setPreferredSize(new Dimension(0,120));
		interactionPanel.add(southInteractionPanel, BorderLayout.SOUTH);
	}
	
	public void setChoiceMeal() {
		interactionPanel.setLayout(new BorderLayout());
		
		northInteractionPanel.setPreferredSize(new Dimension(0,160));
		interactionPanel.add(northInteractionPanel, BorderLayout.NORTH);
		
		centerInteractionPanel.setLayout(new GridLayout(2,1));
		
		JPanel ligne1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel repas = new JLabel("Désirez vous prendre un repas ?");
		ligne1.add(repas);
		centerInteractionPanel.add(ligne1);
		
		JPanel ligne2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		ouiPrendreRepas = new JButton("Oui");
		ligne2.add(ouiPrendreRepas);
		nonPrendreRepas = new JButton("Non");
		ligne2.add(nonPrendreRepas);
		centerInteractionPanel.add(ligne2);
		
		interactionPanel.add(centerInteractionPanel, BorderLayout.CENTER);
		
		southInteractionPanel.setPreferredSize(new Dimension(0,160));
		interactionPanel.add(southInteractionPanel, BorderLayout.SOUTH);
	}
	
	public void setLootOrNot() {
		interactionPanel.setLayout(new BorderLayout());
		
		northInteractionPanel.setPreferredSize(new Dimension(0,170));
		interactionPanel.add(northInteractionPanel, BorderLayout.NORTH);
		
		centerInteractionPanel.setLayout(new GridLayout(2,1));
		JPanel ligne1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		lootOrNotLabel = new JLabel();
		ligne1.add(lootOrNotLabel);
		centerInteractionPanel.add(ligne1);
		
		JPanel ligne2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		ouiLootOrNot = new JButton("Oui");
		ouiLootOrNot.setActionCommand("oui");
		nonLootOrNot = new JButton("Non");
		nonLootOrNot.setActionCommand("non");
		ligne2.add(ouiLootOrNot);
		ligne2.add(nonLootOrNot);
		centerInteractionPanel.add(ligne2);
		
		interactionPanel.add(centerInteractionPanel, BorderLayout.CENTER);
		
		southInteractionPanel.setPreferredSize(new Dimension(0,150));
		interactionPanel.add(southInteractionPanel, BorderLayout.SOUTH);
	}
	
	public void setLootChoice() {
		interactionPanel.setLayout(new BorderLayout());
		
		northInteractionPanel.setPreferredSize(new Dimension(0,140));
		interactionPanel.add(northInteractionPanel, BorderLayout.NORTH);
		
		centerInteractionPanel.setLayout(new GridLayout(3,1));
		JPanel ligne1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		loot1 = new JButton("LOOT1");
		ligne1.add(loot1);
		centerInteractionPanel.add(ligne1);
		
		JPanel ligne2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		loot2 = new JButton("LOOT2");
		ligne2.add(loot2);
		centerInteractionPanel.add(ligne2);
		
		JPanel ligne3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		loot3 = new JButton("LOOT3");
		ligne3.add(loot3);
		centerInteractionPanel.add(ligne3);
		
		interactionPanel.add(centerInteractionPanel, BorderLayout.CENTER);
		
		southInteractionPanel.setPreferredSize(new Dimension(0,140));
		interactionPanel.add(southInteractionPanel, BorderLayout.SOUTH);
	}
	
	public void setLootMultiChoice() {
		interactionPanel.setLayout(new BorderLayout());
		
		northInteractionPanel.setPreferredSize(new Dimension(0,70));
		interactionPanel.add(northInteractionPanel, BorderLayout.NORTH);
		
		centerInteractionPanel.setLayout(new GridLayout(7,1));
		
		JPanel ligne1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel multiChoiceLabel = new JLabel("Veuillez choisir deux objets");
		ligne1.add(multiChoiceLabel);
		centerInteractionPanel.add(ligne1);
		
		JPanel ligne2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JSeparator leftSeparatorLine2 = new JSeparator();
		leftSeparatorLine2.setPreferredSize(new Dimension(170,0));
		loot1CheckBox = new JCheckBox();
		multiLoot1Label = new JLabel("Loot1");
		ligne2.add(leftSeparatorLine2);
		ligne2.add(loot1CheckBox);
		ligne2.add(multiLoot1Label);
		centerInteractionPanel.add(ligne2);
		
		JPanel ligne3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JSeparator leftSeparatorLine3 = new JSeparator();
		leftSeparatorLine3.setPreferredSize(new Dimension(170,0));
		loot2CheckBox = new JCheckBox();
		multiLoot2Label = new JLabel("Loot2");
		ligne3.add(leftSeparatorLine3);
		ligne3.add(loot2CheckBox);
		ligne3.add(multiLoot2Label);
		centerInteractionPanel.add(ligne3);
		
		JPanel ligne4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JSeparator leftSeparatorLine4 = new JSeparator();
		leftSeparatorLine4.setPreferredSize(new Dimension(170,0));
		loot3CheckBox = new JCheckBox();
		multiLoot3Label = new JLabel("Loot3");
		ligne4.add(leftSeparatorLine4);
		ligne4.add(loot3CheckBox);
		ligne4.add(multiLoot3Label);
		centerInteractionPanel.add(ligne4);
		
		JPanel ligne5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JSeparator leftSeparatorLine5 = new JSeparator();
		leftSeparatorLine5.setPreferredSize(new Dimension(170,0));
		loot4CheckBox = new JCheckBox();
		multiLoot4Label = new JLabel("Loot4");
		ligne5.add(leftSeparatorLine5);
		ligne5.add(loot4CheckBox);
		ligne5.add(multiLoot4Label);
		centerInteractionPanel.add(ligne5);
		
		JPanel ligne6 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JSeparator leftSeparatorLine6 = new JSeparator();
		leftSeparatorLine6.setPreferredSize(new Dimension(170,0));
		loot5CheckBox = new JCheckBox();
		multiLoot5Label = new JLabel("Loot5");
		ligne6.add(leftSeparatorLine6);
		ligne6.add(loot5CheckBox);
		ligne6.add(multiLoot5Label);
		centerInteractionPanel.add(ligne6);
		
		JPanel ligne7 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		validerMultiLootChoice = new JButton("Valider"); 
		ligne7.add(validerMultiLootChoice);
		centerInteractionPanel.add(ligne7);
		
		interactionPanel.add(centerInteractionPanel, BorderLayout.CENTER);
		
		southInteractionPanel.setPreferredSize(new Dimension(0,70));
		interactionPanel.add(southInteractionPanel, BorderLayout.SOUTH);
	}
	
	public void setEquipmentChange() {
		interactionPanel.setLayout(new BorderLayout());
		
		northInteractionPanel.setPreferredSize(new Dimension(0,140));
		interactionPanel.add(northInteractionPanel, BorderLayout.NORTH);
		
		centerInteractionPanel.setLayout(new GridLayout(2,1));
		
		JPanel ligne1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel equipmentExchangeLabel = new JLabel("Désirez-vous échanger d'équipement ?");
		ligne1.add(equipmentExchangeLabel);
		
		JPanel ligne2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		equipmentExchangeOuiButton = new JButton("Oui");
		equipmentExchangeOuiButton.setActionCommand("oui");
		equipmentExchangeNonButton = new JButton("Non");
		equipmentExchangeNonButton.setActionCommand("non");
		ligne2.add(equipmentExchangeOuiButton);
		ligne2.add(equipmentExchangeNonButton);
		
		centerInteractionPanel.add(ligne1);
		centerInteractionPanel.add(ligne2);
		
		interactionPanel.add(centerInteractionPanel, BorderLayout.CENTER);
		
		southInteractionPanel.setPreferredSize(new Dimension(0,140));
		interactionPanel.add(southInteractionPanel, BorderLayout.SOUTH);
	}
	
	public void setEquipmentSwitch() {
		interactionPanel.setLayout(new BorderLayout());
		
		northInteractionPanel.setPreferredSize(new Dimension(0,140));
		interactionPanel.add(northInteractionPanel, BorderLayout.NORTH);
		
		centerInteractionPanel.setLayout(new GridLayout(2,1));
		
		JPanel ligne1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel equipmentExchangeLabel = new JLabel("Quel pièce d'équipement souhaitez vous JETER ?");
		ligne1.add(equipmentExchangeLabel);
		
		JPanel ligne2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		equipment1SwitchButton = new JButton("EQ1");
		equipment1SwitchButton.setActionCommand("EQ1");
		equipment2SwitchButton = new JButton("EQ2");
		equipment2SwitchButton.setActionCommand("EQ2");
		ligne2.add(equipment1SwitchButton);
		ligne2.add(equipment2SwitchButton);
		
		centerInteractionPanel.add(ligne1);
		centerInteractionPanel.add(ligne2);
		
		interactionPanel.add(centerInteractionPanel, BorderLayout.CENTER);
		
		southInteractionPanel.setPreferredSize(new Dimension(0,140));
		interactionPanel.add(southInteractionPanel, BorderLayout.SOUTH);
	}
	
	public void setEquipmentDrop() {
		interactionPanel.setLayout(new BorderLayout());
		
		northInteractionPanel.setPreferredSize(new Dimension(0,140));
		interactionPanel.add(northInteractionPanel, BorderLayout.NORTH);
		
		centerInteractionPanel.setLayout(new GridLayout(2,1));
		
		JPanel ligne1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		equipmentDropLabel = new JLabel("");
		ligne1.add(equipmentDropLabel);
		
		JPanel ligne2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		equipmentDropYesButton = new JButton("Oui");
		equipmentDropYesButton.setActionCommand("Oui");
		equipmentDropNoButton = new JButton("Non");
		equipmentDropNoButton.setActionCommand("Non");
		ligne2.add(equipmentDropYesButton);
		ligne2.add(equipmentDropNoButton);
		
		centerInteractionPanel.add(ligne1);
		centerInteractionPanel.add(ligne2);
		
		interactionPanel.add(centerInteractionPanel, BorderLayout.CENTER);
		
		southInteractionPanel.setPreferredSize(new Dimension(0,140));
		interactionPanel.add(southInteractionPanel, BorderLayout.SOUTH);
	}
	
	public void setChoiceEquipmentChange() {
		interactionPanel.setLayout(new BorderLayout());
		
		northInteractionPanel.setPreferredSize(new Dimension(0,160));
		interactionPanel.add(northInteractionPanel, BorderLayout.NORTH);
		
		centerInteractionPanel.setLayout(new GridLayout(2,1));
		
		JPanel ligne1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel equipmentChoiceExchangeLabel = new JLabel("Quel équipement souhaitez vous abandonner ?");
		ligne1.add(equipmentChoiceExchangeLabel);
		
		JPanel ligne2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		listeEquipementJetable = new JComboBox<>();
		validerEquipementJetable = new JButton("Valider");
		ligne2.add(listeEquipementJetable);
		ligne2.add(validerEquipementJetable);
		
		centerInteractionPanel.add(ligne1);
		centerInteractionPanel.add(ligne2);
		
		interactionPanel.add(centerInteractionPanel, BorderLayout.CENTER);
		
		southInteractionPanel.setPreferredSize(new Dimension(0,140));
		interactionPanel.add(southInteractionPanel, BorderLayout.SOUTH);
	}
	
	public void setEnterPreviousNumero() {
		interactionPanel.setLayout(new BorderLayout());
		
		northInteractionPanel.setPreferredSize(new Dimension(0,160));
		interactionPanel.add(northInteractionPanel, BorderLayout.NORTH);
		
		centerInteractionPanel.setLayout(new GridLayout(2,1));
		
		JPanel ligne1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel previousNumber = new JLabel("Veuillez indiquer le numéro indiqué dans la page précédente");
		ligne1.add(previousNumber);
		
		JPanel ligne2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		inputUserPreviousNumber = new JTextField();
		inputUserPreviousNumber.setPreferredSize(new Dimension(27,20));
		validateInputUserPreviousNumber = new JButton("Valider");
		ligne2.add(inputUserPreviousNumber);
		ligne2.add(validateInputUserPreviousNumber);
		
		centerInteractionPanel.add(ligne1);
		centerInteractionPanel.add(ligne2);
		
		interactionPanel.add(centerInteractionPanel, BorderLayout.CENTER);
		
		southInteractionPanel.setPreferredSize(new Dimension(0,140));
		interactionPanel.add(southInteractionPanel, BorderLayout.SOUTH);
	}
	
	public void setBuyOption() {
		interactionPanel.setLayout(new BorderLayout());
		
		northInteractionPanel.setPreferredSize(new Dimension(0,160));
		interactionPanel.add(northInteractionPanel, BorderLayout.NORTH);
		
		centerInteractionPanel.setLayout(new GridLayout(2,1));
		
		JPanel ligne1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		buyOptionText = new JLabel("Désirez vous acheter ");
		ligne1.add(buyOptionText);
		
		JPanel ligne2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		yesBuyOption = new JButton("Oui");
		yesBuyOption.setActionCommand("yes");
		noBuyOption = new JButton("Non");
		noBuyOption.setActionCommand("no");
		ligne2.add(yesBuyOption);
		ligne2.add(noBuyOption);
		
		centerInteractionPanel.add(ligne1);
		centerInteractionPanel.add(ligne2);
		
		interactionPanel.add(centerInteractionPanel, BorderLayout.CENTER);
		
		southInteractionPanel.setPreferredSize(new Dimension(0,140));
		interactionPanel.add(southInteractionPanel, BorderLayout.SOUTH);
	}
	
	public void setGamble() {
		interactionPanel.setLayout(new BorderLayout());
		
		northInteractionPanel.setPreferredSize(new Dimension(0,160));
		interactionPanel.add(northInteractionPanel, BorderLayout.NORTH);
		
		centerInteractionPanel.setLayout(new GridLayout(2,1));
		
		JPanel ligne1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel gambleText = new JLabel("Combien de pièces d'Or souhaitez vous miser ?");
		ligne1.add(gambleText);
		
		JPanel ligne2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		gambleValue = new JSpinner();
		validateGambleValue = new JButton("Valider");
		ligne2.add(gambleValue);
		ligne2.add(validateGambleValue);
		
		centerInteractionPanel.add(ligne1);
		centerInteractionPanel.add(ligne2);
		
		interactionPanel.add(centerInteractionPanel, BorderLayout.CENTER);
		
		southInteractionPanel.setPreferredSize(new Dimension(0,140));
		interactionPanel.add(southInteractionPanel, BorderLayout.SOUTH);
	}
	
	public void setGambleResult() {
		interactionPanel.setLayout(new BorderLayout());

		northInteractionPanel.setPreferredSize(new Dimension(0,120));
		interactionPanel.add(northInteractionPanel, BorderLayout.NORTH);
		
		centerInteractionPanel.setLayout(new GridLayout(3,1));
		
		JPanel line1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		resultatAleatoireTest = new JLabel();
		line1.add(resultatAleatoireTest);
		
		JPanel line2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel gambleAgainText = new JLabel("Souhaitez vous jouer à nouveau ?");
		line2.add(gambleAgainText);
		
		JPanel line3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		yesGambleAgain = new JButton("Oui");
		noGambleAgain = new JButton("Non");
		line3.add(yesGambleAgain);
		line3.add(noGambleAgain);
		
		centerInteractionPanel.add(line1);
		centerInteractionPanel.add(line2);
		centerInteractionPanel.add(line3);
		
		interactionPanel.add(centerInteractionPanel, BorderLayout.CENTER);

		southInteractionPanel.setPreferredSize(new Dimension(0,120));
		interactionPanel.add(southInteractionPanel, BorderLayout.SOUTH);
	}
	
	public void setGameOver() {
		interactionPanel.setLayout(new BorderLayout());
		
		northInteractionPanel.setPreferredSize(new Dimension(0,200));
		interactionPanel.add(northInteractionPanel, BorderLayout.NORTH);
		
		centerInteractionPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel gameOver = new JLabel("GAME OVER");
		gameOver.setForeground(Color.RED);
		centerInteractionPanel.add(gameOver);
		interactionPanel.add(centerInteractionPanel);
		
		southInteractionPanel.setPreferredSize(new Dimension(0,120));
		interactionPanel.add(southInteractionPanel, BorderLayout.SOUTH);
	}
	
	public void setVictory() {
		interactionPanel.setLayout(new BorderLayout());
		
		northInteractionPanel.setPreferredSize(new Dimension(0,200));
		interactionPanel.add(northInteractionPanel, BorderLayout.NORTH);
		
		centerInteractionPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel victory = new JLabel("Victoire !");
		victory.setForeground(new Color(103,221,51));
		centerInteractionPanel.add(victory);
		interactionPanel.add(centerInteractionPanel);
		
		southInteractionPanel.setPreferredSize(new Dimension(0,120));
		interactionPanel.add(southInteractionPanel, BorderLayout.SOUTH);
	}
	
	// Fight Mode -------------------------------------------------------------------------------------------------------------------------------------------------- 
	
	public void setFight() {
		/* Test pour plus tard
		interactionPanel.setLayout(new BorderLayout());
		interactionPanel.add(ennemiPanel, BorderLayout.NORTH);
		fightPanel.setFight();
		interactionPanel.add(fightPanel, BorderLayout.CENTER);
		*/
		interactionPanel.setLayout(new BorderLayout());
		
		JPanel ennemi = new JPanel(new GridLayout(2,1));
		ennemi.setPreferredSize(new Dimension(0,80));
		ennemi.setBorder(BorderFactory.createTitledBorder("Ennemi"));
		
		JPanel ennemiLigne1 = new JPanel(new GridLayout(1,2));
		nomEnnemi = new JLabel();
		JPanel fuitePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		fuite = new JButton("Fuite");
		fuite.setPreferredSize(new Dimension(100,20));
		fuitePanel.add(fuite);
		ennemiLigne1.add(nomEnnemi);
		ennemiLigne1.add(fuitePanel);
		
		JPanel ennemiLigne2 = new JPanel(new GridLayout(1,2));
		habileteEnnemi = new JLabel();
		ennemiLigne2.add(habileteEnnemi);
		enduranceEnnemi = new JLabel();
		ennemiLigne2.add(enduranceEnnemi);
		
		ennemi.add(ennemiLigne1);
		ennemi.add(ennemiLigne2);
		
		fightPanel = new JPanel(new BorderLayout());
		
		northFightPanel.setPreferredSize(new Dimension(0,100));
		fightPanel.add(northFightPanel, BorderLayout.NORTH);

		centerFightPanel.setLayout(new GridLayout(4,1));
		
		JPanel ligne1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		titre = new JLabel("Combattez !");
		ligne1.add(titre);
		centerFightPanel.add(ligne1);
		
		JPanel ligne2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		valeur = new JTextField();
		valeur.setPreferredSize(new Dimension(20,20));
		valider = new JButton("Valider");
		ligne2.add(valeur);
		ligne2.add(valider);
		centerFightPanel.add(ligne2);
		
		JPanel ligne3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		ou = new JLabel("ou");
		ligne3.add(ou);
		centerFightPanel.add(ligne3);
		
		JPanel ligne4 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		aleatoire = new JButton("Aléatoire");
		ligne4.add(aleatoire);
		centerFightPanel.add(ligne4);
		
		fightPanel.add(centerFightPanel, BorderLayout.CENTER);
		
		southFightPanel.setPreferredSize(new Dimension(0,100));
		fightPanel.add(southFightPanel, BorderLayout.SOUTH);
	
		interactionPanel.add(ennemi, BorderLayout.NORTH);
		interactionPanel.add(fightPanel, BorderLayout.CENTER);
	}
	
	public void majFight() {
		fightPanel = new JPanel(new BorderLayout());
		
		northFightPanel.setPreferredSize(new Dimension(0,100));
		fightPanel.add(northFightPanel, BorderLayout.NORTH);
		
		centerFightPanel.setLayout(new GridLayout(4,1));
		
		JPanel ligne1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		titre = new JLabel("Combattez !");
		ligne1.add(titre);
		centerFightPanel.add(ligne1);
		
		JPanel ligne2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		valeur = new JTextField();
		valeur.setPreferredSize(new Dimension(20,20));
		valider = new JButton("Valider");
		ligne2.add(valeur);
		ligne2.add(valider);
		centerFightPanel.add(ligne2);
		
		JPanel ligne3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		ou = new JLabel("ou");
		ligne3.add(ou);
		centerFightPanel.add(ligne3);
		
		JPanel ligne4 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		aleatoire = new JButton("Aléatoire");
		ligne4.add(aleatoire);
		centerFightPanel.add(ligne4);
		
		fightPanel.add(centerFightPanel, BorderLayout.CENTER);
		
		southFightPanel.setPreferredSize(new Dimension(0,100));
		fightPanel.add(southFightPanel, BorderLayout.SOUTH);
	
		interactionPanel.add(fightPanel, BorderLayout.CENTER);
	}
	
	public void setNextFight() {
		northFightPanel.setPreferredSize(new Dimension(0,120));
		fightPanel.add(northFightPanel, BorderLayout.NORTH);
		
		centerFightPanel.setLayout(new GridLayout(3,1));
		
		JPanel ligne1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel ennemiVaincu = new JLabel("Ennemi vaincu !");
		ennemiVaincu.setForeground(new Color(103,221,51));
		ligne1.add(ennemiVaincu);
		centerFightPanel.add(ligne1);
		
		JPanel ligne2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		nextFightButton = new JButton("Ennemi suivant");
		ligne2.add(nextFightButton);
		centerFightPanel.add(ligne2);
		
		fightPanel.add(centerFightPanel, BorderLayout.CENTER);
		
		southFightPanel.setPreferredSize(new Dimension(0,120));
		fightPanel.add(southFightPanel, BorderLayout.SOUTH);

		interactionPanel.add(fightPanel, BorderLayout.CENTER);
	}
	
	public void setFightAleatoire() {
		northFightPanel.setPreferredSize(new Dimension(0,120));
		fightPanel.add(northFightPanel, BorderLayout.NORTH);
	
		centerFightPanel.setLayout(new GridLayout(3,1));
		
		JPanel ligne1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		resultatAssaut = new JLabel();
		ligne1.add(resultatAssaut);
		centerFightPanel.add(ligne1);
		
		JPanel ligne2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		ou = new JLabel("Tentez votre chance ?");
		ligne2.add(ou);
		centerFightPanel.add(ligne2);
		
		JPanel ligne3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		ouiTenterChanceFight = new JButton("Oui");
		ligne3.add(ouiTenterChanceFight);
		nonTenterChanceFight = new JButton("Non");
		ligne3.add(nonTenterChanceFight);
		centerFightPanel.add(ligne3);
		
		fightPanel.add(centerFightPanel, BorderLayout.CENTER);
		
		southFightPanel.setPreferredSize(new Dimension(0,120));
		fightPanel.add(southFightPanel, BorderLayout.SOUTH);

		interactionPanel.add(fightPanel, BorderLayout.CENTER);
	}
	
	public void setFightAleatoireEgalite() {
		northFightPanel.setPreferredSize(new Dimension(0,120));
		fightPanel.add(northFightPanel, BorderLayout.NORTH);
		
		centerFightPanel.setLayout(new GridLayout(2,1));
		
		JPanel ligne1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		resultatAssaut = new JLabel();
		ligne1.add(resultatAssaut);
		centerFightPanel.add(ligne1);
		
		JPanel ligne2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		continuer = new JButton("Assaut suivant");
		ligne2.add(continuer);
		centerFightPanel.add(ligne2);
		
		fightPanel.add(centerFightPanel, BorderLayout.CENTER);
		
		southFightPanel.setPreferredSize(new Dimension(0,120));
		fightPanel.add(southFightPanel, BorderLayout.SOUTH);

		interactionPanel.add(fightPanel, BorderLayout.CENTER);
	}
	
	public void setTenterChanceFight() {
		northFightPanel.setPreferredSize(new Dimension(0,100));
		fightPanel.add(northFightPanel, BorderLayout.NORTH);
		
		centerFightPanel.setLayout(new GridLayout(4,1));
		
		JPanel ligne1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		titre = new JLabel();
		ligne1.add(titre);
		centerFightPanel.add(ligne1);
		
		JPanel ligne2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		valeur = new JTextField();
		valeur.setPreferredSize(new Dimension(20,20));
		valider = new JButton("Valider");
		ligne2.add(valeur);
		ligne2.add(valider);
		centerFightPanel.add(ligne2);
		
		JPanel ligne3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		ou = new JLabel("ou");
		ligne3.add(ou);
		centerFightPanel.add(ligne3);
		
		JPanel ligne4 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		aleatoire = new JButton("Aléatoire");
		ligne4.add(aleatoire);
		centerFightPanel.add(ligne4);
		
		fightPanel.add(centerFightPanel, BorderLayout.CENTER);
		
		southFightPanel.setPreferredSize(new Dimension(0,100));
		fightPanel.add(southFightPanel, BorderLayout.SOUTH);
		
		interactionPanel.add(fightPanel, BorderLayout.CENTER);
	}
	
	public void setResultatChanceFight() {
		northFightPanel.setPreferredSize(new Dimension(0,120));
		fightPanel.add(northFightPanel, BorderLayout.NORTH);
		
		centerFightPanel.setLayout(new GridLayout(2,1));
		
		JPanel ligne1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		resultatChance = new JLabel();
		ligne1.add(resultatChance);
		centerFightPanel.add(ligne1);
		
		JPanel ligne2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		continuer = new JButton("Assaut suivant");
		ligne2.add(continuer);
		centerFightPanel.add(ligne2);
		
		fightPanel.add(centerFightPanel, BorderLayout.CENTER);
		
		southFightPanel.setPreferredSize(new Dimension(0,120));
		fightPanel.add(southFightPanel, BorderLayout.SOUTH);

		interactionPanel.add(fightPanel, BorderLayout.CENTER);
	}
	
	public void setChoiceFuite() {
		northFightPanel.setPreferredSize(new Dimension(0,120));
		fightPanel.add(northFightPanel, BorderLayout.NORTH);
		
		centerFightPanel.setLayout(new GridLayout(3,1));
		
		JPanel ligne1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel fuite = new JLabel("Vous recevez une blessure.");
		fuite.setForeground(Color.RED);
		ligne1.add(fuite);
		centerFightPanel.add(ligne1);
		
		JPanel ligne2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		ou = new JLabel("Tentez votre chance ?");
		ligne2.add(ou);
		centerFightPanel.add(ligne2);
		
		JPanel ligne3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		ouiTenterChanceFight = new JButton("Oui");
		ligne3.add(ouiTenterChanceFight);
		nonTenterChanceFight = new JButton("Non");
		ligne3.add(nonTenterChanceFight);
		centerFightPanel.add(ligne3);
		
		fightPanel.add(centerFightPanel, BorderLayout.CENTER);
		
		southFightPanel.setPreferredSize(new Dimension(0,120));
		fightPanel.add(southFightPanel, BorderLayout.SOUTH);

		interactionPanel.add(fightPanel, BorderLayout.CENTER);
	}
	
	public void setFightWin() {
		northFightPanel.setPreferredSize(new Dimension(0,120));
		fightPanel.add(northFightPanel, BorderLayout.NORTH);
		
		centerFightPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel winFight = new JLabel("Combat gagné !");
		winFight.setForeground(new Color(103,221,51));
		centerFightPanel.add(winFight);
		fightPanel.add(centerFightPanel, BorderLayout.CENTER);
		
		southFightPanel.setPreferredSize(new Dimension(0,120));
		fightPanel.add(southFightPanel, BorderLayout.SOUTH);
	}
	
	public void setFightMealWin() {
		northFightPanel.setPreferredSize(new Dimension(0,120));
		fightPanel.add(northFightPanel, BorderLayout.NORTH);
		
		centerFightPanel.setLayout(new GridLayout(4,1));
		
		JPanel ligne1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel winFight = new JLabel("Combat gagné !");
		winFight.setForeground(new Color(103,221,51));
		ligne1.add(winFight);
		
		JPanel ligne2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel repas = new JLabel("Désirez vous prendre un repas ?");
		ligne2.add(repas);
		
		JPanel ligne3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		ouiRepasApresCombat = new JButton("Oui");
		nonRepasApresCombat = new JButton("Non");
		ligne3.add(ouiRepasApresCombat);
		ligne3.add(nonRepasApresCombat);
		
		centerFightPanel.add(ligne1);
		centerFightPanel.add(ligne2);
		centerFightPanel.add(ligne3);
		
		fightPanel.add(centerFightPanel, BorderLayout.CENTER);
		
		southFightPanel.setPreferredSize(new Dimension(0,80));
		fightPanel.add(southFightPanel, BorderLayout.SOUTH);
	}
	
	public void setFightGameOver() {
		northFightPanel.setPreferredSize(new Dimension(0,120));
		fightPanel.add(northFightPanel, BorderLayout.NORTH);

		JPanel gameOverPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel gameOver = new JLabel("GAME OVER");
		gameOver.setForeground(Color.RED);
		gameOverPanel.add(gameOver);
		centerFightPanel.add(gameOverPanel);
		fightPanel.add(centerFightPanel, BorderLayout.CENTER);
		
		southFightPanel.setPreferredSize(new Dimension(0,120));
		fightPanel.add(southFightPanel, BorderLayout.SOUTH);
	}
	
	public void setFightShield() {
		northFightPanel.setPreferredSize(new Dimension(0,80));
		fightPanel.add(northFightPanel, BorderLayout.NORTH);
	
		centerFightPanel.setLayout(new GridLayout(5,1));
		
		JPanel ligne1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel shieldExplanationText = new JLabel("Assaut perdu...");
		shieldExplanationText.setForeground(Color.RED);
		ligne1.add(shieldExplanationText);
		centerFightPanel.add(ligne1);
		
		JPanel ligne2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel shieldExplanationText2 = new JLabel("Utilisez votre bouclier !");
		ligne2.add(shieldExplanationText2);
		centerFightPanel.add(ligne2);
		
		JPanel ligne3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		valeur = new JTextField();
		valeur.setPreferredSize(new Dimension(20,20));
		valider = new JButton("Valider");
		ligne3.add(valeur);
		ligne3.add(valider);
		centerFightPanel.add(ligne3);
		
		JPanel ligne4 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		ou = new JLabel("ou");
		ligne4.add(ou);
		centerFightPanel.add(ligne4);
		
		JPanel ligne5 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		aleatoire = new JButton("Aléatoire");
		ligne5.add(aleatoire);
		centerFightPanel.add(ligne5);
		
		fightPanel.add(centerFightPanel, BorderLayout.CENTER);
		
		southFightPanel.setPreferredSize(new Dimension(0,80));
		fightPanel.add(southFightPanel, BorderLayout.SOUTH);

		interactionPanel.add(fightPanel, BorderLayout.CENTER);
	}
	
	public void setResultFightShield() {
		northFightPanel.setPreferredSize(new Dimension(0,100));
		fightPanel.add(northFightPanel, BorderLayout.NORTH);
	
		centerFightPanel.setLayout(new GridLayout(5,1));
		
		JPanel ligne1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		shieldResultText = new JLabel();
		ligne1.add(shieldResultText);
		centerFightPanel.add(ligne1);
		
		JPanel ligne2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		ou = new JLabel("Tentez votre chance ?");
		ligne2.add(ou);
		centerFightPanel.add(ligne2);
		
		JPanel ligne3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		ouiTenterChanceFight = new JButton("Oui");
		ouiTenterChanceFight.setActionCommand("oui");
		ligne3.add(ouiTenterChanceFight);
		nonTenterChanceFight = new JButton("Non");
		nonTenterChanceFight.setActionCommand("non");
		ligne3.add(nonTenterChanceFight);
		centerFightPanel.add(ligne3);
		
		fightPanel.add(centerFightPanel, BorderLayout.CENTER);
		
		southFightPanel.setPreferredSize(new Dimension(0,80));
		fightPanel.add(southFightPanel, BorderLayout.SOUTH);

		interactionPanel.add(fightPanel, BorderLayout.CENTER);
	}
	
	public void setFightTestChanceAleatoire() {
		northFightPanel.setPreferredSize(new Dimension(0,160));
		fightPanel.add(northFightPanel, BorderLayout.NORTH);
		
		centerFightPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		resultatAleatoireTest = new JLabel();
		centerFightPanel.add(resultatAleatoireTest);
		fightPanel.add(centerFightPanel, BorderLayout.CENTER);
		
		southFightPanel.setPreferredSize(new Dimension(0,100));
		fightPanel.add(southFightPanel, BorderLayout.SOUTH);

		interactionPanel.add(fightPanel, BorderLayout.CENTER);
	}
	
	// Dices Graphics --------------------------------------------------------------------------------------------------------------------------------------------
	
	public void rollTheDice(int diceValue) {
		
	}
	
	public void rollTheDices(int diceValue1, int diceValue2) {
		long currentMilliSeconds = System.currentTimeMillis();
		long waitingMilli = currentMilliSeconds + 700;
		while(currentMilliSeconds < waitingMilli) {
			
			currentMilliSeconds = System.currentTimeMillis();
		}
	}

}