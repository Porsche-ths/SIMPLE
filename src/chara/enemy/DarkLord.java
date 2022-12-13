package chara.enemy;

import java.util.PriorityQueue;

import chara.base.Ally;
import chara.base.Chara;
import chara.base.Enemy;
import logic.GameLogic;
import skill.enemy.SonicBlow;

public class DarkLord extends Enemy {

	public DarkLord(String name) {
		super(name, 80, 85, 8, 8, 0, 6, 8, 7, 100, 80, 80, 100);
		//getSkills().add(new ???(this));
		//getSkills().add(new ???(this));
		setClassName("darkLord");
	}
	
	@Override
	public void beginTurn() {
		atTurnStart();
		if (this.isAlive()) {
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
