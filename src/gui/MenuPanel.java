package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MenuPanel extends JPanel {
	
	private JButton newGame;
	private JButton loadGame;
	private JButton exitGame;
	
	public MenuPanel() {
		super();
		this.setLayout(new BorderLayout());
		JPanel northMainPanel = new JPanel();
		northMainPanel.setPreferredSize(new Dimension(0,120));
		this.add(northMainPanel, BorderLayout.NORTH);
		
		JPanel centerMainPanel = new JPanel(new GridLayout(3,1,0,100));

		newGame = new JButton("Nouvelle Partie");
		loadGame = new JButton("Charger Partie");
		exitGame = new JButton("Quitter");

		centerMainPanel.add(newGame);
		centerMainPanel.add(loadGame);
		centerMainPanel.add(exitGame);
		this.add(centerMainPanel, BorderLayout.CENTER);
		
		JPanel westMainPanel = new JPanel();
		westMainPanel.setPreferredSize(new Dimension(60,0));
		this.add(westMainPanel, BorderLayout.WEST);
		
		JPanel eastMainPanel = new JPanel();
		eastMainPanel.setPreferredSize(new Dimension(60,0));
		this.add(eastMainPanel, BorderLayout.EAST);
		
		JPanel southMainPanel = new JPanel();
		southMainPanel.setPreferredSize(new Dimension(0,120));
		this.add(southMainPanel, BorderLayout.SOUTH);
	}
	
	// Getters -------------------------------------------------------------------------------------------------------------------------------------------

	public JButton getNewGame() {
		return this.newGame;
	}
	public JButton getLoadGame() {
		return this.loadGame;
	}
	public JButton getExitGame() {
		return this.exitGame;
	}
}
