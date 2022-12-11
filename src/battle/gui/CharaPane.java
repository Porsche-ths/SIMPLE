package battle.gui;

import java.util.ArrayList;

import chara.base.Ally;
import chara.base.Enemy;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;


public class CharaPane extends HBox {
	private ArrayList<Ally> team;
	private ArrayList<Enemy> opponents;
	private StackPane hpBar;

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
			iv.setFitHeight(200);
			iv.setFitWidth(100);
			getChildren().add(iv);
		}
		Image blank = new Image("blank.png");
		ImageView blankIdle = new ImageView(blank);
		blankIdle.setFitHeight(120);
		blankIdle.setFitWidth(140);
		getChildren().add(blankIdle);
		for(Enemy a : opponents) {
			System.out.println(a.getClassName()+ "Idle.gif");
			Image chara = new Image(a.getClassName() + "Idle.gif");
			ImageView iv = new ImageView(chara);
			iv.setFitHeight(200);
			iv.setFitWidth(160);
			getChildren().add(iv);
		}
		if(opponents.size() < 4) {
			for(int i = 0; i < 4-team.size();i++) {
				Image blank2 = new Image("blank.png");
				ImageView blankIdle2 = new ImageView(blank2);
				blankIdle2.setFitHeight(120);
				blankIdle2.setFitWidth(140);
				getChildren().add(blankIdle2);

			}
		}

	}
	public void initializeHpBar() {
		hpBar = new StackPane();
		
	}

}
