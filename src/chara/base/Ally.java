package chara.base;

import java.util.ArrayList;

import item.base.Equipable;
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

}
