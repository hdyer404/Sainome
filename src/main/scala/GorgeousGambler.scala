object GorgeousGambler extends Champion {
  val directions: Map[Direction, Int] = Map(Up -> 2, Left -> 4, Down -> 5, Right -> 3)
  val awakenedDirections: Map[Direction, Int] = Map(Up -> 2, Left -> 2, Down -> 2, Right -> 2)
  var isAwakened: Boolean = false

  def isAwakened(hp: Int): Boolean = isAwakened

  def getName: String = "Gorgeous Gambler"

  def getDescription: String = {
    "GORGEOUS GAMBLER\n" +
      "     2     \n" +
      "4         3\n" +
      "     5\n" +
      "SLEIGHT OF HAND: When attacking, you may choose to reroll your die once.\n" +
      "HOT STREAK: If a 6 is rolled while attacking, awaken after resolving the die roll.\n\n" +
      "MANIAC GAMBLER\n" +
      "     2     \n" +
      "2         2\n" +
      "     2\n" +
      "ROYAL STRAIGHT FLUSH: When all 4 of Maniac Gambler's equipment slots are filled with equipment of the same type," +
      "you may spend an action to roll two dice. Inflict damage to an opponent equal to the difference between the dice results.\n" +
      "UNHOLY CONSTRAINT: Whenever you have two or more open equipment slots, your opponent may not use counterattack cards.\n" +
      "FEIGNED IGNORANCE: Return to Normal Form at the end of your Discard Phase.\n"
  }

  def getStateDescription: String = {
    if (isAwakened)
      "Your current state is: GOD SLAYER (Awakened)\n"
    else
      "Your current state is: GENTLE PRIESTESS (Normal)\n"
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