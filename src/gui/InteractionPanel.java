package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class InteractionPanel extends JPanel {
	
	private JPanel northPanel;
	private JPanel center;
	private JPanel southPanel;
	
	private JLabel userFeedback;
	private JLabel titre;
	private JTextField valeur;
	private JButton valider;
	private JLabel ou;
	private JButton aleatoire;
	private JLabel resultatAleatoireTest;
	private DicePanel dice1;
	private DicePanel dice2;
	private JButton nextTestMultitest;
	private JButton nextTestZ;
	private JButton choixCombattre;
	private JButton choixFuir;
	private JButton fuir;
	private JButton yesEscapeBeforeFight;
	private JButton noEscapeBeforeFight;
	private JButton ouiPrendreRepas;
	private JButton nonPrendreRepas;
	private JLabel lootOrNotLabel;
	private JButton ouiLootOrNot;
	private JButton nonLootOrNot;
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
	private JButton loot1;
	private JButton loot2;
	private JButton loot3;
	private JButton equipmentExchangeOuiButton;
	private JButton equipmentExchangeNonButton;
	private JButton equipment1SwitchButton;
	private JButton equipment2SwitchButton;
	private JLabel equipmentDropLabel;
	private JButton equipmentDropYesButton;
	private JButton equipmentDropNoButton;
	private JComboBox<String> listeEquipementJetable;
	private JButton validerEquipementJetable;
	private JTextField inputUserPreviousNumber;
	private JButton validateInputUserPreviousNumber;
	private JLabel buyOptionText;
	private JButton yesBuyOption;
	private JButton noBuyOption;
	private JSpinner gambleValue;
	private JButton validateGambleValue;
	private JButton yesGambleAgain;
	private JButton noGambleAgain;

	public InteractionPanel() {
		super();
		northPanel = new JPanel();
		center = new JPanel();
		southPanel = new JPanel();
	}
	
	// Getters -------------------------------------------------------------------------------------------------------------------------------------------
	public JPanel getCenter() {
		return this.center;
	}
	public JLabel getUserFeedback() {
		return this.userFeedback;
	}
	public JButton getAleatoireButton() {
		return this.aleatoire;
	}
	public JLabel getResultatAleatoireTestLabel() {
		return this.resultatAleatoireTest;
	}
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
	public JTextField getInputUserPreviousNumber() {
		return this.inputUserPreviousNumber;
	}
	public JButton getValidateInputUserPreviousNumber() {
		return this.validateInputUserPreviousNumber;
	}
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
	public JButton getEquipment1SwitchButton() {
		return this.equipment1SwitchButton;
	}
	public JButton getEquipment2SwitchButton() {
		return this.equipment2SwitchButton;
	}
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
	public JButton getYesEscapeBeforeFight() {
		return this.yesEscapeBeforeFight;
	}
	public JButton getNoEscapeBeforeFight() {
		return this.noEscapeBeforeFight;
	}
	
	// Methods -------------------------------------------------------------------------------------------------------------------------------------------
	
	public void setText() {
		this.setLayout(new BorderLayout());
		
		northPanel.setPreferredSize(new Dimension(0,200));
		this.add(northPanel, BorderLayout.NORTH);
		
		center.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		userFeedback = new JLabel();
		center.add(userFeedback);
		
		this.add(center, BorderLayout.CENTER);
		
		southPanel.setPreferredSize(new Dimension(0,140));
		this.add(southPanel, BorderLayout.SOUTH);
	}
	
	public void setTest() {
		this.setLayout(new BorderLayout());
		
		northPanel.setPreferredSize(new Dimension(0,120));
		this.add(northPanel, BorderLayout.NORTH);
		
		center.setLayout(new GridLayout(4,1));
		
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
		
		this.add(center, BorderLayout.CENTER);
		
		southPanel.setPreferredSize(new Dimension(0,120));
		this.add(southPanel, BorderLayout.SOUTH);
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
		this.setLayout(new BorderLayout());

		northPanel.setPreferredSize(new Dimension(0,140));
		this.add(northPanel, BorderLayout.NORTH);
		
		center.setLayout(new GridLayout(2,1));
		
		JPanel line1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		dice1 = new DicePanel(0);
		dice2 = new DicePanel(0);
		line1.add(dice1);
		line1.add(dice2);
		
		JPanel line2 = new JPanel();
		resultatAleatoireTest = new JLabel();
		line2.add(resultatAleatoireTest);
		
		center.add(line1);
		center.add(line2);
		
		this.add(center, BorderLayout.CENTER);

		southPanel.setPreferredSize(new Dimension(0,120));
		this.add(southPanel, BorderLayout.SOUTH);
	}
	
	public void setMultiTestRandomResult() {
		this.setLayout(new BorderLayout());

		northPanel.setPreferredSize(new Dimension(0,140));
		this.add(northPanel, BorderLayout.NORTH);
		
		center.setLayout(new GridLayout(2,1));
		
		JPanel line1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		resultatAleatoireTest = new JLabel();
		line1.add(resultatAleatoireTest);
		
		JPanel line2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		nextTestMultitest = new JButton("Suite");
		line2.add(nextTestMultitest);
		
		center.add(line1);
		center.add(line2);
		
		this.add(center, BorderLayout.CENTER);

		southPanel.setPreferredSize(new Dimension(0,120));
		this.add(southPanel, BorderLayout.SOUTH);
	}
	
	public void setNextTestAleatoire() {
		this.setLayout(new BorderLayout());

		northPanel.setPreferredSize(new Dimension(0,200));
		this.add(northPanel, BorderLayout.NORTH);
		
		center.setLayout(new GridLayout(2,0));
		
		JPanel ligne1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		resultatAleatoireTest = new JLabel();
		ligne1.add(resultatAleatoireTest);
		
		JPanel ligne2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		nextTestZ = new JButton("Essai suivant");
		ligne2.add(nextTestZ);
		
		center.add(ligne1);
		center.add(ligne2);
		
		this.add(center, BorderLayout.CENTER);

		southPanel.setPreferredSize(new Dimension(0,160));
		this.add(southPanel, BorderLayout.SOUTH);
	}
	
	public void setFightOrEscape() {
		this.setLayout(new BorderLayout());
		
		northPanel.setPreferredSize(new Dimension(0,140));
		this.add(northPanel, BorderLayout.NORTH);
		
		center.setLayout(new GridLayout(2,1));
		
		JPanel ligne1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		titre = new JLabel("Combattre ou fuir ?");
		ligne1.add(titre);
		center.add(ligne1);
		
		JPanel ligne2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		choixCombattre = new JButton("Combattre");
		choixFuir = new JButton("Fuir");
		ligne2.add(choixCombattre);
		ligne2.add(choixFuir);
		center.add(ligne2);
		
		this.add(center, BorderLayout.CENTER);
		
		southPanel.setPreferredSize(new Dimension(0,140));
		this.add(southPanel, BorderLayout.SOUTH);
	}
	
	public void setEscape() {
		this.setLayout(new BorderLayout());
		
		northPanel.setPreferredSize(new Dimension(0,180));
		this.add(northPanel, BorderLayout.NORTH);
		
		JPanel main = new JPanel(new FlowLayout(FlowLayout.CENTER));
		fuir = new JButton("Fuir");
		main.add(fuir);
		
		this.add(main, BorderLayout.CENTER);
		
		southPanel.setPreferredSize(new Dimension(0,140));
		this.add(southPanel, BorderLayout.SOUTH);
	}
	
	public void setChoiceFuiteAvantCombat() {
		this.setLayout(new BorderLayout());
		
		northPanel.setPreferredSize(new Dimension(0,120));
		this.add(northPanel, BorderLayout.NORTH);
		
		center.setLayout(new GridLayout(3,1));
		
		JPanel ligne1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel fuite = new JLabel("Vous recevez une blessure.");
		fuite.setForeground(Color.RED);
		ligne1.add(fuite);
		center.add(ligne1);
		
		JPanel ligne2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		ou = new JLabel("Tentez votre chance ?");
		ligne2.add(ou);
		center.add(ligne2);
		
		JPanel ligne3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		yesEscapeBeforeFight = new JButton("Oui");
		ligne3.add(yesEscapeBeforeFight);
		noEscapeBeforeFight = new JButton("Non");
		ligne3.add(noEscapeBeforeFight);
		center.add(ligne3);
		
		this.add(center, BorderLayout.CENTER);
		
		southPanel.setPreferredSize(new Dimension(0,120));
		this.add(southPanel, BorderLayout.SOUTH);
	}
	
	public void setChoiceMeal() {
		this.setLayout(new BorderLayout());
		
		northPanel.setPreferredSize(new Dimension(0,140));
		this.add(northPanel, BorderLayout.NORTH);
		
		center.setLayout(new GridLayout(2,1));
		
		JPanel ligne1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel repas = new JLabel("Désirez vous prendre un repas ?");
		ligne1.add(repas);
		center.add(ligne1);
		
		JPanel ligne2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		ouiPrendreRepas = new JButton("Oui");
		ligne2.add(ouiPrendreRepas);
		nonPrendreRepas = new JButton("Non");
		ligne2.add(nonPrendreRepas);
		center.add(ligne2);
		
		this.add(center, BorderLayout.CENTER);
		
		southPanel.setPreferredSize(new Dimension(0,140));
		this.add(southPanel, BorderLayout.SOUTH);
	}
	
	public void setLootOrNot() {
		this.setLayout(new BorderLayout());
		
		northPanel.setPreferredSize(new Dimension(0,160));
		this.add(northPanel, BorderLayout.NORTH);
		
		center.setLayout(new GridLayout(2,1));
		JPanel ligne1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		lootOrNotLabel = new JLabel();
		ligne1.add(lootOrNotLabel);
		center.add(ligne1);
		
		JPanel ligne2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		ouiLootOrNot = new JButton("Oui");
		ouiLootOrNot.setActionCommand("oui");
		nonLootOrNot = new JButton("Non");
		nonLootOrNot.setActionCommand("non");
		ligne2.add(ouiLootOrNot);
		ligne2.add(nonLootOrNot);
		center.add(ligne2);
		
		this.add(center, BorderLayout.CENTER);
		
		southPanel.setPreferredSize(new Dimension(0,140));
		this.add(southPanel, BorderLayout.SOUTH);
	}
	
	public void setLootChoice() {
		this.setLayout(new BorderLayout());
		
		northPanel.setPreferredSize(new Dimension(0,140));
		this.add(northPanel, BorderLayout.NORTH);
		
		center.setLayout(new GridLayout(3,1));
		JPanel ligne1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		loot1 = new JButton("LOOT1");
		ligne1.add(loot1);
		center.add(ligne1);
		
		JPanel ligne2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		loot2 = new JButton("LOOT2");
		ligne2.add(loot2);
		center.add(ligne2);
		
		JPanel ligne3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		loot3 = new JButton("LOOT3");
		ligne3.add(loot3);
		center.add(ligne3);
		
		this.add(center, BorderLayout.CENTER);
		
		southPanel.setPreferredSize(new Dimension(0,140));
		this.add(southPanel, BorderLayout.SOUTH);
	}
	
	public void setLootMultiChoice() {
		this.setLayout(new BorderLayout());
		
		northPanel.setPreferredSize(new Dimension(0,70));
		this.add(northPanel, BorderLayout.NORTH);
		
		center.setLayout(new GridLayout(7,1));
		
		JPanel ligne1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel multiChoiceLabel = new JLabel("Veuillez choisir deux objets");
		ligne1.add(multiChoiceLabel);
		center.add(ligne1);
		
		JPanel ligne2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JSeparator leftSeparatorLine2 = new JSeparator();
		leftSeparatorLine2.setPreferredSize(new Dimension(170,0));
		loot1CheckBox = new JCheckBox();
		multiLoot1Label = new JLabel("Loot1");
		ligne2.add(leftSeparatorLine2);
		ligne2.add(loot1CheckBox);
		ligne2.add(multiLoot1Label);
		center.add(ligne2);
		
		JPanel ligne3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JSeparator leftSeparatorLine3 = new JSeparator();
		leftSeparatorLine3.setPreferredSize(new Dimension(170,0));
		loot2CheckBox = new JCheckBox();
		multiLoot2Label = new JLabel("Loot2");
		ligne3.add(leftSeparatorLine3);
		ligne3.add(loot2CheckBox);
		ligne3.add(multiLoot2Label);
		center.add(ligne3);
		
		JPanel ligne4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JSeparator leftSeparatorLine4 = new JSeparator();
		leftSeparatorLine4.setPreferredSize(new Dimension(170,0));
		loot3CheckBox = new JCheckBox();
		multiLoot3Label = new JLabel("Loot3");
		ligne4.add(leftSeparatorLine4);
		ligne4.add(loot3CheckBox);
		ligne4.add(multiLoot3Label);
		center.add(ligne4);
		
		JPanel ligne5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JSeparator leftSeparatorLine5 = new JSeparator();
		leftSeparatorLine5.setPreferredSize(new Dimension(170,0));
		loot4CheckBox = new JCheckBox();
		multiLoot4Label = new JLabel("Loot4");
		ligne5.add(leftSeparatorLine5);
		ligne5.add(loot4CheckBox);
		ligne5.add(multiLoot4Label);
		center.add(ligne5);
		
		JPanel ligne6 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JSeparator leftSeparatorLine6 = new JSeparator();
		leftSeparatorLine6.setPreferredSize(new Dimension(170,0));
		loot5CheckBox = new JCheckBox();
		multiLoot5Label = new JLabel("Loot5");
		ligne6.add(leftSeparatorLine6);
		ligne6.add(loot5CheckBox);
		ligne6.add(multiLoot5Label);
		center.add(ligne6);
		
		JPanel ligne7 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		validerMultiLootChoice = new JButton("Valider"); 
		ligne7.add(validerMultiLootChoice);
		center.add(ligne7);
		
		this.add(center, BorderLayout.CENTER);
		
		southPanel.setPreferredSize(new Dimension(0,70));
		this.add(southPanel, BorderLayout.SOUTH);
	}
	
	public void setEquipmentChange() {
		this.setLayout(new BorderLayout());
		
		northPanel.setPreferredSize(new Dimension(0,140));
		this.add(northPanel, BorderLayout.NORTH);
		
		center.setLayout(new GridLayout(2,1));
		
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
		
		center.add(ligne1);
		center.add(ligne2);
		
		this.add(center, BorderLayout.CENTER);
		
		southPanel.setPreferredSize(new Dimension(0,140));
		this.add(southPanel, BorderLayout.SOUTH);
	}
	
	public void setEquipmentSwitch() {
		this.setLayout(new BorderLayout());
		
		northPanel.setPreferredSize(new Dimension(0,140));
		this.add(northPanel, BorderLayout.NORTH);
		
		center.setLayout(new GridLayout(2,1));
		
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
		
		center.add(ligne1);
		center.add(ligne2);
		
		this.add(center, BorderLayout.CENTER);
		
		southPanel.setPreferredSize(new Dimension(0,140));
		this.add(southPanel, BorderLayout.SOUTH);
	}
	
	public void setEquipmentDrop() {
		this.setLayout(new BorderLayout());
		
		northPanel.setPreferredSize(new Dimension(0,140));
		this.add(northPanel, BorderLayout.NORTH);
		
		center.setLayout(new GridLayout(2,1));
		
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
		
		center.add(ligne1);
		center.add(ligne2);
		
		this.add(center, BorderLayout.CENTER);
		
		southPanel.setPreferredSize(new Dimension(0,140));
		this.add(southPanel, BorderLayout.SOUTH);
	}
	
	public void setChoiceEquipmentChange() {
		this.setLayout(new BorderLayout());
		
		northPanel.setPreferredSize(new Dimension(0,160));
		this.add(northPanel, BorderLayout.NORTH);
		
		center.setLayout(new GridLayout(2,1));
		
		JPanel ligne1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel equipmentChoiceExchangeLabel = new JLabel("Quel équipement souhaitez vous abandonner ?");
		ligne1.add(equipmentChoiceExchangeLabel);
		
		JPanel ligne2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		listeEquipementJetable = new JComboBox<>();
		validerEquipementJetable = new JButton("Valider");
		ligne2.add(listeEquipementJetable);
		ligne2.add(validerEquipementJetable);
		
		center.add(ligne1);
		center.add(ligne2);
		
		this.add(center, BorderLayout.CENTER);
		
		southPanel.setPreferredSize(new Dimension(0,140));
		this.add(southPanel, BorderLayout.SOUTH);
	}
	
	public void setEnterPreviousNumero() {
		this.setLayout(new BorderLayout());
		
		northPanel.setPreferredSize(new Dimension(0,160));
		this.add(northPanel, BorderLayout.NORTH);
		
		center.setLayout(new GridLayout(2,1));
		
		JPanel ligne1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel previousNumber = new JLabel("Veuillez indiquer le numéro indiqué dans la page précédente");
		ligne1.add(previousNumber);
		
		JPanel ligne2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		inputUserPreviousNumber = new JTextField();
		inputUserPreviousNumber.setPreferredSize(new Dimension(27,20));
		validateInputUserPreviousNumber = new JButton("Valider");
		ligne2.add(inputUserPreviousNumber);
		ligne2.add(validateInputUserPreviousNumber);
		
		center.add(ligne1);
		center.add(ligne2);
		
		this.add(center, BorderLayout.CENTER);
		
		southPanel.setPreferredSize(new Dimension(0,140));
		this.add(southPanel, BorderLayout.SOUTH);
	}
	
	public void setBuyOption() {
		this.setLayout(new BorderLayout());
		
		northPanel.setPreferredSize(new Dimension(0,160));
		this.add(northPanel, BorderLayout.NORTH);
		
		center.setLayout(new GridLayout(2,1));
		
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
		
		center.add(ligne1);
		center.add(ligne2);
		
		this.add(center, BorderLayout.CENTER);
		
		southPanel.setPreferredSize(new Dimension(0,140));
		this.add(southPanel, BorderLayout.SOUTH);
	}
	
	public void setGamble() {
		this.setLayout(new BorderLayout());
		
		northPanel.setPreferredSize(new Dimension(0,160));
		this.add(northPanel, BorderLayout.NORTH);
		
		center.setLayout(new GridLayout(2,1));
		
		JPanel ligne1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel gambleText = new JLabel("Combien de pièces d'Or souhaitez vous miser ?");
		ligne1.add(gambleText);
		
		JPanel ligne2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		gambleValue = new JSpinner();
		validateGambleValue = new JButton("Valider");
		ligne2.add(gambleValue);
		ligne2.add(validateGambleValue);
		
		center.add(ligne1);
		center.add(ligne2);
		
		this.add(center, BorderLayout.CENTER);
		
		southPanel.setPreferredSize(new Dimension(0,140));
		this.add(southPanel, BorderLayout.SOUTH);
	}
	
	public void setGambleResult() {
		this.setLayout(new BorderLayout());

		northPanel.setPreferredSize(new Dimension(0,120));
		this.add(northPanel, BorderLayout.NORTH);
		
		center.setLayout(new GridLayout(3,1));
		
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
		
		center.add(line1);
		center.add(line2);
		center.add(line3);
		
		this.add(center, BorderLayout.CENTER);

		southPanel.setPreferredSize(new Dimension(0,120));
		this.add(southPanel, BorderLayout.SOUTH);
	}
	
	public void setGameOver() {
		this.setLayout(new BorderLayout());
		
		northPanel.setPreferredSize(new Dimension(0,200));
		this.add(northPanel, BorderLayout.NORTH);
		
		center.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel gameOver = new JLabel("GAME OVER");
		gameOver.setForeground(Color.RED);
		center.add(gameOver);
		this.add(center);
		
		southPanel.setPreferredSize(new Dimension(0,120));
		this.add(southPanel, BorderLayout.SOUTH);
	}
	
	public void setVictory() {
		this.setLayout(new BorderLayout());
		
		northPanel.setPreferredSize(new Dimension(0,200));
		this.add(northPanel, BorderLayout.NORTH);
		
		center.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel victory = new JLabel("Victoire !");
		victory.setForeground(new Color(103,221,51));
		center.add(victory);
		this.add(center);
		
		southPanel.setPreferredSize(new Dimension(0,120));
		this.add(southPanel, BorderLayout.SOUTH);
	}
	
}