package chapter03

object MainHelperForChapter03 {

  def callForChapter03(): Unit={

    val newPlayer = Player("Kohli", 18)

    ForPattern.printName()

    SeqUnpackingPattern.printPlayer()

    SimplePattern.printMessage(newPlayer)
  }
}
