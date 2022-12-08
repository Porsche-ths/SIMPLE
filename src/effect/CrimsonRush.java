package effect;

import chara.base.Chara;

public class CrimsonRush extends StatusEffect {

	public CrimsonRush(int turnsLeft) {
		super("Crimson Rush", "Buff", turnsLeft);
		// TODO Auto-generated constructor stub
		setDescription("Gain additional damage and speed. Lower PROT by 30%.");
	}

	@Override
	public void triggerEffectAtRoundStart(Chara c) {
		// TODO Auto-generated method stub
		this.turnsLeft -= 1;
		c.setSpd(c.getSpd() + 3);
		c.setMinDmg(c.getMinDmg() + 3);
		c.setMaxDmg(c.getMaxDmg() + 3);
		c.setProt(c.getProt() - 30);


	}

	@Override
	public void triggerEffectAtRoundEnd(Chara c) {
		// TODO Auto-generated method stub
		c.setSpd(c.getSpd() - 3);
		c.setMinDmg(c.getMinDmg() - 3);
		c.setMaxDmg(c.getMaxDmg() - 3);
		c.setProt(c.getProt() + 30);

	}

}
