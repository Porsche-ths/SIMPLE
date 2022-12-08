package Skill;

import java.util.ArrayList;

import chara.base.Chara;
import logic.GameLogic;

public class HealSkill extends Skill {
	
	private int minHeal;
	private int maxHeal;

	public HealSkill(String skillName, Chara user, ArrayList<logic.rank> rank, int minHeal, int maxHeal) {
		super(skillName, user, rank);
		this.setMinHeal(minHeal);
		this.setMaxHeal(maxHeal);
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
		int healAmount = GameLogic.randomRange(minHeal, maxHeal);
		return (int) (isCrit() ? (healAmount * 1.5) : healAmount);
	}

	public int getMinHeal() {
		return minHeal;
	}

	public void setMinHeal(int minHeal) {
		this.minHeal = minHeal;
	}

	public int getMaxHeal() {
		return maxHeal;
	}

	public void setMaxHeal(int maxHeal) {
		this.maxHeal = maxHeal;
	}

}
