package chara.enemy;

import java.util.Comparator;
import java.util.PriorityQueue;

import chara.base.Ally;
import chara.base.Chara;
import chara.base.Enemy;
import logic.GameLogic;
import skill.enemy.BonySlash;

public class SkellySoldier extends Enemy {

	public SkellySoldier(String name) {
		super(name, 12, 25, 0, 0, 0, 2, 5, 1, 10, 300, 10, 15);
		getSkills().add(new BonySlash(this));
		setClassName("skellySoldier");
	}
	
	@Override
	public void beginTurn() {
		atTurnStart();
		if (this.isAlive()) {
			BonySlash bonySlash = (BonySlash) getSkills().get(0);
			bonySlash.setValid();
			if (bonySlash.isValid()) {
				PriorityQueue<Ally> targetQueue = new PriorityQueue<Ally>(2, new TargetPriorityComparator());
				for (Ally hero: GameLogic.team) {
					if (hero.getRank().equals(logic.rank.first) || hero.getRank().equals(logic.rank.second)) {
						int chance = ((hero.getMaxHp() - hero.getHp()) / hero.getMaxHp()) * 100;
						hero.setCalculatedSpd(chance + ((Ally) hero).getTargetPriority());
						targetQueue.add(hero);
					}
				}
				if (!targetQueue.isEmpty()) {
					Chara target = targetQueue.poll();
					getSkills().get(0).getTargets().add(target);
					getSkills().get(0).playAnimation();
					getSkills().get(0).cast();
				} else {
					GameLogic.nextTurn();
				}
			} else {
				GameLogic.nextTurn();
			}
		} else {
			GameLogic.nextTurn();
		}
		atTurnEnd();
	}

}

class TargetPriorityComparator implements Comparator<Ally> {

	@Override
	public int compare(Ally a1, Ally a2) {
		if (a1.getCalculatedPriority() < a1.getCalculatedPriority()) return 1;
		if (a1.getCalculatedPriority() > a1.getCalculatedPriority()) return -1;
		return 0;
	}
}