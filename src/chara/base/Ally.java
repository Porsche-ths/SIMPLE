package chara.base;

import java.util.ArrayList;

import item.base.Equipable;
import logic.GameLogic;
import logic.rank;

public class Ally extends Chara{
	private ArrayList<Equipable> equipmentSlots;
	private int deathBlowResist;
	private String className;
	private int targetPriority, calculatedPriority;
	public Ally(String name, String className, int targetPriority, int maxHp, int accMod, int dodge, int crit, int prot, int minDmg, int maxDmg, int spd,
			 int stunResist, int deathBlowResist, int bleedResist, int decayResist,
			int debuffResist) {
		super(name, maxHp, accMod, dodge, crit, prot, minDmg, maxDmg, spd,  stunResist, bleedResist, decayResist, debuffResist);
		this.setClassName(className);
		this.setTargetPriority(targetPriority);
		this.setDeathBlowResist(deathBlowResist);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void beginTurn() {
		atTurnStart();
		if (!this.isAlive()) {
			atTurnEnd();
			GameLogic.nextTurn();
			return;
		}
		GameLogic.getCurrentStage().getBattlePane().initializeSkillMenu();
	}
	
	@Override
	public void checkStatus() {
		if (isAlive()) {
			if (getHp() == 0) {
				setAlive(false);
			}
		} else {
			if (getHp() > 0) {
				setAlive(true);
			} else {
				if (isDeathBlown()) {
					GameLogic.team.remove(this);
					if (GameLogic.q.contains(this)) { GameLogic.q.remove(this); }
					if (GameLogic.team.isEmpty()) {
						GameLogic.setGameEnd(true);
					} else {
						GameLogic.getCurrentStage().getStageCharaPane().getChildren().clear();
						GameLogic.getCurrentStage().getStageCharaPane().addCharToPane();
						int n = GameLogic.team.size() - 1;
						for (Ally a: GameLogic.team) {
							switch(n) {
							case 0:
								a.setRank(rank.first); break;
							case 1:
								a.setRank(rank.second); break;
							case 2:
								a.setRank(rank.third); break;
							case 3:
								a.setRank(rank.fourth); break;
							}
							n--;
						}
						for (Ally each: GameLogic.team) {
							GameLogic.getCurrentStage().getStageCharaPane().updateHpBar(each,100);
						}
						for(Chara e :GameLogic.enemies) {
							GameLogic.getCurrentStage().getStageCharaPane().updateHpBar(e, 100);
						}
					}
				} else {
					setDeathBlowResist(getDeathBlowResist() - 16);
				}
			}
			
		}
	}
	
	@Override
	public void setHp(int hp) {
		super.setHp(hp);
		checkStatus();
	}
	
	public boolean isDeathBlown() {
		int chance = 100 - this.getDeathBlowResist();
		return GameLogic.randomInt() < chance ? true : false;
	}
	
	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public int getTargetPriority() {
		return targetPriority;
	}

	public void setTargetPriority(int targetPriority) {
		this.targetPriority = targetPriority;
	}

	public ArrayList<Equipable> getEquipmentSlots() {
		return equipmentSlots;
	}

	public void setEquipmentSlots(ArrayList<Equipable> equipmentSlots) {
		this.equipmentSlots = equipmentSlots;
	}

	public int getDeathBlowResist() {
		return deathBlowResist;
	}

	public void setDeathBlowResist(int deathBlowResist) {
		this.deathBlowResist = deathBlowResist;
	}

	public int getCalculatedPriority() {
		return calculatedPriority;
	}

	public void setCalculatedPriority(int calculatedPriority) {
		this.calculatedPriority = calculatedPriority;
	}

}
