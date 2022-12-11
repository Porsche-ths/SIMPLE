package chara.base;

import java.util.ArrayList;

import logic.GameLogic;
import skill.base.BaseSkill;

public class Enemy extends Chara {
	private String className;
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

	@Override
	public void checkStatus() {
		if (isAlive()) {
			if (getHp() == 0) {
				setAlive(false);
				super.setHp(10);
			}
		} else {
			if (getHp() == 0) {
				GameLogic.enemies.remove(this);
				if (GameLogic.enemies.isEmpty()) GameLogic.setStageCleared(true);
			}
		}
	}
	
	@Override
	public void setHp(int hp) {
		super.setHp(hp);
		checkStatus();
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
	

}
