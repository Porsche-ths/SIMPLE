package item.derived;

import chara.base.Ally;
import effect.CrimsonRush;
import effect.StatusEffect;
import item.base.Consumable;

public class BloodVial implements Consumable {

	private int amount;
	private String name;
	private String description;
	
	public BloodVial(int amount) {
		setAmount(amount);
		name = "Blood Vial";
		description = "Do not resist the insatiable urge boiling inside your body."
					+ " Consume to gain strength and speed but lower your defense";
	}

	@Override
	public boolean consume(Ally c) {
		// TODO Auto-generated method stub
		for(StatusEffect e: c.getStatusEffect()) {
			if(e instanceof CrimsonRush){
				c.getStatusEffect().remove(e);
				break;
			}
		}
		c.getStatusEffect().add(new CrimsonRush(3));
		return true;
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
