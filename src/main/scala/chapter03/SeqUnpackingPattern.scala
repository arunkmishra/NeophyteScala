package chapter03

object SeqUnpackingPattern {

  def currentPlayer() =  Player("M S Dhoni", 20)

  val Player(name, score) = currentPlayer()

  def printPlayer() = println("Name : "+ name + " Score : " + score)
}
