object BeautifulBride extends Champion {
  val directions: Map[Direction, Int] = Map(Up -> 5, Left -> 4, Down -> 5, Right -> 4)
  var isAwakened: Boolean = false

  def isAwakened(hp: Int): Boolean = {
    if (hp <= 3)
      isAwakened = true

    isAwakened
  }

  def getName: String = "Beautiful Veiled Bride"

  def getDescription: String = {
    "BEAUTIFUL VEILED BRIDE\n" +
      "     5     \n" +
      "4         4\n" +
      "     5\n" +
      "MYSTERIOUS AURA: If a 6 is rolled during an Attack action, add +1 damage to each card that is activated and inflicts damage.\n" +
      "BOUQUET: Awaken when HP reaches 3 or lower.\n\n" +
      "FOREIGN PRINCESS\n" +
      "     5     \n" +
      "4         4\n" +
      "     5\n" +
      "BACKUP PLAN: When attacking, if the die result is not a 4, 5, or 6, inflict 2 damage upon an opponent.\n"
  }

  def getStateDescription: String = {
    if (isAwakened)
      "Your current state is: FOREIGN PRINCESS (Awakened)\n"
    else
      "Your current state is: BEAUTIFUL VEILED BRIDE (Normal)\n"
  }

  override def getDirections: String = {
      "     5     \n" +
      "4         4\n" +
      "     5"
  }
}