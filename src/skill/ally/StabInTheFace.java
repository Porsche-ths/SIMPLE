package skill.ally;

import java.util.ArrayList;
import java.util.Arrays;

import chara.base.Chara;
import chara.base.Enemy;
import logic.GameLogic;
import skill.base.DamageSkill;
import skill.base.TargetSelectable;

public class StabInTheFace extends DamageSkill implements TargetSelectable {

	public StabInTheFace(Chara user) {
		super("STABINTHEFACE", user, new ArrayList<logic.rank>(Arrays.asList(logic.rank.first, logic.rank.second, logic.rank.third)), 0, 90, 10);
	}

	@Override
	public void selectTarget() {
		// TODO Auto-generated method stub
		for (Enemy e: GameLogic.enemies) {
			if (e.getRank().equals(logic.rank.first) || e.getRank().equals(logic.rank.second)) {
				GameLogic.currentStage.getStageCharaPane().getChildren().get(GameLogic.enemies.indexOf(e) + 5).setDisable(false);
			}
		}
	}

}
