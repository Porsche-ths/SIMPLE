package battle.gui;



import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;

public class BattlePane extends VBox{
	private CharaPane charaPane;
	private GridPane fightMenu,skillMenu;
	private BorderPane fightUI;
	private StackPane fightButton,itemButton;
	
	public BattlePane(CharaPane charaPane) {
		this.charaPane = charaPane;
		setPrefHeight(680);
		setPrefWidth(1400);	
		setAlignment(Pos.BOTTOM_CENTER);
		getChildren().add(this.charaPane);
		Image ui = new Image("battleCommand.png");
		fightUI = new BorderPane();
		fightUI.setPrefWidth(1400);	
		fightUI.setPrefHeight(500);
		fightUI.setBackground(new Background(new BackgroundFill(new ImagePattern(ui),CornerRadii.EMPTY,Insets.EMPTY)));

		getChildren().add(fightUI);
		initializeFightMenu();

	}
	private void initializeFightMenu() {
		fightMenu = new GridPane();
		//fightMenu.setBackground(new Background(new BackgroundFill(Color.AQUA,CornerRadii.EMPTY,Insets.EMPTY)));
		fightButton = new StackPane();
		itemButton = new StackPane();
		fightButton.setPrefHeight(100);
		fightButton.setPrefWidth(250);
		itemButton.setPrefHeight(100);
		itemButton.setPrefWidth(250);
		fightButton.setBackground(new Background(new BackgroundFill(new ImagePattern(new Image("fightButton.png")),CornerRadii.EMPTY,Insets.EMPTY)));
		itemButton.setBackground(new Background(new BackgroundFill(new ImagePattern(new Image("itemButton.png")),CornerRadii.EMPTY,Insets.EMPTY)));
		fightMenu.setAlignment(Pos.CENTER);
		fightMenu.add(fightButton, 0, 0);
		fightMenu.add(itemButton, 1, 0);
		fightMenu.setHgap(50);
		fightUI.setRight(fightMenu);
		fightMenu.setPrefHeight(200);
		fightMenu.setPrefWidth(700);	
		
	}
	private void initializeSkillMenu() {
		skillMenu =  new GridPane();
	}
}
