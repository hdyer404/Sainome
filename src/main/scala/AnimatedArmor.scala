object AnimatedArmor extends Champion {
  val directions: Map[Direction, Int] = Map(Up -> 2, Left -> 4, Down -> 5, Right -> 3)
  var isAwakened: Boolean = false

  def isAwakened(hp: Int): Boolean = isAwakened

  def getName: String = "Animated Armor"

  def getDescription: String = {
    "ANIMATED ARMOR\n" +
      "     2     \n" +
      "4         3\n" +
      "     5\n" +
      "IRON WALL: All damage inflicted and damage taken during Attack actions becomes 1.\n" +
      "CAST OFF: Spend one action to awaken.\n\n" +
      "PUPPETEER\n" +
      "     2     \n" +
      "4         3\n" +
      "     5\n" +
      "DOPPELGANGER: After awakening, declare an opponent's character. You may use that character's skills." +
      "ARMORCLAD: Spend one action to return to Normal Form.\n"
  }

  def getStateDescription: String = {
    if (isAwakened)
      "Your current state is: PUPPETEER (Awakened)"
    else
      "Your current state is: ANIMATED ARMOR (Normal)"
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
