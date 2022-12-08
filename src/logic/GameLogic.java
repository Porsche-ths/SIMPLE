package logic;

import java.util.ArrayList;
import java.util.PriorityQueue;

import Character.Chara;
import Skill.Skill;
import javafx.util.Pair;

public class GameLogic {
	
	private static ArrayList<Chara> team;
	private static ArrayList<Chara> villains;
	public static PriorityQueue<Pair<Integer, Chara>> q;
	
	public static void newGame() {
		// ? ? ? //
	}
	
	public static void beginRound() {
		/*
		 * Generate new queue
		 * set skillButton.isDisable
		 * */
		generateQueue();
		while(!q.isEmpty()) {
			Chara character = q.poll().getValue();
			for (Skill skill: character.getSkills()) {
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
			if (ally.isStunned()) {
				ally.setStunned(false);
			} else {
				ally.setQueueNum(randomRange(1, 8) + ally.getSpd());
				q.add(new Pair<Integer, Chara>(ally.getQueueNum(), ally));
			}
		}
		
		for (Chara enemy: villains) {
			if (enemy.isStunned()) {
				enemy.setStunned(false);
			} else {
				enemy.setQueueNum(randomRange(1, 8) + enemy.getSpd());
				q.add(new Pair<Integer, Chara>(enemy.getQueueNum(), enemy));
			}
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
