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
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import logic.GameLogic;
import skill.base.HealSkill;
import skill.base.TargetSelectable;
import sprites.AttackedSprite;
import sprites.IdleSprite;

public class DivineGrace extends HealSkill implements TargetSelectable {

	public DivineGrace(Chara user) {
		super("DIVINEGRACE", user, new ArrayList<logic.rank>(Arrays.asList(logic.rank.third, logic.rank.fourth)), 4, 5);
	}

	@Override
	public void selectTarget() {
		// TODO Auto-generated method stub
		for (Node n: GameLogic.currentStage.getStageCharaPane().getChildren()) {
			n.setDisable(true);
		}
		for (Ally a: GameLogic.team) {
			GameLogic.currentStage.getStageCharaPane().getChildren().get(GameLogic.team.indexOf(a)).setDisable(false);
		}
	}

	@Override
	public void playAnimation() {
		// TODO Auto-generated method stub
		for (Chara e : targets) {
			HBox animation = new HBox();
			StackPane healBox = new StackPane();
			healBox.setAlignment(Pos.CENTER);
			animation.setPrefWidth(1400);
			animation.setPrefHeight(740);
			animation.setAlignment(Pos.CENTER);
			animation.setPadding(new Insets(200, 0, 50, 0));
			Image img = new Image(ClassLoader.getSystemResource("priestHealing.gif").toString());
			ImageView iv = new ImageView(img);
			animation.setSpacing(0);
			iv.setFitHeight(200);
			iv.setFitWidth(100);
			animation.getChildren().add(iv);
			if (e != getUser()) {
				healBox.getChildren().add(new IdleSprite(((Ally) (e)).getClassName()));
				healBox.getChildren().add(new ImageView(new Image(ClassLoader.getSystemResource("healing.gif").toString())));
			}
			animation.getChildren().add(healBox);
			CharaPane tmp = GameLogic.currentStage.getStageCharaPane();
			GameLogic.currentStage.getBattlePane().getChildren().remove(GameLogic.currentStage.getStageCharaPane());
			GameLogic.currentStage.getBattlePane().getChildren().add(0, animation);
			GameLogic.currentStage.getBattlePane().showBattleText("PRIEST used DIVINE GRACE");
			AudioClip healSound = new AudioClip(ClassLoader.getSystemResource("priestHealing.mp3").toString());
			healSound.play();
			AnimationTimer timer = new AnimationTimer() {
				int time = 0;

				@Override
				public void handle(long arg0) {
					// TODO Auto-generated method stub
					time += 1;
					if (time == 75) {
						GameLogic.getCurrentStage().getBattlePane().getChildren().remove(animation);
						GameLogic.getCurrentStage().getBattlePane().getChildren().add(0, tmp);
					}
					if(time == 100) {
						GameLogic.currentStage.getBattlePane().removeBattleText();
						GameLogic.currentStage.getBattlePane().showBattleText(getResult());
					}
					if(time == 175) {
						GameLogic.currentStage.getBattlePane().removeBattleText();
						GameLogic.nextTurn();
					}
				};

			};
			timer.start();

		}
	}

}
