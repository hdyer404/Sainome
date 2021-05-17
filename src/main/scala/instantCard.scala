sealed trait Instant
case object AimlessBarrage extends Instant
case object Bartering extends Instant
case object ChoiceOfTwo extends Instant
case object Hypnotism extends Instant
case object Overdrive extends Instant
case object QuickChange extends Instant
case object RecklessAssault extends Instant
case object Restart extends Instant
case object Steal extends Instant
case object TreasureSearch extends Instant
case object LegendaryStatue extends Instant

class instantCard(instant: Instant) extends sainomeCard {
  override def getType: Type = instant match {
    case AimlessBarrage => Skill
    case Bartering => Skill
    case ChoiceOfTwo => Skill
    case Hypnotism => Skill
    case Overdrive => Skill
    case QuickChange => Skill
    case RecklessAssault => Skill
    case Restart => Skill
    case Steal => Skill
    case TreasureSearch => Skill
    case LegendaryStatue => Rare
  }

  override def getUsage: Usage = InstantUse

  override def getDescription: String = instant match {
    case AimlessBarrage => "You can only activate this when your HP is lower than your targeted opponent's. " +
      "Discard all currently attached equipment cards and inflict 1 damage for each discarded card."
    case Bartering => "Exchange your hand with that of another player."
    case ChoiceOfTwo => "Roll two dice and use either result to perform an Attack action. You may not activate this if " +
      "you have already performed an Attack action this turn."
    case Hypnotism => "Return an opponent's attached equipment card back to their hand."
    case Overdrive => "Become Awakened until the start of this turn's Discard Phase. Does nothing if already Awakened."
    case QuickChange => "You may perform the Attach Equipment and Attack actions as a single action. You may not activate this " +
      "card if you have already performed an Attach Equipment or Attack action this turn."
    case RecklessAssault => "You may only activate this when you have 1 HP. Discard your hand and roll a die for each discarded card. " +
      "Deal 1 damage for every result of 4 and above."
    case Restart => "Shuffle every card other than the HP Stacks (all players' hands, attached equipment cards, the common deck, and " +
      "the discard pile) into the common deck and deal each player five new cards."
    case Steal => "Look at your opponent's hand and take any card, adding it into your hand."
    case TreasureSearch => "Pick any card from the discard pile and add it to your hand."
    case LegendaryStatue => "You may only activate this once you have all four other Legendary items equipped. When this requirement is " +
      "met, you may activate this card using an Instant Play action at which time you instantly win the game."
  }

  override def toString(): String = instant match {
    case AimlessBarrage => "Aimless Barrage"
    case Bartering => "Bartering"
    case ChoiceOfTwo => "Choice of Two"
    case Hypnotism => "Hypnotism"
    case Overdrive => "Overdrive"
    case QuickChange => "Quick Change"
    case RecklessAssault => "Reckless Assault"
    case Restart => "Restart"
    case Steal => "Steal"
    case TreasureSearch => "Treasure Search"
    case LegendaryStatue => "Statue of the Legendary Hero"
  }
}
