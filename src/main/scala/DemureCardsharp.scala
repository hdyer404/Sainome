object DemureCardsharp extends Champion {
  val directions: Map[Direction, Int] = Map(Up -> 2, Left -> 4, Down -> 5, Right -> 3)
  val awakenedDirections: Map[Direction, Int] = Map(Up -> 2, Left -> 3, Down -> 2, Right -> 3)
  var isAwakened: Boolean = false

  def isAwakened(hp: Int): Boolean = {
    if (hp <= 3)
      isAwakened = true

    isAwakened
  }

  def getName: String = "Demure Cardsharp"

  def getDescription: String = {
    "DEMURE CARDSHARP\n" +
      "     2     \n" +
      "4         3\n" +
      "     5\n" +
      "ACE IN THE HOLE: Spend one of your actions to take one card from the discard pile and immediately attach it.\n" +
      "HYSTERIA: Awaken when HP reaches 3 or lower.\n\n" +
      "UNRESTRAINED PSYCHIC\n" +
      "     2     \n" +
      "4         3\n" +
      "     5\n" +
      "MENTAL MANIPULATION: When attacking, you may discard a card to reroll the die. This action can be used multiple times.\n"
  }

  override def getDirections: String = {
      "     2     \n" +
      "4         3\n" +
      "     5"
  }

  def getStateDescription: String = {
    if (isAwakened)
      "Your current state is: UNRESTRAINED PSYCHIC (Awakened)\n"
    else
      "Your current state is: DEMURE CARDSHARP (Normal)\n"
  }
}