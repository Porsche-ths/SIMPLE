package skill.enemy;

import java.util.ArrayList;
import java.util.Arrays;

import chara.base.Chara;
import skill.base.DamageSkill;

public class BonyShot extends DamageSkill {

	public BonyShot(Chara user) {
		super("BONYSHOT", user, new ArrayList<logic.rank>(Arrays.asList(logic.rank.third, logic.rank.fourth)), 0, 0, 0);
	}
	
}
