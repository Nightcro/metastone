package net.pferdimanzug.hearthstone.analyzer.game.spells.trigger;

import net.pferdimanzug.hearthstone.analyzer.game.entities.Entity;
import net.pferdimanzug.hearthstone.analyzer.game.events.GameEvent;
import net.pferdimanzug.hearthstone.analyzer.game.events.GameEventType;

public abstract class GameEventTrigger implements Cloneable {

	private int owner;

	public GameEventTrigger clone() {
		try {
			return (GameEventTrigger) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}

	public abstract boolean fire(GameEvent event, Entity host);

	public int getOwner() {
		return owner;
	}

	public abstract GameEventType interestedIn();

	public void setOwner(int playerIndex) {
		this.owner = playerIndex;
	}

	@Override
	public String toString() {
		return "[" + getClass().getSimpleName() + " owner:" + owner + "]";
	}

}
