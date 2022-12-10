package startmenu.gui;


import app.Main;
import javafx.event.Event;
import javafx.event.EventHandler;
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
import javafx.scene.text.Font;

import javafx.scene.text.Text;

public class MainMenu extends StackPane {
	public MainMenu() {
		setPrefWidth(1400);	
		setPrefHeight(680);
		setAlignment(Pos.CENTER);
		Image bg = new Image("startMenu.png");
		setBackground(new Background(new BackgroundFill(new ImagePattern(bg),CornerRadii.EMPTY, Insets.EMPTY)));

		
		
		StackPane startBorder = new StackPane();
		startBorder.setMaxWidth(400);
		startBorder.setMaxHeight(500);
		//startBorder.setBackground(new Background(new BackgroundFill(Color.AQUA,CornerRadii.EMPTY,Insets.EMPTY)));
		Image titleImg = new Image("titleText.png");
		ImageView titleText = new ImageView(titleImg);
		Image startImg = new Image("startText.png");
		ImageView startText = new ImageView(startImg);
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
