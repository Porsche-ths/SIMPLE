package chara.enemy;

import java.util.ArrayList;

import chara.base.Ally;
import chara.base.Enemy;
import javafx.util.Pair;
import logic.GameLogic;
import skill.enemy.BonySlash;

public class SkellySoldier extends Enemy {

	public SkellySoldier(String name) {
		super(name, "skellySoldier", 12, 25, 0, 0, 0, 2, 5, 1);
		getSkills().add(new BonySlash(this));
	}
	
	@Override
	public void beginTurn() {
		if (this.isAlive()) {
			BonySlash bonySlash = (BonySlash) getSkills().get(0);
			bonySlash.setValid();
			if (bonySlash.isValid()) {
				int size = 0;
				
				for (Ally hero: GameLogic.team) {
					if (hero.getRank().equals(logic.rank.first) || hero.getRank().equals(logic.rank.second)) size++;
				}
				
				if (size != 0) {
					ArrayList<Pair<Ally, Double>> targetList = new ArrayList<Pair<Ally, Double>>(size);
					
					double mod = 100/size;
					for (Ally hero: GameLogic.team) {
						if (hero.getRank().equals(logic.rank.first) || hero.getRank().equals(logic.rank.second)) {
							targetList.add(new Pair<Ally, Double>(hero, mod));
						}
					}
					
					for (int i = 0; i < size; i++) {
						Ally ally = targetList.get(i).getKey();
						for (int j = 0; j < size; j++) {
							if (targetList.get(j).getKey().equals(ally)) {
								targetList.set(j, new Pair<Ally, Double>(targetList.get(j).getKey(), targetList.get(j).getValue() + ((double) ally.getTargetPriority())));
							} else {
								targetList.set(j, new Pair<Ally, Double>(targetList.get(j).getKey(), targetList.get(j).getValue() - (((double) ally.getTargetPriority())/((double) (size-1)))));
							}
						}
					}
					
					for (int i = 0; i < size; i++) {
						Ally ally = targetList.get(i).getKey();
						double chance = ( ((double) (ally.getMaxHp() - ally.getHp())) / ((double) ally.getMaxHp()) ) * mod;
						for (int j = 0; j < size; j++) {
							if (targetList.get(j).getKey().equals(ally)) {
								targetList.set(j, new Pair<Ally, Double>(targetList.get(j).getKey(), targetList.get(j).getValue() + chance));
							} else {
								targetList.set(j, new Pair<Ally, Double>(targetList.get(j).getKey(), targetList.get(j).getValue() - (chance/((double) (size-1)))));
							}
						}
					}
					
					for (int i = 0; i < size; i++) {
						System.out.println(targetList.get(i).getKey() + " chance to be hit : " + targetList.get(i).getValue());
					}
					
					//int result = GameLogic.randomInt();
					int result = 99;
					System.out.println("result = " + result);
					int check = 0;
					for (int i = 0; i < size; i++) {
						check += targetList.get(i).getValue();
						System.out.println("check" + i + " = " + check);
						if (result < check) {
							getSkills().get(0).getTargets().add(targetList.get(i).getKey());
							break;
						} else if (i == size - 1) {
							getSkills().get(0).getTargets().add(targetList.get(i).getKey());
							break;
						}
					}
					
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
	}

}