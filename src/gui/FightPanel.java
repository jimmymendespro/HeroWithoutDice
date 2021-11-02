package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class FightPanel extends JPanel {
	
	//Panels
	private JPanel north;
	private JPanel center;
	private JPanel south;
	
	//Components
	//Fight
	private JTextField inputFightValue;
	private JButton validateInputFight; 
	private JButton fightRandom;
	//MultipleFight
	private JButton nextEnnemiButton;
	//FightResult
	private JLabel assaultResult;
	private JButton yesTryYourLuck;
	private JButton noTryYourLuck;
	private JButton nextAssaultDraw;
	//TryYourLuck
	private JTextField inputTryYourLuckValue;
	private JButton validateInputTryYourLuck;
	private JButton tryYourLuckRandom;
	private JButton nextAssaultTryYourLuck;
	//TryYourLuckResult
	private JLabel tryYourLuckResult;
	//Escape
	private JButton yesTryYourLuckEscape;
	private JButton noTryYourLuckEscape;
	//Shield
	private JTextField inputShieldValue;
	private JButton validateInputShield;
	private JButton shieldRandom;
	//ShieldResult
	private JLabel shieldResult;
	//Special
	private JButton yesMealAfterFight;
	private JButton noMealAfterFight;

	public FightPanel() {
		super();
		//Panels
		north = new JPanel();
		center = new JPanel();
		south = new JPanel();
		//Components
		//Fight
		inputFightValue = new JTextField();
		inputFightValue.setPreferredSize(new Dimension(20,20));
		validateInputFight = new JButton("Valider");
		fightRandom = new JButton("Aléatoire");
		//MultipleFight
		nextEnnemiButton = new JButton("Ennemi suivant"); 
		//FightResult
		assaultResult = new JLabel();
		yesTryYourLuck = new JButton("Oui");
		noTryYourLuck = new JButton("Non");
		nextAssaultDraw = new JButton("Assaut suivant");
		//TryYourLuck
		inputTryYourLuckValue = new JTextField();
		inputTryYourLuckValue.setPreferredSize(new Dimension(20,20));
		validateInputTryYourLuck = new JButton("Valider");
		tryYourLuckRandom = new JButton("Aléatoire");
		nextAssaultTryYourLuck  = new JButton("Assaut suivant");
		//TryYourLuckResult
		tryYourLuckResult  = new JLabel();
		//Escape
		yesTryYourLuckEscape = new JButton("Oui");
		noTryYourLuckEscape = new JButton("Non");
		//Shield
		inputShieldValue = new JTextField();
		validateInputShield = new JButton("Valider");
		shieldRandom = new JButton("Aléatoire");
		//ShieldResult
		shieldResult = new JLabel();
		//Special
		yesMealAfterFight = new JButton("Oui");
		noMealAfterFight = new JButton("Non");
	}
	
	// Getters -------------------------------------------------------------------------------------------------------------------------------------------
	public JPanel getCenter() {
		return this.center;
	}
	//Fight
	public JTextField inputFightValue() {
		return this.inputFightValue;
	}
	public JButton validateInputValue() {
		return this.validateInputFight;
	}
	public JButton getFightRandom() {
		return this.fightRandom;
	}
	//MultipleFight
	public JButton getNextEnnemiButton() {
		return this.nextEnnemiButton;
	}
	//FightResult
	public JLabel getAssaultResult() {
		return this.assaultResult;
	}
	public JButton getYesTryYourLuck() {
		return this.yesTryYourLuck;
	}
	public JButton getNoTryYourLuck() {
		return this.noTryYourLuck;
	}
	public JButton getNextAssaultDraw() {
		return this.nextAssaultDraw;
	}
	//TryYourLuck
	public JTextField getInputTryYourLuckValue() {
		return this.inputTryYourLuckValue;
	}
	public JButton getValidateInputTryYourLuck() {
		return this.validateInputTryYourLuck;
	}
	public JButton getTryYourLuckRandom() {
		return this.tryYourLuckRandom;
	}
	public JButton getNextAssaultTryYourLuck() {
		return this.nextAssaultTryYourLuck;
	}
	//TryYourLuckResult
	public JLabel getTryYourLuckResult() {
		return this.tryYourLuckResult;
	}
	//Escape
	public JButton getYesTryYourLuckEscape() {
		return this.yesTryYourLuckEscape;
	}
	public JButton getNoTryYourLuckEscape() {
		return this.noTryYourLuckEscape;
	}
	//Shield
	public JTextField getInputShieldValue() {
		return this.inputShieldValue;
	}
	public JButton getValidateInputShield() {
		return this.validateInputShield;
	}
	public JButton getShieldRandom() {
		return this.shieldRandom;
	}
	//ShieldResult
	public JLabel getShieldResult() {
		return this.shieldResult;
	}
	//Special
	public JButton getYesMealAfterFight() {
		return this.yesMealAfterFight;
	}
	public JButton getNoMealAfterFight() {
		return this.noMealAfterFight;
	}
	
	// Methods -------------------------------------------------------------------------------------------------------------------------------------------
	
	public void setFight() {
		this.setLayout(new BorderLayout());
		
		north.setPreferredSize(new Dimension(0,90));
		this.add(north, BorderLayout.NORTH);

		center.setLayout(new GridLayout(4,1));
		
		JPanel line1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel fightText = new JLabel("Combattez !");
		line1.add(fightText);
		center.add(line1);
		
		JPanel line2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		line2.add(inputFightValue);
		line2.add(validateInputFight);
		center.add(line2);
		
		JPanel line3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel orText = new JLabel("ou");
		line3.add(orText);
		center.add(line3);
		
		JPanel ligne4 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		ligne4.add(fightRandom);
		center.add(ligne4);
		
		this.add(center, BorderLayout.CENTER);
		
		south.setPreferredSize(new Dimension(0,90));
		this.add(south, BorderLayout.SOUTH);
	}
	
	/*public void majFight() {
		// identique à setFight()
	}*/
	
	public void setNextFight() {
		north.setPreferredSize(new Dimension(0,120));
		this.add(north, BorderLayout.NORTH);
		
		center.setLayout(new GridLayout(3,1));
		
		JPanel ligne1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel ennemiVaincu = new JLabel("Ennemi vaincu !");
		ennemiVaincu.setForeground(new Color(103,221,51));
		ligne1.add(ennemiVaincu);
		center.add(ligne1);
		
		JPanel ligne2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		ligne2.add(nextEnnemiButton);
		center.add(ligne2);
		
		this.add(center, BorderLayout.CENTER);
		
		south.setPreferredSize(new Dimension(0,80));
		this.add(south, BorderLayout.SOUTH);
	}
	
	public void setFightAleatoire() {
		north.setPreferredSize(new Dimension(0,100));
		this.add(north, BorderLayout.NORTH);
	
		center.setLayout(new GridLayout(3,1));
		
		JPanel ligne1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		ligne1.add(assaultResult);
		center.add(ligne1);
		
		JPanel ligne2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel tryYourLuck = new JLabel("Tentez votre chance ?");
		ligne2.add(tryYourLuck);
		center.add(ligne2);
		
		JPanel ligne3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		ligne3.add(yesTryYourLuck);
		ligne3.add(noTryYourLuck);
		center.add(ligne3);
		
		this.add(center, BorderLayout.CENTER);
		
		south.setPreferredSize(new Dimension(0,100));
		this.add(south, BorderLayout.SOUTH);
	}
	
	public void setFightAleatoireEgalite() {
		north.setPreferredSize(new Dimension(0,120));
		this.add(north, BorderLayout.NORTH);
		
		center.setLayout(new GridLayout(2,1));
		
		JPanel ligne1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		ligne1.add(assaultResult);
		center.add(ligne1);
		
		JPanel ligne2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		ligne2.add(nextAssaultDraw);
		center.add(ligne2);
		
		this.add(center, BorderLayout.CENTER);
		
		south.setPreferredSize(new Dimension(0,100));
		this.add(south, BorderLayout.SOUTH);
	}
	
	public void setTenterChanceFight() {
		north.setPreferredSize(new Dimension(0,90));
		this.add(north, BorderLayout.NORTH);
		
		center.setLayout(new GridLayout(4,1));
		
		JPanel ligne1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel tryYourLuckText = new JLabel("Tenter votre chance :");
		ligne1.add(tryYourLuckText);
		center.add(ligne1);
		
		JPanel ligne2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		ligne2.add(inputTryYourLuckValue);
		ligne2.add(validateInputTryYourLuck);
		center.add(ligne2);
		
		JPanel ligne3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel tryYourLuckOrText = new JLabel("ou");
		ligne3.add(tryYourLuckOrText);
		center.add(ligne3);
		
		JPanel ligne4 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		tryYourLuckRandom = new JButton("Aléatoire");
		ligne4.add(tryYourLuckRandom);
		center.add(ligne4);
		
		this.add(center, BorderLayout.CENTER);
		
		south.setPreferredSize(new Dimension(0,90));
		this.add(south, BorderLayout.SOUTH);
	}
	
	public void setResultatChanceFight() {
		north.setPreferredSize(new Dimension(0,120));
		this.add(north, BorderLayout.NORTH);
		
		center.setLayout(new GridLayout(2,1));
		
		JPanel ligne1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		tryYourLuckResult = new JLabel();
		ligne1.add(tryYourLuckResult);
		center.add(ligne1);
		
		JPanel ligne2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		nextAssaultTryYourLuck = new JButton("Assaut suivant");
		ligne2.add(nextAssaultTryYourLuck);
		center.add(ligne2);
		
		this.add(center, BorderLayout.CENTER);
		
		south.setPreferredSize(new Dimension(0,100));
		this.add(south, BorderLayout.SOUTH);
	}
	
	public void setChoiceFuite() {
		north.setPreferredSize(new Dimension(0,100));
		this.add(north, BorderLayout.NORTH);
		
		center.setLayout(new GridLayout(3,1));
		
		JPanel ligne1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel escapeText = new JLabel("Vous recevez une blessure.");
		escapeText.setForeground(Color.RED);
		ligne1.add(escapeText);
		center.add(ligne1);
		
		JPanel ligne2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel escapeOrText = new JLabel("Tentez votre chance ?");
		ligne2.add(escapeOrText);
		center.add(ligne2);
		
		JPanel ligne3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		yesTryYourLuckEscape = new JButton("Oui");
		ligne3.add(yesTryYourLuckEscape);
		noTryYourLuckEscape = new JButton("Non");
		ligne3.add(noTryYourLuckEscape);
		center.add(ligne3);
		
		this.add(center, BorderLayout.CENTER);
		
		south.setPreferredSize(new Dimension(0,100));
		this.add(south, BorderLayout.SOUTH);
	}
	
	public void setFightWin() {
		north.setPreferredSize(new Dimension(0,120));
		this.add(north, BorderLayout.NORTH);
		
		center.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel winFight = new JLabel("Combat gagné !");
		winFight.setForeground(new Color(103,221,51));
		center.add(winFight);
		this.add(center, BorderLayout.CENTER);
		
		south.setPreferredSize(new Dimension(0,120));
		this.add(south, BorderLayout.SOUTH);
	}
	
	public void setFightMealWin() {
		north.setPreferredSize(new Dimension(0,120));
		this.add(north, BorderLayout.NORTH);
		
		center.setLayout(new GridLayout(4,1));
		
		JPanel ligne1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel winFight = new JLabel("Combat gagné !");
		winFight.setForeground(new Color(103,221,51));
		ligne1.add(winFight);
		
		JPanel ligne2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel repas = new JLabel("Désirez vous prendre un repas ?");
		ligne2.add(repas);
		
		JPanel ligne3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		yesMealAfterFight = new JButton("Oui");
		noMealAfterFight = new JButton("Non");
		ligne3.add(yesMealAfterFight);
		ligne3.add(noMealAfterFight);
		
		center.add(ligne1);
		center.add(ligne2);
		center.add(ligne3);
		
		this.add(center, BorderLayout.CENTER);
		
		south.setPreferredSize(new Dimension(0,80));
		this.add(south, BorderLayout.SOUTH);
	}
	
	public void setFightGameOver() {
		north.setPreferredSize(new Dimension(0,120));
		this.add(north, BorderLayout.NORTH);

		JPanel gameOverPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel gameOver = new JLabel("GAME OVER");
		gameOver.setForeground(Color.RED);
		gameOverPanel.add(gameOver);
		center.add(gameOverPanel);
		this.add(center, BorderLayout.CENTER);
		
		south.setPreferredSize(new Dimension(0,120));
		this.add(south, BorderLayout.SOUTH);
	}
	
	public void setFightShield() {
		north.setPreferredSize(new Dimension(0,70));
		this.add(north, BorderLayout.NORTH);
	
		center.setLayout(new GridLayout(5,1));
		
		JPanel ligne1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel shieldExplanationText = new JLabel("Assaut perdu...");
		shieldExplanationText.setForeground(Color.RED);
		ligne1.add(shieldExplanationText);
		center.add(ligne1);
		
		JPanel ligne2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel shieldExplanationText2 = new JLabel("Utilisez votre bouclier !");
		ligne2.add(shieldExplanationText2);
		center.add(ligne2);
		
		JPanel ligne3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		inputShieldValue = new JTextField();
		inputShieldValue.setPreferredSize(new Dimension(20,20));
		validateInputShield = new JButton("Valider");
		ligne3.add(inputShieldValue);
		ligne3.add(validateInputShield);
		center.add(ligne3);
		
		JPanel ligne4 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel fightShieldOr = new JLabel("ou");
		ligne4.add(fightShieldOr);
		center.add(ligne4);
		
		JPanel ligne5 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		shieldRandom = new JButton("Aléatoire");
		ligne5.add(shieldRandom);
		center.add(ligne5);
		
		this.add(center, BorderLayout.CENTER);
		
		south.setPreferredSize(new Dimension(0,70));
		this.add(south, BorderLayout.SOUTH);
	}
	
	public void setResultFightShield() {
		north.setPreferredSize(new Dimension(0,80));
		this.add(north, BorderLayout.NORTH);
	
		center.setLayout(new GridLayout(5,1));
		
		JPanel ligne1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		shieldResult = new JLabel();
		ligne1.add(shieldResult);
		center.add(ligne1);
		
		JPanel ligne2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel tryYourLuckAfterShield = new JLabel("Tentez votre chance ?");
		ligne2.add(tryYourLuckAfterShield);
		center.add(ligne2);
		
		JPanel ligne3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		yesTryYourLuck.setActionCommand("oui");
		ligne3.add(yesTryYourLuck);
		noTryYourLuck.setActionCommand("non");
		ligne3.add(noTryYourLuck);
		center.add(ligne3);
		
		this.add(center, BorderLayout.CENTER);
		
		south.setPreferredSize(new Dimension(0,80));
		this.add(south, BorderLayout.SOUTH);
	}
	
	public void setEscapeTryYourLuckRandom() {
		north.setPreferredSize(new Dimension(0,160));
		this.add(north, BorderLayout.NORTH);
		
		center.setLayout(new FlowLayout(FlowLayout.CENTER));
		tryYourLuckResult = new JLabel();
		center.add(tryYourLuckResult);
		this.add(center, BorderLayout.CENTER);
		
		south.setPreferredSize(new Dimension(0,100));
		this.add(south, BorderLayout.SOUTH);
	}
	
}