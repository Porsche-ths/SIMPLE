package chara.base;

import java.util.ArrayList;

import Skill.Skill;

public class Enemy extends Chara {

	public Enemy(String name, int maxHp, int accMod, int dodge, int crit, int prot, int minDmg, int maxDmg, int spd,
			 int stunResist, int bleedResist, int decayResist,
			int debuffResist) {
		super(name, maxHp, accMod, dodge, crit, prot, minDmg, maxDmg, spd,  stunResist, bleedResist,
				decayResist, debuffResist);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void beginTurn() {
		// TODO Auto-generated method stub
		
	}

}