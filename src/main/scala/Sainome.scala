import scala.io.StdIn._
import Array._

object Sainome {
  var deck: Deck = Deck(Nil)
  val HP = 10
  val BaseHandLimit = 5

  def main(args: Array[String]): Unit = {
    print("Enter number of players (2-4): ")
    val number = readInt()
    val players: Array[Player] = new Array(number)

    val champions = SainomeHelper.championsList

    pickChampion(1, champions, players)

    /*for (player <- players)
      println(player.getChampion.getName)*/
    // For testing xP

    Sainome(players)
  }

  def Sainome(players: Array[Player]): Unit = {
    deck = buildDeck()
    deck.shuffle()

    for (player <- players)
      player.setHP(deck.deal(HP))

    for (player <- players)
      player.drawCards(deck.deal(BaseHandLimit))

    // Testing!!!1!!1!
    /*for (player <- players) {
      println("Player " + (players.indexOf(player) + 1) + "'s hand")
      for (card <- player.getHand())
        println(card.toString())
    }*/

    playGame(players(0), players)
  }

  def playGame(player: Player, players: Array[Player]): Unit = {
    // Check if game has been won
    if (checkWon(player, concat(players.splitAt(players.indexOf(player))._1, players.splitAt(players.indexOf(player))._2.tail))) {
      println("The tournament is over! The winner is Player " + (players.indexOf(player) + 1) + " and their Champion, " + player.getChampion.getName + "!")
    }

    else {
      println("\nPlayer " + (players.indexOf(player) + 1) + "'s Turn")
      if (player.hp.nonEmpty) {
        // Display hand and equipment state
        println("\nCurrent hand: ")
        for (card <- player.hand) {
          print((player.hand.indexOf(card) + 1) + ". ")
          println(card.toString())
          println(card.getDescription)
        }

        println("\nCurrent equipment state: ")
        println(player.getChampion.getDirections)
        for (state <- player.equipped) {
          print(state._1 + ": ")
          if (state._2 == null)
            println("None")
          else
            println(state._2.toString())
        }

        // Action phase
        actionPhase(player, 2, Nil)

        // Discard phase
        discardPhase(player)
      }

      // Call next player
      if ((players.indexOf(player) + 1) >= players.length)
        playGame(players(0), players)
      else
        playGame(players(players.indexOf(player) + 1), players)
    }
  }

  def checkWon(player: Player, restPlayers: Array[Player]): Boolean = {
    if (restPlayers.isEmpty)
      true
    else if (restPlayers(0).hp.nonEmpty)
      false
    else
      checkWon(player, restPlayers.tail)
  }

  def actionPhase(player: Player, remaining: Int, used: List[Action]): Unit = {
    if (remaining > 0) {
      println("\nChoose the action you would like to perform. (" + remaining + " remaining)")
      println("1. Draw cards\n" +
        "2. Attach equipment\n" +
        "3. Use an Instant Play card\n" +
        "4. Attack an opponent\n" +
        "5. Use a Champion skill")
      print("Your choice: ")
      val choice = readInt()
      var success = false
      choice match {
        case 1 => {
          if (!used.contains(Draw))
            success = drawCards(player)
          else
            println("\nYou have already performed that action this turn.")
        }
        case 2 => {
          if (!used.contains(Equip))
            success = attachEquipment(player)
          else
            println("\nYou have already performed that action this turn.")
        }
        case 3 => {
          if (!used.contains(PlayInstant))
            success = instantPlay(player)
          else
            println("\nYou have already performed that action this turn.")
        }
        case 4 => {
          if (!used.contains(Attack))
            success = attackAction(player)
          else
            println("\nYou have already performed that action this turn.")
        }
        case 5 => {
          if (!used.contains(CharSkill))
            success = championSkill(player)
          else
            println("\nYou have already performed that action this turn.")
        }
      }

      if (success) {
        choice match {
          case 1 => actionPhase(player, remaining - 1, (Draw :: Nil) ::: used)
          case 2 => actionPhase(player, remaining - 1, (Equip :: Nil) ::: used)
          case 3 => actionPhase(player, remaining - 1, (PlayInstant :: Nil) ::: used)
          case 4 => actionPhase(player, remaining - 1, (Attack :: Nil) ::: used)
          case 5 => actionPhase(player, remaining - 1, (CharSkill:: Nil) ::: used)
        }
      }

      else
        actionPhase(player, remaining, used)
    }
  }

  def discardPhase(player: Player): Unit = {
    if (player.hand.nonEmpty) {
      println("\nYour hand: ")
      for (card <- player.hand) {
        println((player.hand.indexOf(card) + 1) + ". " + card.toString())
        println(card.getDescription)
      }
      println("\nWould you like to discard a card from your hand?")
      print("Your choice (Y/N): ")
      val choice = readChar().toUpper
      if (choice == 'Y') {
        println("Which card would you like to discard?")
        print("Your choice: ")
        val choice2 = readInt()

        val pick = player.hand.splitAt(choice2 - 1)
        if (pick._2.head == null)
          deck.discard(player.hand.last :: Nil)
        else
          deck.discard(player.hand.splitAt(choice2 - 1)._2.head :: Nil)

        player.discardCard(choice2 - 1)

        discardPhase(player)
      }
    }
  }

  def drawCards(player: Player): Boolean = {
    if (player.hand.length >= player.handLimit) {
      println("\nNot enough room to draw cards.\n" +
        "Your hand's size: " + player.hand.length + "\n" +
        "Your hand's capacity: " + player.handLimit)
      false
    }
    else {
      val newHand = player.drawCards(deck.deal(player.handLimit - player.hand.length))
      println("\nYour new cards are: ")
      for (card <- newHand)
        println(card.toString())
      true
    }
  }

  def attachEquipment(player: Player): Boolean = {
    val cards = for (card <- player.hand if card.getUsage == EquipmentUse)
                  yield card

    if (cards.isEmpty) {
      println("You do not have any cards that you can equip.")
      false
    }
    else {
      println()
      for (card <- cards) {
        println((cards.indexOf(card) + 1) + ". " + card.toString())
        println(card.getDescription)
        print("Equippable directions: ")
        for (direction <- card.getDirections)
          print(direction + " ")
        println()
      }
      print("\nWhich card would you like to equip?: ")
      val choice = readInt()
      equip(player, choice, cards)
      true
    }
  }

  def equip(player: Player, choice: Int, choices: List[sainomeCard]): Unit = {
    val cards = choices.splitAt(choice - 1)
    val card = cards._2.head

    if (card.getType == Magic) {
      if (player.getChampion != BrokeMagus)
        catalyst(player, card, card.asInstanceOf[equipmentCard].getCatalyst)
    }

    if (card.getDirections.length > 1) {
      println("Which direction do you want to equip this card?")
      for (direction <- card.getDirections)
        println((card.getDirections.indexOf(direction) + 1) + ". " + direction)
      print("Your choice: ")
      val choice2 = readInt()
      val direction = card.getDirections.splitAt(choice2 - 1)._2.head
      player.equipped = player.equipped - direction
      player.equipped = player.equipped + (direction -> card.asInstanceOf[equipmentCard])
    }
    else {
      val direction = card.getDirections(0)
      player.equipped = player.equipped - direction
      player.equipped = player.equipped + (direction -> card.asInstanceOf[equipmentCard])
    }

    player.discardCard(player.hand.indexOf(card))
  }

  def catalyst(player: Player, card: sainomeCard, sacrifice: Int): Unit = {
    if (sacrifice > 0) {
      val cards = player.hand.splitAt(player.hand.indexOf(card))
      val choices = cards._1 ::: cards._2.tail
      println("\nPick a card to discard as catalyst. (" + sacrifice + " remaining)")
      for (option <- choices) {
        println((choices.indexOf(option) + 1) + ". " + option.toString())
        println(option.getDescription)
      }
      print("Your choice: ")
      val choice = readInt()

      val pick = choices.splitAt(choice - 1)
      if (pick._2.head == null) {
        player.discardCard(player.hand.indexOf(choices.last))
        deck.discard(choices.last :: Nil)
      }
      else {
        player.discardCard(player.hand.indexOf(pick._2.head))
        deck.discard(pick._2.head :: Nil)
      }

      catalyst(player, card, sacrifice - 1)
    }
  }

  def instantPlay(player: Player): Boolean = {
    true
  }

  def attackAction(player: Player): Boolean = {
    true
  }

  def championSkill(player: Player): Boolean = {
    true
  }

  def pickChampion(player: Int, champions: List[Champion], players: Array[Player]): Unit = {
    if (player <= players.length) {
      println("\nPlayer " + player + ", select your Champion.")
      for (champ <- champions) {
        println((champions.indexOf(champ) + 1) + ". " + champ.getName)
      }
      print("Your choice: ")
      val choice = readInt()

      println("\n" + getChampion(champions, choice - 1).getDescription)
      print("Is this the Champion you want? (Y/N): ")
      val choice2 = readChar().toUpper

      if (choice2 == 'Y') {
        val lists = champions.splitAt(choice - 1)
        players(player - 1) = new Player(lists._2.head)
        pickChampion(player + 1, lists._1 ::: lists._2.tail, players)
      }

      else
        pickChampion(player, champions, players)
    }
  }

  def getChampion(champions: List[Champion], index: Int): Champion = {
    if (index == 0)
      champions.head
    else
      getChampion(champions.tail, index - 1)
  }

  def buildDeck(): Deck = {
    val list: List[sainomeCard] = new equipmentCard(BattleAxe) :: new equipmentCard(BattleAxe) :: new equipmentCard(Claymore) ::
      new equipmentCard(Claymore) :: new equipmentCard(Crossbow) :: new equipmentCard(Crossbow) ::
      new equipmentCard(Dagger) :: new equipmentCard(Dagger) :: new equipmentCard(Dagger) ::
      new equipmentCard(Dagger) :: new equipmentCard(Longbow) :: new equipmentCard(Longbow) ::
      new equipmentCard(Longsword) :: new equipmentCard(Longsword) :: new equipmentCard(Runesword) ::
      new equipmentCard(Runesword) :: new equipmentCard(Sai) :: new equipmentCard(Sai) ::
      new equipmentCard(SickleAndChain) :: new equipmentCard(SickleAndChain) :: new equipmentCard(Cyclone) ::
      new equipmentCard(Cyclone) :: new equipmentCard(Earthquake) :: new equipmentCard(Earthquake) ::
      new equipmentCard(Fireball) :: new equipmentCard(Fireball) :: new equipmentCard(Fireball) ::
      new equipmentCard(Fireball) :: new equipmentCard(IceEdge) :: new equipmentCard(IceEdge) ::
      new equipmentCard(MeteorStorm) :: new equipmentCard(MeteorStorm) :: new equipmentCard(Ray) ::
      new equipmentCard(Ray) :: new equipmentCard(ShadowBind) :: new equipmentCard(ShadowBind) ::
      new equipmentCard(Thunderbolt) :: new equipmentCard(Thunderbolt) :: new equipmentCard(TidalWave) ::
      new equipmentCard(TidalWave) :: new equipmentCard(Bomb) :: new equipmentCard(Bomb) :: new equipmentCard(Bomb) ::
      new equipmentCard(Bomb) :: new equipmentCard(Chainsaw) :: new equipmentCard(LargeSack) ::
      new equipmentCard(LargeSack) :: new equipmentCard(PlayingCards) :: new equipmentCard(PlayingCards) ::
      new equipmentCard(PlayingCards) :: new equipmentCard(PlayingCards) :: new equipmentCard(Saw) ::
      new equipmentCard(Saw) :: new equipmentCard(ThrowingKnives) :: new equipmentCard(ThrowingKnives) ::
      new equipmentCard(ThrowingKnives) :: new equipmentCard(ThrowingKnives) :: new equipmentCard(Charge) ::
      new equipmentCard(Charge) :: new counterCard(Guts) :: new counterCard(Guts) ::
      new counterCard(SubstitutionJutsu) :: new counterCard(SubstitutionJutsu) :: new counterCard(TimeBomb) ::
      new counterCard(TimeBomb) :: new counterCard(CursedDoll) :: new counterCard(CursedDoll) ::
      new counterCard(CursedDoll) :: new counterCard(CursedDoll) :: new counterCard(SteelArmor) ::
      new counterCard(SteelArmor) :: new counterCard(WeightedDice) :: new counterCard(WeightedDice) ::
      new counterCard(WoodenBuckler) :: new counterCard(WoodenBuckler) :: new counterCard(WoodenBuckler) ::
      new counterCard(WoodenBuckler) :: new instantCard(AimlessBarrage) :: new instantCard(AimlessBarrage) ::
      new instantCard(Bartering) :: new instantCard(Bartering) :: new instantCard(ChoiceOfTwo) ::
      new instantCard(ChoiceOfTwo) :: new instantCard(Hypnotism) :: new instantCard(Hypnotism) ::
      new instantCard(Overdrive) :: new instantCard(QuickChange) :: new instantCard(QuickChange) ::
      new instantCard(RecklessAssault) :: new instantCard(RecklessAssault) :: new instantCard(Restart) ::
      new instantCard(Steal) :: new instantCard(Steal) :: new instantCard(TreasureSearch) ::
      new instantCard(TreasureSearch) :: new instantCard(TreasureSearch) :: new instantCard(LegendaryStatue) ::
      new equipmentCard(LegendaryArmor) :: new equipmentCard(LegendaryHelmet) :: new equipmentCard(LegendaryShield) ::
      new equipmentCard(LegendarySword) :: Nil

    val deck = Deck(list)
    deck
  }
}
