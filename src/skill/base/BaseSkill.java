package skill.base;

import java.util.ArrayList;

import chara.base.Chara;

public abstract class BaseSkill {
	
	protected String skillName;
	protected final Chara user;
	protected ArrayList<logic.rank> rank;
	protected boolean isValid;
	protected ArrayList<Chara> targets;
	
	public BaseSkill(String skillName, Chara user, ArrayList<logic.rank> rank) {
		this.setSkillName(skillName);
		this.user = user;
		this.setRank(rank);
	}
	
	public abstract void cast();
	
	public boolean isValid() {
		return this.isValid;
	}
	
	public void setValid() {
		this.isValid = this.getRank().contains(user.getRank());
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public ArrayList<logic.rank> getRank() {
		return rank;
	}

	public void setRank(ArrayList<logic.rank> rank) {
		this.rank = rank;
	}

	public ArrayList<Chara> getTargets() {
		return targets;
	}

	public void setTargets(ArrayList<Chara> targets) {
		this.targets = targets;
	}
	
}