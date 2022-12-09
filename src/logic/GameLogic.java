package logic;

import java.util.ArrayList;
import java.util.PriorityQueue;

import chara.base.Chara;
import javafx.util.Pair;
import skill.base.BaseSkill;

public class GameLogic {
	
	public static ArrayList<Chara> team;
	public static ArrayList<Chara> enemies;
	public static ArrayList<ArrayList<Chara>> villains;
	public static PriorityQueue<Pair<Integer, Chara>> q;
	
	public static void newGame() {
		// ? ? ? //
	}
	
	public static void beginStage() {
		
	}
	
	public static void beginRound() {
		/*
		 * Generate new queue
		 * set skillButton.isDisable
		 * */
		generateQueue();
		while(!q.isEmpty()) {
			Chara character = q.poll().getValue();
			for (BaseSkill skill: character.getSkills()) {
				skill.setValid();
				if (skill.isValid()) { /* skillButton.isDisable */ }
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
	
}
