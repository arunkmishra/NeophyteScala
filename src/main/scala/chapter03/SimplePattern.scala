package chapter03

object SimplePattern {

  def message(player: Player) = player match {
    case Player(_, score) if score>10 => s"u play too much $score"
    case Player(name, _) => s"Welcome back $name"
  }

  def printMessage(player: Player) = println(message(player))
}
