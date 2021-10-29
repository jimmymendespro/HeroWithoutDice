package gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class NewCharacterPanel extends JPanel {
	
	private JRadioButton originalHeroRadioButton;
	private JRadioButton defaultHeroRadioButton;
	private JComboBox<String> defaultHeroComboBox;
	private JTextField heroName;
	private JTextField heroSkill;
	private JButton heroSkillRandom;
	private JTextField heroStamina;
	private JButton heroStaminaRandom;
	private JTextField heroLuck;
	private JButton heroLuckRandom;
	private JRadioButton skillPotionRadioButton;
	private JRadioButton staminaPotionRadioButton;
	private JRadioButton luckPotionRadioButton;
	private JButton validateNewHero;
	private JButton exitNewHero;
	
	public NewCharacterPanel() {
		super();
		this.setLayout(new GridLayout(12,1));
		JPanel ligne1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel newHeroLabel = new JLabel("Créez votre Héros !");
		newHeroLabel.setFont(new Font(this.getFont().getFamily(), Font.PLAIN ,20));
		ligne1.add(newHeroLabel);
		
		JPanel ligne2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		originalHeroRadioButton = new JRadioButton();
		originalHeroRadioButton.setSelected(true);
		originalHeroRadioButton.setActionCommand("original");
		JLabel originalHeroLabel = new JLabel("Héros personnalisé");
		ligne2.add(originalHeroRadioButton);
		ligne2.add(originalHeroLabel);
		
		JPanel ligne3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		defaultHeroRadioButton = new JRadioButton();
		JLabel defaultHeroLabel = new JLabel("Héros préconfiguré");
		String[] defaultHeroNames = {"---", "Crowald le Nain", "Chaelza la Voleuse", "Raedhell d'Argenton"};
		defaultHeroComboBox = new JComboBox<>(defaultHeroNames);
		defaultHeroComboBox.setEnabled(false);
		ligne3.add(defaultHeroRadioButton);
		ligne3.add(defaultHeroLabel);
		ligne3.add(defaultHeroComboBox);
		
		ButtonGroup heroChoice = new ButtonGroup();
		heroChoice.add(originalHeroRadioButton);
		heroChoice.add(defaultHeroRadioButton);
		
		JPanel ligne4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel nomHero = new JLabel("Nom");
		heroName = new JTextField();
		heroName.setPreferredSize(new Dimension(120,20));
		ligne4.add(nomHero);
		ligne4.add(heroName);
		
		JPanel ligne5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel skillLabel = new JLabel("Habileté");
		JSeparator separatorLigne5 = new JSeparator();
		separatorLigne5.setPreferredSize(new Dimension(7,0));
		heroSkill = new JTextField();
		heroSkill.setPreferredSize(new Dimension(20,20));
		JLabel andLabel = new JLabel("ou");
		heroSkillRandom = new JButton("Aléatoire");
		heroSkillRandom.setActionCommand("skill");
		ligne5.add(skillLabel);
		ligne5.add(separatorLigne5);
		ligne5.add(heroSkill);
		ligne5.add(andLabel);
		ligne5.add(heroSkillRandom);
		
		JPanel ligne6 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel staminaLabel = new JLabel("Endurance");
		heroStamina = new JTextField();
		heroStamina.setPreferredSize(new Dimension(20,20));
		heroStaminaRandom = new JButton("Aléatoire");
		heroStaminaRandom.setActionCommand("stamina");
		ligne6.add(staminaLabel);
		ligne6.add(heroStamina);
		ligne6.add(andLabel);
		ligne6.add(heroStaminaRandom);
		
		JPanel ligne7 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel luckLabel = new JLabel("Chance");
		JSeparator separatorLigne7 = new JSeparator();
		separatorLigne7.setPreferredSize(new Dimension(10,0));
		heroLuck = new JTextField();
		heroLuck.setPreferredSize(new Dimension(20,20));
		heroLuckRandom = new JButton("Aléatoire");
		heroLuckRandom.setActionCommand("luck");
		ligne7.add(luckLabel);
		ligne7.add(separatorLigne7);
		ligne7.add(heroLuck);
		ligne7.add(andLabel);
		ligne7.add(heroLuckRandom);
		
		JPanel ligne8 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel magicPotion = new JLabel("Potion Magique :");
		ligne8.add(magicPotion);
		
		JPanel ligne9 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		skillPotionRadioButton = new JRadioButton();
		skillPotionRadioButton.setSelected(true);
		skillPotionRadioButton.setActionCommand("skill");
		JLabel skillPotionLabel = new JLabel("Potion d'Adresse");
		ligne9.add(skillPotionRadioButton);
		ligne9.add(skillPotionLabel);
		
		JPanel ligne10 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		staminaPotionRadioButton = new JRadioButton();
		staminaPotionRadioButton.setActionCommand("stamina");
		JLabel staminaPotionLabel = new JLabel("Potion de Vigueur");
		ligne10.add(staminaPotionRadioButton);
		ligne10.add(staminaPotionLabel);
		
		JPanel ligne11 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		luckPotionRadioButton = new JRadioButton();
		luckPotionRadioButton.setActionCommand("luck");
		JLabel luckPotionLabel = new JLabel("Potion de Bonne Fortune");
		ligne11.add(luckPotionRadioButton);
		ligne11.add(luckPotionLabel);
		
		ButtonGroup potionGroup = new ButtonGroup();
		potionGroup.add(skillPotionRadioButton);
		potionGroup.add(staminaPotionRadioButton);
		potionGroup.add(luckPotionRadioButton);
		
		JPanel ligne12 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		validateNewHero = new JButton("Valider");
		exitNewHero = new JButton("Quitter");
		ligne12.add(validateNewHero);
		ligne12.add(exitNewHero);
		
		this.add(ligne1);
		this.add(ligne2);
		this.add(ligne3);
		this.add(ligne4);
		this.add(ligne5);
		this.add(ligne6);
		this.add(ligne7);
		this.add(ligne8);
		this.add(ligne9);
		this.add(ligne10);
		this.add(ligne11);
		this.add(ligne12);
	}
	
	// Getters -------------------------------------------------------------------------------------------------------------------------------------------
	
	public JRadioButton getOriginalHeroRadioButton() {
		return this.originalHeroRadioButton;
	}
	public JRadioButton getDefaultHeroRadioButton() {
		return this.defaultHeroRadioButton;
	}
	public JComboBox<String> getDefaultHeroComboBox(){
		return this.defaultHeroComboBox;
	}
	public JTextField getHeroName() {
		return this.heroName;
	}
	public JTextField getHeroSkill() {
		return this.heroSkill;
	}
	public JButton getHeroSkillRandom() {
		return this.heroSkillRandom;
	}
	public JTextField getHeroStamina() {
		return this.heroStamina;
	}
	public JButton getHeroStaminaRandom() {
		return this.heroStaminaRandom;
	}
	public JTextField getHeroLuck() {
		return this.heroLuck;
	}
	public JButton getHeroLuckRandom() {
		return this.heroLuckRandom;
	}
	public JRadioButton getSkillPotionRadioButton() {
		return this.skillPotionRadioButton;
	}
	public JRadioButton getStaminaPotionRadioButton() {
		return this.staminaPotionRadioButton;
	}
	public JRadioButton getLuckPotionRadioButton() {
		return this.luckPotionRadioButton;
	}
	public JButton getValidateNewHero() {
		return this.validateNewHero;
	}
	public JButton getExitNewHero() {
		return this.exitNewHero;
	}
}