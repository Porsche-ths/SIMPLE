package skill.ally;

import java.util.ArrayList;

import battle.gui.CharaPane;
import chara.base.Chara;
import chara.base.Enemy;
import javafx.animation.AnimationTimer;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import logic.GameLogic;
import skill.base.DamageSkill;
import skill.base.TargetSelectable;
import sprites.AttackedSprite;

public class SwordBash extends DamageSkill implements TargetSelectable {

	public SwordBash(Chara user) {
		super("SWORDBASH", user, new ArrayList<logic.rank>(), -50, 90, 100);
		getRank().add(logic.rank.first);
		getRank().add(logic.rank.second);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void selectTarget() {
		// TODO Auto-generated method stub
		getTargets().clear();
		for (Enemy e: GameLogic.enemies) {
			if (e.getRank().equals(logic.rank.first) || e.getRank().equals(logic.rank.second)) {
				GameLogic.currentStage.getStageCharaPane().getChildren().get(GameLogic.enemies.indexOf(e) + 5).setDisable(false);
			}
		}
	}
	@Override
	public void playAnimation() {
		// TODO Auto-generated method stub
		for(Chara e : targets) {
			HBox animation = new HBox();
			animation.setPrefWidth(1400);
			animation.setPrefHeight(740);
			animation.setAlignment(Pos.CENTER);
			animation.setPadding(new Insets(200,0,50,0));
			Image img = new Image(ClassLoader.getSystemResource("crusaderSkill1.gif").toString());
			ImageView iv = new ImageView(img);
			animation.setSpacing(-100);
			iv.setFitHeight(250);
			iv.setFitWidth(250);
			animation.getChildren().add(iv);
			animation.getChildren().add(new AttackedSprite(((Enemy)(e)).getClassName()));
			CharaPane tmp = GameLogic.currentStage.getStageCharaPane();
			GameLogic.currentStage.getBattlePane().getChildren().remove(GameLogic.currentStage.getStageCharaPane());
			GameLogic.currentStage.getBattlePane().getChildren().add(0, animation);
			AnimationTimer timer = new AnimationTimer() {
				int time = 0;
				@Override
				public void handle(long arg0) {
					// TODO Auto-generated method stub
					time += 1;
					if(time == 150) {
					GameLogic.getCurrentStage().getBattlePane().getChildren().remove(animation);
					GameLogic.getCurrentStage().getBattlePane().getChildren().add(0,tmp);
					}
				};
			
			};
			timer.start();
			
		}
	}

}
