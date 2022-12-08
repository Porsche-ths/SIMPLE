package Skill;

import java.util.ArrayList;

import Character.Chara;
import logic.GameLogic;

public class HealSkill extends Skill {
	
	private int healMod;

	public HealSkill(String skillName, Chara user, ArrayList<logic.rank> rank, int healMod) {
		super(skillName, user, rank);
		this.setHealMod(healMod);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void cast() {
		// TODO Auto-generated method stub
		for (Chara each: targets) {
			int healAmount = computeHealAmount(each);
			each.setHp(each.getHp() + healAmount);
		}
	}
	
	private boolean isCrit() {
		return GameLogic.randomInt() < user.getCrit() ? true : false;
	}
	
	private int computeHealAmount(Chara target) {
		int healAmount = (int) (target.getHp() * (healMod/100));
		return (int) (isCrit() ? (healAmount * 1.5) : healAmount);
	}

	public int getHealMod() {
		return healMod;
	}

	public void setHealMod(int healMod) {
		this.healMod = healMod;
	}

}
