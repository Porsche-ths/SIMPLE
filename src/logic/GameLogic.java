package logic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

import app.Main;
import battle.gui.BattleStage;
import chara.base.Ally;
import chara.base.Chara;
import chara.base.Enemy;
import chara.enemy.Executioner;
import chara.enemy.Hemomancer;
import chara.enemy.SkellyArcher;
import chara.enemy.SkellySoldier;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import skill.base.BaseSkill;
import javafx.scene.control.Alert.AlertType;

public class GameLogic {
	
	public static ArrayList<Ally> team;
	public static ArrayList<Enemy> enemies;
	public static ArrayList<ArrayList<Enemy>> villains;
	public static PriorityQueue<Chara> q;
	public static int stage;
	private static boolean isGameEnd;
	public static boolean win;
	private static boolean isStageCleared;
	public static BattleStage currentStage;
	public static Chara currentChara;
	public static BaseSkill currentSkill;
	
	public static void newGame() {
		isStageCleared = false;
		isGameEnd = false;
		win = false;
		addEnemiesToVillains();
		stage = 1;
		beginStage(stage);
	}
	
	public static void endGame() {
		
		Alert alert = new Alert(AlertType.INFORMATION, "Do you want to restart ?", ButtonType.YES, ButtonType.NO);
		if (win) {
			alert.setTitle("Congratulations !");
			alert.setHeaderText("You win :)");
		} else {
			alert.setTitle("Sorry");
			alert.setHeaderText("You lose :(");
		}
		alert.showAndWait();
		
		if (alert.getResult() == ButtonType.YES) {
			team = new ArrayList<Ally>();
			Main.charSelect.resetSelectedChara();
			Main.switchToMainMenu();
		} else {
			Platform.exit();
		}
	}
	
	public static void beginStage(int i) {
		StackPane trans = createStageTrans(i);
		Scene root = new Scene(trans);
		Main.stage.setScene(root);
		AnimationTimer timer = new AnimationTimer() {
			int time = 0;
			@Override
			public void handle(long arg0) {
				// TODO Auto-generated method stub
				time += 1;
				if(time == 100) {
					enemies = villains.get(i-1);
					currentStage = new BattleStage(i-1);
					Scene stageScene = new Scene(GameLogic.getCurrentStage().getBattlePane());
					for (Ally each: team) {
						GameLogic.getCurrentStage().getStageCharaPane().updateHpBar(each,100);
					}
					for (Enemy each: enemies) {
						GameLogic.getCurrentStage().getStageCharaPane().updateHpBar(each,100);
					}
					Main.stage.setScene(stageScene);
					generateQueue();
					nextTurn();
				}
			}
			
		};
		timer.start();
		
		
	}
	
	public static void nextTurn() {
		
		if (isGameEnd) {
			endGame();
		} else if (isStageCleared) {
			if (stage == 5) {
				setGameEnd(true);
				setWin(true);
				endGame();
			} else {
				isStageCleared = false;
				stage++;
				System.out.println("=============================================");
				System.out.println("Begin Stage " + stage);
				System.out.println("=============================================");
				beginStage(stage);
			}
		} else {
			if (q.isEmpty()) generateQueue();
			currentChara = q.poll();
			if(currentChara instanceof Ally) {
				GameLogic.getCurrentStage().getBattlePane().enableSkillMenu();
			}
			else {
				GameLogic.getCurrentStage().getBattlePane().disableSkillMenu();

			}
			System.out.println("-----------------------------------------\n");
			System.out.println("Current Turn : " + currentChara.getName());
			currentChara.beginTurn();
		}
		
	}
	
	public static  void generateQueue() {
		/*
		 * random queue in each turn by calculating chara.spd
		 * if !isStunned add to q
		 * set this.q = new q
		 * */
		PriorityQueue<Chara> q = new PriorityQueue<Chara>(8, new SpeedComparator());
		for (Chara ally: team) {
			ally.setCalculatedSpd(randomRange(1, 8) + ally.getSpd());
			q.add(ally);
		}
		
		for (Chara enemy: enemies) {
			enemy.setCalculatedSpd(randomRange(1, 8) + enemy.getSpd());
			q.add(enemy);
		}
		GameLogic.q = q;
		
	}
	
	public static int randomInt() {
		//random integer less than 100
		double randNumber = Math.random();
		return (int) (randNumber * 100);

	}
	
	public static int randomRange(int a, int b) {
		//random int from a to b *include both a and b*
		int d = (b - a + 1);
		return (int) (Math.random() * d) + a;
	}
	
	private static void addEnemiesToVillains() {
		villains = new ArrayList<ArrayList<Enemy>>();
		ArrayList<Enemy> stageOne = new ArrayList<Enemy>();
		SkellySoldier s11 = new SkellySoldier("Soldier11");
		s11.setRank(rank.first);
		SkellySoldier s12 = new SkellySoldier("Soldier12");
		s12.setRank(rank.second);
		stageOne.add(s11);
		stageOne.add(s12);

		
		ArrayList<Enemy> stageTwo = new ArrayList<Enemy>();
		SkellySoldier s21 = new SkellySoldier("Soldier21");
		s21.setRank(rank.first);
		SkellySoldier s22 = new SkellySoldier("Soldier22");
		s22.setRank(rank.second);
		SkellyArcher a21 = new SkellyArcher("Archer21");
		a21.setRank(rank.third);
		SkellyArcher a22 = new SkellyArcher("Archer22");
		a22.setRank(rank.fourth);
		stageTwo.add(s21);
		stageTwo.add(s22);
		stageTwo.add(a21);
		stageTwo.add(a22);
		
		ArrayList<Enemy> stageThree = new ArrayList<Enemy>();
		Executioner e31 = new Executioner("Executioner31");
		e31.setRank(rank.first);
		Hemomancer h31 = new Hemomancer("Hemomancer31");
		h31.setRank(rank.second);
		stageThree.add(e31);
		stageThree.add(h31);
		
		ArrayList<Enemy> stageFour = new ArrayList<Enemy>();
		Executioner e41 = new Executioner("Executioner41");
		e41.setRank(rank.first);
		Hemomancer h41 = new Hemomancer("Hemomancer41");
		h41.setRank(rank.second);
		SkellyArcher a41 = new SkellyArcher("Archer41");
		a41.setRank(rank.third);
		SkellyArcher a42 = new SkellyArcher("Archer42");
		a42.setRank(rank.fourth);
		stageFour.add(e41);
		stageFour.add(h41);
		stageFour.add(a41);
		stageFour.add(a42);

		villains.add(stageOne);
		villains.add(stageTwo);
		villains.add(stageThree);
		villains.add(stageFour);
	}
	

	public static void setGameEnd(boolean isGameEnd) {
		GameLogic.isGameEnd = isGameEnd;
	}
	
	public static void setStageCleared(boolean isStageCleared) {
		GameLogic.isStageCleared = isStageCleared;
	}
	
	public static void setWin(boolean win) {
		GameLogic.win = win;
	}

	public static ArrayList<Ally> getTeam() {
		return team;
	}

	public static void setTeam(ArrayList<Ally> team) {
		GameLogic.team = team;
	}

	public static ArrayList<ArrayList<Enemy>> getVillains() {
		return villains;
	}

	public static void setVillains(ArrayList<ArrayList<Enemy>> villains) {
		GameLogic.villains = villains;
	}

	public static BattleStage getCurrentStage() {
		return currentStage;
	}

	public static void setCurrentStage(BattleStage currentStage) {
		GameLogic.currentStage = currentStage;
	}
	public static StackPane createStageTrans(int i) {
    	StackPane s = new StackPane();
    	s.setPrefWidth(1400);
    	s.setPrefHeight(680);
    	s.setBackground(new Background(new BackgroundFill(Color.BLACK,CornerRadii.EMPTY,Insets.EMPTY)));
		Font font = Font.loadFont(ClassLoader.getSystemResourceAsStream("MINECRAFT_FONT.TTF"), 80);
		s.setAlignment(Pos.CENTER);
		Text t = new Text("STAGE " + i);
		t.setFill(Color.WHITE);
		t.setFont(font);
		s.getChildren().add(t);

    	return s;
    }

}

class SpeedComparator implements Comparator<Chara>{
    
    @Override
    public int compare(Chara c1, Chara c2) {
        if (c1.getCalculatedSpd() < c2.getCalculatedSpd()) return 1;
        if (c1.getCalculatedSpd() > c2.getCalculatedSpd()) return -1;
        return 0;
    }
    
}