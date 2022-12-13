package chara.enemy;

import java.util.PriorityQueue;

import chara.base.Ally;
import chara.base.Chara;
import chara.base.Enemy;
import logic.GameLogic;
import skill.enemy.RavenousFeast;

public class Hemomancer extends Enemy {

	public Hemomancer(String name) {
		super(name, 20, 0, 23, 10, 0, 4, 7, 6, 55, 70, 70, 70);
		getSkills().add(new RavenousFeast(this));
		setClassName("hemomancer");
	}

	@Override
	public void beginTurn() {
		atTurnStart();
		RavenousFeast ravenousFeast = (RavenousFeast) getSkills().get(0);
		ravenousFeast.setValid();
		if (ravenousFeast.isValid()) {
			PriorityQueue<Ally> targetQueue = new PriorityQueue<Ally>(4, new TargetPriorityComparator());
			for (Ally hero: GameLogic.team) {
				int chance = ((hero.getMaxHp() - hero.getHp()) / hero.getMaxHp()) * 100;
				hero.setCalculatedSpd(chance + ((Ally) hero).getTargetPriority());
				targetQueue.add(hero);
			}
			Chara target = targetQueue.poll();
			getSkills().get(0).getTargets().add(target);
			getSkills().get(0).cast();
		}
		atTurnEnd();
		GameLogic.nextTurn();
	}
	
}
