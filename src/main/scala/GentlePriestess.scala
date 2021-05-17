object GentlePriestess extends Champion {
  val directions: Map[Direction, Int] = Map(Up -> 2, Left -> 4, Down -> 5, Right -> 3)
  var isAwakened: Boolean = false

  def isAwakened(hp: Int): Boolean = isAwakened

  def getName: String = "Gentle Priestess"

  def getDescription: String = {
    "GENTLE PRIESTESS\n" +
      "     2     \n" +
      "4         3\n" +
      "     5\n" +
      "DOCTRINE OF DISARMAMENT: When attacked, discard any amount of cards currently equipped. Reduce the damage taken" +
      "by 1 for each discarded card (up to 4).\n" +
      "TRUE NATURE: When damage is taken, Gentle Priestess awakens.\n\n" +
      "GOD SLAYER\n" +
      "     2     \n" +
      "4         3\n" +
      "     5\n" +
      "ONE-SHOT MASSACRE: Triple the damage of any attached Saw or Chainsaw.\n" +
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