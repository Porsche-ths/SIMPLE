package skill.enemy;

import java.util.ArrayList;
import java.util.Arrays;

import chara.base.Ally;
import chara.base.Chara;
import logic.GameLogic;
import skill.base.DamageSkill;

public class RavenousFeast extends DamageSkill {

	public RavenousFeast(Chara user) {
		super("RAVENOUSFEAST", user, new ArrayList<logic.rank>(Arrays.asList(logic.rank.first, logic.rank.second, 
				logic.rank.third, logic.rank.fourth)), 0, 80, 5);
	}
	
	@Override
	public void cast() {
		for (Chara each: targets) {
			System.out.println("Target Name : " + each.getName());
			System.out.println("Target Before: " + each.getHp());
			if (isHit(each)) {
				
				int damageDeal = computeDamage(each);
				((Ally) each).setHp(each.getHp() - damageDeal);
				System.out.println("Damage : " + damageDeal);
				// show damageDeal
				
				int selfHeal = (int) (damageDeal * 0.5);
				user.setHp(user.getHp() + selfHeal);
				System.out.println("Self Heal : " + selfHeal);
				System.out.println("Self HP : " + user.getHp());
				// show selfDeal
				
				GameLogic.getCurrentStage().getStageCharaPane().updateHpBar(each,100);
			} else {
				String show = "Dodge";
				// show Dodge
				System.out.println(show);
			}
			System.out.println("Target After: " + each.getHp());
		}
		targets.clear();
	}

}
