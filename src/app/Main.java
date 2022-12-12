package app;

import battle.gui.BattlePane;
import battle.gui.CharaPane;
import chara.ally.Crusader;
import charaselect.gui.CharSelect;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;
import logic.GameLogic;
import map.gui.Map;
import sprites.CrusaderSprite;
import startmenu.gui.MainMenu;

public class Main extends Application {
	public static Stage stage;
	private static Scene mainMenuScene, charSelectScene, mapMenuScene;
	private static CharSelect charSelect;
	private static MainMenu mainMenu;
	private static Map mapMenu;

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		mainMenu = new MainMenu();
		charSelect = new CharSelect();
		mapMenu = new Map();
		mainMenuScene = new Scene(mainMenu);
		charSelectScene = new Scene(charSelect);
		mapMenuScene = new Scene(mapMenu);
		stage = primaryStage;
		stage.setScene(mainMenuScene);
		stage.show();

	}

	public static void switchToCharSelect() {
		stage.setScene(charSelectScene);


	}

	public static void switchToMainMenu() {
		stage.setScene(mainMenuScene);

	}

	public static void switchToMap() {
		stage.setScene(mapMenuScene);

	}
	public static void switchToBattleStage() {
		GameLogic.newGame();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
	

}
