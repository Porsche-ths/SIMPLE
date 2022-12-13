package skill.ally;

import java.util.ArrayList;
import java.util.Arrays;

import chara.base.Ally;
import chara.base.Chara;
import logic.GameLogic;
import skill.base.HealSkill;
import skill.base.TargetSelectable;

public class DivineComfort extends HealSkill implements TargetSelectable {

	public DivineComfort(Chara user) {
		super("DIVINECOMFORT", user, new ArrayList<logic.rank>(Arrays.asList(logic.rank.second, logic.rank.third, logic.rank.fourth)), 1, 3);
	}

	@Override
	public void selectTarget() {
		// TODO Auto-generated method stub
		for (Ally a: GameLogic.team) {
			GameLogic.currentStage.getStageCharaPane().getChildren().get(GameLogic.team.indexOf(a)).setDisable(false);
		}
	}

	@Override
	public void cast() {
		getTargets().clear();
		for (Ally hero: GameLogic.team) {
			GameLogic.currentSkill.getTargets().add(hero);
		}
		super.cast();
	}
}
