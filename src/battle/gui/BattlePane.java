package battle.gui;


import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class BattlePane extends VBox{
	private CharaPane charaPane;
	
	public BattlePane(CharaPane charaPane) {
		this.charaPane = charaPane;
		setPrefHeight(578);
		setPrefWidth(904);	
		setAlignment(Pos.BOTTOM_CENTER);
		getChildren().add(this.charaPane);
		Image ui = new Image("UISample.png");
		ImageView iv = new ImageView(ui);
		iv.setFitHeight(250);
		iv.setFitWidth(1400);	
		getChildren().add(iv);

	}
}
