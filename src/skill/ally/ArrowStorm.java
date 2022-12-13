package skill.ally;

import java.util.ArrayList;
import java.util.Arrays;

import chara.base.Chara;
import chara.base.Enemy;
import logic.GameLogic;
import skill.base.DamageSkill;
import skill.base.TargetSelectable;

public class ArrowStorm extends DamageSkill implements TargetSelectable {

	public ArrowStorm(Chara user) {
		super("ARROWSTORM", user, new ArrayList<logic.rank>(Arrays.asList(logic.rank.third, logic.rank.fourth)), -70, 85, 0);
	}

	@Override
	public void selectTarget() {
		// TODO Auto-generated method stub
		for (Enemy e: GameLogic.enemies) {
			GameLogic.currentStage.getStageCharaPane().getChildren().get(GameLogic.enemies.indexOf(e) + 5).setDisable(false);
		}
	}

	@Override
	public void cast() {
		getTargets().clear();
		for (Enemy e: GameLogic.enemies) {
			GameLogic.currentSkill.getTargets().add(e);
		}
		super.cast();
	}
}
