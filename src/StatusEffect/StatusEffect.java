package StatusEffect;

import Character.Chara;

public abstract class StatusEffect {
	protected int turnsLeft;
	protected String effectName;
	protected String effectType;
	
	public StatusEffect(String effectName, String effectType, int turnsLeft) {
		setEffectName(effectName);
		setEffectType(effectType);
		setTurnsLeft(turnsLeft);
		
	}
	public  abstract void triggerEffectAtRoundStart(Chara c);
	public  abstract void triggerEffectAtRoundEnd();

	public int turnsCount() {
		this.turnsLeft -= 1;
		return this.turnsLeft;
	}
	public int getTurnsLeft() {
		return turnsLeft;
	}
	public void setTurnsLeft(int turnsLeft) {
		this.turnsLeft = turnsLeft;
	}
	public String getEffectName() {
		return effectName;
	}
	public void setEffectName(String effectName) {
		this.effectName = effectName;
	}
	public String getEffectType() {
		return effectType;
	}
	public void setEffectType(String effectType) {
		this.effectType = effectType;
	}
	
	
}
