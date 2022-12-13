package skill.ally;

import java.util.ArrayList;
import java.util.Arrays;

import chara.base.Chara;
import chara.base.Enemy;
import logic.GameLogic;
import skill.base.DamageSkill;
import skill.base.TargetSelectable;

public class DaggersPlay extends DamageSkill implements TargetSelectable {

	public DaggersPlay(Chara user) {
		super("DAGGERSPLAY", user, new ArrayList<logic.rank>(Arrays.asList(logic.rank.second, logic.rank.third, logic.rank.fourth)), 0, 90, 5);
	}

	@Override
	public void selectTarget() {
		// TODO Auto-generated method stub
		for (Enemy e: GameLogic.enemies) {
			if (e.getRank().equals(logic.rank.second) || e.getRank().equals(logic.rank.third)) {
				GameLogic.currentStage.getStageCharaPane().getChildren().get(GameLogic.enemies.indexOf(e) + 5).setDisable(false);
			}
		}
	}

	@Override
	public void cast() {
		getTargets().clear();
		for (Enemy e: GameLogic.enemies) {
			if (e.getRank().equals(logic.rank.second) || e.getRank().equals(logic.rank.third)) {
				GameLogic.currentSkill.getTargets().add(e);
			}
		}
		super.cast();
	}
}
