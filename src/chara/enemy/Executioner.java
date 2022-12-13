package chara.enemy;

import java.util.PriorityQueue;

import chara.base.Ally;
import chara.base.Chara;
import chara.base.Enemy;
import logic.GameLogic;
import skill.enemy.SonicBlow;

public class Executioner extends Enemy {

	public Executioner(String name) {
		super(name, 22, 82, 10, 5, 25, 3, 5, 1, 50, 80, 50, 15);
		getSkills().add(new SonicBlow(this));
		setClassName("executioner");
	}

	@Override
	public void beginTurn() {
		atTurnStart();
		SonicBlow sonicBlow = (SonicBlow) getSkills().get(0);
		sonicBlow.setValid();
		if (sonicBlow.isValid()) {
			PriorityQueue<Ally> targetQueue = new PriorityQueue<Ally>(4, new TargetPriorityComparator());
			for (Ally hero: GameLogic.team) {
				if (hero.getRank().equals(logic.rank.first) || hero.getRank().equals(logic.rank.second)) {
					int chance = ((hero.getMaxHp() - hero.getHp()) / hero.getMaxHp()) * 100;
					hero.setCalculatedSpd(chance + ((Ally) hero).getTargetPriority());
					targetQueue.add(hero);
				}
			}
			Chara target = targetQueue.poll();
			getSkills().get(0).getTargets().add(target);
			getSkills().get(0).cast();
		}
		atTurnEnd();
		GameLogic.nextTurn();
	}
	
}
