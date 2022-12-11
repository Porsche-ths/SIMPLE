package charaselect.gui;

import java.util.ArrayList;


import app.Main;
import chara.ally.Crusader;
import chara.ally.Priest;
import chara.ally.Ranger;
import chara.ally.Rogue;
import chara.base.Ally;
import chara.base.Chara;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import logic.GameLogic;

// TODO LIST: ADD SWITCH TO MAP
//			  ADD STAT
public class CharSelect extends StackPane {
	private HBox statBox;
	private GridPane selectedCharaBox;
	private HBox selectableCharaBox;
	private StackPane crusaderBox,rangerBox,priestBox,rogueBox;
	private ImageView resetButton,confirmButton,backButton;
	private HBox buttonPanel;
	//private StackPane selectedCrusader,selectedRanger,selectedPriest,selectedRogue;

	public CharSelect() {
		GameLogic.setTeam(new ArrayList<Chara>());
		setPrefWidth(1400);
		setPrefHeight(680);
		setAlignment(Pos.CENTER);
		Image textImg = new Image("heroesSelectText.png");
		ImageView text = new ImageView(textImg);
		getChildren().add(text);
		setAlignment(text,Pos.TOP_CENTER);
		Image bg = new Image("charSelectBG.png");
		setBackground(new Background(new BackgroundFill(new ImagePattern(bg),CornerRadii.EMPTY, Insets.EMPTY)));

		
		addSelectedCharaBox();
		addStatBox();
		addSelectableCharaBox();
		addOnMouseClicked();
//		=======================Button Panel=======================
		buttonPanel = new HBox();
		getChildren().add(buttonPanel);
		buttonPanel.setPadding(new Insets(0,0,50,0));
		buttonPanel.setSpacing(50);;
		buttonPanel.setMaxHeight(10);
		buttonPanel.setMaxWidth(800);
		buttonPanel.setAlignment(Pos.CENTER);
		setAlignment(buttonPanel,Pos.BOTTOM_CENTER);
		addBackButton();
		addResetButton();
		addConfirmButton();
		resetSelectedChara();

		statBox.setVisible(false);



	}
	private void addSelectableCharaBox() {
		selectableCharaBox = new HBox();
		selectableCharaBox.setMaxWidth(400);
		selectableCharaBox.setMaxHeight(400);
		selectableCharaBox.setSpacing(30);
//		============Crusader Box==============
		crusaderBox = new StackPane();
		crusaderBox.setMaxHeight(120);
		crusaderBox.setMaxWidth(120);
		Image crusader = new Image("crusaderBox.png");
		ImageView crusaderSquare = new ImageView(crusader);
		crusaderSquare.setFitHeight(120);
		crusaderSquare.setFitWidth(120);
		crusaderBox.getChildren().add(crusaderSquare);
		selectableCharaBox.getChildren().add(crusaderBox);
//		============Priest Box=================
		priestBox = new StackPane();
		priestBox.setMaxHeight(120);
		priestBox.setMaxWidth(120);
		Image priest = new Image("priestBox.png");
		ImageView priestSquare = new ImageView(priest);
		priestSquare.setFitHeight(120);
		priestSquare.setFitWidth(120);
		priestBox.getChildren().add(priestSquare);
		selectableCharaBox.getChildren().add(priestBox);
////		============Ranger Box=================
		rangerBox = new StackPane();
		rangerBox.setMaxHeight(120);
		rangerBox.setMaxWidth(120);
		Image ranger = new Image("rangerBox.png");
		ImageView rangerSquare = new ImageView(ranger);
		rangerSquare.setFitHeight(120);
		rangerSquare.setFitWidth(120);
		rangerBox.getChildren().add(rangerSquare);
		selectableCharaBox.getChildren().add(rangerBox);
////		============Rogue Box=================
		rogueBox = new StackPane();
		rogueBox.setMaxHeight(120);
		rogueBox.setMaxWidth(120);
		Image rogue = new Image("rogueBox.png");
		ImageView rogueSquare = new ImageView(rogue);
		rogueSquare.setFitHeight(120);
		rogueSquare.setFitWidth(120);
		selectableCharaBox.getChildren().add(rogueBox);
		rogueBox.getChildren().add(rogueSquare);
		getChildren().add(selectableCharaBox);
		setAlignment(selectableCharaBox,Pos.BOTTOM_CENTER);
		
		
		
	}
	private void addSelectedCharaBox() {
		selectedCharaBox = new GridPane() ;
		selectedCharaBox.setMaxWidth(800);
		selectedCharaBox.setMaxHeight(400);
		selectedCharaBox.setHgap(30);
		selectedCharaBox.setAlignment(Pos.TOP_CENTER);
		getChildren().add(selectedCharaBox);
	}
	private void addStatBox() {
		statBox = new HBox();
		statBox.setMaxWidth(360);
		statBox.setMaxHeight(450);
		statBox.setSpacing(50);
		statBox.setAlignment(Pos.CENTER);
		VBox row1 = new VBox();
		VBox row2 = new VBox();
		row1.setMaxWidth(100);
		row1.setMaxHeight(500);
		row2.setMaxWidth(100);
		row2.setMaxHeight(500);
		Image statImg = new Image("statBox.png");
		statBox.setBackground(new Background(new BackgroundFill(new ImagePattern(statImg),CornerRadii.EMPTY, Insets.EMPTY)));
		row1.setBackground(new Background(new BackgroundFill(Color.BLACK,CornerRadii.EMPTY, Insets.EMPTY)));
		row2.setBackground(new Background(new BackgroundFill(Color.WHITE,CornerRadii.EMPTY, Insets.EMPTY)));
		statBox.getChildren().add(row1);
		statBox.getChildren().add(row2);
		getChildren().add(statBox);
		setAlignment(statBox,Pos.BOTTOM_RIGHT);
	}
	private void addOnMouseClicked() {
		crusaderBox.setOnMouseClicked(new EventHandler <Event>() {
			@Override
			public void handle(Event arg0) {
				// TODO Auto-generated method stub
				charaBoxHandler("crusader",new Crusader(Integer.toString(GameLogic.getTeam().size())));
			}
			
		});
		priestBox.setOnMouseClicked(new EventHandler <Event>() {
			@Override
			public void handle(Event arg0) {
				// TODO Auto-generated method stub
				charaBoxHandler("priest",new Priest(Integer.toString(GameLogic.getTeam().size())));
			}
			
		});
		rangerBox.setOnMouseClicked(new EventHandler <Event>() {
			@Override
			public void handle(Event arg0) {
				// TODO Auto-generated method stub
				charaBoxHandler("ranger",new Ranger(Integer.toString(GameLogic.getTeam().size())));
			}
			
		});
		rogueBox.setOnMouseClicked(new EventHandler <Event>() {
			@Override
			public void handle(Event arg0) {
				// TODO Auto-generated method stub
				charaBoxHandler("rogue",new Rogue(Integer.toString(GameLogic.getTeam().size())));
			}
			
		});
		
	}
	private StackPane createClassBox(String className) {
		StackPane classBox = new StackPane();
		classBox.setMaxHeight(120);
		classBox.setMaxWidth(120);
		Image classImg = new Image(className + "Box.png");
		ImageView classSquare = new ImageView(classImg);
		classSquare.setFitHeight(120);
		classSquare.setFitWidth(120);
		classBox.getChildren().add(classSquare);
		return classBox;
	}
	private void resetSelectedChara() {
		for(int i = 0;i<4;i++) {
			StackPane box = new StackPane();
			box.setMaxHeight(120);
			box.setMaxWidth(120);
			Image charaBox = new Image("charaBox.png");
			ImageView emptyBox = new ImageView(charaBox);
			emptyBox.setFitHeight(120);
			emptyBox.setFitWidth(120);
			box.getChildren().add(emptyBox);
			selectedCharaBox.add(box,i,0);
		}
		GameLogic.getTeam().clear();
		disableConfirmButton();
		
	}
	private void charaBoxHandler(String className,Ally a) {
		int n = GameLogic.getTeam().size();
		if(n<4) {
			enableConfirmButton();
			GameLogic.getTeam().add(a);
			selectedCharaBox.add(createClassBox(className),n,0);
			
			
			for(int i = 0;i<n+1;i++) {
				System.out.println(GameLogic.getTeam().get(i).getName());
			}
			
			}
		else {
			resetSelectedChara();
		}
		
	}
	private void addBackButton() {
		
		Image inactivatedBack = new Image("inactivatedBack.png");
		Image activatedBack = new Image("activatedBack.png");
		backButton = new ImageView(inactivatedBack);
		backButton.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				// TODO Auto-generated method stub
				Thread t = new Thread(new Runnable() {

					@Override
					public void run() {
						// TODO Auto-generated method stub
						Platform.runLater(new Runnable() {

							@Override
							public void run() {
								// TODO Auto-generated method stub
								backButton.setImage(activatedBack);
							}
							
						});
						try {
							Thread.sleep(250);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						Platform.runLater(new Runnable() {

							@Override
							public void run() {
								// TODO Auto-generated method stub
								Main.switchToMainMenu();
							}
							
						});

					}
					
				});
				t.start();

			}
			
		});
		buttonPanel.getChildren().add(backButton);
		
	}
	private void addResetButton() {

		
		Image inactivatedReset = new Image("inactivatedReset.png");
		Image activatedReset = new Image("activatedReset.png");
		resetButton = new ImageView(inactivatedReset);
		resetButton.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				// TODO Auto-generated method stub
				Thread t = new Thread(new Runnable() {

					@Override
					public void run() {
						// TODO Auto-generated method stub
						Platform.runLater(new Runnable() {

							@Override
							public void run() {
								// TODO Auto-generated method stub
								resetButton.setImage(activatedReset);
							}
							
						});
						try {
							Thread.sleep(250);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						Platform.runLater(new Runnable() {

							@Override
							public void run() {
								// TODO Auto-generated method stub
								resetSelectedChara();
								resetButton.setImage(inactivatedReset);

							}
							
						});

					}
					
				});
				t.start();

			}
			
		});
		buttonPanel.getChildren().add(resetButton);
		
	}
private void addConfirmButton() {
		Image inactivatedConfirm = new Image("inactivatedConfirm.png");
		Image activatedConfirm = new Image("activatedConfirm.png");
		confirmButton = new ImageView(inactivatedConfirm);
		confirmButton.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				// TODO Auto-generated method stub
				Thread t = new Thread(new Runnable() {

					@Override
					public void run() {
						// TODO Auto-generated method stub
						Platform.runLater(new Runnable() {

							@Override
							public void run() {
								// TODO Auto-generated method stub
								confirmButton.setImage(activatedConfirm);
							}
							
						});
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						Platform.runLater(new Runnable() {

							@Override
							public void run() {
								// TODO Auto-generated method stub
								confirmButton.setImage(inactivatedConfirm);

							}
							
						});

					}
					
				});
				t.start();

			}
			
		});
		buttonPanel.getChildren().add(confirmButton);
		
	}
	private void disableConfirmButton() {
		Image disabledConfirm = new Image("disabledConfirm.png");
		confirmButton.setDisable(true);
		confirmButton.setImage(disabledConfirm);
		
	}
	private void enableConfirmButton() {
		Image inactivatedConfirm = new Image("inactivatedConfirm.png");
		confirmButton.setDisable(false);
		confirmButton.setImage(inactivatedConfirm);
		
	}
	
}
