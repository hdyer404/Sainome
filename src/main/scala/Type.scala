sealed trait Type
case object Weapon extends Type
case object Magic extends Type
case object Item extends Type
case object Skill extends Type
case object Rare extends Type

sealed trait Usage
case object EquipmentUse extends Usage
case object CounterUse extends Usage
case object InstantUse extends Usage