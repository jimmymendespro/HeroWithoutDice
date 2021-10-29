package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.NewCharacterPanel;
import utilities.Utilitaire;

/**
 * Controller utilisé pour commander le panel de création de personnage (newCharacterPanel).
 * @author Jimmy Mendes
 */
public class NewCharacterPanelController {
	
	private NewCharacterPanel newCharacterPanel;
	
	public NewCharacterPanelController(NewCharacterPanel newCharacterPanel) {
		this.newCharacterPanel = newCharacterPanel;
	}
	
	// Methods -------------------------------------------------------------------------------------------------------------------------------------------
	
	/**
	 * Ajoute les ActionListeners aux éléments du panel de création de personnages (newCharacterPanel).
	 */
	public void setNewHeroListeners() {
		newCharacterPanel.getOriginalHeroRadioButton().addActionListener(new HeroChoiceCheckBoxListener());
		newCharacterPanel.getDefaultHeroRadioButton().addActionListener(new HeroChoiceCheckBoxListener());
		newCharacterPanel.getDefaultHeroComboBox().addActionListener(new DefaultHeroChoiceComboBoxListener());
		newCharacterPanel.getHeroSkillRandom().addActionListener(new RandomNewHeroListener());
		newCharacterPanel.getHeroStaminaRandom().addActionListener(new RandomNewHeroListener());
		newCharacterPanel.getHeroLuckRandom().addActionListener(new RandomNewHeroListener());
	}
	
	// Listeners
	
	class HeroChoiceCheckBoxListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equalsIgnoreCase("original")) {
				newCharacterPanel.getDefaultHeroComboBox().setEnabled(false);
				newCharacterPanel.getHeroName().setEditable(true);
				newCharacterPanel.getHeroSkill().setEditable(true);
				newCharacterPanel.getHeroStamina().setEditable(true);
				newCharacterPanel.getHeroLuck().setEditable(true);
				newCharacterPanel.getHeroSkillRandom().setEnabled(true);
				newCharacterPanel.getHeroStaminaRandom().setEnabled(true);
				newCharacterPanel.getHeroLuckRandom().setEnabled(true);
				newCharacterPanel.getSkillPotionRadioButton().setEnabled(true);
				newCharacterPanel.getStaminaPotionRadioButton().setEnabled(true);
				newCharacterPanel.getLuckPotionRadioButton().setEnabled(true);
			}
			else {
				newCharacterPanel.getStaminaPotionRadioButton().setSelected(true);
				newCharacterPanel.getDefaultHeroComboBox().setEnabled(true);
				newCharacterPanel.getHeroName().setEditable(false);
				newCharacterPanel.getHeroSkill().setEditable(false);
				newCharacterPanel.getHeroStamina().setEditable(false);
				newCharacterPanel.getHeroLuck().setEditable(false);
				newCharacterPanel.getHeroSkillRandom().setEnabled(false);
				newCharacterPanel.getHeroStaminaRandom().setEnabled(false);
				newCharacterPanel.getHeroLuckRandom().setEnabled(false);
				newCharacterPanel.getSkillPotionRadioButton().setEnabled(false);
				newCharacterPanel.getStaminaPotionRadioButton().setEnabled(false);
				newCharacterPanel.getLuckPotionRadioButton().setEnabled(false);
			}
			newCharacterPanel.getHeroName().setText("");
			newCharacterPanel.getHeroSkill().setText("");
			newCharacterPanel.getHeroStamina().setText("");
			newCharacterPanel.getHeroLuck().setText("");
			newCharacterPanel.getSkillPotionRadioButton().setSelected(true);
		}
	}
	
	class DefaultHeroChoiceComboBoxListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if(newCharacterPanel.getDefaultHeroComboBox().getSelectedIndex() == 0) {
				newCharacterPanel.getHeroName().setText("");
				newCharacterPanel.getHeroSkill().setText("");
				newCharacterPanel.getHeroStamina().setText("");
				newCharacterPanel.getHeroLuck().setText("");
				newCharacterPanel.getSkillPotionRadioButton().setSelected(true);
			}
			else if(newCharacterPanel.getDefaultHeroComboBox().getSelectedIndex() == 1) {
				newCharacterPanel.getHeroName().setText("Crowald le Nain");
				newCharacterPanel.getHeroSkill().setText("9");
				newCharacterPanel.getHeroStamina().setText("19");
				newCharacterPanel.getHeroLuck().setText("8");
				newCharacterPanel.getStaminaPotionRadioButton().setSelected(true);
			}
			else if(newCharacterPanel.getDefaultHeroComboBox().getSelectedIndex() == 2) {
				newCharacterPanel.getHeroName().setText("Chaelza la Voleuse");
				newCharacterPanel.getHeroSkill().setText("10");
				newCharacterPanel.getHeroStamina().setText("16");
				newCharacterPanel.getHeroLuck().setText("9");
				newCharacterPanel.getStaminaPotionRadioButton().setSelected(true);
			}
			else if(newCharacterPanel.getDefaultHeroComboBox().getSelectedIndex() == 3) {
				newCharacterPanel.getHeroName().setText("Raedhell d'Argenton");
				newCharacterPanel.getHeroSkill().setText("10");
				newCharacterPanel.getHeroStamina().setText("17");
				newCharacterPanel.getHeroLuck().setText("7");
				newCharacterPanel.getLuckPotionRadioButton().setSelected(true);
			}
		}
	}
	
	class RandomNewHeroListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equalsIgnoreCase("skill")) {
				int skillDice = Utilitaire.lancerSix();
				newCharacterPanel.getHeroSkill().setText(""+(skillDice+6));
				newCharacterPanel.getHeroSkill().setEditable(false);
				newCharacterPanel.getHeroSkillRandom().setEnabled(false);
			}
			else if(e.getActionCommand().equalsIgnoreCase("stamina")) {
				int staminaDices = Utilitaire.doubleLancerSix();
				newCharacterPanel.getHeroStamina().setText(""+(staminaDices+12));
				newCharacterPanel.getHeroStamina().setEditable(false);
				newCharacterPanel.getHeroStaminaRandom().setEnabled(false);
			}
			else if(e.getActionCommand().equalsIgnoreCase("luck")) {
				int luckDice = Utilitaire.lancerSix();
				newCharacterPanel.getHeroLuck().setText(""+(luckDice+6));
				newCharacterPanel.getHeroLuck().setEditable(false);
				newCharacterPanel.getHeroLuckRandom().setEnabled(false);
			}
		}
	}
	
}