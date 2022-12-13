package skill.ally;

import java.util.ArrayList;
import java.util.Arrays;

import battle.gui.CharaPane;
import chara.base.Ally;
import chara.base.Chara;
import chara.base.Enemy;
import javafx.animation.AnimationTimer;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import logic.GameLogic;
import skill.base.HealSkill;
import skill.base.TargetSelectable;
import sprites.AttackedSprite;
import sprites.IdleSprite;

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
	@Override
	public void playAnimation() {
		// TODO Auto-generated method stub
		HBox animation = new HBox();
		animation.setPrefWidth(1400);
		animation.setPrefHeight(740);
		animation.setAlignment(Pos.CENTER);
		animation.setPadding(new Insets(200,0,50,0));
		Image img = new Image(ClassLoader.getSystemResource("priestHealing.gif").toString());
		ImageView iv = new ImageView(img);
		iv.setFitHeight(200);
		iv.setFitWidth(100);
		animation.getChildren().add(iv);
		animation.setSpacing(100);
		for(Chara e : GameLogic.team) {
			if (e != getUser()) {
				animation.getChildren().add(new IdleSprite(((Ally) (e)).getClassName()));
			}
		}
		CharaPane tmp = GameLogic.currentStage.getStageCharaPane();
		GameLogic.currentStage.getBattlePane().getChildren().remove(GameLogic.currentStage.getStageCharaPane());
		GameLogic.currentStage.getBattlePane().getChildren().add(0, animation);
		AnimationTimer timer = new AnimationTimer() {
			int time = 0;
			@Override
			public void handle(long arg0) {
				// TODO Auto-generated method stub
				time += 1;
				if(time == 75) {
				GameLogic.getCurrentStage().getBattlePane().getChildren().remove(animation);
				GameLogic.getCurrentStage().getBattlePane().getChildren().add(0,tmp);
				GameLogic.nextTurn();
				}
			};
		
		};
		timer.start();
	}
}
