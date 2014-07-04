package net.pferdimanzug.hearthstone.analyzer.game.cards.concrete.druid;

import net.pferdimanzug.hearthstone.analyzer.game.actions.Battlecry;
import net.pferdimanzug.hearthstone.analyzer.game.cards.ChooseBattlecryCard;
import net.pferdimanzug.hearthstone.analyzer.game.cards.Rarity;
import net.pferdimanzug.hearthstone.analyzer.game.entities.heroes.HeroClass;
import net.pferdimanzug.hearthstone.analyzer.game.entities.minions.Minion;
import net.pferdimanzug.hearthstone.analyzer.game.spells.DamageSpell;
import net.pferdimanzug.hearthstone.analyzer.game.spells.SilenceSpell;
import net.pferdimanzug.hearthstone.analyzer.game.targeting.TargetSelection;

public class KeeperOfTheGrove extends ChooseBattlecryCard {

	public KeeperOfTheGrove() {
		super("Keeper of the Grove", 2, 4, Rarity.RARE, HeroClass.DRUID, 4);
		setDescription("Choose One - Deal 2 damage; or Silence a minion.");
	}

	@Override
	protected Battlecry getBattlecry1() {
		return Battlecry.createBattlecry(new DamageSpell(2), TargetSelection.ANY);
	}

	@Override
	protected Battlecry getBattlecry2() {
		return Battlecry.createBattlecry(new SilenceSpell(), TargetSelection.MINIONS);
	}

	@Override
	public Minion summon() {
		return createMinion();
	}

	@Override
	protected String getAction1Suffix() {
		return "2 damage";
	}

	@Override
	protected String getAction2Suffix() {
		return "Silence";
	}

}
