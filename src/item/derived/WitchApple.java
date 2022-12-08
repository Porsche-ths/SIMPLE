package item.derived;

import chara.base.Ally;
import effect.Decay;
import effect.StatusEffect;
import item.base.Consumable;

public class WitchApple implements Consumable {
	private int amount;
	private String description;
	private String name;
	
	public WitchApple(int amount) {
		setAmount(amount);
		description = "Consume to cure decay effect";
		name = "Witch's Apple";
	}

	@Override
	public boolean consume(Ally c) {
		// TODO Auto-generated method stub
		for (StatusEffect d : c.getStatusEffect()) {
			if (d instanceof Decay) {
				c.getStatusEffect().remove(d);
				return true;
			}
		}
		return false;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public String getName() {
		return name;
	}

}
