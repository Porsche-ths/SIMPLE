package chara.enemy;

import chara.base.Enemy;

public class SkellySoldier extends Enemy {

	public SkellySoldier(String name, int maxHp, int accMod, int dodge, int crit, int prot, int minDmg, int maxDmg,
			int spd, int stunResist, int bleedResist, int decayResist, int debuffResist) {
		//super(name, maxHp, accMod, dodge, crit, prot, minDmg, maxDmg, spd, stunResist, bleedResist, decayResist, debuffResist);
		super("Skelly Soldier", 12, accMod, dodge, crit, prot, minDmg, maxDmg, spd, stunResist, 300, decayResist, debuffResist);
	}
	
	@Override
	public void beginTurn() {
		atTurnStart();
		
		atTurnEnd();
	}

}
