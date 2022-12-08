package StatusEffect;

import Character.Chara;

public class Decay extends StatusEffect {
	private int damage;
	public Decay(int turnsLeft,int damage) {
		super("Decay", "Decay", turnsLeft);

		// TODO Auto-generated constructor stub
		setDamage(damage);
	}

	@Override
	public void triggerEffectAtRoundStart(Chara c) {
		// TODO Auto-generated method stub
		setTurnsLeft(getTurnsLeft() - 1);
		c.setHp(c.getHp() - this.damage);

	}

	@Override
	public void triggerEffectAtRoundEnd() {
		// TODO Auto-generated method stub

	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

}
