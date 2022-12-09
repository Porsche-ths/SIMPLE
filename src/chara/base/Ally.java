package chara.base;

import java.util.ArrayList;

import item.base.Equipable;
import logic.GameLogic;
import skill.base.BaseSkill;

public class Ally extends Chara{
	private ArrayList<Equipable> equipmentSlots;
	private int deathBlowResist;
	private String className;
	private int targetPriority;
	public Ally(String name, String className, int targetPriority, int maxHp, int accMod, int dodge, int crit, int prot, int minDmg, int maxDmg, int spd,
			 int stunResist, int deathBlowResist, int bleedResist, int decayResist,
			int debuffResist) {
		super(name, maxHp, accMod, dodge, crit, prot, minDmg, maxDmg, spd,  stunResist, bleedResist, decayResist, debuffResist);
		this.setClassName(className);
		this.setTargetPriority(targetPriority);
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
			}
		} else {
			if (getHp() > 0) {
				setAlive(true);
			} else {
				if (isDeathBlown()) {
					GameLogic.team.remove(this);
				} else {
					setDeathBlowResist(getDeathBlowResist() - 16);
				}
			}
			if (GameLogic.team.isEmpty()) GameLogic.setGameEnd(true);
		}
	}
	
	@Override
	public void setHp(int hp) {
		super.setHp(hp);
		checkStatus();
	}
	
	public boolean isDeathBlown() {
		int chance = 100 - this.getDeathBlowResist();
		return GameLogic.randomInt() < chance ? true : false;
	}
	
	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public int getTargetPriority() {
		return targetPriority;
	}

	public void setTargetPriority(int targetPriority) {
		this.targetPriority = targetPriority;
	}

	public ArrayList<Equipable> getEquipmentSlots() {
		return equipmentSlots;
	}

	public void setEquipmentSlots(ArrayList<Equipable> equipmentSlots) {
		this.equipmentSlots = equipmentSlots;
	}

	public int getDeathBlowResist() {
		return deathBlowResist;
	}

	public void setDeathBlowResist(int deathBlowResist) {
		this.deathBlowResist = deathBlowResist;
	}

}
