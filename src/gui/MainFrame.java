package gui;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 * Fenêtre principale de HeroWithoutDice.
 * <p>Regroupe l'ensemble des panels et les met en place.<br/>
 * L'ensemble est architecturé comme suis :<br/> 
 * <ul><li>MenuPanel qui laisse le choix au joueur de créer une nouvelle partie, d'en charger une ou de quitter l'utilitaire.</li>
 * <ul><li>NewCharacterPanel qui permet au joueur de créer une nouvelle partie en créant son personnage.</li>
 * <li>Untitled qui permet au joueur de charger une partie.</li></ul>
 * <li>Ensuite on a un ensemble de panels qui consitue le GUI principal de l'utilitaire.</li>
 * <ul><li>HeroPanel regroupe l'ensemble des caractéristiques du pj.</li>
 * <li>CurrentNumberPanel indique le numéro de salle actuelle ou le pj se trouve.</li>
 * <li>InteractionPanel est la partie d'interaction principale avec le joueur.</li>
 * <ul>Lorsqu'un combat se lance, InteractionPanel rassemble deux autres panels :
 * <li>EnnemiPanel regroupe l'ensemble des caractéristiques d'un ennemi à affronter.</li>
 * <li>FightPanel est la partie intéractive du combat contre un ennemi.</li></ul>
 * <li>NextNumberPanel indique les prochains numéro de salle où il va pouvoir se déplacer.</li>
 * @author Jimmy Mendes
 */
@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	
	// Panel
	private JPanel mainPanel;
	
	private MenuPanel menu;
	private NewCharacterPanel newCharacter;
	
	private HeroPanel heroPanel;
	private CurrentNumberPanel currentNumberPanel;
	private InteractionPanel interactionPanel;
	private EnnemiPanel ennemiPanel;
	private FightPanel fightPanel;
	private NextNumberPanel nextNumberPanel;
	
	// Component
	private JButton start;
	
	public MainFrame() {
		super();
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			SwingUtilities.updateComponentTreeUI(this);
		}
		catch(Exception e) {
			System.out.println("LookAndFeelErrorMainFrame");
		}
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Hero without Dice");
		this.setSize(500,800);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	// Getters ---------------------------------------------------------------------------------------------------------------------------------
	
	public JPanel getMainPanel() {
		return this.mainPanel;
	}
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
	public InteractionPanel getInteractionPanel() {
		return this.interactionPanel;
	}
	public EnnemiPanel getEnnemiPanel() {
		return this.ennemiPanel;
	}
	public FightPanel getFightPanel() {
		return this.fightPanel;
	}
	public NextNumberPanel getNextNumberPanel() {
		return this.nextNumberPanel;
	}
	public JButton getStartButton() {
		return this.start;
	}
	
	// Méthodes ---------------------------------------------------------------------------------------------------------------------------------------------------
	
	public void start() {
		heroPanel = new HeroPanel();
		currentNumberPanel = new CurrentNumberPanel();
		
		interactionPanel = new InteractionPanel();
		
		fightPanel = new FightPanel();
		ennemiPanel = new EnnemiPanel();
		
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
		interactionPanel.getCenter().removeAll();
	}
	
	public void fightPanelRemoveAll() {
		fightPanel.removeAll();
		fightPanel.getCenter().removeAll();
	}
	
	public void setFight() {
		interactionPanel.setLayout(new BorderLayout());
		interactionPanel.add(ennemiPanel, BorderLayout.NORTH);
		fightPanel.setFight();
		interactionPanel.add(fightPanel, BorderLayout.CENTER);
	}

}