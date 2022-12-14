package skill.ally;

import java.util.ArrayList;
import java.util.Arrays;

import battle.gui.CharaPane;
import chara.base.Chara;
import chara.base.Enemy;
import javafx.animation.AnimationTimer;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import logic.GameLogic;
import skill.base.DamageSkill;
import skill.base.TargetSelectable;
import sprites.AttackedSprite;

public class ArrowStorm extends DamageSkill implements TargetSelectable {

	public ArrowStorm(Chara user) {
		super("ARROWSTORM", user, new ArrayList<logic.rank>(Arrays.asList(logic.rank.third, logic.rank.fourth)), -70, 85, 0);
	}

	@Override
	public void selectTarget() {
		// TODO Auto-generated method stub
		for (Node n: GameLogic.currentStage.getStageCharaPane().getChildren()) {
			n.setDisable(true);
		}
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
	@Override
	public void playAnimation() {
		// TODO Auto-generated method stub
		HBox animation = new HBox();
		animation.setPrefWidth(1400);
		animation.setPrefHeight(740);
		animation.setAlignment(Pos.BOTTOM_CENTER);
		animation.setPadding(new Insets(150,0,25,0));
		Image img = new Image(ClassLoader.getSystemResource("rangerSkill.gif").toString());
		ImageView iv = new ImageView(img);
		iv.setFitHeight(220);
		iv.setFitWidth(150);
		animation.getChildren().add(iv);
		animation.setSpacing(100);
		for(Chara e : GameLogic.enemies) {
			System.out.println("name = " +e.getName());
			animation.getChildren().add(new AttackedSprite(((Enemy)(e)).getClassName()));
		}
		CharaPane tmp = GameLogic.currentStage.getStageCharaPane();
		GameLogic.currentStage.getBattlePane().getChildren().remove(GameLogic.currentStage.getStageCharaPane());
		GameLogic.currentStage.getBattlePane().getChildren().add(0, animation);
		GameLogic.currentStage.getBattlePane().showBattleText("RANGER used ARROW STORM!");

		AnimationTimer timer = new AnimationTimer() {
			int time = 0;
			@Override
			public void handle(long arg0) {
				// TODO Auto-generated method stub
				time += 1;
				String[] result = getResult().split(",");
				if(time == 75) {
				GameLogic.getCurrentStage().getBattlePane().getChildren().remove(animation);
				GameLogic.getCurrentStage().getBattlePane().getChildren().add(0,tmp);
				}
				if(time == 100) {
					GameLogic.currentStage.getBattlePane().removeBattleText();
					GameLogic.currentStage.getBattlePane().showBattleText(result[0]);
				}
				if(time == 175 && result.length > 1) {
					GameLogic.currentStage.getBattlePane().removeBattleText();
					GameLogic.currentStage.getBattlePane().showBattleText(result[1]);
				}
				else if (time == 175 && result.length < 2) {
					GameLogic.currentStage.getBattlePane().removeBattleText();
					GameLogic.nextTurn();
				}
				if(time == 250 && result.length > 2) {
					GameLogic.currentStage.getBattlePane().removeBattleText();
					GameLogic.currentStage.getBattlePane().showBattleText(result[2]);
				}
				else if (time == 250 && result.length < 3){
					GameLogic.currentStage.getBattlePane().removeBattleText();
					GameLogic.nextTurn();
				}
				if(time == 325 && result.length > 3) {
					GameLogic.currentStage.getBattlePane().removeBattleText();
					GameLogic.currentStage.getBattlePane().showBattleText(result[3]);
				}
				else if (time == 400 ){
					GameLogic.currentStage.getBattlePane().removeBattleText();
					GameLogic.nextTurn();
				}
			};
		
		};
		timer.start();
	}

}
