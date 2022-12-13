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
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
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
	public static boolean isAction;
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
			alert.setTitle("Congratulations");
			alert.setHeaderText("You win :)");
		} else {
			alert.setTitle("Sorry");
			alert.setHeaderText("You lose :(");
		}
		alert.showAndWait();
		
		if (alert.getResult() == ButtonType.YES) {
			team = new ArrayList<Ally>();
			Main.switchToMainMenu();
		} else if (alert.getResult() == ButtonType.NO) {
			Platform.exit();
		}
	}
	
	public static void beginStage(int i) {

		enemies = villains.get(i-1);
		currentStage = new BattleStage(i-1);
		Scene stageScene = new Scene(GameLogic.getCurrentStage().getBattlePane());
		Main.stage.setScene(stageScene);
		generateQueue();
		nextTurn();
		
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
				beginStage(stage);
			}
		} else {
			if (q.isEmpty()) generateQueue();
			currentChara = q.poll();
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
//		SkellySoldier s1 = new SkellySoldier("Skelly1");
//		s1.setRank(rank.first);
		SkellySoldier s2 = new SkellySoldier("Skelly2");
		s2.setRank(rank.second);
//		SkellyArcher s3 = new SkellyArcher("Skelly3");
//		s3.setRank(rank.third);
		Executioner e1 = new Executioner("Executioner1");
		e1.setRank(rank.first);
		Hemomancer h3 = new Hemomancer("Hemomancer1");
		h3.setRank(rank.third);
		SkellyArcher s4 = new SkellyArcher("Skelly4");
		s4.setRank(rank.fourth);
		stageOne.add(e1);
		stageOne.add(s2);
		stageOne.add(h3);
		stageOne.add(s4);
		
		ArrayList<Enemy> stageTwo = new ArrayList<Enemy>();
		stageTwo.add(new SkellySoldier("Skelly1"));
		stageTwo.add(new SkellySoldier("Skelly2"));


		villains.add(stageOne);
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

}

class SpeedComparator implements Comparator<Chara>{
    
    @Override
    public int compare(Chara c1, Chara c2) {
        if (c1.getCalculatedSpd() < c2.getCalculatedSpd()) return 1;
        if (c1.getCalculatedSpd() > c2.getCalculatedSpd()) return -1;
        return 0;
    }
}