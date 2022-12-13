package skill.ally;

import java.util.ArrayList;
import java.util.Arrays;

import chara.base.Ally;
import chara.base.Chara;
import logic.GameLogic;
import skill.base.HealSkill;
import skill.base.TargetSelectable;

public class DivineGrace extends HealSkill implements TargetSelectable {

	public DivineGrace(Chara user) {
		super("DIVINEGRACE", user, new ArrayList<logic.rank>(Arrays.asList(logic.rank.third, logic.rank.fourth)), 4, 5);
	}

	@Override
	public void selectTarget() {
		// TODO Auto-generated method stub
		for (Ally a: GameLogic.team) {
			GameLogic.currentStage.getStageCharaPane().getChildren().get(GameLogic.team.indexOf(a)).setDisable(false);
		}
	}

}
