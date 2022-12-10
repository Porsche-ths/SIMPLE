package startmenu.gui;


import app.Main;
import game.state.GameState;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import javafx.scene.text.Text;

public class MainMenu extends StackPane {
	public MainMenu() {
		setPrefWidth(1400);	
		setPrefHeight(680);
		setAlignment(Pos.CENTER);
		Image bg = new Image("startMenu.png");
		ImageView iv = new ImageView(bg);
		iv.setFitWidth(1400);
		iv.setFitHeight(680);
		getChildren().add(iv);
		
		
		StackPane startBorder = new StackPane();
		startBorder.setMaxWidth(400);
		startBorder.setMaxHeight(420);
		//startBorder.setBackground(new Background(new BackgroundFill(Color.AQUA,CornerRadii.EMPTY,Insets.EMPTY)));
		Text titleText = new Text("SIMPLE DUNGEON");
		titleText.setFont(Font.font(100));
		titleText.setFill(Color.LIGHTSTEELBLUE);
		Text startText = new Text("Start");
		startText.setFont(Font.font(50));
		startText.setFill(Color.BEIGE);
		startBorder.getChildren().add(startText);
		startBorder.getChildren().add(titleText);
		StackPane.setAlignment(startText,Pos.BOTTOM_CENTER);
		StackPane.setAlignment(titleText,Pos.TOP_CENTER);
		startText.setOnMouseClicked(new EventHandler <Event>() {

			@Override
			public void handle(Event arg0) {
				// TODO Auto-generated method stub
				Main.switchToCharSelect();
				
				
			}
			
		});

		getChildren().add(startBorder);
		
		
	}
}
