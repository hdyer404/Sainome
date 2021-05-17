trait Champion {
  val directions: Map[Direction, Int]
  var isAwakened: Boolean

  def isAwakened(hp: Int): Boolean
  def getName: String
  def getDescription: String
  def getStateDescription: String
  def getDirections: String
}