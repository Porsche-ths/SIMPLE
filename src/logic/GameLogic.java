package logic;

import java.util.ArrayList;
import java.util.PriorityQueue;

import battle.gui.BattlePane;
import battle.gui.BattleStage;
import chara.base.Ally;
import chara.base.Chara;
import chara.base.Enemy;
import chara.enemy.SkellySoldier;
import javafx.util.Pair;
import skill.base.BaseSkill;

public class GameLogic {
	
	public static ArrayList<Ally> team;
	public static ArrayList<Enemy> enemies;
	public static ArrayList<ArrayList<Enemy>> villains;
	public static PriorityQueue<Pair<Integer, Chara>> q;
	private static boolean isGameEnd;
	public static boolean win;
	private static boolean isStageCleared;
	public static BattleStage currentStage;
	
	public static void newGame() {
		isGameEnd = false;
		addEnemiesToVillains();
		for (int i = 1; i <= 5 && !isGameEnd; i++) {

			beginStage(i);
		}
	}
	
	public static void endGame() {
		if (win) {
			//Alert "You Win !"
		} else {
			//Alert "You Lose . . ."
		}
		//RESTART
	}
	
	public static void beginStage(int i) {
		enemies = villains.get(i-1);
		currentStage = new BattleStage(i-1);
		while(!isGameEnd && !isStageCleared) {
			beginRound();
		}
		
		if (isStageCleared && i == 5) {
			setWin(true);
			setGameEnd(true);
		}
	}
	
	public static void beginRound() {
		/*
		 * Generate new queue
		 * set skillButton.isDisable
		 * */
		generateQueue();
		while(!isGameEnd && !isStageCleared && !q.isEmpty()) {
			Chara character = q.poll().getValue();
			if (character instanceof Ally) {
				for (BaseSkill skill: character.getSkills()) {
					skill.setValid();
					if (!skill.isValid()) { /* skillButton.isDisable */ }
				}
			}
			character.beginTurn();
		}
		
	}
	
	public static  void generateQueue() {
		/*
		 * random queue in each turn by calculating chara.spd
		 * if !isStunned add to q
		 * set this.q = new q
		 * */
		PriorityQueue<Pair<Integer, Chara>> q = new PriorityQueue<Pair<Integer, Chara>>();
		for (Chara ally: team) {
			ally.setQueueNum(randomRange(1, 8) + ally.getSpd());
			q.add(new Pair<Integer, Chara>(ally.getQueueNum(), ally));
		}
		
		for (Chara enemy: enemies) {
			enemy.setQueueNum(randomRange(1, 8) + enemy.getSpd());
			q.add(new Pair<Integer, Chara>(enemy.getQueueNum(), enemy));
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
		int d = 100/(a - b + 1);
		return (int) (randomInt()/d) + 1;
	}
	private static void addEnemiesToVillains() {
		villains = new ArrayList<ArrayList<Enemy>>();
		ArrayList<Enemy> stageOne = new ArrayList<Enemy>();
		stageOne.add(new SkellySoldier("Skelly1"));
		stageOne.add(new SkellySoldier("Skelly2"));
		
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
