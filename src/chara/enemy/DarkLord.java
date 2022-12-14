package chara.enemy;

import java.util.ArrayList;

import chara.base.Ally;
import chara.base.Enemy;
import javafx.util.Pair;
import logic.GameLogic;
import skill.enemy.DarkBolt;

public class DarkLord extends Enemy {

	public DarkLord(String name) {
		super(name, 80, 85, 8, 8, 0, 6, 8, 7, 100, 80, 80, 100);
		getSkills().add(new DarkBolt(this));
		setClassName("darkLord");
	}
	
	@Override
	public void beginTurn() {
		atTurnStart();
		int size = GameLogic.team.size();
		
		if (size != 0) {
			ArrayList<Pair<Ally, Double>> targetList = new ArrayList<Pair<Ally, Double>>(size);
			
			double mod = 100/size;
			for (Ally hero: GameLogic.team) {
				targetList.add(new Pair<Ally, Double>(hero, mod));
			}
			
			for (int i = 0; i < size; i++) {
				Ally ally = targetList.get(i).getKey();
				for (int j = 0; j < size; j++) {
					if (targetList.get(j).getKey().equals(ally)) {
						targetList.set(j, new Pair<Ally, Double>(targetList.get(j).getKey(), targetList.get(j).getValue() + ((double) ally.getTargetPriority())));
					} else {
						targetList.set(j, new Pair<Ally, Double>(targetList.get(j).getKey(), targetList.get(j).getValue() - (((double) ally.getTargetPriority())/(size-1))));
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
						targetList.set(j, new Pair<Ally, Double>(targetList.get(j).getKey(), targetList.get(j).getValue() - (chance/(size-1))));
					}
				}
			}
			
			for (int i = 0; i < size; i++) {
				System.out.println(targetList.get(i).getKey() + " chance to be hit : " + targetList.get(i).getValue());
			}
			
			int result = GameLogic.randomInt();
			System.out.println("result = " + result);
			int check = 0;
			for (int i = 0; i < size; i++) {
				check += targetList.get(i).getValue();
				if (result <= check) {
					getSkills().get(0).getTargets().add(targetList.get(i).getKey());
					break;
				}
			}
			
			getSkills().get(0).playAnimation();
			getSkills().get(0).cast();
		} else {
			GameLogic.nextTurn();
		}
		atTurnEnd();
	}

}
