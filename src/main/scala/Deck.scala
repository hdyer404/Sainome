import scala.util.Random

class Deck {
  var cards: List[sainomeCard] = Nil // List of cards currently in this deck
  var discardPile: List[sainomeCard] = Nil // A discard pile for used cards from this deck

  /** Shuffles this deck. */
  def shuffle(): Unit = {
    cards = build(cards, Nil)
  }

  /** Helper method that recursively shuffles a list of cards.
   *
   * @param oldDeck list to be shuffled
   * @param newDeck new list of cards taken at random from oldDeck
   * @return a list containing cards from oldDeck in shuffled order
   */
  private def build(oldDeck: List[sainomeCard], newDeck: List[sainomeCard]): List[sainomeCard] = {
    if (oldDeck.isEmpty)
      newDeck
    else {
      val random = new Random()
      val length = oldDeck.length
      val index = random.nextInt(length)
      val decks = oldDeck.splitAt(index)
      build(decks._1 ::: decks._2.tail, newDeck.::(decks._2.head))
    }
  }

  /** Deals a hand of cards from this deck and updates the deck.
   * @param number the number of cards to be dealt
   * @return a list of cards pulled from this deck
   */
  def deal(number: Int): List[sainomeCard] = {
    if (cards.length < number) {
      val top = cards
      cards = build(discardPile, Nil)
      val pool = cards.splitAt(number - top.length)
      cards = pool._2
      top ::: pool._1
    }
    else {
      val pool = cards.splitAt(number)
      cards = pool._2
      pool._1
    }
  }

  def discard(discarded: List[sainomeCard]): Unit = {
    discardPile = discardPile ::: discarded
  }
}

object Deck {
  def apply(cards: List[sainomeCard]): Deck = {
    val deck = new Deck
    deck.cards = cards
    deck
  }
}