class Player(champion: Champion) {
  var hp: List[sainomeCard] = Nil
  var hand: List[sainomeCard] = Nil
  var handLimit = 5
  var equipped: Map[Direction, equipmentCard] = Map(Up -> null, Left -> null, Down -> null, Right -> null)
  // ms put (k, v)

  def getChampion: Champion = champion

  def setHP(pile: List[sainomeCard]): Unit = {
    hp = pile
  }

  def setHandLimit(limit: Int): Unit = {
    handLimit = limit
  }

  def drawCards(cards: List[sainomeCard]): List[sainomeCard] = {
    hand = hand ::: cards
    cards
  }

  def getHand(): List[sainomeCard] = hand

  def discardCard(index: Int): Unit = {
    val result = hand.splitAt(index - 1)
    hand = result._1 ::: result._2.tail
  }

  def takeDamage(damage: Int): List[sainomeCard] = {
    val result = hp.splitAt(damage)
    hp = result._2
    result._1
  }

  def isAwakened: Boolean = {
    champion.isAwakened(hp.length)
  }
}
