package skill.ally;

import java.util.ArrayList;

import chara.base.Chara;
import skill.base.DamageSkill;

public class HolySmite extends DamageSkill {

	public HolySmite(Chara user) {
		super("HOLYSMITE", user, new ArrayList<logic.rank>(), 0, 85, 0);
		getRank().add(logic.rank.first);
		getRank().add(logic.rank.second);
		// TODO Auto-generated constructor stub
	}
}
