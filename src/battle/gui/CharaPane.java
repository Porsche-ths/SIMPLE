package battle.gui;

import java.util.ArrayList;

import chara.base.Ally;
import chara.base.Chara;
import chara.base.Enemy;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import logic.GameLogic;
import logic.rank;


public class CharaPane extends HBox {
	private ArrayList<Ally> team;
	private ArrayList<Enemy> opponents;

	public CharaPane(ArrayList<Ally> team, ArrayList<Enemy> opponents) {
		this.team = team;
		this.opponents = opponents;
		setPrefWidth(880);
		setAlignment(Pos.CENTER);
		setPrefHeight(83);
		setSpacing(5);
		setPadding(new Insets(200,0,50,0));
		addCharToPane();
		
	}
	private void addCharToPane() {
		if(team.size() < 4) {
			for(int i = 0; i < 4-team.size();i++) {
				Image blank = new Image("blank.png");
				ImageView blankIdle = new ImageView(blank);
				blankIdle.setFitHeight(120);
				blankIdle.setFitWidth(140);
				getChildren().add(blankIdle);

			}
		}
		for(Ally a : team) {
			Image chara = new Image(a.getClassName() + "Idle.gif");
			ImageView iv = new ImageView(chara);
			VBox charaBox = new VBox();
			StackPane hp = initializeHpBar(100, a);
			iv.setFitHeight(200);
			iv.setFitWidth(125);
			//Crusader
			//iv.setFitHeight(200);
			//iv.setFitWidth(100);
			charaBox.getChildren().add(iv);
			charaBox.setPrefHeight(200);
			charaBox.setPrefWidth(125);
			charaBox.getChildren().add(hp);
			charaBox.setAlignment(Pos.CENTER);
			getChildren().add(charaBox);
		}
		Image blank = new Image("blank.png");
		ImageView blankIdle = new ImageView(blank);
		blankIdle.setFitHeight(120);
		blankIdle.setFitWidth(140);
		getChildren().add(blankIdle);
		for(Enemy a : opponents) {
			Image chara = new Image(a.getClassName() + "Idle.gif");
			ImageView iv = new ImageView(chara);
			iv.setFitHeight(180);
			iv.setFitWidth(140);
			iv.setOnMouseClicked(new EventHandler<Event>() {

				@Override
				public void handle(Event arg0) {
					// TODO Auto-generated method stub
					GameLogic.currentSkill.getTargets().add(a);
					GameLogic.currentSkill.cast();
					for (Node n: GameLogic.currentStage.getStageCharaPane().getChildren()) {
						n.setDisable(true);
					}
					GameLogic.nextTurn();
				}
				
			});
			iv.setDisable(true);
			getChildren().add(iv);
		}
		if(opponents.size() < 4) {
			for(int i = 0; i < 4-team.size();i++) {
				Image blank2 = new Image(ClassLoader.getSystemResource("blank.png").toString());
				ImageView blankIdle2 = new ImageView(blank2);
				blankIdle2.setFitHeight(120);
				blankIdle2.setFitWidth(140);
				getChildren().add(blankIdle2);

			}
		}

	}
	public StackPane initializeHpBar(int width,Chara c) {
		StackPane hpBar = new StackPane();
		Rectangle maxHp = new Rectangle(0,0,width,20);
		Rectangle hp = new Rectangle(0,0,(c.getHp()/c.getMaxHp()*(width-2)),15);
		maxHp.setFill(Color.WHITE);
		hp.setFill(Color.GREEN);
		hpBar.setAlignment(Pos.CENTER_LEFT);
		hpBar.getChildren().add(maxHp);
		hpBar.getChildren().add(hp);
		return hpBar;
	}
	public void updateHpBar(Chara c, double defaultWidth) {
		int n = 0;

		switch(c.getRank()) {
		case first:
			n = c instanceof Ally? 3:5; break;
		case second:
			n = c instanceof Ally? 2:6; break;
		case third:
			n = c instanceof Ally? 1:7; break;
		case fourth:
			n = c instanceof Ally? 0:8; break;
		}
		VBox v = (VBox)(getChildren().get(n));
		StackPane s = (StackPane)(v.getChildren().get(1));
		Rectangle r = (Rectangle)(s.getChildren().get(1));
		System.out.println((((double)c.getHp())/(double)(c.getMaxHp()))*(defaultWidth) + c.getName() + " " + n );
		r.setWidth((((double)c.getHp())/(double)(c.getMaxHp()))*defaultWidth);
		for(Ally a : team){
			System.out.println(a.getName());
		}

	}

}
