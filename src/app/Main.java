package app;

import chara.base.Ally;
import charaselect.gui.CharSelect;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import logic.GameLogic;
import map.gui.Map;
import startmenu.gui.MainMenu;

public class Main extends Application {
	public static Stage stage;
	public static Scene mainMenuScene, charSelectScene, mapMenuScene;
	public static CharSelect charSelect;
	public static MainMenu mainMenu;
	public static Map mapMenu;

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		AudioClip music = new AudioClip(ClassLoader.getSystemResource("soundtrack.mp3").toString());
		music.setCycleCount(Timeline.INDEFINITE);

		music.play();
		mainMenu = new MainMenu();
		charSelect = new CharSelect();
		mainMenuScene = new Scene(mainMenu);
		charSelectScene = new Scene(charSelect);	
		stage = primaryStage;
		stage.setScene(mainMenuScene);
		stage.show();
	}

	public static void switchToCharSelect() {
		stage.setScene(charSelectScene);
	}

	public static void switchToMainMenu() {
		MainMenu.fadeTitleText();
		stage.setScene(mainMenuScene);
	}

	
	
	public static void switchToBattleStage() {
		GameLogic.newGame();
		
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
	

}
