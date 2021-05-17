sealed trait Equipment
case object BattleAxe extends Equipment
case object Claymore extends Equipment
case object Crossbow extends Equipment
case object Dagger extends Equipment
case object Longbow extends Equipment
case object Longsword extends Equipment
case object Runesword extends Equipment
case object Sai extends Equipment
case object SickleAndChain extends Equipment
case object Cyclone extends Equipment
case object Earthquake extends Equipment
case object Fireball extends Equipment
case object IceEdge extends Equipment
case object MeteorStorm extends Equipment
case object Ray extends Equipment
case object ShadowBind extends Equipment
case object Thunderbolt extends Equipment
case object TidalWave extends Equipment
case object Bomb extends Equipment
case object Chainsaw extends Equipment
case object LargeSack extends Equipment
case object PlayingCards extends Equipment
case object Saw extends Equipment
case object ThrowingKnives extends Equipment
case object Charge extends Equipment
case object LegendaryArmor extends Equipment
case object LegendaryHelmet extends Equipment
case object LegendaryShield extends Equipment
case object LegendarySword extends Equipment

sealed trait Direction
case object Up extends Direction
case object Down extends Direction
case object Left extends Direction
case object Right extends Direction

class equipmentCard(equipment: Equipment) extends sainomeCard {
  def getEquipment: Equipment = equipment

  def getCatalyst: Int = equipment match {
    case BattleAxe => 0
    case Claymore => 0
    case Crossbow => 0
    case Dagger => 0
    case Longbow => 0
    case Longsword => 0
    case Runesword => 0
    case Sai => 0
    case SickleAndChain => 0
    case Cyclone => 2
    case Earthquake => 2
    case Fireball => 0
    case IceEdge => 0
    case MeteorStorm => -1
    case Ray => 1
    case ShadowBind => 1
    case Thunderbolt => 0
    case TidalWave => 1
    case Bomb => 0
    case Chainsaw => 0
    case LargeSack => 0
    case PlayingCards => 0
    case Saw => 0
    case ThrowingKnives => 0
    case Charge => 0
    case LegendaryArmor => 0
    case LegendaryHelmet => 0
    case LegendaryShield => 0
    case LegendarySword => 0
  }

  def getDamage: Int = equipment match {
    case BattleAxe => 2
    case Claymore => 3
    case Crossbow => 1
    case Dagger => 1
    case Longbow => 2
    case Longsword => 3
    case Runesword => 3
    case Sai => 1
    case SickleAndChain => 2
    case Cyclone => 4
    case Earthquake => 4
    case Fireball => 1
    case IceEdge => 2
    case MeteorStorm => -1
    case Ray => 2
    case ShadowBind => 1
    case Thunderbolt => 2
    case TidalWave => 2
    case Bomb => 1
    case Chainsaw => 4
    case LargeSack => 0
    case PlayingCards => -1
    case Saw => 2
    case ThrowingKnives => 1
    case Charge => 0
    case LegendaryArmor => 0
    case LegendaryHelmet => 0
    case LegendaryShield => 0
    case LegendarySword => 0
  }

  override def getDirections: Array[Direction] = equipment match {
    case BattleAxe => Array(Up, Down)
    case Claymore => Array(Right)
    case Crossbow => Array(Down)
    case Dagger => Array(Up, Down, Left, Right)
    case Longbow => Array(Left, Right)
    case Longsword => Array(Left, Right)
    case Runesword => Array(Left)
    case Sai => Array(Up)
    case SickleAndChain => Array(Up, Down)
    case Cyclone => Array(Down)
    case Earthquake => Array(Up)
    case Fireball => Array(Up, Down, Left, Right)
    case IceEdge => Array(Left)
    case MeteorStorm => Array(Down)
    case Ray => Array(Up, Down)
    case ShadowBind => Array(Up)
    case Thunderbolt => Array(Right)
    case TidalWave => Array(Left, Right)
    case Bomb => Array(Up, Down, Left, Right)
    case Chainsaw => Array(Left, Right)
    case LargeSack => Array(Up, Down, Left, Right)
    case PlayingCards => Array(Up, Down, Left, Right)
    case Saw => Array(Up, Down, Left, Right)
    case ThrowingKnives => Array(Up, Down, Left, Right)
    case Charge => Array(Up, Down, Left, Right)
    case LegendaryArmor => Array(Up)
    case LegendaryHelmet => Array(Down)
    case LegendaryShield => Array(Left)
    case LegendarySword => Array(Right)
  }

  override def getType: Type = equipment match {
    case BattleAxe => Weapon
    case Claymore => Weapon
    case Crossbow => Weapon
    case Dagger => Weapon
    case Longbow => Weapon
    case Longsword => Weapon
    case Runesword => Weapon
    case Sai => Weapon
    case SickleAndChain => Weapon
    case Cyclone => Magic
    case Earthquake => Magic
    case Fireball => Magic
    case IceEdge => Magic
    case MeteorStorm => Magic
    case Ray => Magic
    case ShadowBind => Magic
    case Thunderbolt => Magic
    case TidalWave => Magic
    case Bomb => Item
    case Chainsaw => Item
    case LargeSack => Item
    case PlayingCards => Item
    case Saw => Item
    case ThrowingKnives => Item
    case Charge => Skill
    case LegendaryArmor => Rare
    case LegendaryHelmet => Rare
    case LegendaryShield => Rare
    case LegendarySword => Rare
  }

  override def getUsage: Usage = EquipmentUse

  def isPermanent: Boolean = equipment match {
    case BattleAxe => false
    case Claymore => false
    case Crossbow => true
    case Dagger => false
    case Longbow => false
    case Longsword => false
    case Runesword => false
    case Sai => true
    case SickleAndChain => false
    case Cyclone => false
    case Earthquake => false
    case Fireball => false
    case IceEdge => true
    case MeteorStorm => false
    case Ray => false
    case ShadowBind => false
    case Thunderbolt => true
    case TidalWave => false
    case Bomb => false
    case Chainsaw => false
    case LargeSack => true
    case PlayingCards => true
    case Saw => false
    case ThrowingKnives => false
    case Charge => false
    case LegendaryArmor => true
    case LegendaryHelmet => true
    case LegendaryShield => true
    case LegendarySword => true
  }

  def getString: String = equipment match {
    case BattleAxe => "Battle Axe"
    case Claymore => "Claymore"
    case Crossbow => "Crossbow"
    case Dagger => "Dagger"
    case Longbow => "Longbow"
    case Longsword => "Longsword"
    case Runesword => "Runesword"
    case Sai => "Sai"
    case SickleAndChain => "Sickle and Chain"
    case Cyclone => "Cyclone"
    case Earthquake => "Earthquake"
    case Fireball => "Fireball"
    case IceEdge => "Ice Edge"
    case MeteorStorm => "Meteor Storm"
    case Ray => "Ray"
    case ShadowBind => "Shadow Bind"
    case Thunderbolt => "Thunderbolt"
    case TidalWave => "Tidal Wave"
    case Bomb => "Bomb"
    case Chainsaw => "Chainsaw"
    case LargeSack => "Large Sack"
    case PlayingCards => "Playing Cards"
    case Saw => "Saw"
    case ThrowingKnives => "Throwing Knives"
    case Charge => "Charge"
    case LegendaryArmor => "Legendary Armor"
    case LegendaryHelmet => "Legendary Helmet"
    case LegendaryShield => "Legendary Shield"
    case LegendarySword => "Legendary Sword"
  }

  override def getDescription: String = equipment match {
    case BattleAxe => "Battle Axe has no additional effects."
    case Claymore => "Claymore has no additional effects."
    case Crossbow => "Crossbow has no additional effects."
    case Dagger => "Dagger has no additional effects."
    case Longbow => "Roll the die. If the result is even, deal +1 damage. If the result is odd, deal -1 damage."
    case Longsword => "Longsword has no additional effects."
    case Runesword => "Runesword has no additional effects."
    case Sai => "Sai has no additional effects."
    case SickleAndChain => "After discarding Sickle and Chain, steal one equipment card attacked to an opponent's character " +
      "and immediately attach it to your character."
    case Cyclone => "Cyclone has no additional effects."
    case Earthquake => "Earthquake has no additional effects."
    case Fireball => "Fireball has no additional effects."
    case IceEdge => "Ice Edge does not need to be discarded upon activation."
    case MeteorStorm => "Add damage equal to the amount of cards discarded as a catalyst (up to 4)."
    case Ray => "Ray has no additional effects."
    case ShadowBind => "On your opponent's next turn, they receive one less action."
    case Thunderbolt => "Thunderbolt does not need to be discarded upon activation."
    case TidalWave => "Tidal Wave has no additional effects."
    case Bomb => "After inflicting damage, take one card from your opponent that is currently equipped and put it into the discard pile."
    case Chainsaw => "Chainsaw has no additional effects."
    case LargeSack => "When attached, increase your maximum hand size by two. Large Sack does not need to be discarded upon activation."
    case PlayingCards => "This card's damage (n) is equal to the amount of cards you have attached to your character. " +
      "You do not need to discard this card upon activation."
    case Saw => "Saw has no additional effects."
    case ThrowingKnives => "After inflicting damage, randomly take one card from your opponent's hand and place it into the discard pile."
    case Charge => "Activate when a card attached to your character deals damage. Add +2 to that damage."
    case LegendaryArmor => "Upon attaching all five Legendary items, you win the game."
    case LegendaryHelmet => "Upon attaching all five Legendary items, you win the game."
    case LegendaryShield => "Upon attaching all five Legendary items, you win the game."
    case LegendarySword => "Upon attaching all five Legendary items, you win the game."
  }

  override def toString(): String = {
    var output: String = ""
    if (getDamage == -1) {
      if (getType == Magic)
        output = getString + " (n damage) (-n catalyst)"
      else
        output = getString + " (n damage)"
    } else {
      if (getType == Magic)
        output = getString + " (" + getDamage + " damage) (-" + getCatalyst + " catalyst)"
      else
        output = getString + " (" + getDamage + " damage)"
    }
    output
  }
}
