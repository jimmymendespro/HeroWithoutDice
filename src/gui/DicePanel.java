package gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

//import utilities.Utilitaire;

@SuppressWarnings("serial")
public class DicePanel extends JPanel {
	
	private BufferedImage image;
	private int diceType;
	
	public DicePanel(int diceType) {
		super();
		this.setPreferredSize(new Dimension(50,50));
		this.diceType = diceType;
		try {
			if(diceType == -1) this.ennemiDiceSwap(1);
			else if(diceType == 1) this.pjDiceSwap(1);
			else this.normalDiceSwap(1);
		}	
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, this);
	}
	
	public void normalDiceSwap(int num) throws IOException {
		if(num == 1) image = ImageIO.read(new File("graphics\\dice\\dice_1.png"));
		else if(num == 2) image = ImageIO.read(new File("graphics\\dice\\dice_2.png"));
		else if(num == 3) image = ImageIO.read(new File("graphics\\dice\\dice_3.png"));
		else if(num == 4) image = ImageIO.read(new File("graphics\\dice\\dice_4.png"));
		else if(num == 5) image = ImageIO.read(new File("graphics\\dice\\dice_5.png"));
		else image = ImageIO.read(new File("graphics\\dice\\dice_6.png"));
	}
	
	public void pjDiceSwap(int num) throws IOException {
		if(num == 1) image = ImageIO.read(new File("graphics\\dice_pj\\dice_1_pj.png"));
		else if(num == 2) image = ImageIO.read(new File("graphics\\dice_pj\\dice_2_pj.png"));
		else if(num == 3) image = ImageIO.read(new File("graphics\\dice_pj\\dice_3_pj.png"));
		else if(num == 4) image = ImageIO.read(new File("graphics\\dice_pj\\dice_4_pj.png"));
		else if(num == 5) image = ImageIO.read(new File("graphics\\dice_pj\\dice_5_pj.png"));
		else image = ImageIO.read(new File("graphics\\dice_pj\\dice_6_pj.png"));
	}
	
	public void ennemiDiceSwap(int num) throws IOException {
		if(num == 1) image = ImageIO.read(new File("graphics\\dice_ennemi\\dice_1_ennemi.png"));
		else if(num == 2) image = ImageIO.read(new File("graphics\\dice_ennemi\\dice_2_ennemi.png"));
		else if(num == 3) image = ImageIO.read(new File("graphics\\dice_ennemi\\dice_3_ennemi.png"));
		else if(num == 4) image = ImageIO.read(new File("graphics\\dice_ennemi\\dice_4_ennemi.png"));
		else if(num == 5) image = ImageIO.read(new File("graphics\\dice_ennemi\\dice_5_ennemi.png"));
		else image = ImageIO.read(new File("graphics\\dice_ennemi\\dice_6_ennemi.png"));
	}
	
	public void rollTheDice(int finalNumber) {
		/*int count = 0;
		int test = 0;*/
		while(true) {
			/*count++;
			test = Utilitaire.lancerSix();*/
			try {
				//if(count == 10) {*/
					if(diceType == -1) this.ennemiDiceSwap(finalNumber);
					else if(diceType == 1) this.pjDiceSwap(finalNumber);
					else this.normalDiceSwap(finalNumber);
					break;
				/*}
				if(diceType == -1) this.ennemiDiceSwap(test);
				else if(diceType == 1) this.pjDiceSwap(test);
				else this.normalDiceSwap(test);*/
			}
			catch(Exception e) {
				e.printStackTrace();
			}/*
			this.repaint();
			try {
				Thread.sleep(80);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}*/
		}
		this.repaint();
	}

}
