package battle.gui;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;


public class CharaPane extends HBox {

	public CharaPane() {
 
		setPrefWidth(880);
		setAlignment(Pos.CENTER);
		setPrefHeight(83);
		setSpacing(5);
		setPadding(new Insets(200,0,0,0));
		addCharToPane();
		
	}
	private void addCharToPane() {
		ArrayList<String> charList = new ArrayList<String>();
		charList.add("priestSample.png");
		charList.add("priestSample.png");
		charList.add("priestSample.png");
		charList.add("priestSample.png");
		charList.add("blank.png");
		charList.add("skellySample.png");
		charList.add("skellySample.png");
		charList.add("skellySample.png");
		charList.add("bossSample.gif");
		for(String c : charList) {
			Image chara = new Image(c);
			ImageView iv = new ImageView(chara);
			iv.setFitHeight(120);
			iv.setFitWidth(140);
			getChildren().add(iv);
		}

	}

}
