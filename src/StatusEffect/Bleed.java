package StatusEffect;

import Character.Chara;

public class Bleed extends StatusEffect {
	private int damage;

	public Bleed(String effectName, int turnsLeft, int damage) {
		super("Bleed", "Bleed", turnsLeft);
		setDamage(damage);
		// TODO Auto-generated constructor stub
	}


	@Override
	public void triggerEffectAtRoundStart(Chara c) {
		// TODO Auto-generated method stub
		setTurnsLeft(getTurnsLeft() - 1);
		c.setHp(c.getHp() - this.damage);

	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	@Override
	public void triggerEffectAtRoundEnd() {
		// TODO Auto-generated method stub
		
	}

}
