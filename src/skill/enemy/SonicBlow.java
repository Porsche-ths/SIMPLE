package skill.enemy;

import java.util.ArrayList;
import java.util.Arrays;

import chara.base.Chara;
import skill.base.DamageSkill;

public class SonicBlow extends DamageSkill {

	public SonicBlow(Chara user) {
		super("SONICBLOW", user, new ArrayList<logic.rank>(Arrays.asList(logic.rank.first, logic.rank.second)), 0, 0, 6);
	}

}
