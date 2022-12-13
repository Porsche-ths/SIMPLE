package skill.enemy;

import java.util.ArrayList;
import java.util.Arrays;

import chara.base.Chara;
import skill.base.DamageSkill;

public class BonySlash extends DamageSkill {

	public BonySlash(Chara user) {
		super("BONYSLASH", user, new ArrayList<logic.rank>(Arrays.asList(logic.rank.first, logic.rank.second)), 0, 50, 2);
	}

}
