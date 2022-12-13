package chara.enemy;

import java.util.PriorityQueue;

import chara.base.Ally;
import chara.base.Chara;
import chara.base.Enemy;
import logic.GameLogic;
import skill.enemy.BonyShot;

public class SkellyArcher extends Enemy {

	public SkellyArcher(String name) {
		super(name, 15, 82, 5, 12, 0, 3, 7, 5, 10, 200, 10, 15);
		getSkills().add(new BonyShot(this));
		setClassName("skellyArcher");
	}
	
	@Override
	public void beginTurn() {
		atTurnStart();
		if (this.isAlive()) {
			BonyShot bonyShot = (BonyShot) getSkills().get(0);
			bonyShot.setValid();
			if (bonyShot.isValid()) {
				PriorityQueue<Ally> targetQueue = new PriorityQueue<Ally>(3, new TargetPriorityComparator());
				for (Ally hero: GameLogic.team) {
					if (hero.getRank().equals(logic.rank.second) || hero.getRank().equals(logic.rank.third) || hero.getRank().equals(logic.rank.fourth)) {
						int chance = ((hero.getMaxHp() - hero.getHp()) / hero.getMaxHp()) * 100;
						hero.setCalculatedSpd(chance + ((Ally) hero).getTargetPriority());
						targetQueue.add(hero);
					}
				}
				if (!targetQueue.isEmpty()) {
					Chara target = targetQueue.poll();
					getSkills().get(0).getTargets().add(target);
					getSkills().get(0).cast();
				}
			}
		}
		atTurnEnd();
		GameLogic.nextTurn();
	}

}
