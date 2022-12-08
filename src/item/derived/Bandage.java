package item.derived;

import chara.base.Ally;
import effect.Bleed;
import effect.StatusEffect;
import item.base.Consumable;

public class Bandage implements Consumable {
	private int amount;
	private String name;
	private String description;
	
	public Bandage(int amount) {
		setAmount(amount);
		name = "Bandage";
		description = "Use to stop bleeding...";
	}

	@Override
	public boolean consume(Ally c) {
		// TODO Auto-generated method stub
		for (StatusEffect b : c.getStatusEffect()) {
			if (b instanceof Bleed) {
				c.getStatusEffect().remove(b);
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
