package battle.gui;



import chara.base.Ally;
import javafx.event.Event;
import javafx.event.EventHandler;
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
import logic.GameLogic;
import skill.base.BaseSkill;
import skill.base.TargetSelectable;

public class BattlePane extends VBox{
	private CharaPane charaPane;
	private GridPane fightMenu,skillMenu;
	private BorderPane fightUI;
	private StackPane fightButton;
	
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
		initializeSkillMenu();
	}
	private void initializeFightMenu() {
		fightMenu = new GridPane();
		//fightMenu.setBackground(new Background(new BackgroundFill(Color.AQUA,CornerRadii.EMPTY,Insets.EMPTY)));
		fightButton = new StackPane();
		//itemButton = new StackPane();
		fightButton.setPrefHeight(100);
		fightButton.setPrefWidth(250);
		//itemButton.setPrefHeight(100);
		//itemButton.setPrefWidth(250);
		fightButton.setBackground(new Background(new BackgroundFill(new ImagePattern(new Image("fightButton.png")),CornerRadii.EMPTY,Insets.EMPTY)));
		fightButton.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				// TODO Auto-generated method stub
				GameLogic.nextTurn();
			}

		});
		//itemButton.setBackground(new Background(new BackgroundFill(new ImagePattern(new Image("itemButton.png")),CornerRadii.EMPTY,Insets.EMPTY)));
		fightMenu.setAlignment(Pos.CENTER);
		fightMenu.add(fightButton, 0, 0);
		//fightMenu.add(itemButton, 1, 0);
		fightMenu.setHgap(50);
		fightUI.setRight(fightMenu);
		fightMenu.setPrefHeight(200);
		fightMenu.setPrefWidth(700);
		
	}
	public void initializeSkillMenu() {
		skillMenu =  new GridPane();
		skillMenu.setAlignment(Pos.CENTER);
		skillMenu.setHgap(100);
		skillMenu.setPrefHeight(200);
		skillMenu.setPrefWidth(700);
		if (GameLogic.currentChara instanceof Ally) {
			int i = 0;
			for (BaseSkill s: GameLogic.currentChara.getSkills()) {
				StackPane skillButton = new StackPane();
				skillButton.setMaxHeight(100);
				skillButton.setMaxWidth(100);
				Image skill = new Image(ClassLoader.getSystemResource(s.getSkillName() + ".png").toString());
				ImageView skillSquare = new ImageView(skill);
				skillSquare.setFitHeight(100);
				skillSquare.setFitWidth(100);
				skillButton.getChildren().add(skillSquare);
				skillButton.setOnMouseClicked(new EventHandler<Event>() {

					@Override
					public void handle(Event arg0) {
						// TODO Auto-generated method stub
						
						GameLogic.currentSkill = s;
						((TargetSelectable) s).selectTarget();
					}

				});
				skillMenu.add(skillButton, i, 0); i++;
			}
		}
		fightUI.setLeft(skillMenu);
	}
}
