package gui;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class CurrentNumberPanel extends JPanel {
	
	private JLabel currentNumberLabel;
	
	public CurrentNumberPanel() {
		super();
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.setBorder(BorderFactory.createTitledBorder("Numéro Actuel"));
		this.setPreferredSize(new Dimension(0,50));
		currentNumberLabel = new JLabel();
		this.add(currentNumberLabel);
	}
	
	// Getters -------------------------------------------------------------------------------------------------------------------------------------------
	
	public JLabel getCurrentNumberLabel() {
		return this.currentNumberLabel;
	}

}
