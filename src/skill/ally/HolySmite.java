package skill.ally;

import java.util.ArrayList;

import chara.base.Chara;
import skill.base.DamageSkill;
import skill.base.TargetSelectable;

public class HolySmite extends DamageSkill implements TargetSelectable {

	public HolySmite(Chara user) {
		super("HOLYSMITE", user, new ArrayList<logic.rank>(), 0, 85, 0);
		getRank().add(logic.rank.first);
		getRank().add(logic.rank.second);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void selectTarget() {
		// TODO Auto-generated method stub
		
	}
}
