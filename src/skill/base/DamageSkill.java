package skill.base;

import java.util.ArrayList;

import chara.base.Ally;
import chara.base.Chara;
import chara.base.Enemy;
import logic.GameLogic;

public class DamageSkill extends BaseSkill {

	private int dmgMod;
	private int acc;
	private int critMod;
	
	public DamageSkill(String skillName, Chara user, ArrayList<logic.rank> rank, int dmgMod, int acc, int critMod) {
		super(skillName, user, rank);
		this.setDmgMod(dmgMod);
		this.setAcc(acc);
		this.setCritMod(critMod);
	}

	@Override
	public void cast() {
		// TODO Auto-generated method stub
		for (Chara each: targets) {
			if (each instanceof Ally) {
				if (isHit(each)) {
					int damageDeal = computeDamage(each);
					((Ally) each).setHp(each.getHp() - damageDeal);
					// show damageDeal
				} else {
					String show = "Dodge" ;
					// show Miss or Dodge
				}
			} else {
				if (isHit(each)) {
					int damageDeal = computeDamage(each);
					((Enemy) each).setHp(each.getHp() - damageDeal);
					// show damageDeal
				} else {
					String show = "Miss";
					// show Miss or Dodge
				}
			}
		}
	}
	
	private boolean isHit(Chara target) {
		int finalAcc = user.getAccMod() + getAcc() - target.getDodge();
		return GameLogic.randomInt() < finalAcc ? true : false;
	}
	
	private boolean isCrit() {
		int finalCrit = user.getCrit() + getCritMod();
		return GameLogic.randomInt() < finalCrit ? true : false;
	}
	
	private int computeDamage(Chara target) {
		int damage = GameLogic.randomRange(user.getMinDmg(), user.getMaxDmg()) * (1 + dmgMod/100);
		return (int) (isCrit() ? (damage * 1.5) : damage);
	}

	public int getDmgMod() {
		return dmgMod;
	}

	public void setDmgMod(int dmgMod) {
		this.dmgMod = dmgMod;
	}

	public int getAcc() {
		return acc;
	}

	public void setAcc(int acc) {
		this.acc = acc;
	}

	public int getCritMod() {
		return critMod;
	}

	public void setCritMod(int critMod) {
		this.critMod = critMod;
	}
	
}
