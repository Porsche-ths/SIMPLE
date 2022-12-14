package chara.base;

import logic.GameLogic;
import logic.rank;

public class Enemy extends Chara {
	private String className;
	public Enemy(String name, int maxHp, int accMod, int dodge, int crit, int prot, int minDmg, int maxDmg, int spd,
			 int stunResist, int bleedResist, int decayResist,
			int debuffResist) {
		super(name, maxHp, accMod, dodge, crit, prot, minDmg, maxDmg, spd,  stunResist, bleedResist,
				decayResist, debuffResist);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void beginTurn() {
		// TODO Auto-generated method stub
	}

	@Override
	public void checkStatus() {
		if (isAlive()) {
			if (getHp() == 0) {
				setAlive(false);
				super.setHp(10);
				setDodge(0);
				setProt(0);
				setMaxHp(10);
				GameLogic.getCurrentStage().getStageCharaPane().getChildren().clear();
				GameLogic.getCurrentStage().getStageCharaPane().addCharToPane();
				for(Chara e :GameLogic.team) {
					GameLogic.getCurrentStage().getStageCharaPane().updateHpBar(e, 100);
				}
				for(Chara e :GameLogic.enemies) {
					GameLogic.getCurrentStage().getStageCharaPane().updateHpBar(e, 100);
				}
				boolean allDead = true;
				for (Enemy e: GameLogic.enemies) {
					if (e.isAlive()) {
						allDead = false;
						break;
					}
				}
				if (allDead) {
					GameLogic.setStageCleared(true);
				}
			}
		} else {
			if (getHp() == 0) {
				GameLogic.enemies.remove(this);
				if (GameLogic.q.contains(this)) { GameLogic.q.remove(this); }
				if (GameLogic.enemies.isEmpty()) {
					GameLogic.setStageCleared(true);
				} else {
					GameLogic.getCurrentStage().getStageCharaPane().getChildren().clear();
					GameLogic.getCurrentStage().getStageCharaPane().addCharToPane();
					int n = 0;
					for (Enemy e: GameLogic.enemies) {
						switch(n) {
						case 0:
							e.setRank(rank.first); break;
						case 1:
							e.setRank(rank.second); break;
						case 2:
							e.setRank(rank.third); break;
						case 3:
							e.setRank(rank.fourth); break;
						}
						n++;
					}
					for(Chara e :GameLogic.team) {
						GameLogic.getCurrentStage().getStageCharaPane().updateHpBar(e, 100);
					}
					for(Chara e :GameLogic.enemies) {
						GameLogic.getCurrentStage().getStageCharaPane().updateHpBar(e, 100);
					}
				}
			}
		}
	}
	
	@Override
	public void setHp(int hp) {
		super.setHp(hp);
		checkStatus();
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
	
}