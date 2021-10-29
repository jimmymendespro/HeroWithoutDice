package gui;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class NextNumberPanel extends JPanel {
	
	private JButton nextNumber1;
	private JButton nextNumber2;
	private JButton nextNumber3;
	private JButton nextNumber4;
	private JButton nextNumber5;
	private JButton nextAction;

	public NextNumberPanel() {
		super();
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.setBorder(BorderFactory.createTitledBorder("Numéro(s) Suivant(s)"));
		this.setPreferredSize(new Dimension(0,60));
		nextNumber1 = new JButton();
		nextNumber2 = new JButton();
		nextNumber3 = new JButton();
		nextNumber4 = new JButton();
		nextNumber5 = new JButton();
		nextAction = new JButton("Suite");
	}
	
	// Getters -------------------------------------------------------------------------------------------------------------------------------------------
	
	public JButton getNextNumber1() {
		return this.nextNumber1;
	}
	public JButton getNextNumber2() {
		return this.nextNumber2;
	}
	public JButton getNextNumber3() {
		return this.nextNumber3;
	}
	public JButton getNextNumber4() {
		return this.nextNumber4;
	}
	public JButton getNextNumber5() {
		return this.nextNumber5;
	}
	public JButton getNextAction() {
		return this.nextAction;
	}
	
	// Methods -------------------------------------------------------------------------------------------------------------------------------------------
	
	public void setNextButton(int nombreBouttons) {
		this.removeAll();
		switch(nombreBouttons) {
		case -1:
			this.add(nextAction);
			break;
		case 0:
			//this.add(noBouttonPanel);
			break;
		case 1:
			this.add(nextNumber1);
			break;
		case 2:
			this.add(nextNumber1);
			this.add(nextNumber2);
			break;
		case 3:
			this.add(nextNumber1);
			this.add(nextNumber2);
			this.add(nextNumber3);
			break;
		case 4:
			this.add(nextNumber1);
			this.add(nextNumber2);
			this.add(nextNumber3);
			this.add(nextNumber4);
			break;
		case 5:
			this.add(nextNumber1);
			this.add(nextNumber2);
			this.add(nextNumber3);
			this.add(nextNumber4);
			this.add(nextNumber5);
			break;
		default:
			System.out.println("ERROR Next Number Panel setNextButton()");
			break;
		}
		this.revalidate();
		this.repaint();
	}
	
}