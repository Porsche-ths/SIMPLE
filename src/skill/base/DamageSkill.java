package skill.base;

import java.util.ArrayList;

import chara.base.Ally;
import chara.base.Chara;
import chara.base.Enemy;
import logic.GameLogic;

public class DamageSkill extends BaseSkill {

	private int dmgMod; //percent to multiply
	private int acc;
	private int critMod;
	private int damageDeal;
	private String result;
	
	public DamageSkill(String skillName, Chara user, ArrayList<logic.rank> rank, int dmgMod, int acc, int critMod) {
		super(skillName, user, rank);
		this.setDmgMod(dmgMod);
		this.setAcc(acc);
		this.setCritMod(critMod);
	}

	@Override
	public void cast() {
		// TODO Auto-generated method stub
		result = "";
		for (Chara each: targets) {
			System.out.println("Target Name : " + each.getName());
			System.out.println("Target Before: " + each.getHp());
			if (each instanceof Ally) {
				if (isHit(each)) {
					damageDeal = computeDamage(each);
					((Ally) each).setHp(each.getHp() - damageDeal);
					// show damageDeal
					result = "It dealt " + damageDeal + " damage!";
					if(each.getHp()!=0) {
					GameLogic.getCurrentStage().getStageCharaPane().updateHpBar(each,100);
					}
				} else {
					String show = "Dodge";
					// show Miss or Dodge
					result = "You dodged!";
					System.out.println(show);
				}
			} else {
				if (isHit(each)) {
					damageDeal = computeDamage(each);
					((Enemy) each).setHp(each.getHp() - damageDeal);
					System.out.println(damageDeal);
					if(targets.size() > 1) {
						result += "It dealt " + damageDeal + " damage!,";

					}
					else {
						result = "It dealt " + damageDeal + " damage!";

					}
					GameLogic.getCurrentStage().getStageCharaPane().updateHpBar(each,100);
					// show damageDeal
				} else {
					String show = "Miss";
					// show Miss or Dodge
					if(targets.size() > 1) {
						result += "It missed!,";

					}
					else {
						result = "It missed!";
;

					}
					System.out.println(show);
				}
			}
			System.out.println("Target After: " + each.getHp());
		}
		targets.clear();
	}
	
	protected boolean isHit(Chara target) {
		int finalAcc = user.getAccMod() + getAcc() - target.getDodge();
		return GameLogic.randomInt() < finalAcc ? true : false;
	}
	
	protected boolean isCrit() {
		int finalCrit = user.getCrit() + getCritMod();
		return GameLogic.randomInt() < finalCrit ? true : false;
	}
	
	protected int computeDamage(Chara target) {
		float damage = (float) (GameLogic.randomRange(user.getMinDmg(), user.getMaxDmg()) * (1 + (((float)dmgMod)/100)));
		System.out.println("Damage : " + damage);
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

	@Override
	public void playAnimation() {
		// TODO Auto-generated method stub
		
	}
	public String getResult() {
		return result;
	}
	
}
