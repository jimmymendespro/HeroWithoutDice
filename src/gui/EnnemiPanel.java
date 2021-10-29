package gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class EnnemiPanel extends JPanel {
	
	private JLabel ennemiName;
	private JLabel ennemiSkill;
	private JLabel ennemiStamina;
	private JButton escape;

	public EnnemiPanel() {
		super();
		this.setLayout(new GridLayout(2,1));
		this.setPreferredSize(new Dimension(0,80));
		this.setBorder(BorderFactory.createTitledBorder("Ennemi"));
		
		JPanel ennemiLine1 = new JPanel(new GridLayout(1,2));
		ennemiName = new JLabel();
		ennemiLine1.add(ennemiName);
		
		JPanel escapePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		escape = new JButton("Fuite");
		escape.setPreferredSize(new Dimension(100,20));
		escapePanel.add(escape);
		ennemiLine1.add(escapePanel);
		
		JPanel ennemiLine2 = new JPanel(new GridLayout(1,2));
		ennemiSkill = new JLabel();
		ennemiLine2.add(ennemiSkill);
		ennemiStamina = new JLabel();
		ennemiLine2.add(ennemiStamina);
		
		this.add(ennemiLine1);
		this.add(ennemiLine2);
	}
	
	// Getters -------------------------------------------------------------------------------------------------------------------------------------------
	
	public JLabel getEnnemiName() {
		return this.ennemiName;
	}
	public JLabel getEnnemiSkill() {
		return this.ennemiSkill;
	}
	public JLabel getEnnemiStamina() {
		return this.ennemiStamina;
	}
	public JButton getEscape() {
		return this.escape;
	}
	
}