package item.derived;

import chara.base.Ally;
import effect.StatusEffect;
import item.base.Consumable;

public class HolyWater implements Consumable {
	private int amount;
	private String name;
	private String description;
	
	public HolyWater(int amount) {
		setAmount(amount);
		name = "Holy Water";
		description = "Remove all negative debuffs.";
	}

	@Override
	public boolean consume(Ally c) {
		// TODO Auto-generated method stub
		for (StatusEffect b : c.getStatusEffect()) {
			if (b.getDescription().equals("Debuff")) {
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
