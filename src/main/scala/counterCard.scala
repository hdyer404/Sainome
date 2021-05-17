sealed trait Counter
case object Guts extends Counter
case object SubstitutionJutsu extends Counter
case object TimeBomb extends Counter
case object CursedDoll extends Counter
case object SteelArmor extends Counter
case object WeightedDice extends Counter
case object WoodenBuckler extends Counter

class counterCard(counter: Counter) extends sainomeCard {
  override def getType: Type = counter match {
    case Guts => Skill
    case SubstitutionJutsu => Skill
    case TimeBomb => Skill
    case CursedDoll => Item
    case SteelArmor => Item
    case WeightedDice => Item
    case WoodenBuckler => Item
  }

  override def getUsage: Usage = CounterUse

  override def getDescription: String = counter match {
    case Guts => "Can only be activated when receiving damage that would otherwise reduce your HP to 0 or below. " +
      "Declare a number and roll 2 dice. If the result of either die is your called number, you take a stand and remain at 1 HP."
    case SubstitutionJutsu => "Reduce the damage taken from your opponent to 0."
    case TimeBomb => "Attach this card to an opponent's equipment slot. At the start of your opponent's next Discard Phase, deal 2 damage " +
      "and then discard this card."
    case CursedDoll => "Give this card to your opponent. This card may not be discarded during the Discard Phase."
    case SteelArmor => "Reduce the damage you take to 1 HP."
    case WeightedDice => "Roll two dice. Pick either result and treat it as your opponent's die roll."
    case WoodenBuckler => "Cut the damage you take in half (rounding up)."
  }

  override def toString(): String = counter match {
    case Guts => "Guts"
    case SubstitutionJutsu => "Substitution Jutsu"
    case TimeBomb => "Time Bomb"
    case CursedDoll => "Cursed Doll"
    case SteelArmor => "Steel Armor"
    case WeightedDice => "Weighted Dice"
    case WoodenBuckler => "Wooden Buckler"
  }
}
