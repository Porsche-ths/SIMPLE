package chara.ally;

import chara.base.Ally;
import skill.ally.DivineComfort;
import skill.ally.DivineGrace;

public class Priest extends Ally{

	public Priest(String name) {
		super(name, "Priest", 15, 24, 0, 5, 1, 0, 4, 8, 4, 30, 67, 40, 40, 30);
		getSkills().add(new DivineGrace(this));
		getSkills().add(new DivineComfort(this));
	}

}
