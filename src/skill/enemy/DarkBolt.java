package skill.enemy;

import java.util.ArrayList;
import java.util.Arrays;

import chara.base.Chara;
import skill.base.DamageSkill;

public class DarkBolt extends DamageSkill {

	public DarkBolt(Chara user) {
		super("DARKBOLT", user, new ArrayList<logic.rank>(Arrays.asList(logic.rank.first, logic.rank.second, 
				logic.rank.third, logic.rank.fourth)), 0, 85, 0);
	}

}
