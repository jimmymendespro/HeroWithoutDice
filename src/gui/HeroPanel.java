package gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class HeroPanel extends JPanel {
	
	private JLabel heroName;
	private JButton save;
	private JLabel heroSkill;
	private JLabel heroStamina;
	private JLabel heroLuck;
	private JLabel heroGold;
	private JLabel heroProvisions;
	private JTextArea heroEquipment;	
	private JTextArea heroTreasure;

	public HeroPanel() {
		super();
		this.setLayout(new GridBagLayout());
		this.setBorder(BorderFactory.createTitledBorder("Feuille d'Aventure"));
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.BOTH;
		constraints.insets = new Insets(1, 0, 1, 0);
		constraints.weightx = 3;
		constraints.weighty = 9;
		
		heroName = new JLabel("Nom");
		save = new JButton("Sauvegarde");
		constraints.gridx = 0;
		constraints.gridy = 0;
		this.add(heroName,constraints);
		constraints.gridx = 2;
		this.add(save,constraints);
		
		constraints.insets = new Insets(4, 0, 4, 0);
		heroSkill = new JLabel("Habileté : ");
		heroStamina = new JLabel("Endurance : ");
		heroLuck = new JLabel("Chance : ");
		constraints.gridx = 0;
		constraints.gridy = 1;
		this.add(heroSkill,constraints);
		constraints.gridx = 1;
		this.add(heroStamina,constraints);
		constraints.gridx = 2;
		this.add(heroLuck,constraints);
		
		heroGold = new JLabel("Or : ");
		heroProvisions = new JLabel("Provisions : ");
		constraints.gridx = 0;
		constraints.gridy = 2;
		this.add(heroGold,constraints);
		constraints.gridx = 1;
		this.add(heroProvisions,constraints);
		
		JLabel equipementHeroLabel = new JLabel("Équipement :");
		JButton potionHero = new JButton("Utiliser Potion");
		constraints.gridx = 0;
		constraints.gridy = 3;
		this.add(equipementHeroLabel,constraints);
		constraints.gridx = 2;
		this.add(potionHero,constraints);
		
		heroEquipment = new JTextArea();
		heroEquipment.setEditable(false);
		JScrollPane scrollpane = new JScrollPane(heroEquipment);
		scrollpane.setPreferredSize(new Dimension(0,60));
		constraints.gridx = 0;
		constraints.gridy = 4;
		constraints.gridwidth = 3;
		constraints.gridheight = 2;
		this.add(scrollpane,constraints);
		
		JLabel tresorHeroLabel = new JLabel("Trésors :");
		constraints.gridx = 0;
		constraints.gridy = 6;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		this.add(tresorHeroLabel,constraints);
		
		heroTreasure = new JTextArea();
		heroTreasure.setEditable(false);
		JScrollPane scrollpaneTresor = new JScrollPane(heroTreasure);
		scrollpaneTresor.setPreferredSize(new Dimension(0,60));
		constraints.gridy = 7;
		constraints.gridwidth = 3;
		constraints.gridheight = 2;
		this.add(scrollpaneTresor,constraints);
	}
	
	// Getters -------------------------------------------------------------------------------------------------------------------------------------------
	
	public JLabel getHeroName() {
		return this.heroName;
	}
	public JButton getSave() {
		return this.save;
	}
	public JLabel getHeroSkill() {
		return this.heroSkill;
	}
	public JLabel getHeroStamina() {
		return this.heroStamina;
	}
	public JLabel getHeroLuck() {
		return this.heroLuck;
	}
	public JLabel getHeroGold() {
		return this.heroGold;
	}
	public JLabel getHeroProvisions() {
		return this.heroProvisions;
	}
	public JTextArea getHeroEquipment() {
		return this.heroEquipment;
	}
	public JTextArea getHeroTreasure() {
		return this.heroTreasure;
	}
}