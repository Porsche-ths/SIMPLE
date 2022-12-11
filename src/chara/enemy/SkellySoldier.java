package chara.enemy;

import java.util.PriorityQueue;

import chara.base.Ally;
import chara.base.Chara;
import chara.base.Enemy;
import javafx.util.Pair;
import logic.GameLogic;
import skill.enemy.BonySlash;

public class SkellySoldier extends Enemy {

	public SkellySoldier(String name) {
		//super(name, maxHp, accMod, dodge, crit, prot, minDmg, maxDmg, spd, stunResist, bleedResist, decayResist, debuffResist);
		super(name, 12, 25, 0, 0, 0, 2, 5, 1, 10, 300, 10, 15);
		getSkills().add(new BonySlash(this));
		setClassName("skellySoldier");
	}
	
	@Override
	public void beginTurn() {
		atTurnStart();
		PriorityQueue<Pair<Integer, Chara>> targetQueue = null;
		for (Chara hero: GameLogic.team) {
			if (hero.getRank() == logic.rank.first || hero.getRank() == logic.rank.second) {
				int chance = ((hero.getMaxHp() - hero.getHp()) / hero.getMaxHp()) * 100;
				chance += ((Ally) hero).getTargetPriority();
				targetQueue.add(new Pair<Integer, Chara>(chance, hero));
			}
		}
		Chara target = targetQueue.poll().getValue();
		getSkills().get(0).getTargets().add(target);
		getSkills().get(0).cast();
		atTurnEnd();
	}

}
