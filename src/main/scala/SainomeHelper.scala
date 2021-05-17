object SainomeHelper {

  def championsList: List[Champion] = {
    val list = AnimatedArmor :: BeautifulBride :: BrokeMagus :: DemureCardsharp :: FlowerGirl :: GentlePriestess ::
      GorgeousGambler :: Nil
    list
  }

  def selectChampion(number: Int): Champion = number match {
    case 1 => AnimatedArmor
    case 2 => BeautifulBride
    case 3 => BrokeMagus
    case 4 => DemureCardsharp
    case 5 => FlowerGirl
    case 6 => GentlePriestess
    case 7 => GorgeousGambler
  }

}
