package chara.base;

import java.util.ArrayList;

import Skill.Skill;
import effect.StatusEffect;

public abstract class Chara {
	private String name;
	private int maxHp, hp, accMod, dodge, crit, prot, minDmg, maxDmg, spd, queueNum;
	private int stunResist, bleedResist, decayResist, debuffResist;
	private boolean isStunned;
	private ArrayList<Skill> skills;
	private ArrayList<StatusEffect> statusEffects;
	private logic.rank rank;

	public Chara(String name, int maxHp, int accMod, int dodge, int crit, int prot, int minDmg, int maxDmg, int spd,
			 int stunResist, int bleedResist, int decayResist,
			int debuffResist) {
		setName(name);
		setMaxHp(maxHp);
		setHp(maxHp);
		setAccMod(accMod);
		setDodge(dodge);
		setCrit(crit);
		setProt(prot);
		setMinDmg(minDmg);
		setMaxDmg(maxDmg);
		setSpd(spd);
		setStunned(false);
	}

	

	public abstract void beginTurn(); // check status
	
	public void atRoundStart() {
		ArrayList<StatusEffect> toBeRemoved = new ArrayList<StatusEffect>();

		for(StatusEffect effect: statusEffects ) {
			effect.triggerEffectAtRoundStart(this);
			if(effect.getTurnsLeft() == 0) toBeRemoved.add(effect);
		}
		for(StatusEffect effect:toBeRemoved) {
			statusEffects.remove(effect);
		}
	}
	public void atRoundEnd() {
		for(StatusEffect effect:statusEffects) {
			effect.triggerEffectAtRoundEnd(this);
			
		}
		
	}

	public String getDetail() {

		return "Name            : " + this.getName() + "\nHP              : " + this.getHp() + "/" + this.getMaxHp()
				+ "\nAccuracy        : " + this.getAccMod() + "\nDodge           : " + this.getDodge()
				+ "\nCritical Chance : " + this.getCrit() + "\nProtection      : " + this.getProt()
				+ "\nDamage          : " + this.getMinDmg() + " - " + this.getMaxDmg() + "\nSpeed           : "
				+ this.getSpd();

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMaxHp() {
		return maxHp;
	}

	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		if (hp < 0)
			hp = 0;
		if (hp > this.getMaxHp())
			hp = this.getMaxHp();
		this.hp = hp;
	}

	public int getAccMod() {
		return accMod;
	}

	public void setAccMod(int accMod) {
		this.accMod = accMod;
	}

	public int getDodge() {
		return dodge;
	}

	public void setDodge(int dodge) {
		this.dodge = dodge;
	}

	public int getCrit() {
		return crit;
	}

	public void setCrit(int crit) {
		this.crit = crit;
	}

	public int getProt() {
		return prot;
	}

	public void setProt(int prot) {
		this.prot = prot;
	}

	public int getMinDmg() {
		return minDmg;
	}

	public int getMaxDmg() {
		return maxDmg;
	}

	public void setMaxDmg(int maxDmg) {
		this.maxDmg = maxDmg;
	}

	public void setMinDmg(int minDmg) {
		this.minDmg = minDmg;
	}

	public int getSpd() {
		return spd;
	}

	public void setSpd(int spd) {
		this.spd = spd;
	}

	public boolean isStunned() {
		return isStunned;
	}

	public void setStunned(boolean isStunned) {
		this.isStunned = isStunned;
	}

	public ArrayList<Skill> getSkills() {
		return skills;
	}

	public void setSkills(ArrayList<Skill> skills) {
		this.skills = skills;
	}

	public logic.rank getRank() {
		return rank;
	}

	public void setRank(logic.rank rank) {
		this.rank = rank;
	}

	public int getQueueNum() {
		return this.queueNum;
	}

	public void setQueueNum(int queueNum) {
		this.queueNum = queueNum;
	}
	public int getStunResist() {
		return stunResist;
	}

	public void setStunResist(int stunResist) {
		this.stunResist = stunResist;
	}

	

	public int getBleedResist() {
		return bleedResist;
	}

	public void setBleedResist(int bleedResist) {
		this.bleedResist = bleedResist;
	}

	public int getDecayResist() {
		return decayResist;
	}

	public void setDecayResist(int decayResist) {
		this.decayResist = decayResist;
	}

	public int getDebuffResist() {
		return debuffResist;
	}

	public void setDebuffResist(int debuffResist) {
		this.debuffResist = debuffResist;
	}
	public ArrayList<StatusEffect> getStatusEffect() {
		return this.statusEffects;
	}
}
