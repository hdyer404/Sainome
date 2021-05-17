object FlowerGirl extends Champion {
  val directions: Map[Direction, Int] = Map(Up -> 2, Left -> 4, Down -> 5, Right -> 3)
  var isAwakened: Boolean = false

  def isAwakened(hp: Int): Boolean = isAwakened

  def getName: String = "Flower Girl"

  def getDescription: String = {
    "FLOWER GIRL\n" +
      "     2     \n" +
      "4         3\n" +
      "     5\n" +
      "TIME TO GARDEN!: Spend one action to force all players (including yourself) to discard cards until they have 3" +
      "or less in their hand.\n" +
      "TIME TO SAVE THE PLANET!: Spend one action to awaken.\n\n" +
      "MAGICAL GIRL WHO SAVES THE PLANET\n" +
      "     2     \n" +
      "4         3\n" +
      "     5\n" +
      "FLOWER BOMB: Spend an action to discard your entire hand and perform an Attack action where the damage is equal to" +
      "the number of cards you have just discarded. This ability may only be used on the turn you have awakened.\n" +
      "BACK TO BEING A FLOWER GIRL!: Spend one action to return to your Normal Form.\n"
  }

  def getStateDescription: String = {
    if (isAwakened)
      "Your current state is: MAGICAL GIRL WHO SAVES THE PLANET (Awakened)\n"
    else
      "Your current state is: FLOWER GIRL (Normal)\n"
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