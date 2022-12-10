package logic;

import java.util.ArrayList;
import java.util.PriorityQueue;

import chara.base.Ally;
import chara.base.Chara;
import javafx.util.Pair;
import skill.base.BaseSkill;

public class GameLogic {
	
	public static ArrayList<Chara> team;
	public static ArrayList<Chara> enemies;
	public static ArrayList<ArrayList<Chara>> villains;
	public static PriorityQueue<Pair<Integer, Chara>> q;
	private static boolean isGameEnd;
	public static boolean win;
	private static boolean isStageCleared;
	
	public static void newGame() {
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
	
	public static void generateQueue() {
		/*
		 * random queue in each turn by calculating chara.spd
		 * if !isStunned add to q
		 * set this.q = new q
		 * */
		for (Chara ally: team) {
			ally.setQueueNum(randomRange(1, 8) + ally.getSpd());
			q.add(new Pair<Integer, Chara>(ally.getQueueNum(), ally));
		}
		
		for (Chara enemy: enemies) {
			enemy.setQueueNum(randomRange(1, 8) + enemy.getSpd());
			q.add(new Pair<Integer, Chara>(enemy.getQueueNum(), enemy));
		}
		
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
	

	public static void setGameEnd(boolean isGameEnd) {
		GameLogic.isGameEnd = isGameEnd;
	}
	
	public static void setStageCleared(boolean isStageCleared) {
		GameLogic.isStageCleared = isStageCleared;
	}
	
	public static void setWin(boolean win) {
		GameLogic.win = win;
	}

	public static ArrayList<Chara> getTeam() {
		return team;
	}

	public static void setTeam(ArrayList<Chara> team) {
		GameLogic.team = team;
	}

	public static ArrayList<ArrayList<Chara>> getVillains() {
		return villains;
	}

	public static void setVillains(ArrayList<ArrayList<Chara>> villains) {
		GameLogic.villains = villains;
	}
	
	

}
