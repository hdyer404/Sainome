object BrokeMagus extends Champion {
  val directions: Map[Direction, Int] = Map(Up -> 2, Left -> 4, Down -> 5, Right -> 3)
  var isAwakened: Boolean = false

  def isAwakened(hp: Int): Boolean = isAwakened

  def getName: String = "Broke Magus"

  def getDescription: String = {
    "BROKE MAGUS\n" +
      "     2     \n" +
      "4         3\n" +
      "     5\n" +
      "ECONOMICS: When using Magic-type equipment, you do not need to discard cards to meet the catalyst requirement.\n" +
      "SUMMONING HEX: When you discard one or more cards during the Discard Phase, Broke Magus awakens.\n\n" +
      "MAGUS, MAGIC UNLEASHED\n" +
      "     2     \n" +
      "4         3\n" +
      "     5\n" +
      "ALTER FATE: When attacking, you may discard a card to reroll the die. This action can be used multiple times.\n" +
      "ELIXIR OF MAGICKS: When using Magic-type equipment, you do not need to discard cards to meet the catalyst requirement.\n" +
      "Magic damage is increased by 1.\n" +
      "DISENCHANTMENT: Whenever you perform a Draw Cards action, return the Magus to Normal Form.\n"
  }

  def getStateDescription: String = {
    if (isAwakened)
      "Your current state is: MAGUS, MAGIC UNLEASHED (Awakened)\n"
    else
      "Your current state is: BROKE MAGUS (Normal)\n"
  }

  override def getDirections: String = {
      "     2     \n" +
      "4         3\n" +
      "     5"
  }

  def awaken(): Unit = {
    isAwakened = !isAwakened
  }
}