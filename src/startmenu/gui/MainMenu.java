package startmenu.gui;

import app.Main;
import javafx.animation.AnimationTimer;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
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
import javafx.util.Duration;

public class MainMenu extends StackPane {
	private static int time;
	private static int frameTime;
	private static AnimationTimer timer;
	private static ImageView titleText;

	public MainMenu() {
		setPrefWidth(1400);
		setPrefHeight(680);
		setAlignment(Pos.CENTER);
		Image bg = new Image("startMenu.gif");
		ImageView bgv = new ImageView(bg);
		bgv.setFitWidth(1400);
		bgv.setFitHeight(680);
		getChildren().add(bgv);
		// setBackground(new Background(new BackgroundFill(new
		// ImagePattern(bg),CornerRadii.EMPTY, Insets.EMPTY)));

		Font font = Font.loadFont(ClassLoader.getSystemResourceAsStream("MINECRAFT_FONT.TTF"), 60);
		StackPane startBorder = new StackPane();
		startBorder.setMaxWidth(400);
		startBorder.setMaxHeight(600);
		// startBorder.setBackground(new Background(new
		// BackgroundFill(Color.AQUA,CornerRadii.EMPTY,Insets.EMPTY)));
		Image titleImg = new Image("titleText.png");
		titleText = new ImageView(titleImg);
		Text startText = new Text("START");
		startText.setFill(Color.WHITE);
		startText.setFont(font);
		startBorder.getChildren().add(startText);
		startBorder.getChildren().add(titleText);
		StackPane.setAlignment(startText, Pos.BOTTOM_CENTER);
		startText.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				// TODO Auto-generated method stub
				Main.switchToCharSelect();

			}

		});
		getChildren().add(startBorder);
		time = 0;
		frameTime = 0;
		titleText.setOpacity(0);
		timer = new AnimationTimer() {

			@Override
			public void handle(long arg0) {
				// TODO Auto-generated method stub
				handler();

			}

		};
		timer.start();

	}

	private void handler() {
		if (time < 200) {
			frameTime += 1;
			if (frameTime - time == 20) {
				time += 20;
				titleText.setOpacity(titleText.getOpacity()+0.1);
			}

		}
		else {
			timer.stop();
		}

	}
	public static void fadeTitleText() {
		time = 0;
		frameTime = 0;
		titleText.setOpacity(0);
		timer.start();
	}
}
