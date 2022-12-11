package skill.ally;

import java.util.ArrayList;

import chara.base.Chara;
import skill.base.DamageSkill;

public class SwordBash extends DamageSkill {

	public SwordBash(Chara user) {
		super("Sword Bash", user, new ArrayList<logic.rank>(), -50, 90, 0);
		getRank().add(logic.rank.first);
		getRank().add(logic.rank.second);
		// TODO Auto-generated constructor stub
	}

}
