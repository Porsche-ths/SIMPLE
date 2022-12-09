package skill.enemy;

import java.util.ArrayList;

import chara.base.Chara;
import skill.base.DamageSkill;

public class BonySlash extends DamageSkill {

	public BonySlash(Chara ss) {
		super("Bony Slash", ss, new ArrayList<logic.rank>(), 0, 50, 2);
		getRank().add(logic.rank.first);
		getRank().add(logic.rank.second);
		getRank().add(logic.rank.third);
	}

}
