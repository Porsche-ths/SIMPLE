package chara.ally;

import chara.base.Ally;
import skill.ally.DaggersPlay;
import skill.ally.StabInTheFace;

public class Rogue extends Ally {

	public Rogue(String name) {
		super(name, "Rogue", 9, 20, 0, 20, 7, 0, 4, 8, 9, 20, 67, 30, 30, 30);
		getSkills().add(new DaggersPlay(this));
		getSkills().add(new StabInTheFace(this));
	}

}
