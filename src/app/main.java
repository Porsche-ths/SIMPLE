package app;


import charaselect.gui.CharSelect;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import startmenu.gui.MainMenu;

public class Main extends Application {
		private static  Stage stage;
		private static  Scene scene;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		MainMenu mainMenu = new MainMenu();
		scene = new Scene(mainMenu);
		stage = primaryStage;
		
		stage.setScene(scene);
		
		stage.show();

		
	}
	
	public static void switchToCharSelect() {
		CharSelect charSelect = new CharSelect();
		scene = new Scene(charSelect);
		stage.setScene(scene);
		
		
		
		
	}
	public static void main(String[] args) {
		Application.launch(args);
	}

	

}
