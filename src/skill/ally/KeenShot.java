package skill.ally;

import java.util.ArrayList;
import java.util.Arrays;

import chara.base.Chara;
import chara.base.Enemy;
import logic.GameLogic;
import skill.base.DamageSkill;
import skill.base.TargetSelectable;

public class KeenShot extends DamageSkill implements TargetSelectable{

	public KeenShot(Chara user) {
		super("KEENSHOT", user, new ArrayList<logic.rank>(Arrays.asList(logic.rank.third, logic.rank.fourth)), 0, 95, 5);
	}

	@Override
	public void selectTarget() {
		// TODO Auto-generated method stub
		for (Enemy e: GameLogic.enemies) {
			if (e.getRank().equals(logic.rank.second) || e.getRank().equals(logic.rank.third) || e.getRank().equals(logic.rank.fourth)) {
				GameLogic.currentStage.getStageCharaPane().getChildren().get(GameLogic.enemies.indexOf(e) + 5).setDisable(false);
			}
		}
	}

}
