package controller;

import data.Hero;
import gui.HeroPanel;

public class HeroPanelController {
	
	private HeroPanel heroPanel;
	private Hero pj;
	
	public HeroPanelController(HeroPanel heroPanel, Hero pj) {
		this.heroPanel = heroPanel;
		this.pj = pj;
	}
	
	// Methods -------------------------------------------------------------------------------------------------------------------------------------------
	
	public void setHero() {
		heroPanel.getHeroName().setText(pj.getName());
		majHero();
	}
	
	public void majHero() {
		heroPanel.getHeroSkill().setText("Habileté : "+pj.getSkill());
		heroPanel.getHeroStamina().setText("Endurance : "+pj.getStamina());
		heroPanel.getHeroLuck().setText("Chance : "+pj.getLuck());
		heroPanel.getHeroGold().setText("Or : "+pj.getGold());
		heroPanel.getHeroProvisions().setText("Provisions : "+pj.getProvision());
		String equipmentString = "";
		for(int i = 0 ; i < pj.getEquipment().size() ; i++) {
			if(i != pj.getEquipment().size()-1) equipmentString += pj.getEquipment().get(i)+"\n";
			else equipmentString += pj.getEquipment().get(i);
		}
		heroPanel.getHeroEquipment().setText(equipmentString);
		String treasureString = "";
		for(int i = 0 ; i < pj.getTreasure().size() ; i++) {
			if(i != pj.getTreasure().size()-1) treasureString += pj.getTreasure().get(i)+"\n";
			else treasureString += pj.getTreasure().get(i);
		}
		heroPanel.getHeroTreasure().setText(treasureString);
	}

}
