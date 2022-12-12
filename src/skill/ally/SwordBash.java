package skill.ally;

import java.util.ArrayList;

import chara.base.Chara;
import chara.base.Enemy;
import logic.GameLogic;
import skill.base.DamageSkill;
import skill.base.TargetSelectable;

public class SwordBash extends DamageSkill implements TargetSelectable {

	public SwordBash(Chara user) {
		super("SWORDBASH", user, new ArrayList<logic.rank>(), -50, 90, 0);
		getRank().add(logic.rank.first);
		getRank().add(logic.rank.second);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void selectTarget() {
		// TODO Auto-generated method stub
		for (Enemy e: GameLogic.enemies) {
			if (getRank().contains(e.getRank())) {
				GameLogic.currentStage.getStageCharaPane().getChildren().get(GameLogic.enemies.indexOf(e) + 5).setDisable(false);
			}
		}
	}

}
