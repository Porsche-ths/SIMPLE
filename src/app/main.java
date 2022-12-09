package app;

import battle.gui.BattlePane;
import battle.gui.CharaPane;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class main extends Application {
	public void start(Stage primaryStage) throws Exception {	
		Pane root = new StackPane();
		Image bg = new Image("backgroundSample.png");
		ImageView iv = new ImageView(bg);
		iv.setFitWidth(1400);
		iv.setFitHeight(680);
	
		root.setPrefWidth(904);	
		root.setPrefHeight(578);

		
		Scene scene = new Scene(root,1400,680);
		root.getChildren().add(iv);
		root.getChildren().add(new BattlePane(new CharaPane()));
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
