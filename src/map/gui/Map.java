package map.gui;

import app.Main;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;

public class Map extends StackPane {
	public Map() {
		setPrefWidth(1400);
		setPrefHeight(680);
		setAlignment(Pos.CENTER);
		Image mapBg = new Image("mapBG.png");
		ImageView bg = new ImageView(mapBg);
		bg.setFitWidth(1200);
		bg.setFitHeight(600);
		setBackground(new Background(new BackgroundFill(Color.WHEAT,CornerRadii.EMPTY, Insets.EMPTY)));
		getChildren().add(bg);
		

	}
	
}
